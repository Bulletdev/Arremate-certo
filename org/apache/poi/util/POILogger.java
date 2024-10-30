/*     */ package org.apache.poi.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Internal
/*     */ public abstract class POILogger
/*     */ {
/*     */   public static final int DEBUG = 1;
/*     */   public static final int INFO = 3;
/*     */   public static final int WARN = 5;
/*     */   public static final int ERROR = 7;
/*     */   public static final int FATAL = 9;
/*  36 */   protected static final String[] LEVEL_STRINGS_SHORT = new String[] { "?", "D", "?", "I", "?", "W", "?", "E", "?", "F", "?" };
/*     */   
/*  38 */   protected static final String[] LEVEL_STRINGS = new String[] { "?0?", "DEBUG", "?2?", "INFO", "?4?", "WARN", "?6?", "ERROR", "?8?", "FATAL", "?10+?" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void initialize(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void log(int paramInt, Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void log(int paramInt, Object paramObject, Throwable paramThrowable);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean check(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void log(int paramInt, Object... paramVarArgs) {
/*  84 */     if (!check(paramInt))
/*  85 */       return;  StringBuilder stringBuilder = new StringBuilder(32);
/*  86 */     Throwable throwable = null;
/*  87 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  88 */       if (b == paramVarArgs.length - 1 && paramVarArgs[b] instanceof Throwable) {
/*  89 */         throwable = (Throwable)paramVarArgs[b];
/*     */       } else {
/*  91 */         stringBuilder.append(paramVarArgs[b]);
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     String str = stringBuilder.toString();
/*  96 */     str = str.replaceAll("[\r\n]+", " ");
/*     */ 
/*     */ 
/*     */     
/* 100 */     if (throwable == null) {
/* 101 */       log(paramInt, str);
/*     */     } else {
/* 103 */       log(paramInt, str, throwable);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\POILogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */