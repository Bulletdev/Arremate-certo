/*     */ package org.apache.commons.collections4.collection;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SynchronizedCollection<E>
/*     */   implements Serializable, Collection<E>
/*     */ {
/*     */   private static final long serialVersionUID = 2412805092710877986L;
/*     */   private final Collection<E> collection;
/*     */   protected final Object lock;
/*     */   
/*     */   public static <T> SynchronizedCollection<T> synchronizedCollection(Collection<T> paramCollection) {
/*  61 */     return new SynchronizedCollection<T>(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SynchronizedCollection(Collection<E> paramCollection) {
/*  72 */     if (paramCollection == null) {
/*  73 */       throw new NullPointerException("Collection must not be null.");
/*     */     }
/*  75 */     this.collection = paramCollection;
/*  76 */     this.lock = this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SynchronizedCollection(Collection<E> paramCollection, Object paramObject) {
/*  87 */     if (paramCollection == null) {
/*  88 */       throw new NullPointerException("Collection must not be null.");
/*     */     }
/*  90 */     if (paramObject == null) {
/*  91 */       throw new NullPointerException("Lock must not be null.");
/*     */     }
/*  93 */     this.collection = paramCollection;
/*  94 */     this.lock = paramObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<E> decorated() {
/* 103 */     return this.collection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 110 */     synchronized (this.lock) {
/* 111 */       return decorated().add(paramE);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 117 */     synchronized (this.lock) {
/* 118 */       return decorated().addAll(paramCollection);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 124 */     synchronized (this.lock) {
/* 125 */       decorated().clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 131 */     synchronized (this.lock) {
/* 132 */       return decorated().contains(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 138 */     synchronized (this.lock) {
/* 139 */       return decorated().containsAll(paramCollection);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 145 */     synchronized (this.lock) {
/* 146 */       return decorated().isEmpty();
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
/*     */   public Iterator<E> iterator() {
/* 163 */     return decorated().iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 168 */     synchronized (this.lock) {
/* 169 */       return decorated().toArray();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 175 */     synchronized (this.lock) {
/* 176 */       return decorated().toArray(paramArrayOfT);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 182 */     synchronized (this.lock) {
/* 183 */       return decorated().remove(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 189 */     synchronized (this.lock) {
/* 190 */       return decorated().removeAll(paramCollection);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 196 */     synchronized (this.lock) {
/* 197 */       return decorated().retainAll(paramCollection);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 203 */     synchronized (this.lock) {
/* 204 */       return decorated().size();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 210 */     synchronized (this.lock) {
/* 211 */       if (paramObject == this) {
/* 212 */         return true;
/*     */       }
/* 214 */       return (paramObject == this || decorated().equals(paramObject));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 220 */     synchronized (this.lock) {
/* 221 */       return decorated().hashCode();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 227 */     synchronized (this.lock) {
/* 228 */       return decorated().toString();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\collection\SynchronizedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */