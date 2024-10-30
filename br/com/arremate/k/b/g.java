/*     */ package br.com.arremate.k.b;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class g
/*     */ {
/*  20 */   private Map<Long, Long> A = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(long paramLong1, long paramLong2) {
/*  30 */     this.A.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void t(long paramLong) {
/*  40 */     synchronized (this.A) {
/*  41 */       a(System.currentTimeMillis(), paramLong);
/*  42 */       this.A = n();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long r() {
/*  53 */     Map.Entry[] arrayOfEntry1 = (Map.Entry[])this.A.entrySet().stream().toArray(paramInt -> new Map.Entry[paramInt]);
/*     */     
/*  55 */     double d1 = a(arrayOfEntry1);
/*     */     
/*  57 */     double d2 = a(arrayOfEntry1, d1);
/*     */ 
/*     */     
/*  60 */     double d3 = Math.sqrt(d2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     Map.Entry[] arrayOfEntry2 = (Map.Entry[])Stream.<Map.Entry>of(arrayOfEntry1).filter(paramEntry -> (Math.abs(((Long)paramEntry.getValue()).longValue() - paramDouble1) <= paramDouble2)).toArray(paramInt -> new Map.Entry[paramInt]);
/*     */     
/*  67 */     return Math.round(a(arrayOfEntry2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long s() {
/*  77 */     Map.Entry[] arrayOfEntry1 = (Map.Entry[])this.A.entrySet().stream().toArray(paramInt -> new Map.Entry[paramInt]);
/*     */ 
/*     */     
/*  80 */     Map.Entry[] arrayOfEntry2 = (Map.Entry[])Stream.<Map.Entry>of(arrayOfEntry1).toArray(paramInt -> new Map.Entry[paramInt]);
/*     */     
/*  82 */     return Math.round(a(arrayOfEntry2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double a(Map.Entry[] paramArrayOfEntry) {
/*  93 */     double d = 0.0D;
/*     */     
/*  95 */     for (Map.Entry entry : paramArrayOfEntry) {
/*  96 */       d += ((Long)entry.getValue()).longValue();
/*     */     }
/*  98 */     d /= paramArrayOfEntry.length;
/*     */     
/* 100 */     return d;
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
/*     */   private double a(Map.Entry[] paramArrayOfEntry, double paramDouble) {
/* 112 */     double d = 0.0D;
/*     */     
/* 114 */     for (Map.Entry entry : paramArrayOfEntry) {
/* 115 */       d += Math.pow(((Long)entry.getValue()).longValue() - paramDouble, 2.0D);
/*     */     }
/* 117 */     d /= paramArrayOfEntry.length;
/*     */     
/* 119 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<Long, Long> n() {
/* 129 */     long l = System.currentTimeMillis() - 120000L;
/*     */     
/* 131 */     return (Map)this.A.entrySet().parallelStream()
/* 132 */       .filter(paramEntry -> (((Long)paramEntry.getKey()).longValue() > paramLong))
/* 133 */       .limit(10L)
/* 134 */       .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\b\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */