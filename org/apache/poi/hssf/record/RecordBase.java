package org.apache.poi.hssf.record;

public abstract class RecordBase {
  public abstract int serialize(int paramInt, byte[] paramArrayOfbyte);
  
  public abstract int getRecordSize();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RecordBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */