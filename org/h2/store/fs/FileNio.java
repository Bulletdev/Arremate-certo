/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.NonWritableChannelException;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FileNio
/*     */   extends FileBase
/*     */ {
/*     */   private final String name;
/*     */   private final FileChannel channel;
/*     */   
/*     */   FileNio(String paramString1, String paramString2) throws IOException {
/*  42 */     this.name = paramString1;
/*  43 */     this.channel = (new RandomAccessFile(paramString1, paramString2)).getChannel();
/*     */   }
/*     */ 
/*     */   
/*     */   public void implCloseChannel() throws IOException {
/*  48 */     this.channel.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public long position() throws IOException {
/*  53 */     return this.channel.position();
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() throws IOException {
/*  58 */     return this.channel.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer) throws IOException {
/*  63 */     return this.channel.read(paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel position(long paramLong) throws IOException {
/*  68 */     this.channel.position(paramLong);
/*  69 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/*  74 */     return this.channel.read(paramByteBuffer, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/*  79 */     return this.channel.write(paramByteBuffer, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel truncate(long paramLong) throws IOException {
/*  84 */     long l = this.channel.size();
/*  85 */     if (paramLong < l) {
/*  86 */       long l1 = this.channel.position();
/*  87 */       this.channel.truncate(paramLong);
/*  88 */       long l2 = this.channel.position();
/*  89 */       if (l1 < paramLong) {
/*     */ 
/*     */         
/*  92 */         if (l2 != l1) {
/*  93 */           this.channel.position(l1);
/*     */         }
/*  95 */       } else if (l2 > paramLong) {
/*     */ 
/*     */         
/*  98 */         this.channel.position(paramLong);
/*     */       } 
/*     */     } 
/* 101 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void force(boolean paramBoolean) throws IOException {
/* 106 */     this.channel.force(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer) throws IOException {
/*     */     try {
/* 112 */       return this.channel.write(paramByteBuffer);
/* 113 */     } catch (NonWritableChannelException nonWritableChannelException) {
/* 114 */       throw new IOException("read only");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized FileLock tryLock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/* 121 */     return this.channel.tryLock(paramLong1, paramLong2, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 126 */     return "nio:" + this.name;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileNio.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */