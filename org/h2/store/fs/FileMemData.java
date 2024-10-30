/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ class FileMemData
/*     */ {
/*     */   private static final int CACHE_SIZE = 8;
/*     */   private static final int BLOCK_SIZE_SHIFT = 10;
/*     */   private static final int BLOCK_SIZE = 1024;
/*     */   private static final int BLOCK_SIZE_MASK = 1023;
/* 397 */   private static final CompressLZF LZF = new CompressLZF();
/* 398 */   private static final byte[] BUFFER = new byte[2048];
/*     */   
/*     */   private static final byte[] COMPRESSED_EMPTY_BLOCK;
/* 401 */   private static final Cache<CompressItem, CompressItem> COMPRESS_LATER = new Cache<>(8);
/*     */   
/*     */   private String name;
/*     */   
/*     */   private final int id;
/*     */   private final boolean compress;
/*     */   private long length;
/*     */   private byte[][] data;
/*     */   private long lastModified;
/*     */   private boolean isReadOnly;
/*     */   private boolean isLockedExclusive;
/*     */   private int sharedLockCount;
/*     */   
/*     */   static {
/* 415 */     byte[] arrayOfByte = new byte[1024];
/* 416 */     int i = LZF.compress(arrayOfByte, 1024, BUFFER, 0);
/* 417 */     COMPRESSED_EMPTY_BLOCK = new byte[i];
/* 418 */     System.arraycopy(BUFFER, 0, COMPRESSED_EMPTY_BLOCK, 0, i);
/*     */   }
/*     */   
/*     */   FileMemData(String paramString, boolean paramBoolean) {
/* 422 */     this.name = paramString;
/* 423 */     this.id = paramString.hashCode();
/* 424 */     this.compress = paramBoolean;
/* 425 */     this.data = new byte[0][];
/* 426 */     this.lastModified = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   int getId() {
/* 430 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized boolean lockExclusive() {
/* 439 */     if (this.sharedLockCount > 0 || this.isLockedExclusive) {
/* 440 */       return false;
/*     */     }
/* 442 */     this.isLockedExclusive = true;
/* 443 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized boolean lockShared() {
/* 452 */     if (this.isLockedExclusive) {
/* 453 */       return false;
/*     */     }
/* 455 */     this.sharedLockCount++;
/* 456 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void unlock() {
/* 463 */     if (this.isLockedExclusive) {
/* 464 */       this.isLockedExclusive = false;
/*     */     } else {
/* 466 */       this.sharedLockCount = Math.max(0, this.sharedLockCount - 1);
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
/* 479 */       super(param1Int, 0.75F, true);
/* 480 */       this.size = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean removeEldestEntry(Map.Entry<K, V> param1Entry) {
/* 485 */       if (size() < this.size) {
/* 486 */         return false;
/*     */       }
/* 488 */       FileMemData.CompressItem compressItem = (FileMemData.CompressItem)param1Entry.getKey();
/* 489 */       compressItem.file.compress(compressItem.page, compressItem.data);
/* 490 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class CompressItem
/*     */   {
/*     */     FileMemData file;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     byte[] data;
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
/* 516 */       return this.page ^ this.file.getId();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 521 */       if (param1Object instanceof CompressItem) {
/* 522 */         CompressItem compressItem = (CompressItem)param1Object;
/* 523 */         return (compressItem.page == this.page && compressItem.file == this.file);
/*     */       } 
/* 525 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void compressLater(int paramInt) {
/* 531 */     CompressItem compressItem = new CompressItem();
/* 532 */     compressItem.file = this;
/* 533 */     compressItem.page = paramInt;
/* 534 */     compressItem.data = this.data[paramInt];
/* 535 */     synchronized (LZF) {
/* 536 */       COMPRESS_LATER.put(compressItem, compressItem);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void expand(int paramInt) {
/* 541 */     byte[] arrayOfByte1 = this.data[paramInt];
/* 542 */     if (arrayOfByte1.length == 1024) {
/*     */       return;
/*     */     }
/* 545 */     byte[] arrayOfByte2 = new byte[1024];
/* 546 */     if (arrayOfByte1 != COMPRESSED_EMPTY_BLOCK) {
/* 547 */       synchronized (LZF) {
/* 548 */         LZF.expand(arrayOfByte1, 0, arrayOfByte1.length, arrayOfByte2, 0, 1024);
/*     */       } 
/*     */     }
/* 551 */     this.data[paramInt] = arrayOfByte2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void compress(int paramInt, byte[] paramArrayOfbyte) {
/* 561 */     byte[][] arrayOfByte = this.data;
/* 562 */     if (paramInt >= arrayOfByte.length) {
/*     */       return;
/*     */     }
/* 565 */     byte[] arrayOfByte1 = arrayOfByte[paramInt];
/* 566 */     if (arrayOfByte1 != paramArrayOfbyte) {
/*     */       return;
/*     */     }
/* 569 */     synchronized (LZF) {
/* 570 */       int i = LZF.compress(arrayOfByte1, 1024, BUFFER, 0);
/* 571 */       if (i <= 1024) {
/* 572 */         arrayOfByte1 = new byte[i];
/* 573 */         System.arraycopy(BUFFER, 0, arrayOfByte1, 0, i);
/*     */         
/* 575 */         byte[] arrayOfByte2 = arrayOfByte[paramInt];
/* 576 */         if (arrayOfByte2 != paramArrayOfbyte) {
/*     */           return;
/*     */         }
/* 579 */         arrayOfByte[paramInt] = arrayOfByte1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void touch(boolean paramBoolean) throws IOException {
/* 590 */     if (this.isReadOnly || paramBoolean) {
/* 591 */       throw new IOException("Read only");
/*     */     }
/* 593 */     this.lastModified = System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long length() {
/* 602 */     return this.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void truncate(long paramLong) {
/* 611 */     changeLength(paramLong);
/* 612 */     long l = MathUtils.roundUpLong(paramLong, 1024L);
/* 613 */     if (l != paramLong) {
/* 614 */       int i = (int)(paramLong >>> 10L);
/* 615 */       expand(i);
/* 616 */       byte[] arrayOfByte = this.data[i];
/* 617 */       for (int j = (int)(paramLong & 0x3FFL); j < 1024; j++) {
/* 618 */         arrayOfByte[j] = 0;
/*     */       }
/* 620 */       if (this.compress) {
/* 621 */         compressLater(i);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void changeLength(long paramLong) {
/* 627 */     this.length = paramLong;
/* 628 */     paramLong = MathUtils.roundUpLong(paramLong, 1024L);
/* 629 */     int i = (int)(paramLong >>> 10L);
/* 630 */     if (i != this.data.length) {
/* 631 */       byte[][] arrayOfByte = new byte[i][];
/* 632 */       System.arraycopy(this.data, 0, arrayOfByte, 0, Math.min(this.data.length, arrayOfByte.length));
/* 633 */       for (int j = this.data.length; j < i; j++) {
/* 634 */         arrayOfByte[j] = COMPRESSED_EMPTY_BLOCK;
/*     */       }
/* 636 */       this.data = arrayOfByte;
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
/*     */   long readWrite(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 651 */     long l = paramLong + paramInt2;
/* 652 */     if (l > this.length) {
/* 653 */       if (paramBoolean) {
/* 654 */         changeLength(l);
/*     */       } else {
/* 656 */         paramInt2 = (int)(this.length - paramLong);
/*     */       } 
/*     */     }
/* 659 */     while (paramInt2 > 0) {
/* 660 */       int i = (int)Math.min(paramInt2, 1024L - (paramLong & 0x3FFL));
/* 661 */       int j = (int)(paramLong >>> 10L);
/* 662 */       expand(j);
/* 663 */       byte[] arrayOfByte = this.data[j];
/* 664 */       int k = (int)(paramLong & 0x3FFL);
/* 665 */       if (paramBoolean) {
/* 666 */         System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, k, i);
/*     */       } else {
/* 668 */         System.arraycopy(arrayOfByte, k, paramArrayOfbyte, paramInt1, i);
/*     */       } 
/* 670 */       if (this.compress) {
/* 671 */         compressLater(j);
/*     */       }
/* 673 */       paramInt1 += i;
/* 674 */       paramLong += i;
/* 675 */       paramInt2 -= i;
/*     */     } 
/* 677 */     return paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setName(String paramString) {
/* 686 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String getName() {
/* 695 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long getLastModified() {
/* 704 */     return this.lastModified;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean canWrite() {
/* 713 */     return !this.isReadOnly;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean setReadOnly() {
/* 722 */     this.isReadOnly = true;
/* 723 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileMemData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */