/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.AreaEval;
/*    */ import org.apache.poi.ss.formula.eval.RefEvalBase;
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
/*    */ public final class LazyRefEval
/*    */   extends RefEvalBase
/*    */ {
/*    */   private final SheetRangeEvaluator _evaluator;
/*    */   
/*    */   public LazyRefEval(int paramInt1, int paramInt2, SheetRangeEvaluator paramSheetRangeEvaluator) {
/* 34 */     super(paramSheetRangeEvaluator, paramInt1, paramInt2);
/* 35 */     this._evaluator = paramSheetRangeEvaluator;
/*    */   }
/*    */   
/*    */   public ValueEval getInnerValueEval(int paramInt) {
/* 39 */     return this._evaluator.getEvalForCell(paramInt, getRow(), getColumn());
/*    */   }
/*    */ 
/*    */   
/*    */   public AreaEval offset(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 44 */     AreaI.OffsetArea offsetArea = new AreaI.OffsetArea(getRow(), getColumn(), paramInt1, paramInt2, paramInt3, paramInt4);
/*    */ 
/*    */     
/* 47 */     return (AreaEval)new LazyAreaEval((AreaI)offsetArea, this._evaluator);
/*    */   }
/*    */   
/*    */   public boolean isSubTotal() {
/* 51 */     SheetRefEvaluator sheetRefEvaluator = this._evaluator.getSheetEvaluator(getFirstSheetIndex());
/* 52 */     return sheetRefEvaluator.isSubTotal(getRow(), getColumn());
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     CellReference cellReference = new CellReference(getRow(), getColumn());
/* 57 */     return getClass().getName() + "[" + this._evaluator.getSheetNameRange() + '!' + cellReference.formatAsString() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\LazyRefEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */