/*     */ package org.apache.commons.codec.binary;
/*     */ 
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
/*     */ public class Base32
/*     */   extends BaseNCodec
/*     */ {
/*     */   private static final int BITS_PER_ENCODED_BYTE = 5;
/*     */   private static final int BYTES_PER_ENCODED_BLOCK = 8;
/*     */   private static final int BYTES_PER_UNENCODED_BLOCK = 5;
/*  61 */   private static final byte[] DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   private static final byte[] ENCODE_TABLE = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   private static final byte[] HEX_DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 106 */   private static final byte[] HEX_ENCODE_TABLE = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MASK_5BITS = 31;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long MASK_4BITS = 15L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long MASK_3BITS = 7L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long MASK_2BITS = 3L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long MASK_1BITS = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int decodeSize;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] decodeTable;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int encodeSize;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] encodeTable;
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
/*     */   public Base32() {
/* 167 */     this(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base32(boolean paramBoolean) {
/* 178 */     this(0, (byte[])null, paramBoolean, (byte)61);
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
/*     */   public Base32(boolean paramBoolean, byte paramByte) {
/* 190 */     this(0, (byte[])null, paramBoolean, paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base32(byte paramByte) {
/* 201 */     this(false, paramByte);
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
/*     */   public Base32(int paramInt) {
/* 216 */     this(paramInt, CHUNK_SEPARATOR);
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
/*     */   public Base32(int paramInt, byte[] paramArrayOfbyte) {
/* 238 */     this(paramInt, paramArrayOfbyte, false, (byte)61);
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
/*     */   public Base32(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 263 */     this(paramInt, paramArrayOfbyte, paramBoolean, (byte)61);
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
/*     */   public Base32(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean, byte paramByte) {
/* 289 */     this(paramInt, paramArrayOfbyte, paramBoolean, paramByte, DECODING_POLICY_DEFAULT);
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
/*     */   public Base32(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean, byte paramByte, CodecPolicy paramCodecPolicy) {
/* 317 */     super(5, 8, paramInt, (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length, paramByte, paramCodecPolicy);
/*     */     
/* 319 */     if (paramBoolean) {
/* 320 */       this.encodeTable = HEX_ENCODE_TABLE;
/* 321 */       this.decodeTable = HEX_DECODE_TABLE;
/*     */     } else {
/* 323 */       this.encodeTable = ENCODE_TABLE;
/* 324 */       this.decodeTable = DECODE_TABLE;
/*     */     } 
/* 326 */     if (paramInt > 0) {
/* 327 */       if (paramArrayOfbyte == null) {
/* 328 */         throw new IllegalArgumentException("lineLength " + paramInt + " > 0, but lineSeparator is null");
/*     */       }
/*     */       
/* 331 */       if (containsAlphabetOrPad(paramArrayOfbyte)) {
/* 332 */         String str = StringUtils.newStringUtf8(paramArrayOfbyte);
/* 333 */         throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + str + "]");
/*     */       } 
/* 335 */       this.encodeSize = 8 + paramArrayOfbyte.length;
/* 336 */       this.lineSeparator = new byte[paramArrayOfbyte.length];
/* 337 */       System.arraycopy(paramArrayOfbyte, 0, this.lineSeparator, 0, paramArrayOfbyte.length);
/*     */     } else {
/* 339 */       this.encodeSize = 8;
/* 340 */       this.lineSeparator = null;
/*     */     } 
/* 342 */     this.decodeSize = this.encodeSize - 1;
/*     */     
/* 344 */     if (isInAlphabet(paramByte) || isWhiteSpace(paramByte)) {
/* 345 */       throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
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
/*     */   void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 374 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/* 377 */     if (paramInt2 < 0) {
/* 378 */       paramContext.eof = true;
/*     */     }
/* 380 */     for (byte b = 0; b < paramInt2; b++) {
/* 381 */       byte b1 = paramArrayOfbyte[paramInt1++];
/* 382 */       if (b1 == this.pad) {
/*     */         
/* 384 */         paramContext.eof = true;
/*     */         break;
/*     */       } 
/* 387 */       byte[] arrayOfByte = ensureBufferSize(this.decodeSize, paramContext);
/* 388 */       if (b1 >= 0 && b1 < this.decodeTable.length) {
/* 389 */         byte b2 = this.decodeTable[b1];
/* 390 */         if (b2 >= 0) {
/* 391 */           paramContext.modulus = (paramContext.modulus + 1) % 8;
/*     */           
/* 393 */           paramContext.lbitWorkArea = (paramContext.lbitWorkArea << 5L) + b2;
/* 394 */           if (paramContext.modulus == 0) {
/* 395 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 32L & 0xFFL);
/* 396 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 24L & 0xFFL);
/* 397 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 16L & 0xFFL);
/* 398 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 399 */             arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 408 */     if (paramContext.eof && paramContext.modulus > 0) {
/* 409 */       byte[] arrayOfByte = ensureBufferSize(this.decodeSize, paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 417 */       switch (paramContext.modulus) {
/*     */         
/*     */         case 1:
/* 420 */           validateTrailingCharacters();
/*     */         case 2:
/* 422 */           validateCharacter(3L, paramContext);
/* 423 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 2L & 0xFFL);
/*     */           return;
/*     */         case 3:
/* 426 */           validateTrailingCharacters();
/*     */           
/* 428 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 7L & 0xFFL);
/*     */           return;
/*     */         case 4:
/* 431 */           validateCharacter(15L, paramContext);
/* 432 */           paramContext.lbitWorkArea >>= 4L;
/* 433 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 434 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           return;
/*     */         case 5:
/* 437 */           validateCharacter(1L, paramContext);
/* 438 */           paramContext.lbitWorkArea >>= 1L;
/* 439 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 16L & 0xFFL);
/* 440 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 441 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           return;
/*     */         case 6:
/* 444 */           validateTrailingCharacters();
/*     */           
/* 446 */           paramContext.lbitWorkArea >>= 6L;
/* 447 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 16L & 0xFFL);
/* 448 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 449 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           return;
/*     */         case 7:
/* 452 */           validateCharacter(7L, paramContext);
/* 453 */           paramContext.lbitWorkArea >>= 3L;
/* 454 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 24L & 0xFFL);
/* 455 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 16L & 0xFFL);
/* 456 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea >> 8L & 0xFFL);
/* 457 */           arrayOfByte[paramContext.pos++] = (byte)(int)(paramContext.lbitWorkArea & 0xFFL);
/*     */           return;
/*     */       } 
/*     */       
/* 461 */       throw new IllegalStateException("Impossible modulus " + paramContext.modulus);
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
/*     */   void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 485 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 490 */     if (paramInt2 < 0) {
/* 491 */       paramContext.eof = true;
/* 492 */       if (0 == paramContext.modulus && this.lineLength == 0) {
/*     */         return;
/*     */       }
/* 495 */       byte[] arrayOfByte = ensureBufferSize(this.encodeSize, paramContext);
/* 496 */       int i = paramContext.pos;
/* 497 */       switch (paramContext.modulus) {
/*     */         case 0:
/*     */           break;
/*     */         case 1:
/* 501 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 3L) & 0x1F];
/* 502 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea << 2L) & 0x1F];
/* 503 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 504 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 505 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 506 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 507 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 508 */           arrayOfByte[paramContext.pos++] = this.pad;
/*     */           break;
/*     */         case 2:
/* 511 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 11L) & 0x1F];
/* 512 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 6L) & 0x1F];
/* 513 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 1L) & 0x1F];
/* 514 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea << 4L) & 0x1F];
/* 515 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 516 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 517 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 518 */           arrayOfByte[paramContext.pos++] = this.pad;
/*     */           break;
/*     */         case 3:
/* 521 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 19L) & 0x1F];
/* 522 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 14L) & 0x1F];
/* 523 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 9L) & 0x1F];
/* 524 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 4L) & 0x1F];
/* 525 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea << 1L) & 0x1F];
/* 526 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 527 */           arrayOfByte[paramContext.pos++] = this.pad;
/* 528 */           arrayOfByte[paramContext.pos++] = this.pad;
/*     */           break;
/*     */         case 4:
/* 531 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 27L) & 0x1F];
/* 532 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 22L) & 0x1F];
/* 533 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 17L) & 0x1F];
/* 534 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 12L) & 0x1F];
/* 535 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 7L) & 0x1F];
/* 536 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 2L) & 0x1F];
/* 537 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea << 3L) & 0x1F];
/* 538 */           arrayOfByte[paramContext.pos++] = this.pad;
/*     */           break;
/*     */         default:
/* 541 */           throw new IllegalStateException("Impossible modulus " + paramContext.modulus);
/*     */       } 
/* 543 */       paramContext.currentLinePos += paramContext.pos - i;
/*     */       
/* 545 */       if (this.lineLength > 0 && paramContext.currentLinePos > 0) {
/* 546 */         System.arraycopy(this.lineSeparator, 0, arrayOfByte, paramContext.pos, this.lineSeparator.length);
/* 547 */         paramContext.pos += this.lineSeparator.length;
/*     */       } 
/*     */     } else {
/* 550 */       for (byte b = 0; b < paramInt2; b++) {
/* 551 */         byte[] arrayOfByte = ensureBufferSize(this.encodeSize, paramContext);
/* 552 */         paramContext.modulus = (paramContext.modulus + 1) % 5;
/* 553 */         byte b1 = paramArrayOfbyte[paramInt1++];
/* 554 */         if (b1 < 0) {
/* 555 */           b1 += 256;
/*     */         }
/* 557 */         paramContext.lbitWorkArea = (paramContext.lbitWorkArea << 8L) + b1;
/* 558 */         if (0 == paramContext.modulus) {
/* 559 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 35L) & 0x1F];
/* 560 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 30L) & 0x1F];
/* 561 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 25L) & 0x1F];
/* 562 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 20L) & 0x1F];
/* 563 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 15L) & 0x1F];
/* 564 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 10L) & 0x1F];
/* 565 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)(paramContext.lbitWorkArea >> 5L) & 0x1F];
/* 566 */           arrayOfByte[paramContext.pos++] = this.encodeTable[(int)paramContext.lbitWorkArea & 0x1F];
/* 567 */           paramContext.currentLinePos += 8;
/* 568 */           if (this.lineLength > 0 && this.lineLength <= paramContext.currentLinePos) {
/* 569 */             System.arraycopy(this.lineSeparator, 0, arrayOfByte, paramContext.pos, this.lineSeparator.length);
/* 570 */             paramContext.pos += this.lineSeparator.length;
/* 571 */             paramContext.currentLinePos = 0;
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
/*     */   public boolean isInAlphabet(byte paramByte) {
/* 587 */     return (paramByte >= 0 && paramByte < this.decodeTable.length && this.decodeTable[paramByte] != -1);
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
/*     */   private void validateCharacter(long paramLong, BaseNCodec.Context paramContext) {
/* 604 */     if (isStrictDecoding() && (paramContext.lbitWorkArea & paramLong) != 0L) {
/* 605 */       throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
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
/*     */   private void validateTrailingCharacters() {
/* 618 */     if (isStrictDecoding())
/* 619 */       throw new IllegalArgumentException("Strict decoding: Last encoded character(s) (before the paddings if any) are valid base 32 alphabet but not a possible encoding. Decoding requires either 2, 4, 5, or 7 trailing 5-bit characters to create bytes."); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\Base32.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */