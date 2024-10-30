/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.helpers.ThrowableToStringArray;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusManager;
/*     */ import ch.qos.logback.core.status.StatusUtil;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Iterator;
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
/*     */ public class StatusPrinter
/*     */ {
/*  29 */   private static PrintStream ps = System.out;
/*     */   
/*  31 */   static CachingDateFormatter cachingDateFormat = new CachingDateFormatter("HH:mm:ss,SSS");
/*     */   
/*     */   public static void setPrintStream(PrintStream paramPrintStream) {
/*  34 */     ps = paramPrintStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printInCaseOfErrorsOrWarnings(Context paramContext) {
/*  44 */     printInCaseOfErrorsOrWarnings(paramContext, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printInCaseOfErrorsOrWarnings(Context paramContext, long paramLong) {
/*  54 */     if (paramContext == null) {
/*  55 */       throw new IllegalArgumentException("Context argument cannot be null");
/*     */     }
/*     */     
/*  58 */     StatusManager statusManager = paramContext.getStatusManager();
/*  59 */     if (statusManager == null) {
/*  60 */       ps.println("WARN: Context named \"" + paramContext.getName() + "\" has no status manager");
/*     */     } else {
/*  62 */       StatusUtil statusUtil = new StatusUtil(paramContext);
/*  63 */       if (statusUtil.getHighestLevel(paramLong) >= 1) {
/*  64 */         print(statusManager, paramLong);
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
/*     */   public static void printIfErrorsOccured(Context paramContext) {
/*  76 */     if (paramContext == null) {
/*  77 */       throw new IllegalArgumentException("Context argument cannot be null");
/*     */     }
/*     */     
/*  80 */     StatusManager statusManager = paramContext.getStatusManager();
/*  81 */     if (statusManager == null) {
/*  82 */       ps.println("WARN: Context named \"" + paramContext.getName() + "\" has no status manager");
/*     */     } else {
/*  84 */       StatusUtil statusUtil = new StatusUtil(paramContext);
/*  85 */       if (statusUtil.getHighestLevel(0L) == 2) {
/*  86 */         print(statusManager);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void print(Context paramContext) {
/*  97 */     print(paramContext, 0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void print(Context paramContext, long paramLong) {
/* 105 */     if (paramContext == null) {
/* 106 */       throw new IllegalArgumentException("Context argument cannot be null");
/*     */     }
/*     */     
/* 109 */     StatusManager statusManager = paramContext.getStatusManager();
/* 110 */     if (statusManager == null) {
/* 111 */       ps.println("WARN: Context named \"" + paramContext.getName() + "\" has no status manager");
/*     */     } else {
/* 113 */       print(statusManager, paramLong);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void print(StatusManager paramStatusManager) {
/* 118 */     print(paramStatusManager, 0L);
/*     */   }
/*     */   
/*     */   public static void print(StatusManager paramStatusManager, long paramLong) {
/* 122 */     StringBuilder stringBuilder = new StringBuilder();
/* 123 */     List<Status> list = StatusUtil.filterStatusListByTimeThreshold(paramStatusManager.getCopyOfStatusList(), paramLong);
/* 124 */     buildStrFromStatusList(stringBuilder, list);
/* 125 */     ps.println(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public static void print(List<Status> paramList) {
/* 129 */     StringBuilder stringBuilder = new StringBuilder();
/* 130 */     buildStrFromStatusList(stringBuilder, paramList);
/* 131 */     ps.println(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   private static void buildStrFromStatusList(StringBuilder paramStringBuilder, List<Status> paramList) {
/* 135 */     if (paramList == null)
/*     */       return; 
/* 137 */     for (Status status : paramList) {
/* 138 */       buildStr(paramStringBuilder, "", status);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void appendThrowable(StringBuilder paramStringBuilder, Throwable paramThrowable) {
/* 146 */     String[] arrayOfString = ThrowableToStringArray.convert(paramThrowable);
/*     */     
/* 148 */     for (String str : arrayOfString) {
/* 149 */       if (!str.startsWith("Caused by: "))
/*     */       {
/* 151 */         if (Character.isDigit(str.charAt(0))) {
/*     */           
/* 153 */           paramStringBuilder.append("\t... ");
/*     */         } else {
/*     */           
/* 156 */           paramStringBuilder.append("\tat ");
/*     */         }  } 
/* 158 */       paramStringBuilder.append(str).append(CoreConstants.LINE_SEPARATOR);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void buildStr(StringBuilder paramStringBuilder, String paramString, Status paramStatus) {
/*     */     String str;
/* 164 */     if (paramStatus.hasChildren()) {
/* 165 */       str = paramString + "+ ";
/*     */     } else {
/* 167 */       str = paramString + "|-";
/*     */     } 
/*     */     
/* 170 */     if (cachingDateFormat != null) {
/* 171 */       String str1 = cachingDateFormat.format(paramStatus.getDate().longValue());
/* 172 */       paramStringBuilder.append(str1).append(" ");
/*     */     } 
/* 174 */     paramStringBuilder.append(str).append(paramStatus).append(CoreConstants.LINE_SEPARATOR);
/*     */     
/* 176 */     if (paramStatus.getThrowable() != null) {
/* 177 */       appendThrowable(paramStringBuilder, paramStatus.getThrowable());
/*     */     }
/* 179 */     if (paramStatus.hasChildren()) {
/* 180 */       Iterator<Status> iterator = paramStatus.iterator();
/* 181 */       while (iterator.hasNext()) {
/* 182 */         Status status = iterator.next();
/* 183 */         buildStr(paramStringBuilder, paramString + "  ", status);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\StatusPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */