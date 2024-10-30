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
/*     */ public final class BitField
/*     */ {
/*     */   private static final int ADDRESS_BITS = 6;
/*     */   private static final int BITS = 64;
/*     */   private static final int ADDRESS_MASK = 63;
/*     */   private long[] data;
/*     */   private int maxLength;
/*     */   
/*     */   public BitField() {
/*  20 */     this(64);
/*     */   }
/*     */   
/*     */   public BitField(int paramInt) {
/*  24 */     this.data = new long[paramInt >>> 3];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextClearBit(int paramInt) {
/*  34 */     int i = paramInt >> 6;
/*  35 */     int j = this.data.length;
/*  36 */     for (; i < j; i++) {
/*  37 */       if (this.data[i] != -1L) {
/*     */ 
/*     */         
/*  40 */         int k = Math.max(paramInt, i << 6);
/*  41 */         for (int m = k + 64; k < m; k++) {
/*  42 */           if (!get(k))
/*  43 */             return k; 
/*     */         } 
/*     */       } 
/*     */     } 
/*  47 */     return j << 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean get(int paramInt) {
/*  57 */     int i = paramInt >> 6;
/*  58 */     if (i >= this.data.length) {
/*  59 */       return false;
/*     */     }
/*  61 */     return ((this.data[i] & getBitMask(paramInt)) != 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getByte(int paramInt) {
/*  72 */     int i = paramInt >> 6;
/*  73 */     if (i >= this.data.length) {
/*  74 */       return 0;
/*     */     }
/*  76 */     return (int)(this.data[i] >>> (paramInt & 0x38) & 0xFFL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setByte(int paramInt1, int paramInt2) {
/*  87 */     int i = paramInt1 >> 6;
/*  88 */     checkCapacity(i);
/*  89 */     this.data[i] = this.data[i] | paramInt2 << (paramInt1 & 0x38);
/*  90 */     if (this.maxLength < paramInt1 && paramInt2 != 0) {
/*  91 */       this.maxLength = paramInt1 + 7;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(int paramInt) {
/* 101 */     int i = paramInt >> 6;
/* 102 */     checkCapacity(i);
/* 103 */     this.data[i] = this.data[i] | getBitMask(paramInt);
/* 104 */     if (this.maxLength < paramInt) {
/* 105 */       this.maxLength = paramInt;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear(int paramInt) {
/* 115 */     int i = paramInt >> 6;
/* 116 */     if (i >= this.data.length) {
/*     */       return;
/*     */     }
/* 119 */     this.data[i] = this.data[i] & (getBitMask(paramInt) ^ 0xFFFFFFFFFFFFFFFFL);
/*     */   }
/*     */   
/*     */   private static long getBitMask(int paramInt) {
/* 123 */     return 1L << (paramInt & 0x3F);
/*     */   }
/*     */   
/*     */   private void checkCapacity(int paramInt) {
/* 127 */     if (paramInt >= this.data.length) {
/* 128 */       expandCapacity(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   private void expandCapacity(int paramInt) {
/* 133 */     while (paramInt >= this.data.length) {
/* 134 */       boolean bool = (this.data.length == 0) ? true : (this.data.length * 2);
/* 135 */       long[] arrayOfLong = new long[bool];
/* 136 */       System.arraycopy(this.data, 0, arrayOfLong, 0, this.data.length);
/* 137 */       this.data = arrayOfLong;
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
/*     */   public void set(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 151 */     for (int i = paramInt2 - 1; i >= paramInt1; i--) {
/* 152 */       set(i, paramBoolean);
/*     */     }
/* 154 */     if (paramBoolean) {
/* 155 */       if (paramInt2 > this.maxLength) {
/* 156 */         this.maxLength = paramInt2;
/*     */       }
/*     */     }
/* 159 */     else if (paramInt2 >= this.maxLength) {
/* 160 */       this.maxLength = paramInt1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(int paramInt, boolean paramBoolean) {
/* 166 */     if (paramBoolean) {
/* 167 */       set(paramInt);
/*     */     } else {
/* 169 */       clear(paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int length() {
/* 179 */     int i = this.maxLength >> 6;
/* 180 */     while (i > 0 && this.data[i] == 0L) {
/* 181 */       i--;
/*     */     }
/* 183 */     this.maxLength = (i << 6) + 64 - Long.numberOfLeadingZeros(this.data[i]);
/*     */     
/* 185 */     return this.maxLength;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\BitField.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */