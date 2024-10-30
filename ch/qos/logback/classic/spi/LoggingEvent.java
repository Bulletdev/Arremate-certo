/*     */ package ch.qos.logback.classic.spi;
/*     */ 
/*     */ import ch.qos.logback.classic.Level;
/*     */ import ch.qos.logback.classic.Logger;
/*     */ import ch.qos.logback.classic.LoggerContext;
/*     */ import ch.qos.logback.classic.util.LogbackMDCAdapter;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import org.slf4j.MDC;
/*     */ import org.slf4j.Marker;
/*     */ import org.slf4j.helpers.MessageFormatter;
/*     */ import org.slf4j.spi.MDCAdapter;
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
/*     */ public class LoggingEvent
/*     */   implements ILoggingEvent
/*     */ {
/*     */   transient String fqnOfLoggerClass;
/*     */   private String threadName;
/*     */   private String loggerName;
/*     */   private LoggerContext loggerContext;
/*     */   private LoggerContextVO loggerContextVO;
/*     */   private transient Level level;
/*     */   private String message;
/*     */   transient String formattedMessage;
/*     */   private transient Object[] argumentArray;
/*     */   private ThrowableProxy throwableProxy;
/*     */   private StackTraceElement[] callerDataArray;
/*     */   private Marker marker;
/*     */   private Map<String, String> mdcPropertyMap;
/*     */   private long timeStamp;
/*     */   
/*     */   public LoggingEvent() {}
/*     */   
/*     */   public LoggingEvent(String paramString1, Logger paramLogger, Level paramLevel, String paramString2, Throwable paramThrowable, Object[] paramArrayOfObject) {
/* 105 */     this.fqnOfLoggerClass = paramString1;
/* 106 */     this.loggerName = paramLogger.getName();
/* 107 */     this.loggerContext = paramLogger.getLoggerContext();
/* 108 */     this.loggerContextVO = this.loggerContext.getLoggerContextRemoteView();
/* 109 */     this.level = paramLevel;
/*     */     
/* 111 */     this.message = paramString2;
/* 112 */     this.argumentArray = paramArrayOfObject;
/*     */     
/* 114 */     if (paramThrowable == null) {
/* 115 */       paramThrowable = extractThrowableAnRearrangeArguments(paramArrayOfObject);
/*     */     }
/*     */     
/* 118 */     if (paramThrowable != null) {
/* 119 */       this.throwableProxy = new ThrowableProxy(paramThrowable);
/* 120 */       LoggerContext loggerContext = paramLogger.getLoggerContext();
/* 121 */       if (loggerContext.isPackagingDataEnabled()) {
/* 122 */         this.throwableProxy.calculatePackagingData();
/*     */       }
/*     */     } 
/*     */     
/* 126 */     this.timeStamp = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   private Throwable extractThrowableAnRearrangeArguments(Object[] paramArrayOfObject) {
/* 130 */     Throwable throwable = EventArgUtil.extractThrowable(paramArrayOfObject);
/* 131 */     if (EventArgUtil.successfulExtraction(throwable)) {
/* 132 */       this.argumentArray = EventArgUtil.trimmedCopy(paramArrayOfObject);
/*     */     }
/* 134 */     return throwable;
/*     */   }
/*     */   
/*     */   public void setArgumentArray(Object[] paramArrayOfObject) {
/* 138 */     if (this.argumentArray != null) {
/* 139 */       throw new IllegalStateException("argArray has been already set");
/*     */     }
/* 141 */     this.argumentArray = paramArrayOfObject;
/*     */   }
/*     */   
/*     */   public Object[] getArgumentArray() {
/* 145 */     return this.argumentArray;
/*     */   }
/*     */   
/*     */   public Level getLevel() {
/* 149 */     return this.level;
/*     */   }
/*     */   
/*     */   public String getLoggerName() {
/* 153 */     return this.loggerName;
/*     */   }
/*     */   
/*     */   public void setLoggerName(String paramString) {
/* 157 */     this.loggerName = paramString;
/*     */   }
/*     */   
/*     */   public String getThreadName() {
/* 161 */     if (this.threadName == null) {
/* 162 */       this.threadName = Thread.currentThread().getName();
/*     */     }
/* 164 */     return this.threadName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThreadName(String paramString) throws IllegalStateException {
/* 172 */     if (this.threadName != null) {
/* 173 */       throw new IllegalStateException("threadName has been already set");
/*     */     }
/* 175 */     this.threadName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IThrowableProxy getThrowableProxy() {
/* 183 */     return this.throwableProxy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableProxy(ThrowableProxy paramThrowableProxy) {
/* 190 */     if (this.throwableProxy != null) {
/* 191 */       throw new IllegalStateException("ThrowableProxy has been already set.");
/*     */     }
/* 193 */     this.throwableProxy = paramThrowableProxy;
/*     */   }
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
/*     */   public void prepareForDeferredProcessing() {
/* 206 */     getFormattedMessage();
/* 207 */     getThreadName();
/*     */     
/* 209 */     getMDCPropertyMap();
/*     */   }
/*     */   
/*     */   public LoggerContextVO getLoggerContextVO() {
/* 213 */     return this.loggerContextVO;
/*     */   }
/*     */   
/*     */   public void setLoggerContextRemoteView(LoggerContextVO paramLoggerContextVO) {
/* 217 */     this.loggerContextVO = paramLoggerContextVO;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/* 221 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String paramString) {
/* 225 */     if (this.message != null) {
/* 226 */       throw new IllegalStateException("The message for this event has been set already.");
/*     */     }
/* 228 */     this.message = paramString;
/*     */   }
/*     */   
/*     */   public long getTimeStamp() {
/* 232 */     return this.timeStamp;
/*     */   }
/*     */   
/*     */   public void setTimeStamp(long paramLong) {
/* 236 */     this.timeStamp = paramLong;
/*     */   }
/*     */   
/*     */   public void setLevel(Level paramLevel) {
/* 240 */     if (this.level != null) {
/* 241 */       throw new IllegalStateException("The level has been already set for this event.");
/*     */     }
/* 243 */     this.level = paramLevel;
/*     */   }
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
/*     */   public StackTraceElement[] getCallerData() {
/* 257 */     if (this.callerDataArray == null) {
/* 258 */       this
/* 259 */         .callerDataArray = CallerData.extract(new Throwable(), this.fqnOfLoggerClass, this.loggerContext.getMaxCallerDataDepth(), this.loggerContext.getFrameworkPackages());
/*     */     }
/* 261 */     return this.callerDataArray;
/*     */   }
/*     */   
/*     */   public boolean hasCallerData() {
/* 265 */     return (this.callerDataArray != null);
/*     */   }
/*     */   
/*     */   public void setCallerData(StackTraceElement[] paramArrayOfStackTraceElement) {
/* 269 */     this.callerDataArray = paramArrayOfStackTraceElement;
/*     */   }
/*     */   
/*     */   public Marker getMarker() {
/* 273 */     return this.marker;
/*     */   }
/*     */   
/*     */   public void setMarker(Marker paramMarker) {
/* 277 */     if (this.marker != null) {
/* 278 */       throw new IllegalStateException("The marker has been already set for this event.");
/*     */     }
/* 280 */     this.marker = paramMarker;
/*     */   }
/*     */   
/*     */   public long getContextBirthTime() {
/* 284 */     return this.loggerContextVO.getBirthTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFormattedMessage() {
/* 289 */     if (this.formattedMessage != null) {
/* 290 */       return this.formattedMessage;
/*     */     }
/* 292 */     if (this.argumentArray != null) {
/* 293 */       this.formattedMessage = MessageFormatter.arrayFormat(this.message, this.argumentArray).getMessage();
/*     */     } else {
/* 295 */       this.formattedMessage = this.message;
/*     */     } 
/*     */     
/* 298 */     return this.formattedMessage;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getMDCPropertyMap() {
/* 303 */     if (this.mdcPropertyMap == null) {
/* 304 */       MDCAdapter mDCAdapter = MDC.getMDCAdapter();
/* 305 */       if (mDCAdapter instanceof LogbackMDCAdapter) {
/* 306 */         this.mdcPropertyMap = ((LogbackMDCAdapter)mDCAdapter).getPropertyMap();
/*     */       } else {
/* 308 */         this.mdcPropertyMap = mDCAdapter.getCopyOfContextMap();
/*     */       } 
/*     */     } 
/* 311 */     if (this.mdcPropertyMap == null) {
/* 312 */       this.mdcPropertyMap = Collections.emptyMap();
/*     */     }
/* 314 */     return this.mdcPropertyMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMDCPropertyMap(Map<String, String> paramMap) {
/* 324 */     if (this.mdcPropertyMap != null) {
/* 325 */       throw new IllegalStateException("The MDCPropertyMap has been already set for this event.");
/*     */     }
/* 327 */     this.mdcPropertyMap = paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getMdc() {
/* 337 */     return getMDCPropertyMap();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 342 */     StringBuilder stringBuilder = new StringBuilder();
/* 343 */     stringBuilder.append('[');
/* 344 */     stringBuilder.append(this.level).append("] ");
/* 345 */     stringBuilder.append(getFormattedMessage());
/* 346 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 356 */     throw new UnsupportedOperationException(getClass() + " does not support serialization. Use LoggerEventVO instance instead. See also LoggerEventVO.build method.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\LoggingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */