package org.h2.jmx;

public interface DatabaseInfoMBean {
  boolean isExclusive();
  
  boolean isReadOnly();
  
  String getMode();
  
  boolean isMultiThreaded();
  
  boolean isMvcc();
  
  int getLogMode();
  
  void setLogMode(int paramInt);
  
  long getFileWriteCountTotal();
  
  long getFileWriteCount();
  
  long getFileReadCount();
  
  long getFileSize();
  
  int getCacheSizeMax();
  
  void setCacheSizeMax(int paramInt);
  
  int getCacheSize();
  
  String getVersion();
  
  int getTraceLevel();
  
  void setTraceLevel(int paramInt);
  
  String listSettings();
  
  String listSessions();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jmx\DatabaseInfoMBean.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */