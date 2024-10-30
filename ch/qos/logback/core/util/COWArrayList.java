/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class COWArrayList<E>
/*     */   implements List<E>
/*     */ {
/*  45 */   AtomicBoolean fresh = new AtomicBoolean(false);
/*  46 */   CopyOnWriteArrayList<E> underlyingList = new CopyOnWriteArrayList<E>();
/*     */   E[] ourCopy;
/*     */   final E[] modelArray;
/*     */   
/*     */   public COWArrayList(E[] paramArrayOfE) {
/*  51 */     this.modelArray = paramArrayOfE;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  56 */     return this.underlyingList.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  61 */     return this.underlyingList.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/*  66 */     return this.underlyingList.contains(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/*  71 */     return this.underlyingList.iterator();
/*     */   }
/*     */   
/*     */   private void refreshCopyIfNecessary() {
/*  75 */     if (!isFresh()) {
/*  76 */       refreshCopy();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isFresh() {
/*  81 */     return this.fresh.get();
/*     */   }
/*     */   
/*     */   private void refreshCopy() {
/*  85 */     this.ourCopy = this.underlyingList.toArray(this.modelArray);
/*  86 */     this.fresh.set(true);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/*  91 */     refreshCopyIfNecessary();
/*  92 */     return (Object[])this.ourCopy;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/*  98 */     refreshCopyIfNecessary();
/*  99 */     return (T[])this.ourCopy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E[] asTypedArray() {
/* 110 */     refreshCopyIfNecessary();
/* 111 */     return this.ourCopy;
/*     */   }
/*     */   
/*     */   private void markAsStale() {
/* 115 */     this.fresh.set(false);
/*     */   }
/*     */   
/*     */   public void addIfAbsent(E paramE) {
/* 119 */     this.underlyingList.addIfAbsent(paramE);
/* 120 */     markAsStale();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 125 */     boolean bool = this.underlyingList.add(paramE);
/* 126 */     markAsStale();
/* 127 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 132 */     boolean bool = this.underlyingList.remove(paramObject);
/* 133 */     markAsStale();
/* 134 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 139 */     return this.underlyingList.containsAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 144 */     boolean bool = this.underlyingList.addAll(paramCollection);
/* 145 */     markAsStale();
/* 146 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/* 151 */     boolean bool = this.underlyingList.addAll(paramInt, paramCollection);
/* 152 */     markAsStale();
/* 153 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 158 */     boolean bool = this.underlyingList.removeAll(paramCollection);
/* 159 */     markAsStale();
/* 160 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 165 */     boolean bool = this.underlyingList.retainAll(paramCollection);
/* 166 */     markAsStale();
/* 167 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 172 */     this.underlyingList.clear();
/* 173 */     markAsStale();
/*     */   }
/*     */ 
/*     */   
/*     */   public E get(int paramInt) {
/* 178 */     refreshCopyIfNecessary();
/* 179 */     return this.ourCopy[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public E set(int paramInt, E paramE) {
/* 184 */     E e = this.underlyingList.set(paramInt, paramE);
/* 185 */     markAsStale();
/* 186 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int paramInt, E paramE) {
/* 191 */     this.underlyingList.add(paramInt, paramE);
/* 192 */     markAsStale();
/*     */   }
/*     */ 
/*     */   
/*     */   public E remove(int paramInt) {
/* 197 */     E e = this.underlyingList.remove(paramInt);
/* 198 */     markAsStale();
/* 199 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 204 */     return this.underlyingList.indexOf(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/* 209 */     return this.underlyingList.lastIndexOf(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 214 */     return this.underlyingList.listIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/* 219 */     return this.underlyingList.listIterator(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 224 */     return this.underlyingList.subList(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\COWArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */