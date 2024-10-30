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
/*    */ public final class GreaterEqualPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final int SIZE = 1;
/*    */   public static final byte sid = 12;
/* 30 */   public static final ValueOperatorPtg instance = new GreaterEqualPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 37 */     return 12;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 41 */     return 2;
/*    */   }
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 45 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 47 */     stringBuffer.append(paramArrayOfString[0]);
/*    */     
/* 49 */     stringBuffer.append(">=");
/* 50 */     stringBuffer.append(paramArrayOfString[1]);
/*    */     
/* 52 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\GreaterEqualPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */