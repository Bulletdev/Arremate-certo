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
/*    */ public final class UnaryPlusPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 18;
/*    */   private static final String ADD = "+";
/* 30 */   public static final ValueOperatorPtg instance = new UnaryPlusPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 37 */     return 18;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 41 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 46 */     StringBuffer stringBuffer = new StringBuffer();
/* 47 */     stringBuffer.append("+");
/* 48 */     stringBuffer.append(paramArrayOfString[0]);
/* 49 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\UnaryPlusPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */