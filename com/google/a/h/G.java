/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.E;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.k.c;
/*     */ import com.google.a.m.s;
/*     */ import com.google.a.m.t;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.concurrent.atomic.AtomicLongArray;
/*     */ import java.util.stream.Collector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class g<T>
/*     */   implements E<T>, Serializable
/*     */ {
/*     */   private final h.a a;
/*     */   private final int fv;
/*     */   private final l<? super T> a;
/*     */   private final b a;
/*     */   
/*     */   private g(h.a parama, int paramInt, l<? super T> paraml, b paramb) {
/* 115 */     D.a((paramInt > 0), "numHashFunctions (%s) must be > 0", paramInt);
/* 116 */     D.a((paramInt <= 255), "numHashFunctions (%s) must be <= 255", paramInt);
/*     */     
/* 118 */     this.a = (b)D.checkNotNull(parama);
/* 119 */     this.fv = paramInt;
/* 120 */     this.a = (b)D.checkNotNull(paraml);
/* 121 */     this.a = (b)D.checkNotNull(paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g<T> a() {
/* 131 */     return new g(this.a.a(), this.fv, (l<? super T>)this.a, this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean A(T paramT) {
/* 139 */     return this.a.b(paramT, (l<? super T>)this.a, this.fv, (h.a)this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean b(T paramT) {
/* 149 */     return A(paramT);
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
/*     */   @com.google.b.a.a
/*     */   public boolean B(T paramT) {
/* 165 */     return this.a.a(paramT, (l<? super T>)this.a, this.fv, (h.a)this.a);
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
/*     */   public double v() {
/* 180 */     return Math.pow(this.a.ac() / ab(), this.fv);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long aa() {
/* 191 */     long l1 = this.a.ab();
/* 192 */     long l2 = this.a.ac();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 200 */     double d = l2 / l1;
/* 201 */     return c.a(
/* 202 */         -Math.log1p(-d) * l1 / this.fv, RoundingMode.HALF_UP);
/*     */   }
/*     */ 
/*     */   
/*     */   @d
/*     */   long ab() {
/* 208 */     return this.a.ab();
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
/*     */   public boolean a(g<T> paramg) {
/* 227 */     D.checkNotNull(paramg);
/* 228 */     return (this != paramg && this.fv == paramg.fv && 
/*     */       
/* 230 */       ab() == paramg.ab() && this.a
/* 231 */       .equals(paramg.a) && this.a
/* 232 */       .equals(paramg.a));
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
/*     */   public void a(g<T> paramg) {
/* 245 */     D.checkNotNull(paramg);
/* 246 */     D.a((this != paramg), "Cannot combine a BloomFilter with itself.");
/* 247 */     D.a((this.fv == paramg.fv), "BloomFilters must have the same number of hash functions (%s != %s)", this.fv, paramg.fv);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 252 */     D.a(
/* 253 */         (ab() == paramg.ab()), "BloomFilters must have the same size underlying bit arrays (%s != %s)", 
/*     */         
/* 255 */         ab(), paramg
/* 256 */         .ab());
/* 257 */     D.a(this.a
/* 258 */         .equals(paramg.a), "BloomFilters must have equal strategies (%s != %s)", this.a, paramg.a);
/*     */ 
/*     */ 
/*     */     
/* 262 */     D.a(this.a
/* 263 */         .equals(paramg.a), "BloomFilters must have equal funnels (%s != %s)", this.a, paramg.a);
/*     */ 
/*     */ 
/*     */     
/* 267 */     this.a.a((h.a)paramg.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 272 */     if (paramObject == this) {
/* 273 */       return true;
/*     */     }
/* 275 */     if (paramObject instanceof g) {
/* 276 */       g g1 = (g)paramObject;
/* 277 */       return (this.fv == g1.fv && this.a
/* 278 */         .equals(g1.a) && this.a
/* 279 */         .equals(g1.a) && this.a
/* 280 */         .equals(g1.a));
/*     */     } 
/* 282 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 287 */     return y.a(new Object[] { Integer.valueOf(this.fv), this.a, this.a, this.a });
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
/*     */   public static <T> Collector<T, ?, g<T>> a(l<? super T> paraml, long paramLong) {
/* 313 */     return a(paraml, paramLong, 0.03D);
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
/*     */   public static <T> Collector<T, ?, g<T>> a(l<? super T> paraml, long paramLong, double paramDouble) {
/* 340 */     D.checkNotNull(paraml);
/* 341 */     D.a((paramLong >= 0L), "Expected insertions (%s) must be >= 0", paramLong);
/*     */     
/* 343 */     D.a((paramDouble > 0.0D), "False positive probability (%s) must be > 0.0", Double.valueOf(paramDouble));
/* 344 */     D.a((paramDouble < 1.0D), "False positive probability (%s) must be < 1.0", Double.valueOf(paramDouble));
/* 345 */     return (Collector)Collector.of(() -> a(paraml, paramLong, paramDouble), g::B, (paramg1, paramg2) -> { paramg1.a(paramg2); return paramg1; }new Collector.Characteristics[] { Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> g<T> a(l<? super T> paraml, int paramInt, double paramDouble) {
/* 378 */     return a(paraml, paramInt, paramDouble);
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
/*     */   public static <T> g<T> a(l<? super T> paraml, long paramLong, double paramDouble) {
/* 404 */     return a(paraml, paramLong, paramDouble, h.b);
/*     */   }
/*     */ 
/*     */   
/*     */   @d
/*     */   static <T> g<T> a(l<? super T> paraml, long paramLong, double paramDouble, b paramb) {
/* 410 */     D.checkNotNull(paraml);
/* 411 */     D.a((paramLong >= 0L), "Expected insertions (%s) must be >= 0", paramLong);
/*     */     
/* 413 */     D.a((paramDouble > 0.0D), "False positive probability (%s) must be > 0.0", Double.valueOf(paramDouble));
/* 414 */     D.a((paramDouble < 1.0D), "False positive probability (%s) must be < 1.0", Double.valueOf(paramDouble));
/* 415 */     D.checkNotNull(paramb);
/*     */     
/* 417 */     if (paramLong == 0L) {
/* 418 */       paramLong = 1L;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 425 */     long l1 = a(paramLong, paramDouble);
/* 426 */     int i = a(paramLong, l1);
/*     */     try {
/* 428 */       return new g<>(new h.a(l1), i, paraml, paramb);
/* 429 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 430 */       throw new IllegalArgumentException((new StringBuilder(57)).append("Could not create BloomFilter of ").append(l1).append(" bits").toString(), illegalArgumentException);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> g<T> a(l<? super T> paraml, int paramInt) {
/* 454 */     return a(paraml, paramInt);
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
/*     */   public static <T> g<T> a(l<? super T> paraml, long paramLong) {
/* 478 */     return a(paraml, paramLong, 0.03D);
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
/*     */   @d
/*     */   static int a(long paramLong1, long paramLong2) {
/* 505 */     return Math.max(1, (int)Math.round(paramLong2 / paramLong1 * Math.log(2.0D)));
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
/*     */   @d
/*     */   static long a(long paramLong, double paramDouble) {
/* 520 */     if (paramDouble == 0.0D) {
/* 521 */       paramDouble = Double.MIN_VALUE;
/*     */     }
/* 523 */     return (long)(-paramLong * Math.log(paramDouble) / Math.log(2.0D) * Math.log(2.0D));
/*     */   }
/*     */   
/*     */   private Object writeReplace() {
/* 527 */     return new a(this);
/*     */   }
/*     */   
/*     */   private static class a<T> implements Serializable { final long[] data;
/*     */     final int fv;
/*     */     final l<? super T> a;
/*     */     final g.b a;
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     a(g<T> param1g) {
/* 537 */       this.data = h.a.a((AtomicLongArray)(g.a(param1g)).a);
/* 538 */       this.fv = g.a(param1g);
/* 539 */       this.a = (g.b)g.a(param1g);
/* 540 */       this.a = g.a(param1g);
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 544 */       return new g(new h.a(this.data), this.fv, (l)this.a, this.a);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 563 */     DataOutputStream dataOutputStream = new DataOutputStream(paramOutputStream);
/* 564 */     dataOutputStream.writeByte(s.a(this.a.ordinal()));
/* 565 */     dataOutputStream.writeByte(t.a(this.fv));
/* 566 */     dataOutputStream.writeInt(((h.a)this.a).a.length());
/* 567 */     for (byte b1 = 0; b1 < ((h.a)this.a).a.length(); b1++) {
/* 568 */       dataOutputStream.writeLong(((h.a)this.a).a.get(b1));
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
/*     */   public static <T> g<T> a(InputStream paramInputStream, l<? super T> paraml) throws IOException {
/* 585 */     D.b(paramInputStream, "InputStream");
/* 586 */     D.b(paraml, "Funnel");
/* 587 */     byte b1 = -1;
/* 588 */     int i = -1;
/* 589 */     int j = -1;
/*     */     try {
/* 591 */       DataInputStream dataInputStream = new DataInputStream(paramInputStream);
/*     */ 
/*     */ 
/*     */       
/* 595 */       b1 = dataInputStream.readByte();
/* 596 */       i = t.b(dataInputStream.readByte());
/* 597 */       j = dataInputStream.readInt();
/*     */       
/* 599 */       h h = h.values()[b1];
/* 600 */       long[] arrayOfLong = new long[j];
/* 601 */       for (byte b2 = 0; b2 < arrayOfLong.length; b2++) {
/* 602 */         arrayOfLong[b2] = dataInputStream.readLong();
/*     */       }
/* 604 */       return new g<>(new h.a(arrayOfLong), i, paraml, h);
/* 605 */     } catch (RuntimeException runtimeException) {
/* 606 */       byte b2 = b1; int k = i, m = j; String str = (new StringBuilder(134)).append("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: ").append(b2).append(" numHashFunctions: ").append(k).append(" dataLength: ").append(m).toString();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 614 */       throw new IOException(str, runtimeException);
/*     */     } 
/*     */   }
/*     */   
/*     */   static interface b extends Serializable {
/*     */     <T> boolean a(T param1T, l<? super T> param1l, int param1Int, h.a param1a);
/*     */     
/*     */     <T> boolean b(T param1T, l<? super T> param1l, int param1Int, h.a param1a);
/*     */     
/*     */     int ordinal();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */