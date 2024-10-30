/*     */ package ch.qos.logback.classic.spi;
/*     */ 
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CallerData
/*     */ {
/*     */   public static final String NA = "?";
/*     */   private static final String LOG4J_CATEGORY = "org.apache.log4j.Category";
/*     */   private static final String SLF4J_BOUNDARY = "org.slf4j.Logger";
/*     */   public static final int LINE_NA = -1;
/*  44 */   public static final String CALLER_DATA_NA = "?#?:?" + CoreConstants.LINE_SEPARATOR;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   public static final StackTraceElement[] EMPTY_CALLER_DATA_ARRAY = new StackTraceElement[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackTraceElement[] extract(Throwable paramThrowable, String paramString, int paramInt, List<String> paramList) {
/*  56 */     if (paramThrowable == null) {
/*  57 */       return null;
/*     */     }
/*     */     
/*  60 */     StackTraceElement[] arrayOfStackTraceElement1 = paramThrowable.getStackTrace();
/*     */ 
/*     */     
/*  63 */     int i = -1; int j;
/*  64 */     for (j = 0; j < arrayOfStackTraceElement1.length; j++) {
/*  65 */       if (isInFrameworkSpace(arrayOfStackTraceElement1[j].getClassName(), paramString, paramList)) {
/*     */         
/*  67 */         i = j + 1;
/*     */       }
/*  69 */       else if (i != -1) {
/*     */         break;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  76 */     if (i == -1) {
/*  77 */       return EMPTY_CALLER_DATA_ARRAY;
/*     */     }
/*     */     
/*  80 */     j = arrayOfStackTraceElement1.length - i;
/*  81 */     int k = (paramInt < j) ? paramInt : j;
/*     */     
/*  83 */     StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[k];
/*  84 */     for (byte b = 0; b < k; b++) {
/*  85 */       arrayOfStackTraceElement2[b] = arrayOfStackTraceElement1[i + b];
/*     */     }
/*  87 */     return arrayOfStackTraceElement2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isInFrameworkSpace(String paramString1, String paramString2, List<String> paramList) {
/*  93 */     if (paramString1.equals(paramString2) || paramString1.equals("org.apache.log4j.Category") || paramString1.startsWith("org.slf4j.Logger") || 
/*  94 */       isInFrameworkSpaceList(paramString1, paramList)) {
/*  95 */       return true;
/*     */     }
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isInFrameworkSpaceList(String paramString, List<String> paramList) {
/* 105 */     if (paramList == null) {
/* 106 */       return false;
/*     */     }
/* 108 */     for (String str : paramList) {
/* 109 */       if (paramString.startsWith(str))
/* 110 */         return true; 
/*     */     } 
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StackTraceElement naInstance() {
/* 122 */     return new StackTraceElement("?", "?", "?", -1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\CallerData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */