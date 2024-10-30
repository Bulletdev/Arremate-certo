package org.h2.result;

import org.h2.value.Value;

public interface ResultTarget {
  void addRow(Value[] paramArrayOfValue);
  
  int getRowCount();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\ResultTarget.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */