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
/*     */ public final class TFTPAckPacket
/*     */   extends TFTPPacket
/*     */ {
/*     */   int blockNumber;
/*     */   
/*     */   public TFTPAckPacket(InetAddress paramInetAddress, int paramInt1, int paramInt2) {
/*  59 */     super(4, paramInetAddress, paramInt1);
/*  60 */     this.blockNumber = paramInt2;
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
/*     */   TFTPAckPacket(DatagramPacket paramDatagramPacket) throws TFTPPacketException {
/*  74 */     super(4, paramDatagramPacket.getAddress(), paramDatagramPacket
/*  75 */         .getPort());
/*     */ 
/*     */     
/*  78 */     byte[] arrayOfByte = paramDatagramPacket.getData();
/*     */     
/*  80 */     if (getType() != arrayOfByte[1]) {
/*  81 */       throw new TFTPPacketException("TFTP operator code does not match type.");
/*     */     }
/*     */     
/*  84 */     this.blockNumber = (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF;
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
/*     */   DatagramPacket newDatagram(DatagramPacket paramDatagramPacket, byte[] paramArrayOfbyte) {
/* 101 */     paramArrayOfbyte[0] = 0;
/* 102 */     paramArrayOfbyte[1] = (byte)this.type;
/* 103 */     paramArrayOfbyte[2] = (byte)((this.blockNumber & 0xFFFF) >> 8);
/* 104 */     paramArrayOfbyte[3] = (byte)(this.blockNumber & 0xFF);
/*     */     
/* 106 */     paramDatagramPacket.setAddress(this.address);
/* 107 */     paramDatagramPacket.setPort(this.port);
/* 108 */     paramDatagramPacket.setData(paramArrayOfbyte);
/* 109 */     paramDatagramPacket.setLength(4);
/*     */     
/* 111 */     return paramDatagramPacket;
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
/*     */   public DatagramPacket newDatagram() {
/* 131 */     byte[] arrayOfByte = new byte[4];
/* 132 */     arrayOfByte[0] = 0;
/* 133 */     arrayOfByte[1] = (byte)this.type;
/* 134 */     arrayOfByte[2] = (byte)((this.blockNumber & 0xFFFF) >> 8);
/* 135 */     arrayOfByte[3] = (byte)(this.blockNumber & 0xFF);
/*     */     
/* 137 */     return new DatagramPacket(arrayOfByte, arrayOfByte.length, this.address, this.port);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBlockNumber() {
/* 148 */     return this.blockNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlockNumber(int paramInt) {
/* 159 */     this.blockNumber = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 168 */     return super.toString() + " ACK " + this.blockNumber;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\tftp\TFTPAckPacket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */