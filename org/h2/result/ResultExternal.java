package org.h2.result;

import java.util.ArrayList;
import org.h2.value.Value;

public interface ResultExternal {
  void reset();
  
  Value[] next();
  
  int addRow(Value[] paramArrayOfValue);
  
  int addRows(ArrayList<Value[]> paramArrayList);
  
  void done();
  
  void close();
  
  int removeRow(Value[] paramArrayOfValue);
  
  boolean contains(Value[] paramArrayOfValue);
  
  ResultExternal createShallowCopy();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\ResultExternal.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */