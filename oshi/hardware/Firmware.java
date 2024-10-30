package oshi.hardware;

import oshi.annotation.concurrent.Immutable;

@Immutable
public interface Firmware {
  String getManufacturer();
  
  String getName();
  
  String getDescription();
  
  String getVersion();
  
  String getReleaseDate();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\Firmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */