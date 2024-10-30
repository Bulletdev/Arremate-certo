package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;

public interface Function4Arg extends Function {
  ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, ValueEval paramValueEval4);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Function4Arg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */