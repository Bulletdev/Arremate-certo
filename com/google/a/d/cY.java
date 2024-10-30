/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.k;
/*     */ import java.util.Comparator;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import java.util.function.ObjIntConsumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ final class cy<E>
/*     */   extends by<E>
/*     */ {
/*  36 */   private static final long[] b = new long[] { 0L };
/*     */   
/*  38 */   static final by<Comparable> c = new cy(
/*  39 */       cj.e());
/*     */   @d
/*     */   final transient cz<E> b;
/*     */   private final transient long[] c;
/*     */   private final transient int offset;
/*     */   private final transient int length;
/*     */   
/*     */   cy(Comparator<? super E> paramComparator) {
/*  47 */     this.b = bA.a(paramComparator);
/*  48 */     this.c = (long[])b;
/*  49 */     this.offset = 0;
/*  50 */     this.length = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   cy(cz<E> paramcz, long[] paramArrayOflong, int paramInt1, int paramInt2) {
/*  55 */     this.b = paramcz;
/*  56 */     this.c = paramArrayOflong;
/*  57 */     this.offset = paramInt1;
/*  58 */     this.length = paramInt2;
/*     */   }
/*     */   
/*     */   private int D(int paramInt) {
/*  62 */     return (int)(this.c[this.offset + paramInt + 1] - this.c[this.offset + paramInt]);
/*     */   }
/*     */ 
/*     */   
/*     */   cc.a<E> a(int paramInt) {
/*  67 */     return cd.a(this.b.c().get(paramInt), D(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ObjIntConsumer<? super E> paramObjIntConsumer) {
/*  72 */     D.checkNotNull(paramObjIntConsumer);
/*  73 */     for (byte b = 0; b < this.length; b++) {
/*  74 */       paramObjIntConsumer.accept(this.b.c().get(b), D(b));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> b() {
/*  80 */     return isEmpty() ? null : a(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> c() {
/*  85 */     return isEmpty() ? null : a(this.length - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int b(Object paramObject) {
/*  90 */     int i = this.b.indexOf(paramObject);
/*  91 */     return (i >= 0) ? D(i) : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  96 */     long l = this.c[this.offset + this.length] - this.c[this.offset];
/*  97 */     return k.e(l);
/*     */   }
/*     */ 
/*     */   
/*     */   public bA<E> b() {
/* 102 */     return this.b;
/*     */   }
/*     */ 
/*     */   
/*     */   public by<E> a(E paramE, x paramx) {
/* 107 */     return a(0, this.b.a(paramE, (D.checkNotNull(paramx) == x.b)));
/*     */   }
/*     */ 
/*     */   
/*     */   public by<E> b(E paramE, x paramx) {
/* 112 */     return a(this.b
/* 113 */         .b(paramE, (D.checkNotNull(paramx) == x.b)), this.length);
/*     */   }
/*     */   
/*     */   by<E> a(int paramInt1, int paramInt2) {
/* 117 */     D.a(paramInt1, paramInt2, this.length);
/* 118 */     if (paramInt1 == paramInt2)
/* 119 */       return a(comparator()); 
/* 120 */     if (paramInt1 == 0 && paramInt2 == this.length) {
/* 121 */       return this;
/*     */     }
/* 123 */     cz<E> cz1 = this.b.a(paramInt1, paramInt2);
/* 124 */     return new cy(cz1, this.c, this.offset + paramInt1, paramInt2 - paramInt1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 131 */     return (this.offset > 0 || this.length < this.c.length - 1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */