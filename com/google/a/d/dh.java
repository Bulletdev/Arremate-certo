/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.x;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
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
/*     */ @a
/*     */ @c
/*     */ public class dh<C extends Comparable<?>>
/*     */   extends k<C>
/*     */   implements Serializable
/*     */ {
/*     */   @com.google.a.a.d
/*     */   final NavigableMap<T<C>, cn<C>> e;
/*     */   private transient Set<cn<C>> v;
/*     */   private transient Set<cn<C>> w;
/*     */   private transient cq<C> a;
/*     */   
/*     */   public static <C extends Comparable<?>> dh<C> a() {
/*  50 */     return new dh<>(new TreeMap<>());
/*     */   }
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> dh<C> a(cq<C> paramcq) {
/*  55 */     dh<Comparable<?>> dh1 = a();
/*  56 */     dh1.a(paramcq);
/*  57 */     return (dh)dh1;
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
/*     */   public static <C extends Comparable<?>> dh<C> a(Iterable<cn<C>> paramIterable) {
/*  70 */     dh<Comparable<?>> dh1 = a();
/*  71 */     dh1.b(paramIterable);
/*  72 */     return (dh)dh1;
/*     */   }
/*     */   
/*     */   private dh(NavigableMap<T<C>, cn<C>> paramNavigableMap) {
/*  76 */     this.e = paramNavigableMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<cn<C>> p() {
/*  84 */     Set<cn<C>> set = this.v;
/*  85 */     return (set == null) ? (this.v = new a(this, this.e.values())) : set;
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<cn<C>> o() {
/*  90 */     Set<cn<C>> set = this.w;
/*  91 */     return (set == null) ? (
/*  92 */       this.w = new a(this, this.e.descendingMap().values())) : 
/*  93 */       set;
/*     */   }
/*     */   
/*     */   final class a
/*     */     extends ar<cn<C>> implements Set<cn<C>> {
/*     */     final Collection<cn<C>> b;
/*     */     
/*     */     a(dh this$0, Collection<cn<C>> param1Collection) {
/* 101 */       this.b = param1Collection;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Collection<cn<C>> a() {
/* 106 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 111 */       return cG.a(this);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 116 */       return cG.a(this, param1Object);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public cn<C> a(C paramC) {
/* 122 */     D.checkNotNull(paramC);
/* 123 */     Map.Entry<T<C>, cn<C>> entry = this.e.floorEntry((T)T.a((Comparable)paramC));
/* 124 */     if (entry != null && ((cn)entry.getValue()).a(paramC)) {
/* 125 */       return entry.getValue();
/*     */     }
/*     */     
/* 128 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(cn<C> paramcn) {
/* 134 */     D.checkNotNull(paramcn);
/* 135 */     Map.Entry<T<C>, cn<C>> entry1 = this.e.ceilingEntry(paramcn.a);
/* 136 */     if (entry1 != null && ((cn)entry1
/* 137 */       .getValue()).c(paramcn) && 
/* 138 */       !((cn)entry1.getValue()).a(paramcn).isEmpty()) {
/* 139 */       return true;
/*     */     }
/* 141 */     Map.Entry<T<C>, cn<C>> entry2 = this.e.lowerEntry(paramcn.a);
/* 142 */     return (entry2 != null && ((cn)entry2
/* 143 */       .getValue()).c(paramcn) && 
/* 144 */       !((cn)entry2.getValue()).a(paramcn).isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean b(cn<C> paramcn) {
/* 149 */     D.checkNotNull(paramcn);
/* 150 */     Map.Entry<T<C>, cn<C>> entry = this.e.floorEntry(paramcn.a);
/* 151 */     return (entry != null && ((cn)entry.getValue()).b(paramcn));
/*     */   }
/*     */   
/*     */   private cn<C> d(cn<C> paramcn) {
/* 155 */     D.checkNotNull(paramcn);
/* 156 */     Map.Entry<T<C>, cn<C>> entry = this.e.floorEntry(paramcn.a);
/* 157 */     return (entry != null && ((cn)entry.getValue()).b(paramcn)) ? 
/* 158 */       entry.getValue() : 
/* 159 */       null;
/*     */   }
/*     */ 
/*     */   
/*     */   public cn<C> b() {
/* 164 */     Map.Entry<T<C>, cn<C>> entry1 = this.e.firstEntry();
/* 165 */     Map.Entry<T<C>, cn<C>> entry2 = this.e.lastEntry();
/* 166 */     if (entry1 == null) {
/* 167 */       throw new NoSuchElementException();
/*     */     }
/* 169 */     return cn.a(((cn)entry1.getValue()).a, ((cn)entry2.getValue()).b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(cn<C> paramcn) {
/* 174 */     D.checkNotNull(paramcn);
/*     */     
/* 176 */     if (paramcn.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 182 */     T<C> t1 = paramcn.a;
/* 183 */     T<C> t2 = paramcn.b;
/*     */     
/* 185 */     Map.Entry<T<C>, cn<C>> entry1 = this.e.lowerEntry(t1);
/* 186 */     if (entry1 != null) {
/*     */       
/* 188 */       cn cn1 = entry1.getValue();
/* 189 */       if (cn1.b.a(t1) >= 0) {
/*     */         
/* 191 */         if (cn1.b.a(t2) >= 0)
/*     */         {
/* 193 */           t2 = cn1.b;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 199 */         t1 = cn1.a;
/*     */       } 
/*     */     } 
/*     */     
/* 203 */     Map.Entry<T<C>, cn<C>> entry2 = this.e.floorEntry(t2);
/* 204 */     if (entry2 != null) {
/*     */       
/* 206 */       cn cn1 = entry2.getValue();
/* 207 */       if (cn1.b.a(t2) >= 0)
/*     */       {
/* 209 */         t2 = cn1.b;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 214 */     this.e.subMap(t1, t2).clear();
/*     */     
/* 216 */     c(cn.a(t1, t2));
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(cn<C> paramcn) {
/* 221 */     D.checkNotNull(paramcn);
/*     */     
/* 223 */     if (paramcn.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     Map.Entry<T<C>, cn<C>> entry1 = this.e.lowerEntry(paramcn.a);
/* 231 */     if (entry1 != null) {
/*     */       
/* 233 */       cn cn1 = entry1.getValue();
/* 234 */       if (cn1.b.a(paramcn.a) >= 0) {
/*     */         
/* 236 */         if (paramcn.cU() && cn1.b
/* 237 */           .a(paramcn.b) >= 0)
/*     */         {
/* 239 */           c(
/* 240 */               cn.a(paramcn.b, cn1.b));
/*     */         }
/* 242 */         c(
/* 243 */             cn.a(cn1.a, paramcn.a));
/*     */       } 
/*     */     } 
/*     */     
/* 247 */     Map.Entry<T<C>, cn<C>> entry2 = this.e.floorEntry(paramcn.b);
/* 248 */     if (entry2 != null) {
/*     */       
/* 250 */       cn cn1 = entry2.getValue();
/* 251 */       if (paramcn.cU() && cn1.b
/* 252 */         .a(paramcn.b) >= 0)
/*     */       {
/* 254 */         c(
/* 255 */             cn.a(paramcn.b, cn1.b));
/*     */       }
/*     */     } 
/*     */     
/* 259 */     this.e.subMap(paramcn.a, paramcn.b).clear();
/*     */   }
/*     */   
/*     */   private void c(cn<C> paramcn) {
/* 263 */     if (paramcn.isEmpty()) {
/* 264 */       this.e.remove(paramcn.a);
/*     */     } else {
/* 266 */       this.e.put(paramcn.a, paramcn);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public cq<C> a() {
/* 274 */     cq<C> cq1 = this.a;
/* 275 */     return (cq1 == null) ? (this.a = new b(this)) : cq1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.d
/*     */   static final class d<C extends Comparable<?>>
/*     */     extends j<T<C>, cn<C>>
/*     */   {
/*     */     private final NavigableMap<T<C>, cn<C>> e;
/*     */     
/*     */     private final cn<T<C>> f;
/*     */ 
/*     */     
/*     */     d(NavigableMap<T<C>, cn<C>> param1NavigableMap) {
/* 290 */       this.e = param1NavigableMap;
/* 291 */       this.f = cn.c();
/*     */     }
/*     */ 
/*     */     
/*     */     private d(NavigableMap<T<C>, cn<C>> param1NavigableMap, cn<T<C>> param1cn) {
/* 296 */       this.e = param1NavigableMap;
/* 297 */       this.f = param1cn;
/*     */     }
/*     */     
/*     */     private NavigableMap<T<C>, cn<C>> a(cn<T<C>> param1cn) {
/* 301 */       if (param1cn.c(this.f)) {
/* 302 */         return new d(this.e, param1cn.a(this.f));
/*     */       }
/* 304 */       return bw.a();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> a(T<C> param1T1, boolean param1Boolean1, T<C> param1T2, boolean param1Boolean2) {
/* 311 */       return a(
/* 312 */           cn.a(param1T1, 
/* 313 */             x.a(param1Boolean1), param1T2, 
/* 314 */             x.a(param1Boolean2)));
/*     */     }
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> a(T<C> param1T, boolean param1Boolean) {
/* 319 */       return a(cn.a(param1T, x.a(param1Boolean)));
/*     */     }
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> b(T<C> param1T, boolean param1Boolean) {
/* 324 */       return a(cn.b(param1T, x.a(param1Boolean)));
/*     */     }
/*     */ 
/*     */     
/*     */     public Comparator<? super T<C>> comparator() {
/* 329 */       return cj.e();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 334 */       return (a(param1Object) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public cn<C> a(Object param1Object) {
/* 339 */       if (param1Object instanceof T) {
/*     */         
/*     */         try {
/* 342 */           T<C> t = (T)param1Object;
/* 343 */           if (!this.f.a(t)) {
/* 344 */             return null;
/*     */           }
/* 346 */           Map.Entry<T<C>, cn<C>> entry = this.e.lowerEntry(t);
/* 347 */           if (entry != null && ((cn)entry.getValue()).b.equals(t)) {
/* 348 */             return entry.getValue();
/*     */           }
/* 350 */         } catch (ClassCastException classCastException) {
/* 351 */           return null;
/*     */         } 
/*     */       }
/* 354 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Iterator<Map.Entry<T<C>, cn<C>>> c() {
/*     */       Iterator iterator;
/* 364 */       if (!this.f.cT()) {
/* 365 */         iterator = this.e.values().iterator();
/*     */       } else {
/*     */         
/* 368 */         Map.Entry<T<C>, cn<C>> entry = this.e.lowerEntry(this.f.g());
/* 369 */         if (entry == null) {
/* 370 */           iterator = this.e.values().iterator();
/* 371 */         } else if (this.f.a.b(((cn)entry.getValue()).b)) {
/* 372 */           iterator = this.e.tailMap(entry.getKey(), true).values().iterator();
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 378 */           iterator = this.e.tailMap(this.f.g(), true).values().iterator();
/*     */         } 
/*     */       } 
/* 381 */       return new c<Map.Entry<T<C>, cn<C>>>(this, iterator)
/*     */         {
/*     */           protected Map.Entry<T<C>, cn<C>> b() {
/* 384 */             if (!this.G.hasNext()) {
/* 385 */               return c();
/*     */             }
/* 387 */             cn<C> cn = this.G.next();
/* 388 */             if ((dh.d.a(this.a)).b.b(cn.b)) {
/* 389 */               return c();
/*     */             }
/* 391 */             return bW.d(cn.b, cn);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Iterator<Map.Entry<T<C>, cn<C>>> f() {
/*     */       Collection<?> collection;
/* 400 */       if (this.f.cU()) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 405 */         collection = this.e.headMap(this.f.h(), false).descendingMap().values();
/*     */       } else {
/* 407 */         collection = this.e.descendingMap().values();
/*     */       } 
/* 409 */       ck<?> ck = bH.a(collection.iterator());
/* 410 */       if (ck.hasNext() && this.f.b
/* 411 */         .b(((cn)ck.peek()).b)) {
/* 412 */         ck.next();
/*     */       }
/* 414 */       return new c<Map.Entry<T<C>, cn<C>>>(this, ck)
/*     */         {
/*     */           protected Map.Entry<T<C>, cn<C>> b() {
/* 417 */             if (!this.b.hasNext()) {
/* 418 */               return c();
/*     */             }
/* 420 */             cn<C> cn = this.b.next();
/* 421 */             return (dh.d.a(this.a)).a.b(cn.b) ? 
/* 422 */               bW.<T<C>, cn<C>>d(cn.b, cn) : 
/* 423 */               c();
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 430 */       if (this.f.equals(cn.c())) {
/* 431 */         return this.e.size();
/*     */       }
/* 433 */       return bH.size(c());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 438 */       return this.f.equals(cn.c()) ? 
/* 439 */         this.e.isEmpty() : (
/* 440 */         !c().hasNext());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class c<C extends Comparable<?>>
/*     */     extends j<T<C>, cn<C>>
/*     */   {
/*     */     private final NavigableMap<T<C>, cn<C>> f;
/*     */     
/*     */     private final NavigableMap<T<C>, cn<C>> g;
/*     */     
/*     */     private final cn<T<C>> e;
/*     */ 
/*     */     
/*     */     c(NavigableMap<T<C>, cn<C>> param1NavigableMap) {
/* 457 */       this(param1NavigableMap, cn.c());
/*     */     }
/*     */ 
/*     */     
/*     */     private c(NavigableMap<T<C>, cn<C>> param1NavigableMap, cn<T<C>> param1cn) {
/* 462 */       this.f = param1NavigableMap;
/* 463 */       this.g = new dh.d<>(param1NavigableMap);
/* 464 */       this.e = param1cn;
/*     */     }
/*     */     
/*     */     private NavigableMap<T<C>, cn<C>> a(cn<T<C>> param1cn) {
/* 468 */       if (!this.e.c(param1cn)) {
/* 469 */         return bw.a();
/*     */       }
/* 471 */       param1cn = param1cn.a(this.e);
/* 472 */       return new c(this.f, param1cn);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> a(T<C> param1T1, boolean param1Boolean1, T<C> param1T2, boolean param1Boolean2) {
/* 479 */       return a(
/* 480 */           cn.a(param1T1, 
/* 481 */             x.a(param1Boolean1), param1T2, 
/* 482 */             x.a(param1Boolean2)));
/*     */     }
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> a(T<C> param1T, boolean param1Boolean) {
/* 487 */       return a(cn.a(param1T, x.a(param1Boolean)));
/*     */     }
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> b(T<C> param1T, boolean param1Boolean) {
/* 492 */       return a(cn.b(param1T, x.a(param1Boolean)));
/*     */     }
/*     */ 
/*     */     
/*     */     public Comparator<? super T<C>> comparator() {
/* 497 */       return cj.e();
/*     */     }
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
/*     */     Iterator<Map.Entry<T<C>, cn<C>>> c() {
/*     */       Collection<cn<C>> collection;
/*     */       T t;
/* 512 */       if (this.e.cT()) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 518 */         collection = this.g.tailMap(this.e.g(), (this.e.f() == x.b)).values();
/*     */       } else {
/* 520 */         collection = this.g.values();
/*     */       } 
/*     */       
/* 523 */       ck<?> ck = bH.a(collection.iterator());
/*     */       
/* 525 */       if (this.e.a((T)T.a()) && (
/* 526 */         !ck.hasNext() || ((cn)ck.peek()).a != T.a())) {
/* 527 */         t = T.a();
/* 528 */       } else if (ck.hasNext()) {
/* 529 */         t = ((cn)ck.next()).b;
/*     */       } else {
/* 531 */         return bH.g();
/*     */       } 
/* 533 */       return new c<Map.Entry<T<C>, cn<C>>>(this, t, ck) {
/* 534 */           T<C> c = this.d;
/*     */           
/*     */           protected Map.Entry<T<C>, cn<C>> b() {
/*     */             cn<C> cn;
/* 538 */             if ((dh.c.a(this.a)).b.b(this.c) || this.c == 
/* 539 */               T.b()) {
/* 540 */               return c();
/*     */             }
/*     */             
/* 543 */             if (this.a.hasNext()) {
/* 544 */               cn cn1 = this.a.next();
/* 545 */               cn = cn.a(this.c, cn1.a);
/* 546 */               this.c = cn1.b;
/*     */             } else {
/* 548 */               cn = cn.a(this.c, (T)T.b());
/* 549 */               this.c = T.b();
/*     */             } 
/* 551 */             return bW.d(cn.a, cn);
/*     */           }
/*     */         };
/*     */     }
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
/*     */     Iterator<Map.Entry<T<C>, cn<C>>> f() {
/*     */       T t1;
/* 569 */       T<C> t = this.e.cU() ? this.e.h() : T.<Comparable>b();
/*     */ 
/*     */       
/* 572 */       boolean bool = (this.e.cU() && this.e.g() == x.b) ? true : false;
/*     */       
/* 574 */       ck<?> ck = bH.a(this.g
/*     */           
/* 576 */           .headMap(t, bool)
/* 577 */           .descendingMap()
/* 578 */           .values()
/* 579 */           .iterator());
/*     */       
/* 581 */       if (ck.hasNext())
/*     */       
/*     */       { 
/*     */         
/* 585 */         t1 = (((cn)ck.peek()).b == T.b()) ? ((cn)ck.next()).a : this.f.higherKey(((cn)ck.peek()).b); }
/* 586 */       else { if (!this.e.a((T)T.a()) || this.f
/* 587 */           .containsKey(T.a())) {
/* 588 */           return bH.g();
/*     */         }
/* 590 */         t1 = this.f.higherKey((T)T.a()); }
/*     */ 
/*     */       
/* 593 */       T t2 = (T)x.a(t1, T.b());
/* 594 */       return new c<Map.Entry<T<C>, cn<C>>>(this, t2, ck) {
/* 595 */           T<C> e = this.f;
/*     */ 
/*     */           
/*     */           protected Map.Entry<T<C>, cn<C>> b() {
/* 599 */             if (this.e == T.a())
/* 600 */               return c(); 
/* 601 */             if (this.a.hasNext()) {
/* 602 */               cn cn = this.a.next();
/*     */               
/* 604 */               cn<C> cn1 = cn.a(cn.b, this.e);
/* 605 */               this.e = cn.a;
/* 606 */               if ((dh.c.a(this.a)).a.b(cn1.a)) {
/* 607 */                 return bW.d(cn1.a, cn1);
/*     */               }
/* 609 */             } else if ((dh.c.a(this.a)).a.b(T.a())) {
/* 610 */               cn<C> cn = cn.a((T)T.a(), this.e);
/* 611 */               this.e = T.a();
/* 612 */               return bW.d((T)T.a(), cn);
/*     */             } 
/* 614 */             return c();
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 621 */       return bH.size(c());
/*     */     }
/*     */ 
/*     */     
/*     */     public cn<C> a(Object param1Object) {
/* 626 */       if (param1Object instanceof T) {
/*     */         
/*     */         try {
/* 629 */           T<C> t = (T)param1Object;
/*     */           
/* 631 */           Map.Entry<T<C>, cn<C>> entry = b(t, true).firstEntry();
/* 632 */           if (entry != null && ((T)entry.getKey()).equals(t)) {
/* 633 */             return entry.getValue();
/*     */           }
/* 635 */         } catch (ClassCastException classCastException) {
/* 636 */           return null;
/*     */         } 
/*     */       }
/* 639 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 644 */       return (a(param1Object) != null);
/*     */     }
/*     */   }
/*     */   
/*     */   private final class b extends dh<C> {
/*     */     b(dh this$0) {
/* 650 */       super(new dh.c<>(this$0.e));
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(cn<C> param1cn) {
/* 655 */       this.a.b(param1cn);
/*     */     }
/*     */ 
/*     */     
/*     */     public void b(cn<C> param1cn) {
/* 660 */       this.a.a(param1cn);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean a(C param1C) {
/* 665 */       return !this.a.a((Comparable)param1C);
/*     */     }
/*     */ 
/*     */     
/*     */     public cq<C> a() {
/* 670 */       return this.a;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class f<C extends Comparable<?>>
/*     */     extends j<T<C>, cn<C>>
/*     */   {
/*     */     private final cn<T<C>> h;
/*     */ 
/*     */ 
/*     */     
/*     */     private final cn<C> g;
/*     */ 
/*     */     
/*     */     private final NavigableMap<T<C>, cn<C>> e;
/*     */ 
/*     */     
/*     */     private final NavigableMap<T<C>, cn<C>> h;
/*     */ 
/*     */ 
/*     */     
/*     */     private f(cn<T<C>> param1cn, cn<C> param1cn1, NavigableMap<T<C>, cn<C>> param1NavigableMap) {
/* 695 */       this.h = (NavigableMap<T<C>, cn<C>>)D.checkNotNull(param1cn);
/* 696 */       this.g = (cn<C>)D.checkNotNull(param1cn1);
/* 697 */       this.e = (NavigableMap<T<C>, cn<C>>)D.checkNotNull(param1NavigableMap);
/* 698 */       this.h = new dh.d<>(param1NavigableMap);
/*     */     }
/*     */     
/*     */     private NavigableMap<T<C>, cn<C>> a(cn<T<C>> param1cn) {
/* 702 */       if (!param1cn.c((cn)this.h)) {
/* 703 */         return bw.a();
/*     */       }
/* 705 */       return new f(this.h
/* 706 */           .a(param1cn), this.g, this.e);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> a(T<C> param1T1, boolean param1Boolean1, T<C> param1T2, boolean param1Boolean2) {
/* 713 */       return a(
/* 714 */           cn.a(param1T1, 
/*     */             
/* 716 */             x.a(param1Boolean1), param1T2, 
/*     */             
/* 718 */             x.a(param1Boolean2)));
/*     */     }
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> a(T<C> param1T, boolean param1Boolean) {
/* 723 */       return a(cn.a(param1T, x.a(param1Boolean)));
/*     */     }
/*     */ 
/*     */     
/*     */     public NavigableMap<T<C>, cn<C>> b(T<C> param1T, boolean param1Boolean) {
/* 728 */       return a(cn.b(param1T, x.a(param1Boolean)));
/*     */     }
/*     */ 
/*     */     
/*     */     public Comparator<? super T<C>> comparator() {
/* 733 */       return cj.e();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 738 */       return (a(param1Object) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public cn<C> a(Object param1Object) {
/* 743 */       if (param1Object instanceof T) {
/*     */         
/*     */         try {
/* 746 */           T<C> t = (T)param1Object;
/* 747 */           if (!this.h.a(t) || t
/* 748 */             .a(this.g.a) < 0 || t
/* 749 */             .a(this.g.b) >= 0)
/* 750 */             return null; 
/* 751 */           if (t.equals(this.g.a)) {
/*     */             
/* 753 */             cn cn1 = bW.<cn>c((Map.Entry)this.e.floorEntry(t));
/* 754 */             if (cn1 != null && cn1.b.a(this.g.a) > 0) {
/* 755 */               return cn1.a(this.g);
/*     */             }
/*     */           } else {
/* 758 */             cn cn1 = this.e.get(t);
/* 759 */             if (cn1 != null) {
/* 760 */               return cn1.a(this.g);
/*     */             }
/*     */           } 
/* 763 */         } catch (ClassCastException classCastException) {
/* 764 */           return null;
/*     */         } 
/*     */       }
/* 767 */       return null;
/*     */     }
/*     */     
/*     */     Iterator<Map.Entry<T<C>, cn<C>>> c() {
/*     */       Iterator iterator;
/* 772 */       if (this.g.isEmpty()) {
/* 773 */         return bH.g();
/*     */       }
/*     */       
/* 776 */       if (((cn)this.h).b.b((C)this.g.a))
/* 777 */         return bH.g(); 
/* 778 */       if (((cn)this.h).a.b((C)this.g.a)) {
/*     */ 
/*     */         
/* 781 */         iterator = this.h.tailMap(this.g.a, false).values().iterator();
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */         
/* 790 */         iterator = this.e.tailMap((T<C>)((cn)this.h).a.a(), (this.h.f() == x.b)).values().iterator();
/*     */       } 
/*     */ 
/*     */       
/* 794 */       T t = (T)cj.<Comparable>e().i(((cn)this.h).b, T.a(this.g.b));
/* 795 */       return new c<Map.Entry<T<C>, cn<C>>>(this, iterator, t)
/*     */         {
/*     */           protected Map.Entry<T<C>, cn<C>> b() {
/* 798 */             if (!this.H.hasNext()) {
/* 799 */               return c();
/*     */             }
/* 801 */             cn<C> cn = this.H.next();
/* 802 */             if (this.g.b(cn.a)) {
/* 803 */               return c();
/*     */             }
/* 805 */             cn = cn.a(dh.f.a(this.a));
/* 806 */             return bW.d(cn.a, cn);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Iterator<Map.Entry<T<C>, cn<C>>> f() {
/* 814 */       if (this.g.isEmpty()) {
/* 815 */         return bH.g();
/*     */       }
/*     */ 
/*     */       
/* 819 */       T<T<C>> t = (T)cj.<Comparable>e().i(((cn)this.h).b, T.a(this.g.b));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 827 */       Iterator iterator = this.e.headMap(t.a(), (t.c() == x.b)).descendingMap().values().iterator();
/* 828 */       return new c<Map.Entry<T<C>, cn<C>>>(this, iterator)
/*     */         {
/*     */           protected Map.Entry<T<C>, cn<C>> b() {
/* 831 */             if (!this.H.hasNext()) {
/* 832 */               return c();
/*     */             }
/* 834 */             cn<C> cn = this.H.next();
/* 835 */             if ((dh.f.a(this.a)).a.a(cn.b) >= 0) {
/* 836 */               return c();
/*     */             }
/* 838 */             cn = cn.a(dh.f.a(this.a));
/* 839 */             if (dh.f.b(this.a).a(cn.a)) {
/* 840 */               return bW.d(cn.a, cn);
/*     */             }
/* 842 */             return c();
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 850 */       return bH.size(c());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public cq<C> a(cn<C> paramcn) {
/* 856 */     return paramcn.equals(cn.c()) ? this : new e(this, paramcn);
/*     */   }
/*     */   
/*     */   private final class e extends dh<C> {
/*     */     private final cn<C> g;
/*     */     
/*     */     e(dh this$0, cn<C> param1cn) {
/* 863 */       super(new dh.f<>(
/*     */             
/* 865 */             cn.c(), param1cn, this$0.e, null));
/* 866 */       this.g = param1cn;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean b(cn<C> param1cn) {
/* 871 */       if (!this.g.isEmpty() && this.g.b(param1cn)) {
/* 872 */         cn cn1 = dh.a(this.a, param1cn);
/* 873 */         return (cn1 != null && !cn1.a(this.g).isEmpty());
/*     */       } 
/* 875 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public cn<C> a(C param1C) {
/* 880 */       if (!this.g.a(param1C)) {
/* 881 */         return null;
/*     */       }
/* 883 */       cn<C> cn1 = this.a.a(param1C);
/* 884 */       return (cn1 == null) ? null : cn1.a(this.g);
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(cn<C> param1cn) {
/* 889 */       D.a(this.g
/* 890 */           .b(param1cn), "Cannot add range %s to subRangeSet(%s)", param1cn, this.g);
/*     */ 
/*     */ 
/*     */       
/* 894 */       this.a.a(param1cn);
/*     */     }
/*     */ 
/*     */     
/*     */     public void b(cn<C> param1cn) {
/* 899 */       if (param1cn.c(this.g)) {
/* 900 */         this.a.b(param1cn.a(this.g));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean a(C param1C) {
/* 906 */       return (this.g.a(param1C) && this.a.a((Comparable)param1C));
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 911 */       this.a.b(this.g);
/*     */     }
/*     */ 
/*     */     
/*     */     public cq<C> a(cn<C> param1cn) {
/* 916 */       if (param1cn.b(this.g))
/* 917 */         return this; 
/* 918 */       if (param1cn.c(this.g)) {
/* 919 */         return new e(this, this.g.a(param1cn));
/*     */       }
/* 921 */       return (cq)bs.a();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\dh.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */