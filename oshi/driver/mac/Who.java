/*    */ package oshi.driver.mac;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.jna.platform.mac.SystemB;
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
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class Who
/*    */ {
/* 46 */   private static final SystemB SYS = SystemB.INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static synchronized List<OSSession> queryUtxent() {
/* 57 */     ArrayList<OSSession> arrayList = new ArrayList();
/*    */ 
/*    */     
/* 60 */     SYS.setutxent(); try {
/*    */       SystemB.MacUtmpx macUtmpx;
/* 62 */       while ((macUtmpx = SYS.getutxent()) != null) {
/* 63 */         if (macUtmpx.ut_type == 7 || macUtmpx.ut_type == 6) {
/* 64 */           String str1 = Native.toString(macUtmpx.ut_user, StandardCharsets.US_ASCII);
/* 65 */           String str2 = Native.toString(macUtmpx.ut_line, StandardCharsets.US_ASCII);
/* 66 */           String str3 = Native.toString(macUtmpx.ut_host, StandardCharsets.US_ASCII);
/* 67 */           long l = macUtmpx.ut_tv.tv_sec.longValue() * 1000L + macUtmpx.ut_tv.tv_usec / 1000L;
/*    */           
/* 69 */           if (str1.isEmpty() || str2.isEmpty() || l < 0L || l > System.currentTimeMillis()) {
/* 70 */             return oshi.driver.unix.Who.queryWho();
/*    */           }
/* 72 */           arrayList.add(new OSSession(str1, str2, l, str3));
/*    */         } 
/*    */       } 
/*    */     } finally {
/*    */       
/* 77 */       SYS.endutxent();
/*    */     } 
/* 79 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\mac\Who.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */