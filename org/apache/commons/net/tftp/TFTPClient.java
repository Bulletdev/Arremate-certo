/*     */ package org.apache.commons.net.tftp;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.SocketException;
/*     */ import java.net.UnknownHostException;
/*     */ import org.apache.commons.net.io.FromNetASCIIOutputStream;
/*     */ import org.apache.commons.net.io.ToNetASCIIInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TFTPClient
/*     */   extends TFTP
/*     */ {
/*     */   public static final int DEFAULT_MAX_TIMEOUTS = 5;
/*  82 */   private int maxTimeouts = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long totalBytesReceived;
/*     */ 
/*     */ 
/*     */   
/*     */   private long totalBytesSent;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxTimeouts(int paramInt) {
/*  97 */     if (paramInt < 1) {
/*  98 */       this.maxTimeouts = 1;
/*     */     } else {
/* 100 */       this.maxTimeouts = paramInt;
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
/*     */   public int getMaxTimeouts() {
/* 112 */     return this.maxTimeouts;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTotalBytesReceived() {
/* 120 */     return this.totalBytesReceived;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTotalBytesSent() {
/* 127 */     return this.totalBytesSent;
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
/*     */   public int receiveFile(String paramString, int paramInt1, OutputStream paramOutputStream, InetAddress paramInetAddress, int paramInt2) throws IOException {
/*     */     FromNetASCIIOutputStream fromNetASCIIOutputStream;
/* 150 */     int i = 0;
/* 151 */     int j = 0;
/* 152 */     byte b = 1;
/* 153 */     int k = 0;
/* 154 */     int m = 0;
/*     */     
/* 156 */     this.totalBytesReceived = 0L;
/*     */     
/* 158 */     if (paramInt1 == 0) {
/* 159 */       fromNetASCIIOutputStream = new FromNetASCIIOutputStream(paramOutputStream);
/*     */     }
/*     */     
/* 162 */     TFTPReadRequestPacket tFTPReadRequestPacket = new TFTPReadRequestPacket(paramInetAddress, paramInt2, paramString, paramInt1);
/* 163 */     TFTPAckPacket tFTPAckPacket = new TFTPAckPacket(paramInetAddress, paramInt2, 0);
/*     */     
/* 165 */     beginBufferedOps();
/*     */     
/* 167 */     boolean bool = true;
/*     */     try {
/*     */       while (true) {
/* 170 */         bufferedSend(tFTPReadRequestPacket);
/* 171 */         boolean bool1 = true;
/* 172 */         byte b1 = 0;
/*     */         do {
/*     */           try {
/* 175 */             TFTPPacket tFTPPacket = bufferedReceive();
/*     */ 
/*     */             
/* 178 */             int n = tFTPPacket.getPort();
/* 179 */             InetAddress inetAddress = tFTPPacket.getAddress();
/* 180 */             if (bool) {
/* 181 */               bool = false;
/* 182 */               if (n == paramInt2) {
/* 183 */                 TFTPErrorPacket tFTPErrorPacket = new TFTPErrorPacket(inetAddress, n, 5, "INCORRECT SOURCE PORT");
/*     */ 
/*     */                 
/* 186 */                 bufferedSend(tFTPErrorPacket);
/* 187 */                 throw new IOException("Incorrect source port (" + n + ") in request reply.");
/*     */               } 
/* 189 */               k = n;
/* 190 */               tFTPAckPacket.setPort(k);
/* 191 */               if (!paramInetAddress.equals(inetAddress)) {
/*     */                 
/* 193 */                 paramInetAddress = inetAddress;
/* 194 */                 tFTPAckPacket.setAddress(paramInetAddress);
/* 195 */                 tFTPReadRequestPacket.setAddress(paramInetAddress);
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 200 */             if (paramInetAddress.equals(inetAddress) && n == k) {
/* 201 */               TFTPErrorPacket tFTPErrorPacket; TFTPDataPacket tFTPDataPacket; switch (tFTPPacket.getType()) {
/*     */                 
/*     */                 case 5:
/* 204 */                   tFTPErrorPacket = (TFTPErrorPacket)tFTPPacket;
/* 205 */                   throw new IOException("Error code " + tFTPErrorPacket.getError() + " received: " + tFTPErrorPacket
/* 206 */                       .getMessage());
/*     */                 case 3:
/* 208 */                   tFTPDataPacket = (TFTPDataPacket)tFTPPacket;
/* 209 */                   m = tFTPDataPacket.getDataLength();
/* 210 */                   j = tFTPDataPacket.getBlockNumber();
/*     */                   
/* 212 */                   if (j == b) {
/*     */                     try {
/* 214 */                       fromNetASCIIOutputStream.write(tFTPDataPacket.getData(), tFTPDataPacket.getDataOffset(), m);
/* 215 */                     } catch (IOException iOException) {
/* 216 */                       tFTPErrorPacket = new TFTPErrorPacket(paramInetAddress, k, 3, "File write failed.");
/*     */ 
/*     */                       
/* 219 */                       bufferedSend(tFTPErrorPacket);
/* 220 */                       throw iOException;
/*     */                     } 
/* 222 */                     b++;
/* 223 */                     if (b > '￿')
/*     */                     {
/* 225 */                       b = 0;
/*     */                     }
/* 227 */                     bool1 = false; break;
/*     */                   } 
/* 229 */                   discardPackets();
/* 230 */                   if (j == ((b == 0) ? 65535 : (b - 1))) {
/* 231 */                     bool1 = false;
/*     */                   }
/*     */                   break;
/*     */ 
/*     */                 
/*     */                 default:
/* 237 */                   throw new IOException("Received unexpected packet type (" + tFTPPacket.getType() + ")");
/*     */               } 
/*     */             } else {
/* 240 */               TFTPErrorPacket tFTPErrorPacket = new TFTPErrorPacket(inetAddress, n, 5, "Unexpected host or port.");
/*     */ 
/*     */               
/* 243 */               bufferedSend(tFTPErrorPacket);
/*     */             } 
/* 245 */           } catch (SocketException|java.io.InterruptedIOException socketException) {
/* 246 */             if (++b1 >= this.maxTimeouts) {
/* 247 */               throw new IOException("Connection timed out.");
/*     */             }
/* 249 */           } catch (TFTPPacketException tFTPPacketException) {
/* 250 */             throw new IOException("Bad packet: " + tFTPPacketException.getMessage());
/*     */           } 
/* 252 */         } while (bool1);
/*     */         
/* 254 */         tFTPAckPacket.setBlockNumber(j);
/* 255 */         TFTPAckPacket tFTPAckPacket1 = tFTPAckPacket;
/* 256 */         i += m;
/* 257 */         this.totalBytesReceived += m;
/* 258 */         if (m != 512) {
/* 259 */           bufferedSend(tFTPAckPacket1);
/*     */ 
/*     */ 
/*     */           
/* 263 */           return i;
/*     */         } 
/*     */       } 
/*     */     } finally {
/*     */       endBufferedOps();
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
/*     */   public int receiveFile(String paramString1, int paramInt1, OutputStream paramOutputStream, String paramString2, int paramInt2) throws UnknownHostException, IOException {
/* 289 */     return receiveFile(paramString1, paramInt1, paramOutputStream, InetAddress.getByName(paramString2), paramInt2);
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
/*     */   public int receiveFile(String paramString, int paramInt, OutputStream paramOutputStream, InetAddress paramInetAddress) throws IOException {
/* 309 */     return receiveFile(paramString, paramInt, paramOutputStream, paramInetAddress, 69);
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
/*     */   public int receiveFile(String paramString1, int paramInt, OutputStream paramOutputStream, String paramString2) throws UnknownHostException, IOException {
/* 328 */     return receiveFile(paramString1, paramInt, paramOutputStream, InetAddress.getByName(paramString2), 69);
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
/*     */   public void sendFile(String paramString, int paramInt1, InputStream paramInputStream, InetAddress paramInetAddress, int paramInt2) throws IOException {
/*     */     ToNetASCIIInputStream toNetASCIIInputStream;
/* 353 */     byte b = 0;
/* 354 */     int i = 0;
/* 355 */     boolean bool1 = true;
/* 356 */     boolean bool2 = false;
/*     */     
/* 358 */     this.totalBytesSent = 0L;
/*     */     
/* 360 */     if (paramInt1 == 0) {
/* 361 */       toNetASCIIInputStream = new ToNetASCIIInputStream(paramInputStream);
/*     */     }
/*     */     
/* 364 */     TFTPWriteRequestPacket tFTPWriteRequestPacket = new TFTPWriteRequestPacket(paramInetAddress, paramInt2, paramString, paramInt1);
/* 365 */     TFTPDataPacket tFTPDataPacket = new TFTPDataPacket(paramInetAddress, paramInt2, 0, this.sendBuffer, 4, 0);
/*     */     
/* 367 */     beginBufferedOps();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*     */       while (true) {
/* 373 */         bufferedSend(tFTPWriteRequestPacket);
/* 374 */         boolean bool = true;
/* 375 */         byte b1 = 0;
/*     */         do {
/*     */           try {
/* 378 */             TFTPPacket tFTPPacket = bufferedReceive();
/* 379 */             InetAddress inetAddress = tFTPPacket.getAddress();
/* 380 */             int i1 = tFTPPacket.getPort();
/*     */ 
/*     */             
/* 383 */             if (bool1) {
/* 384 */               bool1 = false;
/* 385 */               if (i1 == paramInt2) {
/* 386 */                 TFTPErrorPacket tFTPErrorPacket = new TFTPErrorPacket(inetAddress, i1, 5, "INCORRECT SOURCE PORT");
/*     */ 
/*     */                 
/* 389 */                 bufferedSend(tFTPErrorPacket);
/* 390 */                 throw new IOException("Incorrect source port (" + i1 + ") in request reply.");
/*     */               } 
/* 392 */               i = i1;
/* 393 */               tFTPDataPacket.setPort(i);
/* 394 */               if (!paramInetAddress.equals(inetAddress)) {
/* 395 */                 paramInetAddress = inetAddress;
/* 396 */                 tFTPDataPacket.setAddress(paramInetAddress);
/* 397 */                 tFTPWriteRequestPacket.setAddress(paramInetAddress);
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 402 */             if (paramInetAddress.equals(inetAddress) && i1 == i) {
/*     */               TFTPErrorPacket tFTPErrorPacket; int i2;
/* 404 */               switch (tFTPPacket.getType()) {
/*     */                 case 5:
/* 406 */                   tFTPErrorPacket = (TFTPErrorPacket)tFTPPacket;
/* 407 */                   throw new IOException("Error code " + tFTPErrorPacket.getError() + " received: " + tFTPErrorPacket
/* 408 */                       .getMessage());
/*     */                 
/*     */                 case 4:
/* 411 */                   i2 = ((TFTPAckPacket)tFTPPacket).getBlockNumber();
/*     */                   
/* 413 */                   if (i2 == b) {
/* 414 */                     b++;
/* 415 */                     if (b > '￿')
/*     */                     {
/* 417 */                       b = 0;
/*     */                     }
/* 419 */                     bool = false; break;
/*     */                   } 
/* 421 */                   discardPackets();
/*     */                   break;
/*     */                 
/*     */                 default:
/* 425 */                   throw new IOException("Received unexpected packet type.");
/*     */               } 
/*     */             } else {
/* 428 */               TFTPErrorPacket tFTPErrorPacket = new TFTPErrorPacket(inetAddress, i1, 5, "Unexpected host or port.");
/*     */ 
/*     */ 
/*     */               
/* 432 */               bufferedSend(tFTPErrorPacket);
/*     */             } 
/* 434 */           } catch (SocketException|java.io.InterruptedIOException socketException) {
/* 435 */             if (++b1 >= this.maxTimeouts) {
/* 436 */               throw new IOException("Connection timed out.");
/*     */             }
/* 438 */           } catch (TFTPPacketException tFTPPacketException) {
/* 439 */             throw new IOException("Bad packet: " + tFTPPacketException.getMessage());
/*     */           }
/*     */         
/* 442 */         } while (bool);
/*     */         
/* 444 */         if (bool2) {
/*     */           break;
/*     */         }
/*     */         
/* 448 */         int j = 512;
/* 449 */         int k = 4;
/* 450 */         int m = 0;
/* 451 */         int n = 0;
/* 452 */         while (j > 0 && (
/* 453 */           n = toNetASCIIInputStream.read(this.sendBuffer, k, j)) > 0) {
/* 454 */           k += n;
/* 455 */           j -= n;
/* 456 */           m += n;
/*     */         } 
/* 458 */         if (m < 512)
/*     */         {
/* 460 */           bool2 = true;
/*     */         }
/* 462 */         tFTPDataPacket.setBlockNumber(b);
/* 463 */         tFTPDataPacket.setData(this.sendBuffer, 4, m);
/* 464 */         TFTPDataPacket tFTPDataPacket1 = tFTPDataPacket;
/* 465 */         this.totalBytesSent += m;
/*     */       } 
/*     */     } finally {
/* 468 */       endBufferedOps();
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
/*     */   public void sendFile(String paramString1, int paramInt1, InputStream paramInputStream, String paramString2, int paramInt2) throws UnknownHostException, IOException {
/* 495 */     sendFile(paramString1, paramInt1, paramInputStream, InetAddress.getByName(paramString2), paramInt2);
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
/*     */   public void sendFile(String paramString, int paramInt, InputStream paramInputStream, InetAddress paramInetAddress) throws IOException {
/* 515 */     sendFile(paramString, paramInt, paramInputStream, paramInetAddress, 69);
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
/*     */   public void sendFile(String paramString1, int paramInt, InputStream paramInputStream, String paramString2) throws UnknownHostException, IOException {
/* 534 */     sendFile(paramString1, paramInt, paramInputStream, InetAddress.getByName(paramString2), 69);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\tftp\TFTPClient.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */