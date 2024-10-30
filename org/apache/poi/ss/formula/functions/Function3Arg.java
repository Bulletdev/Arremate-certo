package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

public interface Function3Arg extends Function {
  ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Function3Arg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */