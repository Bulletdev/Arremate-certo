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
/*    */ public enum PrintCellComments
/*    */ {
/* 30 */   NONE(1),
/*    */ 
/*    */ 
/*    */   
/* 34 */   AS_DISPLAYED(2),
/*    */ 
/*    */ 
/*    */   
/* 38 */   AT_END(3);
/*    */   
/*    */   private int comments;
/*    */   private static PrintCellComments[] _table;
/*    */   
/*    */   PrintCellComments(int paramInt1) {
/* 44 */     this.comments = paramInt1;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 48 */     return this.comments;
/*    */   }
/*    */   static {
/* 51 */     _table = new PrintCellComments[4];
/*    */     
/* 53 */     for (PrintCellComments printCellComments : values())
/* 54 */       _table[printCellComments.getValue()] = printCellComments; 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PrintCellComments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */