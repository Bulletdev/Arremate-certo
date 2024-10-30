/*    */ package oshi.software.os.unix.openbsd;
/*    */ 
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.driver.unix.NetStat;
/*    */ import oshi.software.common.AbstractInternetProtocolStats;
/*    */ import oshi.software.os.InternetProtocolStats;
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
/*    */ public class OpenBsdInternetProtocolStats
/*    */   extends AbstractInternetProtocolStats
/*    */ {
/*    */   public InternetProtocolStats.TcpStats getTCPv4Stats() {
/* 38 */     return NetStat.queryTcpStats("netstat -s -p tcp");
/*    */   }
/*    */ 
/*    */   
/*    */   public InternetProtocolStats.UdpStats getUDPv4Stats() {
/* 43 */     return NetStat.queryUdpStats("netstat -s -p udp");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\openbsd\OpenBsdInternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */