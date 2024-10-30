/*     */ package ch.qos.logback.core.spi;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.InfoStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import ch.qos.logback.core.status.WarnStatus;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContextAwareBase
/*     */   implements ContextAware
/*     */ {
/*  30 */   private int noContextWarning = 0;
/*     */   protected Context context;
/*     */   final Object declaredOrigin;
/*     */   
/*     */   public ContextAwareBase() {
/*  35 */     this.declaredOrigin = this;
/*     */   }
/*     */   
/*     */   public ContextAwareBase(ContextAware paramContextAware) {
/*  39 */     this.declaredOrigin = paramContextAware;
/*     */   }
/*     */   
/*     */   public void setContext(Context paramContext) {
/*  43 */     if (this.context == null) {
/*  44 */       this.context = paramContext;
/*  45 */     } else if (this.context != paramContext) {
/*  46 */       throw new IllegalStateException("Context has been already set");
/*     */     } 
/*     */   }
/*     */   
/*     */   public Context getContext() {
/*  51 */     return this.context;
/*     */   }
/*     */   
/*     */   public StatusManager getStatusManager() {
/*  55 */     if (this.context == null) {
/*  56 */       return null;
/*     */     }
/*  58 */     return this.context.getStatusManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getDeclaredOrigin() {
/*  68 */     return this.declaredOrigin;
/*     */   }
/*     */   
/*     */   public void addStatus(Status paramStatus) {
/*  72 */     if (this.context == null) {
/*  73 */       if (this.noContextWarning++ == 0) {
/*  74 */         System.out.println("LOGBACK: No context given for " + this);
/*     */       }
/*     */       return;
/*     */     } 
/*  78 */     StatusManager statusManager = this.context.getStatusManager();
/*  79 */     if (statusManager != null) {
/*  80 */       statusManager.add(paramStatus);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addInfo(String paramString) {
/*  85 */     addStatus((Status)new InfoStatus(paramString, getDeclaredOrigin()));
/*     */   }
/*     */   
/*     */   public void addInfo(String paramString, Throwable paramThrowable) {
/*  89 */     addStatus((Status)new InfoStatus(paramString, getDeclaredOrigin(), paramThrowable));
/*     */   }
/*     */   
/*     */   public void addWarn(String paramString) {
/*  93 */     addStatus((Status)new WarnStatus(paramString, getDeclaredOrigin()));
/*     */   }
/*     */   
/*     */   public void addWarn(String paramString, Throwable paramThrowable) {
/*  97 */     addStatus((Status)new WarnStatus(paramString, getDeclaredOrigin(), paramThrowable));
/*     */   }
/*     */   
/*     */   public void addError(String paramString) {
/* 101 */     addStatus((Status)new ErrorStatus(paramString, getDeclaredOrigin()));
/*     */   }
/*     */   
/*     */   public void addError(String paramString, Throwable paramThrowable) {
/* 105 */     addStatus((Status)new ErrorStatus(paramString, getDeclaredOrigin(), paramThrowable));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\ContextAwareBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */