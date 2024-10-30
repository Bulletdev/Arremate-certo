/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingletonIterator<E>
/*     */   implements ResettableIterator<E>
/*     */ {
/*     */   private final boolean removeAllowed;
/*     */   private boolean beforeFirst = true;
/*     */   private boolean removed = false;
/*     */   private E object;
/*     */   
/*     */   public SingletonIterator(E paramE) {
/*  49 */     this(paramE, true);
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
/*     */   public SingletonIterator(E paramE, boolean paramBoolean) {
/*  62 */     this.object = paramE;
/*  63 */     this.removeAllowed = paramBoolean;
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
/*     */   public boolean hasNext() {
/*  75 */     return (this.beforeFirst && !this.removed);
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
/*     */   public E next() {
/*  88 */     if (!this.beforeFirst || this.removed) {
/*  89 */       throw new NoSuchElementException();
/*     */     }
/*  91 */     this.beforeFirst = false;
/*  92 */     return this.object;
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
/*     */   public void remove() {
/* 105 */     if (this.removeAllowed) {
/* 106 */       if (this.removed || this.beforeFirst) {
/* 107 */         throw new IllegalStateException();
/*     */       }
/* 109 */       this.object = null;
/* 110 */       this.removed = true;
/*     */     } else {
/* 112 */       throw new UnsupportedOperationException();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 120 */     this.beforeFirst = true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\SingletonIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */