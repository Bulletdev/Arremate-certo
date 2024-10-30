/*     */ package org.apache.commons.collections4.multiset;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.collection.SynchronizedCollection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SynchronizedMultiSet<E>
/*     */   extends SynchronizedCollection<E>
/*     */   implements MultiSet<E>
/*     */ {
/*     */   private static final long serialVersionUID = 20150629L;
/*     */   
/*     */   public static <E> SynchronizedMultiSet<E> synchronizedMultiSet(MultiSet<E> paramMultiSet) {
/*  48 */     return new SynchronizedMultiSet<E>(paramMultiSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SynchronizedMultiSet(MultiSet<E> paramMultiSet) {
/*  59 */     super((Collection)paramMultiSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SynchronizedMultiSet(MultiSet<E> paramMultiSet, Object paramObject) {
/*  70 */     super((Collection)paramMultiSet, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected MultiSet<E> decorated() {
/*  80 */     return (MultiSet<E>)super.decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  85 */     if (paramObject == this) {
/*  86 */       return true;
/*     */     }
/*  88 */     synchronized (this.lock) {
/*  89 */       return decorated().equals(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  95 */     synchronized (this.lock) {
/*  96 */       return decorated().hashCode();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int add(E paramE, int paramInt) {
/* 104 */     synchronized (this.lock) {
/* 105 */       return decorated().add(paramE, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int remove(Object paramObject, int paramInt) {
/* 111 */     synchronized (this.lock) {
/* 112 */       return decorated().remove(paramObject, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCount(Object paramObject) {
/* 118 */     synchronized (this.lock) {
/* 119 */       return decorated().getCount(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int setCount(E paramE, int paramInt) {
/* 125 */     synchronized (this.lock) {
/* 126 */       return decorated().setCount(paramE, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 132 */     synchronized (this.lock) {
/* 133 */       Set<E> set = decorated().uniqueSet();
/* 134 */       return new SynchronizedSet<E>(set, this.lock);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<MultiSet.Entry<E>> entrySet() {
/* 140 */     synchronized (this.lock) {
/* 141 */       Set<MultiSet.Entry<E>> set = decorated().entrySet();
/* 142 */       return new SynchronizedSet<MultiSet.Entry<E>>(set, this.lock);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class SynchronizedSet<T>
/*     */     extends SynchronizedCollection<T>
/*     */     implements Set<T>
/*     */   {
/*     */     private static final long serialVersionUID = 20150629L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SynchronizedSet(Set<T> param1Set, Object param1Object) {
/* 160 */       super(param1Set, param1Object);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multiset\SynchronizedMultiSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */