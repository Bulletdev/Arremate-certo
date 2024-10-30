/*     */ package org.h2.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class HashBase
/*     */ {
/*     */   private static final long MAX_LOAD = 90L;
/*     */   protected int mask;
/*     */   protected int len;
/*     */   protected int size;
/*     */   protected int deletedCount;
/*     */   protected int level;
/*     */   protected boolean zeroKey;
/*     */   private int maxSize;
/*     */   private int minSize;
/*     */   private int maxDeleted;
/*     */   
/*     */   public HashBase() {
/*  53 */     reset(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void rehash(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  69 */     return this.size + (this.zeroKey ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void checkSizePut() {
/*  77 */     if (this.deletedCount > this.size) {
/*  78 */       rehash(this.level);
/*     */     }
/*  80 */     if (this.size + this.deletedCount >= this.maxSize) {
/*  81 */       rehash(this.level + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkSizeRemove() {
/*  90 */     if (this.size < this.minSize && this.level > 0) {
/*  91 */       rehash(this.level - 1);
/*  92 */     } else if (this.deletedCount > this.maxDeleted) {
/*  93 */       rehash(this.level);
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
/*     */   protected void reset(int paramInt) {
/* 105 */     if (paramInt > 30) {
/* 106 */       throw new IllegalStateException("exceeded max size of hash table");
/*     */     }
/* 108 */     this.size = 0;
/* 109 */     this.level = paramInt;
/* 110 */     this.len = 2 << this.level;
/* 111 */     this.mask = this.len - 1;
/* 112 */     this.minSize = (int)((1 << this.level) * 90L / 100L);
/* 113 */     this.maxSize = (int)(this.len * 90L / 100L);
/* 114 */     this.deletedCount = 0;
/* 115 */     this.maxDeleted = 20 + this.len / 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getIndex(int paramInt) {
/* 125 */     return paramInt & this.mask;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\HashBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */