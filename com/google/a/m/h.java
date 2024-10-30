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
/*     */ import java.util.function.DoubleConsumer;
/*     */ import java.util.stream.DoubleStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class h
/*     */   implements Serializable
/*     */ {
/*  92 */   private static final h a = new h(new double[0]);
/*     */   private final double[] b;
/*     */   
/*     */   public static h a() {
/*  96 */     return a;
/*     */   }
/*     */   private final transient int start; private final int end;
/*     */   
/*     */   public static h a(double paramDouble) {
/* 101 */     return new h(new double[] { paramDouble });
/*     */   }
/*     */ 
/*     */   
/*     */   public static h a(double paramDouble1, double paramDouble2) {
/* 106 */     return new h(new double[] { paramDouble1, paramDouble2 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static h a(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 111 */     return new h(new double[] { paramDouble1, paramDouble2, paramDouble3 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static h a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 116 */     return new h(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4 });
/*     */   }
/*     */ 
/*     */   
/*     */   public static h a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5) {
/* 121 */     return new h(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5 });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static h a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
/* 127 */     return new h(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6 });
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
/*     */   public static h a(double paramDouble, double... paramVarArgs) {
/* 140 */     D.a((paramVarArgs.length <= 2147483646), "the total number of elements must fit in an int");
/*     */     
/* 142 */     double[] arrayOfDouble = new double[paramVarArgs.length + 1];
/* 143 */     arrayOfDouble[0] = paramDouble;
/* 144 */     System.arraycopy(paramVarArgs, 0, arrayOfDouble, 1, paramVarArgs.length);
/* 145 */     return new h(arrayOfDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static h a(double[] paramArrayOfdouble) {
/* 150 */     return (paramArrayOfdouble.length == 0) ? 
/* 151 */       a : 
/* 152 */       new h(Arrays.copyOf(paramArrayOfdouble, paramArrayOfdouble.length));
/*     */   }
/*     */ 
/*     */   
/*     */   public static h a(Collection<Double> paramCollection) {
/* 157 */     return paramCollection.isEmpty() ? a : new h(d.a((Collection)paramCollection));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static h a(Iterable<Double> paramIterable) {
/* 168 */     if (paramIterable instanceof Collection) {
/* 169 */       return a((Collection<Double>)paramIterable);
/*     */     }
/* 171 */     return a().a(paramIterable).d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static h a(DoubleStream paramDoubleStream) {
/* 177 */     double[] arrayOfDouble = paramDoubleStream.toArray();
/* 178 */     return (arrayOfDouble.length == 0) ? a : new h(arrayOfDouble);
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
/* 192 */     D.a((paramInt >= 0), "Invalid initialCapacity: %s", paramInt);
/* 193 */     return new b(paramInt);
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
/* 205 */     return new b(10);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public static final class b
/*     */   {
/*     */     private double[] b;
/*     */     
/* 215 */     private int count = 0;
/*     */     
/*     */     b(int param1Int) {
/* 218 */       this.b = new double[param1Int];
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(double param1Double) {
/* 226 */       aF(1);
/* 227 */       this.b[this.count] = param1Double;
/* 228 */       this.count++;
/* 229 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(double[] param1ArrayOfdouble) {
/* 237 */       aF(param1ArrayOfdouble.length);
/* 238 */       System.arraycopy(param1ArrayOfdouble, 0, this.b, this.count, param1ArrayOfdouble.length);
/* 239 */       this.count += param1ArrayOfdouble.length;
/* 240 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(Iterable<Double> param1Iterable) {
/* 248 */       if (param1Iterable instanceof Collection) {
/* 249 */         return a((Collection<Double>)param1Iterable);
/*     */       }
/* 251 */       for (Double double_ : param1Iterable) {
/* 252 */         a(double_.doubleValue());
/*     */       }
/* 254 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(Collection<Double> param1Collection) {
/* 262 */       aF(param1Collection.size());
/* 263 */       for (Double double_ : param1Collection) {
/* 264 */         this.b[this.count++] = double_.doubleValue();
/*     */       }
/* 266 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(DoubleStream param1DoubleStream) {
/* 274 */       Spliterator.OfDouble ofDouble = param1DoubleStream.spliterator();
/* 275 */       long l = ofDouble.getExactSizeIfKnown();
/* 276 */       if (l > 0L) {
/* 277 */         aF(k.e(l));
/*     */       }
/* 279 */       ofDouble.forEachRemaining(this::a);
/* 280 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b a(h param1h) {
/* 288 */       aF(param1h.length());
/* 289 */       System.arraycopy(h.a(param1h), h.a(param1h), this.b, this.count, param1h.length());
/* 290 */       this.count += param1h.length();
/* 291 */       return this;
/*     */     }
/*     */     
/*     */     private void aF(int param1Int) {
/* 295 */       int i = this.count + param1Int;
/* 296 */       if (i > this.b.length) {
/* 297 */         this.b = Arrays.copyOf(this.b, h(this.b.length, i));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private static int h(int param1Int1, int param1Int2) {
/* 303 */       if (param1Int2 < 0) {
/* 304 */         throw new AssertionError("cannot store more than MAX_VALUE elements");
/*     */       }
/*     */       
/* 307 */       int i = param1Int1 + (param1Int1 >> 1) + 1;
/* 308 */       if (i < param1Int2) {
/* 309 */         i = Integer.highestOneBit(param1Int2 - 1) << 1;
/*     */       }
/* 311 */       if (i < 0) {
/* 312 */         i = Integer.MAX_VALUE;
/*     */       }
/* 314 */       return i;
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
/*     */     public h d() {
/* 327 */       return (this.count == 0) ? h.c() : new h(this.b, 0, this.count);
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
/*     */   private h(double[] paramArrayOfdouble) {
/* 348 */     this(paramArrayOfdouble, 0, paramArrayOfdouble.length);
/*     */   }
/*     */   
/*     */   private h(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 352 */     this.b = paramArrayOfdouble;
/* 353 */     this.start = paramInt1;
/* 354 */     this.end = paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/* 359 */     return this.end - this.start;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 364 */     return (this.end == this.start);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double a(int paramInt) {
/* 374 */     D.b(paramInt, length());
/* 375 */     return this.b[this.start + paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int c(double paramDouble) {
/* 384 */     for (int i = this.start; i < this.end; i++) {
/* 385 */       if (a(this.b[i], paramDouble)) {
/* 386 */         return i - this.start;
/*     */       }
/*     */     } 
/* 389 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int d(double paramDouble) {
/* 398 */     for (int i = this.end - 1; i >= this.start; i--) {
/* 399 */       if (a(this.b[i], paramDouble)) {
/* 400 */         return i - this.start;
/*     */       }
/*     */     } 
/* 403 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean g(double paramDouble) {
/* 411 */     return (c(paramDouble) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(DoubleConsumer paramDoubleConsumer) {
/* 416 */     D.checkNotNull(paramDoubleConsumer);
/* 417 */     for (int i = this.start; i < this.end; i++) {
/* 418 */       paramDoubleConsumer.accept(this.b[i]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public DoubleStream a() {
/* 424 */     return Arrays.stream(this.b, this.start, this.end);
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] toArray() {
/* 429 */     return Arrays.copyOfRange(this.b, this.start, this.end);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h a(int paramInt1, int paramInt2) {
/* 440 */     D.a(paramInt1, paramInt2, length());
/* 441 */     return (paramInt1 == paramInt2) ? 
/* 442 */       a : 
/* 443 */       new h(this.b, this.start + paramInt1, this.start + paramInt2);
/*     */   }
/*     */   
/*     */   private Spliterator.OfDouble a() {
/* 447 */     return Spliterators.spliterator(this.b, this.start, this.end, 1040);
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
/*     */   public List<Double> asList() {
/* 463 */     return new a(this);
/*     */   }
/*     */   
/*     */   static class a extends AbstractList<Double> implements Serializable, RandomAccess {
/*     */     private final h b;
/*     */     
/*     */     private a(h param1h) {
/* 470 */       this.b = param1h;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 477 */       return this.b.length();
/*     */     }
/*     */ 
/*     */     
/*     */     public Double a(int param1Int) {
/* 482 */       return Double.valueOf(this.b.a(param1Int));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 487 */       return (indexOf(param1Object) >= 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 492 */       return (param1Object instanceof Double) ? this.b.c(((Double)param1Object).doubleValue()) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 497 */       return (param1Object instanceof Double) ? this.b.d(((Double)param1Object).doubleValue()) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Double> subList(int param1Int1, int param1Int2) {
/* 502 */       return this.b.a(param1Int1, param1Int2).asList();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Spliterator<Double> spliterator() {
/* 508 */       return h.a(this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 513 */       if (param1Object instanceof a) {
/* 514 */         a a1 = (a)param1Object;
/* 515 */         return this.b.equals(a1.b);
/*     */       } 
/*     */       
/* 518 */       if (!(param1Object instanceof List)) {
/* 519 */         return false;
/*     */       }
/* 521 */       List list = (List)param1Object;
/* 522 */       if (size() != list.size()) {
/* 523 */         return false;
/*     */       }
/* 525 */       int i = h.a(this.b);
/*     */       
/* 527 */       for (Double double_ : list) {
/* 528 */         if (!(double_ instanceof Double) || !h.b(h.a(this.b)[i++], ((Double)double_).doubleValue())) {
/* 529 */           return false;
/*     */         }
/*     */       } 
/* 532 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 538 */       return this.b.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 543 */       return this.b.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 553 */     if (paramObject == this) {
/* 554 */       return true;
/*     */     }
/* 556 */     if (!(paramObject instanceof h)) {
/* 557 */       return false;
/*     */     }
/* 559 */     h h1 = (h)paramObject;
/* 560 */     if (length() != h1.length()) {
/* 561 */       return false;
/*     */     }
/* 563 */     for (byte b = 0; b < length(); b++) {
/* 564 */       if (!a(a(b), h1.a(b))) {
/* 565 */         return false;
/*     */       }
/*     */     } 
/* 568 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(double paramDouble1, double paramDouble2) {
/* 573 */     return (Double.doubleToLongBits(paramDouble1) == Double.doubleToLongBits(paramDouble2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 579 */     int i = 1;
/* 580 */     for (int j = this.start; j < this.end; j++) {
/* 581 */       i *= 31;
/* 582 */       i += d.b(this.b[j]);
/*     */     } 
/* 584 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 593 */     if (isEmpty()) {
/* 594 */       return "[]";
/*     */     }
/* 596 */     StringBuilder stringBuilder = new StringBuilder(length() * 5);
/* 597 */     stringBuilder.append('[').append(this.b[this.start]);
/*     */     
/* 599 */     for (int i = this.start + 1; i < this.end; i++) {
/* 600 */       stringBuilder.append(", ").append(this.b[i]);
/*     */     }
/* 602 */     stringBuilder.append(']');
/* 603 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h b() {
/* 613 */     return cO() ? new h(toArray()) : this;
/*     */   }
/*     */   
/*     */   private boolean cO() {
/* 617 */     return (this.start > 0 || this.end < this.b.length);
/*     */   }
/*     */   
/*     */   Object writeReplace() {
/* 621 */     return b();
/*     */   }
/*     */   
/*     */   Object readResolve() {
/* 625 */     return isEmpty() ? a : this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */