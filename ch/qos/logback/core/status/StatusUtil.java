/*     */ package ch.qos.logback.core.status;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class StatusUtil
/*     */ {
/*     */   StatusManager sm;
/*     */   
/*     */   public StatusUtil(StatusManager paramStatusManager) {
/*  30 */     this.sm = paramStatusManager;
/*     */   }
/*     */   
/*     */   public StatusUtil(Context paramContext) {
/*  34 */     this.sm = paramContext.getStatusManager();
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
/*     */   
/*     */   public static boolean contextHasStatusListener(Context paramContext) {
/*  47 */     StatusManager statusManager = paramContext.getStatusManager();
/*  48 */     if (statusManager == null)
/*  49 */       return false; 
/*  50 */     List<StatusListener> list = statusManager.getCopyOfStatusListenerList();
/*  51 */     if (list == null || list.size() == 0) {
/*  52 */       return false;
/*     */     }
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public static List<Status> filterStatusListByTimeThreshold(List<Status> paramList, long paramLong) {
/*  58 */     ArrayList<Status> arrayList = new ArrayList();
/*  59 */     for (Status status : paramList) {
/*  60 */       if (status.getDate().longValue() >= paramLong)
/*  61 */         arrayList.add(status); 
/*     */     } 
/*  63 */     return arrayList;
/*     */   }
/*     */   
/*     */   public void addStatus(Status paramStatus) {
/*  67 */     if (this.sm != null) {
/*  68 */       this.sm.add(paramStatus);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addInfo(Object paramObject, String paramString) {
/*  73 */     addStatus(new InfoStatus(paramString, paramObject));
/*     */   }
/*     */   
/*     */   public void addWarn(Object paramObject, String paramString) {
/*  77 */     addStatus(new WarnStatus(paramString, paramObject));
/*     */   }
/*     */   
/*     */   public void addError(Object paramObject, String paramString, Throwable paramThrowable) {
/*  81 */     addStatus(new ErrorStatus(paramString, paramObject, paramThrowable));
/*     */   }
/*     */   
/*     */   public boolean hasXMLParsingErrors(long paramLong) {
/*  85 */     return containsMatch(paramLong, 2, "XML_PARSING");
/*     */   }
/*     */   
/*     */   public boolean noXMLParsingErrorsOccurred(long paramLong) {
/*  89 */     return !hasXMLParsingErrors(paramLong);
/*     */   }
/*     */   
/*     */   public int getHighestLevel(long paramLong) {
/*  93 */     List<Status> list = filterStatusListByTimeThreshold(this.sm.getCopyOfStatusList(), paramLong);
/*  94 */     int i = 0;
/*  95 */     for (Status status : list) {
/*  96 */       if (status.getLevel() > i)
/*  97 */         i = status.getLevel(); 
/*     */     } 
/*  99 */     return i;
/*     */   }
/*     */   
/*     */   public boolean isErrorFree(long paramLong) {
/* 103 */     return (2 > getHighestLevel(paramLong));
/*     */   }
/*     */   
/*     */   public boolean isWarningOrErrorFree(long paramLong) {
/* 107 */     return (1 > getHighestLevel(paramLong));
/*     */   }
/*     */   
/*     */   public boolean containsMatch(long paramLong, int paramInt, String paramString) {
/* 111 */     List<Status> list = filterStatusListByTimeThreshold(this.sm.getCopyOfStatusList(), paramLong);
/* 112 */     Pattern pattern = Pattern.compile(paramString);
/*     */     
/* 114 */     for (Status status : list) {
/* 115 */       if (paramInt != status.getLevel()) {
/*     */         continue;
/*     */       }
/* 118 */       String str = status.getMessage();
/* 119 */       Matcher matcher = pattern.matcher(str);
/* 120 */       if (matcher.lookingAt()) {
/* 121 */         return true;
/*     */       }
/*     */     } 
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   public boolean containsMatch(int paramInt, String paramString) {
/* 128 */     return containsMatch(0L, paramInt, paramString);
/*     */   }
/*     */   
/*     */   public boolean containsMatch(String paramString) {
/* 132 */     Pattern pattern = Pattern.compile(paramString);
/* 133 */     for (Status status : this.sm.getCopyOfStatusList()) {
/* 134 */       String str = status.getMessage();
/* 135 */       Matcher matcher = pattern.matcher(str);
/* 136 */       if (matcher.lookingAt()) {
/* 137 */         return true;
/*     */       }
/*     */     } 
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   public int matchCount(String paramString) {
/* 144 */     byte b = 0;
/* 145 */     Pattern pattern = Pattern.compile(paramString);
/* 146 */     for (Status status : this.sm.getCopyOfStatusList()) {
/* 147 */       String str = status.getMessage();
/* 148 */       Matcher matcher = pattern.matcher(str);
/* 149 */       if (matcher.lookingAt()) {
/* 150 */         b++;
/*     */       }
/*     */     } 
/* 153 */     return b;
/*     */   }
/*     */   
/*     */   public boolean containsException(Class<?> paramClass) {
/* 157 */     Iterator<Status> iterator = this.sm.getCopyOfStatusList().iterator();
/* 158 */     while (iterator.hasNext()) {
/* 159 */       Status status = iterator.next();
/* 160 */       Throwable throwable = status.getThrowable();
/* 161 */       while (throwable != null) {
/* 162 */         if (throwable.getClass().getName().equals(paramClass.getName())) {
/* 163 */           return true;
/*     */         }
/* 165 */         throwable = throwable.getCause();
/*     */       } 
/*     */     } 
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long timeOfLastReset() {
/* 177 */     List<Status> list = this.sm.getCopyOfStatusList();
/* 178 */     if (list == null) {
/* 179 */       return -1L;
/*     */     }
/* 181 */     int i = list.size();
/* 182 */     for (int j = i - 1; j >= 0; j--) {
/* 183 */       Status status = list.get(j);
/* 184 */       if ("Will reset and reconfigure context ".equals(status.getMessage())) {
/* 185 */         return status.getDate().longValue();
/*     */       }
/*     */     } 
/* 188 */     return -1L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\status\StatusUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */