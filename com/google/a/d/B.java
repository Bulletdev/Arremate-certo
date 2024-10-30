/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class b<E>
/*     */   extends dk<E>
/*     */ {
/*     */   private final int size;
/*     */   private int position;
/*     */   
/*     */   protected abstract E get(int paramInt);
/*     */   
/*     */   protected b(int paramInt) {
/*  48 */     this(paramInt, 0);
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
/*     */   protected b(int paramInt1, int paramInt2) {
/*  62 */     D.c(paramInt2, paramInt1);
/*  63 */     this.size = paramInt1;
/*  64 */     this.position = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasNext() {
/*  69 */     return (this.position < this.size);
/*     */   }
/*     */ 
/*     */   
/*     */   public final E next() {
/*  74 */     if (!hasNext()) {
/*  75 */       throw new NoSuchElementException();
/*     */     }
/*  77 */     return get(this.position++);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int nextIndex() {
/*  82 */     return this.position;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasPrevious() {
/*  87 */     return (this.position > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final E previous() {
/*  92 */     if (!hasPrevious()) {
/*  93 */       throw new NoSuchElementException();
/*     */     }
/*  95 */     return get(--this.position);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int previousIndex() {
/* 100 */     return this.position - 1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */