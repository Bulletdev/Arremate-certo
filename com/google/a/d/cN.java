/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.E;
/*     */ import com.google.a.b.s;
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.SortedSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class cn<C extends Comparable>
/*     */   extends co
/*     */   implements E<C>, Serializable
/*     */ {
/*     */   static class a
/*     */     implements s<cn, T>
/*     */   {
/* 124 */     static final a a = new a();
/*     */ 
/*     */     
/*     */     public T a(cn param1cn) {
/* 128 */       return param1cn.a;
/*     */     }
/*     */   }
/*     */   
/*     */   static class c implements s<cn, T> {
/* 133 */     static final c a = new c();
/*     */ 
/*     */     
/*     */     public T a(cn param1cn) {
/* 137 */       return param1cn.b;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static <C extends Comparable<?>> s<cn<C>, T<C>> g() {
/* 143 */     return a.a;
/*     */   }
/*     */ 
/*     */   
/*     */   static <C extends Comparable<?>> s<cn<C>, T<C>> h() {
/* 148 */     return c.a;
/*     */   }
/*     */   
/*     */   static <C extends Comparable<?>> cj<cn<C>> k() {
/* 152 */     return (cj)b.e;
/*     */   }
/*     */   
/*     */   static <C extends Comparable<?>> cn<C> a(T<C> paramT1, T<C> paramT2) {
/* 156 */     return (cn)new cn<>(paramT1, paramT2);
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
/*     */   public static <C extends Comparable<?>> cn<C> a(C paramC1, C paramC2) {
/* 169 */     return a((T)T.b((Comparable)paramC1), (T)T.a((Comparable)paramC2));
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
/*     */   public static <C extends Comparable<?>> cn<C> b(C paramC1, C paramC2) {
/* 181 */     return a((T)T.a((Comparable)paramC1), (T)T.b((Comparable)paramC2));
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
/*     */   public static <C extends Comparable<?>> cn<C> c(C paramC1, C paramC2) {
/* 193 */     return a((T)T.a((Comparable)paramC1), (T)T.a((Comparable)paramC2));
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
/*     */   public static <C extends Comparable<?>> cn<C> d(C paramC1, C paramC2) {
/* 205 */     return a((T)T.b((Comparable)paramC1), (T)T.b((Comparable)paramC2));
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
/*     */   public static <C extends Comparable<?>> cn<C> a(C paramC1, x paramx1, C paramC2, x paramx2) {
/* 218 */     D.checkNotNull(paramx1);
/* 219 */     D.checkNotNull(paramx2);
/*     */ 
/*     */     
/* 222 */     T<C> t1 = (paramx1 == x.a) ? (T)T.<Comparable>b((Comparable)paramC1) : (T)T.<Comparable>a((Comparable)paramC1);
/*     */     
/* 224 */     T<C> t2 = (paramx2 == x.a) ? (T)T.<Comparable>a((Comparable)paramC2) : (T)T.<Comparable>b((Comparable)paramC2);
/* 225 */     return a(t1, t2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> cn<C> b(C paramC) {
/* 234 */     return a((T)T.a(), (T)T.a((Comparable)paramC));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> cn<C> c(C paramC) {
/* 243 */     return a((T)T.a(), (T)T.b((Comparable)paramC));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> cn<C> a(C paramC, x paramx) {
/* 253 */     switch (null.I[paramx.ordinal()]) {
/*     */       case 1:
/* 255 */         return b(paramC);
/*     */       case 2:
/* 257 */         return c(paramC);
/*     */     } 
/* 259 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> cn<C> d(C paramC) {
/* 269 */     return a((T)T.b((Comparable)paramC), (T)T.b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> cn<C> e(C paramC) {
/* 278 */     return a((T)T.a((Comparable)paramC), (T)T.b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> cn<C> b(C paramC, x paramx) {
/* 288 */     switch (null.I[paramx.ordinal()]) {
/*     */       case 1:
/* 290 */         return d(paramC);
/*     */       case 2:
/* 292 */         return e(paramC);
/*     */     } 
/* 294 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */   
/* 298 */   private static final cn<Comparable> b = new cn((T)T.a(), (T)T.b());
/*     */   
/*     */   final T<C> a;
/*     */   
/*     */   final T<C> b;
/*     */   
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <C extends Comparable<?>> cn<C> c() {
/* 307 */     return (cn<C>)b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> cn<C> f(C paramC) {
/* 317 */     return b(paramC, paramC);
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
/*     */   public static <C extends Comparable<?>> cn<C> a(Iterable<C> paramIterable) {
/* 330 */     D.checkNotNull(paramIterable);
/* 331 */     if (paramIterable instanceof SortedSet) {
/* 332 */       SortedSet<C> sortedSet = a(paramIterable);
/* 333 */       Comparator<? super C> comparator = sortedSet.comparator();
/* 334 */       if (cj.<Comparable>e().equals(comparator) || comparator == null) {
/* 335 */         return b(sortedSet.first(), sortedSet.last());
/*     */       }
/*     */     } 
/* 338 */     Iterator<C> iterator = paramIterable.iterator();
/* 339 */     Comparable comparable1 = (Comparable)D.checkNotNull((Comparable)iterator.next());
/* 340 */     Comparable comparable2 = comparable1;
/* 341 */     while (iterator.hasNext()) {
/* 342 */       Comparable comparable = (Comparable)D.checkNotNull((Comparable)iterator.next());
/* 343 */       comparable1 = (Comparable)cj.<Comparable>e().i(comparable1, comparable);
/* 344 */       comparable2 = (Comparable)cj.<Comparable>e().j(comparable2, comparable);
/*     */     } 
/* 346 */     return b((C)comparable1, (C)comparable2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private cn(T<C> paramT1, T<C> paramT2) {
/* 353 */     this.a = (T<C>)D.checkNotNull(paramT1);
/* 354 */     this.b = (T<C>)D.checkNotNull(paramT2);
/* 355 */     if (paramT1.a(paramT2) > 0 || paramT1 == 
/* 356 */       T.b() || paramT2 == 
/* 357 */       T.a()) {
/* 358 */       String.valueOf(a(paramT1, paramT2)); throw new IllegalArgumentException((String.valueOf(a(paramT1, paramT2)).length() != 0) ? "Invalid range: ".concat(String.valueOf(a(paramT1, paramT2))) : new String("Invalid range: "));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean cT() {
/* 364 */     return (this.a != T.a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public C g() {
/* 374 */     return this.a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public x f() {
/* 385 */     return this.a.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean cU() {
/* 390 */     return (this.b != T.b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public C h() {
/* 400 */     return this.b.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public x g() {
/* 411 */     return this.b.c();
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
/*     */   public boolean isEmpty() {
/* 424 */     return this.a.equals(this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(C paramC) {
/* 433 */     D.checkNotNull(paramC);
/*     */     
/* 435 */     return (this.a.b(paramC) && !this.b.b(paramC));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean c(C paramC) {
/* 445 */     return a(paramC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean c(Iterable<? extends C> paramIterable) {
/* 453 */     if (bG.isEmpty(paramIterable)) {
/* 454 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 458 */     if (paramIterable instanceof SortedSet) {
/* 459 */       SortedSet<? extends C> sortedSet = a(paramIterable);
/* 460 */       Comparator<? super C> comparator = sortedSet.comparator();
/* 461 */       if (cj.<Comparable>e().equals(comparator) || comparator == null) {
/* 462 */         return (a(sortedSet.first()) && a(sortedSet.last()));
/*     */       }
/*     */     } 
/*     */     
/* 466 */     for (Comparable comparable : paramIterable) {
/* 467 */       if (!a((C)comparable)) {
/* 468 */         return false;
/*     */       }
/*     */     } 
/* 471 */     return true;
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
/*     */   public boolean b(cn<C> paramcn) {
/* 498 */     return (this.a.a(paramcn.a) <= 0 && this.b
/* 499 */       .a(paramcn.b) >= 0);
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
/*     */   public boolean c(cn<C> paramcn) {
/* 528 */     return (this.a.a(paramcn.b) <= 0 && paramcn.a
/* 529 */       .a(this.b) <= 0);
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
/*     */   public cn<C> a(cn<C> paramcn) {
/* 549 */     int i = this.a.a(paramcn.a);
/* 550 */     int j = this.b.a(paramcn.b);
/* 551 */     if (i >= 0 && j <= 0)
/* 552 */       return this; 
/* 553 */     if (i <= 0 && j >= 0) {
/* 554 */       return paramcn;
/*     */     }
/* 556 */     T<C> t1 = (i >= 0) ? this.a : paramcn.a;
/* 557 */     T<C> t2 = (j <= 0) ? this.b : paramcn.b;
/* 558 */     return (cn)a(t1, t2);
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
/*     */   public cn<C> b(cn<C> paramcn) {
/* 590 */     if (this.a.a(paramcn.b) < 0 && paramcn.a
/* 591 */       .a(this.b) < 0) {
/* 592 */       String str1 = String.valueOf(this), str2 = String.valueOf(paramcn); throw new IllegalArgumentException((new StringBuilder(39 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Ranges have a nonempty intersection: ").append(str1).append(", ").append(str2).toString());
/*     */     } 
/*     */ 
/*     */     
/* 596 */     boolean bool = (this.a.a(paramcn.a) < 0) ? true : false;
/* 597 */     cn cn1 = bool ? this : paramcn;
/* 598 */     cn cn2 = bool ? paramcn : this;
/* 599 */     return (cn)a(cn1.b, cn2.a);
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
/*     */   public cn<C> c(cn<C> paramcn) {
/* 614 */     int i = this.a.a(paramcn.a);
/* 615 */     int j = this.b.a(paramcn.b);
/* 616 */     if (i <= 0 && j >= 0)
/* 617 */       return this; 
/* 618 */     if (i >= 0 && j <= 0) {
/* 619 */       return paramcn;
/*     */     }
/* 621 */     T<C> t1 = (i <= 0) ? this.a : paramcn.a;
/* 622 */     T<C> t2 = (j >= 0) ? this.b : paramcn.b;
/* 623 */     return (cn)a(t1, t2);
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
/*     */   public cn<C> a(Y<C> paramY) {
/* 652 */     D.checkNotNull(paramY);
/* 653 */     T<C> t1 = this.a.a(paramY);
/* 654 */     T<C> t2 = this.b.a(paramY);
/* 655 */     return (t1 == this.a && t2 == this.b) ? this : (cn)a(t1, t2);
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
/*     */   public boolean equals(Object paramObject) {
/* 667 */     if (paramObject instanceof cn) {
/* 668 */       cn cn1 = (cn)paramObject;
/* 669 */       return (this.a.equals(cn1.a) && this.b.equals(cn1.b));
/*     */     } 
/* 671 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 677 */     return this.a.hashCode() * 31 + this.b.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 686 */     return a(this.a, this.b);
/*     */   }
/*     */   
/*     */   private static String a(T<?> paramT1, T<?> paramT2) {
/* 690 */     StringBuilder stringBuilder = new StringBuilder(16);
/* 691 */     paramT1.b(stringBuilder);
/* 692 */     stringBuilder.append("..");
/* 693 */     paramT2.c(stringBuilder);
/* 694 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T> SortedSet<T> a(Iterable<T> paramIterable) {
/* 699 */     return (SortedSet<T>)paramIterable;
/*     */   }
/*     */   
/*     */   Object readResolve() {
/* 703 */     if (equals(b)) {
/* 704 */       return c();
/*     */     }
/* 706 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(Comparable<Comparable> paramComparable1, Comparable paramComparable2) {
/* 712 */     return paramComparable1.compareTo(paramComparable2);
/*     */   }
/*     */   
/*     */   private static class b
/*     */     extends cj<cn<?>> implements Serializable {
/* 717 */     static final cj<cn<?>> e = new b();
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public int a(cn<?> param1cn1, cn<?> param1cn2) {
/* 721 */       return M.a()
/* 722 */         .a(param1cn1.a, param1cn2.a)
/* 723 */         .a(param1cn1.b, param1cn2.b)
/* 724 */         .am();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */