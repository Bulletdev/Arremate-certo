/*     */ package oshi.software.common;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.os.NetworkParams;
/*     */ import oshi.util.FileUtil;
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
/*     */ @ThreadSafe
/*     */ public abstract class AbstractNetworkParams
/*     */   implements NetworkParams
/*     */ {
/*  46 */   private static final Logger LOG = LoggerFactory.getLogger(AbstractNetworkParams.class);
/*     */   
/*     */   private static final String NAMESERVER = "nameserver";
/*     */   
/*     */   public String getDomainName() {
/*     */     try {
/*  52 */       return InetAddress.getLocalHost().getCanonicalHostName();
/*  53 */     } catch (UnknownHostException unknownHostException) {
/*  54 */       LOG.error("Unknown host exception when getting address of local host: {}", unknownHostException.getMessage());
/*  55 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHostName() {
/*     */     try {
/*  62 */       String str = InetAddress.getLocalHost().getHostName();
/*  63 */       int i = str.indexOf('.');
/*  64 */       if (i == -1) {
/*  65 */         return str;
/*     */       }
/*  67 */       return str.substring(0, i);
/*     */     }
/*  69 */     catch (UnknownHostException unknownHostException) {
/*  70 */       LOG.error("Unknown host exception when getting address of local host: {}", unknownHostException.getMessage());
/*  71 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getDnsServers() {
/*  77 */     List<String> list = FileUtil.readFile("/etc/resolv.conf");
/*  78 */     String str = "nameserver";
/*  79 */     byte b1 = 3;
/*  80 */     ArrayList<String> arrayList = new ArrayList();
/*  81 */     for (byte b2 = 0; b2 < list.size() && arrayList.size() < b1; b2++) {
/*  82 */       String str1 = list.get(b2);
/*  83 */       if (str1.startsWith(str)) {
/*  84 */         String str2 = str1.substring(str.length()).replaceFirst("^[ \t]+", "");
/*  85 */         if (str2.length() != 0 && str2.charAt(0) != '#' && str2.charAt(0) != ';') {
/*  86 */           String str3 = str2.split("[ \t#;]", 2)[0];
/*  87 */           arrayList.add(str3);
/*     */         } 
/*     */       } 
/*     */     } 
/*  91 */     return arrayList.<String>toArray(new String[0]);
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
/*     */   protected static String searchGateway(List<String> paramList) {
/* 103 */     for (String str1 : paramList) {
/* 104 */       String str2 = str1.replaceFirst("^\\s+", "");
/* 105 */       if (str2.startsWith("gateway:")) {
/* 106 */         String[] arrayOfString = ParseUtil.whitespaces.split(str2);
/* 107 */         if (arrayOfString.length < 2) {
/* 108 */           return "";
/*     */         }
/* 110 */         return arrayOfString[1].split("%")[0];
/*     */       } 
/*     */     } 
/* 113 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 118 */     return String.format("Host name: %s, Domain name: %s, DNS servers: %s, IPv4 Gateway: %s, IPv6 Gateway: %s", new Object[] {
/* 119 */           getHostName(), getDomainName(), Arrays.toString((Object[])getDnsServers()), 
/* 120 */           getIpv4DefaultGateway(), getIpv6DefaultGateway()
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\common\AbstractNetworkParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */