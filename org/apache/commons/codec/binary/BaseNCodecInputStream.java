/*     */ package org.apache.commons.codec.binary;
/*     */ 
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
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
/*     */ public class BaseNCodecInputStream
/*     */   extends FilterInputStream
/*     */ {
/*     */   private final BaseNCodec baseNCodec;
/*     */   private final boolean doEncode;
/*  40 */   private final byte[] singleByte = new byte[1];
/*     */   
/*  42 */   private final BaseNCodec.Context context = new BaseNCodec.Context();
/*     */   
/*     */   protected BaseNCodecInputStream(InputStream paramInputStream, BaseNCodec paramBaseNCodec, boolean paramBoolean) {
/*  45 */     super(paramInputStream);
/*  46 */     this.doEncode = paramBoolean;
/*  47 */     this.baseNCodec = paramBaseNCodec;
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
/*     */   public int available() throws IOException {
/*  64 */     return this.context.eof ? 0 : 1;
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
/*     */   public boolean isStrictDecoding() {
/*  78 */     return this.baseNCodec.isStrictDecoding();
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
/*     */   public synchronized void mark(int paramInt) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 101 */     return false;
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
/*     */   public int read() throws IOException {
/* 113 */     int i = read(this.singleByte, 0, 1);
/* 114 */     while (i == 0) {
/* 115 */       i = read(this.singleByte, 0, 1);
/*     */     }
/* 117 */     if (i > 0) {
/* 118 */       byte b = this.singleByte[0];
/* 119 */       return (b < 0) ? (256 + b) : b;
/*     */     } 
/* 121 */     return -1;
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 145 */     Objects.requireNonNull(paramArrayOfbyte, "array");
/* 146 */     if (paramInt1 < 0 || paramInt2 < 0)
/* 147 */       throw new IndexOutOfBoundsException(); 
/* 148 */     if (paramInt1 > paramArrayOfbyte.length || paramInt1 + paramInt2 > paramArrayOfbyte.length)
/* 149 */       throw new IndexOutOfBoundsException(); 
/* 150 */     if (paramInt2 == 0) {
/* 151 */       return 0;
/*     */     }
/* 153 */     int i = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     while (!i) {
/* 171 */       if (!this.baseNCodec.hasData(this.context)) {
/* 172 */         byte[] arrayOfByte = new byte[this.doEncode ? 4096 : 8192];
/* 173 */         int j = this.in.read(arrayOfByte);
/* 174 */         if (this.doEncode) {
/* 175 */           this.baseNCodec.encode(arrayOfByte, 0, j, this.context);
/*     */         } else {
/* 177 */           this.baseNCodec.decode(arrayOfByte, 0, j, this.context);
/*     */         } 
/*     */       } 
/* 180 */       i = this.baseNCodec.readResults(paramArrayOfbyte, paramInt1, paramInt2, this.context);
/*     */     } 
/* 182 */     return i;
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
/*     */   public synchronized void reset() throws IOException {
/* 196 */     throw new IOException("mark/reset not supported");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 207 */     if (paramLong < 0L) {
/* 208 */       throw new IllegalArgumentException("Negative skip length: " + paramLong);
/*     */     }
/*     */ 
/*     */     
/* 212 */     byte[] arrayOfByte = new byte[512];
/* 213 */     long l = paramLong;
/*     */     
/* 215 */     while (l > 0L) {
/* 216 */       int i = (int)Math.min(arrayOfByte.length, l);
/* 217 */       i = read(arrayOfByte, 0, i);
/* 218 */       if (i == -1) {
/*     */         break;
/*     */       }
/* 221 */       l -= i;
/*     */     } 
/*     */     
/* 224 */     return paramLong - l;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\BaseNCodecInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */