/*     */ package com.sun.jna.platform.win32.COM;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.WString;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
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
/*     */ public class Dispatch
/*     */   extends Unknown
/*     */   implements IDispatch
/*     */ {
/*     */   public static class ByReference
/*     */     extends Dispatch
/*     */     implements Structure.ByReference {}
/*     */   
/*     */   public Dispatch() {}
/*     */   
/*     */   public Dispatch(Pointer paramPointer) {
/*  62 */     super(paramPointer);
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
/*     */   public WinNT.HRESULT GetTypeInfoCount(WinDef.UINTByReference paramUINTByReference) {
/*  75 */     return (WinNT.HRESULT)_invokeNativeObject(3, new Object[] {
/*  76 */           getPointer(), paramUINTByReference }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT GetTypeInfo(WinDef.UINT paramUINT, WinDef.LCID paramLCID, PointerByReference paramPointerByReference) {
/*  92 */     return (WinNT.HRESULT)_invokeNativeObject(4, new Object[] {
/*  93 */           getPointer(), paramUINT, paramLCID, paramPointerByReference }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT GetIDsOfNames(Guid.REFIID paramREFIID, WString[] paramArrayOfWString, int paramInt, WinDef.LCID paramLCID, OaIdl.DISPIDByReference paramDISPIDByReference) {
/* 114 */     return (WinNT.HRESULT)_invokeNativeObject(5, new Object[] {
/* 115 */           getPointer(), paramREFIID, paramArrayOfWString, Integer.valueOf(paramInt), paramLCID, paramDISPIDByReference }, WinNT.HRESULT.class);
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
/*     */   public WinNT.HRESULT Invoke(OaIdl.DISPID paramDISPID, Guid.REFIID paramREFIID, WinDef.LCID paramLCID, WinDef.WORD paramWORD, OleAuto.DISPPARAMS.ByReference paramByReference, Variant.VARIANT.ByReference paramByReference1, OaIdl.EXCEPINFO.ByReference paramByReference2, IntByReference paramIntByReference) {
/* 144 */     return (WinNT.HRESULT)
/* 145 */       _invokeNativeObject(6, new Object[] { getPointer(), paramDISPID, paramREFIID, paramLCID, paramWORD, paramByReference, paramByReference1, paramByReference2, paramIntByReference }, WinNT.HRESULT.class);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\Dispatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */