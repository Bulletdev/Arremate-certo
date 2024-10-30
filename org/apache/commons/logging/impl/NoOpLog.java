/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ public class NoOpLog
/*     */   implements Serializable, Log
/*     */ {
/*     */   private static final long serialVersionUID = 561423906191706148L;
/*     */   
/*     */   public NoOpLog() {}
/*     */   
/*     */   public NoOpLog(String paramString) {}
/*     */   
/*     */   public void trace(Object paramObject) {}
/*     */   
/*     */   public void trace(Object paramObject, Throwable paramThrowable) {}
/*     */   
/*     */   public void debug(Object paramObject) {}
/*     */   
/*     */   public void debug(Object paramObject, Throwable paramThrowable) {}
/*     */   
/*     */   public void info(Object paramObject) {}
/*     */   
/*     */   public void info(Object paramObject, Throwable paramThrowable) {}
/*     */   
/*     */   public void warn(Object paramObject) {}
/*     */   
/*     */   public void warn(Object paramObject, Throwable paramThrowable) {}
/*     */   
/*     */   public void error(Object paramObject) {}
/*     */   
/*     */   public void error(Object paramObject, Throwable paramThrowable) {}
/*     */   
/*     */   public void fatal(Object paramObject) {}
/*     */   
/*     */   public void fatal(Object paramObject, Throwable paramThrowable) {}
/*     */   
/*     */   public final boolean isDebugEnabled() {
/*  68 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isErrorEnabled() {
/*  75 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isFatalEnabled() {
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isInfoEnabled() {
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isTraceEnabled() {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isWarnEnabled() {
/* 103 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\NoOpLog.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */