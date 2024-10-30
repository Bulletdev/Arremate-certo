/*     */ package com.google.a.c;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.b.y;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ public final class g
/*     */ {
/*     */   private final long ai;
/*     */   private final long aj;
/*     */   private final long ak;
/*     */   private final long al;
/*     */   private final long am;
/*     */   private final long an;
/*     */   
/*     */   public g(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
/*  85 */     D.checkArgument((paramLong1 >= 0L));
/*  86 */     D.checkArgument((paramLong2 >= 0L));
/*  87 */     D.checkArgument((paramLong3 >= 0L));
/*  88 */     D.checkArgument((paramLong4 >= 0L));
/*  89 */     D.checkArgument((paramLong5 >= 0L));
/*  90 */     D.checkArgument((paramLong6 >= 0L));
/*     */     
/*  92 */     this.ai = paramLong1;
/*  93 */     this.aj = paramLong2;
/*  94 */     this.ak = paramLong3;
/*  95 */     this.al = paramLong4;
/*  96 */     this.am = paramLong5;
/*  97 */     this.an = paramLong6;
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
/*     */   public long M() {
/* 109 */     return com.google.a.k.g.g(this.ai, this.aj);
/*     */   }
/*     */ 
/*     */   
/*     */   public long N() {
/* 114 */     return this.ai;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double r() {
/* 123 */     long l = M();
/* 124 */     return (l == 0L) ? 1.0D : (this.ai / l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long O() {
/* 134 */     return this.aj;
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
/*     */   public double s() {
/* 147 */     long l = M();
/* 148 */     return (l == 0L) ? 0.0D : (this.aj / l);
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
/*     */   public long P() {
/* 161 */     return com.google.a.k.g.g(this.ak, this.al);
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
/*     */   public long Q() {
/* 175 */     return this.ak;
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
/*     */   public long R() {
/* 189 */     return this.al;
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
/*     */   public double t() {
/* 202 */     long l = com.google.a.k.g.g(this.ak, this.al);
/* 203 */     return (l == 0L) ? 0.0D : (this.al / l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long S() {
/* 213 */     return this.am;
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
/*     */   public double u() {
/* 225 */     long l = com.google.a.k.g.g(this.ak, this.al);
/* 226 */     return (l == 0L) ? 0.0D : (this.am / l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long T() {
/* 234 */     return this.an;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g a(g paramg) {
/* 243 */     return new g(
/* 244 */         Math.max(0L, com.google.a.k.g.h(this.ai, paramg.ai)), 
/* 245 */         Math.max(0L, com.google.a.k.g.h(this.aj, paramg.aj)), 
/* 246 */         Math.max(0L, com.google.a.k.g.h(this.ak, paramg.ak)), 
/* 247 */         Math.max(0L, com.google.a.k.g.h(this.al, paramg.al)), 
/* 248 */         Math.max(0L, com.google.a.k.g.h(this.am, paramg.am)), 
/* 249 */         Math.max(0L, com.google.a.k.g.h(this.an, paramg.an)));
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
/*     */   public g b(g paramg) {
/* 263 */     return new g(
/* 264 */         com.google.a.k.g.g(this.ai, paramg.ai), 
/* 265 */         com.google.a.k.g.g(this.aj, paramg.aj), 
/* 266 */         com.google.a.k.g.g(this.ak, paramg.ak), 
/* 267 */         com.google.a.k.g.g(this.al, paramg.al), 
/* 268 */         com.google.a.k.g.g(this.am, paramg.am), 
/* 269 */         com.google.a.k.g.g(this.an, paramg.an));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 274 */     return y.a(new Object[] {
/* 275 */           Long.valueOf(this.ai), Long.valueOf(this.aj), Long.valueOf(this.ak), Long.valueOf(this.al), Long.valueOf(this.am), Long.valueOf(this.an)
/*     */         });
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 280 */     if (paramObject instanceof g) {
/* 281 */       g g1 = (g)paramObject;
/* 282 */       return (this.ai == g1.ai && this.aj == g1.aj && this.ak == g1.ak && this.al == g1.al && this.am == g1.am && this.an == g1.an);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 289 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 294 */     return x.a(this)
/* 295 */       .a("hitCount", this.ai)
/* 296 */       .a("missCount", this.aj)
/* 297 */       .a("loadSuccessCount", this.ak)
/* 298 */       .a("loadExceptionCount", this.al)
/* 299 */       .a("totalLoadTime", this.am)
/* 300 */       .a("evictionCount", this.an)
/* 301 */       .toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */