package org.apache.poi.util;

public interface LittleEndianOutput {
  void writeByte(int paramInt);
  
  void writeShort(int paramInt);
  
  void writeInt(int paramInt);
  
  void writeLong(long paramLong);
  
  void writeDouble(double paramDouble);
  
  void write(byte[] paramArrayOfbyte);
  
  void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LittleEndianOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */