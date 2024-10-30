/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.MappedByteBuffer;
/*     */ import java.nio.channels.FileChannel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class h
/*     */   extends a
/*     */ {
/*     */   private final MappedByteBuffer a;
/*     */   
/*     */   public h(RandomAccessFile paramRandomAccessFile) throws IOException {
/*  41 */     this(paramRandomAccessFile, true);
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
/*     */   public h(RandomAccessFile paramRandomAccessFile, boolean paramBoolean) throws IOException {
/*  60 */     this(paramRandomAccessFile, paramBoolean, 5);
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
/*     */   public h(RandomAccessFile paramRandomAccessFile, boolean paramBoolean, int paramInt) throws IOException {
/*  81 */     this(paramRandomAccessFile, paramBoolean, paramInt, StandardCharsets.UTF_8.newDecoder());
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
/*     */   public h(RandomAccessFile paramRandomAccessFile, boolean paramBoolean, int paramInt, CharsetDecoder paramCharsetDecoder) throws IOException {
/* 107 */     this(paramRandomAccessFile, paramBoolean, paramInt, paramCharsetDecoder, false);
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
/*     */   public h(RandomAccessFile paramRandomAccessFile, boolean paramBoolean1, int paramInt, CharsetDecoder paramCharsetDecoder, boolean paramBoolean2) throws IOException {
/* 135 */     super(paramRandomAccessFile, paramBoolean1, paramCharsetDecoder);
/* 136 */     FileChannel fileChannel = this.file.getChannel();
/* 137 */     this.a = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size());
/* 138 */     b(paramInt, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void seek(long paramLong) throws IOException {
/* 146 */     this.a.clear().position((int)paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ByteBuffer a() {
/* 153 */     return this.a;
/*     */   }
/*     */   
/*     */   protected void fill() throws IOException {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */