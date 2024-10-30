package com.sun.jna.platform.win32.COM;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

public interface ITypeLib extends IUnknown {
  WinDef.UINT GetTypeInfoCount();
  
  WinNT.HRESULT GetTypeInfo(WinDef.UINT paramUINT, PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetTypeInfoType(WinDef.UINT paramUINT, OaIdl.TYPEKIND.ByReference paramByReference);
  
  WinNT.HRESULT GetTypeInfoOfGuid(Guid.GUID paramGUID, PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetLibAttr(PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetTypeComp(PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetDocumentation(int paramInt, WTypes.BSTRByReference paramBSTRByReference1, WTypes.BSTRByReference paramBSTRByReference2, WinDef.DWORDByReference paramDWORDByReference, WTypes.BSTRByReference paramBSTRByReference3);
  
  WinNT.HRESULT IsName(WTypes.LPOLESTR paramLPOLESTR, WinDef.ULONG paramULONG, WinDef.BOOLByReference paramBOOLByReference);
  
  WinNT.HRESULT FindName(WTypes.LPOLESTR paramLPOLESTR, WinDef.ULONG paramULONG, Pointer[] paramArrayOfPointer, OaIdl.MEMBERID[] paramArrayOfMEMBERID, WinDef.USHORTByReference paramUSHORTByReference);
  
  void ReleaseTLibAttr(OaIdl.TLIBATTR paramTLIBATTR);
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\ITypeLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */