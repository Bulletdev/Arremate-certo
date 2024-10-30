/*     */ package ch.qos.logback.core.status;
/*     */ 
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.spi.LifeCycle;
/*     */ import ch.qos.logback.core.util.StatusPrinter;
/*     */ import java.io.PrintStream;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class OnPrintStreamStatusListenerBase
/*     */   extends ContextAwareBase
/*     */   implements LifeCycle, StatusListener
/*     */ {
/*     */   boolean isStarted = false;
/*     */   static final long DEFAULT_RETROSPECTIVE = 300L;
/*  32 */   long retrospectiveThresold = 300L;
/*     */ 
/*     */ 
/*     */   
/*     */   String prefix;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract PrintStream getPrintStream();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void print(Status paramStatus) {
/*  47 */     StringBuilder stringBuilder = new StringBuilder();
/*  48 */     if (this.prefix != null) {
/*  49 */       stringBuilder.append(this.prefix);
/*     */     }
/*  51 */     StatusPrinter.buildStr(stringBuilder, "", paramStatus);
/*  52 */     getPrintStream().print(stringBuilder);
/*     */   }
/*     */   
/*     */   public void addStatusEvent(Status paramStatus) {
/*  56 */     if (!this.isStarted)
/*     */       return; 
/*  58 */     print(paramStatus);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void retrospectivePrint() {
/*  65 */     if (this.context == null)
/*     */       return; 
/*  67 */     long l = System.currentTimeMillis();
/*  68 */     StatusManager statusManager = this.context.getStatusManager();
/*  69 */     List<Status> list = statusManager.getCopyOfStatusList();
/*  70 */     for (Status status : list) {
/*  71 */       long l1 = status.getDate().longValue();
/*  72 */       if (isElapsedTimeLongerThanThreshold(l, l1)) {
/*  73 */         print(status);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isElapsedTimeLongerThanThreshold(long paramLong1, long paramLong2) {
/*  79 */     long l = paramLong1 - paramLong2;
/*  80 */     return (l < this.retrospectiveThresold);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  88 */     this.isStarted = true;
/*  89 */     if (this.retrospectiveThresold > 0L) {
/*  90 */       retrospectivePrint();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPrefix() {
/*  95 */     return this.prefix;
/*     */   }
/*     */   
/*     */   public void setPrefix(String paramString) {
/*  99 */     this.prefix = paramString;
/*     */   }
/*     */   
/*     */   public void setRetrospective(long paramLong) {
/* 103 */     this.retrospectiveThresold = paramLong;
/*     */   }
/*     */   
/*     */   public long getRetrospective() {
/* 107 */     return this.retrospectiveThresold;
/*     */   }
/*     */   
/*     */   public void stop() {
/* 111 */     this.isStarted = false;
/*     */   }
/*     */   
/*     */   public boolean isStarted() {
/* 115 */     return this.isStarted;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\status\OnPrintStreamStatusListenerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */