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
/*    */ public final class PowerPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 7;
/* 28 */   public static final ValueOperatorPtg instance = new PowerPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 35 */     return 7;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 39 */     return 2;
/*    */   }
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 43 */     StringBuffer stringBuffer = new StringBuffer();
/*    */ 
/*    */     
/* 46 */     stringBuffer.append(paramArrayOfString[0]);
/* 47 */     stringBuffer.append("^");
/* 48 */     stringBuffer.append(paramArrayOfString[1]);
/* 49 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\PowerPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */