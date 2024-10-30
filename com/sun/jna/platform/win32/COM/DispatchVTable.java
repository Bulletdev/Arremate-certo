package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.StdCallLibrary;

@FieldOrder({"QueryInterfaceCallback", "AddRefCallback", "ReleaseCallback", "GetTypeInfoCountCallback", "GetTypeInfoCallback", "GetIDsOfNamesCallback", "InvokeCallback"})
public class DispatchVTable extends Structure {
  public QueryInterfaceCallback QueryInterfaceCallback;
  
  public AddRefCallback AddRefCallback;
  
  public ReleaseCallback ReleaseCallback;
  
  public GetTypeInfoCountCallback GetTypeInfoCountCallback;
  
  public GetTypeInfoCallback GetTypeInfoCallback;
  
  public GetIDsOfNamesCallback GetIDsOfNamesCallback;
  
  public InvokeCallback InvokeCallback;
  
  public static interface InvokeCallback extends StdCallLibrary.StdCallCallback {
    WinNT.HRESULT invoke(Pointer param1Pointer, OaIdl.DISPID param1DISPID, Guid.REFIID param1REFIID, WinDef.LCID param1LCID, WinDef.WORD param1WORD, OleAuto.DISPPARAMS.ByReference param1ByReference, Variant.VARIANT.ByReference param1ByReference1, OaIdl.EXCEPINFO.ByReference param1ByReference2, IntByReference param1IntByReference);
  }
  
  public static interface GetIDsOfNamesCallback extends StdCallLibrary.StdCallCallback {
    WinNT.HRESULT invoke(Pointer param1Pointer, Guid.REFIID param1REFIID, WString[] param1ArrayOfWString, int param1Int, WinDef.LCID param1LCID, OaIdl.DISPIDByReference param1DISPIDByReference);
  }
  
  public static interface GetTypeInfoCallback extends StdCallLibrary.StdCallCallback {
    WinNT.HRESULT invoke(Pointer param1Pointer, WinDef.UINT param1UINT, WinDef.LCID param1LCID, PointerByReference param1PointerByReference);
  }
  
  public static interface GetTypeInfoCountCallback extends StdCallLibrary.StdCallCallback {
    WinNT.HRESULT invoke(Pointer param1Pointer, WinDef.UINTByReference param1UINTByReference);
  }
  
  public static interface ReleaseCallback extends StdCallLibrary.StdCallCallback {
    int invoke(Pointer param1Pointer);
  }
  
  public static interface AddRefCallback extends StdCallLibrary.StdCallCallback {
    int invoke(Pointer param1Pointer);
  }
  
  public static interface QueryInterfaceCallback extends StdCallLibrary.StdCallCallback {
    WinNT.HRESULT invoke(Pointer param1Pointer, Guid.REFIID param1REFIID, PointerByReference param1PointerByReference);
  }
  
  public static class ByReference extends DispatchVTable implements Structure.ByReference {}
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\DispatchVTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */