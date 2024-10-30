/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.d;
/*     */ import java.util.Iterator;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.DoubleStream;
/*     */ import java.util.stream.IntStream;
/*     */ import java.util.stream.LongStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class m
/*     */ {
/*  44 */   private long count = 0L;
/*  45 */   private double mean = 0.0D;
/*  46 */   private double K = 0.0D;
/*  47 */   private double L = Double.NaN;
/*  48 */   private double M = Double.NaN;
/*     */ 
/*     */   
/*     */   public void add(double paramDouble) {
/*  52 */     if (this.count == 0L) {
/*  53 */       this.count = 1L;
/*  54 */       this.mean = paramDouble;
/*  55 */       this.L = paramDouble;
/*  56 */       this.M = paramDouble;
/*  57 */       if (!d.e(paramDouble)) {
/*  58 */         this.K = Double.NaN;
/*     */       }
/*     */     } else {
/*  61 */       this.count++;
/*  62 */       if (d.e(paramDouble) && d.e(this.mean)) {
/*     */         
/*  64 */         double d = paramDouble - this.mean;
/*  65 */         this.mean += d / this.count;
/*  66 */         this.K += d * (paramDouble - this.mean);
/*     */       } else {
/*  68 */         this.mean = b(this.mean, paramDouble);
/*  69 */         this.K = Double.NaN;
/*     */       } 
/*  71 */       this.L = Math.min(this.L, paramDouble);
/*  72 */       this.M = Math.max(this.M, paramDouble);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(Iterable<? extends Number> paramIterable) {
/*  83 */     for (Number number : paramIterable) {
/*  84 */       add(number.doubleValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(Iterator<? extends Number> paramIterator) {
/*  95 */     while (paramIterator.hasNext()) {
/*  96 */       add(((Number)paramIterator.next()).doubleValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(double... paramVarArgs) {
/* 106 */     for (double d : paramVarArgs) {
/* 107 */       add(d);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(int... paramVarArgs) {
/* 117 */     for (int i : paramVarArgs) {
/* 118 */       add(i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(long... paramVarArgs) {
/* 129 */     for (long l : paramVarArgs) {
/* 130 */       add(l);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(DoubleStream paramDoubleStream) {
/* 141 */     a(paramDoubleStream.<m>collect(m::new, m::add, m::a));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(IntStream paramIntStream) {
/* 151 */     a(paramIntStream.<m>collect(m::new, m::add, m::a));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(LongStream paramLongStream) {
/* 162 */     a(paramLongStream.<m>collect(m::new, m::add, m::a));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(l paraml) {
/* 170 */     if (paraml.count() == 0L) {
/*     */       return;
/*     */     }
/* 173 */     a(paraml.count(), paraml.B(), paraml.J(), paraml.H(), paraml.I());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(m paramm) {
/* 183 */     if (paramm.count() == 0L) {
/*     */       return;
/*     */     }
/* 186 */     a(paramm.count(), paramm.B(), paramm.J(), paramm.H(), paramm.I());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 195 */     if (this.count == 0L) {
/* 196 */       this.count = paramLong;
/* 197 */       this.mean = paramDouble1;
/* 198 */       this.K = paramDouble2;
/* 199 */       this.L = paramDouble3;
/* 200 */       this.M = paramDouble4;
/*     */     } else {
/* 202 */       this.count += paramLong;
/* 203 */       if (d.e(this.mean) && d.e(paramDouble1)) {
/*     */         
/* 205 */         double d = paramDouble1 - this.mean;
/* 206 */         this.mean += d * paramLong / this.count;
/* 207 */         this.K += paramDouble2 + d * (paramDouble1 - this.mean) * paramLong;
/*     */       } else {
/* 209 */         this.mean = b(this.mean, paramDouble1);
/* 210 */         this.K = Double.NaN;
/*     */       } 
/* 212 */       this.L = Math.min(this.L, paramDouble3);
/* 213 */       this.M = Math.max(this.M, paramDouble4);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public l c() {
/* 219 */     return new l(this.count, this.mean, this.K, this.L, this.M);
/*     */   }
/*     */ 
/*     */   
/*     */   public long count() {
/* 224 */     return this.count;
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
/*     */   public double B() {
/* 246 */     D.ab((this.count != 0L));
/* 247 */     return this.mean;
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
/*     */   public final double C() {
/* 263 */     return this.mean * this.count;
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
/*     */   public final double D() {
/* 282 */     D.ab((this.count != 0L));
/* 283 */     if (Double.isNaN(this.K)) {
/* 284 */       return Double.NaN;
/*     */     }
/* 286 */     if (this.count == 1L) {
/* 287 */       return 0.0D;
/*     */     }
/* 289 */     return d.g(this.K) / this.count;
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
/*     */   public final double E() {
/* 309 */     return Math.sqrt(D());
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
/*     */   public final double F() {
/* 329 */     D.ab((this.count > 1L));
/* 330 */     if (Double.isNaN(this.K)) {
/* 331 */       return Double.NaN;
/*     */     }
/* 333 */     return d.g(this.K) / (this.count - 1L);
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
/*     */   public final double G() {
/* 355 */     return Math.sqrt(F());
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
/*     */   public double H() {
/* 372 */     D.ab((this.count != 0L));
/* 373 */     return this.L;
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
/*     */   public double I() {
/* 390 */     D.ab((this.count != 0L));
/* 391 */     return this.M;
/*     */   }
/*     */   
/*     */   double J() {
/* 395 */     return this.K;
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
/*     */   static double b(double paramDouble1, double paramDouble2) {
/* 417 */     if (d.e(paramDouble1))
/*     */     {
/* 419 */       return paramDouble2; } 
/* 420 */     if (d.e(paramDouble2) || paramDouble1 == paramDouble2)
/*     */     {
/* 422 */       return paramDouble1;
/*     */     }
/*     */     
/* 425 */     return Double.NaN;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */