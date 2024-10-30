package oshi.hardware;

import oshi.annotation.concurrent.Immutable;

@Immutable
public interface GraphicsCard {
  String getName();
  
  String getDeviceId();
  
  String getVendor();
  
  String getVersionInfo();
  
  long getVRam();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\GraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */