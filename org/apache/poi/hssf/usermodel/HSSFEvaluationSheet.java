/*    */ package org.apache.poi.hssf.usermodel;
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
/*    */ 
/*    */ @Internal
/*    */ final class HSSFEvaluationSheet
/*    */   implements EvaluationSheet
/*    */ {
/*    */   private final HSSFSheet _hs;
/*    */   
/*    */   public HSSFEvaluationSheet(HSSFSheet paramHSSFSheet) {
/* 33 */     this._hs = paramHSSFSheet;
/*    */   }
/*    */   
/*    */   public HSSFSheet getHSSFSheet() {
/* 37 */     return this._hs;
/*    */   }
/*    */   
/*    */   public EvaluationCell getCell(int paramInt1, int paramInt2) {
/* 41 */     HSSFRow hSSFRow = this._hs.getRow(paramInt1);
/* 42 */     if (hSSFRow == null) {
/* 43 */       return null;
/*    */     }
/* 45 */     HSSFCell hSSFCell = hSSFRow.getCell(paramInt2);
/* 46 */     if (hSSFCell == null) {
/* 47 */       return null;
/*    */     }
/* 49 */     return new HSSFEvaluationCell(hSSFCell, this);
/*    */   }
/*    */   
/*    */   public void clearAllCachedResultValues() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFEvaluationSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */