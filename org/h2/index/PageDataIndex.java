/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.store.Page;
/*     */ import org.h2.store.PageStore;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.RegularTable;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
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
/*     */ public class PageDataIndex
/*     */   extends PageIndex
/*     */ {
/*     */   private final PageStore store;
/*     */   private final RegularTable tableData;
/*     */   private long lastKey;
/*     */   private long rowCount;
/*     */   private HashSet<Row> delta;
/*     */   private int rowCountDiff;
/*     */   private final HashMap<Integer, Integer> sessionRowCount;
/*  47 */   private int mainIndexColumn = -1;
/*     */ 
/*     */   
/*     */   private DbException fastDuplicateKeyException;
/*     */ 
/*     */   
/*     */   private int memoryPerPage;
/*     */   
/*     */   private int memoryCount;
/*     */   
/*     */   private final boolean multiVersion;
/*     */ 
/*     */   
/*     */   public PageDataIndex(RegularTable paramRegularTable, int paramInt, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, Session paramSession) {
/*  61 */     initBaseIndex((Table)paramRegularTable, paramInt, paramRegularTable.getName() + "_DATA", paramArrayOfIndexColumn, paramIndexType);
/*  62 */     this.multiVersion = this.database.isMultiVersion();
/*     */ 
/*     */ 
/*     */     
/*  66 */     if (this.multiVersion) {
/*  67 */       this.sessionRowCount = New.hashMap();
/*  68 */       this.isMultiVersion = true;
/*     */     } else {
/*  70 */       this.sessionRowCount = null;
/*     */     } 
/*  72 */     this.tableData = paramRegularTable;
/*  73 */     this.store = this.database.getPageStore();
/*  74 */     this.store.addIndex(this);
/*  75 */     if (!this.database.isPersistent()) {
/*  76 */       throw DbException.throwInternalError(paramRegularTable.getName());
/*     */     }
/*  78 */     if (paramBoolean) {
/*  79 */       this.rootPageId = this.store.allocatePage();
/*  80 */       this.store.addMeta(this, paramSession);
/*  81 */       PageDataLeaf pageDataLeaf = PageDataLeaf.create(this, this.rootPageId, 0);
/*  82 */       this.store.update(pageDataLeaf);
/*     */     } else {
/*  84 */       this.rootPageId = this.store.getRootPageId(paramInt);
/*  85 */       PageData pageData = getPage(this.rootPageId, 0);
/*  86 */       this.lastKey = pageData.getLastKey();
/*  87 */       this.rowCount = pageData.getRowCount();
/*     */     } 
/*  89 */     if (this.trace.isDebugEnabled()) {
/*  90 */       this.trace.debug("{0} opened rows: {1}", new Object[] { this, Long.valueOf(this.rowCount) });
/*     */     }
/*  92 */     paramRegularTable.setRowCount(this.rowCount);
/*  93 */     this.memoryPerPage = 240 + this.store.getPageSize() >> 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public DbException getDuplicateKeyException(String paramString) {
/*  98 */     if (this.fastDuplicateKeyException == null) {
/*  99 */       this.fastDuplicateKeyException = super.getDuplicateKeyException((String)null);
/*     */     }
/* 101 */     return this.fastDuplicateKeyException;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/* 106 */     boolean bool = false;
/* 107 */     if (this.mainIndexColumn != -1) {
/* 108 */       paramRow.setKey(paramRow.getValue(this.mainIndexColumn).getLong());
/*     */     }
/* 110 */     else if (paramRow.getKey() == 0L) {
/* 111 */       paramRow.setKey((int)++this.lastKey);
/* 112 */       bool = true;
/*     */     } 
/*     */     
/* 115 */     if (this.tableData.getContainsLargeObject()) {
/* 116 */       byte b; int i; for (b = 0, i = paramRow.getColumnCount(); b < i; b++) {
/* 117 */         Value value1 = paramRow.getValue(b);
/* 118 */         Value value2 = value1.copy((DataHandler)this.database, getId());
/* 119 */         if (value2.isLinkedToTable()) {
/* 120 */           paramSession.removeAtCommitStop(value2);
/*     */         }
/* 122 */         if (value1 != value2) {
/* 123 */           paramRow.setValue(b, value2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 129 */     if (this.trace.isDebugEnabled()) {
/* 130 */       this.trace.debug("{0} add {1}", new Object[] { getName(), paramRow });
/*     */     }
/* 132 */     long l = 0L;
/*     */     while (true) {
/*     */       try {
/* 135 */         addTry(paramSession, paramRow);
/*     */         break;
/* 137 */       } catch (DbException dbException) {
/* 138 */         if (dbException != this.fastDuplicateKeyException) {
/* 139 */           throw dbException;
/*     */         }
/* 141 */         if (!bool) {
/* 142 */           throw getNewDuplicateKeyException();
/*     */         }
/* 144 */         if (l == 0L) {
/*     */ 
/*     */           
/* 147 */           paramRow.setKey((long)(paramRow.getKey() + Math.random() * 10000.0D));
/*     */         } else {
/* 149 */           paramRow.setKey(paramRow.getKey() + l);
/*     */         } 
/* 151 */         l++;
/*     */       } finally {
/* 153 */         this.store.incrementChangeCount();
/*     */       } 
/*     */     } 
/* 156 */     this.lastKey = Math.max(this.lastKey, paramRow.getKey());
/*     */   }
/*     */   
/*     */   public DbException getNewDuplicateKeyException() {
/* 160 */     String str = "PRIMARY KEY ON " + this.table.getSQL();
/* 161 */     if (this.mainIndexColumn >= 0 && this.mainIndexColumn < this.indexColumns.length) {
/* 162 */       str = str + "(" + this.indexColumns[this.mainIndexColumn].getSQL() + ")";
/*     */     }
/* 164 */     DbException dbException = DbException.get(23505, str);
/* 165 */     dbException.setSource(this);
/* 166 */     return dbException;
/*     */   }
/*     */   
/*     */   private void addTry(Session paramSession, Row paramRow) {
/*     */     while (true) {
/* 171 */       PageData pageData1 = getPage(this.rootPageId, 0);
/* 172 */       int i = pageData1.addRowTry(paramRow);
/* 173 */       if (i == -1) {
/*     */         break;
/*     */       }
/* 176 */       if (this.trace.isDebugEnabled()) {
/* 177 */         this.trace.debug("{0} split", new Object[] { this });
/*     */       }
/* 179 */       long l = (i == 0) ? paramRow.getKey() : pageData1.getKey(i - 1);
/* 180 */       PageData pageData2 = pageData1;
/* 181 */       PageData pageData3 = pageData1.split(i);
/* 182 */       int j = this.store.allocatePage();
/* 183 */       pageData2.setPageId(j);
/* 184 */       pageData2.setParentPageId(this.rootPageId);
/* 185 */       pageData3.setParentPageId(this.rootPageId);
/* 186 */       PageDataNode pageDataNode = PageDataNode.create(this, this.rootPageId, 0);
/* 187 */       pageDataNode.init(pageData2, l, pageData3);
/* 188 */       this.store.update(pageData2);
/* 189 */       this.store.update(pageData3);
/* 190 */       this.store.update(pageDataNode);
/* 191 */       pageData1 = pageDataNode;
/*     */     } 
/* 193 */     paramRow.setDeleted(false);
/* 194 */     if (this.multiVersion) {
/* 195 */       if (this.delta == null) {
/* 196 */         this.delta = New.hashSet();
/*     */       }
/* 198 */       boolean bool = this.delta.remove(paramRow);
/* 199 */       if (!bool) {
/* 200 */         this.delta.add(paramRow);
/*     */       }
/* 202 */       incrementRowCount(paramSession.getId(), 1);
/*     */     } 
/* 204 */     invalidateRowCount();
/* 205 */     this.rowCount++;
/* 206 */     this.store.logAddOrRemoveRow(paramSession, this.tableData.getId(), paramRow, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PageDataOverflow getPageOverflow(int paramInt) {
/* 216 */     Page page = this.store.getPage(paramInt);
/* 217 */     if (page instanceof PageDataOverflow) {
/* 218 */       return (PageDataOverflow)page;
/*     */     }
/* 220 */     throw DbException.get(90030, (page == null) ? "null" : page.toString());
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
/*     */   PageData getPage(int paramInt1, int paramInt2) {
/* 232 */     Page page = this.store.getPage(paramInt1);
/* 233 */     if (page == null) {
/* 234 */       PageDataLeaf pageDataLeaf = PageDataLeaf.create(this, paramInt1, paramInt2);
/*     */       
/* 236 */       this.store.logUndo(pageDataLeaf, null);
/* 237 */       this.store.update(pageDataLeaf);
/* 238 */       return pageDataLeaf;
/* 239 */     }  if (!(page instanceof PageData)) {
/* 240 */       throw DbException.get(90030, "" + page);
/*     */     }
/* 242 */     PageData pageData = (PageData)page;
/* 243 */     if (paramInt2 != -1 && 
/* 244 */       pageData.getParentPageId() != paramInt2) {
/* 245 */       throw DbException.throwInternalError(pageData + " parent " + pageData.getParentPageId() + " expected " + paramInt2);
/*     */     }
/*     */ 
/*     */     
/* 249 */     return pageData;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 254 */     return false;
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
/*     */   long getKey(SearchRow paramSearchRow, long paramLong1, long paramLong2) {
/* 266 */     if (paramSearchRow == null) {
/* 267 */       return paramLong1;
/*     */     }
/* 269 */     Value value = paramSearchRow.getValue(this.mainIndexColumn);
/* 270 */     if (value == null)
/* 271 */       throw DbException.throwInternalError(paramSearchRow.toString()); 
/* 272 */     if (value == ValueNull.INSTANCE) {
/* 273 */       return paramLong2;
/*     */     }
/* 275 */     return value.getLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 280 */     long l1 = (paramSearchRow1 == null) ? Long.MIN_VALUE : paramSearchRow1.getKey();
/* 281 */     long l2 = (paramSearchRow2 == null) ? Long.MAX_VALUE : paramSearchRow2.getKey();
/* 282 */     PageData pageData = getPage(this.rootPageId, 0);
/* 283 */     return pageData.find(paramSession, l1, l2, this.isMultiVersion);
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
/*     */ 
/*     */   
/*     */   Cursor find(Session paramSession, long paramLong1, long paramLong2, boolean paramBoolean) {
/* 297 */     PageData pageData = getPage(this.rootPageId, 0);
/* 298 */     return pageData.find(paramSession, paramLong1, paramLong2, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 303 */     throw DbException.throwInternalError();
/*     */   }
/*     */   
/*     */   long getLastKey() {
/* 307 */     PageData pageData = getPage(this.rootPageId, 0);
/* 308 */     return pageData.getLastKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 315 */     long l = 10L * (this.tableData.getRowCountApproximation() + 1000L);
/*     */     
/* 317 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 322 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 327 */     if (this.tableData.getContainsLargeObject()) {
/* 328 */       byte b; int i; for (b = 0, i = paramRow.getColumnCount(); b < i; b++) {
/* 329 */         Value value = paramRow.getValue(b);
/* 330 */         if (value.isLinkedToTable()) {
/* 331 */           paramSession.removeAtCommitStop(value);
/*     */         }
/*     */       } 
/*     */     } 
/* 335 */     if (this.trace.isDebugEnabled()) {
/* 336 */       this.trace.debug("{0} remove {1}", new Object[] { getName(), paramRow });
/*     */     }
/* 338 */     if (this.rowCount == 1L) {
/* 339 */       removeAllRows();
/*     */     } else {
/*     */       try {
/* 342 */         long l = paramRow.getKey();
/* 343 */         PageData pageData = getPage(this.rootPageId, 0);
/* 344 */         pageData.remove(l);
/* 345 */         invalidateRowCount();
/* 346 */         this.rowCount--;
/*     */       } finally {
/* 348 */         this.store.incrementChangeCount();
/*     */       } 
/*     */     } 
/* 351 */     if (this.multiVersion) {
/*     */       
/* 353 */       paramRow.setDeleted(true);
/* 354 */       if (this.delta == null) {
/* 355 */         this.delta = New.hashSet();
/*     */       }
/* 357 */       boolean bool = this.delta.remove(paramRow);
/* 358 */       if (!bool) {
/* 359 */         this.delta.add(paramRow);
/*     */       }
/* 361 */       incrementRowCount(paramSession.getId(), -1);
/*     */     } 
/* 363 */     this.store.logAddOrRemoveRow(paramSession, this.tableData.getId(), paramRow, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 368 */     if (this.trace.isDebugEnabled()) {
/* 369 */       this.trace.debug("{0} remove", new Object[] { this });
/*     */     }
/* 371 */     removeAllRows();
/* 372 */     this.store.free(this.rootPageId);
/* 373 */     this.store.removeMeta(this, paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 378 */     if (this.trace.isDebugEnabled()) {
/* 379 */       this.trace.debug("{0} truncate", new Object[] { this });
/*     */     }
/* 381 */     this.store.logTruncate(paramSession, this.tableData.getId());
/* 382 */     removeAllRows();
/* 383 */     if (this.tableData.getContainsLargeObject() && this.tableData.isPersistData()) {
/*     */       
/* 385 */       paramSession.commit(false);
/* 386 */       this.database.getLobStorage().removeAllForTable(this.table.getId());
/*     */     } 
/* 388 */     if (this.multiVersion) {
/* 389 */       this.sessionRowCount.clear();
/*     */     }
/* 391 */     this.tableData.setRowCount(0L);
/*     */   }
/*     */   
/*     */   private void removeAllRows() {
/*     */     try {
/* 396 */       PageData pageData = getPage(this.rootPageId, 0);
/* 397 */       pageData.freeRecursive();
/* 398 */       pageData = PageDataLeaf.create(this, this.rootPageId, 0);
/* 399 */       this.store.removeFromCache(this.rootPageId);
/* 400 */       this.store.update(pageData);
/* 401 */       this.rowCount = 0L;
/* 402 */       this.lastKey = 0L;
/*     */     } finally {
/* 404 */       this.store.incrementChangeCount();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/* 410 */     throw DbException.getUnsupportedException("PAGE");
/*     */   }
/*     */ 
/*     */   
/*     */   public Row getRow(Session paramSession, long paramLong) {
/* 415 */     return getRowWithKey(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Row getRowWithKey(long paramLong) {
/* 425 */     PageData pageData = getPage(this.rootPageId, 0);
/* 426 */     return pageData.getRowWithKey(paramLong);
/*     */   }
/*     */   
/*     */   PageStore getPageStore() {
/* 430 */     return this.store;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 435 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 440 */     if (this.multiVersion) {
/* 441 */       Integer integer = this.sessionRowCount.get(Integer.valueOf(paramSession.getId()));
/* 442 */       long l = (integer == null) ? 0L : integer.intValue();
/* 443 */       l += this.rowCount;
/* 444 */       l -= this.rowCountDiff;
/* 445 */       return l;
/*     */     } 
/* 447 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 452 */     PageData pageData = getPage(this.rootPageId, 0);
/* 453 */     return pageData.getDiskSpaceUsed();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 458 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumnIndex(Column paramColumn) {
/* 464 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {
/* 469 */     if (this.trace.isDebugEnabled()) {
/* 470 */       this.trace.debug("{0} close", new Object[] { this });
/*     */     }
/* 472 */     if (this.delta != null) {
/* 473 */       this.delta.clear();
/*     */     }
/* 475 */     this.rowCountDiff = 0;
/* 476 */     if (this.sessionRowCount != null) {
/* 477 */       this.sessionRowCount.clear();
/*     */     }
/*     */ 
/*     */     
/* 481 */     writeRowCount();
/*     */   }
/*     */   
/*     */   Iterator<Row> getDelta() {
/* 485 */     if (this.delta == null) {
/* 486 */       List<?> list = Collections.emptyList();
/* 487 */       return (Iterator)list.iterator();
/*     */     } 
/* 489 */     return this.delta.iterator();
/*     */   }
/*     */   
/*     */   private void incrementRowCount(int paramInt1, int paramInt2) {
/* 493 */     if (this.multiVersion) {
/* 494 */       Integer integer1 = Integer.valueOf(paramInt1);
/* 495 */       Integer integer2 = this.sessionRowCount.get(integer1);
/* 496 */       byte b = (integer2 == null) ? 0 : integer2.intValue();
/* 497 */       this.sessionRowCount.put(integer1, Integer.valueOf(b + paramInt2));
/* 498 */       this.rowCountDiff += paramInt2;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void commit(int paramInt, Row paramRow) {
/* 504 */     if (this.multiVersion) {
/* 505 */       if (this.delta != null) {
/* 506 */         this.delta.remove(paramRow);
/*     */       }
/* 508 */       incrementRowCount(paramRow.getSessionId(), (paramInt == 1) ? 1 : -1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRootPageId(Session paramSession, int paramInt) {
/* 520 */     this.store.removeMeta(this, paramSession);
/* 521 */     this.rootPageId = paramInt;
/* 522 */     this.store.addMeta(this, paramSession);
/* 523 */     this.store.addIndex(this);
/*     */   }
/*     */   
/*     */   public void setMainIndexColumn(int paramInt) {
/* 527 */     this.mainIndexColumn = paramInt;
/*     */   }
/*     */   
/*     */   public int getMainIndexColumn() {
/* 531 */     return this.mainIndexColumn;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 536 */     return getName();
/*     */   }
/*     */   
/*     */   private void invalidateRowCount() {
/* 540 */     PageData pageData = getPage(this.rootPageId, 0);
/* 541 */     pageData.setRowCountStored(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeRowCount() {
/* 546 */     if (SysProperties.MODIFY_ON_WRITE && this.rootPageId == 0) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 551 */       PageData pageData = getPage(this.rootPageId, 0);
/* 552 */       pageData.setRowCountStored(MathUtils.convertLongToInt(this.rowCount));
/*     */     } finally {
/* 554 */       this.store.incrementChangeCount();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 560 */     return this.table.getSQL() + ".tableScan";
/*     */   }
/*     */   
/*     */   int getMemoryPerPage() {
/* 564 */     return this.memoryPerPage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void memoryChange(int paramInt) {
/* 574 */     if (this.memoryCount < 64) {
/* 575 */       this.memoryPerPage += (paramInt - this.memoryPerPage) / ++this.memoryCount;
/*     */     } else {
/* 577 */       this.memoryPerPage += ((paramInt > this.memoryPerPage) ? 1 : -1) + (paramInt - this.memoryPerPage) / 64;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRowIdIndex() {
/* 584 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageDataIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */