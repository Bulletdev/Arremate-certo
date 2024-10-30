/*     */ package oshi.driver.windows.registry;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.platform.win32.Wtsapi32;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.os.OSSession;
/*     */ import oshi.util.ParseUtil;
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
/*     */ @ThreadSafe
/*     */ public final class SessionWtsData
/*     */ {
/*     */   private static final int WTS_ACTIVE = 0;
/*     */   private static final int WTS_CLIENTADDRESS = 14;
/*     */   private static final int WTS_SESSIONINFO = 24;
/*     */   private static final int WTS_CLIENTPROTOCOLTYPE = 16;
/*  63 */   private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
/*     */   
/*  65 */   private static final Wtsapi32 WTS = Wtsapi32.INSTANCE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<OSSession> queryUserSessions() {
/*  71 */     ArrayList<OSSession> arrayList = new ArrayList();
/*  72 */     if (IS_VISTA_OR_GREATER) {
/*  73 */       PointerByReference pointerByReference = new PointerByReference();
/*  74 */       IntByReference intByReference = new IntByReference();
/*  75 */       if (WTS.WTSEnumerateSessions(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, 0, 1, pointerByReference, intByReference)) {
/*  76 */         Pointer pointer = pointerByReference.getValue();
/*  77 */         if (intByReference.getValue() > 0) {
/*  78 */           Wtsapi32.WTS_SESSION_INFO wTS_SESSION_INFO = new Wtsapi32.WTS_SESSION_INFO(pointer);
/*  79 */           Wtsapi32.WTS_SESSION_INFO[] arrayOfWTS_SESSION_INFO = (Wtsapi32.WTS_SESSION_INFO[])wTS_SESSION_INFO.toArray(intByReference.getValue());
/*  80 */           for (Wtsapi32.WTS_SESSION_INFO wTS_SESSION_INFO1 : arrayOfWTS_SESSION_INFO) {
/*  81 */             if (wTS_SESSION_INFO1.State == 0) {
/*     */               
/*  83 */               PointerByReference pointerByReference1 = new PointerByReference();
/*  84 */               IntByReference intByReference1 = new IntByReference();
/*  85 */               WTS.WTSQuerySessionInformation(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, wTS_SESSION_INFO1.SessionId, 16, pointerByReference1, intByReference1);
/*     */               
/*  87 */               Pointer pointer1 = pointerByReference1.getValue();
/*  88 */               short s = pointer1.getShort(0L);
/*  89 */               WTS.WTSFreeMemory(pointer1);
/*     */               
/*  91 */               if (s > 0) {
/*     */                 
/*  93 */                 String str1 = wTS_SESSION_INFO1.pWinStationName;
/*     */                 
/*  95 */                 WTS.WTSQuerySessionInformation(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, wTS_SESSION_INFO1.SessionId, 24, pointerByReference1, intByReference1);
/*     */                 
/*  97 */                 pointer1 = pointerByReference1.getValue();
/*  98 */                 Wtsapi32.WTSINFO wTSINFO = new Wtsapi32.WTSINFO(pointer1);
/*     */ 
/*     */                 
/* 101 */                 long l = (new WinBase.FILETIME(new WinNT.LARGE_INTEGER(wTSINFO.LogonTime.getValue()))).toTime();
/* 102 */                 String str2 = wTSINFO.getUserName();
/* 103 */                 WTS.WTSFreeMemory(pointer1);
/*     */                 
/* 105 */                 WTS.WTSQuerySessionInformation(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, wTS_SESSION_INFO1.SessionId, 14, pointerByReference1, intByReference1);
/*     */                 
/* 107 */                 pointer1 = pointerByReference1.getValue();
/* 108 */                 Wtsapi32.WTS_CLIENT_ADDRESS wTS_CLIENT_ADDRESS = new Wtsapi32.WTS_CLIENT_ADDRESS(pointer1);
/* 109 */                 WTS.WTSFreeMemory(pointer1);
/* 110 */                 String str3 = "::";
/* 111 */                 if (wTS_CLIENT_ADDRESS.AddressFamily == 2) {
/*     */                   
/*     */                   try {
/* 114 */                     str3 = InetAddress.getByAddress(Arrays.copyOfRange(wTS_CLIENT_ADDRESS.Address, 2, 6)).getHostAddress();
/* 115 */                   } catch (UnknownHostException unknownHostException) {
/*     */                     
/* 117 */                     str3 = "Illegal length IP Array";
/*     */                   } 
/* 119 */                 } else if (wTS_CLIENT_ADDRESS.AddressFamily == 23) {
/*     */                   
/* 121 */                   int[] arrayOfInt = convertBytesToInts(wTS_CLIENT_ADDRESS.Address);
/* 122 */                   str3 = ParseUtil.parseUtAddrV6toIP(arrayOfInt);
/*     */                 } 
/* 124 */                 arrayList.add(new OSSession(str2, str1, l, str3));
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/* 129 */         WTS.WTSFreeMemory(pointer);
/*     */       } 
/*     */     } 
/* 132 */     return arrayList;
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
/*     */   private static int[] convertBytesToInts(byte[] paramArrayOfbyte) {
/* 148 */     IntBuffer intBuffer = ByteBuffer.wrap(Arrays.copyOfRange(paramArrayOfbyte, 2, 18)).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
/* 149 */     int[] arrayOfInt = new int[intBuffer.remaining()];
/* 150 */     intBuffer.get(arrayOfInt);
/* 151 */     return arrayOfInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\registry\SessionWtsData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */