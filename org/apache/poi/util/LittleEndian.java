/*     */ package org.apache.poi.util;
/*     */ 
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
/*     */ public class LittleEndian
/*     */   implements LittleEndianConsts
/*     */ {
/*     */   public static final class BufferUnderrunException
/*     */     extends IOException
/*     */   {
/*     */     private static final long serialVersionUID = 8736973884877006145L;
/*     */     
/*     */     BufferUnderrunException() {
/*  52 */       super("buffer underrun");
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
/*     */   public static byte[] getByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  71 */     byte[] arrayOfByte = new byte[paramInt2];
/*  72 */     System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, paramInt2);
/*     */     
/*  74 */     return arrayOfByte;
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
/*     */   public static double getDouble(byte[] paramArrayOfbyte) {
/*  88 */     return Double.longBitsToDouble(getLong(paramArrayOfbyte, 0));
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
/*     */   public static double getDouble(byte[] paramArrayOfbyte, int paramInt) {
/* 104 */     return Double.longBitsToDouble(getLong(paramArrayOfbyte, paramInt));
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
/*     */   public static float getFloat(byte[] paramArrayOfbyte) {
/* 118 */     return getFloat(paramArrayOfbyte, 0);
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
/*     */   public static float getFloat(byte[] paramArrayOfbyte, int paramInt) {
/* 134 */     return Float.intBitsToFloat(getInt(paramArrayOfbyte, paramInt));
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
/*     */   public static int getInt(byte[] paramArrayOfbyte) {
/* 146 */     return getInt(paramArrayOfbyte, 0);
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
/*     */   public static int getInt(byte[] paramArrayOfbyte, int paramInt) {
/* 160 */     int i = paramInt;
/* 161 */     int j = paramArrayOfbyte[i++] & 0xFF;
/* 162 */     int k = paramArrayOfbyte[i++] & 0xFF;
/* 163 */     int m = paramArrayOfbyte[i++] & 0xFF;
/* 164 */     int n = paramArrayOfbyte[i++] & 0xFF;
/* 165 */     return (n << 24) + (m << 16) + (k << 8) + (j << 0);
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
/*     */   public static long getLong(byte[] paramArrayOfbyte) {
/* 177 */     return getLong(paramArrayOfbyte, 0);
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
/*     */   public static long getLong(byte[] paramArrayOfbyte, int paramInt) {
/* 191 */     long l = (0xFF & paramArrayOfbyte[paramInt + 7]);
/*     */     
/* 193 */     for (int i = paramInt + 8 - 1; i >= paramInt; i--) {
/*     */       
/* 195 */       l <<= 8L;
/* 196 */       l |= (0xFF & paramArrayOfbyte[i]);
/*     */     } 
/* 198 */     return l;
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
/*     */   public static short getShort(byte[] paramArrayOfbyte) {
/* 210 */     return getShort(paramArrayOfbyte, 0);
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
/*     */   public static short getShort(byte[] paramArrayOfbyte, int paramInt) {
/* 224 */     int i = paramArrayOfbyte[paramInt] & 0xFF;
/* 225 */     int j = paramArrayOfbyte[paramInt + 1] & 0xFF;
/* 226 */     return (short)((j << 8) + (i << 0));
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
/*     */   public static short[] getShortArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 243 */     short[] arrayOfShort = new short[paramInt2 / 2];
/* 244 */     for (byte b = 0; b < arrayOfShort.length; b++)
/*     */     {
/* 246 */       arrayOfShort[b] = getShort(paramArrayOfbyte, paramInt1 + b * 2);
/*     */     }
/* 248 */     return arrayOfShort;
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
/*     */   public static short getUByte(byte[] paramArrayOfbyte) {
/* 260 */     return (short)(paramArrayOfbyte[0] & 0xFF);
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
/*     */   public static short getUByte(byte[] paramArrayOfbyte, int paramInt) {
/* 274 */     return (short)(paramArrayOfbyte[paramInt] & 0xFF);
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
/*     */   public static long getUInt(byte[] paramArrayOfbyte) {
/* 286 */     return getUInt(paramArrayOfbyte, 0);
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
/*     */   public static long getUInt(byte[] paramArrayOfbyte, int paramInt) {
/* 300 */     long l = getInt(paramArrayOfbyte, paramInt);
/* 301 */     return l & 0xFFFFFFFFL;
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
/*     */   public static int getUShort(byte[] paramArrayOfbyte) {
/* 313 */     return getUShort(paramArrayOfbyte, 0);
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
/*     */   public static int getUShort(byte[] paramArrayOfbyte, int paramInt) {
/* 327 */     int i = paramArrayOfbyte[paramInt] & 0xFF;
/* 328 */     int j = paramArrayOfbyte[paramInt + 1] & 0xFF;
/* 329 */     return (j << 8) + (i << 0);
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
/*     */   public static void putByte(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 343 */     paramArrayOfbyte[paramInt1] = (byte)paramInt2;
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
/*     */   public static void putDouble(byte[] paramArrayOfbyte, int paramInt, double paramDouble) {
/* 358 */     putLong(paramArrayOfbyte, paramInt, Double.doubleToLongBits(paramDouble));
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
/*     */   public static void putDouble(double paramDouble, OutputStream paramOutputStream) throws IOException {
/* 374 */     putLong(Double.doubleToLongBits(paramDouble), paramOutputStream);
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
/*     */   public static void putFloat(byte[] paramArrayOfbyte, int paramInt, float paramFloat) {
/* 389 */     putInt(paramArrayOfbyte, paramInt, Float.floatToIntBits(paramFloat));
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
/*     */   public static void putFloat(float paramFloat, OutputStream paramOutputStream) throws IOException {
/* 405 */     putInt(Float.floatToIntBits(paramFloat), paramOutputStream);
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
/*     */   public static void putInt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 420 */     int i = paramInt1;
/* 421 */     paramArrayOfbyte[i++] = (byte)(paramInt2 >>> 0 & 0xFF);
/* 422 */     paramArrayOfbyte[i++] = (byte)(paramInt2 >>> 8 & 0xFF);
/* 423 */     paramArrayOfbyte[i++] = (byte)(paramInt2 >>> 16 & 0xFF);
/* 424 */     paramArrayOfbyte[i++] = (byte)(paramInt2 >>> 24 & 0xFF);
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
/*     */   public static void putInt(int paramInt, OutputStream paramOutputStream) throws IOException {
/* 440 */     paramOutputStream.write((byte)(paramInt >>> 0 & 0xFF));
/* 441 */     paramOutputStream.write((byte)(paramInt >>> 8 & 0xFF));
/* 442 */     paramOutputStream.write((byte)(paramInt >>> 16 & 0xFF));
/* 443 */     paramOutputStream.write((byte)(paramInt >>> 24 & 0xFF));
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
/*     */   public static void putLong(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
/* 458 */     paramArrayOfbyte[paramInt + 0] = (byte)(int)(paramLong >>> 0L & 0xFFL);
/* 459 */     paramArrayOfbyte[paramInt + 1] = (byte)(int)(paramLong >>> 8L & 0xFFL);
/* 460 */     paramArrayOfbyte[paramInt + 2] = (byte)(int)(paramLong >>> 16L & 0xFFL);
/* 461 */     paramArrayOfbyte[paramInt + 3] = (byte)(int)(paramLong >>> 24L & 0xFFL);
/* 462 */     paramArrayOfbyte[paramInt + 4] = (byte)(int)(paramLong >>> 32L & 0xFFL);
/* 463 */     paramArrayOfbyte[paramInt + 5] = (byte)(int)(paramLong >>> 40L & 0xFFL);
/* 464 */     paramArrayOfbyte[paramInt + 6] = (byte)(int)(paramLong >>> 48L & 0xFFL);
/* 465 */     paramArrayOfbyte[paramInt + 7] = (byte)(int)(paramLong >>> 56L & 0xFFL);
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
/*     */   public static void putLong(long paramLong, OutputStream paramOutputStream) throws IOException {
/* 481 */     paramOutputStream.write((byte)(int)(paramLong >>> 0L & 0xFFL));
/* 482 */     paramOutputStream.write((byte)(int)(paramLong >>> 8L & 0xFFL));
/* 483 */     paramOutputStream.write((byte)(int)(paramLong >>> 16L & 0xFFL));
/* 484 */     paramOutputStream.write((byte)(int)(paramLong >>> 24L & 0xFFL));
/* 485 */     paramOutputStream.write((byte)(int)(paramLong >>> 32L & 0xFFL));
/* 486 */     paramOutputStream.write((byte)(int)(paramLong >>> 40L & 0xFFL));
/* 487 */     paramOutputStream.write((byte)(int)(paramLong >>> 48L & 0xFFL));
/* 488 */     paramOutputStream.write((byte)(int)(paramLong >>> 56L & 0xFFL));
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
/*     */   public static void putShort(byte[] paramArrayOfbyte, int paramInt, short paramShort) {
/* 503 */     int i = paramInt;
/* 504 */     paramArrayOfbyte[i++] = (byte)(paramShort >>> 0 & 0xFF);
/* 505 */     paramArrayOfbyte[i++] = (byte)(paramShort >>> 8 & 0xFF);
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
/*     */   public static void putShort(OutputStream paramOutputStream, short paramShort) throws IOException {
/* 521 */     paramOutputStream.write((byte)(paramShort >>> 0 & 0xFF));
/* 522 */     paramOutputStream.write((byte)(paramShort >>> 8 & 0xFF));
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
/*     */   public static void putShortArray(byte[] paramArrayOfbyte, int paramInt, short[] paramArrayOfshort) {
/* 538 */     int i = paramInt;
/* 539 */     for (short s : paramArrayOfshort) {
/*     */       
/* 541 */       putShort(paramArrayOfbyte, i, s);
/* 542 */       i += 2;
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
/*     */   public static void putUByte(byte[] paramArrayOfbyte, int paramInt, short paramShort) {
/* 561 */     paramArrayOfbyte[paramInt] = (byte)(paramShort & 0xFF);
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
/*     */   public static void putUInt(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
/* 579 */     int i = paramInt;
/* 580 */     paramArrayOfbyte[i++] = (byte)(int)(paramLong >>> 0L & 0xFFL);
/* 581 */     paramArrayOfbyte[i++] = (byte)(int)(paramLong >>> 8L & 0xFFL);
/* 582 */     paramArrayOfbyte[i++] = (byte)(int)(paramLong >>> 16L & 0xFFL);
/* 583 */     paramArrayOfbyte[i++] = (byte)(int)(paramLong >>> 24L & 0xFFL);
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
/*     */   public static void putUInt(long paramLong, OutputStream paramOutputStream) throws IOException {
/* 599 */     paramOutputStream.write((byte)(int)(paramLong >>> 0L & 0xFFL));
/* 600 */     paramOutputStream.write((byte)(int)(paramLong >>> 8L & 0xFFL));
/* 601 */     paramOutputStream.write((byte)(int)(paramLong >>> 16L & 0xFFL));
/* 602 */     paramOutputStream.write((byte)(int)(paramLong >>> 24L & 0xFFL));
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
/*     */   public static void putUShort(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 620 */     int i = paramInt1;
/* 621 */     paramArrayOfbyte[i++] = (byte)(paramInt2 >>> 0 & 0xFF);
/* 622 */     paramArrayOfbyte[i++] = (byte)(paramInt2 >>> 8 & 0xFF);
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
/*     */   public static void putUShort(int paramInt, OutputStream paramOutputStream) throws IOException {
/* 638 */     paramOutputStream.write((byte)(paramInt >>> 0 & 0xFF));
/* 639 */     paramOutputStream.write((byte)(paramInt >>> 8 & 0xFF));
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
/*     */   public static int readInt(InputStream paramInputStream) throws IOException, BufferUnderrunException {
/* 656 */     int i = paramInputStream.read();
/* 657 */     int j = paramInputStream.read();
/* 658 */     int k = paramInputStream.read();
/* 659 */     int m = paramInputStream.read();
/* 660 */     if ((i | j | k | m) < 0)
/*     */     {
/* 662 */       throw new BufferUnderrunException();
/*     */     }
/* 664 */     return (m << 24) + (k << 16) + (j << 8) + (i << 0);
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
/*     */   public static long readUInt(InputStream paramInputStream) throws IOException, BufferUnderrunException {
/* 681 */     long l = readInt(paramInputStream);
/* 682 */     return l & 0xFFFFFFFFL;
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
/*     */   public static long readLong(InputStream paramInputStream) throws IOException, BufferUnderrunException {
/* 699 */     int i = paramInputStream.read();
/* 700 */     int j = paramInputStream.read();
/* 701 */     int k = paramInputStream.read();
/* 702 */     int m = paramInputStream.read();
/* 703 */     int n = paramInputStream.read();
/* 704 */     int i1 = paramInputStream.read();
/* 705 */     int i2 = paramInputStream.read();
/* 706 */     int i3 = paramInputStream.read();
/* 707 */     if ((i | j | k | m | n | i1 | i2 | i3) < 0)
/*     */     {
/* 709 */       throw new BufferUnderrunException();
/*     */     }
/*     */     
/* 712 */     return (i3 << 56L) + (i2 << 48L) + (i1 << 40L) + (n << 32L) + (m << 24L) + (k << 16) + (j << 8) + (i << 0);
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
/*     */   public static short readShort(InputStream paramInputStream) throws IOException, BufferUnderrunException {
/* 733 */     return (short)readUShort(paramInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int readUShort(InputStream paramInputStream) throws IOException, BufferUnderrunException {
/* 739 */     int i = paramInputStream.read();
/* 740 */     int j = paramInputStream.read();
/* 741 */     if ((i | j) < 0)
/*     */     {
/* 743 */       throw new BufferUnderrunException();
/*     */     }
/* 745 */     return (j << 8) + (i << 0);
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
/*     */   public static int ubyteToInt(byte paramByte) {
/* 758 */     return paramByte & 0xFF;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LittleEndian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */