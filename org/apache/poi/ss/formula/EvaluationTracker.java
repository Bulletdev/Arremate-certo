/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
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
/*     */ final class EvaluationTracker
/*     */ {
/*     */   private final List<CellEvaluationFrame> _evaluationFrames;
/*     */   private final Set<FormulaCellCacheEntry> _currentlyEvaluatingCells;
/*     */   private final EvaluationCache _cache;
/*     */   
/*     */   public EvaluationTracker(EvaluationCache paramEvaluationCache) {
/*  45 */     this._cache = paramEvaluationCache;
/*  46 */     this._evaluationFrames = new ArrayList<CellEvaluationFrame>();
/*  47 */     this._currentlyEvaluatingCells = new HashSet<FormulaCellCacheEntry>();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean startEvaluate(FormulaCellCacheEntry paramFormulaCellCacheEntry) {
/*  65 */     if (paramFormulaCellCacheEntry == null) {
/*  66 */       throw new IllegalArgumentException("cellLoc must not be null");
/*     */     }
/*  68 */     if (this._currentlyEvaluatingCells.contains(paramFormulaCellCacheEntry)) {
/*  69 */       return false;
/*     */     }
/*  71 */     this._currentlyEvaluatingCells.add(paramFormulaCellCacheEntry);
/*  72 */     this._evaluationFrames.add(new CellEvaluationFrame(paramFormulaCellCacheEntry));
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateCacheResult(ValueEval paramValueEval) {
/*  78 */     int i = this._evaluationFrames.size();
/*  79 */     if (i < 1) {
/*  80 */       throw new IllegalStateException("Call to endEvaluate without matching call to startEvaluate");
/*     */     }
/*  82 */     CellEvaluationFrame cellEvaluationFrame = this._evaluationFrames.get(i - 1);
/*  83 */     if (paramValueEval == ErrorEval.CIRCULAR_REF_ERROR && i > 1) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     cellEvaluationFrame.updateFormulaResult(paramValueEval);
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
/*     */ 
/*     */   
/*     */   public void endEvaluate(CellCacheEntry paramCellCacheEntry) {
/* 108 */     int i = this._evaluationFrames.size();
/* 109 */     if (i < 1) {
/* 110 */       throw new IllegalStateException("Call to endEvaluate without matching call to startEvaluate");
/*     */     }
/*     */     
/* 113 */     i--;
/* 114 */     CellEvaluationFrame cellEvaluationFrame = this._evaluationFrames.get(i);
/* 115 */     if (paramCellCacheEntry != cellEvaluationFrame.getCCE()) {
/* 116 */       throw new IllegalStateException("Wrong cell specified. ");
/*     */     }
/*     */     
/* 119 */     this._evaluationFrames.remove(i);
/* 120 */     this._currentlyEvaluatingCells.remove(paramCellCacheEntry);
/*     */   }
/*     */ 
/*     */   
/*     */   public void acceptFormulaDependency(CellCacheEntry paramCellCacheEntry) {
/* 125 */     int i = this._evaluationFrames.size() - 1;
/* 126 */     if (i >= 0) {
/*     */ 
/*     */       
/* 129 */       CellEvaluationFrame cellEvaluationFrame = this._evaluationFrames.get(i);
/* 130 */       cellEvaluationFrame.addSensitiveInputCell(paramCellCacheEntry);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void acceptPlainValueDependency(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ValueEval paramValueEval) {
/* 137 */     int i = this._evaluationFrames.size() - 1;
/* 138 */     if (i >= 0) {
/*     */ 
/*     */       
/* 141 */       CellEvaluationFrame cellEvaluationFrame = this._evaluationFrames.get(i);
/* 142 */       if (paramValueEval == BlankEval.instance) {
/* 143 */         cellEvaluationFrame.addUsedBlankCell(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */       } else {
/* 145 */         PlainValueCellCacheEntry plainValueCellCacheEntry = this._cache.getPlainValueEntry(paramInt1, paramInt2, paramInt3, paramInt4, paramValueEval);
/*     */         
/* 147 */         cellEvaluationFrame.addSensitiveInputCell(plainValueCellCacheEntry);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\EvaluationTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */