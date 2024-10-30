/*      */ package org.apache.commons.net.util;
/*      */ 
/*      */ import java.math.BigInteger;
/*      */ import java.nio.charset.StandardCharsets;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Base64
/*      */ {
/*      */   private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
/*      */   private static final int DEFAULT_BUFFER_SIZE = 8192;
/*      */   static final int CHUNK_SIZE = 76;
/*   69 */   private static final byte[] CHUNK_SEPARATOR = new byte[] { 13, 10 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   78 */   private static final byte[] STANDARD_ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   91 */   private static final byte[] URL_SAFE_ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final byte PAD = 61;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  115 */   private static final byte[] DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MASK_6BITS = 63;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int MASK_8BITS = 255;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final byte[] encodeTable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int lineLength;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final byte[] lineSeparator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int decodeSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final int encodeSize;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private byte[] buffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int pos;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int readPos;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int currentLinePos;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int modulus;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean eof;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int x;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Base64() {
/*  215 */     this(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Base64(boolean paramBoolean) {
/*  234 */     this(76, CHUNK_SEPARATOR, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Base64(int paramInt) {
/*  256 */     this(paramInt, CHUNK_SEPARATOR);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Base64(int paramInt, byte[] paramArrayOfbyte) {
/*  282 */     this(paramInt, paramArrayOfbyte, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Base64(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
/*  311 */     if (paramArrayOfbyte == null) {
/*  312 */       paramInt = 0;
/*  313 */       paramArrayOfbyte = NetConstants.EMPTY_BTYE_ARRAY;
/*      */     } 
/*  315 */     this.lineLength = (paramInt > 0) ? (paramInt / 4 * 4) : 0;
/*  316 */     this.lineSeparator = new byte[paramArrayOfbyte.length];
/*  317 */     System.arraycopy(paramArrayOfbyte, 0, this.lineSeparator, 0, paramArrayOfbyte.length);
/*  318 */     if (paramInt > 0) {
/*  319 */       this.encodeSize = 4 + paramArrayOfbyte.length;
/*      */     } else {
/*  321 */       this.encodeSize = 4;
/*      */     } 
/*  323 */     this.decodeSize = this.encodeSize - 1;
/*  324 */     if (containsBase64Byte(paramArrayOfbyte)) {
/*  325 */       String str = newStringUtf8(paramArrayOfbyte);
/*  326 */       throw new IllegalArgumentException("lineSeperator must not contain base64 characters: [" + str + "]");
/*      */     } 
/*  328 */     this.encodeTable = paramBoolean ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isUrlSafe() {
/*  338 */     return (this.encodeTable == URL_SAFE_ENCODE_TABLE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean hasData() {
/*  347 */     return (this.buffer != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int avail() {
/*  356 */     return (this.buffer != null) ? (this.pos - this.readPos) : 0;
/*      */   }
/*      */ 
/*      */   
/*      */   private void resizeBuffer() {
/*  361 */     if (this.buffer == null) {
/*  362 */       this.buffer = new byte[8192];
/*  363 */       this.pos = 0;
/*  364 */       this.readPos = 0;
/*      */     } else {
/*  366 */       byte[] arrayOfByte = new byte[this.buffer.length * 2];
/*  367 */       System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.buffer.length);
/*  368 */       this.buffer = arrayOfByte;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int readResults(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  385 */     if (this.buffer != null) {
/*  386 */       int i = Math.min(avail(), paramInt2);
/*  387 */       if (this.buffer != paramArrayOfbyte) {
/*  388 */         System.arraycopy(this.buffer, this.readPos, paramArrayOfbyte, paramInt1, i);
/*  389 */         this.readPos += i;
/*  390 */         if (this.readPos >= this.pos) {
/*  391 */           this.buffer = null;
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/*  396 */         this.buffer = null;
/*      */       } 
/*  398 */       return i;
/*      */     } 
/*  400 */     return this.eof ? -1 : 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setInitialBuffer(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  417 */     if (paramArrayOfbyte != null && paramArrayOfbyte.length == paramInt2) {
/*  418 */       this.buffer = paramArrayOfbyte;
/*  419 */       this.pos = paramInt1;
/*  420 */       this.readPos = paramInt1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  443 */     if (this.eof) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  448 */     if (paramInt2 < 0) {
/*  449 */       this.eof = true;
/*  450 */       if (this.buffer == null || this.buffer.length - this.pos < this.encodeSize) {
/*  451 */         resizeBuffer();
/*      */       }
/*  453 */       switch (this.modulus) {
/*      */         case 1:
/*  455 */           this.buffer[this.pos++] = this.encodeTable[this.x >> 2 & 0x3F];
/*  456 */           this.buffer[this.pos++] = this.encodeTable[this.x << 4 & 0x3F];
/*      */           
/*  458 */           if (this.encodeTable == STANDARD_ENCODE_TABLE) {
/*  459 */             this.buffer[this.pos++] = 61;
/*  460 */             this.buffer[this.pos++] = 61;
/*      */           } 
/*      */           break;
/*      */         
/*      */         case 2:
/*  465 */           this.buffer[this.pos++] = this.encodeTable[this.x >> 10 & 0x3F];
/*  466 */           this.buffer[this.pos++] = this.encodeTable[this.x >> 4 & 0x3F];
/*  467 */           this.buffer[this.pos++] = this.encodeTable[this.x << 2 & 0x3F];
/*      */           
/*  469 */           if (this.encodeTable == STANDARD_ENCODE_TABLE) {
/*  470 */             this.buffer[this.pos++] = 61;
/*      */           }
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/*  476 */       if (this.lineLength > 0 && this.pos > 0) {
/*  477 */         System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
/*  478 */         this.pos += this.lineSeparator.length;
/*      */       } 
/*      */     } else {
/*  481 */       for (byte b = 0; b < paramInt2; b++) {
/*  482 */         if (this.buffer == null || this.buffer.length - this.pos < this.encodeSize) {
/*  483 */           resizeBuffer();
/*      */         }
/*  485 */         this.modulus = ++this.modulus % 3;
/*  486 */         byte b1 = paramArrayOfbyte[paramInt1++];
/*  487 */         if (b1 < 0) {
/*  488 */           b1 += 256;
/*      */         }
/*  490 */         this.x = (this.x << 8) + b1;
/*  491 */         if (0 == this.modulus) {
/*  492 */           this.buffer[this.pos++] = this.encodeTable[this.x >> 18 & 0x3F];
/*  493 */           this.buffer[this.pos++] = this.encodeTable[this.x >> 12 & 0x3F];
/*  494 */           this.buffer[this.pos++] = this.encodeTable[this.x >> 6 & 0x3F];
/*  495 */           this.buffer[this.pos++] = this.encodeTable[this.x & 0x3F];
/*  496 */           this.currentLinePos += 4;
/*  497 */           if (this.lineLength > 0 && this.lineLength <= this.currentLinePos) {
/*  498 */             System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
/*  499 */             this.pos += this.lineSeparator.length;
/*  500 */             this.currentLinePos = 0;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  531 */     if (this.eof) {
/*      */       return;
/*      */     }
/*  534 */     if (paramInt2 < 0) {
/*  535 */       this.eof = true;
/*      */     }
/*  537 */     for (byte b = 0; b < paramInt2; b++) {
/*  538 */       if (this.buffer == null || this.buffer.length - this.pos < this.decodeSize) {
/*  539 */         resizeBuffer();
/*      */       }
/*  541 */       byte b1 = paramArrayOfbyte[paramInt1++];
/*  542 */       if (b1 == 61) {
/*      */         
/*  544 */         this.eof = true;
/*      */         break;
/*      */       } 
/*  547 */       if (b1 >= 0 && b1 < DECODE_TABLE.length) {
/*  548 */         byte b2 = DECODE_TABLE[b1];
/*  549 */         if (b2 >= 0) {
/*  550 */           this.modulus = ++this.modulus % 4;
/*  551 */           this.x = (this.x << 6) + b2;
/*  552 */           if (this.modulus == 0) {
/*  553 */             this.buffer[this.pos++] = (byte)(this.x >> 16 & 0xFF);
/*  554 */             this.buffer[this.pos++] = (byte)(this.x >> 8 & 0xFF);
/*  555 */             this.buffer[this.pos++] = (byte)(this.x & 0xFF);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  564 */     if (this.eof && this.modulus != 0) {
/*  565 */       this.x <<= 6;
/*  566 */       switch (this.modulus) {
/*      */         case 2:
/*  568 */           this.x <<= 6;
/*  569 */           this.buffer[this.pos++] = (byte)(this.x >> 16 & 0xFF);
/*      */           break;
/*      */         case 3:
/*  572 */           this.buffer[this.pos++] = (byte)(this.x >> 16 & 0xFF);
/*  573 */           this.buffer[this.pos++] = (byte)(this.x >> 8 & 0xFF);
/*      */           break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isBase64(byte paramByte) {
/*  590 */     return (paramByte == 61 || (paramByte >= 0 && paramByte < DECODE_TABLE.length && DECODE_TABLE[paramByte] != -1));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isArrayByteBase64(byte[] paramArrayOfbyte) {
/*  603 */     for (byte b : paramArrayOfbyte) {
/*  604 */       if (!isBase64(b) && !isWhiteSpace(b)) {
/*  605 */         return false;
/*      */       }
/*      */     } 
/*  608 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean containsBase64Byte(byte[] paramArrayOfbyte) {
/*  619 */     for (byte b : paramArrayOfbyte) {
/*      */       
/*  621 */       if (isBase64(b)) {
/*  622 */         return true;
/*      */       }
/*      */     } 
/*  625 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] encodeBase64(byte[] paramArrayOfbyte) {
/*  636 */     return encodeBase64(paramArrayOfbyte, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String encodeBase64String(byte[] paramArrayOfbyte) {
/*  650 */     return newStringUtf8(encodeBase64(paramArrayOfbyte, true));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String encodeBase64StringUnChunked(byte[] paramArrayOfbyte) {
/*  664 */     return newStringUtf8(encodeBase64(paramArrayOfbyte, false));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String encodeBase64String(byte[] paramArrayOfbyte, boolean paramBoolean) {
/*  677 */     return newStringUtf8(encodeBase64(paramArrayOfbyte, paramBoolean));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] encodeBase64URLSafe(byte[] paramArrayOfbyte) {
/*  690 */     return encodeBase64(paramArrayOfbyte, false, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String encodeBase64URLSafeString(byte[] paramArrayOfbyte) {
/*  703 */     return newStringUtf8(encodeBase64(paramArrayOfbyte, false, true));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] encodeBase64Chunked(byte[] paramArrayOfbyte) {
/*  714 */     return encodeBase64(paramArrayOfbyte, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] decode(String paramString) {
/*  726 */     return decode(getBytesUtf8(paramString));
/*      */   }
/*      */   
/*      */   private byte[] getBytesUtf8(String paramString) {
/*  730 */     return paramString.getBytes(StandardCharsets.UTF_8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] decode(byte[] paramArrayOfbyte) {
/*  741 */     reset();
/*  742 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/*  743 */       return paramArrayOfbyte;
/*      */     }
/*  745 */     long l = (paramArrayOfbyte.length * 3 / 4);
/*  746 */     byte[] arrayOfByte1 = new byte[(int)l];
/*  747 */     setInitialBuffer(arrayOfByte1, 0, arrayOfByte1.length);
/*  748 */     decode(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*  749 */     decode(paramArrayOfbyte, 0, -1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  757 */     byte[] arrayOfByte2 = new byte[this.pos];
/*  758 */     readResults(arrayOfByte2, 0, arrayOfByte2.length);
/*  759 */     return arrayOfByte2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean) {
/*  774 */     return encodeBase64(paramArrayOfbyte, paramBoolean, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean1, boolean paramBoolean2) {
/*  792 */     return encodeBase64(paramArrayOfbyte, paramBoolean1, paramBoolean2, 2147483647);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/*  813 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/*  814 */       return paramArrayOfbyte;
/*      */     }
/*      */     
/*  817 */     long l = getEncodeLength(paramArrayOfbyte, paramBoolean1 ? 76 : 0, paramBoolean1 ? CHUNK_SEPARATOR : NetConstants.EMPTY_BTYE_ARRAY);
/*      */     
/*  819 */     if (l > paramInt) {
/*  820 */       throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maxium size of " + paramInt);
/*      */     }
/*      */ 
/*      */     
/*  824 */     Base64 base64 = paramBoolean1 ? new Base64(paramBoolean2) : new Base64(0, CHUNK_SEPARATOR, paramBoolean2);
/*  825 */     return base64.encode(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] decodeBase64(String paramString) {
/*  837 */     return (new Base64()).decode(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] decodeBase64(byte[] paramArrayOfbyte) {
/*  848 */     return (new Base64()).decode(paramArrayOfbyte);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isWhiteSpace(byte paramByte) {
/*  859 */     switch (paramByte) {
/*      */       case 9:
/*      */       case 10:
/*      */       case 13:
/*      */       case 32:
/*  864 */         return true;
/*      */     } 
/*  866 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String encodeToString(byte[] paramArrayOfbyte) {
/*  879 */     return newStringUtf8(encode(paramArrayOfbyte));
/*      */   }
/*      */   
/*      */   private static String newStringUtf8(byte[] paramArrayOfbyte) {
/*  883 */     return new String(paramArrayOfbyte, StandardCharsets.UTF_8);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public byte[] encode(byte[] paramArrayOfbyte) {
/*  894 */     reset();
/*  895 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/*  896 */       return paramArrayOfbyte;
/*      */     }
/*  898 */     long l = getEncodeLength(paramArrayOfbyte, this.lineLength, this.lineSeparator);
/*  899 */     byte[] arrayOfByte = new byte[(int)l];
/*  900 */     setInitialBuffer(arrayOfByte, 0, arrayOfByte.length);
/*  901 */     encode(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*  902 */     encode(paramArrayOfbyte, 0, -1);
/*      */     
/*  904 */     if (this.buffer != arrayOfByte) {
/*  905 */       readResults(arrayOfByte, 0, arrayOfByte.length);
/*      */     }
/*      */ 
/*      */     
/*  909 */     if (isUrlSafe() && this.pos < arrayOfByte.length) {
/*  910 */       byte[] arrayOfByte1 = new byte[this.pos];
/*  911 */       System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, this.pos);
/*  912 */       arrayOfByte = arrayOfByte1;
/*      */     } 
/*  914 */     return arrayOfByte;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getEncodeLength(byte[] paramArrayOfbyte1, int paramInt, byte[] paramArrayOfbyte2) {
/*  930 */     paramInt = paramInt / 4 * 4;
/*      */     
/*  932 */     long l1 = (paramArrayOfbyte1.length * 4 / 3);
/*  933 */     long l2 = l1 % 4L;
/*  934 */     if (l2 != 0L) {
/*  935 */       l1 += 4L - l2;
/*      */     }
/*  937 */     if (paramInt > 0) {
/*  938 */       boolean bool = (l1 % paramInt == 0L) ? true : false;
/*  939 */       l1 += l1 / paramInt * paramArrayOfbyte2.length;
/*  940 */       if (!bool) {
/*  941 */         l1 += paramArrayOfbyte2.length;
/*      */       }
/*      */     } 
/*  944 */     return l1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigInteger decodeInteger(byte[] paramArrayOfbyte) {
/*  957 */     return new BigInteger(1, decodeBase64(paramArrayOfbyte));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte[] encodeInteger(BigInteger paramBigInteger) {
/*  971 */     if (paramBigInteger == null) {
/*  972 */       throw new NullPointerException("encodeInteger called with null parameter");
/*      */     }
/*  974 */     return encodeBase64(toIntegerBytes(paramBigInteger), false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static byte[] toIntegerBytes(BigInteger paramBigInteger) {
/*  985 */     int i = paramBigInteger.bitLength();
/*      */     
/*  987 */     i = i + 7 >> 3 << 3;
/*  988 */     byte[] arrayOfByte1 = paramBigInteger.toByteArray();
/*      */     
/*  990 */     if (paramBigInteger.bitLength() % 8 != 0 && paramBigInteger.bitLength() / 8 + 1 == i / 8) {
/*  991 */       return arrayOfByte1;
/*      */     }
/*      */     
/*  994 */     boolean bool = false;
/*  995 */     int j = arrayOfByte1.length;
/*      */ 
/*      */     
/*  998 */     if (paramBigInteger.bitLength() % 8 == 0) {
/*  999 */       bool = true;
/* 1000 */       j--;
/*      */     } 
/* 1002 */     int k = i / 8 - j;
/* 1003 */     byte[] arrayOfByte2 = new byte[i / 8];
/* 1004 */     System.arraycopy(arrayOfByte1, bool, arrayOfByte2, k, j);
/* 1005 */     return arrayOfByte2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void reset() {
/* 1012 */     this.buffer = null;
/* 1013 */     this.pos = 0;
/* 1014 */     this.readPos = 0;
/* 1015 */     this.currentLinePos = 0;
/* 1016 */     this.modulus = 0;
/* 1017 */     this.eof = false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   int getLineLength() {
/* 1023 */     return this.lineLength;
/*      */   }
/*      */   
/*      */   byte[] getLineSeparator() {
/* 1027 */     return (byte[])this.lineSeparator.clone();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\ne\\util\Base64.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */