/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.ToIntFunction;
/*     */ import java.util.stream.Collector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ public abstract class bp<E>
/*     */   extends bq<E>
/*     */   implements cc<E>
/*     */ {
/*     */   @com.google.b.a.a.b
/*     */   private transient bh<E> i;
/*     */   @com.google.b.a.a.b
/*     */   private transient bt<cc.a<E>> a;
/*     */   
/*     */   public static <E> Collector<E, ?, bp<E>> d() {
/*  66 */     return a((Function)Function.identity(), paramObject -> 1);
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
/*     */   public static <T, E> Collector<T, ?, bp<E>> a(Function<? super T, ? extends E> paramFunction, ToIntFunction<? super T> paramToIntFunction) {
/*  82 */     D.checkNotNull(paramFunction);
/*  83 */     D.checkNotNull(paramToIntFunction);
/*  84 */     return Collector.of(bP::a, (paramcc, paramObject) -> paramcc.add(D.checkNotNull(paramFunction.apply(paramObject)), paramToIntFunction.applyAsInt(paramObject)), (paramcc1, paramcc2) -> { paramcc1.addAll(paramcc2); return paramcc1; }paramcc -> a(paramcc.entrySet()), new Collector.Characteristics[0]);
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
/*     */   public static <E> bp<E> d() {
/*  98 */     return (bp)cw.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bp<E> a(E paramE) {
/* 109 */     return b((E[])new Object[] { paramE });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bp<E> a(E paramE1, E paramE2) {
/* 120 */     return b((E[])new Object[] { paramE1, paramE2 });
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
/*     */   public static <E> bp<E> a(E paramE1, E paramE2, E paramE3) {
/* 132 */     return b((E[])new Object[] { paramE1, paramE2, paramE3 });
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
/*     */   public static <E> bp<E> a(E paramE1, E paramE2, E paramE3, E paramE4) {
/* 144 */     return b((E[])new Object[] { paramE1, paramE2, paramE3, paramE4 });
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
/*     */   public static <E> bp<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/* 156 */     return b((E[])new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
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
/*     */   public static <E> bp<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs) {
/* 168 */     return (new a<>()).a(paramE1).a(paramE2).a(paramE3).a(paramE4).a(paramE5).a(paramE6).a(paramVarArgs).e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bp<E> a(E[] paramArrayOfE) {
/* 179 */     return b(paramArrayOfE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bp<E> a(Iterable<? extends E> paramIterable) {
/* 189 */     if (paramIterable instanceof bp) {
/*     */       
/* 191 */       bp<E> bp1 = (bp)paramIterable;
/* 192 */       if (!bp1.cO()) {
/* 193 */         return bp1;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 200 */     cc cc1 = (paramIterable instanceof cc) ? cd.<E>a(paramIterable) : bP.<E>a(paramIterable);
/*     */     
/* 202 */     return a(cc1.entrySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bp<E> a(Iterator<? extends E> paramIterator) {
/* 212 */     bP<?> bP = bP.a();
/* 213 */     bH.addAll(bP, paramIterator);
/* 214 */     return a((Collection)bP.entrySet());
/*     */   }
/*     */   
/*     */   private static <E> bp<E> b(E... paramVarArgs) {
/* 218 */     bP<?> bP = bP.a();
/* 219 */     Collections.addAll(bP, (Object[])paramVarArgs);
/* 220 */     return a((Collection)bP.entrySet());
/*     */   }
/*     */ 
/*     */   
/*     */   static <E> bp<E> a(Collection<? extends cc.a<? extends E>> paramCollection) {
/* 225 */     if (paramCollection.isEmpty()) {
/* 226 */       return d();
/*     */     }
/* 228 */     return cw.b(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public dj<E> b() {
/* 236 */     dj<cc.a<E>> dj = h().b();
/* 237 */     return new dj<E>(this, dj)
/*     */       {
/*     */         int remaining;
/*     */         E element;
/*     */         
/*     */         public boolean hasNext() {
/* 243 */           return (this.remaining > 0 || this.d.hasNext());
/*     */         }
/*     */ 
/*     */         
/*     */         public E next() {
/* 248 */           if (this.remaining <= 0) {
/* 249 */             cc.a<E> a = this.d.next();
/* 250 */             this.element = a.getElement();
/* 251 */             this.remaining = a.getCount();
/*     */           } 
/* 253 */           this.remaining--;
/* 254 */           return this.element;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bh<E> c() {
/* 263 */     bh<E> bh1 = this.i;
/* 264 */     return (bh1 == null) ? (this.i = super.c()) : bh1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 269 */     return (b(paramObject) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final int add(E paramE, int paramInt) {
/* 282 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final int remove(Object paramObject, int paramInt) {
/* 295 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final int setCount(E paramE, int paramInt) {
/* 308 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final boolean a(E paramE, int paramInt1, int paramInt2) {
/* 321 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   int a(Object[] paramArrayOfObject, int paramInt) {
/* 327 */     for (dj<cc.a<E>> dj = h().b(); dj.hasNext(); ) { cc.a a = dj.next();
/* 328 */       Arrays.fill(paramArrayOfObject, paramInt, paramInt + a.getCount(), a.getElement());
/* 329 */       paramInt += a.getCount(); }
/*     */     
/* 331 */     return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 336 */     return cd.a(this, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 341 */     return cG.a(h());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 346 */     return h().toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bt<cc.a<E>> h() {
/* 357 */     bt<cc.a<E>> bt1 = this.a;
/* 358 */     return (bt1 == null) ? (this.a = i()) : bt1;
/*     */   }
/*     */   
/*     */   private bt<cc.a<E>> i() {
/* 362 */     return isEmpty() ? bt.<cc.a<E>>n() : new c();
/*     */   }
/*     */   
/*     */   private final class c extends bD<cc.a<E>> {
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private c(bp this$0) {}
/*     */     
/*     */     boolean cO() {
/* 371 */       return this.a.cO();
/*     */     }
/*     */ 
/*     */     
/*     */     cc.a<E> c(int param1Int) {
/* 376 */       return this.a.a(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 381 */       return this.a.d().size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 386 */       if (param1Object instanceof cc.a) {
/* 387 */         cc.a a = (cc.a)param1Object;
/* 388 */         if (a.getCount() <= 0) {
/* 389 */           return false;
/*     */         }
/* 391 */         int i = this.a.b(a.getElement());
/* 392 */         return (i == a.getCount());
/*     */       } 
/* 394 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 399 */       return this.a.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.a.a.c
/*     */     Object writeReplace() {
/* 405 */       return new bp.d(this.a);
/*     */     }
/*     */   }
/*     */   
/*     */   @com.google.a.a.c
/*     */   static class d<E>
/*     */     implements Serializable
/*     */   {
/*     */     final bp<E> b;
/*     */     
/*     */     d(bp<E> param1bp) {
/* 416 */       this.b = param1bp;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 420 */       return this.b.h();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   Object writeReplace() {
/* 427 */     return new e(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> a<E> a() {
/* 435 */     return new a<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract bt<E> d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract cc.a<E> a(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a<E>
/*     */     extends bd.a<E>
/*     */   {
/*     */     final cc<E> b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a() {
/* 465 */       this(bP.a());
/*     */     }
/*     */     
/*     */     a(cc<E> param1cc) {
/* 469 */       this.b = param1cc;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(E param1E) {
/* 482 */       this.b.add((E)D.checkNotNull(param1E));
/* 483 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(E... param1VarArgs) {
/* 496 */       super.a(param1VarArgs);
/* 497 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(E param1E, int param1Int) {
/* 513 */       this.b.add((E)D.checkNotNull(param1E), param1Int);
/* 514 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> b(E param1E, int param1Int) {
/* 529 */       this.b.setCount((E)D.checkNotNull(param1E), param1Int);
/* 530 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(Iterable<? extends E> param1Iterable) {
/* 543 */       if (param1Iterable instanceof cc) {
/* 544 */         cc<? extends E> cc1 = cd.a(param1Iterable);
/* 545 */         cc1.a((param1Object, param1Int) -> this.b.add((E)D.checkNotNull(param1Object), param1Int));
/*     */       } else {
/* 547 */         super.a(param1Iterable);
/*     */       } 
/* 549 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(Iterator<? extends E> param1Iterator) {
/* 562 */       super.a(param1Iterator);
/* 563 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public bp<E> e() {
/* 572 */       return bp.a(this.b);
/*     */     }
/*     */     
/*     */     @com.google.a.a.d
/*     */     bp<E> f() {
/* 577 */       if (this.b.isEmpty()) {
/* 578 */         return bp.d();
/*     */       }
/* 580 */       return bK.b(this.b.entrySet());
/*     */     }
/*     */   }
/*     */   
/*     */   static final class b<E>
/*     */     extends bt.b<E> {
/*     */     private final List<cc.a<E>> entries;
/*     */     private final cc<E> c;
/*     */     
/*     */     b(List<cc.a<E>> param1List, cc<E> param1cc) {
/* 590 */       this.entries = param1List;
/* 591 */       this.c = param1cc;
/*     */     }
/*     */ 
/*     */     
/*     */     E get(int param1Int) {
/* 596 */       return ((cc.a<E>)this.entries.get(param1Int)).getElement();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 601 */       return this.c.contains(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 606 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 611 */       return this.entries.size();
/*     */     } }
/*     */   
/*     */   static final class e implements Serializable {
/*     */     final Object[] elements;
/*     */     final int[] O;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     e(cc<?> param1cc) {
/* 620 */       int i = param1cc.entrySet().size();
/* 621 */       this.elements = new Object[i];
/* 622 */       this.O = new int[i];
/* 623 */       byte b = 0;
/* 624 */       for (cc.a<?> a : param1cc.entrySet()) {
/* 625 */         this.elements[b] = a.getElement();
/* 626 */         this.O[b] = a.getCount();
/* 627 */         b++;
/*     */       } 
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 632 */       bP<?> bP = bP.a(this.elements.length);
/* 633 */       for (byte b = 0; b < this.elements.length; b++) {
/* 634 */         bP.add(this.elements[b], this.O[b]);
/*     */       }
/* 636 */       return bp.a(bP);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */