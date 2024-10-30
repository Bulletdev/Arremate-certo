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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractCollectionDecorator<E>
/*     */   implements Serializable, Collection<E>
/*     */ {
/*     */   private static final long serialVersionUID = 6249888059822088500L;
/*     */   private Collection<E> collection;
/*     */   
/*     */   protected AbstractCollectionDecorator() {}
/*     */   
/*     */   protected AbstractCollectionDecorator(Collection<E> paramCollection) {
/*  79 */     if (paramCollection == null) {
/*  80 */       throw new NullPointerException("Collection must not be null.");
/*     */     }
/*  82 */     this.collection = paramCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<E> decorated() {
/*  92 */     return this.collection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setCollection(Collection<E> paramCollection) {
/* 103 */     this.collection = paramCollection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 110 */     return decorated().add(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 115 */     return decorated().addAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 120 */     decorated().clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 125 */     return decorated().contains(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 130 */     return decorated().isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 135 */     return decorated().iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 140 */     return decorated().remove(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 145 */     return decorated().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 150 */     return decorated().toArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 155 */     return decorated().toArray(paramArrayOfT);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 160 */     return decorated().containsAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 165 */     return decorated().removeAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 170 */     return decorated().retainAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     return decorated().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\collection\AbstractCollectionDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */