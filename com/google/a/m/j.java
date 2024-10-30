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
/*     */ import java.util.function.LongConsumer;
/*     */ import java.util.stream.LongStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class j
/*     */   implements Serializable
/*     */ {
/*  92 */   private static final j a = new j(new long[0]);
/*     */   private final long[] g;
/*     */   
/*     */   public static j a() {
/*  96 */     return a;
/*     */   }
/*     */   private final transient int start; private final int end;
/*     */   
/*     */   public static j a(long paramLong) {
/* 101 */     return new j(new long[] { paramLong });
/*     */   }
/*     */ 
/*     */   
/*     */   public static j a(long paramLong1, long paramLong2) {
/* 106 */     return new j(new long[] { paramLong1, paramLong2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static j a(long paramLong1, long paramLong2, long paramLong3) {
/* 111 */     return new j(new long[] { paramLong1, paramLong2, paramLong3 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static j a(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/* 116 */     return new j(new long[] { paramLong1, paramLong2, paramLong3, paramLong4 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static j a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/* 121 */     return new j(new long[] { paramLong1, paramLong2, paramLong3, paramLong4, paramLong5 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static j a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
/* 126 */     return new j(new long[] { paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6 });
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
/*     */   public static j a(long paramLong, long... paramVarArgs) {
/* 139 */     D.a((paramVarArgs.length <= 2147483646), "the total number of elements must fit in an int");
/*     */     
/* 141 */     long[] arrayOfLong = new long[paramVarArgs.length + 1];
/* 142 */     arrayOfLong[0] = paramLong;
/* 143 */     System.arraycopy(paramVarArgs, 0, arrayOfLong, 1, paramVarArgs.length);
/* 144 */     return new j(arrayOfLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static j a(long[] paramArrayOflong) {
/* 149 */     return (paramArrayOflong.length == 0) ? 
/* 150 */       a : 
/* 151 */       new j(Arrays.copyOf(paramArrayOflong, paramArrayOflong.length));
/*     */   }
/*     */ 
/*     */   
/*     */   public static j a(Collection<Long> paramCollection) {
/* 156 */     return paramCollection.isEmpty() ? a : new j(m.a((Collection)paramCollection));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static j a(Iterable<Long> paramIterable) {
/* 167 */     if (paramIterable instanceof Collection) {
/* 168 */       return a((Collection<Long>)paramIterable);
/*     */     }
/* 170 */     return a().a(paramIterable).d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static j a(LongStream paramLongStream) {
/* 176 */     long[] arrayOfLong = paramLongStream.toArray();
/* 177 */     return (arrayOfLong.length == 0) ? a : new j(arrayOfLong);
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
/* 191 */     D.a((paramInt >= 0), "Invalid initialCapacity: %s", paramInt);
/* 192 */     return new b(paramInt);
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
/* 204 */     return new b(10);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public static final class b
/*     */   {
/*     */     private long[] g;
/*     */     
/* 214 */     private int count = 0;
/*     */     
/*     */     b(int param1Int) {
/* 217 */       this.g = new long[param1Int];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(long param1Long) {
/* 225 */       aF(1);
/* 226 */       this.g[this.count] = param1Long;
/* 227 */       this.count++;
/* 228 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(long[] param1ArrayOflong) {
/* 236 */       aF(param1ArrayOflong.length);
/* 237 */       System.arraycopy(param1ArrayOflong, 0, this.g, this.count, param1ArrayOflong.length);
/* 238 */       this.count += param1ArrayOflong.length;
/* 239 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(Iterable<Long> param1Iterable) {
/* 247 */       if (param1Iterable instanceof Collection) {
/* 248 */         return a((Collection<Long>)param1Iterable);
/*     */       }
/* 250 */       for (Long long_ : param1Iterable) {
/* 251 */         a(long_.longValue());
/*     */       }
/* 253 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(Collection<Long> param1Collection) {
/* 261 */       aF(param1Collection.size());
/* 262 */       for (Long long_ : param1Collection) {
/* 263 */         this.g[this.count++] = long_.longValue();
/*     */       }
/* 265 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(LongStream param1LongStream) {
/* 273 */       Spliterator.OfLong ofLong = param1LongStream.spliterator();
/* 274 */       long l = ofLong.getExactSizeIfKnown();
/* 275 */       if (l > 0L) {
/* 276 */         aF(k.e(l));
/*     */       }
/* 278 */       ofLong.forEachRemaining(this::a);
/* 279 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(j param1j) {
/* 287 */       aF(param1j.length());
/* 288 */       System.arraycopy(j.a(param1j), j.a(param1j), this.g, this.count, param1j.length());
/* 289 */       this.count += param1j.length();
/* 290 */       return this;
/*     */     }
/*     */     
/*     */     private void aF(int param1Int) {
/* 294 */       int i = this.count + param1Int;
/* 295 */       if (i > this.g.length) {
/* 296 */         this.g = Arrays.copyOf(this.g, h(this.g.length, i));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private static int h(int param1Int1, int param1Int2) {
/* 302 */       if (param1Int2 < 0) {
/* 303 */         throw new AssertionError("cannot store more than MAX_VALUE elements");
/*     */       }
/*     */       
/* 306 */       int i = param1Int1 + (param1Int1 >> 1) + 1;
/* 307 */       if (i < param1Int2) {
/* 308 */         i = Integer.highestOneBit(param1Int2 - 1) << 1;
/*     */       }
/* 310 */       if (i < 0) {
/* 311 */         i = Integer.MAX_VALUE;
/*     */       }
/* 313 */       return i;
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
/*     */     public j d() {
/* 326 */       return (this.count == 0) ? j.c() : new j(this.g, 0, this.count);
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
/*     */   private j(long[] paramArrayOflong) {
/* 347 */     this(paramArrayOflong, 0, paramArrayOflong.length);
/*     */   }
/*     */   
/*     */   private j(long[] paramArrayOflong, int paramInt1, int paramInt2) {
/* 351 */     this.g = paramArrayOflong;
/* 352 */     this.start = paramInt1;
/* 353 */     this.end = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 358 */     return this.end - this.start;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 363 */     return (this.end == this.start);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long c(int paramInt) {
/* 373 */     D.b(paramInt, length());
/* 374 */     return this.g[this.start + paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int b(long paramLong) {
/* 382 */     for (int i = this.start; i < this.end; i++) {
/* 383 */       if (this.g[i] == paramLong) {
/* 384 */         return i - this.start;
/*     */       }
/*     */     } 
/* 387 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int c(long paramLong) {
/* 395 */     for (int i = this.end - 1; i >= this.start; i--) {
/* 396 */       if (this.g[i] == paramLong) {
/* 397 */         return i - this.start;
/*     */       }
/*     */     } 
/* 400 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean i(long paramLong) {
/* 408 */     return (b(paramLong) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(LongConsumer paramLongConsumer) {
/* 413 */     D.checkNotNull(paramLongConsumer);
/* 414 */     for (int i = this.start; i < this.end; i++) {
/* 415 */       paramLongConsumer.accept(this.g[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public LongStream a() {
/* 421 */     return Arrays.stream(this.g, this.start, this.end);
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] a() {
/* 426 */     return Arrays.copyOfRange(this.g, this.start, this.end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a(int paramInt1, int paramInt2) {
/* 437 */     D.a(paramInt1, paramInt2, length());
/* 438 */     return (paramInt1 == paramInt2) ? 
/* 439 */       a : 
/* 440 */       new j(this.g, this.start + paramInt1, this.start + paramInt2);
/*     */   }
/*     */   
/*     */   private Spliterator.OfLong a() {
/* 444 */     return Spliterators.spliterator(this.g, this.start, this.end, 1040);
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
/*     */   public List<Long> asList() {
/* 460 */     return new a(this);
/*     */   }
/*     */   
/*     */   static class a extends AbstractList<Long> implements Serializable, RandomAccess {
/*     */     private final j b;
/*     */     
/*     */     private a(j param1j) {
/* 467 */       this.b = param1j;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 474 */       return this.b.length();
/*     */     }
/*     */ 
/*     */     
/*     */     public Long a(int param1Int) {
/* 479 */       return Long.valueOf(this.b.c(param1Int));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 484 */       return (indexOf(param1Object) >= 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 489 */       return (param1Object instanceof Long) ? this.b.b(((Long)param1Object).longValue()) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 494 */       return (param1Object instanceof Long) ? this.b.c(((Long)param1Object).longValue()) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Long> subList(int param1Int1, int param1Int2) {
/* 499 */       return this.b.a(param1Int1, param1Int2).asList();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Spliterator<Long> spliterator() {
/* 505 */       return j.a(this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 510 */       if (param1Object instanceof a) {
/* 511 */         a a1 = (a)param1Object;
/* 512 */         return this.b.equals(a1.b);
/*     */       } 
/*     */       
/* 515 */       if (!(param1Object instanceof List)) {
/* 516 */         return false;
/*     */       }
/* 518 */       List list = (List)param1Object;
/* 519 */       if (size() != list.size()) {
/* 520 */         return false;
/*     */       }
/* 522 */       int i = j.a(this.b);
/*     */       
/* 524 */       for (Long long_ : list) {
/* 525 */         if (!(long_ instanceof Long) || j.a(this.b)[i++] != ((Long)long_).longValue()) {
/* 526 */           return false;
/*     */         }
/*     */       } 
/* 529 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 535 */       return this.b.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 540 */       return this.b.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 550 */     if (paramObject == this) {
/* 551 */       return true;
/*     */     }
/* 553 */     if (!(paramObject instanceof j)) {
/* 554 */       return false;
/*     */     }
/* 556 */     j j1 = (j)paramObject;
/* 557 */     if (length() != j1.length()) {
/* 558 */       return false;
/*     */     }
/* 560 */     for (byte b = 0; b < length(); b++) {
/* 561 */       if (c(b) != j1.c(b)) {
/* 562 */         return false;
/*     */       }
/*     */     } 
/* 565 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 571 */     int i = 1;
/* 572 */     for (int k = this.start; k < this.end; k++) {
/* 573 */       i *= 31;
/* 574 */       i += m.f(this.g[k]);
/*     */     } 
/* 576 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 585 */     if (isEmpty()) {
/* 586 */       return "[]";
/*     */     }
/* 588 */     StringBuilder stringBuilder = new StringBuilder(length() * 5);
/* 589 */     stringBuilder.append('[').append(this.g[this.start]);
/*     */     
/* 591 */     for (int i = this.start + 1; i < this.end; i++) {
/* 592 */       stringBuilder.append(", ").append(this.g[i]);
/*     */     }
/* 594 */     stringBuilder.append(']');
/* 595 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j b() {
/* 605 */     return cO() ? new j(a()) : this;
/*     */   }
/*     */   
/*     */   private boolean cO() {
/* 609 */     return (this.start > 0 || this.end < this.g.length);
/*     */   }
/*     */   
/*     */   Object writeReplace() {
/* 613 */     return b();
/*     */   }
/*     */   
/*     */   Object readResolve() {
/* 617 */     return isEmpty() ? a : this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */