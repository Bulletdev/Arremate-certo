/*    */ package com.sun.jna.platform.win32.COM;
/*    */ 
/*    */ import com.sun.jna.Pointer;
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
/*    */ public class ConnectionPoint
/*    */   extends Unknown
/*    */   implements IConnectionPoint
/*    */ {
/*    */   public ConnectionPoint(Pointer paramPointer) {
/* 35 */     super(paramPointer);
/*    */   }
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT GetConnectionInterface(Guid.IID paramIID) {
/* 40 */     byte b = 3;
/* 41 */     return (WinNT.HRESULT)_invokeNativeObject(3, new Object[] { getPointer(), paramIID }, WinNT.HRESULT.class);
/*    */   }
/*    */   
/*    */   void GetConnectionPointContainer() {
/* 45 */     byte b = 4;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT Advise(IUnknownCallback paramIUnknownCallback, WinDef.DWORDByReference paramDWORDByReference) {
/* 51 */     byte b = 5;
/*    */     
/* 53 */     return (WinNT.HRESULT)_invokeNativeObject(5, new Object[] { getPointer(), paramIUnknownCallback.getPointer(), paramDWORDByReference }, WinNT.HRESULT.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public WinNT.HRESULT Unadvise(WinDef.DWORD paramDWORD) {
/* 59 */     byte b = 6;
/*    */     
/* 61 */     return (WinNT.HRESULT)_invokeNativeObject(6, new Object[] { getPointer(), paramDWORD }, WinNT.HRESULT.class);
/*    */   }
/*    */   
/*    */   void EnumConnections() {
/* 65 */     byte b = 7;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\COM\ConnectionPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */