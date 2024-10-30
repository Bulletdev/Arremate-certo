/*     */ package com.a.c;
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
/*     */ public class g
/*     */   extends m
/*     */ {
/*  41 */   private a c = new a(1);
/*  42 */   private double[] j = new double[1];
/*     */   
/*     */   public g(String paramString, boolean paramBoolean) {
/*  45 */     super(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(c paramc) {
/*  52 */     a(paramc, this.c.size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(c paramc, int paramInt) {
/*  59 */     a(paramc);
/*  60 */     int i = this.c.getCapacity();
/*  61 */     this.c.c(paramc, paramInt);
/*  62 */     int j = this.c.getCapacity();
/*     */     
/*  64 */     if (i != j) {
/*  65 */       this.j = new double[j];
/*     */     }
/*  67 */     paramc.a = this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(c paramc) {
/*  74 */     int i = this.c.size();
/*  75 */     this.c.q(paramc);
/*  76 */     if (i != this.c.size()) {
/*  77 */       paramc.a = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int aP() {
/*  84 */     return this.c.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c a(int paramInt) {
/*  91 */     return (c)this.c.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double a(o paramo, f paramf) {
/* 101 */     int i = this.c.size();
/*     */     
/* 103 */     for (byte b = 0; b < i; b++) {
/* 104 */       this.j[b] = a(b).a(paramo, paramf);
/*     */     }
/* 106 */     double d = paramf.a(this.name, i).a(this.j, i);
/*     */     
/* 108 */     if (this.bB) d = -d;
/*     */     
/* 110 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */