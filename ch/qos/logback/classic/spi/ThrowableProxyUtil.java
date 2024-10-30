/*     */ package ch.qos.logback.classic.spi;
/*     */ 
/*     */ import ch.qos.logback.core.CoreConstants;
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
/*     */ public class ThrowableProxyUtil
/*     */ {
/*     */   public static final int REGULAR_EXCEPTION_INDENT = 1;
/*     */   public static final int SUPPRESSED_EXCEPTION_INDENT = 1;
/*     */   private static final int BUILDER_CAPACITY = 2048;
/*     */   
/*     */   public static void build(ThrowableProxy paramThrowableProxy1, Throwable paramThrowable, ThrowableProxy paramThrowableProxy2) {
/*  32 */     StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
/*     */     
/*  34 */     int i = -1;
/*  35 */     if (paramThrowableProxy2 != null) {
/*  36 */       i = findNumberOfCommonFrames(arrayOfStackTraceElement, paramThrowableProxy2.getStackTraceElementProxyArray());
/*     */     }
/*     */     
/*  39 */     paramThrowableProxy1.commonFrames = i;
/*  40 */     paramThrowableProxy1.stackTraceElementProxyArray = steArrayToStepArray(arrayOfStackTraceElement);
/*     */   }
/*     */   
/*     */   static StackTraceElementProxy[] steArrayToStepArray(StackTraceElement[] paramArrayOfStackTraceElement) {
/*  44 */     if (paramArrayOfStackTraceElement == null) {
/*  45 */       return new StackTraceElementProxy[0];
/*     */     }
/*  47 */     StackTraceElementProxy[] arrayOfStackTraceElementProxy = new StackTraceElementProxy[paramArrayOfStackTraceElement.length];
/*  48 */     for (byte b = 0; b < arrayOfStackTraceElementProxy.length; b++) {
/*  49 */       arrayOfStackTraceElementProxy[b] = new StackTraceElementProxy(paramArrayOfStackTraceElement[b]);
/*     */     }
/*  51 */     return arrayOfStackTraceElementProxy;
/*     */   }
/*     */   
/*     */   static int findNumberOfCommonFrames(StackTraceElement[] paramArrayOfStackTraceElement, StackTraceElementProxy[] paramArrayOfStackTraceElementProxy) {
/*  55 */     if (paramArrayOfStackTraceElementProxy == null || paramArrayOfStackTraceElement == null) {
/*  56 */       return 0;
/*     */     }
/*     */     
/*  59 */     int i = paramArrayOfStackTraceElement.length - 1;
/*  60 */     int j = paramArrayOfStackTraceElementProxy.length - 1;
/*  61 */     byte b = 0;
/*  62 */     while (i >= 0 && j >= 0) {
/*  63 */       StackTraceElement stackTraceElement1 = paramArrayOfStackTraceElement[i];
/*  64 */       StackTraceElement stackTraceElement2 = (paramArrayOfStackTraceElementProxy[j]).ste;
/*  65 */       if (stackTraceElement1.equals(stackTraceElement2)) {
/*  66 */         b++;
/*     */ 
/*     */ 
/*     */         
/*  70 */         i--;
/*  71 */         j--;
/*     */       } 
/*  73 */     }  return b;
/*     */   }
/*     */   
/*     */   public static String asString(IThrowableProxy paramIThrowableProxy) {
/*  77 */     StringBuilder stringBuilder = new StringBuilder(2048);
/*     */     
/*  79 */     recursiveAppend(stringBuilder, null, 1, paramIThrowableProxy);
/*     */     
/*  81 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static void recursiveAppend(StringBuilder paramStringBuilder, String paramString, int paramInt, IThrowableProxy paramIThrowableProxy) {
/*  85 */     if (paramIThrowableProxy == null)
/*     */       return; 
/*  87 */     subjoinFirstLine(paramStringBuilder, paramString, paramInt, paramIThrowableProxy);
/*  88 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*  89 */     subjoinSTEPArray(paramStringBuilder, paramInt, paramIThrowableProxy);
/*  90 */     IThrowableProxy[] arrayOfIThrowableProxy = paramIThrowableProxy.getSuppressed();
/*  91 */     if (arrayOfIThrowableProxy != null) {
/*  92 */       for (IThrowableProxy iThrowableProxy : arrayOfIThrowableProxy) {
/*  93 */         recursiveAppend(paramStringBuilder, "Suppressed: ", paramInt + 1, iThrowableProxy);
/*     */       }
/*     */     }
/*  96 */     recursiveAppend(paramStringBuilder, "Caused by: ", paramInt, paramIThrowableProxy.getCause());
/*     */   }
/*     */   
/*     */   public static void indent(StringBuilder paramStringBuilder, int paramInt) {
/* 100 */     for (byte b = 0; b < paramInt; b++) {
/* 101 */       paramStringBuilder.append('\t');
/*     */     }
/*     */   }
/*     */   
/*     */   private static void subjoinFirstLine(StringBuilder paramStringBuilder, String paramString, int paramInt, IThrowableProxy paramIThrowableProxy) {
/* 106 */     indent(paramStringBuilder, paramInt - 1);
/* 107 */     if (paramString != null) {
/* 108 */       paramStringBuilder.append(paramString);
/*     */     }
/* 110 */     subjoinExceptionMessage(paramStringBuilder, paramIThrowableProxy);
/*     */   }
/*     */   
/*     */   public static void subjoinPackagingData(StringBuilder paramStringBuilder, StackTraceElementProxy paramStackTraceElementProxy) {
/* 114 */     if (paramStackTraceElementProxy != null) {
/* 115 */       ClassPackagingData classPackagingData = paramStackTraceElementProxy.getClassPackagingData();
/* 116 */       if (classPackagingData != null) {
/* 117 */         if (!classPackagingData.isExact()) {
/* 118 */           paramStringBuilder.append(" ~[");
/*     */         } else {
/* 120 */           paramStringBuilder.append(" [");
/*     */         } 
/*     */         
/* 123 */         paramStringBuilder.append(classPackagingData.getCodeLocation()).append(':').append(classPackagingData.getVersion()).append(']');
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void subjoinSTEP(StringBuilder paramStringBuilder, StackTraceElementProxy paramStackTraceElementProxy) {
/* 129 */     paramStringBuilder.append(paramStackTraceElementProxy.toString());
/* 130 */     subjoinPackagingData(paramStringBuilder, paramStackTraceElementProxy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void subjoinSTEPArray(StringBuilder paramStringBuilder, IThrowableProxy paramIThrowableProxy) {
/* 140 */     subjoinSTEPArray(paramStringBuilder, 1, paramIThrowableProxy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void subjoinSTEPArray(StringBuilder paramStringBuilder, int paramInt, IThrowableProxy paramIThrowableProxy) {
/* 149 */     StackTraceElementProxy[] arrayOfStackTraceElementProxy = paramIThrowableProxy.getStackTraceElementProxyArray();
/* 150 */     int i = paramIThrowableProxy.getCommonFrames();
/*     */     
/* 152 */     for (byte b = 0; b < arrayOfStackTraceElementProxy.length - i; b++) {
/* 153 */       StackTraceElementProxy stackTraceElementProxy = arrayOfStackTraceElementProxy[b];
/* 154 */       indent(paramStringBuilder, paramInt);
/* 155 */       subjoinSTEP(paramStringBuilder, stackTraceElementProxy);
/* 156 */       paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     } 
/*     */     
/* 159 */     if (i > 0) {
/* 160 */       indent(paramStringBuilder, paramInt);
/* 161 */       paramStringBuilder.append("... ").append(i).append(" common frames omitted").append(CoreConstants.LINE_SEPARATOR);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void subjoinFirstLine(StringBuilder paramStringBuilder, IThrowableProxy paramIThrowableProxy) {
/* 167 */     int i = paramIThrowableProxy.getCommonFrames();
/* 168 */     if (i > 0) {
/* 169 */       paramStringBuilder.append("Caused by: ");
/*     */     }
/* 171 */     subjoinExceptionMessage(paramStringBuilder, paramIThrowableProxy);
/*     */   }
/*     */   
/*     */   public static void subjoinFirstLineRootCauseFirst(StringBuilder paramStringBuilder, IThrowableProxy paramIThrowableProxy) {
/* 175 */     if (paramIThrowableProxy.getCause() != null) {
/* 176 */       paramStringBuilder.append("Wrapped by: ");
/*     */     }
/* 178 */     subjoinExceptionMessage(paramStringBuilder, paramIThrowableProxy);
/*     */   }
/*     */   
/*     */   private static void subjoinExceptionMessage(StringBuilder paramStringBuilder, IThrowableProxy paramIThrowableProxy) {
/* 182 */     paramStringBuilder.append(paramIThrowableProxy.getClassName()).append(": ").append(paramIThrowableProxy.getMessage());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\ThrowableProxyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */