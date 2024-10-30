/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayIterator<E>
/*     */   implements ResettableIterator<E>
/*     */ {
/*     */   final Object array;
/*     */   final int startIndex;
/*     */   final int endIndex;
/*  47 */   int index = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayIterator(Object paramObject) {
/*  60 */     this(paramObject, 0);
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
/*     */   public ArrayIterator(Object paramObject, int paramInt) {
/*  74 */     this(paramObject, paramInt, Array.getLength(paramObject));
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
/*     */   public ArrayIterator(Object paramObject, int paramInt1, int paramInt2) {
/*  91 */     this.array = paramObject;
/*  92 */     this.startIndex = paramInt1;
/*  93 */     this.endIndex = paramInt2;
/*  94 */     this.index = paramInt1;
/*     */     
/*  96 */     int i = Array.getLength(paramObject);
/*  97 */     checkBound(paramInt1, i, "start");
/*  98 */     checkBound(paramInt2, i, "end");
/*  99 */     if (paramInt2 < paramInt1) {
/* 100 */       throw new IllegalArgumentException("End index must not be less than start index.");
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
/*     */   protected void checkBound(int paramInt1, int paramInt2, String paramString) {
/* 113 */     if (paramInt1 > paramInt2) {
/* 114 */       throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + paramString + "s beyond the end of the array. ");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 119 */     if (paramInt1 < 0) {
/* 120 */       throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + paramString + "s before the start of the array. ");
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
/*     */   public boolean hasNext() {
/* 135 */     return (this.index < this.endIndex);
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
/*     */   public E next() {
/* 147 */     if (!hasNext()) {
/* 148 */       throw new NoSuchElementException();
/*     */     }
/* 150 */     return (E)Array.get(this.array, this.index++);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 159 */     throw new UnsupportedOperationException("remove() method is not supported");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getArray() {
/* 170 */     return this.array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartIndex() {
/* 180 */     return this.startIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEndIndex() {
/* 190 */     return this.endIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 197 */     this.index = this.startIndex;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\ArrayIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */