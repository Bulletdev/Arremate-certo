/*     */ package org.apache.commons.collections4.queue;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.collections4.BoundedCollection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CircularFifoQueue<E>
/*     */   extends AbstractCollection<E>
/*     */   implements Serializable, Queue<E>, BoundedCollection<E>
/*     */ {
/*     */   private static final long serialVersionUID = -8423413834657610406L;
/*     */   private transient E[] elements;
/*  59 */   private transient int start = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   private transient int end = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private transient boolean full = false;
/*     */ 
/*     */   
/*     */   private final int maxElements;
/*     */ 
/*     */ 
/*     */   
/*     */   public CircularFifoQueue() {
/*  80 */     this(32);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CircularFifoQueue(int paramInt) {
/*  91 */     if (paramInt <= 0) {
/*  92 */       throw new IllegalArgumentException("The size must be greater than 0");
/*     */     }
/*  94 */     this.elements = (E[])new Object[paramInt];
/*  95 */     this.maxElements = this.elements.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CircularFifoQueue(Collection<? extends E> paramCollection) {
/* 106 */     this(paramCollection.size());
/* 107 */     addAll(paramCollection);
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
/* 118 */     paramObjectOutputStream.defaultWriteObject();
/* 119 */     paramObjectOutputStream.writeInt(size());
/* 120 */     for (E e : this) {
/* 121 */       paramObjectOutputStream.writeObject(e);
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 134 */     paramObjectInputStream.defaultReadObject();
/* 135 */     this.elements = (E[])new Object[this.maxElements];
/* 136 */     int i = paramObjectInputStream.readInt();
/* 137 */     for (byte b = 0; b < i; b++) {
/* 138 */       this.elements[b] = (E)paramObjectInputStream.readObject();
/*     */     }
/* 140 */     this.start = 0;
/* 141 */     this.full = (i == this.maxElements);
/* 142 */     if (this.full) {
/* 143 */       this.end = 0;
/*     */     } else {
/* 145 */       this.end = i;
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
/*     */   public int size() {
/* 157 */     int i = 0;
/*     */     
/* 159 */     if (this.end < this.start) {
/* 160 */       i = this.maxElements - this.start + this.end;
/* 161 */     } else if (this.end == this.start) {
/* 162 */       i = this.full ? this.maxElements : 0;
/*     */     } else {
/* 164 */       i = this.end - this.start;
/*     */     } 
/*     */     
/* 167 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 177 */     return (size() == 0);
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
/*     */   public boolean isFull() {
/* 189 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAtFullCapacity() {
/* 200 */     return (size() == this.maxElements);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int maxSize() {
/* 209 */     return this.maxElements;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 217 */     this.full = false;
/* 218 */     this.start = 0;
/* 219 */     this.end = 0;
/* 220 */     Arrays.fill((Object[])this.elements, (Object)null);
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
/*     */   public boolean add(E paramE) {
/* 233 */     if (null == paramE) {
/* 234 */       throw new NullPointerException("Attempted to add null object to queue");
/*     */     }
/*     */     
/* 237 */     if (isAtFullCapacity()) {
/* 238 */       remove();
/*     */     }
/*     */     
/* 241 */     this.elements[this.end++] = paramE;
/*     */     
/* 243 */     if (this.end >= this.maxElements) {
/* 244 */       this.end = 0;
/*     */     }
/*     */     
/* 247 */     if (this.end == this.start) {
/* 248 */       this.full = true;
/*     */     }
/*     */     
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
/*     */   public E get(int paramInt) {
/* 262 */     int i = size();
/* 263 */     if (paramInt < 0 || paramInt >= i) {
/* 264 */       throw new NoSuchElementException(String.format("The specified index (%1$d) is outside the available range [0, %2$d)", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 269 */     int j = (this.start + paramInt) % this.maxElements;
/* 270 */     return this.elements[j];
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
/*     */   public boolean offer(E paramE) {
/* 284 */     return add(paramE);
/*     */   }
/*     */   
/*     */   public E poll() {
/* 288 */     if (isEmpty()) {
/* 289 */       return null;
/*     */     }
/* 291 */     return remove();
/*     */   }
/*     */   
/*     */   public E element() {
/* 295 */     if (isEmpty()) {
/* 296 */       throw new NoSuchElementException("queue is empty");
/*     */     }
/* 298 */     return peek();
/*     */   }
/*     */   
/*     */   public E peek() {
/* 302 */     if (isEmpty()) {
/* 303 */       return null;
/*     */     }
/* 305 */     return this.elements[this.start];
/*     */   }
/*     */   
/*     */   public E remove() {
/* 309 */     if (isEmpty()) {
/* 310 */       throw new NoSuchElementException("queue is empty");
/*     */     }
/*     */     
/* 313 */     E e = this.elements[this.start];
/* 314 */     if (null != e) {
/* 315 */       this.elements[this.start++] = null;
/*     */       
/* 317 */       if (this.start >= this.maxElements) {
/* 318 */         this.start = 0;
/*     */       }
/* 320 */       this.full = false;
/*     */     } 
/* 322 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int increment(int paramInt) {
/* 333 */     paramInt++;
/* 334 */     if (paramInt >= this.maxElements) {
/* 335 */       paramInt = 0;
/*     */     }
/* 337 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int decrement(int paramInt) {
/* 347 */     paramInt--;
/* 348 */     if (paramInt < 0) {
/* 349 */       paramInt = this.maxElements - 1;
/*     */     }
/* 351 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 361 */     return new Iterator<E>()
/*     */       {
/* 363 */         private int index = CircularFifoQueue.this.start;
/* 364 */         private int lastReturnedIndex = -1;
/* 365 */         private boolean isFirst = CircularFifoQueue.this.full;
/*     */         
/*     */         public boolean hasNext() {
/* 368 */           return (this.isFirst || this.index != CircularFifoQueue.this.end);
/*     */         }
/*     */         
/*     */         public E next() {
/* 372 */           if (!hasNext()) {
/* 373 */             throw new NoSuchElementException();
/*     */           }
/* 375 */           this.isFirst = false;
/* 376 */           this.lastReturnedIndex = this.index;
/* 377 */           this.index = CircularFifoQueue.this.increment(this.index);
/* 378 */           return (E)CircularFifoQueue.this.elements[this.lastReturnedIndex];
/*     */         }
/*     */         
/*     */         public void remove() {
/* 382 */           if (this.lastReturnedIndex == -1) {
/* 383 */             throw new IllegalStateException();
/*     */           }
/*     */ 
/*     */           
/* 387 */           if (this.lastReturnedIndex == CircularFifoQueue.this.start) {
/* 388 */             CircularFifoQueue.this.remove();
/* 389 */             this.lastReturnedIndex = -1;
/*     */             
/*     */             return;
/*     */           } 
/* 393 */           int i = this.lastReturnedIndex + 1;
/* 394 */           if (CircularFifoQueue.this.start < this.lastReturnedIndex && i < CircularFifoQueue.this.end) {
/*     */             
/* 396 */             System.arraycopy(CircularFifoQueue.this.elements, i, CircularFifoQueue.this.elements, this.lastReturnedIndex, CircularFifoQueue.this.end - i);
/*     */           } else {
/*     */             
/* 399 */             while (i != CircularFifoQueue.this.end) {
/* 400 */               if (i >= CircularFifoQueue.this.maxElements) {
/* 401 */                 CircularFifoQueue.this.elements[i - 1] = CircularFifoQueue.this.elements[0];
/* 402 */                 i = 0; continue;
/*     */               } 
/* 404 */               CircularFifoQueue.this.elements[CircularFifoQueue.this.decrement(i)] = CircularFifoQueue.this.elements[i];
/* 405 */               i = CircularFifoQueue.this.increment(i);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 410 */           this.lastReturnedIndex = -1;
/* 411 */           CircularFifoQueue.this.end = CircularFifoQueue.this.decrement(CircularFifoQueue.this.end);
/* 412 */           CircularFifoQueue.this.elements[CircularFifoQueue.this.end] = null;
/* 413 */           CircularFifoQueue.this.full = false;
/* 414 */           this.index = CircularFifoQueue.this.decrement(this.index);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\queue\CircularFifoQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */