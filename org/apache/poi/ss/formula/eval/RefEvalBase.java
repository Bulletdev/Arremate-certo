/*    */ package org.apache.poi.ss.formula.eval;
/*    */ 
/*    */ import org.apache.poi.ss.formula.SheetRange;
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
/*    */ public abstract class RefEvalBase
/*    */   implements RefEval
/*    */ {
/*    */   private final int _firstSheetIndex;
/*    */   private final int _lastSheetIndex;
/*    */   private final int _rowIndex;
/*    */   private final int _columnIndex;
/*    */   
/*    */   protected RefEvalBase(SheetRange paramSheetRange, int paramInt1, int paramInt2) {
/* 32 */     if (paramSheetRange == null) {
/* 33 */       throw new IllegalArgumentException("sheetRange must not be null");
/*    */     }
/* 35 */     this._firstSheetIndex = paramSheetRange.getFirstSheetIndex();
/* 36 */     this._lastSheetIndex = paramSheetRange.getLastSheetIndex();
/* 37 */     this._rowIndex = paramInt1;
/* 38 */     this._columnIndex = paramInt2;
/*    */   }
/*    */   protected RefEvalBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 41 */     this._firstSheetIndex = paramInt1;
/* 42 */     this._lastSheetIndex = paramInt2;
/* 43 */     this._rowIndex = paramInt3;
/* 44 */     this._columnIndex = paramInt4;
/*    */   }
/*    */   protected RefEvalBase(int paramInt1, int paramInt2, int paramInt3) {
/* 47 */     this(paramInt1, paramInt1, paramInt2, paramInt3);
/*    */   }
/*    */   
/*    */   public int getNumberOfSheets() {
/* 51 */     return this._lastSheetIndex - this._firstSheetIndex + 1;
/*    */   }
/*    */   public int getFirstSheetIndex() {
/* 54 */     return this._firstSheetIndex;
/*    */   }
/*    */   public int getLastSheetIndex() {
/* 57 */     return this._lastSheetIndex;
/*    */   }
/*    */   public final int getRow() {
/* 60 */     return this._rowIndex;
/*    */   }
/*    */   public final int getColumn() {
/* 63 */     return this._columnIndex;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\RefEvalBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */