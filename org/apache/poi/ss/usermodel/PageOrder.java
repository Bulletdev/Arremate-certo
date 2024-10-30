/*    */ package org.apache.poi.ss.usermodel;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PageOrder
/*    */ {
/* 30 */   DOWN_THEN_OVER(1),
/*    */ 
/*    */ 
/*    */   
/* 34 */   OVER_THEN_DOWN(2);
/*    */   
/*    */   private int order;
/*    */   
/*    */   private static PageOrder[] _table;
/*    */   
/*    */   PageOrder(int paramInt1) {
/* 41 */     this.order = paramInt1;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 45 */     return this.order;
/*    */   }
/*    */   
/*    */   static {
/* 49 */     _table = new PageOrder[3];
/*    */     
/* 51 */     for (PageOrder pageOrder : values())
/* 52 */       _table[pageOrder.getValue()] = pageOrder; 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PageOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */