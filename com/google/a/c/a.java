/*     */ package com.google.a.c;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.bj;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class a<K, V>
/*     */   implements c<K, V>
/*     */ {
/*     */   public V a(K paramK, Callable<? extends V> paramCallable) throws ExecutionException {
/*  49 */     throw new UnsupportedOperationException();
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
/*     */   public bj<K, V> a(Iterable<?> paramIterable) {
/*  63 */     LinkedHashMap<Object, V> linkedHashMap = bW.a();
/*  64 */     for (Object object : paramIterable) {
/*  65 */       if (!linkedHashMap.containsKey(object)) {
/*     */         
/*  67 */         Object object1 = object;
/*  68 */         V v = i(object);
/*  69 */         if (v != null) {
/*  70 */           linkedHashMap.put(object1, v);
/*     */         }
/*     */       } 
/*     */     } 
/*  74 */     return bj.a(linkedHashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(K paramK, V paramV) {
/*  80 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*  86 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/*  87 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void ey() {}
/*     */ 
/*     */   
/*     */   public long size() {
/*  96 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void d(Object paramObject) {
/* 101 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(Iterable<?> paramIterable) {
/* 107 */     for (Object object : paramIterable) {
/* 108 */       d(object);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void eA() {
/* 114 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public g a() {
/* 119 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public ConcurrentMap<K, V> a() {
/* 124 */     throw new UnsupportedOperationException();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a
/*     */     implements b
/*     */   {
/* 197 */     private final l a = m.a();
/* 198 */     private final l b = m.a();
/* 199 */     private final l c = m.a();
/* 200 */     private final l d = m.a();
/* 201 */     private final l e = m.a();
/* 202 */     private final l f = m.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void au(int param1Int) {
/* 210 */       this.a.add(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void av(int param1Int) {
/* 216 */       this.b.add(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void E(long param1Long) {
/* 222 */       this.c.increment();
/* 223 */       this.e.add(param1Long);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void F(long param1Long) {
/* 229 */       this.d.increment();
/* 230 */       this.e.add(param1Long);
/*     */     }
/*     */ 
/*     */     
/*     */     public void eB() {
/* 235 */       this.f.increment();
/*     */     }
/*     */ 
/*     */     
/*     */     public g b() {
/* 240 */       return new g(
/* 241 */           a(this.a.X()), 
/* 242 */           a(this.b.X()), 
/* 243 */           a(this.c.X()), 
/* 244 */           a(this.d.X()), 
/* 245 */           a(this.e.X()), 
/* 246 */           a(this.f.X()));
/*     */     }
/*     */ 
/*     */     
/*     */     private static long a(long param1Long) {
/* 251 */       return (param1Long >= 0L) ? param1Long : Long.MAX_VALUE;
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(a.b param1b) {
/* 256 */       g g = param1b.b();
/* 257 */       this.a.add(g.N());
/* 258 */       this.b.add(g.O());
/* 259 */       this.c.add(g.Q());
/* 260 */       this.d.add(g.R());
/* 261 */       this.e.add(g.S());
/* 262 */       this.f.add(g.T());
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface b {
/*     */     void au(int param1Int);
/*     */     
/*     */     void av(int param1Int);
/*     */     
/*     */     void E(long param1Long);
/*     */     
/*     */     void F(long param1Long);
/*     */     
/*     */     void eB();
/*     */     
/*     */     g b();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */