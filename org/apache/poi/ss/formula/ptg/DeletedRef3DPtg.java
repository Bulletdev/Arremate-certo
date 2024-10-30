/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*    */ import org.apache.poi.ss.formula.WorkbookDependentFormula;
/*    */ import org.apache.poi.ss.usermodel.FormulaError;
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
/*    */ public final class DeletedRef3DPtg
/*    */   extends OperandPtg
/*    */   implements WorkbookDependentFormula
/*    */ {
/*    */   public static final byte sid = 60;
/*    */   private final int field_1_index_extern_sheet;
/*    */   private final int unused1;
/*    */   
/*    */   public DeletedRef3DPtg(LittleEndianInput paramLittleEndianInput) {
/* 39 */     this.field_1_index_extern_sheet = paramLittleEndianInput.readUShort();
/* 40 */     this.unused1 = paramLittleEndianInput.readInt();
/*    */   }
/*    */   
/*    */   public DeletedRef3DPtg(int paramInt) {
/* 44 */     this.field_1_index_extern_sheet = paramInt;
/* 45 */     this.unused1 = 0;
/*    */   }
/*    */   
/*    */   public String toFormulaString(FormulaRenderingWorkbook paramFormulaRenderingWorkbook) {
/* 49 */     return ExternSheetNameResolver.prependSheetName(paramFormulaRenderingWorkbook, this.field_1_index_extern_sheet, FormulaError.REF.getString());
/*    */   }
/*    */   public String toFormulaString() {
/* 52 */     throw new RuntimeException("3D references need a workbook to determine formula text");
/*    */   }
/*    */   public byte getDefaultOperandClass() {
/* 55 */     return 0;
/*    */   }
/*    */   public int getSize() {
/* 58 */     return 7;
/*    */   }
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 61 */     paramLittleEndianOutput.writeByte(60 + getPtgClass());
/* 62 */     paramLittleEndianOutput.writeShort(this.field_1_index_extern_sheet);
/* 63 */     paramLittleEndianOutput.writeInt(this.unused1);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\DeletedRef3DPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */