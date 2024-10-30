package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.ss.formula.TwoDEval;

public interface AreaEval extends ThreeDEval, TwoDEval {
  int getFirstRow();
  
  int getLastRow();
  
  int getFirstColumn();
  
  int getLastColumn();
  
  ValueEval getAbsoluteValue(int paramInt1, int paramInt2);
  
  boolean contains(int paramInt1, int paramInt2);
  
  boolean containsColumn(int paramInt);
  
  boolean containsRow(int paramInt);
  
  int getWidth();
  
  int getHeight();
  
  ValueEval getRelativeValue(int paramInt1, int paramInt2);
  
  AreaEval offset(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\AreaEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */