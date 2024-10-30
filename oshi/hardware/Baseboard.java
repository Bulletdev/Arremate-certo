package oshi.hardware;

import oshi.annotation.concurrent.Immutable;

@Immutable
public interface Baseboard {
  String getManufacturer();
  
  String getModel();
  
  String getVersion();
  
  String getSerialNumber();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\Baseboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */