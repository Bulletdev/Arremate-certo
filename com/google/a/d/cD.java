/*      */ package com.google.a.d;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.E;
/*      */ import com.google.a.b.F;
/*      */ import com.google.a.b.y;
/*      */ import com.google.a.m.k;
/*      */ import java.io.Serializable;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.Iterator;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Objects;
/*      */ import java.util.Set;
/*      */ import java.util.Spliterator;
/*      */ import java.util.function.Function;
/*      */ import java.util.function.Supplier;
/*      */ import java.util.function.ToIntFunction;
/*      */ import java.util.stream.Collector;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @b
/*      */ public final class cd
/*      */ {
/*      */   public static <T, E, M extends cc<E>> Collector<T, ?, M> a(Function<? super T, E> paramFunction, ToIntFunction<? super T> paramToIntFunction, Supplier<M> paramSupplier) {
/*   79 */     D.checkNotNull(paramFunction);
/*   80 */     D.checkNotNull(paramToIntFunction);
/*   81 */     D.checkNotNull(paramSupplier);
/*   82 */     return (Collector)Collector.of(paramSupplier, (paramcc, paramObject) -> paramcc.add(paramFunction.apply(paramObject), paramToIntFunction.applyAsInt(paramObject)), (paramcc1, paramcc2) -> { paramcc1.addAll(paramcc2); return paramcc1; }new Collector.Characteristics[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> cc<E> a(cc<? extends E> paramcc) {
/*  102 */     if (paramcc instanceof h || paramcc instanceof bp)
/*      */     {
/*  104 */       return (cc)paramcc;
/*      */     }
/*      */     
/*  107 */     return new h<>((cc<? extends E>)D.checkNotNull(paramcc));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <E> cc<E> a(bp<E> parambp) {
/*  118 */     return (cc<E>)D.checkNotNull(parambp);
/*      */   }
/*      */   static class h<E> extends aF<E> implements Serializable { final cc<? extends E> c; transient Set<E> i;
/*      */     transient Set<cc.a<E>> entrySet;
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     h(cc<? extends E> param1cc) {
/*  125 */       this.c = param1cc;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected cc<E> d() {
/*  132 */       return (cc)this.c;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     Set<E> e() {
/*  138 */       return Collections.unmodifiableSet(this.c.d());
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<E> d() {
/*  143 */       Set<E> set = this.i;
/*  144 */       return (set == null) ? (this.i = e()) : set;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Set<cc.a<E>> entrySet() {
/*  152 */       Set<cc.a<E>> set = this.entrySet;
/*  153 */       return (set == null) ? (
/*      */ 
/*      */         
/*  156 */         this.entrySet = Collections.unmodifiableSet(this.c.entrySet())) : 
/*  157 */         set;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<E> iterator() {
/*  162 */       return bH.a(this.c.iterator());
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean add(E param1E) {
/*  167 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public int add(E param1E, int param1Int) {
/*  172 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean addAll(Collection<? extends E> param1Collection) {
/*  177 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  182 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public int remove(Object param1Object, int param1Int) {
/*  187 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean removeAll(Collection<?> param1Collection) {
/*  192 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> param1Collection) {
/*  197 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/*  202 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public int setCount(E param1E, int param1Int) {
/*  207 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean a(E param1E, int param1Int1, int param1Int2) {
/*  212 */       throw new UnsupportedOperationException();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static <E> cP<E> a(cP<E> paramcP) {
/*  232 */     return new dl<>((cP<E>)D.checkNotNull(paramcP));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> cc.a<E> a(E paramE, int paramInt) {
/*  244 */     return new f<>(paramE, paramInt);
/*      */   }
/*      */   
/*      */   static class f<E> extends a<E> implements Serializable { private final E element;
/*      */     private final int count;
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     f(E param1E, int param1Int) {
/*  252 */       this.element = param1E;
/*  253 */       this.count = param1Int;
/*  254 */       C.b(param1Int, "count");
/*      */     }
/*      */ 
/*      */     
/*      */     public final E getElement() {
/*  259 */       return this.element;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int getCount() {
/*  264 */       return this.count;
/*      */     }
/*      */     
/*      */     public f<E> a() {
/*  268 */       return null;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static <E> cc<E> a(cc<E> paramcc, E<? super E> paramE) {
/*  301 */     if (paramcc instanceof e) {
/*      */ 
/*      */       
/*  304 */       e e = (e)paramcc;
/*  305 */       E<? super E> e1 = F.a(e.a, paramE);
/*  306 */       return new e<>(e.f, e1);
/*      */     } 
/*  308 */     return new e<>(paramcc, paramE);
/*      */   }
/*      */   
/*      */   private static final class e<E> extends i<E> {
/*      */     final cc<E> f;
/*      */     final E<? super E> a;
/*      */     
/*      */     e(cc<E> param1cc, E<? super E> param1E) {
/*  316 */       this.f = (cc<E>)D.checkNotNull(param1cc);
/*  317 */       this.a = (E<? super E>)D.checkNotNull(param1E);
/*      */     }
/*      */ 
/*      */     
/*      */     public dj<E> b() {
/*  322 */       return bH.a(this.f.iterator(), this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     Set<E> e() {
/*  327 */       return cG.a(this.f.d(), this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     Iterator<E> e() {
/*  332 */       throw new AssertionError("should never be called");
/*      */     }
/*      */ 
/*      */     
/*      */     Set<cc.a<E>> createEntrySet() {
/*  337 */       return cG.a(this.f
/*  338 */           .entrySet(), new E<cc.a<E>>(this)
/*      */           {
/*      */             public boolean a(cc.a<E> param2a)
/*      */             {
/*  342 */               return this.a.a.b(param2a.getElement());
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*      */     Iterator<cc.a<E>> c() {
/*  349 */       throw new AssertionError("should never be called");
/*      */     }
/*      */ 
/*      */     
/*      */     public int b(Object param1Object) {
/*  354 */       int j = this.f.b(param1Object);
/*  355 */       if (j > 0) {
/*      */         
/*  357 */         Object object = param1Object;
/*  358 */         return this.a.b(object) ? j : 0;
/*      */       } 
/*  360 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public int add(E param1E, int param1Int) {
/*  365 */       D.a(this.a
/*  366 */           .b(param1E), "Element %s does not match predicate %s", param1E, this.a);
/*  367 */       return this.f.add(param1E, param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public int remove(Object param1Object, int param1Int) {
/*  372 */       C.b(param1Int, "occurrences");
/*  373 */       if (param1Int == 0) {
/*  374 */         return b(param1Object);
/*      */       }
/*  376 */       return contains(param1Object) ? this.f.remove(param1Object, param1Int) : 0;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static int b(Iterable<?> paramIterable) {
/*  387 */     if (paramIterable instanceof cc) {
/*  388 */       return ((cc)paramIterable).d().size();
/*      */     }
/*  390 */     return 11;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static <E> cc<E> c(cc<? extends E> paramcc1, cc<? extends E> paramcc2) {
/*  408 */     D.checkNotNull(paramcc1);
/*  409 */     D.checkNotNull(paramcc2);
/*      */     
/*  411 */     return new i<E>(paramcc1, paramcc2)
/*      */       {
/*      */         public boolean contains(Object param1Object) {
/*  414 */           return (this.d.contains(param1Object) || this.e.contains(param1Object));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean isEmpty() {
/*  419 */           return (this.d.isEmpty() && this.e.isEmpty());
/*      */         }
/*      */ 
/*      */         
/*      */         public int b(Object param1Object) {
/*  424 */           return Math.max(this.d.b(param1Object), this.e.b(param1Object));
/*      */         }
/*      */ 
/*      */         
/*      */         Set<E> e() {
/*  429 */           return cG.a(this.d.d(), this.e.d());
/*      */         }
/*      */ 
/*      */         
/*      */         Iterator<E> e() {
/*  434 */           throw new AssertionError("should never be called");
/*      */         }
/*      */ 
/*      */         
/*      */         Iterator<cc.a<E>> c() {
/*  439 */           Iterator iterator1 = this.d.entrySet().iterator();
/*  440 */           Iterator iterator2 = this.e.entrySet().iterator();
/*      */           
/*  442 */           return new c(this, iterator1, iterator2)
/*      */             {
/*      */               protected cc.a<E> f() {
/*  445 */                 if (this.s.hasNext()) {
/*  446 */                   cc.a<Object> a = this.s.next();
/*  447 */                   E e = (E)a.getElement();
/*  448 */                   int i = Math.max(a.getCount(), this.a.e.b(e));
/*  449 */                   return cd.a(e, i);
/*      */                 } 
/*  451 */                 while (this.t.hasNext()) {
/*  452 */                   cc.a<Object> a = this.t.next();
/*  453 */                   E e = (E)a.getElement();
/*  454 */                   if (!this.a.d.contains(e)) {
/*  455 */                     return cd.a(e, a.getCount());
/*      */                   }
/*      */                 } 
/*  458 */                 return c();
/*      */               }
/*      */             };
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> cc<E> d(cc<E> paramcc, cc<?> paramcc1) {
/*  479 */     D.checkNotNull(paramcc);
/*  480 */     D.checkNotNull(paramcc1);
/*      */     
/*  482 */     return new i<E>(paramcc, paramcc1)
/*      */       {
/*      */         public int b(Object param1Object) {
/*  485 */           int j = this.d.b(param1Object);
/*  486 */           return (j == 0) ? 0 : Math.min(j, this.e.b(param1Object));
/*      */         }
/*      */ 
/*      */         
/*      */         Set<E> e() {
/*  491 */           return cG.b(this.d.d(), this.e.d());
/*      */         }
/*      */ 
/*      */         
/*      */         Iterator<E> e() {
/*  496 */           throw new AssertionError("should never be called");
/*      */         }
/*      */ 
/*      */         
/*      */         Iterator<cc.a<E>> c() {
/*  501 */           Iterator iterator = this.d.entrySet().iterator();
/*      */           
/*  503 */           return new c(this, iterator)
/*      */             {
/*      */               protected cc.a<E> f() {
/*  506 */                 while (this.s.hasNext()) {
/*  507 */                   cc.a<Object> a = this.s.next();
/*  508 */                   E e = (E)a.getElement();
/*  509 */                   int i = Math.min(a.getCount(), this.a.e.b(e));
/*  510 */                   if (i > 0) {
/*  511 */                     return cd.a(e, i);
/*      */                   }
/*      */                 } 
/*  514 */                 return c();
/*      */               }
/*      */             };
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static <E> cc<E> e(cc<? extends E> paramcc1, cc<? extends E> paramcc2) {
/*  536 */     D.checkNotNull(paramcc1);
/*  537 */     D.checkNotNull(paramcc2);
/*      */ 
/*      */     
/*  540 */     return new i<E>(paramcc1, paramcc2)
/*      */       {
/*      */         public boolean contains(Object param1Object) {
/*  543 */           return (this.d.contains(param1Object) || this.e.contains(param1Object));
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean isEmpty() {
/*  548 */           return (this.d.isEmpty() && this.e.isEmpty());
/*      */         }
/*      */ 
/*      */         
/*      */         public int size() {
/*  553 */           return com.google.a.k.e.v(this.d.size(), this.e.size());
/*      */         }
/*      */ 
/*      */         
/*      */         public int b(Object param1Object) {
/*  558 */           return this.d.b(param1Object) + this.e.b(param1Object);
/*      */         }
/*      */ 
/*      */         
/*      */         Set<E> e() {
/*  563 */           return cG.a(this.d.d(), this.e.d());
/*      */         }
/*      */ 
/*      */         
/*      */         Iterator<E> e() {
/*  568 */           throw new AssertionError("should never be called");
/*      */         }
/*      */ 
/*      */         
/*      */         Iterator<cc.a<E>> c() {
/*  573 */           Iterator iterator1 = this.d.entrySet().iterator();
/*  574 */           Iterator iterator2 = this.e.entrySet().iterator();
/*  575 */           return new c(this, iterator1, iterator2)
/*      */             {
/*      */               protected cc.a<E> f() {
/*  578 */                 if (this.s.hasNext()) {
/*  579 */                   cc.a<Object> a = this.s.next();
/*  580 */                   E e = (E)a.getElement();
/*  581 */                   int i = a.getCount() + this.a.e.b(e);
/*  582 */                   return cd.a(e, i);
/*      */                 } 
/*  584 */                 while (this.t.hasNext()) {
/*  585 */                   cc.a<Object> a = this.t.next();
/*  586 */                   E e = (E)a.getElement();
/*  587 */                   if (!this.a.d.contains(e)) {
/*  588 */                     return cd.a(e, a.getCount());
/*      */                   }
/*      */                 } 
/*  591 */                 return c();
/*      */               }
/*      */             };
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static <E> cc<E> f(cc<E> paramcc, cc<?> paramcc1) {
/*  613 */     D.checkNotNull(paramcc);
/*  614 */     D.checkNotNull(paramcc1);
/*      */ 
/*      */     
/*  617 */     return new i<E>(paramcc, paramcc1)
/*      */       {
/*      */         public int b(Object param1Object) {
/*  620 */           int j = this.d.b(param1Object);
/*  621 */           return (j == 0) ? 0 : Math.max(0, j - this.e.b(param1Object));
/*      */         }
/*      */ 
/*      */         
/*      */         public void clear() {
/*  626 */           throw new UnsupportedOperationException();
/*      */         }
/*      */ 
/*      */         
/*      */         Iterator<E> e() {
/*  631 */           Iterator iterator = this.d.entrySet().iterator();
/*  632 */           return new c(this, iterator)
/*      */             {
/*      */               protected E b() {
/*  635 */                 while (this.s.hasNext()) {
/*  636 */                   cc.a<Object> a = this.s.next();
/*  637 */                   E e = (E)a.getElement();
/*  638 */                   if (a.getCount() > this.a.e.b(e)) {
/*  639 */                     return e;
/*      */                   }
/*      */                 } 
/*  642 */                 return c();
/*      */               }
/*      */             };
/*      */         }
/*      */ 
/*      */         
/*      */         Iterator<cc.a<E>> c() {
/*  649 */           Iterator iterator = this.d.entrySet().iterator();
/*  650 */           return new c(this, iterator)
/*      */             {
/*      */               protected cc.a<E> f() {
/*  653 */                 while (this.s.hasNext()) {
/*  654 */                   cc.a<Object> a = this.s.next();
/*  655 */                   E e = (E)a.getElement();
/*  656 */                   int i = a.getCount() - this.a.e.b(e);
/*  657 */                   if (i > 0) {
/*  658 */                     return cd.a(e, i);
/*      */                   }
/*      */                 } 
/*  661 */                 return c();
/*      */               }
/*      */             };
/*      */         }
/*      */ 
/*      */         
/*      */         int ah() {
/*  668 */           return bH.size(c());
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public static boolean a(cc<?> paramcc1, cc<?> paramcc2) {
/*  681 */     D.checkNotNull(paramcc1);
/*  682 */     D.checkNotNull(paramcc2);
/*  683 */     for (cc.a<?> a : paramcc2.entrySet()) {
/*  684 */       int i = paramcc1.b(a.getElement());
/*  685 */       if (i < a.getCount()) {
/*  686 */         return false;
/*      */       }
/*      */     } 
/*  689 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public static boolean b(cc<?> paramcc1, cc<?> paramcc2) {
/*  711 */     return c(paramcc1, paramcc2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static <E> boolean c(cc<E> paramcc, cc<?> paramcc1) {
/*  717 */     D.checkNotNull(paramcc);
/*  718 */     D.checkNotNull(paramcc1);
/*      */     
/*  720 */     Iterator<cc.a> iterator = paramcc.entrySet().iterator();
/*  721 */     boolean bool = false;
/*  722 */     while (iterator.hasNext()) {
/*  723 */       cc.a<E> a = iterator.next();
/*  724 */       int i = paramcc1.b(a.getElement());
/*  725 */       if (i == 0) {
/*  726 */         iterator.remove();
/*  727 */         bool = true; continue;
/*  728 */       }  if (i < a.getCount()) {
/*  729 */         paramcc.setCount(a.getElement(), i);
/*  730 */         bool = true;
/*      */       } 
/*      */     } 
/*  733 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public static boolean a(cc<?> paramcc, Iterable<?> paramIterable) {
/*  762 */     if (paramIterable instanceof cc) {
/*  763 */       return d(paramcc, (cc)paramIterable);
/*      */     }
/*  765 */     D.checkNotNull(paramcc);
/*  766 */     D.checkNotNull(paramIterable);
/*  767 */     boolean bool = false;
/*  768 */     for (Object object : paramIterable) {
/*  769 */       bool |= paramcc.remove(object);
/*      */     }
/*  771 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public static boolean d(cc<?> paramcc1, cc<?> paramcc2) {
/*  800 */     D.checkNotNull(paramcc1);
/*  801 */     D.checkNotNull(paramcc2);
/*      */     
/*  803 */     boolean bool = false;
/*  804 */     Iterator<cc.a> iterator = paramcc1.entrySet().iterator();
/*  805 */     while (iterator.hasNext()) {
/*  806 */       cc.a a = iterator.next();
/*  807 */       int i = paramcc2.b(a.getElement());
/*  808 */       if (i >= a.getCount()) {
/*  809 */         iterator.remove();
/*  810 */         bool = true; continue;
/*  811 */       }  if (i > 0) {
/*  812 */         paramcc1.remove(a.getElement(), i);
/*  813 */         bool = true;
/*      */       } 
/*      */     } 
/*  816 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static abstract class a<E>
/*      */     implements cc.a<E>
/*      */   {
/*      */     public boolean equals(Object param1Object) {
/*  830 */       if (param1Object instanceof cc.a) {
/*  831 */         cc.a a1 = (cc.a)param1Object;
/*  832 */         return (getCount() == a1.getCount() && 
/*  833 */           y.equal(getElement(), a1.getElement()));
/*      */       } 
/*  835 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  844 */       E e = getElement();
/*  845 */       return ((e == null) ? 0 : e.hashCode()) ^ getCount();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  856 */       String str = String.valueOf(getElement());
/*  857 */       int i = getCount();
/*  858 */       return (i == 1) ? str : (new StringBuilder(14 + String.valueOf(str).length())).append(str).append(" x ").append(i).toString();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static boolean a(cc<?> paramcc, Object paramObject) {
/*  864 */     if (paramObject == paramcc) {
/*  865 */       return true;
/*      */     }
/*  867 */     if (paramObject instanceof cc) {
/*  868 */       cc cc1 = (cc)paramObject;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  875 */       if (paramcc.size() != cc1.size() || paramcc.entrySet().size() != cc1.entrySet().size()) {
/*  876 */         return false;
/*      */       }
/*  878 */       for (cc.a a : cc1.entrySet()) {
/*  879 */         if (paramcc.b(a.getElement()) != a.getCount()) {
/*  880 */           return false;
/*      */         }
/*      */       } 
/*  883 */       return true;
/*      */     } 
/*  885 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   static <E> boolean a(cc<E> paramcc, Collection<? extends E> paramCollection) {
/*  890 */     D.checkNotNull(paramcc);
/*  891 */     D.checkNotNull(paramCollection);
/*  892 */     if (paramCollection instanceof cc)
/*  893 */       return e(paramcc, a(paramCollection)); 
/*  894 */     if (paramCollection.isEmpty()) {
/*  895 */       return false;
/*      */     }
/*  897 */     return bH.addAll(paramcc, paramCollection.iterator());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static <E> boolean e(cc<E> paramcc, cc<? extends E> paramcc1) {
/*  903 */     if (paramcc1.isEmpty()) {
/*  904 */       return false;
/*      */     }
/*  906 */     Objects.requireNonNull(paramcc); paramcc1.a(paramcc::add);
/*  907 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean b(cc<?> paramcc, Collection<?> paramCollection) {
/*  915 */     Collection<?> collection = (paramCollection instanceof cc) ? ((cc)paramCollection).d() : paramCollection;
/*      */     
/*  917 */     return paramcc.d().removeAll(collection);
/*      */   }
/*      */ 
/*      */   
/*      */   static boolean c(cc<?> paramcc, Collection<?> paramCollection) {
/*  922 */     D.checkNotNull(paramCollection);
/*      */ 
/*      */ 
/*      */     
/*  926 */     Collection<?> collection = (paramCollection instanceof cc) ? ((cc)paramCollection).d() : paramCollection;
/*      */     
/*  928 */     return paramcc.d().retainAll(collection);
/*      */   }
/*      */ 
/*      */   
/*      */   static <E> int a(cc<E> paramcc, E paramE, int paramInt) {
/*  933 */     C.b(paramInt, "count");
/*      */     
/*  935 */     int i = paramcc.b(paramE);
/*      */     
/*  937 */     int j = paramInt - i;
/*  938 */     if (j > 0) {
/*  939 */       paramcc.add(paramE, j);
/*  940 */     } else if (j < 0) {
/*  941 */       paramcc.remove(paramE, -j);
/*      */     } 
/*      */     
/*  944 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   static <E> boolean a(cc<E> paramcc, E paramE, int paramInt1, int paramInt2) {
/*  949 */     C.b(paramInt1, "oldCount");
/*  950 */     C.b(paramInt2, "newCount");
/*      */     
/*  952 */     if (paramcc.b(paramE) == paramInt1) {
/*  953 */       paramcc.setCount(paramE, paramInt2);
/*  954 */       return true;
/*      */     } 
/*  956 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   static <E> Iterator<E> e(Iterator<cc.a<E>> paramIterator) {
/*  961 */     return new db<cc.a<E>, E>(paramIterator)
/*      */       {
/*      */         E a(cc.a<E> param1a) {
/*  964 */           return param1a.getElement();
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   static abstract class c<E>
/*      */     extends cG.g<E> {
/*      */     abstract cc<E> c();
/*      */     
/*      */     public void clear() {
/*  974 */       c().clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/*  979 */       return c().contains(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> param1Collection) {
/*  984 */       return c().containsAll(param1Collection);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/*  989 */       return c().isEmpty();
/*      */     }
/*      */ 
/*      */     
/*      */     public abstract Iterator<E> iterator();
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  997 */       return (c().remove(param1Object, 2147483647) > 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1002 */       return c().entrySet().size();
/*      */     }
/*      */   }
/*      */   
/*      */   static abstract class d<E>
/*      */     extends cG.g<cc.a<E>> {
/*      */     abstract cc<E> c();
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1011 */       if (param1Object instanceof cc.a) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1016 */         cc.a a = (cc.a)param1Object;
/* 1017 */         if (a.getCount() <= 0) {
/* 1018 */           return false;
/*      */         }
/* 1020 */         int i = c().b(a.getElement());
/* 1021 */         return (i == a.getCount());
/*      */       } 
/* 1023 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1030 */       if (param1Object instanceof cc.a) {
/* 1031 */         cc.a<Object> a = (cc.a)param1Object;
/* 1032 */         E e = (E)a.getElement();
/* 1033 */         int i = a.getCount();
/* 1034 */         if (i != 0) {
/*      */ 
/*      */           
/* 1037 */           cc<E> cc = c();
/* 1038 */           return cc.a(e, i, 0);
/*      */         } 
/*      */       } 
/* 1041 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1046 */       c().clear();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static <E> Iterator<E> a(cc<E> paramcc) {
/* 1052 */     return new g<>(paramcc, paramcc.entrySet().iterator());
/*      */   }
/*      */ 
/*      */   
/*      */   static final class g<E>
/*      */     implements Iterator<E>
/*      */   {
/*      */     private final cc<E> g;
/*      */     
/*      */     private final Iterator<cc.a<E>> entryIterator;
/*      */     
/*      */     private cc.a<E> b;
/*      */     private int eZ;
/*      */     private int fa;
/*      */     private boolean canRemove;
/*      */     
/*      */     g(cc<E> param1cc, Iterator<cc.a<E>> param1Iterator) {
/* 1069 */       this.g = param1cc;
/* 1070 */       this.entryIterator = param1Iterator;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/* 1075 */       return (this.eZ > 0 || this.entryIterator.hasNext());
/*      */     }
/*      */ 
/*      */     
/*      */     public E next() {
/* 1080 */       if (!hasNext()) {
/* 1081 */         throw new NoSuchElementException();
/*      */       }
/* 1083 */       if (this.eZ == 0) {
/* 1084 */         this.b = this.entryIterator.next();
/* 1085 */         this.fa = this.eZ = this.b.getCount();
/*      */       } 
/* 1087 */       this.eZ--;
/* 1088 */       this.canRemove = true;
/* 1089 */       return this.b.getElement();
/*      */     }
/*      */ 
/*      */     
/*      */     public void remove() {
/* 1094 */       C.ad(this.canRemove);
/* 1095 */       if (this.fa == 1) {
/* 1096 */         this.entryIterator.remove();
/*      */       } else {
/* 1098 */         this.g.remove(this.b.getElement());
/*      */       } 
/* 1100 */       this.fa--;
/* 1101 */       this.canRemove = false;
/*      */     }
/*      */   }
/*      */   
/*      */   static <E> Spliterator<E> a(cc<E> paramcc) {
/* 1106 */     Spliterator<?> spliterator = paramcc.entrySet().spliterator();
/* 1107 */     return D.a(spliterator, parama -> Collections.nCopies(parama.getCount(), parama.getElement()).spliterator(), 0x40 | spliterator
/*      */ 
/*      */ 
/*      */         
/* 1111 */         .characteristics() & 0x510, paramcc
/*      */         
/* 1113 */         .size());
/*      */   }
/*      */ 
/*      */   
/*      */   static int a(cc<?> paramcc) {
/* 1118 */     long l = 0L;
/* 1119 */     for (cc.a<?> a : paramcc.entrySet()) {
/* 1120 */       l += a.getCount();
/*      */     }
/* 1122 */     return k.e(l);
/*      */   }
/*      */ 
/*      */   
/*      */   static <T> cc<T> a(Iterable<T> paramIterable) {
/* 1127 */     return (cc<T>)paramIterable;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static <E> bp<E> b(cc<E> paramcc) {
/* 1138 */     cc.a[] arrayOfA = (cc.a[])paramcc.entrySet().toArray((Object[])new cc.a[0]);
/* 1139 */     Arrays.sort(arrayOfA, b.a);
/* 1140 */     return bp.a(Arrays.asList((cc.a<? extends E>[])arrayOfA));
/*      */   }
/*      */   
/*      */   private static final class b implements Comparator<cc.a<?>> {
/* 1144 */     static final b a = new b();
/*      */ 
/*      */     
/*      */     public int a(cc.a<?> param1a1, cc.a<?> param1a2) {
/* 1148 */       return param1a2.getCount() - param1a1.getCount();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static abstract class i<E>
/*      */     extends i<E>
/*      */   {
/*      */     private i() {}
/*      */     
/*      */     public int size() {
/* 1159 */       return cd.a(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1164 */       d().clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<E> iterator() {
/* 1169 */       return cd.a(this);
/*      */     }
/*      */ 
/*      */     
/*      */     int ah() {
/* 1174 */       return d().size();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */