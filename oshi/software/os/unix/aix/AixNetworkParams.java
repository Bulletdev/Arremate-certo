/*    */ package oshi.software.os.unix.aix;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.jna.platform.unix.aix.AixLibc;
/*    */ import oshi.software.common.AbstractNetworkParams;
/*    */ import oshi.util.ExecutingCommand;
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
/*    */ @ThreadSafe
/*    */ final class AixNetworkParams
/*    */   extends AbstractNetworkParams
/*    */ {
/* 43 */   private static final AixLibc LIBC = AixLibc.INSTANCE;
/*    */ 
/*    */   
/*    */   public String getHostName() {
/* 47 */     byte[] arrayOfByte = new byte[256];
/* 48 */     if (0 != LIBC.gethostname(arrayOfByte, arrayOfByte.length)) {
/* 49 */       return super.getHostName();
/*    */     }
/* 51 */     return Native.toString(arrayOfByte);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIpv4DefaultGateway() {
/* 56 */     return getDefaultGateway("netstat -rnf inet");
/*    */   }
/*    */ 
/*    */   
/*    */   public String getIpv6DefaultGateway() {
/* 61 */     return getDefaultGateway("netstat -rnf inet6");
/*    */   }
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
/*    */   private static String getDefaultGateway(String paramString) {
/* 78 */     for (String str : ExecutingCommand.runNative(paramString)) {
/* 79 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 80 */       if (arrayOfString.length > 7 && "default".equals(arrayOfString[0])) {
/* 81 */         return arrayOfString[1];
/*    */       }
/*    */     } 
/* 84 */     return "unknown";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\aix\AixNetworkParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */