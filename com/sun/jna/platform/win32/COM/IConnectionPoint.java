/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.platform.win32.Guid;
/*    */ import com.sun.jna.platform.win32.WinDef;
/*    */ import com.sun.jna.platform.win32.WinNT;
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
/*    */ public interface IConnectionPoint
/*    */   extends IUnknown
/*    */ {
/* 33 */   public static final Guid.IID IID_IConnectionPoint = new Guid.IID("B196B286-BAB4-101A-B69C-00AA00341D07");
/*    */   
/*    */   WinNT.HRESULT GetConnectionInterface(Guid.IID paramIID);
/*    */   
/*    */   WinNT.HRESULT Advise(IUnknownCallback paramIUnknownCallback, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   WinNT.HRESULT Unadvise(WinDef.DWORD paramDWORD);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\IConnectionPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */