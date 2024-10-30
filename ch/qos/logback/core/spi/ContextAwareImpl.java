/*    */ package ch.qos.logback.core.spi;
/*    */ 
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.status.ErrorStatus;
/*    */ import ch.qos.logback.core.status.InfoStatus;
/*    */ import ch.qos.logback.core.status.Status;
/*    */ import ch.qos.logback.core.status.StatusManager;
/*    */ import ch.qos.logback.core.status.WarnStatus;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContextAwareImpl
/*    */   implements ContextAware
/*    */ {
/* 31 */   private int noContextWarning = 0;
/*    */   protected Context context;
/*    */   final Object origin;
/*    */   
/*    */   public ContextAwareImpl(Context paramContext, Object paramObject) {
/* 36 */     this.context = paramContext;
/* 37 */     this.origin = paramObject;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Object getOrigin() {
/* 42 */     return this.origin;
/*    */   }
/*    */   
/*    */   public void setContext(Context paramContext) {
/* 46 */     if (this.context == null) {
/* 47 */       this.context = paramContext;
/* 48 */     } else if (this.context != paramContext) {
/* 49 */       throw new IllegalStateException("Context has been already set");
/*    */     } 
/*    */   }
/*    */   
/*    */   public Context getContext() {
/* 54 */     return this.context;
/*    */   }
/*    */   
/*    */   public StatusManager getStatusManager() {
/* 58 */     if (this.context == null) {
/* 59 */       return null;
/*    */     }
/* 61 */     return this.context.getStatusManager();
/*    */   }
/*    */   
/*    */   public void addStatus(Status paramStatus) {
/* 65 */     if (this.context == null) {
/* 66 */       if (this.noContextWarning++ == 0) {
/* 67 */         System.out.println("LOGBACK: No context given for " + this);
/*    */       }
/*    */       return;
/*    */     } 
/* 71 */     StatusManager statusManager = this.context.getStatusManager();
/* 72 */     if (statusManager != null) {
/* 73 */       statusManager.add(paramStatus);
/*    */     }
/*    */   }
/*    */   
/*    */   public void addInfo(String paramString) {
/* 78 */     addStatus((Status)new InfoStatus(paramString, getOrigin()));
/*    */   }
/*    */   
/*    */   public void addInfo(String paramString, Throwable paramThrowable) {
/* 82 */     addStatus((Status)new InfoStatus(paramString, getOrigin(), paramThrowable));
/*    */   }
/*    */   
/*    */   public void addWarn(String paramString) {
/* 86 */     addStatus((Status)new WarnStatus(paramString, getOrigin()));
/*    */   }
/*    */   
/*    */   public void addWarn(String paramString, Throwable paramThrowable) {
/* 90 */     addStatus((Status)new WarnStatus(paramString, getOrigin(), paramThrowable));
/*    */   }
/*    */   
/*    */   public void addError(String paramString) {
/* 94 */     addStatus((Status)new ErrorStatus(paramString, getOrigin()));
/*    */   }
/*    */   
/*    */   public void addError(String paramString, Throwable paramThrowable) {
/* 98 */     addStatus((Status)new ErrorStatus(paramString, getOrigin(), paramThrowable));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\spi\ContextAwareImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */