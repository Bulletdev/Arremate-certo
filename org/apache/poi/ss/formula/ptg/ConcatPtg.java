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
/*    */ public final class ConcatPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 8;
/*    */   private static final String CONCAT = "&";
/* 30 */   public static final ValueOperatorPtg instance = new ConcatPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 37 */     return 8;
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
/* 48 */     stringBuffer.append("&");
/* 49 */     stringBuffer.append(paramArrayOfString[1]);
/* 50 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ConcatPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */