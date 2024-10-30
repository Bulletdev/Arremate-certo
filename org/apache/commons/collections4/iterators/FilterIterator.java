/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilterIterator<E>
/*     */   implements Iterator<E>
/*     */ {
/*     */   private Iterator<? extends E> iterator;
/*     */   private Predicate<? super E> predicate;
/*     */   private E nextObject;
/*     */   private boolean nextObjectSet = false;
/*     */   
/*     */   public FilterIterator() {}
/*     */   
/*     */   public FilterIterator(Iterator<? extends E> paramIterator) {
/*  61 */     this.iterator = paramIterator;
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
/*     */   public FilterIterator(Iterator<? extends E> paramIterator, Predicate<? super E> paramPredicate) {
/*  73 */     this.iterator = paramIterator;
/*  74 */     this.predicate = paramPredicate;
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
/*  86 */     return (this.nextObjectSet || setNextObject());
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
/*     */   public E next() {
/*  98 */     if (!this.nextObjectSet && 
/*  99 */       !setNextObject()) {
/* 100 */       throw new NoSuchElementException();
/*     */     }
/*     */     
/* 103 */     this.nextObjectSet = false;
/* 104 */     return this.nextObject;
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
/*     */   public void remove() {
/* 119 */     if (this.nextObjectSet) {
/* 120 */       throw new IllegalStateException("remove() cannot be called");
/*     */     }
/* 122 */     this.iterator.remove();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<? extends E> getIterator() {
/* 132 */     return this.iterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIterator(Iterator<? extends E> paramIterator) {
/* 142 */     this.iterator = paramIterator;
/* 143 */     this.nextObject = null;
/* 144 */     this.nextObjectSet = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate<? super E> getPredicate() {
/* 154 */     return this.predicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPredicate(Predicate<? super E> paramPredicate) {
/* 163 */     this.predicate = paramPredicate;
/* 164 */     this.nextObject = null;
/* 165 */     this.nextObjectSet = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setNextObject() {
/* 174 */     while (this.iterator.hasNext()) {
/* 175 */       E e = this.iterator.next();
/* 176 */       if (this.predicate.evaluate(e)) {
/* 177 */         this.nextObject = e;
/* 178 */         this.nextObjectSet = true;
/* 179 */         return true;
/*     */       } 
/*     */     } 
/* 182 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\FilterIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */