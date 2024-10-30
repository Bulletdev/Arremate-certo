/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.MappedByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.ReadableByteChannel;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ import java.nio.channels.WritableByteChannel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class FileBase
/*     */   extends FileChannel
/*     */ {
/*     */   public synchronized int read(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/*  39 */     long l = position();
/*  40 */     position(paramLong);
/*  41 */     int i = read(paramByteBuffer);
/*  42 */     position(l);
/*  43 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int write(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/*  49 */     long l = position();
/*  50 */     position(paramLong);
/*  51 */     int i = write(paramByteBuffer);
/*  52 */     position(l);
/*  53 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void force(boolean paramBoolean) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void implCloseChannel() throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileLock lock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/*  72 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MappedByteBuffer map(FileChannel.MapMode paramMapMode, long paramLong1, long paramLong2) throws IOException {
/*  78 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long read(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2) throws IOException {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long transferFrom(ReadableByteChannel paramReadableByteChannel, long paramLong1, long paramLong2) throws IOException {
/*  90 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long transferTo(long paramLong1, long paramLong2, WritableByteChannel paramWritableByteChannel) throws IOException {
/*  96 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FileLock tryLock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/* 102 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long write(ByteBuffer[] paramArrayOfByteBuffer, int paramInt1, int paramInt2) throws IOException {
/* 108 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public abstract long size() throws IOException;
/*     */   
/*     */   public abstract long position() throws IOException;
/*     */   
/*     */   public abstract FileChannel position(long paramLong) throws IOException;
/*     */   
/*     */   public abstract int read(ByteBuffer paramByteBuffer) throws IOException;
/*     */   
/*     */   public abstract int write(ByteBuffer paramByteBuffer) throws IOException;
/*     */   
/*     */   public abstract FileChannel truncate(long paramLong) throws IOException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */