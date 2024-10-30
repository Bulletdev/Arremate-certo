/*     */ package org.apache.commons.collections4.multiset;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.IteratorUtils;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractMultiSet<E>
/*     */   extends AbstractCollection<E>
/*     */   implements MultiSet<E>
/*     */ {
/*     */   private transient Set<E> uniqueSet;
/*     */   private transient Set<MultiSet.Entry<E>> entrySet;
/*     */   
/*     */   public int size() {
/*  61 */     int i = 0;
/*  62 */     for (MultiSet.Entry<E> entry : entrySet()) {
/*  63 */       i += entry.getCount();
/*     */     }
/*  65 */     return i;
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
/*  77 */     for (MultiSet.Entry<E> entry : entrySet()) {
/*  78 */       Object object = entry.getElement();
/*  79 */       if (object == paramObject || (object != null && object.equals(paramObject)))
/*     */       {
/*  81 */         return entry.getCount();
/*     */       }
/*     */     } 
/*  84 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int setCount(E paramE, int paramInt) {
/*  89 */     if (paramInt < 0) {
/*  90 */       throw new IllegalArgumentException("Count must not be negative.");
/*     */     }
/*     */     
/*  93 */     int i = getCount(paramE);
/*  94 */     if (i < paramInt) {
/*  95 */       add(paramE, paramInt - i);
/*     */     } else {
/*  97 */       remove(paramE, i - paramInt);
/*     */     } 
/*  99 */     return i;
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
/* 111 */     return (getCount(paramObject) > 0);
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
/* 123 */     return new MultiSetIterator<E>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class MultiSetIterator<E>
/*     */     implements Iterator<E>
/*     */   {
/*     */     private final AbstractMultiSet<E> parent;
/*     */     
/*     */     private final Iterator<MultiSet.Entry<E>> entryIterator;
/*     */     
/*     */     private MultiSet.Entry<E> current;
/*     */     
/*     */     private int itemCount;
/*     */     
/*     */     private boolean canRemove;
/*     */ 
/*     */     
/*     */     public MultiSetIterator(AbstractMultiSet<E> param1AbstractMultiSet) {
/* 142 */       this.parent = param1AbstractMultiSet;
/* 143 */       this.entryIterator = param1AbstractMultiSet.entrySet().iterator();
/* 144 */       this.current = null;
/* 145 */       this.canRemove = false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 151 */       return (this.itemCount > 0 || this.entryIterator.hasNext());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public E next() {
/* 157 */       if (this.itemCount == 0) {
/* 158 */         this.current = this.entryIterator.next();
/* 159 */         this.itemCount = this.current.getCount();
/*     */       } 
/* 161 */       this.canRemove = true;
/* 162 */       this.itemCount--;
/* 163 */       return (E)this.current.getElement();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 169 */       if (!this.canRemove) {
/* 170 */         throw new IllegalStateException();
/*     */       }
/* 172 */       int i = this.current.getCount();
/* 173 */       if (i > 1) {
/* 174 */         this.parent.remove(this.current.getElement());
/*     */       } else {
/* 176 */         this.entryIterator.remove();
/*     */       } 
/* 178 */       this.canRemove = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 185 */     add(paramE, 1);
/* 186 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int add(E paramE, int paramInt) {
/* 191 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 200 */     Iterator<MultiSet.Entry<E>> iterator = entrySet().iterator();
/* 201 */     while (iterator.hasNext()) {
/* 202 */       iterator.next();
/* 203 */       iterator.remove();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 209 */     return (remove(paramObject, 1) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int remove(Object paramObject, int paramInt) {
/* 214 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 219 */     boolean bool = false;
/* 220 */     Iterator<?> iterator = paramCollection.iterator();
/* 221 */     while (iterator.hasNext()) {
/* 222 */       Object object = iterator.next();
/* 223 */       boolean bool1 = (remove(object, getCount(object)) != 0) ? true : false;
/* 224 */       bool = (bool || bool1) ? true : false;
/*     */     } 
/* 226 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<E> uniqueSet() {
/* 237 */     if (this.uniqueSet == null) {
/* 238 */       this.uniqueSet = createUniqueSet();
/*     */     }
/* 240 */     return this.uniqueSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Set<E> createUniqueSet() {
/* 249 */     return new UniqueSet<E>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Iterator<E> createUniqueSetIterator() {
/* 259 */     Transformer<MultiSet.Entry<E>, E> transformer = new Transformer<MultiSet.Entry<E>, E>()
/*     */       {
/*     */         public E transform(MultiSet.Entry<E> param1Entry) {
/* 262 */           return (E)param1Entry.getElement();
/*     */         }
/*     */       };
/* 265 */     return IteratorUtils.transformedIterator(entrySet().iterator(), transformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<MultiSet.Entry<E>> entrySet() {
/* 275 */     if (this.entrySet == null) {
/* 276 */       this.entrySet = createEntrySet();
/*     */     }
/* 278 */     return this.entrySet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Set<MultiSet.Entry<E>> createEntrySet() {
/* 287 */     return new EntrySet<E>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract int uniqueElements();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Iterator<MultiSet.Entry<E>> createEntrySetIterator();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class UniqueSet<E>
/*     */     extends AbstractSet<E>
/*     */   {
/*     */     protected final AbstractMultiSet<E> parent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected UniqueSet(AbstractMultiSet<E> param1AbstractMultiSet) {
/* 320 */       this.parent = param1AbstractMultiSet;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<E> iterator() {
/* 325 */       return this.parent.createUniqueSetIterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 330 */       return this.parent.contains(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsAll(Collection<?> param1Collection) {
/* 335 */       return this.parent.containsAll(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 340 */       return (this.parent.remove(param1Object, this.parent.getCount(param1Object)) != 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 345 */       return this.parent.uniqueElements();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 350 */       this.parent.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class EntrySet<E>
/*     */     extends AbstractSet<MultiSet.Entry<E>>
/*     */   {
/*     */     private final AbstractMultiSet<E> parent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected EntrySet(AbstractMultiSet<E> param1AbstractMultiSet) {
/* 368 */       this.parent = param1AbstractMultiSet;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 373 */       return this.parent.uniqueElements();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<MultiSet.Entry<E>> iterator() {
/* 378 */       return this.parent.createEntrySetIterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 383 */       if (!(param1Object instanceof MultiSet.Entry)) {
/* 384 */         return false;
/*     */       }
/* 386 */       MultiSet.Entry entry = (MultiSet.Entry)param1Object;
/* 387 */       Object object = entry.getElement();
/* 388 */       return (this.parent.getCount(object) == entry.getCount());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 393 */       if (!(param1Object instanceof MultiSet.Entry)) {
/* 394 */         return false;
/*     */       }
/* 396 */       MultiSet.Entry entry = (MultiSet.Entry)param1Object;
/* 397 */       Object object = entry.getElement();
/* 398 */       if (this.parent.contains(object)) {
/* 399 */         int i = this.parent.getCount(object);
/* 400 */         if (entry.getCount() == i) {
/* 401 */           this.parent.remove(object, i);
/* 402 */           return true;
/*     */         } 
/*     */       } 
/* 405 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static abstract class AbstractEntry<E>
/*     */     implements MultiSet.Entry<E>
/*     */   {
/*     */     public boolean equals(Object param1Object) {
/* 416 */       if (param1Object instanceof MultiSet.Entry) {
/* 417 */         MultiSet.Entry entry = (MultiSet.Entry)param1Object;
/* 418 */         Object object1 = getElement();
/* 419 */         Object object2 = entry.getElement();
/*     */         
/* 421 */         return (getCount() == entry.getCount() && (object1 == object2 || (object1 != null && object1.equals(object2))));
/*     */       } 
/*     */ 
/*     */       
/* 425 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 430 */       Object object = getElement();
/* 431 */       return ((object == null) ? 0 : object.hashCode()) ^ getCount();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 436 */       return String.format("%s:%d", new Object[] { getElement(), Integer.valueOf(getCount()) });
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
/* 448 */     paramObjectOutputStream.writeInt(entrySet().size());
/* 449 */     for (MultiSet.Entry<E> entry : entrySet()) {
/* 450 */       paramObjectOutputStream.writeObject(entry.getElement());
/* 451 */       paramObjectOutputStream.writeInt(entry.getCount());
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
/*     */   protected void doReadObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 464 */     int i = paramObjectInputStream.readInt();
/* 465 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 467 */       Object object = paramObjectInputStream.readObject();
/* 468 */       int j = paramObjectInputStream.readInt();
/* 469 */       setCount((E)object, j);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 476 */     if (paramObject == this) {
/* 477 */       return true;
/*     */     }
/* 479 */     if (!(paramObject instanceof MultiSet)) {
/* 480 */       return false;
/*     */     }
/* 482 */     MultiSet multiSet = (MultiSet)paramObject;
/* 483 */     if (multiSet.size() != size()) {
/* 484 */       return false;
/*     */     }
/* 486 */     for (MultiSet.Entry<E> entry : entrySet()) {
/* 487 */       if (multiSet.getCount(entry.getElement()) != getCount(entry.getElement())) {
/* 488 */         return false;
/*     */       }
/*     */     } 
/* 491 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 496 */     return entrySet().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 506 */     return entrySet().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multiset\AbstractMultiSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */