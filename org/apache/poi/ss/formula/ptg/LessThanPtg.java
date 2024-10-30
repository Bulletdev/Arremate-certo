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
/*    */ public final class LessThanPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 9;
/*    */   private static final String LESSTHAN = "<";
/* 33 */   public static final ValueOperatorPtg instance = new LessThanPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 40 */     return 9;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getNumberOfOperands() {
/* 48 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 58 */     StringBuffer stringBuffer = new StringBuffer();
/* 59 */     stringBuffer.append(paramArrayOfString[0]);
/* 60 */     stringBuffer.append("<");
/* 61 */     stringBuffer.append(paramArrayOfString[1]);
/* 62 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\LessThanPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */