/*     */ package oshi.software.os.windows;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.IPHlpAPI;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.Kernel32Util;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
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
/*     */ @ThreadSafe
/*     */ final class WindowsNetworkParams
/*     */   extends AbstractNetworkParams
/*     */ {
/*  54 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsNetworkParams.class);
/*     */   
/*     */   private static final int COMPUTER_NAME_DNS_DOMAIN_FULLY_QUALIFIED = 3;
/*     */ 
/*     */   
/*     */   public String getDomainName() {
/*  60 */     char[] arrayOfChar = new char[256];
/*  61 */     IntByReference intByReference = new IntByReference(arrayOfChar.length);
/*  62 */     if (!Kernel32.INSTANCE.GetComputerNameEx(3, arrayOfChar, intByReference)) {
/*  63 */       LOG.error("Failed to get dns domain name. Error code: {}", Integer.valueOf(Kernel32.INSTANCE.GetLastError()));
/*  64 */       return "";
/*     */     } 
/*  66 */     return Native.toString(arrayOfChar);
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getDnsServers() {
/*  71 */     IntByReference intByReference = new IntByReference();
/*  72 */     int i = IPHlpAPI.INSTANCE.GetNetworkParams(null, intByReference);
/*  73 */     if (i != 111) {
/*  74 */       LOG.error("Failed to get network parameters buffer size. Error code: {}", Integer.valueOf(i));
/*  75 */       return new String[0];
/*     */     } 
/*     */     
/*  78 */     Memory memory = new Memory(intByReference.getValue());
/*  79 */     i = IPHlpAPI.INSTANCE.GetNetworkParams((Pointer)memory, intByReference);
/*  80 */     if (i != 0) {
/*  81 */       LOG.error("Failed to get network parameters. Error code: {}", Integer.valueOf(i));
/*  82 */       return new String[0];
/*     */     } 
/*  84 */     IPHlpAPI.FIXED_INFO fIXED_INFO = new IPHlpAPI.FIXED_INFO((Pointer)memory);
/*     */     
/*  86 */     ArrayList<String> arrayList = new ArrayList();
/*  87 */     IPHlpAPI.IP_ADDR_STRING iP_ADDR_STRING = fIXED_INFO.DnsServerList;
/*  88 */     while (iP_ADDR_STRING != null) {
/*     */ 
/*     */       
/*  91 */       String str = Native.toString(iP_ADDR_STRING.IpAddress.String, StandardCharsets.US_ASCII);
/*  92 */       int j = str.indexOf(false);
/*  93 */       if (j != -1) {
/*  94 */         str = str.substring(0, j);
/*     */       }
/*  96 */       arrayList.add(str);
/*  97 */       IPHlpAPI.IP_ADDR_STRING.ByReference byReference = iP_ADDR_STRING.Next;
/*     */     } 
/*  99 */     return arrayList.<String>toArray(new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHostName() {
/* 104 */     return Kernel32Util.getComputerName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIpv4DefaultGateway() {
/* 109 */     return parseIpv4Route();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIpv6DefaultGateway() {
/* 114 */     return parseIpv6Route();
/*     */   }
/*     */   
/*     */   private static String parseIpv4Route() {
/* 118 */     List list = ExecutingCommand.runNative("route print -4 0.0.0.0");
/* 119 */     for (String str : list) {
/* 120 */       String[] arrayOfString = ParseUtil.whitespaces.split(str.trim());
/* 121 */       if (arrayOfString.length > 2 && "0.0.0.0".equals(arrayOfString[0])) {
/* 122 */         return arrayOfString[2];
/*     */       }
/*     */     } 
/* 125 */     return "";
/*     */   }
/*     */   
/*     */   private static String parseIpv6Route() {
/* 129 */     List list = ExecutingCommand.runNative("route print -6 ::/0");
/* 130 */     for (String str : list) {
/* 131 */       String[] arrayOfString = ParseUtil.whitespaces.split(str.trim());
/* 132 */       if (arrayOfString.length > 3 && "::/0".equals(arrayOfString[2])) {
/* 133 */         return arrayOfString[3];
/*     */       }
/*     */     } 
/* 136 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\windows\WindowsNetworkParams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */