/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.j;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.RandomAccess;
/*     */ import java.util.Spliterator;
/*     */ import java.util.Spliterators;
/*     */ import java.util.function.IntConsumer;
/*     */ import java.util.stream.IntStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @j
/*     */ @a
/*     */ @b
/*     */ public final class i
/*     */   implements Serializable
/*     */ {
/*  92 */   private static final i a = new i(new int[0]);
/*     */   private final int[] aa;
/*     */   
/*     */   public static i a() {
/*  96 */     return a;
/*     */   }
/*     */   private final transient int start; private final int end;
/*     */   
/*     */   public static i a(int paramInt) {
/* 101 */     return new i(new int[] { paramInt });
/*     */   }
/*     */ 
/*     */   
/*     */   public static i a(int paramInt1, int paramInt2) {
/* 106 */     return new i(new int[] { paramInt1, paramInt2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static i a(int paramInt1, int paramInt2, int paramInt3) {
/* 111 */     return new i(new int[] { paramInt1, paramInt2, paramInt3 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static i a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 116 */     return new i(new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static i a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 121 */     return new i(new int[] { paramInt1, paramInt2, paramInt3, paramInt4, paramInt5 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static i a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 126 */     return new i(new int[] { paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6 });
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
/*     */   public static i a(int paramInt, int... paramVarArgs) {
/* 139 */     D.a((paramVarArgs.length <= 2147483646), "the total number of elements must fit in an int");
/*     */     
/* 141 */     int[] arrayOfInt = new int[paramVarArgs.length + 1];
/* 142 */     arrayOfInt[0] = paramInt;
/* 143 */     System.arraycopy(paramVarArgs, 0, arrayOfInt, 1, paramVarArgs.length);
/* 144 */     return new i(arrayOfInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static i a(int[] paramArrayOfint) {
/* 149 */     return (paramArrayOfint.length == 0) ? a : new i(Arrays.copyOf(paramArrayOfint, paramArrayOfint.length));
/*     */   }
/*     */ 
/*     */   
/*     */   public static i a(Collection<Integer> paramCollection) {
/* 154 */     return paramCollection.isEmpty() ? a : new i(k.a((Collection)paramCollection));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static i a(Iterable<Integer> paramIterable) {
/* 165 */     if (paramIterable instanceof Collection) {
/* 166 */       return a((Collection<Integer>)paramIterable);
/*     */     }
/* 168 */     return a().a(paramIterable).d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static i a(IntStream paramIntStream) {
/* 174 */     int[] arrayOfInt = paramIntStream.toArray();
/* 175 */     return (arrayOfInt.length == 0) ? a : new i(arrayOfInt);
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
/*     */   public static b a(int paramInt) {
/* 189 */     D.a((paramInt >= 0), "Invalid initialCapacity: %s", paramInt);
/* 190 */     return new b(paramInt);
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
/*     */   public static b a() {
/* 202 */     return new b(10);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public static final class b
/*     */   {
/*     */     private int[] aa;
/*     */     
/* 212 */     private int count = 0;
/*     */     
/*     */     b(int param1Int) {
/* 215 */       this.aa = new int[param1Int];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b b(int param1Int) {
/* 223 */       aF(1);
/* 224 */       this.aa[this.count] = param1Int;
/* 225 */       this.count++;
/* 226 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(int[] param1ArrayOfint) {
/* 234 */       aF(param1ArrayOfint.length);
/* 235 */       System.arraycopy(param1ArrayOfint, 0, this.aa, this.count, param1ArrayOfint.length);
/* 236 */       this.count += param1ArrayOfint.length;
/* 237 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(Iterable<Integer> param1Iterable) {
/* 245 */       if (param1Iterable instanceof Collection) {
/* 246 */         return a((Collection<Integer>)param1Iterable);
/*     */       }
/* 248 */       for (Integer integer : param1Iterable) {
/* 249 */         b(integer.intValue());
/*     */       }
/* 251 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(Collection<Integer> param1Collection) {
/* 259 */       aF(param1Collection.size());
/* 260 */       for (Integer integer : param1Collection) {
/* 261 */         this.aa[this.count++] = integer.intValue();
/*     */       }
/* 263 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(IntStream param1IntStream) {
/* 271 */       Spliterator.OfInt ofInt = param1IntStream.spliterator();
/* 272 */       long l = ofInt.getExactSizeIfKnown();
/* 273 */       if (l > 0L) {
/* 274 */         aF(k.e(l));
/*     */       }
/* 276 */       ofInt.forEachRemaining(this::b);
/* 277 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(i param1i) {
/* 285 */       aF(param1i.length());
/* 286 */       System.arraycopy(i.a(param1i), i.a(param1i), this.aa, this.count, param1i.length());
/* 287 */       this.count += param1i.length();
/* 288 */       return this;
/*     */     }
/*     */     
/*     */     private void aF(int param1Int) {
/* 292 */       int i = this.count + param1Int;
/* 293 */       if (i > this.aa.length) {
/* 294 */         this.aa = Arrays.copyOf(this.aa, h(this.aa.length, i));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private static int h(int param1Int1, int param1Int2) {
/* 300 */       if (param1Int2 < 0) {
/* 301 */         throw new AssertionError("cannot store more than MAX_VALUE elements");
/*     */       }
/*     */       
/* 304 */       int i = param1Int1 + (param1Int1 >> 1) + 1;
/* 305 */       if (i < param1Int2) {
/* 306 */         i = Integer.highestOneBit(param1Int2 - 1) << 1;
/*     */       }
/* 308 */       if (i < 0) {
/* 309 */         i = Integer.MAX_VALUE;
/*     */       }
/* 311 */       return i;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.b
/*     */     public i d() {
/* 324 */       return (this.count == 0) ? i.c() : new i(this.aa, 0, this.count);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private i(int[] paramArrayOfint) {
/* 345 */     this(paramArrayOfint, 0, paramArrayOfint.length);
/*     */   }
/*     */   
/*     */   private i(int[] paramArrayOfint, int paramInt1, int paramInt2) {
/* 349 */     this.aa = paramArrayOfint;
/* 350 */     this.start = paramInt1;
/* 351 */     this.end = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 356 */     return this.end - this.start;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 361 */     return (this.end == this.start);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(int paramInt) {
/* 371 */     D.b(paramInt, length());
/* 372 */     return this.aa[this.start + paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(int paramInt) {
/* 380 */     for (int j = this.start; j < this.end; j++) {
/* 381 */       if (this.aa[j] == paramInt) {
/* 382 */         return j - this.start;
/*     */       }
/*     */     } 
/* 385 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int lastIndexOf(int paramInt) {
/* 393 */     for (int j = this.end - 1; j >= this.start; j--) {
/* 394 */       if (this.aa[j] == paramInt) {
/* 395 */         return j - this.start;
/*     */       }
/*     */     } 
/* 398 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(int paramInt) {
/* 406 */     return (indexOf(paramInt) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(IntConsumer paramIntConsumer) {
/* 411 */     D.checkNotNull(paramIntConsumer);
/* 412 */     for (int j = this.start; j < this.end; j++) {
/* 413 */       paramIntConsumer.accept(this.aa[j]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public IntStream a() {
/* 419 */     return Arrays.stream(this.aa, this.start, this.end);
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] toArray() {
/* 424 */     return Arrays.copyOfRange(this.aa, this.start, this.end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i b(int paramInt1, int paramInt2) {
/* 435 */     D.a(paramInt1, paramInt2, length());
/* 436 */     return (paramInt1 == paramInt2) ? 
/* 437 */       a : 
/* 438 */       new i(this.aa, this.start + paramInt1, this.start + paramInt2);
/*     */   }
/*     */   
/*     */   private Spliterator.OfInt a() {
/* 442 */     return Spliterators.spliterator(this.aa, this.start, this.end, 1040);
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
/*     */   public List<Integer> asList() {
/* 458 */     return new a(this);
/*     */   }
/*     */   
/*     */   static class a extends AbstractList<Integer> implements Serializable, RandomAccess {
/*     */     private final i b;
/*     */     
/*     */     private a(i param1i) {
/* 465 */       this.b = param1i;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 472 */       return this.b.length();
/*     */     }
/*     */ 
/*     */     
/*     */     public Integer a(int param1Int) {
/* 477 */       return Integer.valueOf(this.b.get(param1Int));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 482 */       return (indexOf(param1Object) >= 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 487 */       return (param1Object instanceof Integer) ? this.b.indexOf(((Integer)param1Object).intValue()) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 492 */       return (param1Object instanceof Integer) ? this.b.lastIndexOf(((Integer)param1Object).intValue()) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Integer> subList(int param1Int1, int param1Int2) {
/* 497 */       return this.b.b(param1Int1, param1Int2).asList();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Spliterator<Integer> spliterator() {
/* 503 */       return i.a(this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 508 */       if (param1Object instanceof a) {
/* 509 */         a a1 = (a)param1Object;
/* 510 */         return this.b.equals(a1.b);
/*     */       } 
/*     */       
/* 513 */       if (!(param1Object instanceof List)) {
/* 514 */         return false;
/*     */       }
/* 516 */       List list = (List)param1Object;
/* 517 */       if (size() != list.size()) {
/* 518 */         return false;
/*     */       }
/* 520 */       int j = i.a(this.b);
/*     */       
/* 522 */       for (Integer integer : list) {
/* 523 */         if (!(integer instanceof Integer) || i.a(this.b)[j++] != ((Integer)integer).intValue()) {
/* 524 */           return false;
/*     */         }
/*     */       } 
/* 527 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 533 */       return this.b.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 538 */       return this.b.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 548 */     if (paramObject == this) {
/* 549 */       return true;
/*     */     }
/* 551 */     if (!(paramObject instanceof i)) {
/* 552 */       return false;
/*     */     }
/* 554 */     i i1 = (i)paramObject;
/* 555 */     if (length() != i1.length()) {
/* 556 */       return false;
/*     */     }
/* 558 */     for (byte b = 0; b < length(); b++) {
/* 559 */       if (get(b) != i1.get(b)) {
/* 560 */         return false;
/*     */       }
/*     */     } 
/* 563 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 569 */     int j = 1;
/* 570 */     for (int k = this.start; k < this.end; k++) {
/* 571 */       j *= 31;
/* 572 */       j += k.R(this.aa[k]);
/*     */     } 
/* 574 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 583 */     if (isEmpty()) {
/* 584 */       return "[]";
/*     */     }
/* 586 */     StringBuilder stringBuilder = new StringBuilder(length() * 5);
/* 587 */     stringBuilder.append('[').append(this.aa[this.start]);
/*     */     
/* 589 */     for (int j = this.start + 1; j < this.end; j++) {
/* 590 */       stringBuilder.append(", ").append(this.aa[j]);
/*     */     }
/* 592 */     stringBuilder.append(']');
/* 593 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i b() {
/* 603 */     return cO() ? new i(toArray()) : this;
/*     */   }
/*     */   
/*     */   private boolean cO() {
/* 607 */     return (this.start > 0 || this.end < this.aa.length);
/*     */   }
/*     */   
/*     */   Object writeReplace() {
/* 611 */     return b();
/*     */   }
/*     */   
/*     */   Object readResolve() {
/* 615 */     return isEmpty() ? a : this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */