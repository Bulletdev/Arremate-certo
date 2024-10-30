/*     */ package org.slf4j.helpers;
/*     */ 
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.Marker;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MarkerIgnoringBase
/*     */   extends a
/*     */   implements Logger
/*     */ {
/*     */   private static final long serialVersionUID = 9044267456635152283L;
/*     */   
/*     */   public boolean isTraceEnabled(Marker paramMarker) {
/*  43 */     return isTraceEnabled();
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString) {
/*  47 */     trace(paramString);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject) {
/*  51 */     trace(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/*  55 */     trace(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Object... paramVarArgs) {
/*  59 */     trace(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void trace(Marker paramMarker, String paramString, Throwable paramThrowable) {
/*  63 */     trace(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isDebugEnabled(Marker paramMarker) {
/*  67 */     return isDebugEnabled();
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString) {
/*  71 */     debug(paramString);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject) {
/*  75 */     debug(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/*  79 */     debug(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Object... paramVarArgs) {
/*  83 */     debug(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void debug(Marker paramMarker, String paramString, Throwable paramThrowable) {
/*  87 */     debug(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isInfoEnabled(Marker paramMarker) {
/*  91 */     return isInfoEnabled();
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString) {
/*  95 */     info(paramString);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject) {
/*  99 */     info(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 103 */     info(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 107 */     info(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void info(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 111 */     info(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isWarnEnabled(Marker paramMarker) {
/* 115 */     return isWarnEnabled();
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString) {
/* 119 */     warn(paramString);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject) {
/* 123 */     warn(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 127 */     warn(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 131 */     warn(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void warn(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 135 */     warn(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public boolean isErrorEnabled(Marker paramMarker) {
/* 139 */     return isErrorEnabled();
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString) {
/* 143 */     error(paramString);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject) {
/* 147 */     error(paramString, paramObject);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object paramObject1, Object paramObject2) {
/* 151 */     error(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Object... paramVarArgs) {
/* 155 */     error(paramString, paramVarArgs);
/*     */   }
/*     */   
/*     */   public void error(Marker paramMarker, String paramString, Throwable paramThrowable) {
/* 159 */     error(paramString, paramThrowable);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 163 */     return getClass().getName() + "(" + getName() + ")";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\MarkerIgnoringBase.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */