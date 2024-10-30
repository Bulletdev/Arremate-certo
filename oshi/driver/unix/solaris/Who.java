/*    */ package oshi.driver.unix.solaris;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.jna.platform.unix.solaris.SolarisLibc;
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
/* 46 */   private static final SolarisLibc LIBC = SolarisLibc.INSTANCE;
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
/* 60 */     LIBC.setutxent();
/*    */     try {
/*    */       SolarisLibc.SolarisUtmpx solarisUtmpx;
/* 63 */       while ((solarisUtmpx = LIBC.getutxent()) != null) {
/* 64 */         if (solarisUtmpx.ut_type == 7 || solarisUtmpx.ut_type == 6) {
/* 65 */           String str = Native.toString(solarisUtmpx.ut_user, StandardCharsets.US_ASCII);
/* 66 */           if (!"LOGIN".equals(str)) {
/* 67 */             String str1 = Native.toString(solarisUtmpx.ut_line, StandardCharsets.US_ASCII);
/* 68 */             String str2 = Native.toString(solarisUtmpx.ut_host, StandardCharsets.US_ASCII);
/* 69 */             long l = solarisUtmpx.ut_tv.tv_sec.longValue() * 1000L + solarisUtmpx.ut_tv.tv_usec.longValue() / 1000L;
/*    */             
/* 71 */             if (str.isEmpty() || str1.isEmpty() || l < 0L || l > 
/* 72 */               System.currentTimeMillis()) {
/* 73 */               return oshi.driver.unix.Who.queryWho();
/*    */             }
/* 75 */             arrayList.add(new OSSession(str, str1, l, str2));
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } finally {
/*    */       
/* 81 */       LIBC.endutxent();
/*    */     } 
/* 83 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\solaris\Who.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */