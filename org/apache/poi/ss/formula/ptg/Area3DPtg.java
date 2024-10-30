/*     */ package org.apache.poi.ss.formula.ptg;
/*     */ 
/*     */ import org.apache.poi.ss.formula.ExternSheetReferenceToken;
/*     */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*     */ import org.apache.poi.ss.formula.WorkbookDependentFormula;
/*     */ import org.apache.poi.ss.util.AreaReference;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Area3DPtg
/*     */   extends AreaPtgBase
/*     */   implements ExternSheetReferenceToken, WorkbookDependentFormula
/*     */ {
/*     */   public static final byte sid = 59;
/*     */   private static final int SIZE = 11;
/*     */   private int field_1_index_extern_sheet;
/*     */   
/*     */   public Area3DPtg(String paramString, int paramInt) {
/*  44 */     super(new AreaReference(paramString));
/*  45 */     setExternSheetIndex(paramInt);
/*     */   }
/*     */   
/*     */   public Area3DPtg(LittleEndianInput paramLittleEndianInput) {
/*  49 */     this.field_1_index_extern_sheet = paramLittleEndianInput.readShort();
/*  50 */     readCoordinates(paramLittleEndianInput);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Area3DPtg(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt5) {
/*  56 */     super(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
/*  57 */     setExternSheetIndex(paramInt5);
/*     */   }
/*     */   
/*     */   public Area3DPtg(AreaReference paramAreaReference, int paramInt) {
/*  61 */     super(paramAreaReference);
/*  62 */     setExternSheetIndex(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  67 */     StringBuffer stringBuffer = new StringBuffer();
/*  68 */     stringBuffer.append(getClass().getName());
/*  69 */     stringBuffer.append(" [");
/*  70 */     stringBuffer.append("sheetIx=").append(getExternSheetIndex());
/*  71 */     stringBuffer.append(" ! ");
/*  72 */     stringBuffer.append(formatReferenceAsString());
/*  73 */     stringBuffer.append("]");
/*  74 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/*  79 */     paramLittleEndianOutput.writeByte(59 + getPtgClass());
/*  80 */     paramLittleEndianOutput.writeShort(this.field_1_index_extern_sheet);
/*  81 */     writeCoordinates(paramLittleEndianOutput);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSize() {
/*  86 */     return 11;
/*     */   }
/*     */   
/*     */   public int getExternSheetIndex() {
/*  90 */     return this.field_1_index_extern_sheet;
/*     */   }
/*     */   
/*     */   public void setExternSheetIndex(int paramInt) {
/*  94 */     this.field_1_index_extern_sheet = paramInt;
/*     */   }
/*     */   public String format2DRefAsString() {
/*  97 */     return formatReferenceAsString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toFormulaString(FormulaRenderingWorkbook paramFormulaRenderingWorkbook) {
/* 104 */     return ExternSheetNameResolver.prependSheetName(paramFormulaRenderingWorkbook, this.field_1_index_extern_sheet, formatReferenceAsString());
/*     */   }
/*     */   
/*     */   public String toFormulaString() {
/* 108 */     throw new RuntimeException("3D references need a workbook to determine formula text");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\Area3DPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */