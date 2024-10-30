package com.sun.jna.platform.win32.COM;

import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.OleAuto;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public interface ITypeInfo extends IUnknown {
  WinNT.HRESULT GetTypeAttr(PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetTypeComp(PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetFuncDesc(WinDef.UINT paramUINT, PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetVarDesc(WinDef.UINT paramUINT, PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetNames(OaIdl.MEMBERID paramMEMBERID, WTypes.BSTR[] paramArrayOfBSTR, WinDef.UINT paramUINT, WinDef.UINTByReference paramUINTByReference);
  
  WinNT.HRESULT GetRefTypeOfImplType(WinDef.UINT paramUINT, OaIdl.HREFTYPEByReference paramHREFTYPEByReference);
  
  WinNT.HRESULT GetImplTypeFlags(WinDef.UINT paramUINT, IntByReference paramIntByReference);
  
  WinNT.HRESULT GetIDsOfNames(WTypes.LPOLESTR[] paramArrayOfLPOLESTR, WinDef.UINT paramUINT, OaIdl.MEMBERID[] paramArrayOfMEMBERID);
  
  WinNT.HRESULT Invoke(WinDef.PVOID paramPVOID, OaIdl.MEMBERID paramMEMBERID, WinDef.WORD paramWORD, OleAuto.DISPPARAMS.ByReference paramByReference, Variant.VARIANT.ByReference paramByReference1, OaIdl.EXCEPINFO.ByReference paramByReference2, WinDef.UINTByReference paramUINTByReference);
  
  WinNT.HRESULT GetDocumentation(OaIdl.MEMBERID paramMEMBERID, WTypes.BSTRByReference paramBSTRByReference1, WTypes.BSTRByReference paramBSTRByReference2, WinDef.DWORDByReference paramDWORDByReference, WTypes.BSTRByReference paramBSTRByReference3);
  
  WinNT.HRESULT GetDllEntry(OaIdl.MEMBERID paramMEMBERID, OaIdl.INVOKEKIND paramINVOKEKIND, WTypes.BSTRByReference paramBSTRByReference1, WTypes.BSTRByReference paramBSTRByReference2, WinDef.WORDByReference paramWORDByReference);
  
  WinNT.HRESULT GetRefTypeInfo(OaIdl.HREFTYPE paramHREFTYPE, PointerByReference paramPointerByReference);
  
  WinNT.HRESULT AddressOfMember(OaIdl.MEMBERID paramMEMBERID, OaIdl.INVOKEKIND paramINVOKEKIND, PointerByReference paramPointerByReference);
  
  WinNT.HRESULT CreateInstance(IUnknown paramIUnknown, Guid.REFIID paramREFIID, PointerByReference paramPointerByReference);
  
  WinNT.HRESULT GetMops(OaIdl.MEMBERID paramMEMBERID, WTypes.BSTRByReference paramBSTRByReference);
  
  WinNT.HRESULT GetContainingTypeLib(PointerByReference paramPointerByReference, WinDef.UINTByReference paramUINTByReference);
  
  void ReleaseTypeAttr(OaIdl.TYPEATTR paramTYPEATTR);
  
  void ReleaseFuncDesc(OaIdl.FUNCDESC paramFUNCDESC);
  
  void ReleaseVarDesc(OaIdl.VARDESC paramVARDESC);
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\ITypeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */