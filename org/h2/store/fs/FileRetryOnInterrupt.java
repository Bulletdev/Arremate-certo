/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FileRetryOnInterrupt
/*     */   extends FileBase
/*     */ {
/*     */   private final String fileName;
/*     */   private final String mode;
/*     */   private FileChannel channel;
/*     */   private FileLockRetry lock;
/*     */   
/*     */   FileRetryOnInterrupt(String paramString1, String paramString2) throws IOException {
/*  51 */     this.fileName = paramString1;
/*  52 */     this.mode = paramString2;
/*  53 */     open();
/*     */   }
/*     */   
/*     */   private void open() throws IOException {
/*  57 */     this.channel = FileUtils.open(this.fileName, this.mode);
/*     */   }
/*     */   
/*     */   private void reopen(int paramInt, IOException paramIOException) throws IOException {
/*  61 */     if (paramInt > 20) {
/*  62 */       throw paramIOException;
/*     */     }
/*  64 */     if (!(paramIOException instanceof java.nio.channels.ClosedByInterruptException) && !(paramIOException instanceof java.nio.channels.ClosedChannelException))
/*     */     {
/*  66 */       throw paramIOException;
/*     */     }
/*     */     
/*  69 */     Thread.interrupted();
/*  70 */     FileChannel fileChannel = this.channel;
/*     */ 
/*     */ 
/*     */     
/*  74 */     synchronized (this) {
/*  75 */       if (fileChannel == this.channel) {
/*  76 */         open();
/*  77 */         reLock();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void reLock() throws IOException {
/*  83 */     if (this.lock == null) {
/*     */       return;
/*     */     }
/*     */     try {
/*  87 */       this.lock.base.release();
/*  88 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/*  91 */     FileLock fileLock = this.channel.tryLock(this.lock.position(), this.lock.size(), this.lock.isShared());
/*  92 */     if (fileLock == null) {
/*  93 */       throw new IOException("Re-locking failed");
/*     */     }
/*  95 */     this.lock.base = fileLock;
/*     */   }
/*     */ 
/*     */   
/*     */   public void implCloseChannel() throws IOException {
/*     */     try {
/* 101 */       this.channel.close();
/* 102 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long position() throws IOException {
/* 109 */     for (byte b = 0;; b++) {
/*     */       try {
/* 111 */         return this.channel.position();
/* 112 */       } catch (IOException iOException) {
/* 113 */         reopen(b, iOException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() throws IOException {
/* 120 */     for (byte b = 0;; b++) {
/*     */       try {
/* 122 */         return this.channel.size();
/* 123 */       } catch (IOException iOException) {
/* 124 */         reopen(b, iOException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer) throws IOException {
/* 131 */     long l = position();
/* 132 */     for (byte b = 0;; b++) {
/*     */       try {
/* 134 */         return this.channel.read(paramByteBuffer);
/* 135 */       } catch (IOException iOException) {
/* 136 */         reopen(b, iOException);
/* 137 */         position(l);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/* 144 */     for (byte b = 0;; b++) {
/*     */       try {
/* 146 */         return this.channel.read(paramByteBuffer, paramLong);
/* 147 */       } catch (IOException iOException) {
/* 148 */         reopen(b, iOException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel position(long paramLong) throws IOException {
/* 155 */     for (byte b = 0;; b++) {
/*     */       try {
/* 157 */         this.channel.position(paramLong);
/* 158 */         return this;
/* 159 */       } catch (IOException iOException) {
/* 160 */         reopen(b, iOException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel truncate(long paramLong) throws IOException {
/* 167 */     for (byte b = 0;; b++) {
/*     */       try {
/* 169 */         this.channel.truncate(paramLong);
/* 170 */         return this;
/* 171 */       } catch (IOException iOException) {
/* 172 */         reopen(b, iOException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void force(boolean paramBoolean) throws IOException {
/* 179 */     for (byte b = 0;; b++) {
/*     */       try {
/* 181 */         this.channel.force(paramBoolean);
/* 182 */       } catch (IOException iOException) {
/* 183 */         reopen(b, iOException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer) throws IOException {
/* 190 */     long l = position();
/* 191 */     for (byte b = 0;; b++) {
/*     */       try {
/* 193 */         return this.channel.write(paramByteBuffer);
/* 194 */       } catch (IOException iOException) {
/* 195 */         reopen(b, iOException);
/* 196 */         position(l);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/* 203 */     for (byte b = 0;; b++) {
/*     */       try {
/* 205 */         return this.channel.write(paramByteBuffer, paramLong);
/* 206 */       } catch (IOException iOException) {
/* 207 */         reopen(b, iOException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized FileLock tryLock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/* 215 */     FileLock fileLock = this.channel.tryLock(paramLong1, paramLong2, paramBoolean);
/* 216 */     if (fileLock == null) {
/* 217 */       return null;
/*     */     }
/* 219 */     this.lock = new FileLockRetry(fileLock, this);
/* 220 */     return this.lock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class FileLockRetry
/*     */     extends FileLock
/*     */   {
/*     */     FileLock base;
/*     */ 
/*     */ 
/*     */     
/*     */     protected FileLockRetry(FileLock param1FileLock, FileChannel param1FileChannel) {
/* 234 */       super(param1FileChannel, param1FileLock.position(), param1FileLock.size(), param1FileLock.isShared());
/* 235 */       this.base = param1FileLock;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isValid() {
/* 240 */       return this.base.isValid();
/*     */     }
/*     */ 
/*     */     
/*     */     public void release() throws IOException {
/* 245 */       this.base.release();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 252 */     return "retry:" + this.fileName;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileRetryOnInterrupt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */