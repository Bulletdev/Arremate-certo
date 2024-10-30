/*    */ package org.apache.commons.net.daytime;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.DatagramPacket;
/*    */ import java.net.InetAddress;
/*    */ import org.apache.commons.net.DatagramSocketClient;
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
/*    */ 
/*    */ 
/*    */ public final class DaytimeUDPClient
/*    */   extends DatagramSocketClient
/*    */ {
/*    */   public static final int DEFAULT_PORT = 13;
/* 46 */   private final byte[] dummyData = new byte[1];
/*    */   
/* 48 */   private final byte[] timeData = new byte[256];
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
/*    */   public String getTime(InetAddress paramInetAddress, int paramInt) throws IOException {
/* 64 */     DatagramPacket datagramPacket1 = new DatagramPacket(this.dummyData, this.dummyData.length, paramInetAddress, paramInt);
/*    */     
/* 66 */     DatagramPacket datagramPacket2 = new DatagramPacket(this.timeData, this.timeData.length);
/*    */     
/* 68 */     this._socket_.send(datagramPacket1);
/* 69 */     this._socket_.receive(datagramPacket2);
/*    */     
/* 71 */     return new String(datagramPacket2.getData(), 0, datagramPacket2.getLength(), getCharset());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTime(InetAddress paramInetAddress) throws IOException {
/* 81 */     return getTime(paramInetAddress, 13);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\daytime\DaytimeUDPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */