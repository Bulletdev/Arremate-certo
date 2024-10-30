/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.m.k;
/*     */ import com.google.b.a.a.b;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true, ck = true)
/*     */ class cw<E>
/*     */   extends bp<E>
/*     */ {
/*  38 */   static final bp<Object> c = b(bh.e()); @d
/*     */   static final double v = 1.0D; @d
/*     */   static final double s = 0.001D; @d
/*  41 */   static final int ea = 9; private final transient cd.f<E>[] a; static <E> bp<E> b(Collection<? extends cc.a<? extends E>> paramCollection) { int i = paramCollection.size();
/*     */     
/*  43 */     cd.f[] arrayOfF1 = new cd.f[i];
/*  44 */     if (i == 0) {
/*  45 */       return new cw<>((cd.f<E>[])arrayOfF1, null, 0, 0, bt.n());
/*     */     }
/*  47 */     int j = aY.a(i, 1.0D);
/*  48 */     int k = j - 1;
/*     */     
/*  50 */     cd.f[] arrayOfF2 = new cd.f[j];
/*     */     
/*  52 */     byte b = 0;
/*  53 */     int m = 0;
/*  54 */     long l = 0L;
/*  55 */     for (cc.a<? extends E> a : paramCollection) {
/*  56 */       cd.f f2; Object object = D.checkNotNull(a.getElement());
/*  57 */       int n = a.getCount();
/*  58 */       int i1 = object.hashCode();
/*  59 */       int i2 = aY.d(i1) & k;
/*  60 */       cd.f f1 = arrayOfF2[i2];
/*     */       
/*  62 */       if (f1 == null) {
/*  63 */         boolean bool = (a instanceof cd.f && !(a instanceof a)) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  68 */         f2 = bool ? (cd.f)a : new cd.f(object, n);
/*     */       } else {
/*  70 */         f2 = new a(object, n, f1);
/*     */       } 
/*  72 */       m += i1 ^ n;
/*  73 */       arrayOfF1[b++] = f2;
/*  74 */       arrayOfF2[i2] = f2;
/*  75 */       l += n;
/*     */     } 
/*     */     
/*  78 */     return a((cd.f<?>[])arrayOfF2) ? 
/*  79 */       bK.<E>b(bh.c((Object[])arrayOfF1)) : 
/*  80 */       new cw<>((cd.f<E>[])arrayOfF1, (cd.f<E>[])arrayOfF2, 
/*  81 */         k.e(l), m, null); }
/*     */    private final transient cd.f<E>[] b; private final transient int size; private final transient int hashCode; @b
/*     */   private transient bt<E> e;
/*     */   private static boolean a(cd.f<?>[] paramArrayOff) {
/*  85 */     for (byte b = 0; b < paramArrayOff.length; b++) {
/*  86 */       byte b1 = 0;
/*  87 */       cd.f<?> f1 = paramArrayOff[b];
/*  88 */       for (; f1 != null; 
/*  89 */         f1 = f1.a()) {
/*  90 */         b1++;
/*  91 */         if (b1 > 9) {
/*  92 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*  96 */     return false;
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
/*     */   private cw(cd.f<E>[] paramArrayOff1, cd.f<E>[] paramArrayOff2, int paramInt1, int paramInt2, bt<E> parambt) {
/* 131 */     this.a = paramArrayOff1;
/* 132 */     this.b = paramArrayOff2;
/* 133 */     this.size = paramInt1;
/* 134 */     this.hashCode = paramInt2;
/* 135 */     this.e = parambt;
/*     */   }
/*     */   
/*     */   private static final class a<E> extends cd.f<E> {
/*     */     private final cd.f<E> a;
/*     */     
/*     */     a(E param1E, int param1Int, cd.f<E> param1f) {
/* 142 */       super(param1E, param1Int);
/* 143 */       this.a = param1f;
/*     */     }
/*     */ 
/*     */     
/*     */     public cd.f<E> a() {
/* 148 */       return this.a;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int b(Object paramObject) {
/* 159 */     cd.f<E>[] arrayOfF = this.b;
/* 160 */     if (paramObject == null || arrayOfF == null) {
/* 161 */       return 0;
/*     */     }
/* 163 */     int i = aY.g(paramObject);
/* 164 */     int j = arrayOfF.length - 1;
/* 165 */     cd.f<E> f1 = arrayOfF[i & j];
/* 166 */     for (; f1 != null; 
/* 167 */       f1 = f1.a()) {
/* 168 */       if (y.equal(paramObject, f1.getElement())) {
/* 169 */         return f1.getCount();
/*     */       }
/*     */     } 
/* 172 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 177 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public bt<E> d() {
/* 182 */     bt<E> bt1 = this.e;
/* 183 */     return (bt1 == null) ? (this.e = new bp.b<>(Arrays.asList((cc.a[])this.a), this)) : bt1;
/*     */   }
/*     */ 
/*     */   
/*     */   cc.a<E> a(int paramInt) {
/* 188 */     return this.a[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 193 */     return this.hashCode;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */