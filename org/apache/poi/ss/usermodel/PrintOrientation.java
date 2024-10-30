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
/*    */ public enum PrintOrientation
/*    */ {
/* 30 */   DEFAULT(1),
/*    */ 
/*    */ 
/*    */   
/* 34 */   PORTRAIT(2),
/*    */ 
/*    */ 
/*    */   
/* 38 */   LANDSCAPE(3);
/*    */   
/*    */   private int orientation;
/*    */   private static PrintOrientation[] _table;
/*    */   
/*    */   PrintOrientation(int paramInt1) {
/* 44 */     this.orientation = paramInt1;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 49 */     return this.orientation;
/*    */   }
/*    */   
/*    */   static {
/* 53 */     _table = new PrintOrientation[4];
/*    */     
/* 55 */     for (PrintOrientation printOrientation : values())
/* 56 */       _table[printOrientation.getValue()] = printOrientation; 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\PrintOrientation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */