/*    */ package com.sun.jna.platform.win32;
/*    */ 
/*    */ import com.sun.jna.Library;
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.Structure;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.ptr.LongByReference;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ import com.sun.jna.ptr.ShortByReference;
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
/*    */ public interface Advapi32
/*    */   extends StdCallLibrary
/*    */ {
/* 70 */   public static final Advapi32 INSTANCE = (Advapi32)Native.load("Advapi32", Advapi32.class, W32APIOptions.DEFAULT_OPTIONS);
/*    */   public static final int MAX_KEY_LENGTH = 255;
/*    */   public static final int MAX_VALUE_NAME = 16383;
/*    */   public static final int RRF_RT_ANY = 65535;
/*    */   public static final int RRF_RT_DWORD = 24;
/*    */   public static final int RRF_RT_QWORD = 72;
/*    */   public static final int RRF_RT_REG_BINARY = 8;
/*    */   public static final int RRF_RT_REG_DWORD = 16;
/*    */   public static final int RRF_RT_REG_EXPAND_SZ = 4;
/*    */   public static final int RRF_RT_REG_MULTI_SZ = 32;
/*    */   public static final int RRF_RT_REG_NONE = 1;
/*    */   public static final int RRF_RT_REG_QWORD = 64;
/*    */   public static final int RRF_RT_REG_SZ = 2;
/*    */   public static final int LOGON_WITH_PROFILE = 1;
/*    */   public static final int LOGON_NETCREDENTIALS_ONLY = 2;
/*    */   
/*    */   boolean GetUserNameW(char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   boolean LookupAccountName(String paramString1, String paramString2, WinNT.PSID paramPSID, IntByReference paramIntByReference1, char[] paramArrayOfchar, IntByReference paramIntByReference2, PointerByReference paramPointerByReference);
/*    */   
/*    */   boolean LookupAccountSid(String paramString, WinNT.PSID paramPSID, char[] paramArrayOfchar1, IntByReference paramIntByReference1, char[] paramArrayOfchar2, IntByReference paramIntByReference2, PointerByReference paramPointerByReference);
/*    */   
/*    */   boolean ConvertSidToStringSid(WinNT.PSID paramPSID, PointerByReference paramPointerByReference);
/*    */   
/*    */   boolean ConvertStringSidToSid(String paramString, WinNT.PSIDByReference paramPSIDByReference);
/*    */   
/*    */   int GetLengthSid(WinNT.PSID paramPSID);
/*    */   
/*    */   boolean IsValidSid(WinNT.PSID paramPSID);
/*    */   
/*    */   boolean EqualSid(WinNT.PSID paramPSID1, WinNT.PSID paramPSID2);
/*    */   
/*    */   boolean IsWellKnownSid(WinNT.PSID paramPSID, int paramInt);
/*    */   
/*    */   boolean CreateWellKnownSid(int paramInt, WinNT.PSID paramPSID1, WinNT.PSID paramPSID2, IntByReference paramIntByReference);
/*    */   
/*    */   boolean InitializeSecurityDescriptor(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, int paramInt);
/*    */   
/*    */   boolean GetSecurityDescriptorControl(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, ShortByReference paramShortByReference, IntByReference paramIntByReference);
/*    */   
/*    */   boolean SetSecurityDescriptorControl(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, short paramShort1, short paramShort2);
/*    */   
/*    */   boolean GetSecurityDescriptorOwner(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, WinNT.PSIDByReference paramPSIDByReference, WinDef.BOOLByReference paramBOOLByReference);
/*    */   
/*    */   boolean SetSecurityDescriptorOwner(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, WinNT.PSID paramPSID, boolean paramBoolean);
/*    */   
/*    */   boolean GetSecurityDescriptorGroup(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, WinNT.PSIDByReference paramPSIDByReference, WinDef.BOOLByReference paramBOOLByReference);
/*    */   
/*    */   boolean SetSecurityDescriptorGroup(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, WinNT.PSID paramPSID, boolean paramBoolean);
/*    */   
/*    */   boolean GetSecurityDescriptorDacl(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, WinDef.BOOLByReference paramBOOLByReference1, WinNT.PACLByReference paramPACLByReference, WinDef.BOOLByReference paramBOOLByReference2);
/*    */   
/*    */   boolean SetSecurityDescriptorDacl(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, boolean paramBoolean1, WinNT.ACL paramACL, boolean paramBoolean2);
/*    */   
/*    */   boolean InitializeAcl(WinNT.ACL paramACL, int paramInt1, int paramInt2);
/*    */   
/*    */   boolean AddAce(WinNT.ACL paramACL, int paramInt1, int paramInt2, Pointer paramPointer, int paramInt3);
/*    */   
/*    */   boolean AddAccessAllowedAce(WinNT.ACL paramACL, int paramInt1, int paramInt2, WinNT.PSID paramPSID);
/*    */   
/*    */   boolean AddAccessAllowedAceEx(WinNT.ACL paramACL, int paramInt1, int paramInt2, int paramInt3, WinNT.PSID paramPSID);
/*    */   
/*    */   boolean GetAce(WinNT.ACL paramACL, int paramInt, PointerByReference paramPointerByReference);
/*    */   
/*    */   boolean LogonUser(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, WinNT.HANDLEByReference paramHANDLEByReference);
/*    */   
/*    */   boolean OpenThreadToken(WinNT.HANDLE paramHANDLE, int paramInt, boolean paramBoolean, WinNT.HANDLEByReference paramHANDLEByReference);
/*    */   
/*    */   boolean SetThreadToken(WinNT.HANDLEByReference paramHANDLEByReference, WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean OpenProcessToken(WinNT.HANDLE paramHANDLE, int paramInt, WinNT.HANDLEByReference paramHANDLEByReference);
/*    */   
/*    */   boolean DuplicateToken(WinNT.HANDLE paramHANDLE, int paramInt, WinNT.HANDLEByReference paramHANDLEByReference);
/*    */   
/*    */   boolean DuplicateTokenEx(WinNT.HANDLE paramHANDLE, int paramInt1, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, int paramInt2, int paramInt3, WinNT.HANDLEByReference paramHANDLEByReference);
/*    */   
/*    */   boolean GetTokenInformation(WinNT.HANDLE paramHANDLE, int paramInt1, Structure paramStructure, int paramInt2, IntByReference paramIntByReference);
/*    */   
/*    */   boolean ImpersonateLoggedOnUser(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean ImpersonateSelf(int paramInt);
/*    */   
/*    */   boolean RevertToSelf();
/*    */   
/*    */   int RegOpenKeyEx(WinReg.HKEY paramHKEY, String paramString, int paramInt1, int paramInt2, WinReg.HKEYByReference paramHKEYByReference);
/*    */   
/*    */   int RegConnectRegistry(String paramString, WinReg.HKEY paramHKEY, WinReg.HKEYByReference paramHKEYByReference);
/*    */   
/*    */   int RegQueryValueEx(WinReg.HKEY paramHKEY, String paramString, int paramInt, IntByReference paramIntByReference1, char[] paramArrayOfchar, IntByReference paramIntByReference2);
/*    */   
/*    */   int RegQueryValueEx(WinReg.HKEY paramHKEY, String paramString, int paramInt, IntByReference paramIntByReference1, byte[] paramArrayOfbyte, IntByReference paramIntByReference2);
/*    */   
/*    */   int RegQueryValueEx(WinReg.HKEY paramHKEY, String paramString, int paramInt, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3);
/*    */   
/*    */   int RegQueryValueEx(WinReg.HKEY paramHKEY, String paramString, int paramInt, IntByReference paramIntByReference1, LongByReference paramLongByReference, IntByReference paramIntByReference2);
/*    */   
/*    */   int RegQueryValueEx(WinReg.HKEY paramHKEY, String paramString, int paramInt, IntByReference paramIntByReference1, Pointer paramPointer, IntByReference paramIntByReference2);
/*    */   
/*    */   int RegCloseKey(WinReg.HKEY paramHKEY);
/*    */   
/*    */   int RegDeleteValue(WinReg.HKEY paramHKEY, String paramString);
/*    */   
/*    */   int RegSetValueEx(WinReg.HKEY paramHKEY, String paramString, int paramInt1, int paramInt2, Pointer paramPointer, int paramInt3);
/*    */   
/*    */   int RegSetValueEx(WinReg.HKEY paramHKEY, String paramString, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3);
/*    */   
/*    */   int RegSetValueEx(WinReg.HKEY paramHKEY, String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, int paramInt3);
/*    */   
/*    */   int RegCreateKeyEx(WinReg.HKEY paramHKEY, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES, WinReg.HKEYByReference paramHKEYByReference, IntByReference paramIntByReference);
/*    */   
/*    */   int RegDeleteKey(WinReg.HKEY paramHKEY, String paramString);
/*    */   
/*    */   int RegEnumKeyEx(WinReg.HKEY paramHKEY, int paramInt, char[] paramArrayOfchar1, IntByReference paramIntByReference1, IntByReference paramIntByReference2, char[] paramArrayOfchar2, IntByReference paramIntByReference3, WinBase.FILETIME paramFILETIME);
/*    */   
/*    */   int RegEnumValue(WinReg.HKEY paramHKEY, int paramInt, char[] paramArrayOfchar, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3, Pointer paramPointer, IntByReference paramIntByReference4);
/*    */   
/*    */   int RegEnumValue(WinReg.HKEY paramHKEY, int paramInt, char[] paramArrayOfchar, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3, byte[] paramArrayOfbyte, IntByReference paramIntByReference4);
/*    */   
/*    */   int RegQueryInfoKey(WinReg.HKEY paramHKEY, char[] paramArrayOfchar, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3, IntByReference paramIntByReference4, IntByReference paramIntByReference5, IntByReference paramIntByReference6, IntByReference paramIntByReference7, IntByReference paramIntByReference8, IntByReference paramIntByReference9, WinBase.FILETIME paramFILETIME);
/*    */   
/*    */   int RegGetValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt, IntByReference paramIntByReference1, Pointer paramPointer, IntByReference paramIntByReference2);
/*    */   
/*    */   int RegGetValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt, IntByReference paramIntByReference1, byte[] paramArrayOfbyte, IntByReference paramIntByReference2);
/*    */   
/*    */   int RegNotifyChangeKeyValue(WinReg.HKEY paramHKEY, boolean paramBoolean1, int paramInt, WinNT.HANDLE paramHANDLE, boolean paramBoolean2);
/*    */   
/*    */   WinNT.HANDLE RegisterEventSource(String paramString1, String paramString2);
/*    */   
/*    */   boolean DeregisterEventSource(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   WinNT.HANDLE OpenEventLog(String paramString1, String paramString2);
/*    */   
/*    */   boolean CloseEventLog(WinNT.HANDLE paramHANDLE);
/*    */   
/*    */   boolean GetNumberOfEventLogRecords(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference);
/*    */   
/*    */   boolean ReportEvent(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2, int paramInt3, WinNT.PSID paramPSID, int paramInt4, int paramInt5, String[] paramArrayOfString, Pointer paramPointer);
/*    */   
/*    */   boolean ClearEventLog(WinNT.HANDLE paramHANDLE, String paramString);
/*    */   
/*    */   boolean BackupEventLog(WinNT.HANDLE paramHANDLE, String paramString);
/*    */   
/*    */   WinNT.HANDLE OpenBackupEventLog(String paramString1, String paramString2);
/*    */   
/*    */   boolean ReadEventLog(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2, Pointer paramPointer, int paramInt3, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*    */   
/*    */   boolean GetOldestEventLogRecord(WinNT.HANDLE paramHANDLE, IntByReference paramIntByReference);
/*    */   
/*    */   boolean ChangeServiceConfig2(Winsvc.SC_HANDLE paramSC_HANDLE, int paramInt, Winsvc.ChangeServiceConfig2Info paramChangeServiceConfig2Info);
/*    */   
/*    */   boolean QueryServiceConfig2(Winsvc.SC_HANDLE paramSC_HANDLE, int paramInt1, Pointer paramPointer, int paramInt2, IntByReference paramIntByReference);
/*    */   
/*    */   boolean QueryServiceStatusEx(Winsvc.SC_HANDLE paramSC_HANDLE, int paramInt1, Winsvc.SERVICE_STATUS_PROCESS paramSERVICE_STATUS_PROCESS, int paramInt2, IntByReference paramIntByReference);
/*    */   
/*    */   boolean QueryServiceStatus(Winsvc.SC_HANDLE paramSC_HANDLE, Winsvc.SERVICE_STATUS paramSERVICE_STATUS);
/*    */   
/*    */   boolean ControlService(Winsvc.SC_HANDLE paramSC_HANDLE, int paramInt, Winsvc.SERVICE_STATUS paramSERVICE_STATUS);
/*    */   
/*    */   boolean StartService(Winsvc.SC_HANDLE paramSC_HANDLE, int paramInt, String[] paramArrayOfString);
/*    */   
/*    */   boolean CloseServiceHandle(Winsvc.SC_HANDLE paramSC_HANDLE);
/*    */   
/*    */   Winsvc.SC_HANDLE OpenService(Winsvc.SC_HANDLE paramSC_HANDLE, String paramString, int paramInt);
/*    */   
/*    */   Winsvc.SC_HANDLE OpenSCManager(String paramString1, String paramString2, int paramInt);
/*    */   
/*    */   boolean EnumDependentServices(Winsvc.SC_HANDLE paramSC_HANDLE, int paramInt1, Pointer paramPointer, int paramInt2, IntByReference paramIntByReference1, IntByReference paramIntByReference2);
/*    */   
/*    */   boolean EnumServicesStatusEx(Winsvc.SC_HANDLE paramSC_HANDLE, int paramInt1, int paramInt2, int paramInt3, Pointer paramPointer, int paramInt4, IntByReference paramIntByReference1, IntByReference paramIntByReference2, IntByReference paramIntByReference3, String paramString);
/*    */   
/*    */   boolean CreateProcessAsUser(WinNT.HANDLE paramHANDLE, String paramString1, String paramString2, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES1, WinBase.SECURITY_ATTRIBUTES paramSECURITY_ATTRIBUTES2, boolean paramBoolean, int paramInt, String paramString3, String paramString4, WinBase.STARTUPINFO paramSTARTUPINFO, WinBase.PROCESS_INFORMATION paramPROCESS_INFORMATION);
/*    */   
/*    */   boolean AdjustTokenPrivileges(WinNT.HANDLE paramHANDLE, boolean paramBoolean, WinNT.TOKEN_PRIVILEGES paramTOKEN_PRIVILEGES1, int paramInt, WinNT.TOKEN_PRIVILEGES paramTOKEN_PRIVILEGES2, IntByReference paramIntByReference);
/*    */   
/*    */   boolean LookupPrivilegeName(String paramString, WinNT.LUID paramLUID, char[] paramArrayOfchar, IntByReference paramIntByReference);
/*    */   
/*    */   boolean LookupPrivilegeValue(String paramString1, String paramString2, WinNT.LUID paramLUID);
/*    */   
/*    */   boolean GetFileSecurity(String paramString, int paramInt1, Pointer paramPointer, int paramInt2, IntByReference paramIntByReference);
/*    */   
/*    */   boolean SetFileSecurity(String paramString, int paramInt, Pointer paramPointer);
/*    */   
/*    */   int GetSecurityInfo(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2, PointerByReference paramPointerByReference1, PointerByReference paramPointerByReference2, PointerByReference paramPointerByReference3, PointerByReference paramPointerByReference4, PointerByReference paramPointerByReference5);
/*    */   
/*    */   int SetSecurityInfo(WinNT.HANDLE paramHANDLE, int paramInt1, int paramInt2, Pointer paramPointer1, Pointer paramPointer2, Pointer paramPointer3, Pointer paramPointer4);
/*    */   
/*    */   int GetNamedSecurityInfo(String paramString, int paramInt1, int paramInt2, PointerByReference paramPointerByReference1, PointerByReference paramPointerByReference2, PointerByReference paramPointerByReference3, PointerByReference paramPointerByReference4, PointerByReference paramPointerByReference5);
/*    */   
/*    */   int SetNamedSecurityInfo(String paramString, int paramInt1, int paramInt2, Pointer paramPointer1, Pointer paramPointer2, Pointer paramPointer3, Pointer paramPointer4);
/*    */   
/*    */   int GetSecurityDescriptorLength(Pointer paramPointer);
/*    */   
/*    */   boolean IsValidSecurityDescriptor(Pointer paramPointer);
/*    */   
/*    */   boolean MakeSelfRelativeSD(WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, WinNT.SECURITY_DESCRIPTOR_RELATIVE paramSECURITY_DESCRIPTOR_RELATIVE, IntByReference paramIntByReference);
/*    */   
/*    */   boolean MakeAbsoluteSD(WinNT.SECURITY_DESCRIPTOR_RELATIVE paramSECURITY_DESCRIPTOR_RELATIVE, WinNT.SECURITY_DESCRIPTOR paramSECURITY_DESCRIPTOR, IntByReference paramIntByReference1, WinNT.ACL paramACL1, IntByReference paramIntByReference2, WinNT.ACL paramACL2, IntByReference paramIntByReference3, WinNT.PSID paramPSID1, IntByReference paramIntByReference4, WinNT.PSID paramPSID2, IntByReference paramIntByReference5);
/*    */   
/*    */   boolean IsValidAcl(Pointer paramPointer);
/*    */   
/*    */   void MapGenericMask(WinDef.DWORDByReference paramDWORDByReference, WinNT.GENERIC_MAPPING paramGENERIC_MAPPING);
/*    */   
/*    */   boolean AccessCheck(Pointer paramPointer, WinNT.HANDLE paramHANDLE, WinDef.DWORD paramDWORD, WinNT.GENERIC_MAPPING paramGENERIC_MAPPING, WinNT.PRIVILEGE_SET paramPRIVILEGE_SET, WinDef.DWORDByReference paramDWORDByReference1, WinDef.DWORDByReference paramDWORDByReference2, WinDef.BOOLByReference paramBOOLByReference);
/*    */   
/*    */   boolean EncryptFile(String paramString);
/*    */   
/*    */   boolean DecryptFile(String paramString, WinDef.DWORD paramDWORD);
/*    */   
/*    */   boolean FileEncryptionStatus(String paramString, WinDef.DWORDByReference paramDWORDByReference);
/*    */   
/*    */   boolean EncryptionDisable(String paramString, boolean paramBoolean);
/*    */   
/*    */   int OpenEncryptedFileRaw(String paramString, WinDef.ULONG paramULONG, PointerByReference paramPointerByReference);
/*    */   
/*    */   int ReadEncryptedFileRaw(WinBase.FE_EXPORT_FUNC paramFE_EXPORT_FUNC, Pointer paramPointer1, Pointer paramPointer2);
/*    */   
/*    */   int WriteEncryptedFileRaw(WinBase.FE_IMPORT_FUNC paramFE_IMPORT_FUNC, Pointer paramPointer1, Pointer paramPointer2);
/*    */   
/*    */   void CloseEncryptedFileRaw(Pointer paramPointer);
/*    */   
/*    */   boolean CreateProcessWithLogonW(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, Pointer paramPointer, String paramString6, WinBase.STARTUPINFO paramSTARTUPINFO, WinBase.PROCESS_INFORMATION paramPROCESS_INFORMATION);
/*    */   
/*    */   boolean StartServiceCtrlDispatcher(Winsvc.SERVICE_TABLE_ENTRY[] paramArrayOfSERVICE_TABLE_ENTRY);
/*    */   
/*    */   Winsvc.SERVICE_STATUS_HANDLE RegisterServiceCtrlHandler(String paramString, Library.Handler paramHandler);
/*    */   
/*    */   Winsvc.SERVICE_STATUS_HANDLE RegisterServiceCtrlHandlerEx(String paramString, Winsvc.HandlerEx paramHandlerEx, Pointer paramPointer);
/*    */   
/*    */   boolean SetServiceStatus(Winsvc.SERVICE_STATUS_HANDLE paramSERVICE_STATUS_HANDLE, Winsvc.SERVICE_STATUS paramSERVICE_STATUS);
/*    */   
/*    */   Winsvc.SC_HANDLE CreateService(Winsvc.SC_HANDLE paramSC_HANDLE, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, IntByReference paramIntByReference, String paramString5, String paramString6, String paramString7);
/*    */   
/*    */   boolean DeleteService(Winsvc.SC_HANDLE paramSC_HANDLE);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Advapi32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */