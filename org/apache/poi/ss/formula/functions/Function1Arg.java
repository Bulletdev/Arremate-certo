package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

public interface Function1Arg extends Function {
  ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Function1Arg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */