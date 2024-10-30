package oshi.hardware;

import oshi.annotation.concurrent.Immutable;

@Immutable
public interface ComputerSystem {
  String getManufacturer();
  
  String getModel();
  
  String getSerialNumber();
  
  String getHardwareUUID();
  
  Firmware getFirmware();
  
  Baseboard getBaseboard();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\ComputerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */