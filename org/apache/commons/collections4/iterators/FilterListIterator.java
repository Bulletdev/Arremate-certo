/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.ListIterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FilterListIterator<E>
/*     */   implements ListIterator<E>
/*     */ {
/*     */   private ListIterator<? extends E> iterator;
/*     */   private Predicate<? super E> predicate;
/*     */   private E nextObject;
/*     */   private boolean nextObjectSet = false;
/*     */   private E previousObject;
/*     */   private boolean previousObjectSet = false;
/*  68 */   private int nextIndex = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilterListIterator() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilterListIterator(ListIterator<? extends E> paramListIterator) {
/*  88 */     this.iterator = paramListIterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilterListIterator(ListIterator<? extends E> paramListIterator, Predicate<? super E> paramPredicate) {
/*  99 */     this.iterator = paramListIterator;
/* 100 */     this.predicate = paramPredicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FilterListIterator(Predicate<? super E> paramPredicate) {
/* 111 */     this.predicate = paramPredicate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(E paramE) {
/* 117 */     throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
/*     */   }
/*     */   
/*     */   public boolean hasNext() {
/* 121 */     return (this.nextObjectSet || setNextObject());
/*     */   }
/*     */   
/*     */   public boolean hasPrevious() {
/* 125 */     return (this.previousObjectSet || setPreviousObject());
/*     */   }
/*     */   
/*     */   public E next() {
/* 129 */     if (!this.nextObjectSet && 
/* 130 */       !setNextObject()) {
/* 131 */       throw new NoSuchElementException();
/*     */     }
/*     */     
/* 134 */     this.nextIndex++;
/* 135 */     E e = this.nextObject;
/* 136 */     clearNextObject();
/* 137 */     return e;
/*     */   }
/*     */   
/*     */   public int nextIndex() {
/* 141 */     return this.nextIndex;
/*     */   }
/*     */   
/*     */   public E previous() {
/* 145 */     if (!this.previousObjectSet && 
/* 146 */       !setPreviousObject()) {
/* 147 */       throw new NoSuchElementException();
/*     */     }
/*     */     
/* 150 */     this.nextIndex--;
/* 151 */     E e = this.previousObject;
/* 152 */     clearPreviousObject();
/* 153 */     return e;
/*     */   }
/*     */   
/*     */   public int previousIndex() {
/* 157 */     return this.nextIndex - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 162 */     throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(E paramE) {
/* 167 */     throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<? extends E> getListIterator() {
/* 177 */     return this.iterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setListIterator(ListIterator<? extends E> paramListIterator) {
/* 187 */     this.iterator = paramListIterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Predicate<? super E> getPredicate() {
/* 197 */     return this.predicate;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPredicate(Predicate<? super E> paramPredicate) {
/* 206 */     this.predicate = paramPredicate;
/*     */   }
/*     */ 
/*     */   
/*     */   private void clearNextObject() {
/* 211 */     this.nextObject = null;
/* 212 */     this.nextObjectSet = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setNextObject() {
/* 220 */     if (this.previousObjectSet) {
/* 221 */       clearPreviousObject();
/* 222 */       if (!setNextObject()) {
/* 223 */         return false;
/*     */       }
/* 225 */       clearNextObject();
/*     */     } 
/*     */     
/* 228 */     if (this.iterator == null) {
/* 229 */       return false;
/*     */     }
/* 231 */     while (this.iterator.hasNext()) {
/* 232 */       E e = this.iterator.next();
/* 233 */       if (this.predicate.evaluate(e)) {
/* 234 */         this.nextObject = e;
/* 235 */         this.nextObjectSet = true;
/* 236 */         return true;
/*     */       } 
/*     */     } 
/* 239 */     return false;
/*     */   }
/*     */   
/*     */   private void clearPreviousObject() {
/* 243 */     this.previousObject = null;
/* 244 */     this.previousObjectSet = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setPreviousObject() {
/* 252 */     if (this.nextObjectSet) {
/* 253 */       clearNextObject();
/* 254 */       if (!setPreviousObject()) {
/* 255 */         return false;
/*     */       }
/* 257 */       clearPreviousObject();
/*     */     } 
/*     */     
/* 260 */     if (this.iterator == null) {
/* 261 */       return false;
/*     */     }
/* 263 */     while (this.iterator.hasPrevious()) {
/* 264 */       E e = this.iterator.previous();
/* 265 */       if (this.predicate.evaluate(e)) {
/* 266 */         this.previousObject = e;
/* 267 */         this.previousObjectSet = true;
/* 268 */         return true;
/*     */       } 
/*     */     } 
/* 271 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\FilterListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */