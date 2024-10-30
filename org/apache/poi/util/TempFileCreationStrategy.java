package org.apache.poi.util;

import java.io.File;
import java.io.IOException;

public interface TempFileCreationStrategy {
  File createTempFile(String paramString1, String paramString2) throws IOException;
  
  File createTempDirectory(String paramString) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\TempFileCreationStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */