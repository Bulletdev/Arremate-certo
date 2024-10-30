/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*    */ final class SheetRangeEvaluator
/*    */   implements SheetRange
/*    */ {
/*    */   private final int _firstSheetIndex;
/*    */   private final int _lastSheetIndex;
/*    */   private SheetRefEvaluator[] _sheetEvaluators;
/*    */   
/*    */   public SheetRangeEvaluator(int paramInt1, int paramInt2, SheetRefEvaluator[] paramArrayOfSheetRefEvaluator) {
/* 31 */     if (paramInt1 < 0) {
/* 32 */       throw new IllegalArgumentException("Invalid firstSheetIndex: " + paramInt1 + ".");
/*    */     }
/* 34 */     if (paramInt2 < paramInt1) {
/* 35 */       throw new IllegalArgumentException("Invalid lastSheetIndex: " + paramInt2 + " for firstSheetIndex: " + paramInt1 + ".");
/*    */     }
/* 37 */     this._firstSheetIndex = paramInt1;
/* 38 */     this._lastSheetIndex = paramInt2;
/* 39 */     this._sheetEvaluators = (SheetRefEvaluator[])paramArrayOfSheetRefEvaluator.clone();
/*    */   }
/*    */   public SheetRangeEvaluator(int paramInt, SheetRefEvaluator paramSheetRefEvaluator) {
/* 42 */     this(paramInt, paramInt, new SheetRefEvaluator[] { paramSheetRefEvaluator });
/*    */   }
/*    */   
/*    */   public SheetRefEvaluator getSheetEvaluator(int paramInt) {
/* 46 */     if (paramInt < this._firstSheetIndex || paramInt > this._lastSheetIndex) {
/* 47 */       throw new IllegalArgumentException("Invalid SheetIndex: " + paramInt + " - Outside range " + this._firstSheetIndex + " : " + this._lastSheetIndex);
/*    */     }
/*    */     
/* 50 */     return this._sheetEvaluators[paramInt - this._firstSheetIndex];
/*    */   }
/*    */   
/*    */   public int getFirstSheetIndex() {
/* 54 */     return this._firstSheetIndex;
/*    */   }
/*    */   public int getLastSheetIndex() {
/* 57 */     return this._lastSheetIndex;
/*    */   }
/*    */   
/*    */   public String getSheetName(int paramInt) {
/* 61 */     return getSheetEvaluator(paramInt).getSheetName();
/*    */   }
/*    */   public String getSheetNameRange() {
/* 64 */     StringBuilder stringBuilder = new StringBuilder();
/* 65 */     stringBuilder.append(getSheetName(this._firstSheetIndex));
/* 66 */     if (this._firstSheetIndex != this._lastSheetIndex) {
/* 67 */       stringBuilder.append(':');
/* 68 */       stringBuilder.append(getSheetName(this._lastSheetIndex));
/*    */     } 
/* 70 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public ValueEval getEvalForCell(int paramInt1, int paramInt2, int paramInt3) {
/* 74 */     return getSheetEvaluator(paramInt1).getEvalForCell(paramInt2, paramInt3);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\SheetRangeEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */