/*    */ package org.h2.index;
/*    */ 
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PageBtreeCursor
/*    */   implements Cursor
/*    */ {
/*    */   private final Session session;
/*    */   private final PageBtreeIndex index;
/*    */   private final SearchRow last;
/*    */   private PageBtreeLeaf current;
/*    */   private int i;
/*    */   private SearchRow currentSearchRow;
/*    */   private Row currentRow;
/*    */   
/*    */   PageBtreeCursor(Session paramSession, PageBtreeIndex paramPageBtreeIndex, SearchRow paramSearchRow) {
/* 26 */     this.session = paramSession;
/* 27 */     this.index = paramPageBtreeIndex;
/* 28 */     this.last = paramSearchRow;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void setCurrent(PageBtreeLeaf paramPageBtreeLeaf, int paramInt) {
/* 38 */     this.current = paramPageBtreeLeaf;
/* 39 */     this.i = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 44 */     if (this.currentRow == null && this.currentSearchRow != null) {
/* 45 */       this.currentRow = this.index.getRow(this.session, this.currentSearchRow.getKey());
/*    */     }
/* 47 */     return this.currentRow;
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 52 */     return this.currentSearchRow;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/* 57 */     if (this.current == null) {
/* 58 */       return false;
/*    */     }
/* 60 */     if (this.i >= this.current.getEntryCount()) {
/* 61 */       this.current.nextPage(this);
/* 62 */       if (this.current == null) {
/* 63 */         return false;
/*    */       }
/*    */     } 
/* 66 */     this.currentSearchRow = this.current.getRow(this.i);
/* 67 */     this.currentRow = null;
/* 68 */     if (this.last != null && this.index.compareRows(this.currentSearchRow, this.last) > 0) {
/* 69 */       this.currentSearchRow = null;
/* 70 */       return false;
/*    */     } 
/* 72 */     this.i++;
/* 73 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 78 */     if (this.current == null) {
/* 79 */       return false;
/*    */     }
/* 81 */     if (this.i < 0) {
/* 82 */       this.current.previousPage(this);
/* 83 */       if (this.current == null) {
/* 84 */         return false;
/*    */       }
/*    */     } 
/* 87 */     this.currentSearchRow = this.current.getRow(this.i);
/* 88 */     this.currentRow = null;
/* 89 */     this.i--;
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageBtreeCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */