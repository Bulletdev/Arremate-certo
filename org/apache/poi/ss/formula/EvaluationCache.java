/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.usermodel.CellType;
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
/*     */ final class EvaluationCache
/*     */ {
/*     */   private final PlainCellCache _plainCellCache;
/*     */   private final FormulaCellCache _formulaCellCache;
/*     */   final IEvaluationListener _evaluationListener;
/*     */   
/*     */   EvaluationCache(IEvaluationListener paramIEvaluationListener) {
/*  46 */     this._evaluationListener = paramIEvaluationListener;
/*  47 */     this._plainCellCache = new PlainCellCache();
/*  48 */     this._formulaCellCache = new FormulaCellCache();
/*     */   }
/*     */   
/*     */   public void notifyUpdateCell(int paramInt1, int paramInt2, EvaluationCell paramEvaluationCell) {
/*  52 */     FormulaCellCacheEntry formulaCellCacheEntry = this._formulaCellCache.get(paramEvaluationCell);
/*     */     
/*  54 */     int i = paramEvaluationCell.getRowIndex();
/*  55 */     int j = paramEvaluationCell.getColumnIndex();
/*  56 */     PlainCellCache.Loc loc = new PlainCellCache.Loc(paramInt1, paramInt2, i, j);
/*  57 */     PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(loc);
/*     */     
/*  59 */     if (paramEvaluationCell.getCellTypeEnum() == CellType.FORMULA) {
/*  60 */       if (formulaCellCacheEntry == null) {
/*  61 */         formulaCellCacheEntry = new FormulaCellCacheEntry();
/*  62 */         if (plainValueCellCacheEntry == null) {
/*  63 */           if (this._evaluationListener != null) {
/*  64 */             this._evaluationListener.onChangeFromBlankValue(paramInt2, i, j, paramEvaluationCell, formulaCellCacheEntry);
/*     */           }
/*     */           
/*  67 */           updateAnyBlankReferencingFormulas(paramInt1, paramInt2, i, j);
/*     */         } 
/*     */         
/*  70 */         this._formulaCellCache.put(paramEvaluationCell, formulaCellCacheEntry);
/*     */       } else {
/*  72 */         formulaCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
/*  73 */         formulaCellCacheEntry.clearFormulaEntry();
/*     */       } 
/*  75 */       if (plainValueCellCacheEntry != null) {
/*     */ 
/*     */ 
/*     */         
/*  79 */         plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
/*  80 */         this._plainCellCache.remove(loc);
/*     */       } 
/*     */     } else {
/*  83 */       ValueEval valueEval = WorkbookEvaluator.getValueFromNonFormulaCell(paramEvaluationCell);
/*  84 */       if (plainValueCellCacheEntry == null) {
/*  85 */         if (valueEval != BlankEval.instance) {
/*     */ 
/*     */ 
/*     */           
/*  89 */           plainValueCellCacheEntry = new PlainValueCellCacheEntry(valueEval);
/*  90 */           if (formulaCellCacheEntry == null) {
/*  91 */             if (this._evaluationListener != null) {
/*  92 */               this._evaluationListener.onChangeFromBlankValue(paramInt2, i, j, paramEvaluationCell, plainValueCellCacheEntry);
/*     */             }
/*  94 */             updateAnyBlankReferencingFormulas(paramInt1, paramInt2, i, j);
/*     */           } 
/*     */           
/*  97 */           this._plainCellCache.put(loc, plainValueCellCacheEntry);
/*     */         } 
/*     */       } else {
/* 100 */         if (plainValueCellCacheEntry.updateValue(valueEval)) {
/* 101 */           plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
/*     */         }
/* 103 */         if (valueEval == BlankEval.instance) {
/* 104 */           this._plainCellCache.remove(loc);
/*     */         }
/*     */       } 
/* 107 */       if (formulaCellCacheEntry != null) {
/*     */ 
/*     */ 
/*     */         
/* 111 */         this._formulaCellCache.remove(paramEvaluationCell);
/* 112 */         formulaCellCacheEntry.setSensitiveInputCells((CellCacheEntry[])null);
/* 113 */         formulaCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void updateAnyBlankReferencingFormulas(int paramInt1, int paramInt2, final int rowIndex, final int columnIndex) {
/* 120 */     final FormulaUsedBlankCellSet.BookSheetKey bsk = new FormulaUsedBlankCellSet.BookSheetKey(paramInt1, paramInt2);
/* 121 */     this._formulaCellCache.applyOperation(new FormulaCellCache.IEntryOperation()
/*     */         {
/*     */           public void processEntry(FormulaCellCacheEntry param1FormulaCellCacheEntry) {
/* 124 */             param1FormulaCellCacheEntry.notifyUpdatedBlankCell(bsk, rowIndex, columnIndex, EvaluationCache.this._evaluationListener);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PlainValueCellCacheEntry getPlainValueEntry(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ValueEval paramValueEval) {
/* 132 */     PlainCellCache.Loc loc = new PlainCellCache.Loc(paramInt1, paramInt2, paramInt3, paramInt4);
/* 133 */     PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(loc);
/* 134 */     if (plainValueCellCacheEntry == null) {
/* 135 */       plainValueCellCacheEntry = new PlainValueCellCacheEntry(paramValueEval);
/* 136 */       this._plainCellCache.put(loc, plainValueCellCacheEntry);
/* 137 */       if (this._evaluationListener != null) {
/* 138 */         this._evaluationListener.onReadPlainValue(paramInt2, paramInt3, paramInt4, plainValueCellCacheEntry);
/*     */       }
/*     */     } else {
/*     */       
/* 142 */       if (!areValuesEqual(plainValueCellCacheEntry.getValue(), paramValueEval)) {
/* 143 */         throw new IllegalStateException("value changed");
/*     */       }
/* 145 */       if (this._evaluationListener != null) {
/* 146 */         this._evaluationListener.onCacheHit(paramInt2, paramInt3, paramInt4, paramValueEval);
/*     */       }
/*     */     } 
/* 149 */     return plainValueCellCacheEntry;
/*     */   }
/*     */   private boolean areValuesEqual(ValueEval paramValueEval1, ValueEval paramValueEval2) {
/* 152 */     if (paramValueEval1 == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     Class<?> clazz = paramValueEval1.getClass();
/* 156 */     if (clazz != paramValueEval2.getClass())
/*     */     {
/* 158 */       return false;
/*     */     }
/* 160 */     if (paramValueEval1 == BlankEval.instance) {
/* 161 */       return (paramValueEval2 == paramValueEval1);
/*     */     }
/* 163 */     if (clazz == NumberEval.class) {
/* 164 */       return (((NumberEval)paramValueEval1).getNumberValue() == ((NumberEval)paramValueEval2).getNumberValue());
/*     */     }
/* 166 */     if (clazz == StringEval.class) {
/* 167 */       return ((StringEval)paramValueEval1).getStringValue().equals(((StringEval)paramValueEval2).getStringValue());
/*     */     }
/* 169 */     if (clazz == BoolEval.class) {
/* 170 */       return (((BoolEval)paramValueEval1).getBooleanValue() == ((BoolEval)paramValueEval2).getBooleanValue());
/*     */     }
/* 172 */     if (clazz == ErrorEval.class) {
/* 173 */       return (((ErrorEval)paramValueEval1).getErrorCode() == ((ErrorEval)paramValueEval2).getErrorCode());
/*     */     }
/* 175 */     throw new IllegalStateException("Unexpected value class (" + clazz.getName() + ")");
/*     */   }
/*     */   
/*     */   public FormulaCellCacheEntry getOrCreateFormulaCellEntry(EvaluationCell paramEvaluationCell) {
/* 179 */     FormulaCellCacheEntry formulaCellCacheEntry = this._formulaCellCache.get(paramEvaluationCell);
/* 180 */     if (formulaCellCacheEntry == null) {
/*     */       
/* 182 */       formulaCellCacheEntry = new FormulaCellCacheEntry();
/* 183 */       this._formulaCellCache.put(paramEvaluationCell, formulaCellCacheEntry);
/*     */     } 
/* 185 */     return formulaCellCacheEntry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 192 */     if (this._evaluationListener != null) {
/* 193 */       this._evaluationListener.onClearWholeCache();
/*     */     }
/* 195 */     this._plainCellCache.clear();
/* 196 */     this._formulaCellCache.clear();
/*     */   }
/*     */   
/*     */   public void notifyDeleteCell(int paramInt1, int paramInt2, EvaluationCell paramEvaluationCell) {
/* 200 */     if (paramEvaluationCell.getCellTypeEnum() == CellType.FORMULA) {
/* 201 */       FormulaCellCacheEntry formulaCellCacheEntry = this._formulaCellCache.remove(paramEvaluationCell);
/* 202 */       if (formulaCellCacheEntry != null) {
/*     */ 
/*     */         
/* 205 */         formulaCellCacheEntry.setSensitiveInputCells((CellCacheEntry[])null);
/* 206 */         formulaCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
/*     */       } 
/*     */     } else {
/* 209 */       PlainCellCache.Loc loc = new PlainCellCache.Loc(paramInt1, paramInt2, paramEvaluationCell.getRowIndex(), paramEvaluationCell.getColumnIndex());
/* 210 */       PlainValueCellCacheEntry plainValueCellCacheEntry = this._plainCellCache.get(loc);
/*     */       
/* 212 */       if (plainValueCellCacheEntry != null)
/*     */       {
/*     */         
/* 215 */         plainValueCellCacheEntry.recurseClearCachedFormulaResults(this._evaluationListener);
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\EvaluationCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */