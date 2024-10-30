/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.MappedByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.NonWritableChannelException;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ import org.h2.engine.SysProperties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FileNioMapped
/*     */   extends FileBase
/*     */ {
/*     */   private static final long GC_TIMEOUT_MS = 10000L;
/*     */   private final String name;
/*     */   private final FileChannel.MapMode mode;
/*     */   private RandomAccessFile file;
/*     */   private MappedByteBuffer mapped;
/*     */   private long fileLength;
/*     */   private int pos;
/*     */   
/*     */   FileNioMapped(String paramString1, String paramString2) throws IOException {
/*  60 */     if ("r".equals(paramString2)) {
/*  61 */       this.mode = FileChannel.MapMode.READ_ONLY;
/*     */     } else {
/*  63 */       this.mode = FileChannel.MapMode.READ_WRITE;
/*     */     } 
/*  65 */     this.name = paramString1;
/*  66 */     this.file = new RandomAccessFile(paramString1, paramString2);
/*  67 */     reMap();
/*     */   }
/*     */   
/*     */   private void unMap() throws IOException {
/*  71 */     if (this.mapped == null) {
/*     */       return;
/*     */     }
/*     */     
/*  75 */     this.mapped.force();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     boolean bool = true;
/*  81 */     if (SysProperties.NIO_CLEANER_HACK) {
/*     */       try {
/*  83 */         Method method = this.mapped.getClass().getMethod("cleaner", new Class[0]);
/*  84 */         method.setAccessible(true);
/*  85 */         Object object = method.invoke(this.mapped, new Object[0]);
/*  86 */         if (object != null) {
/*  87 */           Method method1 = object.getClass().getMethod("clean", new Class[0]);
/*  88 */           method1.invoke(object, new Object[0]);
/*     */         } 
/*  90 */         bool = false;
/*  91 */       } catch (Throwable throwable) {
/*     */       
/*     */       } finally {
/*  94 */         this.mapped = null;
/*     */       } 
/*     */     }
/*  97 */     if (bool) {
/*  98 */       WeakReference<MappedByteBuffer> weakReference = new WeakReference<>(this.mapped);
/*     */       
/* 100 */       this.mapped = null;
/* 101 */       long l = System.currentTimeMillis();
/* 102 */       while (weakReference.get() != null) {
/* 103 */         if (System.currentTimeMillis() - l > 10000L) {
/* 104 */           throw new IOException("Timeout (10000 ms) reached while trying to GC mapped buffer");
/*     */         }
/*     */         
/* 107 */         System.gc();
/* 108 */         Thread.yield();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void reMap() throws IOException {
/* 118 */     int i = 0;
/* 119 */     if (this.mapped != null) {
/* 120 */       i = this.pos;
/* 121 */       unMap();
/*     */     } 
/* 123 */     this.fileLength = this.file.length();
/* 124 */     checkFileSizeLimit(this.fileLength);
/*     */     
/* 126 */     this.mapped = this.file.getChannel().map(this.mode, 0L, this.fileLength);
/* 127 */     int j = this.mapped.limit();
/* 128 */     int k = this.mapped.capacity();
/* 129 */     if (j < this.fileLength || k < this.fileLength) {
/* 130 */       throw new IOException("Unable to map: length=" + j + " capacity=" + k + " length=" + this.fileLength);
/*     */     }
/*     */     
/* 133 */     if (SysProperties.NIO_LOAD_MAPPED) {
/* 134 */       this.mapped.load();
/*     */     }
/* 136 */     this.pos = Math.min(i, (int)this.fileLength);
/*     */   }
/*     */   
/*     */   private static void checkFileSizeLimit(long paramLong) throws IOException {
/* 140 */     if (paramLong > 2147483647L) {
/* 141 */       throw new IOException("File over 2GB is not supported yet when using this file system");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void implCloseChannel() throws IOException {
/* 148 */     if (this.file != null) {
/* 149 */       unMap();
/* 150 */       this.file.close();
/* 151 */       this.file = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public long position() {
/* 157 */     return this.pos;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 162 */     return "nioMapped:" + this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized long size() throws IOException {
/* 167 */     return this.fileLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int read(ByteBuffer paramByteBuffer) throws IOException {
/*     */     try {
/* 173 */       int i = paramByteBuffer.remaining();
/* 174 */       if (i == 0) {
/* 175 */         return 0;
/*     */       }
/* 177 */       i = (int)Math.min(i, this.fileLength - this.pos);
/* 178 */       if (i <= 0) {
/* 179 */         return -1;
/*     */       }
/* 181 */       this.mapped.position(this.pos);
/* 182 */       this.mapped.get(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), i);
/* 183 */       paramByteBuffer.position(paramByteBuffer.position() + i);
/* 184 */       this.pos += i;
/* 185 */       return i;
/* 186 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 187 */       EOFException eOFException = new EOFException("EOF");
/* 188 */       eOFException.initCause(illegalArgumentException);
/* 189 */       throw eOFException;
/* 190 */     } catch (BufferUnderflowException bufferUnderflowException) {
/* 191 */       EOFException eOFException = new EOFException("EOF");
/* 192 */       eOFException.initCause(bufferUnderflowException);
/* 193 */       throw eOFException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel position(long paramLong) throws IOException {
/* 199 */     checkFileSizeLimit(paramLong);
/* 200 */     this.pos = (int)paramLong;
/* 201 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized FileChannel truncate(long paramLong) throws IOException {
/* 207 */     if (this.mode == FileChannel.MapMode.READ_ONLY) {
/* 208 */       throw new NonWritableChannelException();
/*     */     }
/* 210 */     if (paramLong < size()) {
/* 211 */       setFileLength(paramLong);
/*     */     }
/* 213 */     return this;
/*     */   }
/*     */   
/*     */   public synchronized void setFileLength(long paramLong) throws IOException {
/* 217 */     checkFileSizeLimit(paramLong);
/* 218 */     int i = this.pos;
/* 219 */     unMap();
/* 220 */     for (byte b = 0;; b++) {
/*     */       try {
/* 222 */         this.file.setLength(paramLong);
/*     */         break;
/* 224 */       } catch (IOException iOException) {
/* 225 */         if (b > 16 || iOException.toString().indexOf("user-mapped section open") < 0) {
/* 226 */           throw iOException;
/*     */         }
/*     */         
/* 229 */         System.gc();
/*     */       } 
/* 231 */     }  reMap();
/* 232 */     this.pos = (int)Math.min(paramLong, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void force(boolean paramBoolean) throws IOException {
/* 237 */     this.mapped.force();
/* 238 */     this.file.getFD().sync();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int write(ByteBuffer paramByteBuffer) throws IOException {
/* 243 */     int i = paramByteBuffer.remaining();
/*     */     
/* 245 */     if (this.mapped.capacity() < this.pos + i) {
/* 246 */       setFileLength((this.pos + i));
/*     */     }
/* 248 */     this.mapped.position(this.pos);
/* 249 */     this.mapped.put(paramByteBuffer);
/* 250 */     this.pos += i;
/* 251 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized FileLock tryLock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/* 257 */     return this.file.getChannel().tryLock(paramLong1, paramLong2, paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileNioMapped.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */