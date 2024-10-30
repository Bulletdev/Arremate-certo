/*     */ package ch.qos.logback.core.sift;
/*     */ 
/*     */ import ch.qos.logback.core.Appender;
/*     */ import ch.qos.logback.core.AppenderBase;
/*     */ import ch.qos.logback.core.util.Duration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SiftingAppenderBase<E>
/*     */   extends AppenderBase<E>
/*     */ {
/*     */   protected AppenderTracker<E> appenderTracker;
/*     */   AppenderFactory<E> appenderFactory;
/*  34 */   Duration timeout = new Duration(1800000L);
/*  35 */   int maxAppenderCount = Integer.MAX_VALUE;
/*     */   
/*     */   Discriminator<E> discriminator;
/*     */   
/*     */   public Duration getTimeout() {
/*  40 */     return this.timeout;
/*     */   }
/*     */   
/*     */   public void setTimeout(Duration paramDuration) {
/*  44 */     this.timeout = paramDuration;
/*     */   }
/*     */   
/*     */   public int getMaxAppenderCount() {
/*  48 */     return this.maxAppenderCount;
/*     */   }
/*     */   
/*     */   public void setMaxAppenderCount(int paramInt) {
/*  52 */     this.maxAppenderCount = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAppenderFactory(AppenderFactory<E> paramAppenderFactory) {
/*  60 */     this.appenderFactory = paramAppenderFactory;
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  65 */     byte b = 0;
/*  66 */     if (this.discriminator == null) {
/*  67 */       addError("Missing discriminator. Aborting");
/*  68 */       b++;
/*     */     } 
/*  70 */     if (!this.discriminator.isStarted()) {
/*  71 */       addError("Discriminator has not started successfully. Aborting");
/*  72 */       b++;
/*     */     } 
/*  74 */     if (this.appenderFactory == null) {
/*  75 */       addError("AppenderFactory has not been set. Aborting");
/*  76 */       b++;
/*     */     } else {
/*  78 */       this.appenderTracker = new AppenderTracker<E>(this.context, this.appenderFactory);
/*  79 */       this.appenderTracker.setMaxComponents(this.maxAppenderCount);
/*  80 */       this.appenderTracker.setTimeout(this.timeout.getMilliseconds());
/*     */     } 
/*  82 */     if (b == 0) {
/*  83 */       super.start();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/*  89 */     for (Appender appender : this.appenderTracker.allComponents()) {
/*  90 */       appender.stop();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract long getTimestamp(E paramE);
/*     */   
/*     */   protected void append(E paramE) {
/*  98 */     if (!isStarted()) {
/*     */       return;
/*     */     }
/* 101 */     String str = this.discriminator.getDiscriminatingValue(paramE);
/* 102 */     long l = getTimestamp(paramE);
/*     */     
/* 104 */     Appender appender = (Appender)this.appenderTracker.getOrCreate(str, l);
/*     */     
/* 106 */     if (eventMarksEndOfLife(paramE)) {
/* 107 */       this.appenderTracker.endOfLife(str);
/*     */     }
/* 109 */     this.appenderTracker.removeStaleComponents(l);
/* 110 */     appender.doAppend(paramE);
/*     */   }
/*     */   
/*     */   protected abstract boolean eventMarksEndOfLife(E paramE);
/*     */   
/*     */   public Discriminator<E> getDiscriminator() {
/* 116 */     return this.discriminator;
/*     */   }
/*     */   
/*     */   public void setDiscriminator(Discriminator<E> paramDiscriminator) {
/* 120 */     this.discriminator = paramDiscriminator;
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
/*     */   public AppenderTracker<E> getAppenderTracker() {
/* 133 */     return this.appenderTracker;
/*     */   }
/*     */   
/*     */   public String getDiscriminatorKey() {
/* 137 */     if (this.discriminator != null) {
/* 138 */       return this.discriminator.getKey();
/*     */     }
/* 140 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\sift\SiftingAppenderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */