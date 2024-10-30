package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.SheetRange;

public interface RefEval extends SheetRange, ValueEval {
  ValueEval getInnerValueEval(int paramInt);
  
  int getColumn();
  
  int getRow();
  
  int getFirstSheetIndex();
  
  int getLastSheetIndex();
  
  int getNumberOfSheets();
  
  AreaEval offset(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\RefEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */