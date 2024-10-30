/*     */ package org.apache.commons.collections4.collection;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections4.iterators.EmptyIterator;
/*     */ import org.apache.commons.collections4.iterators.IteratorChain;
/*     */ import org.apache.commons.collections4.list.UnmodifiableList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompositeCollection<E>
/*     */   implements Serializable, Collection<E>
/*     */ {
/*     */   private static final long serialVersionUID = 8417515734108306801L;
/*     */   private CollectionMutator<E> mutator;
/*  51 */   private final List<Collection<E>> all = new ArrayList<Collection<E>>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeCollection() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeCollection(Collection<E> paramCollection) {
/*  67 */     addComposited(paramCollection);
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
/*     */   public CompositeCollection(Collection<E> paramCollection1, Collection<E> paramCollection2) {
/*  79 */     addComposited(paramCollection1, paramCollection2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeCollection(Collection<E>... paramVarArgs) {
/*  89 */     addComposited(paramVarArgs);
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
/*     */   public int size() {
/* 102 */     int i = 0;
/* 103 */     for (Collection<E> collection : this.all) {
/* 104 */       i += collection.size();
/*     */     }
/* 106 */     return i;
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
/*     */   public boolean isEmpty() {
/* 118 */     for (Collection<E> collection : this.all) {
/* 119 */       if (!collection.isEmpty()) {
/* 120 */         return false;
/*     */       }
/*     */     } 
/* 123 */     return true;
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
/*     */   public boolean contains(Object paramObject) {
/* 136 */     for (Collection<E> collection : this.all) {
/* 137 */       if (collection.contains(paramObject)) {
/* 138 */         return true;
/*     */       }
/*     */     } 
/* 141 */     return false;
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
/*     */   public Iterator<E> iterator() {
/* 156 */     if (this.all.isEmpty()) {
/* 157 */       return EmptyIterator.emptyIterator();
/*     */     }
/* 159 */     IteratorChain iteratorChain = new IteratorChain();
/* 160 */     for (Collection<E> collection : this.all) {
/* 161 */       iteratorChain.addIterator(collection.iterator());
/*     */     }
/* 163 */     return (Iterator<E>)iteratorChain;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 173 */     Object[] arrayOfObject = new Object[size()];
/* 174 */     byte b = 0;
/* 175 */     for (Iterator<E> iterator = iterator(); iterator.hasNext(); b++) {
/* 176 */       arrayOfObject[b] = iterator.next();
/*     */     }
/* 178 */     return arrayOfObject;
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
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 192 */     int i = size();
/* 193 */     Object[] arrayOfObject = null;
/* 194 */     if (paramArrayOfT.length >= i) {
/* 195 */       T[] arrayOfT = paramArrayOfT;
/*     */     } else {
/* 197 */       arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
/*     */     } 
/*     */     
/* 200 */     byte b = 0;
/* 201 */     for (Collection<E> collection : this.all) {
/* 202 */       for (Object object : collection) {
/* 203 */         arrayOfObject[b++] = object;
/*     */       }
/*     */     } 
/* 206 */     if (arrayOfObject.length > i) {
/* 207 */       arrayOfObject[i] = null;
/*     */     }
/* 209 */     return (T[])arrayOfObject;
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
/*     */   public boolean add(E paramE) {
/* 226 */     if (this.mutator == null) {
/* 227 */       throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
/*     */     }
/*     */     
/* 230 */     return this.mutator.add(this, this.all, paramE);
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
/*     */   public boolean remove(Object paramObject) {
/* 246 */     if (this.mutator == null) {
/* 247 */       throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
/*     */     }
/*     */     
/* 250 */     return this.mutator.remove(this, this.all, paramObject);
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
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 264 */     for (Object object : paramCollection) {
/* 265 */       if (!contains(object)) {
/* 266 */         return false;
/*     */       }
/*     */     } 
/* 269 */     return true;
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
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 286 */     if (this.mutator == null) {
/* 287 */       throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
/*     */     }
/*     */     
/* 290 */     return this.mutator.addAll(this, this.all, paramCollection);
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
/* 304 */     if (paramCollection.size() == 0) {
/* 305 */       return false;
/*     */     }
/* 307 */     boolean bool = false;
/* 308 */     for (Collection<E> collection : this.all) {
/* 309 */       bool |= collection.removeAll(paramCollection);
/*     */     }
/* 311 */     return bool;
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
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 326 */     boolean bool = false;
/* 327 */     for (Collection<E> collection : this.all) {
/* 328 */       bool |= collection.retainAll(paramCollection);
/*     */     }
/* 330 */     return bool;
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
/*     */   public void clear() {
/* 342 */     for (Collection<E> collection : this.all) {
/* 343 */       collection.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMutator(CollectionMutator<E> paramCollectionMutator) {
/* 354 */     this.mutator = paramCollectionMutator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addComposited(Collection<E> paramCollection) {
/* 363 */     this.all.add(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addComposited(Collection<E> paramCollection1, Collection<E> paramCollection2) {
/* 374 */     this.all.add(paramCollection1);
/* 375 */     this.all.add(paramCollection2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addComposited(Collection<E>... paramVarArgs) {
/* 384 */     this.all.addAll(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeComposited(Collection<E> paramCollection) {
/* 393 */     this.all.remove(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<E> toCollection() {
/* 404 */     return new ArrayList<E>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Collection<E>> getCollections() {
/* 413 */     return UnmodifiableList.unmodifiableList(this.all);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CollectionMutator<E> getMutator() {
/* 421 */     return this.mutator;
/*     */   }
/*     */   
/*     */   public static interface CollectionMutator<E> extends Serializable {
/*     */     boolean add(CompositeCollection<E> param1CompositeCollection, List<Collection<E>> param1List, E param1E);
/*     */     
/*     */     boolean addAll(CompositeCollection<E> param1CompositeCollection, List<Collection<E>> param1List, Collection<? extends E> param1Collection);
/*     */     
/*     */     boolean remove(CompositeCollection<E> param1CompositeCollection, List<Collection<E>> param1List, Object param1Object);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\collection\CompositeCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */