package org.h2.api;

import java.sql.Connection;
import java.sql.SQLException;

public interface AggregateFunction {
  void init(Connection paramConnection) throws SQLException;
  
  int getType(int[] paramArrayOfint) throws SQLException;
  
  void add(Object paramObject) throws SQLException;
  
  Object getResult() throws SQLException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\api\AggregateFunction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */