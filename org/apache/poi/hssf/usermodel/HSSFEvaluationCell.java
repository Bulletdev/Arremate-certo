/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationSheet;
/*     */ import org.apache.poi.ss.usermodel.CellType;
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
/*     */ final class HSSFEvaluationCell
/*     */   implements EvaluationCell
/*     */ {
/*     */   private final EvaluationSheet _evalSheet;
/*     */   private final HSSFCell _cell;
/*     */   
/*     */   public HSSFEvaluationCell(HSSFCell paramHSSFCell, EvaluationSheet paramEvaluationSheet) {
/*  33 */     this._cell = paramHSSFCell;
/*  34 */     this._evalSheet = paramEvaluationSheet;
/*     */   }
/*     */   public HSSFEvaluationCell(HSSFCell paramHSSFCell) {
/*  37 */     this(paramHSSFCell, new HSSFEvaluationSheet(paramHSSFCell.getSheet()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getIdentityKey() {
/*  43 */     return this._cell;
/*     */   }
/*     */   
/*     */   public HSSFCell getHSSFCell() {
/*  47 */     return this._cell;
/*     */   }
/*     */   
/*     */   public boolean getBooleanCellValue() {
/*  51 */     return this._cell.getBooleanCellValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCellType() {
/*  62 */     return this._cell.getCellType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellType getCellTypeEnum() {
/*  71 */     return this._cell.getCellTypeEnum();
/*     */   }
/*     */   
/*     */   public int getColumnIndex() {
/*  75 */     return this._cell.getColumnIndex();
/*     */   }
/*     */   
/*     */   public int getErrorCellValue() {
/*  79 */     return this._cell.getErrorCellValue();
/*     */   }
/*     */   
/*     */   public double getNumericCellValue() {
/*  83 */     return this._cell.getNumericCellValue();
/*     */   }
/*     */   
/*     */   public int getRowIndex() {
/*  87 */     return this._cell.getRowIndex();
/*     */   }
/*     */   
/*     */   public EvaluationSheet getSheet() {
/*  91 */     return this._evalSheet;
/*     */   }
/*     */   
/*     */   public String getStringCellValue() {
/*  95 */     return this._cell.getRichStringCellValue().getString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCachedFormulaResultType() {
/* 106 */     return this._cell.getCachedFormulaResultType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellType getCachedFormulaResultTypeEnum() {
/* 115 */     return this._cell.getCachedFormulaResultTypeEnum();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFEvaluationCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */