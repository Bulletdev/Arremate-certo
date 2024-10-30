/*    */ package ch.qos.logback.classic.util;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
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
/*    */ public class LevelToSyslogSeverity
/*    */ {
/*    */   public static int convert(ILoggingEvent paramILoggingEvent) {
/* 28 */     Level level = paramILoggingEvent.getLevel();
/*    */     
/* 30 */     switch (level.levelInt) {
/*    */       case 40000:
/* 32 */         return 3;
/*    */       case 30000:
/* 34 */         return 4;
/*    */       case 20000:
/* 36 */         return 6;
/*    */       case 5000:
/*    */       case 10000:
/* 39 */         return 7;
/*    */     } 
/* 41 */     throw new IllegalArgumentException("Level " + level + " is not a valid level for a printing method");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\LevelToSyslogSeverity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */