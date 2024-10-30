/*     */ package org.apache.commons.net.time;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.InetAddress;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.net.DatagramSocketClient;
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
/*     */ public final class TimeUDPClient
/*     */   extends DatagramSocketClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 37;
/*     */   public static final long SECONDS_1900_TO_1970 = 2208988800L;
/*  58 */   private final byte[] dummyData = new byte[1];
/*  59 */   private final byte[] timeData = new byte[4];
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
/*     */   public long getTime(InetAddress paramInetAddress, int paramInt) throws IOException {
/*  80 */     DatagramPacket datagramPacket1 = new DatagramPacket(this.dummyData, this.dummyData.length, paramInetAddress, paramInt);
/*     */     
/*  82 */     DatagramPacket datagramPacket2 = new DatagramPacket(this.timeData, this.timeData.length);
/*     */     
/*  84 */     this._socket_.send(datagramPacket1);
/*  85 */     this._socket_.receive(datagramPacket2);
/*     */     
/*  87 */     long l = 0L;
/*  88 */     l |= ((this.timeData[0] & 0xFF) << 24) & 0xFFFFFFFFL;
/*  89 */     l |= ((this.timeData[1] & 0xFF) << 16) & 0xFFFFFFFFL;
/*  90 */     l |= ((this.timeData[2] & 0xFF) << 8) & 0xFFFFFFFFL;
/*  91 */     l |= (this.timeData[3] & 0xFF) & 0xFFFFFFFFL;
/*     */     
/*  93 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTime(InetAddress paramInetAddress) throws IOException {
/* 103 */     return getTime(paramInetAddress, 37);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDate(InetAddress paramInetAddress, int paramInt) throws IOException {
/* 119 */     return new Date((getTime(paramInetAddress, paramInt) - 2208988800L) * 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getDate(InetAddress paramInetAddress) throws IOException {
/* 130 */     return new Date((getTime(paramInetAddress, 37) - 2208988800L) * 1000L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\time\TimeUDPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */