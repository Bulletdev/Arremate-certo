/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public class Jdk14Logger
/*     */   implements Serializable, Log
/*     */ {
/*     */   private static final long serialVersionUID = 4784713551416303804L;
/*  44 */   protected static final Level dummyLevel = Level.FINE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected transient Logger logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jdk14Logger(String paramString) {
/*  63 */     this.logger = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     this.name = null;
/*     */     this.name = paramString;
/*     */     this.logger = getLogger();
/*     */   }
/*     */   protected void log(Level paramLevel, String paramString, Throwable paramThrowable) {
/*  73 */     Logger logger = getLogger();
/*  74 */     if (logger.isLoggable(paramLevel)) {
/*     */       
/*  76 */       Throwable throwable = new Throwable();
/*  77 */       StackTraceElement[] arrayOfStackTraceElement = throwable.getStackTrace();
/*     */       
/*  79 */       String str1 = this.name;
/*  80 */       String str2 = "unknown";
/*     */       
/*  82 */       if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length > 2) {
/*  83 */         StackTraceElement stackTraceElement = arrayOfStackTraceElement[2];
/*  84 */         str2 = stackTraceElement.getMethodName();
/*     */       } 
/*  86 */       if (paramThrowable == null) {
/*  87 */         logger.logp(paramLevel, str1, str2, paramString);
/*     */       } else {
/*  89 */         logger.logp(paramLevel, str1, str2, paramString, paramThrowable);
/*     */       } 
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
/*     */   
/*     */   public void debug(Object paramObject) {
/* 103 */     log(Level.FINE, String.valueOf(paramObject), null);
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
/* 114 */     log(Level.FINE, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void error(Object paramObject) {
/* 124 */     log(Level.SEVERE, String.valueOf(paramObject), null);
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
/* 135 */     log(Level.SEVERE, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fatal(Object paramObject) {
/* 145 */     log(Level.SEVERE, String.valueOf(paramObject), null);
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
/* 156 */     log(Level.SEVERE, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getLogger() {
/* 163 */     if (this.logger == null) {
/* 164 */       this.logger = Logger.getLogger(this.name);
/*     */     }
/* 166 */     return this.logger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void info(Object paramObject) {
/* 176 */     log(Level.INFO, String.valueOf(paramObject), null);
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
/* 187 */     log(Level.INFO, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDebugEnabled() {
/* 194 */     return getLogger().isLoggable(Level.FINE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isErrorEnabled() {
/* 201 */     return getLogger().isLoggable(Level.SEVERE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFatalEnabled() {
/* 208 */     return getLogger().isLoggable(Level.SEVERE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 215 */     return getLogger().isLoggable(Level.INFO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTraceEnabled() {
/* 222 */     return getLogger().isLoggable(Level.FINEST);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWarnEnabled() {
/* 229 */     return getLogger().isLoggable(Level.WARNING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(Object paramObject) {
/* 239 */     log(Level.FINEST, String.valueOf(paramObject), null);
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
/* 250 */     log(Level.FINEST, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void warn(Object paramObject) {
/* 260 */     log(Level.WARNING, String.valueOf(paramObject), null);
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
/* 271 */     log(Level.WARNING, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\Jdk14Logger.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */