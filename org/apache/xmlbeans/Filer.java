package org.apache.xmlbeans;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public interface Filer {
  OutputStream createBinaryFile(String paramString) throws IOException;
  
  Writer createSourceFile(String paramString) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\Filer.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */