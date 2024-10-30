/*    */ package org.apache.poi.xssf.streaming;
/*    */ 
/*    */ import org.apache.poi.ss.formula.EvaluationCell;
/*    */ import org.apache.poi.ss.formula.EvaluationSheet;
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
/*    */ final class SXSSFEvaluationSheet
/*    */   implements EvaluationSheet
/*    */ {
/*    */   private final SXSSFSheet _xs;
/*    */   
/*    */   public SXSSFEvaluationSheet(SXSSFSheet paramSXSSFSheet) {
/* 32 */     this._xs = paramSXSSFSheet;
/*    */   }
/*    */   
/*    */   public SXSSFSheet getSXSSFSheet() {
/* 36 */     return this._xs;
/*    */   }
/*    */   
/*    */   public EvaluationCell getCell(int paramInt1, int paramInt2) {
/* 40 */     SXSSFRow sXSSFRow = this._xs.getRow(paramInt1);
/* 41 */     if (sXSSFRow == null) {
/* 42 */       if (paramInt1 <= this._xs.getLastFlushedRowNum()) {
/* 43 */         throw new SXSSFFormulaEvaluator.RowFlushedException(paramInt1);
/*    */       }
/* 45 */       return null;
/*    */     } 
/* 47 */     SXSSFCell sXSSFCell = sXSSFRow.getCell(paramInt2);
/* 48 */     if (sXSSFCell == null) {
/* 49 */       return null;
/*    */     }
/* 51 */     return new SXSSFEvaluationCell(sXSSFCell, this);
/*    */   }
/*    */   
/*    */   public void clearAllCachedResultValues() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFEvaluationSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */