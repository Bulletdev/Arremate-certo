/*     */ package org.h2.index;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.result.Row;
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
/*     */ abstract class PageData
/*     */   extends Page
/*     */ {
/*     */   static final int START_PARENT = 3;
/*     */   static final int ROOT = 0;
/*     */   static final int UNKNOWN_ROWCOUNT = -1;
/*     */   protected final PageDataIndex index;
/*     */   protected int parentPageId;
/*     */   protected final Data data;
/*     */   protected int entryCount;
/*     */   protected long[] keys;
/*     */   protected boolean written;
/*     */   private final int memoryEstimated;
/*     */   
/*     */   PageData(PageDataIndex paramPageDataIndex, int paramInt, Data paramData) {
/*  70 */     this.index = paramPageDataIndex;
/*  71 */     this.data = paramData;
/*  72 */     setPos(paramInt);
/*  73 */     this.memoryEstimated = paramPageDataIndex.getMemoryPerPage();
/*     */   }
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
/*     */   abstract void setRowCountStored(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract long getDiskSpaceUsed();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int find(long paramLong) {
/* 104 */     int i = 0, j = this.entryCount;
/* 105 */     while (i < j) {
/* 106 */       int k = i + j >>> 1;
/* 107 */       long l = this.keys[k];
/* 108 */       if (l == paramLong)
/* 109 */         return k; 
/* 110 */       if (l > paramLong) {
/* 111 */         j = k; continue;
/*     */       } 
/* 113 */       i = k + 1;
/*     */     } 
/*     */     
/* 116 */     return i;
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
/*     */   abstract int addRowTry(Row paramRow);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract Cursor find(Session paramSession, long paramLong1, long paramLong2, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long getKey(int paramInt) {
/* 147 */     return this.keys[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract PageData split(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setPageId(int paramInt) {
/* 164 */     int i = getPos();
/* 165 */     this.index.getPageStore().removeFromCache(getPos());
/* 166 */     setPos(paramInt);
/* 167 */     this.index.getPageStore().logUndo(this, null);
/* 168 */     remapChildren(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract long getLastKey();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract PageDataLeaf getFirstLeaf();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setParentPageId(int paramInt) {
/* 191 */     this.index.getPageStore().logUndo(this, this.data);
/* 192 */     this.parentPageId = paramInt;
/* 193 */     if (this.written) {
/* 194 */       this.changeCount = this.index.getPageStore().getChangeCount();
/* 195 */       this.data.setInt(3, this.parentPageId);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void remapChildren(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract boolean remove(long paramLong);
/*     */ 
/*     */ 
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
/*     */ 
/*     */   
/*     */   abstract Row getRowWithKey(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 238 */     return this.memoryEstimated;
/*     */   }
/*     */   
/*     */   int getParentPageId() {
/* 242 */     return this.parentPageId;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canRemove() {
/* 247 */     if (this.changeCount >= this.index.getPageStore().getChangeCount()) {
/* 248 */       return false;
/*     */     }
/* 250 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */