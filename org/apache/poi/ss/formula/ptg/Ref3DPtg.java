/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.formula.ExternSheetReferenceToken;
/*    */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*    */ import org.apache.poi.ss.formula.WorkbookDependentFormula;
/*    */ import org.apache.poi.ss.util.CellReference;
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
/*    */ public final class Ref3DPtg
/*    */   extends RefPtgBase
/*    */   implements ExternSheetReferenceToken, WorkbookDependentFormula
/*    */ {
/*    */   public static final byte sid = 58;
/*    */   private static final int SIZE = 7;
/*    */   private int field_1_index_extern_sheet;
/*    */   
/*    */   public Ref3DPtg(LittleEndianInput paramLittleEndianInput) {
/* 44 */     this.field_1_index_extern_sheet = paramLittleEndianInput.readShort();
/* 45 */     readCoordinates(paramLittleEndianInput);
/*    */   }
/*    */   
/*    */   public Ref3DPtg(String paramString, int paramInt) {
/* 49 */     this(new CellReference(paramString), paramInt);
/*    */   }
/*    */   
/*    */   public Ref3DPtg(CellReference paramCellReference, int paramInt) {
/* 53 */     super(paramCellReference);
/* 54 */     setExternSheetIndex(paramInt);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 58 */     StringBuffer stringBuffer = new StringBuffer();
/* 59 */     stringBuffer.append(getClass().getName());
/* 60 */     stringBuffer.append(" [");
/* 61 */     stringBuffer.append("sheetIx=").append(getExternSheetIndex());
/* 62 */     stringBuffer.append(" ! ");
/* 63 */     stringBuffer.append(formatReferenceAsString());
/* 64 */     stringBuffer.append("]");
/* 65 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 69 */     paramLittleEndianOutput.writeByte(58 + getPtgClass());
/* 70 */     paramLittleEndianOutput.writeShort(getExternSheetIndex());
/* 71 */     writeCoordinates(paramLittleEndianOutput);
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 75 */     return 7;
/*    */   }
/*    */   
/*    */   public int getExternSheetIndex() {
/* 79 */     return this.field_1_index_extern_sheet;
/*    */   }
/*    */   
/*    */   public void setExternSheetIndex(int paramInt) {
/* 83 */     this.field_1_index_extern_sheet = paramInt;
/*    */   }
/*    */   public String format2DRefAsString() {
/* 86 */     return formatReferenceAsString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String toFormulaString(FormulaRenderingWorkbook paramFormulaRenderingWorkbook) {
/* 93 */     return ExternSheetNameResolver.prependSheetName(paramFormulaRenderingWorkbook, this.field_1_index_extern_sheet, formatReferenceAsString());
/*    */   }
/*    */   public String toFormulaString() {
/* 96 */     throw new RuntimeException("3D references need a workbook to determine formula text");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Ref3DPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */