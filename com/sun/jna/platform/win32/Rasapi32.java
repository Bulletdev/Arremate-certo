/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
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
/*    */ 
/*    */ 
/*    */ public interface Rasapi32
/*    */   extends StdCallLibrary
/*    */ {
/* 47 */   public static final Rasapi32 INSTANCE = (Rasapi32)Native.load("Rasapi32", Rasapi32.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   
/*    */   int RasDial(WinRas.RASDIALEXTENSIONS.ByReference paramByReference, String paramString, WinRas.RASDIALPARAMS.ByReference paramByReference1, int paramInt, WinRas.RasDialFunc2 paramRasDialFunc2, WinNT.HANDLEByReference paramHANDLEByReference);
/*    */   
/*    */   int RasEnumConnections(WinRas.RASCONN[] paramArrayOfRASCONN, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*    */   
/*    */   int RasGetConnectionStatistics(WinNT.HANDLE paramHANDLE, Structure.ByReference paramByReference);
/*    */   
/*    */   int RasGetConnectStatus(WinNT.HANDLE paramHANDLE, Structure.ByReference paramByReference);
/*    */   
/*    */   int RasGetCredentials(String paramString1, String paramString2, WinRas.RASCREDENTIALS.ByReference paramByReference);
/*    */   
/*    */   int RasGetEntryProperties(String paramString1, String paramString2, WinRas.RASENTRY.ByReference paramByReference, IntByReference paramIntByReference, Pointer paramPointer1, Pointer paramPointer2);
/*    */   
/*    */   int RasGetProjectionInfo(WinNT.HANDLE paramHANDLE, int paramInt, Pointer paramPointer, IntByReference paramIntByReference);
/*    */   
/*    */   int RasHangUp(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   int RasSetEntryProperties(String paramString1, String paramString2, WinRas.RASENTRY.ByReference paramByReference, int paramInt1, byte[] paramArrayOfbyte, int paramInt2);
/*    */   
/*    */   int RasGetEntryDialParams(String paramString, WinRas.RASDIALPARAMS.ByReference paramByReference, WinDef.BOOLByReference paramBOOLByReference);
/*    */   
/*    */   int RasGetErrorString(int paramInt1, char[] paramArrayOfchar, int paramInt2);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Rasapi32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */