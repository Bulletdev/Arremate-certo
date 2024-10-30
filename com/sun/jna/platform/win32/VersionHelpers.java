/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VersionHelpers
/*     */ {
/*     */   public static boolean IsWindowsVersionOrGreater(int paramInt1, int paramInt2, int paramInt3) {
/*  59 */     WinNT.OSVERSIONINFOEX oSVERSIONINFOEX = new WinNT.OSVERSIONINFOEX();
/*  60 */     oSVERSIONINFOEX.dwOSVersionInfoSize = new WinDef.DWORD(oSVERSIONINFOEX.size());
/*  61 */     oSVERSIONINFOEX.dwMajorVersion = new WinDef.DWORD(paramInt1);
/*  62 */     oSVERSIONINFOEX.dwMinorVersion = new WinDef.DWORD(paramInt2);
/*  63 */     oSVERSIONINFOEX.wServicePackMajor = new WinDef.WORD(paramInt3);
/*     */     
/*  65 */     long l = 0L;
/*  66 */     l = Kernel32.INSTANCE.VerSetConditionMask(l, 2, (byte)3);
/*     */     
/*  68 */     l = Kernel32.INSTANCE.VerSetConditionMask(l, 1, (byte)3);
/*     */     
/*  70 */     l = Kernel32.INSTANCE.VerSetConditionMask(l, 32, (byte)3);
/*     */ 
/*     */     
/*  73 */     return Kernel32.INSTANCE.VerifyVersionInfoW(oSVERSIONINFOEX, 35, l);
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
/*     */   public static boolean IsWindowsXPOrGreater() {
/*  91 */     return IsWindowsVersionOrGreater(5, 1, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindowsXPSP1OrGreater() {
/* 100 */     return IsWindowsVersionOrGreater(5, 1, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindowsXPSP2OrGreater() {
/* 109 */     return IsWindowsVersionOrGreater(5, 1, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindowsXPSP3OrGreater() {
/* 118 */     return IsWindowsVersionOrGreater(5, 1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindowsVistaOrGreater() {
/* 127 */     return IsWindowsVersionOrGreater(6, 0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindowsVistaSP1OrGreater() {
/* 136 */     return IsWindowsVersionOrGreater(6, 0, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindowsVistaSP2OrGreater() {
/* 145 */     return IsWindowsVersionOrGreater(6, 0, 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindows7OrGreater() {
/* 154 */     return IsWindowsVersionOrGreater(6, 1, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindows7SP1OrGreater() {
/* 162 */     return IsWindowsVersionOrGreater(6, 1, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean IsWindows8OrGreater() {
/* 170 */     return IsWindowsVersionOrGreater(6, 2, 0);
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
/*     */   public static boolean IsWindows8Point1OrGreater() {
/* 182 */     return IsWindowsVersionOrGreater(6, 3, 0);
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
/*     */   public static boolean IsWindows10OrGreater() {
/* 194 */     return IsWindowsVersionOrGreater(10, 0, 0);
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
/*     */   public static boolean IsWindowsServer() {
/* 208 */     WinNT.OSVERSIONINFOEX oSVERSIONINFOEX = new WinNT.OSVERSIONINFOEX();
/* 209 */     oSVERSIONINFOEX.dwOSVersionInfoSize = new WinDef.DWORD(oSVERSIONINFOEX.size());
/* 210 */     oSVERSIONINFOEX.wProductType = 1;
/*     */     
/* 212 */     long l = Kernel32.INSTANCE.VerSetConditionMask(0L, 128, (byte)1);
/*     */ 
/*     */     
/* 215 */     return !Kernel32.INSTANCE.VerifyVersionInfoW(oSVERSIONINFOEX, 128, l);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\VersionHelpers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */