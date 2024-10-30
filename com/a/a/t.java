/*     */ package com.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class t
/*     */ {
/*  41 */   protected int size = 0;
/*  42 */   protected double[] h = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t() {
/*  48 */     this.h = new double[2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t(double[] paramArrayOfdouble, int paramInt) {
/*  57 */     if (paramArrayOfdouble == null) {
/*  58 */       throw new IllegalArgumentException("value array cannot be null.");
/*     */     }
/*  60 */     if (paramInt < 0 || paramInt > paramArrayOfdouble.length) {
/*  61 */       throw new IllegalArgumentException("size >= 0 && size <= value.length required");
/*     */     }
/*  63 */     this.h = paramArrayOfdouble;
/*  64 */     this.size = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t(int paramInt) {
/*  71 */     this.h = new double[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  78 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double a(int paramInt) {
/*  87 */     if (paramInt < 0 || paramInt >= this.size) {
/*  88 */       throw new IllegalArgumentException("required: (index >= 0 && index < size) but: (index = " + paramInt + ", size = " + this.size + ")");
/*     */     }
/*  90 */     return this.h[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(double paramDouble, int paramInt) {
/*  99 */     if (paramInt < 0 || paramInt >= this.size) {
/* 100 */       throw new IllegalArgumentException("required: (index >= 0 && index < size) but: (index = " + paramInt + ", size = " + this.size + ")");
/*     */     }
/* 102 */     this.h[paramInt] = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(int paramInt) {
/* 111 */     if (paramInt < 0 || paramInt >= this.size) {
/* 112 */       throw new IllegalArgumentException("required: (index >= 0 && index < size) but: (index = " + paramInt + ", size = " + this.size + ")");
/*     */     }
/* 114 */     for (int i = paramInt + 1; i < this.size; i++) {
/* 115 */       this.h[i - 1] = this.h[i];
/*     */     }
/* 117 */     this.size--;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(double paramDouble) {
/* 124 */     b(paramDouble, this.size);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(double paramDouble, int paramInt) {
/* 133 */     if (paramInt < 0 || paramInt > this.size) {
/* 134 */       throw new IllegalArgumentException("required: (index >= 0 && index <= size) but: (index = " + paramInt + ", size = " + this.size + ")");
/*     */     }
/* 136 */     ensureCapacity(this.size + 1);
/*     */     
/* 138 */     for (int i = this.size; i > paramInt; i--) {
/* 139 */       this.h[i] = this.h[i - 1];
/*     */     }
/* 141 */     this.h[paramInt] = paramDouble;
/* 142 */     this.size++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ensureCapacity(int paramInt) {
/* 151 */     if (this.h.length < paramInt) {
/* 152 */       int i = 2 * this.h.length;
/* 153 */       if (i < paramInt) i = paramInt; 
/* 154 */       double[] arrayOfDouble = new double[i];
/* 155 */       for (byte b = 0; b < this.size; b++)
/* 156 */         arrayOfDouble[b] = this.h[b]; 
/* 157 */       this.h = arrayOfDouble;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gr() {
/* 166 */     if (this.size < this.h.length) {
/* 167 */       double[] arrayOfDouble = new double[this.size];
/* 168 */       for (byte b = 0; b < this.size; b++)
/* 169 */         arrayOfDouble[b] = this.h[b]; 
/* 170 */       this.h = arrayOfDouble;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\t.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */