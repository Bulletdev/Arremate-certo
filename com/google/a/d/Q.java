/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Spliterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class q<R, C, V>
/*     */   implements cY<R, C, V>
/*     */ {
/*     */   @com.google.b.a.a.b
/*     */   private transient Set<cY.a<R, C, V>> j;
/*     */   @com.google.b.a.a.b
/*     */   private transient Collection<V> values;
/*     */   
/*     */   public boolean d(Object paramObject) {
/*  40 */     return bW.a(y(), paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean e(Object paramObject) {
/*  45 */     return bW.a(x(), paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<R> h() {
/*  50 */     return y().keySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<C> i() {
/*  55 */     return x().keySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/*  60 */     for (Map<C, V> map : y().values()) {
/*  61 */       if (map.containsValue(paramObject)) {
/*  62 */         return true;
/*     */       }
/*     */     } 
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject1, Object paramObject2) {
/*  70 */     Map<?, ?> map = bW.<Map>a((Map)y(), paramObject1);
/*  71 */     return (map != null && bW.a(map, paramObject2));
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object paramObject1, Object paramObject2) {
/*  76 */     Map<?, V> map = bW.<Map>a((Map)y(), paramObject1);
/*  77 */     return (map == null) ? null : bW.<V>a(map, paramObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  82 */     return (size() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  87 */     bH.a(j().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public V e(Object paramObject1, Object paramObject2) {
/*  93 */     Map<?, V> map = bW.<Map>a((Map)y(), paramObject1);
/*  94 */     return (map == null) ? null : bW.<V>b(map, paramObject2);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public V put(R paramR, C paramC, V paramV) {
/* 100 */     return b(paramR).put(paramC, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(cY<? extends R, ? extends C, ? extends V> paramcY) {
/* 105 */     for (cY.a<? extends R, ? extends C, ? extends V> a : paramcY.j()) {
/* 106 */       put((R)a.h(), (C)a.i(), (V)a.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<cY.a<R, C, V>> j() {
/* 114 */     Set<cY.a<R, C, V>> set = this.j;
/* 115 */     return (set == null) ? (this.j = k()) : set;
/*     */   }
/*     */   
/*     */   Set<cY.a<R, C, V>> k() {
/* 119 */     return new a(this);
/*     */   }
/*     */   
/*     */   abstract Iterator<cY.a<R, C, V>> cellIterator();
/*     */   
/*     */   abstract Spliterator<cY.a<R, C, V>> c();
/*     */   
/*     */   class a extends AbstractSet<cY.a<R, C, V>> {
/*     */     a(q this$0) {}
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 130 */       if (param1Object instanceof cY.a) {
/* 131 */         cY.a a1 = (cY.a)param1Object;
/* 132 */         Map map = bW.<Map>a(this.a.y(), a1.h());
/* 133 */         return (map != null && 
/* 134 */           E.a(map
/* 135 */             .entrySet(), bW.d(a1.i(), a1.getValue())));
/*     */       } 
/* 137 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 142 */       if (param1Object instanceof cY.a) {
/* 143 */         cY.a a1 = (cY.a)param1Object;
/* 144 */         Map map = bW.<Map>a(this.a.y(), a1.h());
/* 145 */         return (map != null && 
/* 146 */           E.b(map
/* 147 */             .entrySet(), bW.d(a1.i(), a1.getValue())));
/*     */       } 
/* 149 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 154 */       this.a.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<cY.a<R, C, V>> iterator() {
/* 159 */       return this.a.cellIterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator<cY.a<R, C, V>> spliterator() {
/* 164 */       return this.a.c();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 169 */       return this.a.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 177 */     Collection<V> collection = this.values;
/* 178 */     return (collection == null) ? (this.values = c()) : collection;
/*     */   }
/*     */   
/*     */   Collection<V> c() {
/* 182 */     return new b(this);
/*     */   }
/*     */   
/*     */   Iterator<V> g() {
/* 186 */     return new db<cY.a<R, C, V>, V>(this, j().iterator())
/*     */       {
/*     */         V a(cY.a<R, C, V> param1a) {
/* 189 */           return param1a.getValue();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   Spliterator<V> d() {
/* 195 */     return D.a(c(), cY.a::getValue);
/*     */   }
/*     */   
/*     */   class b extends AbstractCollection<V> {
/*     */     b(q this$0) {}
/*     */     
/*     */     public Iterator<V> iterator() {
/* 202 */       return this.a.g();
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator<V> spliterator() {
/* 207 */       return this.a.d();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 212 */       return this.a.containsValue(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 217 */       this.a.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 222 */       return this.a.size();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 228 */     return cZ.a(this, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 233 */     return j().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 239 */     return y().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */