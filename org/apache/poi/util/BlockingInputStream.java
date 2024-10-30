/*     */ package org.apache.poi.util;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockingInputStream
/*     */   extends InputStream
/*     */ {
/*     */   protected InputStream is;
/*     */   
/*     */   public BlockingInputStream(InputStream paramInputStream) {
/*  44 */     this.is = paramInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() throws IOException {
/*  50 */     return this.is.available();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  56 */     this.is.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/*  61 */     this.is.mark(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/*  66 */     return this.is.markSupported();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  72 */     return this.is.read();
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
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/*  87 */     byte b = 0;
/*  88 */     int i = 4611;
/*  89 */     while (b < paramArrayOfbyte.length) {
/*     */       
/*  91 */       i = this.is.read();
/*  92 */       if (i == -1)
/*     */         break; 
/*  94 */       paramArrayOfbyte[b++] = (byte)i;
/*     */     } 
/*  96 */     if (b == 0 && i == -1)
/*  97 */       return -1; 
/*  98 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 104 */     return this.is.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() throws IOException {
/* 110 */     this.is.reset();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 116 */     return this.is.skip(paramLong);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\BlockingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */