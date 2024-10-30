/*     */ package org.apache.http.client.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.util.zip.Inflater;
/*     */ import java.util.zip.InflaterInputStream;
/*     */ import java.util.zip.ZipException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DeflateInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final InputStream sourceStream;
/*     */   
/*     */   public DeflateInputStream(InputStream paramInputStream) throws IOException {
/*  46 */     PushbackInputStream pushbackInputStream = new PushbackInputStream(paramInputStream, 2);
/*  47 */     int i = pushbackInputStream.read();
/*  48 */     int j = pushbackInputStream.read();
/*  49 */     if (i == -1 || j == -1) {
/*  50 */       throw new ZipException("Unexpected end of stream");
/*     */     }
/*     */     
/*  53 */     pushbackInputStream.unread(j);
/*  54 */     pushbackInputStream.unread(i);
/*     */     
/*  56 */     boolean bool = true;
/*  57 */     int k = i & 0xFF;
/*  58 */     int m = k & 0xF;
/*  59 */     int n = k >> 4 & 0xF;
/*  60 */     int i1 = j & 0xFF;
/*  61 */     if (m == 8 && n <= 7 && (k << 8 | i1) % 31 == 0) {
/*  62 */       bool = false;
/*     */     }
/*  64 */     this.sourceStream = new DeflateStream(pushbackInputStream, new Inflater(bool));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  72 */     return this.sourceStream.read();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/*  80 */     return this.sourceStream.read(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  88 */     return this.sourceStream.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/*  96 */     return this.sourceStream.skip(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() throws IOException {
/* 104 */     return this.sourceStream.available();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/* 112 */     this.sourceStream.mark(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() throws IOException {
/* 120 */     this.sourceStream.reset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 128 */     return this.sourceStream.markSupported();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 136 */     this.sourceStream.close();
/*     */   }
/*     */   
/*     */   static class DeflateStream
/*     */     extends InflaterInputStream {
/*     */     private boolean closed = false;
/*     */     
/*     */     public DeflateStream(InputStream param1InputStream, Inflater param1Inflater) {
/* 144 */       super(param1InputStream, param1Inflater);
/*     */     }
/*     */ 
/*     */     
/*     */     public void close() throws IOException {
/* 149 */       if (this.closed) {
/*     */         return;
/*     */       }
/* 152 */       this.closed = true;
/* 153 */       this.inf.end();
/* 154 */       super.close();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\entity\DeflateInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */