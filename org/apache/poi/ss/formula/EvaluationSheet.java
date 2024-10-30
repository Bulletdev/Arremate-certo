package org.apache.poi.ss.formula;

import org.apache.poi.util.Internal;

@Internal
public interface EvaluationSheet {
  EvaluationCell getCell(int paramInt1, int paramInt2);
  
  void clearAllCachedResultValues();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\EvaluationSheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */