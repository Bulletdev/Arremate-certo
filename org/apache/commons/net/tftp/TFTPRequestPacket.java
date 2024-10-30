/*     */ package org.apache.commons.net.tftp;
/*     */ 
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.InetAddress;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TFTPRequestPacket
/*     */   extends TFTPPacket
/*     */ {
/*  56 */   static final String[] modeStrings = new String[] { "netascii", "octet" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private static final byte[][] modeBytes = new byte[][] { { 110, 101, 116, 97, 115, 99, 105, 105, 0 }, { 111, 99, 116, 101, 116, 0 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int mode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String fileName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TFTPRequestPacket(InetAddress paramInetAddress, int paramInt1, int paramInt2, String paramString, int paramInt3) {
/*  90 */     super(paramInt2, paramInetAddress, paramInt1);
/*     */     
/*  92 */     this.fileName = paramString;
/*  93 */     this.mode = paramInt3;
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
/*     */   TFTPRequestPacket(int paramInt, DatagramPacket paramDatagramPacket) throws TFTPPacketException {
/* 110 */     super(paramInt, paramDatagramPacket.getAddress(), paramDatagramPacket.getPort());
/*     */     
/* 112 */     byte[] arrayOfByte = paramDatagramPacket.getData();
/*     */     
/* 114 */     if (getType() != arrayOfByte[1]) {
/* 115 */       throw new TFTPPacketException("TFTP operator code does not match type.");
/*     */     }
/*     */     
/* 118 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 120 */     byte b1 = 2;
/* 121 */     int i = paramDatagramPacket.getLength();
/*     */     
/* 123 */     while (b1 < i && arrayOfByte[b1] != 0) {
/*     */       
/* 125 */       stringBuilder.append((char)arrayOfByte[b1]);
/* 126 */       b1++;
/*     */     } 
/*     */     
/* 129 */     this.fileName = stringBuilder.toString();
/*     */     
/* 131 */     if (b1 >= i) {
/* 132 */       throw new TFTPPacketException("Bad file name and mode format.");
/*     */     }
/*     */     
/* 135 */     stringBuilder.setLength(0);
/* 136 */     b1++;
/* 137 */     while (b1 < i && arrayOfByte[b1] != 0) {
/*     */       
/* 139 */       stringBuilder.append((char)arrayOfByte[b1]);
/* 140 */       b1++;
/*     */     } 
/*     */     
/* 143 */     String str = stringBuilder.toString().toLowerCase(Locale.ENGLISH);
/* 144 */     i = modeStrings.length;
/*     */     
/* 146 */     byte b2 = 0;
/* 147 */     for (b1 = 0; b1 < i; b1++) {
/*     */       
/* 149 */       if (str.equals(modeStrings[b1])) {
/*     */         
/* 151 */         b2 = b1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 156 */     this.mode = b2;
/*     */     
/* 158 */     if (b1 >= i)
/*     */     {
/* 160 */       throw new TFTPPacketException("Unrecognized TFTP transfer mode: " + str);
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
/*     */   final DatagramPacket newDatagram(DatagramPacket paramDatagramPacket, byte[] paramArrayOfbyte) {
/* 185 */     int i = this.fileName.length();
/* 186 */     int j = (modeBytes[this.mode]).length;
/*     */     
/* 188 */     paramArrayOfbyte[0] = 0;
/* 189 */     paramArrayOfbyte[1] = (byte)this.type;
/* 190 */     System.arraycopy(this.fileName.getBytes(), 0, paramArrayOfbyte, 2, i);
/* 191 */     paramArrayOfbyte[i + 2] = 0;
/* 192 */     System.arraycopy(modeBytes[this.mode], 0, paramArrayOfbyte, i + 3, j);
/*     */ 
/*     */     
/* 195 */     paramDatagramPacket.setAddress(this.address);
/* 196 */     paramDatagramPacket.setPort(this.port);
/* 197 */     paramDatagramPacket.setData(paramArrayOfbyte);
/* 198 */     paramDatagramPacket.setLength(i + j + 3);
/*     */     
/* 200 */     return paramDatagramPacket;
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
/*     */   public final DatagramPacket newDatagram() {
/* 221 */     int i = this.fileName.length();
/* 222 */     int j = (modeBytes[this.mode]).length;
/*     */     
/* 224 */     byte[] arrayOfByte = new byte[i + j + 4];
/* 225 */     arrayOfByte[0] = 0;
/* 226 */     arrayOfByte[1] = (byte)this.type;
/* 227 */     System.arraycopy(this.fileName.getBytes(), 0, arrayOfByte, 2, i);
/* 228 */     arrayOfByte[i + 2] = 0;
/* 229 */     System.arraycopy(modeBytes[this.mode], 0, arrayOfByte, i + 3, j);
/*     */ 
/*     */     
/* 232 */     return new DatagramPacket(arrayOfByte, arrayOfByte.length, this.address, this.port);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMode() {
/* 242 */     return this.mode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getFilename() {
/* 252 */     return this.fileName;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\tftp\TFTPRequestPacket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */