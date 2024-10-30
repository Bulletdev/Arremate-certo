package oshi.hardware;

import java.util.Map;
import java.util.Set;
import oshi.annotation.concurrent.Immutable;

@Immutable
public interface LogicalVolumeGroup {
  String getName();
  
  Set<String> getPhysicalVolumes();
  
  Map<String, Set<String>> getLogicalVolumes();
}


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\LogicalVolumeGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */