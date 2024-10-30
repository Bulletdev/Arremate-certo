/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
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
/*     */ abstract class CellCacheEntry
/*     */   implements IEvaluationListener.ICacheEntry
/*     */ {
/*  32 */   public static final CellCacheEntry[] EMPTY_ARRAY = new CellCacheEntry[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  39 */   private final FormulaCellCacheEntrySet _consumingCells = new FormulaCellCacheEntrySet();
/*     */   
/*     */   protected final void clearValue() {
/*  42 */     this._value = null;
/*     */   }
/*     */   private ValueEval _value;
/*     */   public final boolean updateValue(ValueEval paramValueEval) {
/*  46 */     if (paramValueEval == null) {
/*  47 */       throw new IllegalArgumentException("Did not expect to update to null");
/*     */     }
/*  49 */     boolean bool = !areValuesEqual(this._value, paramValueEval) ? true : false;
/*  50 */     this._value = paramValueEval;
/*  51 */     return bool;
/*     */   }
/*     */   public final ValueEval getValue() {
/*  54 */     return this._value;
/*     */   }
/*     */   
/*     */   private static boolean areValuesEqual(ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*  58 */     if (paramValueEval1 == null) {
/*  59 */       return false;
/*     */     }
/*  61 */     Class<?> clazz = paramValueEval1.getClass();
/*  62 */     if (clazz != paramValueEval2.getClass())
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     if (paramValueEval1 == BlankEval.instance) {
/*  67 */       return (paramValueEval2 == paramValueEval1);
/*     */     }
/*  69 */     if (clazz == NumberEval.class) {
/*  70 */       return (((NumberEval)paramValueEval1).getNumberValue() == ((NumberEval)paramValueEval2).getNumberValue());
/*     */     }
/*  72 */     if (clazz == StringEval.class) {
/*  73 */       return ((StringEval)paramValueEval1).getStringValue().equals(((StringEval)paramValueEval2).getStringValue());
/*     */     }
/*  75 */     if (clazz == BoolEval.class) {
/*  76 */       return (((BoolEval)paramValueEval1).getBooleanValue() == ((BoolEval)paramValueEval2).getBooleanValue());
/*     */     }
/*  78 */     if (clazz == ErrorEval.class) {
/*  79 */       return (((ErrorEval)paramValueEval1).getErrorCode() == ((ErrorEval)paramValueEval2).getErrorCode());
/*     */     }
/*  81 */     throw new IllegalStateException("Unexpected value class (" + clazz.getName() + ")");
/*     */   }
/*     */   
/*     */   public final void addConsumingCell(FormulaCellCacheEntry paramFormulaCellCacheEntry) {
/*  85 */     this._consumingCells.add(paramFormulaCellCacheEntry);
/*     */   }
/*     */   
/*     */   public final FormulaCellCacheEntry[] getConsumingCells() {
/*  89 */     return this._consumingCells.toArray();
/*     */   }
/*     */   
/*     */   public final void clearConsumingCell(FormulaCellCacheEntry paramFormulaCellCacheEntry) {
/*  93 */     if (!this._consumingCells.remove(paramFormulaCellCacheEntry))
/*  94 */       throw new IllegalStateException("Specified formula cell is not consumed by this cell"); 
/*     */   }
/*     */   
/*     */   public final void recurseClearCachedFormulaResults(IEvaluationListener paramIEvaluationListener) {
/*  98 */     if (paramIEvaluationListener == null) {
/*  99 */       recurseClearCachedFormulaResults();
/*     */     } else {
/* 101 */       paramIEvaluationListener.onClearCachedValue(this);
/* 102 */       recurseClearCachedFormulaResults(paramIEvaluationListener, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void recurseClearCachedFormulaResults() {
/* 113 */     FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry = getConsumingCells();
/*     */     
/* 115 */     for (byte b = 0; b < arrayOfFormulaCellCacheEntry.length; b++) {
/* 116 */       FormulaCellCacheEntry formulaCellCacheEntry = arrayOfFormulaCellCacheEntry[b];
/* 117 */       formulaCellCacheEntry.clearFormulaEntry();
/* 118 */       formulaCellCacheEntry.recurseClearCachedFormulaResults();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void recurseClearCachedFormulaResults(IEvaluationListener paramIEvaluationListener, int paramInt) {
/* 126 */     FormulaCellCacheEntry[] arrayOfFormulaCellCacheEntry = getConsumingCells();
/*     */     
/* 128 */     paramIEvaluationListener.sortDependentCachedValues((IEvaluationListener.ICacheEntry[])arrayOfFormulaCellCacheEntry);
/* 129 */     for (byte b = 0; b < arrayOfFormulaCellCacheEntry.length; b++) {
/* 130 */       FormulaCellCacheEntry formulaCellCacheEntry = arrayOfFormulaCellCacheEntry[b];
/* 131 */       paramIEvaluationListener.onClearDependentCachedValue(formulaCellCacheEntry, paramInt);
/* 132 */       formulaCellCacheEntry.clearFormulaEntry();
/* 133 */       formulaCellCacheEntry.recurseClearCachedFormulaResults(paramIEvaluationListener, paramInt + 1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\CellCacheEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */