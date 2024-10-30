/*    */ package ch.qos.logback.classic.sift;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
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
/*    */ public class ContextBasedDiscriminator
/*    */   extends AbstractDiscriminator<ILoggingEvent>
/*    */ {
/*    */   private static final String KEY = "contextName";
/*    */   private String defaultValue;
/*    */   
/*    */   public String getDiscriminatingValue(ILoggingEvent paramILoggingEvent) {
/* 38 */     String str = paramILoggingEvent.getLoggerContextVO().getName();
/*    */     
/* 40 */     if (str == null) {
/* 41 */       return this.defaultValue;
/*    */     }
/* 43 */     return str;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getKey() {
/* 48 */     return "contextName";
/*    */   }
/*    */   
/*    */   public void setKey(String paramString) {
/* 52 */     throw new UnsupportedOperationException("Key cannot be set. Using fixed key contextName");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getDefaultValue() {
/* 60 */     return this.defaultValue;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDefaultValue(String paramString) {
/* 70 */     this.defaultValue = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\sift\ContextBasedDiscriminator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */