package com.sun.jna.platform.win32.COM;

import com.sun.jna.WString;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.PointerByReference;

public interface ITypeComp extends IUnknown {
  WinNT.HRESULT Bind(WString paramWString, WinDef.ULONG paramULONG, WinDef.WORD paramWORD, PointerByReference paramPointerByReference, OaIdl.DESCKIND.ByReference paramByReference, OaIdl.BINDPTR.ByReference paramByReference1);
  
  WinNT.HRESULT BindType(WString paramWString, WinDef.ULONG paramULONG, PointerByReference paramPointerByReference1, PointerByReference paramPointerByReference2);
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\ITypeComp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */