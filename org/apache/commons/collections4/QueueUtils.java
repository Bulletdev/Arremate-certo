/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.collections4.queue.PredicatedQueue;
/*     */ import org.apache.commons.collections4.queue.TransformedQueue;
/*     */ import org.apache.commons.collections4.queue.UnmodifiableQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueueUtils
/*     */ {
/*  38 */   public static final Queue EMPTY_QUEUE = UnmodifiableQueue.unmodifiableQueue(new LinkedList());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Queue<E> unmodifiableQueue(Queue<? extends E> paramQueue) {
/*  56 */     return UnmodifiableQueue.unmodifiableQueue(paramQueue);
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
/*     */   public static <E> Queue<E> predicatedQueue(Queue<E> paramQueue, Predicate<? super E> paramPredicate) {
/*  74 */     return (Queue<E>)PredicatedQueue.predicatedQueue(paramQueue, paramPredicate);
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
/*     */   public static <E> Queue<E> transformingQueue(Queue<E> paramQueue, Transformer<? super E, ? extends E> paramTransformer) {
/*  95 */     return (Queue<E>)TransformedQueue.transformingQueue(paramQueue, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Queue<E> emptyQueue() {
/* 106 */     return EMPTY_QUEUE;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\QueueUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */