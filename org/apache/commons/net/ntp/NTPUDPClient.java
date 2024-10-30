/*     */ package org.apache.commons.net.ntp;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.InetAddress;
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
/*     */ public final class NTPUDPClient
/*     */   extends DatagramSocketClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 123;
/*  45 */   private int version = 3;
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
/*     */   public TimeInfo getTime(InetAddress paramInetAddress, int paramInt) throws IOException {
/*  62 */     if (!isOpen())
/*     */     {
/*  64 */       open();
/*     */     }
/*     */     
/*  67 */     NtpV3Impl ntpV3Impl1 = new NtpV3Impl();
/*  68 */     ntpV3Impl1.setMode(3);
/*  69 */     ntpV3Impl1.setVersion(this.version);
/*  70 */     DatagramPacket datagramPacket1 = ntpV3Impl1.getDatagramPacket();
/*  71 */     datagramPacket1.setAddress(paramInetAddress);
/*  72 */     datagramPacket1.setPort(paramInt);
/*     */     
/*  74 */     NtpV3Impl ntpV3Impl2 = new NtpV3Impl();
/*  75 */     DatagramPacket datagramPacket2 = ntpV3Impl2.getDatagramPacket();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     TimeStamp timeStamp = TimeStamp.getCurrentTime();
/*     */ 
/*     */ 
/*     */     
/*  87 */     ntpV3Impl1.setTransmitTime(timeStamp);
/*     */     
/*  89 */     this._socket_.send(datagramPacket1);
/*  90 */     this._socket_.receive(datagramPacket2);
/*     */     
/*  92 */     long l = System.currentTimeMillis();
/*     */     
/*  94 */     return new TimeInfo(ntpV3Impl2, l, false);
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
/*     */   public TimeInfo getTime(InetAddress paramInetAddress) throws IOException {
/* 110 */     return getTime(paramInetAddress, 123);
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
/*     */   public int getVersion() {
/* 122 */     return this.version;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersion(int paramInt) {
/* 133 */     this.version = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ntp\NTPUDPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */