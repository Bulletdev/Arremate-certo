/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
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
/*     */ public class CollatingIterator<E>
/*     */   implements Iterator<E>
/*     */ {
/*  44 */   private Comparator<? super E> comparator = null;
/*     */ 
/*     */   
/*  47 */   private List<Iterator<? extends E>> iterators = null;
/*     */ 
/*     */   
/*  50 */   private List<E> values = null;
/*     */ 
/*     */   
/*  53 */   private BitSet valueSet = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   private int lastReturned = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CollatingIterator() {
/*  71 */     this((Comparator<? super E>)null, 2);
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
/*     */   public CollatingIterator(Comparator<? super E> paramComparator) {
/*  83 */     this(paramComparator, 2);
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
/*     */   public CollatingIterator(Comparator<? super E> paramComparator, int paramInt) {
/*  98 */     this.iterators = new ArrayList<Iterator<? extends E>>(paramInt);
/*  99 */     setComparator(paramComparator);
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
/*     */   public CollatingIterator(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator1, Iterator<? extends E> paramIterator2) {
/* 115 */     this(paramComparator, 2);
/* 116 */     addIterator(paramIterator1);
/* 117 */     addIterator(paramIterator2);
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
/*     */   public CollatingIterator(Comparator<? super E> paramComparator, Iterator<? extends E>[] paramArrayOfIterator) {
/* 131 */     this(paramComparator, paramArrayOfIterator.length);
/* 132 */     for (Iterator<? extends E> iterator : paramArrayOfIterator) {
/* 133 */       addIterator(iterator);
/*     */     }
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
/*     */   public CollatingIterator(Comparator<? super E> paramComparator, Collection<Iterator<? extends E>> paramCollection) {
/* 150 */     this(paramComparator, paramCollection.size());
/* 151 */     for (Iterator<? extends E> iterator : paramCollection) {
/* 152 */       addIterator(iterator);
/*     */     }
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
/*     */   public void addIterator(Iterator<? extends E> paramIterator) {
/* 166 */     checkNotStarted();
/* 167 */     if (paramIterator == null) {
/* 168 */       throw new NullPointerException("Iterator must not be null");
/*     */     }
/* 170 */     this.iterators.add(paramIterator);
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
/*     */   public void setIterator(int paramInt, Iterator<? extends E> paramIterator) {
/* 183 */     checkNotStarted();
/* 184 */     if (paramIterator == null) {
/* 185 */       throw new NullPointerException("Iterator must not be null");
/*     */     }
/* 187 */     this.iterators.set(paramInt, paramIterator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Iterator<? extends E>> getIterators() {
/* 196 */     return UnmodifiableList.unmodifiableList(this.iterators);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<? super E> getComparator() {
/* 205 */     return this.comparator;
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
/*     */   public void setComparator(Comparator<? super E> paramComparator) {
/* 219 */     checkNotStarted();
/* 220 */     this.comparator = paramComparator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 231 */     start();
/* 232 */     return (anyValueSet(this.valueSet) || anyHasNext(this.iterators));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E next() throws NoSuchElementException {
/* 242 */     if (!hasNext()) {
/* 243 */       throw new NoSuchElementException();
/*     */     }
/* 245 */     int i = least();
/* 246 */     if (i == -1) {
/* 247 */       throw new NoSuchElementException();
/*     */     }
/* 249 */     E e = this.values.get(i);
/* 250 */     clear(i);
/* 251 */     this.lastReturned = i;
/* 252 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 262 */     if (this.lastReturned == -1) {
/* 263 */       throw new IllegalStateException("No value can be removed at present");
/*     */     }
/* 265 */     ((Iterator)this.iterators.get(this.lastReturned)).remove();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIteratorIndex() {
/* 275 */     if (this.lastReturned == -1) {
/* 276 */       throw new IllegalStateException("No value has been returned yet");
/*     */     }
/*     */     
/* 279 */     return this.lastReturned;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void start() {
/* 288 */     if (this.values == null) {
/* 289 */       this.values = new ArrayList<E>(this.iterators.size());
/* 290 */       this.valueSet = new BitSet(this.iterators.size());
/* 291 */       for (byte b = 0; b < this.iterators.size(); b++) {
/* 292 */         this.values.add(null);
/* 293 */         this.valueSet.clear(b);
/*     */       } 
/*     */     } 
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
/*     */   private boolean set(int paramInt) {
/* 307 */     Iterator<E> iterator = (Iterator)this.iterators.get(paramInt);
/* 308 */     if (iterator.hasNext()) {
/* 309 */       this.values.set(paramInt, iterator.next());
/* 310 */       this.valueSet.set(paramInt);
/* 311 */       return true;
/*     */     } 
/* 313 */     this.values.set(paramInt, null);
/* 314 */     this.valueSet.clear(paramInt);
/* 315 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void clear(int paramInt) {
/* 323 */     this.values.set(paramInt, null);
/* 324 */     this.valueSet.clear(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkNotStarted() throws IllegalStateException {
/* 334 */     if (this.values != null) {
/* 335 */       throw new IllegalStateException("Can't do that after next or hasNext has been called.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int least() {
/* 346 */     byte b = -1;
/* 347 */     E e = null;
/* 348 */     for (byte b1 = 0; b1 < this.values.size(); b1++) {
/* 349 */       if (!this.valueSet.get(b1)) {
/* 350 */         set(b1);
/*     */       }
/* 352 */       if (this.valueSet.get(b1)) {
/* 353 */         if (b == -1) {
/* 354 */           b = b1;
/* 355 */           e = this.values.get(b1);
/*     */         } else {
/* 357 */           E e1 = this.values.get(b1);
/* 358 */           if (this.comparator == null) {
/* 359 */             throw new NullPointerException("You must invoke setComparator() to set a comparator first.");
/*     */           }
/* 361 */           if (this.comparator.compare(e1, e) < 0) {
/* 362 */             E e2 = e1;
/* 363 */             b = b1;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/* 368 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean anyValueSet(BitSet paramBitSet) {
/* 376 */     for (byte b = 0; b < paramBitSet.size(); b++) {
/* 377 */       if (paramBitSet.get(b)) {
/* 378 */         return true;
/*     */       }
/*     */     } 
/* 381 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean anyHasNext(List<Iterator<? extends E>> paramList) {
/* 389 */     for (Iterator<? extends E> iterator : paramList) {
/* 390 */       if (iterator.hasNext()) {
/* 391 */         return true;
/*     */       }
/*     */     } 
/* 394 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\CollatingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */