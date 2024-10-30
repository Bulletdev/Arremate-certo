/*     */ package org.junit.f;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.junit.c.e.a.c;
/*     */ import org.junit.c.e.c.c;
/*     */ import org.junit.c.e.c.d;
/*     */ import org.junit.c.e.c.e;
/*     */ import org.junit.c.e.c.f;
/*     */ import org.junit.e.f;
/*     */ import org.junit.e.l;
/*     */ import org.junit.f;
/*     */ import org.junit.f.a.c;
/*     */ import org.junit.f.a.d;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.f.a.g;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.f.a.m;
/*     */ import org.junit.g.d;
/*     */ import org.junit.g.e;
/*     */ import org.junit.k;
/*     */ import org.junit.l;
/*     */ import org.junit.m;
/*     */ import org.junit.runner.b.c;
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
/*     */ public class b
/*     */   extends f<d>
/*     */ {
/*  64 */   private static e a = (e)new d();
/*     */   
/*  66 */   private final ConcurrentMap<d, c> g = new ConcurrentHashMap<d, c>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b(Class<?> paramClass) throws e {
/*  74 */     super(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected b(m paramm) throws e {
/*  84 */     super(paramm);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(d paramd, c paramc) {
/*  93 */     c c1 = a(paramd);
/*  94 */     if (a(paramd)) {
/*  95 */       paramc.o(c1);
/*     */     } else {
/*  97 */       l l = new l(this, paramd)
/*     */         {
/*     */           public void io() throws Throwable {
/* 100 */             this.a.a(this.b).io();
/*     */           }
/*     */         };
/* 103 */       a(l, c1, paramc);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean a(d paramd) {
/* 113 */     return (paramd.getAnnotation(k.class) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected c a(d paramd) {
/* 118 */     c c = this.g.get(paramd);
/*     */     
/* 120 */     if (c == null) {
/* 121 */       c = c.a(a().getJavaClass(), a(paramd), paramd.getAnnotations());
/*     */       
/* 123 */       this.g.putIfAbsent(paramd, c);
/*     */     } 
/*     */     
/* 126 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<d> getChildren() {
/* 131 */     return bf();
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
/*     */   protected List<d> bf() {
/* 144 */     return a().a(m.class);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void t(List<Throwable> paramList) {
/* 149 */     super.t(paramList);
/*     */     
/* 151 */     y(paramList);
/* 152 */     z(paramList);
/* 153 */     w(paramList);
/* 154 */     C(paramList);
/* 155 */     D(paramList);
/* 156 */     E(paramList);
/*     */   }
/*     */   
/*     */   private void y(List<Throwable> paramList) {
/* 160 */     if (a().getJavaClass() != null) {
/* 161 */       paramList.addAll(a.b(a()));
/*     */     }
/*     */   }
/*     */   
/*     */   protected void z(List<Throwable> paramList) {
/* 166 */     if (a().gz()) {
/* 167 */       String str = "The inner class " + a().getName() + " is not static.";
/*     */       
/* 169 */       paramList.add(new Exception(str));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void w(List<Throwable> paramList) {
/* 179 */     A(paramList);
/* 180 */     B(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void A(List<Throwable> paramList) {
/* 188 */     if (!gv()) {
/* 189 */       String str = "Test class should have exactly one public constructor";
/* 190 */       paramList.add(new Exception(str));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void B(List<Throwable> paramList) {
/* 199 */     if (!a().gz() && gv() && (a().c().getParameterTypes()).length != 0) {
/*     */ 
/*     */       
/* 202 */       String str = "Test class should have exactly one public zero-argument constructor";
/* 203 */       paramList.add(new Exception(str));
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean gv() {
/* 208 */     return ((a().getJavaClass().getConstructors()).length == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected void C(List<Throwable> paramList) {
/* 219 */     a((Class)org.junit.a.class, false, paramList);
/* 220 */     a((Class)f.class, false, paramList);
/* 221 */     x(paramList);
/*     */     
/* 223 */     if (bf().isEmpty()) {
/* 224 */       paramList.add(new Exception("No runnable methods"));
/*     */     }
/*     */   }
/*     */   
/*     */   protected void D(List<Throwable> paramList) {
/* 229 */     org.junit.c.e.b.a.b.a(a(), paramList);
/*     */   }
/*     */   
/*     */   private void E(List<Throwable> paramList) {
/* 233 */     org.junit.c.e.b.a.d.a(a(), paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void x(List<Throwable> paramList) {
/* 241 */     a((Class)m.class, false, paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object O() throws Exception {
/* 250 */     return a().c().newInstance(new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object a(d paramd) throws Exception {
/* 260 */     return O();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String a(d paramd) {
/* 268 */     return paramd.getName();
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
/*     */   
/*     */   protected l a(d paramd) {
/*     */     Object object;
/*     */     try {
/* 306 */       object = (new c(this, paramd)
/*     */         {
/*     */           protected Object P() throws Throwable {
/* 309 */             return this.a.a(this.b);
/*     */           }
/*     */         }).run();
/* 312 */     } catch (Throwable throwable) {
/* 313 */       return (l)new org.junit.c.e.c.b(throwable);
/*     */     } 
/*     */     
/* 316 */     l l = a(paramd, object);
/* 317 */     l = a(paramd, object, l);
/* 318 */     l = b(paramd, object, l);
/* 319 */     l = c(paramd, object, l);
/* 320 */     l = d(paramd, object, l);
/* 321 */     l = e(paramd, object, l);
/* 322 */     l = f(l);
/* 323 */     return l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected l a(d paramd, Object paramObject) {
/* 334 */     return (l)new d(paramd, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected l a(d paramd, Object paramObject, l paraml) {
/* 345 */     m m = (m)paramd.getAnnotation(m.class);
/* 346 */     Class<? extends Throwable> clazz = a(m);
/* 347 */     return (clazz != null) ? (l)new org.junit.c.e.c.a(paraml, clazz) : paraml;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected l b(d paramd, Object paramObject, l paraml) {
/* 359 */     long l1 = a((m)paramd.getAnnotation(m.class));
/* 360 */     if (l1 <= 0L) {
/* 361 */       return paraml;
/*     */     }
/* 363 */     return (l)c.a().a(l1, TimeUnit.MILLISECONDS).a(paraml);
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
/*     */   protected l c(d paramd, Object paramObject, l paraml) {
/* 375 */     List list = a().a(f.class);
/*     */     
/* 377 */     return list.isEmpty() ? paraml : (l)new f(paraml, list, paramObject);
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
/*     */   protected l d(d paramd, Object paramObject, l paraml) {
/* 390 */     List list = a().a(org.junit.a.class);
/*     */     
/* 392 */     return list.isEmpty() ? paraml : (l)new e(paraml, list, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   private l e(d paramd, Object paramObject, l paraml) {
/* 397 */     g g = new g();
/* 398 */     f.set(g);
/*     */     try {
/* 400 */       List<l> list = d(paramObject);
/* 401 */       for (f f1 : c(paramObject)) {
/* 402 */         if (!(f1 instanceof l) || !list.contains(f1)) {
/* 403 */           g.a(f1);
/*     */         }
/*     */       } 
/* 406 */       for (l l1 : list) {
/* 407 */         g.a(l1);
/*     */       }
/*     */     } finally {
/* 410 */       f.remove();
/*     */     } 
/* 412 */     return g.a(paramd, a(paramd), paramObject, paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<f> c(Object paramObject) {
/* 421 */     a a = new a();
/* 422 */     a().b(paramObject, l.class, f.class, a);
/*     */     
/* 424 */     a().a(paramObject, l.class, f.class, a);
/*     */     
/* 426 */     return a.result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<l> d(Object paramObject) {
/* 435 */     a a = new a();
/* 436 */     a().b(paramObject, l.class, l.class, a);
/* 437 */     a().a(paramObject, l.class, l.class, a);
/* 438 */     return a.result;
/*     */   }
/*     */   
/*     */   private Class<? extends Throwable> a(m paramm) {
/* 442 */     if (paramm == null || paramm.k() == m.a.class) {
/* 443 */       return null;
/*     */     }
/* 445 */     return paramm.k();
/*     */   }
/*     */ 
/*     */   
/*     */   private long a(m paramm) {
/* 450 */     if (paramm == null) {
/* 451 */       return 0L;
/*     */     }
/* 453 */     return paramm.am();
/*     */   }
/*     */   
/* 456 */   private static final ThreadLocal<g> f = new ThreadLocal<g>();
/*     */   
/*     */   private static class a<T>
/*     */     implements g<T> {
/* 460 */     final List<T> result = new ArrayList<T>();
/*     */     
/*     */     public void a(c<?> param1c, T param1T) {
/* 463 */       l l = (l)param1c.getAnnotation(l.class);
/* 464 */       if (l != null) {
/* 465 */         g g1 = b.a().get();
/* 466 */         if (g1 != null) {
/* 467 */           g1.d(param1T, l.bT());
/*     */         }
/*     */       } 
/* 470 */       this.result.add(param1T);
/*     */     }
/*     */     
/*     */     private a() {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */