/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.E;
/*     */ import com.google.a.b.F;
/*     */ import com.google.a.b.x;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ class ah<K, V>
/*     */   extends h<K, V>
/*     */   implements am<K, V>
/*     */ {
/*     */   final bZ<K, V> a;
/*     */   final E<? super Map.Entry<K, V>> a;
/*     */   
/*     */   ah(bZ<K, V> parambZ, E<? super Map.Entry<K, V>> paramE) {
/*  50 */     this.a = (E<? super Map.Entry<K, V>>)D.checkNotNull(parambZ);
/*  51 */     this.a = (E<? super Map.Entry<K, V>>)D.checkNotNull(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public bZ<K, V> b() {
/*  56 */     return (bZ)this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public E<? super Map.Entry<K, V>> f() {
/*  61 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  66 */     return entries().size();
/*     */   }
/*     */   
/*     */   private boolean d(K paramK, V paramV) {
/*  70 */     return this.a.b(bW.d(paramK, paramV));
/*     */   }
/*     */   
/*     */   final class c implements E<V> {
/*     */     private final K key;
/*     */     
/*     */     c(ah this$0, K param1K) {
/*  77 */       this.key = param1K;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean b(V param1V) {
/*  82 */       return ah.a(this.a, this.key, param1V);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static <E> Collection<E> b(Collection<E> paramCollection, E<? super E> paramE) {
/*  88 */     if (paramCollection instanceof Set) {
/*  89 */       return cG.a((Set<E>)paramCollection, paramE);
/*     */     }
/*  91 */     return E.a(paramCollection, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  97 */     return (asMap().get(paramObject) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> a(Object paramObject) {
/* 102 */     return (Collection<V>)x.a(asMap().remove(paramObject), f());
/*     */   }
/*     */ 
/*     */   
/*     */   Collection<V> f() {
/* 107 */     return (this.a instanceof cF) ? 
/* 108 */       Collections.<V>emptySet() : 
/* 109 */       Collections.<V>emptyList();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 114 */     entries().clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> get(K paramK) {
/* 119 */     return b(this.a.get((Map.Entry<K, V>)paramK), new c(this, paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   Collection<Map.Entry<K, V>> d() {
/* 124 */     return b((Collection)this.a.entries(), this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   Collection<V> c() {
/* 129 */     return new an<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   Iterator<Map.Entry<K, V>> c() {
/* 134 */     throw new AssertionError("should never be called");
/*     */   }
/*     */ 
/*     */   
/*     */   Map<K, Collection<V>> u() {
/* 139 */     return new a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   Set<K> b() {
/* 144 */     return asMap().keySet();
/*     */   }
/*     */   
/*     */   boolean a(E<? super Map.Entry<K, Collection<V>>> paramE) {
/* 148 */     Iterator<Map.Entry> iterator = this.a.asMap().entrySet().iterator();
/* 149 */     boolean bool = false;
/* 150 */     while (iterator.hasNext()) {
/* 151 */       Map.Entry entry = iterator.next();
/* 152 */       Object object = entry.getKey();
/* 153 */       Collection<?> collection = b((Collection)entry.getValue(), new c(this, (K)object));
/* 154 */       if (!collection.isEmpty() && paramE.b(bW.d(object, collection))) {
/* 155 */         if (collection.size() == ((Collection)entry.getValue()).size()) {
/* 156 */           iterator.remove();
/*     */         } else {
/* 158 */           collection.clear();
/*     */         } 
/* 160 */         bool = true;
/*     */       } 
/*     */     } 
/* 163 */     return bool;
/*     */   }
/*     */   
/*     */   class a extends bW.F<K, Collection<V>> {
/*     */     a(ah this$0) {}
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 170 */       return (get(param1Object) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 175 */       this.a.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public Collection<V> get(Object param1Object) {
/* 180 */       Collection<?> collection = (Collection)this.a.a.asMap().get(param1Object);
/* 181 */       if (collection == null) {
/* 182 */         return null;
/*     */       }
/*     */       
/* 185 */       Object object = param1Object;
/* 186 */       collection = ah.b(collection, new ah.c(this.a, (K)object));
/* 187 */       return collection.isEmpty() ? null : (Collection)collection;
/*     */     }
/*     */ 
/*     */     
/*     */     public Collection<V> remove(Object param1Object) {
/* 192 */       Collection collection = (Collection)this.a.a.asMap().get(param1Object);
/* 193 */       if (collection == null) {
/* 194 */         return null;
/*     */       }
/*     */       
/* 197 */       Object object = param1Object;
/* 198 */       ArrayList<?> arrayList = bS.a();
/* 199 */       Iterator<Object> iterator = collection.iterator();
/* 200 */       while (iterator.hasNext()) {
/* 201 */         Object object1 = iterator.next();
/* 202 */         if (ah.a(this.a, object, object1)) {
/* 203 */           iterator.remove();
/* 204 */           arrayList.add(object1);
/*     */         } 
/*     */       } 
/* 207 */       if (arrayList.isEmpty())
/* 208 */         return null; 
/* 209 */       if (this.a.a instanceof cF) {
/* 210 */         return Collections.unmodifiableSet(cG.a((Iterable)arrayList));
/*     */       }
/* 212 */       return Collections.unmodifiableList((List)arrayList);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     class b
/*     */       extends bW.p<K, Collection<V>>
/*     */     {
/*     */       b(ah.a this$0) {
/* 221 */         super(this$0);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean removeAll(Collection<?> param2Collection) {
/* 226 */         return this.a.a.a(bW.b(F.a(param2Collection)));
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean retainAll(Collection<?> param2Collection) {
/* 231 */         return this.a.a.a(bW.b(F.a(F.a(param2Collection))));
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean remove(Object param2Object) {
/* 236 */         return (this.a.remove(param2Object) != null);
/*     */       } }
/*     */     Set<K> b() {
/* 239 */       return new b(this);
/*     */     }
/*     */     
/*     */     class a
/*     */       extends bW.g<K, Collection<V>>
/*     */     {
/*     */       a(ah.a this$0) {}
/*     */       
/*     */       Map<K, Collection<V>> w() {
/* 248 */         return this.a;
/*     */       }
/*     */ 
/*     */       
/*     */       public Iterator<Map.Entry<K, Collection<V>>> iterator() {
/* 253 */         return new c<Map.Entry<K, Collection<V>>>(this) {
/* 254 */             final Iterator<Map.Entry<K, Collection<V>>> h = this.a.a.a.a
/* 255 */               .asMap().entrySet().iterator();
/*     */ 
/*     */             
/*     */             protected Map.Entry<K, Collection<V>> b() {
/* 259 */               while (this.h.hasNext()) {
/* 260 */                 Map.Entry entry = this.h.next();
/* 261 */                 Object object = entry.getKey();
/*     */                 
/* 263 */                 Collection<?> collection = ah.b((Collection)entry.getValue(), new ah.c(this.a.a.a, (K)object));
/* 264 */                 if (!collection.isEmpty()) {
/* 265 */                   return (Map.Entry)bW.d((K)object, collection);
/*     */                 }
/*     */               } 
/* 268 */               return c();
/*     */             }
/*     */           };
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean removeAll(Collection<?> param2Collection) {
/* 275 */         return this.a.a.a(F.a(param2Collection));
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean retainAll(Collection<?> param2Collection) {
/* 280 */         return this.a.a.a(F.a(F.a(param2Collection)));
/*     */       }
/*     */ 
/*     */       
/*     */       public int size() {
/* 285 */         return bH.size(iterator());
/*     */       } }
/*     */     Set<Map.Entry<K, Collection<V>>> createEntrySet() {
/* 288 */       return new a(this);
/*     */     }
/*     */ 
/*     */     
/*     */     class c
/*     */       extends bW.E<K, Collection<V>>
/*     */     {
/*     */       c(ah.a this$0) {
/* 296 */         super(this$0);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean remove(Object param2Object) {
/* 301 */         if (param2Object instanceof Collection) {
/* 302 */           Collection collection = (Collection)param2Object;
/*     */           
/* 304 */           Iterator<Map.Entry> iterator = this.a.a.a.asMap().entrySet().iterator();
/* 305 */           while (iterator.hasNext()) {
/* 306 */             Map.Entry entry = iterator.next();
/* 307 */             Object object = entry.getKey();
/*     */             
/* 309 */             Collection<?> collection1 = ah.b((Collection)entry.getValue(), new ah.c(this.a.a, (K)object));
/* 310 */             if (!collection1.isEmpty() && collection.equals(collection1)) {
/* 311 */               if (collection1.size() == ((Collection)entry.getValue()).size()) {
/* 312 */                 iterator.remove();
/*     */               } else {
/* 314 */                 collection1.clear();
/*     */               } 
/* 316 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/* 320 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean removeAll(Collection<?> param2Collection) {
/* 325 */         return this.a.a.a(bW.c(F.a(param2Collection)));
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean retainAll(Collection<?> param2Collection) {
/* 330 */         return this.a.a.a(bW.c(F.a(F.a(param2Collection))));
/*     */       } }
/*     */     Collection<Collection<V>> c() {
/* 333 */       return new c(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   cc<K> a() {
/* 339 */     return new b(this);
/*     */   }
/*     */   
/*     */   class b
/*     */     extends cb.g<K, V> {
/*     */     b(ah<K, V> this$0) {
/* 345 */       super(this$0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int remove(Object param1Object, int param1Int) {
/* 350 */       C.b(param1Int, "occurrences");
/* 351 */       if (param1Int == 0) {
/* 352 */         return b(param1Object);
/*     */       }
/* 354 */       Collection collection = (Collection)this.a.a.asMap().get(param1Object);
/* 355 */       if (collection == null) {
/* 356 */         return 0;
/*     */       }
/*     */       
/* 359 */       Object object = param1Object;
/* 360 */       byte b1 = 0;
/* 361 */       Iterator<Object> iterator = collection.iterator();
/* 362 */       while (iterator.hasNext()) {
/* 363 */         Object object1 = iterator.next();
/*     */         
/* 365 */         b1++;
/* 366 */         if (ah.a(this.a, object, object1) && b1 <= param1Int) {
/* 367 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */       
/* 371 */       return b1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<cc.a<K>> entrySet() {
/* 376 */       return new cd.d<K>(this)
/*     */         {
/*     */           cc<K> c()
/*     */           {
/* 380 */             return this.a;
/*     */           }
/*     */ 
/*     */           
/*     */           public Iterator<cc.a<K>> iterator() {
/* 385 */             return this.a.c();
/*     */           }
/*     */ 
/*     */           
/*     */           public int size() {
/* 390 */             return this.a.a.keySet().size();
/*     */           }
/*     */           
/*     */           private boolean a(E<? super cc.a<K>> param2E) {
/* 394 */             return this.a.a.a(new E<Map.Entry<K, Collection<V>>>(this, param2E)
/*     */                 {
/*     */                   public boolean a(Map.Entry<K, Collection<V>> param3Entry)
/*     */                   {
/* 398 */                     return this.c.b(
/* 399 */                         cd.a(param3Entry.getKey(), ((Collection)param3Entry.getValue()).size()));
/*     */                   }
/*     */                 });
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean removeAll(Collection<?> param2Collection) {
/* 406 */             return a(F.a(param2Collection));
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean retainAll(Collection<?> param2Collection) {
/* 411 */             return a(F.a(F.a(param2Collection)));
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ah.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */