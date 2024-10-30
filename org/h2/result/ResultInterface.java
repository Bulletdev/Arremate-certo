package org.h2.result;

import org.h2.value.Value;

public interface ResultInterface extends AutoCloseable {
  void reset();
  
  Value[] currentRow();
  
  boolean next();
  
  int getRowId();
  
  int getVisibleColumnCount();
  
  int getRowCount();
  
  boolean needToClose();
  
  void close();
  
  String getAlias(int paramInt);
  
  String getSchemaName(int paramInt);
  
  String getTableName(int paramInt);
  
  String getColumnName(int paramInt);
  
  int getColumnType(int paramInt);
  
  long getColumnPrecision(int paramInt);
  
  int getColumnScale(int paramInt);
  
  int getDisplaySize(int paramInt);
  
  boolean isAutoIncrement(int paramInt);
  
  int getNullable(int paramInt);
  
  void setFetchSize(int paramInt);
  
  int getFetchSize();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\ResultInterface.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */