/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultInvocationGate
/*     */   implements InvocationGate
/*     */ {
/*     */   static final int MASK_DECREASE_RIGHT_SHIFT_COUNT = 2;
/*     */   private static final int MAX_MASK = 65535;
/*     */   static final int DEFAULT_MASK = 15;
/*  30 */   private volatile long mask = 15L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   private long invocationCounter = 0L;
/*     */   
/*     */   private static final long MASK_INCREASE_THRESHOLD = 100L;
/*     */   
/*     */   private static final long MASK_DECREASE_THRESHOLD = 800L;
/*     */   
/*     */   private long minDelayThreshold;
/*     */   private long maxDelayThreshold;
/*     */   long lowerLimitForMaskMatch;
/*     */   long upperLimitForNoMaskMatch;
/*     */   
/*     */   public DefaultInvocationGate() {
/*  49 */     this(100L, 800L, System.currentTimeMillis());
/*     */   }
/*     */   
/*     */   public DefaultInvocationGate(long paramLong1, long paramLong2, long paramLong3) {
/*  53 */     this.minDelayThreshold = paramLong1;
/*  54 */     this.maxDelayThreshold = paramLong2;
/*  55 */     this.lowerLimitForMaskMatch = paramLong3 + paramLong1;
/*  56 */     this.upperLimitForNoMaskMatch = paramLong3 + paramLong2;
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
/*     */   public final boolean isTooSoon(long paramLong) {
/*  72 */     boolean bool = ((this.invocationCounter++ & this.mask) == this.mask) ? true : false;
/*     */     
/*  74 */     if (bool) {
/*  75 */       if (paramLong < this.lowerLimitForMaskMatch) {
/*  76 */         increaseMask();
/*     */       }
/*  78 */       updateLimits(paramLong);
/*     */     }
/*  80 */     else if (paramLong > this.upperLimitForNoMaskMatch) {
/*  81 */       decreaseMask();
/*  82 */       updateLimits(paramLong);
/*  83 */       return false;
/*     */     } 
/*     */     
/*  86 */     return !bool;
/*     */   }
/*     */   
/*     */   private void updateLimits(long paramLong) {
/*  90 */     this.lowerLimitForMaskMatch = paramLong + this.minDelayThreshold;
/*  91 */     this.upperLimitForNoMaskMatch = paramLong + this.maxDelayThreshold;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   long getMask() {
/*  97 */     return this.mask;
/*     */   }
/*     */   
/*     */   private void increaseMask() {
/* 101 */     if (this.mask >= 65535L)
/*     */       return; 
/* 103 */     this.mask = this.mask << 1L | 0x1L;
/*     */   }
/*     */   
/*     */   private void decreaseMask() {
/* 107 */     this.mask >>>= 2L;
/*     */   }
/*     */   
/*     */   public long getInvocationCounter() {
/* 111 */     return this.invocationCounter;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\DefaultInvocationGate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */