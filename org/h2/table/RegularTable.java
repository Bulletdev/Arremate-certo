/*     */ package org.h2.table;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.h2.command.ddl.Analyze;
/*     */ import org.h2.command.ddl.CreateTableData;
/*     */ import org.h2.constraint.Constraint;
/*     */ import org.h2.constraint.ConstraintReferential;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.HashIndex;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.index.MultiVersionIndex;
/*     */ import org.h2.index.NonUniqueHashIndex;
/*     */ import org.h2.index.PageBtreeIndex;
/*     */ import org.h2.index.PageDataIndex;
/*     */ import org.h2.index.PageDelegateIndex;
/*     */ import org.h2.index.ScanIndex;
/*     */ import org.h2.index.SpatialTreeIndex;
/*     */ import org.h2.index.TreeIndex;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.CompareMode;
/*     */ import org.h2.value.DataType;
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
/*     */ public class RegularTable
/*     */   extends TableBase
/*     */ {
/*     */   private Index scanIndex;
/*     */   private long rowCount;
/*     */   private volatile Session lockExclusiveSession;
/*  57 */   private HashSet<Session> lockSharedSessions = New.hashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private final ArrayDeque<Session> waitingSessions = new ArrayDeque<>();
/*     */   private final Trace traceLock;
/*  65 */   private final ArrayList<Index> indexes = New.arrayList();
/*     */   private long lastModificationId;
/*     */   private boolean containsLargeObject;
/*     */   private final PageDataIndex mainIndex;
/*     */   private int changesSinceAnalyze;
/*     */   private int nextAnalyze;
/*     */   private Column rowIdColumn;
/*     */   
/*     */   public RegularTable(CreateTableData paramCreateTableData) {
/*  74 */     super(paramCreateTableData);
/*  75 */     this.nextAnalyze = (this.database.getSettings()).analyzeAuto;
/*  76 */     this.isHidden = paramCreateTableData.isHidden;
/*  77 */     for (Column column : getColumns()) {
/*  78 */       if (DataType.isLargeObject(column.getType())) {
/*  79 */         this.containsLargeObject = true;
/*     */       }
/*     */     } 
/*  82 */     if (paramCreateTableData.persistData && this.database.isPersistent()) {
/*  83 */       this.mainIndex = new PageDataIndex(this, paramCreateTableData.id, IndexColumn.wrap(getColumns()), IndexType.createScan(paramCreateTableData.persistData), paramCreateTableData.create, paramCreateTableData.session);
/*     */ 
/*     */ 
/*     */       
/*  87 */       this.scanIndex = (Index)this.mainIndex;
/*     */     } else {
/*  89 */       this.mainIndex = null;
/*  90 */       this.scanIndex = (Index)new ScanIndex(this, paramCreateTableData.id, IndexColumn.wrap(getColumns()), IndexType.createScan(paramCreateTableData.persistData));
/*     */     } 
/*     */     
/*  93 */     this.indexes.add(this.scanIndex);
/*  94 */     this.traceLock = this.database.getTrace(7);
/*     */   }
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {
/*  99 */     for (Index index : this.indexes) {
/* 100 */       index.close(paramSession);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Row getRow(Session paramSession, long paramLong) {
/* 106 */     return this.scanIndex.getRow(paramSession, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRow(Session paramSession, Row paramRow) {
/* 111 */     this.lastModificationId = this.database.getNextModificationDataId();
/* 112 */     if (this.database.isMultiVersion()) {
/* 113 */       paramRow.setSessionId(paramSession.getId());
/*     */     }
/* 115 */     byte b = 0;
/*     */     try {
/* 117 */       for (int i = this.indexes.size(); b < i; b++) {
/* 118 */         Index index = this.indexes.get(b);
/* 119 */         index.add(paramSession, paramRow);
/* 120 */         checkRowCount(paramSession, index, 1);
/*     */       } 
/* 122 */       this.rowCount++;
/* 123 */     } catch (Throwable throwable) {
/*     */       try {
/* 125 */         while (--b >= 0) {
/* 126 */           Index index = this.indexes.get(b);
/* 127 */           index.remove(paramSession, paramRow);
/* 128 */           checkRowCount(paramSession, index, 0);
/*     */         } 
/* 130 */       } catch (DbException dbException1) {
/*     */ 
/*     */ 
/*     */         
/* 134 */         this.trace.error((Throwable)dbException1, "could not undo operation");
/* 135 */         throw dbException1;
/*     */       } 
/* 137 */       DbException dbException = DbException.convert(throwable);
/* 138 */       if (dbException.getErrorCode() == 23505) {
/* 139 */         for (byte b1 = 0; b1 < this.indexes.size(); b1++) {
/* 140 */           Index index = this.indexes.get(b1);
/* 141 */           if (index.getIndexType().isUnique() && index instanceof MultiVersionIndex) {
/* 142 */             MultiVersionIndex multiVersionIndex = (MultiVersionIndex)index;
/* 143 */             if (multiVersionIndex.isUncommittedFromOtherSession(paramSession, paramRow)) {
/* 144 */               throw DbException.get(90131, index.getName());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 150 */       throw dbException;
/*     */     } 
/* 152 */     analyzeIfRequired(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void commit(short paramShort, Row paramRow) {
/* 157 */     this.lastModificationId = this.database.getNextModificationDataId(); byte b; int i;
/* 158 */     for (b = 0, i = this.indexes.size(); b < i; b++) {
/* 159 */       Index index = this.indexes.get(b);
/* 160 */       index.commit(paramShort, paramRow);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkRowCount(Session paramSession, Index paramIndex, int paramInt) {
/* 165 */     if (SysProperties.CHECK && !this.database.isMultiVersion() && 
/* 166 */       !(paramIndex instanceof PageDelegateIndex)) {
/* 167 */       long l = paramIndex.getRowCount(paramSession);
/* 168 */       if (l != this.rowCount + paramInt) {
/* 169 */         DbException.throwInternalError("rowCount expected " + (this.rowCount + paramInt) + " got " + l + " " + getName() + "." + paramIndex.getName());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Index getScanIndex(Session paramSession) {
/* 179 */     return this.indexes.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 184 */     for (Index index : this.indexes) {
/* 185 */       if (index.getIndexType().isUnique()) {
/* 186 */         return index;
/*     */       }
/*     */     } 
/* 189 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Index> getIndexes() {
/* 194 */     return this.indexes;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index addIndex(Session paramSession, String paramString1, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, String paramString2) {
/*     */     TreeIndex treeIndex;
/*     */     MultiVersionIndex multiVersionIndex;
/* 201 */     if (paramIndexType.isPrimaryKey()) {
/* 202 */       for (IndexColumn indexColumn : paramArrayOfIndexColumn) {
/* 203 */         Column column = indexColumn.column;
/* 204 */         if (column.isNullable()) {
/* 205 */           throw DbException.get(90023, column.getName());
/*     */         }
/*     */         
/* 208 */         column.setPrimaryKey(true);
/*     */       } 
/*     */     }
/* 211 */     boolean bool = (isTemporary() && !isGlobalTemporary()) ? true : false;
/* 212 */     if (!bool) {
/* 213 */       this.database.lockMeta(paramSession);
/*     */     }
/*     */     
/* 216 */     if (isPersistIndexes() && paramIndexType.isPersistent()) {
/*     */       int i;
/* 218 */       if (this.database.isStarting() && this.database.getPageStore().getRootPageId(paramInt) != 0) {
/*     */         
/* 220 */         i = -1;
/* 221 */       } else if (!this.database.isStarting() && this.mainIndex.getRowCount(paramSession) != 0L) {
/* 222 */         i = -1;
/*     */       } else {
/* 224 */         i = getMainIndexColumn(paramIndexType, paramArrayOfIndexColumn);
/*     */       } 
/* 226 */       if (i != -1) {
/* 227 */         this.mainIndex.setMainIndexColumn(i);
/* 228 */         PageDelegateIndex pageDelegateIndex = new PageDelegateIndex(this, paramInt, paramString1, paramIndexType, this.mainIndex, paramBoolean, paramSession);
/*     */       }
/* 230 */       else if (paramIndexType.isSpatial()) {
/* 231 */         SpatialTreeIndex spatialTreeIndex = new SpatialTreeIndex(this, paramInt, paramString1, paramArrayOfIndexColumn, paramIndexType, true, paramBoolean, paramSession);
/*     */       } else {
/*     */         
/* 234 */         PageBtreeIndex pageBtreeIndex = new PageBtreeIndex(this, paramInt, paramString1, paramArrayOfIndexColumn, paramIndexType, paramBoolean, paramSession);
/*     */       }
/*     */     
/*     */     }
/* 238 */     else if (paramIndexType.isHash()) {
/* 239 */       if (paramArrayOfIndexColumn.length != 1) {
/* 240 */         throw DbException.getUnsupportedException("hash indexes may index only one column");
/*     */       }
/*     */       
/* 243 */       if (paramIndexType.isUnique()) {
/* 244 */         HashIndex hashIndex = new HashIndex(this, paramInt, paramString1, paramArrayOfIndexColumn, paramIndexType);
/*     */       } else {
/*     */         
/* 247 */         NonUniqueHashIndex nonUniqueHashIndex = new NonUniqueHashIndex(this, paramInt, paramString1, paramArrayOfIndexColumn, paramIndexType);
/*     */       }
/*     */     
/* 250 */     } else if (paramIndexType.isSpatial()) {
/* 251 */       SpatialTreeIndex spatialTreeIndex = new SpatialTreeIndex(this, paramInt, paramString1, paramArrayOfIndexColumn, paramIndexType, false, true, paramSession);
/*     */     } else {
/*     */       
/* 254 */       treeIndex = new TreeIndex(this, paramInt, paramString1, paramArrayOfIndexColumn, paramIndexType);
/*     */     } 
/*     */     
/* 257 */     if (this.database.isMultiVersion()) {
/* 258 */       multiVersionIndex = new MultiVersionIndex((Index)treeIndex, this);
/*     */     }
/* 260 */     if (multiVersionIndex.needRebuild() && this.rowCount > 0L) {
/*     */       try {
/* 262 */         Index index = getScanIndex(paramSession);
/* 263 */         long l1 = index.getRowCount(paramSession);
/* 264 */         long l2 = l1;
/* 265 */         Cursor cursor = index.find(paramSession, null, null);
/* 266 */         long l3 = 0L;
/* 267 */         int i = (int)Math.min(this.rowCount, this.database.getMaxMemoryRows());
/* 268 */         ArrayList<Row> arrayList = New.arrayList(i);
/* 269 */         String str = getName() + ":" + multiVersionIndex.getName();
/* 270 */         int j = MathUtils.convertLongToInt(l2);
/* 271 */         while (cursor.next()) {
/* 272 */           this.database.setProgress(1, str, MathUtils.convertLongToInt(l3++), j);
/*     */           
/* 274 */           Row row = cursor.get();
/* 275 */           arrayList.add(row);
/* 276 */           if (arrayList.size() >= i) {
/* 277 */             addRowsToIndex(paramSession, arrayList, (Index)multiVersionIndex);
/*     */           }
/* 279 */           l1--;
/*     */         } 
/* 281 */         addRowsToIndex(paramSession, arrayList, (Index)multiVersionIndex);
/* 282 */         if (SysProperties.CHECK && l1 != 0L) {
/* 283 */           DbException.throwInternalError("rowcount remaining=" + l1 + " " + getName());
/*     */         }
/*     */       }
/* 286 */       catch (DbException dbException) {
/* 287 */         getSchema().freeUniqueName(paramString1);
/*     */         try {
/* 289 */           multiVersionIndex.remove(paramSession);
/* 290 */         } catch (DbException dbException1) {
/*     */ 
/*     */ 
/*     */           
/* 294 */           this.trace.error((Throwable)dbException1, "could not remove index");
/* 295 */           throw dbException1;
/*     */         } 
/* 297 */         throw dbException;
/*     */       } 
/*     */     }
/* 300 */     multiVersionIndex.setTemporary(isTemporary());
/* 301 */     if (multiVersionIndex.getCreateSQL() != null) {
/* 302 */       multiVersionIndex.setComment(paramString2);
/* 303 */       if (bool) {
/* 304 */         paramSession.addLocalTempTableIndex((Index)multiVersionIndex);
/*     */       } else {
/* 306 */         this.database.addSchemaObject(paramSession, (SchemaObject)multiVersionIndex);
/*     */       } 
/*     */     } 
/* 309 */     this.indexes.add(multiVersionIndex);
/* 310 */     setModified();
/* 311 */     return (Index)multiVersionIndex;
/*     */   }
/*     */   
/*     */   private int getMainIndexColumn(IndexType paramIndexType, IndexColumn[] paramArrayOfIndexColumn) {
/* 315 */     if (this.mainIndex.getMainIndexColumn() != -1) {
/* 316 */       return -1;
/*     */     }
/* 318 */     if (!paramIndexType.isPrimaryKey() || paramArrayOfIndexColumn.length != 1) {
/* 319 */       return -1;
/*     */     }
/* 321 */     IndexColumn indexColumn = paramArrayOfIndexColumn[0];
/* 322 */     if (indexColumn.sortType != 0) {
/* 323 */       return -1;
/*     */     }
/* 325 */     switch (indexColumn.column.getType()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/* 334 */         return indexColumn.column.getColumnId();
/*     */     } 
/*     */     return -1;
/*     */   }
/*     */   public boolean canGetRowCount() {
/* 339 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void addRowsToIndex(Session paramSession, ArrayList<Row> paramArrayList, Index paramIndex) {
/* 344 */     final Index idx = paramIndex;
/* 345 */     Collections.sort(paramArrayList, new Comparator<Row>()
/*     */         {
/*     */           public int compare(Row param1Row1, Row param1Row2) {
/* 348 */             return idx.compareRows((SearchRow)param1Row1, (SearchRow)param1Row2);
/*     */           }
/*     */         });
/* 351 */     for (Row row : paramArrayList) {
/* 352 */       paramIndex.add(paramSession, row);
/*     */     }
/* 354 */     paramArrayList.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDrop() {
/* 359 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 364 */     if (this.database.isMultiVersion()) {
/* 365 */       return getScanIndex(paramSession).getRowCount(paramSession);
/*     */     }
/* 367 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRow(Session paramSession, Row paramRow) {
/* 372 */     if (this.database.isMultiVersion()) {
/* 373 */       if (paramRow.isDeleted()) {
/* 374 */         throw DbException.get(90131, getName());
/*     */       }
/* 376 */       int j = paramRow.getSessionId();
/* 377 */       int k = paramSession.getId();
/* 378 */       if (j == 0) {
/* 379 */         paramRow.setSessionId(k);
/* 380 */       } else if (j != k) {
/* 381 */         throw DbException.get(90131, getName());
/*     */       } 
/*     */     } 
/* 384 */     this.lastModificationId = this.database.getNextModificationDataId();
/* 385 */     int i = this.indexes.size() - 1;
/*     */     try {
/* 387 */       for (; i >= 0; i--) {
/* 388 */         Index index = this.indexes.get(i);
/* 389 */         index.remove(paramSession, paramRow);
/* 390 */         checkRowCount(paramSession, index, -1);
/*     */       } 
/* 392 */       this.rowCount--;
/* 393 */     } catch (Throwable throwable) {
/*     */       try {
/* 395 */         while (++i < this.indexes.size()) {
/* 396 */           Index index = this.indexes.get(i);
/* 397 */           index.add(paramSession, paramRow);
/* 398 */           checkRowCount(paramSession, index, 0);
/*     */         } 
/* 400 */       } catch (DbException dbException) {
/*     */ 
/*     */ 
/*     */         
/* 404 */         this.trace.error((Throwable)dbException, "could not undo operation");
/* 405 */         throw dbException;
/*     */       } 
/* 407 */       throw DbException.convert(throwable);
/*     */     } 
/* 409 */     analyzeIfRequired(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 414 */     this.lastModificationId = this.database.getNextModificationDataId();
/* 415 */     for (int i = this.indexes.size() - 1; i >= 0; i--) {
/* 416 */       Index index = this.indexes.get(i);
/* 417 */       index.truncate(paramSession);
/*     */     } 
/* 419 */     this.rowCount = 0L;
/* 420 */     this.changesSinceAnalyze = 0;
/*     */   }
/*     */   
/*     */   private void analyzeIfRequired(Session paramSession) {
/* 424 */     if (this.nextAnalyze == 0 || this.nextAnalyze > this.changesSinceAnalyze++) {
/*     */       return;
/*     */     }
/* 427 */     this.changesSinceAnalyze = 0;
/* 428 */     int i = 2 * this.nextAnalyze;
/* 429 */     if (i > 0) {
/* 430 */       this.nextAnalyze = i;
/*     */     }
/* 432 */     int j = (paramSession.getDatabase().getSettings()).analyzeSample / 10;
/* 433 */     Analyze.analyzeTable(paramSession, this, j, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLockedExclusivelyBy(Session paramSession) {
/* 438 */     return (this.lockExclusiveSession == paramSession);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/* 444 */     int i = this.database.getLockMode();
/* 445 */     if (i == 0) {
/* 446 */       return (this.lockExclusiveSession != null);
/*     */     }
/* 448 */     if (!paramBoolean2 && this.database.isMultiVersion())
/*     */     {
/*     */       
/* 451 */       if (paramBoolean1) {
/* 452 */         paramBoolean1 = false;
/*     */       }
/* 454 */       else if (this.lockExclusiveSession == null) {
/* 455 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 459 */     if (this.lockExclusiveSession == paramSession) {
/* 460 */       return true;
/*     */     }
/* 462 */     synchronized (this.database) {
/* 463 */       if (this.lockExclusiveSession == paramSession) {
/* 464 */         return true;
/*     */       }
/* 466 */       if (!paramBoolean1 && this.lockSharedSessions.contains(paramSession)) {
/* 467 */         return true;
/*     */       }
/* 469 */       paramSession.setWaitForLock(this, Thread.currentThread());
/* 470 */       this.waitingSessions.addLast(paramSession);
/*     */       try {
/* 472 */         doLock1(paramSession, i, paramBoolean1);
/*     */       } finally {
/* 474 */         paramSession.setWaitForLock(null, null);
/* 475 */         this.waitingSessions.remove(paramSession);
/*     */       } 
/*     */     } 
/* 478 */     return false;
/*     */   }
/*     */   
/*     */   private void doLock1(Session paramSession, int paramInt, boolean paramBoolean) {
/* 482 */     traceLock(paramSession, paramBoolean, "requesting for");
/*     */     
/* 484 */     long l = 0L;
/* 485 */     boolean bool = false;
/*     */     
/*     */     while (true) {
/* 488 */       if (this.waitingSessions.getFirst() == paramSession && 
/* 489 */         doLock2(paramSession, paramInt, paramBoolean)) {
/*     */         return;
/*     */       }
/*     */       
/* 493 */       if (bool) {
/* 494 */         ArrayList<Session> arrayList = checkDeadlock(paramSession, (Session)null, (Set<Session>)null);
/* 495 */         if (arrayList != null) {
/* 496 */           throw DbException.get(40001, getDeadlockDetails(arrayList, paramBoolean));
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 501 */         bool = true;
/*     */       } 
/* 503 */       long l1 = System.currentTimeMillis();
/* 504 */       if (l == 0L) {
/*     */         
/* 506 */         l = l1 + paramSession.getLockTimeout();
/* 507 */       } else if (l1 >= l) {
/* 508 */         traceLock(paramSession, paramBoolean, "timeout after " + paramSession.getLockTimeout());
/* 509 */         throw DbException.get(50200, getName());
/*     */       } 
/*     */       try {
/* 512 */         traceLock(paramSession, paramBoolean, "waiting for");
/* 513 */         if (this.database.getLockMode() == 2) {
/* 514 */           for (byte b = 0; b < 20; b++) {
/* 515 */             long l3 = Runtime.getRuntime().freeMemory();
/* 516 */             System.gc();
/* 517 */             long l4 = Runtime.getRuntime().freeMemory();
/* 518 */             if (l3 == l4) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         }
/*     */         
/* 524 */         long l2 = Math.min(100L, l - l1);
/* 525 */         if (l2 == 0L) {
/* 526 */           l2 = 1L;
/*     */         }
/* 528 */         this.database.wait(l2);
/* 529 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean doLock2(Session paramSession, int paramInt, boolean paramBoolean) {
/* 536 */     if (paramBoolean) {
/* 537 */       if (this.lockExclusiveSession == null) {
/* 538 */         if (this.lockSharedSessions.isEmpty()) {
/* 539 */           traceLock(paramSession, paramBoolean, "added for");
/* 540 */           paramSession.addLock(this);
/* 541 */           this.lockExclusiveSession = paramSession;
/* 542 */           return true;
/* 543 */         }  if (this.lockSharedSessions.size() == 1 && this.lockSharedSessions.contains(paramSession))
/*     */         {
/* 545 */           traceLock(paramSession, paramBoolean, "add (upgraded) for ");
/* 546 */           this.lockExclusiveSession = paramSession;
/* 547 */           return true;
/*     */         }
/*     */       
/*     */       } 
/* 551 */     } else if (this.lockExclusiveSession == null) {
/* 552 */       if (paramInt == 3 && 
/* 553 */         !this.database.isMultiThreaded() && !this.database.isMultiVersion())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 560 */         return true;
/*     */       }
/*     */       
/* 563 */       if (!this.lockSharedSessions.contains(paramSession)) {
/* 564 */         traceLock(paramSession, paramBoolean, "ok");
/* 565 */         paramSession.addLock(this);
/* 566 */         this.lockSharedSessions.add(paramSession);
/*     */       } 
/* 568 */       return true;
/*     */     } 
/*     */     
/* 571 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getDeadlockDetails(ArrayList<Session> paramArrayList, boolean paramBoolean) {
/* 576 */     StringBuilder stringBuilder = new StringBuilder();
/* 577 */     for (Session session : paramArrayList) {
/* 578 */       Table table = session.getWaitForLock();
/* 579 */       Thread thread = session.getWaitForLockThread();
/* 580 */       stringBuilder.append("\nSession ").append(session.toString()).append(" on thread ").append(thread.getName()).append(" is waiting to lock ").append(table.toString()).append(paramBoolean ? " (exclusive)" : " (shared)").append(" while locking ");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 588 */       byte b = 0;
/* 589 */       for (Table table1 : session.getLocks()) {
/* 590 */         if (b++ > 0) {
/* 591 */           stringBuilder.append(", ");
/*     */         }
/* 593 */         stringBuilder.append(table1.toString());
/* 594 */         if (table1 instanceof RegularTable) {
/* 595 */           if (((RegularTable)table1).lockExclusiveSession == session) {
/* 596 */             stringBuilder.append(" (exclusive)");
/*     */           } else {
/* 598 */             stringBuilder.append(" (shared)");
/*     */           } 
/*     */         }
/*     */       } 
/* 602 */       stringBuilder.append('.');
/*     */     } 
/* 604 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Session> checkDeadlock(Session paramSession1, Session paramSession2, Set<Session> paramSet) {
/* 611 */     synchronized (RegularTable.class) {
/* 612 */       if (paramSession2 == null)
/*     */       
/* 614 */       { paramSession2 = paramSession1;
/* 615 */         paramSet = New.hashSet(); }
/* 616 */       else { if (paramSession2 == paramSession1)
/*     */         {
/* 618 */           return New.arrayList(); } 
/* 619 */         if (paramSet.contains(paramSession1))
/*     */         {
/*     */ 
/*     */           
/* 623 */           return null; }  }
/*     */       
/* 625 */       paramSet.add(paramSession1);
/* 626 */       ArrayList<Session> arrayList = null;
/* 627 */       for (Session session : this.lockSharedSessions) {
/* 628 */         if (session == paramSession1) {
/*     */           continue;
/*     */         }
/*     */         
/* 632 */         Table table = session.getWaitForLock();
/* 633 */         if (table != null) {
/* 634 */           arrayList = table.checkDeadlock(session, paramSession2, paramSet);
/* 635 */           if (arrayList != null) {
/* 636 */             arrayList.add(paramSession1);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 641 */       if (arrayList == null && this.lockExclusiveSession != null) {
/* 642 */         Table table = this.lockExclusiveSession.getWaitForLock();
/* 643 */         if (table != null) {
/* 644 */           arrayList = table.checkDeadlock(this.lockExclusiveSession, paramSession2, paramSet);
/* 645 */           if (arrayList != null) {
/* 646 */             arrayList.add(paramSession1);
/*     */           }
/*     */         } 
/*     */       } 
/* 650 */       return arrayList;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void traceLock(Session paramSession, boolean paramBoolean, String paramString) {
/* 655 */     if (this.traceLock.isDebugEnabled()) {
/* 656 */       this.traceLock.debug("{0} {1} {2} {3}", new Object[] { Integer.valueOf(paramSession.getId()), paramBoolean ? "exclusive write lock" : "shared read lock", paramString, getName() });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLockedExclusively() {
/* 663 */     return (this.lockExclusiveSession != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unlock(Session paramSession) {
/* 668 */     if (this.database != null) {
/* 669 */       traceLock(paramSession, (this.lockExclusiveSession == paramSession), "unlock");
/* 670 */       if (this.lockExclusiveSession == paramSession) {
/* 671 */         this.lockExclusiveSession = null;
/*     */       }
/* 673 */       synchronized (this.database) {
/* 674 */         if (this.lockSharedSessions.size() > 0) {
/* 675 */           this.lockSharedSessions.remove(paramSession);
/*     */         }
/* 677 */         if (!this.waitingSessions.isEmpty()) {
/* 678 */           this.database.notifyAll();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowCount(long paramLong) {
/* 690 */     this.rowCount = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 695 */     if (this.containsLargeObject) {
/*     */       
/* 697 */       truncate(paramSession);
/* 698 */       this.database.getLobStorage().removeAllForTable(getId());
/* 699 */       this.database.lockMeta(paramSession);
/*     */     } 
/* 701 */     super.removeChildrenAndResources(paramSession);
/*     */     
/* 703 */     while (this.indexes.size() > 1) {
/* 704 */       Index index = this.indexes.get(1);
/* 705 */       if (index.getName() != null) {
/* 706 */         this.database.removeSchemaObject(paramSession, (SchemaObject)index);
/*     */       }
/*     */       
/* 709 */       this.indexes.remove(index);
/*     */     } 
/* 711 */     if (SysProperties.CHECK) {
/* 712 */       for (SchemaObject schemaObject : this.database.getAllSchemaObjects(1)) {
/* 713 */         Index index = (Index)schemaObject;
/* 714 */         if (index.getTable() == this) {
/* 715 */           DbException.throwInternalError("index not dropped: " + index.getName());
/*     */         }
/*     */       } 
/*     */     }
/* 719 */     this.scanIndex.remove(paramSession);
/* 720 */     this.database.removeMeta(paramSession, getId());
/* 721 */     this.scanIndex = null;
/* 722 */     this.lockExclusiveSession = null;
/* 723 */     this.lockSharedSessions = null;
/* 724 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 729 */     return getSQL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkSupportAlter() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canTruncate() {
/* 744 */     if (getCheckForeignKeyConstraints() && this.database.getReferentialIntegrity()) {
/* 745 */       ArrayList<Constraint> arrayList = getConstraints();
/* 746 */       if (arrayList != null) {
/* 747 */         byte b; int i; for (b = 0, i = arrayList.size(); b < i; b++) {
/* 748 */           Constraint constraint = arrayList.get(b);
/* 749 */           if (constraint.getConstraintType().equals("REFERENTIAL")) {
/*     */ 
/*     */             
/* 752 */             ConstraintReferential constraintReferential = (ConstraintReferential)constraint;
/* 753 */             if (constraintReferential.getRefTable() == this)
/* 754 */               return false; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 759 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTableType() {
/* 764 */     return "TABLE";
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxDataModificationId() {
/* 769 */     return this.lastModificationId;
/*     */   }
/*     */   
/*     */   public boolean getContainsLargeObject() {
/* 773 */     return this.containsLargeObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 778 */     return this.scanIndex.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 783 */     return this.scanIndex.getDiskSpaceUsed();
/*     */   }
/*     */   
/*     */   public void setCompareMode(CompareMode paramCompareMode) {
/* 787 */     this.compareMode = paramCompareMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeterministic() {
/* 792 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Column getRowIdColumn() {
/* 797 */     if (this.rowIdColumn == null) {
/* 798 */       this.rowIdColumn = new Column("_ROWID_", 5);
/* 799 */       this.rowIdColumn.setTable(this, -1);
/*     */     } 
/* 801 */     return this.rowIdColumn;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\RegularTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */