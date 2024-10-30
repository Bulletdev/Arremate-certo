/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.d;
/*     */ import java.util.Iterator;
/*     */ import java.util.Spliterator;
/*     */ import java.util.Spliterators;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class cx<E>
/*     */   extends bt<E>
/*     */ {
/*  33 */   static final cx<Object> a = new cx(new Object[0], 0, null, 0);
/*     */   
/*     */   private final transient Object[] elements;
/*     */   
/*     */   @d
/*     */   final transient Object[] m;
/*     */   
/*     */   private final transient int mask;
/*     */   private final transient int hashCode;
/*     */   
/*     */   cx(Object[] paramArrayOfObject1, int paramInt1, Object[] paramArrayOfObject2, int paramInt2) {
/*  44 */     this.elements = paramArrayOfObject1;
/*  45 */     this.m = paramArrayOfObject2;
/*  46 */     this.mask = paramInt2;
/*  47 */     this.hashCode = paramInt1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  52 */     Object[] arrayOfObject = this.m;
/*  53 */     if (paramObject == null || arrayOfObject == null) {
/*  54 */       return false;
/*     */     }
/*  56 */     for (int i = aY.g(paramObject);; i++) {
/*  57 */       i &= this.mask;
/*  58 */       Object object = arrayOfObject[i];
/*  59 */       if (object == null)
/*  60 */         return false; 
/*  61 */       if (object.equals(paramObject)) {
/*  62 */         return true;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  69 */     return this.elements.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public dj<E> b() {
/*  74 */     return bH.a((E[])this.elements);
/*     */   }
/*     */ 
/*     */   
/*     */   public Spliterator<E> spliterator() {
/*  79 */     return Spliterators.spliterator(this.elements, 1297);
/*     */   }
/*     */ 
/*     */   
/*     */   Object[] d() {
/*  84 */     return this.elements;
/*     */   }
/*     */ 
/*     */   
/*     */   int ap() {
/*  89 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   int aq() {
/*  94 */     return this.elements.length;
/*     */   }
/*     */ 
/*     */   
/*     */   int a(Object[] paramArrayOfObject, int paramInt) {
/*  99 */     System.arraycopy(this.elements, 0, paramArrayOfObject, paramInt, this.elements.length);
/* 100 */     return paramInt + this.elements.length;
/*     */   }
/*     */ 
/*     */   
/*     */   bh<E> h() {
/* 105 */     return (this.m == null) ? bh.<E>e() : new cs<>(this, this.elements);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 110 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 115 */     return this.hashCode;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cR() {
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cx.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */