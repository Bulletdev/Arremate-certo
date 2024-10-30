/*     */ package org.slf4j.helpers;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Queue;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.Marker;
/*     */ import org.slf4j.event.EventRecodingLogger;
/*     */ import org.slf4j.event.LoggingEvent;
/*     */ import org.slf4j.event.SubstituteLoggingEvent;
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
/*     */ public class SubstituteLogger
/*     */   implements Logger
/*     */ {
/*     */   private final String name;
/*     */   private volatile Logger _delegate;
/*     */   private Boolean delegateEventAware;
/*     */   private Method logMethodCache;
/*     */   private EventRecodingLogger eventRecodingLogger;
/*     */   private Queue<SubstituteLoggingEvent> eventQueue;
/*     */   private final boolean createdPostInitialization;
/*     */   
/*     */   public SubstituteLogger(String paramString, Queue<SubstituteLoggingEvent> paramQueue, boolean paramBoolean) {
/*  59 */     this.name = paramString;
/*  60 */     this.eventQueue = paramQueue;
/*  61 */     this.createdPostInitialization = paramBoolean;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  65 */     return this.name;
/*     */   }
/*     */   
/*     */   public boolean isTraceEnabled() {
/*  69 */     return delegate().isTraceEnabled();
/*     */   }
/*     */   
/*     */   public void trace(String paramString) {
/*  73 */     delegate().trace(paramString);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object paramObject) {
/*  77 */     delegate().trace(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object paramObject1, Object paramObject2) {
/*  81 */     delegate().trace(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Object... paramVarArgs) {
/*  85 */     delegate().trace(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void trace(String paramString, Throwable paramThrowable) {
/*  89 */     delegate().trace(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isTraceEnabled(Marker paramMarker) {
/*  93 */     return delegate().isTraceEnabled(paramMarker);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString) {
/*  97 */     delegate().trace(paramMarker, paramString);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject) {
/* 101 */     delegate().trace(paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 105 */     delegate().trace(paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 109 */     delegate().trace(paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 113 */     delegate().trace(paramMarker, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isDebugEnabled() {
/* 117 */     return delegate().isDebugEnabled();
/*     */   }
/*     */   
/*     */   public void debug(String paramString) {
/* 121 */     delegate().debug(paramString);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object paramObject) {
/* 125 */     delegate().debug(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object paramObject1, Object paramObject2) {
/* 129 */     delegate().debug(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Object... paramVarArgs) {
/* 133 */     delegate().debug(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void debug(String paramString, Throwable paramThrowable) {
/* 137 */     delegate().debug(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isDebugEnabled(Marker paramMarker) {
/* 141 */     return delegate().isDebugEnabled(paramMarker);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString) {
/* 145 */     delegate().debug(paramMarker, paramString);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject) {
/* 149 */     delegate().debug(paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 153 */     delegate().debug(paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 157 */     delegate().debug(paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 161 */     delegate().debug(paramMarker, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 165 */     return delegate().isInfoEnabled();
/*     */   }
/*     */   
/*     */   public void info(String paramString) {
/* 169 */     delegate().info(paramString);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object paramObject) {
/* 173 */     delegate().info(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object paramObject1, Object paramObject2) {
/* 177 */     delegate().info(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Object... paramVarArgs) {
/* 181 */     delegate().info(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void info(String paramString, Throwable paramThrowable) {
/* 185 */     delegate().info(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isInfoEnabled(Marker paramMarker) {
/* 189 */     return delegate().isInfoEnabled(paramMarker);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString) {
/* 193 */     delegate().info(paramMarker, paramString);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject) {
/* 197 */     delegate().info(paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 201 */     delegate().info(paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 205 */     delegate().info(paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 209 */     delegate().info(paramMarker, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isWarnEnabled() {
/* 213 */     return delegate().isWarnEnabled();
/*     */   }
/*     */   
/*     */   public void warn(String paramString) {
/* 217 */     delegate().warn(paramString);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object paramObject) {
/* 221 */     delegate().warn(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object paramObject1, Object paramObject2) {
/* 225 */     delegate().warn(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Object... paramVarArgs) {
/* 229 */     delegate().warn(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void warn(String paramString, Throwable paramThrowable) {
/* 233 */     delegate().warn(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isWarnEnabled(Marker paramMarker) {
/* 237 */     return delegate().isWarnEnabled(paramMarker);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString) {
/* 241 */     delegate().warn(paramMarker, paramString);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject) {
/* 245 */     delegate().warn(paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 249 */     delegate().warn(paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 253 */     delegate().warn(paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 257 */     delegate().warn(paramMarker, paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isErrorEnabled() {
/* 261 */     return delegate().isErrorEnabled();
/*     */   }
/*     */   
/*     */   public void error(String paramString) {
/* 265 */     delegate().error(paramString);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object paramObject) {
/* 269 */     delegate().error(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object paramObject1, Object paramObject2) {
/* 273 */     delegate().error(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Object... paramVarArgs) {
/* 277 */     delegate().error(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void error(String paramString, Throwable paramThrowable) {
/* 281 */     delegate().error(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isErrorEnabled(Marker paramMarker) {
/* 285 */     return delegate().isErrorEnabled(paramMarker);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString) {
/* 289 */     delegate().error(paramMarker, paramString);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject) {
/* 293 */     delegate().error(paramMarker, paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 297 */     delegate().error(paramMarker, paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 301 */     delegate().error(paramMarker, paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 305 */     delegate().error(paramMarker, paramString, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 310 */     if (this == paramObject)
/* 311 */       return true; 
/* 312 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 313 */       return false;
/*     */     }
/* 315 */     SubstituteLogger substituteLogger = (SubstituteLogger)paramObject;
/*     */     
/* 317 */     if (!this.name.equals(substituteLogger.name)) {
/* 318 */       return false;
/*     */     }
/* 320 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 325 */     return this.name.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Logger delegate() {
/* 333 */     if (this._delegate != null) {
/* 334 */       return this._delegate;
/*     */     }
/* 336 */     if (this.createdPostInitialization) {
/* 337 */       return NOPLogger.NOP_LOGGER;
/*     */     }
/* 339 */     return getEventRecordingLogger();
/*     */   }
/*     */ 
/*     */   
/*     */   private Logger getEventRecordingLogger() {
/* 344 */     if (this.eventRecodingLogger == null) {
/* 345 */       this.eventRecodingLogger = new EventRecodingLogger(this, this.eventQueue);
/*     */     }
/* 347 */     return (Logger)this.eventRecodingLogger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDelegate(Logger paramLogger) {
/* 355 */     this._delegate = paramLogger;
/*     */   }
/*     */   
/*     */   public boolean isDelegateEventAware() {
/* 359 */     if (this.delegateEventAware != null) {
/* 360 */       return this.delegateEventAware.booleanValue();
/*     */     }
/*     */     try {
/* 363 */       this.logMethodCache = this._delegate.getClass().getMethod("log", new Class[] { LoggingEvent.class });
/* 364 */       this.delegateEventAware = Boolean.TRUE;
/* 365 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 366 */       this.delegateEventAware = Boolean.FALSE;
/*     */     } 
/* 368 */     return this.delegateEventAware.booleanValue();
/*     */   }
/*     */   
/*     */   public void log(LoggingEvent paramLoggingEvent) {
/* 372 */     if (isDelegateEventAware()) {
/*     */       
/* 374 */       try { this.logMethodCache.invoke(this._delegate, new Object[] { paramLoggingEvent }); }
/* 375 */       catch (IllegalAccessException illegalAccessException) {  }
/* 376 */       catch (IllegalArgumentException illegalArgumentException) {  }
/* 377 */       catch (InvocationTargetException invocationTargetException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDelegateNull() {
/* 384 */     return (this._delegate == null);
/*     */   }
/*     */   
/*     */   public boolean isDelegateNOP() {
/* 388 */     return this._delegate instanceof NOPLogger;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\SubstituteLogger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */