/*     */ package oshi.util;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class Memoizer
/*     */ {
/*  39 */   private static final Supplier<Long> defaultExpirationNanos = memoize(Memoizer::queryExpirationConfig, TimeUnit.MINUTES
/*  40 */       .toNanos(1L));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long queryExpirationConfig() {
/*  46 */     return TimeUnit.MILLISECONDS.toNanos(GlobalConfig.get("oshi.util.memoizer.expiration", 300));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long defaultExpiration() {
/*  57 */     return ((Long)defaultExpirationNanos.get()).longValue();
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
/*     */   public static <T> Supplier<T> memoize(final Supplier<T> original, final long ttlNanos) {
/*  75 */     return new Supplier<T>() {
/*  76 */         final Supplier<T> delegate = original;
/*     */         
/*     */         volatile T value;
/*     */         volatile long expirationNanos;
/*     */         
/*     */         public T get() {
/*  82 */           long l1 = this.expirationNanos;
/*  83 */           long l2 = System.nanoTime();
/*  84 */           if (l1 == 0L || (ttlNanos >= 0L && l2 - l1 >= 0L)) {
/*  85 */             synchronized (this) {
/*  86 */               if (l1 == this.expirationNanos) {
/*  87 */                 T t = this.delegate.get();
/*  88 */                 this.value = t;
/*  89 */                 l1 = l2 + ttlNanos;
/*  90 */                 this.expirationNanos = (l1 == 0L) ? 1L : l1;
/*  91 */                 return t;
/*     */               } 
/*     */             } 
/*     */           }
/*  95 */           return this.value;
/*     */         }
/*     */       };
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
/*     */   public static <T> Supplier<T> memoize(Supplier<T> paramSupplier) {
/* 110 */     return memoize(paramSupplier, -1L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\Memoizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */