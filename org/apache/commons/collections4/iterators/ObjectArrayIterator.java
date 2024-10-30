/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
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
/*     */ public class ObjectArrayIterator<E>
/*     */   implements ResettableIterator<E>
/*     */ {
/*     */   final E[] array;
/*     */   final int startIndex;
/*     */   final int endIndex;
/*  44 */   int index = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectArrayIterator(E... paramVarArgs) {
/*  55 */     this(paramVarArgs, 0, paramVarArgs.length);
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
/*     */   public ObjectArrayIterator(E[] paramArrayOfE, int paramInt) {
/*  68 */     this(paramArrayOfE, paramInt, paramArrayOfE.length);
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
/*     */   public ObjectArrayIterator(E[] paramArrayOfE, int paramInt1, int paramInt2) {
/*  84 */     if (paramInt1 < 0) {
/*  85 */       throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
/*     */     }
/*  87 */     if (paramInt2 > paramArrayOfE.length) {
/*  88 */       throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
/*     */     }
/*  90 */     if (paramInt1 > paramArrayOfE.length) {
/*  91 */       throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
/*     */     }
/*  93 */     if (paramInt2 < paramInt1) {
/*  94 */       throw new IllegalArgumentException("End index must not be less than start index");
/*     */     }
/*  96 */     this.array = paramArrayOfE;
/*  97 */     this.startIndex = paramInt1;
/*  98 */     this.endIndex = paramInt2;
/*  99 */     this.index = paramInt1;
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
/*     */   public boolean hasNext() {
/* 111 */     return (this.index < this.endIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E next() {
/* 122 */     if (!hasNext()) {
/* 123 */       throw new NoSuchElementException();
/*     */     }
/* 125 */     return this.array[this.index++];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 134 */     throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
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
/*     */   public E[] getArray() {
/* 146 */     return this.array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartIndex() {
/* 155 */     return this.startIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getEndIndex() {
/* 164 */     return this.endIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 171 */     this.index = this.startIndex;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\ObjectArrayIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */