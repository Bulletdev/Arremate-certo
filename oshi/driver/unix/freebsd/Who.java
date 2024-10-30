/*    */ package oshi.driver.unix.freebsd;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.jna.platform.unix.freebsd.FreeBsdLibc;
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
/* 46 */   private static final FreeBsdLibc LIBC = FreeBsdLibc.INSTANCE;
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
/*    */       FreeBsdLibc.FreeBsdUtmpx freeBsdUtmpx;
/* 63 */       while ((freeBsdUtmpx = LIBC.getutxent()) != null) {
/* 64 */         if (freeBsdUtmpx.ut_type == 7 || freeBsdUtmpx.ut_type == 6) {
/* 65 */           String str1 = Native.toString(freeBsdUtmpx.ut_user, StandardCharsets.US_ASCII);
/* 66 */           String str2 = Native.toString(freeBsdUtmpx.ut_line, StandardCharsets.US_ASCII);
/* 67 */           String str3 = Native.toString(freeBsdUtmpx.ut_host, StandardCharsets.US_ASCII);
/* 68 */           long l = freeBsdUtmpx.ut_tv.tv_sec * 1000L + freeBsdUtmpx.ut_tv.tv_usec / 1000L;
/*    */           
/* 70 */           if (str1.isEmpty() || str2.isEmpty() || l < 0L || l > System.currentTimeMillis()) {
/* 71 */             return oshi.driver.unix.Who.queryWho();
/*    */           }
/* 73 */           arrayList.add(new OSSession(str1, str2, l, str3));
/*    */         } 
/*    */       } 
/*    */     } finally {
/*    */       
/* 78 */       LIBC.endutxent();
/*    */     } 
/* 80 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\freebsd\Who.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */