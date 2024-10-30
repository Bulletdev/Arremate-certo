/*     */ package org.apache.commons.net.tftp;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.SocketException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFTP
/*     */   extends DatagramSocketClient
/*     */ {
/*     */   public static final int ASCII_MODE = 0;
/*     */   public static final int NETASCII_MODE = 0;
/*     */   public static final int BINARY_MODE = 1;
/*     */   public static final int IMAGE_MODE = 1;
/*     */   public static final int OCTET_MODE = 1;
/*     */   public static final int DEFAULT_TIMEOUT = 5000;
/*     */   public static final int DEFAULT_PORT = 69;
/*     */   static final int PACKET_SIZE = 516;
/*     */   private byte[] receiveBuffer;
/*     */   private DatagramPacket receiveDatagram;
/*     */   private DatagramPacket sendDatagram;
/*     */   byte[] sendBuffer;
/*     */   
/*     */   public static final String getModeName(int paramInt) {
/* 120 */     return TFTPRequestPacket.modeStrings[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TFTP() {
/* 129 */     setDefaultTimeout(5000);
/* 130 */     this.receiveBuffer = null;
/* 131 */     this.receiveDatagram = null;
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
/*     */   public final void discardPackets() throws IOException {
/* 146 */     DatagramPacket datagramPacket = new DatagramPacket(new byte[516], 516);
/*     */     
/* 148 */     int i = getSoTimeout();
/* 149 */     setSoTimeout(1);
/*     */ 
/*     */     
/*     */     try {
/*     */       while (true) {
/* 154 */         this._socket_.receive(datagramPacket);
/*     */       }
/*     */     }
/* 157 */     catch (SocketException|InterruptedIOException socketException) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 162 */       setSoTimeout(i);
/*     */       return;
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TFTPPacket bufferedReceive() throws IOException, InterruptedIOException, SocketException, TFTPPacketException {
/* 196 */     this.receiveDatagram.setData(this.receiveBuffer);
/* 197 */     this.receiveDatagram.setLength(this.receiveBuffer.length);
/* 198 */     this._socket_.receive(this.receiveDatagram);
/*     */     
/* 200 */     TFTPPacket tFTPPacket = TFTPPacket.newTFTPPacket(this.receiveDatagram);
/* 201 */     trace("<", tFTPPacket);
/* 202 */     return tFTPPacket;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void bufferedSend(TFTPPacket paramTFTPPacket) throws IOException {
/* 225 */     trace(">", paramTFTPPacket);
/* 226 */     this._socket_.send(paramTFTPPacket.newDatagram(this.sendDatagram, this.sendBuffer));
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
/*     */   public final void beginBufferedOps() {
/* 240 */     this.receiveBuffer = new byte[516];
/* 241 */     this.receiveDatagram = new DatagramPacket(this.receiveBuffer, this.receiveBuffer.length);
/*     */     
/* 243 */     this.sendBuffer = new byte[516];
/* 244 */     this.sendDatagram = new DatagramPacket(this.sendBuffer, this.sendBuffer.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void endBufferedOps() {
/* 253 */     this.receiveBuffer = null;
/* 254 */     this.receiveDatagram = null;
/* 255 */     this.sendBuffer = null;
/* 256 */     this.sendDatagram = null;
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
/*     */   public final void send(TFTPPacket paramTFTPPacket) throws IOException {
/* 268 */     trace(">", paramTFTPPacket);
/* 269 */     this._socket_.send(paramTFTPPacket.newDatagram());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TFTPPacket receive() throws IOException, InterruptedIOException, SocketException, TFTPPacketException {
/* 293 */     DatagramPacket datagramPacket = new DatagramPacket(new byte[516], 516);
/*     */     
/* 295 */     this._socket_.receive(datagramPacket);
/*     */     
/* 297 */     TFTPPacket tFTPPacket = TFTPPacket.newTFTPPacket(datagramPacket);
/* 298 */     trace("<", tFTPPacket);
/* 299 */     return tFTPPacket;
/*     */   }
/*     */   
/*     */   protected void trace(String paramString, TFTPPacket paramTFTPPacket) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\tftp\TFTP.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */