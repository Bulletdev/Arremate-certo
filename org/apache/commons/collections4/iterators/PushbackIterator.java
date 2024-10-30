/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PushbackIterator<E>
/*     */   implements Iterator<E>
/*     */ {
/*     */   private final Iterator<? extends E> iterator;
/*  42 */   private Deque<E> items = new ArrayDeque<E>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> PushbackIterator<E> pushbackIterator(Iterator<? extends E> paramIterator) {
/*  56 */     if (paramIterator == null) {
/*  57 */       throw new NullPointerException("Iterator must not be null");
/*     */     }
/*  59 */     if (paramIterator instanceof PushbackIterator)
/*     */     {
/*  61 */       return (PushbackIterator)paramIterator;
/*     */     }
/*     */     
/*  64 */     return new PushbackIterator<E>(paramIterator);
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
/*     */   public PushbackIterator(Iterator<? extends E> paramIterator) {
/*  76 */     this.iterator = paramIterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void pushback(E paramE) {
/*  87 */     this.items.push(paramE);
/*     */   }
/*     */   
/*     */   public boolean hasNext() {
/*  91 */     return !this.items.isEmpty() ? true : this.iterator.hasNext();
/*     */   }
/*     */   
/*     */   public E next() {
/*  95 */     return !this.items.isEmpty() ? this.items.pop() : this.iterator.next();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 104 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\PushbackIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */