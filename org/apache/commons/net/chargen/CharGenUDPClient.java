/*     */ package org.apache.commons.net.chargen;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.InetAddress;
/*     */ import org.apache.commons.net.DatagramSocketClient;
/*     */ import org.apache.commons.net.util.NetConstants;
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
/*     */ public final class CharGenUDPClient
/*     */   extends DatagramSocketClient
/*     */ {
/*     */   public static final int SYSTAT_PORT = 11;
/*     */   public static final int NETSTAT_PORT = 15;
/*     */   public static final int QUOTE_OF_DAY_PORT = 17;
/*     */   public static final int CHARGEN_PORT = 19;
/*     */   public static final int DEFAULT_PORT = 19;
/*  78 */   private final byte[] receiveData = new byte[512];
/*  79 */   private final DatagramPacket receivePacket = new DatagramPacket(this.receiveData, this.receiveData.length);
/*  80 */   private final DatagramPacket sendPacket = new DatagramPacket(NetConstants.EMPTY_BTYE_ARRAY, 0);
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
/*     */   public void send(InetAddress paramInetAddress, int paramInt) throws IOException {
/*  95 */     this.sendPacket.setAddress(paramInetAddress);
/*  96 */     this.sendPacket.setPort(paramInt);
/*  97 */     this._socket_.send(this.sendPacket);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void send(InetAddress paramInetAddress) throws IOException {
/* 106 */     send(paramInetAddress, 19);
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
/*     */   public byte[] receive() throws IOException {
/* 122 */     this._socket_.receive(this.receivePacket);
/*     */     int i;
/* 124 */     byte[] arrayOfByte = new byte[i = this.receivePacket.getLength()];
/* 125 */     System.arraycopy(this.receiveData, 0, arrayOfByte, 0, i);
/*     */     
/* 127 */     return arrayOfByte;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\chargen\CharGenUDPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */