package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;

public interface FixedField {
  void readFromBytes(byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException;
  
  void readFromStream(InputStream paramInputStream) throws IOException;
  
  void writeToBytes(byte[] paramArrayOfbyte) throws ArrayIndexOutOfBoundsException;
  
  String toString();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\FixedField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */