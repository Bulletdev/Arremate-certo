package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

public interface TwoDEval extends ValueEval {
  ValueEval getValue(int paramInt1, int paramInt2);
  
  int getWidth();
  
  int getHeight();
  
  boolean isRow();
  
  boolean isColumn();
  
  TwoDEval getRow(int paramInt);
  
  TwoDEval getColumn(int paramInt);
  
  boolean isSubTotal(int paramInt1, int paramInt2);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\TwoDEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */