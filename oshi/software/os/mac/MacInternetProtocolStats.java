/*     */ package oshi.software.os.mac;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.NetStat;
/*     */ import oshi.jna.platform.mac.SystemB;
/*     */ import oshi.jna.platform.unix.CLibrary;
/*     */ import oshi.software.common.AbstractInternetProtocolStats;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.mac.SysctlUtil;
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
/*     */ public class MacInternetProtocolStats
/*     */   extends AbstractInternetProtocolStats
/*     */ {
/*     */   private boolean isElevated;
/*     */   private Supplier<Pair<Long, Long>> establishedv4v6;
/*     */   private Supplier<CLibrary.BsdTcpstat> tcpstat;
/*     */   private Supplier<CLibrary.BsdUdpstat> udpstat;
/*     */   private Supplier<CLibrary.BsdIpstat> ipstat;
/*     */   private Supplier<CLibrary.BsdIp6stat> ip6stat;
/*     */   
/*     */   public MacInternetProtocolStats(boolean paramBoolean) {
/*  84 */     this.establishedv4v6 = Memoizer.memoize(NetStat::queryTcpnetstat, Memoizer.defaultExpiration());
/*  85 */     this.tcpstat = Memoizer.memoize(MacInternetProtocolStats::queryTcpstat, Memoizer.defaultExpiration());
/*  86 */     this.udpstat = Memoizer.memoize(MacInternetProtocolStats::queryUdpstat, Memoizer.defaultExpiration());
/*     */ 
/*     */     
/*  89 */     this.ipstat = Memoizer.memoize(MacInternetProtocolStats::queryIpstat, Memoizer.defaultExpiration());
/*  90 */     this.ip6stat = Memoizer.memoize(MacInternetProtocolStats::queryIp6stat, Memoizer.defaultExpiration());
/*     */     this.isElevated = paramBoolean;
/*     */   }
/*     */   public InternetProtocolStats.TcpStats getTCPv4Stats() {
/*  94 */     CLibrary.BsdTcpstat bsdTcpstat = this.tcpstat.get();
/*  95 */     if (this.isElevated) {
/*  96 */       return new InternetProtocolStats.TcpStats(((Long)((Pair)this.establishedv4v6.get()).getA()).longValue(), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_connattempt), 
/*  97 */           ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_accepts), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_conndrops), 
/*  98 */           ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_drops), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_sndpack), 
/*  99 */           ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_rcvpack), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_sndrexmitpack), 
/* 100 */           ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_rcvbadsum + bsdTcpstat.tcps_rcvbadoff + bsdTcpstat.tcps_rcvmemdrop + bsdTcpstat.tcps_rcvshort), 0L);
/*     */     }
/*     */ 
/*     */     
/* 104 */     CLibrary.BsdIpstat bsdIpstat = this.ipstat.get();
/* 105 */     CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
/* 106 */     return new InternetProtocolStats.TcpStats(((Long)((Pair)this.establishedv4v6.get()).getA()).longValue(), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_connattempt), 
/* 107 */         ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_accepts), ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_conndrops), 
/* 108 */         ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_drops), 
/* 109 */         Math.max(0L, ParseUtil.unsignedIntToLong(bsdIpstat.ips_delivered - bsdUdpstat.udps_opackets)), 
/* 110 */         Math.max(0L, ParseUtil.unsignedIntToLong(bsdIpstat.ips_total - bsdUdpstat.udps_ipackets)), 
/* 111 */         ParseUtil.unsignedIntToLong(bsdTcpstat.tcps_sndrexmitpack), 
/* 112 */         Math.max(0L, ParseUtil.unsignedIntToLong(bsdIpstat.ips_badsum + bsdIpstat.ips_tooshort + bsdIpstat.ips_toosmall + bsdIpstat.ips_badhlen + bsdIpstat.ips_badlen - bsdUdpstat.udps_hdrops + bsdUdpstat.udps_badsum + bsdUdpstat.udps_badlen)), 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.TcpStats getTCPv6Stats() {
/* 119 */     CLibrary.BsdIp6stat bsdIp6stat = this.ip6stat.get();
/* 120 */     CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
/* 121 */     return new InternetProtocolStats.TcpStats(((Long)((Pair)this.establishedv4v6.get()).getB()).longValue(), 0L, 0L, 0L, 0L, bsdIp6stat.ip6s_localout - 
/* 122 */         ParseUtil.unsignedIntToLong(bsdUdpstat.udps_snd6_swcsum), bsdIp6stat.ip6s_total - 
/* 123 */         ParseUtil.unsignedIntToLong(bsdUdpstat.udps_rcv6_swcsum), 0L, 0L, 0L);
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv4Stats() {
/* 128 */     CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
/* 129 */     return new InternetProtocolStats.UdpStats(ParseUtil.unsignedIntToLong(bsdUdpstat.udps_opackets), 
/* 130 */         ParseUtil.unsignedIntToLong(bsdUdpstat.udps_ipackets), ParseUtil.unsignedIntToLong(bsdUdpstat.udps_noportmcast), 
/* 131 */         ParseUtil.unsignedIntToLong(bsdUdpstat.udps_hdrops + bsdUdpstat.udps_badsum + bsdUdpstat.udps_badlen));
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv6Stats() {
/* 136 */     CLibrary.BsdUdpstat bsdUdpstat = this.udpstat.get();
/* 137 */     return new InternetProtocolStats.UdpStats(ParseUtil.unsignedIntToLong(bsdUdpstat.udps_snd6_swcsum), 
/* 138 */         ParseUtil.unsignedIntToLong(bsdUdpstat.udps_rcv6_swcsum), 0L, 0L);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<InternetProtocolStats.IPConnection> getConnections() {
/* 143 */     ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/* 144 */     int[] arrayOfInt = new int[1024];
/* 145 */     int i = SystemB.INSTANCE.proc_listpids(1, 0, arrayOfInt, arrayOfInt.length * SystemB.INT_SIZE) / SystemB.INT_SIZE;
/*     */     
/* 147 */     for (byte b = 0; b < i; b++) {
/*     */ 
/*     */       
/* 150 */       if (arrayOfInt[b] > 0) {
/* 151 */         for (Integer integer : queryFdList(arrayOfInt[b])) {
/* 152 */           InternetProtocolStats.IPConnection iPConnection = queryIPConnection(arrayOfInt[b], integer.intValue());
/* 153 */           if (iPConnection != null) {
/* 154 */             arrayList.add(iPConnection);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/* 159 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static List<Integer> queryFdList(int paramInt) {
/* 163 */     ArrayList<Integer> arrayList = new ArrayList();
/* 164 */     int i = SystemB.INSTANCE.proc_pidinfo(paramInt, 1, 0L, null, 0);
/* 165 */     if (i > 0) {
/* 166 */       SystemB.ProcFdInfo procFdInfo = new SystemB.ProcFdInfo();
/* 167 */       int j = i / procFdInfo.size();
/* 168 */       SystemB.ProcFdInfo[] arrayOfProcFdInfo = (SystemB.ProcFdInfo[])procFdInfo.toArray(j);
/* 169 */       i = SystemB.INSTANCE.proc_pidinfo(paramInt, 1, 0L, (Structure)arrayOfProcFdInfo[0], i);
/* 170 */       j = i / procFdInfo.size();
/* 171 */       for (byte b = 0; b < j; b++) {
/* 172 */         if ((arrayOfProcFdInfo[b]).proc_fdtype == 2) {
/* 173 */           arrayList.add(Integer.valueOf((arrayOfProcFdInfo[b]).proc_fd));
/*     */         }
/*     */       } 
/*     */     } 
/* 177 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static InternetProtocolStats.IPConnection queryIPConnection(int paramInt1, int paramInt2) {
/* 181 */     SystemB.SocketFdInfo socketFdInfo = new SystemB.SocketFdInfo();
/* 182 */     int i = SystemB.INSTANCE.proc_pidfdinfo(paramInt1, paramInt2, 3, (Structure)socketFdInfo, socketFdInfo.size());
/* 183 */     if ((socketFdInfo.size() == i && socketFdInfo.psi.soi_family == 2) || socketFdInfo.psi.soi_family == 30) {
/*     */       SystemB.InSockInfo inSockInfo; String str;
/*     */       InternetProtocolStats.TcpState tcpState;
/*     */       byte[] arrayOfByte1, arrayOfByte2;
/* 187 */       if (socketFdInfo.psi.soi_kind == 2) {
/* 188 */         socketFdInfo.psi.soi_proto.setType("pri_tcp");
/* 189 */         socketFdInfo.psi.soi_proto.read();
/* 190 */         inSockInfo = socketFdInfo.psi.soi_proto.pri_tcp.tcpsi_ini;
/* 191 */         tcpState = stateLookup(socketFdInfo.psi.soi_proto.pri_tcp.tcpsi_state);
/* 192 */         str = "tcp";
/* 193 */       } else if (socketFdInfo.psi.soi_kind == 1) {
/* 194 */         socketFdInfo.psi.soi_proto.setType("pri_in");
/* 195 */         socketFdInfo.psi.soi_proto.read();
/* 196 */         inSockInfo = socketFdInfo.psi.soi_proto.pri_in;
/* 197 */         tcpState = InternetProtocolStats.TcpState.NONE;
/* 198 */         str = "udp";
/*     */       } else {
/* 200 */         return null;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 205 */       if (inSockInfo.insi_vflag == 1) {
/* 206 */         arrayOfByte1 = ParseUtil.parseIntToIP(inSockInfo.insi_laddr[3]);
/* 207 */         arrayOfByte2 = ParseUtil.parseIntToIP(inSockInfo.insi_faddr[3]);
/* 208 */         str = str + "4";
/* 209 */       } else if (inSockInfo.insi_vflag == 2) {
/* 210 */         arrayOfByte1 = ParseUtil.parseIntArrayToIP(inSockInfo.insi_laddr);
/* 211 */         arrayOfByte2 = ParseUtil.parseIntArrayToIP(inSockInfo.insi_faddr);
/* 212 */         str = str + "6";
/*     */       } else {
/* 214 */         return null;
/*     */       } 
/* 216 */       int j = ParseUtil.bigEndian16ToLittleEndian(inSockInfo.insi_lport);
/* 217 */       int k = ParseUtil.bigEndian16ToLittleEndian(inSockInfo.insi_fport);
/* 218 */       return new InternetProtocolStats.IPConnection(str, arrayOfByte1, j, arrayOfByte2, k, tcpState, socketFdInfo.psi.soi_qlen, socketFdInfo.psi.soi_incqlen, paramInt1);
/*     */     } 
/* 220 */     return null;
/*     */   }
/*     */   
/*     */   private static InternetProtocolStats.TcpState stateLookup(int paramInt) {
/* 224 */     switch (paramInt) {
/*     */       case 0:
/* 226 */         return InternetProtocolStats.TcpState.CLOSED;
/*     */       case 1:
/* 228 */         return InternetProtocolStats.TcpState.LISTEN;
/*     */       case 2:
/* 230 */         return InternetProtocolStats.TcpState.SYN_SENT;
/*     */       case 3:
/* 232 */         return InternetProtocolStats.TcpState.SYN_RECV;
/*     */       case 4:
/* 234 */         return InternetProtocolStats.TcpState.ESTABLISHED;
/*     */       case 5:
/* 236 */         return InternetProtocolStats.TcpState.CLOSE_WAIT;
/*     */       case 6:
/* 238 */         return InternetProtocolStats.TcpState.FIN_WAIT_1;
/*     */       case 7:
/* 240 */         return InternetProtocolStats.TcpState.CLOSING;
/*     */       case 8:
/* 242 */         return InternetProtocolStats.TcpState.LAST_ACK;
/*     */       case 9:
/* 244 */         return InternetProtocolStats.TcpState.FIN_WAIT_2;
/*     */       case 10:
/* 246 */         return InternetProtocolStats.TcpState.TIME_WAIT;
/*     */     } 
/* 248 */     return InternetProtocolStats.TcpState.UNKNOWN;
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
/*     */   private static CLibrary.BsdTcpstat queryTcpstat() {
/* 260 */     CLibrary.BsdTcpstat bsdTcpstat = new CLibrary.BsdTcpstat();
/* 261 */     Memory memory = SysctlUtil.sysctl("net.inet.tcp.stats");
/* 262 */     if (memory != null && memory.size() >= 128L) {
/* 263 */       bsdTcpstat.tcps_connattempt = memory.getInt(0L);
/* 264 */       bsdTcpstat.tcps_accepts = memory.getInt(4L);
/* 265 */       bsdTcpstat.tcps_drops = memory.getInt(12L);
/* 266 */       bsdTcpstat.tcps_conndrops = memory.getInt(16L);
/* 267 */       bsdTcpstat.tcps_sndpack = memory.getInt(64L);
/* 268 */       bsdTcpstat.tcps_sndrexmitpack = memory.getInt(72L);
/* 269 */       bsdTcpstat.tcps_rcvpack = memory.getInt(104L);
/* 270 */       bsdTcpstat.tcps_rcvbadsum = memory.getInt(112L);
/* 271 */       bsdTcpstat.tcps_rcvbadoff = memory.getInt(116L);
/* 272 */       bsdTcpstat.tcps_rcvmemdrop = memory.getInt(120L);
/* 273 */       bsdTcpstat.tcps_rcvshort = memory.getInt(124L);
/*     */     } 
/* 275 */     return bsdTcpstat;
/*     */   }
/*     */   
/*     */   private static CLibrary.BsdIpstat queryIpstat() {
/* 279 */     CLibrary.BsdIpstat bsdIpstat = new CLibrary.BsdIpstat();
/* 280 */     Memory memory = SysctlUtil.sysctl("net.inet.ip.stats");
/* 281 */     if (memory != null && memory.size() >= 60L) {
/* 282 */       bsdIpstat.ips_total = memory.getInt(0L);
/* 283 */       bsdIpstat.ips_badsum = memory.getInt(4L);
/* 284 */       bsdIpstat.ips_tooshort = memory.getInt(8L);
/* 285 */       bsdIpstat.ips_toosmall = memory.getInt(12L);
/* 286 */       bsdIpstat.ips_badhlen = memory.getInt(16L);
/* 287 */       bsdIpstat.ips_badlen = memory.getInt(20L);
/* 288 */       bsdIpstat.ips_delivered = memory.getInt(56L);
/*     */     } 
/* 290 */     return bsdIpstat;
/*     */   }
/*     */   
/*     */   private static CLibrary.BsdIp6stat queryIp6stat() {
/* 294 */     CLibrary.BsdIp6stat bsdIp6stat = new CLibrary.BsdIp6stat();
/* 295 */     Memory memory = SysctlUtil.sysctl("net.inet6.ip6.stats");
/* 296 */     if (memory != null && memory.size() >= 96L) {
/* 297 */       bsdIp6stat.ip6s_total = memory.getLong(0L);
/* 298 */       bsdIp6stat.ip6s_localout = memory.getLong(88L);
/*     */     } 
/* 300 */     return bsdIp6stat;
/*     */   }
/*     */   
/*     */   public static CLibrary.BsdUdpstat queryUdpstat() {
/* 304 */     CLibrary.BsdUdpstat bsdUdpstat = new CLibrary.BsdUdpstat();
/* 305 */     Memory memory = SysctlUtil.sysctl("net.inet.udp.stats");
/* 306 */     if (memory != null && memory.size() >= 1644L) {
/* 307 */       bsdUdpstat.udps_ipackets = memory.getInt(0L);
/* 308 */       bsdUdpstat.udps_hdrops = memory.getInt(4L);
/* 309 */       bsdUdpstat.udps_badsum = memory.getInt(8L);
/* 310 */       bsdUdpstat.udps_badlen = memory.getInt(12L);
/* 311 */       bsdUdpstat.udps_opackets = memory.getInt(36L);
/* 312 */       bsdUdpstat.udps_noportmcast = memory.getInt(48L);
/* 313 */       bsdUdpstat.udps_rcv6_swcsum = memory.getInt(64L);
/* 314 */       bsdUdpstat.udps_snd6_swcsum = memory.getInt(80L);
/*     */     } 
/* 316 */     return bsdUdpstat;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\mac\MacInternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */