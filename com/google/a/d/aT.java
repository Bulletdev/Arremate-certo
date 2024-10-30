/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.b.a.a;
/*     */ import java.util.Collection;
/*     */ import java.util.Deque;
/*     */ import java.util.Iterator;
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
/*     */ @c
/*     */ public abstract class at<E>
/*     */   extends aJ<E>
/*     */   implements Deque<E>
/*     */ {
/*     */   public void addFirst(E paramE) {
/*  52 */     a().addFirst(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addLast(E paramE) {
/*  57 */     a().addLast(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> descendingIterator() {
/*  62 */     return a().descendingIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public E getFirst() {
/*  67 */     return a().getFirst();
/*     */   }
/*     */ 
/*     */   
/*     */   public E getLast() {
/*  72 */     return a().getLast();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean offerFirst(E paramE) {
/*  78 */     return a().offerFirst(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean offerLast(E paramE) {
/*  84 */     return a().offerLast(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E peekFirst() {
/*  89 */     return a().peekFirst();
/*     */   }
/*     */ 
/*     */   
/*     */   public E peekLast() {
/*  94 */     return a().peekLast();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public E pollFirst() {
/* 100 */     return a().pollFirst();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public E pollLast() {
/* 106 */     return a().pollLast();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public E pop() {
/* 112 */     return a().pop();
/*     */   }
/*     */ 
/*     */   
/*     */   public void push(E paramE) {
/* 117 */     a().push(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public E removeFirst() {
/* 123 */     return a().removeFirst();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public E removeLast() {
/* 129 */     return a().removeLast();
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean removeFirstOccurrence(Object paramObject) {
/* 135 */     return a().removeFirstOccurrence(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   @a
/*     */   public boolean removeLastOccurrence(Object paramObject) {
/* 141 */     return a().removeLastOccurrence(paramObject);
/*     */   }
/*     */   
/*     */   protected abstract Deque<E> a();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\at.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */