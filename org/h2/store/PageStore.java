/*      */ package org.h2.store;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.OutputStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.zip.CRC32;
/*      */ import org.h2.command.ddl.CreateTableData;
/*      */ import org.h2.engine.Database;
/*      */ import org.h2.engine.Session;
/*      */ import org.h2.engine.SysProperties;
/*      */ import org.h2.index.Cursor;
/*      */ import org.h2.index.Index;
/*      */ import org.h2.index.IndexType;
/*      */ import org.h2.index.MultiVersionIndex;
/*      */ import org.h2.index.PageBtreeIndex;
/*      */ import org.h2.index.PageBtreeLeaf;
/*      */ import org.h2.index.PageBtreeNode;
/*      */ import org.h2.index.PageDataIndex;
/*      */ import org.h2.index.PageDataLeaf;
/*      */ import org.h2.index.PageDataNode;
/*      */ import org.h2.index.PageDataOverflow;
/*      */ import org.h2.index.PageIndex;
/*      */ import org.h2.message.DbException;
/*      */ import org.h2.message.Trace;
/*      */ import org.h2.result.Row;
/*      */ import org.h2.schema.Schema;
/*      */ import org.h2.schema.SchemaObject;
/*      */ import org.h2.store.fs.FileUtils;
/*      */ import org.h2.table.Column;
/*      */ import org.h2.table.IndexColumn;
/*      */ import org.h2.table.RegularTable;
/*      */ import org.h2.table.Table;
/*      */ import org.h2.util.BitField;
/*      */ import org.h2.util.Cache;
/*      */ import org.h2.util.CacheLRU;
/*      */ import org.h2.util.CacheObject;
/*      */ import org.h2.util.CacheWriter;
/*      */ import org.h2.util.IntArray;
/*      */ import org.h2.util.IntIntHashMap;
/*      */ import org.h2.util.New;
/*      */ import org.h2.util.StatementBuilder;
/*      */ import org.h2.util.StringUtils;
/*      */ import org.h2.value.CompareMode;
/*      */ import org.h2.value.Value;
/*      */ import org.h2.value.ValueInt;
/*      */ import org.h2.value.ValueString;
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
/*      */ public class PageStore
/*      */   implements CacheWriter
/*      */ {
/*      */   public static final int PAGE_SIZE_MIN = 64;
/*      */   public static final int PAGE_SIZE_MAX = 32768;
/*      */   public static final int LOG_MODE_OFF = 0;
/*      */   public static final int LOG_MODE_SYNC = 2;
/*      */   private static final int PAGE_ID_FREE_LIST_ROOT = 3;
/*      */   private static final int PAGE_ID_META_ROOT = 4;
/*      */   private static final int MIN_PAGE_COUNT = 5;
/*      */   private static final int INCREMENT_KB = 1024;
/*      */   private static final int INCREMENT_PERCENT_MIN = 35;
/*      */   private static final int READ_VERSION = 3;
/*      */   private static final int WRITE_VERSION = 3;
/*      */   private static final int META_TYPE_DATA_INDEX = 0;
/*      */   private static final int META_TYPE_BTREE_INDEX = 1;
/*      */   private static final int META_TABLE_ID = -1;
/*      */   private static final int COMPACT_BLOCK_SIZE = 1536;
/*      */   private final Database database;
/*      */   private final Trace trace;
/*      */   private final String fileName;
/*      */   private FileStore file;
/*      */   private String accessMode;
/*  137 */   private int pageSize = 4096;
/*      */   
/*      */   private int pageSizeShift;
/*      */   
/*      */   private long writeCountBase;
/*      */   
/*      */   private long writeCount;
/*      */   
/*      */   private long readCount;
/*      */   
/*      */   private int logKey;
/*      */   
/*      */   private int logFirstTrunkPage;
/*      */   
/*      */   private int logFirstDataPage;
/*      */   
/*      */   private final Cache cache;
/*      */   
/*      */   private int freeListPagesPerList;
/*      */   private boolean recoveryRunning;
/*      */   private boolean ignoreBigLog;
/*      */   private int firstFreeListIndex;
/*      */   private long fileLength;
/*      */   private int pageCount;
/*      */   private PageLog log;
/*      */   private Schema metaSchema;
/*      */   private RegularTable metaTable;
/*      */   private PageDataIndex metaIndex;
/*  165 */   private final IntIntHashMap metaRootPageId = new IntIntHashMap();
/*  166 */   private final HashMap<Integer, PageIndex> metaObjects = New.hashMap();
/*      */ 
/*      */   
/*      */   private HashMap<Integer, PageIndex> tempObjects;
/*      */ 
/*      */   
/*      */   private HashMap<Integer, Integer> reservedPages;
/*      */   
/*      */   private boolean isNew;
/*      */   
/*  176 */   private long maxLogSize = 16777216L;
/*      */ 
/*      */   
/*      */   private final Session pageStoreSession;
/*      */ 
/*      */   
/*  182 */   private final BitField freed = new BitField();
/*  183 */   private final ArrayList<PageFreeList> freeLists = New.arrayList();
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean recordPageReads;
/*      */ 
/*      */   
/*      */   private ArrayList<Integer> recordedPagesList;
/*      */ 
/*      */   
/*      */   private IntIntHashMap recordedPagesIndex;
/*      */ 
/*      */   
/*  196 */   private long changeCount = 1L;
/*      */   
/*      */   private Data emptyPage;
/*      */   private long logSizeBase;
/*      */   private HashMap<String, Integer> statistics;
/*  201 */   private int logMode = 2;
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean lockFile;
/*      */ 
/*      */   
/*      */   private boolean readMode;
/*      */ 
/*      */   
/*      */   private int backupLevel;
/*      */ 
/*      */ 
/*      */   
/*      */   public PageStore(Database paramDatabase, String paramString1, String paramString2, int paramInt) {
/*  216 */     this.fileName = paramString1;
/*  217 */     this.accessMode = paramString2;
/*  218 */     this.database = paramDatabase;
/*  219 */     this.trace = paramDatabase.getTrace(14);
/*      */ 
/*      */     
/*  222 */     String str = paramDatabase.getCacheType();
/*  223 */     this.cache = CacheLRU.getCache(this, str, paramInt);
/*  224 */     this.pageStoreSession = new Session(paramDatabase, null, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void statisticsStart() {
/*  231 */     this.statistics = New.hashMap();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HashMap<String, Integer> statisticsEnd() {
/*  240 */     HashMap<String, Integer> hashMap = this.statistics;
/*  241 */     this.statistics = null;
/*  242 */     return hashMap;
/*      */   }
/*      */   
/*      */   private void statisticsIncrement(String paramString) {
/*  246 */     if (this.statistics != null) {
/*  247 */       Integer integer = this.statistics.get(paramString);
/*  248 */       this.statistics.put(paramString, Integer.valueOf((integer == null) ? 1 : (integer.intValue() + 1)));
/*      */     } 
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
/*      */   public synchronized int copyDirect(int paramInt, OutputStream paramOutputStream) throws IOException {
/*  261 */     byte[] arrayOfByte = new byte[this.pageSize];
/*  262 */     if (paramInt >= this.pageCount) {
/*  263 */       return -1;
/*      */     }
/*  265 */     this.file.seek(paramInt << this.pageSizeShift);
/*  266 */     this.file.readFullyDirect(arrayOfByte, 0, this.pageSize);
/*  267 */     this.readCount++;
/*  268 */     paramOutputStream.write(arrayOfByte, 0, this.pageSize);
/*  269 */     return paramInt + 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void open() {
/*      */     try {
/*  277 */       this.metaRootPageId.put(-1, 4);
/*  278 */       if (FileUtils.exists(this.fileName)) {
/*  279 */         long l = FileUtils.size(this.fileName);
/*  280 */         if (l < 320L) {
/*  281 */           if (this.database.isReadOnly()) {
/*  282 */             throw DbException.get(90030, this.fileName + " length: " + l);
/*      */           }
/*      */ 
/*      */           
/*  286 */           openNew();
/*      */         } else {
/*  288 */           openExisting();
/*      */         } 
/*      */       } else {
/*  291 */         openNew();
/*      */       } 
/*  293 */     } catch (DbException dbException) {
/*  294 */       close();
/*  295 */       throw dbException;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void openNew() {
/*  300 */     setPageSize(this.pageSize);
/*  301 */     this.freeListPagesPerList = PageFreeList.getPagesAddressed(this.pageSize);
/*  302 */     this.file = this.database.openFile(this.fileName, this.accessMode, false);
/*  303 */     lockFile();
/*  304 */     this.recoveryRunning = true;
/*  305 */     writeStaticHeader();
/*  306 */     writeVariableHeader();
/*  307 */     this.log = new PageLog(this);
/*  308 */     increaseFileSize(5);
/*  309 */     openMetaIndex();
/*  310 */     this.logFirstTrunkPage = allocatePage();
/*  311 */     this.log.openForWriting(this.logFirstTrunkPage, false);
/*  312 */     this.isNew = true;
/*  313 */     this.recoveryRunning = false;
/*  314 */     increaseFileSize();
/*      */   }
/*      */   
/*      */   private void lockFile() {
/*  318 */     if (this.lockFile && 
/*  319 */       !this.file.tryLock()) {
/*  320 */       throw DbException.get(90020, this.fileName);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void openExisting() {
/*      */     try {
/*  328 */       this.file = this.database.openFile(this.fileName, this.accessMode, true);
/*  329 */     } catch (DbException dbException) {
/*  330 */       if (dbException.getErrorCode() == 90031 && 
/*  331 */         dbException.getMessage().contains("locked"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  337 */         throw DbException.get(90020, dbException, new String[] { this.fileName });
/*      */       }
/*      */ 
/*      */       
/*  341 */       throw dbException;
/*      */     } 
/*  343 */     lockFile();
/*  344 */     readStaticHeader();
/*  345 */     this.freeListPagesPerList = PageFreeList.getPagesAddressed(this.pageSize);
/*  346 */     this.fileLength = this.file.length();
/*  347 */     this.pageCount = (int)(this.fileLength / this.pageSize);
/*  348 */     if (this.pageCount < 5) {
/*  349 */       if (this.database.isReadOnly()) {
/*  350 */         throw DbException.get(90030, this.fileName + " pageCount: " + this.pageCount);
/*      */       }
/*      */       
/*  353 */       this.file.releaseLock();
/*  354 */       this.file.close();
/*  355 */       FileUtils.delete(this.fileName);
/*  356 */       openNew();
/*      */       return;
/*      */     } 
/*  359 */     readVariableHeader();
/*  360 */     this.log = new PageLog(this);
/*  361 */     this.log.openForReading(this.logKey, this.logFirstTrunkPage, this.logFirstDataPage);
/*  362 */     boolean bool1 = this.database.isMultiVersion();
/*      */ 
/*      */ 
/*      */     
/*  366 */     this.database.setMultiVersion(false);
/*  367 */     boolean bool2 = recover();
/*  368 */     this.database.setMultiVersion(bool1);
/*  369 */     if (!this.database.isReadOnly()) {
/*  370 */       this.readMode = true;
/*  371 */       if (!bool2 || !SysProperties.MODIFY_ON_WRITE || this.tempObjects != null) {
/*  372 */         openForWriting();
/*  373 */         removeOldTempIndexes();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void openForWriting() {
/*  379 */     if (!this.readMode || this.database.isReadOnly()) {
/*      */       return;
/*      */     }
/*  382 */     this.readMode = false;
/*  383 */     this.recoveryRunning = true;
/*  384 */     this.log.free();
/*  385 */     this.logFirstTrunkPage = allocatePage();
/*  386 */     this.log.openForWriting(this.logFirstTrunkPage, false);
/*  387 */     this.recoveryRunning = false;
/*  388 */     this.freed.set(0, this.pageCount, true);
/*  389 */     checkpoint();
/*      */   }
/*      */   
/*      */   private void removeOldTempIndexes() {
/*  393 */     if (this.tempObjects != null) {
/*  394 */       this.metaObjects.putAll(this.tempObjects);
/*  395 */       for (PageIndex pageIndex : this.tempObjects.values()) {
/*  396 */         if (pageIndex.getTable().isTemporary()) {
/*  397 */           pageIndex.truncate(this.pageStoreSession);
/*  398 */           pageIndex.remove(this.pageStoreSession);
/*      */         } 
/*      */       } 
/*  401 */       this.pageStoreSession.commit(true);
/*  402 */       this.tempObjects = null;
/*      */     } 
/*  404 */     this.metaObjects.clear();
/*  405 */     this.metaObjects.put(Integer.valueOf(-1), this.metaIndex);
/*      */   }
/*      */   
/*      */   private void writeIndexRowCounts() {
/*  409 */     for (PageIndex pageIndex : this.metaObjects.values()) {
/*  410 */       pageIndex.writeRowCount();
/*      */     }
/*      */   }
/*      */   
/*      */   private void writeBack() {
/*  415 */     ArrayList<Comparable> arrayList = this.cache.getAllChanged();
/*  416 */     Collections.sort(arrayList); byte b; int i;
/*  417 */     for (b = 0, i = arrayList.size(); b < i; b++) {
/*  418 */       writeBack((CacheObject)arrayList.get(b));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void checkpoint() {
/*  426 */     this.trace.debug("checkpoint");
/*  427 */     if (this.log == null || this.readMode || this.database.isReadOnly() || this.backupLevel > 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  432 */     this.database.checkPowerOff();
/*  433 */     writeIndexRowCounts();
/*      */     
/*  435 */     this.log.checkpoint();
/*  436 */     writeBack();
/*      */     
/*  438 */     int i = getFirstUncommittedSection();
/*      */     
/*  440 */     this.log.removeUntil(i);
/*      */ 
/*      */     
/*  443 */     writeBack();
/*      */ 
/*      */     
/*  446 */     this.log.checkpoint();
/*      */     
/*  448 */     if (this.trace.isDebugEnabled()) {
/*  449 */       this.trace.debug("writeFree");
/*      */     }
/*  451 */     byte[] arrayOfByte1 = new byte[16];
/*  452 */     byte[] arrayOfByte2 = new byte[this.pageSize];
/*  453 */     for (byte b = 3; b < this.pageCount; b++) {
/*  454 */       if (isUsed(b)) {
/*  455 */         this.freed.clear(b);
/*  456 */       } else if (!this.freed.get(b)) {
/*  457 */         if (this.trace.isDebugEnabled()) {
/*  458 */           this.trace.debug("free " + b);
/*      */         }
/*  460 */         this.file.seek(b << this.pageSizeShift);
/*  461 */         this.file.readFully(arrayOfByte1, 0, 16);
/*  462 */         if (arrayOfByte1[0] != 0) {
/*  463 */           this.file.seek(b << this.pageSizeShift);
/*  464 */           this.file.write(arrayOfByte2, 0, this.pageSize);
/*  465 */           this.writeCount++;
/*      */         } 
/*  467 */         this.freed.set(b);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void compact(int paramInt) {
/*  479 */     if (!(this.database.getSettings()).pageStoreTrim) {
/*      */       return;
/*      */     }
/*  482 */     if (SysProperties.MODIFY_ON_WRITE && this.readMode && paramInt == 0) {
/*      */       return;
/*      */     }
/*      */     
/*  486 */     openForWriting();
/*      */     
/*  488 */     int i = -1;
/*  489 */     for (int j = getFreeListId(this.pageCount); j >= 0; j--) {
/*  490 */       i = getFreeList(j).getLastUsed();
/*  491 */       if (i != -1) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  497 */     writeBack();
/*  498 */     this.log.free();
/*  499 */     this.recoveryRunning = true;
/*      */     try {
/*  501 */       this.logFirstTrunkPage = i + 1;
/*  502 */       allocatePage(this.logFirstTrunkPage);
/*  503 */       this.log.openForWriting(this.logFirstTrunkPage, true);
/*      */       
/*  505 */       this.log.checkpoint();
/*      */     } finally {
/*  507 */       this.recoveryRunning = false;
/*      */     } 
/*  509 */     long l1 = System.currentTimeMillis();
/*  510 */     boolean bool1 = (paramInt == 82) ? true : false;
/*      */     
/*  512 */     boolean bool2 = (paramInt == 84) ? true : false;
/*      */ 
/*      */     
/*  515 */     if ((this.database.getSettings()).defragAlways) {
/*  516 */       bool1 = bool2 = true;
/*      */     }
/*      */     
/*  519 */     int k = (this.database.getSettings()).maxCompactTime;
/*  520 */     int m = (this.database.getSettings()).maxCompactCount;
/*      */     
/*  522 */     if (bool1 || bool2) {
/*  523 */       k = Integer.MAX_VALUE;
/*  524 */       m = Integer.MAX_VALUE;
/*      */     } 
/*  526 */     byte b = bool1 ? 1536 : 1;
/*  527 */     int n = 5; int i1, i2;
/*  528 */     for (i1 = i, i2 = 0; i1 > 5 && i2 < m; 
/*  529 */       i1 -= b) {
/*  530 */       for (int i3 = i1 - b + 1; i3 <= i1; i3++) {
/*  531 */         if (i3 > 5 && isUsed(i3)) {
/*  532 */           synchronized (this) {
/*  533 */             n = getFirstFree(n);
/*  534 */             if (n == -1 || n >= i3) {
/*  535 */               i2 = m;
/*      */               break;
/*      */             } 
/*  538 */             if (compact(i3, n)) {
/*  539 */               i2++;
/*  540 */               long l = System.currentTimeMillis();
/*  541 */               if (l > l1 + k) {
/*  542 */                 i2 = m;
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*  550 */     if (bool2) {
/*  551 */       this.log.checkpoint();
/*  552 */       writeBack();
/*  553 */       this.cache.clear();
/*  554 */       ArrayList arrayList = this.database.getAllTablesAndViews(false);
/*  555 */       this.recordedPagesList = New.arrayList();
/*  556 */       this.recordedPagesIndex = new IntIntHashMap();
/*  557 */       this.recordPageReads = true;
/*  558 */       Session session = this.database.getSystemSession();
/*  559 */       for (Table table : arrayList) {
/*  560 */         if (!table.isTemporary() && "TABLE".equals(table.getTableType())) {
/*  561 */           Index index = table.getScanIndex(session);
/*  562 */           Cursor cursor = index.find(session, null, null);
/*  563 */           while (cursor.next()) {
/*  564 */             cursor.get();
/*      */           }
/*  566 */           for (Index index1 : table.getIndexes()) {
/*  567 */             if (index1 != index && index1.canScan()) {
/*  568 */               cursor = index1.find(session, null, null);
/*  569 */               while (cursor.next());
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  576 */       this.recordPageReads = false;
/*  577 */       byte b1 = 4;
/*  578 */       int i3 = 0; byte b2; int i4;
/*  579 */       for (b2 = 0, i4 = this.recordedPagesList.size(); b2 < i4; b2++) {
/*  580 */         this.log.checkpoint();
/*  581 */         writeBack();
/*  582 */         int i5 = ((Integer)this.recordedPagesList.get(b2)).intValue();
/*  583 */         Page page = getPage(i5);
/*  584 */         if (page.canMove()) {
/*      */           Page page1;
/*      */           
/*      */           do {
/*  588 */             page1 = getPage(++b1);
/*  589 */           } while (page1 != null && !page1.canMove());
/*      */ 
/*      */ 
/*      */           
/*  593 */           if (b1 != i5)
/*      */           
/*      */           { 
/*  596 */             i3 = getFirstFree(i3);
/*  597 */             if (i3 == -1) {
/*  598 */               DbException.throwInternalError("no free page for defrag");
/*      */             }
/*  600 */             this.cache.clear();
/*  601 */             swap(i5, b1, i3);
/*  602 */             int i6 = this.recordedPagesIndex.get(b1);
/*  603 */             if (i6 != -1) {
/*  604 */               this.recordedPagesList.set(i6, Integer.valueOf(i5));
/*  605 */               this.recordedPagesIndex.put(i5, i6);
/*      */             } 
/*  607 */             this.recordedPagesList.set(b2, Integer.valueOf(b1));
/*  608 */             this.recordedPagesIndex.put(b1, b2); } 
/*      */         } 
/*  610 */       }  this.recordedPagesList = null;
/*  611 */       this.recordedPagesIndex = null;
/*      */     } 
/*      */     
/*  614 */     checkpoint();
/*  615 */     this.log.checkpoint();
/*  616 */     writeIndexRowCounts();
/*  617 */     this.log.checkpoint();
/*  618 */     writeBack();
/*  619 */     commit(this.pageStoreSession);
/*  620 */     writeBack();
/*  621 */     this.log.checkpoint();
/*      */     
/*  623 */     this.log.free();
/*      */     
/*  625 */     this.recoveryRunning = true;
/*      */     try {
/*  627 */       setLogFirstPage(++this.logKey, 0, 0);
/*      */     } finally {
/*  629 */       this.recoveryRunning = false;
/*      */     } 
/*  631 */     writeBack();
/*  632 */     for (i1 = getFreeListId(this.pageCount); i1 >= 0; i1--) {
/*  633 */       i = getFreeList(i1).getLastUsed();
/*  634 */       if (i != -1) {
/*      */         break;
/*      */       }
/*      */     } 
/*  638 */     i1 = i + 1;
/*  639 */     if (i1 < this.pageCount) {
/*  640 */       this.freed.set(i1, this.pageCount, false);
/*      */     }
/*  642 */     this.pageCount = i1;
/*      */     
/*  644 */     this.freeLists.clear();
/*  645 */     this.trace.debug("pageCount: " + this.pageCount);
/*  646 */     long l2 = this.pageCount << this.pageSizeShift;
/*  647 */     if (this.file.length() != l2) {
/*  648 */       this.file.setLength(l2);
/*  649 */       this.writeCount++;
/*      */     } 
/*      */   }
/*      */   
/*      */   private int getFirstFree(int paramInt) {
/*  654 */     int i = -1;
/*  655 */     for (int j = getFreeListId(paramInt); paramInt < this.pageCount; j++) {
/*  656 */       i = getFreeList(j).getFirstFree(paramInt);
/*  657 */       if (i != -1) {
/*      */         break;
/*      */       }
/*      */     } 
/*  661 */     return i;
/*      */   }
/*      */   
/*      */   private void swap(int paramInt1, int paramInt2, int paramInt3) {
/*  665 */     if (paramInt1 < 5 || paramInt2 < 5) {
/*  666 */       System.out.println(isUsed(paramInt1) + " " + isUsed(paramInt2));
/*  667 */       DbException.throwInternalError("can't swap " + paramInt1 + " and " + paramInt2);
/*      */     } 
/*  669 */     Page page1 = (Page)this.cache.get(paramInt3);
/*  670 */     if (page1 != null) {
/*  671 */       DbException.throwInternalError("not free: " + page1);
/*      */     }
/*  673 */     if (this.trace.isDebugEnabled()) {
/*  674 */       this.trace.debug("swap " + paramInt1 + " and " + paramInt2 + " via " + paramInt3);
/*      */     }
/*  676 */     Page page2 = null;
/*  677 */     if (isUsed(paramInt1)) {
/*  678 */       page2 = getPage(paramInt1);
/*  679 */       if (page2 != null) {
/*  680 */         page2.moveTo(this.pageStoreSession, paramInt3);
/*      */       }
/*  682 */       free(paramInt1);
/*      */     } 
/*  684 */     if (paramInt3 != paramInt2) {
/*  685 */       if (isUsed(paramInt2)) {
/*  686 */         Page page = getPage(paramInt2);
/*  687 */         if (page != null) {
/*  688 */           page.moveTo(this.pageStoreSession, paramInt1);
/*      */         }
/*  690 */         free(paramInt2);
/*      */       } 
/*  692 */       if (page2 != null) {
/*  693 */         page1 = getPage(paramInt3);
/*  694 */         if (page1 != null) {
/*  695 */           page1.moveTo(this.pageStoreSession, paramInt2);
/*      */         }
/*  697 */         free(paramInt3);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean compact(int paramInt1, int paramInt2) {
/*  703 */     if (paramInt1 < 5 || paramInt2 == -1 || paramInt2 >= paramInt1 || !isUsed(paramInt1)) {
/*  704 */       return false;
/*      */     }
/*  706 */     Page page1 = (Page)this.cache.get(paramInt2);
/*  707 */     if (page1 != null) {
/*  708 */       DbException.throwInternalError("not free: " + page1);
/*      */     }
/*  710 */     Page page2 = getPage(paramInt1);
/*  711 */     if (page2 == null) {
/*  712 */       freePage(paramInt1);
/*  713 */     } else if (page2 instanceof PageStreamData || page2 instanceof PageStreamTrunk) {
/*  714 */       if (page2.getPos() < this.log.getMinPageId())
/*      */       {
/*      */         
/*  717 */         freePage(paramInt1);
/*      */       }
/*      */     } else {
/*  720 */       if (this.trace.isDebugEnabled()) {
/*  721 */         this.trace.debug("move " + page2.getPos() + " to " + paramInt2);
/*      */       }
/*      */       try {
/*  724 */         page2.moveTo(this.pageStoreSession, paramInt2);
/*      */       } finally {
/*  726 */         this.changeCount++;
/*  727 */         if (SysProperties.CHECK && this.changeCount < 0L) {
/*  728 */           throw DbException.throwInternalError("changeCount has wrapped");
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  733 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized Page getPage(int paramInt) {
/*      */     int i;
/*      */     PageIndex pageIndex;
/*      */     PageDataIndex pageDataIndex;
/*      */     PageBtreeIndex pageBtreeIndex;
/*  743 */     Page page = (Page)this.cache.get(paramInt);
/*  744 */     if (page != null) {
/*  745 */       return page;
/*      */     }
/*      */     
/*  748 */     Data data = createData();
/*  749 */     readPage(paramInt, data);
/*  750 */     byte b = data.readByte();
/*  751 */     if (b == 0) {
/*  752 */       return null;
/*      */     }
/*  754 */     data.readShortInt();
/*  755 */     data.readInt();
/*  756 */     if (!checksumTest(data.getBytes(), paramInt, this.pageSize)) {
/*  757 */       throw DbException.get(90030, "wrong checksum");
/*      */     }
/*      */     
/*  760 */     switch (b & 0xFFFFFFEF) {
/*      */       case 6:
/*  762 */         page = PageFreeList.read(this, data, paramInt);
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
/*  857 */         this.cache.put(page);
/*  858 */         return page;case 1: i = data.readVarInt(); pageIndex = this.metaObjects.get(Integer.valueOf(i)); if (pageIndex == null) throw DbException.get(90030, "index not found " + i);  if (!(pageIndex instanceof PageDataIndex)) throw DbException.get(90030, "not a data index " + i + " " + pageIndex);  pageDataIndex = (PageDataIndex)pageIndex; if (this.statistics != null) statisticsIncrement(pageDataIndex.getTable().getName() + "." + pageDataIndex.getName() + " read");  page = PageDataLeaf.read(pageDataIndex, data, paramInt); this.cache.put(page); return page;case 2: i = data.readVarInt(); pageIndex = this.metaObjects.get(Integer.valueOf(i)); if (pageIndex == null) throw DbException.get(90030, "index not found " + i);  if (!(pageIndex instanceof PageDataIndex)) throw DbException.get(90030, "not a data index " + i + " " + pageIndex);  pageDataIndex = (PageDataIndex)pageIndex; if (this.statistics != null) statisticsIncrement(pageDataIndex.getTable().getName() + "." + pageDataIndex.getName() + " read");  page = PageDataNode.read(pageDataIndex, data, paramInt); this.cache.put(page); return page;case 3: page = PageDataOverflow.read(this, data, paramInt); if (this.statistics != null) statisticsIncrement("overflow read");  this.cache.put(page); return page;case 4: i = data.readVarInt(); pageIndex = this.metaObjects.get(Integer.valueOf(i)); if (pageIndex == null) throw DbException.get(90030, "index not found " + i);  if (!(pageIndex instanceof PageBtreeIndex)) throw DbException.get(90030, "not a btree index " + i + " " + pageIndex);  pageBtreeIndex = (PageBtreeIndex)pageIndex; if (this.statistics != null) statisticsIncrement(pageBtreeIndex.getTable().getName() + "." + pageBtreeIndex.getName() + " read");  page = PageBtreeLeaf.read(pageBtreeIndex, data, paramInt); this.cache.put(page); return page;case 5: i = data.readVarInt(); pageIndex = this.metaObjects.get(Integer.valueOf(i)); if (pageIndex == null) throw DbException.get(90030, "index not found " + i);  if (!(pageIndex instanceof PageBtreeIndex)) throw DbException.get(90030, "not a btree index " + i + " " + pageIndex);  pageBtreeIndex = (PageBtreeIndex)pageIndex; if (this.statistics != null) statisticsIncrement(pageBtreeIndex.getTable().getName() + "." + pageBtreeIndex.getName() + " read");  page = PageBtreeNode.read(pageBtreeIndex, data, paramInt); this.cache.put(page); return page;case 7: page = PageStreamTrunk.read(this, data, paramInt); this.cache.put(page); return page;case 8: page = PageStreamData.read(this, data, paramInt); this.cache.put(page); return page;
/*      */     } 
/*      */     throw DbException.get(90030, "page=" + paramInt + " type=" + b);
/*      */   } private int getFirstUncommittedSection() {
/*  862 */     this.trace.debug("getFirstUncommittedSection");
/*  863 */     Session[] arrayOfSession = this.database.getSessions(true);
/*  864 */     int i = this.log.getLogSectionId();
/*  865 */     for (Session session : arrayOfSession) {
/*  866 */       int j = session.getFirstUncommittedLog();
/*  867 */       if (j != -1 && 
/*  868 */         j < i) {
/*  869 */         i = j;
/*      */       }
/*      */     } 
/*      */     
/*  873 */     return i;
/*      */   }
/*      */   
/*      */   private void readStaticHeader() {
/*  877 */     this.file.seek(48L);
/*  878 */     Data data = Data.create((DataHandler)this.database, new byte[16]);
/*      */     
/*  880 */     this.file.readFully(data.getBytes(), 0, 16);
/*      */     
/*  882 */     this.readCount++;
/*  883 */     setPageSize(data.readInt());
/*  884 */     byte b1 = data.readByte();
/*  885 */     byte b2 = data.readByte();
/*  886 */     if (b2 > 3) {
/*  887 */       throw DbException.get(90048, this.fileName);
/*      */     }
/*      */     
/*  890 */     if (b1 > 3) {
/*  891 */       close();
/*  892 */       this.database.setReadOnly(true);
/*  893 */       this.accessMode = "r";
/*  894 */       this.file = this.database.openFile(this.fileName, this.accessMode, true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void readVariableHeader() {
/*  899 */     Data data = createData();
/*  900 */     for (byte b = 1;; b++) {
/*  901 */       if (b == 3) {
/*  902 */         throw DbException.get(90030, this.fileName);
/*      */       }
/*      */       
/*  905 */       data.reset();
/*  906 */       readPage(b, data);
/*  907 */       CRC32 cRC32 = new CRC32();
/*  908 */       cRC32.update(data.getBytes(), 4, this.pageSize - 4);
/*  909 */       int i = (int)cRC32.getValue();
/*  910 */       int j = data.readInt();
/*  911 */       if (i == j) {
/*  912 */         this.writeCountBase = data.readLong();
/*  913 */         this.logKey = data.readInt();
/*  914 */         this.logFirstTrunkPage = data.readInt();
/*  915 */         this.logFirstDataPage = data.readInt();
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPageSize(int paramInt) {
/*  928 */     if (paramInt < 64 || paramInt > 32768) {
/*  929 */       throw DbException.get(90030, this.fileName + " pageSize: " + paramInt);
/*      */     }
/*      */     
/*  932 */     boolean bool = false;
/*  933 */     byte b = 0; int i;
/*  934 */     for (i = 1; i <= paramInt; ) {
/*  935 */       if (paramInt == i) {
/*  936 */         bool = true;
/*      */         break;
/*      */       } 
/*  939 */       b++;
/*  940 */       i += i;
/*      */     } 
/*  942 */     if (!bool) {
/*  943 */       throw DbException.get(90030, this.fileName);
/*      */     }
/*  945 */     this.pageSize = paramInt;
/*  946 */     this.emptyPage = createData();
/*  947 */     this.pageSizeShift = b;
/*      */   }
/*      */   
/*      */   private void writeStaticHeader() {
/*  951 */     Data data = Data.create((DataHandler)this.database, new byte[this.pageSize - 48]);
/*  952 */     data.writeInt(this.pageSize);
/*  953 */     data.writeByte((byte)3);
/*  954 */     data.writeByte((byte)3);
/*  955 */     this.file.seek(48L);
/*  956 */     this.file.write(data.getBytes(), 0, this.pageSize - 48);
/*  957 */     this.writeCount++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setLogFirstPage(int paramInt1, int paramInt2, int paramInt3) {
/*  968 */     if (this.trace.isDebugEnabled()) {
/*  969 */       this.trace.debug("setLogFirstPage key: " + paramInt1 + " trunk: " + paramInt2 + " data: " + paramInt3);
/*      */     }
/*      */     
/*  972 */     this.logKey = paramInt1;
/*  973 */     this.logFirstTrunkPage = paramInt2;
/*  974 */     this.logFirstDataPage = paramInt3;
/*  975 */     writeVariableHeader();
/*      */   }
/*      */   
/*      */   private void writeVariableHeader() {
/*  979 */     this.trace.debug("writeVariableHeader");
/*  980 */     if (this.logMode == 2) {
/*  981 */       this.file.sync();
/*      */     }
/*  983 */     Data data = createData();
/*  984 */     data.writeInt(0);
/*  985 */     data.writeLong(getWriteCountTotal());
/*  986 */     data.writeInt(this.logKey);
/*  987 */     data.writeInt(this.logFirstTrunkPage);
/*  988 */     data.writeInt(this.logFirstDataPage);
/*  989 */     CRC32 cRC32 = new CRC32();
/*  990 */     cRC32.update(data.getBytes(), 4, this.pageSize - 4);
/*  991 */     data.setInt(0, (int)cRC32.getValue());
/*  992 */     this.file.seek(this.pageSize);
/*  993 */     this.file.write(data.getBytes(), 0, this.pageSize);
/*  994 */     this.file.seek((this.pageSize + this.pageSize));
/*  995 */     this.file.write(data.getBytes(), 0, this.pageSize);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void close() {
/* 1003 */     this.trace.debug("close");
/* 1004 */     if (this.log != null) {
/* 1005 */       this.log.close();
/* 1006 */       this.log = null;
/*      */     } 
/* 1008 */     if (this.file != null) {
/*      */       try {
/* 1010 */         this.file.releaseLock();
/* 1011 */         this.file.close();
/*      */       } finally {
/* 1013 */         this.file = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public synchronized void flushLog() {
/* 1020 */     if (this.file != null) {
/* 1021 */       this.log.flush();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void sync() {
/* 1029 */     if (this.file != null) {
/* 1030 */       this.log.flush();
/* 1031 */       this.file.sync();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Trace getTrace() {
/* 1037 */     return this.trace;
/*      */   }
/*      */ 
/*      */   
/*      */   public synchronized void writeBack(CacheObject paramCacheObject) {
/* 1042 */     Page page = (Page)paramCacheObject;
/* 1043 */     if (this.trace.isDebugEnabled()) {
/* 1044 */       this.trace.debug("writeBack " + page);
/*      */     }
/* 1046 */     page.write();
/* 1047 */     page.setChanged(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void logUndo(Page paramPage, Data paramData) {
/* 1057 */     if (this.logMode == 0) {
/*      */       return;
/*      */     }
/* 1060 */     checkOpen();
/* 1061 */     this.database.checkWritingAllowed();
/* 1062 */     if (!this.recoveryRunning) {
/* 1063 */       int i = paramPage.getPos();
/* 1064 */       if (!this.log.getUndo(i)) {
/* 1065 */         if (paramData == null) {
/* 1066 */           paramData = readPage(i);
/*      */         }
/* 1068 */         openForWriting();
/* 1069 */         this.log.addUndo(i, paramData);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void update(Page paramPage) {
/* 1080 */     if (this.trace.isDebugEnabled() && 
/* 1081 */       !paramPage.isChanged()) {
/* 1082 */       this.trace.debug("updateRecord " + paramPage.toString());
/*      */     }
/*      */     
/* 1085 */     checkOpen();
/* 1086 */     this.database.checkWritingAllowed();
/* 1087 */     paramPage.setChanged(true);
/* 1088 */     int i = paramPage.getPos();
/* 1089 */     if (SysProperties.CHECK && !this.recoveryRunning)
/*      */     {
/* 1091 */       if (this.logMode != 0) {
/* 1092 */         this.log.addUndo(i, null);
/*      */       }
/*      */     }
/* 1095 */     allocatePage(i);
/* 1096 */     this.cache.update(i, paramPage);
/*      */   }
/*      */   
/*      */   private int getFreeListId(int paramInt) {
/* 1100 */     return (paramInt - 3) / this.freeListPagesPerList;
/*      */   }
/*      */   
/*      */   private PageFreeList getFreeListForPage(int paramInt) {
/* 1104 */     return getFreeList(getFreeListId(paramInt));
/*      */   }
/*      */   
/*      */   private PageFreeList getFreeList(int paramInt) {
/* 1108 */     PageFreeList pageFreeList = null;
/* 1109 */     if (paramInt < this.freeLists.size()) {
/* 1110 */       pageFreeList = this.freeLists.get(paramInt);
/* 1111 */       if (pageFreeList != null) {
/* 1112 */         return pageFreeList;
/*      */       }
/*      */     } 
/* 1115 */     int i = 3 + paramInt * this.freeListPagesPerList;
/* 1116 */     while (i >= this.pageCount) {
/* 1117 */       increaseFileSize();
/*      */     }
/* 1119 */     if (i < this.pageCount) {
/* 1120 */       pageFreeList = (PageFreeList)getPage(i);
/*      */     }
/* 1122 */     if (pageFreeList == null) {
/* 1123 */       pageFreeList = PageFreeList.create(this, i);
/* 1124 */       this.cache.put(pageFreeList);
/*      */     } 
/* 1126 */     while (this.freeLists.size() <= paramInt) {
/* 1127 */       this.freeLists.add(null);
/*      */     }
/* 1129 */     this.freeLists.set(paramInt, pageFreeList);
/* 1130 */     return pageFreeList;
/*      */   }
/*      */   
/*      */   private void freePage(int paramInt) {
/* 1134 */     int i = getFreeListId(paramInt);
/* 1135 */     PageFreeList pageFreeList = getFreeList(i);
/* 1136 */     this.firstFreeListIndex = Math.min(i, this.firstFreeListIndex);
/* 1137 */     pageFreeList.free(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void allocatePage(int paramInt) {
/* 1146 */     PageFreeList pageFreeList = getFreeListForPage(paramInt);
/* 1147 */     pageFreeList.allocate(paramInt);
/*      */   }
/*      */   
/*      */   private boolean isUsed(int paramInt) {
/* 1151 */     return getFreeListForPage(paramInt).isUsed(paramInt);
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
/*      */   void allocatePages(IntArray paramIntArray, int paramInt1, BitField paramBitField, int paramInt2) {
/* 1164 */     paramIntArray.ensureCapacity(paramIntArray.size() + paramInt1);
/* 1165 */     for (byte b = 0; b < paramInt1; b++) {
/* 1166 */       int i = allocatePage(paramBitField, paramInt2);
/* 1167 */       paramInt2 = i;
/* 1168 */       paramIntArray.add(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized int allocatePage() {
/* 1178 */     openForWriting();
/* 1179 */     int i = allocatePage(null, 0);
/* 1180 */     if (!this.recoveryRunning && 
/* 1181 */       this.logMode != 0) {
/* 1182 */       this.log.addUndo(i, this.emptyPage);
/*      */     }
/*      */     
/* 1185 */     return i;
/*      */   }
/*      */   
/*      */   private int allocatePage(BitField paramBitField, int paramInt) {
/*      */     int i;
/* 1190 */     for (int j = this.firstFreeListIndex;; j++) {
/* 1191 */       PageFreeList pageFreeList = getFreeList(j);
/* 1192 */       i = pageFreeList.allocate(paramBitField, paramInt);
/* 1193 */       if (i >= 0) {
/* 1194 */         this.firstFreeListIndex = j;
/*      */         break;
/*      */       } 
/*      */     } 
/* 1198 */     while (i >= this.pageCount) {
/* 1199 */       increaseFileSize();
/*      */     }
/* 1201 */     if (this.trace.isDebugEnabled());
/*      */ 
/*      */     
/* 1204 */     return i;
/*      */   }
/*      */   
/*      */   private void increaseFileSize() {
/* 1208 */     int i = 1048576 / this.pageSize;
/* 1209 */     int j = this.pageCount * 35 / 100;
/* 1210 */     if (i < j) {
/* 1211 */       i = (1 + j / i) * i;
/*      */     }
/* 1213 */     int k = (this.database.getSettings()).pageStoreMaxGrowth;
/* 1214 */     if (k < i) {
/* 1215 */       i = k;
/*      */     }
/* 1217 */     increaseFileSize(i);
/*      */   }
/*      */   
/*      */   private void increaseFileSize(int paramInt) {
/* 1221 */     for (int i = this.pageCount; i < this.pageCount + paramInt; i++) {
/* 1222 */       this.freed.set(i);
/*      */     }
/* 1224 */     this.pageCount += paramInt;
/* 1225 */     long l = this.pageCount << this.pageSizeShift;
/* 1226 */     this.file.setLength(l);
/* 1227 */     this.writeCount++;
/* 1228 */     this.fileLength = l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void free(int paramInt) {
/* 1237 */     free(paramInt, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void free(int paramInt, boolean paramBoolean) {
/* 1247 */     if (this.trace.isDebugEnabled());
/*      */ 
/*      */     
/* 1250 */     this.cache.remove(paramInt);
/* 1251 */     if (SysProperties.CHECK && !this.recoveryRunning && paramBoolean)
/*      */     {
/* 1253 */       if (this.logMode != 0) {
/* 1254 */         this.log.addUndo(paramInt, null);
/*      */       }
/*      */     }
/* 1257 */     freePage(paramInt);
/* 1258 */     if (this.recoveryRunning) {
/* 1259 */       writePage(paramInt, createData());
/* 1260 */       if (this.reservedPages != null && this.reservedPages.containsKey(Integer.valueOf(paramInt))) {
/*      */         
/* 1262 */         int i = ((Integer)this.reservedPages.get(Integer.valueOf(paramInt))).intValue();
/* 1263 */         if (i > this.log.getLogPos()) {
/* 1264 */           allocatePage(paramInt);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void freeUnused(int paramInt) {
/* 1277 */     if (this.trace.isDebugEnabled()) {
/* 1278 */       this.trace.debug("freeUnused " + paramInt);
/*      */     }
/* 1280 */     this.cache.remove(paramInt);
/* 1281 */     freePage(paramInt);
/* 1282 */     this.freed.set(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Data createData() {
/* 1291 */     return Data.create((DataHandler)this.database, new byte[this.pageSize]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized Data readPage(int paramInt) {
/* 1301 */     Data data = createData();
/* 1302 */     readPage(paramInt, data);
/* 1303 */     return data;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void readPage(int paramInt, Data paramData) {
/* 1313 */     if (this.recordPageReads && 
/* 1314 */       paramInt >= 5 && this.recordedPagesIndex.get(paramInt) == -1) {
/*      */       
/* 1316 */       this.recordedPagesIndex.put(paramInt, this.recordedPagesList.size());
/* 1317 */       this.recordedPagesList.add(Integer.valueOf(paramInt));
/*      */     } 
/*      */     
/* 1320 */     if (paramInt < 0 || paramInt >= this.pageCount) {
/* 1321 */       throw DbException.get(90030, paramInt + " of " + this.pageCount);
/*      */     }
/*      */     
/* 1324 */     this.file.seek(paramInt << this.pageSizeShift);
/* 1325 */     this.file.readFully(paramData.getBytes(), 0, this.pageSize);
/* 1326 */     this.readCount++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPageSize() {
/* 1335 */     return this.pageSize;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getPageCount() {
/* 1344 */     return this.pageCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void writePage(int paramInt, Data paramData) {
/* 1354 */     if (paramInt <= 0) {
/* 1355 */       DbException.throwInternalError("write to page " + paramInt);
/*      */     }
/* 1357 */     byte[] arrayOfByte = paramData.getBytes();
/* 1358 */     if (SysProperties.CHECK) {
/* 1359 */       boolean bool1 = ((paramInt - 3) % this.freeListPagesPerList == 0) ? true : false;
/*      */       
/* 1361 */       boolean bool2 = (arrayOfByte[0] == 6) ? true : false;
/* 1362 */       if (arrayOfByte[0] != 0 && bool1 != bool2) {
/* 1363 */         throw DbException.throwInternalError();
/*      */       }
/*      */     } 
/* 1366 */     checksumSet(arrayOfByte, paramInt);
/* 1367 */     this.file.seek(paramInt << this.pageSizeShift);
/* 1368 */     this.file.write(arrayOfByte, 0, this.pageSize);
/* 1369 */     this.writeCount++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void removeFromCache(int paramInt) {
/* 1378 */     this.cache.remove(paramInt);
/*      */   }
/*      */   
/*      */   Database getDatabase() {
/* 1382 */     return this.database;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean recover() {
/* 1391 */     this.trace.debug("log recover");
/* 1392 */     this.recoveryRunning = true;
/* 1393 */     boolean bool = true;
/* 1394 */     bool &= this.log.recover(0);
/* 1395 */     if (this.reservedPages != null) {
/* 1396 */       for (Iterator<Integer> iterator = this.reservedPages.keySet().iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 1397 */         if (this.trace.isDebugEnabled()) {
/* 1398 */           this.trace.debug("reserve " + i);
/*      */         }
/* 1400 */         allocatePage(i); }
/*      */     
/*      */     }
/* 1403 */     bool &= this.log.recover(1);
/* 1404 */     openMetaIndex();
/* 1405 */     readMetaData();
/* 1406 */     bool &= this.log.recover(2);
/* 1407 */     boolean bool1 = false;
/* 1408 */     if (!this.database.isReadOnly()) {
/* 1409 */       if (this.log.getInDoubtTransactions().size() == 0) {
/* 1410 */         this.log.recoverEnd();
/* 1411 */         int i = getFirstUncommittedSection();
/* 1412 */         this.log.removeUntil(i);
/*      */       } else {
/* 1414 */         bool1 = true;
/*      */       } 
/*      */     }
/* 1417 */     PageDataIndex pageDataIndex = (PageDataIndex)this.metaObjects.get(Integer.valueOf(0));
/* 1418 */     this.isNew = (pageDataIndex == null);
/* 1419 */     for (PageIndex pageIndex : this.metaObjects.values()) {
/* 1420 */       if (pageIndex.getTable().isTemporary()) {
/*      */         
/* 1422 */         if (this.tempObjects == null) {
/* 1423 */           this.tempObjects = New.hashMap();
/*      */         }
/* 1425 */         this.tempObjects.put(Integer.valueOf(pageIndex.getId()), pageIndex); continue;
/*      */       } 
/* 1427 */       pageIndex.close(this.pageStoreSession);
/*      */     } 
/*      */ 
/*      */     
/* 1431 */     allocatePage(4);
/* 1432 */     writeIndexRowCounts();
/* 1433 */     this.recoveryRunning = false;
/* 1434 */     this.reservedPages = null;
/*      */     
/* 1436 */     writeBack();
/*      */     
/* 1438 */     this.cache.clear();
/* 1439 */     this.freeLists.clear();
/*      */     
/* 1441 */     this.metaObjects.clear();
/* 1442 */     this.metaObjects.put(Integer.valueOf(-1), this.metaIndex);
/*      */     
/* 1444 */     if (bool1) {
/* 1445 */       this.database.setReadOnly(true);
/*      */     }
/* 1447 */     this.trace.debug("log recover done");
/* 1448 */     return bool;
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
/*      */   public synchronized void logAddOrRemoveRow(Session paramSession, int paramInt, Row paramRow, boolean paramBoolean) {
/* 1461 */     if (this.logMode != 0 && 
/* 1462 */       !this.recoveryRunning) {
/* 1463 */       this.log.logAddOrRemoveRow(paramSession, paramInt, paramRow, paramBoolean);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void commit(Session paramSession) {
/* 1474 */     checkOpen();
/* 1475 */     openForWriting();
/* 1476 */     this.log.commit(paramSession.getId());
/* 1477 */     long l = this.log.getSize();
/* 1478 */     if (l - this.logSizeBase > this.maxLogSize / 2L) {
/* 1479 */       int i = this.log.getLogFirstSectionId();
/* 1480 */       checkpoint();
/* 1481 */       int j = this.log.getLogSectionId();
/* 1482 */       if (j - i <= 2) {
/*      */         return;
/*      */       }
/*      */ 
/*      */       
/* 1487 */       long l1 = this.log.getSize();
/* 1488 */       if (l1 < l || l < this.maxLogSize) {
/* 1489 */         this.ignoreBigLog = false;
/*      */         return;
/*      */       } 
/* 1492 */       if (!this.ignoreBigLog) {
/* 1493 */         this.ignoreBigLog = true;
/* 1494 */         this.trace.error(null, "Transaction log could not be truncated; size: " + (l1 / 1024L / 1024L) + " MB");
/*      */       } 
/*      */ 
/*      */       
/* 1498 */       this.logSizeBase = this.log.getSize();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void prepareCommit(Session paramSession, String paramString) {
/* 1509 */     this.log.prepareCommit(paramSession, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNew() {
/* 1518 */     return this.isNew;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void allocateIfIndexRoot(int paramInt1, int paramInt2, Row paramRow) {
/* 1529 */     if (paramInt2 == -1) {
/* 1530 */       int i = paramRow.getValue(3).getInt();
/* 1531 */       if (this.reservedPages == null) {
/* 1532 */         this.reservedPages = New.hashMap();
/*      */       }
/* 1534 */       this.reservedPages.put(Integer.valueOf(i), Integer.valueOf(paramInt1));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void redoDelete(int paramInt, long paramLong) {
/* 1545 */     Index index = (Index)this.metaObjects.get(Integer.valueOf(paramInt));
/* 1546 */     PageDataIndex pageDataIndex = (PageDataIndex)index;
/* 1547 */     Row row = pageDataIndex.getRowWithKey(paramLong);
/* 1548 */     if (row == null || row.getKey() != paramLong) {
/* 1549 */       this.trace.error(null, "Entry not found: " + paramLong + " found instead: " + row + " - ignoring");
/*      */       
/*      */       return;
/*      */     } 
/* 1553 */     redo(paramInt, row, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void redo(int paramInt, Row paramRow, boolean paramBoolean) {
/* 1564 */     if (paramInt == -1) {
/* 1565 */       if (paramBoolean) {
/* 1566 */         addMeta(paramRow, this.pageStoreSession, true);
/*      */       } else {
/* 1568 */         removeMeta(paramRow);
/*      */       } 
/*      */     }
/* 1571 */     Index index = (Index)this.metaObjects.get(Integer.valueOf(paramInt));
/* 1572 */     if (index == null) {
/* 1573 */       throw DbException.throwInternalError("Table not found: " + paramInt + " " + paramRow + " " + paramBoolean);
/*      */     }
/*      */     
/* 1576 */     Table table = index.getTable();
/* 1577 */     if (paramBoolean) {
/* 1578 */       table.addRow(this.pageStoreSession, paramRow);
/*      */     } else {
/* 1580 */       table.removeRow(this.pageStoreSession, paramRow);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void redoTruncate(int paramInt) {
/* 1590 */     Index index = (Index)this.metaObjects.get(Integer.valueOf(paramInt));
/* 1591 */     Table table = index.getTable();
/* 1592 */     table.truncate(this.pageStoreSession);
/*      */   }
/*      */   
/*      */   private void openMetaIndex() {
/* 1596 */     CreateTableData createTableData = new CreateTableData();
/* 1597 */     ArrayList<Column> arrayList = createTableData.columns;
/* 1598 */     arrayList.add(new Column("ID", 4));
/* 1599 */     arrayList.add(new Column("TYPE", 4));
/* 1600 */     arrayList.add(new Column("PARENT", 4));
/* 1601 */     arrayList.add(new Column("HEAD", 4));
/* 1602 */     arrayList.add(new Column("OPTIONS", 13));
/* 1603 */     arrayList.add(new Column("COLUMNS", 13));
/* 1604 */     this.metaSchema = new Schema(this.database, 0, "", null, true);
/* 1605 */     createTableData.schema = this.metaSchema;
/* 1606 */     createTableData.tableName = "PAGE_INDEX";
/* 1607 */     createTableData.id = -1;
/* 1608 */     createTableData.temporary = false;
/* 1609 */     createTableData.persistData = true;
/* 1610 */     createTableData.persistIndexes = true;
/* 1611 */     createTableData.create = false;
/* 1612 */     createTableData.session = this.pageStoreSession;
/* 1613 */     this.metaTable = new RegularTable(createTableData);
/* 1614 */     this.metaIndex = (PageDataIndex)this.metaTable.getScanIndex(this.pageStoreSession);
/*      */     
/* 1616 */     this.metaObjects.clear();
/* 1617 */     this.metaObjects.put(Integer.valueOf(-1), this.metaIndex);
/*      */   }
/*      */   
/*      */   private void readMetaData() {
/* 1621 */     Cursor cursor = this.metaIndex.find(this.pageStoreSession, null, null);
/*      */     
/* 1623 */     while (cursor.next()) {
/* 1624 */       Row row = cursor.get();
/* 1625 */       int i = row.getValue(1).getInt();
/* 1626 */       if (i == 0) {
/* 1627 */         addMeta(row, this.pageStoreSession, false);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1632 */     cursor = this.metaIndex.find(this.pageStoreSession, null, null);
/* 1633 */     while (cursor.next()) {
/* 1634 */       Row row = cursor.get();
/* 1635 */       int i = row.getValue(1).getInt();
/* 1636 */       if (i != 0) {
/* 1637 */         addMeta(row, this.pageStoreSession, false);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void removeMeta(Row paramRow) {
/* 1643 */     int i = paramRow.getValue(0).getInt();
/* 1644 */     PageIndex pageIndex = this.metaObjects.get(Integer.valueOf(i));
/* 1645 */     pageIndex.getTable().removeIndex((Index)pageIndex);
/* 1646 */     if (pageIndex instanceof PageBtreeIndex || pageIndex instanceof org.h2.index.PageDelegateIndex) {
/* 1647 */       if (pageIndex.isTemporary()) {
/* 1648 */         this.pageStoreSession.removeLocalTempTableIndex((Index)pageIndex);
/*      */       } else {
/* 1650 */         pageIndex.getSchema().remove((SchemaObject)pageIndex);
/*      */       } 
/*      */     }
/* 1653 */     pageIndex.remove(this.pageStoreSession);
/* 1654 */     this.metaObjects.remove(Integer.valueOf(i));
/*      */   } private void addMeta(Row paramRow, Session paramSession, boolean paramBoolean) {
/*      */     Index index;
/*      */     PageIndex pageIndex;
/* 1658 */     int i = paramRow.getValue(0).getInt();
/* 1659 */     int j = paramRow.getValue(1).getInt();
/* 1660 */     int k = paramRow.getValue(2).getInt();
/* 1661 */     int m = paramRow.getValue(3).getInt();
/* 1662 */     String[] arrayOfString1 = StringUtils.arraySplit(paramRow.getValue(4).getString(), ',', false);
/*      */     
/* 1664 */     String str = paramRow.getValue(5).getString();
/* 1665 */     String[] arrayOfString2 = StringUtils.arraySplit(str, ',', false);
/*      */     
/* 1667 */     if (this.trace.isDebugEnabled()) {
/* 1668 */       this.trace.debug("addMeta id=" + i + " type=" + j + " root=" + m + " parent=" + k + " columns=" + str);
/*      */     }
/*      */     
/* 1671 */     if (paramBoolean && m != 0) {
/*      */       
/* 1673 */       writePage(m, createData());
/* 1674 */       allocatePage(m);
/*      */     } 
/* 1676 */     this.metaRootPageId.put(i, m);
/* 1677 */     if (j == 0) {
/* 1678 */       CreateTableData createTableData = new CreateTableData();
/* 1679 */       if (SysProperties.CHECK && 
/* 1680 */         arrayOfString2 == null)
/* 1681 */         throw DbException.throwInternalError(paramRow.toString()); 
/*      */       byte b;
/*      */       int n;
/* 1684 */       for (b = 0, n = arrayOfString2.length; b < n; b++) {
/* 1685 */         Column column = new Column("C" + b, 4);
/* 1686 */         createTableData.columns.add(column);
/*      */       } 
/* 1688 */       createTableData.schema = this.metaSchema;
/* 1689 */       createTableData.tableName = "T" + i;
/* 1690 */       createTableData.id = i;
/* 1691 */       createTableData.temporary = arrayOfString1[2].equals("temp");
/* 1692 */       createTableData.persistData = true;
/* 1693 */       createTableData.persistIndexes = true;
/* 1694 */       createTableData.create = false;
/* 1695 */       createTableData.session = paramSession;
/* 1696 */       RegularTable regularTable = new RegularTable(createTableData);
/* 1697 */       boolean bool = SysProperties.SORT_BINARY_UNSIGNED;
/* 1698 */       if (arrayOfString1.length > 3) {
/* 1699 */         bool = Boolean.parseBoolean(arrayOfString1[3]);
/*      */       }
/* 1701 */       CompareMode compareMode = CompareMode.getInstance(arrayOfString1[0], Integer.parseInt(arrayOfString1[1]), bool);
/*      */       
/* 1703 */       regularTable.setCompareMode(compareMode);
/* 1704 */       index = regularTable.getScanIndex(paramSession);
/*      */     } else {
/* 1706 */       IndexType indexType; Index index1 = (Index)this.metaObjects.get(Integer.valueOf(k));
/* 1707 */       if (index1 == null) {
/* 1708 */         throw DbException.get(90030, "Table not found:" + k + " for " + paramRow + " meta:" + this.metaObjects);
/*      */       }
/*      */       
/* 1711 */       RegularTable regularTable = (RegularTable)index1.getTable();
/* 1712 */       Column[] arrayOfColumn = regularTable.getColumns();
/* 1713 */       int n = arrayOfString2.length;
/* 1714 */       IndexColumn[] arrayOfIndexColumn = new IndexColumn[n];
/* 1715 */       for (byte b = 0; b < n; b++) {
/* 1716 */         String str1 = arrayOfString2[b];
/* 1717 */         IndexColumn indexColumn = new IndexColumn();
/* 1718 */         int i1 = str1.indexOf('/');
/* 1719 */         if (i1 >= 0) {
/* 1720 */           String str2 = str1.substring(i1 + 1);
/* 1721 */           indexColumn.sortType = Integer.parseInt(str2);
/* 1722 */           str1 = str1.substring(0, i1);
/*      */         } 
/* 1724 */         Column column = arrayOfColumn[Integer.parseInt(str1)];
/* 1725 */         indexColumn.column = column;
/* 1726 */         arrayOfIndexColumn[b] = indexColumn;
/*      */       } 
/*      */       
/* 1729 */       if (arrayOfString1[3].equals("d")) {
/* 1730 */         indexType = IndexType.createPrimaryKey(true, false);
/* 1731 */         Column[] arrayOfColumn1 = regularTable.getColumns();
/* 1732 */         for (IndexColumn indexColumn : arrayOfIndexColumn) {
/* 1733 */           arrayOfColumn1[indexColumn.column.getColumnId()].setNullable(false);
/*      */         }
/*      */       } else {
/* 1736 */         indexType = IndexType.createNonUnique(true);
/*      */       } 
/* 1738 */       index = regularTable.addIndex(paramSession, "I" + i, i, arrayOfIndexColumn, indexType, false, null);
/*      */     } 
/*      */     
/* 1741 */     if (index instanceof MultiVersionIndex) {
/* 1742 */       pageIndex = (PageIndex)((MultiVersionIndex)index).getBaseIndex();
/*      */     } else {
/* 1744 */       pageIndex = (PageIndex)index;
/*      */     } 
/* 1746 */     this.metaObjects.put(Integer.valueOf(i), pageIndex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void addIndex(PageIndex paramPageIndex) {
/* 1755 */     this.metaObjects.put(Integer.valueOf(paramPageIndex.getId()), paramPageIndex);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addMeta(PageIndex paramPageIndex, Session paramSession) {
/* 1765 */     Table table = paramPageIndex.getTable();
/* 1766 */     if (SysProperties.CHECK && 
/* 1767 */       !table.isTemporary())
/*      */     {
/*      */       
/* 1770 */       synchronized (this.database) {
/* 1771 */         synchronized (this) {
/* 1772 */           this.database.verifyMetaLocked(paramSession);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1777 */     synchronized (this) {
/* 1778 */       boolean bool = (paramPageIndex instanceof PageDataIndex) ? false : true;
/*      */       
/* 1780 */       IndexColumn[] arrayOfIndexColumn = paramPageIndex.getIndexColumns();
/* 1781 */       StatementBuilder statementBuilder = new StatementBuilder();
/* 1782 */       for (IndexColumn indexColumn : arrayOfIndexColumn) {
/* 1783 */         statementBuilder.appendExceptFirst(",");
/* 1784 */         int i = indexColumn.column.getColumnId();
/* 1785 */         statementBuilder.append(i);
/* 1786 */         int j = indexColumn.sortType;
/* 1787 */         if (j != 0) {
/* 1788 */           statementBuilder.append('/');
/* 1789 */           statementBuilder.append(j);
/*      */         } 
/*      */       } 
/* 1792 */       String str1 = statementBuilder.toString();
/* 1793 */       CompareMode compareMode = table.getCompareMode();
/* 1794 */       String str2 = compareMode.getName() + "," + compareMode.getStrength() + ",";
/* 1795 */       if (table.isTemporary()) {
/* 1796 */         str2 = str2 + "temp";
/*      */       }
/* 1798 */       str2 = str2 + ",";
/* 1799 */       if (paramPageIndex instanceof org.h2.index.PageDelegateIndex) {
/* 1800 */         str2 = str2 + "d";
/*      */       }
/* 1802 */       str2 = str2 + "," + compareMode.isBinaryUnsigned();
/* 1803 */       Row row = this.metaTable.getTemplateRow();
/* 1804 */       row.setValue(0, (Value)ValueInt.get(paramPageIndex.getId()));
/* 1805 */       row.setValue(1, (Value)ValueInt.get(bool));
/* 1806 */       row.setValue(2, (Value)ValueInt.get(table.getId()));
/* 1807 */       row.setValue(3, (Value)ValueInt.get(paramPageIndex.getRootPageId()));
/* 1808 */       row.setValue(4, ValueString.get(str2));
/* 1809 */       row.setValue(5, ValueString.get(str1));
/* 1810 */       row.setKey((paramPageIndex.getId() + 1));
/* 1811 */       this.metaIndex.add(paramSession, row);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeMeta(Index paramIndex, Session paramSession) {
/* 1822 */     if (SysProperties.CHECK && 
/* 1823 */       !paramIndex.getTable().isTemporary())
/*      */     {
/*      */       
/* 1826 */       synchronized (this.database) {
/* 1827 */         synchronized (this) {
/* 1828 */           this.database.verifyMetaLocked(paramSession);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1833 */     synchronized (this) {
/* 1834 */       if (!this.recoveryRunning) {
/* 1835 */         removeMetaIndex(paramIndex, paramSession);
/* 1836 */         this.metaObjects.remove(Integer.valueOf(paramIndex.getId()));
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void removeMetaIndex(Index paramIndex, Session paramSession) {
/* 1842 */     int i = paramIndex.getId() + 1;
/* 1843 */     Row row = this.metaIndex.getRow(paramSession, i);
/* 1844 */     if (row.getKey() != i) {
/* 1845 */       throw DbException.get(90030, "key: " + i + " index: " + paramIndex + " table: " + paramIndex.getTable() + " row: " + row);
/*      */     }
/*      */ 
/*      */     
/* 1849 */     this.metaIndex.remove(paramSession, row);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxLogSize(long paramLong) {
/* 1858 */     this.maxLogSize = paramLong;
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
/*      */   public synchronized void setInDoubtTransactionState(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 1871 */     boolean bool = this.database.isReadOnly();
/*      */     try {
/* 1873 */       this.database.setReadOnly(false);
/* 1874 */       this.log.setInDoubtTransactionState(paramInt1, paramInt2, paramBoolean);
/*      */     } finally {
/* 1876 */       this.database.setReadOnly(bool);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ArrayList<InDoubtTransaction> getInDoubtTransactions() {
/* 1886 */     return this.log.getInDoubtTransactions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isRecoveryRunning() {
/* 1895 */     return this.recoveryRunning;
/*      */   }
/*      */   
/*      */   private void checkOpen() {
/* 1899 */     if (this.file == null) {
/* 1900 */       throw DbException.get(90098);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWriteCountTotal() {
/* 1910 */     return this.writeCount + this.writeCountBase;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getWriteCount() {
/* 1919 */     return this.writeCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getReadCount() {
/* 1928 */     return this.readCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void logTruncate(Session paramSession, int paramInt) {
/* 1938 */     if (!this.recoveryRunning) {
/* 1939 */       openForWriting();
/* 1940 */       this.log.logTruncate(paramSession, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRootPageId(int paramInt) {
/* 1951 */     return this.metaRootPageId.get(paramInt);
/*      */   }
/*      */   
/*      */   public Cache getCache() {
/* 1955 */     return this.cache;
/*      */   }
/*      */   
/*      */   private void checksumSet(byte[] paramArrayOfbyte, int paramInt) {
/* 1959 */     int i = this.pageSize;
/* 1960 */     byte b = paramArrayOfbyte[0];
/* 1961 */     if (b == 0) {
/*      */       return;
/*      */     }
/* 1964 */     int j = 255 + (b & 0xFF), k = 255 + j;
/* 1965 */     k += j += paramArrayOfbyte[6] & 0xFF;
/* 1966 */     k += j += paramArrayOfbyte[(i >> 1) - 1] & 0xFF;
/* 1967 */     k += j += paramArrayOfbyte[i >> 1] & 0xFF;
/* 1968 */     k += j += paramArrayOfbyte[i - 2] & 0xFF;
/* 1969 */     k += j += paramArrayOfbyte[i - 1] & 0xFF;
/* 1970 */     paramArrayOfbyte[1] = (byte)((j & 0xFF) + (j >> 8) ^ paramInt);
/* 1971 */     paramArrayOfbyte[2] = (byte)((k & 0xFF) + (k >> 8) ^ paramInt >> 8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean checksumTest(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 1982 */     int i = paramInt2;
/* 1983 */     int j = 255 + (paramArrayOfbyte[0] & 0xFF), k = 255 + j;
/* 1984 */     k += j += paramArrayOfbyte[6] & 0xFF;
/* 1985 */     k += j += paramArrayOfbyte[(i >> 1) - 1] & 0xFF;
/* 1986 */     k += j += paramArrayOfbyte[i >> 1] & 0xFF;
/* 1987 */     k += j += paramArrayOfbyte[i - 2] & 0xFF;
/* 1988 */     k += j += paramArrayOfbyte[i - 1] & 0xFF;
/* 1989 */     if (paramArrayOfbyte[1] != (byte)((j & 0xFF) + (j >> 8) ^ paramInt1) || paramArrayOfbyte[2] != (byte)((k & 0xFF) + (k >> 8) ^ paramInt1 >> 8))
/*      */     {
/* 1991 */       return false;
/*      */     }
/* 1993 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void incrementChangeCount() {
/* 2000 */     this.changeCount++;
/* 2001 */     if (SysProperties.CHECK && this.changeCount < 0L) {
/* 2002 */       throw DbException.throwInternalError("changeCount has wrapped");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getChangeCount() {
/* 2012 */     return this.changeCount;
/*      */   }
/*      */   
/*      */   public void setLogMode(int paramInt) {
/* 2016 */     this.logMode = paramInt;
/*      */   }
/*      */   
/*      */   public int getLogMode() {
/* 2020 */     return this.logMode;
/*      */   }
/*      */   
/*      */   public void setLockFile(boolean paramBoolean) {
/* 2024 */     this.lockFile = paramBoolean;
/*      */   }
/*      */   
/*      */   public BitField getObjectIds() {
/* 2028 */     BitField bitField = new BitField();
/* 2029 */     Cursor cursor = this.metaIndex.find(this.pageStoreSession, null, null);
/* 2030 */     while (cursor.next()) {
/* 2031 */       Row row = cursor.get();
/* 2032 */       int i = row.getValue(0).getInt();
/* 2033 */       if (i > 0) {
/* 2034 */         bitField.set(i);
/*      */       }
/*      */     } 
/* 2037 */     return bitField;
/*      */   }
/*      */   
/*      */   public Session getPageStoreSession() {
/* 2041 */     return this.pageStoreSession;
/*      */   }
/*      */   
/*      */   public synchronized void setBackup(boolean paramBoolean) {
/* 2045 */     this.backupLevel += paramBoolean ? 1 : -1;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\PageStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */