package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

public interface Function {
  ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Function.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */