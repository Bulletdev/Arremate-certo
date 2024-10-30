/*     */ package org.apache.poi.xssf.streaming;
/*     */ 
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationSheet;
/*     */ import org.apache.poi.ss.usermodel.CellType;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ final class SXSSFEvaluationCell
/*     */   implements EvaluationCell
/*     */ {
/*     */   private final EvaluationSheet _evalSheet;
/*     */   private final SXSSFCell _cell;
/*     */   
/*     */   public SXSSFEvaluationCell(SXSSFCell paramSXSSFCell, SXSSFEvaluationSheet paramSXSSFEvaluationSheet) {
/*  33 */     this._cell = paramSXSSFCell;
/*  34 */     this._evalSheet = paramSXSSFEvaluationSheet;
/*     */   }
/*     */   
/*     */   public SXSSFEvaluationCell(SXSSFCell paramSXSSFCell) {
/*  38 */     this(paramSXSSFCell, new SXSSFEvaluationSheet(paramSXSSFCell.getSheet()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getIdentityKey() {
/*  45 */     return this._cell;
/*     */   }
/*     */   
/*     */   public SXSSFCell getSXSSFCell() {
/*  49 */     return this._cell;
/*     */   }
/*     */   
/*     */   public boolean getBooleanCellValue() {
/*  53 */     return this._cell.getBooleanCellValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCellType() {
/*  63 */     return this._cell.getCellType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal(since = "POI 3.15 beta 3")
/*     */   public CellType getCellTypeEnum() {
/*  73 */     return this._cell.getCellTypeEnum();
/*     */   }
/*     */   
/*     */   public int getColumnIndex() {
/*  77 */     return this._cell.getColumnIndex();
/*     */   }
/*     */   
/*     */   public int getErrorCellValue() {
/*  81 */     return this._cell.getErrorCellValue();
/*     */   }
/*     */   
/*     */   public double getNumericCellValue() {
/*  85 */     return this._cell.getNumericCellValue();
/*     */   }
/*     */   
/*     */   public int getRowIndex() {
/*  89 */     return this._cell.getRowIndex();
/*     */   }
/*     */   
/*     */   public EvaluationSheet getSheet() {
/*  93 */     return this._evalSheet;
/*     */   }
/*     */   
/*     */   public String getStringCellValue() {
/*  97 */     return this._cell.getRichStringCellValue().getString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCachedFormulaResultType() {
/* 107 */     return this._cell.getCachedFormulaResultType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal(since = "POI 3.15 beta 3")
/*     */   public CellType getCachedFormulaResultTypeEnum() {
/* 117 */     return this._cell.getCachedFormulaResultTypeEnum();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFEvaluationCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */