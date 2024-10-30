package org.apache.xmlbeans;

import java.io.InputStream;

public interface ResourceLoader {
  InputStream getResourceAsStream(String paramString);
  
  void close();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\ResourceLoader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */