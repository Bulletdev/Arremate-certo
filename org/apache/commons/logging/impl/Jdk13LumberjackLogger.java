/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Serializable;
/*     */ import java.io.StringWriter;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.LogRecord;
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
/*     */ public class Jdk13LumberjackLogger
/*     */   implements Serializable, Log
/*     */ {
/*     */   private static final long serialVersionUID = -8649807923527610591L;
/*  48 */   protected transient Logger logger = null;
/*  49 */   protected String name = null;
/*  50 */   private String sourceClassName = "unknown";
/*  51 */   private String sourceMethodName = "unknown";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean classAndMethodFound = false;
/*     */ 
/*     */ 
/*     */   
/*  60 */   protected static final Level dummyLevel = Level.FINE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Jdk13LumberjackLogger(String paramString) {
/*  70 */     this.name = paramString;
/*  71 */     this.logger = getLogger();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void log(Level paramLevel, String paramString, Throwable paramThrowable) {
/*  77 */     if (getLogger().isLoggable(paramLevel)) {
/*  78 */       LogRecord logRecord = new LogRecord(paramLevel, paramString);
/*  79 */       if (!this.classAndMethodFound) {
/*  80 */         getClassAndMethod();
/*     */       }
/*  82 */       logRecord.setSourceClassName(this.sourceClassName);
/*  83 */       logRecord.setSourceMethodName(this.sourceMethodName);
/*  84 */       if (paramThrowable != null) {
/*  85 */         logRecord.setThrown(paramThrowable);
/*     */       }
/*  87 */       getLogger().log(logRecord);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void getClassAndMethod() {
/*     */     try {
/*  97 */       Throwable throwable = new Throwable();
/*  98 */       throwable.fillInStackTrace();
/*  99 */       StringWriter stringWriter = new StringWriter();
/* 100 */       PrintWriter printWriter = new PrintWriter(stringWriter);
/* 101 */       throwable.printStackTrace(printWriter);
/* 102 */       String str1 = stringWriter.getBuffer().toString();
/* 103 */       StringTokenizer stringTokenizer = new StringTokenizer(str1, "\n");
/*     */       
/* 105 */       stringTokenizer.nextToken();
/* 106 */       String str2 = stringTokenizer.nextToken();
/* 107 */       while (str2.indexOf(getClass().getName()) == -1) {
/* 108 */         str2 = stringTokenizer.nextToken();
/*     */       }
/* 110 */       while (str2.indexOf(getClass().getName()) >= 0) {
/* 111 */         str2 = stringTokenizer.nextToken();
/*     */       }
/* 113 */       int i = str2.indexOf("at ") + 3;
/* 114 */       int j = str2.indexOf('(');
/* 115 */       String str3 = str2.substring(i, j);
/* 116 */       int k = str3.lastIndexOf('.');
/* 117 */       this.sourceClassName = str3.substring(0, k);
/* 118 */       this.sourceMethodName = str3.substring(k + 1);
/* 119 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 122 */     this.classAndMethodFound = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Object paramObject) {
/* 132 */     log(Level.FINE, String.valueOf(paramObject), null);
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
/* 143 */     log(Level.FINE, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void error(Object paramObject) {
/* 153 */     log(Level.SEVERE, String.valueOf(paramObject), null);
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
/* 164 */     log(Level.SEVERE, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fatal(Object paramObject) {
/* 174 */     log(Level.SEVERE, String.valueOf(paramObject), null);
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
/* 185 */     log(Level.SEVERE, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getLogger() {
/* 192 */     if (this.logger == null) {
/* 193 */       this.logger = Logger.getLogger(this.name);
/*     */     }
/* 195 */     return this.logger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void info(Object paramObject) {
/* 205 */     log(Level.INFO, String.valueOf(paramObject), null);
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
/* 216 */     log(Level.INFO, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDebugEnabled() {
/* 223 */     return getLogger().isLoggable(Level.FINE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isErrorEnabled() {
/* 230 */     return getLogger().isLoggable(Level.SEVERE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFatalEnabled() {
/* 237 */     return getLogger().isLoggable(Level.SEVERE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInfoEnabled() {
/* 244 */     return getLogger().isLoggable(Level.INFO);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTraceEnabled() {
/* 251 */     return getLogger().isLoggable(Level.FINEST);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWarnEnabled() {
/* 258 */     return getLogger().isLoggable(Level.WARNING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(Object paramObject) {
/* 268 */     log(Level.FINEST, String.valueOf(paramObject), null);
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
/* 279 */     log(Level.FINEST, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void warn(Object paramObject) {
/* 289 */     log(Level.WARNING, String.valueOf(paramObject), null);
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
/* 300 */     log(Level.WARNING, String.valueOf(paramObject), paramThrowable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\Jdk13LumberjackLogger.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */