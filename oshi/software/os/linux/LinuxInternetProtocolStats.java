/*     */ package oshi.software.os.linux;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.linux.proc.ProcessStat;
/*     */ import oshi.driver.unix.NetStat;
/*     */ import oshi.software.common.AbstractInternetProtocolStats;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public class LinuxInternetProtocolStats
/*     */   extends AbstractInternetProtocolStats
/*     */ {
/*     */   public InternetProtocolStats.TcpStats getTCPv4Stats() {
/*  60 */     return NetStat.queryTcpStats("netstat -st4");
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv4Stats() {
/*  65 */     return NetStat.queryUdpStats("netstat -su4");
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv6Stats() {
/*  70 */     return NetStat.queryUdpStats("netstat -su6");
/*     */   }
/*     */ 
/*     */   
/*     */   public List<InternetProtocolStats.IPConnection> getConnections() {
/*  75 */     ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/*  76 */     Map<Integer, Integer> map = ProcessStat.querySocketToPidMap();
/*  77 */     arrayList.addAll(queryConnections("tcp", 4, map));
/*  78 */     arrayList.addAll(queryConnections("tcp", 6, map));
/*  79 */     arrayList.addAll(queryConnections("udp", 4, map));
/*  80 */     arrayList.addAll(queryConnections("udp", 6, map));
/*  81 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static List<InternetProtocolStats.IPConnection> queryConnections(String paramString, int paramInt, Map<Integer, Integer> paramMap) {
/*  85 */     ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/*  86 */     for (String str : FileUtil.readFile(ProcPath.NET + "/" + paramString + ((paramInt == 6) ? "6" : ""))) {
/*  87 */       if (str.indexOf(':') >= 0) {
/*  88 */         String[] arrayOfString = ParseUtil.whitespaces.split(str.trim());
/*  89 */         if (arrayOfString.length > 9) {
/*  90 */           Pair<byte[], Integer> pair1 = parseIpAddr(arrayOfString[1]);
/*  91 */           Pair<byte[], Integer> pair2 = parseIpAddr(arrayOfString[2]);
/*  92 */           InternetProtocolStats.TcpState tcpState = stateLookup(ParseUtil.hexStringToInt(arrayOfString[3], 0));
/*  93 */           Pair<Integer, Integer> pair = parseHexColonHex(arrayOfString[4]);
/*  94 */           int i = ParseUtil.parseIntOrDefault(arrayOfString[9], 0);
/*  95 */           arrayList.add(new InternetProtocolStats.IPConnection(paramString + paramInt, (byte[])pair1.getA(), ((Integer)pair1.getB()).intValue(), (byte[])pair2.getA(), ((Integer)pair2.getB()).intValue(), tcpState, ((Integer)pair
/*  96 */                 .getA()).intValue(), ((Integer)pair.getB()).intValue(), ((Integer)paramMap.getOrDefault(Integer.valueOf(i), Integer.valueOf(-1))).intValue()));
/*     */         } 
/*     */       } 
/*     */     } 
/* 100 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static Pair<byte[], Integer> parseIpAddr(String paramString) {
/* 104 */     int i = paramString.indexOf(':');
/* 105 */     if (i > 0 && i < paramString.length()) {
/* 106 */       byte[] arrayOfByte = ParseUtil.hexStringToByteArray(paramString.substring(0, i));
/*     */       int j;
/* 108 */       for (j = 0; j + 3 < arrayOfByte.length; j += 4) {
/* 109 */         byte b = arrayOfByte[j];
/* 110 */         arrayOfByte[j] = arrayOfByte[j + 3];
/* 111 */         arrayOfByte[j + 3] = b;
/* 112 */         b = arrayOfByte[j + 1];
/* 113 */         arrayOfByte[j + 1] = arrayOfByte[j + 2];
/* 114 */         arrayOfByte[j + 2] = b;
/*     */       } 
/* 116 */       j = ParseUtil.hexStringToInt(paramString.substring(i + 1), 0);
/* 117 */       return new Pair(arrayOfByte, Integer.valueOf(j));
/*     */     } 
/* 119 */     return new Pair(new byte[0], Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   private static Pair<Integer, Integer> parseHexColonHex(String paramString) {
/* 123 */     int i = paramString.indexOf(':');
/* 124 */     if (i > 0 && i < paramString.length()) {
/* 125 */       int j = ParseUtil.hexStringToInt(paramString.substring(0, i), 0);
/* 126 */       int k = ParseUtil.hexStringToInt(paramString.substring(i + 1), 0);
/* 127 */       return new Pair(Integer.valueOf(j), Integer.valueOf(k));
/*     */     } 
/* 129 */     return new Pair(Integer.valueOf(0), Integer.valueOf(0));
/*     */   }
/*     */   
/*     */   private static InternetProtocolStats.TcpState stateLookup(int paramInt) {
/* 133 */     switch (paramInt) {
/*     */       case 1:
/* 135 */         return InternetProtocolStats.TcpState.ESTABLISHED;
/*     */       case 2:
/* 137 */         return InternetProtocolStats.TcpState.SYN_SENT;
/*     */       case 3:
/* 139 */         return InternetProtocolStats.TcpState.SYN_RECV;
/*     */       case 4:
/* 141 */         return InternetProtocolStats.TcpState.FIN_WAIT_1;
/*     */       case 5:
/* 143 */         return InternetProtocolStats.TcpState.FIN_WAIT_2;
/*     */       case 6:
/* 145 */         return InternetProtocolStats.TcpState.TIME_WAIT;
/*     */       case 7:
/* 147 */         return InternetProtocolStats.TcpState.CLOSED;
/*     */       case 8:
/* 149 */         return InternetProtocolStats.TcpState.CLOSE_WAIT;
/*     */       case 9:
/* 151 */         return InternetProtocolStats.TcpState.LAST_ACK;
/*     */       case 10:
/* 153 */         return InternetProtocolStats.TcpState.LISTEN;
/*     */       case 11:
/* 155 */         return InternetProtocolStats.TcpState.CLOSING;
/*     */     } 
/*     */     
/* 158 */     return InternetProtocolStats.TcpState.UNKNOWN;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\linux\LinuxInternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */