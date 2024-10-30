/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.m.d;
/*     */ import java.io.Serializable;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.util.Iterator;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.DoubleStream;
/*     */ import java.util.stream.IntStream;
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
/*     */ @a
/*     */ @c
/*     */ public final class l
/*     */   implements Serializable
/*     */ {
/*     */   private final long count;
/*     */   private final double mean;
/*     */   private final double K;
/*     */   private final double L;
/*     */   private final double M;
/*     */   static final int BYTES = 40;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   l(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/*  90 */     this.count = paramLong;
/*  91 */     this.mean = paramDouble1;
/*  92 */     this.K = paramDouble2;
/*  93 */     this.L = paramDouble3;
/*  94 */     this.M = paramDouble4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(Iterable<? extends Number> paramIterable) {
/* 104 */     m m = new m();
/* 105 */     m.b(paramIterable);
/* 106 */     return m.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(Iterator<? extends Number> paramIterator) {
/* 117 */     m m = new m();
/* 118 */     m.c(paramIterator);
/* 119 */     return m.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(double... paramVarArgs) {
/* 128 */     m m = new m();
/* 129 */     m.a(paramVarArgs);
/* 130 */     return m.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(int... paramVarArgs) {
/* 139 */     m m = new m();
/* 140 */     m.a(paramVarArgs);
/* 141 */     return m.c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(long... paramVarArgs) {
/* 151 */     m m = new m();
/* 152 */     m.a(paramVarArgs);
/* 153 */     return m.c();
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
/*     */   public static l a(DoubleStream paramDoubleStream) {
/* 167 */     return ((m)paramDoubleStream
/* 168 */       .<m>collect(m::new, m::add, m::a))
/* 169 */       .c();
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
/*     */   public static l a(IntStream paramIntStream) {
/* 183 */     return ((m)paramIntStream
/* 184 */       .<m>collect(m::new, m::add, m::a))
/* 185 */       .c();
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
/*     */   public static l a(LongStream paramLongStream) {
/* 200 */     return ((m)paramLongStream
/* 201 */       .<m>collect(m::new, m::add, m::a))
/* 202 */       .c();
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
/*     */   public static Collector<Number, m, l> h() {
/* 217 */     return Collector.of(m::new, (paramm, paramNumber) -> paramm.add(paramNumber.doubleValue()), (paramm1, paramm2) -> { paramm1.a(paramm2); return paramm1; }m::c, new Collector.Characteristics[] { Collector.Characteristics.UNORDERED });
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
/*     */   public long count() {
/* 230 */     return this.count;
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
/*     */   public double B() {
/* 255 */     D.ab((this.count != 0L));
/* 256 */     return this.mean;
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
/*     */   public double C() {
/* 272 */     return this.mean * this.count;
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
/*     */   public double D() {
/* 291 */     D.ab((this.count > 0L));
/* 292 */     if (Double.isNaN(this.K)) {
/* 293 */       return Double.NaN;
/*     */     }
/* 295 */     if (this.count == 1L) {
/* 296 */       return 0.0D;
/*     */     }
/* 298 */     return d.g(this.K) / count();
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
/*     */   public double E() {
/* 318 */     return Math.sqrt(D());
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
/*     */   public double F() {
/* 338 */     D.ab((this.count > 1L));
/* 339 */     if (Double.isNaN(this.K)) {
/* 340 */       return Double.NaN;
/*     */     }
/* 342 */     return d.g(this.K) / (this.count - 1L);
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
/*     */   public double G() {
/* 364 */     return Math.sqrt(F());
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
/*     */   public double H() {
/* 381 */     D.ab((this.count != 0L));
/* 382 */     return this.L;
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
/*     */   public double I() {
/* 399 */     D.ab((this.count != 0L));
/* 400 */     return this.M;
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
/*     */   public boolean equals(Object paramObject) {
/* 420 */     if (paramObject == null) {
/* 421 */       return false;
/*     */     }
/* 423 */     if (getClass() != paramObject.getClass()) {
/* 424 */       return false;
/*     */     }
/* 426 */     l l1 = (l)paramObject;
/* 427 */     return (this.count == l1.count && 
/* 428 */       Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(l1.mean) && 
/* 429 */       Double.doubleToLongBits(this.K) == Double.doubleToLongBits(l1.K) && 
/* 430 */       Double.doubleToLongBits(this.L) == Double.doubleToLongBits(l1.L) && 
/* 431 */       Double.doubleToLongBits(this.M) == Double.doubleToLongBits(l1.M));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 442 */     return y.a(new Object[] { Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.K), Double.valueOf(this.L), Double.valueOf(this.M) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 447 */     if (count() > 0L) {
/* 448 */       return x.a(this)
/* 449 */         .a("count", this.count)
/* 450 */         .a("mean", this.mean)
/* 451 */         .a("populationStandardDeviation", E())
/* 452 */         .a("min", this.L)
/* 453 */         .a("max", this.M)
/* 454 */         .toString();
/*     */     }
/* 456 */     return x.a(this).a("count", this.count).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   double J() {
/* 461 */     return this.K;
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
/*     */   public static double b(Iterable<? extends Number> paramIterable) {
/* 475 */     return b(paramIterable.iterator());
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
/*     */   public static double b(Iterator<? extends Number> paramIterator) {
/* 489 */     D.checkArgument(paramIterator.hasNext());
/* 490 */     long l1 = 1L;
/* 491 */     double d = ((Number)paramIterator.next()).doubleValue();
/* 492 */     while (paramIterator.hasNext()) {
/* 493 */       double d1 = ((Number)paramIterator.next()).doubleValue();
/* 494 */       l1++;
/* 495 */       if (d.e(d1) && d.e(d)) {
/*     */         
/* 497 */         d += (d1 - d) / l1; continue;
/*     */       } 
/* 499 */       d = m.b(d, d1);
/*     */     } 
/*     */     
/* 502 */     return d;
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
/*     */   public static double d(double... paramVarArgs) {
/* 515 */     D.checkArgument((paramVarArgs.length > 0));
/* 516 */     double d = paramVarArgs[0];
/* 517 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 518 */       double d1 = paramVarArgs[b];
/* 519 */       if (d.e(d1) && d.e(d)) {
/*     */         
/* 521 */         d += (d1 - d) / (b + 1);
/*     */       } else {
/* 523 */         d = m.b(d, d1);
/*     */       } 
/*     */     } 
/* 526 */     return d;
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
/*     */   public static double c(int... paramVarArgs) {
/* 539 */     D.checkArgument((paramVarArgs.length > 0));
/* 540 */     double d = paramVarArgs[0];
/* 541 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 542 */       double d1 = paramVarArgs[b];
/* 543 */       if (d.e(d1) && d.e(d)) {
/*     */         
/* 545 */         d += (d1 - d) / (b + 1);
/*     */       } else {
/* 547 */         d = m.b(d, d1);
/*     */       } 
/*     */     } 
/* 550 */     return d;
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
/*     */   public static double c(long... paramVarArgs) {
/* 564 */     D.checkArgument((paramVarArgs.length > 0));
/* 565 */     double d = paramVarArgs[0];
/* 566 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 567 */       double d1 = paramVarArgs[b];
/* 568 */       if (d.e(d1) && d.e(d)) {
/*     */         
/* 570 */         d += (d1 - d) / (b + 1);
/*     */       } else {
/* 572 */         d = m.b(d, d1);
/*     */       } 
/*     */     } 
/* 575 */     return d;
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
/*     */   public byte[] toByteArray() {
/* 590 */     ByteBuffer byteBuffer = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
/* 591 */     e(byteBuffer);
/* 592 */     return byteBuffer.array();
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
/*     */   void e(ByteBuffer paramByteBuffer) {
/* 606 */     D.checkNotNull(paramByteBuffer);
/* 607 */     D.a(
/* 608 */         (paramByteBuffer.remaining() >= 40), "Expected at least Stats.BYTES = %s remaining , got %s", 40, paramByteBuffer
/*     */ 
/*     */         
/* 611 */         .remaining());
/* 612 */     paramByteBuffer
/* 613 */       .putLong(this.count)
/* 614 */       .putDouble(this.mean)
/* 615 */       .putDouble(this.K)
/* 616 */       .putDouble(this.L)
/* 617 */       .putDouble(this.M);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static l a(byte[] paramArrayOfbyte) {
/* 628 */     D.checkNotNull(paramArrayOfbyte);
/* 629 */     D.a((paramArrayOfbyte.length == 40), "Expected Stats.BYTES = %s remaining , got %s", 40, paramArrayOfbyte.length);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 634 */     return a(ByteBuffer.wrap(paramArrayOfbyte).order(ByteOrder.LITTLE_ENDIAN));
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
/*     */   static l a(ByteBuffer paramByteBuffer) {
/* 648 */     D.checkNotNull(paramByteBuffer);
/* 649 */     D.a(
/* 650 */         (paramByteBuffer.remaining() >= 40), "Expected at least Stats.BYTES = %s remaining , got %s", 40, paramByteBuffer
/*     */ 
/*     */         
/* 653 */         .remaining());
/* 654 */     return new l(paramByteBuffer
/* 655 */         .getLong(), paramByteBuffer
/* 656 */         .getDouble(), paramByteBuffer
/* 657 */         .getDouble(), paramByteBuffer
/* 658 */         .getDouble(), paramByteBuffer
/* 659 */         .getDouble());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */