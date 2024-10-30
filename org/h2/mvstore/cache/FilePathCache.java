/*     */ package org.h2.mvstore.cache;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ import org.h2.store.fs.FileBase;
/*     */ import org.h2.store.fs.FilePath;
/*     */ import org.h2.store.fs.FilePathWrapper;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilePathCache
/*     */   extends FilePathWrapper
/*     */ {
/*  24 */   public static final FilePathCache INSTANCE = new FilePathCache();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  30 */     FilePath.register((FilePath)INSTANCE);
/*     */   }
/*     */   
/*     */   public static FileChannel wrap(FileChannel paramFileChannel) {
/*  34 */     return (FileChannel)new FileCache(paramFileChannel);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel open(String paramString) throws IOException {
/*  39 */     return (FileChannel)new FileCache(getBase().open(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getScheme() {
/*  44 */     return "cache";
/*     */   }
/*     */ 
/*     */   
/*     */   public static class FileCache
/*     */     extends FileBase
/*     */   {
/*     */     private static final int CACHE_BLOCK_SIZE = 4096;
/*     */     
/*     */     private final FileChannel base;
/*     */     
/*     */     private final CacheLongKeyLIRS<ByteBuffer> cache;
/*     */     
/*     */     FileCache(FileChannel param1FileChannel) {
/*  58 */       CacheLongKeyLIRS.Config config = new CacheLongKeyLIRS.Config();
/*     */       
/*  60 */       config.maxMemory = 1048576L;
/*  61 */       this.cache = new CacheLongKeyLIRS<>(config);
/*     */ 
/*     */ 
/*     */       
/*  65 */       this.base = param1FileChannel;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void implCloseChannel() throws IOException {
/*  70 */       this.base.close();
/*     */     }
/*     */ 
/*     */     
/*     */     public FileChannel position(long param1Long) throws IOException {
/*  75 */       this.base.position(param1Long);
/*  76 */       return (FileChannel)this;
/*     */     }
/*     */ 
/*     */     
/*     */     public long position() throws IOException {
/*  81 */       return this.base.position();
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(ByteBuffer param1ByteBuffer) throws IOException {
/*  86 */       return this.base.read(param1ByteBuffer);
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(ByteBuffer param1ByteBuffer, long param1Long) throws IOException {
/*  91 */       long l = getCachePos(param1Long);
/*  92 */       int i = (int)(param1Long - l);
/*  93 */       int j = 4096 - i;
/*  94 */       j = Math.min(j, param1ByteBuffer.remaining());
/*  95 */       ByteBuffer byteBuffer = this.cache.get(l);
/*  96 */       if (byteBuffer == null) {
/*  97 */         byteBuffer = ByteBuffer.allocate(4096);
/*  98 */         long l1 = l;
/*     */         while (true) {
/* 100 */           int m = this.base.read(byteBuffer, l1);
/* 101 */           if (m <= 0) {
/*     */             break;
/*     */           }
/* 104 */           if (byteBuffer.remaining() == 0) {
/*     */             break;
/*     */           }
/* 107 */           l1 += m;
/*     */         } 
/* 109 */         int k = byteBuffer.position();
/* 110 */         if (k == 4096) {
/* 111 */           this.cache.put(l, byteBuffer, 4096);
/*     */         } else {
/* 113 */           if (k <= 0) {
/* 114 */             return -1;
/*     */           }
/* 116 */           j = Math.min(j, k - i);
/*     */         } 
/*     */       } 
/* 119 */       param1ByteBuffer.put(byteBuffer.array(), i, j);
/* 120 */       return (j == 0) ? -1 : j;
/*     */     }
/*     */     
/*     */     private static long getCachePos(long param1Long) {
/* 124 */       return param1Long / 4096L * 4096L;
/*     */     }
/*     */ 
/*     */     
/*     */     public long size() throws IOException {
/* 129 */       return this.base.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public FileChannel truncate(long param1Long) throws IOException {
/* 134 */       this.cache.clear();
/* 135 */       this.base.truncate(param1Long);
/* 136 */       return (FileChannel)this;
/*     */     }
/*     */ 
/*     */     
/*     */     public int write(ByteBuffer param1ByteBuffer, long param1Long) throws IOException {
/* 141 */       clearCache(param1ByteBuffer, param1Long);
/* 142 */       return this.base.write(param1ByteBuffer, param1Long);
/*     */     }
/*     */ 
/*     */     
/*     */     public int write(ByteBuffer param1ByteBuffer) throws IOException {
/* 147 */       clearCache(param1ByteBuffer, position());
/* 148 */       return this.base.write(param1ByteBuffer);
/*     */     }
/*     */     
/*     */     private void clearCache(ByteBuffer param1ByteBuffer, long param1Long) {
/* 152 */       if (this.cache.size() > 0) {
/* 153 */         int i = param1ByteBuffer.remaining();
/* 154 */         long l = getCachePos(param1Long);
/* 155 */         while (i > 0) {
/* 156 */           this.cache.remove(l);
/* 157 */           l += 4096L;
/* 158 */           i -= 4096;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void force(boolean param1Boolean) throws IOException {
/* 165 */       this.base.force(param1Boolean);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public FileLock tryLock(long param1Long1, long param1Long2, boolean param1Boolean) throws IOException {
/* 171 */       return this.base.tryLock(param1Long1, param1Long2, param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 176 */       return "cache:" + this.base.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\cache\FilePathCache.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */