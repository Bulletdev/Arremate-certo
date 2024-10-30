/*     */ package org.apache.poi.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntList
/*     */ {
/*     */   private int[] _array;
/*     */   private int _limit;
/*  50 */   private int fillval = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int _default_size = 128;
/*     */ 
/*     */ 
/*     */   
/*     */   public IntList() {
/*  59 */     this(128);
/*     */   }
/*     */ 
/*     */   
/*     */   public IntList(int paramInt) {
/*  64 */     this(paramInt, 0);
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
/*     */   public IntList(IntList paramIntList) {
/*  76 */     this(paramIntList._array.length);
/*  77 */     System.arraycopy(paramIntList._array, 0, this._array, 0, this._array.length);
/*  78 */     this._limit = paramIntList._limit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntList(int paramInt1, int paramInt2) {
/*  89 */     this._array = new int[paramInt1];
/*  90 */     if (this.fillval != 0) {
/*  91 */       this.fillval = paramInt2;
/*  92 */       fillArray(this.fillval, this._array, 0);
/*     */     } 
/*  94 */     this._limit = 0;
/*     */   }
/*     */   
/*     */   private void fillArray(int paramInt1, int[] paramArrayOfint, int paramInt2) {
/*  98 */     for (int i = paramInt2; i < paramArrayOfint.length; i++) {
/*  99 */       paramArrayOfint[i] = paramInt1;
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
/*     */   public void add(int paramInt1, int paramInt2) {
/* 115 */     if (paramInt1 > this._limit)
/*     */     {
/* 117 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 119 */     if (paramInt1 == this._limit) {
/*     */       
/* 121 */       add(paramInt2);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 127 */       if (this._limit == this._array.length)
/*     */       {
/* 129 */         growArray(this._limit * 2);
/*     */       }
/* 131 */       System.arraycopy(this._array, paramInt1, this._array, paramInt1 + 1, this._limit - paramInt1);
/*     */       
/* 133 */       this._array[paramInt1] = paramInt2;
/* 134 */       this._limit++;
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
/*     */   public boolean add(int paramInt) {
/* 149 */     if (this._limit == this._array.length)
/*     */     {
/* 151 */       growArray(this._limit * 2);
/*     */     }
/* 153 */     this._array[this._limit++] = paramInt;
/* 154 */     return true;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(IntList paramIntList) {
/* 174 */     if (paramIntList._limit != 0) {
/*     */       
/* 176 */       if (this._limit + paramIntList._limit > this._array.length)
/*     */       {
/* 178 */         growArray(this._limit + paramIntList._limit);
/*     */       }
/* 180 */       System.arraycopy(paramIntList._array, 0, this._array, this._limit, paramIntList._limit);
/* 181 */       this._limit += paramIntList._limit;
/*     */     } 
/* 183 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, IntList paramIntList) {
/* 210 */     if (paramInt > this._limit)
/*     */     {
/* 212 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 214 */     if (paramIntList._limit != 0) {
/*     */       
/* 216 */       if (this._limit + paramIntList._limit > this._array.length)
/*     */       {
/* 218 */         growArray(this._limit + paramIntList._limit);
/*     */       }
/*     */ 
/*     */       
/* 222 */       System.arraycopy(this._array, paramInt, this._array, paramInt + paramIntList._limit, this._limit - paramInt);
/*     */ 
/*     */ 
/*     */       
/* 226 */       System.arraycopy(paramIntList._array, 0, this._array, paramInt, paramIntList._limit);
/* 227 */       this._limit += paramIntList._limit;
/*     */     } 
/* 229 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 239 */     this._limit = 0;
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
/*     */   public boolean contains(int paramInt) {
/* 254 */     boolean bool = false;
/*     */     
/* 256 */     for (byte b = 0; !bool && b < this._limit; b++) {
/*     */       
/* 258 */       if (this._array[b] == paramInt)
/*     */       {
/* 260 */         bool = true;
/*     */       }
/*     */     } 
/* 263 */     return bool;
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
/*     */   public boolean containsAll(IntList paramIntList) {
/* 278 */     boolean bool = true;
/*     */     
/* 280 */     if (this != paramIntList)
/*     */     {
/* 282 */       for (byte b = 0; bool && b < paramIntList._limit; b++) {
/*     */         
/* 284 */         if (!contains(paramIntList._array[b]))
/*     */         {
/* 286 */           bool = false;
/*     */         }
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 311 */     boolean bool = (this == paramObject) ? true : false;
/*     */     
/* 313 */     if (!bool && paramObject != null && paramObject.getClass() == getClass()) {
/*     */       
/* 315 */       IntList intList = (IntList)paramObject;
/*     */       
/* 317 */       if (intList._limit == this._limit) {
/*     */ 
/*     */ 
/*     */         
/* 321 */         bool = true;
/* 322 */         for (byte b = 0; bool && b < this._limit; b++)
/*     */         {
/* 324 */           bool = (this._array[b] == intList._array[b]) ? true : false;
/*     */         }
/*     */       } 
/*     */     } 
/* 328 */     return bool;
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
/*     */   public int get(int paramInt) {
/* 344 */     if (paramInt >= this._limit)
/*     */     {
/* 346 */       throw new IndexOutOfBoundsException(paramInt + " not accessible in a list of length " + this._limit);
/*     */     }
/*     */ 
/*     */     
/* 350 */     return this._array[paramInt];
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 375 */     int i = 0;
/*     */     
/* 377 */     for (byte b = 0; b < this._limit; b++)
/*     */     {
/* 379 */       i = 31 * i + this._array[b];
/*     */     }
/* 381 */     return i;
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
/*     */   
/*     */   public int indexOf(int paramInt) {
/* 399 */     byte b = 0;
/*     */     
/* 401 */     for (; b < this._limit; b++) {
/*     */       
/* 403 */       if (paramInt == this._array[b]) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 408 */     if (b == this._limit)
/*     */     {
/* 410 */       b = -1;
/*     */     }
/* 412 */     return b;
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
/* 423 */     return (this._limit == 0);
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
/*     */   
/*     */   public int lastIndexOf(int paramInt) {
/* 441 */     int i = this._limit - 1;
/*     */     
/* 443 */     for (; i >= 0; i--) {
/*     */       
/* 445 */       if (paramInt == this._array[i]) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 450 */     return i;
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
/*     */ 
/*     */   
/*     */   public int remove(int paramInt) {
/* 469 */     if (paramInt >= this._limit)
/*     */     {
/* 471 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 473 */     int i = this._array[paramInt];
/*     */     
/* 475 */     System.arraycopy(this._array, paramInt + 1, this._array, paramInt, this._limit - paramInt);
/* 476 */     this._limit--;
/* 477 */     return i;
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
/*     */   public boolean removeValue(int paramInt) {
/* 494 */     boolean bool = false;
/*     */     
/* 496 */     for (byte b = 0; !bool && b < this._limit; b++) {
/*     */       
/* 498 */       if (paramInt == this._array[b]) {
/*     */         
/* 500 */         if (b + 1 < this._limit) {
/* 501 */           System.arraycopy(this._array, b + 1, this._array, b, this._limit - b);
/*     */         }
/* 503 */         this._limit--;
/* 504 */         bool = true;
/*     */       } 
/*     */     } 
/* 507 */     return bool;
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
/*     */   public boolean removeAll(IntList paramIntList) {
/* 522 */     boolean bool = false;
/*     */     
/* 524 */     for (byte b = 0; b < paramIntList._limit; b++) {
/*     */       
/* 526 */       if (removeValue(paramIntList._array[b]))
/*     */       {
/* 528 */         bool = true;
/*     */       }
/*     */     } 
/* 531 */     return bool;
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
/*     */   public boolean retainAll(IntList paramIntList) {
/* 548 */     boolean bool = false;
/*     */     
/* 550 */     for (byte b = 0; b < this._limit; ) {
/*     */       
/* 552 */       if (!paramIntList.contains(this._array[b])) {
/*     */         
/* 554 */         remove(b);
/* 555 */         bool = true;
/*     */         
/*     */         continue;
/*     */       } 
/* 559 */       b++;
/*     */     } 
/*     */     
/* 562 */     return bool;
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
/*     */   
/*     */   public int set(int paramInt1, int paramInt2) {
/* 580 */     if (paramInt1 >= this._limit)
/*     */     {
/* 582 */       throw new IndexOutOfBoundsException();
/*     */     }
/* 584 */     int i = this._array[paramInt1];
/*     */     
/* 586 */     this._array[paramInt1] = paramInt2;
/* 587 */     return i;
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
/* 600 */     return this._limit;
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
/*     */   public int[] toArray() {
/* 614 */     int[] arrayOfInt = new int[this._limit];
/*     */     
/* 616 */     System.arraycopy(this._array, 0, arrayOfInt, 0, this._limit);
/* 617 */     return arrayOfInt;
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
/*     */   
/*     */   public int[] toArray(int[] paramArrayOfint) {
/*     */     int[] arrayOfInt;
/* 636 */     if (paramArrayOfint.length == this._limit) {
/*     */       
/* 638 */       System.arraycopy(this._array, 0, paramArrayOfint, 0, this._limit);
/* 639 */       arrayOfInt = paramArrayOfint;
/*     */     }
/*     */     else {
/*     */       
/* 643 */       arrayOfInt = toArray();
/*     */     } 
/* 645 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */   
/*     */   private void growArray(int paramInt) {
/* 650 */     int i = (paramInt == this._array.length) ? (paramInt + 1) : paramInt;
/*     */     
/* 652 */     int[] arrayOfInt = new int[i];
/*     */     
/* 654 */     if (this.fillval != 0) {
/* 655 */       fillArray(this.fillval, arrayOfInt, this._array.length);
/*     */     }
/*     */     
/* 658 */     System.arraycopy(this._array, 0, arrayOfInt, 0, this._limit);
/* 659 */     this._array = arrayOfInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\IntList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */