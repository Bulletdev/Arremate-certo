/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class j
/*     */ {
/*  39 */   private final m a = new m();
/*  40 */   private final m b = new m();
/*  41 */   private double J = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(double paramDouble1, double paramDouble2) {
/*  56 */     this.a.add(paramDouble1);
/*  57 */     if (d.e(paramDouble1) && d.e(paramDouble2)) {
/*  58 */       if (this.a.count() > 1L) {
/*  59 */         this.J += (paramDouble1 - this.a.B()) * (paramDouble2 - this.b.B());
/*     */       }
/*     */     } else {
/*  62 */       this.J = Double.NaN;
/*     */     } 
/*  64 */     this.b.add(paramDouble2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(i parami) {
/*  72 */     if (parami.count() == 0L) {
/*     */       return;
/*     */     }
/*     */     
/*  76 */     this.a.a(parami.a());
/*  77 */     if (this.b.count() == 0L) {
/*  78 */       this.J = parami.A();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  83 */       this.J += parami
/*  84 */         .A() + (parami
/*  85 */         .a().B() - this.a.B()) * (parami
/*  86 */         .b().B() - this.b.B()) * parami
/*  87 */         .count();
/*     */     } 
/*  89 */     this.b.a(parami.b());
/*     */   }
/*     */ 
/*     */   
/*     */   public i a() {
/*  94 */     return new i(this.a.c(), this.b.c(), this.J);
/*     */   }
/*     */ 
/*     */   
/*     */   public long count() {
/*  99 */     return this.a.count();
/*     */   }
/*     */ 
/*     */   
/*     */   public l a() {
/* 104 */     return this.a.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public l b() {
/* 109 */     return this.b.c();
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
/*     */   public double x() {
/* 127 */     D.ab((count() != 0L));
/* 128 */     return this.J / count();
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
/*     */   public final double y() {
/* 145 */     D.ab((count() > 1L));
/* 146 */     return this.J / (count() - 1L);
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
/*     */   public final double z() {
/* 166 */     D.ab((count() > 1L));
/* 167 */     if (Double.isNaN(this.J)) {
/* 168 */       return Double.NaN;
/*     */     }
/* 170 */     double d1 = this.a.J();
/* 171 */     double d2 = this.b.J();
/* 172 */     D.ab((d1 > 0.0D));
/* 173 */     D.ab((d2 > 0.0D));
/*     */ 
/*     */ 
/*     */     
/* 177 */     double d3 = i(d1 * d2);
/* 178 */     return j(this.J / Math.sqrt(d3));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f d() {
/* 213 */     D.ab((count() > 1L));
/* 214 */     if (Double.isNaN(this.J)) {
/* 215 */       return f.a();
/*     */     }
/* 217 */     double d = this.a.J();
/* 218 */     if (d > 0.0D) {
/* 219 */       if (this.b.J() > 0.0D) {
/* 220 */         return f.a(this.a.B(), this.b.B())
/* 221 */           .c(this.J / d);
/*     */       }
/* 223 */       return f.b(this.b.B());
/*     */     } 
/*     */     
/* 226 */     D.ab((this.b.J() > 0.0D));
/* 227 */     return f.a(this.a.B());
/*     */   }
/*     */ 
/*     */   
/*     */   private double i(double paramDouble) {
/* 232 */     if (paramDouble > 0.0D) {
/* 233 */       return paramDouble;
/*     */     }
/* 235 */     return Double.MIN_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   private static double j(double paramDouble) {
/* 240 */     return d.a(paramDouble, -1.0D, 1.0D);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */