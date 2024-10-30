package com.sun.jna.platform.win32.COM.util;

import java.util.List;

public interface IRunningObjectTable {
  Iterable<IDispatch> enumRunning();
  
  <T> List<T> getActiveObjectsByInterface(Class<T> paramClass);
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\IRunningObjectTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */