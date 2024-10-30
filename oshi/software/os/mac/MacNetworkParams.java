/*     */ package oshi.software.os.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.mac.SystemB;
/*     */ import oshi.jna.platform.unix.CLibrary;
/*     */ import oshi.software.common.AbstractNetworkParams;
/*     */ import oshi.util.ExecutingCommand;
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
/*     */ @ThreadSafe
/*     */ final class MacNetworkParams
/*     */   extends AbstractNetworkParams
/*     */ {
/*  52 */   private static final Logger LOG = LoggerFactory.getLogger(MacNetworkParams.class);
/*     */   
/*  54 */   private static final SystemB SYS = SystemB.INSTANCE;
/*     */   
/*     */   private static final String IPV6_ROUTE_HEADER = "Internet6:";
/*     */   
/*     */   private static final String DEFAULT_GATEWAY = "default";
/*     */ 
/*     */   
/*     */   public String getDomainName() {
/*  62 */     CLibrary.Addrinfo addrinfo1 = new CLibrary.Addrinfo();
/*  63 */     addrinfo1.ai_flags = 2;
/*  64 */     String str1 = "";
/*     */     try {
/*  66 */       str1 = InetAddress.getLocalHost().getHostName();
/*  67 */     } catch (UnknownHostException unknownHostException) {
/*  68 */       LOG.error("Unknown host exception when getting address of local host: {}", unknownHostException.getMessage());
/*  69 */       return "";
/*     */     } 
/*  71 */     PointerByReference pointerByReference = new PointerByReference();
/*  72 */     int i = SYS.getaddrinfo(str1, null, addrinfo1, pointerByReference);
/*  73 */     if (i > 0) {
/*  74 */       if (LOG.isErrorEnabled()) {
/*  75 */         LOG.error("Failed getaddrinfo(): {}", SYS.gai_strerror(i));
/*     */       }
/*  77 */       return "";
/*     */     } 
/*  79 */     CLibrary.Addrinfo addrinfo2 = new CLibrary.Addrinfo(pointerByReference.getValue());
/*  80 */     String str2 = addrinfo2.ai_canonname.trim();
/*  81 */     SYS.freeaddrinfo(pointerByReference.getValue());
/*  82 */     return str2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHostName() {
/*  87 */     byte[] arrayOfByte = new byte[256];
/*  88 */     if (0 != SYS.gethostname(arrayOfByte, arrayOfByte.length)) {
/*  89 */       return super.getHostName();
/*     */     }
/*  91 */     return Native.toString(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIpv4DefaultGateway() {
/*  96 */     return searchGateway(ExecutingCommand.runNative("route -n get default"));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIpv6DefaultGateway() {
/* 101 */     List list = ExecutingCommand.runNative("netstat -nr");
/* 102 */     boolean bool = false;
/* 103 */     for (String str : list) {
/* 104 */       if (bool && str.startsWith("default")) {
/* 105 */         String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 106 */         if (arrayOfString.length > 2 && arrayOfString[2].contains("G"))
/* 107 */           return arrayOfString[1].split("%")[0];  continue;
/*     */       } 
/* 109 */       if (str.startsWith("Internet6:")) {
/* 110 */         bool = true;
/*     */       }
/*     */     } 
/* 113 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\mac\MacNetworkParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */