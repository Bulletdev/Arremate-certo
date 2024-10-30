/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import org.apache.commons.collections4.SortedBag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CollectionSortedBag<E>
/*     */   extends AbstractSortedBagDecorator<E>
/*     */ {
/*     */   private static final long serialVersionUID = -2560033712679053143L;
/*     */   
/*     */   public static <E> SortedBag<E> collectionSortedBag(SortedBag<E> paramSortedBag) {
/*  47 */     return new CollectionSortedBag<E>(paramSortedBag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CollectionSortedBag(SortedBag<E> paramSortedBag) {
/*  58 */     super(paramSortedBag);
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
/*  69 */     paramObjectOutputStream.defaultWriteObject();
/*  70 */     paramObjectOutputStream.writeObject(decorated());
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
/*  83 */     paramObjectInputStream.defaultReadObject();
/*  84 */     setCollection((Collection)paramObjectInputStream.readObject());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/*  93 */     Iterator<?> iterator = paramCollection.iterator();
/*  94 */     while (iterator.hasNext()) {
/*  95 */       if (!contains(iterator.next())) {
/*  96 */         return false;
/*     */       }
/*     */     } 
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 104 */     return add(paramE, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 109 */     boolean bool = false;
/* 110 */     Iterator<? extends E> iterator = paramCollection.iterator();
/* 111 */     while (iterator.hasNext()) {
/* 112 */       boolean bool1 = add(iterator.next(), 1);
/* 113 */       bool = (bool || bool1) ? true : false;
/*     */     } 
/* 115 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 120 */     return remove(paramObject, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 125 */     if (paramCollection != null) {
/* 126 */       boolean bool = false;
/* 127 */       Iterator<?> iterator = paramCollection.iterator();
/* 128 */       while (iterator.hasNext()) {
/* 129 */         Object object = iterator.next();
/* 130 */         boolean bool1 = remove(object, getCount(object));
/* 131 */         bool = (bool || bool1) ? true : false;
/*     */       } 
/* 133 */       return bool;
/*     */     } 
/*     */     
/* 136 */     return decorated().removeAll(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 142 */     if (paramCollection != null) {
/* 143 */       boolean bool = false;
/* 144 */       Iterator iterator = iterator();
/* 145 */       while (iterator.hasNext()) {
/* 146 */         if (!paramCollection.contains(iterator.next())) {
/* 147 */           iterator.remove();
/* 148 */           bool = true;
/*     */         } 
/*     */       } 
/* 151 */       return bool;
/*     */     } 
/*     */     
/* 154 */     return decorated().retainAll(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE, int paramInt) {
/* 164 */     decorated().add(paramE, paramInt);
/* 165 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\CollectionSortedBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */