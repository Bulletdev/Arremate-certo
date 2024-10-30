package org.apache.poi.hssf.record;

public interface CellValueRecordInterface {
  int getRow();
  
  short getColumn();
  
  void setRow(int paramInt);
  
  void setColumn(short paramShort);
  
  void setXFIndex(short paramShort);
  
  short getXFIndex();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CellValueRecordInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */