/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.E;
/*     */ import com.google.a.b.F;
/*     */ import com.google.a.b.x;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.NoSuchElementException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @c
/*     */ public final class dg<K extends Comparable, V>
/*     */   implements cp<K, V>
/*     */ {
/*     */   private final NavigableMap<T<K>, b<K, V>> d;
/*     */   
/*     */   public static <K extends Comparable, V> dg<K, V> a() {
/*  59 */     return new dg<>();
/*     */   }
/*     */   
/*     */   private dg() {
/*  63 */     this.d = bW.a();
/*     */   }
/*     */   
/*     */   private static final class b<K extends Comparable, V>
/*     */     extends g<cn<K>, V> {
/*     */     private final cn<K> c;
/*     */     private final V value;
/*     */     
/*     */     b(T<K> param1T1, T<K> param1T2, V param1V) {
/*  72 */       this(cn.a(param1T1, param1T2), param1V);
/*     */     }
/*     */     
/*     */     b(cn<K> param1cn, V param1V) {
/*  76 */       this.c = param1cn;
/*  77 */       this.value = param1V;
/*     */     }
/*     */ 
/*     */     
/*     */     public cn<K> d() {
/*  82 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public V getValue() {
/*  87 */       return this.value;
/*     */     }
/*     */     
/*     */     public boolean a(K param1K) {
/*  91 */       return this.c.a(param1K);
/*     */     }
/*     */     
/*     */     T<K> c() {
/*  95 */       return this.c.a;
/*     */     }
/*     */     
/*     */     T<K> d() {
/*  99 */       return this.c.b;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public V a(K paramK) {
/* 105 */     Map.Entry<cn<K>, V> entry = a(paramK);
/* 106 */     return (entry == null) ? null : entry.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map.Entry<cn<K>, V> a(K paramK) {
/* 112 */     Map.Entry<T<K>, b<K, V>> entry = this.d.floorEntry(T.a(paramK));
/* 113 */     if (entry != null && ((b)entry.getValue()).a(paramK)) {
/* 114 */       return entry.getValue();
/*     */     }
/* 116 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(cn<K> paramcn, V paramV) {
/* 122 */     if (!paramcn.isEmpty()) {
/* 123 */       D.checkNotNull(paramV);
/* 124 */       b(paramcn);
/* 125 */       this.d.put(paramcn.a, new b<>(paramcn, paramV));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(cn<K> paramcn, V paramV) {
/* 132 */     if (this.d.isEmpty()) {
/* 133 */       a(paramcn, paramV);
/*     */       
/*     */       return;
/*     */     } 
/* 137 */     cn<K> cn1 = a(paramcn, (V)D.checkNotNull(paramV));
/* 138 */     a(cn1, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   private cn<K> a(cn<K> paramcn, V paramV) {
/* 143 */     cn<K> cn1 = paramcn;
/*     */     
/* 145 */     Map.Entry<T<K>, b<K, V>> entry1 = this.d.lowerEntry(paramcn.a);
/* 146 */     cn1 = a(cn1, paramV, entry1);
/*     */ 
/*     */     
/* 149 */     Map.Entry<T<K>, b<K, V>> entry2 = this.d.floorEntry(paramcn.b);
/* 150 */     cn1 = a(cn1, paramV, entry2);
/*     */     
/* 152 */     return cn1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static <K extends Comparable, V> cn<K> a(cn<K> paramcn, V paramV, Map.Entry<T<K>, b<K, V>> paramEntry) {
/* 158 */     if (paramEntry != null && ((b)paramEntry
/* 159 */       .getValue()).d().c(paramcn) && ((b)paramEntry
/* 160 */       .getValue()).getValue().equals(paramV)) {
/* 161 */       return paramcn.c(((b)paramEntry.getValue()).d());
/*     */     }
/* 163 */     return paramcn;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(cp<K, V> paramcp) {
/* 168 */     for (Map.Entry entry : paramcp.D().entrySet()) {
/* 169 */       a((cn<K>)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 175 */     this.d.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public cn<K> b() {
/* 180 */     Map.Entry<T<K>, b<K, V>> entry1 = this.d.firstEntry();
/* 181 */     Map.Entry<T<K>, b<K, V>> entry2 = this.d.lastEntry();
/* 182 */     if (entry1 == null) {
/* 183 */       throw new NoSuchElementException();
/*     */     }
/* 185 */     return cn.a(
/* 186 */         (((b)entry1.getValue()).d()).a, (((b)entry2.getValue()).d()).b);
/*     */   }
/*     */   
/*     */   private void a(T<K> paramT1, T<K> paramT2, V paramV) {
/* 190 */     this.d.put(paramT1, new b<>(paramT1, paramT2, paramV));
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(cn<K> paramcn) {
/* 195 */     if (paramcn.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     Map.Entry<T<K>, b<K, V>> entry1 = this.d.lowerEntry(paramcn.a);
/* 205 */     if (entry1 != null) {
/*     */       
/* 207 */       b b = entry1.getValue();
/* 208 */       if (b.d().a(paramcn.a) > 0) {
/*     */         
/* 210 */         if (b.d().a(paramcn.b) > 0)
/*     */         {
/*     */           
/* 213 */           a(paramcn.b, b
/*     */               
/* 215 */               .d(), (V)((b)entry1
/* 216 */               .getValue()).getValue());
/*     */         }
/*     */         
/* 219 */         a(b
/* 220 */             .c(), paramcn.a, (V)((b)entry1
/*     */             
/* 222 */             .getValue()).getValue());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 227 */     Map.Entry<T<K>, b<K, V>> entry2 = this.d.lowerEntry(paramcn.b);
/* 228 */     if (entry2 != null) {
/*     */       
/* 230 */       b b = entry2.getValue();
/* 231 */       if (b.d().a(paramcn.b) > 0)
/*     */       {
/*     */         
/* 234 */         a(paramcn.b, b
/*     */             
/* 236 */             .d(), (V)((b)entry2
/* 237 */             .getValue()).getValue());
/*     */       }
/*     */     } 
/* 240 */     this.d.subMap(paramcn.a, paramcn.b).clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(T<K> paramT) {
/* 248 */     Map.Entry<T<K>, b<K, V>> entry = this.d.lowerEntry(paramT);
/* 249 */     if (entry == null) {
/*     */       return;
/*     */     }
/*     */     
/* 253 */     b b = entry.getValue();
/* 254 */     if (b.d().a(paramT) <= 0) {
/*     */       return;
/*     */     }
/*     */     
/* 258 */     a(b.c(), paramT, (V)b.getValue());
/* 259 */     a(paramT, b.d(), (V)b.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(cn<K> paramcn, V paramV, BiFunction<? super V, ? super V, ? extends V> paramBiFunction) {
/* 267 */     D.checkNotNull(paramcn);
/* 268 */     D.checkNotNull(paramBiFunction);
/*     */     
/* 270 */     if (paramcn.isEmpty()) {
/*     */       return;
/*     */     }
/* 273 */     a(paramcn.a);
/* 274 */     a(paramcn.b);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     Set set = this.d.subMap(paramcn.a, paramcn.b).entrySet();
/*     */ 
/*     */     
/* 282 */     bj.a<?, ?> a = bj.a();
/* 283 */     if (paramV != null) {
/*     */       
/* 285 */       Iterator<Map.Entry> iterator1 = set.iterator();
/* 286 */       T<K> t = paramcn.a;
/* 287 */       while (iterator1.hasNext()) {
/* 288 */         b b = (b)((Map.Entry)iterator1.next()).getValue();
/* 289 */         T<K> t1 = b.c();
/* 290 */         if (!t.equals(t1)) {
/* 291 */           a.a(t, new b<>(t, t1, paramV));
/*     */         }
/* 293 */         t = b.d();
/*     */       } 
/* 295 */       if (!t.equals(paramcn.b)) {
/* 296 */         a.a(t, new b<>(t, paramcn.b, paramV));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 301 */     Iterator<Map.Entry> iterator = set.iterator();
/* 302 */     while (iterator.hasNext()) {
/* 303 */       Map.Entry entry = iterator.next();
/* 304 */       V v = paramBiFunction.apply((V)((b)entry.getValue()).getValue(), paramV);
/* 305 */       if (v == null) {
/* 306 */         iterator.remove(); continue;
/*     */       } 
/* 308 */       entry.setValue(new b<>(((b)entry
/*     */             
/* 310 */             .getValue()).c(), ((b)entry.getValue()).d(), v));
/*     */     } 
/*     */ 
/*     */     
/* 314 */     this.d.putAll((Map)a.e());
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<cn<K>, V> D() {
/* 319 */     return new a(this, this.d.values());
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<cn<K>, V> C() {
/* 324 */     return new a(this, this.d.descendingMap().values());
/*     */   }
/*     */   
/*     */   private final class a
/*     */     extends bW.o<cn<K>, V>
/*     */   {
/*     */     final Iterable<Map.Entry<cn<K>, V>> f;
/*     */     
/*     */     a(dg this$0, Iterable<dg.b<K, V>> param1Iterable) {
/* 333 */       this.f = (Iterable)param1Iterable;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 338 */       return (get(param1Object) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public V get(Object param1Object) {
/* 343 */       if (param1Object instanceof cn) {
/* 344 */         cn cn = (cn)param1Object;
/* 345 */         dg.b b = (dg.b)dg.a(this.a).get(cn.a);
/* 346 */         if (b != null && b.d().equals(cn)) {
/* 347 */           return (V)b.getValue();
/*     */         }
/*     */       } 
/* 350 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 355 */       return dg.a(this.a).size();
/*     */     }
/*     */ 
/*     */     
/*     */     Iterator<Map.Entry<cn<K>, V>> c() {
/* 360 */       return this.f.iterator();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public cp<K, V> a(cn<K> paramcn) {
/* 366 */     if (paramcn.equals(cn.c())) {
/* 367 */       return this;
/*     */     }
/* 369 */     return new c(this, paramcn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private cp<K, V> a() {
/* 375 */     return a;
/*     */   }
/*     */   
/* 378 */   private static final cp a = new cp<Comparable, Object>()
/*     */     {
/*     */       public Object a(Comparable param1Comparable)
/*     */       {
/* 382 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public Map.Entry<cn, Object> a(Comparable param1Comparable) {
/* 387 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public cn b() {
/* 392 */         throw new NoSuchElementException();
/*     */       }
/*     */ 
/*     */       
/*     */       public void a(cn param1cn, Object param1Object) {
/* 397 */         D.checkNotNull(param1cn);
/* 398 */         String str = String.valueOf(param1cn); throw new IllegalArgumentException((new StringBuilder(46 + String.valueOf(str).length())).append("Cannot insert range ").append(str).append(" into an empty subRangeMap").toString());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void b(cn param1cn, Object param1Object) {
/* 404 */         D.checkNotNull(param1cn);
/* 405 */         String str = String.valueOf(param1cn); throw new IllegalArgumentException((new StringBuilder(46 + String.valueOf(str).length())).append("Cannot insert range ").append(str).append(" into an empty subRangeMap").toString());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void a(cp param1cp) {
/* 411 */         if (!param1cp.D().isEmpty()) {
/* 412 */           throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void clear() {}
/*     */ 
/*     */       
/*     */       public void b(cn param1cn) {
/* 422 */         D.checkNotNull(param1cn);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void a(cn param1cn, Object param1Object, BiFunction param1BiFunction) {
/* 428 */         D.checkNotNull(param1cn);
/* 429 */         String str = String.valueOf(param1cn); throw new IllegalArgumentException((new StringBuilder(45 + String.valueOf(str).length())).append("Cannot merge range ").append(str).append(" into an empty subRangeMap").toString());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public Map<cn, Object> D() {
/* 435 */         return Collections.emptyMap();
/*     */       }
/*     */ 
/*     */       
/*     */       public Map<cn, Object> C() {
/* 440 */         return Collections.emptyMap();
/*     */       }
/*     */ 
/*     */       
/*     */       public cp a(cn param1cn) {
/* 445 */         D.checkNotNull(param1cn);
/* 446 */         return this;
/*     */       }
/*     */     };
/*     */   
/*     */   private class c
/*     */     implements cp<K, V> {
/*     */     private final cn<K> d;
/*     */     
/*     */     c(dg this$0, cn<K> param1cn) {
/* 455 */       this.d = param1cn;
/*     */     }
/*     */ 
/*     */     
/*     */     public V a(K param1K) {
/* 460 */       return this.d.a(param1K) ? this.a.a(param1K) : null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Map.Entry<cn<K>, V> a(K param1K) {
/* 465 */       if (this.d.a(param1K)) {
/* 466 */         Map.Entry entry = this.a.a(param1K);
/* 467 */         if (entry != null) {
/* 468 */           return bW.d(((cn<K>)entry.getKey()).a(this.d), (V)entry.getValue());
/*     */         }
/*     */       } 
/* 471 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public cn<K> b() {
/*     */       T<K> t1, t2;
/* 478 */       Map.Entry entry1 = dg.a(this.a).floorEntry(this.d.a);
/* 479 */       if (entry1 != null && ((dg.b)entry1
/* 480 */         .getValue()).d().a(this.d.a) > 0) {
/* 481 */         t1 = this.d.a;
/*     */       } else {
/* 483 */         t1 = (T)dg.a(this.a).ceilingKey(this.d.a);
/* 484 */         if (t1 == null || t1.a(this.d.b) >= 0) {
/* 485 */           throw new NoSuchElementException();
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 491 */       Map.Entry entry2 = dg.a(this.a).lowerEntry(this.d.b);
/* 492 */       if (entry2 == null)
/* 493 */         throw new NoSuchElementException(); 
/* 494 */       if (((dg.b)entry2.getValue()).d().a(this.d.b) >= 0) {
/* 495 */         t2 = this.d.b;
/*     */       } else {
/* 497 */         t2 = ((dg.b)entry2.getValue()).d();
/*     */       } 
/* 499 */       return cn.a(t1, t2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(cn<K> param1cn, V param1V) {
/* 504 */       D.a(this.d
/* 505 */           .b(param1cn), "Cannot put range %s into a subRangeMap(%s)", param1cn, this.d);
/* 506 */       this.a.a(param1cn, param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public void b(cn<K> param1cn, V param1V) {
/* 511 */       if (dg.a(this.a).isEmpty() || !this.d.b(param1cn)) {
/* 512 */         a(param1cn, param1V);
/*     */         
/*     */         return;
/*     */       } 
/* 516 */       cn<K> cn1 = dg.a(this.a, param1cn, D.checkNotNull(param1V));
/*     */       
/* 518 */       a(cn1.a(this.d), param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(cp<K, V> param1cp) {
/* 523 */       if (param1cp.D().isEmpty()) {
/*     */         return;
/*     */       }
/* 526 */       cn<K> cn1 = param1cp.b();
/* 527 */       D.a(this.d
/* 528 */           .b(cn1), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", cn1, this.d);
/*     */ 
/*     */ 
/*     */       
/* 532 */       this.a.a(param1cp);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 537 */       this.a.b(this.d);
/*     */     }
/*     */ 
/*     */     
/*     */     public void b(cn<K> param1cn) {
/* 542 */       if (param1cn.c(this.d)) {
/* 543 */         this.a.b(param1cn.a(this.d));
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(cn<K> param1cn, V param1V, BiFunction<? super V, ? super V, ? extends V> param1BiFunction) {
/* 552 */       D.a(this.d
/* 553 */           .b(param1cn), "Cannot merge range %s into a subRangeMap(%s)", param1cn, this.d);
/*     */ 
/*     */ 
/*     */       
/* 557 */       this.a.a(param1cn, param1V, param1BiFunction);
/*     */     }
/*     */ 
/*     */     
/*     */     public cp<K, V> a(cn<K> param1cn) {
/* 562 */       if (!param1cn.c(this.d)) {
/* 563 */         return dg.a(this.a);
/*     */       }
/* 565 */       return this.a.a(param1cn.a(this.d));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<cn<K>, V> D() {
/* 571 */       return new a(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public Map<cn<K>, V> C() {
/* 576 */       return new a(this)
/*     */         {
/*     */           Iterator<Map.Entry<cn<K>, V>> c()
/*     */           {
/* 580 */             if (dg.c.a(this.a).isEmpty()) {
/* 581 */               return bH.g();
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 588 */             Iterator iterator = dg.a(this.a.a).headMap((dg.c.a(this.a)).b, false).descendingMap().values().iterator();
/* 589 */             return new c<Map.Entry<cn<K>, V>>(this, iterator)
/*     */               {
/*     */                 protected Map.Entry<cn<K>, V> b()
/*     */                 {
/* 593 */                   if (this.G.hasNext()) {
/* 594 */                     dg.b b = this.G.next();
/* 595 */                     if (b.d().a((dg.c.a(this.a.a)).a) <= 0) {
/* 596 */                       return c();
/*     */                     }
/* 598 */                     return bW.d(b.d().a(dg.c.a(this.a.a)), (V)b.getValue());
/*     */                   } 
/* 600 */                   return c();
/*     */                 }
/*     */               };
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 609 */       if (param1Object instanceof cp) {
/* 610 */         cp cp1 = (cp)param1Object;
/* 611 */         return D().equals(cp1.D());
/*     */       } 
/* 613 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 618 */       return D().hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 623 */       return D().toString();
/*     */     }
/*     */     
/*     */     class a extends AbstractMap<cn<K>, V> {
/*     */       a(dg.c this$0) {}
/*     */       
/*     */       public boolean containsKey(Object param2Object) {
/* 630 */         return (get(param2Object) != null);
/*     */       }
/*     */ 
/*     */       
/*     */       public V get(Object param2Object) {
/*     */         try {
/* 636 */           if (param2Object instanceof cn) {
/*     */             
/* 638 */             cn cn = (cn)param2Object;
/* 639 */             if (!dg.c.a(this.a).b(cn) || cn.isEmpty()) {
/* 640 */               return null;
/*     */             }
/* 642 */             dg.b b = null;
/* 643 */             if (cn.a.a((dg.c.a(this.a)).a) == 0) {
/*     */ 
/*     */               
/* 646 */               Map.Entry entry = dg.a(this.a.a).floorEntry(cn.a);
/* 647 */               if (entry != null) {
/* 648 */                 b = (dg.b)entry.getValue();
/*     */               }
/*     */             } else {
/* 651 */               b = (dg.b)dg.a(this.a.a).get(cn.a);
/*     */             } 
/*     */             
/* 654 */             if (b != null && b
/* 655 */               .d().c(dg.c.a(this.a)) && b
/* 656 */               .d().a(dg.c.a(this.a)).equals(cn)) {
/* 657 */               return (V)b.getValue();
/*     */             }
/*     */           } 
/* 660 */         } catch (ClassCastException classCastException) {
/* 661 */           return null;
/*     */         } 
/* 663 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public V remove(Object param2Object) {
/* 668 */         V v = get(param2Object);
/* 669 */         if (v != null) {
/*     */           
/* 671 */           cn cn = (cn)param2Object;
/* 672 */           this.a.a.b(cn);
/* 673 */           return v;
/*     */         } 
/* 675 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public void clear() {
/* 680 */         this.a.clear();
/*     */       }
/*     */       
/*     */       private boolean e(E<? super Map.Entry<cn<K>, V>> param2E) {
/* 684 */         ArrayList<?> arrayList = bS.a();
/* 685 */         for (Map.Entry<cn<K>, V> entry : entrySet()) {
/* 686 */           if (param2E.b(entry)) {
/* 687 */             arrayList.add(entry.getKey());
/*     */           }
/*     */         } 
/* 690 */         for (cn cn : arrayList) {
/* 691 */           this.a.a.b(cn);
/*     */         }
/* 693 */         return !arrayList.isEmpty();
/*     */       }
/*     */ 
/*     */       
/*     */       public Set<cn<K>> keySet() {
/* 698 */         return (Set)new bW.p<cn<cn<K>>, V>(this, this)
/*     */           {
/*     */             public boolean remove(Object param3Object) {
/* 701 */               return (this.a.remove(param3Object) != null);
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean retainAll(Collection<?> param3Collection) {
/* 706 */               return dg.c.a.a(this.a, F.a(F.a(F.a(param3Collection)), bW.e()));
/*     */             }
/*     */           };
/*     */       }
/*     */ 
/*     */       
/*     */       public Set<Map.Entry<cn<K>, V>> entrySet() {
/* 713 */         return (Set)new bW.g<cn<cn<K>>, V>(this)
/*     */           {
/*     */             Map<cn<K>, V> w() {
/* 716 */               return this.a;
/*     */             }
/*     */ 
/*     */             
/*     */             public Iterator<Map.Entry<cn<K>, V>> iterator() {
/* 721 */               return this.a.c();
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean retainAll(Collection<?> param3Collection) {
/* 726 */               return dg.c.a.a(this.a, F.a(F.a(param3Collection)));
/*     */             }
/*     */ 
/*     */             
/*     */             public int size() {
/* 731 */               return bH.size(iterator());
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean isEmpty() {
/* 736 */               return !iterator().hasNext();
/*     */             }
/*     */           };
/*     */       }
/*     */       
/*     */       Iterator<Map.Entry<cn<K>, V>> c() {
/* 742 */         if (dg.c.a(this.a).isEmpty()) {
/* 743 */           return bH.g();
/*     */         }
/*     */         
/* 746 */         T t = (T)x.a(
/* 747 */             dg.a(this.a.a).floorKey((dg.c.a(this.a)).a), (dg.c.a(this.a)).a);
/*     */         
/* 749 */         Iterator iterator = dg.a(this.a.a).tailMap(t, true).values().iterator();
/* 750 */         return new c<Map.Entry<cn<K>, V>>(this, iterator)
/*     */           {
/*     */             protected Map.Entry<cn<K>, V> b()
/*     */             {
/* 754 */               while (this.G.hasNext()) {
/* 755 */                 dg.b b = this.G.next();
/* 756 */                 if (b.c().a((dg.c.a(this.a.a)).b) >= 0)
/* 757 */                   return c(); 
/* 758 */                 if (b.d().a((dg.c.a(this.a.a)).a) > 0)
/*     */                 {
/* 760 */                   return bW.d(b.d().a(dg.c.a(this.a.a)), (V)b.getValue());
/*     */                 }
/*     */               } 
/* 763 */               return c();
/*     */             }
/*     */           };
/*     */       }
/*     */ 
/*     */       
/*     */       public Collection<V> values() {
/* 770 */         return new bW.E<cn<cn<K>>, V>(this, this)
/*     */           {
/*     */             public boolean removeAll(Collection<?> param3Collection) {
/* 773 */               return dg.c.a.a(this.a, F.a(F.a(param3Collection), bW.f()));
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean retainAll(Collection<?> param3Collection) {
/* 778 */               return dg.c.a.a(this.a, F.a(F.a(F.a(param3Collection)), bW.f()));
/*     */             }
/*     */           };
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 787 */     if (paramObject instanceof cp) {
/* 788 */       cp cp1 = (cp)paramObject;
/* 789 */       return D().equals(cp1.D());
/*     */     } 
/* 791 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 796 */     return D().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 801 */     return this.d.values().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\dg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */