/*    */ package oshi.software.os.unix.aix;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.platform.unix.aix.Perfstat;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.driver.unix.aix.perfstat.PerfstatProtocol;
/*    */ import oshi.software.common.AbstractInternetProtocolStats;
/*    */ import oshi.software.os.InternetProtocolStats;
/*    */ import oshi.util.Memoizer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public class AixInternetProtocolStats
/*    */   extends AbstractInternetProtocolStats
/*    */ {
/* 44 */   private Supplier<Perfstat.perfstat_protocol_t[]> ipstats = Memoizer.memoize(PerfstatProtocol::queryProtocols, Memoizer.defaultExpiration());
/*    */ 
/*    */   
/*    */   public InternetProtocolStats.TcpStats getTCPv4Stats() {
/* 48 */     for (Perfstat.perfstat_protocol_t perfstat_protocol_t : (Perfstat.perfstat_protocol_t[])this.ipstats.get()) {
/* 49 */       if ("tcp".equals(Native.toString(perfstat_protocol_t.name))) {
/* 50 */         return new InternetProtocolStats.TcpStats(perfstat_protocol_t.u.tcp.established, perfstat_protocol_t.u.tcp.initiated, perfstat_protocol_t.u.tcp.accepted, perfstat_protocol_t.u.tcp.dropped, perfstat_protocol_t.u.tcp.dropped, perfstat_protocol_t.u.tcp.opackets, perfstat_protocol_t.u.tcp.ipackets, 0L, perfstat_protocol_t.u.tcp.ierrors, 0L);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 55 */     return new InternetProtocolStats.TcpStats(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L);
/*    */   }
/*    */ 
/*    */   
/*    */   public InternetProtocolStats.UdpStats getUDPv4Stats() {
/* 60 */     for (Perfstat.perfstat_protocol_t perfstat_protocol_t : (Perfstat.perfstat_protocol_t[])this.ipstats.get()) {
/* 61 */       if ("udp".equals(Native.toString(perfstat_protocol_t.name))) {
/* 62 */         return new InternetProtocolStats.UdpStats(perfstat_protocol_t.u.udp.opackets, perfstat_protocol_t.u.udp.ipackets, perfstat_protocol_t.u.udp.no_socket, perfstat_protocol_t.u.udp.ierrors);
/*    */       }
/*    */     } 
/* 65 */     return new InternetProtocolStats.UdpStats(0L, 0L, 0L, 0L);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\aix\AixInternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */