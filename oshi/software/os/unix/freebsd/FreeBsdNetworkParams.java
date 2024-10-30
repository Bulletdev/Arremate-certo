/*    */ package oshi.software.os.unix.freebsd;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.ptr.PointerByReference;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.jna.platform.unix.CLibrary;
/*    */ import oshi.jna.platform.unix.freebsd.FreeBsdLibc;
/*    */ import oshi.software.common.AbstractNetworkParams;
/*    */ import oshi.util.ExecutingCommand;
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
/*    */ final class FreeBsdNetworkParams
/*    */   extends AbstractNetworkParams
/*    */ {
/* 47 */   private static final Logger LOG = LoggerFactory.getLogger(FreeBsdNetworkParams.class);
/*    */   
/* 49 */   private static final FreeBsdLibc LIBC = FreeBsdLibc.INSTANCE;
/*    */ 
/*    */   
/*    */   public String getDomainName() {
/* 53 */     CLibrary.Addrinfo addrinfo1 = new CLibrary.Addrinfo();
/* 54 */     addrinfo1.ai_flags = 2;
/* 55 */     String str1 = getHostName();
/*    */     
/* 57 */     PointerByReference pointerByReference = new PointerByReference();
/* 58 */     int i = LIBC.getaddrinfo(str1, null, addrinfo1, pointerByReference);
/* 59 */     if (i > 0) {
/* 60 */       if (LOG.isErrorEnabled()) {
/* 61 */         LOG.warn("Failed getaddrinfo(): {}", LIBC.gai_strerror(i));
/*    */       }
/* 63 */       return "";
/*    */     } 
/* 65 */     CLibrary.Addrinfo addrinfo2 = new CLibrary.Addrinfo(pointerByReference.getValue());
/* 66 */     String str2 = addrinfo2.ai_canonname.trim();
/* 67 */     LIBC.freeaddrinfo(pointerByReference.getValue());
/* 68 */     return str2;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHostName() {
/* 73 */     byte[] arrayOfByte = new byte[256];
/* 74 */     if (0 != LIBC.gethostname(arrayOfByte, arrayOfByte.length)) {
/* 75 */       return super.getHostName();
/*    */     }
/* 77 */     return Native.toString(arrayOfByte);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIpv4DefaultGateway() {
/* 82 */     return searchGateway(ExecutingCommand.runNative("route -4 get default"));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIpv6DefaultGateway() {
/* 87 */     return searchGateway(ExecutingCommand.runNative("route -6 get default"));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\freebsd\FreeBsdNetworkParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */