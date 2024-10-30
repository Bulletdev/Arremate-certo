/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
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
/*     */ 
/*     */ @b
/*     */ public abstract class cj<T>
/*     */   implements Comparator<T>
/*     */ {
/*     */   static final int fb = 1;
/*     */   static final int fc = -1;
/*     */   
/*     */   @b(ck = true)
/*     */   public static <C extends Comparable> cj<C> e() {
/* 162 */     return cf.a;
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
/*     */ 
/*     */   
/*     */   @b(ck = true)
/*     */   public static <T> cj<T> b(Comparator<T> paramComparator) {
/* 182 */     return (paramComparator instanceof cj) ? 
/* 183 */       (cj<T>)paramComparator : 
/* 184 */       new K<>(paramComparator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @b(ck = true)
/*     */   public static <T> cj<T> a(cj<T> paramcj) {
/* 195 */     return (cj<T>)D.checkNotNull(paramcj);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @b(ck = true)
/*     */   public static <T> cj<T> a(List<T> paramList) {
/* 220 */     return new ag<>(paramList);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @b(ck = true)
/*     */   public static <T> cj<T> a(T paramT, T... paramVarArgs) {
/* 246 */     return a(bS.a(paramT, paramVarArgs));
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
/*     */   @b(ck = true)
/*     */   public static cj<Object> f() {
/* 282 */     return r.a;
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
/*     */   @b(ck = true)
/*     */   public static cj<Object> g() {
/* 295 */     return dm.a;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static cj<Object> h() {
/* 315 */     return b.d;
/*     */   }
/*     */   
/*     */   private static class b {
/* 319 */     static final cj<Object> d = new cj.a();
/*     */   }
/*     */   
/*     */   @d
/*     */   static class a
/*     */     extends cj<Object> {
/* 325 */     private final AtomicInteger counter = new AtomicInteger(0);
/*     */     
/* 327 */     private final ConcurrentMap<Object, Integer> c = cl.a(new bU()).c();
/*     */     
/*     */     private Integer a(Object param1Object) {
/* 330 */       Integer integer = this.c.get(param1Object);
/* 331 */       if (integer == null) {
/*     */ 
/*     */ 
/*     */         
/* 335 */         integer = Integer.valueOf(this.counter.getAndIncrement());
/* 336 */         Integer integer1 = this.c.putIfAbsent(param1Object, integer);
/* 337 */         if (integer1 != null) {
/* 338 */           integer = integer1;
/*     */         }
/*     */       } 
/* 341 */       return integer;
/*     */     }
/*     */ 
/*     */     
/*     */     public int compare(Object param1Object1, Object param1Object2) {
/* 346 */       if (param1Object1 == param1Object2)
/* 347 */         return 0; 
/* 348 */       if (param1Object1 == null)
/* 349 */         return -1; 
/* 350 */       if (param1Object2 == null) {
/* 351 */         return 1;
/*     */       }
/* 353 */       int i = k(param1Object1);
/* 354 */       int j = k(param1Object2);
/* 355 */       if (i != j) {
/* 356 */         return (i < j) ? -1 : 1;
/*     */       }
/*     */ 
/*     */       
/* 360 */       int k = a(param1Object1).compareTo(a(param1Object2));
/* 361 */       if (k == 0) {
/* 362 */         throw new AssertionError();
/*     */       }
/* 364 */       return k;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 369 */       return "Ordering.arbitrary()";
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
/*     */     int k(Object param1Object) {
/* 381 */       return System.identityHashCode(param1Object);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @b(ck = true)
/*     */   public <S extends T> cj<S> a() {
/* 405 */     return new cC<>(this);
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
/*     */   @b(ck = true)
/*     */   public <S extends T> cj<S> c() {
/* 418 */     return new cg<>(this);
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
/*     */   @b(ck = true)
/*     */   public <S extends T> cj<S> d() {
/* 431 */     return new ch<>(this);
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
/*     */   @b(ck = true)
/*     */   public <F> cj<F> a(s<F, ? extends T> params) {
/* 449 */     return new y<>(params, this);
/*     */   }
/*     */   
/*     */   <T2 extends T> cj<Map.Entry<T2, ?>> i() {
/* 453 */     return a(bW.e());
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
/*     */   @b(ck = true)
/*     */   public <U extends T> cj<U> c(Comparator<? super U> paramComparator) {
/* 471 */     return new N<>(this, (Comparator<? super U>)D.checkNotNull(paramComparator));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @b(ck = true)
/*     */   public static <T> cj<T> a(Iterable<? extends Comparator<? super T>> paramIterable) {
/* 495 */     return new N<>(paramIterable);
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
/*     */   @b(ck = true)
/*     */   public <S extends T> cj<Iterable<S>> j() {
/* 525 */     return new bM<>(this);
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
/*     */   @com.google.b.a.a
/*     */   public abstract int compare(T paramT1, T paramT2);
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
/*     */   public <E extends T> E d(Iterator<E> paramIterator) {
/* 551 */     E e = paramIterator.next();
/*     */     
/* 553 */     while (paramIterator.hasNext()) {
/* 554 */       e = i(e, paramIterator.next());
/*     */     }
/*     */     
/* 557 */     return e;
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
/*     */   
/*     */   public <E extends T> E c(Iterable<E> paramIterable) {
/* 575 */     return d(paramIterable.iterator());
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
/*     */ 
/*     */   
/*     */   public <E extends T> E i(E paramE1, E paramE2) {
/* 594 */     return (compare((T)paramE1, (T)paramE2) <= 0) ? paramE1 : paramE2;
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
/*     */   
/*     */   public <E extends T> E a(E paramE1, E paramE2, E paramE3, E... paramVarArgs) {
/* 612 */     E e = (E)i(i((Object)paramE1, (Object)paramE2), (Object)paramE3);
/*     */     
/* 614 */     for (E e1 : paramVarArgs) {
/* 615 */       e = i((Object)e, (Object)e1);
/*     */     }
/*     */     
/* 618 */     return e;
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
/*     */ 
/*     */   
/*     */   public <E extends T> E e(Iterator<E> paramIterator) {
/* 637 */     E e = paramIterator.next();
/*     */     
/* 639 */     while (paramIterator.hasNext()) {
/* 640 */       e = j(e, paramIterator.next());
/*     */     }
/*     */     
/* 643 */     return e;
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
/*     */   
/*     */   public <E extends T> E d(Iterable<E> paramIterable) {
/* 661 */     return e(paramIterable.iterator());
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
/*     */ 
/*     */   
/*     */   public <E extends T> E j(E paramE1, E paramE2) {
/* 680 */     return (compare((T)paramE1, (T)paramE2) >= 0) ? paramE1 : paramE2;
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
/*     */   
/*     */   public <E extends T> E b(E paramE1, E paramE2, E paramE3, E... paramVarArgs) {
/* 698 */     E e = (E)j(j((Object)paramE1, (Object)paramE2), (Object)paramE3);
/*     */     
/* 700 */     for (E e1 : paramVarArgs) {
/* 701 */       e = j((Object)e, (Object)e1);
/*     */     }
/*     */     
/* 704 */     return e;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public <E extends T> List<E> a(Iterable<E> paramIterable, int paramInt) {
/* 724 */     if (paramIterable instanceof Collection) {
/* 725 */       Collection collection = (Collection)paramIterable;
/* 726 */       if (collection.size() <= 2L * paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 732 */         Object[] arrayOfObject = collection.toArray();
/* 733 */         Arrays.sort(arrayOfObject, this);
/* 734 */         if (arrayOfObject.length > paramInt) {
/* 735 */           arrayOfObject = Arrays.copyOf(arrayOfObject, paramInt);
/*     */         }
/* 737 */         return Collections.unmodifiableList(Arrays.asList((E[])arrayOfObject));
/*     */       } 
/*     */     } 
/* 740 */     return a(paramIterable.iterator(), paramInt);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public <E extends T> List<E> a(Iterator<E> paramIterator, int paramInt) {
/* 760 */     D.checkNotNull(paramIterator);
/* 761 */     C.b(paramInt, "k");
/*     */     
/* 763 */     if (paramInt == 0 || !paramIterator.hasNext())
/* 764 */       return Collections.emptyList(); 
/* 765 */     if (paramInt >= 1073741823) {
/*     */       
/* 767 */       ArrayList<E> arrayList = bS.a(paramIterator);
/* 768 */       Collections.sort(arrayList, this);
/* 769 */       if (arrayList.size() > paramInt) {
/* 770 */         arrayList.subList(paramInt, arrayList.size()).clear();
/*     */       }
/* 772 */       arrayList.trimToSize();
/* 773 */       return Collections.unmodifiableList(arrayList);
/*     */     } 
/* 775 */     da<?> da = da.b(paramInt, this);
/* 776 */     da.b(paramIterator);
/* 777 */     return (List)da.Y();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <E extends T> List<E> b(Iterable<E> paramIterable, int paramInt) {
/* 800 */     return a().a(paramIterable, paramInt);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public <E extends T> List<E> b(Iterator<E> paramIterator, int paramInt) {
/* 820 */     return a().a(paramIterator, paramInt);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <E extends T> List<E> b(Iterable<E> paramIterable) {
/* 841 */     Object[] arrayOfObject = bG.a(paramIterable);
/* 842 */     Arrays.sort(arrayOfObject, this);
/* 843 */     return bS.a(Arrays.asList((E[])arrayOfObject));
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
/*     */ 
/*     */ 
/*     */   
/*     */   public <E extends T> bh<E> a(Iterable<E> paramIterable) {
/* 863 */     return bh.a(this, paramIterable);
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
/*     */   public boolean a(Iterable<? extends T> paramIterable) {
/* 876 */     Iterator<? extends T> iterator = paramIterable.iterator();
/* 877 */     if (iterator.hasNext()) {
/* 878 */       T t = iterator.next();
/* 879 */       while (iterator.hasNext()) {
/* 880 */         T t2 = iterator.next();
/* 881 */         if (compare(t, t2) > 0) {
/* 882 */           return false;
/*     */         }
/* 884 */         T t1 = t2;
/*     */       } 
/*     */     } 
/* 887 */     return true;
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
/*     */   public boolean b(Iterable<? extends T> paramIterable) {
/* 900 */     Iterator<? extends T> iterator = paramIterable.iterator();
/* 901 */     if (iterator.hasNext()) {
/* 902 */       T t = iterator.next();
/* 903 */       while (iterator.hasNext()) {
/* 904 */         T t2 = iterator.next();
/* 905 */         if (compare(t, t2) >= 0) {
/* 906 */           return false;
/*     */         }
/* 908 */         T t1 = t2;
/*     */       } 
/*     */     } 
/* 911 */     return true;
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
/*     */   public int e(List<? extends T> paramList, T paramT) {
/* 924 */     return Collections.binarySearch(paramList, paramT, this);
/*     */   }
/*     */ 
/*     */   
/*     */   @d
/*     */   static class c
/*     */     extends ClassCastException
/*     */   {
/*     */     final Object value;
/*     */     
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     c(Object param1Object) {
/* 937 */       super((new StringBuilder(22 + String.valueOf(str).length())).append("Cannot compare value: ").append(str).toString());
/* 938 */       this.value = param1Object;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */