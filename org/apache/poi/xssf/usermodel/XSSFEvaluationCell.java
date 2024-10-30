/*     */ package org.apache.poi.xssf.usermodel;
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
/*     */ 
/*     */ final class XSSFEvaluationCell
/*     */   implements EvaluationCell
/*     */ {
/*     */   private final EvaluationSheet _evalSheet;
/*     */   private final XSSFCell _cell;
/*     */   
/*     */   public XSSFEvaluationCell(XSSFCell paramXSSFCell, XSSFEvaluationSheet paramXSSFEvaluationSheet) {
/*  34 */     this._cell = paramXSSFCell;
/*  35 */     this._evalSheet = paramXSSFEvaluationSheet;
/*     */   }
/*     */   
/*     */   public XSSFEvaluationCell(XSSFCell paramXSSFCell) {
/*  39 */     this(paramXSSFCell, new XSSFEvaluationSheet(paramXSSFCell.getSheet()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getIdentityKey() {
/*  46 */     return this._cell;
/*     */   }
/*     */   
/*     */   public XSSFCell getXSSFCell() {
/*  50 */     return this._cell;
/*     */   }
/*     */   
/*     */   public boolean getBooleanCellValue() {
/*  54 */     return this._cell.getBooleanCellValue();
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
/*  65 */     return this._cell.getCellType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellType getCellTypeEnum() {
/*  74 */     return this._cell.getCellTypeEnum();
/*     */   }
/*     */   
/*     */   public int getColumnIndex() {
/*  78 */     return this._cell.getColumnIndex();
/*     */   }
/*     */   
/*     */   public int getErrorCellValue() {
/*  82 */     return this._cell.getErrorCellValue();
/*     */   }
/*     */   
/*     */   public double getNumericCellValue() {
/*  86 */     return this._cell.getNumericCellValue();
/*     */   }
/*     */   
/*     */   public int getRowIndex() {
/*  90 */     return this._cell.getRowIndex();
/*     */   }
/*     */   
/*     */   public EvaluationSheet getSheet() {
/*  94 */     return this._evalSheet;
/*     */   }
/*     */   
/*     */   public String getStringCellValue() {
/*  98 */     return this._cell.getRichStringCellValue().getString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCachedFormulaResultType() {
/* 108 */     return this._cell.getCachedFormulaResultType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal(since = "POI 3.15 beta 3")
/*     */   public CellType getCachedFormulaResultTypeEnum() {
/* 118 */     return this._cell.getCachedFormulaResultTypeEnum();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFEvaluationCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */