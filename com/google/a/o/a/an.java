/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.k.g;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ abstract class an
/*     */   extends af
/*     */ {
/*     */   double N;
/*     */   double O;
/*     */   double P;
/*     */   
/*     */   static final class b
/*     */     extends an
/*     */   {
/*     */     private final long bF;
/*     */     private double H;
/*     */     private double R;
/*     */     private double S;
/*     */     
/*     */     b(af.a param1a, long param1Long, TimeUnit param1TimeUnit, double param1Double) {
/* 217 */       super(param1a);
/* 218 */       this.bF = param1TimeUnit.toMicros(param1Long);
/* 219 */       this.S = param1Double;
/*     */     }
/*     */ 
/*     */     
/*     */     void b(double param1Double1, double param1Double2) {
/* 224 */       double d1 = this.O;
/* 225 */       double d2 = param1Double2 * this.S;
/* 226 */       this.R = 0.5D * this.bF / param1Double2;
/* 227 */       this.O = this.R + 2.0D * this.bF / (param1Double2 + d2);
/*     */       
/* 229 */       this.H = (d2 - param1Double2) / (this.O - this.R);
/* 230 */       if (d1 == Double.POSITIVE_INFINITY) {
/*     */         
/* 232 */         this.N = 0.0D;
/*     */       } else {
/* 234 */         this
/*     */ 
/*     */           
/* 237 */           .N = (d1 == 0.0D) ? this.O : (this.N * this.O / d1);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     long a(double param1Double1, double param1Double2) {
/* 243 */       double d = param1Double1 - this.R;
/* 244 */       long l = 0L;
/*     */       
/* 246 */       if (d > 0.0D) {
/* 247 */         double d1 = Math.min(d, param1Double2);
/*     */ 
/*     */ 
/*     */         
/* 251 */         double d2 = l(d) + l(d - d1);
/* 252 */         l = (long)(d1 * d2 / 2.0D);
/* 253 */         param1Double2 -= d1;
/*     */       } 
/*     */       
/* 256 */       l += (long)(this.P * param1Double2);
/* 257 */       return l;
/*     */     }
/*     */     
/*     */     private double l(double param1Double) {
/* 261 */       return this.P + param1Double * this.H;
/*     */     }
/*     */ 
/*     */     
/*     */     double O() {
/* 266 */       return this.bF / this.O;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */     extends an
/*     */   {
/*     */     final double Q;
/*     */ 
/*     */ 
/*     */     
/*     */     a(af.a param1a, double param1Double) {
/* 281 */       super(param1a);
/* 282 */       this.Q = param1Double;
/*     */     }
/*     */ 
/*     */     
/*     */     void b(double param1Double1, double param1Double2) {
/* 287 */       double d = this.O;
/* 288 */       this.O = this.Q * param1Double1;
/* 289 */       if (d == Double.POSITIVE_INFINITY) {
/*     */         
/* 291 */         this.N = this.O;
/*     */       } else {
/* 293 */         this
/*     */ 
/*     */           
/* 296 */           .N = (d == 0.0D) ? 0.0D : (this.N * this.O / d);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     long a(double param1Double1, double param1Double2) {
/* 302 */       return 0L;
/*     */     }
/*     */ 
/*     */     
/*     */     double O() {
/* 307 */       return this.P;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 327 */   private long bE = 0L;
/*     */   
/*     */   private an(af.a parama) {
/* 330 */     super(parama);
/*     */   }
/*     */ 
/*     */   
/*     */   final void a(double paramDouble, long paramLong) {
/* 335 */     Q(paramLong);
/* 336 */     double d = TimeUnit.SECONDS.toMicros(1L) / paramDouble;
/* 337 */     this.P = d;
/* 338 */     b(paramDouble, d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final double M() {
/* 345 */     return TimeUnit.SECONDS.toMicros(1L) / this.P;
/*     */   }
/*     */ 
/*     */   
/*     */   final long k(long paramLong) {
/* 350 */     return this.bE;
/*     */   }
/*     */ 
/*     */   
/*     */   final long b(int paramInt, long paramLong) {
/* 355 */     Q(paramLong);
/* 356 */     long l1 = this.bE;
/* 357 */     double d1 = Math.min(paramInt, this.N);
/* 358 */     double d2 = paramInt - d1;
/*     */     
/* 360 */     long l2 = a(this.N, d1) + (long)(d2 * this.P);
/*     */ 
/*     */     
/* 363 */     this.bE = g.g(this.bE, l2);
/* 364 */     this.N -= d1;
/* 365 */     return l1;
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
/*     */   void Q(long paramLong) {
/* 385 */     if (paramLong > this.bE) {
/* 386 */       double d = (paramLong - this.bE) / O();
/* 387 */       this.N = Math.min(this.O, this.N + d);
/* 388 */       this.bE = paramLong;
/*     */     } 
/*     */   }
/*     */   
/*     */   abstract void b(double paramDouble1, double paramDouble2);
/*     */   
/*     */   abstract long a(double paramDouble1, double paramDouble2);
/*     */   
/*     */   abstract double O();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\an.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */