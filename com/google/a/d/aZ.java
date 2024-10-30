/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.b.a.a;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class az<E>
/*     */   extends ar<E>
/*     */   implements List<E>
/*     */ {
/*     */   public void add(int paramInt, E paramE) {
/*  65 */     S().add(paramInt, paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/*  71 */     return S().addAll(paramInt, paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public E get(int paramInt) {
/*  76 */     return S().get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/*  81 */     return S().indexOf(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/*  86 */     return S().lastIndexOf(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator() {
/*  91 */     return S().listIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/*  96 */     return S().listIterator(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public E remove(int paramInt) {
/* 102 */     return S().remove(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public E set(int paramInt, E paramE) {
/* 108 */     return S().set(paramInt, paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 113 */     return S().subList(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 118 */     return (paramObject == this || S().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 123 */     return S().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean i(E paramE) {
/* 134 */     add(size(), paramE);
/* 135 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean a(int paramInt, Iterable<? extends E> paramIterable) {
/* 146 */     return bS.a(this, paramInt, paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int d(Object paramObject) {
/* 157 */     return bS.a(this, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int e(Object paramObject) {
/* 168 */     return bS.c(this, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Iterator<E> j() {
/* 179 */     return listIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ListIterator<E> b() {
/* 190 */     return listIterator(0);
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
/*     */   @a
/*     */   protected ListIterator<E> a(int paramInt) {
/* 203 */     return bS.a(this, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   protected List<E> a(int paramInt1, int paramInt2) {
/* 214 */     return bS.a(this, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   protected boolean j(Object paramObject) {
/* 226 */     return bS.a(this, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   protected int an() {
/* 238 */     return bS.a(this);
/*     */   }
/*     */   
/*     */   protected abstract List<E> S();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\az.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */