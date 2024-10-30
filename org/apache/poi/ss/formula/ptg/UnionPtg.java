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
/*    */ public final class UnionPtg
/*    */   extends OperationPtg
/*    */ {
/*    */   public static final byte sid = 16;
/* 29 */   public static final OperationPtg instance = new UnionPtg();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean isBaseToken() {
/* 36 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 41 */     return 1;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 45 */     paramLittleEndianOutput.writeByte(16 + getPtgClass());
/*    */   }
/*    */ 
/*    */   
/*    */   public String toFormulaString() {
/* 50 */     return ",";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toFormulaString(String[] paramArrayOfString) {
/* 57 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 59 */     stringBuffer.append(paramArrayOfString[0]);
/* 60 */     stringBuffer.append(",");
/* 61 */     stringBuffer.append(paramArrayOfString[1]);
/* 62 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getNumberOfOperands() {
/* 67 */     return 2;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\UnionPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */