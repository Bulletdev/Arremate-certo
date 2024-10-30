/*     */ package org.apache.commons.net.echo;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.InetAddress;
/*     */ import org.apache.commons.net.discard.DiscardUDPClient;
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
/*     */ public final class EchoUDPClient
/*     */   extends DiscardUDPClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 7;
/*  47 */   private final DatagramPacket receivePacket = new DatagramPacket(NetConstants.EMPTY_BTYE_ARRAY, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void send(byte[] paramArrayOfbyte, int paramInt, InetAddress paramInetAddress) throws IOException {
/*  64 */     send(paramArrayOfbyte, paramInt, paramInetAddress, 7);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void send(byte[] paramArrayOfbyte, InetAddress paramInetAddress) throws IOException {
/*  72 */     send(paramArrayOfbyte, paramArrayOfbyte.length, paramInetAddress, 7);
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
/*     */   
/*     */   public int receive(byte[] paramArrayOfbyte, int paramInt) throws IOException {
/*  89 */     this.receivePacket.setData(paramArrayOfbyte);
/*  90 */     this.receivePacket.setLength(paramInt);
/*  91 */     this._socket_.receive(this.receivePacket);
/*  92 */     return this.receivePacket.getLength();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int receive(byte[] paramArrayOfbyte) throws IOException {
/* 102 */     return receive(paramArrayOfbyte, paramArrayOfbyte.length);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\echo\EchoUDPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */