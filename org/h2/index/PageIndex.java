/*    */ package org.h2.index;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class PageIndex
/*    */   extends BaseIndex
/*    */ {
/*    */   protected int rootPageId;
/*    */   private boolean sortedInsertMode;
/*    */   
/*    */   public int getRootPageId() {
/* 27 */     return this.rootPageId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void writeRowCount();
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSortedInsertMode(boolean paramBoolean) {
/* 37 */     this.sortedInsertMode = paramBoolean;
/*    */   }
/*    */   
/*    */   boolean isSortedInsertMode() {
/* 41 */     return this.sortedInsertMode;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */