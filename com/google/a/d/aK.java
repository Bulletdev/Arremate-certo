/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.E;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ class ak<K, V>
/*     */   extends h<K, V>
/*     */   implements am<K, V>
/*     */ {
/*     */   final bZ<K, V> a;
/*     */   final E<? super K> d;
/*     */   
/*     */   ak(bZ<K, V> parambZ, E<? super K> paramE) {
/*  44 */     this.a = (bZ<K, V>)D.checkNotNull(parambZ);
/*  45 */     this.d = (E<? super K>)D.checkNotNull(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public bZ<K, V> b() {
/*  50 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public E<? super Map.Entry<K, V>> f() {
/*  55 */     return (E)bW.b(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  60 */     int i = 0;
/*  61 */     for (Collection<V> collection : asMap().values()) {
/*  62 */       i += collection.size();
/*     */     }
/*  64 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  69 */     if (this.a.containsKey(paramObject)) {
/*     */       
/*  71 */       Object object = paramObject;
/*  72 */       return this.d.b(object);
/*     */     } 
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> a(Object paramObject) {
/*  79 */     return containsKey(paramObject) ? this.a.a(paramObject) : f();
/*     */   }
/*     */   
/*     */   Collection<V> f() {
/*  83 */     if (this.a instanceof cF) {
/*  84 */       return bt.n();
/*     */     }
/*  86 */     return bh.e();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  92 */     keySet().clear();
/*     */   }
/*     */ 
/*     */   
/*     */   Set<K> b() {
/*  97 */     return cG.a(this.a.keySet(), this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> get(K paramK) {
/* 102 */     if (this.d.b(paramK))
/* 103 */       return this.a.get(paramK); 
/* 104 */     if (this.a instanceof cF) {
/* 105 */       return new b<>(paramK);
/*     */     }
/* 107 */     return new a<>(paramK);
/*     */   }
/*     */   
/*     */   static class b<K, V>
/*     */     extends aK<V> {
/*     */     final K key;
/*     */     
/*     */     b(K param1K) {
/* 115 */       this.key = param1K;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean add(V param1V) {
/* 120 */       String str = String.valueOf(this.key); throw new IllegalArgumentException((new StringBuilder(32 + String.valueOf(str).length())).append("Key does not satisfy predicate: ").append(str).toString());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean addAll(Collection<? extends V> param1Collection) {
/* 125 */       D.checkNotNull(param1Collection);
/* 126 */       String str = String.valueOf(this.key); throw new IllegalArgumentException((new StringBuilder(32 + String.valueOf(str).length())).append("Key does not satisfy predicate: ").append(str).toString());
/*     */     }
/*     */ 
/*     */     
/*     */     protected Set<V> a() {
/* 131 */       return Collections.emptySet();
/*     */     }
/*     */   }
/*     */   
/*     */   static class a<K, V> extends az<V> {
/*     */     final K key;
/*     */     
/*     */     a(K param1K) {
/* 139 */       this.key = param1K;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean add(V param1V) {
/* 144 */       add(0, param1V);
/* 145 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(int param1Int, V param1V) {
/* 150 */       D.c(param1Int, 0);
/* 151 */       String str = String.valueOf(this.key); throw new IllegalArgumentException((new StringBuilder(32 + String.valueOf(str).length())).append("Key does not satisfy predicate: ").append(str).toString());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean addAll(Collection<? extends V> param1Collection) {
/* 156 */       addAll(0, param1Collection);
/* 157 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public boolean addAll(int param1Int, Collection<? extends V> param1Collection) {
/* 163 */       D.checkNotNull(param1Collection);
/* 164 */       D.c(param1Int, 0);
/* 165 */       String str = String.valueOf(this.key); throw new IllegalArgumentException((new StringBuilder(32 + String.valueOf(str).length())).append("Key does not satisfy predicate: ").append(str).toString());
/*     */     }
/*     */ 
/*     */     
/*     */     protected List<V> S() {
/* 170 */       return Collections.emptyList();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   Iterator<Map.Entry<K, V>> c() {
/* 176 */     throw new AssertionError("should never be called");
/*     */   }
/*     */ 
/*     */   
/*     */   Collection<Map.Entry<K, V>> d() {
/* 181 */     return new c(this);
/*     */   }
/*     */   
/*     */   class c extends ar<Map.Entry<K, V>> {
/*     */     c(ak this$0) {}
/*     */     
/*     */     protected Collection<Map.Entry<K, V>> a() {
/* 188 */       return E.a(this.a.a.entries(), this.a.f());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 194 */       if (param1Object instanceof Map.Entry) {
/* 195 */         Map.Entry entry = (Map.Entry)param1Object;
/* 196 */         if (this.a.a.containsKey(entry.getKey()) && this.a.d
/*     */           
/* 198 */           .b(entry.getKey())) {
/* 199 */           return this.a.a.remove(entry.getKey(), entry.getValue());
/*     */         }
/*     */       } 
/* 202 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   Collection<V> c() {
/* 208 */     return new an<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   Map<K, Collection<V>> u() {
/* 213 */     return bW.a(this.a.asMap(), this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   cc<K> a() {
/* 218 */     return cd.a(this.a.b(), this.d);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */