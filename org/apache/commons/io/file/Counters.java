/*     */ package org.apache.commons.io.file;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Counters
/*     */ {
/*     */   private static class AbstractPathCounters
/*     */     implements PathCounters
/*     */   {
/*     */     private final Counters.Counter byteCounter;
/*     */     private final Counters.Counter directoryCounter;
/*     */     private final Counters.Counter fileCounter;
/*     */     
/*     */     protected AbstractPathCounters(Counters.Counter param1Counter1, Counters.Counter param1Counter2, Counters.Counter param1Counter3) {
/*  49 */       this.byteCounter = param1Counter1;
/*  50 */       this.directoryCounter = param1Counter2;
/*  51 */       this.fileCounter = param1Counter3;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/*  56 */       if (this == param1Object) {
/*  57 */         return true;
/*     */       }
/*  59 */       if (!(param1Object instanceof AbstractPathCounters)) {
/*  60 */         return false;
/*     */       }
/*  62 */       AbstractPathCounters abstractPathCounters = (AbstractPathCounters)param1Object;
/*  63 */       return (Objects.equals(this.byteCounter, abstractPathCounters.byteCounter) && 
/*  64 */         Objects.equals(this.directoryCounter, abstractPathCounters.directoryCounter) && 
/*  65 */         Objects.equals(this.fileCounter, abstractPathCounters.fileCounter));
/*     */     }
/*     */ 
/*     */     
/*     */     public Counters.Counter getByteCounter() {
/*  70 */       return this.byteCounter;
/*     */     }
/*     */ 
/*     */     
/*     */     public Counters.Counter getDirectoryCounter() {
/*  75 */       return this.directoryCounter;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Counters.Counter getFileCounter() {
/*  85 */       return this.fileCounter;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/*  90 */       return Objects.hash(new Object[] { this.byteCounter, this.directoryCounter, this.fileCounter });
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  95 */       return String.format("%,d files, %,d directories, %,d bytes", new Object[] { Long.valueOf(this.fileCounter.get()), 
/*  96 */             Long.valueOf(this.directoryCounter.get()), Long.valueOf(this.byteCounter.get()) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class BigIntegerCounter
/*     */     implements Counter
/*     */   {
/* 106 */     private BigInteger value = BigInteger.ZERO;
/*     */ 
/*     */     
/*     */     public void add(long param1Long) {
/* 110 */       this.value = this.value.add(BigInteger.valueOf(param1Long));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 116 */       if (this == param1Object) {
/* 117 */         return true;
/*     */       }
/* 119 */       if (!(param1Object instanceof Counters.Counter)) {
/* 120 */         return false;
/*     */       }
/* 122 */       Counters.Counter counter = (Counters.Counter)param1Object;
/* 123 */       return Objects.equals(this.value, counter.getBigInteger());
/*     */     }
/*     */ 
/*     */     
/*     */     public long get() {
/* 128 */       return this.value.longValueExact();
/*     */     }
/*     */ 
/*     */     
/*     */     public BigInteger getBigInteger() {
/* 133 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public Long getLong() {
/* 138 */       return Long.valueOf(this.value.longValueExact());
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 143 */       return Objects.hash(new Object[] { this.value });
/*     */     }
/*     */ 
/*     */     
/*     */     public void increment() {
/* 148 */       this.value = this.value.add(BigInteger.ONE);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 153 */       return this.value.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private BigIntegerCounter() {}
/*     */   }
/*     */ 
/*     */   
/*     */   private static class BigIntegerPathCounters
/*     */     extends AbstractPathCounters
/*     */   {
/*     */     protected BigIntegerPathCounters() {
/* 166 */       super(Counters.bigIntegerCounter(), Counters.bigIntegerCounter(), Counters.bigIntegerCounter());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface Counter
/*     */   {
/*     */     void add(long param1Long);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     long get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     BigInteger getBigInteger();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Long getLong();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void increment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class LongCounter
/*     */     implements Counter
/*     */   {
/*     */     private long value;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private LongCounter() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void add(long param1Long) {
/* 220 */       this.value += param1Long;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 226 */       if (this == param1Object) {
/* 227 */         return true;
/*     */       }
/* 229 */       if (!(param1Object instanceof Counters.Counter)) {
/* 230 */         return false;
/*     */       }
/* 232 */       Counters.Counter counter = (Counters.Counter)param1Object;
/* 233 */       return (this.value == counter.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public long get() {
/* 238 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public BigInteger getBigInteger() {
/* 243 */       return BigInteger.valueOf(this.value);
/*     */     }
/*     */ 
/*     */     
/*     */     public Long getLong() {
/* 248 */       return Long.valueOf(this.value);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 253 */       return Objects.hash(new Object[] { Long.valueOf(this.value) });
/*     */     }
/*     */ 
/*     */     
/*     */     public void increment() {
/* 258 */       this.value++;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 263 */       return Long.toString(this.value);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class LongPathCounters
/*     */     extends AbstractPathCounters
/*     */   {
/*     */     protected LongPathCounters() {
/* 276 */       super(Counters.longCounter(), Counters.longCounter(), Counters.longCounter());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Counter bigIntegerCounter() {
/* 315 */     return new BigIntegerCounter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PathCounters bigIntegerPathCounters() {
/* 324 */     return new BigIntegerPathCounters();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Counter longCounter() {
/* 333 */     return new LongCounter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PathCounters longPathCounters() {
/* 342 */     return new LongPathCounters();
/*     */   }
/*     */   
/*     */   public static interface PathCounters {
/*     */     Counters.Counter getByteCounter();
/*     */     
/*     */     Counters.Counter getDirectoryCounter();
/*     */     
/*     */     Counters.Counter getFileCounter();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\file\Counters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */