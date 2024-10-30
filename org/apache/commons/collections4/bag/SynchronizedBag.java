/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Bag;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SynchronizedBag<E>
/*     */   extends SynchronizedCollection<E>
/*     */   implements Bag<E>
/*     */ {
/*     */   private static final long serialVersionUID = 8084674570753837109L;
/*     */   
/*     */   public static <E> SynchronizedBag<E> synchronizedBag(Bag<E> paramBag) {
/*  51 */     return new SynchronizedBag<E>(paramBag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SynchronizedBag(Bag<E> paramBag) {
/*  62 */     super((Collection)paramBag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SynchronizedBag(Bag<E> paramBag, Object paramObject) {
/*  73 */     super((Collection)paramBag, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Bag<E> getBag() {
/*  82 */     return (Bag<E>)decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  87 */     if (paramObject == this) {
/*  88 */       return true;
/*     */     }
/*  90 */     synchronized (this.lock) {
/*  91 */       return getBag().equals(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  97 */     synchronized (this.lock) {
/*  98 */       return getBag().hashCode();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE, int paramInt) {
/* 106 */     synchronized (this.lock) {
/* 107 */       return getBag().add(paramE, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject, int paramInt) {
/* 113 */     synchronized (this.lock) {
/* 114 */       return getBag().remove(paramObject, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 120 */     synchronized (this.lock) {
/* 121 */       Set<E> set = getBag().uniqueSet();
/* 122 */       return new SynchronizedBagSet(set, this.lock);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCount(Object paramObject) {
/* 128 */     synchronized (this.lock) {
/* 129 */       return getBag().getCount(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class SynchronizedBagSet
/*     */     extends SynchronizedCollection<E>
/*     */     implements Set<E>
/*     */   {
/*     */     private static final long serialVersionUID = 2990565892366827855L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SynchronizedBagSet(Set<E> param1Set, Object param1Object) {
/* 147 */       super(param1Set, param1Object);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\SynchronizedBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */