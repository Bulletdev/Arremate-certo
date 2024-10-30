/*     */ package org.junit.e;
/*     */ 
/*     */ import org.d.d;
/*     */ import org.d.k;
/*     */ import org.d.m;
/*     */ import org.d.n;
/*     */ import org.junit.c.c.b;
/*     */ import org.junit.f.a.l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   implements l
/*     */ {
/*     */   @Deprecated
/*     */   public static c a() {
/* 123 */     return new c();
/*     */   }
/*     */   
/* 126 */   private final d a = new d();
/*     */   
/* 128 */   private String mg = "Expected test to throw %s";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public c b() {
/* 140 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public c c() {
/* 150 */     return this;
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
/*     */   public c a(String paramString) {
/* 164 */     this.mg = paramString;
/* 165 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public l a(l paraml, org.junit.runner.c paramc) {
/* 170 */     return new a(this, paraml);
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
/*     */   public void a(k<?> paramk) {
/* 184 */     this.a.d(paramk);
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
/*     */   public void g(Class<? extends Throwable> paramClass) {
/* 197 */     a(d.d(paramClass));
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
/*     */   public void bM(String paramString) {
/* 210 */     b(d.b(paramString));
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
/*     */   public void b(k<String> paramk) {
/* 223 */     a(org.junit.c.c.c.i(paramk));
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
/*     */   public void c(k<?> paramk) {
/* 237 */     a(b.h(paramk));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean go() {
/* 245 */     return this.a.gp();
/*     */   }
/*     */   
/*     */   private class a extends l {
/*     */     private final l b;
/*     */     
/*     */     public a(c this$0, l param1l) {
/* 252 */       this.b = param1l;
/*     */     }
/*     */ 
/*     */     
/*     */     public void io() throws Throwable {
/*     */       try {
/* 258 */         this.b.io();
/* 259 */       } catch (Throwable throwable) {
/* 260 */         c.a(this.a, throwable);
/*     */         return;
/*     */       } 
/* 263 */       if (this.a.go()) {
/* 264 */         c.a(this.a);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void d(Throwable paramThrowable) throws Throwable {
/* 270 */     if (go()) {
/* 271 */       org.junit.c.a(paramThrowable, this.a.e());
/*     */     } else {
/* 273 */       throw paramThrowable;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void iG() throws AssertionError {
/* 278 */     org.junit.c.fail(eZ());
/*     */   }
/*     */   
/*     */   private String eZ() {
/* 282 */     String str = n.a((m)this.a.e());
/* 283 */     return String.format(this.mg, new Object[] { str });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */