/*     */ package org.h2.mvstore.db;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.h2.api.TableEngine;
/*     */ import org.h2.command.ddl.CreateTableData;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.mvstore.FileStore;
/*     */ import org.h2.mvstore.MVMap;
/*     */ import org.h2.mvstore.MVStore;
/*     */ import org.h2.mvstore.MVStoreTool;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.store.InDoubtTransaction;
/*     */ import org.h2.store.fs.FileChannelInputStream;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableBase;
/*     */ import org.h2.util.BitField;
/*     */ import org.h2.util.New;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MVTableEngine
/*     */   implements TableEngine
/*     */ {
/*     */   public static Store init(final Database db) {
/*  50 */     Store store = db.getMvStore();
/*  51 */     if (store != null) {
/*  52 */       return store;
/*     */     }
/*  54 */     byte[] arrayOfByte = db.getFileEncryptionKey();
/*  55 */     String str = db.getDatabasePath();
/*  56 */     MVStore.Builder builder = new MVStore.Builder();
/*  57 */     store = new Store();
/*  58 */     boolean bool = false;
/*  59 */     if (str != null) {
/*  60 */       String str1 = str + ".mv.db";
/*  61 */       MVStoreTool.compactCleanUp(str1);
/*  62 */       builder.fileName(str1);
/*  63 */       builder.pageSplitSize(db.getPageSize());
/*  64 */       if (db.isReadOnly()) {
/*  65 */         builder.readOnly();
/*     */       } else {
/*     */         
/*  68 */         boolean bool1 = FileUtils.exists(str1);
/*  69 */         if (!bool1 || FileUtils.canWrite(str1)) {
/*     */ 
/*     */           
/*  72 */           String str2 = FileUtils.getParent(str1);
/*  73 */           FileUtils.createDirectories(str2);
/*     */         } 
/*     */       } 
/*  76 */       if (arrayOfByte != null) {
/*  77 */         bool = true;
/*  78 */         char[] arrayOfChar = new char[arrayOfByte.length / 2];
/*  79 */         for (byte b = 0; b < arrayOfChar.length; b++) {
/*  80 */           arrayOfChar[b] = (char)((arrayOfByte[b + b] & 0xFF) << 16 | arrayOfByte[b + b + 1] & 0xFF);
/*     */         }
/*     */         
/*  83 */         builder.encryptionKey(arrayOfChar);
/*     */       } 
/*  85 */       if ((db.getSettings()).compressData) {
/*  86 */         builder.compress();
/*     */         
/*  88 */         builder.pageSplitSize(65536);
/*     */       } 
/*  90 */       builder.backgroundExceptionHandler(new Thread.UncaughtExceptionHandler()
/*     */           {
/*     */             public void uncaughtException(Thread param1Thread, Throwable param1Throwable)
/*     */             {
/*  94 */               db.setBackgroundException(DbException.convert(param1Throwable));
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/*  99 */     store.open(db, builder, bool);
/* 100 */     db.setMvStore(store);
/* 101 */     return store;
/*     */   }
/*     */ 
/*     */   
/*     */   public TableBase createTable(CreateTableData paramCreateTableData) {
/* 106 */     Database database = paramCreateTableData.session.getDatabase();
/* 107 */     Store store = init(database);
/* 108 */     MVTable mVTable = new MVTable(paramCreateTableData, store);
/* 109 */     mVTable.init(paramCreateTableData.session);
/* 110 */     store.tableMap.put(mVTable.getMapName(), mVTable);
/* 111 */     return mVTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Store
/*     */   {
/* 123 */     final ConcurrentHashMap<String, MVTable> tableMap = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */     
/*     */     private MVStore store;
/*     */ 
/*     */ 
/*     */     
/*     */     private TransactionStore transactionStore;
/*     */ 
/*     */ 
/*     */     
/*     */     private long statisticsStart;
/*     */ 
/*     */ 
/*     */     
/*     */     private int temporaryMapId;
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean encrypted;
/*     */ 
/*     */ 
/*     */     
/*     */     private String fileName;
/*     */ 
/*     */ 
/*     */     
/*     */     void open(Database param1Database, MVStore.Builder param1Builder, boolean param1Boolean) {
/* 152 */       this.encrypted = param1Boolean;
/*     */       try {
/* 154 */         this.store = param1Builder.open();
/* 155 */         FileStore fileStore = this.store.getFileStore();
/* 156 */         if (fileStore != null) {
/* 157 */           this.fileName = fileStore.getFileName();
/*     */         }
/* 159 */         if (!(param1Database.getSettings()).reuseSpace) {
/* 160 */           this.store.setReuseSpace(false);
/*     */         }
/* 162 */         this.transactionStore = new TransactionStore(this.store, new ValueDataType(null, (DataHandler)param1Database, null));
/*     */ 
/*     */         
/* 165 */         this.transactionStore.init();
/* 166 */       } catch (IllegalStateException illegalStateException) {
/* 167 */         throw convertIllegalStateException(illegalStateException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DbException convertIllegalStateException(IllegalStateException param1IllegalStateException) {
/* 179 */       int i = DataUtils.getErrorCode(param1IllegalStateException.getMessage());
/* 180 */       if (i == 6) {
/* 181 */         if (this.encrypted) {
/* 182 */           throw DbException.get(90049, param1IllegalStateException, new String[] { this.fileName });
/*     */         }
/*     */       } else {
/*     */         
/* 186 */         if (i == 7) {
/* 187 */           throw DbException.get(90020, param1IllegalStateException, new String[] { this.fileName });
/*     */         }
/*     */         
/* 190 */         if (i == 1) {
/* 191 */           throw DbException.get(90028, param1IllegalStateException, new String[] { this.fileName });
/*     */         }
/*     */       } 
/*     */       
/* 195 */       throw DbException.get(90030, param1IllegalStateException, new String[] { this.fileName });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public MVStore getStore() {
/* 202 */       return this.store;
/*     */     }
/*     */     
/*     */     public TransactionStore getTransactionStore() {
/* 206 */       return this.transactionStore;
/*     */     }
/*     */     
/*     */     public HashMap<String, MVTable> getTables() {
/* 210 */       return new HashMap<>(this.tableMap);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeTable(MVTable param1MVTable) {
/* 219 */       this.tableMap.remove(param1MVTable.getMapName());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void flush() {
/* 226 */       FileStore fileStore = this.store.getFileStore();
/* 227 */       if (fileStore == null || fileStore.isReadOnly()) {
/*     */         return;
/*     */       }
/* 230 */       if (!this.store.compact(50, 4194304)) {
/* 231 */         this.store.commit();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void closeImmediately() {
/* 239 */       if (this.store.isClosed()) {
/*     */         return;
/*     */       }
/* 242 */       this.store.closeImmediately();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void initTransactions() {
/* 250 */       List<TransactionStore.Transaction> list = this.transactionStore.getOpenTransactions();
/* 251 */       for (TransactionStore.Transaction transaction : list) {
/* 252 */         if (transaction.getStatus() == 3) {
/* 253 */           transaction.commit(); continue;
/* 254 */         }  if (transaction.getStatus() != 2) {
/* 255 */           transaction.rollback();
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeTemporaryMaps(BitField param1BitField) {
/* 266 */       for (String str : this.store.getMapNames()) {
/* 267 */         if (str.startsWith("temp.")) {
/* 268 */           MVMap mVMap = this.store.openMap(str);
/* 269 */           this.store.removeMap(mVMap); continue;
/* 270 */         }  if (str.startsWith("table.") || str.startsWith("index.")) {
/* 271 */           int i = Integer.parseInt(str.substring(1 + str.indexOf(".")));
/* 272 */           if (!param1BitField.get(i)) {
/* 273 */             ValueDataType valueDataType1 = new ValueDataType(null, null, null);
/* 274 */             ValueDataType valueDataType2 = new ValueDataType(null, null, null);
/* 275 */             TransactionStore.Transaction transaction = this.transactionStore.begin();
/* 276 */             TransactionStore.TransactionMap<?, ?> transactionMap = transaction.openMap(str, valueDataType1, valueDataType2);
/* 277 */             this.transactionStore.removeMap(transactionMap);
/* 278 */             transaction.commit();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public synchronized String nextTemporaryMapName() {
/* 290 */       return "temp." + this.temporaryMapId++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void prepareCommit(Session param1Session, String param1String) {
/* 300 */       TransactionStore.Transaction transaction = param1Session.getTransaction();
/* 301 */       transaction.setName(param1String);
/* 302 */       transaction.prepare();
/* 303 */       this.store.commit();
/*     */     }
/*     */     
/*     */     public ArrayList<InDoubtTransaction> getInDoubtTransactions() {
/* 307 */       List<TransactionStore.Transaction> list = this.transactionStore.getOpenTransactions();
/* 308 */       ArrayList<MVTableEngine.MVInDoubtTransaction> arrayList = New.arrayList();
/* 309 */       for (TransactionStore.Transaction transaction : list) {
/* 310 */         if (transaction.getStatus() == 2) {
/* 311 */           arrayList.add(new MVTableEngine.MVInDoubtTransaction(this.store, transaction));
/*     */         }
/*     */       } 
/* 314 */       return (ArrayList)arrayList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setCacheSize(int param1Int) {
/* 323 */       this.store.setCacheSize(Math.max(1, param1Int / 1024));
/*     */     }
/*     */     
/*     */     public InputStream getInputStream() {
/* 327 */       FileChannel fileChannel = this.store.getFileStore().getEncryptedFile();
/* 328 */       if (fileChannel == null) {
/* 329 */         fileChannel = this.store.getFileStore().getFile();
/*     */       }
/* 331 */       return (InputStream)new FileChannelInputStream(fileChannel, false);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void sync() {
/* 338 */       flush();
/* 339 */       this.store.sync();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void compactFile(long param1Long) {
/* 351 */       this.store.setRetentionTime(0);
/* 352 */       long l = System.currentTimeMillis();
/* 353 */       while (this.store.compact(95, 16777216)) {
/* 354 */         this.store.sync();
/* 355 */         this.store.compactMoveChunks(95, 16777216L);
/* 356 */         long l1 = System.currentTimeMillis() - l;
/* 357 */         if (l1 > param1Long) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void close(long param1Long) {
/*     */       try {
/* 372 */         if (!this.store.isClosed() && this.store.getFileStore() != null) {
/* 373 */           boolean bool = false;
/* 374 */           if (!this.store.getFileStore().isReadOnly()) {
/* 375 */             this.transactionStore.close();
/* 376 */             if (param1Long == Long.MAX_VALUE) {
/* 377 */               bool = true;
/*     */             }
/*     */           } 
/* 380 */           String str = this.store.getFileStore().getFileName();
/* 381 */           this.store.close();
/* 382 */           if (bool && FileUtils.exists(str))
/*     */           {
/*     */             
/* 385 */             MVStoreTool.compact(str, true);
/*     */           }
/*     */         } 
/* 388 */       } catch (IllegalStateException illegalStateException) {
/* 389 */         int i = DataUtils.getErrorCode(illegalStateException.getMessage());
/* 390 */         if (i != 2)
/*     */         {
/* 392 */           if (i == 6);
/*     */         }
/*     */         
/* 395 */         this.store.closeImmediately();
/* 396 */         throw DbException.get(90028, illegalStateException, new String[] { "Closing" });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void statisticsStart() {
/* 404 */       FileStore fileStore = this.store.getFileStore();
/* 405 */       this.statisticsStart = (fileStore == null) ? 0L : fileStore.getReadCount();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<String, Integer> statisticsEnd() {
/* 414 */       HashMap<String, Integer> hashMap = New.hashMap();
/* 415 */       FileStore fileStore = this.store.getFileStore();
/* 416 */       boolean bool = (fileStore == null) ? false : (int)(fileStore.getReadCount() - this.statisticsStart);
/* 417 */       hashMap.put("reads", Integer.valueOf(bool));
/* 418 */       return hashMap;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class MVInDoubtTransaction
/*     */     implements InDoubtTransaction
/*     */   {
/*     */     private final MVStore store;
/*     */     
/*     */     private final TransactionStore.Transaction transaction;
/*     */     
/* 430 */     private int state = 0;
/*     */     
/*     */     MVInDoubtTransaction(MVStore param1MVStore, TransactionStore.Transaction param1Transaction) {
/* 433 */       this.store = param1MVStore;
/* 434 */       this.transaction = param1Transaction;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setState(int param1Int) {
/* 439 */       if (param1Int == 1) {
/* 440 */         this.transaction.commit();
/*     */       } else {
/* 442 */         this.transaction.rollback();
/*     */       } 
/* 444 */       this.store.commit();
/* 445 */       this.state = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getState() {
/* 450 */       switch (this.state) {
/*     */         case 0:
/* 452 */           return "IN_DOUBT";
/*     */         case 1:
/* 454 */           return "COMMIT";
/*     */         case 2:
/* 456 */           return "ROLLBACK";
/*     */       } 
/* 458 */       throw DbException.throwInternalError("state=" + this.state);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getTransactionName() {
/* 464 */       return this.transaction.getName();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\MVTableEngine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */