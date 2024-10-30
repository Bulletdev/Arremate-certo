package org.apache.xmlbeans.impl.jam.provider;

public interface JamLogger {
  void setVerbose(Class paramClass);
  
  boolean isVerbose(Object paramObject);
  
  boolean isVerbose(Class paramClass);
  
  void setShowWarnings(boolean paramBoolean);
  
  void verbose(String paramString, Object paramObject);
  
  void verbose(Throwable paramThrowable, Object paramObject);
  
  void verbose(String paramString);
  
  void verbose(Throwable paramThrowable);
  
  void warning(Throwable paramThrowable);
  
  void warning(String paramString);
  
  void error(Throwable paramThrowable);
  
  void error(String paramString);
  
  boolean isVerbose();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\provider\JamLogger.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */