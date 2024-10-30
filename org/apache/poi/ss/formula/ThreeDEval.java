package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

public interface ThreeDEval extends SheetRange, TwoDEval {
  ValueEval getValue(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ThreeDEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */