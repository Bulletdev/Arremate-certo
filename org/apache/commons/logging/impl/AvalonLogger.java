/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import org.apache.avalon.framework.logger.Logger;
/*     */ import org.apache.commons.logging.Log;
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
/*     */ public class AvalonLogger
/*     */   implements Log
/*     */ {
/*  55 */   private static volatile Logger defaultLogger = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final transient Logger logger;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AvalonLogger(Logger paramLogger) {
/*  66 */     this.logger = paramLogger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AvalonLogger(String paramString) {
/*  76 */     if (defaultLogger == null) {
/*  77 */       throw new NullPointerException("default logger has to be specified if this constructor is used!");
/*     */     }
/*  79 */     this.logger = defaultLogger.getChildLogger(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getLogger() {
/*  88 */     return this.logger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setDefaultLogger(Logger paramLogger) {
/*  98 */     defaultLogger = paramLogger;
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
/* 109 */     if (getLogger().isDebugEnabled()) {
/* 110 */       getLogger().debug(String.valueOf(paramObject), paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Object paramObject) {
/* 121 */     if (getLogger().isDebugEnabled()) {
/* 122 */       getLogger().debug(String.valueOf(paramObject));
/*     */     }
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
/* 134 */     if (getLogger().isErrorEnabled()) {
/* 135 */       getLogger().error(String.valueOf(paramObject), paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void error(Object paramObject) {
/* 146 */     if (getLogger().isErrorEnabled()) {
/* 147 */       getLogger().error(String.valueOf(paramObject));
/*     */     }
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
/* 159 */     if (getLogger().isFatalErrorEnabled()) {
/* 160 */       getLogger().fatalError(String.valueOf(paramObject), paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fatal(Object paramObject) {
/* 171 */     if (getLogger().isFatalErrorEnabled()) {
/* 172 */       getLogger().fatalError(String.valueOf(paramObject));
/*     */     }
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
/* 184 */     if (getLogger().isInfoEnabled()) {
/* 185 */       getLogger().info(String.valueOf(paramObject), paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void info(Object paramObject) {
/* 196 */     if (getLogger().isInfoEnabled()) {
/* 197 */       getLogger().info(String.valueOf(paramObject));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDebugEnabled() {
/* 206 */     return getLogger().isDebugEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isErrorEnabled() {
/* 214 */     return getLogger().isErrorEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFatalEnabled() {
/* 222 */     return getLogger().isFatalErrorEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 230 */     return getLogger().isInfoEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTraceEnabled() {
/* 238 */     return getLogger().isDebugEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWarnEnabled() {
/* 246 */     return getLogger().isWarnEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(Object paramObject, Throwable paramThrowable) {
/* 257 */     if (getLogger().isDebugEnabled()) {
/* 258 */       getLogger().debug(String.valueOf(paramObject), paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(Object paramObject) {
/* 269 */     if (getLogger().isDebugEnabled()) {
/* 270 */       getLogger().debug(String.valueOf(paramObject));
/*     */     }
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
/* 282 */     if (getLogger().isWarnEnabled()) {
/* 283 */       getLogger().warn(String.valueOf(paramObject), paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void warn(Object paramObject) {
/* 294 */     if (getLogger().isWarnEnabled())
/* 295 */       getLogger().warn(String.valueOf(paramObject)); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\AvalonLogger.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */