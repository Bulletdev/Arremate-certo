/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Collection;
/*     */ import java.util.Queue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @b
/*     */ public final class af<E>
/*     */   extends aJ<E>
/*     */   implements Serializable
/*     */ {
/*     */   private final Queue<E> g;
/*     */   @d
/*     */   final int maxSize;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   private af(int paramInt) {
/*  55 */     D.a((paramInt >= 0), "maxSize (%s) must >= 0", paramInt);
/*  56 */     this.g = new ArrayDeque<>(paramInt);
/*  57 */     this.maxSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> af<E> a(int paramInt) {
/*  67 */     return new af<>(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int remainingCapacity() {
/*  77 */     return this.maxSize - size();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Queue<E> b() {
/*  82 */     return this.g;
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
/*     */   public boolean offer(E paramE) {
/*  94 */     return add(paramE);
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
/*     */   public boolean add(E paramE) {
/* 106 */     D.checkNotNull(paramE);
/* 107 */     if (this.maxSize == 0) {
/* 108 */       return true;
/*     */     }
/* 110 */     if (size() == this.maxSize) {
/* 111 */       this.g.remove();
/*     */     }
/* 113 */     this.g.add(paramE);
/* 114 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 120 */     int i = paramCollection.size();
/* 121 */     if (i >= this.maxSize) {
/* 122 */       clear();
/* 123 */       return bG.addAll(this, bG.c(paramCollection, i - this.maxSize));
/*     */     } 
/* 125 */     return b(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 130 */     return b().contains(D.checkNotNull(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean remove(Object paramObject) {
/* 136 */     return b().remove(D.checkNotNull(paramObject));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\af.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */