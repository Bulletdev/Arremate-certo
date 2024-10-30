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
/*    */ public final class ExpPtg
/*    */   extends ControlPtg
/*    */ {
/*    */   private static final int SIZE = 5;
/*    */   public static final short sid = 1;
/*    */   private final int field_1_first_row;
/*    */   private final int field_2_first_col;
/*    */   
/*    */   public ExpPtg(LittleEndianInput paramLittleEndianInput) {
/* 36 */     this.field_1_first_row = paramLittleEndianInput.readShort();
/* 37 */     this.field_2_first_col = paramLittleEndianInput.readShort();
/*    */   }
/*    */   
/*    */   public ExpPtg(int paramInt1, int paramInt2) {
/* 41 */     this.field_1_first_row = paramInt1;
/* 42 */     this.field_2_first_col = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 47 */     paramLittleEndianOutput.writeByte(1 + getPtgClass());
/* 48 */     paramLittleEndianOutput.writeShort(this.field_1_first_row);
/* 49 */     paramLittleEndianOutput.writeShort(this.field_2_first_col);
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSize() {
/* 54 */     return 5;
/*    */   }
/*    */   
/*    */   public int getRow() {
/* 58 */     return this.field_1_first_row;
/*    */   }
/*    */   
/*    */   public int getColumn() {
/* 62 */     return this.field_2_first_col;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toFormulaString() {
/* 67 */     throw new RuntimeException("Coding Error: Expected ExpPtg to be converted from Shared to Non-Shared Formula by ValueRecordsAggregate, but it wasn't");
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuffer stringBuffer = new StringBuffer("[Array Formula or Shared Formula]\n");
/* 73 */     stringBuffer.append("row = ").append(getRow()).append("\n");
/* 74 */     stringBuffer.append("col = ").append(getColumn()).append("\n");
/* 75 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ExpPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */