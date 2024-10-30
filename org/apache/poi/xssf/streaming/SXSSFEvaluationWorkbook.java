/*    */ package org.apache.poi.xssf.streaming;
/*    */ 
/*    */ import org.apache.poi.ss.formula.EvaluationCell;
/*    */ import org.apache.poi.ss.formula.EvaluationSheet;
/*    */ import org.apache.poi.ss.formula.FormulaParser;
/*    */ import org.apache.poi.ss.formula.FormulaParsingWorkbook;
/*    */ import org.apache.poi.ss.formula.FormulaType;
/*    */ import org.apache.poi.ss.formula.ptg.Ptg;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.xssf.usermodel.BaseXSSFEvaluationWorkbook;
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
/*    */ public final class SXSSFEvaluationWorkbook
/*    */   extends BaseXSSFEvaluationWorkbook
/*    */ {
/*    */   private final SXSSFWorkbook _uBook;
/*    */   
/*    */   public static SXSSFEvaluationWorkbook create(SXSSFWorkbook paramSXSSFWorkbook) {
/* 36 */     if (paramSXSSFWorkbook == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     return new SXSSFEvaluationWorkbook(paramSXSSFWorkbook);
/*    */   }
/*    */   
/*    */   private SXSSFEvaluationWorkbook(SXSSFWorkbook paramSXSSFWorkbook) {
/* 43 */     super(paramSXSSFWorkbook.getXSSFWorkbook());
/* 44 */     this._uBook = paramSXSSFWorkbook;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getSheetIndex(EvaluationSheet paramEvaluationSheet) {
/* 49 */     SXSSFSheet sXSSFSheet = ((SXSSFEvaluationSheet)paramEvaluationSheet).getSXSSFSheet();
/* 50 */     return this._uBook.getSheetIndex(sXSSFSheet);
/*    */   }
/*    */ 
/*    */   
/*    */   public EvaluationSheet getSheet(int paramInt) {
/* 55 */     return new SXSSFEvaluationSheet(this._uBook.getSheetAt(paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   public Ptg[] getFormulaTokens(EvaluationCell paramEvaluationCell) {
/* 60 */     SXSSFCell sXSSFCell = ((SXSSFEvaluationCell)paramEvaluationCell).getSXSSFCell();
/* 61 */     return FormulaParser.parse(sXSSFCell.getCellFormula(), (FormulaParsingWorkbook)this, FormulaType.CELL, this._uBook.getSheetIndex(sXSSFCell.getSheet()));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFEvaluationWorkbook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */