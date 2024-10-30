/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ObjectGraphIterator<E>
/*     */   implements Iterator<E>
/*     */ {
/*  80 */   private final Deque<Iterator<? extends E>> stack = new ArrayDeque<Iterator<? extends E>>(8);
/*     */ 
/*     */ 
/*     */   
/*     */   private E root;
/*     */ 
/*     */ 
/*     */   
/*     */   private final Transformer<? super E, ? extends E> transformer;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean hasNext = false;
/*     */ 
/*     */ 
/*     */   
/*     */   private Iterator<? extends E> currentIterator;
/*     */ 
/*     */ 
/*     */   
/*     */   private E currentValue;
/*     */ 
/*     */   
/*     */   private Iterator<? extends E> lastUsedIterator;
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectGraphIterator(E paramE, Transformer<? super E, ? extends E> paramTransformer) {
/* 108 */     if (paramE instanceof Iterator) {
/* 109 */       this.currentIterator = (Iterator<? extends E>)paramE;
/*     */     } else {
/* 111 */       this.root = paramE;
/*     */     } 
/* 113 */     this.transformer = paramTransformer;
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
/*     */   public ObjectGraphIterator(Iterator<? extends E> paramIterator) {
/* 128 */     this.currentIterator = paramIterator;
/* 129 */     this.transformer = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateCurrentIterator() {
/* 137 */     if (this.hasNext) {
/*     */       return;
/*     */     }
/* 140 */     if (this.currentIterator == null) {
/* 141 */       if (this.root != null) {
/*     */ 
/*     */         
/* 144 */         if (this.transformer == null) {
/* 145 */           findNext(this.root);
/*     */         } else {
/* 147 */           findNext((E)this.transformer.transform(this.root));
/*     */         } 
/* 149 */         this.root = null;
/*     */       } 
/*     */     } else {
/* 152 */       findNextByIterator(this.currentIterator);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void findNext(E paramE) {
/* 163 */     if (paramE instanceof Iterator) {
/*     */       
/* 165 */       findNextByIterator((Iterator<? extends E>)paramE);
/*     */     } else {
/*     */       
/* 168 */       this.currentValue = paramE;
/* 169 */       this.hasNext = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void findNextByIterator(Iterator<? extends E> paramIterator) {
/* 179 */     if (paramIterator != this.currentIterator) {
/*     */       
/* 181 */       if (this.currentIterator != null) {
/* 182 */         this.stack.push(this.currentIterator);
/*     */       }
/* 184 */       this.currentIterator = paramIterator;
/*     */     } 
/*     */     
/* 187 */     while (this.currentIterator.hasNext() && !this.hasNext) {
/* 188 */       E e = this.currentIterator.next();
/* 189 */       if (this.transformer != null) {
/* 190 */         e = (E)this.transformer.transform(e);
/*     */       }
/* 192 */       findNext(e);
/*     */     } 
/*     */     
/* 195 */     if (!this.hasNext && !this.stack.isEmpty()) {
/*     */       
/* 197 */       this.currentIterator = this.stack.pop();
/* 198 */       findNextByIterator(this.currentIterator);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 209 */     updateCurrentIterator();
/* 210 */     return this.hasNext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E next() {
/* 220 */     updateCurrentIterator();
/* 221 */     if (!this.hasNext) {
/* 222 */       throw new NoSuchElementException("No more elements in the iteration");
/*     */     }
/* 224 */     this.lastUsedIterator = this.currentIterator;
/* 225 */     E e = this.currentValue;
/* 226 */     this.currentValue = null;
/* 227 */     this.hasNext = false;
/* 228 */     return e;
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
/*     */   public void remove() {
/* 245 */     if (this.lastUsedIterator == null) {
/* 246 */       throw new IllegalStateException("Iterator remove() cannot be called at this time");
/*     */     }
/* 248 */     this.lastUsedIterator.remove();
/* 249 */     this.lastUsedIterator = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\ObjectGraphIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */