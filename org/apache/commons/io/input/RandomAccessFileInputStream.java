/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RandomAccessFileInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final boolean closeOnClose;
/*     */   private final RandomAccessFile randomAccessFile;
/*     */   
/*     */   public RandomAccessFileInputStream(RandomAccessFile paramRandomAccessFile) {
/*  41 */     this(paramRandomAccessFile, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomAccessFileInputStream(RandomAccessFile paramRandomAccessFile, boolean paramBoolean) {
/*  51 */     this.randomAccessFile = Objects.<RandomAccessFile>requireNonNull(paramRandomAccessFile, "file");
/*  52 */     this.closeOnClose = paramBoolean;
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
/*     */   public int available() throws IOException {
/*  65 */     long l = availableLong();
/*  66 */     if (l > 2147483647L) {
/*  67 */       return Integer.MAX_VALUE;
/*     */     }
/*  69 */     return (int)l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long availableLong() throws IOException {
/*  79 */     return this.randomAccessFile.length() - this.randomAccessFile.getFilePointer();
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  84 */     super.close();
/*  85 */     if (this.closeOnClose) {
/*  86 */       this.randomAccessFile.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RandomAccessFile getRandomAccessFile() {
/*  96 */     return this.randomAccessFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCloseOnClose() {
/* 105 */     return this.closeOnClose;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 110 */     return this.randomAccessFile.read();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 115 */     return this.randomAccessFile.read(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 120 */     return this.randomAccessFile.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void seek(long paramLong) throws IOException {
/* 131 */     this.randomAccessFile.seek(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 136 */     if (paramLong <= 0L) {
/* 137 */       return 0L;
/*     */     }
/* 139 */     long l1 = this.randomAccessFile.getFilePointer();
/* 140 */     long l2 = this.randomAccessFile.length();
/* 141 */     if (l1 >= l2) {
/* 142 */       return 0L;
/*     */     }
/* 144 */     long l3 = l1 + paramLong;
/* 145 */     long l4 = (l3 > l2) ? (l2 - 1L) : l3;
/* 146 */     if (l4 > 0L) {
/* 147 */       seek(l4);
/*     */     }
/* 149 */     return this.randomAccessFile.getFilePointer() - l1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\RandomAccessFileInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */