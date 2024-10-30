/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.io.Serializable;
/*     */ import java.util.EnumMap;
/*     */ import java.util.Map;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.BiConsumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ final class bf<K extends Enum<K>, V>
/*     */   extends bj.b<K, V>
/*     */ {
/*     */   private final transient EnumMap<K, V> a;
/*     */   
/*     */   static <K extends Enum<K>, V> bj<K, V> a(EnumMap<K, V> paramEnumMap) {
/*     */     Map.Entry entry;
/*  38 */     switch (paramEnumMap.size()) {
/*     */       case 0:
/*  40 */         return bj.f();
/*     */       case 1:
/*  42 */         entry = bG.<Map.Entry>a((Iterable)paramEnumMap.entrySet());
/*  43 */         return bj.a((K)entry.getKey(), (V)entry.getValue());
/*     */     } 
/*  45 */     return new bf<>(paramEnumMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private bf(EnumMap<K, V> paramEnumMap) {
/*  52 */     this.a = paramEnumMap;
/*  53 */     D.checkArgument(!paramEnumMap.isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   dj<K> d() {
/*  58 */     return bH.a(this.a.keySet().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   Spliterator<K> e() {
/*  63 */     return this.a.keySet().spliterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  68 */     return this.a.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  73 */     return this.a.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/*  78 */     return this.a.get(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object<K, V> paramObject) {
/*  83 */     if (paramObject == this) {
/*  84 */       return true;
/*     */     }
/*  86 */     if (paramObject instanceof bf) {
/*  87 */       paramObject = (Object<K, V>)((bf)paramObject).a;
/*     */     }
/*  89 */     return this.a.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   dj<Map.Entry<K, V>> a() {
/*  94 */     return bW.b(this.a.entrySet().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   Spliterator<Map.Entry<K, V>> b() {
/*  99 */     return D.a(this.a.entrySet().spliterator(), bW::b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(BiConsumer<? super K, ? super V> paramBiConsumer) {
/* 104 */     this.a.forEach(paramBiConsumer);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 115 */     return new a<>(this.a);
/*     */   }
/*     */   
/*     */   private static class a<K extends Enum<K>, V>
/*     */     implements Serializable
/*     */   {
/*     */     final EnumMap<K, V> a;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(EnumMap<K, V> param1EnumMap) {
/* 125 */       this.a = param1EnumMap;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 129 */       return new bf<>(this.a);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */