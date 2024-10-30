package org.h2.expression;

import org.h2.engine.Session;
import org.h2.value.ValueResultSet;

public interface FunctionCall {
  String getName();
  
  ValueResultSet getValueForColumnList(Session paramSession, Expression[] paramArrayOfExpression);
  
  int getType();
  
  Expression optimize(Session paramSession);
  
  Expression[] getArgs();
  
  String getSQL();
  
  boolean isDeterministic();
  
  boolean isBufferResultSetToLocalTemp();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\FunctionCall.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */