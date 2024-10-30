/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.platform.win32.WTypes;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TypeInfo
/*     */   extends Unknown
/*     */   implements ITypeInfo
/*     */ {
/*     */   public static class ByReference
/*     */     extends TypeInfo
/*     */     implements Structure.ByReference {}
/*     */   
/*     */   public TypeInfo() {}
/*     */   
/*     */   public TypeInfo(Pointer paramPointer) {
/*  77 */     super(paramPointer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetTypeAttr(PointerByReference paramPointerByReference) {
/*  90 */     return (WinNT.HRESULT)_invokeNativeObject(3, new Object[] {
/*  91 */           getPointer(), paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetTypeComp(PointerByReference paramPointerByReference) {
/* 104 */     return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] {
/* 105 */           getPointer(), paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetFuncDesc(WinDef.UINT paramUINT, PointerByReference paramPointerByReference) {
/* 121 */     return (WinNT.HRESULT)_invokeNativeObject(5, new Object[] {
/* 122 */           getPointer(), paramUINT, paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetVarDesc(WinDef.UINT paramUINT, PointerByReference paramPointerByReference) {
/* 139 */     return (WinNT.HRESULT)_invokeNativeObject(6, new Object[] {
/* 140 */           getPointer(), paramUINT, paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetNames(OaIdl.MEMBERID paramMEMBERID, WTypes.BSTR[] paramArrayOfBSTR, WinDef.UINT paramUINT, WinDef.UINTByReference paramUINTByReference) {
/* 163 */     return (WinNT.HRESULT)_invokeNativeObject(7, new Object[] {
/* 164 */           getPointer(), paramMEMBERID, paramArrayOfBSTR, paramUINT, paramUINTByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetRefTypeOfImplType(WinDef.UINT paramUINT, OaIdl.HREFTYPEByReference paramHREFTYPEByReference) {
/* 181 */     return (WinNT.HRESULT)_invokeNativeObject(8, new Object[] {
/* 182 */           getPointer(), paramUINT, paramHREFTYPEByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetImplTypeFlags(WinDef.UINT paramUINT, IntByReference paramIntByReference) {
/* 199 */     return (WinNT.HRESULT)_invokeNativeObject(9, new Object[] {
/* 200 */           getPointer(), paramUINT, paramIntByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetIDsOfNames(WTypes.LPOLESTR[] paramArrayOfLPOLESTR, WinDef.UINT paramUINT, OaIdl.MEMBERID[] paramArrayOfMEMBERID) {
/* 220 */     return (WinNT.HRESULT)_invokeNativeObject(10, new Object[] {
/* 221 */           getPointer(), paramArrayOfLPOLESTR, paramUINT, paramArrayOfMEMBERID }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT Invoke(WinDef.PVOID paramPVOID, OaIdl.MEMBERID paramMEMBERID, WinDef.WORD paramWORD, OleAuto.DISPPARAMS.ByReference paramByReference, Variant.VARIANT.ByReference paramByReference1, OaIdl.EXCEPINFO.ByReference paramByReference2, WinDef.UINTByReference paramUINTByReference) {
/* 253 */     return (WinNT.HRESULT)_invokeNativeObject(11, new Object[] {
/* 254 */           getPointer(), paramPVOID, paramMEMBERID, paramWORD, paramByReference, paramByReference1, paramByReference2, paramUINTByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetDocumentation(OaIdl.MEMBERID paramMEMBERID, WTypes.BSTRByReference paramBSTRByReference1, WTypes.BSTRByReference paramBSTRByReference2, WinDef.DWORDByReference paramDWORDByReference, WTypes.BSTRByReference paramBSTRByReference3) {
/* 281 */     return (WinNT.HRESULT)_invokeNativeObject(12, new Object[] {
/* 282 */           getPointer(), paramMEMBERID, paramBSTRByReference1, paramBSTRByReference2, paramDWORDByReference, paramBSTRByReference3 }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetDllEntry(OaIdl.MEMBERID paramMEMBERID, OaIdl.INVOKEKIND paramINVOKEKIND, WTypes.BSTRByReference paramBSTRByReference1, WTypes.BSTRByReference paramBSTRByReference2, WinDef.WORDByReference paramWORDByReference) {
/* 309 */     return (WinNT.HRESULT)_invokeNativeObject(13, new Object[] {
/* 310 */           getPointer(), paramMEMBERID, paramINVOKEKIND, paramBSTRByReference1, paramBSTRByReference2, paramWORDByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetRefTypeInfo(OaIdl.HREFTYPE paramHREFTYPE, PointerByReference paramPointerByReference) {
/* 327 */     return (WinNT.HRESULT)_invokeNativeObject(14, new Object[] {
/* 328 */           getPointer(), paramHREFTYPE, paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT AddressOfMember(OaIdl.MEMBERID paramMEMBERID, OaIdl.INVOKEKIND paramINVOKEKIND, PointerByReference paramPointerByReference) {
/* 348 */     return (WinNT.HRESULT)_invokeNativeObject(15, new Object[] {
/* 349 */           getPointer(), paramMEMBERID, paramINVOKEKIND, paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT CreateInstance(IUnknown paramIUnknown, Guid.REFIID paramREFIID, PointerByReference paramPointerByReference) {
/* 369 */     return (WinNT.HRESULT)_invokeNativeObject(16, new Object[] {
/* 370 */           getPointer(), paramIUnknown, paramREFIID, paramPointerByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetMops(OaIdl.MEMBERID paramMEMBERID, WTypes.BSTRByReference paramBSTRByReference) {
/* 387 */     return (WinNT.HRESULT)_invokeNativeObject(17, new Object[] {
/* 388 */           getPointer(), paramMEMBERID, paramBSTRByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinNT.HRESULT GetContainingTypeLib(PointerByReference paramPointerByReference, WinDef.UINTByReference paramUINTByReference) {
/* 405 */     return (WinNT.HRESULT)_invokeNativeObject(18, new Object[] {
/* 406 */           getPointer(), paramPointerByReference, paramUINTByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReleaseTypeAttr(OaIdl.TYPEATTR paramTYPEATTR) {
/* 418 */     _invokeNativeVoid(19, new Object[] { getPointer(), paramTYPEATTR });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReleaseFuncDesc(OaIdl.FUNCDESC paramFUNCDESC) {
/* 429 */     _invokeNativeVoid(20, new Object[] { getPointer(), paramFUNCDESC });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReleaseVarDesc(OaIdl.VARDESC paramVARDESC) {
/* 440 */     _invokeNativeVoid(21, new Object[] { getPointer(), paramVARDESC });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\TypeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */