package oshi.hardware;

import oshi.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface VirtualMemory {
  long getSwapTotal();
  
  long getSwapUsed();
  
  long getVirtualMax();
  
  long getVirtualInUse();
  
  long getSwapPagesIn();
  
  long getSwapPagesOut();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\VirtualMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */