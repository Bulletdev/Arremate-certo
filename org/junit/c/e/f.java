/*     */ package org.junit.c.e;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.junit.runner.a.b;
/*     */ import org.junit.runner.a.c;
/*     */ import org.junit.runner.a.e;
/*     */ import org.junit.runner.a.i;
/*     */ import org.junit.runner.a.j;
/*     */ import org.junit.runner.b.a;
/*     */ import org.junit.runner.b.c;
/*     */ import org.junit.runner.c;
/*     */ import org.junit.runner.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class f
/*     */   extends m
/*     */   implements c, i
/*     */ {
/*     */   private final List<Method> aE;
/*     */   private j a;
/*     */   
/*     */   public f(Class<?> paramClass) throws d {
/*  33 */     this.a = new j(paramClass);
/*  34 */     this.aE = bj();
/*  35 */     validate();
/*     */   }
/*     */   
/*     */   protected List<Method> bj() {
/*  39 */     return this.a.bj();
/*     */   }
/*     */   
/*     */   protected void validate() throws d {
/*  43 */     h h = new h(this.a);
/*  44 */     h.bk();
/*  45 */     h.ix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(c paramc) {
/*  50 */     (new a(paramc, this.a, a(), new Runnable(this, paramc) {
/*     */           public void run() {
/*  52 */             this.a.b(this.b);
/*     */           }
/*     */         })).ir();
/*     */   }
/*     */   
/*     */   protected void b(c paramc) {
/*  58 */     for (Method method : this.aE) {
/*  59 */       a(method, paramc);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/*  65 */     c c1 = c.a(getName(), a());
/*  66 */     List<Method> list = this.aE;
/*  67 */     for (Method method : list) {
/*  68 */       c1.g(a(method));
/*     */     }
/*  70 */     return c1;
/*     */   }
/*     */   
/*     */   protected Annotation[] a() {
/*  74 */     return this.a.getJavaClass().getAnnotations();
/*     */   }
/*     */   
/*     */   protected String getName() {
/*  78 */     return a().getName();
/*     */   }
/*     */   
/*     */   protected Object O() throws Exception {
/*  82 */     return a().b().newInstance(new Object[0]);
/*     */   }
/*     */   protected void a(Method paramMethod, c paramc) {
/*     */     Object object;
/*  86 */     c c1 = a(paramMethod);
/*     */     
/*     */     try {
/*  89 */       object = O();
/*  90 */     } catch (InvocationTargetException invocationTargetException) {
/*  91 */       a(paramc, c1, invocationTargetException.getCause());
/*     */       return;
/*  93 */     } catch (Exception exception) {
/*  94 */       a(paramc, c1, exception);
/*     */       return;
/*     */     } 
/*  97 */     k k = a(paramMethod);
/*  98 */     (new g(object, k, paramc, c1)).run();
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(c paramc, c paramc1, Throwable paramThrowable) {
/* 103 */     paramc.n(paramc1);
/* 104 */     paramc.c(new a(paramc1, paramThrowable));
/* 105 */     paramc.p(paramc1);
/*     */   }
/*     */   
/*     */   protected k a(Method paramMethod) {
/* 109 */     return new k(paramMethod, this.a);
/*     */   }
/*     */   
/*     */   protected String b(Method paramMethod) {
/* 113 */     return paramMethod.getName();
/*     */   }
/*     */   
/*     */   protected c a(Method paramMethod) {
/* 117 */     return c.a(a().getJavaClass(), b(paramMethod), a(paramMethod));
/*     */   }
/*     */   
/*     */   protected Annotation[] a(Method paramMethod) {
/* 121 */     return paramMethod.getAnnotations();
/*     */   }
/*     */   
/*     */   public void a(b paramb) throws e {
/* 125 */     for (Iterator<Method> iterator = this.aE.iterator(); iterator.hasNext(); ) {
/* 126 */       Method method = iterator.next();
/* 127 */       if (!paramb.b(a(method))) {
/* 128 */         iterator.remove();
/*     */       }
/*     */     } 
/* 131 */     if (this.aE.isEmpty()) {
/* 132 */       throw new e();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(j paramj) {
/* 137 */     Collections.sort(this.aE, new Comparator<Method>(this, paramj) {
/*     */           public int compare(Method param1Method1, Method param1Method2) {
/* 139 */             return this.a.a(this.a.a(param1Method1), this.a.a(param1Method2));
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   protected j a() {
/* 145 */     return this.a;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */