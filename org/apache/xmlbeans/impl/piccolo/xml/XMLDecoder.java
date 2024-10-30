package org.apache.xmlbeans.impl.piccolo.xml;

import java.io.CharConversionException;
import org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder;

public interface XMLDecoder extends CharsetDecoder {
  void decodeXMLDecl(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException;
  
  XMLDecoder newXMLDecoder();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\XMLDecoder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */