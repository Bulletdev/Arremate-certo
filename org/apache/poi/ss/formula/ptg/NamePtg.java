/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*    */ import org.apache.poi.ss.formula.WorkbookDependentFormula;
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
/*    */ public final class NamePtg
/*    */   extends OperandPtg
/*    */   implements WorkbookDependentFormula
/*    */ {
/*    */   public static final short sid = 35;
/*    */   private static final int SIZE = 5;
/*    */   private int field_1_label_index;
/*    */   private short field_2_zero;
/*    */   
/*    */   public NamePtg(int paramInt) {
/* 41 */     this.field_1_label_index = 1 + paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public NamePtg(LittleEndianInput paramLittleEndianInput) {
/* 47 */     this.field_1_label_index = paramLittleEndianInput.readShort();
/* 48 */     this.field_2_zero = paramLittleEndianInput.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getIndex() {
/* 55 */     return this.field_1_label_index - 1;
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 59 */     paramLittleEndianOutput.writeByte(35 + getPtgClass());
/* 60 */     paramLittleEndianOutput.writeShort(this.field_1_label_index);
/* 61 */     paramLittleEndianOutput.writeShort(this.field_2_zero);
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 65 */     return 5;
/*    */   }
/*    */   
/*    */   public String toFormulaString(FormulaRenderingWorkbook paramFormulaRenderingWorkbook) {
/* 69 */     return paramFormulaRenderingWorkbook.getNameText(this);
/*    */   }
/*    */   
/*    */   public String toFormulaString() {
/* 73 */     throw new RuntimeException("3D references need a workbook to determine formula text");
/*    */   }
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 77 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\NamePtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */