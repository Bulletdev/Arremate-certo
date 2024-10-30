/*     */ package com.b.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class s
/*     */ {
/*     */   private final int gX;
/*     */   private final int gY;
/*     */   private final int[] ai;
/*     */   private final int[] aj;
/*     */   
/*     */   public s(int[] paramArrayOfint) {
/*  34 */     this.gX = Math.max(v.min(paramArrayOfint), 1);
/*  35 */     this.gY = v.max(paramArrayOfint);
/*     */ 
/*     */     
/*  38 */     int[] arrayOfInt1 = a(paramArrayOfint, this.gY);
/*     */ 
/*     */     
/*  41 */     Object[] arrayOfObject = new Object[2];
/*  42 */     this.ai = a(arrayOfInt1, this.gY, arrayOfObject);
/*     */ 
/*     */     
/*  45 */     int[] arrayOfInt2 = (int[])arrayOfObject[0];
/*  46 */     int i = ((Integer)arrayOfObject[1]).intValue();
/*  47 */     this.aj = a(paramArrayOfint, arrayOfInt2, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] a(int paramInt1, int paramInt2) {
/*  56 */     int[] arrayOfInt = new int[paramInt1];
/*     */     
/*  58 */     for (byte b = 0; b < paramInt1; b++)
/*     */     {
/*  60 */       arrayOfInt[b] = paramInt2;
/*     */     }
/*     */     
/*  63 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] a(int[] paramArrayOfint, int paramInt) {
/*  69 */     int[] arrayOfInt = new int[paramInt + 1];
/*     */ 
/*     */ 
/*     */     
/*  73 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/*     */       
/*  75 */       int i = paramArrayOfint[b];
/*  76 */       arrayOfInt[i] = arrayOfInt[i] + 1;
/*     */     } 
/*     */     
/*  79 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] a(int[] paramArrayOfint, int paramInt, Object[] paramArrayOfObject) {
/*  88 */     int[] arrayOfInt1 = a(paramInt + 1, -1);
/*     */ 
/*     */ 
/*     */     
/*  92 */     int i = 0;
/*  93 */     int j = 0;
/*  94 */     paramArrayOfint[0] = 0;
/*  95 */     int[] arrayOfInt2 = new int[paramInt + 1];
/*  96 */     for (byte b = 1; b < paramArrayOfint.length; b++) {
/*     */ 
/*     */       
/*  99 */       int k = paramArrayOfint[b - 1];
/* 100 */       i = i + k << 1;
/* 101 */       arrayOfInt2[b] = i;
/*     */ 
/*     */       
/* 104 */       j = i + paramArrayOfint[b] - 1;
/* 105 */       arrayOfInt1[b] = j;
/*     */     } 
/*     */     
/* 108 */     paramArrayOfObject[0] = arrayOfInt2;
/* 109 */     paramArrayOfObject[1] = Integer.valueOf(j);
/*     */     
/* 111 */     return arrayOfInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int[] a(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) {
/* 117 */     int[] arrayOfInt = new int[paramInt + 1];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     for (byte b = 0; b < paramArrayOfint1.length; b++) {
/*     */       
/* 124 */       int i = paramArrayOfint1[b];
/*     */       
/* 126 */       if (i != 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 131 */         paramArrayOfint2[i] = paramArrayOfint2[i] + 1; int j = paramArrayOfint2[i];
/* 132 */         arrayOfInt[j] = b;
/*     */       } 
/*     */     } 
/* 135 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int a(c paramc, int[] paramArrayOfint) throws o {
/* 141 */     for (int i = this.gX; i <= this.gY; i++) {
/*     */ 
/*     */ 
/*     */       
/* 145 */       int j = this.ai[i];
/*     */       
/* 147 */       if (j >= 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 154 */         int k = paramc.E(paramArrayOfint[0], i);
/*     */         
/* 156 */         if (j >= k) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 176 */           int m = this.aj[k];
/*     */ 
/*     */           
/* 179 */           paramArrayOfint[0] = paramArrayOfint[0] + i;
/*     */           
/* 181 */           return m;
/*     */         } 
/*     */       } 
/*     */     } 
/* 185 */     String str = String.format("[%s] Bad code at the bit index '%d'.", new Object[] {
/*     */           
/* 187 */           getClass().getSimpleName(), Integer.valueOf(paramArrayOfint[0])
/*     */         });
/* 189 */     throw new o(str);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\s.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */