/*    */ package org.c.a.b.k.d;
/*    */ 
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.LogRecord;
/*    */ import java.util.logging.Logger;
/*    */ import org.c.a.a.f.a;
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
/*    */ public class a
/*    */   implements a
/*    */ {
/*    */   private final Logger logger;
/*    */   
/*    */   public a(Logger paramLogger) {
/* 39 */     this.logger = paramLogger;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDebugEnabled() {
/* 44 */     return this.logger.isLoggable(Level.FINE);
/*    */   }
/*    */   
/*    */   public void debug(String paramString) {
/* 48 */     a(Level.FINE, paramString, null);
/*    */   }
/*    */   
/*    */   public void info(String paramString) {
/* 52 */     a(Level.INFO, paramString, null);
/*    */   }
/*    */   
/*    */   public void warn(String paramString) {
/* 56 */     a(Level.WARNING, paramString, null);
/*    */   }
/*    */   
/*    */   public void error(String paramString) {
/* 60 */     a(Level.SEVERE, paramString, null);
/*    */   }
/*    */   
/*    */   public void a(String paramString, Exception paramException) {
/* 64 */     a(Level.SEVERE, paramString, paramException);
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
/*    */   private void a(Level paramLevel, String paramString, Exception paramException) {
/* 76 */     LogRecord logRecord = new LogRecord(paramLevel, paramString);
/* 77 */     logRecord.setLoggerName(this.logger.getName());
/* 78 */     logRecord.setThrown(paramException);
/* 79 */     logRecord.setSourceClassName(this.logger.getName());
/* 80 */     logRecord.setSourceMethodName(getMethodName());
/* 81 */     this.logger.log(logRecord);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String getMethodName() {
/* 88 */     StackTraceElement[] arrayOfStackTraceElement = (new Throwable()).getStackTrace();
/*    */     
/* 90 */     for (StackTraceElement stackTraceElement : arrayOfStackTraceElement) {
/* 91 */       if (this.logger.getName().equals(stackTraceElement.getClassName())) {
/* 92 */         return stackTraceElement.getMethodName();
/*    */       }
/*    */     } 
/*    */     
/* 96 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\k\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */