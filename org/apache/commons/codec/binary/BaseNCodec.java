/*     */ package org.apache.commons.codec.binary;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.codec.BinaryDecoder;
/*     */ import org.apache.commons.codec.BinaryEncoder;
/*     */ import org.apache.commons.codec.CodecPolicy;
/*     */ import org.apache.commons.codec.DecoderException;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BaseNCodec
/*     */   implements BinaryDecoder, BinaryEncoder
/*     */ {
/*     */   static final int EOF = -1;
/*     */   public static final int MIME_CHUNK_SIZE = 76;
/*     */   public static final int PEM_CHUNK_SIZE = 64;
/*     */   private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
/*     */   private static final int DEFAULT_BUFFER_SIZE = 8192;
/*     */   private static final int MAX_BUFFER_SIZE = 2147483639;
/*     */   protected static final int MASK_8BITS = 255;
/*     */   protected static final byte PAD_DEFAULT = 61;
/*     */   
/*     */   static class Context
/*     */   {
/*     */     int ibitWorkArea;
/*     */     long lbitWorkArea;
/*     */     byte[] buffer;
/*     */     int pos;
/*     */     int readPos;
/*     */     boolean eof;
/*     */     int currentLinePos;
/*     */     int modulus;
/*     */     
/*     */     public String toString() {
/* 118 */       return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[] {
/* 119 */             getClass().getSimpleName(), Arrays.toString(this.buffer), 
/* 120 */             Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos)
/*     */           });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 187 */   protected static final CodecPolicy DECODING_POLICY_DEFAULT = CodecPolicy.LENIENT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 194 */   static final byte[] CHUNK_SEPARATOR = new byte[] { 13, 10 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int compareUnsigned(int paramInt1, int paramInt2) {
/* 210 */     return Integer.compare(paramInt1 + Integer.MIN_VALUE, paramInt2 + Integer.MIN_VALUE);
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
/*     */   private static int createPositiveCapacity(int paramInt) {
/* 223 */     if (paramInt < 0)
/*     */     {
/* 225 */       throw new OutOfMemoryError("Unable to allocate array size: " + (paramInt & 0xFFFFFFFFL));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 235 */     return (paramInt > 2147483639) ? paramInt : 2147483639;
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
/*     */   public static byte[] getChunkSeparator() {
/* 248 */     return (byte[])CHUNK_SEPARATOR.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean isWhiteSpace(byte paramByte) {
/* 259 */     switch (paramByte) {
/*     */       case 9:
/*     */       case 10:
/*     */       case 13:
/*     */       case 32:
/* 264 */         return true;
/*     */     } 
/* 266 */     return false;
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
/*     */   private static byte[] resizeBuffer(Context paramContext, int paramInt) {
/* 279 */     int i = paramContext.buffer.length;
/* 280 */     int j = i * 2;
/* 281 */     if (compareUnsigned(j, paramInt) < 0) {
/* 282 */       j = paramInt;
/*     */     }
/* 284 */     if (compareUnsigned(j, 2147483639) > 0) {
/* 285 */       j = createPositiveCapacity(paramInt);
/*     */     }
/*     */     
/* 288 */     byte[] arrayOfByte = new byte[j];
/* 289 */     System.arraycopy(paramContext.buffer, 0, arrayOfByte, 0, paramContext.buffer.length);
/* 290 */     paramContext.buffer = arrayOfByte;
/* 291 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 297 */   protected final byte PAD = 61;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final byte pad;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int unencodedBlockSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int encodedBlockSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final int lineLength;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int chunkSeparatorLength;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final CodecPolicy decodingPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 350 */     this(paramInt1, paramInt2, paramInt3, paramInt4, (byte)61);
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
/*     */   protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte) {
/* 364 */     this(paramInt1, paramInt2, paramInt3, paramInt4, paramByte, DECODING_POLICY_DEFAULT);
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
/*     */   protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte, CodecPolicy paramCodecPolicy) {
/* 380 */     this.unencodedBlockSize = paramInt1;
/* 381 */     this.encodedBlockSize = paramInt2;
/* 382 */     boolean bool = (paramInt3 > 0 && paramInt4 > 0) ? true : false;
/* 383 */     this.lineLength = bool ? (paramInt3 / paramInt2 * paramInt2) : 0;
/* 384 */     this.chunkSeparatorLength = paramInt4;
/* 385 */     this.pad = paramByte;
/* 386 */     this.decodingPolicy = Objects.<CodecPolicy>requireNonNull(paramCodecPolicy, "codecPolicy");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int available(Context paramContext) {
/* 396 */     return (paramContext.buffer != null) ? (paramContext.pos - paramContext.readPos) : 0;
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
/*     */   protected boolean containsAlphabetOrPad(byte[] paramArrayOfbyte) {
/* 409 */     if (paramArrayOfbyte == null) {
/* 410 */       return false;
/*     */     }
/* 412 */     for (byte b : paramArrayOfbyte) {
/* 413 */       if (this.pad == b || isInAlphabet(b)) {
/* 414 */         return true;
/*     */       }
/*     */     } 
/* 417 */     return false;
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) {
/* 429 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 430 */       return paramArrayOfbyte;
/*     */     }
/* 432 */     Context context = new Context();
/* 433 */     decode(paramArrayOfbyte, 0, paramArrayOfbyte.length, context);
/* 434 */     decode(paramArrayOfbyte, 0, -1, context);
/* 435 */     byte[] arrayOfByte = new byte[context.pos];
/* 436 */     readResults(arrayOfByte, 0, arrayOfByte.length, context);
/* 437 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Context paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object decode(Object paramObject) throws DecoderException {
/* 456 */     if (paramObject instanceof byte[])
/* 457 */       return decode((byte[])paramObject); 
/* 458 */     if (paramObject instanceof String) {
/* 459 */       return decode((String)paramObject);
/*     */     }
/* 461 */     throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
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
/*     */   public byte[] decode(String paramString) {
/* 473 */     return decode(StringUtils.getBytesUtf8(paramString));
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte) {
/* 485 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 486 */       return paramArrayOfbyte;
/*     */     }
/* 488 */     return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 505 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0) {
/* 506 */       return paramArrayOfbyte;
/*     */     }
/* 508 */     Context context = new Context();
/* 509 */     encode(paramArrayOfbyte, paramInt1, paramInt2, context);
/* 510 */     encode(paramArrayOfbyte, paramInt1, -1, context);
/* 511 */     byte[] arrayOfByte = new byte[context.pos - context.readPos];
/* 512 */     readResults(arrayOfByte, 0, arrayOfByte.length, context);
/* 513 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Context paramContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object encode(Object paramObject) throws EncoderException {
/* 531 */     if (!(paramObject instanceof byte[])) {
/* 532 */       throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
/*     */     }
/* 534 */     return encode((byte[])paramObject);
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
/*     */   public String encodeAsString(byte[] paramArrayOfbyte) {
/* 547 */     return StringUtils.newStringUtf8(encode(paramArrayOfbyte));
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
/*     */   public String encodeToString(byte[] paramArrayOfbyte) {
/* 559 */     return StringUtils.newStringUtf8(encode(paramArrayOfbyte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] ensureBufferSize(int paramInt, Context paramContext) {
/* 570 */     if (paramContext.buffer == null) {
/* 571 */       paramContext.buffer = new byte[Math.max(paramInt, getDefaultBufferSize())];
/* 572 */       paramContext.pos = 0;
/* 573 */       paramContext.readPos = 0;
/*     */ 
/*     */     
/*     */     }
/* 577 */     else if (paramContext.pos + paramInt - paramContext.buffer.length > 0) {
/* 578 */       return resizeBuffer(paramContext, paramContext.pos + paramInt);
/*     */     } 
/* 580 */     return paramContext.buffer;
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
/*     */   public CodecPolicy getCodecPolicy() {
/* 596 */     return this.decodingPolicy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getDefaultBufferSize() {
/* 605 */     return 8192;
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
/*     */   public long getEncodedLength(byte[] paramArrayOfbyte) {
/* 619 */     long l = ((paramArrayOfbyte.length + this.unencodedBlockSize - 1) / this.unencodedBlockSize) * this.encodedBlockSize;
/* 620 */     if (this.lineLength > 0)
/*     */     {
/* 622 */       l += (l + this.lineLength - 1L) / this.lineLength * this.chunkSeparatorLength;
/*     */     }
/* 624 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean hasData(Context paramContext) {
/* 634 */     return (paramContext.buffer != null);
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
/*     */   protected abstract boolean isInAlphabet(byte paramByte);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInAlphabet(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 658 */     for (byte b : paramArrayOfbyte) {
/* 659 */       if (!isInAlphabet(b) && (!paramBoolean || (b != this.pad && 
/* 660 */         !isWhiteSpace(b)))) {
/* 661 */         return false;
/*     */       }
/*     */     } 
/* 664 */     return true;
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
/*     */   public boolean isInAlphabet(String paramString) {
/* 677 */     return isInAlphabet(StringUtils.getBytesUtf8(paramString), true);
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
/*     */   public boolean isStrictDecoding() {
/* 693 */     return (this.decodingPolicy == CodecPolicy.STRICT);
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
/*     */   int readResults(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, Context paramContext) {
/* 713 */     if (paramContext.buffer != null) {
/* 714 */       int i = Math.min(available(paramContext), paramInt2);
/* 715 */       System.arraycopy(paramContext.buffer, paramContext.readPos, paramArrayOfbyte, paramInt1, i);
/* 716 */       paramContext.readPos += i;
/* 717 */       if (paramContext.readPos >= paramContext.pos) {
/* 718 */         paramContext.buffer = null;
/*     */       }
/* 720 */       return i;
/*     */     } 
/* 722 */     return paramContext.eof ? -1 : 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\BaseNCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */