/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Bag;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UnmodifiableBag<E>
/*     */   extends AbstractBagDecorator<E>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = -1873799975157099624L;
/*     */   
/*     */   public static <E> Bag<E> unmodifiableBag(Bag<? extends E> paramBag) {
/*  59 */     if (paramBag instanceof Unmodifiable)
/*     */     {
/*  61 */       return (Bag)paramBag;
/*     */     }
/*     */     
/*  64 */     return new UnmodifiableBag<E>(paramBag);
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
/*     */   private UnmodifiableBag(Bag<? extends E> paramBag) {
/*  76 */     super((Bag)paramBag);
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
/*  87 */     paramObjectOutputStream.defaultWriteObject();
/*  88 */     paramObjectOutputStream.writeObject(decorated());
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
/* 101 */     paramObjectInputStream.defaultReadObject();
/* 102 */     setCollection((Collection)paramObjectInputStream.readObject());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 108 */     return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 113 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 118 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 123 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 128 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 133 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 138 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE, int paramInt) {
/* 144 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject, int paramInt) {
/* 149 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 154 */     Set set = decorated().uniqueSet();
/* 155 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\UnmodifiableBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */