/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.WTypes;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
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
/*     */ public class TypeLib
/*     */   extends Unknown
/*     */   implements ITypeLib
/*     */ {
/*     */   public static class ByReference
/*     */     extends TypeLib
/*     */     implements Structure.ByReference {}
/*     */   
/*     */   public TypeLib() {}
/*     */   
/*     */   public TypeLib(Pointer paramPointer) {
/*  67 */     super(paramPointer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WinDef.UINT GetTypeInfoCount() {
/*  76 */     return (WinDef.UINT)_invokeNativeObject(3, new Object[] {
/*  77 */           getPointer() }, WinDef.UINT.class);
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
/*     */   public WinNT.HRESULT GetTypeInfo(WinDef.UINT paramUINT, PointerByReference paramPointerByReference) {
/*  93 */     return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] {
/*  94 */           getPointer(), paramUINT, paramPointerByReference }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT GetTypeInfoType(WinDef.UINT paramUINT, OaIdl.TYPEKIND.ByReference paramByReference) {
/* 111 */     return (WinNT.HRESULT)_invokeNativeObject(5, new Object[] {
/* 112 */           getPointer(), paramUINT, paramByReference }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT GetTypeInfoOfGuid(Guid.GUID paramGUID, PointerByReference paramPointerByReference) {
/* 129 */     return (WinNT.HRESULT)
/* 130 */       _invokeNativeObject(6, new Object[] { getPointer(), paramGUID, paramPointerByReference }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT GetLibAttr(PointerByReference paramPointerByReference) {
/* 144 */     return (WinNT.HRESULT)_invokeNativeObject(7, new Object[] {
/* 145 */           getPointer(), paramPointerByReference }, WinNT.HRESULT.class);
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
/* 158 */     return (WinNT.HRESULT)_invokeNativeObject(8, new Object[] {
/* 159 */           getPointer(), paramPointerByReference }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT GetDocumentation(int paramInt, WTypes.BSTRByReference paramBSTRByReference1, WTypes.BSTRByReference paramBSTRByReference2, WinDef.DWORDByReference paramDWORDByReference, WTypes.BSTRByReference paramBSTRByReference3) {
/* 184 */     return (WinNT.HRESULT)_invokeNativeObject(9, new Object[] {
/* 185 */           getPointer(), Integer.valueOf(paramInt), paramBSTRByReference1, paramBSTRByReference2, paramDWORDByReference, paramBSTRByReference3 }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT IsName(WTypes.LPOLESTR paramLPOLESTR, WinDef.ULONG paramULONG, WinDef.BOOLByReference paramBOOLByReference) {
/* 206 */     return (WinNT.HRESULT)
/* 207 */       _invokeNativeObject(10, new Object[] { getPointer(), paramLPOLESTR, paramULONG, paramBOOLByReference }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT FindName(WTypes.LPOLESTR paramLPOLESTR, WinDef.ULONG paramULONG, Pointer[] paramArrayOfPointer, OaIdl.MEMBERID[] paramArrayOfMEMBERID, WinDef.USHORTByReference paramUSHORTByReference) {
/* 233 */     return (WinNT.HRESULT)_invokeNativeObject(11, new Object[] {
/* 234 */           getPointer(), paramLPOLESTR, paramULONG, paramArrayOfPointer, paramArrayOfMEMBERID, paramUSHORTByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReleaseTLibAttr(OaIdl.TLIBATTR paramTLIBATTR) {
/* 245 */     _invokeNativeObject(12, new Object[] { getPointer(), paramTLIBATTR
/* 246 */           .getPointer() }, WinNT.HRESULT.class);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\TypeLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */