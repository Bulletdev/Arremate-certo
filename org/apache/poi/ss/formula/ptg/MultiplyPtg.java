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
/*    */ public final class MultiplyPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 5;
/* 28 */   public static final ValueOperatorPtg instance = new MultiplyPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 35 */     return 5;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 39 */     return 2;
/*    */   }
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 43 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 45 */     stringBuffer.append(paramArrayOfString[0]);
/* 46 */     stringBuffer.append("*");
/* 47 */     stringBuffer.append(paramArrayOfString[1]);
/* 48 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\MultiplyPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */