/*     */ package org.apache.commons.collections4.queue;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.collection.PredicatedCollection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PredicatedQueue<E>
/*     */   extends PredicatedCollection<E>
/*     */   implements Queue<E>
/*     */ {
/*     */   private static final long serialVersionUID = 2307609000539943581L;
/*     */   
/*     */   public static <E> PredicatedQueue<E> predicatedQueue(Queue<E> paramQueue, Predicate<? super E> paramPredicate) {
/*  58 */     return new PredicatedQueue<E>(paramQueue, paramPredicate);
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
/*     */   protected PredicatedQueue(Queue<E> paramQueue, Predicate<? super E> paramPredicate) {
/*  74 */     super(paramQueue, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Queue<E> decorated() {
/*  84 */     return (Queue<E>)super.decorated();
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
/*     */   public boolean offer(E paramE) {
/*  98 */     validate(paramE);
/*  99 */     return decorated().offer(paramE);
/*     */   }
/*     */   
/*     */   public E poll() {
/* 103 */     return decorated().poll();
/*     */   }
/*     */   
/*     */   public E peek() {
/* 107 */     return decorated().peek();
/*     */   }
/*     */   
/*     */   public E element() {
/* 111 */     return decorated().element();
/*     */   }
/*     */   
/*     */   public E remove() {
/* 115 */     return decorated().remove();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\queue\PredicatedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */