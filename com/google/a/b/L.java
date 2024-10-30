/*     */ package com.google.a.b;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.b.a.g;
/*     */ import java.io.Serializable;
/*     */ import java.util.function.BiPredicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class l<T>
/*     */   implements BiPredicate<T, T>
/*     */ {
/*     */   public final boolean a(T paramT1, T paramT2) {
/*  59 */     if (paramT1 == paramT2) {
/*  60 */       return true;
/*     */     }
/*  62 */     if (paramT1 == null || paramT2 == null) {
/*  63 */       return false;
/*     */     }
/*  65 */     return b(paramT1, paramT2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final boolean test(T paramT1, T paramT2) {
/*  76 */     return a(paramT1, paramT2);
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
/*     */   @g
/*     */   protected abstract boolean b(T paramT1, T paramT2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hash(T paramT) {
/* 109 */     if (paramT == null) {
/* 110 */       return 0;
/*     */     }
/* 112 */     return a(paramT);
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
/*     */   @g
/*     */   protected abstract int a(T paramT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <F> l<F> a(s<F, ? extends T> params) {
/* 151 */     return new t<>(params, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <S extends T> d<S> a(S paramS) {
/* 162 */     return new d<>(this, paramS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class d<T>
/*     */     implements Serializable
/*     */   {
/*     */     private final l<? super T> a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final T i;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static final long serialVersionUID = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private d(l<? super T> param1l, T param1T) {
/* 190 */       this.a = D.<l<? super T>>checkNotNull(param1l);
/* 191 */       this.i = param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     public T get() {
/* 196 */       return this.i;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 206 */       if (param1Object == this) {
/* 207 */         return true;
/*     */       }
/* 209 */       if (param1Object instanceof d) {
/* 210 */         d d1 = (d)param1Object;
/*     */         
/* 212 */         if (this.a.equals(d1.a)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 218 */           l<? super T> l1 = this.a;
/* 219 */           return l1.a(this.i, d1.i);
/*     */         } 
/*     */       } 
/* 222 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 228 */       return this.a.hash(this.i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 237 */       String str1 = String.valueOf(this.a), str2 = String.valueOf(this.i); return (new StringBuilder(7 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".wrap(").append(str2).append(")").toString();
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
/*     */   @b(ck = true)
/*     */   public final <S extends T> l<Iterable<S>> a() {
/* 258 */     return new A<>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final E<T> a(T paramT) {
/* 268 */     return new b<>(this, paramT);
/*     */   }
/*     */   
/*     */   private static final class b<T> implements E<T>, Serializable {
/*     */     private final l<T> a;
/*     */     private final T target;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     b(l<T> param1l, T param1T) {
/* 277 */       this.a = D.<l<T>>checkNotNull(param1l);
/* 278 */       this.target = param1T;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean b(T param1T) {
/* 283 */       return this.a.a(param1T, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 288 */       if (this == param1Object) {
/* 289 */         return true;
/*     */       }
/* 291 */       if (param1Object instanceof b) {
/* 292 */         b b1 = (b)param1Object;
/* 293 */         return (this.a.equals(b1.a) && y.equal(this.target, b1.target));
/*     */       } 
/* 295 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 300 */       return y.a(new Object[] { this.a, this.target });
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 305 */       String str1 = String.valueOf(this.a), str2 = String.valueOf(this.target); return (new StringBuilder(15 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".equivalentTo(").append(str2).append(")").toString();
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
/*     */   public static l<Object> b() {
/* 322 */     return a.a;
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
/*     */   public static l<Object> c() {
/* 334 */     return c.a;
/*     */   }
/*     */   
/*     */   static final class a
/*     */     extends l<Object> implements Serializable {
/* 339 */     static final a a = new a();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected boolean b(Object param1Object1, Object param1Object2) {
/* 343 */       return param1Object1.equals(param1Object2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int a(Object param1Object) {
/* 348 */       return param1Object.hashCode();
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 352 */       return a;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class c
/*     */     extends l<Object>
/*     */     implements Serializable
/*     */   {
/* 360 */     static final c a = new c();
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     protected boolean b(Object param1Object1, Object param1Object2) {
/* 364 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int a(Object param1Object) {
/* 369 */       return System.identityHashCode(param1Object);
/*     */     }
/*     */     
/*     */     private Object readResolve() {
/* 373 */       return a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */