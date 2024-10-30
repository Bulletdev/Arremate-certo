/*     */ package ch.qos.logback.core;
/*     */ 
/*     */ import ch.qos.logback.core.filter.Filter;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.spi.FilterAttachableImpl;
/*     */ import ch.qos.logback.core.spi.FilterReply;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.WarnStatus;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AppenderBase<E>
/*     */   extends ContextAwareBase
/*     */   implements Appender<E>
/*     */ {
/*     */   protected volatile boolean started = false;
/*     */   private boolean guard = false;
/*     */   protected String name;
/*  47 */   private FilterAttachableImpl<E> fai = new FilterAttachableImpl();
/*     */   
/*     */   public String getName() {
/*  50 */     return this.name;
/*     */   }
/*     */   
/*  53 */   private int statusRepeatCount = 0;
/*  54 */   private int exceptionCount = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   static final int ALLOWED_REPEATS = 5;
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void doAppend(E paramE) {
/*  63 */     if (this.guard) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  68 */       this.guard = true;
/*     */       
/*  70 */       if (!this.started) {
/*  71 */         if (this.statusRepeatCount++ < 5) {
/*  72 */           addStatus((Status)new WarnStatus("Attempted to append to non started appender [" + this.name + "].", this));
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/*  77 */       if (getFilterChainDecision(paramE) == FilterReply.DENY) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/*  82 */       append(paramE);
/*     */     }
/*  84 */     catch (Exception exception) {
/*  85 */       if (this.exceptionCount++ < 5) {
/*  86 */         addError("Appender [" + this.name + "] failed to append.", exception);
/*     */       }
/*     */     } finally {
/*  89 */       this.guard = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void append(E paramE);
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/*  99 */     this.name = paramString;
/*     */   }
/*     */   
/*     */   public void start() {
/* 103 */     this.started = true;
/*     */   }
/*     */   
/*     */   public void stop() {
/* 107 */     this.started = false;
/*     */   }
/*     */   
/*     */   public boolean isStarted() {
/* 111 */     return this.started;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     return getClass().getName() + "[" + this.name + "]";
/*     */   }
/*     */   
/*     */   public void addFilter(Filter<E> paramFilter) {
/* 119 */     this.fai.addFilter(paramFilter);
/*     */   }
/*     */   
/*     */   public void clearAllFilters() {
/* 123 */     this.fai.clearAllFilters();
/*     */   }
/*     */   
/*     */   public List<Filter<E>> getCopyOfAttachedFiltersList() {
/* 127 */     return this.fai.getCopyOfAttachedFiltersList();
/*     */   }
/*     */   
/*     */   public FilterReply getFilterChainDecision(E paramE) {
/* 131 */     return this.fai.getFilterChainDecision(paramE);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\AppenderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */