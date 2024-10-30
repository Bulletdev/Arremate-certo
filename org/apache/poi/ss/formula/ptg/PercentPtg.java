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
/*    */ public final class PercentPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final int SIZE = 1;
/*    */   public static final byte sid = 20;
/*    */   private static final String PERCENT = "%";
/* 31 */   public static final ValueOperatorPtg instance = new PercentPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 38 */     return 20;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 42 */     return 1;
/*    */   }
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 46 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 48 */     stringBuffer.append(paramArrayOfString[0]);
/* 49 */     stringBuffer.append("%");
/* 50 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\PercentPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */