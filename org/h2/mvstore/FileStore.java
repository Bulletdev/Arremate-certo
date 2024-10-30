/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.OverlappingFileLockException;
/*     */ import org.h2.mvstore.cache.FilePathCache;
/*     */ import org.h2.store.fs.FilePath;
/*     */ import org.h2.store.fs.FilePathEncrypt;
/*     */ import org.h2.store.fs.FilePathNio;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileStore
/*     */ {
/*     */   protected long readCount;
/*     */   protected long readBytes;
/*     */   protected long writeCount;
/*     */   protected long writeBytes;
/*  51 */   protected final FreeSpaceBitSet freeSpace = new FreeSpaceBitSet(2, 4096);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String fileName;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean readOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long fileSize;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FileChannel file;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FileChannel encryptedFile;
/*     */ 
/*     */ 
/*     */   
/*     */   protected FileLock fileLock;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  86 */     return this.fileName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ByteBuffer readFully(long paramLong, int paramInt) {
/*  97 */     ByteBuffer byteBuffer = ByteBuffer.allocate(paramInt);
/*  98 */     DataUtils.readFully(this.file, paramLong, byteBuffer);
/*  99 */     this.readCount++;
/* 100 */     this.readBytes += paramInt;
/* 101 */     return byteBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeFully(long paramLong, ByteBuffer paramByteBuffer) {
/* 111 */     int i = paramByteBuffer.remaining();
/* 112 */     this.fileSize = Math.max(this.fileSize, paramLong + i);
/* 113 */     DataUtils.writeFully(this.file, paramLong, paramByteBuffer);
/* 114 */     this.writeCount++;
/* 115 */     this.writeBytes += i;
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
/*     */   public void open(String paramString, boolean paramBoolean, char[] paramArrayOfchar) {
/* 128 */     if (this.file != null) {
/*     */       return;
/*     */     }
/* 131 */     if (paramString != null) {
/*     */       
/* 133 */       FilePathCache.INSTANCE.getScheme();
/* 134 */       FilePath filePath = FilePath.get(paramString);
/*     */       
/* 136 */       if (filePath instanceof org.h2.store.fs.FilePathDisk && !paramString.startsWith(filePath.getScheme() + ":")) {
/*     */ 
/*     */         
/* 139 */         FilePathNio.class.getName();
/* 140 */         paramString = "nio:" + paramString;
/*     */       } 
/*     */     } 
/* 143 */     this.fileName = paramString;
/* 144 */     FilePath filePath1 = FilePath.get(paramString);
/* 145 */     FilePath filePath2 = filePath1.getParent();
/* 146 */     if (filePath2 != null && !filePath2.exists()) {
/* 147 */       throw DataUtils.newIllegalArgumentException("Directory does not exist: {0}", new Object[] { filePath2 });
/*     */     }
/*     */     
/* 150 */     if (filePath1.exists() && !filePath1.canWrite()) {
/* 151 */       paramBoolean = true;
/*     */     }
/* 153 */     this.readOnly = paramBoolean;
/*     */     try {
/* 155 */       this.file = filePath1.open(paramBoolean ? "r" : "rw");
/* 156 */       if (paramArrayOfchar != null) {
/* 157 */         byte[] arrayOfByte = FilePathEncrypt.getPasswordBytes(paramArrayOfchar);
/* 158 */         this.encryptedFile = this.file;
/* 159 */         this.file = (FileChannel)new FilePathEncrypt.FileEncrypt(paramString, arrayOfByte, this.file);
/*     */       } 
/*     */       try {
/* 162 */         if (paramBoolean) {
/* 163 */           this.fileLock = this.file.tryLock(0L, Long.MAX_VALUE, true);
/*     */         } else {
/* 165 */           this.fileLock = this.file.tryLock();
/*     */         } 
/* 167 */       } catch (OverlappingFileLockException overlappingFileLockException) {
/* 168 */         throw DataUtils.newIllegalStateException(7, "The file is locked: {0}", new Object[] { paramString, overlappingFileLockException });
/*     */       } 
/*     */ 
/*     */       
/* 172 */       if (this.fileLock == null) {
/* 173 */         throw DataUtils.newIllegalStateException(7, "The file is locked: {0}", new Object[] { paramString });
/*     */       }
/*     */ 
/*     */       
/* 177 */       this.fileSize = this.file.size();
/* 178 */     } catch (IOException iOException) {
/* 179 */       throw DataUtils.newIllegalStateException(1, "Could not open file {0}", new Object[] { paramString, iOException });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/* 190 */       if (this.fileLock != null) {
/* 191 */         this.fileLock.release();
/* 192 */         this.fileLock = null;
/*     */       } 
/* 194 */       this.file.close();
/* 195 */       this.freeSpace.clear();
/* 196 */     } catch (Exception exception) {
/* 197 */       throw DataUtils.newIllegalStateException(2, "Closing failed for file {0}", new Object[] { this.fileName, exception });
/*     */     }
/*     */     finally {
/*     */       
/* 201 */       this.file = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sync() {
/*     */     try {
/* 210 */       this.file.force(true);
/* 211 */     } catch (IOException iOException) {
/* 212 */       throw DataUtils.newIllegalStateException(2, "Could not sync file {0}", new Object[] { this.fileName, iOException });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long size() {
/* 224 */     return this.fileSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void truncate(long paramLong) {
/*     */     try {
/* 234 */       this.writeCount++;
/* 235 */       this.file.truncate(paramLong);
/* 236 */       this.fileSize = Math.min(this.fileSize, paramLong);
/* 237 */     } catch (IOException iOException) {
/* 238 */       throw DataUtils.newIllegalStateException(2, "Could not truncate file {0} to size {1}", new Object[] { this.fileName, Long.valueOf(paramLong), iOException });
/*     */     } 
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
/*     */   public FileChannel getFile() {
/* 254 */     return this.file;
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
/*     */   public FileChannel getEncryptedFile() {
/* 266 */     return this.encryptedFile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWriteCount() {
/* 276 */     return this.writeCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getWriteBytes() {
/* 285 */     return this.writeBytes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getReadCount() {
/* 295 */     return this.readCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getReadBytes() {
/* 304 */     return this.readBytes;
/*     */   }
/*     */   
/*     */   public boolean isReadOnly() {
/* 308 */     return this.readOnly;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDefaultRetentionTime() {
/* 317 */     return 45000;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void markUsed(long paramLong, int paramInt) {
/* 327 */     this.freeSpace.markUsed(paramLong, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long allocate(int paramInt) {
/* 337 */     return this.freeSpace.allocate(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free(long paramLong, int paramInt) {
/* 347 */     this.freeSpace.free(paramLong, paramInt);
/*     */   }
/*     */   
/*     */   public int getFillRate() {
/* 351 */     return this.freeSpace.getFillRate();
/*     */   }
/*     */   
/*     */   long getFirstFree() {
/* 355 */     return this.freeSpace.getFirstFree();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 362 */     this.freeSpace.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileName() {
/* 371 */     return this.fileName;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\FileStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */