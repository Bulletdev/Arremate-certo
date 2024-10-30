/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.WString;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.ptr.PointerByReference;
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
/*    */ public interface Shell32
/*    */   extends ShellAPI, StdCallLibrary
/*    */ {
/* 48 */   public static final Shell32 INSTANCE = (Shell32)Native.load("shell32", Shell32.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   public static final int SHERB_NOCONFIRMATION = 1;
/*    */   public static final int SHERB_NOPROGRESSUI = 2;
/*    */   public static final int SHERB_NOSOUND = 4;
/*    */   public static final int SEE_MASK_NOCLOSEPROCESS = 64;
/*    */   public static final int SEE_MASK_FLAG_NO_UI = 1024;
/*    */   
/*    */   int SHFileOperation(ShellAPI.SHFILEOPSTRUCT paramSHFILEOPSTRUCT);
/*    */   
/*    */   WinNT.HRESULT SHGetFolderPath(WinDef.HWND paramHWND, int paramInt, WinNT.HANDLE paramHANDLE, WinDef.DWORD paramDWORD, char[] paramArrayOfchar);
/*    */   
/*    */   WinNT.HRESULT SHGetKnownFolderPath(Guid.GUID paramGUID, int paramInt, WinNT.HANDLE paramHANDLE, PointerByReference paramPointerByReference);
/*    */   
/*    */   WinNT.HRESULT SHGetDesktopFolder(PointerByReference paramPointerByReference);
/*    */   
/*    */   WinDef.INT_PTR ShellExecute(WinDef.HWND paramHWND, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt);
/*    */   
/*    */   boolean SHGetSpecialFolderPath(WinDef.HWND paramHWND, char[] paramArrayOfchar, int paramInt, boolean paramBoolean);
/*    */   
/*    */   WinDef.UINT_PTR SHAppBarMessage(WinDef.DWORD paramDWORD, ShellAPI.APPBARDATA paramAPPBARDATA);
/*    */   
/*    */   int SHEmptyRecycleBin(WinNT.HANDLE paramHANDLE, String paramString, int paramInt);
/*    */   
/*    */   boolean ShellExecuteEx(ShellAPI.SHELLEXECUTEINFO paramSHELLEXECUTEINFO);
/*    */   
/*    */   WinNT.HRESULT SHGetSpecialFolderLocation(WinDef.HWND paramHWND, int paramInt, PointerByReference paramPointerByReference);
/*    */   
/*    */   int ExtractIconEx(String paramString, int paramInt1, WinDef.HICON[] paramArrayOfHICON1, WinDef.HICON[] paramArrayOfHICON2, int paramInt2);
/*    */   
/*    */   WinNT.HRESULT GetCurrentProcessExplicitAppUserModelID(PointerByReference paramPointerByReference);
/*    */   
/*    */   WinNT.HRESULT SetCurrentProcessExplicitAppUserModelID(WString paramWString);
/*    */   
/*    */   Pointer CommandLineToArgvW(WString paramWString, IntByReference paramIntByReference);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Shell32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */