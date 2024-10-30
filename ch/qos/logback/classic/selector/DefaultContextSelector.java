/*    */ package ch.qos.logback.classic.selector;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
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
/*    */ public class DefaultContextSelector
/*    */   implements ContextSelector
/*    */ {
/*    */   private LoggerContext defaultLoggerContext;
/*    */   
/*    */   public DefaultContextSelector(LoggerContext paramLoggerContext) {
/* 26 */     this.defaultLoggerContext = paramLoggerContext;
/*    */   }
/*    */   
/*    */   public LoggerContext getLoggerContext() {
/* 30 */     return getDefaultLoggerContext();
/*    */   }
/*    */   
/*    */   public LoggerContext getDefaultLoggerContext() {
/* 34 */     return this.defaultLoggerContext;
/*    */   }
/*    */   
/*    */   public LoggerContext detachLoggerContext(String paramString) {
/* 38 */     return this.defaultLoggerContext;
/*    */   }
/*    */   
/*    */   public List<String> getContextNames() {
/* 42 */     return Arrays.asList(new String[] { this.defaultLoggerContext.getName() });
/*    */   }
/*    */   
/*    */   public LoggerContext getLoggerContext(String paramString) {
/* 46 */     if (this.defaultLoggerContext.getName().equals(paramString)) {
/* 47 */       return this.defaultLoggerContext;
/*    */     }
/* 49 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\selector\DefaultContextSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */