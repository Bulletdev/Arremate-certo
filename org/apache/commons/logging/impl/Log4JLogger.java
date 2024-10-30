/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.log4j.Level;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.log4j.Priority;
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
/*     */ public class Log4JLogger
/*     */   implements Serializable, Log
/*     */ {
/*     */   private static final long serialVersionUID = 5160705895411730424L;
/*  53 */   private static final String FQCN = Log4JLogger.class.getName();
/*     */ 
/*     */   
/*  56 */   private volatile transient Logger logger = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     Level level;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Priority traceLevel;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  78 */     if (!Priority.class.isAssignableFrom(Level.class))
/*     */     {
/*  80 */       throw new InstantiationError("Log4J 1.2 not available");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  89 */       Priority priority = (Priority)Level.class.getDeclaredField("TRACE").get(null);
/*  90 */     } catch (Exception exception) {
/*     */       
/*  92 */       level = Level.DEBUG;
/*     */     } 
/*  94 */     traceLevel = (Priority)level;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Log4JLogger() {
/* 100 */     this.name = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Log4JLogger(String paramString) {
/* 107 */     this.name = paramString;
/* 108 */     this.logger = getLogger();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Log4JLogger(Logger paramLogger) {
/* 115 */     if (paramLogger == null) {
/* 116 */       throw new IllegalArgumentException("Warning - null logger in constructor; possible log4j misconfiguration.");
/*     */     }
/*     */     
/* 119 */     this.name = paramLogger.getName();
/* 120 */     this.logger = paramLogger;
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
/*     */   public void trace(Object paramObject) {
/* 132 */     getLogger().log(FQCN, traceLevel, paramObject, null);
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
/*     */   public void trace(Object paramObject, Throwable paramThrowable) {
/* 145 */     getLogger().log(FQCN, traceLevel, paramObject, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Object paramObject) {
/* 155 */     getLogger().log(FQCN, (Priority)Level.DEBUG, paramObject, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Object paramObject, Throwable paramThrowable) {
/* 166 */     getLogger().log(FQCN, (Priority)Level.DEBUG, paramObject, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void info(Object paramObject) {
/* 176 */     getLogger().log(FQCN, (Priority)Level.INFO, paramObject, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void info(Object paramObject, Throwable paramThrowable) {
/* 187 */     getLogger().log(FQCN, (Priority)Level.INFO, paramObject, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void warn(Object paramObject) {
/* 197 */     getLogger().log(FQCN, (Priority)Level.WARN, paramObject, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void warn(Object paramObject, Throwable paramThrowable) {
/* 208 */     getLogger().log(FQCN, (Priority)Level.WARN, paramObject, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void error(Object paramObject) {
/* 218 */     getLogger().log(FQCN, (Priority)Level.ERROR, paramObject, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void error(Object paramObject, Throwable paramThrowable) {
/* 229 */     getLogger().log(FQCN, (Priority)Level.ERROR, paramObject, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fatal(Object paramObject) {
/* 239 */     getLogger().log(FQCN, (Priority)Level.FATAL, paramObject, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fatal(Object paramObject, Throwable paramThrowable) {
/* 250 */     getLogger().log(FQCN, (Priority)Level.FATAL, paramObject, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getLogger() {
/* 257 */     Logger logger = this.logger;
/* 258 */     if (logger == null) {
/* 259 */       synchronized (this) {
/* 260 */         logger = this.logger;
/* 261 */         if (logger == null) {
/* 262 */           this.logger = logger = Logger.getLogger(this.name);
/*     */         }
/*     */       } 
/*     */     }
/* 266 */     return logger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDebugEnabled() {
/* 273 */     return getLogger().isDebugEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isErrorEnabled() {
/* 280 */     return getLogger().isEnabledFor((Priority)Level.ERROR);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFatalEnabled() {
/* 287 */     return getLogger().isEnabledFor((Priority)Level.FATAL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 294 */     return getLogger().isInfoEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTraceEnabled() {
/* 303 */     return getLogger().isEnabledFor(traceLevel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWarnEnabled() {
/* 310 */     return getLogger().isEnabledFor((Priority)Level.WARN);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\Log4JLogger.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */