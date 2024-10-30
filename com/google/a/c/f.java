/*     */ package com.google.a.c;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.M;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.o.a.L;
/*     */ import com.google.a.o.a.U;
/*     */ import com.google.a.o.a.V;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.Executor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ public abstract class f<K, V>
/*     */ {
/*     */   public abstract V j(K paramK) throws Exception;
/*     */   
/*     */   @com.google.a.a.c
/*     */   public U<V> a(K paramK, V paramV) throws Exception {
/*  98 */     D.checkNotNull(paramK);
/*  99 */     D.checkNotNull(paramV);
/* 100 */     return L.b(j(paramK));
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
/*     */   public Map<K, V> a(Iterable<? extends K> paramIterable) throws Exception {
/* 128 */     throw new d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> f<K, V> a(s<K, V> params) {
/* 139 */     return new a<>(params);
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
/*     */   public static <V> f<Object, V> a(M<V> paramM) {
/* 152 */     return new c<>(paramM);
/*     */   }
/*     */   
/*     */   private static final class a<K, V> extends f<K, V> implements Serializable {
/*     */     private final s<K, V> f;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public a(s<K, V> param1s) {
/* 160 */       this.f = (s<K, V>)D.checkNotNull(param1s);
/*     */     }
/*     */ 
/*     */     
/*     */     public V j(K param1K) {
/* 165 */       return (V)this.f.apply(D.checkNotNull(param1K));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   public static <K, V> f<K, V> a(f<K, V> paramf, Executor paramExecutor) {
/* 183 */     D.checkNotNull(paramf);
/* 184 */     D.checkNotNull(paramExecutor);
/* 185 */     return new f<K, V>(paramf, paramExecutor)
/*     */       {
/*     */         public V j(K param1K) throws Exception {
/* 188 */           return this.a.j(param1K);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public U<V> a(K param1K, final V key) throws Exception {
/* 194 */           V v = V.a(new Callable<V>(this, param1K)
/*     */               {
/*     */                 public V call() throws Exception
/*     */                 {
/* 198 */                   return (V)this.a.a.a(key, (V)this.p).get();
/*     */                 }
/*     */               });
/* 201 */           this.a.execute((Runnable)v);
/* 202 */           return (U<V>)v;
/*     */         }
/*     */ 
/*     */         
/*     */         public Map<K, V> a(Iterable<? extends K> param1Iterable) throws Exception {
/* 207 */           return this.a.a(param1Iterable);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static final class c<V> extends f<Object, V> implements Serializable {
/*     */     private final M<V> f;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public c(M<V> param1M) {
/* 217 */       this.f = (M<V>)D.checkNotNull(param1M);
/*     */     }
/*     */ 
/*     */     
/*     */     public V j(Object param1Object) {
/* 222 */       D.checkNotNull(param1Object);
/* 223 */       return (V)this.f.get();
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
/*     */   public static final class d
/*     */     extends UnsupportedOperationException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class b
/*     */     extends RuntimeException
/*     */   {
/*     */     public b(String param1String) {
/* 248 */       super(param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */