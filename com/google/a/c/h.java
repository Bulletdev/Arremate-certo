/*     */ package com.google.a.c;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.aI;
/*     */ import com.google.a.d.bj;
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
/*     */ @c
/*     */ public abstract class h<K, V>
/*     */   extends aI
/*     */   implements c<K, V>
/*     */ {
/*     */   public V i(Object paramObject) {
/*  47 */     return b().i(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V a(K paramK, Callable<? extends V> paramCallable) throws ExecutionException {
/*  53 */     return b().a(paramK, paramCallable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public bj<K, V> a(Iterable<?> paramIterable) {
/*  59 */     return b().a(paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void put(K paramK, V paramV) {
/*  65 */     b().put(paramK, paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*  71 */     b().putAll(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public void d(Object paramObject) {
/*  76 */     b().d(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(Iterable<?> paramIterable) {
/*  82 */     b().a(paramIterable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void eA() {
/*  87 */     b().eA();
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/*  92 */     return b().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public g a() {
/*  97 */     return b().a();
/*     */   }
/*     */ 
/*     */   
/*     */   public ConcurrentMap<K, V> a() {
/* 102 */     return b().a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void ey() {
/* 107 */     b().ey();
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract c<K, V> b();
/*     */ 
/*     */   
/*     */   public static abstract class a<K, V>
/*     */     extends h<K, V>
/*     */   {
/*     */     private final c<K, V> a;
/*     */     
/*     */     protected a(c<K, V> param1c) {
/* 120 */       this.a = (c<K, V>)D.checkNotNull(param1c);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final c<K, V> b() {
/* 125 */       return this.a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */