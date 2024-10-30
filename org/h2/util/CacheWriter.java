package org.h2.util;

import org.h2.message.Trace;

public interface CacheWriter {
  void writeBack(CacheObject paramCacheObject);
  
  void flushLog();
  
  Trace getTrace();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\CacheWriter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */