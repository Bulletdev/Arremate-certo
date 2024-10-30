/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.cj;
/*     */ import com.google.b.a.j;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @j
/*     */ @a
/*     */ public final class m<T>
/*     */ {
/*     */   private final a a;
/*     */   private final Comparator<T> comparator;
/*     */   
/*     */   public enum a
/*     */   {
/*  67 */     b,
/*  68 */     c,
/*  69 */     d,
/*  70 */     e;
/*     */   }
/*     */   
/*     */   private m(a parama, Comparator<T> paramComparator) {
/*  74 */     this.a = (a)D.checkNotNull(parama);
/*  75 */     this.comparator = paramComparator;
/*  76 */     D.ab((((parama == a.e) ? true : false) == ((paramComparator != null) ? true : false)));
/*     */   }
/*     */ 
/*     */   
/*     */   public static <S> m<S> c() {
/*  81 */     return new m<>(a.b, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <S> m<S> d() {
/* 121 */     return new m<>(a.c, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <S> m<S> e() {
/* 126 */     return new m<>(a.d, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <S extends Comparable<? super S>> m<S> f() {
/* 133 */     return new m<>(a.e, (Comparator<S>)cj.e());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <S> m<S> a(Comparator<S> paramComparator) {
/* 141 */     return new m<>(a.e, (Comparator<S>)D.checkNotNull(paramComparator));
/*     */   }
/*     */ 
/*     */   
/*     */   public a a() {
/* 146 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<T> comparator() {
/* 155 */     if (this.comparator != null) {
/* 156 */       return this.comparator;
/*     */     }
/* 158 */     throw new UnsupportedOperationException("This ordering does not define a comparator.");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 163 */     if (paramObject == this) {
/* 164 */       return true;
/*     */     }
/* 166 */     if (!(paramObject instanceof m)) {
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     m m1 = (m)paramObject;
/* 171 */     return (this.a == m1.a && y.equal(this.comparator, m1.comparator));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 176 */     return y.a(new Object[] { this.a, this.comparator });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 181 */     x.a a1 = x.a(this).a("type", this.a);
/* 182 */     if (this.comparator != null) {
/* 183 */       a1.a("comparator", this.comparator);
/*     */     }
/* 185 */     return a1.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   <K extends T, V> Map<K, V> e(int paramInt) {
/* 190 */     switch (null.Q[this.a.ordinal()]) {
/*     */       case 1:
/* 192 */         return bW.a(paramInt);
/*     */       case 2:
/*     */       case 3:
/* 195 */         return bW.a(paramInt);
/*     */       case 4:
/* 197 */         return bW.b(comparator());
/*     */     } 
/* 199 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   <T1 extends T> m<T1> g() {
/* 205 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */