/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.CharBuffer;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ import org.h2.engine.Constants;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CountingReaderInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final Reader reader;
/*  25 */   private final CharBuffer charBuffer = CharBuffer.allocate(4096);
/*     */ 
/*     */   
/*  28 */   private final CharsetEncoder encoder = Constants.UTF8.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
/*     */ 
/*     */ 
/*     */   
/*  32 */   private ByteBuffer byteBuffer = ByteBuffer.allocate(0);
/*     */   private long length;
/*     */   private long remaining;
/*     */   
/*     */   CountingReaderInputStream(Reader paramReader, long paramLong) {
/*  37 */     this.reader = paramReader;
/*  38 */     this.remaining = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  43 */     if (!fetch()) {
/*  44 */       return -1;
/*     */     }
/*  46 */     paramInt2 = Math.min(paramInt2, this.byteBuffer.remaining());
/*  47 */     this.byteBuffer.get(paramArrayOfbyte, paramInt1, paramInt2);
/*  48 */     return paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  53 */     if (!fetch()) {
/*  54 */       return -1;
/*     */     }
/*  56 */     return this.byteBuffer.get() & 0xFF;
/*     */   }
/*     */   
/*     */   private boolean fetch() throws IOException {
/*  60 */     if (this.byteBuffer != null && this.byteBuffer.remaining() == 0) {
/*  61 */       fillBuffer();
/*     */     }
/*  63 */     return (this.byteBuffer != null);
/*     */   }
/*     */   
/*     */   private void fillBuffer() throws IOException {
/*  67 */     int i = (int)Math.min((this.charBuffer.capacity() - this.charBuffer.position()), this.remaining);
/*     */     
/*  69 */     if (i > 0) {
/*  70 */       i = this.reader.read(this.charBuffer.array(), this.charBuffer.position(), i);
/*     */     }
/*  72 */     if (i > 0) {
/*  73 */       this.remaining -= i;
/*     */     } else {
/*  75 */       i = 0;
/*  76 */       this.remaining = 0L;
/*     */     } 
/*  78 */     this.length += i;
/*  79 */     this.charBuffer.limit(this.charBuffer.position() + i);
/*  80 */     this.charBuffer.rewind();
/*  81 */     this.byteBuffer = ByteBuffer.allocate(4096);
/*  82 */     boolean bool = (this.remaining == 0L) ? true : false;
/*  83 */     this.encoder.encode(this.charBuffer, this.byteBuffer, bool);
/*  84 */     if (bool && this.byteBuffer.position() == 0) {
/*     */       
/*  86 */       this.byteBuffer = null;
/*     */       return;
/*     */     } 
/*  89 */     this.byteBuffer.flip();
/*  90 */     this.charBuffer.compact();
/*  91 */     this.charBuffer.flip();
/*  92 */     this.charBuffer.position(this.charBuffer.limit());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLength() {
/* 102 */     return this.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 107 */     this.reader.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\CountingReaderInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */