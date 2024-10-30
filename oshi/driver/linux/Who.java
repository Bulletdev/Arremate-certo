/*    */ package oshi.driver.linux;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import java.nio.charset.Charset;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.jna.platform.linux.LinuxLibc;
/*    */ import oshi.software.os.OSSession;
/*    */ import oshi.util.ParseUtil;
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
/* 47 */   private static final LinuxLibc LIBC = LinuxLibc.INSTANCE;
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
/* 58 */     ArrayList<OSSession> arrayList = new ArrayList();
/*    */ 
/*    */     
/* 61 */     LIBC.setutxent();
/*    */     try {
/*    */       LinuxLibc.LinuxUtmpx linuxUtmpx;
/* 64 */       while ((linuxUtmpx = LIBC.getutxent()) != null) {
/* 65 */         if (linuxUtmpx.ut_type == 7 || linuxUtmpx.ut_type == 6) {
/* 66 */           String str1 = Native.toString(linuxUtmpx.ut_user, Charset.defaultCharset());
/* 67 */           String str2 = Native.toString(linuxUtmpx.ut_line, Charset.defaultCharset());
/* 68 */           String str3 = ParseUtil.parseUtAddrV6toIP(linuxUtmpx.ut_addr_v6);
/* 69 */           long l = linuxUtmpx.ut_tv.tv_sec * 1000L + linuxUtmpx.ut_tv.tv_usec / 1000L;
/*    */           
/* 71 */           if (str1.isEmpty() || str2.isEmpty() || l < 0L || l > System.currentTimeMillis()) {
/* 72 */             return oshi.driver.unix.Who.queryWho();
/*    */           }
/* 74 */           arrayList.add(new OSSession(str1, str2, l, str3));
/*    */         } 
/*    */       } 
/*    */     } finally {
/*    */       
/* 79 */       LIBC.endutxent();
/*    */     } 
/* 81 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\Who.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */