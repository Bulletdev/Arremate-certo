/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.WString;
/*    */ import com.sun.jna.platform.win32.Guid;
/*    */ import com.sun.jna.platform.win32.OaIdl;
/*    */ import com.sun.jna.platform.win32.OleAuto;
/*    */ import com.sun.jna.platform.win32.Variant;
/*    */ import com.sun.jna.platform.win32.WinDef;
/*    */ import com.sun.jna.platform.win32.WinNT;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IDispatch
/*    */   extends IUnknown
/*    */ {
/* 53 */   public static final Guid.IID IID_IDISPATCH = new Guid.IID("00020400-0000-0000-C000-000000000046");
/*    */   
/*    */   WinNT.HRESULT GetTypeInfoCount(WinDef.UINTByReference paramUINTByReference);
/*    */   
/*    */   WinNT.HRESULT GetTypeInfo(WinDef.UINT paramUINT, WinDef.LCID paramLCID, PointerByReference paramPointerByReference);
/*    */   
/*    */   WinNT.HRESULT GetIDsOfNames(Guid.REFIID paramREFIID, WString[] paramArrayOfWString, int paramInt, WinDef.LCID paramLCID, OaIdl.DISPIDByReference paramDISPIDByReference);
/*    */   
/*    */   WinNT.HRESULT Invoke(OaIdl.DISPID paramDISPID, Guid.REFIID paramREFIID, WinDef.LCID paramLCID, WinDef.WORD paramWORD, OleAuto.DISPPARAMS.ByReference paramByReference, Variant.VARIANT.ByReference paramByReference1, OaIdl.EXCEPINFO.ByReference paramByReference2, IntByReference paramIntByReference);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\IDispatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */