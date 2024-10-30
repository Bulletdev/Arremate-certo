/*     */ package org.h2.util;
/*     */ 
/*     */ import org.h2.message.DbException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntIntHashMap
/*     */   extends HashBase
/*     */ {
/*     */   public static final int NOT_FOUND = -1;
/*     */   private static final int DELETED = 1;
/*     */   private int[] keys;
/*     */   private int[] values;
/*     */   private int zeroValue;
/*     */   
/*     */   protected void reset(int paramInt) {
/*  30 */     super.reset(paramInt);
/*  31 */     this.keys = new int[this.len];
/*  32 */     this.values = new int[this.len];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(int paramInt1, int paramInt2) {
/*  42 */     if (paramInt1 == 0) {
/*  43 */       this.zeroKey = true;
/*  44 */       this.zeroValue = paramInt2;
/*     */       return;
/*     */     } 
/*  47 */     checkSizePut();
/*  48 */     internalPut(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   private void internalPut(int paramInt1, int paramInt2) {
/*  52 */     int i = getIndex(paramInt1);
/*  53 */     byte b = 1;
/*  54 */     int j = -1;
/*     */     do {
/*  56 */       int k = this.keys[i];
/*  57 */       if (k == 0) {
/*  58 */         if (this.values[i] != 1) {
/*     */           
/*  60 */           if (j >= 0) {
/*  61 */             i = j;
/*  62 */             this.deletedCount--;
/*     */           } 
/*  64 */           this.size++;
/*  65 */           this.keys[i] = paramInt1;
/*  66 */           this.values[i] = paramInt2;
/*     */           
/*     */           return;
/*     */         } 
/*  70 */         if (j < 0) {
/*  71 */           j = i;
/*     */         }
/*  73 */       } else if (k == paramInt1) {
/*     */         
/*  75 */         this.values[i] = paramInt2;
/*     */         return;
/*     */       } 
/*  78 */       i = i + b++ & this.mask;
/*  79 */     } while (b <= this.len);
/*     */     
/*  81 */     DbException.throwInternalError("hashmap is full");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(int paramInt) {
/*  90 */     if (paramInt == 0) {
/*  91 */       this.zeroKey = false;
/*     */       return;
/*     */     } 
/*  94 */     checkSizeRemove();
/*  95 */     int i = getIndex(paramInt);
/*  96 */     byte b = 1;
/*     */     do {
/*  98 */       int j = this.keys[i];
/*  99 */       if (j == paramInt) {
/*     */         
/* 101 */         this.keys[i] = 0;
/* 102 */         this.values[i] = 1;
/* 103 */         this.deletedCount++;
/* 104 */         this.size--; return;
/*     */       } 
/* 106 */       if (j == 0 && this.values[i] == 0) {
/*     */         return;
/*     */       }
/*     */       
/* 110 */       i = i + b++ & this.mask;
/* 111 */     } while (b <= this.len);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void rehash(int paramInt) {
/* 117 */     int[] arrayOfInt1 = this.keys;
/* 118 */     int[] arrayOfInt2 = this.values;
/* 119 */     reset(paramInt);
/* 120 */     for (byte b = 0; b < arrayOfInt1.length; b++) {
/* 121 */       int i = arrayOfInt1[b];
/* 122 */       if (i != 0)
/*     */       {
/*     */         
/* 125 */         internalPut(i, arrayOfInt2[b]);
/*     */       }
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
/*     */   public int get(int paramInt) {
/* 138 */     if (paramInt == 0) {
/* 139 */       return this.zeroKey ? this.zeroValue : -1;
/*     */     }
/* 141 */     int i = getIndex(paramInt);
/* 142 */     byte b = 1;
/*     */     while (true) {
/* 144 */       int j = this.keys[i];
/* 145 */       if (j == 0 && this.values[i] == 0)
/*     */       {
/* 147 */         return -1; } 
/* 148 */       if (j == paramInt)
/*     */       {
/* 150 */         return this.values[i];
/*     */       }
/* 152 */       i = i + b++ & this.mask;
/* 153 */       if (b > this.len)
/* 154 */         return -1; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\IntIntHashMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */