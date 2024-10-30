/*     */ package oshi.software.os.unix.solaris;
/*     */ 
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.common.AbstractInternetProtocolStats;
/*     */ import oshi.software.os.InternetProtocolStats;
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
/*     */ @ThreadSafe
/*     */ public class SolarisInternetProtocolStats
/*     */   extends AbstractInternetProtocolStats
/*     */ {
/*     */   public InternetProtocolStats.TcpStats getTCPv4Stats() {
/*  41 */     return getTcpStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv4Stats() {
/*  46 */     return getUdpStats();
/*     */   }
/*     */   
/*     */   private static InternetProtocolStats.TcpStats getTcpStats() {
/*  50 */     long l1 = 0L;
/*  51 */     long l2 = 0L;
/*  52 */     long l3 = 0L;
/*  53 */     long l4 = 0L;
/*  54 */     long l5 = 0L;
/*  55 */     long l6 = 0L;
/*  56 */     long l7 = 0L;
/*  57 */     long l8 = 0L;
/*  58 */     long l9 = 0L;
/*  59 */     long l10 = 0L;
/*  60 */     List list = ExecutingCommand.runNative("netstat -s -P tcp");
/*     */     
/*  62 */     list.addAll(ExecutingCommand.runNative("netstat -s -P ip"));
/*  63 */     for (String str : list) {
/*     */       
/*  65 */       String[] arrayOfString = splitOnPrefix(str, "tcp");
/*     */       
/*  67 */       for (String str1 : arrayOfString) {
/*  68 */         if (str1 != null) {
/*  69 */           String[] arrayOfString1 = str1.split("=");
/*  70 */           if (arrayOfString1.length == 2) {
/*  71 */             switch (arrayOfString1[0].trim()) {
/*     */               case "tcpCurrEstab":
/*  73 */                 l1 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "tcpActiveOpens":
/*  76 */                 l2 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "tcpPassiveOpens":
/*  79 */                 l3 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "tcpAttemptFails":
/*  82 */                 l4 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "tcpEstabResets":
/*  85 */                 l5 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "tcpOutSegs":
/*  88 */                 l6 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "tcpInSegs":
/*  91 */                 l7 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "tcpRetransSegs":
/*  94 */                 l8 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               
/*     */               case "tcpInErr":
/*  98 */                 l9 = ParseUtil.getFirstIntValue(arrayOfString1[1].trim());
/*     */                 break;
/*     */               case "tcpOutRsts":
/* 101 */                 l10 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */             } 
/*     */ 
/*     */           
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 110 */     return new InternetProtocolStats.TcpStats(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
/*     */   }
/*     */ 
/*     */   
/*     */   private static InternetProtocolStats.UdpStats getUdpStats() {
/* 115 */     long l1 = 0L;
/* 116 */     long l2 = 0L;
/* 117 */     long l3 = 0L;
/* 118 */     long l4 = 0L;
/* 119 */     List list = ExecutingCommand.runNative("netstat -s -P udp");
/*     */     
/* 121 */     list.addAll(ExecutingCommand.runNative("netstat -s -P ip"));
/* 122 */     for (String str : list) {
/*     */       
/* 124 */       String[] arrayOfString = splitOnPrefix(str, "udp");
/*     */       
/* 126 */       for (String str1 : arrayOfString) {
/* 127 */         if (str1 != null) {
/* 128 */           String[] arrayOfString1 = str1.split("=");
/* 129 */           if (arrayOfString1.length == 2) {
/* 130 */             switch (arrayOfString1[0].trim()) {
/*     */               case "udpOutDatagrams":
/* 132 */                 l1 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "udpInDatagrams":
/* 135 */                 l2 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "udpNoPorts":
/* 138 */                 l3 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */               case "udpInErrors":
/* 141 */                 l4 = ParseUtil.parseLongOrDefault(arrayOfString1[1].trim(), 0L);
/*     */                 break;
/*     */             } 
/*     */ 
/*     */           
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 150 */     return new InternetProtocolStats.UdpStats(l1, l2, l3, l4);
/*     */   }
/*     */   
/*     */   private static String[] splitOnPrefix(String paramString1, String paramString2) {
/* 154 */     String[] arrayOfString = new String[2];
/* 155 */     int i = paramString1.indexOf(paramString2);
/* 156 */     if (i >= 0) {
/* 157 */       int j = paramString1.indexOf(paramString2, i + 1);
/* 158 */       if (j >= 0) {
/* 159 */         arrayOfString[0] = paramString1.substring(i, j).trim();
/* 160 */         arrayOfString[1] = paramString1.substring(j).trim();
/*     */       } else {
/* 162 */         arrayOfString[0] = paramString1.substring(i).trim();
/*     */       } 
/*     */     } 
/* 165 */     return arrayOfString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\solaris\SolarisInternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */