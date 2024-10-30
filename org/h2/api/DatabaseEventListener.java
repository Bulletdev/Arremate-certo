package org.h2.api;

import java.sql.SQLException;
import java.util.EventListener;

public interface DatabaseEventListener extends EventListener {
  public static final int STATE_SCAN_FILE = 0;
  
  public static final int STATE_CREATE_INDEX = 1;
  
  public static final int STATE_RECOVER = 2;
  
  public static final int STATE_BACKUP_FILE = 3;
  
  public static final int STATE_RECONNECTED = 4;
  
  public static final int STATE_STATEMENT_START = 5;
  
  public static final int STATE_STATEMENT_END = 6;
  
  public static final int STATE_STATEMENT_PROGRESS = 7;
  
  void init(String paramString);
  
  void opened();
  
  void exceptionThrown(SQLException paramSQLException, String paramString);
  
  void setProgress(int paramInt1, String paramString, int paramInt2, int paramInt3);
  
  void closingDatabase();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\api\DatabaseEventListener.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */