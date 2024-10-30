/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Collection;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Bag;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractMapBag<E>
/*     */   implements Bag<E>
/*     */ {
/*     */   private transient Map<E, MutableInteger> map;
/*     */   private int size;
/*     */   private transient int modCount;
/*     */   private transient Set<E> uniqueSet;
/*     */   
/*     */   protected AbstractMapBag() {}
/*     */   
/*     */   protected AbstractMapBag(Map<E, MutableInteger> paramMap) {
/*  70 */     this.map = paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<E, MutableInteger> getMap() {
/*  80 */     return this.map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  91 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 101 */     return this.map.isEmpty();
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
/*     */   public int getCount(Object paramObject) {
/* 113 */     MutableInteger mutableInteger = this.map.get(paramObject);
/* 114 */     if (mutableInteger != null) {
/* 115 */       return mutableInteger.value;
/*     */     }
/* 117 */     return 0;
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
/* 130 */     return this.map.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 141 */     if (paramCollection instanceof Bag) {
/* 142 */       return containsAll((Bag)paramCollection);
/*     */     }
/* 144 */     return containsAll(new HashBag(paramCollection));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean containsAll(Bag<?> paramBag) {
/* 155 */     Iterator<Object> iterator = paramBag.uniqueSet().iterator();
/* 156 */     while (iterator.hasNext()) {
/* 157 */       Object object = iterator.next();
/* 158 */       if (getCount(object) < paramBag.getCount(object)) {
/* 159 */         return false;
/*     */       }
/*     */     } 
/* 162 */     return true;
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
/*     */   public Iterator<E> iterator() {
/* 174 */     return new BagIterator<E>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   static class BagIterator<E>
/*     */     implements Iterator<E>
/*     */   {
/*     */     private final AbstractMapBag<E> parent;
/*     */     
/*     */     private final Iterator<Map.Entry<E, AbstractMapBag.MutableInteger>> entryIterator;
/*     */     
/*     */     private Map.Entry<E, AbstractMapBag.MutableInteger> current;
/*     */     
/*     */     private int itemCount;
/*     */     
/*     */     private final int mods;
/*     */     
/*     */     private boolean canRemove;
/*     */     
/*     */     public BagIterator(AbstractMapBag<E> param1AbstractMapBag) {
/* 194 */       this.parent = param1AbstractMapBag;
/* 195 */       this.entryIterator = param1AbstractMapBag.map.entrySet().iterator();
/* 196 */       this.current = null;
/* 197 */       this.mods = param1AbstractMapBag.modCount;
/* 198 */       this.canRemove = false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 204 */       return (this.itemCount > 0 || this.entryIterator.hasNext());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E next() {
/* 210 */       if (this.parent.modCount != this.mods) {
/* 211 */         throw new ConcurrentModificationException();
/*     */       }
/* 213 */       if (this.itemCount == 0) {
/* 214 */         this.current = this.entryIterator.next();
/* 215 */         this.itemCount = ((AbstractMapBag.MutableInteger)this.current.getValue()).value;
/*     */       } 
/* 217 */       this.canRemove = true;
/* 218 */       this.itemCount--;
/* 219 */       return this.current.getKey();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 225 */       if (this.parent.modCount != this.mods) {
/* 226 */         throw new ConcurrentModificationException();
/*     */       }
/* 228 */       if (!this.canRemove) {
/* 229 */         throw new IllegalStateException();
/*     */       }
/* 231 */       AbstractMapBag.MutableInteger mutableInteger = this.current.getValue();
/* 232 */       if (mutableInteger.value > 1) {
/* 233 */         mutableInteger.value--;
/*     */       } else {
/* 235 */         this.entryIterator.remove();
/*     */       } 
/* 237 */       this.parent.size--;
/* 238 */       this.canRemove = false;
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
/*     */   public boolean add(E paramE) {
/* 251 */     return add(paramE, 1);
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
/*     */   public boolean add(E paramE, int paramInt) {
/* 263 */     this.modCount++;
/* 264 */     if (paramInt > 0) {
/* 265 */       MutableInteger mutableInteger = this.map.get(paramE);
/* 266 */       this.size += paramInt;
/* 267 */       if (mutableInteger == null) {
/* 268 */         this.map.put(paramE, new MutableInteger(paramInt));
/* 269 */         return true;
/*     */       } 
/* 271 */       mutableInteger.value += paramInt;
/* 272 */       return false;
/*     */     } 
/* 274 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 285 */     boolean bool = false;
/* 286 */     Iterator<? extends E> iterator = paramCollection.iterator();
/* 287 */     while (iterator.hasNext()) {
/* 288 */       boolean bool1 = add(iterator.next());
/* 289 */       bool = (bool || bool1) ? true : false;
/*     */     } 
/* 291 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 300 */     this.modCount++;
/* 301 */     this.map.clear();
/* 302 */     this.size = 0;
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
/* 313 */     MutableInteger mutableInteger = this.map.get(paramObject);
/* 314 */     if (mutableInteger == null) {
/* 315 */       return false;
/*     */     }
/* 317 */     this.modCount++;
/* 318 */     this.map.remove(paramObject);
/* 319 */     this.size -= mutableInteger.value;
/* 320 */     return true;
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
/*     */   public boolean remove(Object paramObject, int paramInt) {
/* 332 */     MutableInteger mutableInteger = this.map.get(paramObject);
/* 333 */     if (mutableInteger == null) {
/* 334 */       return false;
/*     */     }
/* 336 */     if (paramInt <= 0) {
/* 337 */       return false;
/*     */     }
/* 339 */     this.modCount++;
/* 340 */     if (paramInt < mutableInteger.value) {
/* 341 */       mutableInteger.value -= paramInt;
/* 342 */       this.size -= paramInt;
/*     */     } else {
/* 344 */       this.map.remove(paramObject);
/* 345 */       this.size -= mutableInteger.value;
/*     */     } 
/* 347 */     return true;
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
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 359 */     boolean bool = false;
/* 360 */     if (paramCollection != null) {
/* 361 */       Iterator<?> iterator = paramCollection.iterator();
/* 362 */       while (iterator.hasNext()) {
/* 363 */         boolean bool1 = remove(iterator.next(), 1);
/* 364 */         bool = (bool || bool1) ? true : false;
/*     */       } 
/*     */     } 
/* 367 */     return bool;
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
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 379 */     if (paramCollection instanceof Bag) {
/* 380 */       return retainAll((Bag)paramCollection);
/*     */     }
/* 382 */     return retainAll(new HashBag(paramCollection));
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
/*     */   boolean retainAll(Bag<?> paramBag) {
/* 394 */     boolean bool = false;
/* 395 */     HashBag hashBag = new HashBag();
/* 396 */     Iterator<E> iterator = uniqueSet().iterator();
/* 397 */     while (iterator.hasNext()) {
/* 398 */       E e = iterator.next();
/* 399 */       int i = getCount(e);
/* 400 */       int j = paramBag.getCount(e);
/* 401 */       if (1 <= j && j <= i) {
/* 402 */         hashBag.add(e, i - j); continue;
/*     */       } 
/* 404 */       hashBag.add(e, i);
/*     */     } 
/*     */     
/* 407 */     if (!hashBag.isEmpty()) {
/* 408 */       bool = removeAll((Collection<?>)hashBag);
/*     */     }
/* 410 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class MutableInteger
/*     */   {
/*     */     protected int value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     MutableInteger(int param1Int) {
/* 426 */       this.value = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 431 */       if (!(param1Object instanceof MutableInteger)) {
/* 432 */         return false;
/*     */       }
/* 434 */       return (((MutableInteger)param1Object).value == this.value);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 439 */       return this.value;
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
/*     */   public Object[] toArray() {
/* 451 */     Object[] arrayOfObject = new Object[size()];
/* 452 */     byte b = 0;
/* 453 */     Iterator<Object> iterator = this.map.keySet().iterator();
/* 454 */     while (iterator.hasNext()) {
/* 455 */       Object object = iterator.next();
/* 456 */       for (int i = getCount(object); i > 0; i--) {
/* 457 */         arrayOfObject[b++] = object;
/*     */       }
/*     */     } 
/* 460 */     return arrayOfObject;
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
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 477 */     int i = size();
/* 478 */     if (paramArrayOfT.length < i) {
/*     */       
/* 480 */       Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
/* 481 */       paramArrayOfT = (T[])arrayOfObject;
/*     */     } 
/*     */     
/* 484 */     byte b = 0;
/* 485 */     Iterator<Object> iterator = this.map.keySet().iterator();
/* 486 */     while (iterator.hasNext()) {
/* 487 */       T t = (T)iterator.next();
/* 488 */       for (int j = getCount(t); j > 0; j--) {
/*     */ 
/*     */         
/* 491 */         T t1 = t;
/* 492 */         paramArrayOfT[b++] = t1;
/*     */       } 
/*     */     } 
/* 495 */     while (b < paramArrayOfT.length) {
/* 496 */       paramArrayOfT[b++] = null;
/*     */     }
/* 498 */     return paramArrayOfT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 508 */     if (this.uniqueSet == null) {
/* 509 */       this.uniqueSet = UnmodifiableSet.unmodifiableSet(this.map.keySet());
/*     */     }
/* 511 */     return this.uniqueSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doWriteObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 521 */     paramObjectOutputStream.writeInt(this.map.size());
/* 522 */     for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
/* 523 */       paramObjectOutputStream.writeObject(entry.getKey());
/* 524 */       paramObjectOutputStream.writeInt(((MutableInteger)entry.getValue()).value);
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
/*     */   protected void doReadObject(Map<E, MutableInteger> paramMap, ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 538 */     this.map = paramMap;
/* 539 */     int i = paramObjectInputStream.readInt();
/* 540 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 542 */       Object object = paramObjectInputStream.readObject();
/* 543 */       int j = paramObjectInputStream.readInt();
/* 544 */       paramMap.put((E)object, new MutableInteger(j));
/* 545 */       this.size += j;
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
/*     */   public boolean equals(Object paramObject) {
/* 559 */     if (paramObject == this) {
/* 560 */       return true;
/*     */     }
/* 562 */     if (!(paramObject instanceof Bag)) {
/* 563 */       return false;
/*     */     }
/* 565 */     Bag bag = (Bag)paramObject;
/* 566 */     if (bag.size() != size()) {
/* 567 */       return false;
/*     */     }
/* 569 */     for (E e : this.map.keySet()) {
/* 570 */       if (bag.getCount(e) != getCount(e)) {
/* 571 */         return false;
/*     */       }
/*     */     } 
/* 574 */     return true;
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
/*     */   public int hashCode() {
/* 588 */     int i = 0;
/* 589 */     for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
/* 590 */       Object object = entry.getKey();
/* 591 */       MutableInteger mutableInteger = (MutableInteger)entry.getValue();
/* 592 */       i += ((object == null) ? 0 : object.hashCode()) ^ mutableInteger.value;
/*     */     } 
/* 594 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 604 */     if (size() == 0) {
/* 605 */       return "[]";
/*     */     }
/* 607 */     StringBuilder stringBuilder = new StringBuilder();
/* 608 */     stringBuilder.append('[');
/* 609 */     Iterator<E> iterator = uniqueSet().iterator();
/* 610 */     while (iterator.hasNext()) {
/* 611 */       E e = iterator.next();
/* 612 */       int i = getCount(e);
/* 613 */       stringBuilder.append(i);
/* 614 */       stringBuilder.append(':');
/* 615 */       stringBuilder.append(e);
/* 616 */       if (iterator.hasNext()) {
/* 617 */         stringBuilder.append(',');
/*     */       }
/*     */     } 
/* 620 */     stringBuilder.append(']');
/* 621 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\AbstractMapBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */