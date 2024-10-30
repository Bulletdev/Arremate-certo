/*     */ package org.junit.g;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.junit.f.a.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   implements e
/*     */ {
/*  22 */   private static final List<a<?>> aQ = Arrays.asList((a<?>[])new a[] { new b(), new d(), new c() });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Exception> b(m paramm) {
/*  34 */     ArrayList<Exception> arrayList = new ArrayList();
/*  35 */     for (a<?> a : aQ) {
/*  36 */       List<Exception> list = a.b(paramm);
/*     */       
/*  38 */       arrayList.addAll(list);
/*     */     } 
/*  40 */     return arrayList;
/*     */   }
/*     */   private static abstract class a<T extends org.junit.f.a.a> { private a() {}
/*     */     
/*  44 */     private static final b a = new b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List<Exception> b(m param1m) {
/*  52 */       ArrayList<Exception> arrayList = new ArrayList();
/*  53 */       for (org.junit.f.a.a a1 : a(param1m)) {
/*  54 */         List<Exception> list = a((T)a1);
/*  55 */         arrayList.addAll(list);
/*     */       } 
/*  57 */       return arrayList;
/*     */     }
/*     */     abstract Iterable<T> a(m param1m);
/*     */     private List<Exception> a(T param1T) {
/*  61 */       ArrayList<Exception> arrayList = new ArrayList();
/*  62 */       for (Annotation annotation : param1T.getAnnotations()) {
/*  63 */         Class<? extends Annotation> clazz = annotation.annotationType();
/*     */         
/*  65 */         f f = clazz.<f>getAnnotation(f.class);
/*     */         
/*  67 */         if (f != null) {
/*  68 */           a a1 = a.a(f);
/*     */           
/*  70 */           List<Exception> list = a(a1, param1T);
/*     */           
/*  72 */           arrayList.addAll(list);
/*     */         } 
/*     */       } 
/*  75 */       return arrayList;
/*     */     }
/*     */     
/*     */     abstract List<Exception> a(a param1a, T param1T); }
/*     */   
/*     */   private static class b extends a<m> {
/*     */     Iterable<m> a(m param1m) {
/*  82 */       return Collections.singletonList(param1m);
/*     */     }
/*     */     
/*     */     private b() {}
/*     */     
/*     */     List<Exception> a(a param1a, m param1m) {
/*  88 */       return param1a.a(param1m);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class d
/*     */     extends a<org.junit.f.a.d> {
/*     */     private d() {}
/*     */     
/*     */     Iterable<org.junit.f.a.d> a(m param1m) {
/*  97 */       return param1m.bx();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     List<Exception> a(a param1a, org.junit.f.a.d param1d) {
/* 103 */       return param1a.a(param1d);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class c extends a<org.junit.f.a.b> {
/*     */     private c() {}
/*     */     
/*     */     Iterable<org.junit.f.a.b> a(m param1m) {
/* 111 */       return param1m.by();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     List<Exception> a(a param1a, org.junit.f.a.b param1b) {
/* 117 */       return param1a.a(param1b);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\g\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */