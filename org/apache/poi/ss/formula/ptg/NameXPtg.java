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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class NameXPtg
/*    */   extends OperandPtg
/*    */   implements WorkbookDependentFormula
/*    */ {
/*    */   public static final short sid = 57;
/*    */   private static final int SIZE = 7;
/*    */   private final int _sheetRefIndex;
/*    */   private final int _nameNumber;
/*    */   private final int _reserved;
/*    */   
/*    */   private NameXPtg(int paramInt1, int paramInt2, int paramInt3) {
/* 45 */     this._sheetRefIndex = paramInt1;
/* 46 */     this._nameNumber = paramInt2;
/* 47 */     this._reserved = paramInt3;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NameXPtg(int paramInt1, int paramInt2) {
/* 55 */     this(paramInt1, paramInt2 + 1, 0);
/*    */   }
/*    */   
/*    */   public NameXPtg(LittleEndianInput paramLittleEndianInput) {
/* 59 */     this(paramLittleEndianInput.readUShort(), paramLittleEndianInput.readUShort(), paramLittleEndianInput.readUShort());
/*    */   }
/*    */   
/*    */   public void write(LittleEndianOutput paramLittleEndianOutput) {
/* 63 */     paramLittleEndianOutput.writeByte(57 + getPtgClass());
/* 64 */     paramLittleEndianOutput.writeShort(this._sheetRefIndex);
/* 65 */     paramLittleEndianOutput.writeShort(this._nameNumber);
/* 66 */     paramLittleEndianOutput.writeShort(this._reserved);
/*    */   }
/*    */   
/*    */   public int getSize() {
/* 70 */     return 7;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toFormulaString(FormulaRenderingWorkbook paramFormulaRenderingWorkbook) {
/* 75 */     return paramFormulaRenderingWorkbook.resolveNameXText(this);
/*    */   }
/*    */   public String toFormulaString() {
/* 78 */     throw new RuntimeException("3D references need a workbook to determine formula text");
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     return "NameXPtg:[sheetRefIndex:" + this._sheetRefIndex + " , nameNumber:" + this._nameNumber + "]";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getDefaultOperandClass() {
/* 88 */     return 32;
/*    */   }
/*    */   
/*    */   public int getSheetRefIndex() {
/* 92 */     return this._sheetRefIndex;
/*    */   }
/*    */   public int getNameIndex() {
/* 95 */     return this._nameNumber - 1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\NameXPtg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */