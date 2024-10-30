/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.formula.EvaluationCell;
/*    */ import org.apache.poi.ss.formula.EvaluationSheet;
/*    */ import org.apache.poi.ss.formula.FormulaParser;
/*    */ import org.apache.poi.ss.formula.FormulaType;
/*    */ import org.apache.poi.ss.formula.ptg.Ptg;
/*    */ import org.apache.poi.util.Internal;
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
/*    */ @Internal
/*    */ public final class XSSFEvaluationWorkbook
/*    */   extends BaseXSSFEvaluationWorkbook
/*    */ {
/*    */   private XSSFEvaluationSheet[] _sheetCache;
/*    */   
/*    */   public static XSSFEvaluationWorkbook create(XSSFWorkbook paramXSSFWorkbook) {
/* 35 */     if (paramXSSFWorkbook == null) {
/* 36 */       return null;
/*    */     }
/* 38 */     return new XSSFEvaluationWorkbook(paramXSSFWorkbook);
/*    */   }
/*    */   
/*    */   private XSSFEvaluationWorkbook(XSSFWorkbook paramXSSFWorkbook) {
/* 42 */     super(paramXSSFWorkbook);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clearAllCachedResultValues() {
/* 50 */     super.clearAllCachedResultValues();
/* 51 */     this._sheetCache = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSheetIndex(EvaluationSheet paramEvaluationSheet) {
/* 56 */     XSSFSheet xSSFSheet = ((XSSFEvaluationSheet)paramEvaluationSheet).getXSSFSheet();
/* 57 */     return this._uBook.getSheetIndex(xSSFSheet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EvaluationSheet getSheet(int paramInt) {
/* 66 */     if (this._sheetCache == null) {
/* 67 */       int i = this._uBook.getNumberOfSheets();
/* 68 */       this._sheetCache = new XSSFEvaluationSheet[i];
/* 69 */       for (byte b = 0; b < i; b++) {
/* 70 */         this._sheetCache[b] = new XSSFEvaluationSheet(this._uBook.getSheetAt(b));
/*    */       }
/*    */     } 
/* 73 */     if (paramInt < 0 || paramInt >= this._sheetCache.length)
/*    */     {
/* 75 */       this._uBook.getSheetAt(paramInt);
/*    */     }
/* 77 */     return this._sheetCache[paramInt];
/*    */   }
/*    */ 
/*    */   
/*    */   public Ptg[] getFormulaTokens(EvaluationCell paramEvaluationCell) {
/* 82 */     XSSFCell xSSFCell = ((XSSFEvaluationCell)paramEvaluationCell).getXSSFCell();
/* 83 */     int i = this._uBook.getSheetIndex(xSSFCell.getSheet());
/* 84 */     int j = xSSFCell.getRowIndex();
/* 85 */     return FormulaParser.parse(xSSFCell.getCellFormula(this), this, FormulaType.CELL, i, j);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFEvaluationWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */