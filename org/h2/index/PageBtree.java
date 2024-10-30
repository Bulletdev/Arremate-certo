/*     */ package org.h2.index;
/*     */ 
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.Page;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PageBtree
/*     */   extends Page
/*     */ {
/*     */   static final int ROOT = 0;
/*     */   static final int UNKNOWN_ROWCOUNT = -1;
/*     */   protected final PageBtreeIndex index;
/*     */   protected int parentPageId;
/*     */   protected final Data data;
/*     */   protected int[] offsets;
/*     */   protected int entryCount;
/*     */   protected SearchRow[] rows;
/*     */   protected int start;
/*     */   protected boolean onlyPosition;
/*     */   protected boolean written;
/*     */   private final int memoryEstimated;
/*     */   
/*     */   PageBtree(PageBtreeIndex paramPageBtreeIndex, int paramInt, Data paramData) {
/*  78 */     this.index = paramPageBtreeIndex;
/*  79 */     this.data = paramData;
/*  80 */     setPos(paramInt);
/*  81 */     this.memoryEstimated = paramPageBtreeIndex.getMemoryPerPage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract int getRowCount();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void setRowCountStored(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int find(SearchRow paramSearchRow, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 108 */     if (paramSearchRow == null) {
/* 109 */       return 0;
/*     */     }
/* 111 */     int i = 0, j = this.entryCount;
/* 112 */     int k = 1;
/* 113 */     while (i < j) {
/* 114 */       int m = i + j >>> 1;
/* 115 */       SearchRow searchRow = getRow(m);
/* 116 */       k = this.index.compareRows(searchRow, paramSearchRow);
/* 117 */       if (k == 0) {
/* 118 */         if (paramBoolean2 && this.index.indexType.isUnique() && 
/* 119 */           !this.index.containsNullAndAllowMultipleNull(paramSearchRow)) {
/* 120 */           throw this.index.getDuplicateKeyException(paramSearchRow.toString());
/*     */         }
/*     */         
/* 123 */         if (paramBoolean3) {
/* 124 */           k = this.index.compareKeys(searchRow, paramSearchRow);
/* 125 */           if (k == 0) {
/* 126 */             return m;
/*     */           }
/*     */         } 
/*     */       } 
/* 130 */       if (k > 0 || (!paramBoolean1 && k == 0)) {
/* 131 */         j = m; continue;
/*     */       } 
/* 133 */       i = m + 1;
/*     */     } 
/*     */     
/* 136 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract int addRowTry(SearchRow paramSearchRow);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void find(PageBtreeCursor paramPageBtreeCursor, SearchRow paramSearchRow, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void last(PageBtreeCursor paramPageBtreeCursor);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SearchRow getRow(int paramInt) {
/* 171 */     SearchRow searchRow = this.rows[paramInt];
/* 172 */     if (searchRow == null) {
/* 173 */       searchRow = this.index.readRow(this.data, this.offsets[paramInt], this.onlyPosition, true);
/* 174 */       memoryChange();
/* 175 */       this.rows[paramInt] = searchRow;
/* 176 */     } else if (!this.index.hasData(searchRow)) {
/* 177 */       searchRow = this.index.readRow(searchRow.getKey());
/* 178 */       memoryChange();
/* 179 */       this.rows[paramInt] = searchRow;
/*     */     } 
/* 181 */     return searchRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void memoryChange() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract PageBtree split(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setPageId(int paramInt) {
/* 206 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 207 */     this.written = false;
/* 208 */     this.index.getPageStore().removeFromCache(getPos());
/* 209 */     setPos(paramInt);
/* 210 */     this.index.getPageStore().logUndo(this, null);
/* 211 */     remapChildren();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract PageBtreeLeaf getFirstLeaf();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract PageBtreeLeaf getLastLeaf();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setParentPageId(int paramInt) {
/* 234 */     this.index.getPageStore().logUndo(this, this.data);
/* 235 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 236 */     this.written = false;
/* 237 */     this.parentPageId = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void remapChildren();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract SearchRow remove(SearchRow paramSearchRow);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void freeRecursive();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void readAllRows() {
/* 264 */     for (byte b = 0; b < this.entryCount; b++) {
/* 265 */       SearchRow searchRow = this.rows[b];
/* 266 */       if (searchRow == null) {
/* 267 */         searchRow = this.index.readRow(this.data, this.offsets[b], this.onlyPosition, false);
/* 268 */         this.rows[b] = searchRow;
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
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 284 */     return this.memoryEstimated;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canRemove() {
/* 289 */     if (this.changeCount >= this.index.getPageStore().getChangeCount()) {
/* 290 */       return false;
/*     */     }
/* 292 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageBtree.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */