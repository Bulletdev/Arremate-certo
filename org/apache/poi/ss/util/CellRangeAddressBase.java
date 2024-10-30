/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CellRangeAddressBase
/*     */ {
/*     */   private int _firstRow;
/*     */   private int _firstCol;
/*     */   private int _lastRow;
/*     */   private int _lastCol;
/*     */   
/*     */   protected CellRangeAddressBase(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  36 */     this._firstRow = paramInt1;
/*  37 */     this._lastRow = paramInt2;
/*  38 */     this._firstCol = paramInt3;
/*  39 */     this._lastCol = paramInt4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void validate(SpreadsheetVersion paramSpreadsheetVersion) {
/*  49 */     validateRow(this._firstRow, paramSpreadsheetVersion);
/*  50 */     validateRow(this._lastRow, paramSpreadsheetVersion);
/*  51 */     validateColumn(this._firstCol, paramSpreadsheetVersion);
/*  52 */     validateColumn(this._lastCol, paramSpreadsheetVersion);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void validateRow(int paramInt, SpreadsheetVersion paramSpreadsheetVersion) {
/*  59 */     int i = paramSpreadsheetVersion.getLastRowIndex();
/*  60 */     if (paramInt > i) throw new IllegalArgumentException("Maximum row number is " + i); 
/*  61 */     if (paramInt < 0) throw new IllegalArgumentException("Minumum row number is 0");
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void validateColumn(int paramInt, SpreadsheetVersion paramSpreadsheetVersion) {
/*  69 */     int i = paramSpreadsheetVersion.getLastColumnIndex();
/*  70 */     if (paramInt > i) throw new IllegalArgumentException("Maximum column number is " + i); 
/*  71 */     if (paramInt < 0) throw new IllegalArgumentException("Minimum column number is 0");
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isFullColumnRange() {
/*  77 */     return ((this._firstRow == 0 && this._lastRow == SpreadsheetVersion.EXCEL97.getLastRowIndex()) || (this._firstRow == -1 && this._lastRow == -1));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isFullRowRange() {
/*  82 */     return ((this._firstCol == 0 && this._lastCol == SpreadsheetVersion.EXCEL97.getLastColumnIndex()) || (this._firstCol == -1 && this._lastCol == -1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getFirstColumn() {
/*  90 */     return this._firstCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getFirstRow() {
/*  97 */     return this._firstRow;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLastColumn() {
/* 104 */     return this._lastCol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getLastRow() {
/* 111 */     return this._lastRow;
/*     */   }
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
/*     */   public boolean isInRange(int paramInt1, int paramInt2) {
/* 124 */     return (this._firstRow <= paramInt1 && paramInt1 <= this._lastRow && this._firstCol <= paramInt2 && paramInt2 <= this._lastCol);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsRow(int paramInt) {
/* 135 */     return (this._firstRow <= paramInt && paramInt <= this._lastRow);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsColumn(int paramInt) {
/* 145 */     return (this._firstCol <= paramInt && paramInt <= this._lastCol);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean intersects(CellRangeAddressBase paramCellRangeAddressBase) {
/* 156 */     return (this._firstRow <= paramCellRangeAddressBase._lastRow && this._firstCol <= paramCellRangeAddressBase._lastCol && paramCellRangeAddressBase._firstRow <= this._lastRow && paramCellRangeAddressBase._firstCol <= this._lastCol);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFirstColumn(int paramInt) {
/* 166 */     this._firstCol = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setFirstRow(int paramInt) {
/* 173 */     this._firstRow = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLastColumn(int paramInt) {
/* 180 */     this._lastCol = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLastRow(int paramInt) {
/* 187 */     this._lastRow = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfCells() {
/* 193 */     return (this._lastRow - this._firstRow + 1) * (this._lastCol - this._firstCol + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 198 */     CellReference cellReference1 = new CellReference(this._firstRow, this._firstCol);
/* 199 */     CellReference cellReference2 = new CellReference(this._lastRow, this._lastCol);
/* 200 */     return getClass().getName() + " [" + cellReference1.formatAsString() + ":" + cellReference2.formatAsString() + "]";
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getMinRow() {
/* 205 */     return Math.min(this._firstRow, this._lastRow);
/*     */   }
/*     */   protected int getMaxRow() {
/* 208 */     return Math.max(this._firstRow, this._lastRow);
/*     */   }
/*     */   protected int getMinColumn() {
/* 211 */     return Math.min(this._firstCol, this._lastCol);
/*     */   }
/*     */   protected int getMaxColumn() {
/* 214 */     return Math.max(this._firstCol, this._lastCol);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 219 */     if (paramObject instanceof CellRangeAddressBase) {
/* 220 */       CellRangeAddressBase cellRangeAddressBase = (CellRangeAddressBase)paramObject;
/* 221 */       return (getMinRow() == cellRangeAddressBase.getMinRow() && getMaxRow() == cellRangeAddressBase.getMaxRow() && getMinColumn() == cellRangeAddressBase.getMinColumn() && getMaxColumn() == cellRangeAddressBase.getMaxColumn());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 226 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 231 */     return getMinColumn() + (getMaxColumn() << 8) + (getMinRow() << 16) + (getMaxRow() << 24);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\CellRangeAddressBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */