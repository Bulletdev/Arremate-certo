/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.LastErrorException;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
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
/*    */ public interface Kernel32
/*    */   extends WinNT, Wincon, StdCallLibrary
/*    */ {
/* 44 */   public static final Kernel32 INSTANCE = (Kernel32)Native.load("kernel32", Kernel32.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   public static final int LOAD_LIBRARY_AS_DATAFILE = 2;
/*    */   public static final int MAX_PIPE_NAME_LENGTH = 256;
/*    */   
/*    */   boolean ReadFile(WinNT.HANDLE paramHANDLE, byte[] paramArrayOfbyte, int paramInt, IntByReference paramIntByReference, WinBase.OVERLAPPED paramOVERLAPPED);
/*    */   
/*    */   Pointer LocalFree(Pointer paramPointer);
/*    */   
/*    */   Pointer GlobalFree(Pointer paramPointer);
/*    */   
/*    */   WinDef.HMODULE GetModuleHandle(String paramString);
/*    */   
/*    */   void GetSystemTime(WinBase.SYSTEMTIME paramSYSTEMTIME);
/*    */   
/*    */   boolean SetSystemTime(WinBase.SYSTEMTIME paramSYSTEMTIME);
/*    */   
/*    */   void GetLocalTime(WinBase.SYSTEMTIME paramSYSTEMTIME);
/*    */   
/*    */   boolean SetLocalTime(WinBase.SYSTEMTIME paramSYSTEMTIME);
/*    */   
/*    */   boolean GetSystemTimes(WinBase.FILETIME paramFILETIME1, WinBase.FILETIME paramFILETIME2, WinBase.FILETIME paramFILETIME3);
/*    */   
/*    */   int GetTickCount();
/*    */   
/*    */   long GetTickCount64();
/*    */   
/*    */   int GetCurrentThreadId();
/*    */   
/*    */   WinNT.HANDLE GetCurrentThread();
/*    */   
/*    */   int GetCurrentProcessId();
/*    */   
/*    */   WinNT.HANDLE GetCurrentProcess();
/*    */   
/*    */   int GetProcessId(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   int GetProcessVersion(int paramInt);
/*    */   
/*    */   boolean GetProcessAffinityMask(WinNT.HANDLE paramHANDLE, BaseTSD.ULONG_PTRByReference paramULONG_PTRByReference1, BaseTSD.ULONG_PTRByReference paramULONG_PTRByReference2);
/*    */   
/*    */   boolean SetProcessAffinityMask(WinNT.HANDLE paramHANDLE, BaseTSD.ULONG_PTR paramULONG_PTR);
/*    */   
/*    */   boolean GetExitCodeProcess(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference);
/*    */   
/*    */   boolean TerminateProcess(WinNT.HANDLE paramHANDLE, int paramInt);
/*    */   
/*    */   int GetLastError();
/*    */   
/*    */   void SetLastError(int paramInt);
/*    */   
/*    */   int GetDriveType(String paramString);
/*    */   
/*    */   int FormatMessage(int paramInt1, Pointer paramPointer1, int paramInt2, int paramInt3, PointerByReference paramPointerByReference, int paramInt4, Pointer paramPointer2);
/*    */   
/*    */   WinNT.HANDLE CreateFile(String paramString, int paramInt1, int paramInt2, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, int paramInt3, int paramInt4, WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean CopyFile(String paramString1, String paramString2, boolean paramBoolean);
/*    */   
/*    */   boolean MoveFile(String paramString1, String paramString2);
/*    */   
/*    */   boolean MoveFileEx(String paramString1, String paramString2, WinDef.DWORD paramDWORD);
/*    */   
/*    */   boolean CreateDirectory(String paramString, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES);
/*    */   
/*    */   WinNT.HANDLE CreateIoCompletionPort(WinNT.HANDLE paramHANDLE1, WinNT.HANDLE paramHANDLE2, Pointer paramPointer, int paramInt);
/*    */   
/*    */   boolean GetQueuedCompletionStatus(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference, BaseTSD.ULONG_PTRByReference paramULONG_PTRByReference, PointerByReference paramPointerByReference, int paramInt);
/*    */   
/*    */   boolean PostQueuedCompletionStatus(WinNT.HANDLE paramHANDLE, int paramInt, Pointer paramPointer, WinBase.OVERLAPPED paramOVERLAPPED);
/*    */   
/*    */   int WaitForSingleObject(WinNT.HANDLE paramHANDLE, int paramInt);
/*    */   
/*    */   int WaitForMultipleObjects(int paramInt1, WinNT.HANDLE[] paramArrayOfHANDLE, boolean paramBoolean, int paramInt2);
/*    */   
/*    */   boolean DuplicateHandle(WinNT.HANDLE paramHANDLE1, WinNT.HANDLE paramHANDLE2, WinNT.HANDLE paramHANDLE3, WinNT.HANDLEByReference paramHANDLEByReference, int paramInt1, boolean paramBoolean, int paramInt2);
/*    */   
/*    */   boolean CloseHandle(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean ReadDirectoryChangesW(WinNT.HANDLE paramHANDLE, WinNT.FILE_NOTIFY_INFORMATION paramFILE_NOTIFY_INFORMATION, int paramInt1, boolean paramBoolean, int paramInt2, IntByReference paramIntByReference, WinBase.OVERLAPPED paramOVERLAPPED, WinNT.OVERLAPPED_COMPLETION_ROUTINE paramOVERLAPPED_COMPLETION_ROUTINE);
/*    */   
/*    */   int GetShortPathName(String paramString, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   Pointer LocalAlloc(int paramInt1, int paramInt2);
/*    */   
/*    */   boolean WriteFile(WinNT.HANDLE paramHANDLE, byte[] paramArrayOfbyte, int paramInt, IntByReference paramIntByReference, WinBase.OVERLAPPED paramOVERLAPPED);
/*    */   
/*    */   boolean FlushFileBuffers(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinNT.HANDLE CreateEvent(WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, boolean paramBoolean1, boolean paramBoolean2, String paramString);
/*    */   
/*    */   WinNT.HANDLE OpenEvent(int paramInt, boolean paramBoolean, String paramString);
/*    */   
/*    */   boolean SetEvent(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean ResetEvent(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean PulseEvent(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinNT.HANDLE CreateFileMapping(WinNT.HANDLE paramHANDLE, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, int paramInt1, int paramInt2, int paramInt3, String paramString);
/*    */   
/*    */   Pointer MapViewOfFile(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   boolean UnmapViewOfFile(Pointer paramPointer);
/*    */   
/*    */   boolean GetComputerName(char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   boolean GetComputerNameEx(int paramInt, char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   WinNT.HANDLE OpenThread(int paramInt1, boolean paramBoolean, int paramInt2);
/*    */   
/*    */   boolean CreateProcess(String paramString1, String paramString2, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES1, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES2, boolean paramBoolean, WinDef.DWORD paramDWORD, Pointer paramPointer, String paramString3, WinBase.STARTUPINFO paramSTARTUPINFO, WinBase.PROCESS_INFORMATION paramPROCESS_INFORMATION);
/*    */   
/*    */   boolean CreateProcessW(String paramString1, char[] paramArrayOfchar, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES1, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES2, boolean paramBoolean, WinDef.DWORD paramDWORD, Pointer paramPointer, String paramString2, WinBase.STARTUPINFO paramSTARTUPINFO, WinBase.PROCESS_INFORMATION paramPROCESS_INFORMATION);
/*    */   
/*    */   WinNT.HANDLE OpenProcess(int paramInt1, boolean paramBoolean, int paramInt2);
/*    */   
/*    */   boolean QueryFullProcessImageName(WinNT.HANDLE paramHANDLE, int paramInt, char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   WinDef.DWORD GetTempPath(WinDef.DWORD paramDWORD, char[] paramArrayOfchar);
/*    */   
/*    */   WinDef.DWORD GetVersion();
/*    */   
/*    */   boolean GetVersionEx(WinNT.OSVERSIONINFO paramOSVERSIONINFO);
/*    */   
/*    */   boolean GetVersionEx(WinNT.OSVERSIONINFOEX paramOSVERSIONINFOEX);
/*    */   
/*    */   boolean VerifyVersionInfoW(WinNT.OSVERSIONINFOEX paramOSVERSIONINFOEX, int paramInt, long paramLong);
/*    */   
/*    */   long VerSetConditionMask(long paramLong, int paramInt, byte paramByte);
/*    */   
/*    */   void GetSystemInfo(WinBase.SYSTEM_INFO paramSYSTEM_INFO);
/*    */   
/*    */   void GetNativeSystemInfo(WinBase.SYSTEM_INFO paramSYSTEM_INFO);
/*    */   
/*    */   boolean IsWow64Process(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference);
/*    */   
/*    */   boolean GetLogicalProcessorInformation(Pointer paramPointer, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   boolean GetLogicalProcessorInformationEx(int paramInt, Pointer paramPointer, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   boolean GlobalMemoryStatusEx(WinBase.MEMORYSTATUSEX paramMEMORYSTATUSEX);
/*    */   
/*    */   boolean GetFileInformationByHandleEx(WinNT.HANDLE paramHANDLE, int paramInt, Pointer paramPointer, WinDef.DWORD paramDWORD);
/*    */   
/*    */   boolean SetFileInformationByHandle(WinNT.HANDLE paramHANDLE, int paramInt, Pointer paramPointer, WinDef.DWORD paramDWORD);
/*    */   
/*    */   boolean GetFileTime(WinNT.HANDLE paramHANDLE, WinBase.FILETIME paramFILETIME1, WinBase.FILETIME paramFILETIME2, WinBase.FILETIME paramFILETIME3);
/*    */   
/*    */   int SetFileTime(WinNT.HANDLE paramHANDLE, WinBase.FILETIME paramFILETIME1, WinBase.FILETIME paramFILETIME2, WinBase.FILETIME paramFILETIME3);
/*    */   
/*    */   boolean SetFileAttributes(String paramString, WinDef.DWORD paramDWORD);
/*    */   
/*    */   WinDef.DWORD GetLogicalDriveStrings(WinDef.DWORD paramDWORD, char[] paramArrayOfchar);
/*    */   
/*    */   boolean GetDiskFreeSpace(String paramString, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2, WinDef.DWORDByReference paramDWORDByReference3, WinDef.DWORDByReference paramDWORDByReference4);
/*    */   
/*    */   boolean GetDiskFreeSpaceEx(String paramString, WinNT.LARGE_INTEGER paramLARGE_INTEGER1, WinNT.LARGE_INTEGER paramLARGE_INTEGER2, WinNT.LARGE_INTEGER paramLARGE_INTEGER3);
/*    */   
/*    */   boolean DeleteFile(String paramString);
/*    */   
/*    */   boolean CreatePipe(WinNT.HANDLEByReference paramHANDLEByReference1, WinNT.HANDLEByReference paramHANDLEByReference2, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, int paramInt);
/*    */   
/*    */   boolean CallNamedPipe(String paramString, byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, IntByReference paramIntByReference, int paramInt3);
/*    */   
/*    */   boolean ConnectNamedPipe(WinNT.HANDLE paramHANDLE, WinBase.OVERLAPPED paramOVERLAPPED);
/*    */   
/*    */   WinNT.HANDLE CreateNamedPipe(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES);
/*    */   
/*    */   boolean DisconnectNamedPipe(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean GetNamedPipeClientComputerName(WinNT.HANDLE paramHANDLE, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean GetNamedPipeClientProcessId(WinNT.HANDLE paramHANDLE, WinDef.ULONGByReference paramULONGByReference);
/*    */   
/*    */   boolean GetNamedPipeClientSessionId(WinNT.HANDLE paramHANDLE, WinDef.ULONGByReference paramULONGByReference);
/*    */   
/*    */   boolean GetNamedPipeHandleState(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3, IntByReference paramIntByReference4, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean GetNamedPipeInfo(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3, IntByReference paramIntByReference4);
/*    */   
/*    */   boolean GetNamedPipeServerProcessId(WinNT.HANDLE paramHANDLE, WinDef.ULONGByReference paramULONGByReference);
/*    */   
/*    */   boolean GetNamedPipeServerSessionId(WinNT.HANDLE paramHANDLE, WinDef.ULONGByReference paramULONGByReference);
/*    */   
/*    */   boolean PeekNamedPipe(WinNT.HANDLE paramHANDLE, byte[] paramArrayOfbyte, int paramInt, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3);
/*    */   
/*    */   boolean SetNamedPipeHandleState(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3);
/*    */   
/*    */   boolean TransactNamedPipe(WinNT.HANDLE paramHANDLE, byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, IntByReference paramIntByReference, WinBase.OVERLAPPED paramOVERLAPPED);
/*    */   
/*    */   boolean WaitNamedPipe(String paramString, int paramInt);
/*    */   
/*    */   boolean SetHandleInformation(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2);
/*    */   
/*    */   int GetFileAttributes(String paramString);
/*    */   
/*    */   int GetFileType(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean DeviceIoControl(WinNT.HANDLE paramHANDLE, int paramInt1, Pointer paramPointer1, int paramInt2, Pointer paramPointer2, int paramInt3, IntByReference paramIntByReference, Pointer paramPointer3);
/*    */   
/*    */   WinNT.HANDLE CreateToolhelp32Snapshot(WinDef.DWORD paramDWORD1, WinDef.DWORD paramDWORD2);
/*    */   
/*    */   boolean Process32First(WinNT.HANDLE paramHANDLE, Tlhelp32.PROCESSENTRY32 paramPROCESSENTRY32);
/*    */   
/*    */   boolean Process32Next(WinNT.HANDLE paramHANDLE, Tlhelp32.PROCESSENTRY32 paramPROCESSENTRY32);
/*    */   
/*    */   boolean Thread32First(WinNT.HANDLE paramHANDLE, Tlhelp32.THREADENTRY32 paramTHREADENTRY32);
/*    */   
/*    */   boolean Thread32Next(WinNT.HANDLE paramHANDLE, Tlhelp32.THREADENTRY32 paramTHREADENTRY32);
/*    */   
/*    */   boolean SetEnvironmentVariable(String paramString1, String paramString2);
/*    */   
/*    */   int GetEnvironmentVariable(String paramString, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   Pointer GetEnvironmentStrings();
/*    */   
/*    */   boolean FreeEnvironmentStrings(Pointer paramPointer);
/*    */   
/*    */   WinDef.LCID GetSystemDefaultLCID();
/*    */   
/*    */   WinDef.LCID GetUserDefaultLCID();
/*    */   
/*    */   int GetPrivateProfileInt(String paramString1, String paramString2, int paramInt, String paramString3);
/*    */   
/*    */   WinDef.DWORD GetPrivateProfileString(String paramString1, String paramString2, String paramString3, char[] paramArrayOfchar, WinDef.DWORD paramDWORD, String paramString4);
/*    */   
/*    */   boolean WritePrivateProfileString(String paramString1, String paramString2, String paramString3, String paramString4);
/*    */   
/*    */   WinDef.DWORD GetPrivateProfileSection(String paramString1, char[] paramArrayOfchar, WinDef.DWORD paramDWORD, String paramString2);
/*    */   
/*    */   WinDef.DWORD GetPrivateProfileSectionNames(char[] paramArrayOfchar, WinDef.DWORD paramDWORD, String paramString);
/*    */   
/*    */   boolean WritePrivateProfileSection(String paramString1, String paramString2, String paramString3);
/*    */   
/*    */   boolean FileTimeToLocalFileTime(WinBase.FILETIME paramFILETIME1, WinBase.FILETIME paramFILETIME2);
/*    */   
/*    */   boolean SystemTimeToTzSpecificLocalTime(WinBase.TIME_ZONE_INFORMATION paramTIME_ZONE_INFORMATION, WinBase.SYSTEMTIME paramSYSTEMTIME1, WinBase.SYSTEMTIME paramSYSTEMTIME2);
/*    */   
/*    */   boolean SystemTimeToFileTime(WinBase.SYSTEMTIME paramSYSTEMTIME, WinBase.FILETIME paramFILETIME);
/*    */   
/*    */   boolean FileTimeToSystemTime(WinBase.FILETIME paramFILETIME, WinBase.SYSTEMTIME paramSYSTEMTIME);
/*    */   
/*    */   @Deprecated
/*    */   WinNT.HANDLE CreateRemoteThread(WinNT.HANDLE paramHANDLE, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, int paramInt, WinBase.FOREIGN_THREAD_START_ROUTINE paramFOREIGN_THREAD_START_ROUTINE, Pointer paramPointer1, WinDef.DWORD paramDWORD, Pointer paramPointer2);
/*    */   
/*    */   WinNT.HANDLE CreateRemoteThread(WinNT.HANDLE paramHANDLE, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, int paramInt1, Pointer paramPointer1, Pointer paramPointer2, int paramInt2, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   boolean WriteProcessMemory(WinNT.HANDLE paramHANDLE, Pointer paramPointer1, Pointer paramPointer2, int paramInt, IntByReference paramIntByReference);
/*    */   
/*    */   boolean ReadProcessMemory(WinNT.HANDLE paramHANDLE, Pointer paramPointer1, Pointer paramPointer2, int paramInt, IntByReference paramIntByReference);
/*    */   
/*    */   BaseTSD.SIZE_T VirtualQueryEx(WinNT.HANDLE paramHANDLE, Pointer paramPointer, WinNT.MEMORY_BASIC_INFORMATION paramMEMORY_BASIC_INFORMATION, BaseTSD.SIZE_T paramSIZE_T);
/*    */   
/*    */   boolean DefineDosDevice(int paramInt, String paramString1, String paramString2);
/*    */   
/*    */   int QueryDosDevice(String paramString, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   WinNT.HANDLE FindFirstFile(String paramString, Pointer paramPointer);
/*    */   
/*    */   WinNT.HANDLE FindFirstFileEx(String paramString, int paramInt1, Pointer paramPointer1, int paramInt2, Pointer paramPointer2, WinDef.DWORD paramDWORD);
/*    */   
/*    */   boolean FindNextFile(WinNT.HANDLE paramHANDLE, Pointer paramPointer);
/*    */   
/*    */   boolean FindClose(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinNT.HANDLE FindFirstVolumeMountPoint(String paramString, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean FindNextVolumeMountPoint(WinNT.HANDLE paramHANDLE, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean FindVolumeMountPointClose(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean GetVolumeNameForVolumeMountPoint(String paramString, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean SetVolumeLabel(String paramString1, String paramString2);
/*    */   
/*    */   boolean SetVolumeMountPoint(String paramString1, String paramString2);
/*    */   
/*    */   boolean DeleteVolumeMountPoint(String paramString);
/*    */   
/*    */   boolean GetVolumeInformation(String paramString, char[] paramArrayOfchar1, int paramInt1, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3, char[] paramArrayOfchar2, int paramInt2);
/*    */   
/*    */   boolean GetVolumePathName(String paramString, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean GetVolumePathNamesForVolumeName(String paramString, char[] paramArrayOfchar, int paramInt, IntByReference paramIntByReference);
/*    */   
/*    */   WinNT.HANDLE FindFirstVolume(char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean FindNextVolume(WinNT.HANDLE paramHANDLE, char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   boolean FindVolumeClose(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean GetCommState(WinNT.HANDLE paramHANDLE, WinBase.DCB paramDCB);
/*    */   
/*    */   boolean GetCommTimeouts(WinNT.HANDLE paramHANDLE, WinBase.COMMTIMEOUTS paramCOMMTIMEOUTS);
/*    */   
/*    */   boolean SetCommState(WinNT.HANDLE paramHANDLE, WinBase.DCB paramDCB);
/*    */   
/*    */   boolean SetCommTimeouts(WinNT.HANDLE paramHANDLE, WinBase.COMMTIMEOUTS paramCOMMTIMEOUTS);
/*    */   
/*    */   boolean ProcessIdToSessionId(int paramInt, IntByReference paramIntByReference);
/*    */   
/*    */   WinDef.HMODULE LoadLibraryEx(String paramString, WinNT.HANDLE paramHANDLE, int paramInt);
/*    */   
/*    */   WinDef.HRSRC FindResource(WinDef.HMODULE paramHMODULE, Pointer paramPointer1, Pointer paramPointer2);
/*    */   
/*    */   WinNT.HANDLE LoadResource(WinDef.HMODULE paramHMODULE, WinDef.HRSRC paramHRSRC);
/*    */   
/*    */   Pointer LockResource(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   int SizeofResource(WinDef.HMODULE paramHMODULE, WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean FreeLibrary(WinDef.HMODULE paramHMODULE);
/*    */   
/*    */   boolean EnumResourceTypes(WinDef.HMODULE paramHMODULE, WinBase.EnumResTypeProc paramEnumResTypeProc, Pointer paramPointer);
/*    */   
/*    */   boolean EnumResourceNames(WinDef.HMODULE paramHMODULE, Pointer paramPointer1, WinBase.EnumResNameProc paramEnumResNameProc, Pointer paramPointer2);
/*    */   
/*    */   boolean Module32FirstW(WinNT.HANDLE paramHANDLE, Tlhelp32.MODULEENTRY32W paramMODULEENTRY32W);
/*    */   
/*    */   boolean Module32NextW(WinNT.HANDLE paramHANDLE, Tlhelp32.MODULEENTRY32W paramMODULEENTRY32W);
/*    */   
/*    */   int SetErrorMode(int paramInt);
/*    */   
/*    */   Pointer GetProcAddress(WinDef.HMODULE paramHMODULE, int paramInt) throws LastErrorException;
/*    */   
/*    */   int SetThreadExecutionState(int paramInt);
/*    */   
/*    */   int ExpandEnvironmentStrings(String paramString, Pointer paramPointer, int paramInt);
/*    */   
/*    */   boolean GetProcessTimes(WinNT.HANDLE paramHANDLE, WinBase.FILETIME paramFILETIME1, WinBase.FILETIME paramFILETIME2, WinBase.FILETIME paramFILETIME3, WinBase.FILETIME paramFILETIME4);
/*    */   
/*    */   boolean GetProcessIoCounters(WinNT.HANDLE paramHANDLE, WinNT.IO_COUNTERS paramIO_COUNTERS);
/*    */   
/*    */   WinNT.HANDLE CreateMutex(WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, boolean paramBoolean, String paramString);
/*    */   
/*    */   WinNT.HANDLE OpenMutex(int paramInt, boolean paramBoolean, String paramString);
/*    */   
/*    */   boolean ReleaseMutex(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   void ExitProcess(int paramInt);
/*    */   
/*    */   Pointer VirtualAllocEx(WinNT.HANDLE paramHANDLE, Pointer paramPointer, BaseTSD.SIZE_T paramSIZE_T, int paramInt1, int paramInt2);
/*    */   
/*    */   boolean GetExitCodeThread(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference);
/*    */   
/*    */   boolean VirtualFreeEx(WinNT.HANDLE paramHANDLE, Pointer paramPointer, BaseTSD.SIZE_T paramSIZE_T, int paramInt);
/*    */   
/*    */   WinNT.HRESULT RegisterApplicationRestart(char[] paramArrayOfchar, int paramInt);
/*    */   
/*    */   WinNT.HRESULT UnregisterApplicationRestart();
/*    */   
/*    */   WinNT.HRESULT GetApplicationRestartSettings(WinNT.HANDLE paramHANDLE, char[] paramArrayOfchar, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Kernel32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */