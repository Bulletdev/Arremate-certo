/*     */ package ch.qos.logback.core.pattern;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.spi.ContextAware;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.spi.LifeCycle;
/*     */ import ch.qos.logback.core.status.Status;
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
/*     */ public abstract class DynamicConverter<E>
/*     */   extends FormattingConverter<E>
/*     */   implements ContextAware, LifeCycle
/*     */ {
/*  26 */   ContextAwareBase cab = new ContextAwareBase(this);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<String> optionList;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean started = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  43 */     this.started = true;
/*     */   }
/*     */   
/*     */   public void stop() {
/*  47 */     this.started = false;
/*     */   }
/*     */   
/*     */   public boolean isStarted() {
/*  51 */     return this.started;
/*     */   }
/*     */   
/*     */   public void setOptionList(List<String> paramList) {
/*  55 */     this.optionList = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFirstOption() {
/*  65 */     if (this.optionList == null || this.optionList.size() == 0) {
/*  66 */       return null;
/*     */     }
/*  68 */     return this.optionList.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<String> getOptionList() {
/*  73 */     return this.optionList;
/*     */   }
/*     */   
/*     */   public void setContext(Context paramContext) {
/*  77 */     this.cab.setContext(paramContext);
/*     */   }
/*     */   
/*     */   public Context getContext() {
/*  81 */     return this.cab.getContext();
/*     */   }
/*     */   
/*     */   public void addStatus(Status paramStatus) {
/*  85 */     this.cab.addStatus(paramStatus);
/*     */   }
/*     */   
/*     */   public void addInfo(String paramString) {
/*  89 */     this.cab.addInfo(paramString);
/*     */   }
/*     */   
/*     */   public void addInfo(String paramString, Throwable paramThrowable) {
/*  93 */     this.cab.addInfo(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public void addWarn(String paramString) {
/*  97 */     this.cab.addWarn(paramString);
/*     */   }
/*     */   
/*     */   public void addWarn(String paramString, Throwable paramThrowable) {
/* 101 */     this.cab.addWarn(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public void addError(String paramString) {
/* 105 */     this.cab.addError(paramString);
/*     */   }
/*     */   
/*     */   public void addError(String paramString, Throwable paramThrowable) {
/* 109 */     this.cab.addError(paramString, paramThrowable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\DynamicConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */