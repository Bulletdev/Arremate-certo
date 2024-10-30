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
/*    */ public final class DividePtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 6;
/* 28 */   public static final ValueOperatorPtg instance = new DividePtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 35 */     return 6;
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
/* 46 */     stringBuffer.append("/");
/* 47 */     stringBuffer.append(paramArrayOfString[1]);
/* 48 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\DividePtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */