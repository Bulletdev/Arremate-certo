/*      */ package com.sun.jna.platform.win32;
/*      */ 
/*      */ import com.sun.jna.Memory;
/*      */ import com.sun.jna.Native;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.ptr.IntByReference;
/*      */ import com.sun.jna.ptr.LongByReference;
/*      */ import com.sun.jna.ptr.PointerByReference;
/*      */ import com.sun.jna.win32.W32APITypeMapper;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.TreeMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class Advapi32Util
/*      */ {
/*      */   public static class Account
/*      */   {
/*      */     public String name;
/*      */     public String domain;
/*      */     public byte[] sid;
/*      */     public String sidString;
/*      */     public int accountType;
/*      */     public String fqn;
/*      */   }
/*      */   
/*      */   public static String getUserName() {
/*  145 */     char[] arrayOfChar = new char[128];
/*  146 */     IntByReference intByReference = new IntByReference(arrayOfChar.length);
/*  147 */     boolean bool = Advapi32.INSTANCE.GetUserNameW(arrayOfChar, intByReference);
/*      */     
/*  149 */     if (!bool) {
/*  150 */       switch (Kernel32.INSTANCE.GetLastError()) {
/*      */         case 122:
/*  152 */           arrayOfChar = new char[intByReference.getValue()];
/*      */           break;
/*      */         
/*      */         default:
/*  156 */           throw new Win32Exception(Native.getLastError());
/*      */       } 
/*      */       
/*  159 */       bool = Advapi32.INSTANCE.GetUserNameW(arrayOfChar, intByReference);
/*      */     } 
/*      */     
/*  162 */     if (!bool) {
/*  163 */       throw new Win32Exception(Native.getLastError());
/*      */     }
/*      */     
/*  166 */     return Native.toString(arrayOfChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account getAccountByName(String paramString) {
/*  178 */     return getAccountByName(null, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account getAccountByName(String paramString1, String paramString2) {
/*  191 */     IntByReference intByReference1 = new IntByReference(0);
/*  192 */     IntByReference intByReference2 = new IntByReference(0);
/*  193 */     PointerByReference pointerByReference = new PointerByReference();
/*      */     
/*  195 */     if (Advapi32.INSTANCE.LookupAccountName(paramString1, paramString2, null, intByReference1, null, intByReference2, pointerByReference))
/*      */     {
/*  197 */       throw new RuntimeException("LookupAccountNameW was expected to fail with ERROR_INSUFFICIENT_BUFFER");
/*      */     }
/*      */ 
/*      */     
/*  201 */     int i = Kernel32.INSTANCE.GetLastError();
/*  202 */     if (intByReference1.getValue() == 0 || i != 122) {
/*  203 */       throw new Win32Exception(i);
/*      */     }
/*      */     
/*  206 */     Memory memory = new Memory(intByReference1.getValue());
/*  207 */     WinNT.PSID pSID = new WinNT.PSID((Pointer)memory);
/*  208 */     char[] arrayOfChar = new char[intByReference2.getValue() + 1];
/*      */     
/*  210 */     if (!Advapi32.INSTANCE.LookupAccountName(paramString1, paramString2, pSID, intByReference1, arrayOfChar, intByReference2, pointerByReference))
/*      */     {
/*  212 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  215 */     Account account = new Account();
/*  216 */     account.accountType = pointerByReference.getPointer().getInt(0L);
/*      */     
/*  218 */     String[] arrayOfString1 = paramString2.split("\\\\", 2);
/*  219 */     String[] arrayOfString2 = paramString2.split("@", 2);
/*      */     
/*  221 */     if (arrayOfString1.length == 2) {
/*  222 */       account.name = arrayOfString1[1];
/*  223 */     } else if (arrayOfString2.length == 2) {
/*  224 */       account.name = arrayOfString2[0];
/*      */     } else {
/*  226 */       account.name = paramString2;
/*      */     } 
/*      */     
/*  229 */     if (intByReference2.getValue() > 0) {
/*  230 */       account.domain = Native.toString(arrayOfChar);
/*  231 */       account.fqn = account.domain + "\\" + account.name;
/*      */     } else {
/*  233 */       account.fqn = account.name;
/*      */     } 
/*      */     
/*  236 */     account.sid = pSID.getBytes();
/*  237 */     account.sidString = convertSidToStringSid(new WinNT.PSID(account.sid));
/*  238 */     return account;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account getAccountBySid(WinNT.PSID paramPSID) {
/*  249 */     return getAccountBySid((String)null, paramPSID);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account getAccountBySid(String paramString, WinNT.PSID paramPSID) {
/*  263 */     IntByReference intByReference1 = new IntByReference(257);
/*      */     
/*  265 */     IntByReference intByReference2 = new IntByReference(256);
/*  266 */     PointerByReference pointerByReference = new PointerByReference();
/*      */     
/*  268 */     char[] arrayOfChar1 = new char[intByReference2.getValue()];
/*  269 */     char[] arrayOfChar2 = new char[intByReference1.getValue()];
/*      */     
/*  271 */     int i = 0;
/*  272 */     if (!Advapi32.INSTANCE.LookupAccountSid(paramString, paramPSID, arrayOfChar2, intByReference1, arrayOfChar1, intByReference2, pointerByReference)) {
/*      */       
/*  274 */       i = Kernel32.INSTANCE.GetLastError();
/*  275 */       if (i != 1332) {
/*  276 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */     
/*  280 */     Account account = new Account();
/*  281 */     if (i == 1332) {
/*  282 */       account.accountType = 8;
/*  283 */       account.name = "NONE_MAPPED";
/*      */     } else {
/*  285 */       account.accountType = pointerByReference.getPointer().getInt(0L);
/*  286 */       account.name = Native.toString(arrayOfChar2);
/*      */     } 
/*      */     
/*  289 */     account.domain = Native.toString(arrayOfChar1);
/*  290 */     if (account.domain.isEmpty()) {
/*  291 */       account.fqn = account.name;
/*      */     } else {
/*  293 */       account.fqn = account.domain + "\\" + account.name;
/*      */     } 
/*      */     
/*  296 */     account.sid = paramPSID.getBytes();
/*  297 */     account.sidString = convertSidToStringSid(paramPSID);
/*  298 */     return account;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String convertSidToStringSid(WinNT.PSID paramPSID) {
/*  310 */     PointerByReference pointerByReference = new PointerByReference();
/*  311 */     if (!Advapi32.INSTANCE.ConvertSidToStringSid(paramPSID, pointerByReference)) {
/*  312 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  315 */     Pointer pointer = pointerByReference.getValue();
/*      */     try {
/*  317 */       return pointer.getWideString(0L);
/*      */     } finally {
/*  319 */       Kernel32Util.freeLocalMemory(pointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] convertStringSidToSid(String paramString) {
/*  332 */     WinNT.PSIDByReference pSIDByReference = new WinNT.PSIDByReference();
/*  333 */     if (!Advapi32.INSTANCE.ConvertStringSidToSid(paramString, pSIDByReference)) {
/*  334 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  337 */     WinNT.PSID pSID = pSIDByReference.getValue();
/*      */     try {
/*  339 */       return pSID.getBytes();
/*      */     } finally {
/*  341 */       Kernel32Util.freeLocalMemory(pSID.getPointer());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isWellKnownSid(String paramString, int paramInt) {
/*  356 */     WinNT.PSIDByReference pSIDByReference = new WinNT.PSIDByReference();
/*  357 */     if (!Advapi32.INSTANCE.ConvertStringSidToSid(paramString, pSIDByReference)) {
/*  358 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  361 */     WinNT.PSID pSID = pSIDByReference.getValue();
/*      */     try {
/*  363 */       return Advapi32.INSTANCE.IsWellKnownSid(pSID, paramInt);
/*      */     } finally {
/*  365 */       Kernel32Util.freeLocalMemory(pSID.getPointer());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isWellKnownSid(byte[] paramArrayOfbyte, int paramInt) {
/*  380 */     WinNT.PSID pSID = new WinNT.PSID(paramArrayOfbyte);
/*  381 */     return Advapi32.INSTANCE.IsWellKnownSid(pSID, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int alignOnDWORD(int paramInt) {
/*  390 */     return paramInt + 3 & 0xFFFFFFFC;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getAceSize(int paramInt) {
/*  399 */     return Native.getNativeSize(WinNT.ACCESS_ALLOWED_ACE.class, null) + paramInt - 4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account getAccountBySid(String paramString) {
/*  412 */     return getAccountBySid((String)null, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account getAccountBySid(String paramString1, String paramString2) {
/*  425 */     return getAccountBySid(paramString1, new WinNT.PSID(convertStringSidToSid(paramString2)));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account[] getTokenGroups(WinNT.HANDLE paramHANDLE) {
/*  438 */     IntByReference intByReference = new IntByReference();
/*  439 */     if (Advapi32.INSTANCE.GetTokenInformation(paramHANDLE, 2, null, 0, intByReference))
/*      */     {
/*      */       
/*  442 */       throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
/*      */     }
/*      */     
/*  445 */     int i = Kernel32.INSTANCE.GetLastError();
/*  446 */     if (i != 122) {
/*  447 */       throw new Win32Exception(i);
/*      */     }
/*      */ 
/*      */     
/*  451 */     WinNT.TOKEN_GROUPS tOKEN_GROUPS = new WinNT.TOKEN_GROUPS(intByReference.getValue());
/*  452 */     if (!Advapi32.INSTANCE.GetTokenInformation(paramHANDLE, 2, tOKEN_GROUPS, intByReference
/*      */         
/*  454 */         .getValue(), intByReference)) {
/*  455 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*  457 */     ArrayList<Account> arrayList = new ArrayList();
/*      */     
/*  459 */     for (WinNT.SID_AND_ATTRIBUTES sID_AND_ATTRIBUTES : tOKEN_GROUPS.getGroups()) {
/*      */       Account account;
/*      */       try {
/*  462 */         account = getAccountBySid(sID_AND_ATTRIBUTES.Sid);
/*  463 */       } catch (Exception exception) {
/*  464 */         account = new Account();
/*  465 */         account.sid = sID_AND_ATTRIBUTES.Sid.getBytes();
/*  466 */         account
/*  467 */           .sidString = convertSidToStringSid(sID_AND_ATTRIBUTES.Sid);
/*  468 */         account.name = account.sidString;
/*  469 */         account.fqn = account.sidString;
/*  470 */         account.accountType = 2;
/*      */       } 
/*  472 */       arrayList.add(account);
/*      */     } 
/*  474 */     return arrayList.<Account>toArray(new Account[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account getTokenPrimaryGroup(WinNT.HANDLE paramHANDLE) {
/*      */     Account account;
/*  487 */     IntByReference intByReference = new IntByReference();
/*  488 */     if (Advapi32.INSTANCE.GetTokenInformation(paramHANDLE, 5, null, 0, intByReference))
/*      */     {
/*  490 */       throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
/*      */     }
/*  492 */     int i = Kernel32.INSTANCE.GetLastError();
/*  493 */     if (i != 122) {
/*  494 */       throw new Win32Exception(i);
/*      */     }
/*      */     
/*  497 */     WinNT.TOKEN_PRIMARY_GROUP tOKEN_PRIMARY_GROUP = new WinNT.TOKEN_PRIMARY_GROUP(intByReference.getValue());
/*  498 */     if (!Advapi32.INSTANCE.GetTokenInformation(paramHANDLE, 5, tOKEN_PRIMARY_GROUP, intByReference
/*  499 */         .getValue(), intByReference)) {
/*  500 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*      */     try {
/*  504 */       account = getAccountBySid(tOKEN_PRIMARY_GROUP.PrimaryGroup);
/*  505 */     } catch (Exception exception) {
/*  506 */       account = new Account();
/*  507 */       account.sid = tOKEN_PRIMARY_GROUP.PrimaryGroup.getBytes();
/*  508 */       account.sidString = convertSidToStringSid(tOKEN_PRIMARY_GROUP.PrimaryGroup);
/*  509 */       account.name = account.sidString;
/*  510 */       account.fqn = account.sidString;
/*  511 */       account.accountType = 2;
/*      */     } 
/*  513 */     return account;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account getTokenAccount(WinNT.HANDLE paramHANDLE) {
/*  526 */     IntByReference intByReference = new IntByReference();
/*  527 */     if (Advapi32.INSTANCE.GetTokenInformation(paramHANDLE, 1, null, 0, intByReference))
/*      */     {
/*      */       
/*  530 */       throw new RuntimeException("Expected GetTokenInformation to fail with ERROR_INSUFFICIENT_BUFFER");
/*      */     }
/*      */     
/*  533 */     int i = Kernel32.INSTANCE.GetLastError();
/*  534 */     if (i != 122) {
/*  535 */       throw new Win32Exception(i);
/*      */     }
/*      */ 
/*      */     
/*  539 */     WinNT.TOKEN_USER tOKEN_USER = new WinNT.TOKEN_USER(intByReference.getValue());
/*  540 */     if (!Advapi32.INSTANCE.GetTokenInformation(paramHANDLE, 1, tOKEN_USER, intByReference
/*      */         
/*  542 */         .getValue(), intByReference)) {
/*  543 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*  545 */     return getAccountBySid(tOKEN_USER.User.Sid);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Account[] getCurrentUserGroups() {
/*  554 */     WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/*  555 */     Win32Exception win32Exception = null;
/*      */     
/*      */     try {
/*  558 */       WinNT.HANDLE hANDLE1 = Kernel32.INSTANCE.GetCurrentThread();
/*  559 */       if (!Advapi32.INSTANCE.OpenThreadToken(hANDLE1, 10, true, hANDLEByReference)) {
/*      */         
/*  561 */         int i = Kernel32.INSTANCE.GetLastError();
/*  562 */         if (i != 1008) {
/*  563 */           throw new Win32Exception(i);
/*      */         }
/*      */         
/*  566 */         WinNT.HANDLE hANDLE = Kernel32.INSTANCE.GetCurrentProcess();
/*  567 */         if (!Advapi32.INSTANCE.OpenProcessToken(hANDLE, 10, hANDLEByReference))
/*      */         {
/*  569 */           throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */         }
/*      */       } 
/*      */       
/*  573 */       return getTokenGroups(hANDLEByReference.getValue());
/*  574 */     } catch (Win32Exception win32Exception1) {
/*  575 */       win32Exception = win32Exception1;
/*  576 */       throw win32Exception;
/*      */     } finally {
/*  578 */       WinNT.HANDLE hANDLE = hANDLEByReference.getValue();
/*  579 */       if (!WinBase.INVALID_HANDLE_VALUE.equals(hANDLE)) {
/*      */         try {
/*  581 */           Kernel32Util.closeHandle(hANDLE);
/*  582 */         } catch (Win32Exception win32Exception1) {
/*  583 */           if (win32Exception == null) {
/*  584 */             win32Exception = win32Exception1;
/*      */           } else {
/*  586 */             win32Exception.addSuppressedReflected((Throwable)win32Exception1);
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/*  591 */       if (win32Exception != null) {
/*  592 */         throw win32Exception;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registryKeyExists(WinReg.HKEY paramHKEY, String paramString) {
/*  607 */     return registryKeyExists(paramHKEY, paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registryKeyExists(WinReg.HKEY paramHKEY, String paramString, int paramInt) {
/*  623 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/*  624 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/*  626 */     switch (i) {
/*      */       case 0:
/*  628 */         Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/*  629 */         return true;
/*      */       case 2:
/*  631 */         return false;
/*      */     } 
/*  633 */     throw new Win32Exception(i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registryValueExists(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/*  649 */     return registryValueExists(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registryValueExists(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/*  668 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/*  669 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/*  671 */     switch (i) {
/*      */       case 0:
/*      */         break;
/*      */       case 2:
/*  675 */         return false;
/*      */       default:
/*  677 */         throw new Win32Exception(i);
/*      */     }  try {
/*      */       boolean bool;
/*  680 */       IntByReference intByReference1 = new IntByReference();
/*  681 */       IntByReference intByReference2 = new IntByReference();
/*  682 */       i = Advapi32.INSTANCE.RegQueryValueEx(hKEYByReference.getValue(), paramString2, 0, intByReference2, (Pointer)null, intByReference1);
/*      */       
/*  684 */       switch (i) {
/*      */         case 0:
/*      */         case 122:
/*      */         case 234:
/*  688 */           bool = true; return bool;
/*      */         case 2:
/*  690 */           bool = false; return bool;
/*      */       } 
/*  692 */       throw new Win32Exception(i);
/*      */     } finally {
/*      */       
/*  695 */       if (hKEYByReference.getValue() != WinBase.INVALID_HANDLE_VALUE) {
/*  696 */         i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/*  697 */         if (i != 0) {
/*  698 */           throw new Win32Exception(i);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String registryGetStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/*  717 */     return registryGetStringValue(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String registryGetStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/*  736 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/*  737 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/*  739 */     if (i != 0) {
/*  740 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/*  743 */       return registryGetStringValue(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/*  745 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/*  746 */       if (i != 0) {
/*  747 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String registryGetStringValue(WinReg.HKEY paramHKEY, String paramString) {
/*  762 */     IntByReference intByReference1 = new IntByReference();
/*  763 */     IntByReference intByReference2 = new IntByReference();
/*  764 */     int i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (Pointer)null, intByReference1);
/*      */     
/*  766 */     if (i != 0 && i != 122)
/*      */     {
/*  768 */       throw new Win32Exception(i);
/*      */     }
/*  770 */     if (intByReference2.getValue() != 1 && intByReference2
/*  771 */       .getValue() != 2) {
/*  772 */       throw new RuntimeException("Unexpected registry type " + intByReference2
/*  773 */           .getValue() + ", expected REG_SZ or REG_EXPAND_SZ");
/*      */     }
/*      */     
/*  776 */     if (intByReference1.getValue() == 0) {
/*  777 */       return "";
/*      */     }
/*      */     
/*  780 */     Memory memory = new Memory((intByReference1.getValue() + Native.WCHAR_SIZE));
/*  781 */     memory.clear();
/*  782 */     i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (Pointer)memory, intByReference1);
/*      */     
/*  784 */     if (i != 0 && i != 122)
/*      */     {
/*  786 */       throw new Win32Exception(i);
/*      */     }
/*  788 */     if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/*  789 */       return memory.getWideString(0L);
/*      */     }
/*  791 */     return memory.getString(0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String registryGetExpandableStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/*  808 */     return registryGetExpandableStringValue(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String registryGetExpandableStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/*  827 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/*  828 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/*  830 */     if (i != 0) {
/*  831 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/*  834 */       return registryGetExpandableStringValue(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/*  836 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/*  837 */       if (i != 0) {
/*  838 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String registryGetExpandableStringValue(WinReg.HKEY paramHKEY, String paramString) {
/*  853 */     IntByReference intByReference1 = new IntByReference();
/*  854 */     IntByReference intByReference2 = new IntByReference();
/*  855 */     int i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (char[])null, intByReference1);
/*      */     
/*  857 */     if (i != 0 && i != 122)
/*      */     {
/*  859 */       throw new Win32Exception(i);
/*      */     }
/*  861 */     if (intByReference2.getValue() != 2) {
/*  862 */       throw new RuntimeException("Unexpected registry type " + intByReference2
/*  863 */           .getValue() + ", expected REG_SZ");
/*      */     }
/*  865 */     if (intByReference1.getValue() == 0) {
/*  866 */       return "";
/*      */     }
/*      */     
/*  869 */     Memory memory = new Memory((intByReference1.getValue() + Native.WCHAR_SIZE));
/*  870 */     memory.clear();
/*  871 */     i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (Pointer)memory, intByReference1);
/*      */     
/*  873 */     if (i != 0 && i != 122)
/*      */     {
/*  875 */       throw new Win32Exception(i);
/*      */     }
/*  877 */     if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/*  878 */       return memory.getWideString(0L);
/*      */     }
/*  880 */     return memory.getString(0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] registryGetStringArray(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/*  897 */     return registryGetStringArray(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] registryGetStringArray(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/*  916 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/*  917 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/*  919 */     if (i != 0) {
/*  920 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/*  923 */       return registryGetStringArray(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/*  925 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/*  926 */       if (i != 0) {
/*  927 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] registryGetStringArray(WinReg.HKEY paramHKEY, String paramString) {
/*  942 */     IntByReference intByReference1 = new IntByReference();
/*  943 */     IntByReference intByReference2 = new IntByReference();
/*  944 */     int i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (char[])null, intByReference1);
/*      */     
/*  946 */     if (i != 0 && i != 122)
/*      */     {
/*  948 */       throw new Win32Exception(i);
/*      */     }
/*  950 */     if (intByReference2.getValue() != 7) {
/*  951 */       throw new RuntimeException("Unexpected registry type " + intByReference2
/*  952 */           .getValue() + ", expected REG_SZ");
/*      */     }
/*      */ 
/*      */     
/*  956 */     Memory memory = new Memory((intByReference1.getValue() + 2 * Native.WCHAR_SIZE));
/*  957 */     memory.clear();
/*  958 */     i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (Pointer)memory, intByReference1);
/*      */     
/*  960 */     if (i != 0 && i != 122)
/*      */     {
/*  962 */       throw new Win32Exception(i);
/*      */     }
/*  964 */     return regMultiSzBufferToStringArray(memory);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String[] regMultiSzBufferToStringArray(Memory paramMemory) {
/*  977 */     ArrayList<String> arrayList = new ArrayList();
/*  978 */     int i = 0;
/*  979 */     while (i < paramMemory.size()) {
/*      */       String str;
/*  981 */       if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/*  982 */         str = paramMemory.getWideString(i);
/*  983 */         i += str.length() * Native.WCHAR_SIZE;
/*  984 */         i += Native.WCHAR_SIZE;
/*      */       } else {
/*  986 */         str = paramMemory.getString(i);
/*  987 */         i += str.length();
/*  988 */         i++;
/*      */       } 
/*      */       
/*  991 */       if (str.length() == 0) {
/*      */         break;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  997 */       arrayList.add(str);
/*      */     } 
/*      */     
/* 1000 */     return arrayList.<String>toArray(new String[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] registryGetBinaryValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/* 1016 */     return registryGetBinaryValue(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] registryGetBinaryValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/* 1035 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1036 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/* 1038 */     if (i != 0) {
/* 1039 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1042 */       return registryGetBinaryValue(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/* 1044 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1045 */       if (i != 0) {
/* 1046 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] registryGetBinaryValue(WinReg.HKEY paramHKEY, String paramString) {
/* 1061 */     IntByReference intByReference1 = new IntByReference();
/* 1062 */     IntByReference intByReference2 = new IntByReference();
/* 1063 */     int i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (Pointer)null, intByReference1);
/*      */     
/* 1065 */     if (i != 0 && i != 122)
/*      */     {
/* 1067 */       throw new Win32Exception(i);
/*      */     }
/* 1069 */     if (intByReference2.getValue() != 3) {
/* 1070 */       throw new RuntimeException("Unexpected registry type " + intByReference2
/* 1071 */           .getValue() + ", expected REG_BINARY");
/*      */     }
/* 1073 */     byte[] arrayOfByte = new byte[intByReference1.getValue()];
/* 1074 */     i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, arrayOfByte, intByReference1);
/*      */     
/* 1076 */     if (i != 0 && i != 122)
/*      */     {
/* 1078 */       throw new Win32Exception(i);
/*      */     }
/* 1080 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int registryGetIntValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/* 1095 */     return registryGetIntValue(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int registryGetIntValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/* 1113 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1114 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/* 1116 */     if (i != 0) {
/* 1117 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1120 */       return registryGetIntValue(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/* 1122 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1123 */       if (i != 0) {
/* 1124 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int registryGetIntValue(WinReg.HKEY paramHKEY, String paramString) {
/* 1139 */     IntByReference intByReference1 = new IntByReference();
/* 1140 */     IntByReference intByReference2 = new IntByReference();
/* 1141 */     int i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (char[])null, intByReference1);
/*      */     
/* 1143 */     if (i != 0 && i != 122)
/*      */     {
/* 1145 */       throw new Win32Exception(i);
/*      */     }
/* 1147 */     if (intByReference2.getValue() != 4) {
/* 1148 */       throw new RuntimeException("Unexpected registry type " + intByReference2
/* 1149 */           .getValue() + ", expected REG_DWORD");
/*      */     }
/* 1151 */     IntByReference intByReference3 = new IntByReference();
/* 1152 */     i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, intByReference3, intByReference1);
/*      */     
/* 1154 */     if (i != 0 && i != 122)
/*      */     {
/* 1156 */       throw new Win32Exception(i);
/*      */     }
/* 1158 */     return intByReference3.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long registryGetLongValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/* 1173 */     return registryGetLongValue(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long registryGetLongValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/* 1191 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1192 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/* 1194 */     if (i != 0) {
/* 1195 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1198 */       return registryGetLongValue(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/* 1200 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1201 */       if (i != 0) {
/* 1202 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long registryGetLongValue(WinReg.HKEY paramHKEY, String paramString) {
/* 1217 */     IntByReference intByReference1 = new IntByReference();
/* 1218 */     IntByReference intByReference2 = new IntByReference();
/* 1219 */     int i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, (char[])null, intByReference1);
/*      */     
/* 1221 */     if (i != 0 && i != 122)
/*      */     {
/* 1223 */       throw new Win32Exception(i);
/*      */     }
/* 1225 */     if (intByReference2.getValue() != 11) {
/* 1226 */       throw new RuntimeException("Unexpected registry type " + intByReference2
/* 1227 */           .getValue() + ", expected REG_QWORD");
/*      */     }
/* 1229 */     LongByReference longByReference = new LongByReference();
/* 1230 */     i = Advapi32.INSTANCE.RegQueryValueEx(paramHKEY, paramString, 0, intByReference2, longByReference, intByReference1);
/*      */     
/* 1232 */     if (i != 0 && i != 122)
/*      */     {
/* 1234 */       throw new Win32Exception(i);
/*      */     }
/* 1236 */     return longByReference.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object registryGetValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/*      */     String str;
/* 1253 */     Integer integer = null;
/* 1254 */     IntByReference intByReference1 = new IntByReference();
/* 1255 */     IntByReference intByReference2 = new IntByReference();
/*      */     
/* 1257 */     int i = Advapi32.INSTANCE.RegGetValue(paramHKEY, paramString1, paramString2, 65535, intByReference1, (Pointer)null, intByReference2);
/*      */ 
/*      */ 
/*      */     
/* 1261 */     if (intByReference1.getValue() == 0) {
/* 1262 */       return null;
/*      */     }
/* 1264 */     if (i != 0 && i != 122)
/*      */     {
/* 1266 */       throw new Win32Exception(i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1273 */     Memory memory = new Memory((intByReference2.getValue() + Native.WCHAR_SIZE));
/* 1274 */     memory.clear();
/*      */     
/* 1276 */     i = Advapi32.INSTANCE.RegGetValue(paramHKEY, paramString1, paramString2, 65535, intByReference1, (Pointer)memory, intByReference2);
/*      */ 
/*      */     
/* 1279 */     if (i != 0) {
/* 1280 */       throw new Win32Exception(i);
/*      */     }
/*      */     
/* 1283 */     if (intByReference1.getValue() == 4) {
/* 1284 */       integer = Integer.valueOf(memory.getInt(0L));
/* 1285 */     } else if (intByReference1.getValue() == 11) {
/* 1286 */       Long long_ = Long.valueOf(memory.getLong(0L));
/* 1287 */     } else if (intByReference1.getValue() == 3) {
/* 1288 */       byte[] arrayOfByte = memory.getByteArray(0L, intByReference2.getValue());
/* 1289 */     } else if (intByReference1.getValue() == 1 || intByReference1
/* 1290 */       .getValue() == 2) {
/* 1291 */       if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/* 1292 */         str = memory.getWideString(0L);
/*      */       } else {
/* 1294 */         str = memory.getString(0L);
/*      */       } 
/*      */     } 
/*      */     
/* 1298 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registryCreateKey(WinReg.HKEY paramHKEY, String paramString) {
/* 1311 */     return registryCreateKey(paramHKEY, paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registryCreateKey(WinReg.HKEY paramHKEY, String paramString, int paramInt) {
/* 1327 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1328 */     IntByReference intByReference = new IntByReference();
/* 1329 */     int i = Advapi32.INSTANCE.RegCreateKeyEx(paramHKEY, paramString, 0, null, 0, 0x20019 | paramInt, null, hKEYByReference, intByReference);
/*      */ 
/*      */     
/* 1332 */     if (i != 0) {
/* 1333 */       throw new Win32Exception(i);
/*      */     }
/* 1335 */     i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1336 */     if (i != 0) {
/* 1337 */       throw new Win32Exception(i);
/*      */     }
/* 1339 */     return (1 == intByReference.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registryCreateKey(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/* 1355 */     return registryCreateKey(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean registryCreateKey(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/* 1374 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1375 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x4 | paramInt, hKEYByReference);
/*      */     
/* 1377 */     if (i != 0) {
/* 1378 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1381 */       return registryCreateKey(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/* 1383 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1384 */       if (i != 0) {
/* 1385 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetIntValue(WinReg.HKEY paramHKEY, String paramString, int paramInt) {
/* 1401 */     byte[] arrayOfByte = new byte[4];
/* 1402 */     arrayOfByte[0] = (byte)(paramInt & 0xFF);
/* 1403 */     arrayOfByte[1] = (byte)(paramInt >> 8 & 0xFF);
/* 1404 */     arrayOfByte[2] = (byte)(paramInt >> 16 & 0xFF);
/* 1405 */     arrayOfByte[3] = (byte)(paramInt >> 24 & 0xFF);
/* 1406 */     int i = Advapi32.INSTANCE.RegSetValueEx(paramHKEY, paramString, 0, 4, arrayOfByte, 4);
/*      */     
/* 1408 */     if (i != 0) {
/* 1409 */       throw new Win32Exception(i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetIntValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/* 1427 */     registrySetIntValue(paramHKEY, paramString1, paramString2, paramInt, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetIntValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt1, int paramInt2) {
/* 1447 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1448 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x2001F | paramInt2, hKEYByReference);
/*      */     
/* 1450 */     if (i != 0) {
/* 1451 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1454 */       registrySetIntValue(hKEYByReference.getValue(), paramString2, paramInt1);
/*      */     } finally {
/* 1456 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1457 */       if (i != 0) {
/* 1458 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetLongValue(WinReg.HKEY paramHKEY, String paramString, long paramLong) {
/* 1474 */     byte[] arrayOfByte = new byte[8];
/* 1475 */     arrayOfByte[0] = (byte)(int)(paramLong & 0xFFL);
/* 1476 */     arrayOfByte[1] = (byte)(int)(paramLong >> 8L & 0xFFL);
/* 1477 */     arrayOfByte[2] = (byte)(int)(paramLong >> 16L & 0xFFL);
/* 1478 */     arrayOfByte[3] = (byte)(int)(paramLong >> 24L & 0xFFL);
/* 1479 */     arrayOfByte[4] = (byte)(int)(paramLong >> 32L & 0xFFL);
/* 1480 */     arrayOfByte[5] = (byte)(int)(paramLong >> 40L & 0xFFL);
/* 1481 */     arrayOfByte[6] = (byte)(int)(paramLong >> 48L & 0xFFL);
/* 1482 */     arrayOfByte[7] = (byte)(int)(paramLong >> 56L & 0xFFL);
/* 1483 */     int i = Advapi32.INSTANCE.RegSetValueEx(paramHKEY, paramString, 0, 11, arrayOfByte, 8);
/*      */     
/* 1485 */     if (i != 0) {
/* 1486 */       throw new Win32Exception(i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetLongValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, long paramLong) {
/* 1504 */     registrySetLongValue(paramHKEY, paramString1, paramString2, paramLong, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetLongValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, long paramLong, int paramInt) {
/* 1524 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1525 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x2001F | paramInt, hKEYByReference);
/*      */     
/* 1527 */     if (i != 0) {
/* 1528 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1531 */       registrySetLongValue(hKEYByReference.getValue(), paramString2, paramLong);
/*      */     } finally {
/* 1533 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1534 */       if (i != 0) {
/* 1535 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/*      */     Memory memory;
/* 1552 */     if (paramString2 == null) {
/* 1553 */       paramString2 = "";
/*      */     }
/*      */     
/* 1556 */     if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/* 1557 */       memory = new Memory(((paramString2.length() + 1) * Native.WCHAR_SIZE));
/* 1558 */       memory.setWideString(0L, paramString2);
/*      */     } else {
/* 1560 */       memory = new Memory((paramString2.length() + 1));
/* 1561 */       memory.setString(0L, paramString2);
/*      */     } 
/* 1563 */     int i = Advapi32.INSTANCE.RegSetValueEx(paramHKEY, paramString1, 0, 1, (Pointer)memory, 
/* 1564 */         (int)memory.size());
/* 1565 */     if (i != 0) {
/* 1566 */       throw new Win32Exception(i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, String paramString3) {
/* 1584 */     registrySetStringValue(paramHKEY, paramString1, paramString2, paramString3, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, String paramString3, int paramInt) {
/* 1604 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1605 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x2001F | paramInt, hKEYByReference);
/*      */     
/* 1607 */     if (i != 0) {
/* 1608 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1611 */       registrySetStringValue(hKEYByReference.getValue(), paramString2, paramString3);
/*      */     } finally {
/* 1613 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1614 */       if (i != 0) {
/* 1615 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetExpandableStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/*      */     Memory memory;
/* 1633 */     if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/* 1634 */       memory = new Memory(((paramString2.length() + 1) * Native.WCHAR_SIZE));
/* 1635 */       memory.setWideString(0L, paramString2);
/*      */     } else {
/* 1637 */       memory = new Memory((paramString2.length() + 1));
/* 1638 */       memory.setString(0L, paramString2);
/*      */     } 
/* 1640 */     int i = Advapi32.INSTANCE.RegSetValueEx(paramHKEY, paramString1, 0, 2, (Pointer)memory, 
/* 1641 */         (int)memory.size());
/* 1642 */     if (i != 0) {
/* 1643 */       throw new Win32Exception(i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetExpandableStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, String paramString3) {
/* 1661 */     registrySetExpandableStringValue(paramHKEY, paramString1, paramString2, paramString3, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetExpandableStringValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, String paramString3, int paramInt) {
/* 1681 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1682 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x2001F | paramInt, hKEYByReference);
/*      */     
/* 1684 */     if (i != 0) {
/* 1685 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1688 */       registrySetExpandableStringValue(hKEYByReference.getValue(), paramString2, paramString3);
/*      */     } finally {
/* 1690 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1691 */       if (i != 0) {
/* 1692 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetStringArray(WinReg.HKEY paramHKEY, String paramString, String[] paramArrayOfString) {
/* 1710 */     byte b = (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) ? Native.WCHAR_SIZE : 1;
/*      */     
/* 1712 */     int i = 0;
/* 1713 */     for (String str : paramArrayOfString) {
/* 1714 */       i += str.length() * b;
/* 1715 */       i += b;
/*      */     } 
/* 1717 */     i += b;
/*      */     
/* 1719 */     int j = 0;
/* 1720 */     Memory memory = new Memory(i);
/* 1721 */     memory.clear();
/* 1722 */     for (String str : paramArrayOfString) {
/* 1723 */       if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/* 1724 */         memory.setWideString(j, str);
/*      */       } else {
/* 1726 */         memory.setString(j, str);
/*      */       } 
/* 1728 */       j += str.length() * b;
/* 1729 */       j += b;
/*      */     } 
/*      */     
/* 1732 */     int k = Advapi32.INSTANCE.RegSetValueEx(paramHKEY, paramString, 0, 7, (Pointer)memory, i);
/*      */ 
/*      */     
/* 1735 */     if (k != 0) {
/* 1736 */       throw new Win32Exception(k);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetStringArray(WinReg.HKEY paramHKEY, String paramString1, String paramString2, String[] paramArrayOfString) {
/* 1754 */     registrySetStringArray(paramHKEY, paramString1, paramString2, paramArrayOfString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetStringArray(WinReg.HKEY paramHKEY, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt) {
/* 1774 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1775 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x2001F | paramInt, hKEYByReference);
/*      */     
/* 1777 */     if (i != 0) {
/* 1778 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1781 */       registrySetStringArray(hKEYByReference.getValue(), paramString2, paramArrayOfString);
/*      */     } finally {
/* 1783 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1784 */       if (i != 0) {
/* 1785 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetBinaryValue(WinReg.HKEY paramHKEY, String paramString, byte[] paramArrayOfbyte) {
/* 1802 */     int i = Advapi32.INSTANCE.RegSetValueEx(paramHKEY, paramString, 0, 3, paramArrayOfbyte, paramArrayOfbyte.length);
/*      */     
/* 1804 */     if (i != 0) {
/* 1805 */       throw new Win32Exception(i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetBinaryValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, byte[] paramArrayOfbyte) {
/* 1823 */     registrySetBinaryValue(paramHKEY, paramString1, paramString2, paramArrayOfbyte, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registrySetBinaryValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, byte[] paramArrayOfbyte, int paramInt) {
/* 1843 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1844 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x2001F | paramInt, hKEYByReference);
/*      */     
/* 1846 */     if (i != 0) {
/* 1847 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1850 */       registrySetBinaryValue(hKEYByReference.getValue(), paramString2, paramArrayOfbyte);
/*      */     } finally {
/* 1852 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1853 */       if (i != 0) {
/* 1854 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registryDeleteKey(WinReg.HKEY paramHKEY, String paramString) {
/* 1868 */     int i = Advapi32.INSTANCE.RegDeleteKey(paramHKEY, paramString);
/* 1869 */     if (i != 0) {
/* 1870 */       throw new Win32Exception(i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registryDeleteKey(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/* 1886 */     registryDeleteKey(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registryDeleteKey(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/* 1904 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1905 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x2001F | paramInt, hKEYByReference);
/*      */     
/* 1907 */     if (i != 0) {
/* 1908 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1911 */       registryDeleteKey(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/* 1913 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1914 */       if (i != 0) {
/* 1915 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registryDeleteValue(WinReg.HKEY paramHKEY, String paramString) {
/* 1929 */     int i = Advapi32.INSTANCE.RegDeleteValue(paramHKEY, paramString);
/* 1930 */     if (i != 0) {
/* 1931 */       throw new Win32Exception(i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registryDeleteValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2) {
/* 1947 */     registryDeleteValue(paramHKEY, paramString1, paramString2, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registryDeleteValue(WinReg.HKEY paramHKEY, String paramString1, String paramString2, int paramInt) {
/* 1965 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 1966 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString1, 0, 0x2001F | paramInt, hKEYByReference);
/*      */     
/* 1968 */     if (i != 0) {
/* 1969 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 1972 */       registryDeleteValue(hKEYByReference.getValue(), paramString2);
/*      */     } finally {
/* 1974 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 1975 */       if (i != 0) {
/* 1976 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] registryGetKeys(WinReg.HKEY paramHKEY) {
/* 1989 */     IntByReference intByReference1 = new IntByReference();
/* 1990 */     IntByReference intByReference2 = new IntByReference();
/*      */     
/* 1992 */     int i = Advapi32.INSTANCE.RegQueryInfoKey(paramHKEY, null, null, null, intByReference1, intByReference2, null, null, null, null, null, null);
/*      */     
/* 1994 */     if (i != 0) {
/* 1995 */       throw new Win32Exception(i);
/*      */     }
/* 1997 */     ArrayList<String> arrayList = new ArrayList(intByReference1.getValue());
/* 1998 */     char[] arrayOfChar = new char[intByReference2.getValue() + 1];
/* 1999 */     for (byte b = 0; b < intByReference1.getValue(); b++) {
/*      */       
/* 2001 */       IntByReference intByReference = new IntByReference(intByReference2.getValue() + 1);
/* 2002 */       i = Advapi32.INSTANCE.RegEnumKeyEx(paramHKEY, b, arrayOfChar, intByReference, null, null, null, null);
/*      */       
/* 2004 */       if (i != 0) {
/* 2005 */         throw new Win32Exception(i);
/*      */       }
/* 2007 */       arrayList.add(Native.toString(arrayOfChar));
/*      */     } 
/* 2009 */     return arrayList.<String>toArray(new String[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] registryGetKeys(WinReg.HKEY paramHKEY, String paramString) {
/* 2022 */     return registryGetKeys(paramHKEY, paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] registryGetKeys(WinReg.HKEY paramHKEY, String paramString, int paramInt) {
/* 2038 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 2039 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/* 2041 */     if (i != 0) {
/* 2042 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 2045 */       return registryGetKeys(hKEYByReference.getValue());
/*      */     } finally {
/* 2047 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 2048 */       if (i != 0) {
/* 2049 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WinReg.HKEYByReference registryGetKey(WinReg.HKEY paramHKEY, String paramString, int paramInt) {
/* 2069 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 2070 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString, 0, paramInt, hKEYByReference);
/*      */     
/* 2072 */     if (i != 0) {
/* 2073 */       throw new Win32Exception(i);
/*      */     }
/*      */     
/* 2076 */     return hKEYByReference;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void registryCloseKey(WinReg.HKEY paramHKEY) {
/* 2086 */     int i = Advapi32.INSTANCE.RegCloseKey(paramHKEY);
/* 2087 */     if (i != 0) {
/* 2088 */       throw new Win32Exception(i);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static TreeMap<String, Object> registryGetValues(WinReg.HKEY paramHKEY) {
/* 2100 */     IntByReference intByReference1 = new IntByReference();
/* 2101 */     IntByReference intByReference2 = new IntByReference();
/* 2102 */     IntByReference intByReference3 = new IntByReference();
/* 2103 */     int i = Advapi32.INSTANCE.RegQueryInfoKey(paramHKEY, null, null, null, null, null, null, intByReference1, intByReference2, intByReference3, null, null);
/*      */ 
/*      */     
/* 2106 */     if (i != 0) {
/* 2107 */       throw new Win32Exception(i);
/*      */     }
/* 2109 */     TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
/* 2110 */     char[] arrayOfChar = new char[intByReference2.getValue() + 1];
/*      */ 
/*      */ 
/*      */     
/* 2114 */     Memory memory = new Memory((intByReference3.getValue() + 2 * Native.WCHAR_SIZE));
/* 2115 */     for (byte b = 0; b < intByReference1.getValue(); b++) {
/* 2116 */       memory.clear();
/*      */       
/* 2118 */       IntByReference intByReference4 = new IntByReference(intByReference2.getValue() + 1);
/*      */       
/* 2120 */       IntByReference intByReference5 = new IntByReference(intByReference3.getValue());
/* 2121 */       IntByReference intByReference6 = new IntByReference();
/* 2122 */       i = Advapi32.INSTANCE.RegEnumValue(paramHKEY, b, arrayOfChar, intByReference4, (IntByReference)null, intByReference6, (Pointer)memory, intByReference5);
/*      */       
/* 2124 */       if (i != 0) {
/* 2125 */         throw new Win32Exception(i);
/*      */       }
/*      */       
/* 2128 */       String str = Native.toString(arrayOfChar);
/*      */       
/* 2130 */       if (intByReference5.getValue() == 0) {
/* 2131 */         switch (intByReference6.getValue()) {
/*      */           case 3:
/* 2133 */             treeMap.put(str, new byte[0]);
/*      */             break;
/*      */           
/*      */           case 1:
/*      */           case 2:
/* 2138 */             treeMap.put(str, new char[0]);
/*      */             break;
/*      */           
/*      */           case 7:
/* 2142 */             treeMap.put(str, new String[0]);
/*      */             break;
/*      */           
/*      */           case 0:
/* 2146 */             treeMap.put(str, null);
/*      */             break;
/*      */           
/*      */           default:
/* 2150 */             throw new RuntimeException("Unsupported empty type: " + intByReference6
/* 2151 */                 .getValue());
/*      */         } 
/*      */       } else {
/*      */         ArrayList<String> arrayList;
/*      */         int j;
/* 2156 */         switch (intByReference6.getValue()) {
/*      */           case 11:
/* 2158 */             treeMap.put(str, Long.valueOf(memory.getLong(0L)));
/*      */             break;
/*      */           
/*      */           case 4:
/* 2162 */             treeMap.put(str, Integer.valueOf(memory.getInt(0L)));
/*      */             break;
/*      */           
/*      */           case 1:
/*      */           case 2:
/* 2167 */             if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/* 2168 */               treeMap.put(str, memory.getWideString(0L)); break;
/*      */             } 
/* 2170 */             treeMap.put(str, memory.getString(0L));
/*      */             break;
/*      */ 
/*      */           
/*      */           case 3:
/* 2175 */             treeMap.put(str, memory
/* 2176 */                 .getByteArray(0L, intByReference5.getValue()));
/*      */             break;
/*      */           
/*      */           case 7:
/* 2180 */             arrayList = new ArrayList();
/* 2181 */             j = 0;
/* 2182 */             while (j < memory.size()) {
/*      */               String str1;
/* 2184 */               if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/* 2185 */                 str1 = memory.getWideString(j);
/* 2186 */                 j += str1.length() * Native.WCHAR_SIZE;
/* 2187 */                 j += Native.WCHAR_SIZE;
/*      */               } else {
/* 2189 */                 str1 = memory.getString(j);
/* 2190 */                 j += str1.length();
/* 2191 */                 j++;
/*      */               } 
/*      */               
/* 2194 */               if (str1.length() == 0) {
/*      */                 break;
/*      */               }
/*      */ 
/*      */ 
/*      */               
/* 2200 */               arrayList.add(str1);
/*      */             } 
/*      */             
/* 2203 */             treeMap.put(str, arrayList.toArray(new String[0]));
/*      */             break;
/*      */           
/*      */           default:
/* 2207 */             throw new RuntimeException("Unsupported type: " + intByReference6
/* 2208 */                 .getValue());
/*      */         } 
/*      */       } 
/* 2211 */     }  return (TreeMap)treeMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static TreeMap<String, Object> registryGetValues(WinReg.HKEY paramHKEY, String paramString) {
/* 2225 */     return registryGetValues(paramHKEY, paramString, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static TreeMap<String, Object> registryGetValues(WinReg.HKEY paramHKEY, String paramString, int paramInt) {
/* 2242 */     WinReg.HKEYByReference hKEYByReference = new WinReg.HKEYByReference();
/* 2243 */     int i = Advapi32.INSTANCE.RegOpenKeyEx(paramHKEY, paramString, 0, 0x20019 | paramInt, hKEYByReference);
/*      */     
/* 2245 */     if (i != 0) {
/* 2246 */       throw new Win32Exception(i);
/*      */     }
/*      */     try {
/* 2249 */       return registryGetValues(hKEYByReference.getValue());
/*      */     } finally {
/* 2251 */       i = Advapi32.INSTANCE.RegCloseKey(hKEYByReference.getValue());
/* 2252 */       if (i != 0) {
/* 2253 */         throw new Win32Exception(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static InfoKey registryQueryInfoKey(WinReg.HKEY paramHKEY, int paramInt) {
/* 2270 */     InfoKey infoKey = new InfoKey(paramHKEY, paramInt);
/* 2271 */     int i = Advapi32.INSTANCE.RegQueryInfoKey(paramHKEY, infoKey.lpClass, infoKey.lpcClass, null, infoKey.lpcSubKeys, infoKey.lpcMaxSubKeyLen, infoKey.lpcMaxClassLen, infoKey.lpcValues, infoKey.lpcMaxValueNameLen, infoKey.lpcMaxValueLen, infoKey.lpcbSecurityDescriptor, infoKey.lpftLastWriteTime);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2278 */     if (i != 0) {
/* 2279 */       throw new Win32Exception(i);
/*      */     }
/*      */     
/* 2282 */     return infoKey;
/*      */   }
/*      */   
/*      */   public static class InfoKey {
/*      */     public WinReg.HKEY hKey;
/* 2287 */     public char[] lpClass = new char[260];
/* 2288 */     public IntByReference lpcClass = new IntByReference(260);
/* 2289 */     public IntByReference lpcSubKeys = new IntByReference();
/* 2290 */     public IntByReference lpcMaxSubKeyLen = new IntByReference();
/* 2291 */     public IntByReference lpcMaxClassLen = new IntByReference();
/* 2292 */     public IntByReference lpcValues = new IntByReference();
/* 2293 */     public IntByReference lpcMaxValueNameLen = new IntByReference();
/* 2294 */     public IntByReference lpcMaxValueLen = new IntByReference();
/* 2295 */     public IntByReference lpcbSecurityDescriptor = new IntByReference();
/* 2296 */     public WinBase.FILETIME lpftLastWriteTime = new WinBase.FILETIME();
/*      */ 
/*      */     
/*      */     public InfoKey() {}
/*      */     
/*      */     public InfoKey(WinReg.HKEY param1HKEY, int param1Int) {
/* 2302 */       this.hKey = param1HKEY;
/* 2303 */       this.lpcbSecurityDescriptor = new IntByReference(param1Int);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static EnumKey registryRegEnumKey(WinReg.HKEY paramHKEY, int paramInt) {
/* 2317 */     EnumKey enumKey = new EnumKey(paramHKEY, paramInt);
/* 2318 */     int i = Advapi32.INSTANCE.RegEnumKeyEx(paramHKEY, enumKey.dwIndex, enumKey.lpName, enumKey.lpcName, null, enumKey.lpClass, enumKey.lpcbClass, enumKey.lpftLastWriteTime);
/*      */ 
/*      */ 
/*      */     
/* 2322 */     if (i != 0) {
/* 2323 */       throw new Win32Exception(i);
/*      */     }
/*      */     
/* 2326 */     return enumKey;
/*      */   }
/*      */   
/*      */   public static class EnumKey {
/*      */     public WinReg.HKEY hKey;
/* 2331 */     public int dwIndex = 0;
/* 2332 */     public char[] lpName = new char[255];
/* 2333 */     public IntByReference lpcName = new IntByReference(255);
/*      */     
/* 2335 */     public char[] lpClass = new char[255];
/* 2336 */     public IntByReference lpcbClass = new IntByReference(255);
/*      */     
/* 2338 */     public WinBase.FILETIME lpftLastWriteTime = new WinBase.FILETIME();
/*      */ 
/*      */     
/*      */     public EnumKey() {}
/*      */     
/*      */     public EnumKey(WinReg.HKEY param1HKEY, int param1Int) {
/* 2344 */       this.hKey = param1HKEY;
/* 2345 */       this.dwIndex = param1Int;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getEnvironmentBlock(Map<String, String> paramMap) {
/* 2360 */     StringBuilder stringBuilder = new StringBuilder(paramMap.size() * 32);
/* 2361 */     for (Map.Entry<String, String> entry : paramMap.entrySet()) {
/* 2362 */       String str1 = (String)entry.getKey(), str2 = (String)entry.getValue();
/* 2363 */       if (str2 != null) {
/* 2364 */         stringBuilder.append(str1).append("=").append(str2).append(false);
/*      */       }
/*      */     } 
/* 2367 */     return stringBuilder.append(false).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public enum EventLogType
/*      */   {
/* 2374 */     Error, Warning, Informational, AuditSuccess, AuditFailure;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class EventLogRecord
/*      */   {
/*      */     private WinNT.EVENTLOGRECORD _record;
/*      */ 
/*      */     
/*      */     private String _source;
/*      */     
/*      */     private byte[] _data;
/*      */     
/*      */     private String[] _strings;
/*      */ 
/*      */     
/*      */     public WinNT.EVENTLOGRECORD getRecord() {
/* 2392 */       return this._record;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getInstanceId() {
/* 2403 */       return this._record.EventID.intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @Deprecated
/*      */     public int getEventId() {
/* 2414 */       return this._record.EventID.intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getSource() {
/* 2423 */       return this._source;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getStatusCode() {
/* 2434 */       return this._record.EventID.intValue() & 0xFFFF;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getRecordNumber() {
/* 2445 */       return this._record.RecordNumber.intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLength() {
/* 2454 */       return this._record.Length.intValue();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String[] getStrings() {
/* 2463 */       return this._strings;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Advapi32Util.EventLogType getType() {
/* 2472 */       switch (this._record.EventType.intValue()) {
/*      */         case 0:
/*      */         case 4:
/* 2475 */           return Advapi32Util.EventLogType.Informational;
/*      */         case 16:
/* 2477 */           return Advapi32Util.EventLogType.AuditFailure;
/*      */         case 8:
/* 2479 */           return Advapi32Util.EventLogType.AuditSuccess;
/*      */         case 1:
/* 2481 */           return Advapi32Util.EventLogType.Error;
/*      */         case 2:
/* 2483 */           return Advapi32Util.EventLogType.Warning;
/*      */       } 
/* 2485 */       throw new RuntimeException("Invalid type: " + this._record.EventType
/* 2486 */           .intValue());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public byte[] getData() {
/* 2496 */       return this._data;
/*      */     }
/*      */     
/*      */     public EventLogRecord(Pointer param1Pointer) {
/* 2500 */       this._record = new WinNT.EVENTLOGRECORD(param1Pointer);
/* 2501 */       this._source = param1Pointer.getWideString(this._record.size());
/*      */       
/* 2503 */       if (this._record.DataLength.intValue() > 0) {
/* 2504 */         this._data = param1Pointer.getByteArray(this._record.DataOffset.intValue(), this._record.DataLength
/* 2505 */             .intValue());
/*      */       }
/*      */       
/* 2508 */       if (this._record.NumStrings.intValue() > 0) {
/* 2509 */         ArrayList<String> arrayList = new ArrayList();
/* 2510 */         int i = this._record.NumStrings.intValue();
/* 2511 */         long l = this._record.StringOffset.intValue();
/* 2512 */         while (i > 0) {
/* 2513 */           String str = param1Pointer.getWideString(l);
/* 2514 */           arrayList.add(str);
/* 2515 */           l += (str.length() * Native.WCHAR_SIZE);
/* 2516 */           l += Native.WCHAR_SIZE;
/* 2517 */           i--;
/*      */         } 
/* 2519 */         this._strings = arrayList.<String>toArray(new String[0]);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class EventLogIterator
/*      */     implements Iterable<EventLogRecord>, Iterator<EventLogRecord>
/*      */   {
/*      */     private WinNT.HANDLE _h;
/*      */     
/* 2531 */     private Memory _buffer = new Memory(65536L);
/*      */     
/*      */     private boolean _done = false;
/* 2534 */     private int _dwRead = 0;
/*      */     
/* 2536 */     private Pointer _pevlr = null;
/*      */     private int _flags;
/*      */     
/*      */     public EventLogIterator(String param1String) {
/* 2540 */       this(null, param1String, 4);
/*      */     }
/*      */     
/*      */     public EventLogIterator(String param1String1, String param1String2, int param1Int) {
/* 2544 */       this._flags = param1Int;
/* 2545 */       this._h = Advapi32.INSTANCE.OpenEventLog(param1String1, param1String2);
/* 2546 */       if (this._h == null) {
/* 2547 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean read() {
/* 2553 */       if (this._done || this._dwRead > 0) {
/* 2554 */         return false;
/*      */       }
/*      */       
/* 2557 */       IntByReference intByReference1 = new IntByReference();
/* 2558 */       IntByReference intByReference2 = new IntByReference();
/*      */ 
/*      */       
/* 2561 */       if (!Advapi32.INSTANCE.ReadEventLog(this._h, 0x1 | this._flags, 0, (Pointer)this._buffer, 
/* 2562 */           (int)this._buffer.size(), intByReference1, intByReference2)) {
/*      */ 
/*      */         
/* 2565 */         int i = Kernel32.INSTANCE.GetLastError();
/*      */ 
/*      */         
/* 2568 */         if (i == 122) {
/* 2569 */           this._buffer = new Memory(intByReference2.getValue());
/*      */           
/* 2571 */           if (!Advapi32.INSTANCE.ReadEventLog(this._h, 0x1 | this._flags, 0, (Pointer)this._buffer, 
/*      */               
/* 2573 */               (int)this._buffer.size(), intByReference1, intByReference2))
/*      */           {
/* 2575 */             throw new Win32Exception(Kernel32.INSTANCE
/* 2576 */                 .GetLastError());
/*      */           }
/*      */         } else {
/*      */           
/* 2580 */           close();
/* 2581 */           if (i != 38) {
/* 2582 */             throw new Win32Exception(i);
/*      */           }
/* 2584 */           return false;
/*      */         } 
/*      */       } 
/*      */       
/* 2588 */       this._dwRead = intByReference1.getValue();
/* 2589 */       this._pevlr = (Pointer)this._buffer;
/* 2590 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/* 2598 */       this._done = true;
/* 2599 */       if (this._h != null) {
/* 2600 */         if (!Advapi32.INSTANCE.CloseEventLog(this._h)) {
/* 2601 */           throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */         }
/* 2603 */         this._h = null;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Iterator<Advapi32Util.EventLogRecord> iterator() {
/* 2611 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/* 2618 */       read();
/* 2619 */       return !this._done;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Advapi32Util.EventLogRecord next() {
/* 2626 */       read();
/* 2627 */       Advapi32Util.EventLogRecord eventLogRecord = new Advapi32Util.EventLogRecord(this._pevlr);
/* 2628 */       this._dwRead -= eventLogRecord.getLength();
/* 2629 */       this._pevlr = this._pevlr.share(eventLogRecord.getLength());
/* 2630 */       return eventLogRecord;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void remove() {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WinNT.ACE_HEADER[] getFileSecurity(String paramString, boolean paramBoolean) {
/*      */     boolean bool;
/*      */     Memory memory;
/* 2647 */     byte b = 4;
/* 2648 */     int i = 1024;
/*      */ 
/*      */ 
/*      */     
/*      */     do {
/* 2653 */       bool = false;
/* 2654 */       memory = new Memory(i);
/* 2655 */       IntByReference intByReference = new IntByReference();
/* 2656 */       boolean bool1 = Advapi32.INSTANCE.GetFileSecurity(paramString, b, (Pointer)memory, i, intByReference);
/*      */ 
/*      */       
/* 2659 */       if (!bool1) {
/* 2660 */         int k = Kernel32.INSTANCE.GetLastError();
/* 2661 */         memory.clear();
/* 2662 */         if (122 != k) {
/* 2663 */           throw new Win32Exception(k);
/*      */         }
/*      */       } 
/* 2666 */       int j = intByReference.getValue();
/* 2667 */       if (i >= j)
/* 2668 */         continue;  bool = true;
/* 2669 */       i = j;
/* 2670 */       memory.clear();
/*      */     }
/* 2672 */     while (bool);
/*      */     
/* 2674 */     WinNT.SECURITY_DESCRIPTOR_RELATIVE sECURITY_DESCRIPTOR_RELATIVE = new WinNT.SECURITY_DESCRIPTOR_RELATIVE((Pointer)memory);
/*      */     
/* 2676 */     WinNT.ACL aCL = sECURITY_DESCRIPTOR_RELATIVE.getDiscretionaryACL();
/* 2677 */     WinNT.ACE_HEADER[] arrayOfACE_HEADER = aCL.getACEs();
/*      */     
/* 2679 */     if (paramBoolean) {
/* 2680 */       ArrayList<WinNT.ACCESS_ACEStructure> arrayList = new ArrayList();
/* 2681 */       HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 2682 */       for (WinNT.ACE_HEADER aCE_HEADER : arrayOfACE_HEADER) {
/* 2683 */         if (aCE_HEADER instanceof WinNT.ACCESS_ACEStructure) {
/* 2684 */           WinNT.ACCESS_ACEStructure aCCESS_ACEStructure1 = (WinNT.ACCESS_ACEStructure)aCE_HEADER;
/* 2685 */           boolean bool1 = ((aCE_HEADER.AceFlags & 0x1F) != 0) ? true : false;
/*      */           
/* 2687 */           String str = aCCESS_ACEStructure1.getSidString() + "/" + bool1 + "/" + aCE_HEADER.getClass().getName();
/* 2688 */           WinNT.ACCESS_ACEStructure aCCESS_ACEStructure2 = (WinNT.ACCESS_ACEStructure)hashMap.get(str);
/* 2689 */           if (aCCESS_ACEStructure2 != null) {
/* 2690 */             int j = aCCESS_ACEStructure2.Mask;
/* 2691 */             j |= aCCESS_ACEStructure1.Mask;
/* 2692 */             aCCESS_ACEStructure2.Mask = j;
/*      */           } else {
/* 2694 */             hashMap.put(str, aCCESS_ACEStructure1);
/* 2695 */             arrayList.add(aCCESS_ACEStructure2);
/*      */           } 
/*      */         } else {
/* 2698 */           arrayList.add(aCE_HEADER);
/*      */         } 
/*      */       } 
/* 2701 */       return arrayList.<WinNT.ACE_HEADER>toArray(new WinNT.ACE_HEADER[0]);
/*      */     } 
/*      */     
/* 2704 */     return arrayOfACE_HEADER;
/*      */   }
/*      */   
/*      */   public enum AccessCheckPermission {
/* 2708 */     READ(-2147483648),
/* 2709 */     WRITE(1073741824),
/* 2710 */     EXECUTE(536870912);
/*      */     
/*      */     final int code;
/*      */     
/*      */     AccessCheckPermission(int param1Int1) {
/* 2715 */       this.code = param1Int1;
/*      */     }
/*      */     
/*      */     public int getCode() {
/* 2719 */       return this.code;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static Memory getSecurityDescriptorForFile(String paramString) {
/* 2725 */     byte b = 7;
/*      */ 
/*      */     
/* 2728 */     IntByReference intByReference = new IntByReference();
/* 2729 */     boolean bool = Advapi32.INSTANCE.GetFileSecurity(paramString, 7, null, 0, intByReference);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2735 */     if (!bool) {
/* 2736 */       int j = Kernel32.INSTANCE.GetLastError();
/* 2737 */       if (122 != j) {
/* 2738 */         throw new Win32Exception(j);
/*      */       }
/*      */     } 
/*      */     
/* 2742 */     int i = intByReference.getValue();
/* 2743 */     Memory memory = new Memory(i);
/* 2744 */     bool = Advapi32.INSTANCE.GetFileSecurity(paramString, 7, (Pointer)memory, i, intByReference);
/*      */ 
/*      */     
/* 2747 */     if (!bool) {
/* 2748 */       memory.clear();
/* 2749 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     } 
/*      */     
/* 2752 */     return memory;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Memory getSecurityDescriptorForObject(String paramString, int paramInt, boolean paramBoolean) {
/* 2770 */     int i = 0x7 | (paramBoolean ? 8 : 0);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2775 */     PointerByReference pointerByReference = new PointerByReference();
/*      */     
/* 2777 */     int j = Advapi32.INSTANCE.GetNamedSecurityInfo(paramString, paramInt, i, null, null, null, null, pointerByReference);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2787 */     if (j != 0) {
/* 2788 */       throw new Win32Exception(j);
/*      */     }
/*      */     
/* 2791 */     int k = Advapi32.INSTANCE.GetSecurityDescriptorLength(pointerByReference.getValue());
/* 2792 */     Memory memory = new Memory(k);
/* 2793 */     Pointer pointer = pointerByReference.getValue();
/*      */     try {
/* 2795 */       byte[] arrayOfByte = pointer.getByteArray(0L, k);
/* 2796 */       memory.write(0L, arrayOfByte, 0, k);
/* 2797 */       return memory;
/*      */     } finally {
/* 2799 */       Kernel32Util.freeLocalMemory(pointer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setSecurityDescriptorForObject(String paramString, int paramInt, WinNT.SECURITY_DESCRIPTOR_RELATIVE paramSECURITY_DESCRIPTOR_RELATIVE, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 2843 */     WinNT.PSID pSID1 = paramSECURITY_DESCRIPTOR_RELATIVE.getOwner();
/* 2844 */     WinNT.PSID pSID2 = paramSECURITY_DESCRIPTOR_RELATIVE.getGroup();
/* 2845 */     WinNT.ACL aCL1 = paramSECURITY_DESCRIPTOR_RELATIVE.getDiscretionaryACL();
/* 2846 */     WinNT.ACL aCL2 = paramSECURITY_DESCRIPTOR_RELATIVE.getSystemACL();
/*      */     
/* 2848 */     int i = 0;
/*      */     
/* 2850 */     if (paramBoolean1) {
/* 2851 */       if (pSID1 == null)
/* 2852 */         throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain owner"); 
/* 2853 */       if (!Advapi32.INSTANCE.IsValidSid(pSID1))
/* 2854 */         throw new IllegalArgumentException("Owner PSID is invalid"); 
/* 2855 */       i |= 0x1;
/*      */     } 
/*      */     
/* 2858 */     if (paramBoolean2) {
/* 2859 */       if (pSID2 == null)
/* 2860 */         throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain group"); 
/* 2861 */       if (!Advapi32.INSTANCE.IsValidSid(pSID2))
/* 2862 */         throw new IllegalArgumentException("Group PSID is invalid"); 
/* 2863 */       i |= 0x2;
/*      */     } 
/*      */     
/* 2866 */     if (paramBoolean3) {
/* 2867 */       if (aCL1 == null)
/* 2868 */         throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain DACL"); 
/* 2869 */       if (!Advapi32.INSTANCE.IsValidAcl(aCL1.getPointer()))
/* 2870 */         throw new IllegalArgumentException("DACL is invalid"); 
/* 2871 */       i |= 0x4;
/*      */     } 
/*      */     
/* 2874 */     if (paramBoolean4) {
/* 2875 */       if (aCL2 == null)
/* 2876 */         throw new IllegalArgumentException("SECURITY_DESCRIPTOR_RELATIVE does not contain SACL"); 
/* 2877 */       if (!Advapi32.INSTANCE.IsValidAcl(aCL2.getPointer()))
/* 2878 */         throw new IllegalArgumentException("SACL is invalid"); 
/* 2879 */       i |= 0x8;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2887 */     if (paramBoolean5) {
/* 2888 */       if ((paramSECURITY_DESCRIPTOR_RELATIVE.Control & 0x1000) != 0) {
/* 2889 */         i |= Integer.MIN_VALUE;
/*      */       }
/* 2891 */       else if ((paramSECURITY_DESCRIPTOR_RELATIVE.Control & 0x1000) == 0) {
/* 2892 */         i |= 0x20000000;
/*      */       } 
/*      */     }
/*      */     
/* 2896 */     if (paramBoolean6) {
/* 2897 */       if ((paramSECURITY_DESCRIPTOR_RELATIVE.Control & 0x2000) != 0) {
/* 2898 */         i |= 0x40000000;
/* 2899 */       } else if ((paramSECURITY_DESCRIPTOR_RELATIVE.Control & 0x2000) == 0) {
/* 2900 */         i |= 0x10000000;
/*      */       } 
/*      */     }
/*      */     
/* 2904 */     int j = Advapi32.INSTANCE.SetNamedSecurityInfo(paramString, paramInt, i, paramBoolean1 ? pSID1
/*      */ 
/*      */ 
/*      */         
/* 2908 */         .getPointer() : null, paramBoolean2 ? pSID2
/* 2909 */         .getPointer() : null, paramBoolean3 ? aCL1
/* 2910 */         .getPointer() : null, paramBoolean4 ? aCL2
/* 2911 */         .getPointer() : null);
/*      */     
/* 2913 */     if (j != 0) {
/* 2914 */       throw new Win32Exception(j);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean accessCheck(File paramFile, AccessCheckPermission paramAccessCheckPermission) {
/* 2925 */     Memory memory = getSecurityDescriptorForFile(paramFile.getAbsolutePath().replace('/', '\\'));
/*      */     
/* 2927 */     WinNT.HANDLEByReference hANDLEByReference1 = new WinNT.HANDLEByReference();
/* 2928 */     WinNT.HANDLEByReference hANDLEByReference2 = new WinNT.HANDLEByReference();
/* 2929 */     Win32Exception win32Exception = null;
/*      */     try {
/* 2931 */       int i = 131086;
/* 2932 */       WinNT.HANDLE hANDLE = Kernel32.INSTANCE.GetCurrentProcess();
/* 2933 */       if (!Advapi32.INSTANCE.OpenProcessToken(hANDLE, i, hANDLEByReference1)) {
/* 2934 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */       
/* 2937 */       if (!Advapi32.INSTANCE.DuplicateToken(hANDLEByReference1.getValue(), 2, hANDLEByReference2)) {
/* 2938 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */       
/* 2941 */       WinNT.GENERIC_MAPPING gENERIC_MAPPING = new WinNT.GENERIC_MAPPING();
/* 2942 */       gENERIC_MAPPING.genericRead = new WinDef.DWORD(1179785L);
/* 2943 */       gENERIC_MAPPING.genericWrite = new WinDef.DWORD(1179926L);
/* 2944 */       gENERIC_MAPPING.genericExecute = new WinDef.DWORD(1179808L);
/* 2945 */       gENERIC_MAPPING.genericAll = new WinDef.DWORD(2032127L);
/*      */       
/* 2947 */       WinDef.DWORDByReference dWORDByReference1 = new WinDef.DWORDByReference(new WinDef.DWORD(paramAccessCheckPermission.getCode()));
/* 2948 */       Advapi32.INSTANCE.MapGenericMask(dWORDByReference1, gENERIC_MAPPING);
/*      */       
/* 2950 */       WinNT.PRIVILEGE_SET pRIVILEGE_SET = new WinNT.PRIVILEGE_SET(1);
/* 2951 */       pRIVILEGE_SET.PrivilegeCount = new WinDef.DWORD(0L);
/* 2952 */       WinDef.DWORDByReference dWORDByReference2 = new WinDef.DWORDByReference(new WinDef.DWORD(pRIVILEGE_SET.size()));
/*      */       
/* 2954 */       WinDef.DWORDByReference dWORDByReference3 = new WinDef.DWORDByReference();
/* 2955 */       WinDef.BOOLByReference bOOLByReference = new WinDef.BOOLByReference();
/* 2956 */       if (!Advapi32.INSTANCE.AccessCheck((Pointer)memory, hANDLEByReference2
/* 2957 */           .getValue(), dWORDByReference1
/* 2958 */           .getValue(), gENERIC_MAPPING, pRIVILEGE_SET, dWORDByReference2, dWORDByReference3, bOOLByReference))
/*      */       {
/*      */         
/* 2961 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */       
/* 2964 */       return bOOLByReference.getValue().booleanValue();
/* 2965 */     } catch (Win32Exception win32Exception1) {
/* 2966 */       win32Exception = win32Exception1;
/* 2967 */       throw win32Exception;
/*      */     } finally {
/*      */       try {
/* 2970 */         Kernel32Util.closeHandleRefs(new WinNT.HANDLEByReference[] { hANDLEByReference1, hANDLEByReference2 });
/* 2971 */       } catch (Win32Exception win32Exception1) {
/* 2972 */         if (win32Exception == null) {
/* 2973 */           win32Exception = win32Exception1;
/*      */         } else {
/* 2975 */           win32Exception.addSuppressedReflected((Throwable)win32Exception1);
/*      */         } 
/*      */       } 
/*      */       
/* 2979 */       if (memory != null) {
/* 2980 */         memory.clear();
/*      */       }
/*      */       
/* 2983 */       if (win32Exception != null) {
/* 2984 */         throw win32Exception;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WinNT.SECURITY_DESCRIPTOR_RELATIVE getFileSecurityDescriptor(File paramFile, boolean paramBoolean) {
/* 3001 */     Memory memory = getSecurityDescriptorForObject(paramFile.getAbsolutePath().replaceAll("/", "\\"), 1, paramBoolean);
/* 3002 */     return new WinNT.SECURITY_DESCRIPTOR_RELATIVE((Pointer)memory);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setFileSecurityDescriptor(File paramFile, WinNT.SECURITY_DESCRIPTOR_RELATIVE paramSECURITY_DESCRIPTOR_RELATIVE, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
/* 3035 */     setSecurityDescriptorForObject(paramFile.getAbsolutePath().replaceAll("/", "\\"), 1, paramSECURITY_DESCRIPTOR_RELATIVE, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void encryptFile(File paramFile) {
/* 3045 */     String str = paramFile.getAbsolutePath();
/* 3046 */     if (!Advapi32.INSTANCE.EncryptFile(str)) {
/* 3047 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void decryptFile(File paramFile) {
/* 3058 */     String str = paramFile.getAbsolutePath();
/* 3059 */     if (!Advapi32.INSTANCE.DecryptFile(str, new WinDef.DWORD(0L))) {
/* 3060 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int fileEncryptionStatus(File paramFile) {
/* 3072 */     WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference();
/* 3073 */     String str = paramFile.getAbsolutePath();
/* 3074 */     if (!Advapi32.INSTANCE.FileEncryptionStatus(str, dWORDByReference)) {
/* 3075 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/* 3077 */     return dWORDByReference.getValue().intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void disableEncryption(File paramFile, boolean paramBoolean) {
/* 3090 */     String str = paramFile.getAbsolutePath();
/* 3091 */     if (!Advapi32.INSTANCE.EncryptionDisable(str, paramBoolean)) {
/* 3092 */       throw new Win32Exception(Native.getLastError());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void backupEncryptedFile(File paramFile1, File paramFile2) {
/* 3110 */     if (!paramFile2.isDirectory()) {
/* 3111 */       throw new IllegalArgumentException("destDir must be a directory.");
/*      */     }
/*      */     
/* 3114 */     WinDef.ULONG uLONG1 = new WinDef.ULONG(0L);
/* 3115 */     WinDef.ULONG uLONG2 = new WinDef.ULONG(1L);
/*      */     
/* 3117 */     if (paramFile1.isDirectory()) {
/* 3118 */       uLONG2.setValue(3L);
/*      */     }
/*      */ 
/*      */     
/* 3122 */     String str1 = paramFile1.getAbsolutePath();
/* 3123 */     PointerByReference pointerByReference = new PointerByReference();
/* 3124 */     if (Advapi32.INSTANCE.OpenEncryptedFileRaw(str1, uLONG1, pointerByReference) != 0)
/*      */     {
/* 3126 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */ 
/*      */     
/* 3130 */     final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/* 3131 */     WinBase.FE_EXPORT_FUNC fE_EXPORT_FUNC = new WinBase.FE_EXPORT_FUNC()
/*      */       {
/*      */         public WinDef.DWORD callback(Pointer param1Pointer1, Pointer param1Pointer2, WinDef.ULONG param1ULONG)
/*      */         {
/* 3135 */           byte[] arrayOfByte = param1Pointer1.getByteArray(0L, param1ULONG.intValue());
/*      */           try {
/* 3137 */             outputStream.write(arrayOfByte);
/* 3138 */           } catch (IOException iOException) {
/* 3139 */             throw new RuntimeException(iOException);
/*      */           } 
/* 3141 */           return new WinDef.DWORD(0L);
/*      */         }
/*      */       };
/*      */     
/* 3145 */     if (Advapi32.INSTANCE.ReadEncryptedFileRaw(fE_EXPORT_FUNC, null, pointerByReference
/* 3146 */         .getValue()) != 0) {
/* 3147 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/* 3152 */       byteArrayOutputStream.close();
/* 3153 */     } catch (IOException iOException) {
/* 3154 */       throw new RuntimeException(iOException);
/*      */     } 
/* 3156 */     Advapi32.INSTANCE.CloseEncryptedFileRaw(pointerByReference.getValue());
/*      */ 
/*      */ 
/*      */     
/* 3160 */     String str2 = paramFile2.getAbsolutePath() + File.separator + paramFile1.getName();
/* 3161 */     pointerByReference = new PointerByReference();
/* 3162 */     if (Advapi32.INSTANCE.OpenEncryptedFileRaw(str2, uLONG2, pointerByReference) != 0)
/*      */     {
/* 3164 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */ 
/*      */     
/* 3168 */     final IntByReference elementsReadWrapper = new IntByReference(0);
/* 3169 */     WinBase.FE_IMPORT_FUNC fE_IMPORT_FUNC = new WinBase.FE_IMPORT_FUNC()
/*      */       {
/*      */         public WinDef.DWORD callback(Pointer param1Pointer1, Pointer param1Pointer2, WinDef.ULONGByReference param1ULONGByReference)
/*      */         {
/* 3173 */           int i = elementsReadWrapper.getValue();
/* 3174 */           int j = outputStream.size() - i;
/* 3175 */           int k = Math.min(j, param1ULONGByReference.getValue().intValue());
/* 3176 */           param1Pointer1.write(0L, outputStream.toByteArray(), i, k);
/*      */           
/* 3178 */           elementsReadWrapper.setValue(i + k);
/* 3179 */           param1ULONGByReference.setValue(new WinDef.ULONG(k));
/* 3180 */           return new WinDef.DWORD(0L);
/*      */         }
/*      */       };
/*      */     
/* 3184 */     if (Advapi32.INSTANCE.WriteEncryptedFileRaw(fE_IMPORT_FUNC, null, pointerByReference
/* 3185 */         .getValue()) != 0) {
/* 3186 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */ 
/*      */     
/* 3190 */     Advapi32.INSTANCE.CloseEncryptedFileRaw(pointerByReference.getValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Privilege
/*      */     implements Closeable
/*      */   {
/*      */     private boolean currentlyImpersonating = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean privilegesEnabled = false;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final WinNT.LUID[] pLuids;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Privilege(String... param1VarArgs) throws IllegalArgumentException, Win32Exception {
/* 3218 */       this.pLuids = new WinNT.LUID[param1VarArgs.length];
/* 3219 */       byte b = 0;
/* 3220 */       for (String str : param1VarArgs) {
/* 3221 */         this.pLuids[b] = new WinNT.LUID();
/* 3222 */         if (!Advapi32.INSTANCE.LookupPrivilegeValue(null, str, this.pLuids[b])) {
/* 3223 */           throw new IllegalArgumentException("Failed to find privilege \"" + param1VarArgs[b] + "\" - " + Kernel32.INSTANCE.GetLastError());
/*      */         }
/* 3225 */         b++;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() {
/* 3235 */       disable();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Privilege enable() throws Win32Exception {
/* 3247 */       if (this.privilegesEnabled) {
/* 3248 */         return this;
/*      */       }
/*      */       
/* 3251 */       WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/*      */       
/*      */       try {
/* 3254 */         hANDLEByReference.setValue(getThreadToken());
/* 3255 */         WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
/* 3256 */         for (byte b = 0; b < this.pLuids.length; b++) {
/* 3257 */           tOKEN_PRIVILEGES.Privileges[b] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[b], new WinDef.DWORD(2L));
/*      */         }
/* 3259 */         if (!Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, 0, null, null)) {
/* 3260 */           throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */         }
/* 3262 */         this.privilegesEnabled = true;
/*      */       }
/* 3264 */       catch (Win32Exception win32Exception) {
/*      */         
/* 3266 */         if (this.currentlyImpersonating) {
/* 3267 */           Advapi32.INSTANCE.SetThreadToken(null, null);
/* 3268 */           this.currentlyImpersonating = false;
/*      */         
/*      */         }
/* 3271 */         else if (this.privilegesEnabled) {
/* 3272 */           WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
/* 3273 */           for (byte b = 0; b < this.pLuids.length; b++) {
/* 3274 */             tOKEN_PRIVILEGES.Privileges[b] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[b], new WinDef.DWORD(0L));
/*      */           }
/* 3276 */           Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, 0, null, null);
/* 3277 */           this.privilegesEnabled = false;
/*      */         } 
/*      */         
/* 3280 */         throw win32Exception;
/*      */       }
/*      */       finally {
/*      */         
/* 3284 */         if (hANDLEByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference
/* 3285 */           .getValue() != null) {
/* 3286 */           Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
/* 3287 */           hANDLEByReference.setValue(null);
/*      */         } 
/*      */       } 
/* 3290 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void disable() throws Win32Exception {
/* 3299 */       WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/*      */       
/*      */       try {
/* 3302 */         hANDLEByReference.setValue(getThreadToken());
/* 3303 */         if (this.currentlyImpersonating) {
/* 3304 */           Advapi32.INSTANCE.SetThreadToken(null, null);
/*      */ 
/*      */         
/*      */         }
/* 3308 */         else if (this.privilegesEnabled) {
/* 3309 */           WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(this.pLuids.length);
/* 3310 */           for (byte b = 0; b < this.pLuids.length; b++) {
/* 3311 */             tOKEN_PRIVILEGES.Privileges[b] = new WinNT.LUID_AND_ATTRIBUTES(this.pLuids[b], new WinDef.DWORD(0L));
/*      */           }
/* 3313 */           Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, 0, null, null);
/* 3314 */           this.privilegesEnabled = false;
/*      */         }
/*      */       
/*      */       }
/*      */       finally {
/*      */         
/* 3320 */         if (hANDLEByReference.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference
/* 3321 */           .getValue() != null) {
/* 3322 */           Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
/* 3323 */           hANDLEByReference.setValue(null);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private WinNT.HANDLE getThreadToken() throws Win32Exception {
/* 3336 */       WinNT.HANDLEByReference hANDLEByReference1 = new WinNT.HANDLEByReference();
/* 3337 */       WinNT.HANDLEByReference hANDLEByReference2 = new WinNT.HANDLEByReference();
/*      */ 
/*      */       
/*      */       try {
/* 3341 */         if (!Advapi32.INSTANCE.OpenThreadToken(Kernel32.INSTANCE.GetCurrentThread(), 32, false, hANDLEByReference1))
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 3346 */           int i = Kernel32.INSTANCE.GetLastError();
/* 3347 */           if (1008 != i) {
/* 3348 */             throw new Win32Exception(i);
/*      */           }
/*      */ 
/*      */           
/* 3352 */           if (!Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 2, hANDLEByReference2)) {
/* 3353 */             throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */           }
/*      */ 
/*      */           
/* 3357 */           if (!Advapi32.INSTANCE.DuplicateTokenEx(hANDLEByReference2.getValue(), 36, null, 2, 2, hANDLEByReference1))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/* 3363 */             throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */           }
/*      */ 
/*      */           
/* 3367 */           if (!Advapi32.INSTANCE.SetThreadToken(null, hANDLEByReference1.getValue())) {
/* 3368 */             throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */           }
/* 3370 */           this.currentlyImpersonating = true;
/*      */         }
/*      */       
/* 3373 */       } catch (Win32Exception win32Exception) {
/*      */         
/* 3375 */         if (hANDLEByReference1.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference1
/* 3376 */           .getValue() != null) {
/* 3377 */           Kernel32.INSTANCE.CloseHandle(hANDLEByReference1.getValue());
/* 3378 */           hANDLEByReference1.setValue(null);
/*      */         } 
/* 3380 */         throw win32Exception;
/*      */       
/*      */       }
/*      */       finally {
/*      */         
/* 3385 */         if (hANDLEByReference2.getValue() != WinBase.INVALID_HANDLE_VALUE && hANDLEByReference2
/* 3386 */           .getValue() != null) {
/* 3387 */           Kernel32.INSTANCE.CloseHandle(hANDLEByReference2.getValue());
/* 3388 */           hANDLEByReference2.setValue(null);
/*      */         } 
/*      */       } 
/*      */       
/* 3392 */       return hANDLEByReference1.getValue();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Advapi32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */