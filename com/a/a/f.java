/*     */ package com.a.a;
/*     */ 
/*     */ import com.a.e.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class f
/*     */ {
/*  44 */   private a a = new a();
/*  45 */   private a b = new a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(i parami) {
/*  58 */     if (parami == null) {
/*  59 */       throw new IllegalArgumentException("Curve cannot be null.");
/*     */     }
/*  61 */     this.a.add(parami);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(p paramp) {
/*  70 */     if (paramp == null) {
/*  71 */       throw new IllegalArgumentException("Point cannot be null.");
/*     */     }
/*  73 */     this.b.add(paramp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(i parami, int paramInt) {
/*  82 */     if (parami == null) {
/*  83 */       throw new IllegalArgumentException("Curve cannot be null.");
/*     */     }
/*  85 */     this.a.c(parami, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(p paramp, int paramInt) {
/*  94 */     if (paramp == null) {
/*  95 */       throw new IllegalArgumentException("Point cannot be null.");
/*     */     }
/*  97 */     this.b.c(paramp, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i a(i parami, int paramInt) {
/* 107 */     if (parami == null) {
/* 108 */       throw new IllegalArgumentException("Curve cannot be null.");
/*     */     }
/* 110 */     return (i)this.a.b(parami, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p a(p paramp, int paramInt) {
/* 120 */     if (paramp == null) {
/* 121 */       throw new IllegalArgumentException("Point cannot be null.");
/*     */     }
/* 123 */     return (p)this.b.b(paramp, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i a(int paramInt) {
/* 130 */     return (i)this.a.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public p a(int paramInt) {
/* 137 */     return (p)this.b.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aD() {
/* 144 */     return this.a.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aE() {
/* 151 */     return this.b.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(i parami) {
/* 158 */     this.a.q(parami);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(p paramp) {
/* 165 */     this.b.q(paramp);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCurve(int paramInt) {
/* 172 */     this.a.remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aK(int paramInt) {
/* 179 */     this.b.remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aL(int paramInt) {
/* 188 */     this.a.ensureCapacity(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void aM(int paramInt) {
/* 197 */     this.b.ensureCapacity(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gp() {
/* 205 */     this.a.gr();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gq() {
/* 213 */     this.b.gr();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */