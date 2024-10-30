/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Spliterator;
/*     */ import java.util.Spliterators;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class h<K, V>
/*     */   implements bZ<K, V>
/*     */ {
/*     */   private transient Collection<Map.Entry<K, V>> e;
/*     */   private transient Set<K> keySet;
/*     */   private transient cc<K> a;
/*     */   private transient Collection<V> values;
/*     */   private transient Map<K, Collection<V>> I;
/*     */   
/*     */   public boolean isEmpty() {
/*  43 */     return (size() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/*  48 */     for (Collection<V> collection : asMap().values()) {
/*  49 */       if (collection.contains(paramObject)) {
/*  50 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  54 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c(Object paramObject1, Object paramObject2) {
/*  59 */     Collection collection = asMap().get(paramObject1);
/*  60 */     return (collection != null && collection.contains(paramObject2));
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public boolean remove(Object paramObject1, Object paramObject2) {
/*  66 */     Collection collection = asMap().get(paramObject1);
/*  67 */     return (collection != null && collection.remove(paramObject2));
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public boolean put(K paramK, V paramV) {
/*  73 */     return get(paramK).add(paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public boolean putAll(K paramK, Iterable<? extends V> paramIterable) {
/*  79 */     D.checkNotNull(paramIterable);
/*     */ 
/*     */     
/*  82 */     if (paramIterable instanceof Collection) {
/*  83 */       Collection<? extends V> collection = (Collection)paramIterable;
/*  84 */       return (!collection.isEmpty() && get(paramK).addAll(collection));
/*     */     } 
/*  86 */     Iterator<? extends V> iterator = paramIterable.iterator();
/*  87 */     return (iterator.hasNext() && bH.addAll(get(paramK), iterator));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public boolean a(bZ<? extends K, ? extends V> parambZ) {
/*  94 */     boolean bool = false;
/*  95 */     for (Map.Entry<? extends K, ? extends V> entry : parambZ.entries()) {
/*  96 */       bool |= put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*  98 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public Collection<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 104 */     D.checkNotNull(paramIterable);
/* 105 */     Collection<V> collection = a(paramK);
/* 106 */     putAll(paramK, paramIterable);
/* 107 */     return collection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<Map.Entry<K, V>> entries() {
/* 114 */     Collection<Map.Entry<K, V>> collection = this.e;
/* 115 */     return (collection == null) ? (this.e = d()) : collection;
/*     */   }
/*     */   
/*     */   abstract Collection<Map.Entry<K, V>> d();
/*     */   
/*     */   abstract Iterator<Map.Entry<K, V>> c();
/*     */   
/*     */   class a extends cb.f<K, V> {
/*     */     bZ<K, V> a() {
/* 124 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 129 */       return this.a.c();
/*     */     }
/*     */     a(h this$0) {}
/*     */     
/*     */     public Spliterator<Map.Entry<K, V>> spliterator() {
/* 134 */       return this.a.b();
/*     */     } }
/*     */   
/*     */   class b extends a implements Set<Map.Entry<K, V>> {
/*     */     b(h this$0) {
/* 139 */       super(this$0);
/*     */     }
/*     */     public int hashCode() {
/* 142 */       return cG.a(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 147 */       return cG.a(this, param1Object);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Spliterator<Map.Entry<K, V>> b() {
/* 154 */     return Spliterators.spliterator(
/* 155 */         c(), size(), (this instanceof cF) ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 162 */     Set<K> set = this.keySet;
/* 163 */     return (set == null) ? (this.keySet = b()) : set;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   abstract Set<K> b();
/*     */ 
/*     */   
/*     */   public cc<K> b() {
/* 172 */     cc<K> cc1 = this.a;
/* 173 */     return (cc1 == null) ? (this.a = a()) : cc1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   abstract cc<K> a();
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 182 */     Collection<V> collection = this.values;
/* 183 */     return (collection == null) ? (this.values = c()) : collection;
/*     */   }
/*     */   
/*     */   abstract Collection<V> c();
/*     */   
/*     */   class c extends AbstractCollection<V> {
/*     */     c(h this$0) {}
/*     */     
/*     */     public Iterator<V> iterator() {
/* 192 */       return this.a.b();
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator<V> spliterator() {
/* 197 */       return this.a.a();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 202 */       return this.a.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 207 */       return this.a.containsValue(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 212 */       this.a.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   Iterator<V> b() {
/* 217 */     return bW.d(entries().iterator());
/*     */   }
/*     */   
/*     */   Spliterator<V> a() {
/* 221 */     return Spliterators.spliterator(b(), size(), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<K, Collection<V>> asMap() {
/* 228 */     Map<K, Collection<V>> map = this.I;
/* 229 */     return (map == null) ? (this.I = u()) : map;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   abstract Map<K, Collection<V>> u();
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 238 */     return cb.a(this, paramObject);
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
/*     */   public int hashCode() {
/* 251 */     return asMap().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 262 */     return asMap().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */