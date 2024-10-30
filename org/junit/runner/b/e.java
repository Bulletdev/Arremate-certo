/*     */ package org.junit.runner.b;
/*     */ 
/*     */ import org.junit.runner.c;
/*     */ import org.junit.runner.k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class e
/*     */   extends b
/*     */ {
/*     */   private final b a;
/*     */   private final Object aJ;
/*     */   
/*     */   e(b paramb, Object paramObject) {
/*  28 */     this.a = paramb;
/*  29 */     this.aJ = paramObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public void h(c paramc) throws Exception {
/*  34 */     synchronized (this.aJ) {
/*  35 */       this.a.h(paramc);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(k paramk) throws Exception {
/*  41 */     synchronized (this.aJ) {
/*  42 */       this.a.a(paramk);
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
/*     */   public void i(c paramc) throws Exception {
/*  57 */     synchronized (this.aJ) {
/*  58 */       this.a.i(paramc);
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
/*     */   public void j(c paramc) throws Exception {
/*  72 */     synchronized (this.aJ) {
/*  73 */       this.a.j(paramc);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(c paramc) throws Exception {
/*  79 */     synchronized (this.aJ) {
/*  80 */       this.a.b(paramc);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(c paramc) throws Exception {
/*  86 */     synchronized (this.aJ) {
/*  87 */       this.a.a(paramc);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(a parama) throws Exception {
/*  93 */     synchronized (this.aJ) {
/*  94 */       this.a.a(parama);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(a parama) {
/* 100 */     synchronized (this.aJ) {
/* 101 */       this.a.b(parama);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void c(c paramc) throws Exception {
/* 107 */     synchronized (this.aJ) {
/* 108 */       this.a.c(paramc);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 114 */     return this.a.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 119 */     if (this == paramObject) {
/* 120 */       return true;
/*     */     }
/* 122 */     if (!(paramObject instanceof e)) {
/* 123 */       return false;
/*     */     }
/* 125 */     e e1 = (e)paramObject;
/*     */     
/* 127 */     return this.a.equals(e1.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     return this.a.toString() + " (with synchronization wrapper)";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\b\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */