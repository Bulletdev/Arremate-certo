/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.SortedSet;
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
/*     */ public final class UnmodifiableSortedSet<E>
/*     */   extends AbstractSortedSetDecorator<E>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = -725356885467962424L;
/*     */   
/*     */   public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> paramSortedSet) {
/*  56 */     if (paramSortedSet instanceof Unmodifiable) {
/*  57 */       return paramSortedSet;
/*     */     }
/*  59 */     return new UnmodifiableSortedSet<E>(paramSortedSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnmodifiableSortedSet(SortedSet<E> paramSortedSet) {
/*  70 */     super(paramSortedSet);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/*  76 */     return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/*  81 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/*  86 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  91 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/*  96 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 101 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 106 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SortedSet<E> subSet(E paramE1, E paramE2) {
/* 112 */     SortedSet<E> sortedSet = decorated().subSet(paramE1, paramE2);
/* 113 */     return unmodifiableSortedSet(sortedSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedSet<E> headSet(E paramE) {
/* 118 */     SortedSet<E> sortedSet = decorated().headSet(paramE);
/* 119 */     return unmodifiableSortedSet(sortedSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedSet<E> tailSet(E paramE) {
/* 124 */     SortedSet<E> sortedSet = decorated().tailSet(paramE);
/* 125 */     return unmodifiableSortedSet(sortedSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 136 */     paramObjectOutputStream.defaultWriteObject();
/* 137 */     paramObjectOutputStream.writeObject(decorated());
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 149 */     paramObjectInputStream.defaultReadObject();
/* 150 */     setCollection((Collection)paramObjectInputStream.readObject());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\UnmodifiableSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */