/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import java.util.function.LongBinaryOperator;
/*     */ import java.util.function.LongUnaryOperator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ public final class o<K>
/*     */   implements Serializable
/*     */ {
/*     */   private final ConcurrentHashMap<K, Long> map;
/*     */   private transient Map<K, Long> I;
/*     */   
/*     */   private o(ConcurrentHashMap<K, Long> paramConcurrentHashMap) {
/*  62 */     this.map = (ConcurrentHashMap<K, Long>)D.checkNotNull(paramConcurrentHashMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K> o<K> a() {
/*  67 */     return new o<>(new ConcurrentHashMap<>());
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K> o<K> a(Map<? extends K, ? extends Long> paramMap) {
/*  72 */     o<?> o1 = a();
/*  73 */     o1.putAll(paramMap);
/*  74 */     return (o)o1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long a(K paramK) {
/*  82 */     return ((Long)this.map.getOrDefault(paramK, Long.valueOf(0L))).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long b(K paramK) {
/*  90 */     return a(paramK, 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long c(K paramK) {
/*  98 */     return a(paramK, -1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long a(K paramK, long paramLong) {
/* 107 */     return a(paramK, paramLong, Long::sum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long d(K paramK) {
/* 115 */     return b(paramK, 1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long e(K paramK) {
/* 123 */     return b(paramK, -1L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long b(K paramK, long paramLong) {
/* 132 */     return b(paramK, paramLong, Long::sum);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long a(K paramK, LongUnaryOperator paramLongUnaryOperator) {
/* 144 */     D.checkNotNull(paramLongUnaryOperator);
/* 145 */     return ((Long)this.map.compute(paramK, (paramObject, paramLong) -> Long.valueOf(paramLongUnaryOperator.applyAsLong((paramLong == null) ? 0L : paramLong.longValue())))).longValue();
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
/*     */   @a
/*     */   public long b(K paramK, LongUnaryOperator paramLongUnaryOperator) {
/* 158 */     D.checkNotNull(paramLongUnaryOperator);
/* 159 */     AtomicLong atomicLong = new AtomicLong();
/* 160 */     this.map.compute(paramK, (paramObject, paramLong) -> {
/*     */           long l = (paramLong == null) ? 0L : paramLong.longValue();
/*     */           
/*     */           paramAtomicLong.set(l);
/*     */           
/*     */           return Long.valueOf(paramLongUnaryOperator.applyAsLong(l));
/*     */         });
/* 167 */     return atomicLong.get();
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
/*     */   @a
/*     */   public long a(K paramK, long paramLong, LongBinaryOperator paramLongBinaryOperator) {
/* 180 */     D.checkNotNull(paramLongBinaryOperator);
/* 181 */     return a(paramK, paramLong2 -> paramLongBinaryOperator.applyAsLong(paramLong2, paramLong1));
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
/*     */   @a
/*     */   public long b(K paramK, long paramLong, LongBinaryOperator paramLongBinaryOperator) {
/* 194 */     D.checkNotNull(paramLongBinaryOperator);
/* 195 */     return b(paramK, paramLong2 -> paramLongBinaryOperator.applyAsLong(paramLong2, paramLong1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long c(K paramK, long paramLong) {
/* 204 */     return b(paramK, paramLong2 -> paramLong1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends Long> paramMap) {
/* 214 */     paramMap.forEach(this::c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public long f(K paramK) {
/* 223 */     Long long_ = this.map.remove(paramK);
/* 224 */     return (long_ == null) ? 0L : long_.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean a(K paramK, long paramLong) {
/* 232 */     return this.map.remove(paramK, Long.valueOf(paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   @a
/*     */   public boolean C(K paramK) {
/* 243 */     return a(paramK, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fS() {
/* 253 */     this.map.values().removeIf(paramLong -> (paramLong.longValue() == 0L));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long X() {
/* 262 */     return this.map.values().stream().mapToLong(Long::longValue).sum();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<K, Long> asMap() {
/* 269 */     Map<K, Long> map = this.I;
/* 270 */     return (map == null) ? (this.I = u()) : map;
/*     */   }
/*     */   
/*     */   private Map<K, Long> u() {
/* 274 */     return Collections.unmodifiableMap(this.map);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 279 */     return this.map.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 287 */     return this.map.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 292 */     return this.map.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 302 */     this.map.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 307 */     return this.map.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long d(K paramK, long paramLong) {
/* 316 */     AtomicBoolean atomicBoolean = new AtomicBoolean(false);
/*     */     
/* 318 */     Long long_ = this.map.compute(paramK, (paramObject, paramLong1) -> {
/*     */           if (paramLong1 == null || paramLong1.longValue() == 0L) {
/*     */             paramAtomicBoolean.set(true);
/*     */             
/*     */             return Long.valueOf(paramLong);
/*     */           } 
/*     */           
/*     */           return paramLong1;
/*     */         });
/*     */     
/* 328 */     return atomicBoolean.get() ? 0L : long_.longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean a(K paramK, long paramLong1, long paramLong2) {
/* 339 */     if (paramLong1 == 0L) {
/* 340 */       return (d(paramK, paramLong2) == 0L);
/*     */     }
/* 342 */     return this.map.replace(paramK, Long.valueOf(paramLong1), Long.valueOf(paramLong2));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */