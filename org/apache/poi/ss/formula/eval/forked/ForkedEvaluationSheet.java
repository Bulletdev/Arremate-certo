/*     */ package org.apache.poi.ss.formula.eval.forked;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.formula.EvaluationCell;
/*     */ import org.apache.poi.ss.formula.EvaluationSheet;
/*     */ import org.apache.poi.ss.formula.EvaluationWorkbook;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ final class ForkedEvaluationSheet
/*     */   implements EvaluationSheet
/*     */ {
/*     */   private final EvaluationSheet _masterSheet;
/*     */   private final Map<RowColKey, ForkedEvaluationCell> _sharedCellsByRowCol;
/*     */   
/*     */   public ForkedEvaluationSheet(EvaluationSheet paramEvaluationSheet) {
/*  53 */     this._masterSheet = paramEvaluationSheet;
/*  54 */     this._sharedCellsByRowCol = new HashMap<RowColKey, ForkedEvaluationCell>();
/*     */   }
/*     */ 
/*     */   
/*     */   public EvaluationCell getCell(int paramInt1, int paramInt2) {
/*  59 */     RowColKey rowColKey = new RowColKey(paramInt1, paramInt2);
/*     */     
/*  61 */     ForkedEvaluationCell forkedEvaluationCell = this._sharedCellsByRowCol.get(rowColKey);
/*  62 */     if (forkedEvaluationCell == null) {
/*  63 */       return this._masterSheet.getCell(paramInt1, paramInt2);
/*     */     }
/*  65 */     return forkedEvaluationCell;
/*     */   }
/*     */   
/*     */   public ForkedEvaluationCell getOrCreateUpdatableCell(int paramInt1, int paramInt2) {
/*  69 */     RowColKey rowColKey = new RowColKey(paramInt1, paramInt2);
/*     */     
/*  71 */     ForkedEvaluationCell forkedEvaluationCell = this._sharedCellsByRowCol.get(rowColKey);
/*  72 */     if (forkedEvaluationCell == null) {
/*  73 */       EvaluationCell evaluationCell = this._masterSheet.getCell(paramInt1, paramInt2);
/*  74 */       if (evaluationCell == null) {
/*  75 */         CellReference cellReference = new CellReference(paramInt1, paramInt2);
/*  76 */         throw new UnsupportedOperationException("Underlying cell '" + cellReference.formatAsString() + "' is missing in master sheet.");
/*     */       } 
/*     */       
/*  79 */       forkedEvaluationCell = new ForkedEvaluationCell(this, evaluationCell);
/*  80 */       this._sharedCellsByRowCol.put(rowColKey, forkedEvaluationCell);
/*     */     } 
/*  82 */     return forkedEvaluationCell;
/*     */   }
/*     */   
/*     */   public void copyUpdatedCells(Sheet paramSheet) {
/*  86 */     RowColKey[] arrayOfRowColKey = new RowColKey[this._sharedCellsByRowCol.size()];
/*  87 */     this._sharedCellsByRowCol.keySet().toArray((Object[])arrayOfRowColKey);
/*  88 */     Arrays.sort((Object[])arrayOfRowColKey);
/*  89 */     for (byte b = 0; b < arrayOfRowColKey.length; b++) {
/*  90 */       RowColKey rowColKey = arrayOfRowColKey[b];
/*  91 */       Row row = paramSheet.getRow(rowColKey.getRowIndex());
/*  92 */       if (row == null) {
/*  93 */         row = paramSheet.createRow(rowColKey.getRowIndex());
/*     */       }
/*  95 */       Cell cell = row.getCell(rowColKey.getColumnIndex());
/*  96 */       if (cell == null) {
/*  97 */         cell = row.createCell(rowColKey.getColumnIndex());
/*     */       }
/*     */       
/* 100 */       ForkedEvaluationCell forkedEvaluationCell = this._sharedCellsByRowCol.get(rowColKey);
/* 101 */       forkedEvaluationCell.copyValue(cell);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getSheetIndex(EvaluationWorkbook paramEvaluationWorkbook) {
/* 106 */     return paramEvaluationWorkbook.getSheetIndex(this._masterSheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearAllCachedResultValues() {
/* 117 */     this._masterSheet.clearAllCachedResultValues();
/*     */   }
/*     */   
/*     */   private static final class RowColKey
/*     */     implements Comparable<RowColKey> {
/*     */     private final int _rowIndex;
/*     */     private final int _columnIndex;
/*     */     
/*     */     public RowColKey(int param1Int1, int param1Int2) {
/* 126 */       this._rowIndex = param1Int1;
/* 127 */       this._columnIndex = param1Int2;
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 131 */       assert param1Object instanceof RowColKey : "these private cache key instances are only compared to themselves";
/* 132 */       RowColKey rowColKey = (RowColKey)param1Object;
/* 133 */       return (this._rowIndex == rowColKey._rowIndex && this._columnIndex == rowColKey._columnIndex);
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 137 */       return this._rowIndex ^ this._columnIndex;
/*     */     }
/*     */     public int compareTo(RowColKey param1RowColKey) {
/* 140 */       int i = this._rowIndex - param1RowColKey._rowIndex;
/* 141 */       if (i != 0) {
/* 142 */         return i;
/*     */       }
/* 144 */       return this._columnIndex - param1RowColKey._columnIndex;
/*     */     }
/*     */     public int getRowIndex() {
/* 147 */       return this._rowIndex;
/*     */     }
/*     */     public int getColumnIndex() {
/* 150 */       return this._columnIndex;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\forked\ForkedEvaluationSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */