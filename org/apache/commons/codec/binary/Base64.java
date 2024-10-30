/*     */ package org.apache.commons.codec.binary;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.codec.CodecPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Base64
/*     */   extends BaseNCodec
/*     */ {
/*     */   private static final int BITS_PER_ENCODED_BYTE = 6;
/*     */   private static final int BYTES_PER_UNENCODED_BLOCK = 3;
/*     */   private static final int BYTES_PER_ENCODED_BLOCK = 4;
/*  74 */   private static final byte[] STANDARD_ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   private static final byte[] URL_SAFE_ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   private static final byte[] DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MASK_6BITS = 63;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MASK_4BITS = 15;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MASK_2BITS = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] encodeTable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decodeBase64(byte[] paramArrayOfbyte) {
/* 143 */     return (new Base64()).decode(paramArrayOfbyte);
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
/*     */   public static byte[] decodeBase64(String paramString) {
/* 158 */     return (new Base64()).decode(paramString);
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
/*     */   public static BigInteger decodeInteger(byte[] paramArrayOfbyte) {
/* 171 */     return new BigInteger(1, decodeBase64(paramArrayOfbyte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] encodeBase64(byte[] paramArrayOfbyte) {
/* 182 */     return encodeBase64(paramArrayOfbyte, false);
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
/*     */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 197 */     return encodeBase64(paramArrayOfbyte, paramBoolean, false);
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
/*     */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean1, boolean paramBoolean2) {
/* 216 */     return encodeBase64(paramArrayOfbyte, paramBoolean1, paramBoolean2, 2147483647);
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
/*     */   public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
/* 238 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 239 */       return paramArrayOfbyte;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 244 */     Base64 base64 = paramBoolean1 ? new Base64(paramBoolean2) : new Base64(0, CHUNK_SEPARATOR, paramBoolean2);
/* 245 */     long l = base64.getEncodedLength(paramArrayOfbyte);
/* 246 */     if (l > paramInt) {
/* 247 */       throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maximum size of " + paramInt);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 253 */     return base64.encode(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] encodeBase64Chunked(byte[] paramArrayOfbyte) {
/* 264 */     return encodeBase64(paramArrayOfbyte, true);
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
/*     */   public static String encodeBase64String(byte[] paramArrayOfbyte) {
/* 279 */     return StringUtils.newStringUsAscii(encodeBase64(paramArrayOfbyte, false));
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
/*     */   public static byte[] encodeBase64URLSafe(byte[] paramArrayOfbyte) {
/* 292 */     return encodeBase64(paramArrayOfbyte, false, true);
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
/*     */   public static String encodeBase64URLSafeString(byte[] paramArrayOfbyte) {
/* 305 */     return StringUtils.newStringUsAscii(encodeBase64(paramArrayOfbyte, false, true));
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
/*     */   public static byte[] encodeInteger(BigInteger paramBigInteger) {
/* 319 */     Objects.requireNonNull(paramBigInteger, "bigInteger");
/* 320 */     return encodeBase64(toIntegerBytes(paramBigInteger), false);
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
/*     */   @Deprecated
/*     */   public static boolean isArrayByteBase64(byte[] paramArrayOfbyte) {
/* 335 */     return isBase64(paramArrayOfbyte);
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
/*     */   public static boolean isBase64(byte paramByte) {
/* 347 */     return (paramByte == 61 || (paramByte >= 0 && paramByte < DECODE_TABLE.length && DECODE_TABLE[paramByte] != -1));
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
/*     */   public static boolean isBase64(byte[] paramArrayOfbyte) {
/* 361 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 362 */       if (!isBase64(paramArrayOfbyte[b]) && !isWhiteSpace(paramArrayOfbyte[b])) {
/* 363 */         return false;
/*     */       }
/*     */     } 
/* 366 */     return true;
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
/*     */   public static boolean isBase64(String paramString) {
/* 380 */     return isBase64(StringUtils.getBytesUtf8(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static byte[] toIntegerBytes(BigInteger paramBigInteger) {
/* 391 */     int i = paramBigInteger.bitLength();
/*     */     
/* 393 */     i = i + 7 >> 3 << 3;
/* 394 */     byte[] arrayOfByte1 = paramBigInteger.toByteArray();
/*     */     
/* 396 */     if (paramBigInteger.bitLength() % 8 != 0 && paramBigInteger.bitLength() / 8 + 1 == i / 8) {
/* 397 */       return arrayOfByte1;
/*     */     }
/*     */     
/* 400 */     boolean bool = false;
/* 401 */     int j = arrayOfByte1.length;
/*     */ 
/*     */     
/* 404 */     if (paramBigInteger.bitLength() % 8 == 0) {
/* 405 */       bool = true;
/* 406 */       j--;
/*     */     } 
/* 408 */     int k = i / 8 - j;
/* 409 */     byte[] arrayOfByte2 = new byte[i / 8];
/* 410 */     System.arraycopy(arrayOfByte1, bool, arrayOfByte2, k, j);
/* 411 */     return arrayOfByte2;
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
/* 422 */   private final byte[] decodeTable = DECODE_TABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] lineSeparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int decodeSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int encodeSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base64() {
/* 452 */     this(0);
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
/*     */   public Base64(boolean paramBoolean) {
/* 471 */     this(76, CHUNK_SEPARATOR, paramBoolean);
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
/*     */   public Base64(int paramInt) {
/* 494 */     this(paramInt, CHUNK_SEPARATOR);
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
/*     */   public Base64(int paramInt, byte[] paramArrayOfbyte) {
/* 521 */     this(paramInt, paramArrayOfbyte, false);
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
/*     */   public Base64(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 552 */     this(paramInt, paramArrayOfbyte, paramBoolean, DECODING_POLICY_DEFAULT);
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
/*     */   public Base64(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean, CodecPolicy paramCodecPolicy) {
/* 584 */     super(3, 4, paramInt, (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length, (byte)61, paramCodecPolicy);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 591 */     if (paramArrayOfbyte != null) {
/* 592 */       if (containsAlphabetOrPad(paramArrayOfbyte)) {
/* 593 */         String str = StringUtils.newStringUtf8(paramArrayOfbyte);
/* 594 */         throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + str + "]");
/*     */       } 
/* 596 */       if (paramInt > 0) {
/* 597 */         this.encodeSize = 4 + paramArrayOfbyte.length;
/* 598 */         this.lineSeparator = new byte[paramArrayOfbyte.length];
/* 599 */         System.arraycopy(paramArrayOfbyte, 0, this.lineSeparator, 0, paramArrayOfbyte.length);
/*     */       } else {
/* 601 */         this.encodeSize = 4;
/* 602 */         this.lineSeparator = null;
/*     */       } 
/*     */     } else {
/* 605 */       this.encodeSize = 4;
/* 606 */       this.lineSeparator = null;
/*     */     } 
/* 608 */     this.decodeSize = this.encodeSize - 1;
/* 609 */     this.encodeTable = paramBoolean ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
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
/*     */   void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 641 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/* 644 */     if (paramInt2 < 0) {
/* 645 */       paramContext.eof = true;
/*     */     }
/* 647 */     for (byte b = 0; b < paramInt2; b++) {
/* 648 */       byte[] arrayOfByte = ensureBufferSize(this.decodeSize, paramContext);
/* 649 */       byte b1 = paramArrayOfbyte[paramInt1++];
/* 650 */       if (b1 == this.pad) {
/*     */         
/* 652 */         paramContext.eof = true;
/*     */         break;
/*     */       } 
/* 655 */       if (b1 >= 0 && b1 < DECODE_TABLE.length) {
/* 656 */         byte b2 = DECODE_TABLE[b1];
/* 657 */         if (b2 >= 0) {
/* 658 */           paramContext.modulus = (paramContext.modulus + 1) % 4;
/* 659 */           paramContext.ibitWorkArea = (paramContext.ibitWorkArea << 6) + b2;
/* 660 */           if (paramContext.modulus == 0) {
/* 661 */             arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea >> 16 & 0xFF);
/* 662 */             arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea >> 8 & 0xFF);
/* 663 */             arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea & 0xFF);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 672 */     if (paramContext.eof && paramContext.modulus != 0) {
/* 673 */       byte[] arrayOfByte = ensureBufferSize(this.decodeSize, paramContext);
/*     */ 
/*     */ 
/*     */       
/* 677 */       switch (paramContext.modulus) {
/*     */         
/*     */         case 1:
/* 680 */           validateTrailingCharacter();
/*     */           return;
/*     */         case 2:
/* 683 */           validateCharacter(15, paramContext);
/* 684 */           paramContext.ibitWorkArea >>= 4;
/* 685 */           arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea & 0xFF);
/*     */           return;
/*     */         case 3:
/* 688 */           validateCharacter(3, paramContext);
/* 689 */           paramContext.ibitWorkArea >>= 2;
/* 690 */           arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea >> 8 & 0xFF);
/* 691 */           arrayOfByte[paramContext.pos++] = (byte)(paramContext.ibitWorkArea & 0xFF);
/*     */           return;
/*     */       } 
/* 694 */       throw new IllegalStateException("Impossible modulus " + paramContext.modulus);
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
/*     */   void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 722 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 727 */     if (paramInt2 < 0) {
/* 728 */       paramContext.eof = true;
/* 729 */       if (0 == paramContext.modulus && this.lineLength == 0) {
/*     */         return;
/*     */       }
/* 732 */       byte[] arrayOfByte = ensureBufferSize(this.encodeSize, paramContext);
/* 733 */       int i = paramContext.pos;
/* 734 */       switch (paramContext.modulus) {
/*     */         case 0:
/*     */           break;
/*     */         
/*     */         case 1:
/* 739 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 2 & 0x3F];
/*     */           
/* 741 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea << 4 & 0x3F];
/*     */           
/* 743 */           if (this.encodeTable == STANDARD_ENCODE_TABLE) {
/* 744 */             arrayOfByte[paramContext.pos++] = this.pad;
/* 745 */             arrayOfByte[paramContext.pos++] = this.pad;
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 2:
/* 750 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 10 & 0x3F];
/* 751 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 4 & 0x3F];
/* 752 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea << 2 & 0x3F];
/*     */           
/* 754 */           if (this.encodeTable == STANDARD_ENCODE_TABLE) {
/* 755 */             arrayOfByte[paramContext.pos++] = this.pad;
/*     */           }
/*     */           break;
/*     */         default:
/* 759 */           throw new IllegalStateException("Impossible modulus " + paramContext.modulus);
/*     */       } 
/* 761 */       paramContext.currentLinePos += paramContext.pos - i;
/*     */       
/* 763 */       if (this.lineLength > 0 && paramContext.currentLinePos > 0) {
/* 764 */         System.arraycopy(this.lineSeparator, 0, arrayOfByte, paramContext.pos, this.lineSeparator.length);
/* 765 */         paramContext.pos += this.lineSeparator.length;
/*     */       } 
/*     */     } else {
/* 768 */       for (byte b = 0; b < paramInt2; b++) {
/* 769 */         byte[] arrayOfByte = ensureBufferSize(this.encodeSize, paramContext);
/* 770 */         paramContext.modulus = (paramContext.modulus + 1) % 3;
/* 771 */         byte b1 = paramArrayOfbyte[paramInt1++];
/* 772 */         if (b1 < 0) {
/* 773 */           b1 += 256;
/*     */         }
/* 775 */         paramContext.ibitWorkArea = (paramContext.ibitWorkArea << 8) + b1;
/* 776 */         if (0 == paramContext.modulus) {
/* 777 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 18 & 0x3F];
/* 778 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 12 & 0x3F];
/* 779 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea >> 6 & 0x3F];
/* 780 */           arrayOfByte[paramContext.pos++] = this.encodeTable[paramContext.ibitWorkArea & 0x3F];
/* 781 */           paramContext.currentLinePos += 4;
/* 782 */           if (this.lineLength > 0 && this.lineLength <= paramContext.currentLinePos) {
/* 783 */             System.arraycopy(this.lineSeparator, 0, arrayOfByte, paramContext.pos, this.lineSeparator.length);
/* 784 */             paramContext.pos += this.lineSeparator.length;
/* 785 */             paramContext.currentLinePos = 0;
/*     */           } 
/*     */         } 
/*     */       } 
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
/*     */   protected boolean isInAlphabet(byte paramByte) {
/* 801 */     return (paramByte >= 0 && paramByte < this.decodeTable.length && this.decodeTable[paramByte] != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUrlSafe() {
/* 811 */     return (this.encodeTable == URL_SAFE_ENCODE_TABLE);
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
/*     */   private void validateCharacter(int paramInt, BaseNCodec.Context paramContext) {
/* 827 */     if (isStrictDecoding() && (paramContext.ibitWorkArea & paramInt) != 0) {
/* 828 */       throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
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
/*     */   private void validateTrailingCharacter() {
/* 841 */     if (isStrictDecoding())
/* 842 */       throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes."); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\Base64.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */