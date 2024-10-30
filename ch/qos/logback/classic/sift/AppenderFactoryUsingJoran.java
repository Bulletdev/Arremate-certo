/*    */ package ch.qos.logback.classic.sift;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.joran.event.SaxEvent;
/*    */ import ch.qos.logback.core.sift.AbstractAppenderFactoryUsingJoran;
/*    */ import ch.qos.logback.core.sift.SiftingJoranConfiguratorBase;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public class AppenderFactoryUsingJoran
/*    */   extends AbstractAppenderFactoryUsingJoran<ILoggingEvent>
/*    */ {
/*    */   AppenderFactoryUsingJoran(List<SaxEvent> paramList, String paramString, Map<String, String> paramMap) {
/* 30 */     super(paramList, paramString, paramMap);
/*    */   }
/*    */   
/*    */   public SiftingJoranConfiguratorBase<ILoggingEvent> getSiftingJoranConfigurator(String paramString) {
/* 34 */     return new SiftingJoranConfigurator(this.key, paramString, this.parentPropertyMap);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\sift\AppenderFactoryUsingJoran.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */