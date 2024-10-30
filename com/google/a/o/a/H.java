/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.b.a.g;
/*     */ import java.util.concurrent.CancellationException;
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
/*     */ @b
/*     */ abstract class h<I, O, F, T>
/*     */   extends A.a<O>
/*     */   implements Runnable
/*     */ {
/*     */   U<? extends I> b;
/*     */   F ao;
/*     */   
/*     */   static <I, O> U<O> a(U<I> paramU, l<? super I, ? extends O> paraml, Executor paramExecutor) {
/*  37 */     D.checkNotNull(paramExecutor);
/*  38 */     a<I, O> a1 = new a<>(paramU, paraml);
/*  39 */     paramU.a(a1, ab.a(paramExecutor, a1));
/*  40 */     return a1;
/*     */   }
/*     */ 
/*     */   
/*     */   static <I, O> U<O> a(U<I> paramU, s<? super I, ? extends O> params, Executor paramExecutor) {
/*  45 */     D.checkNotNull(params);
/*  46 */     b<I, O> b = new b<>(paramU, params);
/*  47 */     paramU.a(b, ab.a(paramExecutor, b));
/*  48 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   h(U<? extends I> paramU, F paramF) {
/*  59 */     this.b = (U<? extends I>)D.checkNotNull(paramU);
/*  60 */     this.ao = (F)D.checkNotNull(paramF);
/*     */   }
/*     */   public final void run() {
/*     */     I i;
/*     */     T t;
/*  65 */     U<? extends I> u = this.b;
/*  66 */     F f = this.ao;
/*  67 */     if ((isCancelled() | ((u == null) ? 1 : 0) | ((f == null) ? 1 : 0)) != 0) {
/*     */       return;
/*     */     }
/*  70 */     this.b = null;
/*     */     
/*  72 */     if (u.isCancelled()) {
/*     */ 
/*     */       
/*  75 */       boolean bool = a(u);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  89 */       i = L.b((Future)u);
/*  90 */     } catch (CancellationException cancellationException) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  96 */       cancel(false);
/*     */       return;
/*  98 */     } catch (ExecutionException executionException) {
/*     */       
/* 100 */       a(executionException.getCause());
/*     */       return;
/* 102 */     } catch (RuntimeException runtimeException) {
/*     */       
/* 104 */       a(runtimeException);
/*     */       return;
/* 106 */     } catch (Error error) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 112 */       a(error);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/* 118 */       t = o(f, i);
/* 119 */     } catch (Throwable throwable) {
/*     */       
/* 121 */       a(throwable);
/*     */       return;
/*     */     } finally {
/* 124 */       this.ao = null;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     u(t);
/*     */   }
/*     */ 
/*     */   
/*     */   @g
/*     */   abstract T o(F paramF, I paramI) throws Exception;
/*     */ 
/*     */   
/*     */   @g
/*     */   abstract void u(T paramT);
/*     */ 
/*     */   
/*     */   protected final void fx() {
/* 176 */     h(this.b);
/* 177 */     this.b = null;
/* 178 */     this.ao = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String ds() {
/* 183 */     U<? extends I> u = this.b;
/* 184 */     F f = this.ao;
/* 185 */     String str1 = super.ds();
/* 186 */     String str2 = "";
/* 187 */     if (u != null) {
/* 188 */       String str = String.valueOf(u); str2 = (new StringBuilder(16 + String.valueOf(str).length())).append("inputFuture=[").append(str).append("], ").toString();
/*     */     } 
/* 190 */     if (f != null) {
/* 191 */       String str3 = str2, str4 = String.valueOf(f); return (new StringBuilder(11 + String.valueOf(str3).length() + String.valueOf(str4).length())).append(str3).append("function=[").append(str4).append("]").toString();
/* 192 */     }  if (str1 != null) {
/* 193 */       String.valueOf(str1); return (String.valueOf(str1).length() != 0) ? String.valueOf(str2).concat(String.valueOf(str1)) : new String(String.valueOf(str2));
/*     */     } 
/* 195 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class a<I, O>
/*     */     extends h<I, O, l<? super I, ? extends O>, U<? extends O>>
/*     */   {
/*     */     a(U<? extends I> param1U, l<? super I, ? extends O> param1l) {
/* 207 */       super(param1U, param1l);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     U<? extends O> a(l<? super I, ? extends O> param1l, I param1I) throws Exception {
/* 213 */       U<? extends O> u = param1l.a(param1I);
/* 214 */       D.a(u, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", param1l);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 219 */       return u;
/*     */     }
/*     */ 
/*     */     
/*     */     void a(U<? extends O> param1U) {
/* 224 */       a(param1U);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class b<I, O>
/*     */     extends h<I, O, s<? super I, ? extends O>, O>
/*     */   {
/*     */     b(U<? extends I> param1U, s<? super I, ? extends O> param1s) {
/* 236 */       super(param1U, param1s);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     O a(s<? super I, ? extends O> param1s, I param1I) {
/* 242 */       return (O)param1s.apply(param1I);
/*     */     }
/*     */ 
/*     */     
/*     */     void u(O param1O) {
/* 247 */       c(param1O);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */