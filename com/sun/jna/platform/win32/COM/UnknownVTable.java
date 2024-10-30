package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

@FieldOrder({"QueryInterfaceCallback", "AddRefCallback", "ReleaseCallback"})
public class UnknownVTable extends Structure {
  public QueryInterfaceCallback QueryInterfaceCallback;
  
  public AddRefCallback AddRefCallback;
  
  public ReleaseCallback ReleaseCallback;
  
  public static interface ReleaseCallback extends StdCallLibrary.StdCallCallback {
    int invoke(Pointer param1Pointer);
  }
  
  public static interface AddRefCallback extends StdCallLibrary.StdCallCallback {
    int invoke(Pointer param1Pointer);
  }
  
  public static interface QueryInterfaceCallback extends StdCallLibrary.StdCallCallback {
    WinNT.HRESULT invoke(Pointer param1Pointer, Guid.REFIID param1REFIID, PointerByReference param1PointerByReference);
  }
  
  public static class ByReference extends UnknownVTable implements Structure.ByReference {}
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\UnknownVTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */