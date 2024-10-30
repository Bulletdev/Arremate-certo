/*     */ package org.apache.commons.net.tftp;
/*     */ 
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.InetAddress;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TFTPPacket
/*     */ {
/*     */   static final int MIN_PACKET_SIZE = 4;
/*     */   public static final int READ_REQUEST = 1;
/*     */   public static final int WRITE_REQUEST = 2;
/*     */   public static final int DATA = 3;
/*     */   public static final int ACKNOWLEDGEMENT = 4;
/*     */   public static final int ERROR = 5;
/*     */   public static final int SEGMENT_SIZE = 512;
/*     */   int type;
/*     */   int port;
/*     */   InetAddress address;
/*     */   
/*     */   public static final TFTPPacket newTFTPPacket(DatagramPacket paramDatagramPacket) throws TFTPPacketException {
/*     */     TFTPWriteRequestPacket tFTPWriteRequestPacket;
/*     */     TFTPDataPacket tFTPDataPacket;
/*     */     TFTPAckPacket tFTPAckPacket;
/* 128 */     TFTPReadRequestPacket tFTPReadRequestPacket = null;
/*     */     
/* 130 */     if (paramDatagramPacket.getLength() < 4) {
/* 131 */       throw new TFTPPacketException("Bad packet. Datagram data length is too short.");
/*     */     }
/*     */ 
/*     */     
/* 135 */     byte[] arrayOfByte = paramDatagramPacket.getData();
/*     */     
/* 137 */     switch (arrayOfByte[1]) {
/*     */       
/*     */       case 1:
/* 140 */         tFTPReadRequestPacket = new TFTPReadRequestPacket(paramDatagramPacket);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 159 */         return tFTPReadRequestPacket;
/*     */       case 2:
/*     */         return new TFTPWriteRequestPacket(paramDatagramPacket);
/*     */       case 3:
/*     */         return new TFTPDataPacket(paramDatagramPacket);
/*     */       case 4:
/*     */         return new TFTPAckPacket(paramDatagramPacket);
/*     */       case 5:
/*     */         return new TFTPErrorPacket(paramDatagramPacket);
/*     */     } 
/*     */     throw new TFTPPacketException("Bad packet.  Invalid TFTP operator code.");
/*     */   }
/*     */   TFTPPacket(int paramInt1, InetAddress paramInetAddress, int paramInt2) {
/* 172 */     this.type = paramInt1;
/* 173 */     this.address = paramInetAddress;
/* 174 */     this.port = paramInt2;
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
/*     */   abstract DatagramPacket newDatagram(DatagramPacket paramDatagramPacket, byte[] paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract DatagramPacket newDatagram();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getType() {
/* 211 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final InetAddress getAddress() {
/* 222 */     return this.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getPort() {
/* 233 */     return this.port;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setPort(int paramInt) {
/* 242 */     this.port = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setAddress(InetAddress paramInetAddress) {
/* 250 */     this.address = paramInetAddress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 259 */     return this.address + " " + this.port + " " + this.type;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\tftp\TFTPPacket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */