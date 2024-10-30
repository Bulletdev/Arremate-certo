/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.Page;
/*     */ import org.h2.store.PageStore;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.IndexColumn;
/*     */ import org.h2.table.RegularTable;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.MathUtils;
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
/*     */ 
/*     */ 
/*     */ public class PageBtreeIndex
/*     */   extends PageIndex
/*     */ {
/*     */   private static int memoryChangeRequired;
/*     */   private final PageStore store;
/*     */   private final RegularTable tableData;
/*     */   private final boolean needRebuild;
/*     */   private long rowCount;
/*     */   private int memoryPerPage;
/*     */   private int memoryCount;
/*     */   
/*     */   public PageBtreeIndex(RegularTable paramRegularTable, int paramInt, String paramString, IndexColumn[] paramArrayOfIndexColumn, IndexType paramIndexType, boolean paramBoolean, Session paramSession) {
/*  46 */     initBaseIndex((Table)paramRegularTable, paramInt, paramString, paramArrayOfIndexColumn, paramIndexType);
/*  47 */     if (!this.database.isStarting() && paramBoolean) {
/*  48 */       checkIndexColumnTypes(paramArrayOfIndexColumn);
/*     */     }
/*     */ 
/*     */     
/*  52 */     this.tableData = paramRegularTable;
/*  53 */     if (!this.database.isPersistent() || paramInt < 0) {
/*  54 */       throw DbException.throwInternalError("" + paramString);
/*     */     }
/*  56 */     this.store = this.database.getPageStore();
/*  57 */     this.store.addIndex(this);
/*  58 */     if (paramBoolean) {
/*     */       
/*  60 */       this.rootPageId = this.store.allocatePage();
/*     */ 
/*     */ 
/*     */       
/*  64 */       this.store.addMeta(this, paramSession);
/*  65 */       PageBtreeLeaf pageBtreeLeaf = PageBtreeLeaf.create(this, this.rootPageId, 0);
/*  66 */       this.store.logUndo(pageBtreeLeaf, null);
/*  67 */       this.store.update(pageBtreeLeaf);
/*     */     } else {
/*  69 */       this.rootPageId = this.store.getRootPageId(paramInt);
/*  70 */       PageBtree pageBtree = getPage(this.rootPageId);
/*  71 */       this.rowCount = pageBtree.getRowCount();
/*     */     } 
/*  73 */     this.needRebuild = (paramBoolean || (this.rowCount == 0L && this.store.isRecoveryRunning()));
/*  74 */     if (this.trace.isDebugEnabled()) {
/*  75 */       this.trace.debug("opened {0} rows: {1}", new Object[] { getName(), Long.valueOf(this.rowCount) });
/*     */     }
/*  77 */     this.memoryPerPage = 184 + this.store.getPageSize() >> 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(Session paramSession, Row paramRow) {
/*  82 */     if (this.trace.isDebugEnabled()) {
/*  83 */       this.trace.debug("{0} add {1}", new Object[] { getName(), paramRow });
/*     */     }
/*     */     
/*  86 */     SearchRow searchRow = getSearchRow(paramRow);
/*     */     try {
/*  88 */       addRow(searchRow);
/*     */     } finally {
/*  90 */       this.store.incrementChangeCount();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addRow(SearchRow paramSearchRow) {
/*     */     while (true) {
/*  96 */       PageBtree pageBtree1 = getPage(this.rootPageId);
/*  97 */       int i = pageBtree1.addRowTry(paramSearchRow);
/*  98 */       if (i == -1) {
/*     */         break;
/*     */       }
/* 101 */       if (this.trace.isDebugEnabled()) {
/* 102 */         this.trace.debug("split {0}", new Object[] { Integer.valueOf(i) });
/*     */       }
/* 104 */       SearchRow searchRow = pageBtree1.getRow(i - 1);
/* 105 */       this.store.logUndo(pageBtree1, pageBtree1.data);
/* 106 */       PageBtree pageBtree2 = pageBtree1;
/* 107 */       PageBtree pageBtree3 = pageBtree1.split(i);
/* 108 */       this.store.logUndo(pageBtree3, null);
/* 109 */       int j = this.store.allocatePage();
/* 110 */       pageBtree2.setPageId(j);
/* 111 */       pageBtree2.setParentPageId(this.rootPageId);
/* 112 */       pageBtree3.setParentPageId(this.rootPageId);
/* 113 */       PageBtreeNode pageBtreeNode = PageBtreeNode.create(this, this.rootPageId, 0);
/*     */       
/* 115 */       this.store.logUndo(pageBtreeNode, null);
/* 116 */       pageBtreeNode.init(pageBtree2, searchRow, pageBtree3);
/* 117 */       this.store.update(pageBtree2);
/* 118 */       this.store.update(pageBtree3);
/* 119 */       this.store.update(pageBtreeNode);
/* 120 */       pageBtree1 = pageBtreeNode;
/*     */     } 
/* 122 */     invalidateRowCount();
/* 123 */     this.rowCount++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SearchRow getSearchRow(Row paramRow) {
/* 133 */     SearchRow searchRow = this.table.getTemplateSimpleRow((this.columns.length == 1));
/* 134 */     searchRow.setKeyAndVersion((SearchRow)paramRow);
/* 135 */     for (Column column : this.columns) {
/* 136 */       int i = column.getColumnId();
/* 137 */       searchRow.setValue(i, paramRow.getValue(i));
/*     */     } 
/* 139 */     return searchRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PageBtree getPage(int paramInt) {
/* 149 */     Page page = this.store.getPage(paramInt);
/* 150 */     if (page == null) {
/* 151 */       PageBtreeLeaf pageBtreeLeaf = PageBtreeLeaf.create(this, paramInt, 0);
/*     */       
/* 153 */       this.store.logUndo(pageBtreeLeaf, null);
/* 154 */       this.store.update(pageBtreeLeaf);
/* 155 */       return pageBtreeLeaf;
/* 156 */     }  if (!(page instanceof PageBtree)) {
/* 157 */       throw DbException.get(90030, "" + page);
/*     */     }
/* 159 */     return (PageBtree)page;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGetFirstOrLast() {
/* 164 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findNext(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 169 */     return find(paramSession, paramSearchRow1, true, paramSearchRow2);
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor find(Session paramSession, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/* 174 */     return find(paramSession, paramSearchRow1, false, paramSearchRow2);
/*     */   }
/*     */ 
/*     */   
/*     */   private Cursor find(Session paramSession, SearchRow paramSearchRow1, boolean paramBoolean, SearchRow paramSearchRow2) {
/* 179 */     if (SysProperties.CHECK && this.store == null) {
/* 180 */       throw DbException.get(90007);
/*     */     }
/* 182 */     PageBtree pageBtree = getPage(this.rootPageId);
/* 183 */     PageBtreeCursor pageBtreeCursor = new PageBtreeCursor(paramSession, this, paramSearchRow2);
/* 184 */     pageBtree.find(pageBtreeCursor, paramSearchRow1, paramBoolean);
/* 185 */     return pageBtreeCursor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Cursor findFirstOrLast(Session paramSession, boolean paramBoolean) {
/* 190 */     if (paramBoolean) {
/*     */       
/* 192 */       Cursor cursor = find(paramSession, (SearchRow)null, false, (SearchRow)null);
/* 193 */       while (cursor.next()) {
/* 194 */         SearchRow searchRow = cursor.getSearchRow();
/* 195 */         Value value = searchRow.getValue(this.columnIds[0]);
/* 196 */         if (value != ValueNull.INSTANCE) {
/* 197 */           return cursor;
/*     */         }
/*     */       } 
/* 200 */       return cursor;
/*     */     } 
/* 202 */     PageBtree pageBtree = getPage(this.rootPageId);
/* 203 */     PageBtreeCursor pageBtreeCursor = new PageBtreeCursor(paramSession, this, null);
/* 204 */     pageBtree.last(pageBtreeCursor);
/* 205 */     pageBtreeCursor.previous();
/*     */     
/*     */     do {
/* 208 */       SearchRow searchRow = pageBtreeCursor.getSearchRow();
/* 209 */       if (searchRow == null) {
/*     */         break;
/*     */       }
/* 212 */       Value value = searchRow.getValue(this.columnIds[0]);
/* 213 */       if (value != ValueNull.INSTANCE) {
/* 214 */         return pageBtreeCursor;
/*     */       }
/* 216 */     } while (pageBtreeCursor.previous());
/* 217 */     return pageBtreeCursor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCost(Session paramSession, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder, HashSet<Column> paramHashSet) {
/* 224 */     return (10L * getCostRangeIndex(paramArrayOfint, this.tableData.getRowCount(paramSession), paramArrayOfTableFilter, paramInt, paramSortOrder, false, paramHashSet));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needRebuild() {
/* 230 */     return this.needRebuild;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession, Row paramRow) {
/* 235 */     if (this.trace.isDebugEnabled()) {
/* 236 */       this.trace.debug("{0} remove {1}", new Object[] { getName(), paramRow });
/*     */     }
/*     */ 
/*     */     
/* 240 */     if (this.rowCount == 1L) {
/* 241 */       removeAllRows();
/*     */     } else {
/*     */       try {
/* 244 */         PageBtree pageBtree = getPage(this.rootPageId);
/* 245 */         pageBtree.remove((SearchRow)paramRow);
/* 246 */         invalidateRowCount();
/* 247 */         this.rowCount--;
/*     */       } finally {
/* 249 */         this.store.incrementChangeCount();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(Session paramSession) {
/* 256 */     if (this.trace.isDebugEnabled()) {
/* 257 */       this.trace.debug("remove");
/*     */     }
/* 259 */     removeAllRows();
/* 260 */     this.store.free(this.rootPageId);
/* 261 */     this.store.removeMeta(this, paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(Session paramSession) {
/* 266 */     if (this.trace.isDebugEnabled()) {
/* 267 */       this.trace.debug("truncate");
/*     */     }
/* 269 */     removeAllRows();
/* 270 */     if (this.tableData.getContainsLargeObject()) {
/* 271 */       this.database.getLobStorage().removeAllForTable(this.table.getId());
/*     */     }
/* 273 */     this.tableData.setRowCount(0L);
/*     */   }
/*     */   
/*     */   private void removeAllRows() {
/*     */     try {
/* 278 */       PageBtree pageBtree = getPage(this.rootPageId);
/* 279 */       pageBtree.freeRecursive();
/* 280 */       pageBtree = PageBtreeLeaf.create(this, this.rootPageId, 0);
/* 281 */       this.store.removeFromCache(this.rootPageId);
/* 282 */       this.store.update(pageBtree);
/* 283 */       this.rowCount = 0L;
/*     */     } finally {
/* 285 */       this.store.incrementChangeCount();
/*     */     } 
/*     */   }
/*     */ 
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
/*     */   
/*     */   public Row getRow(Session paramSession, long paramLong) {
/* 303 */     return this.tableData.getRow(paramSession, paramLong);
/*     */   }
/*     */   
/*     */   PageStore getPageStore() {
/* 307 */     return this.store;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCountApproximation() {
/* 312 */     return this.tableData.getRowCountApproximation();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getDiskSpaceUsed() {
/* 317 */     return this.tableData.getDiskSpaceUsed();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRowCount(Session paramSession) {
/* 322 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close(Session paramSession) {
/* 327 */     if (this.trace.isDebugEnabled()) {
/* 328 */       this.trace.debug("close");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 333 */       writeRowCount();
/*     */     } finally {
/* 335 */       this.store.incrementChangeCount();
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
/*     */ 
/*     */ 
/*     */   
/*     */   SearchRow readRow(Data paramData, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/* 350 */     synchronized (paramData) {
/* 351 */       paramData.setPos(paramInt);
/* 352 */       long l = paramData.readVarLong();
/* 353 */       if (paramBoolean1) {
/* 354 */         if (paramBoolean2) {
/* 355 */           return (SearchRow)this.tableData.getRow(null, l);
/*     */         }
/* 357 */         SearchRow searchRow1 = this.table.getTemplateSimpleRow(true);
/* 358 */         searchRow1.setKey(l);
/* 359 */         return searchRow1;
/*     */       } 
/* 361 */       SearchRow searchRow = this.table.getTemplateSimpleRow((this.columns.length == 1));
/* 362 */       searchRow.setKey(l);
/* 363 */       for (Column column : this.columns) {
/* 364 */         int i = column.getColumnId();
/* 365 */         searchRow.setValue(i, paramData.readValue());
/*     */       } 
/* 367 */       return searchRow;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SearchRow readRow(long paramLong) {
/* 378 */     return (SearchRow)this.tableData.getRow(null, paramLong);
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
/*     */   void writeRow(Data paramData, int paramInt, SearchRow paramSearchRow, boolean paramBoolean) {
/* 390 */     paramData.setPos(paramInt);
/* 391 */     paramData.writeVarLong(paramSearchRow.getKey());
/* 392 */     if (!paramBoolean) {
/* 393 */       for (Column column : this.columns) {
/* 394 */         int i = column.getColumnId();
/* 395 */         paramData.writeValue(paramSearchRow.getValue(i));
/*     */       } 
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
/*     */   
/*     */   int getRowSize(Data paramData, SearchRow paramSearchRow, boolean paramBoolean) {
/* 409 */     int i = Data.getVarLongLen(paramSearchRow.getKey());
/* 410 */     if (!paramBoolean) {
/* 411 */       for (Column column : this.columns) {
/* 412 */         Value value = paramSearchRow.getValue(column.getColumnId());
/* 413 */         i += paramData.getValueLen(value);
/*     */       } 
/*     */     }
/* 416 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canFindNext() {
/* 421 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setRootPageId(Session paramSession, int paramInt) {
/* 431 */     this.store.removeMeta(this, paramSession);
/* 432 */     this.rootPageId = paramInt;
/* 433 */     this.store.addMeta(this, paramSession);
/* 434 */     this.store.addIndex(this);
/*     */   }
/*     */   
/*     */   private void invalidateRowCount() {
/* 438 */     PageBtree pageBtree = getPage(this.rootPageId);
/* 439 */     pageBtree.setRowCountStored(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeRowCount() {
/* 444 */     if (SysProperties.MODIFY_ON_WRITE && this.rootPageId == 0) {
/*     */       return;
/*     */     }
/*     */     
/* 448 */     PageBtree pageBtree = getPage(this.rootPageId);
/* 449 */     pageBtree.setRowCountStored(MathUtils.convertLongToInt(this.rowCount));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean hasData(SearchRow paramSearchRow) {
/* 459 */     return (paramSearchRow.getValue(this.columns[0].getColumnId()) != null);
/*     */   }
/*     */   
/*     */   int getMemoryPerPage() {
/* 463 */     return this.memoryPerPage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void memoryChange(int paramInt) {
/* 473 */     if (this.memoryCount < 64) {
/* 474 */       this.memoryPerPage += (paramInt - this.memoryPerPage) / ++this.memoryCount;
/*     */     } else {
/* 476 */       this.memoryPerPage += ((paramInt > this.memoryPerPage) ? 1 : -1) + (paramInt - this.memoryPerPage) / 64;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isMemoryChangeRequired() {
/* 487 */     if (memoryChangeRequired-- <= 0) {
/* 488 */       memoryChangeRequired = 10;
/* 489 */       return true;
/*     */     } 
/* 491 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageBtreeIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */