/*     */ package org.apache.commons.collections4.collection;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import org.apache.commons.collections4.BoundedCollection;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UnmodifiableBoundedCollection<E>
/*     */   extends AbstractCollectionDecorator<E>
/*     */   implements BoundedCollection<E>, Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = -7112672385450340330L;
/*     */   
/*     */   public static <E> BoundedCollection<E> unmodifiableBoundedCollection(BoundedCollection<? extends E> paramBoundedCollection) {
/*  59 */     if (paramBoundedCollection instanceof Unmodifiable)
/*     */     {
/*  61 */       return (BoundedCollection)paramBoundedCollection;
/*     */     }
/*     */     
/*  64 */     return new UnmodifiableBoundedCollection<E>(paramBoundedCollection);
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
/*     */   public static <E> BoundedCollection<E> unmodifiableBoundedCollection(Collection<? extends E> paramCollection) {
/*  82 */     if (paramCollection == null) {
/*  83 */       throw new NullPointerException("Collection must not be null.");
/*     */     }
/*     */ 
/*     */     
/*  87 */     for (byte b = 0; b < 'Ϩ' && 
/*  88 */       !(paramCollection instanceof BoundedCollection); b++) {
/*     */ 
/*     */       
/*  91 */       if (paramCollection instanceof AbstractCollectionDecorator) {
/*  92 */         paramCollection = ((AbstractCollectionDecorator<? extends E>)paramCollection).decorated();
/*  93 */       } else if (paramCollection instanceof SynchronizedCollection) {
/*  94 */         paramCollection = ((SynchronizedCollection<? extends E>)paramCollection).decorated();
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     if (!(paramCollection instanceof BoundedCollection)) {
/*  99 */       throw new IllegalArgumentException("Collection is not a bounded collection.");
/*     */     }
/* 101 */     return new UnmodifiableBoundedCollection<E>((BoundedCollection<? extends E>)paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnmodifiableBoundedCollection(BoundedCollection<? extends E> paramBoundedCollection) {
/* 112 */     super((Collection)paramBoundedCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 118 */     return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 123 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 128 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 133 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 138 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 143 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 148 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFull() {
/* 154 */     return decorated().isFull();
/*     */   }
/*     */ 
/*     */   
/*     */   public int maxSize() {
/* 159 */     return decorated().maxSize();
/*     */   }
/*     */ 
/*     */   
/*     */   protected BoundedCollection<E> decorated() {
/* 164 */     return (BoundedCollection<E>)super.decorated();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\collection\UnmodifiableBoundedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */