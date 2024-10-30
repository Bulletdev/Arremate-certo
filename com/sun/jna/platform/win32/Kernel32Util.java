/*      */ package com.sun.jna.platform.win32;
/*      */ 
/*      */ import com.sun.jna.LastErrorException;
/*      */ import com.sun.jna.Memory;
/*      */ import com.sun.jna.Native;
/*      */ import com.sun.jna.Pointer;
/*      */ import com.sun.jna.Structure;
/*      */ import com.sun.jna.ptr.IntByReference;
/*      */ import com.sun.jna.ptr.PointerByReference;
/*      */ import com.sun.jna.win32.W32APITypeMapper;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.nio.ByteOrder;
/*      */ import java.util.ArrayList;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
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
/*      */ public abstract class Kernel32Util
/*      */   implements WinDef
/*      */ {
/*      */   public static final String VOLUME_GUID_PATH_PREFIX = "\\\\?\\Volume{";
/*      */   public static final String VOLUME_GUID_PATH_SUFFIX = "}\\";
/*      */   
/*      */   public static String getComputerName() {
/*   63 */     char[] arrayOfChar = new char[WinBase.MAX_COMPUTERNAME_LENGTH + 1];
/*   64 */     IntByReference intByReference = new IntByReference(arrayOfChar.length);
/*   65 */     if (!Kernel32.INSTANCE.GetComputerName(arrayOfChar, intByReference)) {
/*   66 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*   68 */     return Native.toString(arrayOfChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void freeLocalMemory(Pointer paramPointer) {
/*   78 */     Pointer pointer = Kernel32.INSTANCE.LocalFree(paramPointer);
/*   79 */     if (pointer != null) {
/*   80 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void freeGlobalMemory(Pointer paramPointer) {
/*   91 */     Pointer pointer = Kernel32.INSTANCE.GlobalFree(paramPointer);
/*   92 */     if (pointer != null) {
/*   93 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
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
/*      */   public static void closeHandleRefs(WinNT.HANDLEByReference... paramVarArgs) {
/*  108 */     Win32Exception win32Exception = null;
/*  109 */     for (WinNT.HANDLEByReference hANDLEByReference : paramVarArgs) {
/*      */       try {
/*  111 */         closeHandleRef(hANDLEByReference);
/*  112 */       } catch (Win32Exception win32Exception1) {
/*  113 */         if (win32Exception == null) {
/*  114 */           win32Exception = win32Exception1;
/*      */         } else {
/*  116 */           win32Exception.addSuppressedReflected((Throwable)win32Exception1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  121 */     if (win32Exception != null) {
/*  122 */       throw win32Exception;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void closeHandleRef(WinNT.HANDLEByReference paramHANDLEByReference) {
/*  132 */     closeHandle((paramHANDLEByReference == null) ? null : paramHANDLEByReference.getValue());
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
/*      */   public static void closeHandles(WinNT.HANDLE... paramVarArgs) {
/*  146 */     Win32Exception win32Exception = null;
/*  147 */     for (WinNT.HANDLE hANDLE : paramVarArgs) {
/*      */       try {
/*  149 */         closeHandle(hANDLE);
/*  150 */       } catch (Win32Exception win32Exception1) {
/*  151 */         if (win32Exception == null) {
/*  152 */           win32Exception = win32Exception1;
/*      */         } else {
/*  154 */           win32Exception.addSuppressedReflected((Throwable)win32Exception1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  159 */     if (win32Exception != null) {
/*  160 */       throw win32Exception;
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
/*      */   public static void closeHandle(WinNT.HANDLE paramHANDLE) {
/*  172 */     if (paramHANDLE == null) {
/*      */       return;
/*      */     }
/*      */     
/*  176 */     if (!Kernel32.INSTANCE.CloseHandle(paramHANDLE)) {
/*  177 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
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
/*      */   public static String formatMessage(int paramInt) {
/*  189 */     PointerByReference pointerByReference = new PointerByReference();
/*  190 */     int i = Kernel32.INSTANCE.FormatMessage(4864, null, paramInt, 0, pointerByReference, 0, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  198 */     if (i == 0) {
/*  199 */       throw new LastErrorException(Native.getLastError());
/*      */     }
/*      */     
/*  202 */     Pointer pointer = pointerByReference.getValue();
/*      */     try {
/*  204 */       String str = pointer.getWideString(0L);
/*  205 */       return str.trim();
/*      */     } finally {
/*  207 */       freeLocalMemory(pointer);
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
/*      */   public static String formatMessage(WinNT.HRESULT paramHRESULT) {
/*  219 */     return formatMessage(paramHRESULT.intValue());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String formatMessageFromLastErrorCode(int paramInt) {
/*  230 */     return formatMessage(W32Errors.HRESULT_FROM_WIN32(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getLastErrorMessage() {
/*  238 */     return formatMessageFromLastErrorCode(Kernel32.INSTANCE
/*  239 */         .GetLastError());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getTempPath() {
/*  248 */     WinDef.DWORD dWORD = new WinDef.DWORD(260L);
/*  249 */     char[] arrayOfChar = new char[dWORD.intValue()];
/*  250 */     if (Kernel32.INSTANCE.GetTempPath(dWORD, arrayOfChar).intValue() == 0) {
/*  251 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*  253 */     return Native.toString(arrayOfChar);
/*      */   }
/*      */   
/*      */   public static void deleteFile(String paramString) {
/*  257 */     if (!Kernel32.INSTANCE.DeleteFile(paramString)) {
/*  258 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<String> getLogicalDriveStrings() {
/*  268 */     WinDef.DWORD dWORD = Kernel32.INSTANCE.GetLogicalDriveStrings(new WinDef.DWORD(0L), null);
/*  269 */     if (dWORD.intValue() <= 0) {
/*  270 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  273 */     char[] arrayOfChar = new char[dWORD.intValue()];
/*  274 */     dWORD = Kernel32.INSTANCE.GetLogicalDriveStrings(dWORD, arrayOfChar);
/*  275 */     int i = dWORD.intValue();
/*  276 */     if (i <= 0) {
/*  277 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  280 */     return Native.toStringList(arrayOfChar, 0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getFileAttributes(String paramString) {
/*  291 */     int i = Kernel32.INSTANCE.GetFileAttributes(paramString);
/*  292 */     if (i == -1) {
/*  293 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*  295 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getFileType(String paramString) throws FileNotFoundException {
/*  305 */     File file = new File(paramString);
/*  306 */     if (!file.exists()) {
/*  307 */       throw new FileNotFoundException(paramString);
/*      */     }
/*      */     
/*  310 */     WinNT.HANDLE hANDLE = null;
/*  311 */     Win32Exception win32Exception = null; try {
/*      */       int j;
/*  313 */       hANDLE = Kernel32.INSTANCE.CreateFile(paramString, -2147483648, 1, new WinBase.SECURITY_ATTRIBUTES(), 3, 128, (new WinNT.HANDLEByReference())
/*      */ 
/*      */           
/*  316 */           .getValue());
/*      */       
/*  318 */       if (WinBase.INVALID_HANDLE_VALUE.equals(hANDLE)) {
/*  319 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */       
/*  322 */       int i = Kernel32.INSTANCE.GetFileType(hANDLE);
/*  323 */       switch (i) {
/*      */         case 0:
/*  325 */           j = Kernel32.INSTANCE.GetLastError();
/*  326 */           switch (j) {
/*      */             case 0:
/*      */               break;
/*      */           } 
/*  330 */           throw new Win32Exception(j);
/*      */       } 
/*      */       
/*  333 */       return i;
/*      */     }
/*  335 */     catch (Win32Exception win32Exception1) {
/*  336 */       win32Exception = win32Exception1;
/*  337 */       throw win32Exception;
/*      */     } finally {
/*      */       try {
/*  340 */         closeHandle(hANDLE);
/*  341 */       } catch (Win32Exception win32Exception1) {
/*  342 */         if (win32Exception == null) {
/*  343 */           win32Exception = win32Exception1;
/*      */         } else {
/*  345 */           win32Exception.addSuppressedReflected((Throwable)win32Exception1);
/*      */         } 
/*      */       } 
/*      */       
/*  349 */       if (win32Exception != null) {
/*  350 */         throw win32Exception;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getDriveType(String paramString) {
/*  360 */     return Kernel32.INSTANCE.GetDriveType(paramString);
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
/*      */   public static String getEnvironmentVariable(String paramString) {
/*  372 */     int i = Kernel32.INSTANCE.GetEnvironmentVariable(paramString, null, 0);
/*  373 */     if (i == 0)
/*  374 */       return null; 
/*  375 */     if (i < 0) {
/*  376 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  379 */     char[] arrayOfChar = new char[i];
/*  380 */     i = Kernel32.INSTANCE.GetEnvironmentVariable(paramString, arrayOfChar, arrayOfChar.length);
/*      */     
/*  382 */     if (i <= 0) {
/*  383 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*  385 */     return Native.toString(arrayOfChar);
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
/*      */   public static Map<String, String> getEnvironmentVariables() {
/*  397 */     Pointer pointer = Kernel32.INSTANCE.GetEnvironmentStrings();
/*  398 */     if (pointer == null) {
/*  399 */       throw new LastErrorException(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*      */     try {
/*  403 */       return getEnvironmentVariables(pointer, 0L);
/*      */     } finally {
/*  405 */       if (!Kernel32.INSTANCE.FreeEnvironmentStrings(pointer)) {
/*  406 */         throw new LastErrorException(Kernel32.INSTANCE.GetLastError());
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
/*      */   public static Map<String, String> getEnvironmentVariables(Pointer paramPointer, long paramLong) {
/*  423 */     if (paramPointer == null) {
/*  424 */       return null;
/*      */     }
/*      */     
/*  427 */     TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
/*  428 */     boolean bool = isWideCharEnvironmentStringBlock(paramPointer, paramLong);
/*  429 */     long l1 = bool ? 2L : 1L;
/*  430 */     long l2 = paramLong; while (true) {
/*  431 */       String str1 = readEnvironmentStringBlockEntry(paramPointer, l2, bool);
/*  432 */       int i = str1.length();
/*  433 */       if (i == 0) {
/*      */         break;
/*      */       }
/*      */       
/*  437 */       int j = str1.indexOf('=');
/*  438 */       if (j < 0) {
/*  439 */         throw new IllegalArgumentException("Missing variable value separator in " + str1);
/*      */       }
/*      */       
/*  442 */       String str2 = str1.substring(0, j), str3 = str1.substring(j + 1);
/*  443 */       treeMap.put(str2, str3);
/*      */       
/*  445 */       l2 += (i + 1) * l1;
/*      */     } 
/*      */     
/*  448 */     return (Map)treeMap;
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
/*      */   public static String readEnvironmentStringBlockEntry(Pointer paramPointer, long paramLong, boolean paramBoolean) {
/*  464 */     long l1 = findEnvironmentStringBlockEntryEnd(paramPointer, paramLong, paramBoolean);
/*  465 */     int i = (int)(l1 - paramLong);
/*  466 */     if (i == 0) {
/*  467 */       return "";
/*      */     }
/*      */     
/*  470 */     int j = paramBoolean ? (i / 2) : i;
/*  471 */     char[] arrayOfChar = new char[j];
/*  472 */     long l2 = paramLong, l3 = paramBoolean ? 2L : 1L;
/*  473 */     ByteOrder byteOrder = ByteOrder.nativeOrder();
/*  474 */     for (byte b = 0; b < arrayOfChar.length; b++, l2 += l3) {
/*  475 */       byte b1 = paramPointer.getByte(l2);
/*  476 */       if (paramBoolean) {
/*  477 */         byte b2 = paramPointer.getByte(l2 + 1L);
/*  478 */         if (ByteOrder.LITTLE_ENDIAN.equals(byteOrder)) {
/*  479 */           arrayOfChar[b] = (char)(b2 << 8 & 0xFF00 | b1 & 0xFF);
/*      */         } else {
/*  481 */           arrayOfChar[b] = (char)(b1 << 8 & 0xFF00 | b2 & 0xFF);
/*      */         } 
/*      */       } else {
/*  484 */         arrayOfChar[b] = (char)(b1 & 0xFF);
/*      */       } 
/*      */     } 
/*      */     
/*  488 */     return new String(arrayOfChar);
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
/*      */   public static long findEnvironmentStringBlockEntryEnd(Pointer paramPointer, long paramLong, boolean paramBoolean) {
/*      */     long l1;
/*      */     long l2;
/*  504 */     for (l1 = paramLong, l2 = paramBoolean ? 2L : 1L;; l1 += l2) {
/*  505 */       byte b = paramPointer.getByte(l1);
/*  506 */       if (b == 0) {
/*  507 */         return l1;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isWideCharEnvironmentStringBlock(Pointer paramPointer, long paramLong) {
/*  540 */     byte b1 = paramPointer.getByte(paramLong);
/*  541 */     byte b2 = paramPointer.getByte(paramLong + 1L);
/*  542 */     ByteOrder byteOrder = ByteOrder.nativeOrder();
/*  543 */     if (ByteOrder.LITTLE_ENDIAN.equals(byteOrder)) {
/*  544 */       return isWideCharEnvironmentStringBlock(b2);
/*      */     }
/*  546 */     return isWideCharEnvironmentStringBlock(b1);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isWideCharEnvironmentStringBlock(byte paramByte) {
/*  552 */     if (paramByte != 0) {
/*  553 */       return false;
/*      */     }
/*  555 */     return true;
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
/*      */   public static final int getPrivateProfileInt(String paramString1, String paramString2, int paramInt, String paramString3) {
/*  581 */     return Kernel32.INSTANCE.GetPrivateProfileInt(paramString1, paramString2, paramInt, paramString3);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final String getPrivateProfileString(String paramString1, String paramString2, String paramString3, String paramString4) {
/*  636 */     char[] arrayOfChar = new char[1024];
/*  637 */     Kernel32.INSTANCE.GetPrivateProfileString(paramString1, paramString2, paramString3, arrayOfChar, new WinDef.DWORD(arrayOfChar.length), paramString4);
/*      */     
/*  639 */     return Native.toString(arrayOfChar);
/*      */   }
/*      */ 
/*      */   
/*      */   public static final void writePrivateProfileString(String paramString1, String paramString2, String paramString3, String paramString4) {
/*  644 */     if (!Kernel32.INSTANCE.WritePrivateProfileString(paramString1, paramString2, paramString3, paramString4))
/*      */     {
/*  646 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION[] getLogicalProcessorInformation() {
/*      */     Memory memory;
/*  657 */     int i = (new WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION()).size();
/*  658 */     WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD(i));
/*      */ 
/*      */     
/*      */     while (true) {
/*  662 */       memory = new Memory(dWORDByReference.getValue().intValue());
/*  663 */       if (!Kernel32.INSTANCE.GetLogicalProcessorInformation((Pointer)memory, dWORDByReference)) {
/*      */         
/*  665 */         int k = Kernel32.INSTANCE.GetLastError();
/*  666 */         if (k != 122)
/*  667 */           throw new Win32Exception(k); 
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  672 */     WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION sYSTEM_LOGICAL_PROCESSOR_INFORMATION = new WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION((Pointer)memory);
/*      */     
/*  674 */     int j = dWORDByReference.getValue().intValue() / i;
/*      */     
/*  676 */     return (WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION[])sYSTEM_LOGICAL_PROCESSOR_INFORMATION
/*  677 */       .toArray((Structure[])new WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION[j]);
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
/*      */   public static final WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[] getLogicalProcessorInformationEx(int paramInt) {
/*      */     Memory memory;
/*  698 */     WinDef.DWORDByReference dWORDByReference = new WinDef.DWORDByReference(new WinDef.DWORD(1L));
/*      */     
/*      */     while (true) {
/*  701 */       memory = new Memory(dWORDByReference.getValue().intValue());
/*  702 */       if (!Kernel32.INSTANCE.GetLogicalProcessorInformationEx(paramInt, (Pointer)memory, dWORDByReference)) {
/*  703 */         int j = Kernel32.INSTANCE.GetLastError();
/*  704 */         if (j != 122) {
/*  705 */           throw new Win32Exception(j);
/*      */         }
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  711 */     ArrayList<WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX> arrayList = new ArrayList();
/*  712 */     int i = 0;
/*  713 */     while (i < dWORDByReference.getValue().intValue()) {
/*      */       
/*  715 */       WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX = WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX.fromPointer(memory.share(i));
/*  716 */       arrayList.add(sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX);
/*  717 */       i += sYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX.size;
/*      */     } 
/*  719 */     return arrayList.<WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX>toArray(new WinNT.SYSTEM_LOGICAL_PROCESSOR_INFORMATION_EX[0]);
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
/*      */   public static final String[] getPrivateProfileSection(String paramString1, String paramString2) {
/*  740 */     char[] arrayOfChar = new char[32768];
/*  741 */     if (Kernel32.INSTANCE.GetPrivateProfileSection(paramString1, arrayOfChar, new WinDef.DWORD(arrayOfChar.length), paramString2).intValue() == 0) {
/*  742 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*  744 */     return (new String(arrayOfChar)).split("\000");
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
/*      */   public static final String[] getPrivateProfileSectionNames(String paramString) {
/*  759 */     char[] arrayOfChar = new char[65536];
/*  760 */     if (Kernel32.INSTANCE.GetPrivateProfileSectionNames(arrayOfChar, new WinDef.DWORD(arrayOfChar.length), paramString).intValue() == 0) {
/*  761 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*  763 */     return (new String(arrayOfChar)).split("\000");
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
/*      */   public static final void writePrivateProfileSection(String paramString1, String[] paramArrayOfString, String paramString2) {
/*  776 */     StringBuilder stringBuilder = new StringBuilder();
/*  777 */     for (String str : paramArrayOfString)
/*  778 */       stringBuilder.append(str).append(false); 
/*  779 */     stringBuilder.append(false);
/*  780 */     if (!Kernel32.INSTANCE.WritePrivateProfileSection(paramString1, stringBuilder.toString(), paramString2)) {
/*  781 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
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
/*      */   public static final List<String> queryDosDevice(String paramString, int paramInt) {
/*  793 */     char[] arrayOfChar = new char[paramInt];
/*  794 */     int i = Kernel32.INSTANCE.QueryDosDevice(paramString, arrayOfChar, arrayOfChar.length);
/*  795 */     if (i == 0) {
/*  796 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  799 */     return Native.toStringList(arrayOfChar, 0, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final List<String> getVolumePathNamesForVolumeName(String paramString) {
/*  809 */     char[] arrayOfChar = new char[261];
/*  810 */     IntByReference intByReference = new IntByReference();
/*      */     
/*  812 */     if (!Kernel32.INSTANCE.GetVolumePathNamesForVolumeName(paramString, arrayOfChar, arrayOfChar.length, intByReference)) {
/*  813 */       int j = Kernel32.INSTANCE.GetLastError();
/*  814 */       if (j != 234) {
/*  815 */         throw new Win32Exception(j);
/*      */       }
/*      */       
/*  818 */       int k = intByReference.getValue();
/*  819 */       arrayOfChar = new char[k];
/*      */       
/*  821 */       if (!Kernel32.INSTANCE.GetVolumePathNamesForVolumeName(paramString, arrayOfChar, arrayOfChar.length, intByReference)) {
/*  822 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */     } 
/*      */     
/*  826 */     int i = intByReference.getValue();
/*  827 */     return Native.toStringList(arrayOfChar, 0, i);
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
/*      */   public static final String extractVolumeGUID(String paramString) {
/*  847 */     if (paramString == null || paramString
/*  848 */       .length() <= "\\\\?\\Volume{".length() + "}\\".length() || 
/*  849 */       !paramString.startsWith("\\\\?\\Volume{") || 
/*  850 */       !paramString.endsWith("}\\")) {
/*  851 */       throw new IllegalArgumentException("Bad volume GUID path format: " + paramString);
/*      */     }
/*      */     
/*  854 */     return paramString.substring("\\\\?\\Volume{".length(), paramString.length() - "}\\".length());
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
/*      */   public static final String QueryFullProcessImageName(int paramInt1, int paramInt2) {
/*  870 */     WinNT.HANDLE hANDLE = null;
/*  871 */     Win32Exception win32Exception = null;
/*      */     
/*      */     try {
/*  874 */       hANDLE = Kernel32.INSTANCE.OpenProcess(1040, false, paramInt1);
/*  875 */       if (hANDLE == null) {
/*  876 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*  878 */       return QueryFullProcessImageName(hANDLE, paramInt2);
/*  879 */     } catch (Win32Exception win32Exception1) {
/*  880 */       win32Exception = win32Exception1;
/*  881 */       throw win32Exception;
/*      */     } finally {
/*      */       try {
/*  884 */         closeHandle(hANDLE);
/*  885 */       } catch (Win32Exception win32Exception1) {
/*  886 */         if (win32Exception == null) {
/*  887 */           win32Exception = win32Exception1;
/*      */         } else {
/*  889 */           win32Exception.addSuppressed((Throwable)win32Exception1);
/*      */         } 
/*      */       } 
/*  892 */       if (win32Exception != null) {
/*  893 */         throw win32Exception;
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
/*      */   public static final String QueryFullProcessImageName(WinNT.HANDLE paramHANDLE, int paramInt) {
/*  912 */     char c = 'Ą';
/*  913 */     IntByReference intByReference = new IntByReference();
/*      */     while (true) {
/*  915 */       char[] arrayOfChar = new char[c];
/*  916 */       intByReference.setValue(c);
/*  917 */       if (Kernel32.INSTANCE.QueryFullProcessImageName(paramHANDLE, paramInt, arrayOfChar, intByReference)) {
/*  918 */         return new String(arrayOfChar, 0, intByReference.getValue());
/*      */       }
/*  920 */       c += 'Ѐ';
/*  921 */       if (Kernel32.INSTANCE.GetLastError() != 122) {
/*  922 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
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
/*      */   public static byte[] getResource(String paramString1, String paramString2, String paramString3) {
/*      */     Win32Exception win32Exception;
/*  939 */     WinDef.HMODULE hMODULE = Kernel32.INSTANCE.LoadLibraryEx(paramString1, null, 2);
/*      */     
/*  941 */     if (hMODULE == null) {
/*  942 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/*  945 */     Throwable throwable = null;
/*  946 */     Pointer pointer = null;
/*  947 */     int i = 0;
/*  948 */     byte[] arrayOfByte = null; try {
/*      */       Memory memory1, memory2;
/*  950 */       Pointer pointer1 = null;
/*      */       try {
/*  952 */         pointer1 = new Pointer(Long.parseLong(paramString2));
/*  953 */       } catch (NumberFormatException numberFormatException) {
/*  954 */         memory1 = new Memory((Native.WCHAR_SIZE * (paramString2.length() + 1)));
/*  955 */         memory1.setWideString(0L, paramString2);
/*      */       } 
/*      */       
/*  958 */       Pointer pointer2 = null;
/*      */       try {
/*  960 */         pointer2 = new Pointer(Long.parseLong(paramString3));
/*  961 */       } catch (NumberFormatException numberFormatException) {
/*  962 */         memory2 = new Memory((Native.WCHAR_SIZE * (paramString3.length() + 1)));
/*  963 */         memory2.setWideString(0L, paramString3);
/*      */       } 
/*      */       
/*  966 */       WinDef.HRSRC hRSRC = Kernel32.INSTANCE.FindResource(hMODULE, (Pointer)memory2, (Pointer)memory1);
/*  967 */       if (hRSRC == null) {
/*  968 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */ 
/*      */       
/*  972 */       WinNT.HANDLE hANDLE = Kernel32.INSTANCE.LoadResource(hMODULE, hRSRC);
/*  973 */       if (hANDLE == null) {
/*  974 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */       
/*  977 */       i = Kernel32.INSTANCE.SizeofResource(hMODULE, hRSRC);
/*  978 */       if (i == 0) {
/*  979 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  984 */       pointer = Kernel32.INSTANCE.LockResource(hANDLE);
/*  985 */       if (pointer == null) {
/*  986 */         throw new IllegalStateException("LockResource returned null.");
/*      */       }
/*      */       
/*  989 */       arrayOfByte = pointer.getByteArray(0L, i);
/*  990 */     } catch (Win32Exception win32Exception1) {
/*  991 */       win32Exception = win32Exception1;
/*      */     } finally {
/*      */       
/*  994 */       if (hMODULE != null && 
/*  995 */         !Kernel32.INSTANCE.FreeLibrary(hMODULE)) {
/*  996 */         Win32Exception win32Exception1 = new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*  997 */         if (win32Exception != null) {
/*  998 */           win32Exception1.addSuppressedReflected((Throwable)win32Exception);
/*      */         }
/* 1000 */         throw win32Exception1;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1005 */     if (win32Exception != null) {
/* 1006 */       throw win32Exception;
/*      */     }
/*      */     
/* 1009 */     return arrayOfByte;
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
/*      */   public static Map<String, List<String>> getResourceNames(String paramString) {
/*      */     Win32Exception win32Exception;
/* 1022 */     WinDef.HMODULE hMODULE = Kernel32.INSTANCE.LoadLibraryEx(paramString, null, 2);
/*      */     
/* 1024 */     if (hMODULE == null) {
/* 1025 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/* 1028 */     final ArrayList types = new ArrayList();
/* 1029 */     final LinkedHashMap<Object, Object> result = new LinkedHashMap<Object, Object>();
/*      */     
/* 1031 */     WinBase.EnumResTypeProc enumResTypeProc = new WinBase.EnumResTypeProc()
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean invoke(WinDef.HMODULE param1HMODULE, Pointer param1Pointer1, Pointer param1Pointer2)
/*      */         {
/* 1039 */           if (Pointer.nativeValue(param1Pointer1) <= 65535L) {
/* 1040 */             types.add(Pointer.nativeValue(param1Pointer1) + "");
/*      */           } else {
/* 1042 */             types.add(param1Pointer1.getWideString(0L));
/*      */           } 
/* 1044 */           return true;
/*      */         }
/*      */       };
/*      */     
/* 1048 */     WinBase.EnumResNameProc enumResNameProc = new WinBase.EnumResNameProc()
/*      */       {
/*      */         public boolean invoke(WinDef.HMODULE param1HMODULE, Pointer param1Pointer1, Pointer param1Pointer2, Pointer param1Pointer3)
/*      */         {
/* 1052 */           String str = "";
/*      */           
/* 1054 */           if (Pointer.nativeValue(param1Pointer1) <= 65535L) {
/* 1055 */             str = Pointer.nativeValue(param1Pointer1) + "";
/*      */           } else {
/* 1057 */             str = param1Pointer1.getWideString(0L);
/*      */           } 
/*      */           
/* 1060 */           if (Pointer.nativeValue(param1Pointer2) < 65535L) {
/* 1061 */             ((List<String>)result.get(str)).add(Pointer.nativeValue(param1Pointer2) + "");
/*      */           } else {
/* 1063 */             ((List<String>)result.get(str)).add(param1Pointer2.getWideString(0L));
/*      */           } 
/*      */           
/* 1066 */           return true;
/*      */         }
/*      */       };
/*      */ 
/*      */     
/* 1071 */     Throwable throwable = null;
/*      */     try {
/* 1073 */       if (!Kernel32.INSTANCE.EnumResourceTypes(hMODULE, enumResTypeProc, null)) {
/* 1074 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */       
/* 1077 */       for (String str : arrayList) {
/* 1078 */         Memory memory; linkedHashMap.put(str, new ArrayList());
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1083 */         Pointer pointer = null;
/*      */         try {
/* 1085 */           pointer = new Pointer(Long.parseLong(str));
/* 1086 */         } catch (NumberFormatException numberFormatException) {
/* 1087 */           memory = new Memory((Native.WCHAR_SIZE * (str.length() + 1)));
/* 1088 */           memory.setWideString(0L, str);
/*      */         } 
/*      */         
/* 1091 */         boolean bool = Kernel32.INSTANCE.EnumResourceNames(hMODULE, (Pointer)memory, enumResNameProc, null);
/*      */         
/* 1093 */         if (!bool) {
/* 1094 */           throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */         }
/*      */       } 
/* 1097 */     } catch (Win32Exception win32Exception1) {
/* 1098 */       win32Exception = win32Exception1;
/*      */     }
/*      */     finally {
/*      */       
/* 1102 */       if (hMODULE != null && 
/* 1103 */         !Kernel32.INSTANCE.FreeLibrary(hMODULE)) {
/* 1104 */         Win32Exception win32Exception1 = new Win32Exception(Kernel32.INSTANCE.GetLastError());
/* 1105 */         if (win32Exception != null) {
/* 1106 */           win32Exception1.addSuppressedReflected((Throwable)win32Exception);
/*      */         }
/* 1108 */         throw win32Exception1;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1113 */     if (win32Exception != null) {
/* 1114 */       throw win32Exception;
/*      */     }
/* 1116 */     return (Map)linkedHashMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static List<Tlhelp32.MODULEENTRY32W> getModules(int paramInt) {
/* 1127 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPMODULE, new WinDef.DWORD(paramInt));
/* 1128 */     if (hANDLE == null) {
/* 1129 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/* 1132 */     Win32Exception win32Exception = null;
/*      */     try {
/* 1134 */       Tlhelp32.MODULEENTRY32W mODULEENTRY32W1 = new Tlhelp32.MODULEENTRY32W();
/*      */       
/* 1136 */       if (!Kernel32.INSTANCE.Module32FirstW(hANDLE, mODULEENTRY32W1)) {
/* 1137 */         throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */       }
/*      */       
/* 1140 */       ArrayList<Tlhelp32.MODULEENTRY32W> arrayList = new ArrayList();
/* 1141 */       arrayList.add(mODULEENTRY32W1);
/*      */       
/* 1143 */       Tlhelp32.MODULEENTRY32W mODULEENTRY32W2 = new Tlhelp32.MODULEENTRY32W();
/* 1144 */       while (Kernel32.INSTANCE.Module32NextW(hANDLE, mODULEENTRY32W2)) {
/* 1145 */         arrayList.add(mODULEENTRY32W2);
/* 1146 */         mODULEENTRY32W2 = new Tlhelp32.MODULEENTRY32W();
/*      */       } 
/*      */       
/* 1149 */       int i = Kernel32.INSTANCE.GetLastError();
/*      */ 
/*      */ 
/*      */       
/* 1153 */       if (i != 0 && i != 18) {
/* 1154 */         throw new Win32Exception(i);
/*      */       }
/*      */       
/* 1157 */       return arrayList;
/* 1158 */     } catch (Win32Exception win32Exception1) {
/* 1159 */       win32Exception = win32Exception1;
/* 1160 */       throw win32Exception;
/*      */     } finally {
/*      */       try {
/* 1163 */         closeHandle(hANDLE);
/* 1164 */       } catch (Win32Exception win32Exception1) {
/* 1165 */         if (win32Exception == null) {
/* 1166 */           win32Exception = win32Exception1;
/*      */         } else {
/* 1168 */           win32Exception.addSuppressedReflected((Throwable)win32Exception1);
/*      */         } 
/*      */       } 
/*      */       
/* 1172 */       if (win32Exception != null) {
/* 1173 */         throw win32Exception;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String expandEnvironmentStrings(String paramString) {
/*      */     Memory memory;
/* 1199 */     if (paramString == null) {
/* 1200 */       return "";
/*      */     }
/*      */     
/* 1203 */     int i = Kernel32.INSTANCE.ExpandEnvironmentStrings(paramString, null, 0);
/*      */     
/* 1205 */     if (i == 0) {
/* 1206 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */ 
/*      */     
/* 1210 */     if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/* 1211 */       memory = new Memory((i * Native.WCHAR_SIZE));
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1216 */       memory = new Memory((i + 1));
/*      */     } 
/* 1218 */     i = Kernel32.INSTANCE.ExpandEnvironmentStrings(paramString, (Pointer)memory, i);
/*      */     
/* 1220 */     if (i == 0) {
/* 1221 */       throw new Win32Exception(Kernel32.INSTANCE.GetLastError());
/*      */     }
/*      */     
/* 1224 */     if (W32APITypeMapper.DEFAULT == W32APITypeMapper.UNICODE) {
/* 1225 */       return memory.getWideString(0L);
/*      */     }
/* 1227 */     return memory.getString(0L);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Kernel32Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */