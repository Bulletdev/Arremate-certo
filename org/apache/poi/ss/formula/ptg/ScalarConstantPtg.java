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
/*    */ public abstract class ScalarConstantPtg
/*    */   extends Ptg
/*    */ {
/*    */   public final boolean isBaseToken() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public final byte getDefaultOperandClass() {
/* 32 */     return 32;
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 36 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 37 */     stringBuffer.append(getClass().getName()).append(" [");
/* 38 */     stringBuffer.append(toFormulaString());
/* 39 */     stringBuffer.append("]");
/* 40 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ScalarConstantPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */