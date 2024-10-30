/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import org.apache.commons.collections4.Bag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CollectionBag<E>
/*     */   extends AbstractBagDecorator<E>
/*     */ {
/*     */   private static final long serialVersionUID = -2560033712679053143L;
/*     */   
/*     */   public static <E> Bag<E> collectionBag(Bag<E> paramBag) {
/*  55 */     return new CollectionBag<E>(paramBag);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CollectionBag(Bag<E> paramBag) {
/*  66 */     super(paramBag);
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
/*  77 */     paramObjectOutputStream.defaultWriteObject();
/*  78 */     paramObjectOutputStream.writeObject(decorated());
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
/*  91 */     paramObjectInputStream.defaultReadObject();
/*  92 */     setCollection((Collection)paramObjectInputStream.readObject());
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
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 111 */     Iterator<?> iterator = paramCollection.iterator();
/* 112 */     while (iterator.hasNext()) {
/* 113 */       if (!contains(iterator.next())) {
/* 114 */         return false;
/*     */       }
/*     */     } 
/* 117 */     return true;
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
/*     */   public boolean add(E paramE) {
/* 132 */     return add(paramE, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 137 */     boolean bool = false;
/* 138 */     Iterator<? extends E> iterator = paramCollection.iterator();
/* 139 */     while (iterator.hasNext()) {
/* 140 */       boolean bool1 = add(iterator.next(), 1);
/* 141 */       bool = (bool || bool1) ? true : false;
/*     */     } 
/* 143 */     return bool;
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
/*     */   public boolean remove(Object paramObject) {
/* 158 */     return remove(paramObject, 1);
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
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 172 */     if (paramCollection != null) {
/* 173 */       boolean bool = false;
/* 174 */       Iterator<?> iterator = paramCollection.iterator();
/* 175 */       while (iterator.hasNext()) {
/* 176 */         Object object = iterator.next();
/* 177 */         boolean bool1 = remove(object, getCount(object));
/* 178 */         bool = (bool || bool1) ? true : false;
/*     */       } 
/* 180 */       return bool;
/*     */     } 
/*     */     
/* 183 */     return decorated().removeAll(null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 206 */     if (paramCollection != null) {
/* 207 */       boolean bool = false;
/* 208 */       Iterator iterator = iterator();
/* 209 */       while (iterator.hasNext()) {
/* 210 */         if (!paramCollection.contains(iterator.next())) {
/* 211 */           iterator.remove();
/* 212 */           bool = true;
/*     */         } 
/*     */       } 
/* 215 */       return bool;
/*     */     } 
/*     */     
/* 218 */     return decorated().retainAll(null);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE, int paramInt) {
/* 239 */     decorated().add(paramE, paramInt);
/* 240 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\CollectionBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */