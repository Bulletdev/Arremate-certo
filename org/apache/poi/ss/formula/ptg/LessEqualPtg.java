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
/*    */ public final class LessEqualPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 10;
/* 32 */   public static final ValueOperatorPtg instance = new LessEqualPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 39 */     return 10;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 43 */     return 2;
/*    */   }
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 47 */     StringBuffer stringBuffer = new StringBuffer();
/* 48 */     stringBuffer.append(paramArrayOfString[0]);
/* 49 */     stringBuffer.append("<=");
/* 50 */     stringBuffer.append(paramArrayOfString[1]);
/* 51 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\LessEqualPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */