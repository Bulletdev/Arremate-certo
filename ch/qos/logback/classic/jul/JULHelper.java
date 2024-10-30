/*    */ package ch.qos.logback.classic.jul;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
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
/*    */ public class JULHelper
/*    */ {
/*    */   public static final boolean isRegularNonRootLogger(Logger paramLogger) {
/* 22 */     if (paramLogger == null)
/* 23 */       return false; 
/* 24 */     return !paramLogger.getName().equals("");
/*    */   }
/*    */   
/*    */   public static final boolean isRoot(Logger paramLogger) {
/* 28 */     if (paramLogger == null)
/* 29 */       return false; 
/* 30 */     return paramLogger.getName().equals("");
/*    */   }
/*    */   
/*    */   public static Level asJULLevel(Level paramLevel) {
/* 34 */     if (paramLevel == null) {
/* 35 */       throw new IllegalArgumentException("Unexpected level [null]");
/*    */     }
/* 37 */     switch (paramLevel.levelInt) {
/*    */       case -2147483648:
/* 39 */         return Level.ALL;
/*    */       case 5000:
/* 41 */         return Level.FINEST;
/*    */       case 10000:
/* 43 */         return Level.FINE;
/*    */       case 20000:
/* 45 */         return Level.INFO;
/*    */       case 30000:
/* 47 */         return Level.WARNING;
/*    */       case 40000:
/* 49 */         return Level.SEVERE;
/*    */       case 2147483647:
/* 51 */         return Level.OFF;
/*    */     } 
/* 53 */     throw new IllegalArgumentException("Unexpected level [" + paramLevel + "]");
/*    */   }
/*    */ 
/*    */   
/*    */   public static String asJULLoggerName(String paramString) {
/* 58 */     if ("ROOT".equals(paramString)) {
/* 59 */       return "";
/*    */     }
/* 61 */     return paramString;
/*    */   }
/*    */   
/*    */   public static Logger asJULLogger(String paramString) {
/* 65 */     String str = asJULLoggerName(paramString);
/* 66 */     return Logger.getLogger(str);
/*    */   }
/*    */   
/*    */   public static Logger asJULLogger(Logger paramLogger) {
/* 70 */     return asJULLogger(paramLogger.getName());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\jul\JULHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */