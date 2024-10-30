/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.win32.StdCallLibrary;
/*    */ import com.sun.jna.win32.W32APIOptions;
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
/*    */ public interface Mpr
/*    */   extends StdCallLibrary
/*    */ {
/* 44 */   public static final Mpr INSTANCE = (Mpr)Native.load("Mpr", Mpr.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   
/*    */   int WNetOpenEnum(int paramInt1, int paramInt2, int paramInt3, Winnetwk.NETRESOURCE.ByReference paramByReference, WinNT.HANDLEByReference paramHANDLEByReference);
/*    */   
/*    */   int WNetEnumResource(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference1, Pointer paramPointer, IntByReference paramIntByReference2);
/*    */   
/*    */   int WNetCloseEnum(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   int WNetGetUniversalName(String paramString, int paramInt, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   int WNetUseConnection(WinDef.HWND paramHWND, Winnetwk.NETRESOURCE paramNETRESOURCE, String paramString1, String paramString2, int paramInt, Pointer paramPointer, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*    */   
/*    */   int WNetAddConnection3(WinDef.HWND paramHWND, Winnetwk.NETRESOURCE paramNETRESOURCE, String paramString1, String paramString2, int paramInt);
/*    */   
/*    */   int WNetCancelConnection2(String paramString, int paramInt, boolean paramBoolean);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Mpr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */