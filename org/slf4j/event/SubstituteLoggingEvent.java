/*    */ package org.slf4j.event;
/*    */ 
/*    */ import org.slf4j.Marker;
/*    */ import org.slf4j.helpers.SubstituteLogger;
/*    */ 
/*    */ public class SubstituteLoggingEvent
/*    */   implements LoggingEvent {
/*    */   Level level;
/*    */   Marker marker;
/*    */   String loggerName;
/*    */   SubstituteLogger logger;
/*    */   String threadName;
/*    */   String message;
/*    */   Object[] argArray;
/*    */   long timeStamp;
/*    */   Throwable throwable;
/*    */   
/*    */   public Level getLevel() {
/* 19 */     return this.level;
/*    */   }
/*    */   
/*    */   public void setLevel(Level paramLevel) {
/* 23 */     this.level = paramLevel;
/*    */   }
/*    */   
/*    */   public Marker getMarker() {
/* 27 */     return this.marker;
/*    */   }
/*    */   
/*    */   public void setMarker(Marker paramMarker) {
/* 31 */     this.marker = paramMarker;
/*    */   }
/*    */   
/*    */   public String getLoggerName() {
/* 35 */     return this.loggerName;
/*    */   }
/*    */   
/*    */   public void setLoggerName(String paramString) {
/* 39 */     this.loggerName = paramString;
/*    */   }
/*    */   
/*    */   public SubstituteLogger getLogger() {
/* 43 */     return this.logger;
/*    */   }
/*    */   
/*    */   public void setLogger(SubstituteLogger paramSubstituteLogger) {
/* 47 */     this.logger = paramSubstituteLogger;
/*    */   }
/*    */   
/*    */   public String getMessage() {
/* 51 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String paramString) {
/* 55 */     this.message = paramString;
/*    */   }
/*    */   
/*    */   public Object[] getArgumentArray() {
/* 59 */     return this.argArray;
/*    */   }
/*    */   
/*    */   public void setArgumentArray(Object[] paramArrayOfObject) {
/* 63 */     this.argArray = paramArrayOfObject;
/*    */   }
/*    */   
/*    */   public long getTimeStamp() {
/* 67 */     return this.timeStamp;
/*    */   }
/*    */   
/*    */   public void setTimeStamp(long paramLong) {
/* 71 */     this.timeStamp = paramLong;
/*    */   }
/*    */   
/*    */   public String getThreadName() {
/* 75 */     return this.threadName;
/*    */   }
/*    */   
/*    */   public void setThreadName(String paramString) {
/* 79 */     this.threadName = paramString;
/*    */   }
/*    */   
/*    */   public Throwable getThrowable() {
/* 83 */     return this.throwable;
/*    */   }
/*    */   
/*    */   public void setThrowable(Throwable paramThrowable) {
/* 87 */     this.throwable = paramThrowable;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\event\SubstituteLoggingEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */