package org.apache.xmlbeans.impl.piccolo.io;

import java.io.CharConversionException;

public interface CharsetDecoder {
  int minBytesPerChar();
  
  int maxBytesPerChar();
  
  void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException;
  
  CharsetDecoder newCharsetDecoder();
  
  void reset();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\io\CharsetDecoder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */