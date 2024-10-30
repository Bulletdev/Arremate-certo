/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*     */ 
/*     */ 
/*     */ final class FormulaCellCacheEntry
/*     */   extends CellCacheEntry
/*     */ {
/*     */   private CellCacheEntry[] _sensitiveInputCells;
/*     */   private FormulaUsedBlankCellSet _usedBlankCellGroup;
/*     */   
/*     */   public boolean isInputSensitive() {
/*  47 */     if (this._sensitiveInputCells != null && 
/*  48 */       this._sensitiveInputCells.length > 0) {
/*  49 */       return true;
/*     */     }
/*     */     
/*  52 */     return (this._usedBlankCellGroup == null) ? false : (!this._usedBlankCellGroup.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSensitiveInputCells(CellCacheEntry[] paramArrayOfCellCacheEntry) {
/*  58 */     if (paramArrayOfCellCacheEntry == null) {
/*  59 */       this._sensitiveInputCells = null;
/*  60 */       changeConsumingCells(CellCacheEntry.EMPTY_ARRAY);
/*     */     } else {
/*  62 */       this._sensitiveInputCells = (CellCacheEntry[])paramArrayOfCellCacheEntry.clone();
/*  63 */       changeConsumingCells(this._sensitiveInputCells);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clearFormulaEntry() {
/*  68 */     CellCacheEntry[] arrayOfCellCacheEntry = this._sensitiveInputCells;
/*  69 */     if (arrayOfCellCacheEntry != null) {
/*  70 */       for (int i = arrayOfCellCacheEntry.length - 1; i >= 0; i--) {
/*  71 */         arrayOfCellCacheEntry[i].clearConsumingCell(this);
/*     */       }
/*     */     }
/*  74 */     this._sensitiveInputCells = null;
/*  75 */     clearValue();
/*     */   }
/*     */   
/*     */   private void changeConsumingCells(CellCacheEntry[] paramArrayOfCellCacheEntry) {
/*     */     Set<?> set;
/*  80 */     CellCacheEntry[] arrayOfCellCacheEntry = this._sensitiveInputCells;
/*  81 */     int i = paramArrayOfCellCacheEntry.length; int j;
/*  82 */     for (j = 0; j < i; j++) {
/*  83 */       paramArrayOfCellCacheEntry[j].addConsumingCell(this);
/*     */     }
/*  85 */     if (arrayOfCellCacheEntry == null) {
/*     */       return;
/*     */     }
/*  88 */     j = arrayOfCellCacheEntry.length;
/*  89 */     if (j < 1) {
/*     */       return;
/*     */     }
/*     */     
/*  93 */     if (i < 1) {
/*  94 */       set = Collections.emptySet();
/*     */     } else {
/*  96 */       set = new HashSet(i * 3 / 2);
/*  97 */       for (byte b1 = 0; b1 < i; b1++) {
/*  98 */         set.add(paramArrayOfCellCacheEntry[b1]);
/*     */       }
/*     */     } 
/* 101 */     for (byte b = 0; b < j; b++) {
/* 102 */       CellCacheEntry cellCacheEntry = arrayOfCellCacheEntry[b];
/* 103 */       if (!set.contains(cellCacheEntry))
/*     */       {
/* 105 */         cellCacheEntry.clearConsumingCell(this);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void updateFormulaResult(ValueEval paramValueEval, CellCacheEntry[] paramArrayOfCellCacheEntry, FormulaUsedBlankCellSet paramFormulaUsedBlankCellSet) {
/* 111 */     updateValue(paramValueEval);
/* 112 */     setSensitiveInputCells(paramArrayOfCellCacheEntry);
/* 113 */     this._usedBlankCellGroup = paramFormulaUsedBlankCellSet;
/*     */   }
/*     */   
/*     */   public void notifyUpdatedBlankCell(FormulaUsedBlankCellSet.BookSheetKey paramBookSheetKey, int paramInt1, int paramInt2, IEvaluationListener paramIEvaluationListener) {
/* 117 */     if (this._usedBlankCellGroup != null && 
/* 118 */       this._usedBlankCellGroup.containsCell(paramBookSheetKey, paramInt1, paramInt2)) {
/* 119 */       clearFormulaEntry();
/* 120 */       recurseClearCachedFormulaResults(paramIEvaluationListener);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\FormulaCellCacheEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */