/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.NavigableSet;
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
/*     */ public final class UnmodifiableNavigableSet<E>
/*     */   extends AbstractNavigableSetDecorator<E>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = 20150528L;
/*     */   
/*     */   public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> paramNavigableSet) {
/*  54 */     if (paramNavigableSet instanceof Unmodifiable) {
/*  55 */       return paramNavigableSet;
/*     */     }
/*  57 */     return new UnmodifiableNavigableSet<E>(paramNavigableSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnmodifiableNavigableSet(NavigableSet<E> paramNavigableSet) {
/*  68 */     super(paramNavigableSet);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/*  74 */     return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/*  79 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  89 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/*  94 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/*  99 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 104 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SortedSet<E> subSet(E paramE1, E paramE2) {
/* 111 */     SortedSet<E> sortedSet = decorated().subSet(paramE1, paramE2);
/* 112 */     return UnmodifiableSortedSet.unmodifiableSortedSet(sortedSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedSet<E> headSet(E paramE) {
/* 117 */     SortedSet<E> sortedSet = decorated().headSet(paramE);
/* 118 */     return UnmodifiableSortedSet.unmodifiableSortedSet(sortedSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedSet<E> tailSet(E paramE) {
/* 123 */     SortedSet<E> sortedSet = decorated().tailSet(paramE);
/* 124 */     return UnmodifiableSortedSet.unmodifiableSortedSet(sortedSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NavigableSet<E> descendingSet() {
/* 131 */     return unmodifiableNavigableSet(decorated().descendingSet());
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> descendingIterator() {
/* 136 */     return UnmodifiableIterator.unmodifiableIterator(decorated().descendingIterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
/* 141 */     NavigableSet<E> navigableSet = decorated().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2);
/* 142 */     return unmodifiableNavigableSet(navigableSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> headSet(E paramE, boolean paramBoolean) {
/* 147 */     NavigableSet<E> navigableSet = decorated().headSet(paramE, paramBoolean);
/* 148 */     return unmodifiableNavigableSet(navigableSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> tailSet(E paramE, boolean paramBoolean) {
/* 153 */     NavigableSet<E> navigableSet = decorated().tailSet(paramE, paramBoolean);
/* 154 */     return unmodifiableNavigableSet(navigableSet);
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
/* 165 */     paramObjectOutputStream.defaultWriteObject();
/* 166 */     paramObjectOutputStream.writeObject(decorated());
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
/* 178 */     paramObjectInputStream.defaultReadObject();
/* 179 */     setCollection((Collection)paramObjectInputStream.readObject());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\UnmodifiableNavigableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */