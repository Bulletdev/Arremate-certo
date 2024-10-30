package org.apache.poi.hssf.record.crypto;

public interface Biff8Cipher {
  void startRecord(int paramInt);
  
  void setNextRecordSize(int paramInt);
  
  void skipTwoBytes();
  
  void xor(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  int xorByte(int paramInt);
  
  int xorShort(int paramInt);
  
  int xorInt(int paramInt);
  
  long xorLong(long paramLong);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\crypto\Biff8Cipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */