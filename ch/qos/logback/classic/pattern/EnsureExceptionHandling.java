/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.pattern.Converter;
/*    */ import ch.qos.logback.core.pattern.ConverterUtil;
/*    */ import ch.qos.logback.core.pattern.PostCompileProcessor;
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
/*    */ 
/*    */ 
/*    */ public class EnsureExceptionHandling
/*    */   implements PostCompileProcessor<ILoggingEvent>
/*    */ {
/*    */   public void process(Context paramContext, Converter<ILoggingEvent> paramConverter) {
/* 41 */     if (paramConverter == null)
/*    */     {
/* 43 */       throw new IllegalArgumentException("cannot process empty chain");
/*    */     }
/* 45 */     if (!chainHandlesThrowable(paramConverter)) {
/* 46 */       Converter converter = ConverterUtil.findTail(paramConverter);
/* 47 */       ThrowableProxyConverter throwableProxyConverter = null;
/* 48 */       LoggerContext loggerContext = (LoggerContext)paramContext;
/* 49 */       if (loggerContext.isPackagingDataEnabled()) {
/* 50 */         throwableProxyConverter = new ExtendedThrowableProxyConverter();
/*    */       } else {
/* 52 */         throwableProxyConverter = new ThrowableProxyConverter();
/*    */       } 
/* 54 */       converter.setNext((Converter)throwableProxyConverter);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean chainHandlesThrowable(Converter<ILoggingEvent> paramConverter) {
/* 67 */     Converter<ILoggingEvent> converter = paramConverter;
/* 68 */     while (converter != null) {
/* 69 */       if (converter instanceof ThrowableHandlingConverter) {
/* 70 */         return true;
/*    */       }
/* 72 */       converter = converter.getNext();
/*    */     } 
/* 74 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\EnsureExceptionHandling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */