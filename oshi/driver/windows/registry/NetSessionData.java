/*    */ package oshi.driver.windows.registry;
/*    */ 
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.win32.Netapi32;
/*    */ import com.sun.jna.ptr.IntByReference;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.software.os.OSSession;
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
/*    */ @ThreadSafe
/*    */ public final class NetSessionData
/*    */ {
/* 45 */   private static final Netapi32 NET = Netapi32.INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static List<OSSession> queryUserSessions() {
/* 51 */     ArrayList<OSSession> arrayList = new ArrayList();
/* 52 */     PointerByReference pointerByReference = new PointerByReference();
/* 53 */     IntByReference intByReference1 = new IntByReference();
/* 54 */     IntByReference intByReference2 = new IntByReference();
/* 55 */     if (0 == NET.NetSessionEnum(null, null, null, 10, pointerByReference, -1, intByReference1, intByReference2, null)) {
/*    */       
/* 57 */       Pointer pointer = pointerByReference.getValue();
/* 58 */       Netapi32.SESSION_INFO_10 sESSION_INFO_10 = new Netapi32.SESSION_INFO_10(pointer);
/* 59 */       if (intByReference1.getValue() > 0) {
/* 60 */         Netapi32.SESSION_INFO_10[] arrayOfSESSION_INFO_10 = (Netapi32.SESSION_INFO_10[])sESSION_INFO_10.toArray(intByReference1.getValue());
/* 61 */         for (Netapi32.SESSION_INFO_10 sESSION_INFO_101 : arrayOfSESSION_INFO_10) {
/*    */           
/* 63 */           long l = System.currentTimeMillis() - 1000L * sESSION_INFO_101.sesi10_time;
/* 64 */           arrayList.add(new OSSession(sESSION_INFO_101.sesi10_username, "Network session", l, sESSION_INFO_101.sesi10_cname));
/*    */         } 
/*    */       } 
/* 67 */       NET.NetApiBufferFree(pointer);
/*    */     } 
/* 69 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\registry\NetSessionData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */