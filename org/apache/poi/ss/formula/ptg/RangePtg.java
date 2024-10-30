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
/*    */ 
/*    */ public final class RangePtg
/*    */   extends OperationPtg
/*    */ {
/*    */   public static final int SIZE = 1;
/*    */   public static final byte sid = 17;
/* 30 */   public static final OperationPtg instance = new RangePtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isBaseToken() {
/* 37 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 42 */     return 1;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 46 */     paramLittleEndianOutput.writeByte(17 + getPtgClass());
/*    */   }
/*    */ 
/*    */   
/*    */   public String toFormulaString() {
/* 51 */     return ":";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 58 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 60 */     stringBuffer.append(paramArrayOfString[0]);
/* 61 */     stringBuffer.append(":");
/* 62 */     stringBuffer.append(paramArrayOfString[1]);
/* 63 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getNumberOfOperands() {
/* 68 */     return 2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\RangePtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */