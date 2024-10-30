/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianInput;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class MemFuncPtg
/*    */   extends OperandPtg
/*    */ {
/*    */   public static final byte sid = 41;
/*    */   private final int field_1_len_ref_subexpression;
/*    */   
/*    */   public MemFuncPtg(LittleEndianInput paramLittleEndianInput) {
/* 36 */     this(paramLittleEndianInput.readUShort());
/*    */   }
/*    */   
/*    */   public MemFuncPtg(int paramInt) {
/* 40 */     this.field_1_len_ref_subexpression = paramInt;
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 44 */     return 3;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 48 */     paramLittleEndianOutput.writeByte(41 + getPtgClass());
/* 49 */     paramLittleEndianOutput.writeShort(this.field_1_len_ref_subexpression);
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 53 */     return "";
/*    */   }
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 57 */     return 0;
/*    */   }
/*    */   
/*    */   public int getNumberOfOperands() {
/* 61 */     return this.field_1_len_ref_subexpression;
/*    */   }
/*    */   
/*    */   public int getLenRefSubexpression() {
/* 65 */     return this.field_1_len_ref_subexpression;
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 69 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 70 */     stringBuffer.append(getClass().getName()).append(" [len=");
/* 71 */     stringBuffer.append(this.field_1_len_ref_subexpression);
/* 72 */     stringBuffer.append("]");
/* 73 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\MemFuncPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */