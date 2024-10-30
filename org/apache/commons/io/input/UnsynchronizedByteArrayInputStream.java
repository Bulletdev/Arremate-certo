/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.InputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnsynchronizedByteArrayInputStream
/*     */   extends InputStream
/*     */ {
/*     */   public static final int END_OF_STREAM = -1;
/*     */   private final byte[] data;
/*     */   private final int eod;
/*     */   private int offset;
/*     */   private int markedOffset;
/*     */   
/*     */   public UnsynchronizedByteArrayInputStream(byte[] paramArrayOfbyte) {
/*  68 */     Objects.requireNonNull(paramArrayOfbyte);
/*  69 */     this.data = paramArrayOfbyte;
/*  70 */     this.offset = 0;
/*  71 */     this.eod = paramArrayOfbyte.length;
/*  72 */     this.markedOffset = this.offset;
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
/*     */   public UnsynchronizedByteArrayInputStream(byte[] paramArrayOfbyte, int paramInt) {
/*  84 */     Objects.requireNonNull(paramArrayOfbyte);
/*  85 */     if (paramInt < 0) {
/*  86 */       throw new IllegalArgumentException("offset cannot be negative");
/*     */     }
/*  88 */     this.data = paramArrayOfbyte;
/*  89 */     this.offset = Math.min(paramInt, (paramArrayOfbyte.length > 0) ? paramArrayOfbyte.length : paramInt);
/*  90 */     this.eod = paramArrayOfbyte.length;
/*  91 */     this.markedOffset = this.offset;
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
/*     */   public UnsynchronizedByteArrayInputStream(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 105 */     Objects.requireNonNull(paramArrayOfbyte);
/* 106 */     if (paramInt1 < 0) {
/* 107 */       throw new IllegalArgumentException("offset cannot be negative");
/*     */     }
/* 109 */     if (paramInt2 < 0) {
/* 110 */       throw new IllegalArgumentException("length cannot be negative");
/*     */     }
/* 112 */     this.data = paramArrayOfbyte;
/* 113 */     this.offset = Math.min(paramInt1, (paramArrayOfbyte.length > 0) ? paramArrayOfbyte.length : paramInt1);
/* 114 */     this.eod = Math.min(this.offset + paramInt2, paramArrayOfbyte.length);
/* 115 */     this.markedOffset = this.offset;
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/* 120 */     return (this.offset < this.eod) ? (this.eod - this.offset) : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() {
/* 125 */     return (this.offset < this.eod) ? (this.data[this.offset++] & 0xFF) : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) {
/* 130 */     Objects.requireNonNull(paramArrayOfbyte);
/* 131 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 136 */     Objects.requireNonNull(paramArrayOfbyte);
/* 137 */     if (paramInt1 < 0 || paramInt2 < 0 || paramInt1 + paramInt2 > paramArrayOfbyte.length) {
/* 138 */       throw new IndexOutOfBoundsException();
/*     */     }
/*     */     
/* 141 */     if (this.offset >= this.eod) {
/* 142 */       return -1;
/*     */     }
/*     */     
/* 145 */     int i = this.eod - this.offset;
/* 146 */     if (paramInt2 < i) {
/* 147 */       i = paramInt2;
/*     */     }
/* 149 */     if (i <= 0) {
/* 150 */       return 0;
/*     */     }
/* 152 */     System.arraycopy(this.data, this.offset, paramArrayOfbyte, paramInt1, i);
/* 153 */     this.offset += i;
/* 154 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) {
/* 159 */     if (paramLong < 0L) {
/* 160 */       throw new IllegalArgumentException("Skipping backward is not supported");
/*     */     }
/*     */     
/* 163 */     long l = (this.eod - this.offset);
/* 164 */     if (paramLong < l) {
/* 165 */       l = paramLong;
/*     */     }
/*     */     
/* 168 */     this.offset = (int)(this.offset + l);
/* 169 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 174 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/* 180 */     this.markedOffset = this.offset;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 186 */     this.offset = this.markedOffset;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\UnsynchronizedByteArrayInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */