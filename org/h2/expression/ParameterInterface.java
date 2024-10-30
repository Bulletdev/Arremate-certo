package org.h2.expression;

import org.h2.message.DbException;
import org.h2.value.Value;

public interface ParameterInterface {
  void setValue(Value paramValue, boolean paramBoolean);
  
  Value getParamValue();
  
  void checkSet() throws DbException;
  
  boolean isValueSet();
  
  int getType();
  
  long getPrecision();
  
  int getScale();
  
  int getNullable();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\ParameterInterface.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */