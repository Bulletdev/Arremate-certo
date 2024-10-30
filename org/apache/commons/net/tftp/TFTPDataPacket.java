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
/*     */ public final class TFTPDataPacket
/*     */   extends TFTPPacket
/*     */ {
/*     */   public static final int MAX_DATA_LENGTH = 512;
/*     */   public static final int MIN_DATA_LENGTH = 0;
/*     */   int blockNumber;
/*     */   private int length;
/*     */   private int offset;
/*     */   private byte[] data;
/*     */   
/*     */   public TFTPDataPacket(InetAddress paramInetAddress, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, int paramInt3, int paramInt4) {
/*  82 */     super(3, paramInetAddress, paramInt1);
/*     */     
/*  84 */     this.blockNumber = paramInt2;
/*  85 */     this.data = paramArrayOfbyte;
/*  86 */     this.offset = paramInt3;
/*     */     
/*  88 */     if (paramInt4 > 512) {
/*  89 */       this.length = 512;
/*     */     } else {
/*  91 */       this.length = paramInt4;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TFTPDataPacket(InetAddress paramInetAddress, int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
/*  98 */     this(paramInetAddress, paramInt1, paramInt2, paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   TFTPDataPacket(DatagramPacket paramDatagramPacket) throws TFTPPacketException {
/* 113 */     super(3, paramDatagramPacket.getAddress(), paramDatagramPacket.getPort());
/*     */     
/* 115 */     this.data = paramDatagramPacket.getData();
/* 116 */     this.offset = 4;
/*     */     
/* 118 */     if (getType() != this.data[1]) {
/* 119 */       throw new TFTPPacketException("TFTP operator code does not match type.");
/*     */     }
/*     */     
/* 122 */     this.blockNumber = (this.data[2] & 0xFF) << 8 | this.data[3] & 0xFF;
/*     */     
/* 124 */     this.length = paramDatagramPacket.getLength() - 4;
/*     */     
/* 126 */     if (this.length > 512) {
/* 127 */       this.length = 512;
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
/*     */   DatagramPacket newDatagram(DatagramPacket paramDatagramPacket, byte[] paramArrayOfbyte) {
/* 145 */     paramArrayOfbyte[0] = 0;
/* 146 */     paramArrayOfbyte[1] = (byte)this.type;
/* 147 */     paramArrayOfbyte[2] = (byte)((this.blockNumber & 0xFFFF) >> 8);
/* 148 */     paramArrayOfbyte[3] = (byte)(this.blockNumber & 0xFF);
/*     */ 
/*     */     
/* 151 */     if (paramArrayOfbyte != this.data) {
/* 152 */       System.arraycopy(this.data, this.offset, paramArrayOfbyte, 4, this.length);
/*     */     }
/*     */     
/* 155 */     paramDatagramPacket.setAddress(this.address);
/* 156 */     paramDatagramPacket.setPort(this.port);
/* 157 */     paramDatagramPacket.setData(paramArrayOfbyte);
/* 158 */     paramDatagramPacket.setLength(this.length + 4);
/*     */     
/* 160 */     return paramDatagramPacket;
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
/* 180 */     byte[] arrayOfByte = new byte[this.length + 4];
/* 181 */     arrayOfByte[0] = 0;
/* 182 */     arrayOfByte[1] = (byte)this.type;
/* 183 */     arrayOfByte[2] = (byte)((this.blockNumber & 0xFFFF) >> 8);
/* 184 */     arrayOfByte[3] = (byte)(this.blockNumber & 0xFF);
/*     */     
/* 186 */     System.arraycopy(this.data, this.offset, arrayOfByte, 4, this.length);
/*     */     
/* 188 */     return new DatagramPacket(arrayOfByte, this.length + 4, this.address, this.port);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBlockNumber() {
/* 198 */     return this.blockNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlockNumber(int paramInt) {
/* 206 */     this.blockNumber = paramInt;
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
/*     */   public void setData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 218 */     this.data = paramArrayOfbyte;
/* 219 */     this.offset = paramInt1;
/* 220 */     this.length = paramInt2;
/*     */     
/* 222 */     if (paramInt2 > 512) {
/* 223 */       this.length = 512;
/*     */     } else {
/* 225 */       this.length = paramInt2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDataLength() {
/* 236 */     return this.length;
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
/*     */   public int getDataOffset() {
/* 248 */     return this.offset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getData() {
/* 258 */     return this.data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 267 */     return super.toString() + " DATA " + this.blockNumber + " " + this.length;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\tftp\TFTPDataPacket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */