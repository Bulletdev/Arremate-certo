/*     */ package org.h2.mvstore;
/*     */ 
/*     */ import java.util.BitSet;
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
/*     */ public class FreeSpaceBitSet
/*     */ {
/*     */   private static final boolean DETAILED_INFO = false;
/*     */   private final int firstFreeBlock;
/*     */   private final int blockSize;
/*  32 */   private final BitSet set = new BitSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FreeSpaceBitSet(int paramInt1, int paramInt2) {
/*  41 */     this.firstFreeBlock = paramInt1;
/*  42 */     this.blockSize = paramInt2;
/*  43 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  50 */     this.set.clear();
/*  51 */     this.set.set(0, this.firstFreeBlock);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsed(long paramLong, int paramInt) {
/*  62 */     int i = getBlock(paramLong);
/*  63 */     int j = getBlockCount(paramInt);
/*  64 */     for (int k = i; k < i + j; k++) {
/*  65 */       if (!this.set.get(k)) {
/*  66 */         return false;
/*     */       }
/*     */     } 
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFree(long paramLong, int paramInt) {
/*  80 */     int i = getBlock(paramLong);
/*  81 */     int j = getBlockCount(paramInt);
/*  82 */     for (int k = i; k < i + j; k++) {
/*  83 */       if (this.set.get(k)) {
/*  84 */         return false;
/*     */       }
/*     */     } 
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long allocate(int paramInt) {
/*  97 */     int i = getBlockCount(paramInt);
/*  98 */     int j = 0; while (true) {
/*  99 */       int k = this.set.nextClearBit(j);
/* 100 */       int m = this.set.nextSetBit(k + 1);
/* 101 */       if (m < 0 || m - k >= i) {
/* 102 */         this.set.set(k, k + i);
/* 103 */         return getPos(k);
/*     */       } 
/* 105 */       j = m;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void markUsed(long paramLong, int paramInt) {
/* 116 */     int i = getBlock(paramLong);
/* 117 */     int j = getBlockCount(paramInt);
/* 118 */     this.set.set(i, i + j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free(long paramLong, int paramInt) {
/* 128 */     int i = getBlock(paramLong);
/* 129 */     int j = getBlockCount(paramInt);
/* 130 */     this.set.clear(i, i + j);
/*     */   }
/*     */   
/*     */   private long getPos(int paramInt) {
/* 134 */     return paramInt * this.blockSize;
/*     */   }
/*     */   
/*     */   private int getBlock(long paramLong) {
/* 138 */     return (int)(paramLong / this.blockSize);
/*     */   }
/*     */   
/*     */   private int getBlockCount(int paramInt) {
/* 142 */     return MathUtils.roundUpInt(paramInt, this.blockSize) / this.blockSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFillRate() {
/* 152 */     int i = this.set.length(); byte b1 = 0;
/* 153 */     for (byte b2 = 0; b2 < i; b2++) {
/* 154 */       if (this.set.get(b2)) {
/* 155 */         b1++;
/*     */       }
/*     */     } 
/* 158 */     if (b1 == 0) {
/* 159 */       return 0;
/*     */     }
/* 161 */     return Math.max(1, (int)(100L * b1 / i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getFirstFree() {
/* 170 */     return getPos(this.set.nextClearBit(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     stringBuilder.append('[');
/* 196 */     int i = 0; while (true) {
/* 197 */       if (i) {
/* 198 */         stringBuilder.append(", ");
/*     */       }
/* 200 */       int j = this.set.nextClearBit(i);
/* 201 */       stringBuilder.append(Integer.toHexString(j)).append('-');
/* 202 */       int k = this.set.nextSetBit(j + 1);
/* 203 */       if (k < 0) {
/*     */         break;
/*     */       }
/* 206 */       stringBuilder.append(Integer.toHexString(k - 1));
/* 207 */       i = k + 1;
/*     */     } 
/* 209 */     stringBuilder.append(']');
/* 210 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\FreeSpaceBitSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */