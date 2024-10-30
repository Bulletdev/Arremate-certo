/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import org.h2.compress.CompressLZF;
/*     */ import org.h2.util.MathUtils;
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
/*     */ class FileNioMemData
/*     */ {
/*     */   private static final int CACHE_SIZE = 8;
/*     */   private static final int BLOCK_SIZE_SHIFT = 16;
/*     */   private static final int BLOCK_SIZE = 65536;
/*     */   private static final int BLOCK_SIZE_MASK = 65535;
/* 403 */   private static final CompressLZF LZF = new CompressLZF();
/* 404 */   private static final byte[] BUFFER = new byte[131072];
/*     */   
/*     */   private static final ByteBuffer COMPRESSED_EMPTY_BLOCK;
/* 407 */   private static final Cache<CompressItem, CompressItem> COMPRESS_LATER = new Cache<>(8);
/*     */   
/*     */   private String name;
/*     */   
/*     */   private final int id;
/*     */   private final boolean compress;
/*     */   private long length;
/*     */   private ByteBuffer[] data;
/*     */   private long lastModified;
/*     */   private boolean isReadOnly;
/*     */   private boolean isLockedExclusive;
/*     */   private int sharedLockCount;
/*     */   
/*     */   static {
/* 421 */     byte[] arrayOfByte = new byte[65536];
/* 422 */     int i = LZF.compress(arrayOfByte, 65536, BUFFER, 0);
/* 423 */     COMPRESSED_EMPTY_BLOCK = ByteBuffer.allocateDirect(i);
/* 424 */     COMPRESSED_EMPTY_BLOCK.put(BUFFER, 0, i);
/*     */   }
/*     */   
/*     */   FileNioMemData(String paramString, boolean paramBoolean) {
/* 428 */     this.name = paramString;
/* 429 */     this.id = paramString.hashCode();
/* 430 */     this.compress = paramBoolean;
/* 431 */     this.data = new ByteBuffer[0];
/* 432 */     this.lastModified = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   int getId() {
/* 436 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized boolean lockExclusive() {
/* 445 */     if (this.sharedLockCount > 0 || this.isLockedExclusive) {
/* 446 */       return false;
/*     */     }
/* 448 */     this.isLockedExclusive = true;
/* 449 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized boolean lockShared() {
/* 458 */     if (this.isLockedExclusive) {
/* 459 */       return false;
/*     */     }
/* 461 */     this.sharedLockCount++;
/* 462 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void unlock() {
/* 469 */     if (this.isLockedExclusive) {
/* 470 */       this.isLockedExclusive = false;
/*     */     } else {
/* 472 */       this.sharedLockCount = Math.max(0, this.sharedLockCount - 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static class Cache<K, V>
/*     */     extends LinkedHashMap<K, V>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final int size;
/*     */     
/*     */     Cache(int param1Int) {
/* 485 */       super(param1Int, 0.75F, true);
/* 486 */       this.size = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean removeEldestEntry(Map.Entry<K, V> param1Entry) {
/* 491 */       if (size() < this.size) {
/* 492 */         return false;
/*     */       }
/* 494 */       FileNioMemData.CompressItem compressItem = (FileNioMemData.CompressItem)param1Entry.getKey();
/* 495 */       compressItem.data.compress(compressItem.page);
/* 496 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class CompressItem
/*     */   {
/*     */     FileNioMemData data;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int page;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 517 */       return this.page ^ this.data.getId();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 522 */       if (param1Object instanceof CompressItem) {
/* 523 */         CompressItem compressItem = (CompressItem)param1Object;
/* 524 */         return (compressItem.data == this.data && compressItem.page == this.page);
/*     */       } 
/* 526 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void compressLater(int paramInt) {
/* 532 */     CompressItem compressItem = new CompressItem();
/* 533 */     compressItem.data = this;
/* 534 */     compressItem.page = paramInt;
/* 535 */     synchronized (LZF) {
/* 536 */       COMPRESS_LATER.put(compressItem, compressItem);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void expand(int paramInt) {
/* 541 */     ByteBuffer byteBuffer1 = this.data[paramInt];
/* 542 */     if (byteBuffer1.capacity() == 65536) {
/*     */       return;
/*     */     }
/* 545 */     ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(65536);
/* 546 */     if (byteBuffer1 != COMPRESSED_EMPTY_BLOCK) {
/* 547 */       synchronized (LZF) {
/* 548 */         byteBuffer1.position(0);
/* 549 */         CompressLZF.expand(byteBuffer1, byteBuffer2);
/*     */       } 
/*     */     }
/* 552 */     this.data[paramInt] = byteBuffer2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void compress(int paramInt) {
/* 561 */     ByteBuffer byteBuffer = this.data[paramInt];
/* 562 */     synchronized (LZF) {
/* 563 */       int i = LZF.compress(byteBuffer, 0, BUFFER, 0);
/* 564 */       byteBuffer = ByteBuffer.allocateDirect(i);
/* 565 */       byteBuffer.put(BUFFER, 0, i);
/* 566 */       this.data[paramInt] = byteBuffer;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void touch(boolean paramBoolean) throws IOException {
/* 576 */     if (this.isReadOnly || paramBoolean) {
/* 577 */       throw new IOException("Read only");
/*     */     }
/* 579 */     this.lastModified = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long length() {
/* 588 */     return this.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void truncate(long paramLong) {
/* 597 */     changeLength(paramLong);
/* 598 */     long l = MathUtils.roundUpLong(paramLong, 65536L);
/* 599 */     if (l != paramLong) {
/* 600 */       int i = (int)(paramLong >>> 16L);
/* 601 */       expand(i);
/* 602 */       ByteBuffer byteBuffer = this.data[i];
/* 603 */       for (int j = (int)(paramLong & 0xFFFFL); j < 65536; j++) {
/* 604 */         byteBuffer.put(j, (byte)0);
/*     */       }
/* 606 */       if (this.compress) {
/* 607 */         compressLater(i);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void changeLength(long paramLong) {
/* 613 */     this.length = paramLong;
/* 614 */     paramLong = MathUtils.roundUpLong(paramLong, 65536L);
/* 615 */     int i = (int)(paramLong >>> 16L);
/* 616 */     if (i != this.data.length) {
/* 617 */       ByteBuffer[] arrayOfByteBuffer = new ByteBuffer[i];
/* 618 */       System.arraycopy(this.data, 0, arrayOfByteBuffer, 0, Math.min(this.data.length, arrayOfByteBuffer.length));
/* 619 */       for (int j = this.data.length; j < i; j++) {
/* 620 */         arrayOfByteBuffer[j] = COMPRESSED_EMPTY_BLOCK;
/*     */       }
/* 622 */       this.data = arrayOfByteBuffer;
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
/*     */   long readWrite(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 637 */     long l = paramLong + paramInt2;
/* 638 */     if (l > this.length) {
/* 639 */       if (paramBoolean) {
/* 640 */         changeLength(l);
/*     */       } else {
/* 642 */         paramInt2 = (int)(this.length - paramLong);
/*     */       } 
/*     */     }
/* 645 */     while (paramInt2 > 0) {
/* 646 */       int i = (int)Math.min(paramInt2, 65536L - (paramLong & 0xFFFFL));
/* 647 */       int j = (int)(paramLong >>> 16L);
/* 648 */       expand(j);
/* 649 */       ByteBuffer byteBuffer = this.data[j];
/* 650 */       int k = (int)(paramLong & 0xFFFFL);
/* 651 */       if (paramBoolean) {
/* 652 */         ByteBuffer byteBuffer1 = paramByteBuffer.slice();
/* 653 */         byteBuffer1.position(paramInt1);
/* 654 */         byteBuffer1.limit(paramInt1 + i);
/* 655 */         byteBuffer.position(k);
/* 656 */         byteBuffer.put(byteBuffer1);
/*     */       } else {
/*     */         
/* 659 */         ByteBuffer byteBuffer1 = byteBuffer.duplicate();
/* 660 */         byteBuffer1.position(k);
/* 661 */         byteBuffer1.limit(i + k);
/* 662 */         int m = paramByteBuffer.position();
/* 663 */         paramByteBuffer.position(paramInt1);
/* 664 */         paramByteBuffer.put(byteBuffer1);
/*     */         
/* 666 */         paramByteBuffer.position(m);
/*     */       } 
/* 668 */       if (this.compress) {
/* 669 */         compressLater(j);
/*     */       }
/* 671 */       paramInt1 += i;
/* 672 */       paramLong += i;
/* 673 */       paramInt2 -= i;
/*     */     } 
/* 675 */     return paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setName(String paramString) {
/* 684 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getName() {
/* 693 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long getLastModified() {
/* 702 */     return this.lastModified;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean canWrite() {
/* 711 */     return !this.isReadOnly;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean setReadOnly() {
/* 720 */     this.isReadOnly = true;
/* 721 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileNioMemData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */