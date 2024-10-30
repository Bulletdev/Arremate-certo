package oshi.hardware;

import java.util.List;
import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface HWDiskStore {
  String getName();
  
  String getModel();
  
  String getSerial();
  
  long getSize();
  
  long getReads();
  
  long getReadBytes();
  
  long getWrites();
  
  long getWriteBytes();
  
  long getCurrentQueueLength();
  
  long getTransferTime();
  
  List<HWPartition> getPartitions();
  
  long getTimeStamp();
  
  boolean updateAttributes();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\HWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */