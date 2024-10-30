/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import java.util.Collection;
/*     */ import java.util.Deque;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.BlockingDeque;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @c
/*     */ public abstract class aq<E>
/*     */   extends at<E>
/*     */   implements BlockingDeque<E>
/*     */ {
/*     */   public int remainingCapacity() {
/*  60 */     return a().remainingCapacity();
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFirst(E paramE) throws InterruptedException {
/*  65 */     a().putFirst(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putLast(E paramE) throws InterruptedException {
/*  70 */     a().putLast(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/*  75 */     return a().offerFirst(paramE, paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/*  80 */     return a().offerLast(paramE, paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public E takeFirst() throws InterruptedException {
/*  85 */     return a().takeFirst();
/*     */   }
/*     */ 
/*     */   
/*     */   public E takeLast() throws InterruptedException {
/*  90 */     return a().takeLast();
/*     */   }
/*     */ 
/*     */   
/*     */   public E pollFirst(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/*  95 */     return a().pollFirst(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public E pollLast(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/* 100 */     return a().pollLast(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public void put(E paramE) throws InterruptedException {
/* 105 */     a().put(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/* 110 */     return a().offer(paramE, paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public E take() throws InterruptedException {
/* 115 */     return a().take();
/*     */   }
/*     */ 
/*     */   
/*     */   public E poll(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/* 120 */     return a().poll(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public int drainTo(Collection<? super E> paramCollection) {
/* 125 */     return a().drainTo(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public int drainTo(Collection<? super E> paramCollection, int paramInt) {
/* 130 */     return a().drainTo(paramCollection, paramInt);
/*     */   }
/*     */   
/*     */   protected abstract BlockingDeque<E> a();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\aq.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */