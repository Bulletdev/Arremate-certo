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
/*    */ public final class EqualPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 11;
/* 27 */   public static final ValueOperatorPtg instance = new EqualPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 34 */     return 11;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 38 */     return 2;
/*    */   }
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 42 */     StringBuffer stringBuffer = new StringBuffer();
/*    */ 
/*    */     
/* 45 */     stringBuffer.append(paramArrayOfString[0]);
/* 46 */     stringBuffer.append("=");
/* 47 */     stringBuffer.append(paramArrayOfString[1]);
/* 48 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\EqualPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */