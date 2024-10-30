/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EndianUtils
/*     */ {
/*     */   public static short swapShort(short paramShort) {
/*  57 */     return (short)(((paramShort >> 0 & 0xFF) << 8) + ((paramShort >> 8 & 0xFF) << 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int swapInteger(int paramInt) {
/*  67 */     return ((paramInt >> 0 & 0xFF) << 24) + ((paramInt >> 8 & 0xFF) << 16) + ((paramInt >> 16 & 0xFF) << 8) + ((paramInt >> 24 & 0xFF) << 0);
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
/*     */   public static long swapLong(long paramLong) {
/*  80 */     return ((paramLong >> 0L & 0xFFL) << 56L) + ((paramLong >> 8L & 0xFFL) << 48L) + ((paramLong >> 16L & 0xFFL) << 40L) + ((paramLong >> 24L & 0xFFL) << 32L) + ((paramLong >> 32L & 0xFFL) << 24L) + ((paramLong >> 40L & 0xFFL) << 16L) + ((paramLong >> 48L & 0xFFL) << 8L) + ((paramLong >> 56L & 0xFFL) << 0L);
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
/*     */   public static float swapFloat(float paramFloat) {
/*  97 */     return Float.intBitsToFloat(swapInteger(Float.floatToIntBits(paramFloat)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double swapDouble(double paramDouble) {
/* 106 */     return Double.longBitsToDouble(swapLong(Double.doubleToLongBits(paramDouble)));
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
/*     */   public static void writeSwappedShort(byte[] paramArrayOfbyte, int paramInt, short paramShort) {
/* 119 */     paramArrayOfbyte[paramInt + 0] = (byte)(paramShort >> 0 & 0xFF);
/* 120 */     paramArrayOfbyte[paramInt + 1] = (byte)(paramShort >> 8 & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static short readSwappedShort(byte[] paramArrayOfbyte, int paramInt) {
/* 131 */     return (short)(((paramArrayOfbyte[paramInt + 0] & 0xFF) << 0) + ((paramArrayOfbyte[paramInt + 1] & 0xFF) << 8));
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
/*     */   public static int readSwappedUnsignedShort(byte[] paramArrayOfbyte, int paramInt) {
/* 144 */     return ((paramArrayOfbyte[paramInt + 0] & 0xFF) << 0) + ((paramArrayOfbyte[paramInt + 1] & 0xFF) << 8);
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
/*     */   public static void writeSwappedInteger(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 156 */     paramArrayOfbyte[paramInt1 + 0] = (byte)(paramInt2 >> 0 & 0xFF);
/* 157 */     paramArrayOfbyte[paramInt1 + 1] = (byte)(paramInt2 >> 8 & 0xFF);
/* 158 */     paramArrayOfbyte[paramInt1 + 2] = (byte)(paramInt2 >> 16 & 0xFF);
/* 159 */     paramArrayOfbyte[paramInt1 + 3] = (byte)(paramInt2 >> 24 & 0xFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int readSwappedInteger(byte[] paramArrayOfbyte, int paramInt) {
/* 170 */     return ((paramArrayOfbyte[paramInt + 0] & 0xFF) << 0) + ((paramArrayOfbyte[paramInt + 1] & 0xFF) << 8) + ((paramArrayOfbyte[paramInt + 2] & 0xFF) << 16) + ((paramArrayOfbyte[paramInt + 3] & 0xFF) << 24);
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
/*     */   public static long readSwappedUnsignedInteger(byte[] paramArrayOfbyte, int paramInt) {
/* 185 */     long l1 = (((paramArrayOfbyte[paramInt + 0] & 0xFF) << 0) + ((paramArrayOfbyte[paramInt + 1] & 0xFF) << 8) + ((paramArrayOfbyte[paramInt + 2] & 0xFF) << 16));
/*     */ 
/*     */ 
/*     */     
/* 189 */     long l2 = (paramArrayOfbyte[paramInt + 3] & 0xFF);
/*     */     
/* 191 */     return (l2 << 24L) + (0xFFFFFFFFL & l1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeSwappedLong(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
/* 202 */     paramArrayOfbyte[paramInt + 0] = (byte)(int)(paramLong >> 0L & 0xFFL);
/* 203 */     paramArrayOfbyte[paramInt + 1] = (byte)(int)(paramLong >> 8L & 0xFFL);
/* 204 */     paramArrayOfbyte[paramInt + 2] = (byte)(int)(paramLong >> 16L & 0xFFL);
/* 205 */     paramArrayOfbyte[paramInt + 3] = (byte)(int)(paramLong >> 24L & 0xFFL);
/* 206 */     paramArrayOfbyte[paramInt + 4] = (byte)(int)(paramLong >> 32L & 0xFFL);
/* 207 */     paramArrayOfbyte[paramInt + 5] = (byte)(int)(paramLong >> 40L & 0xFFL);
/* 208 */     paramArrayOfbyte[paramInt + 6] = (byte)(int)(paramLong >> 48L & 0xFFL);
/* 209 */     paramArrayOfbyte[paramInt + 7] = (byte)(int)(paramLong >> 56L & 0xFFL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long readSwappedLong(byte[] paramArrayOfbyte, int paramInt) {
/* 220 */     long l1 = readSwappedInteger(paramArrayOfbyte, paramInt);
/* 221 */     long l2 = readSwappedInteger(paramArrayOfbyte, paramInt + 4);
/* 222 */     return (l2 << 32L) + (0xFFFFFFFFL & l1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeSwappedFloat(byte[] paramArrayOfbyte, int paramInt, float paramFloat) {
/* 233 */     writeSwappedInteger(paramArrayOfbyte, paramInt, Float.floatToIntBits(paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float readSwappedFloat(byte[] paramArrayOfbyte, int paramInt) {
/* 244 */     return Float.intBitsToFloat(readSwappedInteger(paramArrayOfbyte, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void writeSwappedDouble(byte[] paramArrayOfbyte, int paramInt, double paramDouble) {
/* 255 */     writeSwappedLong(paramArrayOfbyte, paramInt, Double.doubleToLongBits(paramDouble));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double readSwappedDouble(byte[] paramArrayOfbyte, int paramInt) {
/* 266 */     return Double.longBitsToDouble(readSwappedLong(paramArrayOfbyte, paramInt));
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
/*     */   public static void writeSwappedShort(OutputStream paramOutputStream, short paramShort) throws IOException {
/* 279 */     paramOutputStream.write((byte)(paramShort >> 0 & 0xFF));
/* 280 */     paramOutputStream.write((byte)(paramShort >> 8 & 0xFF));
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
/*     */   public static short readSwappedShort(InputStream paramInputStream) throws IOException {
/* 293 */     return 
/* 294 */       (short)(((read(paramInputStream) & 0xFF) << 0) + ((read(paramInputStream) & 0xFF) << 8));
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
/*     */   public static int readSwappedUnsignedShort(InputStream paramInputStream) throws IOException {
/* 307 */     int i = read(paramInputStream);
/* 308 */     int j = read(paramInputStream);
/*     */     
/* 310 */     return ((i & 0xFF) << 0) + ((j & 0xFF) << 8);
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
/*     */   public static void writeSwappedInteger(OutputStream paramOutputStream, int paramInt) throws IOException {
/* 324 */     paramOutputStream.write((byte)(paramInt >> 0 & 0xFF));
/* 325 */     paramOutputStream.write((byte)(paramInt >> 8 & 0xFF));
/* 326 */     paramOutputStream.write((byte)(paramInt >> 16 & 0xFF));
/* 327 */     paramOutputStream.write((byte)(paramInt >> 24 & 0xFF));
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
/*     */   public static int readSwappedInteger(InputStream paramInputStream) throws IOException {
/* 340 */     int i = read(paramInputStream);
/* 341 */     int j = read(paramInputStream);
/* 342 */     int k = read(paramInputStream);
/* 343 */     int m = read(paramInputStream);
/*     */     
/* 345 */     return ((i & 0xFF) << 0) + ((j & 0xFF) << 8) + ((k & 0xFF) << 16) + ((m & 0xFF) << 24);
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
/*     */   public static long readSwappedUnsignedInteger(InputStream paramInputStream) throws IOException {
/* 361 */     int i = read(paramInputStream);
/* 362 */     int j = read(paramInputStream);
/* 363 */     int k = read(paramInputStream);
/* 364 */     int m = read(paramInputStream);
/*     */     
/* 366 */     long l1 = (((i & 0xFF) << 0) + ((j & 0xFF) << 8) + ((k & 0xFF) << 16));
/*     */ 
/*     */ 
/*     */     
/* 370 */     long l2 = (m & 0xFF);
/*     */     
/* 372 */     return (l2 << 24L) + (0xFFFFFFFFL & l1);
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
/*     */   public static void writeSwappedLong(OutputStream paramOutputStream, long paramLong) throws IOException {
/* 385 */     paramOutputStream.write((byte)(int)(paramLong >> 0L & 0xFFL));
/* 386 */     paramOutputStream.write((byte)(int)(paramLong >> 8L & 0xFFL));
/* 387 */     paramOutputStream.write((byte)(int)(paramLong >> 16L & 0xFFL));
/* 388 */     paramOutputStream.write((byte)(int)(paramLong >> 24L & 0xFFL));
/* 389 */     paramOutputStream.write((byte)(int)(paramLong >> 32L & 0xFFL));
/* 390 */     paramOutputStream.write((byte)(int)(paramLong >> 40L & 0xFFL));
/* 391 */     paramOutputStream.write((byte)(int)(paramLong >> 48L & 0xFFL));
/* 392 */     paramOutputStream.write((byte)(int)(paramLong >> 56L & 0xFFL));
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
/*     */   public static long readSwappedLong(InputStream paramInputStream) throws IOException {
/* 405 */     byte[] arrayOfByte = new byte[8];
/* 406 */     for (byte b = 0; b < 8; b++) {
/* 407 */       arrayOfByte[b] = (byte)read(paramInputStream);
/*     */     }
/* 409 */     return readSwappedLong(arrayOfByte, 0);
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
/*     */   public static void writeSwappedFloat(OutputStream paramOutputStream, float paramFloat) throws IOException {
/* 422 */     writeSwappedInteger(paramOutputStream, Float.floatToIntBits(paramFloat));
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
/*     */   public static float readSwappedFloat(InputStream paramInputStream) throws IOException {
/* 435 */     return Float.intBitsToFloat(readSwappedInteger(paramInputStream));
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
/*     */   public static void writeSwappedDouble(OutputStream paramOutputStream, double paramDouble) throws IOException {
/* 448 */     writeSwappedLong(paramOutputStream, Double.doubleToLongBits(paramDouble));
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
/*     */   public static double readSwappedDouble(InputStream paramInputStream) throws IOException {
/* 461 */     return Double.longBitsToDouble(readSwappedLong(paramInputStream));
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
/*     */   private static int read(InputStream paramInputStream) throws IOException {
/* 473 */     int i = paramInputStream.read();
/*     */     
/* 475 */     if (-1 == i) {
/* 476 */       throw new EOFException("Unexpected EOF reached");
/*     */     }
/*     */     
/* 479 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\EndianUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */