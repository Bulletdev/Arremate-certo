/*      */ package org.h2.tools;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.OutputStream;
/*      */ import java.io.PrintWriter;
/*      */ import java.io.Reader;
/*      */ import java.io.SequenceInputStream;
/*      */ import java.sql.Connection;
/*      */ import java.sql.PreparedStatement;
/*      */ import java.sql.ResultSet;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.zip.CRC32;
/*      */ import org.h2.api.JavaObjectSerializer;
/*      */ import org.h2.compress.CompressLZF;
/*      */ import org.h2.engine.Constants;
/*      */ import org.h2.engine.MetaRecord;
/*      */ import org.h2.jdbc.JdbcConnection;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.mvstore.MVMap;
/*      */ import org.h2.mvstore.MVStore;
/*      */ import org.h2.mvstore.MVStoreTool;
/*      */ import org.h2.mvstore.StreamStore;
/*      */ import org.h2.mvstore.db.TransactionStore;
/*      */ import org.h2.mvstore.db.ValueDataType;
/*      */ import org.h2.mvstore.type.DataType;
/*      */ import org.h2.result.Row;
/*      */ import org.h2.result.RowFactory;
/*      */ import org.h2.result.SearchRow;
/*      */ import org.h2.result.SimpleRow;
/*      */ import org.h2.security.SHA256;
/*      */ import org.h2.store.Data;
/*      */ import org.h2.store.DataHandler;
/*      */ import org.h2.store.DataReader;
/*      */ import org.h2.store.FileLister;
/*      */ import org.h2.store.FileStore;
/*      */ import org.h2.store.FileStoreInputStream;
/*      */ import org.h2.store.LobStorageBackend;
/*      */ import org.h2.store.LobStorageInterface;
/*      */ import org.h2.store.PageFreeList;
/*      */ import org.h2.store.PageLog;
/*      */ import org.h2.store.PageStore;
/*      */ import org.h2.store.fs.FileUtils;
/*      */ import org.h2.util.BitField;
/*      */ import org.h2.util.IOUtils;
/*      */ import org.h2.util.IntArray;
/*      */ import org.h2.util.MathUtils;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.SmallLRUCache;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.util.TempFileDeleter;
/*      */ import org.h2.util.Tool;
/*      */ import org.h2.util.Utils;
/*      */ import org.h2.value.CompareMode;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueArray;
/*      */ import org.h2.value.ValueLob;
/*      */ import org.h2.value.ValueLobDb;
/*      */ import org.h2.value.ValueLong;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Recover
/*      */   extends Tool
/*      */   implements DataHandler
/*      */ {
/*      */   private String databaseName;
/*      */   private int storageId;
/*      */   private String storageName;
/*      */   private int recordLength;
/*      */   private int valueId;
/*      */   private boolean trace;
/*      */   private boolean transactionLog;
/*      */   private ArrayList<MetaRecord> schema;
/*      */   private HashSet<Integer> objectIdSet;
/*      */   private HashMap<Integer, String> tableMap;
/*      */   private HashMap<String, String> columnTypeMap;
/*      */   private boolean remove;
/*      */   private int pageSize;
/*      */   private FileStore store;
/*      */   private int[] parents;
/*      */   private Stats stat;
/*      */   private boolean lobMaps;
/*      */   
/*      */   static class Stats
/*      */   {
/*      */     long pageDataEmpty;
/*      */     long pageDataRows;
/*      */     long pageDataHead;
/*  131 */     final int[] pageTypeCount = new int[10];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int free;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void main(String... paramVarArgs) throws SQLException {
/*  159 */     (new Recover()).runTool(paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void runTool(String... paramVarArgs) throws SQLException {
/*  175 */     String str1 = ".";
/*  176 */     String str2 = null;
/*  177 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  178 */       String str = paramVarArgs[b];
/*  179 */       if ("-dir".equals(str))
/*  180 */       { str1 = paramVarArgs[++b]; }
/*  181 */       else if ("-db".equals(str))
/*  182 */       { str2 = paramVarArgs[++b]; }
/*  183 */       else if ("-removePassword".equals(str))
/*  184 */       { this.remove = true; }
/*  185 */       else if ("-trace".equals(str))
/*  186 */       { this.trace = true; }
/*  187 */       else if ("-transactionLog".equals(str))
/*  188 */       { this.transactionLog = true; }
/*  189 */       else { if (str.equals("-help") || str.equals("-?")) {
/*  190 */           showUsage();
/*      */           return;
/*      */         } 
/*  193 */         showUsageAndThrowUnsupportedOption(str); }
/*      */     
/*      */     } 
/*  196 */     process(str1, str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Reader readClob(String paramString) throws IOException {
/*  203 */     return new BufferedReader(new InputStreamReader(readBlob(paramString), Constants.UTF8));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream readBlob(String paramString) throws IOException {
/*  211 */     return new BufferedInputStream(FileUtils.newInputStream(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Value.ValueBlob readBlobDb(Connection paramConnection, long paramLong1, long paramLong2) {
/*  219 */     DataHandler dataHandler = ((JdbcConnection)paramConnection).getSession().getDataHandler();
/*  220 */     verifyPageStore(dataHandler);
/*  221 */     return (Value.ValueBlob)ValueLobDb.create(15, dataHandler, -2, paramLong1, null, paramLong2);
/*      */   }
/*      */ 
/*      */   
/*      */   private static void verifyPageStore(DataHandler paramDataHandler) {
/*  226 */     if (paramDataHandler.getLobStorage() instanceof org.h2.store.LobStorageMap) {
/*  227 */       throw DbException.get(50100, "Restore page store recovery SQL script can only be restored to a PageStore file");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Value.ValueClob readClobDb(Connection paramConnection, long paramLong1, long paramLong2) {
/*  238 */     DataHandler dataHandler = ((JdbcConnection)paramConnection).getSession().getDataHandler();
/*  239 */     verifyPageStore(dataHandler);
/*  240 */     return (Value.ValueClob)ValueLobDb.create(16, dataHandler, -2, paramLong1, null, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InputStream readBlobMap(Connection paramConnection, long paramLong1, long paramLong2) throws SQLException {
/*  249 */     final PreparedStatement prep = paramConnection.prepareStatement("SELECT DATA FROM INFORMATION_SCHEMA.LOB_BLOCKS WHERE LOB_ID = ? AND SEQ = ? AND ? > 0");
/*      */ 
/*      */     
/*  252 */     preparedStatement.setLong(1, paramLong1);
/*      */ 
/*      */     
/*  255 */     preparedStatement.setLong(3, paramLong2);
/*  256 */     return new SequenceInputStream(new Enumeration<InputStream>()
/*      */         {
/*      */           private int seq;
/*      */           
/*  260 */           private byte[] data = fetch();
/*      */           
/*      */           private byte[] fetch() {
/*      */             try {
/*  264 */               prep.setInt(2, this.seq++);
/*  265 */               ResultSet resultSet = prep.executeQuery();
/*  266 */               if (resultSet.next()) {
/*  267 */                 return resultSet.getBytes(1);
/*      */               }
/*  269 */               return null;
/*  270 */             } catch (SQLException sQLException) {
/*  271 */               throw DbException.convert(sQLException);
/*      */             } 
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean hasMoreElements() {
/*  277 */             return (this.data != null);
/*      */           }
/*      */ 
/*      */           
/*      */           public InputStream nextElement() {
/*  282 */             ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
/*  283 */             this.data = fetch();
/*  284 */             return byteArrayInputStream;
/*      */           }
/*      */         });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Reader readClobMap(Connection paramConnection, long paramLong1, long paramLong2) throws Exception {
/*  295 */     InputStream inputStream = readBlobMap(paramConnection, paramLong1, paramLong2);
/*  296 */     return new BufferedReader(new InputStreamReader(inputStream, Constants.UTF8));
/*      */   }
/*      */   
/*      */   private void trace(String paramString) {
/*  300 */     if (this.trace) {
/*  301 */       this.out.println(paramString);
/*      */     }
/*      */   }
/*      */   
/*      */   private void traceError(String paramString, Throwable paramThrowable) {
/*  306 */     this.out.println(paramString + ": " + paramThrowable.toString());
/*  307 */     if (this.trace) {
/*  308 */       paramThrowable.printStackTrace(this.out);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void execute(String paramString1, String paramString2) throws SQLException {
/*      */     try {
/*  320 */       (new Recover()).process(paramString1, paramString2);
/*  321 */     } catch (DbException dbException) {
/*  322 */       throw DbException.toSQLException(dbException);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void process(String paramString1, String paramString2) {
/*  327 */     ArrayList arrayList = FileLister.getDatabaseFiles(paramString1, paramString2, true);
/*  328 */     if (arrayList.size() == 0) {
/*  329 */       printNoDatabaseFilesFound(paramString1, paramString2);
/*      */     }
/*  331 */     for (String str : arrayList) {
/*  332 */       if (str.endsWith(".h2.db")) {
/*  333 */         dumpPageStore(str); continue;
/*  334 */       }  if (str.endsWith(".lob.db")) {
/*  335 */         dumpLob(str, false); continue;
/*  336 */       }  if (str.endsWith(".mv.db")) {
/*  337 */         String str1 = str.substring(0, str.length() - ".h2.db".length());
/*      */ 
/*      */         
/*  340 */         PrintWriter printWriter = getWriter(str, ".txt");
/*  341 */         MVStoreTool.dump(str, printWriter, true);
/*  342 */         MVStoreTool.info(str, printWriter);
/*  343 */         printWriter.close();
/*  344 */         printWriter = getWriter(str1 + ".h2.db", ".sql");
/*  345 */         dumpMVStoreFile(printWriter, str);
/*  346 */         printWriter.close();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private PrintWriter getWriter(String paramString1, String paramString2) {
/*  352 */     paramString1 = paramString1.substring(0, paramString1.length() - 3);
/*  353 */     String str = paramString1 + paramString2;
/*  354 */     trace("Created file: " + str);
/*      */     try {
/*  356 */       return new PrintWriter(IOUtils.getBufferedWriter(FileUtils.newOutputStream(str, false)));
/*      */     }
/*  358 */     catch (IOException iOException) {
/*  359 */       throw DbException.convertIOException(iOException, null);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void writeDataError(PrintWriter paramPrintWriter, String paramString, byte[] paramArrayOfbyte) {
/*  364 */     paramPrintWriter.println("-- ERROR: " + paramString + " storageId: " + this.storageId + " recordLength: " + this.recordLength + " valueId: " + this.valueId);
/*      */     
/*  366 */     StringBuilder stringBuilder = new StringBuilder(); byte b;
/*  367 */     for (b = 0; b < paramArrayOfbyte.length; b++) {
/*  368 */       int i = paramArrayOfbyte[b] & 0xFF;
/*  369 */       if (i >= 32 && i < 128) {
/*  370 */         stringBuilder.append((char)i);
/*      */       } else {
/*  372 */         stringBuilder.append('?');
/*      */       } 
/*      */     } 
/*  375 */     paramPrintWriter.println("-- dump: " + stringBuilder.toString());
/*  376 */     stringBuilder = new StringBuilder();
/*  377 */     for (b = 0; b < paramArrayOfbyte.length; b++) {
/*  378 */       int i = paramArrayOfbyte[b] & 0xFF;
/*  379 */       stringBuilder.append(' ');
/*  380 */       if (i < 16) {
/*  381 */         stringBuilder.append('0');
/*      */       }
/*  383 */       stringBuilder.append(Integer.toHexString(i));
/*      */     } 
/*  385 */     paramPrintWriter.println("-- dump: " + stringBuilder.toString());
/*      */   }
/*      */   
/*      */   private void dumpLob(String paramString, boolean paramBoolean) {
/*  389 */     OutputStream outputStream = null;
/*  390 */     FileStore fileStore = null;
/*  391 */     long l = 0L;
/*  392 */     String str = paramString + (paramBoolean ? ".comp" : "") + ".txt";
/*  393 */     FileStoreInputStream fileStoreInputStream = null;
/*      */     try {
/*  395 */       outputStream = FileUtils.newOutputStream(str, false);
/*  396 */       fileStore = FileStore.open(null, paramString, "r");
/*  397 */       fileStore.init();
/*  398 */       fileStoreInputStream = new FileStoreInputStream(fileStore, this, paramBoolean, false);
/*  399 */       l = IOUtils.copy((InputStream)fileStoreInputStream, outputStream);
/*  400 */     } catch (Throwable throwable) {
/*      */ 
/*      */     
/*      */     } finally {
/*  404 */       IOUtils.closeSilently(outputStream);
/*  405 */       IOUtils.closeSilently((InputStream)fileStoreInputStream);
/*  406 */       closeSilently(fileStore);
/*      */     } 
/*  408 */     if (l == 0L) {
/*      */       try {
/*  410 */         FileUtils.delete(str);
/*  411 */       } catch (Exception exception) {
/*  412 */         traceError(str, exception);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private String getSQL(String paramString, Value paramValue) {
/*  418 */     if (paramValue instanceof ValueLob) {
/*  419 */       ValueLob valueLob = (ValueLob)paramValue;
/*  420 */       byte[] arrayOfByte = valueLob.getSmall();
/*  421 */       if (arrayOfByte == null) {
/*  422 */         String str1 = valueLob.getFileName();
/*  423 */         String str2 = (valueLob.getType() == 15) ? "BLOB" : "CLOB";
/*  424 */         if (valueLob.isCompressed()) {
/*  425 */           dumpLob(str1, true);
/*  426 */           str1 = str1 + ".comp";
/*      */         } 
/*  428 */         return "READ_" + str2 + "('" + str1 + ".txt')";
/*      */       } 
/*  430 */     } else if (paramValue instanceof ValueLobDb) {
/*  431 */       ValueLobDb valueLobDb = (ValueLobDb)paramValue;
/*  432 */       byte[] arrayOfByte = valueLobDb.getSmall();
/*  433 */       if (arrayOfByte == null) {
/*  434 */         String str1, str2; int i = valueLobDb.getType();
/*  435 */         long l1 = valueLobDb.getLobId();
/*  436 */         long l2 = valueLobDb.getPrecision();
/*      */ 
/*      */         
/*  439 */         if (i == 15) {
/*  440 */           str2 = "BLOB";
/*  441 */           str1 = "READ_BLOB";
/*      */         } else {
/*  443 */           str2 = "CLOB";
/*  444 */           str1 = "READ_CLOB";
/*      */         } 
/*  446 */         if (this.lobMaps) {
/*  447 */           str1 = str1 + "_MAP";
/*      */         } else {
/*  449 */           str1 = str1 + "_DB";
/*      */         } 
/*  451 */         this.columnTypeMap.put(paramString, str2);
/*  452 */         return str1 + "(" + l1 + ", " + l2 + ")";
/*      */       } 
/*      */     } 
/*  455 */     return paramValue.getSQL();
/*      */   }
/*      */   
/*      */   private void setDatabaseName(String paramString) {
/*  459 */     this.databaseName = paramString;
/*      */   }
/*      */   
/*      */   private void dumpPageStore(String paramString) {
/*  463 */     setDatabaseName(paramString.substring(0, paramString.length() - ".h2.db".length()));
/*      */     
/*  465 */     PrintWriter printWriter = null;
/*  466 */     this.stat = new Stats();
/*      */     try {
/*  468 */       printWriter = getWriter(paramString, ".sql");
/*  469 */       printWriter.println("CREATE ALIAS IF NOT EXISTS READ_BLOB FOR \"" + getClass().getName() + ".readBlob\";");
/*      */       
/*  471 */       printWriter.println("CREATE ALIAS IF NOT EXISTS READ_CLOB FOR \"" + getClass().getName() + ".readClob\";");
/*      */       
/*  473 */       printWriter.println("CREATE ALIAS IF NOT EXISTS READ_BLOB_DB FOR \"" + getClass().getName() + ".readBlobDb\";");
/*      */       
/*  475 */       printWriter.println("CREATE ALIAS IF NOT EXISTS READ_CLOB_DB FOR \"" + getClass().getName() + ".readClobDb\";");
/*      */       
/*  477 */       resetSchema();
/*  478 */       this.store = FileStore.open(null, paramString, this.remove ? "rw" : "r");
/*  479 */       long l1 = this.store.length();
/*      */       try {
/*  481 */         this.store.init();
/*  482 */       } catch (Exception exception) {
/*  483 */         writeError(printWriter, exception);
/*      */       } 
/*  485 */       Data data = Data.create(this, 128);
/*  486 */       seek(0L);
/*  487 */       this.store.readFully(data.getBytes(), 0, 128);
/*  488 */       data.setPos(48);
/*  489 */       this.pageSize = data.readInt();
/*  490 */       byte b1 = data.readByte();
/*  491 */       byte b2 = data.readByte();
/*  492 */       printWriter.println("-- pageSize: " + this.pageSize + " writeVersion: " + b1 + " readVersion: " + b2);
/*      */ 
/*      */       
/*  495 */       if (this.pageSize < 64 || this.pageSize > 32768) {
/*      */         
/*  497 */         this.pageSize = 4096;
/*  498 */         printWriter.println("-- ERROR: page size; using " + this.pageSize);
/*      */       } 
/*  500 */       long l2 = l1 / this.pageSize;
/*  501 */       this.parents = new int[(int)l2];
/*  502 */       data = Data.create(this, this.pageSize); long l3;
/*  503 */       for (l3 = 3L; l3 < l2; l3++) {
/*  504 */         data.reset();
/*  505 */         seek(l3);
/*  506 */         this.store.readFully(data.getBytes(), 0, 32);
/*  507 */         data.readByte();
/*  508 */         data.readShortInt();
/*  509 */         this.parents[(int)l3] = data.readInt();
/*      */       } 
/*  511 */       int i = 0, j = 0, k = 0;
/*  512 */       data = Data.create(this, this.pageSize);
/*  513 */       long l4 = 1L;
/*  514 */       for (; l4 != 3L; l4++) {
/*      */ 
/*      */         
/*  517 */         data.reset();
/*  518 */         seek(l4);
/*  519 */         this.store.readFully(data.getBytes(), 0, this.pageSize);
/*  520 */         CRC32 cRC32 = new CRC32();
/*  521 */         cRC32.update(data.getBytes(), 4, this.pageSize - 4);
/*  522 */         int m = (int)cRC32.getValue();
/*  523 */         int n = data.readInt();
/*  524 */         long l = data.readLong();
/*  525 */         int i1 = data.readInt();
/*  526 */         int i2 = data.readInt();
/*  527 */         int i3 = data.readInt();
/*  528 */         if (m == n) {
/*  529 */           i = i1;
/*  530 */           j = i2;
/*  531 */           k = i3;
/*      */         } 
/*  533 */         printWriter.println("-- head " + l4 + ": writeCounter: " + l + " log " + i1 + ":" + i2 + "/" + i3 + " crc " + n + " (" + ((m == n) ? "ok" : ("expected: " + m)) + ")");
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  539 */       printWriter.println("-- log " + i + ":" + j + "/" + k);
/*      */ 
/*      */       
/*  542 */       PrintWriter printWriter1 = new PrintWriter(new OutputStream()
/*      */           {
/*      */             public void write(int param1Int) {}
/*      */           });
/*      */ 
/*      */       
/*  548 */       dumpPageStore(printWriter1, l2);
/*  549 */       this.stat = new Stats();
/*  550 */       this.schema.clear();
/*  551 */       this.objectIdSet = New.hashSet();
/*  552 */       dumpPageStore(printWriter, l2);
/*  553 */       writeSchema(printWriter);
/*      */       try {
/*  555 */         dumpPageLogStream(printWriter, i, j, k, l2);
/*      */       }
/*  557 */       catch (IOException iOException) {}
/*      */ 
/*      */       
/*  560 */       printWriter.println("---- Statistics ----");
/*  561 */       printWriter.println("-- page count: " + l2 + ", free: " + this.stat.free);
/*  562 */       long l5 = Math.max(1L, this.stat.pageDataRows + this.stat.pageDataEmpty + this.stat.pageDataHead);
/*      */       
/*  564 */       printWriter.println("-- page data bytes: head " + this.stat.pageDataHead + ", empty " + this.stat.pageDataEmpty + ", rows " + this.stat.pageDataRows + " (" + (100L - 100L * this.stat.pageDataEmpty / l5) + "% full)");
/*      */ 
/*      */ 
/*      */       
/*  568 */       for (byte b = 0; b < this.stat.pageTypeCount.length; b++) {
/*  569 */         int m = this.stat.pageTypeCount[b];
/*  570 */         if (m > 0) {
/*  571 */           printWriter.println("-- " + getPageType(b) + " " + ((100 * m) / l2) + "%, " + m + " page(s)");
/*      */         }
/*      */       } 
/*      */       
/*  575 */       printWriter.close();
/*  576 */     } catch (Throwable throwable) {
/*  577 */       writeError(printWriter, throwable);
/*      */     } finally {
/*  579 */       IOUtils.closeSilently(printWriter);
/*  580 */       closeSilently(this.store);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void dumpMVStoreFile(PrintWriter paramPrintWriter, String paramString) {
/*  585 */     paramPrintWriter.println("-- MVStore");
/*  586 */     paramPrintWriter.println("CREATE ALIAS IF NOT EXISTS READ_BLOB FOR \"" + getClass().getName() + ".readBlob\";");
/*      */     
/*  588 */     paramPrintWriter.println("CREATE ALIAS IF NOT EXISTS READ_CLOB FOR \"" + getClass().getName() + ".readClob\";");
/*      */     
/*  590 */     paramPrintWriter.println("CREATE ALIAS IF NOT EXISTS READ_BLOB_DB FOR \"" + getClass().getName() + ".readBlobDb\";");
/*      */     
/*  592 */     paramPrintWriter.println("CREATE ALIAS IF NOT EXISTS READ_CLOB_DB FOR \"" + getClass().getName() + ".readClobDb\";");
/*      */     
/*  594 */     paramPrintWriter.println("CREATE ALIAS IF NOT EXISTS READ_BLOB_MAP FOR \"" + getClass().getName() + ".readBlobMap\";");
/*      */     
/*  596 */     paramPrintWriter.println("CREATE ALIAS IF NOT EXISTS READ_CLOB_MAP FOR \"" + getClass().getName() + ".readClobMap\";");
/*      */     
/*  598 */     resetSchema();
/*  599 */     setDatabaseName(paramString.substring(0, paramString.length() - ".mv.db".length()));
/*      */     
/*  601 */     MVStore mVStore = (new MVStore.Builder()).fileName(paramString).readOnly().open();
/*      */     
/*  603 */     dumpLobMaps(paramPrintWriter, mVStore);
/*  604 */     paramPrintWriter.println("-- Meta");
/*  605 */     dumpMeta(paramPrintWriter, mVStore);
/*  606 */     paramPrintWriter.println("-- Tables");
/*  607 */     TransactionStore transactionStore = new TransactionStore(mVStore);
/*      */     try {
/*  609 */       transactionStore.init();
/*  610 */     } catch (Throwable throwable) {
/*  611 */       writeError(paramPrintWriter, throwable);
/*      */     } 
/*      */     try {
/*  614 */       for (String str1 : mVStore.getMapNames()) {
/*  615 */         if (!str1.startsWith("table.")) {
/*      */           continue;
/*      */         }
/*  618 */         String str2 = str1.substring("table.".length());
/*  619 */         ValueDataType valueDataType1 = new ValueDataType(null, this, null);
/*      */         
/*  621 */         ValueDataType valueDataType2 = new ValueDataType(null, this, null);
/*      */         
/*  623 */         TransactionStore.TransactionMap transactionMap = transactionStore.begin().openMap(str1, (DataType)valueDataType1, (DataType)valueDataType2);
/*      */         
/*  625 */         Iterator<Value> iterator = transactionMap.keyIterator(null);
/*  626 */         boolean bool = false;
/*  627 */         while (iterator.hasNext()) {
/*  628 */           Value value = iterator.next();
/*  629 */           Value[] arrayOfValue = ((ValueArray)transactionMap.get(value)).getList();
/*  630 */           this.recordLength = arrayOfValue.length;
/*  631 */           if (!bool) {
/*  632 */             setStorage(Integer.parseInt(str2));
/*      */             
/*  634 */             for (this.valueId = 0; this.valueId < this.recordLength; this.valueId++) {
/*  635 */               String str = this.storageName + "." + this.valueId;
/*  636 */               getSQL(str, arrayOfValue[this.valueId]);
/*      */             } 
/*  638 */             createTemporaryTable(paramPrintWriter);
/*  639 */             bool = true;
/*      */           } 
/*  641 */           StringBuilder stringBuilder = new StringBuilder();
/*  642 */           stringBuilder.append("INSERT INTO O_").append(str2).append(" VALUES(");
/*      */           
/*  644 */           for (this.valueId = 0; this.valueId < this.recordLength; this.valueId++) {
/*  645 */             if (this.valueId > 0) {
/*  646 */               stringBuilder.append(", ");
/*      */             }
/*  648 */             String str = this.storageName + "." + this.valueId;
/*  649 */             stringBuilder.append(getSQL(str, arrayOfValue[this.valueId]));
/*      */           } 
/*  651 */           stringBuilder.append(");");
/*  652 */           paramPrintWriter.println(stringBuilder.toString());
/*  653 */           if (this.storageId == 0) {
/*      */             try {
/*  655 */               SimpleRow simpleRow = new SimpleRow(arrayOfValue);
/*  656 */               MetaRecord metaRecord = new MetaRecord((SearchRow)simpleRow);
/*  657 */               this.schema.add(metaRecord);
/*  658 */               if (metaRecord.getObjectType() == 0) {
/*  659 */                 String str3 = arrayOfValue[3].getString();
/*  660 */                 String str4 = extractTableOrViewName(str3);
/*  661 */                 this.tableMap.put(Integer.valueOf(metaRecord.getId()), str4);
/*      */               } 
/*  663 */             } catch (Throwable throwable) {
/*  664 */               writeError(paramPrintWriter, throwable);
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*  669 */       writeSchema(paramPrintWriter);
/*  670 */       paramPrintWriter.println("DROP ALIAS READ_BLOB_MAP;");
/*  671 */       paramPrintWriter.println("DROP ALIAS READ_CLOB_MAP;");
/*  672 */       paramPrintWriter.println("DROP TABLE IF EXISTS INFORMATION_SCHEMA.LOB_BLOCKS;");
/*  673 */     } catch (Throwable throwable) {
/*  674 */       writeError(paramPrintWriter, throwable);
/*      */     } finally {
/*  676 */       mVStore.close();
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void dumpMeta(PrintWriter paramPrintWriter, MVStore paramMVStore) {
/*  681 */     MVMap mVMap = paramMVStore.getMetaMap();
/*  682 */     for (Map.Entry entry : mVMap.entrySet()) {
/*  683 */       paramPrintWriter.println("-- " + (String)entry.getKey() + " = " + (String)entry.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void dumpLobMaps(PrintWriter paramPrintWriter, MVStore paramMVStore) {
/*  688 */     this.lobMaps = paramMVStore.hasMap("lobData");
/*  689 */     if (!this.lobMaps) {
/*      */       return;
/*      */     }
/*  692 */     MVMap mVMap1 = paramMVStore.openMap("lobData");
/*  693 */     StreamStore streamStore = new StreamStore((Map)mVMap1);
/*  694 */     MVMap mVMap2 = paramMVStore.openMap("lobMap");
/*  695 */     paramPrintWriter.println("-- LOB");
/*  696 */     paramPrintWriter.println("CREATE TABLE IF NOT EXISTS INFORMATION_SCHEMA.LOB_BLOCKS(LOB_ID BIGINT, SEQ INT, DATA BINARY, PRIMARY KEY(LOB_ID, SEQ));");
/*      */ 
/*      */ 
/*      */     
/*  700 */     boolean bool = false;
/*  701 */     label34: for (Map.Entry entry : mVMap2.entrySet()) {
/*  702 */       long l = ((Long)entry.getKey()).longValue();
/*  703 */       Object[] arrayOfObject = (Object[])entry.getValue();
/*  704 */       byte[] arrayOfByte1 = (byte[])arrayOfObject[0];
/*  705 */       InputStream inputStream = streamStore.get(arrayOfByte1);
/*  706 */       char c = ' ';
/*  707 */       byte[] arrayOfByte2 = new byte[c];
/*      */       try {
/*  709 */         for (byte b = 0;; b++) {
/*  710 */           int i = IOUtils.readFully(inputStream, arrayOfByte2, arrayOfByte2.length);
/*  711 */           String str = StringUtils.convertBytesToHex(arrayOfByte2, i);
/*  712 */           if (i > 0) {
/*  713 */             paramPrintWriter.println("INSERT INTO INFORMATION_SCHEMA.LOB_BLOCKS VALUES(" + l + ", " + b + ", '" + str + "');");
/*      */           }
/*      */           
/*  716 */           if (i != c) {
/*      */             continue label34;
/*      */           }
/*      */         } 
/*  720 */       } catch (IOException iOException) {
/*  721 */         writeError(paramPrintWriter, iOException);
/*  722 */         bool = true;
/*      */       } 
/*      */     } 
/*  725 */     paramPrintWriter.println("-- lobMap.size: " + mVMap2.sizeAsLong());
/*  726 */     paramPrintWriter.println("-- lobData.size: " + mVMap1.sizeAsLong());
/*      */     
/*  728 */     if (bool) {
/*  729 */       paramPrintWriter.println("-- lobMap");
/*  730 */       for (Long long_ : mVMap2.keyList()) {
/*  731 */         Object[] arrayOfObject = (Object[])mVMap2.get(long_);
/*  732 */         byte[] arrayOfByte = (byte[])arrayOfObject[0];
/*  733 */         paramPrintWriter.println("--     " + long_ + " " + StreamStore.toString(arrayOfByte));
/*      */       } 
/*  735 */       paramPrintWriter.println("-- lobData");
/*  736 */       for (Long long_ : mVMap1.keyList()) {
/*  737 */         paramPrintWriter.println("--     " + long_ + " len " + ((byte[])mVMap1.get(long_)).length);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static String getPageType(int paramInt) {
/*  743 */     switch (paramInt) {
/*      */       case 0:
/*  745 */         return "free";
/*      */       case 1:
/*  747 */         return "data leaf";
/*      */       case 2:
/*  749 */         return "data node";
/*      */       case 3:
/*  751 */         return "data overflow";
/*      */       case 4:
/*  753 */         return "btree leaf";
/*      */       case 5:
/*  755 */         return "btree node";
/*      */       case 6:
/*  757 */         return "free list";
/*      */       case 7:
/*  759 */         return "stream trunk";
/*      */       case 8:
/*  761 */         return "stream data";
/*      */     } 
/*  763 */     return "[" + paramInt + "]";
/*      */   }
/*      */   
/*      */   private void dumpPageStore(PrintWriter paramPrintWriter, long paramLong) {
/*  767 */     Data data = Data.create(this, this.pageSize); long l;
/*  768 */     for (l = 3L; l < paramLong; l++) {
/*  769 */       data = Data.create(this, this.pageSize);
/*  770 */       seek(l);
/*  771 */       this.store.readFully(data.getBytes(), 0, this.pageSize);
/*  772 */       dumpPage(paramPrintWriter, data, l, paramLong);
/*      */     } 
/*      */   } private void dumpPage(PrintWriter paramPrintWriter, Data paramData, long paramLong1, long paramLong2) {
/*      */     try {
/*      */       int j, k;
/*      */       short s;
/*  778 */       byte b = paramData.readByte();
/*  779 */       switch (b) {
/*      */         case 0:
/*  781 */           this.stat.pageTypeCount[b] = this.stat.pageTypeCount[b] + 1;
/*      */           return;
/*      */       } 
/*  784 */       boolean bool = ((b & 0x10) != 0) ? true : false;
/*  785 */       int i = b & 0xFFFFFFEF;
/*  786 */       if (!PageStore.checksumTest(paramData.getBytes(), (int)paramLong1, this.pageSize)) {
/*  787 */         writeDataError(paramPrintWriter, "checksum mismatch type: " + i, paramData.getBytes());
/*      */       }
/*  789 */       paramData.readShortInt();
/*  790 */       switch (i) {
/*      */         
/*      */         case 1:
/*  793 */           this.stat.pageTypeCount[i] = this.stat.pageTypeCount[i] + 1;
/*  794 */           j = paramData.readInt();
/*  795 */           setStorage(paramData.readVarInt());
/*  796 */           k = paramData.readVarInt();
/*  797 */           s = paramData.readShortInt();
/*  798 */           paramPrintWriter.println("-- page " + paramLong1 + ": data leaf " + (bool ? "(last) " : "") + "parent: " + j + " table: " + this.storageId + " entries: " + s + " columns: " + k);
/*      */ 
/*      */ 
/*      */           
/*  802 */           dumpPageDataLeaf(paramPrintWriter, paramData, bool, paramLong1, k, s);
/*      */           return;
/*      */ 
/*      */         
/*      */         case 2:
/*  807 */           this.stat.pageTypeCount[i] = this.stat.pageTypeCount[i] + 1;
/*  808 */           j = paramData.readInt();
/*  809 */           setStorage(paramData.readVarInt());
/*  810 */           k = paramData.readInt();
/*  811 */           s = paramData.readShortInt();
/*  812 */           paramPrintWriter.println("-- page " + paramLong1 + ": data node " + (bool ? "(last) " : "") + "parent: " + j + " table: " + this.storageId + " entries: " + s + " rowCount: " + k);
/*      */ 
/*      */ 
/*      */           
/*  816 */           dumpPageDataNode(paramPrintWriter, paramData, paramLong1, s);
/*      */           return;
/*      */ 
/*      */         
/*      */         case 3:
/*  821 */           this.stat.pageTypeCount[i] = this.stat.pageTypeCount[i] + 1;
/*  822 */           paramPrintWriter.println("-- page " + paramLong1 + ": data overflow " + (bool ? "(last) " : ""));
/*      */           return;
/*      */ 
/*      */         
/*      */         case 4:
/*  827 */           this.stat.pageTypeCount[i] = this.stat.pageTypeCount[i] + 1;
/*  828 */           j = paramData.readInt();
/*  829 */           setStorage(paramData.readVarInt());
/*  830 */           k = paramData.readShortInt();
/*  831 */           paramPrintWriter.println("-- page " + paramLong1 + ": b-tree leaf " + (bool ? "(last) " : "") + "parent: " + j + " index: " + this.storageId + " entries: " + k);
/*      */ 
/*      */           
/*  834 */           if (this.trace) {
/*  835 */             dumpPageBtreeLeaf(paramPrintWriter, paramData, k, !bool);
/*      */           }
/*      */           return;
/*      */ 
/*      */         
/*      */         case 5:
/*  841 */           this.stat.pageTypeCount[i] = this.stat.pageTypeCount[i] + 1;
/*  842 */           j = paramData.readInt();
/*  843 */           setStorage(paramData.readVarInt());
/*  844 */           paramPrintWriter.println("-- page " + paramLong1 + ": b-tree node " + (bool ? "(last) " : "") + "parent: " + j + " index: " + this.storageId);
/*      */ 
/*      */           
/*  847 */           dumpPageBtreeNode(paramPrintWriter, paramData, paramLong1, !bool);
/*      */           return;
/*      */         
/*      */         case 6:
/*  851 */           this.stat.pageTypeCount[i] = this.stat.pageTypeCount[i] + 1;
/*  852 */           paramPrintWriter.println("-- page " + paramLong1 + ": free list " + (bool ? "(last)" : ""));
/*  853 */           this.stat.free += dumpPageFreeList(paramPrintWriter, paramData, paramLong1, paramLong2);
/*      */           return;
/*      */         
/*      */         case 7:
/*  857 */           this.stat.pageTypeCount[i] = this.stat.pageTypeCount[i] + 1;
/*  858 */           paramPrintWriter.println("-- page " + paramLong1 + ": log trunk");
/*      */           return;
/*      */         
/*      */         case 8:
/*  862 */           this.stat.pageTypeCount[i] = this.stat.pageTypeCount[i] + 1;
/*  863 */           paramPrintWriter.println("-- page " + paramLong1 + ": log data");
/*      */           return;
/*      */       } 
/*  866 */       paramPrintWriter.println("-- ERROR page " + paramLong1 + " unknown type " + i);
/*      */     
/*      */     }
/*  869 */     catch (Exception exception) {
/*  870 */       writeError(paramPrintWriter, exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void dumpPageLogStream(PrintWriter paramPrintWriter, int paramInt1, int paramInt2, int paramInt3, long paramLong) throws IOException {
/*  877 */     Data data = Data.create(this, this.pageSize);
/*  878 */     DataReader dataReader = new DataReader(new PageInputStream(paramPrintWriter, this, this.store, paramInt1, paramInt2, paramInt3, this.pageSize));
/*      */ 
/*      */ 
/*      */     
/*  882 */     paramPrintWriter.println("---- Transaction log ----");
/*  883 */     CompressLZF compressLZF = new CompressLZF();
/*      */     while (true) {
/*  885 */       byte b = dataReader.readByte();
/*  886 */       if (b < 0) {
/*      */         break;
/*      */       }
/*  889 */       if (b == 0)
/*      */         continue; 
/*  891 */       if (b == 1) {
/*  892 */         int i = dataReader.readVarInt();
/*  893 */         int j = dataReader.readVarInt();
/*  894 */         byte[] arrayOfByte = new byte[this.pageSize];
/*  895 */         if (j == 0) {
/*  896 */           dataReader.readFully(arrayOfByte, this.pageSize);
/*  897 */         } else if (j != 1) {
/*      */ 
/*      */           
/*  900 */           byte[] arrayOfByte1 = new byte[j];
/*  901 */           dataReader.readFully(arrayOfByte1, j);
/*      */           try {
/*  903 */             compressLZF.expand(arrayOfByte1, 0, j, arrayOfByte, 0, this.pageSize);
/*  904 */           } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/*  905 */             throw DbException.convertToIOException(arrayIndexOutOfBoundsException);
/*      */           } 
/*      */         } 
/*  908 */         String str = "";
/*  909 */         byte b1 = arrayOfByte[0];
/*  910 */         boolean bool = ((b1 & 0x10) != 0) ? true : false;
/*  911 */         int k = b1 & 0xFFFFFFEF;
/*  912 */         switch (k) {
/*      */           case 0:
/*  914 */             str = "empty";
/*      */             break;
/*      */           case 1:
/*  917 */             str = "data leaf " + (bool ? "(last)" : "");
/*      */             break;
/*      */           case 2:
/*  920 */             str = "data node " + (bool ? "(last)" : "");
/*      */             break;
/*      */           case 3:
/*  923 */             str = "data overflow " + (bool ? "(last)" : "");
/*      */             break;
/*      */           case 4:
/*  926 */             str = "b-tree leaf " + (bool ? "(last)" : "");
/*      */             break;
/*      */           case 5:
/*  929 */             str = "b-tree node " + (bool ? "(last)" : "");
/*      */             break;
/*      */           case 6:
/*  932 */             str = "free list " + (bool ? "(last)" : "");
/*      */             break;
/*      */           case 7:
/*  935 */             str = "log trunk";
/*      */             break;
/*      */           case 8:
/*  938 */             str = "log data";
/*      */             break;
/*      */           default:
/*  941 */             str = "ERROR: unknown type " + k;
/*      */             break;
/*      */         } 
/*  944 */         paramPrintWriter.println("-- undo page " + i + " " + str);
/*  945 */         if (this.trace) {
/*  946 */           Data data1 = Data.create(null, arrayOfByte);
/*  947 */           dumpPage(paramPrintWriter, data1, i, paramLong);
/*      */         }  continue;
/*  949 */       }  if (b == 5) {
/*  950 */         int i = dataReader.readVarInt();
/*  951 */         setStorage(dataReader.readVarInt());
/*  952 */         Row row = PageLog.readRow(RowFactory.DEFAULT, dataReader, data);
/*  953 */         paramPrintWriter.println("-- session " + i + " table " + this.storageId + " + " + row.toString());
/*      */ 
/*      */         
/*  956 */         if (this.transactionLog) {
/*  957 */           if (this.storageId == 0 && row.getColumnCount() >= 4) {
/*  958 */             int j = (int)row.getKey();
/*  959 */             String str1 = row.getValue(3).getString();
/*  960 */             String str2 = extractTableOrViewName(str1);
/*  961 */             if (row.getValue(2).getInt() == 0) {
/*  962 */               this.tableMap.put(Integer.valueOf(j), str2);
/*      */             }
/*  964 */             paramPrintWriter.println(str1 + ";"); continue;
/*      */           } 
/*  966 */           String str = this.tableMap.get(Integer.valueOf(this.storageId));
/*  967 */           if (str != null) {
/*  968 */             StatementBuilder statementBuilder = new StatementBuilder();
/*  969 */             statementBuilder.append("INSERT INTO ").append(str).append(" VALUES(");
/*      */             
/*  971 */             for (byte b1 = 0; b1 < row.getColumnCount(); b1++) {
/*  972 */               statementBuilder.appendExceptFirst(", ");
/*  973 */               statementBuilder.append(row.getValue(b1).getSQL());
/*      */             } 
/*  975 */             statementBuilder.append(");");
/*  976 */             paramPrintWriter.println(statementBuilder.toString());
/*      */           } 
/*      */         }  continue;
/*      */       } 
/*  980 */       if (b == 6) {
/*  981 */         int i = dataReader.readVarInt();
/*  982 */         setStorage(dataReader.readVarInt());
/*  983 */         long l = dataReader.readVarLong();
/*  984 */         paramPrintWriter.println("-- session " + i + " table " + this.storageId + " - " + l);
/*      */ 
/*      */         
/*  987 */         if (this.transactionLog) {
/*  988 */           if (this.storageId == 0) {
/*  989 */             int j = (int)l;
/*  990 */             String str1 = this.tableMap.get(Integer.valueOf(j));
/*  991 */             if (str1 != null)
/*  992 */               paramPrintWriter.println("DROP TABLE IF EXISTS " + str1 + ";"); 
/*      */             continue;
/*      */           } 
/*  995 */           String str = this.tableMap.get(Integer.valueOf(this.storageId));
/*  996 */           if (str != null) {
/*  997 */             String str1 = "DELETE FROM " + str + " WHERE _ROWID_ = " + l + ";";
/*      */             
/*  999 */             paramPrintWriter.println(str1);
/*      */           } 
/*      */         }  continue;
/*      */       } 
/* 1003 */       if (b == 7) {
/* 1004 */         int i = dataReader.readVarInt();
/* 1005 */         setStorage(dataReader.readVarInt());
/* 1006 */         paramPrintWriter.println("-- session " + i + " table " + this.storageId + " truncate");
/*      */ 
/*      */         
/* 1009 */         if (this.transactionLog)
/* 1010 */           paramPrintWriter.println("TRUNCATE TABLE " + this.storageId);  continue;
/*      */       } 
/* 1012 */       if (b == 2) {
/* 1013 */         int i = dataReader.readVarInt();
/* 1014 */         paramPrintWriter.println("-- commit " + i); continue;
/* 1015 */       }  if (b == 4) {
/* 1016 */         int i = dataReader.readVarInt();
/* 1017 */         paramPrintWriter.println("-- rollback " + i); continue;
/* 1018 */       }  if (b == 3) {
/* 1019 */         int i = dataReader.readVarInt();
/* 1020 */         String str = dataReader.readString();
/* 1021 */         paramPrintWriter.println("-- prepare commit " + i + " " + str); continue;
/* 1022 */       }  if (b == 0)
/*      */         continue; 
/* 1024 */       if (b == 8) {
/* 1025 */         paramPrintWriter.println("-- checkpoint"); continue;
/* 1026 */       }  if (b == 9) {
/* 1027 */         int i = dataReader.readVarInt();
/* 1028 */         StringBuilder stringBuilder = new StringBuilder("-- free");
/* 1029 */         for (byte b1 = 0; b1 < i; b1++) {
/* 1030 */           stringBuilder.append(' ').append(dataReader.readVarInt());
/*      */         }
/* 1032 */         paramPrintWriter.println(stringBuilder); continue;
/*      */       } 
/* 1034 */       paramPrintWriter.println("-- ERROR: unknown operation " + b);
/*      */       break;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private String setStorage(int paramInt) {
/* 1041 */     this.storageId = paramInt;
/* 1042 */     this.storageName = "O_" + String.valueOf(paramInt).replace('-', 'M');
/* 1043 */     return this.storageName;
/*      */   }
/*      */ 
/*      */   
/*      */   static class PageInputStream
/*      */     extends InputStream
/*      */   {
/*      */     private final PrintWriter writer;
/*      */     
/*      */     private final FileStore store;
/*      */     private final Data page;
/*      */     private final int pageSize;
/*      */     private long trunkPage;
/*      */     private long nextTrunkPage;
/*      */     private long dataPage;
/* 1058 */     private final IntArray dataPages = new IntArray();
/*      */     
/*      */     private boolean endOfFile;
/*      */     
/*      */     private int remaining;
/*      */     private int logKey;
/*      */     
/*      */     public PageInputStream(PrintWriter param1PrintWriter, DataHandler param1DataHandler, FileStore param1FileStore, int param1Int1, long param1Long1, long param1Long2, int param1Int2) {
/* 1066 */       this.writer = param1PrintWriter;
/* 1067 */       this.store = param1FileStore;
/* 1068 */       this.pageSize = param1Int2;
/* 1069 */       this.logKey = param1Int1 - 1;
/* 1070 */       this.nextTrunkPage = param1Long1;
/* 1071 */       this.dataPage = param1Long2;
/* 1072 */       this.page = Data.create(param1DataHandler, param1Int2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int read() {
/* 1077 */       byte[] arrayOfByte = { 0 };
/* 1078 */       int i = read(arrayOfByte);
/* 1079 */       return (i < 0) ? -1 : (arrayOfByte[0] & 0xFF);
/*      */     }
/*      */ 
/*      */     
/*      */     public int read(byte[] param1ArrayOfbyte) {
/* 1084 */       return read(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
/*      */     }
/*      */ 
/*      */     
/*      */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 1089 */       if (param1Int2 == 0) {
/* 1090 */         return 0;
/*      */       }
/* 1092 */       int i = 0;
/* 1093 */       while (param1Int2 > 0) {
/* 1094 */         int j = readBlock(param1ArrayOfbyte, param1Int1, param1Int2);
/* 1095 */         if (j < 0) {
/*      */           break;
/*      */         }
/* 1098 */         i += j;
/* 1099 */         param1Int1 += j;
/* 1100 */         param1Int2 -= j;
/*      */       } 
/* 1102 */       return (i == 0) ? -1 : i;
/*      */     }
/*      */     
/*      */     private int readBlock(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 1106 */       fillBuffer();
/* 1107 */       if (this.endOfFile) {
/* 1108 */         return -1;
/*      */       }
/* 1110 */       int i = Math.min(this.remaining, param1Int2);
/* 1111 */       this.page.read(param1ArrayOfbyte, param1Int1, i);
/* 1112 */       this.remaining -= i;
/* 1113 */       return i;
/*      */     }
/*      */     
/*      */     private void fillBuffer() {
/* 1117 */       if (this.remaining > 0 || this.endOfFile) {
/*      */         return;
/*      */       }
/* 1120 */       while (this.dataPages.size() == 0) {
/* 1121 */         if (this.nextTrunkPage == 0L) {
/* 1122 */           this.endOfFile = true;
/*      */           return;
/*      */         } 
/* 1125 */         this.trunkPage = this.nextTrunkPage;
/* 1126 */         this.store.seek(this.trunkPage * this.pageSize);
/* 1127 */         this.store.readFully(this.page.getBytes(), 0, this.pageSize);
/* 1128 */         this.page.reset();
/* 1129 */         if (!PageStore.checksumTest(this.page.getBytes(), (int)this.trunkPage, this.pageSize)) {
/* 1130 */           this.writer.println("-- ERROR: checksum mismatch page: " + this.trunkPage);
/* 1131 */           this.endOfFile = true;
/*      */           return;
/*      */         } 
/* 1134 */         byte b = this.page.readByte();
/* 1135 */         this.page.readShortInt();
/* 1136 */         if (b != 7) {
/* 1137 */           this.writer.println("-- log eof " + this.trunkPage + " type: " + b + " expected type: " + '\007');
/*      */           
/* 1139 */           this.endOfFile = true;
/*      */           return;
/*      */         } 
/* 1142 */         this.page.readInt();
/* 1143 */         int i = this.page.readInt();
/* 1144 */         this.logKey++;
/* 1145 */         if (i != this.logKey) {
/* 1146 */           this.writer.println("-- log eof " + this.trunkPage + " type: " + b + " expected key: " + this.logKey + " got: " + i);
/*      */         }
/*      */         
/* 1149 */         this.nextTrunkPage = this.page.readInt();
/* 1150 */         this.writer.println("-- log " + i + ":" + this.trunkPage + " next: " + this.nextTrunkPage);
/*      */         
/* 1152 */         short s = this.page.readShortInt();
/* 1153 */         for (byte b1 = 0; b1 < s; b1++) {
/* 1154 */           int j = this.page.readInt();
/* 1155 */           if (this.dataPage != 0L) {
/* 1156 */             if (j == this.dataPage) {
/* 1157 */               this.dataPage = 0L;
/*      */             } else {
/*      */               continue;
/*      */             } 
/*      */           }
/*      */           
/* 1163 */           this.dataPages.add(j); continue;
/*      */         } 
/*      */       } 
/* 1166 */       if (this.dataPages.size() > 0) {
/* 1167 */         this.page.reset();
/* 1168 */         long l = this.dataPages.get(0);
/* 1169 */         this.dataPages.remove(0);
/* 1170 */         this.store.seek(l * this.pageSize);
/* 1171 */         this.store.readFully(this.page.getBytes(), 0, this.pageSize);
/* 1172 */         this.page.reset();
/* 1173 */         byte b = this.page.readByte();
/* 1174 */         if (b != 0 && !PageStore.checksumTest(this.page.getBytes(), (int)l, this.pageSize)) {
/*      */           
/* 1176 */           this.writer.println("-- ERROR: checksum mismatch page: " + l);
/* 1177 */           this.endOfFile = true;
/*      */           return;
/*      */         } 
/* 1180 */         this.page.readShortInt();
/* 1181 */         int i = this.page.readInt();
/* 1182 */         int j = this.page.readInt();
/* 1183 */         this.writer.println("-- log " + j + ":" + this.trunkPage + "/" + l);
/* 1184 */         if (b != 8) {
/* 1185 */           this.writer.println("-- log eof " + l + " type: " + b + " parent: " + i + " expected type: " + '\b');
/*      */           
/* 1187 */           this.endOfFile = true; return;
/*      */         } 
/* 1189 */         if (j != this.logKey) {
/* 1190 */           this.writer.println("-- log eof " + l + " type: " + b + " parent: " + i + " expected key: " + this.logKey + " got: " + j);
/*      */           
/* 1192 */           this.endOfFile = true;
/*      */           return;
/*      */         } 
/* 1195 */         this.remaining = this.pageSize - this.page.length();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void dumpPageBtreeNode(PrintWriter paramPrintWriter, Data paramData, long paramLong, boolean paramBoolean) {
/* 1202 */     int i = paramData.readInt();
/* 1203 */     short s = paramData.readShortInt();
/* 1204 */     int[] arrayOfInt1 = new int[s + 1];
/* 1205 */     int[] arrayOfInt2 = new int[s];
/* 1206 */     arrayOfInt1[s] = paramData.readInt();
/* 1207 */     checkParent(paramPrintWriter, paramLong, arrayOfInt1, s);
/* 1208 */     int j = Integer.MAX_VALUE; byte b;
/* 1209 */     for (b = 0; b < s; b++) {
/* 1210 */       arrayOfInt1[b] = paramData.readInt();
/* 1211 */       checkParent(paramPrintWriter, paramLong, arrayOfInt1, b);
/* 1212 */       short s1 = paramData.readShortInt();
/* 1213 */       j = Math.min(s1, j);
/* 1214 */       arrayOfInt2[b] = s1;
/*      */     } 
/* 1216 */     j -= paramData.length();
/* 1217 */     if (!this.trace) {
/*      */       return;
/*      */     }
/* 1220 */     paramPrintWriter.println("--   empty: " + j);
/* 1221 */     for (b = 0; b < s; b++) {
/* 1222 */       Value value; int k = arrayOfInt2[b];
/* 1223 */       paramData.setPos(k);
/* 1224 */       long l = paramData.readVarLong();
/*      */       
/* 1226 */       if (paramBoolean) {
/* 1227 */         ValueLong valueLong = ValueLong.get(l);
/*      */       } else {
/*      */         try {
/* 1230 */           value = paramData.readValue();
/* 1231 */         } catch (Throwable throwable) {
/* 1232 */           writeDataError(paramPrintWriter, "exception " + throwable, paramData.getBytes());
/*      */         } 
/*      */       } 
/*      */       
/* 1236 */       paramPrintWriter.println("-- [" + b + "] child: " + arrayOfInt1[b] + " key: " + l + " data: " + value);
/*      */     } 
/*      */     
/* 1239 */     paramPrintWriter.println("-- [" + s + "] child: " + arrayOfInt1[s] + " rowCount: " + i);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int dumpPageFreeList(PrintWriter paramPrintWriter, Data paramData, long paramLong1, long paramLong2) {
/* 1245 */     int i = PageFreeList.getPagesAddressed(this.pageSize);
/* 1246 */     BitField bitField = new BitField(); byte b;
/* 1247 */     for (b = 0; b < i; b += 8) {
/* 1248 */       int j = paramData.readByte() & 0xFF;
/* 1249 */       for (byte b1 = 0; b1 < 8; b1++) {
/* 1250 */         if ((j & 1 << b1) != 0) {
/* 1251 */           bitField.set(b + b1);
/*      */         }
/*      */       } 
/*      */     } 
/* 1255 */     b = 0; long l2;
/* 1256 */     for (long l1 = 0L; l1 < i && l2 < paramLong2; l1++, l2++) {
/* 1257 */       if (l1 == 0L || l2 % 100L == 0L) {
/* 1258 */         if (l1 > 0L) {
/* 1259 */           paramPrintWriter.println();
/*      */         }
/* 1261 */         paramPrintWriter.print("-- " + l2 + " ");
/* 1262 */       } else if (l2 % 20L == 0L) {
/* 1263 */         paramPrintWriter.print(" - ");
/* 1264 */       } else if (l2 % 10L == 0L) {
/* 1265 */         paramPrintWriter.print(' ');
/*      */       } 
/* 1267 */       paramPrintWriter.print(bitField.get((int)l1) ? 49 : 48);
/* 1268 */       if (!bitField.get((int)l1)) {
/* 1269 */         b++;
/*      */       }
/*      */     } 
/* 1272 */     paramPrintWriter.println();
/* 1273 */     return b;
/*      */   }
/*      */ 
/*      */   
/*      */   private void dumpPageBtreeLeaf(PrintWriter paramPrintWriter, Data paramData, int paramInt, boolean paramBoolean) {
/* 1278 */     int[] arrayOfInt = new int[paramInt];
/* 1279 */     int i = Integer.MAX_VALUE; byte b;
/* 1280 */     for (b = 0; b < paramInt; b++) {
/* 1281 */       short s = paramData.readShortInt();
/* 1282 */       i = Math.min(s, i);
/* 1283 */       arrayOfInt[b] = s;
/*      */     } 
/* 1285 */     i -= paramData.length();
/* 1286 */     paramPrintWriter.println("--   empty: " + i);
/* 1287 */     for (b = 0; b < paramInt; b++) {
/* 1288 */       Value value; int j = arrayOfInt[b];
/* 1289 */       paramData.setPos(j);
/* 1290 */       long l = paramData.readVarLong();
/*      */       
/* 1292 */       if (paramBoolean) {
/* 1293 */         ValueLong valueLong = ValueLong.get(l);
/*      */       } else {
/*      */         try {
/* 1296 */           value = paramData.readValue();
/* 1297 */         } catch (Throwable throwable) {
/* 1298 */           writeDataError(paramPrintWriter, "exception " + throwable, paramData.getBytes());
/*      */         } 
/*      */       } 
/*      */       
/* 1302 */       paramPrintWriter.println("-- [" + b + "] key: " + l + " data: " + value);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void checkParent(PrintWriter paramPrintWriter, long paramLong, int[] paramArrayOfint, int paramInt) {
/* 1308 */     int i = paramArrayOfint[paramInt];
/* 1309 */     if (i < 0 || i >= this.parents.length) {
/* 1310 */       paramPrintWriter.println("-- ERROR [" + paramLong + "] child[" + paramInt + "]: " + i + " >= page count: " + this.parents.length);
/*      */     }
/* 1312 */     else if (this.parents[i] != paramLong) {
/* 1313 */       paramPrintWriter.println("-- ERROR [" + paramLong + "] child[" + paramInt + "]: " + i + " parent: " + this.parents[i]);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void dumpPageDataNode(PrintWriter paramPrintWriter, Data paramData, long paramLong, int paramInt) {
/* 1320 */     int[] arrayOfInt = new int[paramInt + 1];
/* 1321 */     long[] arrayOfLong = new long[paramInt];
/* 1322 */     arrayOfInt[paramInt] = paramData.readInt();
/* 1323 */     checkParent(paramPrintWriter, paramLong, arrayOfInt, paramInt); byte b;
/* 1324 */     for (b = 0; b < paramInt; b++) {
/* 1325 */       arrayOfInt[b] = paramData.readInt();
/* 1326 */       checkParent(paramPrintWriter, paramLong, arrayOfInt, b);
/* 1327 */       arrayOfLong[b] = paramData.readVarLong();
/*      */     } 
/* 1329 */     if (!this.trace) {
/*      */       return;
/*      */     }
/* 1332 */     for (b = 0; b < paramInt; b++) {
/* 1333 */       paramPrintWriter.println("-- [" + b + "] child: " + arrayOfInt[b] + " key: " + arrayOfLong[b]);
/*      */     }
/* 1335 */     paramPrintWriter.println("-- [" + paramInt + "] child: " + arrayOfInt[paramInt]);
/*      */   }
/*      */ 
/*      */   
/*      */   private void dumpPageDataLeaf(PrintWriter paramPrintWriter, Data paramData, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {
/* 1340 */     long[] arrayOfLong = new long[paramInt2];
/* 1341 */     int[] arrayOfInt = new int[paramInt2];
/* 1342 */     long l = 0L;
/* 1343 */     if (!paramBoolean) {
/* 1344 */       l = paramData.readInt();
/* 1345 */       paramPrintWriter.println("--   next: " + l);
/*      */     } 
/* 1347 */     int i = this.pageSize; byte b;
/* 1348 */     for (b = 0; b < paramInt2; b++) {
/* 1349 */       arrayOfLong[b] = paramData.readVarLong();
/* 1350 */       short s = paramData.readShortInt();
/* 1351 */       i = Math.min(s, i);
/* 1352 */       arrayOfInt[b] = s;
/*      */     } 
/* 1354 */     this.stat.pageDataRows += (this.pageSize - i);
/* 1355 */     i -= paramData.length();
/* 1356 */     this.stat.pageDataHead += paramData.length();
/* 1357 */     this.stat.pageDataEmpty += i;
/* 1358 */     if (this.trace) {
/* 1359 */       paramPrintWriter.println("--   empty: " + i);
/*      */     }
/* 1361 */     if (!paramBoolean) {
/* 1362 */       Data data = Data.create(this, this.pageSize);
/* 1363 */       paramData.setPos(this.pageSize);
/* 1364 */       long l1 = paramLong;
/*      */       while (true) {
/* 1366 */         checkParent(paramPrintWriter, l1, new int[] { (int)l }, 0);
/* 1367 */         l1 = l;
/* 1368 */         seek(l);
/* 1369 */         this.store.readFully(data.getBytes(), 0, this.pageSize);
/* 1370 */         data.reset();
/* 1371 */         byte b1 = data.readByte();
/* 1372 */         data.readShortInt();
/* 1373 */         data.readInt();
/* 1374 */         if (b1 == 19) {
/* 1375 */           short s = data.readShortInt();
/* 1376 */           paramPrintWriter.println("-- chain: " + l + " type: " + b1 + " size: " + s);
/*      */           
/* 1378 */           paramData.checkCapacity(s);
/* 1379 */           paramData.write(data.getBytes(), data.length(), s); break;
/*      */         } 
/* 1381 */         if (b1 == 3) {
/* 1382 */           l = data.readInt();
/* 1383 */           if (l == 0L) {
/* 1384 */             writeDataError(paramPrintWriter, "next:0", data.getBytes());
/*      */             break;
/*      */           } 
/* 1387 */           int j = this.pageSize - data.length();
/* 1388 */           paramPrintWriter.println("-- chain: " + l + " type: " + b1 + " size: " + j + " next: " + l);
/*      */           
/* 1390 */           paramData.checkCapacity(j);
/* 1391 */           paramData.write(data.getBytes(), data.length(), j); continue;
/*      */         } 
/* 1393 */         writeDataError(paramPrintWriter, "type: " + b1, data.getBytes());
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 1398 */     for (b = 0; b < paramInt2; b++) {
/* 1399 */       long l1 = arrayOfLong[b];
/* 1400 */       int j = arrayOfInt[b];
/* 1401 */       if (this.trace) {
/* 1402 */         paramPrintWriter.println("-- [" + b + "] storage: " + this.storageId + " key: " + l1 + " off: " + j);
/*      */       }
/*      */       
/* 1405 */       paramData.setPos(j);
/* 1406 */       Value[] arrayOfValue = createRecord(paramPrintWriter, paramData, paramInt1);
/* 1407 */       if (arrayOfValue != null) {
/* 1408 */         createTemporaryTable(paramPrintWriter);
/* 1409 */         writeRow(paramPrintWriter, paramData, arrayOfValue);
/* 1410 */         if (this.remove && this.storageId == 0) {
/* 1411 */           String str = arrayOfValue[3].getString();
/* 1412 */           if (str.startsWith("CREATE USER ")) {
/* 1413 */             int k = Utils.indexOf(paramData.getBytes(), "SALT ".getBytes(), j);
/* 1414 */             if (k >= 0) {
/* 1415 */               String str1 = str.substring("CREATE USER ".length(), str.indexOf("SALT ") - 1);
/*      */               
/* 1417 */               if (str1.startsWith("IF NOT EXISTS ")) {
/* 1418 */                 str1 = str1.substring("IF NOT EXISTS ".length());
/*      */               }
/* 1420 */               if (str1.startsWith("\""))
/*      */               {
/*      */                 
/* 1423 */                 str1 = str1.substring(1, str1.length() - 1);
/*      */               }
/* 1425 */               byte[] arrayOfByte1 = SHA256.getKeyPasswordHash(str1, "".toCharArray());
/*      */               
/* 1427 */               byte[] arrayOfByte2 = MathUtils.secureRandomBytes(8);
/* 1428 */               byte[] arrayOfByte3 = SHA256.getHashWithSalt(arrayOfByte1, arrayOfByte2);
/*      */               
/* 1430 */               StringBuilder stringBuilder = new StringBuilder();
/* 1431 */               stringBuilder.append("SALT '").append(StringUtils.convertBytesToHex(arrayOfByte2)).append("' HASH '").append(StringUtils.convertBytesToHex(arrayOfByte3)).append('\'');
/*      */ 
/*      */ 
/*      */ 
/*      */               
/* 1436 */               byte[] arrayOfByte4 = stringBuilder.toString().getBytes();
/* 1437 */               System.arraycopy(arrayOfByte4, 0, paramData.getBytes(), k, arrayOfByte4.length);
/*      */               
/* 1439 */               seek(paramLong);
/* 1440 */               this.store.write(paramData.getBytes(), 0, this.pageSize);
/* 1441 */               if (this.trace) {
/* 1442 */                 this.out.println("User: " + str1);
/*      */               }
/* 1444 */               this.remove = false;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void seek(long paramLong) {
/* 1454 */     this.store.seek(paramLong * this.pageSize);
/*      */   }
/*      */   private Value[] createRecord(PrintWriter paramPrintWriter, Data paramData, int paramInt) {
/*      */     Value[] arrayOfValue;
/* 1458 */     this.recordLength = paramInt;
/* 1459 */     if (paramInt <= 0) {
/* 1460 */       writeDataError(paramPrintWriter, "columnCount<0", paramData.getBytes());
/* 1461 */       return null;
/*      */     } 
/*      */     
/*      */     try {
/* 1465 */       arrayOfValue = new Value[paramInt];
/* 1466 */     } catch (OutOfMemoryError outOfMemoryError) {
/* 1467 */       writeDataError(paramPrintWriter, "out of memory", paramData.getBytes());
/* 1468 */       return null;
/*      */     } 
/* 1470 */     return arrayOfValue;
/*      */   }
/*      */   
/*      */   private void writeRow(PrintWriter paramPrintWriter, Data paramData, Value[] paramArrayOfValue) {
/* 1474 */     StringBuilder stringBuilder = new StringBuilder();
/* 1475 */     stringBuilder.append("INSERT INTO " + this.storageName + " VALUES(");
/* 1476 */     for (this.valueId = 0; this.valueId < this.recordLength; this.valueId++) {
/*      */       try {
/* 1478 */         Value value = paramData.readValue();
/* 1479 */         paramArrayOfValue[this.valueId] = value;
/* 1480 */         if (this.valueId > 0) {
/* 1481 */           stringBuilder.append(", ");
/*      */         }
/* 1483 */         String str = this.storageName + "." + this.valueId;
/* 1484 */         stringBuilder.append(getSQL(str, value));
/* 1485 */       } catch (Exception exception) {
/* 1486 */         writeDataError(paramPrintWriter, "exception " + exception, paramData.getBytes());
/*      */       }
/* 1488 */       catch (OutOfMemoryError outOfMemoryError) {
/* 1489 */         writeDataError(paramPrintWriter, "out of memory", paramData.getBytes());
/*      */       } 
/*      */     } 
/*      */     
/* 1493 */     stringBuilder.append(");");
/* 1494 */     paramPrintWriter.println(stringBuilder.toString());
/* 1495 */     if (this.storageId == 0) {
/*      */       try {
/* 1497 */         SimpleRow simpleRow = new SimpleRow(paramArrayOfValue);
/* 1498 */         MetaRecord metaRecord = new MetaRecord((SearchRow)simpleRow);
/* 1499 */         this.schema.add(metaRecord);
/* 1500 */         if (metaRecord.getObjectType() == 0) {
/* 1501 */           String str1 = paramArrayOfValue[3].getString();
/* 1502 */           String str2 = extractTableOrViewName(str1);
/* 1503 */           this.tableMap.put(Integer.valueOf(metaRecord.getId()), str2);
/*      */         } 
/* 1505 */       } catch (Throwable throwable) {
/* 1506 */         writeError(paramPrintWriter, throwable);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void resetSchema() {
/* 1512 */     this.schema = New.arrayList();
/* 1513 */     this.objectIdSet = New.hashSet();
/* 1514 */     this.tableMap = New.hashMap();
/* 1515 */     this.columnTypeMap = New.hashMap();
/*      */   }
/*      */   
/*      */   private void writeSchema(PrintWriter paramPrintWriter) {
/* 1519 */     paramPrintWriter.println("---- Schema ----");
/* 1520 */     Collections.sort(this.schema);
/* 1521 */     for (MetaRecord metaRecord : this.schema) {
/* 1522 */       if (!isSchemaObjectTypeDelayed(metaRecord)) {
/*      */ 
/*      */         
/* 1525 */         String str = metaRecord.getSQL();
/* 1526 */         paramPrintWriter.println(str + ";");
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1532 */     boolean bool = false;
/* 1533 */     for (Map.Entry<Integer, String> entry : this.tableMap.entrySet()) {
/* 1534 */       Integer integer = (Integer)entry.getKey();
/* 1535 */       String str = (String)entry.getValue();
/* 1536 */       if (this.objectIdSet.contains(integer) && 
/* 1537 */         str.startsWith("INFORMATION_SCHEMA.LOB")) {
/* 1538 */         setStorage(integer.intValue());
/* 1539 */         paramPrintWriter.println("DELETE FROM " + str + ";");
/* 1540 */         paramPrintWriter.println("INSERT INTO " + str + " SELECT * FROM " + this.storageName + ";");
/* 1541 */         if (str.startsWith("INFORMATION_SCHEMA.LOBS")) {
/* 1542 */           paramPrintWriter.println("UPDATE " + str + " SET TABLE = " + -2 + ";");
/*      */           
/* 1544 */           bool = true;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1549 */     for (Map.Entry<Integer, String> entry : this.tableMap.entrySet()) {
/* 1550 */       Integer integer = (Integer)entry.getKey();
/* 1551 */       String str = (String)entry.getValue();
/* 1552 */       if (this.objectIdSet.contains(integer)) {
/* 1553 */         setStorage(integer.intValue());
/* 1554 */         if (str.startsWith("INFORMATION_SCHEMA.LOB")) {
/*      */           continue;
/*      */         }
/* 1557 */         paramPrintWriter.println("INSERT INTO " + str + " SELECT * FROM " + this.storageName + ";");
/*      */       } 
/*      */     } 
/* 1560 */     for (Integer integer : this.objectIdSet) {
/* 1561 */       setStorage(integer.intValue());
/* 1562 */       paramPrintWriter.println("DROP TABLE " + this.storageName + ";");
/*      */     } 
/* 1564 */     paramPrintWriter.println("DROP ALIAS READ_BLOB;");
/* 1565 */     paramPrintWriter.println("DROP ALIAS READ_CLOB;");
/* 1566 */     paramPrintWriter.println("DROP ALIAS READ_BLOB_DB;");
/* 1567 */     paramPrintWriter.println("DROP ALIAS READ_CLOB_DB;");
/* 1568 */     if (bool) {
/* 1569 */       paramPrintWriter.println("DELETE FROM INFORMATION_SCHEMA.LOBS WHERE TABLE = -2;");
/*      */     }
/*      */     
/* 1572 */     for (MetaRecord metaRecord : this.schema) {
/* 1573 */       if (isSchemaObjectTypeDelayed(metaRecord)) {
/* 1574 */         String str = metaRecord.getSQL();
/* 1575 */         paramPrintWriter.println(str + ";");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static boolean isSchemaObjectTypeDelayed(MetaRecord paramMetaRecord) {
/* 1581 */     switch (paramMetaRecord.getObjectType()) {
/*      */       case 1:
/*      */       case 4:
/*      */       case 5:
/* 1585 */         return true;
/*      */     } 
/* 1587 */     return false;
/*      */   }
/*      */   
/*      */   private void createTemporaryTable(PrintWriter paramPrintWriter) {
/* 1591 */     if (!this.objectIdSet.contains(Integer.valueOf(this.storageId))) {
/* 1592 */       this.objectIdSet.add(Integer.valueOf(this.storageId));
/* 1593 */       StatementBuilder statementBuilder = new StatementBuilder("CREATE TABLE ");
/* 1594 */       statementBuilder.append(this.storageName).append('(');
/* 1595 */       for (byte b = 0; b < this.recordLength; b++) {
/* 1596 */         statementBuilder.appendExceptFirst(", ");
/* 1597 */         statementBuilder.append('C').append(b).append(' ');
/* 1598 */         String str = this.columnTypeMap.get(this.storageName + "." + b);
/* 1599 */         if (str == null) {
/* 1600 */           statementBuilder.append("VARCHAR");
/*      */         } else {
/* 1602 */           statementBuilder.append(str);
/*      */         } 
/*      */       } 
/* 1605 */       paramPrintWriter.println(statementBuilder.append(");").toString());
/* 1606 */       paramPrintWriter.flush();
/*      */     } 
/*      */   }
/*      */   
/*      */   private static String extractTableOrViewName(String paramString) {
/* 1611 */     int i = paramString.indexOf(" TABLE ");
/* 1612 */     int j = paramString.indexOf(" VIEW ");
/* 1613 */     if (i > 0 && j > 0) {
/* 1614 */       if (i < j) {
/* 1615 */         j = -1;
/*      */       } else {
/* 1617 */         i = -1;
/*      */       } 
/*      */     }
/* 1620 */     if (j > 0) {
/* 1621 */       paramString = paramString.substring(j + " VIEW ".length());
/* 1622 */     } else if (i > 0) {
/* 1623 */       paramString = paramString.substring(i + " TABLE ".length());
/*      */     } else {
/* 1625 */       return "UNKNOWN";
/*      */     } 
/* 1627 */     if (paramString.startsWith("IF NOT EXISTS ")) {
/* 1628 */       paramString = paramString.substring("IF NOT EXISTS ".length());
/*      */     }
/* 1630 */     boolean bool = false;
/*      */     
/* 1632 */     for (byte b = 0; b < paramString.length(); b++) {
/* 1633 */       char c = paramString.charAt(b);
/* 1634 */       if (c == '"') {
/* 1635 */         bool = !bool ? true : false;
/* 1636 */       } else if (!bool && (c <= ' ' || c == '(')) {
/* 1637 */         paramString = paramString.substring(0, b);
/* 1638 */         return paramString;
/*      */       } 
/*      */     } 
/* 1641 */     return "UNKNOWN";
/*      */   }
/*      */ 
/*      */   
/*      */   private static void closeSilently(FileStore paramFileStore) {
/* 1646 */     if (paramFileStore != null) {
/* 1647 */       paramFileStore.closeSilently();
/*      */     }
/*      */   }
/*      */   
/*      */   private void writeError(PrintWriter paramPrintWriter, Throwable paramThrowable) {
/* 1652 */     if (paramPrintWriter != null) {
/* 1653 */       paramPrintWriter.println("// error: " + paramThrowable);
/*      */     }
/* 1655 */     traceError("Error", paramThrowable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDatabasePath() {
/* 1663 */     return this.databaseName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FileStore openFile(String paramString1, String paramString2, boolean paramBoolean) {
/* 1671 */     return FileStore.open(this, paramString1, "rw");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkPowerOff() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkWritingAllowed() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxLengthInplaceLob() {
/* 1695 */     throw DbException.throwInternalError();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getLobCompressionAlgorithm(int paramInt) {
/* 1703 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getLobSyncObject() {
/* 1711 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SmallLRUCache<String, String[]> getLobFileListCache() {
/* 1719 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TempFileDeleter getTempFileDeleter() {
/* 1727 */     return TempFileDeleter.getInstance();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LobStorageBackend getLobStorage() {
/* 1735 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int readLob(long paramLong1, byte[] paramArrayOfbyte1, long paramLong2, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
/* 1744 */     throw DbException.throwInternalError();
/*      */   }
/*      */ 
/*      */   
/*      */   public JavaObjectSerializer getJavaObjectSerializer() {
/* 1749 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public CompareMode getCompareMode() {
/* 1754 */     return CompareMode.getInstance(null, 0);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\Recover.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */