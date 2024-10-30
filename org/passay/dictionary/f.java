/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.CharsetDecoder;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */   extends a
/*     */ {
/*     */   private static final int jh = 8192;
/*  23 */   private final byte[] bytes = new byte[8192];
/*     */ 
/*     */   
/*  26 */   private final ByteBuffer buffer = ByteBuffer.wrap(this.bytes);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f(RandomAccessFile paramRandomAccessFile) throws IOException {
/*  43 */     this(paramRandomAccessFile, true);
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
/*     */   public f(RandomAccessFile paramRandomAccessFile, boolean paramBoolean) throws IOException {
/*  62 */     this(paramRandomAccessFile, paramBoolean, 5);
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
/*     */   public f(RandomAccessFile paramRandomAccessFile, boolean paramBoolean, int paramInt) throws IOException {
/*  83 */     this(paramRandomAccessFile, paramBoolean, paramInt, StandardCharsets.UTF_8.newDecoder());
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
/*     */ 
/*     */   
/*     */   public f(RandomAccessFile paramRandomAccessFile, boolean paramBoolean, int paramInt, CharsetDecoder paramCharsetDecoder) throws IOException {
/* 109 */     this(paramRandomAccessFile, paramBoolean, paramInt, paramCharsetDecoder, false);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public f(RandomAccessFile paramRandomAccessFile, boolean paramBoolean1, int paramInt, CharsetDecoder paramCharsetDecoder, boolean paramBoolean2) throws IOException {
/* 137 */     super(paramRandomAccessFile, paramBoolean1, paramCharsetDecoder);
/* 138 */     b(paramInt, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void seek(long paramLong) throws IOException {
/* 146 */     this.file.seek(paramLong);
/* 147 */     this.buffer.clear();
/* 148 */     fill();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ByteBuffer a() {
/* 155 */     return this.buffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fill() throws IOException {
/* 163 */     this.buffer.clear();
/* 164 */     int i = this.file.read(this.bytes);
/* 165 */     this.buffer.limit((i > 0) ? i : 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */