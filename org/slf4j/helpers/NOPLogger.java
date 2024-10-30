/*     */ package org.slf4j.helpers;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NOPLogger
/*     */   extends MarkerIgnoringBase
/*     */ {
/*     */   private static final long serialVersionUID = -517220405410904473L;
/*  42 */   public static final NOPLogger NOP_LOGGER = new NOPLogger();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  55 */     return "NOP";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isTraceEnabled() {
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void trace(String paramString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void trace(String paramString, Object paramObject) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void trace(String paramString, Object paramObject1, Object paramObject2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void trace(String paramString, Object... paramVarArgs) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void trace(String paramString, Throwable paramThrowable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDebugEnabled() {
/*  96 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void debug(String paramString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void debug(String paramString, Object paramObject) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void debug(String paramString, Object paramObject1, Object paramObject2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void debug(String paramString, Object... paramVarArgs) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void debug(String paramString, Throwable paramThrowable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isInfoEnabled() {
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void info(String paramString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void info(String paramString, Object paramObject) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void info(String paramString, Object paramObject1, Object paramObject2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void info(String paramString, Object... paramVarArgs) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void info(String paramString, Throwable paramThrowable) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isWarnEnabled() {
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void warn(String paramString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void warn(String paramString, Object paramObject) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void warn(String paramString, Object paramObject1, Object paramObject2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void warn(String paramString, Object... paramVarArgs) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final void warn(String paramString, Throwable paramThrowable) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isErrorEnabled() {
/* 193 */     return false;
/*     */   }
/*     */   
/*     */   public final void error(String paramString) {}
/*     */   
/*     */   public final void error(String paramString, Object paramObject) {}
/*     */   
/*     */   public final void error(String paramString, Object paramObject1, Object paramObject2) {}
/*     */   
/*     */   public final void error(String paramString, Object... paramVarArgs) {}
/*     */   
/*     */   public final void error(String paramString, Throwable paramThrowable) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\NOPLogger.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */