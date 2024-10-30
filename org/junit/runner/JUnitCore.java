/*     */ package org.junit.runner;
/*     */ 
/*     */ import junit.b.i;
/*     */ import junit.runner.Version;
/*     */ import org.junit.c.e.e;
/*     */ import org.junit.c.h;
/*     */ import org.junit.c.j;
/*     */ import org.junit.c.k;
/*     */ import org.junit.runner.b.b;
/*     */ import org.junit.runner.b.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JUnitCore
/*     */ {
/*  25 */   private final c a = new c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String... paramVarArgs) {
/*  36 */     k k = (new JUnitCore()).a((h)new j(), paramVarArgs);
/*  37 */     System.exit(k.er() ? 0 : 1);
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
/*     */   public static k a(Class<?>... paramVarArgs) {
/*  49 */     return a(d(), paramVarArgs);
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
/*     */   public static k a(a parama, Class<?>... paramVarArgs) {
/*  62 */     return (new JUnitCore()).b(parama, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   k a(h paramh, String... paramVarArgs) {
/*  70 */     paramh.b().println("JUnit version " + Version.id());
/*     */     
/*  72 */     g g = g.a(paramVarArgs);
/*     */     
/*  74 */     k k = new k(paramh);
/*  75 */     a((b)k);
/*     */     
/*  77 */     return a(g.a(d()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  84 */     return Version.id();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k b(Class<?>... paramVarArgs) {
/*  94 */     return b(d(), paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k b(a parama, Class<?>... paramVarArgs) {
/* 105 */     return a(j.a(parama, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k a(j paramj) {
/* 115 */     return a(paramj.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k a(i parami) {
/* 125 */     return a((m)new e(parami));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public k a(m paramm) {
/* 132 */     k k = new k();
/* 133 */     b b = k.b();
/* 134 */     this.a.c(b);
/*     */     try {
/* 136 */       this.a.k(paramm.a());
/* 137 */       paramm.a(this.a);
/* 138 */       this.a.d(k);
/*     */     } finally {
/* 140 */       b(b);
/*     */     } 
/* 142 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(b paramb) {
/* 152 */     this.a.a(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(b paramb) {
/* 161 */     this.a.b(paramb);
/*     */   }
/*     */   
/*     */   static a d() {
/* 165 */     return new a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\JUnitCore.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */