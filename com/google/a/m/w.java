/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.io.Serializable;
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
/*     */ @b(ck = true)
/*     */ public final class w
/*     */   extends Number
/*     */   implements Serializable, Comparable<w>
/*     */ {
/*     */   private static final long bp = 9223372036854775807L;
/*  45 */   public static final w a = new w(0L);
/*  46 */   public static final w b = new w(1L);
/*  47 */   public static final w c = new w(-1L);
/*     */   
/*     */   private final long value;
/*     */   
/*     */   private w(long paramLong) {
/*  52 */     this.value = paramLong;
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
/*     */   
/*     */   public static w a(long paramLong) {
/*  70 */     return new w(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static w b(long paramLong) {
/*  81 */     D.a((paramLong >= 0L), "value (%s) is outside the range for an unsigned long value", paramLong);
/*  82 */     return a(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static w a(BigInteger paramBigInteger) {
/*  93 */     D.checkNotNull(paramBigInteger);
/*  94 */     D.a((paramBigInteger
/*  95 */         .signum() >= 0 && paramBigInteger.bitLength() <= 64), "value (%s) is outside the range for an unsigned long value", paramBigInteger);
/*     */ 
/*     */     
/*  98 */     return a(paramBigInteger.longValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static w a(String paramString) {
/* 110 */     return a(paramString, 10);
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
/*     */   @a
/*     */   public static w a(String paramString, int paramInt) {
/* 123 */     return a(x.a(paramString, paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w a(w paramw) {
/* 133 */     return a(this.value + ((w)D.checkNotNull(paramw)).value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w b(w paramw) {
/* 143 */     return a(this.value - ((w)D.checkNotNull(paramw)).value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w c(w paramw) {
/* 153 */     return a(this.value * ((w)D.checkNotNull(paramw)).value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w d(w paramw) {
/* 162 */     return a(x.m(this.value, ((w)D.checkNotNull(paramw)).value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w e(w paramw) {
/* 171 */     return a(x.n(this.value, ((w)D.checkNotNull(paramw)).value));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int intValue() {
/* 177 */     return (int)this.value;
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
/*     */   public long longValue() {
/* 189 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 199 */     float f = (float)(this.value & Long.MAX_VALUE);
/* 200 */     if (this.value < 0L) {
/* 201 */       f += 9.223372E18F;
/*     */     }
/* 203 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 213 */     double d = (this.value & Long.MAX_VALUE);
/* 214 */     if (this.value < 0L) {
/* 215 */       d += 9.223372036854776E18D;
/*     */     }
/* 217 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   public BigInteger bigIntegerValue() {
/* 222 */     BigInteger bigInteger = BigInteger.valueOf(this.value & Long.MAX_VALUE);
/* 223 */     if (this.value < 0L) {
/* 224 */       bigInteger = bigInteger.setBit(63);
/*     */     }
/* 226 */     return bigInteger;
/*     */   }
/*     */ 
/*     */   
/*     */   public int a(w paramw) {
/* 231 */     D.checkNotNull(paramw);
/* 232 */     return x.compare(this.value, paramw.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 237 */     return m.f(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 242 */     if (paramObject instanceof w) {
/* 243 */       w w1 = (w)paramObject;
/* 244 */       return (this.value == w1.value);
/*     */     } 
/* 246 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 252 */     return x.toString(this.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString(int paramInt) {
/* 261 */     return x.a(this.value, paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\w.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */