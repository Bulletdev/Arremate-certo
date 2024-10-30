/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OffHeapStore
/*     */   extends FileStore
/*     */ {
/*  19 */   private final TreeMap<Long, ByteBuffer> memory = new TreeMap<>();
/*     */ 
/*     */ 
/*     */   
/*     */   public void open(String paramString, boolean paramBoolean, char[] paramArrayOfchar) {
/*  24 */     this.memory.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  29 */     return this.memory.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public ByteBuffer readFully(long paramLong, int paramInt) {
/*  34 */     Map.Entry<Long, ByteBuffer> entry = this.memory.floorEntry(Long.valueOf(paramLong));
/*  35 */     if (entry == null) {
/*  36 */       throw DataUtils.newIllegalStateException(1, "Could not read from position {0}", new Object[] { Long.valueOf(paramLong) });
/*     */     }
/*     */ 
/*     */     
/*  40 */     this.readCount++;
/*  41 */     this.readBytes += paramInt;
/*  42 */     ByteBuffer byteBuffer1 = entry.getValue();
/*  43 */     ByteBuffer byteBuffer2 = byteBuffer1.duplicate();
/*  44 */     int i = (int)(paramLong - ((Long)entry.getKey()).longValue());
/*  45 */     byteBuffer2.position(i);
/*  46 */     byteBuffer2.limit(paramInt + i);
/*  47 */     return byteBuffer2.slice();
/*     */   }
/*     */ 
/*     */   
/*     */   public void free(long paramLong, int paramInt) {
/*  52 */     this.freeSpace.free(paramLong, paramInt);
/*  53 */     ByteBuffer byteBuffer = this.memory.remove(Long.valueOf(paramLong));
/*  54 */     if (byteBuffer != null)
/*     */     {
/*  56 */       if (byteBuffer.remaining() != paramInt) {
/*  57 */         throw DataUtils.newIllegalStateException(1, "Partial remove is not supported at position {0}", new Object[] { Long.valueOf(paramLong) });
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeFully(long paramLong, ByteBuffer paramByteBuffer) {
/*  65 */     this.fileSize = Math.max(this.fileSize, paramLong + paramByteBuffer.remaining());
/*  66 */     Map.Entry<Long, ByteBuffer> entry = this.memory.floorEntry(Long.valueOf(paramLong));
/*  67 */     if (entry == null) {
/*     */       
/*  69 */       writeNewEntry(paramLong, paramByteBuffer);
/*     */       return;
/*     */     } 
/*  72 */     long l = ((Long)entry.getKey()).longValue();
/*  73 */     ByteBuffer byteBuffer = entry.getValue();
/*  74 */     int i = byteBuffer.capacity();
/*  75 */     int j = paramByteBuffer.remaining();
/*  76 */     if (l == paramLong) {
/*  77 */       if (i != j) {
/*  78 */         throw DataUtils.newIllegalStateException(1, "Could not write to position {0}; partial overwrite is not supported", new Object[] { Long.valueOf(paramLong) });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  83 */       this.writeCount++;
/*  84 */       this.writeBytes += j;
/*  85 */       byteBuffer.rewind();
/*  86 */       byteBuffer.put(paramByteBuffer);
/*     */       return;
/*     */     } 
/*  89 */     if (l + i > paramLong) {
/*  90 */       throw DataUtils.newIllegalStateException(1, "Could not write to position {0}; partial overwrite is not supported", new Object[] { Long.valueOf(paramLong) });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  95 */     writeNewEntry(paramLong, paramByteBuffer);
/*     */   }
/*     */   
/*     */   private void writeNewEntry(long paramLong, ByteBuffer paramByteBuffer) {
/*  99 */     int i = paramByteBuffer.remaining();
/* 100 */     this.writeCount++;
/* 101 */     this.writeBytes += i;
/* 102 */     ByteBuffer byteBuffer = ByteBuffer.allocateDirect(i);
/* 103 */     byteBuffer.put(paramByteBuffer);
/* 104 */     byteBuffer.rewind();
/* 105 */     this.memory.put(Long.valueOf(paramLong), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void truncate(long paramLong) {
/* 110 */     this.writeCount++;
/* 111 */     if (paramLong == 0L) {
/* 112 */       this.fileSize = 0L;
/* 113 */       this.memory.clear();
/*     */       return;
/*     */     } 
/* 116 */     this.fileSize = paramLong;
/* 117 */     for (Iterator<Long> iterator = this.memory.keySet().iterator(); iterator.hasNext(); ) {
/* 118 */       long l = ((Long)iterator.next()).longValue();
/* 119 */       if (l < paramLong) {
/*     */         break;
/*     */       }
/* 122 */       ByteBuffer byteBuffer = this.memory.get(Long.valueOf(l));
/* 123 */       if (byteBuffer.capacity() > paramLong) {
/* 124 */         throw DataUtils.newIllegalStateException(1, "Could not truncate to {0}; partial truncate is not supported", new Object[] { Long.valueOf(l) });
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 129 */       iterator.remove();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 135 */     this.memory.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sync() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDefaultRetentionTime() {
/* 145 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\OffHeapStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */