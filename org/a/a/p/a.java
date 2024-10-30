/*     */ package org.a.a.p;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.math.BigInteger;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*     */   private a() {
/*  21 */     throw new Error("Do not instantiate");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(byte[] paramArrayOfbyte) {
/*  31 */     return ByteBuffer.wrap(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  41 */     return ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(ByteBuffer paramByteBuffer) {
/*  51 */     return paramByteBuffer.getInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short a(ByteBuffer paramByteBuffer) {
/*  61 */     return paramByteBuffer.getShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte a(ByteBuffer paramByteBuffer) {
/*  71 */     return paramByteBuffer.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte a(ByteBuffer paramByteBuffer, int paramInt) {
/*  81 */     return paramByteBuffer.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  91 */     return paramByteBuffer.get(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer, byte paramByte) {
/* 101 */     return paramByteBuffer.put(paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt, byte paramByte) {
/* 111 */     return paramByteBuffer.put(paramInt, paramByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer a(IntBuffer paramIntBuffer, int paramInt) {
/* 121 */     return paramIntBuffer.put(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer a(IntBuffer paramIntBuffer, int paramInt1, int paramInt2) {
/* 131 */     return paramIntBuffer.put(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer a(IntBuffer paramIntBuffer, int[] paramArrayOfint) {
/* 141 */     return paramIntBuffer.put(paramArrayOfint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IntBuffer a(IntBuffer paramIntBuffer, int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 151 */     return paramIntBuffer.put(paramArrayOfint, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(IntBuffer paramIntBuffer, int paramInt) {
/* 161 */     return paramIntBuffer.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer, short paramShort) {
/* 171 */     return paramByteBuffer.putShort(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt, short paramShort) {
/* 181 */     return paramByteBuffer.putShort(paramInt, paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt) {
/* 191 */     return paramByteBuffer.putInt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2) {
/* 201 */     return paramByteBuffer.putInt(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ByteBuffer a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
/* 211 */     return paramByteBuffer.putLong(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char a(RandomAccessFile paramRandomAccessFile) throws IOException {
/* 221 */     return paramRandomAccessFile.readChar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(RandomAccessFile paramRandomAccessFile) throws IOException {
/* 231 */     return paramRandomAccessFile.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long a(RandomAccessFile paramRandomAccessFile) throws IOException {
/* 241 */     return paramRandomAccessFile.readLong();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 252 */     return paramRandomAccessFile.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfbyte) throws IOException {
/* 263 */     paramRandomAccessFile.readFully(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 274 */     paramRandomAccessFile.write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(RandomAccessFile paramRandomAccessFile, byte paramByte) throws IOException {
/* 284 */     paramRandomAccessFile.writeByte(Byte.toUnsignedInt(paramByte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(RandomAccessFile paramRandomAccessFile, char paramChar) throws IOException {
/* 294 */     paramRandomAccessFile.writeChar(d(paramChar));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(RandomAccessFile paramRandomAccessFile, short paramShort) throws IOException {
/* 305 */     paramRandomAccessFile.writeShort(Short.toUnsignedInt(paramShort));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(RandomAccessFile paramRandomAccessFile, int paramInt) throws IOException {
/* 315 */     paramRandomAccessFile.writeInt(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(RandomAccessFile paramRandomAccessFile, long paramLong) throws IOException {
/* 325 */     paramRandomAccessFile.writeLong(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(ByteBuffer paramByteBuffer, byte[] paramArrayOfbyte) {
/* 335 */     paramByteBuffer.get(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(short paramShort1, short paramShort2) {
/* 346 */     return Integer.compareUnsigned(Short.toUnsignedInt(paramShort1), Short.toUnsignedInt(paramShort2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(byte paramByte1, byte paramByte2) {
/* 357 */     return Integer.compareUnsigned(Byte.toUnsignedInt(paramByte1), Byte.toUnsignedInt(paramByte2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(short paramShort) {
/* 363 */     return Long.toString(Short.toUnsignedLong(paramShort));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String a(short paramShort, int paramInt) {
/* 369 */     return Integer.toUnsignedString(Short.toUnsignedInt(paramShort), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String b(byte paramByte) {
/* 375 */     return Integer.toUnsignedString(Byte.toUnsignedInt(paramByte));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String b(byte paramByte, int paramInt) {
/* 381 */     return Integer.toUnsignedString(Byte.toUnsignedInt(paramByte), paramInt);
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
/*     */   private static BigInteger a(long paramLong) {
/* 393 */     if (paramLong >= 0L) {
/* 394 */       return BigInteger.valueOf(paramLong);
/*     */     }
/* 396 */     int i = (int)(paramLong >>> 32L);
/* 397 */     int j = (int)paramLong;
/*     */ 
/*     */     
/* 400 */     return BigInteger.valueOf(Integer.toUnsignedLong(i))
/* 401 */       .shiftLeft(32)
/* 402 */       .add(BigInteger.valueOf(Integer.toUnsignedLong(j)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short a(byte paramByte) {
/* 408 */     return (short)(paramByte & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static long e(char paramChar) {
/* 413 */     return paramChar & 0xFFL;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int d(char paramChar) {
/* 418 */     return paramChar & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public static short a(char paramChar) {
/* 423 */     return (short)(paramChar & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float a(byte paramByte) {
/* 428 */     return a(Byte.toUnsignedLong(paramByte)).floatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static float a(short paramShort) {
/* 433 */     return a(Short.toUnsignedLong(paramShort)).floatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static float a(int paramInt) {
/* 438 */     return a(Integer.toUnsignedLong(paramInt)).floatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static float a(long paramLong) {
/* 443 */     return a(paramLong).floatValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static double a(byte paramByte) {
/* 448 */     return a(Byte.toUnsignedLong(paramByte)).doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static double a(short paramShort) {
/* 453 */     return a(Short.toUnsignedLong(paramShort)).doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static double c(int paramInt) {
/* 458 */     return a(Integer.toUnsignedLong(paramInt)).doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static double a(long paramLong) {
/* 463 */     return a(paramLong).doubleValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte a(float paramFloat) {
/* 469 */     assert paramFloat >= 0.0F;
/* 470 */     return (byte)(int)paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short a(float paramFloat) {
/* 476 */     assert paramFloat >= 0.0F;
/* 477 */     return (short)(int)paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int b(float paramFloat) {
/* 483 */     assert paramFloat >= 0.0F;
/* 484 */     return (int)paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long a(float paramFloat) {
/* 490 */     assert paramFloat >= 0.0F;
/* 491 */     return (long)paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte a(double paramDouble) {
/* 497 */     assert paramDouble >= 0.0D;
/* 498 */     return (byte)(int)paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static short a(double paramDouble) {
/* 504 */     assert paramDouble >= 0.0D;
/* 505 */     return (short)(int)paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int e(double paramDouble) {
/* 511 */     assert paramDouble >= 0.0D;
/* 512 */     return (int)paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long b(double paramDouble) {
/* 518 */     assert paramDouble >= 0.0D;
/* 519 */     return (long)paramDouble;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\p\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */