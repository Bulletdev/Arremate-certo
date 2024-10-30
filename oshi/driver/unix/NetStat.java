/*     */ package oshi.driver.unix;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
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
/*     */ @ThreadSafe
/*     */ public final class NetStat
/*     */ {
/*     */   public static Pair<Long, Long> queryTcpnetstat() {
/*  55 */     long l1 = 0L;
/*  56 */     long l2 = 0L;
/*  57 */     List list = ExecutingCommand.runNative("netstat -n -p tcp");
/*  58 */     for (String str : list) {
/*  59 */       if (str.endsWith("ESTABLISHED")) {
/*  60 */         if (str.startsWith("tcp4")) {
/*  61 */           l1++; continue;
/*  62 */         }  if (str.startsWith("tcp6")) {
/*  63 */           l2++;
/*     */         }
/*     */       } 
/*     */     } 
/*  67 */     return new Pair(Long.valueOf(l1), Long.valueOf(l2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<InternetProtocolStats.IPConnection> queryNetstat() {
/*  76 */     ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/*  77 */     List list = ExecutingCommand.runNative("netstat -n");
/*  78 */     for (String str : list) {
/*  79 */       String[] arrayOfString = null;
/*  80 */       if (str.startsWith("tcp") || str.startsWith("udp")) {
/*  81 */         arrayOfString = ParseUtil.whitespaces.split(str);
/*  82 */         if (arrayOfString.length >= 5) {
/*  83 */           String str1 = (arrayOfString.length == 6) ? arrayOfString[5] : null;
/*  84 */           String str2 = arrayOfString[0];
/*  85 */           Pair<byte[], Integer> pair1 = parseIP(arrayOfString[3]);
/*  86 */           Pair<byte[], Integer> pair2 = parseIP(arrayOfString[4]);
/*  87 */           arrayList.add(new InternetProtocolStats.IPConnection(str2, (byte[])pair1.getA(), ((Integer)pair1.getB()).intValue(), (byte[])pair2.getA(), ((Integer)pair2.getB()).intValue(), 
/*  88 */                 (str1 == null) ? InternetProtocolStats.TcpState.NONE : InternetProtocolStats.TcpState.valueOf(str1), 
/*  89 */                 ParseUtil.parseIntOrDefault(arrayOfString[2], 0), ParseUtil.parseIntOrDefault(arrayOfString[1], 0), -1));
/*     */         } 
/*     */       } 
/*     */     } 
/*  93 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Pair<byte[], Integer> parseIP(String paramString) {
/* 100 */     int i = paramString.lastIndexOf('.');
/* 101 */     if (i > 0 && paramString.length() > i) {
/* 102 */       int j = ParseUtil.parseIntOrDefault(paramString.substring(i + 1), 0);
/* 103 */       String str = paramString.substring(0, i);
/*     */       
/*     */       try {
/* 106 */         return new Pair(InetAddress.getByName(str).getAddress(), Integer.valueOf(j));
/* 107 */       } catch (UnknownHostException unknownHostException) {
/*     */         
/*     */         try {
/* 110 */           if (str.endsWith(":") && str.contains("::")) {
/* 111 */             str = str + "0";
/* 112 */           } else if (str.endsWith(":") || str.contains("::")) {
/* 113 */             str = str + ":0";
/*     */           } else {
/* 115 */             str = str + "::0";
/*     */           } 
/* 117 */           return new Pair(InetAddress.getByName(str).getAddress(), Integer.valueOf(j));
/* 118 */         } catch (UnknownHostException unknownHostException1) {
/* 119 */           return new Pair(new byte[0], Integer.valueOf(j));
/*     */         } 
/*     */       } 
/*     */     } 
/* 123 */     return new Pair(new byte[0], Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static InternetProtocolStats.TcpStats queryTcpStats(String paramString) {
/* 134 */     long l1 = 0L;
/* 135 */     long l2 = 0L;
/* 136 */     long l3 = 0L;
/* 137 */     long l4 = 0L;
/* 138 */     long l5 = 0L;
/* 139 */     long l6 = 0L;
/* 140 */     long l7 = 0L;
/* 141 */     long l8 = 0L;
/* 142 */     long l9 = 0L;
/* 143 */     long l10 = 0L;
/* 144 */     List list = ExecutingCommand.runNative(paramString);
/* 145 */     for (String str : list) {
/* 146 */       String[] arrayOfString = str.trim().split(" ", 2);
/* 147 */       if (arrayOfString.length == 2) {
/* 148 */         switch (arrayOfString[1]) {
/*     */           case "connections established":
/*     */           case "connection established (including accepts)":
/*     */           case "connections established (including accepts)":
/* 152 */             l1 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "active connection openings":
/* 155 */             l2 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "passive connection openings":
/* 158 */             l3 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "failed connection attempts":
/*     */           case "bad connection attempts":
/* 162 */             l4 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "connection resets received":
/*     */           case "dropped due to RST":
/* 166 */             l5 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "segments sent out":
/*     */           case "packet sent":
/*     */           case "packets sent":
/* 171 */             l6 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "segments received":
/*     */           case "packet received":
/*     */           case "packets received":
/* 176 */             l7 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "segments retransmitted":
/* 179 */             l8 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "bad segments received":
/*     */           case "discarded for bad checksum":
/*     */           case "discarded for bad checksums":
/*     */           case "discarded for bad header offset field":
/*     */           case "discarded for bad header offset fields":
/*     */           case "discarded because packet too short":
/*     */           case "discarded for missing IPsec protection":
/* 188 */             l9 += ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */           case "resets sent":
/* 191 */             l10 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */             continue;
/*     */         } 
/*     */         
/* 195 */         if (arrayOfString[1].contains("retransmitted") && arrayOfString[1].contains("data packet")) {
/* 196 */           l8 += ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     return new InternetProtocolStats.TcpStats(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
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
/*     */   public static InternetProtocolStats.UdpStats queryUdpStats(String paramString) {
/* 216 */     long l1 = 0L;
/* 217 */     long l2 = 0L;
/* 218 */     long l3 = 0L;
/* 219 */     long l4 = 0L;
/* 220 */     List list = ExecutingCommand.runNative(paramString);
/* 221 */     for (String str : list) {
/* 222 */       String[] arrayOfString = str.trim().split(" ", 2);
/* 223 */       if (arrayOfString.length == 2) {
/* 224 */         switch (arrayOfString[1]) {
/*     */           case "packets sent":
/*     */           case "datagram output":
/*     */           case "datagrams output":
/* 228 */             l1 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */           
/*     */           case "packets received":
/*     */           case "datagram received":
/*     */           case "datagrams received":
/* 233 */             l2 = ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */           
/*     */           case "packets to unknown port received":
/*     */           case "dropped due to no socket":
/*     */           case "broadcast/multicast datagram dropped due to no socket":
/*     */           case "broadcast/multicast datagrams dropped due to no socket":
/* 239 */             l3 += ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */           
/*     */           case "packet receive errors":
/*     */           case "with incomplete header":
/*     */           case "with bad data length field":
/*     */           case "with bad checksum":
/*     */           case "woth no checksum":
/* 246 */             l4 += ParseUtil.parseLongOrDefault(arrayOfString[0], 0L);
/*     */         } 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */     } 
/* 253 */     return new InternetProtocolStats.UdpStats(l1, l2, l3, l4);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\NetStat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */