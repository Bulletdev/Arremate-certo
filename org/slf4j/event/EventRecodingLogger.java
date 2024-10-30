/*     */ package org.slf4j.event;
/*     */ 
/*     */ import java.util.Queue;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.Marker;
/*     */ import org.slf4j.helpers.MessageFormatter;
/*     */ import org.slf4j.helpers.SubstituteLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventRecodingLogger
/*     */   implements Logger
/*     */ {
/*     */   String name;
/*     */   SubstituteLogger logger;
/*     */   Queue<SubstituteLoggingEvent> eventQueue;
/*     */   static final boolean RECORD_ALL_EVENTS = true;
/*     */   
/*     */   public EventRecodingLogger(SubstituteLogger paramSubstituteLogger, Queue<SubstituteLoggingEvent> paramQueue) {
/*  30 */     this.logger = paramSubstituteLogger;
/*  31 */     this.name = paramSubstituteLogger.getName();
/*  32 */     this.eventQueue = paramQueue;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  36 */     return this.name;
/*     */   }
/*     */   
/*     */   public boolean isTraceEnabled() {
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public void trace(String paramString) {
/*  44 */     recordEvent_0Args(Level.TRACE, null, paramString, null);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object paramObject) {
/*  48 */     recordEvent_1Args(Level.TRACE, null, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object paramObject1, Object paramObject2) {
/*  52 */     recordEvent2Args(Level.TRACE, null, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object... paramVarArgs) {
/*  56 */     recordEventArgArray(Level.TRACE, null, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Throwable paramThrowable) {
/*  60 */     recordEvent_0Args(Level.TRACE, null, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isTraceEnabled(Marker paramMarker) {
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString) {
/*  68 */     recordEvent_0Args(Level.TRACE, paramMarker, paramString, null);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject) {
/*  72 */     recordEvent_1Args(Level.TRACE, paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/*  76 */     recordEvent2Args(Level.TRACE, paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object... paramVarArgs) {
/*  80 */     recordEventArgArray(Level.TRACE, paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Throwable paramThrowable) {
/*  84 */     recordEvent_0Args(Level.TRACE, paramMarker, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isDebugEnabled() {
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   public void debug(String paramString) {
/*  92 */     recordEvent_0Args(Level.DEBUG, null, paramString, null);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object paramObject) {
/*  96 */     recordEvent_1Args(Level.DEBUG, null, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object paramObject1, Object paramObject2) {
/* 100 */     recordEvent2Args(Level.DEBUG, null, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object... paramVarArgs) {
/* 104 */     recordEventArgArray(Level.DEBUG, null, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Throwable paramThrowable) {
/* 108 */     recordEvent_0Args(Level.DEBUG, null, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isDebugEnabled(Marker paramMarker) {
/* 112 */     return true;
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString) {
/* 116 */     recordEvent_0Args(Level.DEBUG, paramMarker, paramString, null);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject) {
/* 120 */     recordEvent_1Args(Level.DEBUG, paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 124 */     recordEvent2Args(Level.DEBUG, paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 128 */     recordEventArgArray(Level.DEBUG, paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 132 */     recordEvent_0Args(Level.DEBUG, paramMarker, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 136 */     return true;
/*     */   }
/*     */   
/*     */   public void info(String paramString) {
/* 140 */     recordEvent_0Args(Level.INFO, null, paramString, null);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object paramObject) {
/* 144 */     recordEvent_1Args(Level.INFO, null, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object paramObject1, Object paramObject2) {
/* 148 */     recordEvent2Args(Level.INFO, null, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object... paramVarArgs) {
/* 152 */     recordEventArgArray(Level.INFO, null, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Throwable paramThrowable) {
/* 156 */     recordEvent_0Args(Level.INFO, null, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isInfoEnabled(Marker paramMarker) {
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString) {
/* 164 */     recordEvent_0Args(Level.INFO, paramMarker, paramString, null);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject) {
/* 168 */     recordEvent_1Args(Level.INFO, paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 172 */     recordEvent2Args(Level.INFO, paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 176 */     recordEventArgArray(Level.INFO, paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 180 */     recordEvent_0Args(Level.INFO, paramMarker, paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWarnEnabled() {
/* 185 */     return true;
/*     */   }
/*     */   
/*     */   public void warn(String paramString) {
/* 189 */     recordEvent_0Args(Level.WARN, null, paramString, null);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object paramObject) {
/* 193 */     recordEvent_1Args(Level.WARN, null, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object paramObject1, Object paramObject2) {
/* 197 */     recordEvent2Args(Level.WARN, null, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object... paramVarArgs) {
/* 201 */     recordEventArgArray(Level.WARN, null, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Throwable paramThrowable) {
/* 205 */     recordEvent_0Args(Level.WARN, null, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isWarnEnabled(Marker paramMarker) {
/* 209 */     return true;
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString) {
/* 213 */     recordEvent_0Args(Level.WARN, paramMarker, paramString, null);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject) {
/* 217 */     recordEvent_1Args(Level.WARN, paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 221 */     recordEvent2Args(Level.WARN, paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 225 */     recordEventArgArray(Level.WARN, paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 229 */     recordEvent_0Args(Level.WARN, paramMarker, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isErrorEnabled() {
/* 233 */     return true;
/*     */   }
/*     */   
/*     */   public void error(String paramString) {
/* 237 */     recordEvent_0Args(Level.ERROR, null, paramString, null);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object paramObject) {
/* 241 */     recordEvent_1Args(Level.ERROR, null, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object paramObject1, Object paramObject2) {
/* 245 */     recordEvent2Args(Level.ERROR, null, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object... paramVarArgs) {
/* 249 */     recordEventArgArray(Level.ERROR, null, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Throwable paramThrowable) {
/* 253 */     recordEvent_0Args(Level.ERROR, null, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isErrorEnabled(Marker paramMarker) {
/* 257 */     return true;
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString) {
/* 261 */     recordEvent_0Args(Level.ERROR, paramMarker, paramString, null);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject) {
/* 265 */     recordEvent_1Args(Level.ERROR, paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 269 */     recordEvent2Args(Level.ERROR, paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 273 */     recordEventArgArray(Level.ERROR, paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 277 */     recordEvent_0Args(Level.ERROR, paramMarker, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   private void recordEvent_0Args(Level paramLevel, Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 281 */     recordEvent(paramLevel, paramMarker, paramString, null, paramThrowable);
/*     */   }
/*     */   
/*     */   private void recordEvent_1Args(Level paramLevel, Marker paramMarker, String paramString, Object paramObject) {
/* 285 */     recordEvent(paramLevel, paramMarker, paramString, new Object[] { paramObject }, null);
/*     */   }
/*     */   
/*     */   private void recordEvent2Args(Level paramLevel, Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 289 */     if (paramObject2 instanceof Throwable) {
/* 290 */       recordEvent(paramLevel, paramMarker, paramString, new Object[] { paramObject1 }, (Throwable)paramObject2);
/*     */     } else {
/* 292 */       recordEvent(paramLevel, paramMarker, paramString, new Object[] { paramObject1, paramObject2 }, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void recordEventArgArray(Level paramLevel, Marker paramMarker, String paramString, Object[] paramArrayOfObject) {
/* 297 */     Throwable throwable = MessageFormatter.getThrowableCandidate(paramArrayOfObject);
/* 298 */     if (throwable != null) {
/* 299 */       Object[] arrayOfObject = MessageFormatter.trimmedCopy(paramArrayOfObject);
/* 300 */       recordEvent(paramLevel, paramMarker, paramString, arrayOfObject, throwable);
/*     */     } else {
/* 302 */       recordEvent(paramLevel, paramMarker, paramString, paramArrayOfObject, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void recordEvent(Level paramLevel, Marker paramMarker, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 309 */     SubstituteLoggingEvent substituteLoggingEvent = new SubstituteLoggingEvent();
/* 310 */     substituteLoggingEvent.setTimeStamp(System.currentTimeMillis());
/* 311 */     substituteLoggingEvent.setLevel(paramLevel);
/* 312 */     substituteLoggingEvent.setLogger(this.logger);
/* 313 */     substituteLoggingEvent.setLoggerName(this.name);
/* 314 */     substituteLoggingEvent.setMarker(paramMarker);
/* 315 */     substituteLoggingEvent.setMessage(paramString);
/* 316 */     substituteLoggingEvent.setThreadName(Thread.currentThread().getName());
/*     */     
/* 318 */     substituteLoggingEvent.setArgumentArray(paramArrayOfObject);
/* 319 */     substituteLoggingEvent.setThrowable(paramThrowable);
/*     */     
/* 321 */     this.eventQueue.add(substituteLoggingEvent);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\event\EventRecodingLogger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */