/*    */ package ch.qos.logback.core.sift;
/*    */ 
/*    */ import ch.qos.logback.core.Appender;
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.joran.event.SaxEvent;
/*    */ import ch.qos.logback.core.joran.spi.JoranException;
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
/*    */ 
/*    */ 
/*    */ public abstract class AbstractAppenderFactoryUsingJoran<E>
/*    */   implements AppenderFactory<E>
/*    */ {
/*    */   final List<SaxEvent> eventList;
/*    */   protected String key;
/*    */   protected Map<String, String> parentPropertyMap;
/*    */   
/*    */   protected AbstractAppenderFactoryUsingJoran(List<SaxEvent> paramList, String paramString, Map<String, String> paramMap) {
/* 36 */     this.eventList = removeSiftElement(paramList);
/* 37 */     this.key = paramString;
/* 38 */     this.parentPropertyMap = paramMap;
/*    */   }
/*    */ 
/*    */   
/*    */   List<SaxEvent> removeSiftElement(List<SaxEvent> paramList) {
/* 43 */     return paramList.subList(1, paramList.size() - 1);
/*    */   }
/*    */   
/*    */   public abstract SiftingJoranConfiguratorBase<E> getSiftingJoranConfigurator(String paramString);
/*    */   
/*    */   public Appender<E> buildAppender(Context paramContext, String paramString) throws JoranException {
/* 49 */     SiftingJoranConfiguratorBase<E> siftingJoranConfiguratorBase = getSiftingJoranConfigurator(paramString);
/* 50 */     siftingJoranConfiguratorBase.setContext(paramContext);
/* 51 */     siftingJoranConfiguratorBase.doConfigure(this.eventList);
/* 52 */     return siftingJoranConfiguratorBase.getAppender();
/*    */   }
/*    */   
/*    */   public List<SaxEvent> getEventList() {
/* 56 */     return this.eventList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\sift\AbstractAppenderFactoryUsingJoran.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */