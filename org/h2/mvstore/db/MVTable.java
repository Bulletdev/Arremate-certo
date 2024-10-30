/*     */ package org.h2.mvstore.db;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.h2.command.ddl.Analyze;
/*     */ import org.h2.command.ddl.CreateTableData;
/*     */ import org.h2.constraint.Constraint;
/*     */ import org.h2.constraint.ConstraintReferential;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.index.MultiVersionIndex;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.mvstore.DataUtils;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableBase;
/*     */ import org.h2.util.DebuggingThreadLocal;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
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
/*     */ public class MVTable
/*     */   extends TableBase
/*     */ {
/*     */   public static final DebuggingThreadLocal<String> WAITING_FOR_LOCK;
/*     */   public static final DebuggingThreadLocal<ArrayList<String>> EXCLUSIVE_LOCKS;
/*     */   public static final DebuggingThreadLocal<ArrayList<String>> SHARED_LOCKS;
/*     */   private MVPrimaryIndex primaryIndex;
/*     */   
/*     */   static {
/*  68 */     if (SysProperties.THREAD_DEADLOCK_DETECTOR) {
/*  69 */       WAITING_FOR_LOCK = new DebuggingThreadLocal();
/*  70 */       EXCLUSIVE_LOCKS = new DebuggingThreadLocal();
/*  71 */       SHARED_LOCKS = new DebuggingThreadLocal();
/*     */     } else {
/*  73 */       WAITING_FOR_LOCK = null;
/*  74 */       EXCLUSIVE_LOCKS = null;
/*  75 */       SHARED_LOCKS = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*  80 */   private final ArrayList<Index> indexes = New.arrayList();
/*     */   
/*     */   private long lastModificationId;
/*     */   
/*     */   private volatile Session lockExclusiveSession;
/*  85 */   private final ConcurrentHashMap<Session, Session> lockSharedSessions = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  92 */   private final ArrayDeque<Session> waitingSessions = new ArrayDeque<>();
/*     */   
/*     */   private final Trace traceLock;
/*     */   private int changesSinceAnalyze;
/*     */   private int nextAnalyze;
/*     */   private boolean containsLargeObject;
/*     */   private Column rowIdColumn;
/*     */   private final MVTableEngine.Store store;
/*     */   private final TransactionStore transactionStore;
/*     */   
/*     */   public MVTable(CreateTableData paramCreateTableData, MVTableEngine.Store paramStore) {
/* 103 */     super(paramCreateTableData);
/* 104 */     this.nextAnalyze = (this.database.getSettings()).analyzeAuto;
/* 105 */     this.store = paramStore;
/* 106 */     this.transactionStore = paramStore.getTransactionStore();
/* 107 */     this.isHidden = paramCreateTableData.isHidden;
/* 108 */     for (Column column : getColumns()) {
/* 109 */       if (DataType.isLargeObject(column.getType())) {
/* 110 */         this.containsLargeObject = true;
/*     */       }
/*     */     } 
/* 113 */     this.traceLock = this.database.getTrace(7);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init(Session paramSession) {
/* 122 */     this.primaryIndex = new MVPrimaryIndex(paramSession.getDatabase(), this, getId(), IndexColumn.wrap(getColumns()), IndexType.createScan(true));
/*     */     
/* 124 */     this.indexes.add(this.primaryIndex);
/*     */   }
/*     */   
/*     */   public String getMapName() {
/* 128 */     return this.primaryIndex.getMapName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean lock(Session paramSession, boolean paramBoolean1, boolean paramBoolean2) {
/* 134 */     int i = this.database.getLockMode();
/* 135 */     if (i == 0) {
/* 136 */       return false;
/*     */     }
/* 138 */     if (!paramBoolean2 && this.database.isMultiVersion())
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 143 */       if (paramBoolean1) {
/* 144 */         paramBoolean1 = false;
/*     */       }
/* 146 */       else if (this.lockExclusiveSession == null) {
/* 147 */         return false;
/*     */       } 
/*     */     }
/*     */     
/* 151 */     if (this.lockExclusiveSession == paramSession) {
/* 152 */       return true;
/*     */     }
/* 154 */     if (!paramBoolean1 && this.lockSharedSessions.containsKey(paramSession)) {
/* 155 */       return true;
/*     */     }
/* 157 */     synchronized (getLockSyncObject()) {
/* 158 */       if (!paramBoolean1 && this.lockSharedSessions.containsKey(paramSession)) {
/* 159 */         return true;
/*     */       }
/* 161 */       paramSession.setWaitForLock((Table)this, Thread.currentThread());
/* 162 */       if (SysProperties.THREAD_DEADLOCK_DETECTOR) {
/* 163 */         WAITING_FOR_LOCK.set(getName());
/*     */       }
/* 165 */       this.waitingSessions.addLast(paramSession);
/*     */       try {
/* 167 */         doLock1(paramSession, i, paramBoolean1);
/*     */       } finally {
/* 169 */         paramSession.setWaitForLock(null, null);
/* 170 */         if (SysProperties.THREAD_DEADLOCK_DETECTOR) {
/* 171 */           WAITING_FOR_LOCK.remove();
/*     */         }
/* 173 */         this.waitingSessions.remove(paramSession);
/*     */       } 
/*     */     } 
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object getLockSyncObject() {
/* 188 */     if (this.database.isMultiThreaded()) {
/* 189 */       return this;
/*     */     }
/* 191 */     return this.database;
/*     */   }
/*     */   
/*     */   private void doLock1(Session paramSession, int paramInt, boolean paramBoolean) {
/* 195 */     traceLock(paramSession, paramBoolean, "requesting for");
/*     */     
/* 197 */     long l = 0L;
/* 198 */     boolean bool = false;
/*     */     
/*     */     while (true) {
/* 201 */       if (this.waitingSessions.getFirst() == paramSession && 
/* 202 */         doLock2(paramSession, paramInt, paramBoolean)) {
/*     */         return;
/*     */       }
/*     */       
/* 206 */       if (bool) {
/* 207 */         ArrayList<Session> arrayList = checkDeadlock(paramSession, (Session)null, (Set<Session>)null);
/* 208 */         if (arrayList != null) {
/* 209 */           throw DbException.get(40001, getDeadlockDetails(arrayList, paramBoolean));
/*     */         }
/*     */       }
/*     */       else {
/*     */         
/* 214 */         bool = true;
/*     */       } 
/* 216 */       long l1 = System.currentTimeMillis();
/* 217 */       if (l == 0L) {
/*     */         
/* 219 */         l = l1 + paramSession.getLockTimeout();
/* 220 */       } else if (l1 >= l) {
/* 221 */         traceLock(paramSession, paramBoolean, "timeout after " + paramSession.getLockTimeout());
/*     */         
/* 223 */         throw DbException.get(50200, getName());
/*     */       } 
/*     */       try {
/* 226 */         traceLock(paramSession, paramBoolean, "waiting for");
/* 227 */         if (this.database.getLockMode() == 2) {
/* 228 */           for (byte b = 0; b < 20; b++) {
/* 229 */             long l3 = Runtime.getRuntime().freeMemory();
/* 230 */             System.gc();
/* 231 */             long l4 = Runtime.getRuntime().freeMemory();
/* 232 */             if (l3 == l4) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         }
/*     */         
/* 238 */         long l2 = Math.min(100L, l - l1);
/* 239 */         if (l2 == 0L) {
/* 240 */           l2 = 1L;
/*     */         }
/* 242 */         getLockSyncObject().wait(l2);
/* 243 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean doLock2(Session paramSession, int paramInt, boolean paramBoolean) {
/* 250 */     if (paramBoolean) {
/* 251 */       if (this.lockExclusiveSession == null) {
/* 252 */         if (this.lockSharedSessions.isEmpty()) {
/* 253 */           traceLock(paramSession, paramBoolean, "added for");
/* 254 */           paramSession.addLock((Table)this);
/* 255 */           this.lockExclusiveSession = paramSession;
/* 256 */           if (SysProperties.THREAD_DEADLOCK_DETECTOR) {
/* 257 */             if (EXCLUSIVE_LOCKS.get() == null) {
/* 258 */               EXCLUSIVE_LOCKS.set(new ArrayList());
/*     */             }
/* 260 */             ((ArrayList<String>)EXCLUSIVE_LOCKS.get()).add(getName());
/*     */           } 
/* 262 */           return true;
/* 263 */         }  if (this.lockSharedSessions.size() == 1 && this.lockSharedSessions.containsKey(paramSession))
/*     */         {
/* 265 */           traceLock(paramSession, paramBoolean, "add (upgraded) for ");
/* 266 */           this.lockExclusiveSession = paramSession;
/* 267 */           if (SysProperties.THREAD_DEADLOCK_DETECTOR) {
/* 268 */             if (EXCLUSIVE_LOCKS.get() == null) {
/* 269 */               EXCLUSIVE_LOCKS.set(new ArrayList());
/*     */             }
/* 271 */             ((ArrayList<String>)EXCLUSIVE_LOCKS.get()).add(getName());
/*     */           } 
/* 273 */           return true;
/*     */         }
/*     */       
/*     */       } 
/* 277 */     } else if (this.lockExclusiveSession == null) {
/* 278 */       if (paramInt == 3 && 
/* 279 */         !this.database.isMultiThreaded() && !this.database.isMultiVersion())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 287 */         return true;
/*     */       }
/*     */       
/* 290 */       if (!this.lockSharedSessions.containsKey(paramSession)) {
/* 291 */         traceLock(paramSession, paramBoolean, "ok");
/* 292 */         paramSession.addLock((Table)this);
/* 293 */         this.lockSharedSessions.put(paramSession, paramSession);
/* 294 */         if (SysProperties.THREAD_DEADLOCK_DETECTOR) {
/* 295 */           if (SHARED_LOCKS.get() == null) {
/* 296 */             SHARED_LOCKS.set(new ArrayList());
/*     */           }
/* 298 */           ((ArrayList<String>)SHARED_LOCKS.get()).add(getName());
/*     */         } 
/*     */       } 
/* 301 */       return true;
/*     */     } 
/*     */     
/* 304 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getDeadlockDetails(ArrayList<Session> paramArrayList, boolean paramBoolean) {
/* 310 */     StringBuilder stringBuilder = new StringBuilder();
/* 311 */     for (Session session : paramArrayList) {
/* 312 */       Table table = session.getWaitForLock();
/* 313 */       Thread thread = session.getWaitForLockThread();
/* 314 */       stringBuilder.append("\nSession ").append(session.toString()).append(" on thread ").append(thread.getName()).append(" is waiting to lock ").append(table.toString()).append(paramBoolean ? " (exclusive)" : " (shared)").append(" while locking ");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 319 */       byte b = 0;
/* 320 */       for (Table table1 : session.getLocks()) {
/* 321 */         if (b++ > 0) {
/* 322 */           stringBuilder.append(", ");
/*     */         }
/* 324 */         stringBuilder.append(table1.toString());
/* 325 */         if (table1 instanceof MVTable) {
/* 326 */           if (((MVTable)table1).lockExclusiveSession == session) {
/* 327 */             stringBuilder.append(" (exclusive)");
/*     */           } else {
/* 329 */             stringBuilder.append(" (shared)");
/*     */           } 
/*     */         }
/*     */       } 
/* 333 */       stringBuilder.append('.');
/*     */     } 
/* 335 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Session> checkDeadlock(Session paramSession1, Session paramSession2, Set<Session> paramSet) {
/* 342 */     synchronized (MVTable.class) {
/* 343 */       if (paramSession2 == null)
/*     */       
/* 345 */       { paramSession2 = paramSession1;
/* 346 */         paramSet = New.hashSet(); }
/* 347 */       else { if (paramSession2 == paramSession1)
/*     */         {
/* 349 */           return New.arrayList(); } 
/* 350 */         if (paramSet.contains(paramSession1))
/*     */         {
/*     */ 
/*     */           
/* 354 */           return null; }  }
/*     */       
/* 356 */       paramSet.add(paramSession1);
/* 357 */       ArrayList<Session> arrayList = null;
/* 358 */       for (Session session1 : this.lockSharedSessions.keySet()) {
/* 359 */         if (session1 == paramSession1) {
/*     */           continue;
/*     */         }
/*     */         
/* 363 */         Table table = session1.getWaitForLock();
/* 364 */         if (table != null) {
/* 365 */           arrayList = table.checkDeadlock(session1, paramSession2, paramSet);
/* 366 */           if (arrayList != null) {
/* 367 */             arrayList.add(paramSession1);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 374 */       Session session = this.lockExclusiveSession;
/* 375 */       if (arrayList == null && session != null) {
/* 376 */         Table table = session.getWaitForLock();
/* 377 */         if (table != null) {
/* 378 */           arrayList = table.checkDeadlock(session, paramSession2, paramSet);
/*     */           
/* 380 */           if (arrayList != null) {
/* 381 */             arrayList.add(paramSession1);
/*     */           }
/*     */         } 
/*     */       } 
/* 385 */       return arrayList;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void traceLock(Session paramSession, boolean paramBoolean, String paramString) {
/* 390 */     if (this.traceLock.isDebugEnabled()) {
/* 391 */       this.traceLock.debug("{0} {1} {2} {3}", new Object[] { Integer.valueOf(paramSession.getId()), paramBoolean ? "exclusive write lock" : "shared read lock", paramString, getName() });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLockedExclusively() {
/* 399 */     return (this.lockExclusiveSession != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLockedExclusivelyBy(Session paramSession) {
/* 404 */     return (this.lockExclusiveSession == paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void unlock(Session paramSession) {
/* 409 */     if (this.database != null) {
/* 410 */       traceLock(paramSession, (this.lockExclusiveSession == paramSession), "unlock");
/* 411 */       if (this.lockExclusiveSession == paramSession) {
/* 412 */         this.lockExclusiveSession = null;
/* 413 */         if (SysProperties.THREAD_DEADLOCK_DETECTOR && 
/* 414 */           EXCLUSIVE_LOCKS.get() != null) {
/* 415 */           ((ArrayList)EXCLUSIVE_LOCKS.get()).remove(getName());
/*     */         }
/*     */       } 
/*     */       
/* 419 */       synchronized (getLockSyncObject()) {
/* 420 */         if (this.lockSharedSessions.size() > 0) {
/* 421 */           this.lockSharedSessions.remove(paramSession);
/* 422 */           if (SysProperties.THREAD_DEADLOCK_DETECTOR && 
/* 423 */             SHARED_LOCKS.get() != null) {
/* 424 */             ((ArrayList)SHARED_LOCKS.get()).remove(getName());
/*     */           }
/*     */         } 
/*     */         
/* 428 */         if (!this.waitingSessions.isEmpty()) {
/* 429 */           getLockSyncObject().notifyAll();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canTruncate() {
/* 437 */     if (getCheckForeignKeyConstraints() && this.database.getReferentialIntegrity()) {
/*     */       
/* 439 */       ArrayList<Constraint> arrayList = getConstraints();
/* 440 */       if (arrayList != null) {
/* 441 */         byte b; int i; for (b = 0, i = arrayList.size(); b < i; b++) {
/* 442 */           Constraint constraint = arrayList.get(b);
/* 443 */           if (constraint.getConstraintType().equals("REFERENTIAL")) {
/*     */ 
/*     */             
/* 446 */             ConstraintReferential constraintReferential = (ConstraintReferential)constraint;
/* 447 */             if (constraintReferential.getRefTable() == this)
/* 448 */               return false; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 453 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Row getRow(Session paramSession, long paramLong) {
/* 463 */     return this.primaryIndex.getRow(paramSession, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Index addIndex(Session paramSession, String paramString1, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, String paramString2) {
/*     */     MVSecondaryIndex mVSecondaryIndex;
/* 470 */     if (paramIndexType.isPrimaryKey()) {
/* 471 */       for (IndexColumn indexColumn : paramArrayOfIndexColumn) {
/* 472 */         Column column = indexColumn.column;
/* 473 */         if (column.isNullable()) {
/* 474 */           throw DbException.get(90023, column.getName());
/*     */         }
/*     */ 
/*     */         
/* 478 */         column.setPrimaryKey(true);
/*     */       } 
/*     */     }
/* 481 */     boolean bool = (isTemporary() && !isGlobalTemporary()) ? true : false;
/* 482 */     if (!bool) {
/* 483 */       this.database.lockMeta(paramSession);
/*     */     }
/*     */ 
/*     */     
/* 487 */     int i = getMainIndexColumn(paramIndexType, paramArrayOfIndexColumn);
/* 488 */     if (this.database.isStarting()) {
/* 489 */       if (this.transactionStore.store.hasMap("index." + paramInt)) {
/* 490 */         i = -1;
/*     */       }
/* 492 */     } else if (this.primaryIndex.getRowCountMax() != 0L) {
/* 493 */       i = -1;
/*     */     } 
/* 495 */     if (i != -1) {
/* 496 */       this.primaryIndex.setMainIndexColumn(i);
/* 497 */       MVDelegateIndex mVDelegateIndex = new MVDelegateIndex(this, paramInt, paramString1, this.primaryIndex, paramIndexType);
/*     */     }
/* 499 */     else if (paramIndexType.isSpatial()) {
/* 500 */       MVSpatialIndex mVSpatialIndex = new MVSpatialIndex(paramSession.getDatabase(), this, paramInt, paramString1, paramArrayOfIndexColumn, paramIndexType);
/*     */     } else {
/*     */       
/* 503 */       mVSecondaryIndex = new MVSecondaryIndex(paramSession.getDatabase(), this, paramInt, paramString1, paramArrayOfIndexColumn, paramIndexType);
/*     */     } 
/*     */     
/* 506 */     if (mVSecondaryIndex.needRebuild()) {
/* 507 */       rebuildIndex(paramSession, mVSecondaryIndex, paramString1);
/*     */     }
/* 509 */     mVSecondaryIndex.setTemporary(isTemporary());
/* 510 */     if (mVSecondaryIndex.getCreateSQL() != null) {
/* 511 */       mVSecondaryIndex.setComment(paramString2);
/* 512 */       if (bool) {
/* 513 */         paramSession.addLocalTempTableIndex(mVSecondaryIndex);
/*     */       } else {
/* 515 */         this.database.addSchemaObject(paramSession, (SchemaObject)mVSecondaryIndex);
/*     */       } 
/*     */     } 
/* 518 */     this.indexes.add(mVSecondaryIndex);
/* 519 */     setModified();
/* 520 */     return mVSecondaryIndex;
/*     */   }
/*     */   
/*     */   private void rebuildIndex(Session paramSession, MVIndex paramMVIndex, String paramString) {
/*     */     try {
/* 525 */       if (paramSession.getDatabase().getMvStore() == null || paramMVIndex instanceof MVSpatialIndex) {
/*     */ 
/*     */         
/* 528 */         rebuildIndexBuffered(paramSession, paramMVIndex);
/*     */       } else {
/* 530 */         rebuildIndexBlockMerge(paramSession, paramMVIndex);
/*     */       } 
/* 532 */     } catch (DbException dbException) {
/* 533 */       getSchema().freeUniqueName(paramString);
/*     */       try {
/* 535 */         paramMVIndex.remove(paramSession);
/* 536 */       } catch (DbException dbException1) {
/*     */ 
/*     */ 
/*     */         
/* 540 */         this.trace.error((Throwable)dbException1, "could not remove index");
/* 541 */         throw dbException1;
/*     */       } 
/* 543 */       throw dbException;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void rebuildIndexBlockMerge(Session paramSession, MVIndex paramMVIndex) {
/* 548 */     if (paramMVIndex instanceof MVSpatialIndex)
/*     */     {
/* 550 */       rebuildIndexBuffered(paramSession, paramMVIndex);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 559 */     Index index = getScanIndex(paramSession);
/* 560 */     long l1 = index.getRowCount(paramSession);
/* 561 */     long l2 = l1;
/* 562 */     Cursor cursor = index.find(paramSession, null, null);
/* 563 */     long l3 = 0L;
/* 564 */     MVTableEngine.Store store = paramSession.getDatabase().getMvStore();
/*     */     
/* 566 */     int i = this.database.getMaxMemoryRows() / 2;
/* 567 */     ArrayList<Row> arrayList = New.arrayList(i);
/* 568 */     String str = getName() + ":" + paramMVIndex.getName();
/* 569 */     int j = MathUtils.convertLongToInt(l2);
/* 570 */     ArrayList<String> arrayList1 = New.arrayList();
/* 571 */     while (cursor.next()) {
/* 572 */       Row row = cursor.get();
/* 573 */       arrayList.add(row);
/* 574 */       this.database.setProgress(1, str, MathUtils.convertLongToInt(l3++), j);
/*     */       
/* 576 */       if (arrayList.size() >= i) {
/* 577 */         sortRows(arrayList, paramMVIndex);
/* 578 */         String str1 = store.nextTemporaryMapName();
/* 579 */         paramMVIndex.addRowsToBuffer(arrayList, str1);
/* 580 */         arrayList1.add(str1);
/* 581 */         arrayList.clear();
/*     */       } 
/* 583 */       l1--;
/*     */     } 
/* 585 */     sortRows(arrayList, paramMVIndex);
/* 586 */     if (arrayList1.size() > 0) {
/* 587 */       String str1 = store.nextTemporaryMapName();
/* 588 */       paramMVIndex.addRowsToBuffer(arrayList, str1);
/* 589 */       arrayList1.add(str1);
/* 590 */       arrayList.clear();
/* 591 */       paramMVIndex.addBufferedRows(arrayList1);
/*     */     } else {
/* 593 */       addRowsToIndex(paramSession, arrayList, paramMVIndex);
/*     */     } 
/* 595 */     if (SysProperties.CHECK && l1 != 0L) {
/* 596 */       DbException.throwInternalError("rowcount remaining=" + l1 + " " + getName());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void rebuildIndexBuffered(Session paramSession, Index paramIndex) {
/* 602 */     Index index = getScanIndex(paramSession);
/* 603 */     long l1 = index.getRowCount(paramSession);
/* 604 */     long l2 = l1;
/* 605 */     Cursor cursor = index.find(paramSession, null, null);
/* 606 */     long l3 = 0L;
/* 607 */     int i = (int)Math.min(l2, this.database.getMaxMemoryRows());
/* 608 */     ArrayList<Row> arrayList = New.arrayList(i);
/* 609 */     String str = getName() + ":" + paramIndex.getName();
/* 610 */     int j = MathUtils.convertLongToInt(l2);
/* 611 */     while (cursor.next()) {
/* 612 */       Row row = cursor.get();
/* 613 */       arrayList.add(row);
/* 614 */       this.database.setProgress(1, str, MathUtils.convertLongToInt(l3++), j);
/*     */       
/* 616 */       if (arrayList.size() >= i) {
/* 617 */         addRowsToIndex(paramSession, arrayList, paramIndex);
/*     */       }
/* 619 */       l1--;
/*     */     } 
/* 621 */     addRowsToIndex(paramSession, arrayList, paramIndex);
/* 622 */     if (SysProperties.CHECK && l1 != 0L) {
/* 623 */       DbException.throwInternalError("rowcount remaining=" + l1 + " " + getName());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private int getMainIndexColumn(IndexType paramIndexType, IndexColumn[] paramArrayOfIndexColumn) {
/* 629 */     if (this.primaryIndex.getMainIndexColumn() != -1) {
/* 630 */       return -1;
/*     */     }
/* 632 */     if (!paramIndexType.isPrimaryKey() || paramArrayOfIndexColumn.length != 1) {
/* 633 */       return -1;
/*     */     }
/* 635 */     IndexColumn indexColumn = paramArrayOfIndexColumn[0];
/* 636 */     if (indexColumn.sortType != 0) {
/* 637 */       return -1;
/*     */     }
/* 639 */     switch (indexColumn.column.getType()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/*     */       case 5:
/* 648 */         return indexColumn.column.getColumnId();
/*     */     } 
/*     */     return -1;
/*     */   }
/*     */   private static void addRowsToIndex(Session paramSession, ArrayList<Row> paramArrayList, Index paramIndex) {
/* 653 */     sortRows(paramArrayList, paramIndex);
/* 654 */     for (Row row : paramArrayList) {
/* 655 */       paramIndex.add(paramSession, row);
/*     */     }
/* 657 */     paramArrayList.clear();
/*     */   }
/*     */   
/*     */   private static void sortRows(ArrayList<Row> paramArrayList, final Index index) {
/* 661 */     Collections.sort(paramArrayList, new Comparator<Row>()
/*     */         {
/*     */           public int compare(Row param1Row1, Row param1Row2) {
/* 664 */             return index.compareRows((SearchRow)param1Row1, (SearchRow)param1Row2);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRow(Session paramSession, Row paramRow) {
/* 671 */     this.lastModificationId = this.database.getNextModificationDataId();
/* 672 */     TransactionStore.Transaction transaction = getTransaction(paramSession);
/* 673 */     long l = transaction.setSavepoint();
/*     */     try {
/* 675 */       for (int i = this.indexes.size() - 1; i >= 0; i--) {
/* 676 */         Index index = this.indexes.get(i);
/* 677 */         index.remove(paramSession, paramRow);
/*     */       } 
/* 679 */     } catch (Throwable throwable) {
/* 680 */       transaction.rollbackToSavepoint(l);
/* 681 */       throw DbException.convert(throwable);
/*     */     } 
/* 683 */     analyzeIfRequired(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 688 */     this.lastModificationId = this.database.getNextModificationDataId();
/* 689 */     for (int i = this.indexes.size() - 1; i >= 0; i--) {
/* 690 */       Index index = this.indexes.get(i);
/* 691 */       index.truncate(paramSession);
/*     */     } 
/* 693 */     this.changesSinceAnalyze = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRow(Session paramSession, Row paramRow) {
/* 698 */     this.lastModificationId = this.database.getNextModificationDataId();
/* 699 */     TransactionStore.Transaction transaction = getTransaction(paramSession);
/* 700 */     long l = transaction.setSavepoint(); try {
/*     */       byte b; int i;
/* 702 */       for (b = 0, i = this.indexes.size(); b < i; b++) {
/* 703 */         Index index = this.indexes.get(b);
/* 704 */         index.add(paramSession, paramRow);
/*     */       } 
/* 706 */     } catch (Throwable throwable) {
/* 707 */       transaction.rollbackToSavepoint(l);
/* 708 */       DbException dbException = DbException.convert(throwable);
/* 709 */       if (dbException.getErrorCode() == 23505) {
/* 710 */         for (byte b = 0; b < this.indexes.size(); b++) {
/* 711 */           Index index = this.indexes.get(b);
/* 712 */           if (index.getIndexType().isUnique() && index instanceof MultiVersionIndex) {
/*     */             
/* 714 */             MultiVersionIndex multiVersionIndex = (MultiVersionIndex)index;
/* 715 */             if (multiVersionIndex.isUncommittedFromOtherSession(paramSession, paramRow)) {
/* 716 */               throw DbException.get(90131, index.getName());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 723 */       throw dbException;
/*     */     } 
/* 725 */     analyzeIfRequired(paramSession);
/*     */   }
/*     */   
/*     */   private void analyzeIfRequired(Session paramSession) {
/* 729 */     if (this.nextAnalyze == 0 || this.nextAnalyze > this.changesSinceAnalyze++) {
/*     */       return;
/*     */     }
/* 732 */     this.changesSinceAnalyze = 0;
/* 733 */     int i = 2 * this.nextAnalyze;
/* 734 */     if (i > 0) {
/* 735 */       this.nextAnalyze = i;
/*     */     }
/* 737 */     int j = (paramSession.getDatabase().getSettings()).analyzeSample / 10;
/* 738 */     Analyze.analyzeTable(paramSession, (Table)this, j, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkSupportAlter() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTableType() {
/* 748 */     return "TABLE";
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getScanIndex(Session paramSession) {
/* 753 */     return (Index)this.primaryIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public Index getUniqueIndex() {
/* 758 */     return (Index)this.primaryIndex;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Index> getIndexes() {
/* 763 */     return this.indexes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxDataModificationId() {
/* 768 */     return this.lastModificationId;
/*     */   }
/*     */   
/*     */   public boolean getContainsLargeObject() {
/* 772 */     return this.containsLargeObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeterministic() {
/* 777 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetRowCount() {
/* 782 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canDrop() {
/* 787 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 792 */     if (this.containsLargeObject) {
/*     */       
/* 794 */       truncate(paramSession);
/* 795 */       this.database.getLobStorage().removeAllForTable(getId());
/* 796 */       this.database.lockMeta(paramSession);
/*     */     } 
/* 798 */     this.database.getMvStore().removeTable(this);
/* 799 */     super.removeChildrenAndResources(paramSession);
/*     */ 
/*     */     
/* 802 */     while (this.indexes.size() > 1) {
/* 803 */       Index index = this.indexes.get(1);
/* 804 */       if (index.getName() != null) {
/* 805 */         this.database.removeSchemaObject(paramSession, (SchemaObject)index);
/*     */       }
/*     */       
/* 808 */       this.indexes.remove(index);
/*     */     } 
/* 810 */     if (SysProperties.CHECK) {
/* 811 */       for (SchemaObject schemaObject : this.database.getAllSchemaObjects(1)) {
/*     */         
/* 813 */         Index index = (Index)schemaObject;
/* 814 */         if (index.getTable() == this) {
/* 815 */           DbException.throwInternalError("index not dropped: " + index.getName());
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 820 */     this.primaryIndex.remove(paramSession);
/* 821 */     this.database.removeMeta(paramSession, getId());
/* 822 */     close(paramSession);
/* 823 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 828 */     return this.primaryIndex.getRowCount(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 833 */     return this.primaryIndex.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 838 */     return this.primaryIndex.getDiskSpaceUsed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TransactionStore.Transaction getTransaction(Session paramSession) {
/* 853 */     if (paramSession == null)
/*     */     {
/* 855 */       return this.transactionStore.begin();
/*     */     }
/* 857 */     return paramSession.getTransaction();
/*     */   }
/*     */ 
/*     */   
/*     */   public Column getRowIdColumn() {
/* 862 */     if (this.rowIdColumn == null) {
/* 863 */       this.rowIdColumn = new Column("_ROWID_", 5);
/* 864 */       this.rowIdColumn.setTable((Table)this, -1);
/*     */     } 
/* 866 */     return this.rowIdColumn;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 871 */     return getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMVStore() {
/* 876 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit() {
/* 884 */     if (this.database != null) {
/* 885 */       this.lastModificationId = this.database.getNextModificationDataId();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DbException convertException(IllegalStateException paramIllegalStateException) {
/* 896 */     if (DataUtils.getErrorCode(paramIllegalStateException.getMessage()) == 101)
/*     */     {
/* 898 */       throw DbException.get(90131, paramIllegalStateException, new String[] { getName() });
/*     */     }
/*     */     
/* 901 */     return this.store.convertIllegalStateException(paramIllegalStateException);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\MVTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */