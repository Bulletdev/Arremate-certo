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
/*     */ public final class TFTPErrorPacket
/*     */   extends TFTPPacket
/*     */ {
/*     */   public static final int UNDEFINED = 0;
/*     */   public static final int FILE_NOT_FOUND = 1;
/*     */   public static final int ACCESS_VIOLATION = 2;
/*     */   public static final int OUT_OF_SPACE = 3;
/*     */   public static final int ILLEGAL_OPERATION = 4;
/*     */   public static final int UNKNOWN_TID = 5;
/*     */   public static final int FILE_EXISTS = 6;
/*     */   public static final int NO_SUCH_USER = 7;
/*     */   private final int error;
/*     */   private final String message;
/*     */   
/*     */   public TFTPErrorPacket(InetAddress paramInetAddress, int paramInt1, int paramInt2, String paramString) {
/*  90 */     super(5, paramInetAddress, paramInt1);
/*     */     
/*  92 */     this.error = paramInt2;
/*  93 */     this.message = paramString;
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
/*     */   TFTPErrorPacket(DatagramPacket paramDatagramPacket) throws TFTPPacketException {
/* 107 */     super(5, paramDatagramPacket.getAddress(), paramDatagramPacket.getPort());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     byte[] arrayOfByte = paramDatagramPacket.getData();
/* 114 */     int i = paramDatagramPacket.getLength();
/*     */     
/* 116 */     if (getType() != arrayOfByte[1]) {
/* 117 */       throw new TFTPPacketException("TFTP operator code does not match type.");
/*     */     }
/*     */     
/* 120 */     this.error = (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF;
/*     */     
/* 122 */     if (i < 5) {
/* 123 */       throw new TFTPPacketException("Bad error packet. No message.");
/*     */     }
/*     */     
/* 126 */     byte b = 4;
/* 127 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 129 */     while (b < i && arrayOfByte[b] != 0) {
/*     */       
/* 131 */       stringBuilder.append((char)arrayOfByte[b]);
/* 132 */       b++;
/*     */     } 
/*     */     
/* 135 */     this.message = stringBuilder.toString();
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
/*     */   DatagramPacket newDatagram(DatagramPacket paramDatagramPacket, byte[] paramArrayOfbyte) {
/* 154 */     int i = this.message.length();
/*     */     
/* 156 */     paramArrayOfbyte[0] = 0;
/* 157 */     paramArrayOfbyte[1] = (byte)this.type;
/* 158 */     paramArrayOfbyte[2] = (byte)((this.error & 0xFFFF) >> 8);
/* 159 */     paramArrayOfbyte[3] = (byte)(this.error & 0xFF);
/*     */     
/* 161 */     System.arraycopy(this.message.getBytes(), 0, paramArrayOfbyte, 4, i);
/*     */     
/* 163 */     paramArrayOfbyte[i + 4] = 0;
/*     */     
/* 165 */     paramDatagramPacket.setAddress(this.address);
/* 166 */     paramDatagramPacket.setPort(this.port);
/* 167 */     paramDatagramPacket.setData(paramArrayOfbyte);
/* 168 */     paramDatagramPacket.setLength(i + 4);
/*     */     
/* 170 */     return paramDatagramPacket;
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
/*     */   public DatagramPacket newDatagram() {
/* 192 */     int i = this.message.length();
/*     */     
/* 194 */     byte[] arrayOfByte = new byte[i + 5];
/* 195 */     arrayOfByte[0] = 0;
/* 196 */     arrayOfByte[1] = (byte)this.type;
/* 197 */     arrayOfByte[2] = (byte)((this.error & 0xFFFF) >> 8);
/* 198 */     arrayOfByte[3] = (byte)(this.error & 0xFF);
/*     */     
/* 200 */     System.arraycopy(this.message.getBytes(), 0, arrayOfByte, 4, i);
/*     */     
/* 202 */     arrayOfByte[i + 4] = 0;
/*     */     
/* 204 */     return new DatagramPacket(arrayOfByte, arrayOfByte.length, this.address, this.port);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getError() {
/* 215 */     return this.error;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 226 */     return this.message;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 235 */     return super.toString() + " ERR " + this.error + " " + this.message;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\tftp\TFTPErrorPacket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */