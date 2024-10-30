/*     */ package ch.qos.logback.classic.pattern;
/*     */ 
/*     */ import ch.qos.logback.classic.spi.CallerData;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.boolex.EvaluationException;
/*     */ import ch.qos.logback.core.boolex.EventEvaluator;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CallerDataConverter
/*     */   extends ClassicConverter
/*     */ {
/*     */   public static final String DEFAULT_CALLER_LINE_PREFIX = "Caller+";
/*     */   public static final String DEFAULT_RANGE_DELIMITER = "..";
/*  40 */   private int depthStart = 0;
/*  41 */   private int depthEnd = 5;
/*  42 */   List<EventEvaluator<ILoggingEvent>> evaluatorList = null;
/*     */   
/*  44 */   final int MAX_ERROR_COUNT = 4;
/*  45 */   int errorCount = 0;
/*     */ 
/*     */   
/*     */   public void start() {
/*  49 */     String str = getFirstOption();
/*  50 */     if (str == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  55 */       if (isRange(str)) {
/*  56 */         String[] arrayOfString = splitRange(str);
/*  57 */         if (arrayOfString.length == 2) {
/*  58 */           this.depthStart = Integer.parseInt(arrayOfString[0]);
/*  59 */           this.depthEnd = Integer.parseInt(arrayOfString[1]);
/*  60 */           checkRange();
/*     */         } else {
/*  62 */           addError("Failed to parse depth option as range [" + str + "]");
/*     */         } 
/*     */       } else {
/*  65 */         this.depthEnd = Integer.parseInt(str);
/*     */       } 
/*  67 */     } catch (NumberFormatException numberFormatException) {
/*  68 */       addError("Failed to parse depth option [" + str + "]", numberFormatException);
/*     */     } 
/*     */     
/*  71 */     List<String> list = getOptionList();
/*     */     
/*  73 */     if (list != null && list.size() > 1) {
/*  74 */       int i = list.size();
/*  75 */       for (byte b = 1; b < i; b++) {
/*  76 */         String str1 = list.get(b);
/*  77 */         Context context = getContext();
/*  78 */         if (context != null) {
/*  79 */           Map map = (Map)context.getObject("EVALUATOR_MAP");
/*  80 */           EventEvaluator<ILoggingEvent> eventEvaluator = (EventEvaluator)map.get(str1);
/*  81 */           if (eventEvaluator != null) {
/*  82 */             addEvaluator(eventEvaluator);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean isRange(String paramString) {
/*  90 */     return paramString.contains(getDefaultRangeDelimiter());
/*     */   }
/*     */   
/*     */   private String[] splitRange(String paramString) {
/*  94 */     return paramString.split(Pattern.quote(getDefaultRangeDelimiter()), 2);
/*     */   }
/*     */   
/*     */   private void checkRange() {
/*  98 */     if (this.depthStart < 0 || this.depthEnd < 0) {
/*  99 */       addError("Invalid depthStart/depthEnd range [" + this.depthStart + ", " + this.depthEnd + "] (negative values are not allowed)");
/* 100 */     } else if (this.depthStart >= this.depthEnd) {
/* 101 */       addError("Invalid depthEnd range [" + this.depthStart + ", " + this.depthEnd + "] (start greater or equal to end)");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addEvaluator(EventEvaluator<ILoggingEvent> paramEventEvaluator) {
/* 106 */     if (this.evaluatorList == null) {
/* 107 */       this.evaluatorList = new ArrayList<EventEvaluator<ILoggingEvent>>();
/*     */     }
/* 109 */     this.evaluatorList.add(paramEventEvaluator);
/*     */   }
/*     */   
/*     */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 113 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 115 */     if (this.evaluatorList != null) {
/* 116 */       boolean bool = false;
/* 117 */       for (byte b = 0; b < this.evaluatorList.size(); b++) {
/* 118 */         EventEvaluator eventEvaluator = this.evaluatorList.get(b);
/*     */         try {
/* 120 */           if (eventEvaluator.evaluate(paramILoggingEvent)) {
/* 121 */             bool = true;
/*     */             break;
/*     */           } 
/* 124 */         } catch (EvaluationException evaluationException) {
/* 125 */           this.errorCount++;
/* 126 */           if (this.errorCount < 4) {
/* 127 */             addError("Exception thrown for evaluator named [" + eventEvaluator.getName() + "]", (Throwable)evaluationException);
/* 128 */           } else if (this.errorCount == 4) {
/* 129 */             ErrorStatus errorStatus = new ErrorStatus("Exception thrown for evaluator named [" + eventEvaluator.getName() + "].", this, (Throwable)evaluationException);
/* 130 */             errorStatus.add((Status)new ErrorStatus("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
/*     */             
/* 132 */             addStatus((Status)errorStatus);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 138 */       if (!bool) {
/* 139 */         return "";
/*     */       }
/*     */     } 
/*     */     
/* 143 */     StackTraceElement[] arrayOfStackTraceElement = paramILoggingEvent.getCallerData();
/* 144 */     if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length > this.depthStart) {
/* 145 */       int i = (this.depthEnd < arrayOfStackTraceElement.length) ? this.depthEnd : arrayOfStackTraceElement.length;
/*     */       
/* 147 */       for (int j = this.depthStart; j < i; j++) {
/* 148 */         stringBuilder.append(getCallerLinePrefix());
/* 149 */         stringBuilder.append(j);
/* 150 */         stringBuilder.append("\t at ");
/* 151 */         stringBuilder.append(arrayOfStackTraceElement[j]);
/* 152 */         stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */       } 
/* 154 */       return stringBuilder.toString();
/*     */     } 
/* 156 */     return CallerData.CALLER_DATA_NA;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getCallerLinePrefix() {
/* 161 */     return "Caller+";
/*     */   }
/*     */   
/*     */   protected String getDefaultRangeDelimiter() {
/* 165 */     return "..";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\CallerDataConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */