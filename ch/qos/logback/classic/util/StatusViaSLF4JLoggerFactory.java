/*    */ package ch.qos.logback.classic.util;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.spi.ContextAwareBase;
/*    */ import ch.qos.logback.core.status.ErrorStatus;
/*    */ import ch.qos.logback.core.status.InfoStatus;
/*    */ import ch.qos.logback.core.status.Status;
/*    */ import org.slf4j.ILoggerFactory;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StatusViaSLF4JLoggerFactory
/*    */ {
/*    */   public static void addInfo(String paramString, Object paramObject) {
/* 20 */     addStatus((Status)new InfoStatus(paramString, paramObject));
/*    */   }
/*    */   
/*    */   public static void addError(String paramString, Object paramObject) {
/* 24 */     addStatus((Status)new ErrorStatus(paramString, paramObject));
/*    */   }
/*    */   
/*    */   public static void addError(String paramString, Object paramObject, Throwable paramThrowable) {
/* 28 */     addStatus((Status)new ErrorStatus(paramString, paramObject, paramThrowable));
/*    */   }
/*    */   
/*    */   public static void addStatus(Status paramStatus) {
/* 32 */     ILoggerFactory iLoggerFactory = LoggerFactory.getILoggerFactory();
/* 33 */     if (iLoggerFactory instanceof LoggerContext) {
/* 34 */       ContextAwareBase contextAwareBase = new ContextAwareBase();
/* 35 */       LoggerContext loggerContext = (LoggerContext)iLoggerFactory;
/* 36 */       contextAwareBase.setContext((Context)loggerContext);
/* 37 */       contextAwareBase.addStatus(paramStatus);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\StatusViaSLF4JLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */