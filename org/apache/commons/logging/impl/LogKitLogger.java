/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.log.Hierarchy;
/*     */ import org.apache.log.Logger;
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
/*     */ public class LogKitLogger
/*     */   implements Serializable, Log
/*     */ {
/*     */   private static final long serialVersionUID = 3768538055836059519L;
/*  44 */   protected volatile transient Logger logger = null;
/*     */ 
/*     */   
/*  47 */   protected String name = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LogKitLogger(String paramString) {
/*  58 */     this.name = paramString;
/*  59 */     this.logger = getLogger();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getLogger() {
/*  68 */     Logger logger = this.logger;
/*  69 */     if (logger == null) {
/*  70 */       synchronized (this) {
/*  71 */         logger = this.logger;
/*  72 */         if (logger == null) {
/*  73 */           this.logger = logger = Hierarchy.getDefaultHierarchy().getLoggerFor(this.name);
/*     */         }
/*     */       } 
/*     */     }
/*  77 */     return logger;
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
/*  89 */     debug(paramObject);
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
/* 100 */     debug(paramObject, paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Object paramObject) {
/* 110 */     if (paramObject != null) {
/* 111 */       getLogger().debug(String.valueOf(paramObject));
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
/*     */   public void debug(Object paramObject, Throwable paramThrowable) {
/* 123 */     if (paramObject != null) {
/* 124 */       getLogger().debug(String.valueOf(paramObject), paramThrowable);
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
/* 135 */     if (paramObject != null) {
/* 136 */       getLogger().info(String.valueOf(paramObject));
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
/* 148 */     if (paramObject != null) {
/* 149 */       getLogger().info(String.valueOf(paramObject), paramThrowable);
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
/* 160 */     if (paramObject != null) {
/* 161 */       getLogger().warn(String.valueOf(paramObject));
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
/* 173 */     if (paramObject != null) {
/* 174 */       getLogger().warn(String.valueOf(paramObject), paramThrowable);
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
/* 185 */     if (paramObject != null) {
/* 186 */       getLogger().error(String.valueOf(paramObject));
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
/* 198 */     if (paramObject != null) {
/* 199 */       getLogger().error(String.valueOf(paramObject), paramThrowable);
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
/* 210 */     if (paramObject != null) {
/* 211 */       getLogger().fatalError(String.valueOf(paramObject));
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
/* 223 */     if (paramObject != null) {
/* 224 */       getLogger().fatalError(String.valueOf(paramObject), paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDebugEnabled() {
/* 232 */     return getLogger().isDebugEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isErrorEnabled() {
/* 239 */     return getLogger().isErrorEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFatalEnabled() {
/* 246 */     return getLogger().isFatalErrorEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 253 */     return getLogger().isInfoEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTraceEnabled() {
/* 260 */     return getLogger().isDebugEnabled();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWarnEnabled() {
/* 267 */     return getLogger().isWarnEnabled();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\LogKitLogger.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */