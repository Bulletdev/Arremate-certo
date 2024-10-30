/*     */ package org.junit.e;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.junit.e;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.runner.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class i
/*     */   implements l
/*     */ {
/*     */   private final a a;
/*     */   private volatile long bX;
/*     */   private volatile long bY;
/*     */   
/*     */   public i() {
/*  85 */     this(new a());
/*     */   }
/*     */   
/*     */   i(a parama) {
/*  89 */     this.a = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long b(TimeUnit paramTimeUnit) {
/*  99 */     return paramTimeUnit.convert(getNanos(), TimeUnit.NANOSECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(long paramLong, c paramc) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(long paramLong, Throwable paramThrowable, c paramc) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(long paramLong, e parame, c paramc) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void b(long paramLong, c paramc) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long getNanos() {
/* 127 */     if (this.bX == 0L) {
/* 128 */       throw new IllegalStateException("Test has not started");
/*     */     }
/* 130 */     long l1 = this.bY;
/* 131 */     if (l1 == 0L) {
/* 132 */       l1 = this.a.an();
/*     */     }
/*     */     
/* 135 */     return l1 - this.bX;
/*     */   }
/*     */   
/*     */   private void gd() {
/* 139 */     this.bX = this.a.an();
/* 140 */     this.bY = 0L;
/*     */   }
/*     */   
/*     */   private void iJ() {
/* 144 */     this.bY = this.a.an();
/*     */   }
/*     */   
/*     */   public final l a(l paraml, c paramc) {
/* 148 */     return (new b()).a(paraml, paramc);
/*     */   }
/*     */   
/*     */   private class b
/*     */     extends m {
/*     */     protected void d(c param1c) {
/* 154 */       i.a(this.a);
/*     */     }
/*     */     private b(i this$0) {}
/*     */     protected void e(c param1c) {
/* 158 */       this.a.b(i.a(this.a), param1c);
/*     */     }
/*     */     
/*     */     protected void f(c param1c) {
/* 162 */       i.b(this.a);
/* 163 */       this.a.a(i.a(this.a), param1c);
/*     */     }
/*     */     
/*     */     protected void a(Throwable param1Throwable, c param1c) {
/* 167 */       i.b(this.a);
/* 168 */       this.a.a(i.a(this.a), param1Throwable, param1c);
/*     */     }
/*     */     
/*     */     protected void a(e param1e, c param1c) {
/* 172 */       i.b(this.a);
/* 173 */       this.a.a(i.a(this.a), param1e, param1c);
/*     */     }
/*     */   }
/*     */   
/*     */   static class a
/*     */   {
/*     */     public long an() {
/* 180 */       return System.nanoTime();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */