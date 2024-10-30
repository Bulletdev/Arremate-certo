/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.WString;
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
/*     */ public abstract class Shell32Util
/*     */ {
/*     */   public static String getFolderPath(WinDef.HWND paramHWND, int paramInt, WinDef.DWORD paramDWORD) {
/*  54 */     char[] arrayOfChar = new char[260];
/*  55 */     WinNT.HRESULT hRESULT = Shell32.INSTANCE.SHGetFolderPath(paramHWND, paramInt, null, paramDWORD, arrayOfChar);
/*     */     
/*  57 */     if (!hRESULT.equals(W32Errors.S_OK)) {
/*  58 */       throw new Win32Exception(hRESULT);
/*     */     }
/*  60 */     return Native.toString(arrayOfChar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getFolderPath(int paramInt) {
/*  71 */     return getFolderPath(null, paramInt, ShlObj.SHGFP_TYPE_CURRENT);
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
/*     */   public static String getKnownFolderPath(Guid.GUID paramGUID) throws Win32Exception {
/*  86 */     int i = ShlObj.KNOWN_FOLDER_FLAG.NONE.getFlag();
/*  87 */     PointerByReference pointerByReference = new PointerByReference();
/*  88 */     WinNT.HANDLE hANDLE = null;
/*  89 */     WinNT.HRESULT hRESULT = Shell32.INSTANCE.SHGetKnownFolderPath(paramGUID, i, hANDLE, pointerByReference);
/*     */     
/*  91 */     if (!W32Errors.SUCCEEDED(hRESULT.intValue()))
/*     */     {
/*  93 */       throw new Win32Exception(hRESULT);
/*     */     }
/*     */     
/*  96 */     String str = pointerByReference.getValue().getWideString(0L);
/*  97 */     Ole32.INSTANCE.CoTaskMemFree(pointerByReference.getValue());
/*     */     
/*  99 */     return str;
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
/*     */   public static final String getSpecialFolderPath(int paramInt, boolean paramBoolean) {
/* 113 */     char[] arrayOfChar = new char[260];
/* 114 */     if (!Shell32.INSTANCE.SHGetSpecialFolderPath(null, arrayOfChar, paramInt, paramBoolean))
/* 115 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError()); 
/* 116 */     return Native.toString(arrayOfChar);
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
/*     */   public static final String[] CommandLineToArgv(String paramString) {
/* 130 */     WString wString = new WString(paramString);
/* 131 */     IntByReference intByReference = new IntByReference();
/* 132 */     Pointer pointer = Shell32.INSTANCE.CommandLineToArgvW(wString, intByReference);
/* 133 */     if (pointer != null) {
/*     */       try {
/* 135 */         return pointer.getWideStringArray(0L, intByReference.getValue());
/*     */       } finally {
/* 137 */         Kernel32.INSTANCE.LocalFree(pointer);
/*     */       } 
/*     */     }
/* 140 */     throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Shell32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */