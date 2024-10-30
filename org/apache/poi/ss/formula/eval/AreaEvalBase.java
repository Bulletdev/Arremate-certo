/*     */ package org.apache.poi.ss.formula.eval;
/*     */ 
/*     */ import org.apache.poi.ss.formula.SheetRange;
/*     */ import org.apache.poi.ss.formula.ptg.AreaI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AreaEvalBase
/*     */   implements AreaEval
/*     */ {
/*     */   private final int _firstSheet;
/*     */   private final int _firstColumn;
/*     */   private final int _firstRow;
/*     */   private final int _lastSheet;
/*     */   private final int _lastColumn;
/*     */   private final int _lastRow;
/*     */   private final int _nColumns;
/*     */   private final int _nRows;
/*     */   
/*     */   protected AreaEvalBase(SheetRange paramSheetRange, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  38 */     this._firstColumn = paramInt2;
/*  39 */     this._firstRow = paramInt1;
/*  40 */     this._lastColumn = paramInt4;
/*  41 */     this._lastRow = paramInt3;
/*     */     
/*  43 */     this._nColumns = this._lastColumn - this._firstColumn + 1;
/*  44 */     this._nRows = this._lastRow - this._firstRow + 1;
/*     */     
/*  46 */     if (paramSheetRange != null) {
/*  47 */       this._firstSheet = paramSheetRange.getFirstSheetIndex();
/*  48 */       this._lastSheet = paramSheetRange.getLastSheetIndex();
/*     */     } else {
/*  50 */       this._firstSheet = -1;
/*  51 */       this._lastSheet = -1;
/*     */     } 
/*     */   }
/*     */   protected AreaEvalBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  55 */     this(null, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */   
/*     */   protected AreaEvalBase(AreaI paramAreaI) {
/*  59 */     this(paramAreaI, null);
/*     */   }
/*     */   protected AreaEvalBase(AreaI paramAreaI, SheetRange paramSheetRange) {
/*  62 */     this(paramSheetRange, paramAreaI.getFirstRow(), paramAreaI.getFirstColumn(), paramAreaI.getLastRow(), paramAreaI.getLastColumn());
/*     */   }
/*     */   
/*     */   public final int getFirstColumn() {
/*  66 */     return this._firstColumn;
/*     */   }
/*     */   
/*     */   public final int getFirstRow() {
/*  70 */     return this._firstRow;
/*     */   }
/*     */   
/*     */   public final int getLastColumn() {
/*  74 */     return this._lastColumn;
/*     */   }
/*     */   
/*     */   public final int getLastRow() {
/*  78 */     return this._lastRow;
/*     */   }
/*     */   
/*     */   public int getFirstSheetIndex() {
/*  82 */     return this._firstSheet;
/*     */   }
/*     */   public int getLastSheetIndex() {
/*  85 */     return this._lastSheet;
/*     */   }
/*     */   
/*     */   public final ValueEval getAbsoluteValue(int paramInt1, int paramInt2) {
/*  89 */     int i = paramInt1 - this._firstRow;
/*  90 */     int j = paramInt2 - this._firstColumn;
/*     */     
/*  92 */     if (i < 0 || i >= this._nRows) {
/*  93 */       throw new IllegalArgumentException("Specified row index (" + paramInt1 + ") is outside the allowed range (" + this._firstRow + ".." + this._lastRow + ")");
/*     */     }
/*     */     
/*  96 */     if (j < 0 || j >= this._nColumns) {
/*  97 */       throw new IllegalArgumentException("Specified column index (" + paramInt2 + ") is outside the allowed range (" + this._firstColumn + ".." + paramInt2 + ")");
/*     */     }
/*     */     
/* 100 */     return getRelativeValue(i, j);
/*     */   }
/*     */   
/*     */   public final boolean contains(int paramInt1, int paramInt2) {
/* 104 */     return (this._firstRow <= paramInt1 && this._lastRow >= paramInt1 && this._firstColumn <= paramInt2 && this._lastColumn >= paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean containsRow(int paramInt) {
/* 109 */     return (this._firstRow <= paramInt && this._lastRow >= paramInt);
/*     */   }
/*     */   
/*     */   public final boolean containsColumn(int paramInt) {
/* 113 */     return (this._firstColumn <= paramInt && this._lastColumn >= paramInt);
/*     */   }
/*     */   
/*     */   public final boolean isColumn() {
/* 117 */     return (this._firstColumn == this._lastColumn);
/*     */   }
/*     */   
/*     */   public final boolean isRow() {
/* 121 */     return (this._firstRow == this._lastRow);
/*     */   }
/*     */   public int getHeight() {
/* 124 */     return this._lastRow - this._firstRow + 1;
/*     */   }
/*     */   
/*     */   public final ValueEval getValue(int paramInt1, int paramInt2) {
/* 128 */     return getRelativeValue(paramInt1, paramInt2);
/*     */   }
/*     */   public final ValueEval getValue(int paramInt1, int paramInt2, int paramInt3) {
/* 131 */     return getRelativeValue(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   public abstract ValueEval getRelativeValue(int paramInt1, int paramInt2);
/*     */   
/*     */   public abstract ValueEval getRelativeValue(int paramInt1, int paramInt2, int paramInt3);
/*     */   
/*     */   public int getWidth() {
/* 138 */     return this._lastColumn - this._firstColumn + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSubTotal(int paramInt1, int paramInt2) {
/* 146 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\AreaEvalBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */