/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.o.a.a.a;
/*     */ import com.google.a.o.a.a.b;
/*     */ import com.google.b.a.g;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.Future;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ abstract class a<V, X extends Throwable, F, T>
/*     */   extends A.a<V>
/*     */   implements Runnable
/*     */ {
/*     */   U<? extends V> b;
/*     */   Class<X> f;
/*     */   F an;
/*     */   
/*     */   static <V, X extends Throwable> U<V> a(U<? extends V> paramU, Class<X> paramClass, s<? super X, ? extends V> params, Executor paramExecutor) {
/*  40 */     b<V, X> b = new b<>(paramU, paramClass, params);
/*  41 */     paramU.a(b, ab.a(paramExecutor, b));
/*  42 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <X extends Throwable, V> U<V> a(U<? extends V> paramU, Class<X> paramClass, l<? super X, ? extends V> paraml, Executor paramExecutor) {
/*  50 */     a<V, X> a1 = new a<>(paramU, paramClass, paraml);
/*  51 */     paramU.a(a1, ab.a(paramExecutor, a1));
/*  52 */     return a1;
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
/*     */   a(U<? extends V> paramU, Class<X> paramClass, F paramF) {
/*  65 */     this.b = (U<? extends V>)D.checkNotNull(paramU);
/*  66 */     this.f = (Class<X>)D.checkNotNull(paramClass);
/*  67 */     this.an = (F)D.checkNotNull(paramF);
/*     */   }
/*     */   
/*     */   public final void run() {
/*     */     T t;
/*  72 */     U<? extends V> u = this.b;
/*  73 */     Class<X> clazz = this.f;
/*  74 */     F f = this.an;
/*  75 */     if ((((u == null) ? 1 : 0) | ((clazz == null) ? 1 : 0) | ((f == null) ? 1 : 0)) != 0 || 
/*     */       
/*  77 */       isCancelled()) {
/*     */       return;
/*     */     }
/*  80 */     this.b = null;
/*     */ 
/*     */     
/*  83 */     V v = null;
/*  84 */     Throwable throwable1 = null;
/*     */     try {
/*  86 */       if (u instanceof a)
/*     */       {
/*  88 */         throwable1 = b.a((a)u);
/*     */       }
/*     */       
/*  91 */       if (throwable1 == null) {
/*  92 */         v = L.b((Future)u);
/*     */       }
/*  94 */     } catch (ExecutionException executionException) {
/*  95 */       throwable1 = executionException.getCause();
/*  96 */       if (throwable1 == null)
/*     */       {
/*     */ 
/*     */         
/* 100 */         String str1 = String.valueOf(u.getClass());
/*     */         
/* 102 */         String str2 = String.valueOf(executionException.getClass()); throwable1 = new NullPointerException((new StringBuilder(35 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Future type ").append(str1).append(" threw ").append(str2).append(" without a cause").toString());
/*     */       }
/*     */     
/* 105 */     } catch (Throwable throwable) {
/* 106 */       throwable1 = throwable;
/*     */     } 
/*     */     
/* 109 */     if (throwable1 == null) {
/* 110 */       c(v);
/*     */       
/*     */       return;
/*     */     } 
/* 114 */     if (!ae.a(throwable1, clazz)) {
/* 115 */       a(u);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 121 */     Throwable throwable2 = throwable1;
/*     */     
/*     */     try {
/* 124 */       t = a(f, (X)throwable2);
/* 125 */     } catch (Throwable throwable) {
/* 126 */       a(throwable);
/*     */       return;
/*     */     } finally {
/* 129 */       this.f = null;
/* 130 */       this.an = null;
/*     */     } 
/*     */     
/* 133 */     u(t);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String ds() {
/* 138 */     U<? extends V> u = this.b;
/* 139 */     Class<X> clazz = this.f;
/* 140 */     F f = this.an;
/* 141 */     String str1 = super.ds();
/* 142 */     String str2 = "";
/* 143 */     if (u != null) {
/* 144 */       String str = String.valueOf(u); str2 = (new StringBuilder(16 + String.valueOf(str).length())).append("inputFuture=[").append(str).append("], ").toString();
/*     */     } 
/* 146 */     if (clazz != null && f != null) {
/* 147 */       String str3 = str2, str4 = String.valueOf(clazz), str5 = String.valueOf(f); return (new StringBuilder(29 + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length())).append(str3).append("exceptionType=[").append(str4).append("], fallback=[").append(str5).append("]").toString();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     if (str1 != null) {
/* 154 */       String.valueOf(str1); return (String.valueOf(str1).length() != 0) ? String.valueOf(str2).concat(String.valueOf(str1)) : new String(String.valueOf(str2));
/*     */     } 
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   @g
/*     */   abstract T a(F paramF, X paramX) throws Exception;
/*     */ 
/*     */   
/*     */   @g
/*     */   abstract void u(T paramT);
/*     */ 
/*     */   
/*     */   protected final void fx() {
/* 169 */     h(this.b);
/* 170 */     this.b = null;
/* 171 */     this.f = null;
/* 172 */     this.an = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class a<V, X extends Throwable>
/*     */     extends a<V, X, l<? super X, ? extends V>, U<? extends V>>
/*     */   {
/*     */     a(U<? extends V> param1U, Class<X> param1Class, l<? super X, ? extends V> param1l) {
/* 186 */       super(param1U, param1Class, param1l);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     U<? extends V> a(l<? super X, ? extends V> param1l, X param1X) throws Exception {
/* 192 */       U<? extends V> u = param1l.a(param1X);
/* 193 */       D.a(u, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", param1l);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 198 */       return u;
/*     */     }
/*     */ 
/*     */     
/*     */     void a(U<? extends V> param1U) {
/* 203 */       a(param1U);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class b<V, X extends Throwable>
/*     */     extends a<V, X, s<? super X, ? extends V>, V>
/*     */   {
/*     */     b(U<? extends V> param1U, Class<X> param1Class, s<? super X, ? extends V> param1s) {
/* 217 */       super(param1U, param1Class, param1s);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     V a(s<? super X, ? extends V> param1s, X param1X) throws Exception {
/* 223 */       return (V)param1s.apply(param1X);
/*     */     }
/*     */ 
/*     */     
/*     */     void u(V param1V) {
/* 228 */       c(param1V);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */