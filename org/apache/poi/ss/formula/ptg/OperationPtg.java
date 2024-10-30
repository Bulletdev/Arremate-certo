/*    */ package org.apache.poi.ss.formula.ptg;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class OperationPtg
/*    */   extends Ptg
/*    */ {
/*    */   public static final int TYPE_UNARY = 0;
/*    */   public static final int TYPE_BINARY = 1;
/*    */   public static final int TYPE_FUNCTION = 2;
/*    */   
/*    */   public abstract String toFormulaString(String[] paramArrayOfString);
/*    */   
/*    */   public abstract int getNumberOfOperands();
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 43 */     return 32;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\OperationPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */