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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class TblPtg
/*    */   extends ControlPtg
/*    */ {
/*    */   private static final int SIZE = 5;
/*    */   public static final short sid = 2;
/*    */   private final int field_1_first_row;
/*    */   private final int field_2_first_col;
/*    */   
/*    */   public TblPtg(LittleEndianInput paramLittleEndianInput) {
/* 46 */     this.field_1_first_row = paramLittleEndianInput.readUShort();
/* 47 */     this.field_2_first_col = paramLittleEndianInput.readUShort();
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 51 */     paramLittleEndianOutput.writeByte(2 + getPtgClass());
/* 52 */     paramLittleEndianOutput.writeShort(this.field_1_first_row);
/* 53 */     paramLittleEndianOutput.writeShort(this.field_2_first_col);
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 57 */     return 5;
/*    */   }
/*    */   
/*    */   public int getRow() {
/* 61 */     return this.field_1_first_row;
/*    */   }
/*    */   
/*    */   public int getColumn() {
/* 65 */     return this.field_2_first_col;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toFormulaString() {
/* 71 */     throw new RuntimeException("Table and Arrays are not yet supported");
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuffer stringBuffer = new StringBuffer("[Data Table - Parent cell is an interior cell in a data table]\n");
/* 76 */     stringBuffer.append("top left row = ").append(getRow()).append("\n");
/* 77 */     stringBuffer.append("top left col = ").append(getColumn()).append("\n");
/* 78 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\TblPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */