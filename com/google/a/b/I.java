/*     */ package com.google.a.b;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.b.a.g;
/*     */ import com.google.c.a.h;
/*     */ import java.io.Serializable;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class i<A, B>
/*     */   implements s<A, B>
/*     */ {
/*     */   private final boolean at;
/*     */   @com.google.b.a.a.b
/*     */   @h
/*     */   private transient i<B, A> a;
/*     */   
/*     */   protected i() {
/* 125 */     this(true);
/*     */   }
/*     */ 
/*     */   
/*     */   i(boolean paramBoolean) {
/* 130 */     this.at = paramBoolean;
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
/*     */   @g
/*     */   protected abstract B c(A paramA);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @g
/*     */   protected abstract A b(B paramB);
/*     */ 
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
/*     */   public final B d(A paramA) {
/* 169 */     return e(paramA);
/*     */   }
/*     */ 
/*     */   
/*     */   B e(A paramA) {
/* 174 */     if (this.at)
/*     */     {
/* 176 */       return (paramA == null) ? null : D.<B>checkNotNull(c(paramA));
/*     */     }
/* 178 */     return c(paramA);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   A f(B paramB) {
/* 184 */     if (this.at)
/*     */     {
/* 186 */       return (paramB == null) ? null : D.<A>checkNotNull(b(paramB));
/*     */     }
/* 188 */     return b(paramB);
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
/*     */   @com.google.b.a.a
/*     */   public Iterable<B> a(Iterable<? extends A> paramIterable) {
/* 202 */     D.b(paramIterable, "fromIterable");
/* 203 */     return new Iterable<B>(this, paramIterable)
/*     */       {
/*     */         public Iterator<B> iterator() {
/* 206 */           return new Iterator<B>(this)
/*     */             {
/*     */               private final Iterator<? extends A> a;
/*     */               
/*     */               public boolean hasNext() {
/* 211 */                 return this.a.hasNext();
/*     */               }
/*     */ 
/*     */               
/*     */               public B next() {
/* 216 */                 return (B)this.a.b.d(this.a.next());
/*     */               }
/*     */ 
/*     */               
/*     */               public void remove() {
/* 221 */                 this.a.remove();
/*     */               }
/*     */             };
/*     */         }
/*     */       };
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
/*     */   @com.google.b.a.a
/*     */   public i<B, A> a() {
/* 238 */     i<B, A> i1 = this.a;
/* 239 */     return (i1 == null) ? (this.a = new d<>(this)) : i1;
/*     */   }
/*     */   
/*     */   private static final class d<A, B> extends i<B, A> implements Serializable {
/*     */     final i<A, B> e;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     d(i<A, B> param1i) {
/* 247 */       this.e = param1i;
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
/*     */     protected A c(B param1B) {
/* 259 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */     
/*     */     protected B b(A param1A) {
/* 264 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     A e(B param1B) {
/* 270 */       return this.e.f(param1B);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     B f(A param1A) {
/* 276 */       return this.e.e(param1A);
/*     */     }
/*     */ 
/*     */     
/*     */     public i<A, B> a() {
/* 281 */       return this.e;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 286 */       if (param1Object instanceof d) {
/* 287 */         d d1 = (d)param1Object;
/* 288 */         return this.e.equals(d1.e);
/*     */       } 
/* 290 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 295 */       return this.e.hashCode() ^ 0xFFFFFFFF;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 300 */       String str = String.valueOf(this.e); return (new StringBuilder(10 + String.valueOf(str).length())).append(str).append(".reverse()").toString();
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
/*     */   public final <C> i<A, C> a(i<B, C> parami) {
/* 314 */     return b(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   <C> i<A, C> b(i<B, C> parami) {
/* 319 */     return new a<>(this, D.<i<?, C>>checkNotNull(parami));
/*     */   }
/*     */   
/*     */   private static final class a<A, B, C> extends i<A, C> implements Serializable {
/*     */     final i<A, B> c;
/*     */     final i<B, C> d;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(i<A, B> param1i, i<B, C> param1i1) {
/* 328 */       this.c = param1i;
/* 329 */       this.d = param1i1;
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
/*     */     protected C c(A param1A) {
/* 341 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */     
/*     */     protected A b(C param1C) {
/* 346 */       throw new AssertionError();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     C e(A param1A) {
/* 352 */       return this.d.e(this.c.e(param1A));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     A f(C param1C) {
/* 358 */       return this.c.f(this.d.f(param1C));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 363 */       if (param1Object instanceof a) {
/* 364 */         a a1 = (a)param1Object;
/* 365 */         return (this.c.equals(a1.c) && this.d.equals(a1.d));
/*     */       } 
/* 367 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 372 */       return 31 * this.c.hashCode() + this.d.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 377 */       String str1 = String.valueOf(this.c), str2 = String.valueOf(this.d); return (new StringBuilder(10 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".andThen(").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final B apply(A paramA) {
/* 390 */     return d(paramA);
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
/*     */   public boolean equals(Object paramObject) {
/* 406 */     return super.equals(paramObject);
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
/*     */   public static <A, B> i<A, B> a(s<? super A, ? extends B> params, s<? super B, ? extends A> params1) {
/* 428 */     return new b<>(params, params1);
/*     */   }
/*     */   
/*     */   private static final class b<A, B>
/*     */     extends i<A, B>
/*     */     implements Serializable
/*     */   {
/*     */     private final s<? super A, ? extends B> a;
/*     */     private final s<? super B, ? extends A> b;
/*     */     
/*     */     private b(s<? super A, ? extends B> param1s, s<? super B, ? extends A> param1s1) {
/* 439 */       this.a = D.<s<? super A, ? extends B>>checkNotNull(param1s);
/* 440 */       this.b = D.<s<? super B, ? extends A>>checkNotNull(param1s1);
/*     */     }
/*     */ 
/*     */     
/*     */     protected B c(A param1A) {
/* 445 */       return this.a.apply(param1A);
/*     */     }
/*     */ 
/*     */     
/*     */     protected A b(B param1B) {
/* 450 */       return this.b.apply(param1B);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 455 */       if (param1Object instanceof b) {
/* 456 */         b b1 = (b)param1Object;
/* 457 */         return (this.a.equals(b1.a) && this.b
/* 458 */           .equals(b1.b));
/*     */       } 
/* 460 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 465 */       return this.a.hashCode() * 31 + this.b.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 470 */       String str1 = String.valueOf(this.a), str2 = String.valueOf(this.b); return (new StringBuilder(18 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Converter.from(").append(str1).append(", ").append(str2).append(")").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> i<T, T> b() {
/* 477 */     return (i)c.a;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class c<T>
/*     */     extends i<T, T>
/*     */     implements Serializable
/*     */   {
/* 485 */     static final c<?> a = new c();
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     protected T c(T param1T) {
/* 489 */       return param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     protected T b(T param1T) {
/* 494 */       return param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     public c<T> a() {
/* 499 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     <S> i<T, S> b(i<T, S> param1i) {
/* 504 */       return D.<i<T, S>>b(param1i, "otherConverter");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 514 */       return "Converter.identity()";
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 518 */       return a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */