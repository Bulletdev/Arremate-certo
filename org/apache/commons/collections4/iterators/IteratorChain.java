/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IteratorChain<E>
/*     */   implements Iterator<E>
/*     */ {
/*  54 */   private final Queue<Iterator<? extends E>> iteratorChain = new LinkedList<Iterator<? extends E>>();
/*     */ 
/*     */   
/*  57 */   private Iterator<? extends E> currentIterator = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private Iterator<? extends E> lastUsedIterator = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isLocked = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IteratorChain() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IteratorChain(Iterator<? extends E> paramIterator) {
/*  97 */     addIterator(paramIterator);
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
/*     */   public IteratorChain(Iterator<? extends E> paramIterator1, Iterator<? extends E> paramIterator2) {
/* 112 */     addIterator(paramIterator1);
/* 113 */     addIterator(paramIterator2);
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
/*     */   public IteratorChain(Iterator<? extends E>... paramVarArgs) {
/* 127 */     for (Iterator<? extends E> iterator : paramVarArgs) {
/* 128 */       addIterator(iterator);
/*     */     }
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
/*     */   public IteratorChain(Collection<Iterator<? extends E>> paramCollection) {
/* 146 */     for (Iterator<? extends E> iterator : paramCollection) {
/* 147 */       addIterator(iterator);
/*     */     }
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
/*     */   public void addIterator(Iterator<? extends E> paramIterator) {
/* 160 */     checkLocked();
/* 161 */     if (paramIterator == null) {
/* 162 */       throw new NullPointerException("Iterator must not be null");
/*     */     }
/* 164 */     this.iteratorChain.add(paramIterator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 173 */     return this.iteratorChain.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLocked() {
/* 184 */     return this.isLocked;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkLocked() {
/* 191 */     if (this.isLocked == true) {
/* 192 */       throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void lockChain() {
/* 202 */     if (!this.isLocked) {
/* 203 */       this.isLocked = true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateCurrentIterator() {
/* 212 */     if (this.currentIterator == null) {
/* 213 */       if (this.iteratorChain.isEmpty()) {
/* 214 */         this.currentIterator = EmptyIterator.emptyIterator();
/*     */       } else {
/* 216 */         this.currentIterator = this.iteratorChain.remove();
/*     */       } 
/*     */ 
/*     */       
/* 220 */       this.lastUsedIterator = this.currentIterator;
/*     */     } 
/*     */     
/* 223 */     while (!this.currentIterator.hasNext() && !this.iteratorChain.isEmpty()) {
/* 224 */       this.currentIterator = this.iteratorChain.remove();
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
/* 235 */     lockChain();
/* 236 */     updateCurrentIterator();
/* 237 */     this.lastUsedIterator = this.currentIterator;
/*     */     
/* 239 */     return this.currentIterator.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E next() {
/* 250 */     lockChain();
/* 251 */     updateCurrentIterator();
/* 252 */     this.lastUsedIterator = this.currentIterator;
/*     */     
/* 254 */     return this.currentIterator.next();
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
/* 271 */     lockChain();
/* 272 */     if (this.currentIterator == null) {
/* 273 */       updateCurrentIterator();
/*     */     }
/* 275 */     this.lastUsedIterator.remove();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\IteratorChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */