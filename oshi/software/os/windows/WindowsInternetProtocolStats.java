/*     */ package oshi.software.os.windows;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.IPHlpAPI;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.common.AbstractInternetProtocolStats;
/*     */ import oshi.software.os.InternetProtocolStats;
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
/*     */ public class WindowsInternetProtocolStats
/*     */   extends AbstractInternetProtocolStats
/*     */ {
/*  72 */   private static final IPHlpAPI IPHLP = IPHlpAPI.INSTANCE;
/*     */   
/*  74 */   private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.TcpStats getTCPv4Stats() {
/*  78 */     IPHlpAPI.MIB_TCPSTATS mIB_TCPSTATS = new IPHlpAPI.MIB_TCPSTATS();
/*  79 */     IPHLP.GetTcpStatisticsEx(mIB_TCPSTATS, 2);
/*  80 */     return new InternetProtocolStats.TcpStats(mIB_TCPSTATS.dwCurrEstab, mIB_TCPSTATS.dwActiveOpens, mIB_TCPSTATS.dwPassiveOpens, mIB_TCPSTATS.dwAttemptFails, mIB_TCPSTATS.dwEstabResets, mIB_TCPSTATS.dwOutSegs, mIB_TCPSTATS.dwInSegs, mIB_TCPSTATS.dwRetransSegs, mIB_TCPSTATS.dwInErrs, mIB_TCPSTATS.dwOutRsts);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.TcpStats getTCPv6Stats() {
/*  87 */     IPHlpAPI.MIB_TCPSTATS mIB_TCPSTATS = new IPHlpAPI.MIB_TCPSTATS();
/*  88 */     IPHLP.GetTcpStatisticsEx(mIB_TCPSTATS, 23);
/*  89 */     return new InternetProtocolStats.TcpStats(mIB_TCPSTATS.dwCurrEstab, mIB_TCPSTATS.dwActiveOpens, mIB_TCPSTATS.dwPassiveOpens, mIB_TCPSTATS.dwAttemptFails, mIB_TCPSTATS.dwEstabResets, mIB_TCPSTATS.dwOutSegs, mIB_TCPSTATS.dwInSegs, mIB_TCPSTATS.dwRetransSegs, mIB_TCPSTATS.dwInErrs, mIB_TCPSTATS.dwOutRsts);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv4Stats() {
/*  96 */     IPHlpAPI.MIB_UDPSTATS mIB_UDPSTATS = new IPHlpAPI.MIB_UDPSTATS();
/*  97 */     IPHLP.GetUdpStatisticsEx(mIB_UDPSTATS, 2);
/*  98 */     return new InternetProtocolStats.UdpStats(mIB_UDPSTATS.dwOutDatagrams, mIB_UDPSTATS.dwInDatagrams, mIB_UDPSTATS.dwNoPorts, mIB_UDPSTATS.dwInErrors);
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats.UdpStats getUDPv6Stats() {
/* 103 */     IPHlpAPI.MIB_UDPSTATS mIB_UDPSTATS = new IPHlpAPI.MIB_UDPSTATS();
/* 104 */     IPHLP.GetUdpStatisticsEx(mIB_UDPSTATS, 23);
/* 105 */     return new InternetProtocolStats.UdpStats(mIB_UDPSTATS.dwOutDatagrams, mIB_UDPSTATS.dwInDatagrams, mIB_UDPSTATS.dwNoPorts, mIB_UDPSTATS.dwInErrors);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<InternetProtocolStats.IPConnection> getConnections() {
/* 110 */     if (IS_VISTA_OR_GREATER) {
/* 111 */       ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/* 112 */       arrayList.addAll(queryTCPv4Connections());
/* 113 */       arrayList.addAll(queryTCPv6Connections());
/* 114 */       arrayList.addAll(queryUDPv4Connections());
/* 115 */       arrayList.addAll(queryUDPv6Connections());
/* 116 */       return arrayList;
/*     */     } 
/* 118 */     return Collections.emptyList();
/*     */   }
/*     */   
/*     */   private static List<InternetProtocolStats.IPConnection> queryTCPv4Connections() {
/* 122 */     ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/*     */     
/* 124 */     IntByReference intByReference = new IntByReference();
/* 125 */     IPHLP.GetExtendedTcpTable(null, intByReference, false, 2, 5, 0);
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 130 */       int i = intByReference.getValue();
/* 131 */       Memory memory = new Memory(i);
/* 132 */       IPHLP.GetExtendedTcpTable((Pointer)memory, intByReference, false, 2, 5, 0);
/*     */       
/* 134 */       if (i >= intByReference.getValue()) {
/* 135 */         IPHlpAPI.MIB_TCPTABLE_OWNER_PID mIB_TCPTABLE_OWNER_PID = new IPHlpAPI.MIB_TCPTABLE_OWNER_PID((Pointer)memory);
/* 136 */         for (byte b = 0; b < mIB_TCPTABLE_OWNER_PID.dwNumEntries; b++) {
/* 137 */           IPHlpAPI.MIB_TCPROW_OWNER_PID mIB_TCPROW_OWNER_PID = mIB_TCPTABLE_OWNER_PID.table[b];
/* 138 */           arrayList.add(new InternetProtocolStats.IPConnection("tcp4", ParseUtil.parseIntToIP(mIB_TCPROW_OWNER_PID.dwLocalAddr), 
/* 139 */                 ParseUtil.bigEndian16ToLittleEndian(mIB_TCPROW_OWNER_PID.dwLocalPort), ParseUtil.parseIntToIP(mIB_TCPROW_OWNER_PID.dwRemoteAddr), 
/* 140 */                 ParseUtil.bigEndian16ToLittleEndian(mIB_TCPROW_OWNER_PID.dwRemotePort), stateLookup(mIB_TCPROW_OWNER_PID.dwState), 0, 0, mIB_TCPROW_OWNER_PID.dwOwningPid));
/*     */         } 
/*     */         
/* 143 */         return arrayList;
/*     */       } 
/*     */     } 
/*     */   } private static List<InternetProtocolStats.IPConnection> queryTCPv6Connections() {
/* 147 */     ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/*     */     
/* 149 */     IntByReference intByReference = new IntByReference();
/* 150 */     IPHLP.GetExtendedTcpTable(null, intByReference, false, 23, 5, 0);
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 155 */       int i = intByReference.getValue();
/* 156 */       Memory memory = new Memory(i);
/* 157 */       IPHLP.GetExtendedTcpTable((Pointer)memory, intByReference, false, 23, 5, 0);
/*     */       
/* 159 */       if (i >= intByReference.getValue()) {
/* 160 */         IPHlpAPI.MIB_TCP6TABLE_OWNER_PID mIB_TCP6TABLE_OWNER_PID = new IPHlpAPI.MIB_TCP6TABLE_OWNER_PID((Pointer)memory);
/* 161 */         for (byte b = 0; b < mIB_TCP6TABLE_OWNER_PID.dwNumEntries; b++) {
/* 162 */           IPHlpAPI.MIB_TCP6ROW_OWNER_PID mIB_TCP6ROW_OWNER_PID = mIB_TCP6TABLE_OWNER_PID.table[b];
/* 163 */           arrayList.add(new InternetProtocolStats.IPConnection("tcp6", mIB_TCP6ROW_OWNER_PID.LocalAddr, ParseUtil.bigEndian16ToLittleEndian(mIB_TCP6ROW_OWNER_PID.dwLocalPort), mIB_TCP6ROW_OWNER_PID.RemoteAddr, 
/* 164 */                 ParseUtil.bigEndian16ToLittleEndian(mIB_TCP6ROW_OWNER_PID.dwRemotePort), stateLookup(mIB_TCP6ROW_OWNER_PID.State), 0, 0, mIB_TCP6ROW_OWNER_PID.dwOwningPid));
/*     */         } 
/*     */         
/* 167 */         return arrayList;
/*     */       } 
/*     */     } 
/*     */   } private static List<InternetProtocolStats.IPConnection> queryUDPv4Connections() {
/* 171 */     ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/*     */     
/* 173 */     IntByReference intByReference = new IntByReference();
/* 174 */     IPHLP.GetExtendedUdpTable(null, intByReference, false, 2, 1, 0);
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 179 */       int i = intByReference.getValue();
/* 180 */       Memory memory = new Memory(i);
/* 181 */       IPHLP.GetExtendedUdpTable((Pointer)memory, intByReference, false, 2, 1, 0);
/*     */       
/* 183 */       if (i >= intByReference.getValue()) {
/* 184 */         IPHlpAPI.MIB_UDPTABLE_OWNER_PID mIB_UDPTABLE_OWNER_PID = new IPHlpAPI.MIB_UDPTABLE_OWNER_PID((Pointer)memory);
/* 185 */         for (byte b = 0; b < mIB_UDPTABLE_OWNER_PID.dwNumEntries; b++) {
/* 186 */           IPHlpAPI.MIB_UDPROW_OWNER_PID mIB_UDPROW_OWNER_PID = mIB_UDPTABLE_OWNER_PID.table[b];
/* 187 */           arrayList.add(new InternetProtocolStats.IPConnection("udp4", ParseUtil.parseIntToIP(mIB_UDPROW_OWNER_PID.dwLocalAddr), 
/* 188 */                 ParseUtil.bigEndian16ToLittleEndian(mIB_UDPROW_OWNER_PID.dwLocalPort), new byte[0], 0, InternetProtocolStats.TcpState.NONE, 0, 0, mIB_UDPROW_OWNER_PID.dwOwningPid));
/*     */         } 
/*     */         
/* 191 */         return arrayList;
/*     */       } 
/*     */     } 
/*     */   } private static List<InternetProtocolStats.IPConnection> queryUDPv6Connections() {
/* 195 */     ArrayList<InternetProtocolStats.IPConnection> arrayList = new ArrayList();
/*     */     
/* 197 */     IntByReference intByReference = new IntByReference();
/* 198 */     IPHLP.GetExtendedUdpTable(null, intByReference, false, 23, 1, 0);
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 203 */       int i = intByReference.getValue();
/* 204 */       Memory memory = new Memory(i);
/* 205 */       IPHLP.GetExtendedUdpTable((Pointer)memory, intByReference, false, 23, 1, 0);
/*     */       
/* 207 */       if (i >= intByReference.getValue()) {
/* 208 */         IPHlpAPI.MIB_UDP6TABLE_OWNER_PID mIB_UDP6TABLE_OWNER_PID = new IPHlpAPI.MIB_UDP6TABLE_OWNER_PID((Pointer)memory);
/* 209 */         for (byte b = 0; b < mIB_UDP6TABLE_OWNER_PID.dwNumEntries; b++) {
/* 210 */           IPHlpAPI.MIB_UDP6ROW_OWNER_PID mIB_UDP6ROW_OWNER_PID = mIB_UDP6TABLE_OWNER_PID.table[b];
/* 211 */           arrayList.add(new InternetProtocolStats.IPConnection("udp6", mIB_UDP6ROW_OWNER_PID.ucLocalAddr, ParseUtil.bigEndian16ToLittleEndian(mIB_UDP6ROW_OWNER_PID.dwLocalPort), new byte[0], 0, InternetProtocolStats.TcpState.NONE, 0, 0, mIB_UDP6ROW_OWNER_PID.dwOwningPid));
/*     */         } 
/*     */         
/* 214 */         return arrayList;
/*     */       } 
/*     */     } 
/*     */   } private static InternetProtocolStats.TcpState stateLookup(int paramInt) {
/* 218 */     switch (paramInt) {
/*     */       case 1:
/*     */       case 12:
/* 221 */         return InternetProtocolStats.TcpState.CLOSED;
/*     */       case 2:
/* 223 */         return InternetProtocolStats.TcpState.LISTEN;
/*     */       case 3:
/* 225 */         return InternetProtocolStats.TcpState.SYN_SENT;
/*     */       case 4:
/* 227 */         return InternetProtocolStats.TcpState.SYN_RECV;
/*     */       case 5:
/* 229 */         return InternetProtocolStats.TcpState.ESTABLISHED;
/*     */       case 6:
/* 231 */         return InternetProtocolStats.TcpState.FIN_WAIT_1;
/*     */       case 7:
/* 233 */         return InternetProtocolStats.TcpState.FIN_WAIT_2;
/*     */       case 8:
/* 235 */         return InternetProtocolStats.TcpState.CLOSE_WAIT;
/*     */       case 9:
/* 237 */         return InternetProtocolStats.TcpState.CLOSING;
/*     */       case 10:
/* 239 */         return InternetProtocolStats.TcpState.LAST_ACK;
/*     */       case 11:
/* 241 */         return InternetProtocolStats.TcpState.TIME_WAIT;
/*     */     } 
/* 243 */     return InternetProtocolStats.TcpState.UNKNOWN;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\windows\WindowsInternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */