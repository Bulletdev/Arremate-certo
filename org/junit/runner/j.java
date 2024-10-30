/*     */ package org.junit.runner;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import org.junit.c.a.a;
/*     */ import org.junit.c.d.a;
/*     */ import org.junit.c.d.b;
/*     */ import org.junit.c.d.d;
/*     */ import org.junit.c.d.e;
/*     */ import org.junit.c.e.b;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.runner.a.b;
/*     */ import org.junit.runner.a.h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class j
/*     */ {
/*     */   public static j a(Class<?> paramClass, String paramString) {
/*  40 */     c c = c.a(paramClass, paramString);
/*  41 */     return a(paramClass).a(c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static j a(Class<?> paramClass) {
/*  52 */     return (j)new a(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static j b(Class<?> paramClass) {
/*  63 */     return (j)new a(paramClass, false);
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
/*     */   public static j a(a parama, Class<?>... paramVarArgs) {
/*     */     try {
/*  76 */       a a1 = new a();
/*  77 */       m m = parama.a((org.junit.f.a.j)a1, paramVarArgs);
/*  78 */       return a(m);
/*  79 */     } catch (e e) {
/*  80 */       return a((m)new b((Throwable)e, paramVarArgs));
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
/*     */   public static j a(Class<?>... paramVarArgs) {
/*  92 */     return a(JUnitCore.d(), paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static j a(Class<?> paramClass, Throwable paramThrowable) {
/* 101 */     return a((m)new b(paramClass, paramThrowable));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static j a(m paramm) {
/* 109 */     return new j(paramm)
/*     */       {
/*     */         public m a() {
/* 112 */           return this.c;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract m a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a(b paramb) {
/* 132 */     return (j)new b(this, paramb);
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
/*     */   public j a(c paramc) {
/* 146 */     return a(b.a(paramc));
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
/*     */   public j a(Comparator<c> paramComparator) {
/* 172 */     return (j)new e(this, paramComparator);
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
/*     */   public j a(h paramh) {
/* 200 */     return (j)new d(this, paramh);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */