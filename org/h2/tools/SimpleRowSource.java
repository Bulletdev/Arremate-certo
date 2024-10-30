package org.h2.tools;

import java.sql.SQLException;

public interface SimpleRowSource {
  Object[] readRow() throws SQLException;
  
  void close();
  
  void reset() throws SQLException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\SimpleRowSource.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */