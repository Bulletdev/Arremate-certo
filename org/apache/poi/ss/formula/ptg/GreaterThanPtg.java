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
/*    */ public final class GreaterThanPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 13;
/*    */   private static final String GREATERTHAN = ">";
/* 29 */   public static final ValueOperatorPtg instance = new GreaterThanPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 36 */     return 13;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getNumberOfOperands() {
/* 44 */     return 2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 54 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 56 */     stringBuffer.append(paramArrayOfString[0]);
/* 57 */     stringBuffer.append(">");
/* 58 */     stringBuffer.append(paramArrayOfString[1]);
/* 59 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\GreaterThanPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */