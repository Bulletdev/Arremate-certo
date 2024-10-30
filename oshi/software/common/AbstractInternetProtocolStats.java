/*    */ package oshi.software.common;
/*    */ 
/*    */ import java.util.List;
/*    */ import oshi.driver.unix.NetStat;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AbstractInternetProtocolStats
/*    */   implements InternetProtocolStats
/*    */ {
/*    */   public InternetProtocolStats.TcpStats getTCPv6Stats() {
/* 43 */     return new InternetProtocolStats.TcpStats(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public InternetProtocolStats.UdpStats getUDPv6Stats() {
/* 49 */     return new InternetProtocolStats.UdpStats(0L, 0L, 0L, 0L);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<InternetProtocolStats.IPConnection> getConnections() {
/* 54 */     return NetStat.queryNetstat();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\common\AbstractInternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */