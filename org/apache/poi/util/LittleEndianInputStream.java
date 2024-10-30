/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LittleEndianInputStream
/*     */   extends FilterInputStream
/*     */   implements LittleEndianInput
/*     */ {
/*     */   public LittleEndianInputStream(InputStream paramInputStream) {
/*  34 */     super(paramInputStream);
/*     */   }
/*     */   
/*     */   public int available() {
/*     */     try {
/*  39 */       return super.available();
/*  40 */     } catch (IOException iOException) {
/*  41 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public byte readByte() {
/*  46 */     return (byte)readUByte();
/*     */   }
/*     */   
/*     */   public int readUByte() {
/*  50 */     byte[] arrayOfByte = new byte[1];
/*     */     try {
/*  52 */       checkEOF(read(arrayOfByte), 1);
/*  53 */     } catch (IOException iOException) {
/*  54 */       throw new RuntimeException(iOException);
/*     */     } 
/*  56 */     return LittleEndian.getUByte(arrayOfByte);
/*     */   }
/*     */   
/*     */   public double readDouble() {
/*  60 */     return Double.longBitsToDouble(readLong());
/*     */   }
/*     */   
/*     */   public int readInt() {
/*  64 */     byte[] arrayOfByte = new byte[4];
/*     */     try {
/*  66 */       checkEOF(read(arrayOfByte), arrayOfByte.length);
/*  67 */     } catch (IOException iOException) {
/*  68 */       throw new RuntimeException(iOException);
/*     */     } 
/*  70 */     return LittleEndian.getInt(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long readUInt() {
/*  81 */     long l = readInt();
/*  82 */     return l & 0xFFFFFFFFL;
/*     */   }
/*     */   
/*     */   public long readLong() {
/*  86 */     byte[] arrayOfByte = new byte[8];
/*     */     try {
/*  88 */       checkEOF(read(arrayOfByte), 8);
/*  89 */     } catch (IOException iOException) {
/*  90 */       throw new RuntimeException(iOException);
/*     */     } 
/*  92 */     return LittleEndian.getLong(arrayOfByte);
/*     */   }
/*     */   
/*     */   public short readShort() {
/*  96 */     return (short)readUShort();
/*     */   }
/*     */   
/*     */   public int readUShort() {
/* 100 */     byte[] arrayOfByte = new byte[2];
/*     */     try {
/* 102 */       checkEOF(read(arrayOfByte), 2);
/* 103 */     } catch (IOException iOException) {
/* 104 */       throw new RuntimeException(iOException);
/*     */     } 
/* 106 */     return LittleEndian.getUShort(arrayOfByte);
/*     */   }
/*     */   
/*     */   private static void checkEOF(int paramInt1, int paramInt2) {
/* 110 */     if (paramInt2 != 0 && (paramInt1 == -1 || paramInt1 != paramInt2)) {
/* 111 */       throw new RuntimeException("Unexpected end-of-file");
/*     */     }
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/* 116 */     readFully(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*     */     try {
/* 121 */       checkEOF(read(paramArrayOfbyte, paramInt1, paramInt2), paramInt2);
/* 122 */     } catch (IOException iOException) {
/* 123 */       throw new RuntimeException(iOException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LittleEndianInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */