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
/*    */ public final class AddPtg
/*    */   extends ValueOperatorPtg
/*    */ {
/*    */   public static final byte sid = 3;
/*    */   private static final String ADD = "+";
/* 31 */   public static final ValueOperatorPtg instance = new AddPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected byte getSid() {
/* 38 */     return 3;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 42 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 47 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 49 */     stringBuffer.append(paramArrayOfString[0]);
/* 50 */     stringBuffer.append("+");
/* 51 */     stringBuffer.append(paramArrayOfString[1]);
/* 52 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\AddPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */