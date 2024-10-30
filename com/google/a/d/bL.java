/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class bl<K, V>
/*     */   extends bt<Map.Entry<K, V>>
/*     */ {
/*     */   abstract bj<K, V> g();
/*     */   
/*     */   static final class b<K, V>
/*     */     extends bl<K, V>
/*     */   {
/*     */     private final transient bj<K, V> j;
/*     */     private final transient bh<Map.Entry<K, V>> g;
/*     */     
/*     */     b(bj<K, V> param1bj, Map.Entry<K, V>[] param1ArrayOfEntry) {
/*  40 */       this(param1bj, bh.c((Object[])param1ArrayOfEntry));
/*     */     }
/*     */     
/*     */     b(bj<K, V> param1bj, bh<Map.Entry<K, V>> param1bh) {
/*  44 */       this.j = param1bj;
/*  45 */       this.g = param1bh;
/*     */     }
/*     */ 
/*     */     
/*     */     bj<K, V> g() {
/*  50 */       return this.j;
/*     */     }
/*     */ 
/*     */     
/*     */     @c("not used in GWT")
/*     */     int a(Object[] param1ArrayOfObject, int param1Int) {
/*  56 */       return this.g.a(param1ArrayOfObject, param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public dj<Map.Entry<K, V>> b() {
/*  61 */       return this.g.b();
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator<Map.Entry<K, V>> spliterator() {
/*  66 */       return this.g.spliterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public void forEach(Consumer<? super Map.Entry<K, V>> param1Consumer) {
/*  71 */       this.g.forEach(param1Consumer);
/*     */     }
/*     */ 
/*     */     
/*     */     bh<Map.Entry<K, V>> h() {
/*  76 */       return new cs<>(this, this.g);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  86 */     return g().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  91 */     if (paramObject instanceof Map.Entry) {
/*  92 */       Map.Entry entry = (Map.Entry)paramObject;
/*  93 */       V v = g().get(entry.getKey());
/*  94 */       return (v != null && v.equals(entry.getValue()));
/*     */     } 
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 101 */     return g().cO();
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   boolean cR() {
/* 107 */     return g().cR();
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 112 */     return g().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   Object writeReplace() {
/* 118 */     return new a<>(g());
/*     */   }
/*     */   
/*     */   @c
/*     */   private static class a<K, V> implements Serializable {
/*     */     final bj<K, V> j;
/*     */     
/*     */     a(bj<K, V> param1bj) {
/* 126 */       this.j = param1bj;
/*     */     }
/*     */     private static final long serialVersionUID = 0L;
/*     */     Object readResolve() {
/* 130 */       return this.j.h();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */