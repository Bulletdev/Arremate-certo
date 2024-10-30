/*     */ package org.apache.commons.collections4.multiset;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableIterator;
/*     */ import org.apache.commons.collections4.set.UnmodifiableSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UnmodifiableMultiSet<E>
/*     */   extends AbstractMultiSetDecorator<E>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = 20150611L;
/*     */   
/*     */   public static <E> MultiSet<E> unmodifiableMultiSet(MultiSet<? extends E> paramMultiSet) {
/*  56 */     if (paramMultiSet instanceof Unmodifiable)
/*     */     {
/*  58 */       return (MultiSet)paramMultiSet;
/*     */     }
/*     */     
/*  61 */     return new UnmodifiableMultiSet<E>(paramMultiSet);
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
/*     */   private UnmodifiableMultiSet(MultiSet<? extends E> paramMultiSet) {
/*  73 */     super((MultiSet)paramMultiSet);
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
/*  84 */     paramObjectOutputStream.defaultWriteObject();
/*  85 */     paramObjectOutputStream.writeObject(decorated());
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/*  98 */     paramObjectInputStream.defaultReadObject();
/*  99 */     setCollection((Collection)paramObjectInputStream.readObject());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 105 */     return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 110 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 115 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 120 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 125 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 130 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 135 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int setCount(E paramE, int paramInt) {
/* 141 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public int add(E paramE, int paramInt) {
/* 146 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public int remove(Object paramObject, int paramInt) {
/* 151 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 156 */     Set set = decorated().uniqueSet();
/* 157 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<MultiSet.Entry<E>> entrySet() {
/* 162 */     Set set = decorated().entrySet();
/* 163 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multiset\UnmodifiableMultiSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */