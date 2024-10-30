/*     */ package org.apache.commons.net.discard;
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
/*     */ public class DiscardUDPClient
/*     */   extends DatagramSocketClient
/*     */ {
/*     */   public static final int DEFAULT_PORT = 9;
/*  49 */   private final DatagramPacket sendPacket = new DatagramPacket(NetConstants.EMPTY_BTYE_ARRAY, 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void send(byte[] paramArrayOfbyte, int paramInt1, InetAddress paramInetAddress, int paramInt2) throws IOException {
/*  67 */     this.sendPacket.setData(paramArrayOfbyte);
/*  68 */     this.sendPacket.setLength(paramInt1);
/*  69 */     this.sendPacket.setAddress(paramInetAddress);
/*  70 */     this.sendPacket.setPort(paramInt2);
/*  71 */     this._socket_.send(this.sendPacket);
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
/*     */   public void send(byte[] paramArrayOfbyte, int paramInt, InetAddress paramInetAddress) throws IOException {
/*  87 */     send(paramArrayOfbyte, paramInt, paramInetAddress, 9);
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
/*     */   public void send(byte[] paramArrayOfbyte, InetAddress paramInetAddress) throws IOException {
/* 101 */     send(paramArrayOfbyte, paramArrayOfbyte.length, paramInetAddress, 9);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\discard\DiscardUDPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */