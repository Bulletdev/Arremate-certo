package org.h2.api;

import java.sql.Connection;
import java.sql.SQLException;

public interface Trigger {
  public static final int INSERT = 1;
  
  public static final int UPDATE = 2;
  
  public static final int DELETE = 4;
  
  public static final int SELECT = 8;
  
  void init(Connection paramConnection, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt) throws SQLException;
  
  void fire(Connection paramConnection, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) throws SQLException;
  
  void close() throws SQLException;
  
  void remove() throws SQLException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\api\Trigger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */