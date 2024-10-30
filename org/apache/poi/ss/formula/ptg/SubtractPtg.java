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
/*    */ public final class SubtractPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 4;
/* 28 */   public static final ValueOperatorPtg instance = new SubtractPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 35 */     return 4;
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
/* 46 */     stringBuffer.append("-");
/* 47 */     stringBuffer.append(paramArrayOfString[1]);
/* 48 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\SubtractPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */