package org.apache.poi.openxml4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

public interface ZipEntrySource {
  Enumeration<? extends ZipEntry> getEntries();
  
  InputStream getInputStream(ZipEntry paramZipEntry) throws IOException;
  
  void close() throws IOException;
  
  boolean isClosed();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4\\util\ZipEntrySource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */