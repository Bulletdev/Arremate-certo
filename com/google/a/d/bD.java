/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.f;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Spliterator;
/*     */ import java.util.Spliterators;
/*     */ import java.util.function.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @f("Use ImmutableList.of or another implementation")
/*     */ @b(cl = true)
/*     */ public abstract class bd<E>
/*     */   extends AbstractCollection<E>
/*     */   implements Serializable
/*     */ {
/*     */   static final int ex = 1296;
/*     */   
/*     */   public Spliterator<E> spliterator() {
/* 183 */     return Spliterators.spliterator(this, 1296);
/*     */   }
/*     */   
/* 186 */   private static final Object[] c = new Object[0];
/*     */ 
/*     */   
/*     */   public final Object[] toArray() {
/* 190 */     return toArray(c);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final <T> T[] toArray(T[] paramArrayOfT) {
/* 196 */     D.checkNotNull(paramArrayOfT);
/* 197 */     int i = size();
/*     */     
/* 199 */     if (paramArrayOfT.length < i) {
/* 200 */       Object[] arrayOfObject = d();
/* 201 */       if (arrayOfObject != null) {
/* 202 */         return cl.b(arrayOfObject, ap(), aq(), paramArrayOfT);
/*     */       }
/* 204 */       paramArrayOfT = ci.a(paramArrayOfT, i);
/* 205 */     } else if (paramArrayOfT.length > i) {
/* 206 */       paramArrayOfT[i] = null;
/*     */     } 
/* 208 */     a((Object[])paramArrayOfT, 0);
/* 209 */     return paramArrayOfT;
/*     */   }
/*     */ 
/*     */   
/*     */   Object[] d() {
/* 214 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int ap() {
/* 222 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int aq() {
/* 230 */     throw new UnsupportedOperationException();
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
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final boolean add(E paramE) {
/* 246 */     throw new UnsupportedOperationException();
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
/*     */   public final boolean remove(Object paramObject) {
/* 259 */     throw new UnsupportedOperationException();
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
/*     */   public final boolean addAll(Collection<? extends E> paramCollection) {
/* 272 */     throw new UnsupportedOperationException();
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
/*     */   public final boolean removeAll(Collection<?> paramCollection) {
/* 285 */     throw new UnsupportedOperationException();
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
/*     */   public final boolean removeIf(Predicate<? super E> paramPredicate) {
/* 298 */     throw new UnsupportedOperationException();
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
/*     */   public final boolean retainAll(Collection<?> paramCollection) {
/* 310 */     throw new UnsupportedOperationException();
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
/*     */   public final void clear() {
/* 322 */     throw new UnsupportedOperationException();
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
/*     */   public bh<E> c() {
/* 336 */     switch (size()) {
/*     */       case 0:
/* 338 */         return bh.e();
/*     */       case 1:
/* 340 */         return bh.a(b().next());
/*     */     } 
/* 342 */     return new cs<>(this, toArray());
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
/*     */   @com.google.b.a.a
/*     */   int a(Object[] paramArrayOfObject, int paramInt) {
/* 360 */     for (dj<E> dj = b(); dj.hasNext(); ) { E e = dj.next();
/* 361 */       paramArrayOfObject[paramInt++] = e; }
/*     */     
/* 363 */     return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 368 */     return new bh.c(toArray());
/*     */   }
/*     */   
/*     */   public abstract dj<E> b();
/*     */   
/*     */   public abstract boolean contains(Object paramObject);
/*     */   
/*     */   abstract boolean cO();
/*     */   
/*     */   @f
/*     */   public static abstract class a<E> { static final int DEFAULT_INITIAL_CAPACITY = 4;
/*     */     
/*     */     static int h(int param1Int1, int param1Int2) {
/* 381 */       if (param1Int2 < 0) {
/* 382 */         throw new AssertionError("cannot store more than MAX_VALUE elements");
/*     */       }
/*     */       
/* 385 */       int i = param1Int1 + (param1Int1 >> 1) + 1;
/* 386 */       if (i < param1Int2) {
/* 387 */         i = Integer.highestOneBit(param1Int2 - 1) << 1;
/*     */       }
/* 389 */       if (i < 0) {
/* 390 */         i = Integer.MAX_VALUE;
/*     */       }
/*     */       
/* 393 */       return i;
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
/*     */     public abstract a<E> a(E param1E);
/*     */ 
/*     */ 
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
/* 422 */       for (E e : param1VarArgs) {
/* 423 */         a(e);
/*     */       }
/* 425 */       return this;
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
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<E> a(Iterable<? extends E> param1Iterable) {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */       //   6: astore_2
/*     */       //   7: aload_2
/*     */       //   8: invokeinterface hasNext : ()Z
/*     */       //   13: ifeq -> 32
/*     */       //   16: aload_2
/*     */       //   17: invokeinterface next : ()Ljava/lang/Object;
/*     */       //   22: astore_3
/*     */       //   23: aload_0
/*     */       //   24: aload_3
/*     */       //   25: invokevirtual a : (Ljava/lang/Object;)Lcom/google/a/d/bd$a;
/*     */       //   28: pop
/*     */       //   29: goto -> 7
/*     */       //   32: aload_0
/*     */       //   33: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #440	-> 0
/*     */       //   #441	-> 23
/*     */       //   #442	-> 29
/*     */       //   #443	-> 32
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
/*     */     public a<E> a(Iterator<? extends E> param1Iterator) {
/* 458 */       while (param1Iterator.hasNext()) {
/* 459 */         a(param1Iterator.next());
/*     */       }
/* 461 */       return this;
/*     */     }
/*     */     
/*     */     public abstract bd<E> d(); }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */