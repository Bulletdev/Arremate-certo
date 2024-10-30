/*     */ package oshi.software.os.unix.freebsd;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.NetStat;
/*     */ import oshi.jna.platform.unix.CLibrary;
/*     */ import oshi.software.common.AbstractInternetProtocolStats;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
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
/*     */ @ThreadSafe
/*     */ public class FreeBsdInternetProtocolStats
/*     */   extends AbstractInternetProtocolStats
/*     */ {
/*  48 */   private Supplier<Pair<Long, Long>> establishedv4v6 = Memoizer.memoize(NetStat::queryTcpnetstat, Memoizer.defaultExpiration());
/*  49 */   private Supplier<CLibrary.BsdTcpstat> tcpstat = Memoizer.memoize(FreeBsdInternetProtocolStats::queryTcpstat, Memoizer.defaultExpiration());
/*  50 */   private Supplier<CLibrary.BsdUdpstat> udpstat = Memoizer.memoize(FreeBsdInternetProtocolStats::queryUdpstat, Memoizer.defaultExpiration());
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.TcpStats getTCPv4Stats() {
/*  54 */     CLibrary.BsdTcpstat bsdTcpstat = this.tcpstat.get();
/*  55 */     return new InternetProtocolStats.TcpStats(((Long)((Pair)this.establishedv4v6.get()).getA()).longValue(), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_connattempt), 
/*  56 */         ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_accepts), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_conndrops), 
/*  57 */         ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_drops), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_sndpack), 
/*  58 */         ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_rcvpack), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_sndrexmitpack), 
/*  59 */         ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_rcvbadsum + bsdTcpstat.tcps_rcvbadoff + bsdTcpstat.tcps_rcvmemdrop + bsdTcpstat.tcps_rcvshort), 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv4Stats() {
/*  66 */     CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
/*  67 */     return new InternetProtocolStats.UdpStats(ParseUtil.unsignedIntToLong(bsdUdpstat.udps_opackets), 
/*  68 */         ParseUtil.unsignedIntToLong(bsdUdpstat.udps_ipackets), ParseUtil.unsignedIntToLong(bsdUdpstat.udps_noportmcast), 
/*  69 */         ParseUtil.unsignedIntToLong(bsdUdpstat.udps_hdrops + bsdUdpstat.udps_badsum + bsdUdpstat.udps_badlen));
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv6Stats() {
/*  74 */     CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
/*  75 */     return new InternetProtocolStats.UdpStats(ParseUtil.unsignedIntToLong(bsdUdpstat.udps_snd6_swcsum), 
/*  76 */         ParseUtil.unsignedIntToLong(bsdUdpstat.udps_rcv6_swcsum), 0L, 0L);
/*     */   }
/*     */   
/*     */   private static CLibrary.BsdTcpstat queryTcpstat() {
/*  80 */     CLibrary.BsdTcpstat bsdTcpstat = new CLibrary.BsdTcpstat();
/*  81 */     Memory memory = BsdSysctlUtil.sysctl("net.inet.tcp.stats");
/*  82 */     if (memory != null && memory.size() >= 128L) {
/*  83 */       bsdTcpstat.tcps_connattempt = memory.getInt(0L);
/*  84 */       bsdTcpstat.tcps_accepts = memory.getInt(4L);
/*  85 */       bsdTcpstat.tcps_drops = memory.getInt(12L);
/*  86 */       bsdTcpstat.tcps_conndrops = memory.getInt(16L);
/*  87 */       bsdTcpstat.tcps_sndpack = memory.getInt(64L);
/*  88 */       bsdTcpstat.tcps_sndrexmitpack = memory.getInt(72L);
/*  89 */       bsdTcpstat.tcps_rcvpack = memory.getInt(104L);
/*  90 */       bsdTcpstat.tcps_rcvbadsum = memory.getInt(112L);
/*  91 */       bsdTcpstat.tcps_rcvbadoff = memory.getInt(116L);
/*  92 */       bsdTcpstat.tcps_rcvmemdrop = memory.getInt(120L);
/*  93 */       bsdTcpstat.tcps_rcvshort = memory.getInt(124L);
/*     */     } 
/*  95 */     return bsdTcpstat;
/*     */   }
/*     */   
/*     */   private static CLibrary.BsdUdpstat queryUdpstat() {
/*  99 */     CLibrary.BsdUdpstat bsdUdpstat = new CLibrary.BsdUdpstat();
/* 100 */     Memory memory = BsdSysctlUtil.sysctl("net.inet.udp.stats");
/* 101 */     if (memory != null && memory.size() >= 1644L) {
/* 102 */       bsdUdpstat.udps_ipackets = memory.getInt(0L);
/* 103 */       bsdUdpstat.udps_hdrops = memory.getInt(4L);
/* 104 */       bsdUdpstat.udps_badsum = memory.getInt(8L);
/* 105 */       bsdUdpstat.udps_badlen = memory.getInt(12L);
/* 106 */       bsdUdpstat.udps_opackets = memory.getInt(36L);
/* 107 */       bsdUdpstat.udps_noportmcast = memory.getInt(48L);
/* 108 */       bsdUdpstat.udps_rcv6_swcsum = memory.getInt(64L);
/* 109 */       bsdUdpstat.udps_snd6_swcsum = memory.getInt(80L);
/*     */     } 
/* 111 */     return bsdUdpstat;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\freebsd\FreeBsdInternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */