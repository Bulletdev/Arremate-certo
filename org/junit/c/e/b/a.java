/*     */ package org.junit.c.e.b;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.junit.e.l;
/*     */ import org.junit.f.a.m;
/*     */ import org.junit.l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*  32 */   public static final a a = a().a(new b()).a(new g()).a(new f()).a(new d()).a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  42 */   public static final a b = b().a(new e()).a(new f()).a(new c()).a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   public static final a c = a().c().a(new b()).a(new g()).a(new f()).a(new i()).a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   public static final a d = b().c().a(new e()).a(new f()).a(new h()).a();
/*     */ 
/*     */   
/*     */   private final Class<? extends Annotation> o;
/*     */ 
/*     */   
/*     */   private final boolean dg;
/*     */ 
/*     */   
/*     */   private final List<j> aF;
/*     */ 
/*     */   
/*     */   a(a parama) {
/*  76 */     this.o = a.a(parama);
/*  77 */     this.dg = a.a(parama);
/*  78 */     this.aF = a.a(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(m paramm, List<Throwable> paramList) {
/*  89 */     List list = this.dg ? paramm.a(this.o) : paramm.c(this.o);
/*     */ 
/*     */     
/*  92 */     for (org.junit.f.a.c<?> c : (Iterable<org.junit.f.a.c<?>>)list) {
/*  93 */       a(c, paramList);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(org.junit.f.a.c<?> paramc, List<Throwable> paramList) {
/*  98 */     for (j j : this.aF) {
/*  99 */       j.a(paramc, this.o, paramList);
/*     */     }
/*     */   }
/*     */   
/*     */   private static a a() {
/* 104 */     return new a(org.junit.h.class);
/*     */   }
/*     */   
/*     */   private static a b() {
/* 108 */     return new a(l.class);
/*     */   }
/*     */   
/*     */   private static class a {
/*     */     private final Class<? extends Annotation> o;
/*     */     private boolean dg;
/*     */     private final List<a.j> aG;
/*     */     
/*     */     private a(Class<? extends Annotation> param1Class) {
/* 117 */       this.o = param1Class;
/* 118 */       this.dg = false;
/* 119 */       this.aG = new ArrayList<a.j>();
/*     */     }
/*     */     
/*     */     a c() {
/* 123 */       this.dg = true;
/* 124 */       return this;
/*     */     }
/*     */     
/*     */     a a(a.j param1j) {
/* 128 */       this.aG.add(param1j);
/* 129 */       return this;
/*     */     }
/*     */     
/*     */     a a() {
/* 133 */       return new a(this);
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean a(org.junit.f.a.c<?> paramc) {
/* 138 */     return (c(paramc) || b(paramc));
/*     */   }
/*     */   
/*     */   private static boolean b(org.junit.f.a.c<?> paramc) {
/* 142 */     return l.class.isAssignableFrom(paramc.getType());
/*     */   }
/*     */   
/*     */   private static boolean c(org.junit.f.a.c<?> paramc) {
/* 146 */     return org.junit.e.f.class.isAssignableFrom(paramc.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static interface j
/*     */   {
/*     */     void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class e
/*     */     implements j
/*     */   {
/*     */     private e() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List) {
/* 168 */       boolean bool = a.d(param1c);
/* 169 */       boolean bool1 = (param1c.getAnnotation(org.junit.h.class) != null) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 176 */       if (param1c.isStatic() && (bool || !bool1)) {
/*     */         String str;
/* 178 */         if (a.d(param1c)) {
/* 179 */           str = "must not be static.";
/*     */         } else {
/* 181 */           str = "must not be static or it must be annotated with @ClassRule.";
/*     */         } 
/* 183 */         param1List.add(new b(param1c, param1Class, str));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class g
/*     */     implements j {
/*     */     private g() {}
/*     */     
/*     */     public void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List) {
/* 193 */       if (!param1c.isStatic()) {
/* 194 */         param1List.add(new b(param1c, param1Class, "must be static."));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class b
/*     */     implements j
/*     */   {
/*     */     private b() {}
/*     */     
/*     */     public void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List) {
/* 205 */       if (!g(param1c)) {
/* 206 */         param1List.add(new b(param1c, param1Class, "must be declared in a public class."));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean g(org.junit.f.a.c<?> param1c) {
/* 212 */       return Modifier.isPublic(param1c.getDeclaringClass().getModifiers());
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class f
/*     */     implements j {
/*     */     private f() {}
/*     */     
/*     */     public void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List) {
/* 221 */       if (!param1c.isPublic()) {
/* 222 */         param1List.add(new b(param1c, param1Class, "must be public."));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class c
/*     */     implements j
/*     */   {
/*     */     private c() {}
/*     */     
/*     */     public void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List) {
/* 233 */       if (!a.e(param1c)) {
/* 234 */         param1List.add(new b(param1c, param1Class, "must implement MethodRule or TestRule."));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class h
/*     */     implements j
/*     */   {
/*     */     private h() {}
/*     */     
/*     */     public void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List) {
/* 246 */       if (!a.e(param1c)) {
/* 247 */         param1List.add(new b(param1c, param1Class, "must return an implementation of MethodRule or TestRule."));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class i
/*     */     implements j
/*     */   {
/*     */     private i() {}
/*     */     
/*     */     public void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List) {
/* 259 */       if (!a.f(param1c)) {
/* 260 */         param1List.add(new b(param1c, param1Class, "must return an implementation of TestRule."));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class d
/*     */     implements j
/*     */   {
/*     */     private d() {}
/*     */ 
/*     */     
/*     */     public void a(org.junit.f.a.c<?> param1c, Class<? extends Annotation> param1Class, List<Throwable> param1List) {
/* 273 */       if (!a.f(param1c))
/* 274 */         param1List.add(new b(param1c, param1Class, "must implement TestRule.")); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\b\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */