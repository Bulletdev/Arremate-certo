/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.ptr.ByteByReference;
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
/*    */ 
/*    */ public interface User32
/*    */   extends WinNT, WinUser, StdCallLibrary
/*    */ {
/* 49 */   public static final User32 INSTANCE = (User32)Native.load("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 54 */   public static final WinDef.HWND HWND_MESSAGE = new WinDef.HWND(Pointer.createConstant(-3));
/*    */   public static final int CS_GLOBALCLASS = 16384;
/*    */   public static final int WS_EX_TOPMOST = 8;
/*    */   public static final int DEVICE_NOTIFY_WINDOW_HANDLE = 0;
/*    */   public static final int DEVICE_NOTIFY_SERVICE_HANDLE = 1;
/*    */   public static final int DEVICE_NOTIFY_ALL_INTERFACE_CLASSES = 4;
/*    */   public static final int SW_SHOWDEFAULT = 10;
/*    */   
/*    */   WinDef.HDC GetDC(WinDef.HWND paramHWND);
/*    */   
/*    */   int ReleaseDC(WinDef.HWND paramHWND, WinDef.HDC paramHDC);
/*    */   
/*    */   WinDef.HWND FindWindow(String paramString1, String paramString2);
/*    */   
/*    */   int GetClassName(WinDef.HWND paramHWND, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean GetGUIThreadInfo(int paramInt, WinUser.GUITHREADINFO paramGUITHREADINFO);
/*    */   
/*    */   boolean GetWindowInfo(WinDef.HWND paramHWND, WinUser.WINDOWINFO paramWINDOWINFO);
/*    */   
/*    */   boolean GetWindowRect(WinDef.HWND paramHWND, WinDef.RECT paramRECT);
/*    */   
/*    */   boolean GetClientRect(WinDef.HWND paramHWND, WinDef.RECT paramRECT);
/*    */   
/*    */   int GetWindowText(WinDef.HWND paramHWND, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   int GetWindowTextLength(WinDef.HWND paramHWND);
/*    */   
/*    */   int GetWindowModuleFileName(WinDef.HWND paramHWND, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   int GetWindowThreadProcessId(WinDef.HWND paramHWND, IntByReference paramIntByReference);
/*    */   
/*    */   boolean EnumWindows(WinUser.WNDENUMPROC paramWNDENUMPROC, Pointer paramPointer);
/*    */   
/*    */   boolean EnumChildWindows(WinDef.HWND paramHWND, WinUser.WNDENUMPROC paramWNDENUMPROC, Pointer paramPointer);
/*    */   
/*    */   boolean EnumThreadWindows(int paramInt, WinUser.WNDENUMPROC paramWNDENUMPROC, Pointer paramPointer);
/*    */   
/*    */   boolean BringWindowToTop(WinDef.HWND paramHWND);
/*    */   
/*    */   boolean FlashWindowEx(WinUser.FLASHWINFO paramFLASHWINFO);
/*    */   
/*    */   WinDef.HICON LoadIcon(WinDef.HINSTANCE paramHINSTANCE, String paramString);
/*    */   
/*    */   WinNT.HANDLE LoadImage(WinDef.HINSTANCE paramHINSTANCE, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   boolean DestroyIcon(WinDef.HICON paramHICON);
/*    */   
/*    */   int GetWindowLong(WinDef.HWND paramHWND, int paramInt);
/*    */   
/*    */   int SetWindowLong(WinDef.HWND paramHWND, int paramInt1, int paramInt2);
/*    */   
/*    */   BaseTSD.LONG_PTR GetWindowLongPtr(WinDef.HWND paramHWND, int paramInt);
/*    */   
/*    */   Pointer SetWindowLongPtr(WinDef.HWND paramHWND, int paramInt, Pointer paramPointer);
/*    */   
/*    */   boolean SetLayeredWindowAttributes(WinDef.HWND paramHWND, int paramInt1, byte paramByte, int paramInt2);
/*    */   
/*    */   boolean GetLayeredWindowAttributes(WinDef.HWND paramHWND, IntByReference paramIntByReference1, ByteByReference paramByteByReference, IntByReference paramIntByReference2);
/*    */   
/*    */   boolean UpdateLayeredWindow(WinDef.HWND paramHWND, WinDef.HDC paramHDC1, WinDef.POINT paramPOINT1, WinUser.SIZE paramSIZE, WinDef.HDC paramHDC2, WinDef.POINT paramPOINT2, int paramInt1, WinUser.BLENDFUNCTION paramBLENDFUNCTION, int paramInt2);
/*    */   
/*    */   int SetWindowRgn(WinDef.HWND paramHWND, WinDef.HRGN paramHRGN, boolean paramBoolean);
/*    */   
/*    */   boolean GetKeyboardState(byte[] paramArrayOfbyte);
/*    */   
/*    */   short GetAsyncKeyState(int paramInt);
/*    */   
/*    */   WinUser.HHOOK SetWindowsHookEx(int paramInt1, WinUser.HOOKPROC paramHOOKPROC, WinDef.HINSTANCE paramHINSTANCE, int paramInt2);
/*    */   
/*    */   WinDef.LRESULT CallNextHookEx(WinUser.HHOOK paramHHOOK, int paramInt, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM);
/*    */   
/*    */   boolean UnhookWindowsHookEx(WinUser.HHOOK paramHHOOK);
/*    */   
/*    */   int GetMessage(WinUser.MSG paramMSG, WinDef.HWND paramHWND, int paramInt1, int paramInt2);
/*    */   
/*    */   boolean PeekMessage(WinUser.MSG paramMSG, WinDef.HWND paramHWND, int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   boolean TranslateMessage(WinUser.MSG paramMSG);
/*    */   
/*    */   WinDef.LRESULT DispatchMessage(WinUser.MSG paramMSG);
/*    */   
/*    */   void PostMessage(WinDef.HWND paramHWND, int paramInt, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM);
/*    */   
/*    */   int PostThreadMessage(int paramInt1, int paramInt2, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM);
/*    */   
/*    */   void PostQuitMessage(int paramInt);
/*    */   
/*    */   int GetSystemMetrics(int paramInt);
/*    */   
/*    */   WinDef.HWND SetParent(WinDef.HWND paramHWND1, WinDef.HWND paramHWND2);
/*    */   
/*    */   boolean IsWindowVisible(WinDef.HWND paramHWND);
/*    */   
/*    */   boolean MoveWindow(WinDef.HWND paramHWND, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
/*    */   
/*    */   boolean SetWindowPos(WinDef.HWND paramHWND1, WinDef.HWND paramHWND2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*    */   
/*    */   boolean AttachThreadInput(WinDef.DWORD paramDWORD1, WinDef.DWORD paramDWORD2, boolean paramBoolean);
/*    */   
/*    */   boolean SetForegroundWindow(WinDef.HWND paramHWND);
/*    */   
/*    */   WinDef.HWND GetForegroundWindow();
/*    */   
/*    */   WinDef.HWND SetFocus(WinDef.HWND paramHWND);
/*    */   
/*    */   WinDef.DWORD SendInput(WinDef.DWORD paramDWORD, WinUser.INPUT[] paramArrayOfINPUT, int paramInt);
/*    */   
/*    */   WinDef.DWORD WaitForInputIdle(WinNT.HANDLE paramHANDLE, WinDef.DWORD paramDWORD);
/*    */   
/*    */   boolean InvalidateRect(WinDef.HWND paramHWND, WinDef.RECT paramRECT, boolean paramBoolean);
/*    */   
/*    */   boolean RedrawWindow(WinDef.HWND paramHWND, WinDef.RECT paramRECT, WinDef.HRGN paramHRGN, WinDef.DWORD paramDWORD);
/*    */   
/*    */   WinDef.HWND GetWindow(WinDef.HWND paramHWND, WinDef.DWORD paramDWORD);
/*    */   
/*    */   boolean UpdateWindow(WinDef.HWND paramHWND);
/*    */   
/*    */   boolean ShowWindow(WinDef.HWND paramHWND, int paramInt);
/*    */   
/*    */   boolean CloseWindow(WinDef.HWND paramHWND);
/*    */   
/*    */   boolean RegisterHotKey(WinDef.HWND paramHWND, int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   boolean UnregisterHotKey(Pointer paramPointer, int paramInt);
/*    */   
/*    */   boolean GetLastInputInfo(WinUser.LASTINPUTINFO paramLASTINPUTINFO);
/*    */   
/*    */   WinDef.ATOM RegisterClassEx(WinUser.WNDCLASSEX paramWNDCLASSEX);
/*    */   
/*    */   boolean UnregisterClass(String paramString, WinDef.HINSTANCE paramHINSTANCE);
/*    */   
/*    */   WinDef.HWND CreateWindowEx(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, WinDef.HWND paramHWND, WinDef.HMENU paramHMENU, WinDef.HINSTANCE paramHINSTANCE, WinDef.LPVOID paramLPVOID);
/*    */   
/*    */   boolean DestroyWindow(WinDef.HWND paramHWND);
/*    */   
/*    */   boolean GetClassInfoEx(WinDef.HINSTANCE paramHINSTANCE, String paramString, WinUser.WNDCLASSEX paramWNDCLASSEX);
/*    */   
/*    */   WinDef.LRESULT CallWindowProc(Pointer paramPointer, WinDef.HWND paramHWND, int paramInt, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM);
/*    */   
/*    */   WinDef.LRESULT DefWindowProc(WinDef.HWND paramHWND, int paramInt, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM);
/*    */   
/*    */   WinUser.HDEVNOTIFY RegisterDeviceNotification(WinNT.HANDLE paramHANDLE, Structure paramStructure, int paramInt);
/*    */   
/*    */   boolean UnregisterDeviceNotification(WinUser.HDEVNOTIFY paramHDEVNOTIFY);
/*    */   
/*    */   int RegisterWindowMessage(String paramString);
/*    */   
/*    */   WinUser.HMONITOR MonitorFromPoint(WinDef.POINT.ByValue paramByValue, int paramInt);
/*    */   
/*    */   WinUser.HMONITOR MonitorFromRect(WinDef.RECT paramRECT, int paramInt);
/*    */   
/*    */   WinUser.HMONITOR MonitorFromWindow(WinDef.HWND paramHWND, int paramInt);
/*    */   
/*    */   WinDef.BOOL GetMonitorInfo(WinUser.HMONITOR paramHMONITOR, WinUser.MONITORINFO paramMONITORINFO);
/*    */   
/*    */   WinDef.BOOL GetMonitorInfo(WinUser.HMONITOR paramHMONITOR, WinUser.MONITORINFOEX paramMONITORINFOEX);
/*    */   
/*    */   WinDef.BOOL EnumDisplayMonitors(WinDef.HDC paramHDC, WinDef.RECT paramRECT, WinUser.MONITORENUMPROC paramMONITORENUMPROC, WinDef.LPARAM paramLPARAM);
/*    */   
/*    */   WinDef.BOOL GetWindowPlacement(WinDef.HWND paramHWND, WinUser.WINDOWPLACEMENT paramWINDOWPLACEMENT);
/*    */   
/*    */   WinDef.BOOL SetWindowPlacement(WinDef.HWND paramHWND, WinUser.WINDOWPLACEMENT paramWINDOWPLACEMENT);
/*    */   
/*    */   WinDef.BOOL AdjustWindowRect(WinDef.RECT paramRECT, WinDef.DWORD paramDWORD, WinDef.BOOL paramBOOL);
/*    */   
/*    */   WinDef.BOOL AdjustWindowRectEx(WinDef.RECT paramRECT, WinDef.DWORD paramDWORD1, WinDef.BOOL paramBOOL, WinDef.DWORD paramDWORD2);
/*    */   
/*    */   WinDef.BOOL ExitWindowsEx(WinDef.UINT paramUINT, WinDef.DWORD paramDWORD);
/*    */   
/*    */   WinDef.BOOL LockWorkStation();
/*    */   
/*    */   boolean GetIconInfo(WinDef.HICON paramHICON, WinGDI.ICONINFO paramICONINFO);
/*    */   
/*    */   WinDef.LRESULT SendMessageTimeout(WinDef.HWND paramHWND, int paramInt1, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM, int paramInt2, int paramInt3, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   BaseTSD.ULONG_PTR GetClassLongPtr(WinDef.HWND paramHWND, int paramInt);
/*    */   
/*    */   int GetRawInputDeviceList(WinUser.RAWINPUTDEVICELIST[] paramArrayOfRAWINPUTDEVICELIST, IntByReference paramIntByReference, int paramInt);
/*    */   
/*    */   WinDef.HWND GetDesktopWindow();
/*    */   
/*    */   boolean PrintWindow(WinDef.HWND paramHWND, WinDef.HDC paramHDC, int paramInt);
/*    */   
/*    */   boolean IsWindowEnabled(WinDef.HWND paramHWND);
/*    */   
/*    */   boolean IsWindow(WinDef.HWND paramHWND);
/*    */   
/*    */   WinDef.HWND FindWindowEx(WinDef.HWND paramHWND1, WinDef.HWND paramHWND2, String paramString1, String paramString2);
/*    */   
/*    */   WinDef.HWND GetAncestor(WinDef.HWND paramHWND, int paramInt);
/*    */   
/*    */   WinDef.HWND GetParent(WinDef.HWND paramHWND);
/*    */   
/*    */   boolean GetCursorPos(WinDef.POINT paramPOINT);
/*    */   
/*    */   boolean SetCursorPos(long paramLong1, long paramLong2);
/*    */   
/*    */   WinNT.HANDLE SetWinEventHook(int paramInt1, int paramInt2, WinDef.HMODULE paramHMODULE, WinUser.WinEventProc paramWinEventProc, int paramInt3, int paramInt4, int paramInt5);
/*    */   
/*    */   boolean UnhookWinEvent(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinDef.HICON CopyIcon(WinDef.HICON paramHICON);
/*    */   
/*    */   int GetClassLong(WinDef.HWND paramHWND, int paramInt);
/*    */   
/*    */   int RegisterClipboardFormat(String paramString);
/*    */   
/*    */   WinDef.HWND GetActiveWindow();
/*    */   
/*    */   WinDef.LRESULT SendMessage(WinDef.HWND paramHWND, int paramInt, WinDef.WPARAM paramWPARAM, WinDef.LPARAM paramLPARAM);
/*    */   
/*    */   int GetKeyboardLayoutList(int paramInt, WinDef.HKL[] paramArrayOfHKL);
/*    */   
/*    */   WinDef.HKL GetKeyboardLayout(int paramInt);
/*    */   
/*    */   boolean GetKeyboardLayoutName(char[] paramArrayOfchar);
/*    */   
/*    */   short VkKeyScanExA(byte paramByte, WinDef.HKL paramHKL);
/*    */   
/*    */   short VkKeyScanExW(char paramChar, WinDef.HKL paramHKL);
/*    */   
/*    */   int MapVirtualKeyEx(int paramInt1, int paramInt2, WinDef.HKL paramHKL);
/*    */   
/*    */   int ToUnicodeEx(int paramInt1, int paramInt2, byte[] paramArrayOfbyte, char[] paramArrayOfchar, int paramInt3, int paramInt4, WinDef.HKL paramHKL);
/*    */   
/*    */   int LoadString(WinDef.HINSTANCE paramHINSTANCE, int paramInt1, Pointer paramPointer, int paramInt2);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\User32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */