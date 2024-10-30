/*     */ package oshi.software.os.linux;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.linux.LibC;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.linux.LinuxLibc;
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
/*     */ final class LinuxNetworkParams
/*     */   extends AbstractNetworkParams
/*     */ {
/*  53 */   private static final Logger LOG = LoggerFactory.getLogger(LinuxNetworkParams.class);
/*     */   
/*  55 */   private static final LinuxLibc LIBC = LinuxLibc.INSTANCE;
/*     */   
/*     */   private static final String IPV4_DEFAULT_DEST = "0.0.0.0";
/*     */   
/*     */   private static final String IPV6_DEFAULT_DEST = "::/0";
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
/*  72 */     int i = LIBC.getaddrinfo(str1, null, addrinfo1, pointerByReference);
/*  73 */     if (i > 0) {
/*  74 */       if (LOG.isErrorEnabled()) {
/*  75 */         LOG.error("Failed getaddrinfo(): {}", LIBC.gai_strerror(i));
/*     */       }
/*  77 */       return "";
/*     */     } 
/*  79 */     CLibrary.Addrinfo addrinfo2 = new CLibrary.Addrinfo(pointerByReference.getValue());
/*  80 */     String str2 = addrinfo2.ai_canonname.trim();
/*  81 */     LIBC.freeaddrinfo(pointerByReference.getValue());
/*  82 */     return str2;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHostName() {
/*  87 */     byte[] arrayOfByte = new byte[256];
/*  88 */     if (0 != LibC.INSTANCE.gethostname(arrayOfByte, arrayOfByte.length)) {
/*  89 */       return super.getHostName();
/*     */     }
/*  91 */     return Native.toString(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIpv4DefaultGateway() {
/*  96 */     List<CharSequence> list = ExecutingCommand.runNative("route -A inet -n");
/*  97 */     if (list.size() <= 2) {
/*  98 */       return "";
/*     */     }
/*     */     
/* 101 */     String str = "";
/* 102 */     int i = Integer.MAX_VALUE;
/*     */     
/* 104 */     for (byte b = 2; b < list.size(); b++) {
/* 105 */       String[] arrayOfString = ParseUtil.whitespaces.split(list.get(b));
/* 106 */       if (arrayOfString.length > 4 && arrayOfString[0].equals("0.0.0.0")) {
/* 107 */         boolean bool = (arrayOfString[3].indexOf('G') != -1) ? true : false;
/* 108 */         int j = ParseUtil.parseIntOrDefault(arrayOfString[4], 2147483647);
/* 109 */         if (bool && j < i) {
/* 110 */           i = j;
/* 111 */           str = arrayOfString[1];
/*     */         } 
/*     */       } 
/*     */     } 
/* 115 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIpv6DefaultGateway() {
/* 120 */     List<CharSequence> list = ExecutingCommand.runNative("route -A inet6 -n");
/* 121 */     if (list.size() <= 2) {
/* 122 */       return "";
/*     */     }
/*     */     
/* 125 */     String str = "";
/* 126 */     int i = Integer.MAX_VALUE;
/*     */     
/* 128 */     for (byte b = 2; b < list.size(); b++) {
/* 129 */       String[] arrayOfString = ParseUtil.whitespaces.split(list.get(b));
/* 130 */       if (arrayOfString.length > 3 && arrayOfString[0].equals("::/0")) {
/* 131 */         boolean bool = (arrayOfString[2].indexOf('G') != -1) ? true : false;
/* 132 */         int j = ParseUtil.parseIntOrDefault(arrayOfString[3], 2147483647);
/* 133 */         if (bool && j < i) {
/* 134 */           i = j;
/* 135 */           str = arrayOfString[1];
/*     */         } 
/*     */       } 
/*     */     } 
/* 139 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\linux\LinuxNetworkParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */