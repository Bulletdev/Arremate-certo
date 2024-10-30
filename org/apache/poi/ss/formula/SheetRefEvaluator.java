/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.formula.ptg.FuncVarPtg;
/*    */ import org.apache.poi.ss.formula.ptg.Ptg;
/*    */ import org.apache.poi.ss.usermodel.CellType;
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
/*    */ final class SheetRefEvaluator
/*    */ {
/*    */   private final WorkbookEvaluator _bookEvaluator;
/*    */   private final EvaluationTracker _tracker;
/*    */   private final int _sheetIndex;
/*    */   private EvaluationSheet _sheet;
/*    */   
/*    */   public SheetRefEvaluator(WorkbookEvaluator paramWorkbookEvaluator, EvaluationTracker paramEvaluationTracker, int paramInt) {
/* 35 */     if (paramInt < 0) {
/* 36 */       throw new IllegalArgumentException("Invalid sheetIndex: " + paramInt + ".");
/*    */     }
/* 38 */     this._bookEvaluator = paramWorkbookEvaluator;
/* 39 */     this._tracker = paramEvaluationTracker;
/* 40 */     this._sheetIndex = paramInt;
/*    */   }
/*    */   
/*    */   public String getSheetName() {
/* 44 */     return this._bookEvaluator.getSheetName(this._sheetIndex);
/*    */   }
/*    */   
/*    */   public ValueEval getEvalForCell(int paramInt1, int paramInt2) {
/* 48 */     return this._bookEvaluator.evaluateReference(getSheet(), this._sheetIndex, paramInt1, paramInt2, this._tracker);
/*    */   }
/*    */   
/*    */   private EvaluationSheet getSheet() {
/* 52 */     if (this._sheet == null) {
/* 53 */       this._sheet = this._bookEvaluator.getSheet(this._sheetIndex);
/*    */     }
/* 55 */     return this._sheet;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isSubTotal(int paramInt1, int paramInt2) {
/* 63 */     boolean bool = false;
/* 64 */     EvaluationCell evaluationCell = getSheet().getCell(paramInt1, paramInt2);
/* 65 */     if (evaluationCell != null && evaluationCell.getCellTypeEnum() == CellType.FORMULA) {
/* 66 */       EvaluationWorkbook evaluationWorkbook = this._bookEvaluator.getWorkbook();
/* 67 */       for (Ptg ptg : evaluationWorkbook.getFormulaTokens(evaluationCell)) {
/* 68 */         if (ptg instanceof FuncVarPtg) {
/* 69 */           FuncVarPtg funcVarPtg = (FuncVarPtg)ptg;
/* 70 */           if ("SUBTOTAL".equals(funcVarPtg.getName())) {
/* 71 */             bool = true;
/*    */             break;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 77 */     return bool;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\SheetRefEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */