/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.K;
/*     */ import java.time.Duration;
/*     */ import java.util.Locale;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @c
/*     */ public abstract class af
/*     */ {
/*     */   private final a a;
/*     */   private volatile Object aq;
/*     */   
/*     */   public static af a(double paramDouble) {
/* 129 */     return a(paramDouble, a.a());
/*     */   }
/*     */   
/*     */   @d
/*     */   static af a(double paramDouble, a parama) {
/* 134 */     an.a a1 = new an.a(parama, 1.0D);
/* 135 */     a1.v(paramDouble);
/* 136 */     return a1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static af a(double paramDouble, Duration paramDuration) {
/* 164 */     return a(paramDouble, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static af a(double paramDouble, long paramLong, TimeUnit paramTimeUnit) {
/* 193 */     D.a((paramLong >= 0L), "warmupPeriod must not be negative: %s", paramLong);
/* 194 */     return a(paramDouble, paramLong, paramTimeUnit, 3.0D, 
/* 195 */         a.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static af a(double paramDouble1, long paramLong, TimeUnit paramTimeUnit, double paramDouble2, a parama) {
/* 205 */     an.b b = new an.b(parama, paramLong, paramTimeUnit, paramDouble2);
/* 206 */     b.v(paramDouble1);
/* 207 */     return b;
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
/*     */   private Object G() {
/* 220 */     Object object = this.aq;
/* 221 */     if (object == null) {
/* 222 */       synchronized (this) {
/* 223 */         object = this.aq;
/* 224 */         if (object == null) {
/* 225 */           this.aq = object = new Object();
/*     */         }
/*     */       } 
/*     */     }
/* 229 */     return object;
/*     */   }
/*     */   
/*     */   af(a parama) {
/* 233 */     this.a = (a)D.checkNotNull(parama);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void v(double paramDouble) {
/* 255 */     D.a((paramDouble > 0.0D && 
/* 256 */         !Double.isNaN(paramDouble)), "rate must be positive");
/* 257 */     synchronized (G()) {
/* 258 */       a(paramDouble, this.a.ae());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract void a(double paramDouble, long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double L() {
/* 271 */     synchronized (G()) {
/* 272 */       return M();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract double M();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public double N() {
/* 289 */     return b(1);
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
/*     */   @com.google.b.a.a
/*     */   public double b(int paramInt) {
/* 303 */     long l = e(paramInt);
/* 304 */     this.a.O(l);
/* 305 */     return 1.0D * l / TimeUnit.SECONDS.toMicros(1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final long e(int paramInt) {
/* 315 */     aG(paramInt);
/* 316 */     synchronized (G()) {
/* 317 */       return a(paramInt, this.a.ae());
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
/*     */ 
/*     */   
/*     */   public boolean c(Duration paramDuration) {
/* 334 */     return a(1, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */   public boolean c(long paramLong, TimeUnit paramTimeUnit) {
/* 351 */     return a(1, paramLong, paramTimeUnit);
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
/*     */   public boolean s(int paramInt) {
/* 365 */     return a(paramInt, 0L, TimeUnit.MICROSECONDS);
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
/*     */   public boolean tryAcquire() {
/* 378 */     return a(1, 0L, TimeUnit.MICROSECONDS);
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
/*     */   public boolean a(int paramInt, Duration paramDuration) {
/* 393 */     return a(paramInt, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */   public boolean a(int paramInt, long paramLong, TimeUnit paramTimeUnit) {
/* 409 */     long l2, l1 = Math.max(paramTimeUnit.toMicros(paramLong), 0L);
/* 410 */     aG(paramInt);
/*     */     
/* 412 */     synchronized (G()) {
/* 413 */       long l = this.a.ae();
/* 414 */       if (!e(l, l1)) {
/* 415 */         return false;
/*     */       }
/* 417 */       l2 = a(paramInt, l);
/*     */     } 
/*     */     
/* 420 */     this.a.O(l2);
/* 421 */     return true;
/*     */   }
/*     */   
/*     */   private boolean e(long paramLong1, long paramLong2) {
/* 425 */     return (k(paramLong1) - paramLong2 <= paramLong1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final long a(int paramInt, long paramLong) {
/* 434 */     long l = b(paramInt, paramLong);
/* 435 */     return Math.max(l - paramLong, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract long k(long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract long b(int paramInt, long paramLong);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 457 */     return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[] { Double.valueOf(L()) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static abstract class a
/*     */   {
/*     */     protected abstract long ae();
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract void O(long param1Long);
/*     */ 
/*     */ 
/*     */     
/*     */     public static a a() {
/* 474 */       return new a() {
/* 475 */           final K a = K.b();
/*     */ 
/*     */           
/*     */           protected long ae() {
/* 479 */             return this.a.a(TimeUnit.MICROSECONDS);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void O(long param2Long) {
/* 484 */             if (param2Long > 0L) {
/* 485 */               aw.e(param2Long, TimeUnit.MICROSECONDS);
/*     */             }
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */   
/*     */   private static void aG(int paramInt) {
/* 493 */     D.a((paramInt > 0), "Requested permits (%s) must be positive", paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\af.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */