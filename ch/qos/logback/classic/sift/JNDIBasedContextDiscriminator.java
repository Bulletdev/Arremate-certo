/*    */ package ch.qos.logback.classic.sift;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.classic.selector.ContextSelector;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
/*    */ import ch.qos.logback.core.sift.AbstractDiscriminator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JNDIBasedContextDiscriminator
/*    */   extends AbstractDiscriminator<ILoggingEvent>
/*    */ {
/*    */   private static final String KEY = "contextName";
/*    */   private String defaultValue;
/*    */   
/*    */   public String getDiscriminatingValue(ILoggingEvent paramILoggingEvent) {
/* 41 */     ContextSelector contextSelector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
/*    */     
/* 43 */     if (contextSelector == null) {
/* 44 */       return this.defaultValue;
/*    */     }
/*    */     
/* 47 */     LoggerContext loggerContext = contextSelector.getLoggerContext();
/* 48 */     if (loggerContext == null) {
/* 49 */       return this.defaultValue;
/*    */     }
/*    */     
/* 52 */     return loggerContext.getName();
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 56 */     return "contextName";
/*    */   }
/*    */   
/*    */   public void setKey(String paramString) {
/* 60 */     throw new UnsupportedOperationException("Key cannot be set. Using fixed key contextName");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDefaultValue() {
/* 68 */     return this.defaultValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDefaultValue(String paramString) {
/* 78 */     this.defaultValue = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\sift\JNDIBasedContextDiscriminator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */