package org.h2.compress;

public interface Compressor {
  public static final int NO = 0;
  
  public static final int LZF = 1;
  
  public static final int DEFLATE = 2;
  
  int getAlgorithm();
  
  int compress(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2);
  
  void expand(byte[] paramArrayOfbyte1, int paramInt1, int paramInt2, byte[] paramArrayOfbyte2, int paramInt3, int paramInt4);
  
  void setOptions(String paramString);
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\compress\Compressor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */