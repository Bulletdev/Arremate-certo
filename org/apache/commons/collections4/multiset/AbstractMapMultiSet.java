/*     */ package org.apache.commons.collections4.multiset;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractMapMultiSet<E>
/*     */   extends AbstractMultiSet<E>
/*     */ {
/*     */   private transient Map<E, MutableInteger> map;
/*     */   private transient int size;
/*     */   private transient int modCount;
/*     */   
/*     */   protected AbstractMapMultiSet() {}
/*     */   
/*     */   protected AbstractMapMultiSet(Map<E, MutableInteger> paramMap) {
/*  65 */     this.map = paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<E, MutableInteger> getMap() {
/*  75 */     return this.map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setMap(Map<E, MutableInteger> paramMap) {
/*  86 */     this.map = paramMap;
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
/*  97 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 107 */     return this.map.isEmpty();
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
/* 119 */     MutableInteger mutableInteger = this.map.get(paramObject);
/* 120 */     if (mutableInteger != null) {
/* 121 */       return mutableInteger.value;
/*     */     }
/* 123 */     return 0;
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
/* 136 */     return this.map.containsKey(paramObject);
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
/* 148 */     return new MapBasedMultiSetIterator<E>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class MapBasedMultiSetIterator<E>
/*     */     implements Iterator<E>
/*     */   {
/*     */     private final AbstractMapMultiSet<E> parent;
/*     */     
/*     */     private final Iterator<Map.Entry<E, AbstractMapMultiSet.MutableInteger>> entryIterator;
/*     */     
/*     */     private Map.Entry<E, AbstractMapMultiSet.MutableInteger> current;
/*     */     
/*     */     private int itemCount;
/*     */     
/*     */     private final int mods;
/*     */     
/*     */     private boolean canRemove;
/*     */     
/*     */     public MapBasedMultiSetIterator(AbstractMapMultiSet<E> param1AbstractMapMultiSet) {
/* 168 */       this.parent = param1AbstractMapMultiSet;
/* 169 */       this.entryIterator = param1AbstractMapMultiSet.map.entrySet().iterator();
/* 170 */       this.current = null;
/* 171 */       this.mods = param1AbstractMapMultiSet.modCount;
/* 172 */       this.canRemove = false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 178 */       return (this.itemCount > 0 || this.entryIterator.hasNext());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E next() {
/* 184 */       if (this.parent.modCount != this.mods) {
/* 185 */         throw new ConcurrentModificationException();
/*     */       }
/* 187 */       if (this.itemCount == 0) {
/* 188 */         this.current = this.entryIterator.next();
/* 189 */         this.itemCount = ((AbstractMapMultiSet.MutableInteger)this.current.getValue()).value;
/*     */       } 
/* 191 */       this.canRemove = true;
/* 192 */       this.itemCount--;
/* 193 */       return this.current.getKey();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 199 */       if (this.parent.modCount != this.mods) {
/* 200 */         throw new ConcurrentModificationException();
/*     */       }
/* 202 */       if (!this.canRemove) {
/* 203 */         throw new IllegalStateException();
/*     */       }
/* 205 */       AbstractMapMultiSet.MutableInteger mutableInteger = this.current.getValue();
/* 206 */       if (mutableInteger.value > 1) {
/* 207 */         mutableInteger.value--;
/*     */       } else {
/* 209 */         this.entryIterator.remove();
/*     */       } 
/* 211 */       this.parent.size--;
/* 212 */       this.canRemove = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int add(E paramE, int paramInt) {
/* 219 */     if (paramInt < 0) {
/* 220 */       throw new IllegalArgumentException("Occurrences must not be negative.");
/*     */     }
/*     */     
/* 223 */     MutableInteger mutableInteger = this.map.get(paramE);
/* 224 */     boolean bool = (mutableInteger != null) ? mutableInteger.value : false;
/*     */     
/* 226 */     if (paramInt > 0) {
/* 227 */       this.modCount++;
/* 228 */       this.size += paramInt;
/* 229 */       if (mutableInteger == null) {
/* 230 */         this.map.put(paramE, new MutableInteger(paramInt));
/*     */       } else {
/* 232 */         mutableInteger.value += paramInt;
/*     */       } 
/*     */     } 
/* 235 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 244 */     this.modCount++;
/* 245 */     this.map.clear();
/* 246 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int remove(Object paramObject, int paramInt) {
/* 251 */     if (paramInt < 0) {
/* 252 */       throw new IllegalArgumentException("Occurrences must not be negative.");
/*     */     }
/*     */     
/* 255 */     MutableInteger mutableInteger = this.map.get(paramObject);
/* 256 */     if (mutableInteger == null) {
/* 257 */       return 0;
/*     */     }
/* 259 */     int i = mutableInteger.value;
/* 260 */     if (paramInt > 0) {
/* 261 */       this.modCount++;
/* 262 */       if (paramInt < mutableInteger.value) {
/* 263 */         mutableInteger.value -= paramInt;
/* 264 */         this.size -= paramInt;
/*     */       } else {
/* 266 */         this.map.remove(paramObject);
/* 267 */         this.size -= mutableInteger.value;
/*     */       } 
/*     */     } 
/* 270 */     return i;
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
/* 286 */       this.value = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 291 */       if (!(param1Object instanceof MutableInteger)) {
/* 292 */         return false;
/*     */       }
/* 294 */       return (((MutableInteger)param1Object).value == this.value);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 299 */       return this.value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Iterator<E> createUniqueSetIterator() {
/* 306 */     return (Iterator<E>)new UniqueSetIterator(getMap().keySet().iterator(), this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int uniqueElements() {
/* 311 */     return this.map.size();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Iterator<MultiSet.Entry<E>> createEntrySetIterator() {
/* 316 */     return new EntrySetIterator<E>(this.map.entrySet().iterator(), this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class UniqueSetIterator<E>
/*     */     extends AbstractIteratorDecorator<E>
/*     */   {
/*     */     protected final AbstractMapMultiSet<E> parent;
/*     */ 
/*     */ 
/*     */     
/* 329 */     protected E lastElement = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean canRemove = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected UniqueSetIterator(Iterator<E> param1Iterator, AbstractMapMultiSet<E> param1AbstractMapMultiSet) {
/* 340 */       super(param1Iterator);
/* 341 */       this.parent = param1AbstractMapMultiSet;
/*     */     }
/*     */ 
/*     */     
/*     */     public E next() {
/* 346 */       this.lastElement = (E)super.next();
/* 347 */       this.canRemove = true;
/* 348 */       return this.lastElement;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 353 */       if (!this.canRemove) {
/* 354 */         throw new IllegalStateException("Iterator remove() can only be called once after next()");
/*     */       }
/* 356 */       int i = this.parent.getCount(this.lastElement);
/* 357 */       super.remove();
/* 358 */       this.parent.remove(this.lastElement, i);
/* 359 */       this.lastElement = null;
/* 360 */       this.canRemove = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class EntrySetIterator<E>
/*     */     implements Iterator<MultiSet.Entry<E>>
/*     */   {
/*     */     protected final AbstractMapMultiSet<E> parent;
/*     */ 
/*     */     
/*     */     protected final Iterator<Map.Entry<E, AbstractMapMultiSet.MutableInteger>> decorated;
/*     */ 
/*     */     
/* 375 */     protected MultiSet.Entry<E> last = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean canRemove = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected EntrySetIterator(Iterator<Map.Entry<E, AbstractMapMultiSet.MutableInteger>> param1Iterator, AbstractMapMultiSet<E> param1AbstractMapMultiSet) {
/* 387 */       this.decorated = param1Iterator;
/* 388 */       this.parent = param1AbstractMapMultiSet;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 393 */       return this.decorated.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public MultiSet.Entry<E> next() {
/* 398 */       this.last = new AbstractMapMultiSet.MultiSetEntry<E>(this.decorated.next());
/* 399 */       this.canRemove = true;
/* 400 */       return this.last;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 405 */       if (!this.canRemove) {
/* 406 */         throw new IllegalStateException("Iterator remove() can only be called once after next()");
/*     */       }
/* 408 */       this.decorated.remove();
/* 409 */       this.last = null;
/* 410 */       this.canRemove = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class MultiSetEntry<E>
/*     */     extends AbstractMultiSet.AbstractEntry<E>
/*     */   {
/*     */     protected final Map.Entry<E, AbstractMapMultiSet.MutableInteger> parentEntry;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected MultiSetEntry(Map.Entry<E, AbstractMapMultiSet.MutableInteger> param1Entry) {
/* 426 */       this.parentEntry = param1Entry;
/*     */     }
/*     */ 
/*     */     
/*     */     public E getElement() {
/* 431 */       return this.parentEntry.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getCount() {
/* 436 */       return ((AbstractMapMultiSet.MutableInteger)this.parentEntry.getValue()).value;
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
/*     */   protected void doWriteObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 448 */     paramObjectOutputStream.writeInt(this.map.size());
/* 449 */     for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
/* 450 */       paramObjectOutputStream.writeObject(entry.getKey());
/* 451 */       paramObjectOutputStream.writeInt(((MutableInteger)entry.getValue()).value);
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
/*     */   protected void doReadObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 465 */     int i = paramObjectInputStream.readInt();
/* 466 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 468 */       Object object = paramObjectInputStream.readObject();
/* 469 */       int j = paramObjectInputStream.readInt();
/* 470 */       this.map.put((E)object, new MutableInteger(j));
/* 471 */       this.size += j;
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
/* 483 */     Object[] arrayOfObject = new Object[size()];
/* 484 */     byte b = 0;
/* 485 */     for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
/* 486 */       Object object = entry.getKey();
/* 487 */       MutableInteger mutableInteger = (MutableInteger)entry.getValue();
/* 488 */       for (int i = mutableInteger.value; i > 0; i--) {
/* 489 */         arrayOfObject[b++] = object;
/*     */       }
/*     */     } 
/* 492 */     return arrayOfObject;
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
/* 509 */     int i = size();
/* 510 */     if (paramArrayOfT.length < i) {
/*     */       
/* 512 */       Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
/* 513 */       paramArrayOfT = (T[])arrayOfObject;
/*     */     } 
/*     */     
/* 516 */     byte b = 0;
/* 517 */     for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
/* 518 */       Object object = entry.getKey();
/* 519 */       MutableInteger mutableInteger = (MutableInteger)entry.getValue();
/* 520 */       for (int j = mutableInteger.value; j > 0; j--) {
/*     */ 
/*     */         
/* 523 */         Object object1 = object;
/* 524 */         paramArrayOfT[b++] = (T)object1;
/*     */       } 
/*     */     } 
/* 527 */     while (b < paramArrayOfT.length) {
/* 528 */       paramArrayOfT[b++] = null;
/*     */     }
/* 530 */     return paramArrayOfT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 536 */     if (paramObject == this) {
/* 537 */       return true;
/*     */     }
/* 539 */     if (!(paramObject instanceof MultiSet)) {
/* 540 */       return false;
/*     */     }
/* 542 */     MultiSet multiSet = (MultiSet)paramObject;
/* 543 */     if (multiSet.size() != size()) {
/* 544 */       return false;
/*     */     }
/* 546 */     for (E e : this.map.keySet()) {
/* 547 */       if (multiSet.getCount(e) != getCount(e)) {
/* 548 */         return false;
/*     */       }
/*     */     } 
/* 551 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 556 */     int i = 0;
/* 557 */     for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
/* 558 */       Object object = entry.getKey();
/* 559 */       MutableInteger mutableInteger = (MutableInteger)entry.getValue();
/* 560 */       i += ((object == null) ? 0 : object.hashCode()) ^ mutableInteger.value;
/*     */     } 
/* 562 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multiset\AbstractMapMultiSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */