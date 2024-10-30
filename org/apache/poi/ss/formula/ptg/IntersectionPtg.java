/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianOutput;
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
/*    */ public final class IntersectionPtg
/*    */   extends OperationPtg
/*    */ {
/*    */   public static final byte sid = 15;
/* 28 */   public static final OperationPtg instance = new IntersectionPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isBaseToken() {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 39 */     return 1;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 43 */     paramLittleEndianOutput.writeByte(15 + getPtgClass());
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 47 */     return " ";
/*    */   }
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 51 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 53 */     stringBuffer.append(paramArrayOfString[0]);
/* 54 */     stringBuffer.append(" ");
/* 55 */     stringBuffer.append(paramArrayOfString[1]);
/* 56 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 60 */     return 2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\IntersectionPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */