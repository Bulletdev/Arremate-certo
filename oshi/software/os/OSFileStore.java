package oshi.software.os;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface OSFileStore {
  String getName();
  
  String getVolume();
  
  String getLabel();
  
  String getLogicalVolume();
  
  String getMount();
  
  String getDescription();
  
  String getType();
  
  String getOptions();
  
  String getUUID();
  
  long getFreeSpace();
  
  long getUsableSpace();
  
  long getTotalSpace();
  
  long getFreeInodes();
  
  long getTotalInodes();
  
  boolean updateAttributes();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\OSFileStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */