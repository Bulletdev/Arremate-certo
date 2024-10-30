package org.apache.poi.util;

public interface LittleEndianInput {
  int available();
  
  byte readByte();
  
  int readUByte();
  
  short readShort();
  
  int readUShort();
  
  int readInt();
  
  long readLong();
  
  double readDouble();
  
  void readFully(byte[] paramArrayOfbyte);
  
  void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LittleEndianInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */