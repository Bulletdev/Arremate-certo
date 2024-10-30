/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.formula.BaseFormulaEvaluator;
/*    */ import org.apache.poi.ss.formula.EvaluationCell;
/*    */ import org.apache.poi.ss.formula.WorkbookEvaluator;
/*    */ import org.apache.poi.ss.formula.eval.BoolEval;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.StringEval;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.usermodel.Cell;
/*    */ import org.apache.poi.ss.usermodel.CellValue;
/*    */ import org.apache.poi.ss.usermodel.RichTextString;
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
/*    */ public abstract class BaseXSSFFormulaEvaluator
/*    */   extends BaseFormulaEvaluator
/*    */ {
/*    */   protected BaseXSSFFormulaEvaluator(WorkbookEvaluator paramWorkbookEvaluator) {
/* 38 */     super(paramWorkbookEvaluator);
/*    */   }
/*    */   
/*    */   protected RichTextString createRichTextString(String paramString) {
/* 42 */     return new XSSFRichTextString(paramString);
/*    */   }
/*    */   
/*    */   public void notifySetFormula(Cell paramCell) {
/* 46 */     this._bookEvaluator.notifyUpdateCell(new XSSFEvaluationCell((XSSFCell)paramCell));
/*    */   }
/*    */   public void notifyDeleteCell(Cell paramCell) {
/* 49 */     this._bookEvaluator.notifyDeleteCell(new XSSFEvaluationCell((XSSFCell)paramCell));
/*    */   }
/*    */   public void notifyUpdateCell(Cell paramCell) {
/* 52 */     this._bookEvaluator.notifyUpdateCell(new XSSFEvaluationCell((XSSFCell)paramCell));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract EvaluationCell toEvaluationCell(Cell paramCell);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected CellValue evaluateFormulaCellValue(Cell paramCell) {
/* 64 */     EvaluationCell evaluationCell = toEvaluationCell(paramCell);
/* 65 */     ValueEval valueEval = this._bookEvaluator.evaluate(evaluationCell);
/* 66 */     if (valueEval instanceof NumberEval) {
/* 67 */       NumberEval numberEval = (NumberEval)valueEval;
/* 68 */       return new CellValue(numberEval.getNumberValue());
/*    */     } 
/* 70 */     if (valueEval instanceof BoolEval) {
/* 71 */       BoolEval boolEval = (BoolEval)valueEval;
/* 72 */       return CellValue.valueOf(boolEval.getBooleanValue());
/*    */     } 
/* 74 */     if (valueEval instanceof StringEval) {
/* 75 */       StringEval stringEval = (StringEval)valueEval;
/* 76 */       return new CellValue(stringEval.getStringValue());
/*    */     } 
/* 78 */     if (valueEval instanceof ErrorEval) {
/* 79 */       return CellValue.getError(((ErrorEval)valueEval).getErrorCode());
/*    */     }
/* 81 */     throw new RuntimeException("Unexpected eval class (" + valueEval.getClass().getName() + ")");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\BaseXSSFFormulaEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */