/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ public final class u
/*     */   extends Number
/*     */   implements Comparable<u>
/*     */ {
/*  43 */   public static final u a = a(0);
/*  44 */   public static final u b = a(1);
/*  45 */   public static final u c = a(-1);
/*     */   
/*     */   private final int value;
/*     */ 
/*     */   
/*     */   private u(int paramInt) {
/*  51 */     this.value = paramInt & 0xFFFFFFFF;
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
/*     */   public static u a(int paramInt) {
/*  67 */     return new u(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static u a(long paramLong) {
/*  75 */     D.a(((paramLong & 0xFFFFFFFFL) == paramLong), "value (%s) is outside the range for an unsigned integer value", paramLong);
/*     */ 
/*     */ 
/*     */     
/*  79 */     return a((int)paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static u a(BigInteger paramBigInteger) {
/*  89 */     D.checkNotNull(paramBigInteger);
/*  90 */     D.a((paramBigInteger
/*  91 */         .signum() >= 0 && paramBigInteger.bitLength() <= 32), "value (%s) is outside the range for an unsigned integer value", paramBigInteger);
/*     */ 
/*     */     
/*  94 */     return a(paramBigInteger.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static u a(String paramString) {
/* 105 */     return a(paramString, 10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static u a(String paramString, int paramInt) {
/* 116 */     return a(v.c(paramString, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u a(u paramu) {
/* 126 */     return a(this.value + ((u)D.checkNotNull(paramu)).value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u b(u paramu) {
/* 136 */     return a(this.value - ((u)D.checkNotNull(paramu)).value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public u c(u paramu) {
/* 148 */     return a(this.value * ((u)D.checkNotNull(paramu)).value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u d(u paramu) {
/* 158 */     return a(v.B(this.value, ((u)D.checkNotNull(paramu)).value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u e(u paramu) {
/* 168 */     return a(v.C(this.value, ((u)D.checkNotNull(paramu)).value));
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
/*     */   public int intValue() {
/* 180 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 186 */     return v.d(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 195 */     return (float)longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 204 */     return longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public BigInteger bigIntegerValue() {
/* 209 */     return BigInteger.valueOf(longValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int a(u paramu) {
/* 219 */     D.checkNotNull(paramu);
/* 220 */     return v.compare(this.value, paramu.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 225 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 230 */     if (paramObject instanceof u) {
/* 231 */       u u1 = (u)paramObject;
/* 232 */       return (this.value == u1.value);
/*     */     } 
/* 234 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 240 */     return toString(10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(int paramInt) {
/* 249 */     return v.f(this.value, paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */