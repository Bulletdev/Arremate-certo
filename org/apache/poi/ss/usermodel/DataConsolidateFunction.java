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
/*    */ public enum DataConsolidateFunction
/*    */ {
/* 29 */   AVERAGE(1, "Average"),
/* 30 */   COUNT(2, "Count"),
/* 31 */   COUNT_NUMS(3, "Count"),
/* 32 */   MAX(4, "Max"),
/* 33 */   MIN(5, "Min"),
/* 34 */   PRODUCT(6, "Product"),
/* 35 */   STD_DEV(7, "StdDev"),
/* 36 */   STD_DEVP(8, "StdDevp"),
/* 37 */   SUM(9, "Sum"),
/* 38 */   VAR(10, "Var"),
/* 39 */   VARP(11, "Varp");
/*    */   
/*    */   private final int value;
/*    */   private final String name;
/*    */   
/*    */   DataConsolidateFunction(int paramInt1, String paramString1) {
/* 45 */     this.value = paramInt1;
/* 46 */     this.name = paramString1;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 50 */     return this.name;
/*    */   }
/*    */   
/*    */   public int getValue() {
/* 54 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\DataConsolidateFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */