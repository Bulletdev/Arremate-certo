/*     */ package oshi.software.os;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
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
/*     */ public interface InternetProtocolStats
/*     */ {
/*     */   TcpStats getTCPv4Stats();
/*     */   
/*     */   TcpStats getTCPv6Stats();
/*     */   
/*     */   UdpStats getUDPv4Stats();
/*     */   
/*     */   UdpStats getUDPv6Stats();
/*     */   
/*     */   List<IPConnection> getConnections();
/*     */   
/*     */   @Immutable
/*     */   public static final class TcpStats
/*     */   {
/*     */     private final long connectionsEstablished;
/*     */     private final long connectionsActive;
/*     */     private final long connectionsPassive;
/*     */     private final long connectionFailures;
/*     */     private final long connectionsReset;
/*     */     private final long segmentsSent;
/*     */     private final long segmentsReceived;
/*     */     private final long segmentsRetransmitted;
/*     */     private final long inErrors;
/*     */     private final long outResets;
/*     */     
/*     */     public TcpStats(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, long param1Long6, long param1Long7, long param1Long8, long param1Long9, long param1Long10) {
/*  99 */       this.connectionsEstablished = param1Long1;
/* 100 */       this.connectionsActive = param1Long2;
/* 101 */       this.connectionsPassive = param1Long3;
/* 102 */       this.connectionFailures = param1Long4;
/* 103 */       this.connectionsReset = param1Long5;
/* 104 */       this.segmentsSent = param1Long6;
/* 105 */       this.segmentsReceived = param1Long7;
/* 106 */       this.segmentsRetransmitted = param1Long8;
/* 107 */       this.inErrors = param1Long9;
/* 108 */       this.outResets = param1Long10;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getConnectionsEstablished() {
/* 118 */       return this.connectionsEstablished;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getConnectionsActive() {
/* 130 */       return this.connectionsActive;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getConnectionsPassive() {
/* 142 */       return this.connectionsPassive;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getConnectionFailures() {
/* 154 */       return this.connectionFailures;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getConnectionsReset() {
/* 165 */       return this.connectionsReset;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getSegmentsSent() {
/* 175 */       return this.segmentsSent;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getSegmentsReceived() {
/* 186 */       return this.segmentsReceived;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getSegmentsRetransmitted() {
/* 196 */       return this.segmentsRetransmitted;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getInErrors() {
/* 205 */       return this.inErrors;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getOutResets() {
/* 214 */       return this.outResets;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 219 */       return "TcpStats [connectionsEstablished=" + this.connectionsEstablished + ", connectionsActive=" + this.connectionsActive + ", connectionsPassive=" + this.connectionsPassive + ", connectionFailures=" + this.connectionFailures + ", connectionsReset=" + this.connectionsReset + ", segmentsSent=" + this.segmentsSent + ", segmentsReceived=" + this.segmentsReceived + ", segmentsRetransmitted=" + this.segmentsRetransmitted + ", inErrors=" + this.inErrors + ", outResets=" + this.outResets + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static final class UdpStats
/*     */   {
/*     */     private final long datagramsSent;
/*     */ 
/*     */     
/*     */     private final long datagramsReceived;
/*     */     
/*     */     private final long datagramsNoPort;
/*     */     
/*     */     private final long datagramsReceivedErrors;
/*     */ 
/*     */     
/*     */     public UdpStats(long param1Long1, long param1Long2, long param1Long3, long param1Long4) {
/* 239 */       this.datagramsSent = param1Long1;
/* 240 */       this.datagramsReceived = param1Long2;
/* 241 */       this.datagramsNoPort = param1Long3;
/* 242 */       this.datagramsReceivedErrors = param1Long4;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getDatagramsSent() {
/* 251 */       return this.datagramsSent;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getDatagramsReceived() {
/* 260 */       return this.datagramsReceived;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getDatagramsNoPort() {
/* 270 */       return this.datagramsNoPort;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getDatagramsReceivedErrors() {
/* 281 */       return this.datagramsReceivedErrors;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 286 */       return "UdpStats [datagramsSent=" + this.datagramsSent + ", datagramsReceived=" + this.datagramsReceived + ", datagramsNoPort=" + this.datagramsNoPort + ", datagramsReceivedErrors=" + this.datagramsReceivedErrors + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum TcpState
/*     */   {
/* 296 */     UNKNOWN, CLOSED, LISTEN, SYN_SENT, SYN_RECV, ESTABLISHED, FIN_WAIT_1, FIN_WAIT_2, CLOSE_WAIT, CLOSING, LAST_ACK,
/* 297 */     TIME_WAIT, NONE;
/*     */   }
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static final class IPConnection
/*     */   {
/*     */     private final String type;
/*     */     
/*     */     private final byte[] localAddress;
/*     */     
/*     */     private final int localPort;
/*     */     private final byte[] foreignAddress;
/*     */     private final int foreignPort;
/*     */     private final InternetProtocolStats.TcpState state;
/*     */     private final int transmitQueue;
/*     */     private final int receiveQueue;
/*     */     private int owningProcessId;
/*     */     
/*     */     public IPConnection(String param1String, byte[] param1ArrayOfbyte1, int param1Int1, byte[] param1ArrayOfbyte2, int param1Int2, InternetProtocolStats.TcpState param1TcpState, int param1Int3, int param1Int4, int param1Int5) {
/* 317 */       this.type = param1String;
/* 318 */       this.localAddress = Arrays.copyOf(param1ArrayOfbyte1, param1ArrayOfbyte1.length);
/* 319 */       this.localPort = param1Int1;
/* 320 */       this.foreignAddress = Arrays.copyOf(param1ArrayOfbyte2, param1ArrayOfbyte2.length);
/* 321 */       this.foreignPort = param1Int2;
/* 322 */       this.state = param1TcpState;
/* 323 */       this.transmitQueue = param1Int3;
/* 324 */       this.receiveQueue = param1Int4;
/* 325 */       this.owningProcessId = param1Int5;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getType() {
/* 334 */       return this.type;
/*     */     }
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
/*     */     public byte[] getLocalAddress() {
/* 349 */       return Arrays.copyOf(this.localAddress, this.localAddress.length);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getLocalPort() {
/* 358 */       return this.localPort;
/*     */     }
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
/*     */     public byte[] getForeignAddress() {
/* 372 */       return Arrays.copyOf(this.foreignAddress, this.foreignAddress.length);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getForeignPort() {
/* 381 */       return this.foreignPort;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public InternetProtocolStats.TcpState getState() {
/* 390 */       return this.state;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getTransmitQueue() {
/* 399 */       return this.transmitQueue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getReceiveQueue() {
/* 408 */       return this.receiveQueue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getowningProcessId() {
/* 418 */       return this.owningProcessId;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 423 */       String str1 = "*";
/*     */       try {
/* 425 */         str1 = InetAddress.getByAddress(this.localAddress).toString();
/* 426 */       } catch (UnknownHostException unknownHostException) {}
/*     */       
/* 428 */       String str2 = "*";
/*     */       try {
/* 430 */         str2 = InetAddress.getByAddress(this.foreignAddress).toString();
/* 431 */       } catch (UnknownHostException unknownHostException) {}
/*     */       
/* 433 */       return "IPConnection [type=" + this.type + ", localAddress=" + str1 + ", localPort=" + this.localPort + ", foreignAddress=" + str2 + ", foreignPort=" + this.foreignPort + ", state=" + this.state + ", transmitQueue=" + this.transmitQueue + ", receiveQueue=" + this.receiveQueue + ", owningProcessId=" + this.owningProcessId + "]";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\InternetProtocolStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */