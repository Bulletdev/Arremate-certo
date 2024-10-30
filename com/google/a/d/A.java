/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.y;
/*     */ import com.google.c.a.h;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiFunction;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class a<K, V>
/*     */   extends aC<K, V>
/*     */   implements w<K, V>, Serializable
/*     */ {
/*     */   private transient Map<K, V> F;
/*     */   @h
/*     */   transient a<V, K> a;
/*     */   private transient Set<K> keySet;
/*     */   private transient Set<V> f;
/*     */   private transient Set<Map.Entry<K, V>> entrySet;
/*     */   @com.google.a.a.c
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   a(Map<K, V> paramMap, Map<V, K> paramMap1) {
/*  58 */     a(paramMap, paramMap1);
/*     */   }
/*     */ 
/*     */   
/*     */   private a(Map<K, V> paramMap, a<V, K> parama) {
/*  63 */     this.F = paramMap;
/*  64 */     this.a = parama;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Map<K, V> s() {
/*  69 */     return this.F;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   K m(K paramK) {
/*  75 */     return paramK;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   V n(V paramV) {
/*  81 */     return paramV;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void a(Map<K, V> paramMap, Map<V, K> paramMap1) {
/*  89 */     D.ab((this.F == null));
/*  90 */     D.ab((this.a == null));
/*  91 */     D.checkArgument(paramMap.isEmpty());
/*  92 */     D.checkArgument(paramMap1.isEmpty());
/*  93 */     D.checkArgument((paramMap != paramMap1));
/*  94 */     this.F = paramMap;
/*  95 */     this.a = a(paramMap1);
/*     */   }
/*     */   
/*     */   a<V, K> a(Map<V, K> paramMap) {
/*  99 */     return new c<>(paramMap, this);
/*     */   }
/*     */   
/*     */   void a(a<V, K> parama) {
/* 103 */     this.a = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 110 */     return this.a.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public V put(K paramK, V paramV) {
/* 118 */     return a(paramK, paramV, false);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public V c(K paramK, V paramV) {
/* 124 */     return a(paramK, paramV, true);
/*     */   }
/*     */   
/*     */   private V a(K paramK, V paramV, boolean paramBoolean) {
/* 128 */     m(paramK);
/* 129 */     n(paramV);
/* 130 */     boolean bool = containsKey(paramK);
/* 131 */     if (bool && y.equal(paramV, get(paramK))) {
/* 132 */       return paramV;
/*     */     }
/* 134 */     if (paramBoolean) {
/* 135 */       a().remove(paramV);
/*     */     } else {
/* 137 */       D.a(!containsValue(paramV), "value already present: %s", paramV);
/*     */     } 
/* 139 */     V v = this.F.put(paramK, paramV);
/* 140 */     a(paramK, bool, v, paramV);
/* 141 */     return v;
/*     */   }
/*     */   
/*     */   private void a(K paramK, boolean paramBoolean, V paramV1, V paramV2) {
/* 145 */     if (paramBoolean) {
/* 146 */       g(paramV1);
/*     */     }
/* 148 */     this.a.F.put((K)paramV2, (V)paramK);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public V remove(Object paramObject) {
/* 154 */     return containsKey(paramObject) ? o(paramObject) : null;
/*     */   }
/*     */   
/*     */   @com.google.b.a.a
/*     */   private V o(Object paramObject) {
/* 159 */     V v = this.F.remove(paramObject);
/* 160 */     g(v);
/* 161 */     return v;
/*     */   }
/*     */   
/*     */   private void g(V paramV) {
/* 165 */     this.a.F.remove(paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 172 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 173 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void replaceAll(BiFunction<? super K, ? super V, ? extends V> paramBiFunction) {
/* 179 */     this.F.replaceAll(paramBiFunction);
/* 180 */     this.a.F.clear();
/* 181 */     Map.Entry entry = null;
/* 182 */     Iterator<Map.Entry> iterator = this.F.entrySet().iterator();
/* 183 */     while (iterator.hasNext()) {
/* 184 */       Map.Entry entry1 = iterator.next();
/* 185 */       Object object1 = entry1.getKey();
/* 186 */       Object object2 = entry1.getValue();
/* 187 */       V v = this.a.F.putIfAbsent((K)object2, (V)object1);
/* 188 */       if (v != null) {
/* 189 */         entry = entry1;
/*     */ 
/*     */         
/* 192 */         iterator.remove();
/*     */       } 
/*     */     } 
/* 195 */     if (entry != null) {
/* 196 */       String str = String.valueOf(entry.getValue()); throw new IllegalArgumentException((new StringBuilder(23 + String.valueOf(str).length())).append("value already present: ").append(str).toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 202 */     this.F.clear();
/* 203 */     this.a.F.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public w<V, K> a() {
/* 210 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 217 */     Set<K> set = this.keySet;
/* 218 */     return (set == null) ? (this.keySet = new d()) : set;
/*     */   }
/*     */   
/*     */   private class d extends aK<K> {
/*     */     private d(a this$0) {}
/*     */     
/*     */     protected Set<K> a() {
/* 225 */       return a.a(this.b).keySet();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 230 */       this.b.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 235 */       if (!contains(param1Object)) {
/* 236 */         return false;
/*     */       }
/* 238 */       a.a(this.b, param1Object);
/* 239 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean removeAll(Collection<?> param1Collection) {
/* 244 */       return c(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean retainAll(Collection<?> param1Collection) {
/* 249 */       return d(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<K> iterator() {
/* 254 */       return bW.c(this.b.entrySet().iterator());
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
/*     */   public Set<V> values() {
/* 266 */     Set<V> set = this.f;
/* 267 */     return (set == null) ? (this.f = new e()) : set;
/*     */   }
/*     */   
/*     */   private class e
/*     */     extends aK<V> {
/* 272 */     final Set<V> h = this.b.a.keySet();
/*     */ 
/*     */     
/*     */     protected Set<V> a() {
/* 276 */       return this.h;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<V> iterator() {
/* 281 */       return bW.d(this.b.entrySet().iterator());
/*     */     }
/*     */ 
/*     */     
/*     */     public Object[] toArray() {
/* 286 */       return c();
/*     */     }
/*     */ 
/*     */     
/*     */     public <T> T[] toArray(T[] param1ArrayOfT) {
/* 291 */       return (T[])a((Object[])param1ArrayOfT);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 296 */       return dk();
/*     */     }
/*     */ 
/*     */     
/*     */     private e(a this$0) {}
/*     */   }
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 304 */     Set<Map.Entry<K, V>> set = this.entrySet;
/* 305 */     return (set == null) ? (this.entrySet = new b()) : set;
/*     */   }
/*     */   
/*     */   class a extends aD<K, V> {
/*     */     private final Map.Entry<K, V> a;
/*     */     
/*     */     a(a this$0, Map.Entry<K, V> param1Entry) {
/* 312 */       this.a = param1Entry;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Map.Entry<K, V> a() {
/* 317 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 322 */       this.b.n(param1V);
/*     */       
/* 324 */       D.b(this.b.entrySet().contains(this), "entry no longer in map");
/*     */       
/* 326 */       if (y.equal(param1V, getValue())) {
/* 327 */         return param1V;
/*     */       }
/* 329 */       D.a(!this.b.containsValue(param1V), "value already present: %s", param1V);
/* 330 */       V v = this.a.setValue(param1V);
/* 331 */       D.b(y.equal(param1V, this.b.get(getKey())), "entry no longer in map");
/* 332 */       a.a(this.b, getKey(), true, v, param1V);
/* 333 */       return v;
/*     */     }
/*     */   }
/*     */   
/*     */   Iterator<Map.Entry<K, V>> a() {
/* 338 */     final Iterator iterator = this.F.entrySet().iterator();
/* 339 */     return new Iterator<Map.Entry<K, V>>(this)
/*     */       {
/*     */         Map.Entry<K, V> entry;
/*     */         
/*     */         public boolean hasNext() {
/* 344 */           return iterator.hasNext();
/*     */         }
/*     */ 
/*     */         
/*     */         public Map.Entry<K, V> next() {
/* 349 */           this.entry = iterator.next();
/* 350 */           return new a.a(this.b, this.entry);
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 355 */           C.ad((this.entry != null));
/* 356 */           V v = this.entry.getValue();
/* 357 */           iterator.remove();
/* 358 */           a.a(this.b, v);
/* 359 */           this.entry = null;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private class b
/*     */     extends aK<Map.Entry<K, V>> {
/* 366 */     final Set<Map.Entry<K, V>> g = a.a(this.b).entrySet();
/*     */ 
/*     */     
/*     */     protected Set<Map.Entry<K, V>> a() {
/* 370 */       return this.g;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 375 */       this.b.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 380 */       if (!this.g.contains(param1Object)) {
/* 381 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 385 */       Map.Entry entry = (Map.Entry)param1Object;
/* 386 */       a.a(this.b.a).remove(entry.getValue());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 392 */       this.g.remove(entry);
/* 393 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 398 */       return this.b.a();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object[] toArray() {
/* 405 */       return c();
/*     */     }
/*     */ 
/*     */     
/*     */     public <T> T[] toArray(T[] param1ArrayOfT) {
/* 410 */       return (T[])a((Object[])param1ArrayOfT);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 415 */       return bW.d(a(), param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsAll(Collection<?> param1Collection) {
/* 420 */       return a(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean removeAll(Collection<?> param1Collection) {
/* 425 */       return c(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean retainAll(Collection<?> param1Collection) {
/* 430 */       return d(param1Collection);
/*     */     }
/*     */     
/*     */     private b(a this$0) {} }
/*     */   
/*     */   static class c<K, V> extends a<K, V> {
/*     */     c(Map<K, V> param1Map, a<V, K> param1a) {
/* 437 */       super(param1Map, param1a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.c
/*     */     private static final long serialVersionUID = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     K m(K param1K) {
/* 451 */       return this.a.n(param1K);
/*     */     }
/*     */ 
/*     */     
/*     */     V n(V param1V) {
/* 456 */       return this.a.m(param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.a.a.c
/*     */     private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
/* 462 */       param1ObjectOutputStream.defaultWriteObject();
/* 463 */       param1ObjectOutputStream.writeObject(a());
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.a.a.c
/*     */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/* 469 */       param1ObjectInputStream.defaultReadObject();
/* 470 */       a((a<V, K>)param1ObjectInputStream.readObject());
/*     */     }
/*     */     
/*     */     @com.google.a.a.c
/*     */     Object readResolve() {
/* 475 */       return a().a();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */