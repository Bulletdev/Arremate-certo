/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.M;
/*     */ import com.google.a.b.s;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(ck = true)
/*     */ public class dd<R, C, V>
/*     */   extends cU<R, C, V>
/*     */ {
/*     */   private final Comparator<? super C> c;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   private static class a<C, V>
/*     */     implements M<TreeMap<C, V>>, Serializable
/*     */   {
/*     */     final Comparator<? super C> comparator;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(Comparator<? super C> param1Comparator) {
/*  76 */       this.comparator = param1Comparator;
/*     */     }
/*     */ 
/*     */     
/*     */     public TreeMap<C, V> b() {
/*  81 */       return new TreeMap<>(this.comparator);
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
/*     */   public static <R extends Comparable, C extends Comparable, V> dd<R, C, V> a() {
/*  96 */     return new dd<>(cj.e(), cj.e());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <R, C, V> dd<R, C, V> a(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1) {
/* 107 */     D.checkNotNull(paramComparator);
/* 108 */     D.checkNotNull(paramComparator1);
/* 109 */     return new dd<>(paramComparator, paramComparator1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <R, C, V> dd<R, C, V> a(dd<R, C, ? extends V> paramdd) {
/* 118 */     dd<Object, Object, Object> dd1 = new dd<>(paramdd.b(), paramdd.c());
/* 119 */     dd1.a(paramdd);
/* 120 */     return (dd)dd1;
/*     */   }
/*     */   
/*     */   dd(Comparator<? super R> paramComparator, Comparator<? super C> paramComparator1) {
/* 124 */     super(new TreeMap<>(paramComparator), (M)new a<>(paramComparator1));
/* 125 */     this.c = paramComparator1;
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
/*     */   @Deprecated
/*     */   public Comparator<? super R> b() {
/* 138 */     return j().comparator();
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
/*     */   @Deprecated
/*     */   public Comparator<? super C> c() {
/* 151 */     return this.c;
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
/*     */   public SortedMap<C, V> c(R paramR) {
/* 168 */     return new b(paramR);
/*     */   }
/*     */   
/*     */   private class b
/*     */     extends cV<R, C, V>.f implements SortedMap<C, V> {
/*     */     final C W;
/*     */     
/*     */     b(R param1R) {
/* 176 */       this(param1R, null, null);
/*     */     }
/*     */     final C X; transient SortedMap<C, V> a;
/*     */     b(R param1R, C param1C1, C param1C2) {
/* 180 */       super(param1R);
/* 181 */       this.W = param1C1;
/* 182 */       this.X = param1C2;
/* 183 */       D.checkArgument((param1C1 == null || param1C2 == null || 
/* 184 */           compare(param1C1, param1C2) <= 0));
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedSet<C> b() {
/* 189 */       return new bW.u<>(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public Comparator<? super C> comparator() {
/* 194 */       return this.a.c();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     int compare(Object param1Object1, Object param1Object2) {
/* 200 */       Comparator<? super C> comparator = comparator();
/* 201 */       return comparator.compare((C)param1Object1, (C)param1Object2);
/*     */     }
/*     */     
/*     */     boolean q(Object param1Object) {
/* 205 */       return (param1Object != null && (this.W == null || 
/* 206 */         compare(this.W, param1Object) <= 0) && (this.X == null || 
/* 207 */         compare(this.X, param1Object) > 0));
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedMap<C, V> subMap(C param1C1, C param1C2) {
/* 212 */       D.checkArgument((q(D.checkNotNull(param1C1)) && q(D.checkNotNull(param1C2))));
/* 213 */       return new b(this.T, param1C1, param1C2);
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedMap<C, V> headMap(C param1C) {
/* 218 */       D.checkArgument(q(D.checkNotNull(param1C)));
/* 219 */       return new b(this.T, this.W, param1C);
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedMap<C, V> tailMap(C param1C) {
/* 224 */       D.checkArgument(q(D.checkNotNull(param1C)));
/* 225 */       return new b(this.T, param1C, this.X);
/*     */     }
/*     */ 
/*     */     
/*     */     public C firstKey() {
/* 230 */       SortedMap<C, V> sortedMap = o();
/* 231 */       if (sortedMap == null) {
/* 232 */         throw new NoSuchElementException();
/*     */       }
/* 234 */       return o().firstKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public C lastKey() {
/* 239 */       SortedMap<C, V> sortedMap = o();
/* 240 */       if (sortedMap == null) {
/* 241 */         throw new NoSuchElementException();
/*     */       }
/* 243 */       return o().lastKey();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SortedMap<C, V> n() {
/* 253 */       if (this.a == null || (this.a.isEmpty() && this.a.H.containsKey(this.T))) {
/* 254 */         this.a = (dd)this.a.H.get(this.T);
/*     */       }
/* 256 */       return (SortedMap<C, V>)this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     SortedMap<C, V> o() {
/* 261 */       return (SortedMap<C, V>)super.L();
/*     */     }
/*     */ 
/*     */     
/*     */     SortedMap<C, V> p() {
/* 266 */       SortedMap<C, V> sortedMap = n();
/* 267 */       if (sortedMap != null) {
/* 268 */         if (this.W != null) {
/* 269 */           sortedMap = sortedMap.tailMap(this.W);
/*     */         }
/* 271 */         if (this.X != null) {
/* 272 */           sortedMap = sortedMap.headMap(this.X);
/*     */         }
/* 274 */         return sortedMap;
/*     */       } 
/* 276 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     void fo() {
/* 281 */       if (n() != null && this.a.isEmpty()) {
/* 282 */         this.a.H.remove(this.T);
/* 283 */         this.a = null;
/* 284 */         this.X = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 290 */       return (q(param1Object) && super.containsKey(param1Object));
/*     */     }
/*     */ 
/*     */     
/*     */     public V put(C param1C, V param1V) {
/* 295 */       D.checkArgument(q(D.checkNotNull(param1C)));
/* 296 */       return super.put(param1C, param1V);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SortedSet<R> j() {
/* 304 */     return super.j();
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<R, Map<C, V>> k() {
/* 309 */     return super.k();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Iterator<C> m() {
/* 315 */     final Comparator<? super C> comparator = c();
/*     */ 
/*     */     
/* 318 */     dj<C> dj = bH.a(
/* 319 */         bG.a(this.H
/* 320 */           .values(), new s<Map<C, V>, Iterator<C>>(this)
/*     */           {
/*     */             public Iterator<C> a(Map<C, V> param1Map)
/*     */             {
/* 324 */               return param1Map.keySet().iterator();
/*     */             }
/*     */           }), comparator);
/*     */ 
/*     */     
/* 329 */     return new c<C>(this, dj)
/*     */       {
/*     */         C lastValue;
/*     */         
/*     */         protected C b() {
/* 334 */           while (this.F.hasNext()) {
/* 335 */             C c1 = (C)this.F.next();
/* 336 */             boolean bool = (this.lastValue != null && comparator.compare(c1, this.lastValue) == 0) ? true : false;
/*     */ 
/*     */             
/* 339 */             if (!bool) {
/* 340 */               this.lastValue = c1;
/* 341 */               return this.lastValue;
/*     */             } 
/*     */           } 
/*     */           
/* 345 */           this.lastValue = null;
/* 346 */           return c();
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\dd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */