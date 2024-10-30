package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ValueEval;

public interface FreeRefFunction {
  ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\FreeRefFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */