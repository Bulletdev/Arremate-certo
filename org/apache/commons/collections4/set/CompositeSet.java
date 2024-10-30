/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.CollectionUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompositeSet<E>
/*     */   implements Serializable, Set<E>
/*     */ {
/*     */   private static final long serialVersionUID = 5185069727540378940L;
/*     */   private SetMutator<E> mutator;
/*  58 */   private final List<Set<E>> all = new ArrayList<Set<E>>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeSet() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeSet(Set<E> paramSet) {
/*  74 */     addComposited(paramSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CompositeSet(Set<E>... paramVarArgs) {
/*  84 */     addComposited(paramVarArgs);
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
/*     */   public int size() {
/*  96 */     int i = 0;
/*  97 */     for (Set<E> set : this.all) {
/*  98 */       i += set.size();
/*     */     }
/* 100 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 111 */     for (Set<E> set : this.all) {
/* 112 */       if (!set.isEmpty()) {
/* 113 */         return false;
/*     */       }
/*     */     } 
/* 116 */     return true;
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
/*     */   public boolean contains(Object paramObject) {
/* 128 */     for (Set<E> set : this.all) {
/* 129 */       if (set.contains(paramObject)) {
/* 130 */         return true;
/*     */       }
/*     */     } 
/* 133 */     return false;
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
/*     */   public Iterator<E> iterator() {
/* 147 */     if (this.all.isEmpty()) {
/* 148 */       return EmptyIterator.emptyIterator();
/*     */     }
/* 150 */     IteratorChain iteratorChain = new IteratorChain();
/* 151 */     for (Set<E> set : this.all) {
/* 152 */       iteratorChain.addIterator(set.iterator());
/*     */     }
/* 154 */     return (Iterator<E>)iteratorChain;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 163 */     Object[] arrayOfObject = new Object[size()];
/* 164 */     byte b = 0;
/* 165 */     for (Iterator<E> iterator = iterator(); iterator.hasNext(); b++) {
/* 166 */       arrayOfObject[b] = iterator.next();
/*     */     }
/* 168 */     return arrayOfObject;
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
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 181 */     int i = size();
/* 182 */     Object[] arrayOfObject = null;
/* 183 */     if (paramArrayOfT.length >= i) {
/* 184 */       T[] arrayOfT = paramArrayOfT;
/*     */     } else {
/* 186 */       arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
/*     */     } 
/*     */     
/* 189 */     byte b = 0;
/* 190 */     for (Collection<E> collection : this.all) {
/* 191 */       for (Object object : collection) {
/* 192 */         arrayOfObject[b++] = object;
/*     */       }
/*     */     } 
/* 195 */     if (arrayOfObject.length > i) {
/* 196 */       arrayOfObject[i] = null;
/*     */     }
/* 198 */     return (T[])arrayOfObject;
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
/* 213 */     if (this.mutator == null) {
/* 214 */       throw new UnsupportedOperationException("add() is not supported on CompositeSet without a SetMutator strategy");
/*     */     }
/*     */     
/* 217 */     return this.mutator.add(this, this.all, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 228 */     for (Set<E> set : getSets()) {
/* 229 */       if (set.contains(paramObject)) {
/* 230 */         return set.remove(paramObject);
/*     */       }
/*     */     } 
/* 233 */     return false;
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
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 246 */     for (Object object : paramCollection) {
/* 247 */       if (!contains(object)) {
/* 248 */         return false;
/*     */       }
/*     */     } 
/* 251 */     return true;
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
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 266 */     if (this.mutator == null) {
/* 267 */       throw new UnsupportedOperationException("addAll() is not supported on CompositeSet without a SetMutator strategy");
/*     */     }
/*     */     
/* 270 */     return this.mutator.addAll(this, this.all, paramCollection);
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
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 283 */     if (paramCollection.size() == 0) {
/* 284 */       return false;
/*     */     }
/* 286 */     boolean bool = false;
/* 287 */     for (Collection<E> collection : this.all) {
/* 288 */       bool |= collection.removeAll(paramCollection);
/*     */     }
/* 290 */     return bool;
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
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 304 */     boolean bool = false;
/* 305 */     for (Collection<E> collection : this.all) {
/* 306 */       bool |= collection.retainAll(paramCollection);
/*     */     }
/* 308 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 319 */     for (Collection<E> collection : this.all) {
/* 320 */       collection.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMutator(SetMutator<E> paramSetMutator) {
/* 331 */     this.mutator = paramSetMutator;
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
/*     */   public synchronized void addComposited(Set<E> paramSet) {
/* 344 */     for (Set<E> set : getSets()) {
/* 345 */       Collection<E> collection = CollectionUtils.intersection(set, paramSet);
/* 346 */       if (collection.size() > 0) {
/* 347 */         if (this.mutator == null) {
/* 348 */           throw new UnsupportedOperationException("Collision adding composited set with no SetMutator set");
/*     */         }
/*     */         
/* 351 */         getMutator().resolveCollision(this, set, paramSet, collection);
/* 352 */         if (CollectionUtils.intersection(set, paramSet).size() > 0) {
/* 353 */           throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 358 */     this.all.add(paramSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addComposited(Set<E> paramSet1, Set<E> paramSet2) {
/* 368 */     addComposited(paramSet1);
/* 369 */     addComposited(paramSet2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addComposited(Set<E>... paramVarArgs) {
/* 378 */     for (Set<E> set : paramVarArgs) {
/* 379 */       addComposited(set);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeComposited(Set<E> paramSet) {
/* 389 */     this.all.remove(paramSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<E> toSet() {
/* 400 */     return new HashSet<E>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Set<E>> getSets() {
/* 409 */     return UnmodifiableList.unmodifiableList(this.all);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SetMutator<E> getMutator() {
/* 417 */     return this.mutator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 426 */     if (paramObject instanceof Set) {
/* 427 */       Set set = (Set)paramObject;
/* 428 */       return (set.size() == size() && set.containsAll(this));
/*     */     } 
/* 430 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 439 */     int i = 0;
/* 440 */     for (E e : this) {
/* 441 */       i += (e == null) ? 0 : e.hashCode();
/*     */     }
/* 443 */     return i;
/*     */   }
/*     */   
/*     */   public static interface SetMutator<E> extends Serializable {
/*     */     boolean add(CompositeSet<E> param1CompositeSet, List<Set<E>> param1List, E param1E);
/*     */     
/*     */     boolean addAll(CompositeSet<E> param1CompositeSet, List<Set<E>> param1List, Collection<? extends E> param1Collection);
/*     */     
/*     */     void resolveCollision(CompositeSet<E> param1CompositeSet, Set<E> param1Set1, Set<E> param1Set2, Collection<E> param1Collection);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\CompositeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */