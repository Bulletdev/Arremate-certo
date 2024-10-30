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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Permutations<T>
/*     */ {
/*     */   private final T[] in;
/*     */   private final T[] out;
/*     */   private final int n;
/*     */   private final int m;
/*     */   private final int[] index;
/*     */   private boolean hasNext = true;
/*     */   
/*     */   private Permutations(T[] paramArrayOfT1, T[] paramArrayOfT2, int paramInt) {
/*  41 */     this.n = paramArrayOfT1.length;
/*  42 */     this.m = paramInt;
/*  43 */     if (this.n < paramInt || paramInt < 0) {
/*  44 */       DbException.throwInternalError("n < m or m < 0");
/*     */     }
/*  46 */     this.in = paramArrayOfT1;
/*  47 */     this.out = paramArrayOfT2;
/*  48 */     this.index = new int[this.n];
/*  49 */     for (byte b = 0; b < this.n; b++) {
/*  50 */       this.index[b] = b;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  55 */     reverseAfter(paramInt - 1);
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
/*     */   public static <T> Permutations<T> create(T[] paramArrayOfT1, T[] paramArrayOfT2) {
/*  67 */     return new Permutations<>(paramArrayOfT1, paramArrayOfT2, paramArrayOfT1.length);
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
/*     */   public static <T> Permutations<T> create(T[] paramArrayOfT1, T[] paramArrayOfT2, int paramInt) {
/*  80 */     return new Permutations<>(paramArrayOfT1, paramArrayOfT2, paramInt);
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
/*     */ 
/*     */   
/*     */   private void moveIndex() {
/*  97 */     int i = rightmostDip();
/*  98 */     if (i < 0) {
/*  99 */       this.hasNext = false;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 104 */     int j = i + 1; int k;
/* 105 */     for (k = i + 2; k < this.n; k++) {
/* 106 */       if (this.index[k] < this.index[j] && this.index[k] > this.index[i]) {
/* 107 */         j = k;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 112 */     k = this.index[i];
/* 113 */     this.index[i] = this.index[j];
/* 114 */     this.index[j] = k;
/*     */     
/* 116 */     if (this.m - 1 > i) {
/*     */       
/* 118 */       reverseAfter(i);
/*     */ 
/*     */       
/* 121 */       reverseAfter(this.m - 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int rightmostDip() {
/* 132 */     for (int i = this.n - 2; i >= 0; i--) {
/* 133 */       if (this.index[i] < this.index[i + 1]) {
/* 134 */         return i;
/*     */       }
/*     */     } 
/* 137 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void reverseAfter(int paramInt) {
/* 146 */     int i = paramInt + 1;
/* 147 */     int j = this.n - 1;
/* 148 */     while (i < j) {
/* 149 */       int k = this.index[i];
/* 150 */       this.index[i] = this.index[j];
/* 151 */       this.index[j] = k;
/* 152 */       i++;
/* 153 */       j--;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean next() {
/* 163 */     if (!this.hasNext) {
/* 164 */       return false;
/*     */     }
/* 166 */     for (byte b = 0; b < this.m; b++) {
/* 167 */       this.out[b] = this.in[this.index[b]];
/*     */     }
/* 169 */     moveIndex();
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\Permutations.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */