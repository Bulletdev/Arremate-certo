package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

interface IEvaluationListener {
  void onCacheHit(int paramInt1, int paramInt2, int paramInt3, ValueEval paramValueEval);
  
  void onReadPlainValue(int paramInt1, int paramInt2, int paramInt3, ICacheEntry paramICacheEntry);
  
  void onStartEvaluate(EvaluationCell paramEvaluationCell, ICacheEntry paramICacheEntry);
  
  void onEndEvaluate(ICacheEntry paramICacheEntry, ValueEval paramValueEval);
  
  void onClearWholeCache();
  
  void onClearCachedValue(ICacheEntry paramICacheEntry);
  
  void sortDependentCachedValues(ICacheEntry[] paramArrayOfICacheEntry);
  
  void onClearDependentCachedValue(ICacheEntry paramICacheEntry, int paramInt);
  
  void onChangeFromBlankValue(int paramInt1, int paramInt2, int paramInt3, EvaluationCell paramEvaluationCell, ICacheEntry paramICacheEntry);
  
  public static interface ICacheEntry {
    ValueEval getValue();
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\IEvaluationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */