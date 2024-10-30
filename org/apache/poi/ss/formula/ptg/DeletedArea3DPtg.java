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
/*    */ public final class DeletedArea3DPtg
/*    */   extends OperandPtg
/*    */   implements WorkbookDependentFormula
/*    */ {
/*    */   public static final byte sid = 61;
/*    */   private final int field_1_index_extern_sheet;
/*    */   private final int unused1;
/*    */   private final int unused2;
/*    */   
/*    */   public DeletedArea3DPtg(int paramInt) {
/* 40 */     this.field_1_index_extern_sheet = paramInt;
/* 41 */     this.unused1 = 0;
/* 42 */     this.unused2 = 0;
/*    */   }
/*    */   
/*    */   public DeletedArea3DPtg(LittleEndianInput paramLittleEndianInput) {
/* 46 */     this.field_1_index_extern_sheet = paramLittleEndianInput.readUShort();
/* 47 */     this.unused1 = paramLittleEndianInput.readInt();
/* 48 */     this.unused2 = paramLittleEndianInput.readInt();
/*    */   }
/*    */   public String toFormulaString(FormulaRenderingWorkbook paramFormulaRenderingWorkbook) {
/* 51 */     return ExternSheetNameResolver.prependSheetName(paramFormulaRenderingWorkbook, this.field_1_index_extern_sheet, FormulaError.REF.getString());
/*    */   }
/*    */   public String toFormulaString() {
/* 54 */     throw new RuntimeException("3D references need a workbook to determine formula text");
/*    */   }
/*    */   public byte getDefaultOperandClass() {
/* 57 */     return 0;
/*    */   }
/*    */   public int getSize() {
/* 60 */     return 11;
/*    */   }
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 63 */     paramLittleEndianOutput.writeByte(61 + getPtgClass());
/* 64 */     paramLittleEndianOutput.writeShort(this.field_1_index_extern_sheet);
/* 65 */     paramLittleEndianOutput.writeInt(this.unused1);
/* 66 */     paramLittleEndianOutput.writeInt(this.unused2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\DeletedArea3DPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */