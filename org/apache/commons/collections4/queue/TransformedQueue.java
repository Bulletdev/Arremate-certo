/*     */ package org.apache.commons.collections4.queue;
/*     */ 
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.collection.TransformedCollection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformedQueue<E>
/*     */   extends TransformedCollection<E>
/*     */   implements Queue<E>
/*     */ {
/*     */   private static final long serialVersionUID = -7901091318986132033L;
/*     */   
/*     */   public static <E> TransformedQueue<E> transformingQueue(Queue<E> paramQueue, Transformer<? super E, ? extends E> paramTransformer) {
/*  55 */     return new TransformedQueue<E>(paramQueue, paramTransformer);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> TransformedQueue<E> transformedQueue(Queue<E> paramQueue, Transformer<? super E, ? extends E> paramTransformer) {
/*  76 */     TransformedQueue<E> transformedQueue = new TransformedQueue<E>(paramQueue, paramTransformer);
/*  77 */     if (paramQueue.size() > 0) {
/*     */       
/*  79 */       Object[] arrayOfObject = paramQueue.toArray();
/*  80 */       paramQueue.clear();
/*  81 */       for (Object object : arrayOfObject) {
/*  82 */         transformedQueue.decorated().add(paramTransformer.transform(object));
/*     */       }
/*     */     } 
/*  85 */     return transformedQueue;
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
/*     */   protected TransformedQueue(Queue<E> paramQueue, Transformer<? super E, ? extends E> paramTransformer) {
/* 100 */     super(paramQueue, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Queue<E> getQueue() {
/* 109 */     return (Queue<E>)decorated();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean offer(E paramE) {
/* 115 */     return getQueue().offer((E)transform(paramE));
/*     */   }
/*     */   
/*     */   public E poll() {
/* 119 */     return getQueue().poll();
/*     */   }
/*     */   
/*     */   public E peek() {
/* 123 */     return getQueue().peek();
/*     */   }
/*     */   
/*     */   public E element() {
/* 127 */     return getQueue().element();
/*     */   }
/*     */   
/*     */   public E remove() {
/* 131 */     return getQueue().remove();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\queue\TransformedQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */