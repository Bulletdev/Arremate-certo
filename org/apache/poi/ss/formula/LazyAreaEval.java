/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.AreaEval;
/*    */ import org.apache.poi.ss.formula.eval.AreaEvalBase;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.formula.ptg.AreaI;
/*    */ import org.apache.poi.ss.util.CellReference;
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
/*    */ final class LazyAreaEval
/*    */   extends AreaEvalBase
/*    */ {
/*    */   private final SheetRangeEvaluator _evaluator;
/*    */   
/*    */   LazyAreaEval(AreaI paramAreaI, SheetRangeEvaluator paramSheetRangeEvaluator) {
/* 34 */     super(paramAreaI, paramSheetRangeEvaluator);
/* 35 */     this._evaluator = paramSheetRangeEvaluator;
/*    */   }
/*    */ 
/*    */   
/*    */   public LazyAreaEval(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SheetRangeEvaluator paramSheetRangeEvaluator) {
/* 40 */     super(paramSheetRangeEvaluator, paramInt1, paramInt2, paramInt3, paramInt4);
/* 41 */     this._evaluator = paramSheetRangeEvaluator;
/*    */   }
/*    */   
/*    */   public ValueEval getRelativeValue(int paramInt1, int paramInt2) {
/* 45 */     return getRelativeValue(getFirstSheetIndex(), paramInt1, paramInt2);
/*    */   }
/*    */   public ValueEval getRelativeValue(int paramInt1, int paramInt2, int paramInt3) {
/* 48 */     int i = paramInt2 + getFirstRow();
/* 49 */     int j = paramInt3 + getFirstColumn();
/*    */     
/* 51 */     return this._evaluator.getEvalForCell(paramInt1, i, j);
/*    */   }
/*    */   
/*    */   public AreaEval offset(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 55 */     AreaI.OffsetArea offsetArea = new AreaI.OffsetArea(getFirstRow(), getFirstColumn(), paramInt1, paramInt2, paramInt3, paramInt4);
/*    */ 
/*    */     
/* 58 */     return (AreaEval)new LazyAreaEval((AreaI)offsetArea, this._evaluator);
/*    */   }
/*    */   public LazyAreaEval getRow(int paramInt) {
/* 61 */     if (paramInt >= getHeight()) {
/* 62 */       throw new IllegalArgumentException("Invalid rowIndex " + paramInt + ".  Allowable range is (0.." + getHeight() + ").");
/*    */     }
/*    */     
/* 65 */     int i = getFirstRow() + paramInt;
/* 66 */     return new LazyAreaEval(i, getFirstColumn(), i, getLastColumn(), this._evaluator);
/*    */   }
/*    */   public LazyAreaEval getColumn(int paramInt) {
/* 69 */     if (paramInt >= getWidth()) {
/* 70 */       throw new IllegalArgumentException("Invalid columnIndex " + paramInt + ".  Allowable range is (0.." + getWidth() + ").");
/*    */     }
/*    */     
/* 73 */     int i = getFirstColumn() + paramInt;
/* 74 */     return new LazyAreaEval(getFirstRow(), i, getLastRow(), i, this._evaluator);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     CellReference cellReference1 = new CellReference(getFirstRow(), getFirstColumn());
/* 79 */     CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn());
/* 80 */     return getClass().getName() + "[" + this._evaluator.getSheetNameRange() + '!' + cellReference1.formatAsString() + ':' + cellReference2.formatAsString() + "]";
/*    */   }
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
/*    */   public boolean isSubTotal(int paramInt1, int paramInt2) {
/* 94 */     SheetRefEvaluator sheetRefEvaluator = this._evaluator.getSheetEvaluator(this._evaluator.getFirstSheetIndex());
/* 95 */     return sheetRefEvaluator.isSubTotal(getFirstRow() + paramInt1, getFirstColumn() + paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\LazyAreaEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */