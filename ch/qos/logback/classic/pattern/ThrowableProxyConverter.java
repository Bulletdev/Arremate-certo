/*     */ package ch.qos.logback.classic.pattern;
/*     */ 
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.classic.spi.IThrowableProxy;
/*     */ import ch.qos.logback.classic.spi.StackTraceElementProxy;
/*     */ import ch.qos.logback.classic.spi.ThrowableProxyUtil;
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.boolex.EvaluationException;
/*     */ import ch.qos.logback.core.boolex.EventEvaluator;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class ThrowableProxyConverter
/*     */   extends ThrowableHandlingConverter
/*     */ {
/*     */   protected static final int BUILDER_CAPACITY = 2048;
/*     */   int lengthOption;
/*  40 */   List<EventEvaluator<ILoggingEvent>> evaluatorList = null;
/*  41 */   List<String> ignoredStackTraceLines = null;
/*     */   
/*  43 */   int errorCount = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  48 */     String str = getFirstOption();
/*     */     
/*  50 */     if (str == null) {
/*  51 */       this.lengthOption = Integer.MAX_VALUE;
/*     */     } else {
/*  53 */       str = str.toLowerCase();
/*  54 */       if ("full".equals(str)) {
/*  55 */         this.lengthOption = Integer.MAX_VALUE;
/*  56 */       } else if ("short".equals(str)) {
/*  57 */         this.lengthOption = 1;
/*     */       } else {
/*     */         try {
/*  60 */           this.lengthOption = Integer.parseInt(str);
/*  61 */         } catch (NumberFormatException numberFormatException) {
/*  62 */           addError("Could not parse [" + str + "] as an integer");
/*  63 */           this.lengthOption = Integer.MAX_VALUE;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  68 */     List<String> list = getOptionList();
/*     */     
/*  70 */     if (list != null && list.size() > 1) {
/*  71 */       int i = list.size();
/*  72 */       for (byte b = 1; b < i; b++) {
/*  73 */         String str1 = list.get(b);
/*  74 */         Context context = getContext();
/*  75 */         Map map = (Map)context.getObject("EVALUATOR_MAP");
/*  76 */         EventEvaluator<ILoggingEvent> eventEvaluator = (EventEvaluator)map.get(str1);
/*  77 */         if (eventEvaluator != null) {
/*  78 */           addEvaluator(eventEvaluator);
/*     */         } else {
/*  80 */           addIgnoreStackTraceLine(str1);
/*     */         } 
/*     */       } 
/*     */     } 
/*  84 */     super.start();
/*     */   }
/*     */   
/*     */   private void addEvaluator(EventEvaluator<ILoggingEvent> paramEventEvaluator) {
/*  88 */     if (this.evaluatorList == null) {
/*  89 */       this.evaluatorList = new ArrayList<EventEvaluator<ILoggingEvent>>();
/*     */     }
/*  91 */     this.evaluatorList.add(paramEventEvaluator);
/*     */   }
/*     */   
/*     */   private void addIgnoreStackTraceLine(String paramString) {
/*  95 */     if (this.ignoredStackTraceLines == null) {
/*  96 */       this.ignoredStackTraceLines = new ArrayList<String>();
/*     */     }
/*  98 */     this.ignoredStackTraceLines.add(paramString);
/*     */   }
/*     */   
/*     */   public void stop() {
/* 102 */     this.evaluatorList = null;
/* 103 */     super.stop();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void extraData(StringBuilder paramStringBuilder, StackTraceElementProxy paramStackTraceElementProxy) {}
/*     */ 
/*     */   
/*     */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 112 */     IThrowableProxy iThrowableProxy = paramILoggingEvent.getThrowableProxy();
/* 113 */     if (iThrowableProxy == null) {
/* 114 */       return "";
/*     */     }
/*     */ 
/*     */     
/* 118 */     if (this.evaluatorList != null) {
/* 119 */       boolean bool = true;
/* 120 */       for (byte b = 0; b < this.evaluatorList.size(); b++) {
/* 121 */         EventEvaluator eventEvaluator = this.evaluatorList.get(b);
/*     */         try {
/* 123 */           if (eventEvaluator.evaluate(paramILoggingEvent)) {
/* 124 */             bool = false;
/*     */             break;
/*     */           } 
/* 127 */         } catch (EvaluationException evaluationException) {
/* 128 */           this.errorCount++;
/* 129 */           if (this.errorCount < 4) {
/* 130 */             addError("Exception thrown for evaluator named [" + eventEvaluator.getName() + "]", (Throwable)evaluationException);
/* 131 */           } else if (this.errorCount == 4) {
/* 132 */             ErrorStatus errorStatus = new ErrorStatus("Exception thrown for evaluator named [" + eventEvaluator.getName() + "].", this, (Throwable)evaluationException);
/* 133 */             errorStatus.add((Status)new ErrorStatus("This was the last warning about this evaluator's errors.We don't want the StatusManager to get flooded.", this));
/*     */             
/* 135 */             addStatus((Status)errorStatus);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 140 */       if (!bool) {
/* 141 */         return "";
/*     */       }
/*     */     } 
/*     */     
/* 145 */     return throwableProxyToString(iThrowableProxy);
/*     */   }
/*     */   
/*     */   protected String throwableProxyToString(IThrowableProxy paramIThrowableProxy) {
/* 149 */     StringBuilder stringBuilder = new StringBuilder(2048);
/*     */     
/* 151 */     recursiveAppend(stringBuilder, (String)null, 1, paramIThrowableProxy);
/*     */     
/* 153 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void recursiveAppend(StringBuilder paramStringBuilder, String paramString, int paramInt, IThrowableProxy paramIThrowableProxy) {
/* 157 */     if (paramIThrowableProxy == null)
/*     */       return; 
/* 159 */     subjoinFirstLine(paramStringBuilder, paramString, paramInt, paramIThrowableProxy);
/* 160 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 161 */     subjoinSTEPArray(paramStringBuilder, paramInt, paramIThrowableProxy);
/* 162 */     IThrowableProxy[] arrayOfIThrowableProxy = paramIThrowableProxy.getSuppressed();
/* 163 */     if (arrayOfIThrowableProxy != null) {
/* 164 */       for (IThrowableProxy iThrowableProxy : arrayOfIThrowableProxy) {
/* 165 */         recursiveAppend(paramStringBuilder, "Suppressed: ", paramInt + 1, iThrowableProxy);
/*     */       }
/*     */     }
/* 168 */     recursiveAppend(paramStringBuilder, "Caused by: ", paramInt, paramIThrowableProxy.getCause());
/*     */   }
/*     */   
/*     */   private void subjoinFirstLine(StringBuilder paramStringBuilder, String paramString, int paramInt, IThrowableProxy paramIThrowableProxy) {
/* 172 */     ThrowableProxyUtil.indent(paramStringBuilder, paramInt - 1);
/* 173 */     if (paramString != null) {
/* 174 */       paramStringBuilder.append(paramString);
/*     */     }
/* 176 */     subjoinExceptionMessage(paramStringBuilder, paramIThrowableProxy);
/*     */   }
/*     */   
/*     */   private void subjoinExceptionMessage(StringBuilder paramStringBuilder, IThrowableProxy paramIThrowableProxy) {
/* 180 */     paramStringBuilder.append(paramIThrowableProxy.getClassName()).append(": ").append(paramIThrowableProxy.getMessage());
/*     */   }
/*     */   
/*     */   protected void subjoinSTEPArray(StringBuilder paramStringBuilder, int paramInt, IThrowableProxy paramIThrowableProxy) {
/* 184 */     StackTraceElementProxy[] arrayOfStackTraceElementProxy = paramIThrowableProxy.getStackTraceElementProxyArray();
/* 185 */     int i = paramIThrowableProxy.getCommonFrames();
/*     */     
/* 187 */     boolean bool = (this.lengthOption > arrayOfStackTraceElementProxy.length) ? true : false;
/*     */     
/* 189 */     int j = bool ? arrayOfStackTraceElementProxy.length : this.lengthOption;
/* 190 */     if (i > 0 && bool) {
/* 191 */       j -= i;
/*     */     }
/*     */     
/* 194 */     byte b1 = 0;
/* 195 */     for (byte b2 = 0; b2 < j; b2++) {
/* 196 */       StackTraceElementProxy stackTraceElementProxy = arrayOfStackTraceElementProxy[b2];
/* 197 */       if (!isIgnoredStackTraceLine(stackTraceElementProxy.toString())) {
/* 198 */         ThrowableProxyUtil.indent(paramStringBuilder, paramInt);
/* 199 */         printStackLine(paramStringBuilder, b1, stackTraceElementProxy);
/* 200 */         b1 = 0;
/* 201 */         paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */       } else {
/* 203 */         b1++;
/* 204 */         if (j < arrayOfStackTraceElementProxy.length) {
/* 205 */           j++;
/*     */         }
/*     */       } 
/*     */     } 
/* 209 */     if (b1 > 0) {
/* 210 */       printIgnoredCount(paramStringBuilder, b1);
/* 211 */       paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     } 
/*     */     
/* 214 */     if (i > 0 && bool) {
/* 215 */       ThrowableProxyUtil.indent(paramStringBuilder, paramInt);
/* 216 */       paramStringBuilder.append("... ").append(paramIThrowableProxy.getCommonFrames()).append(" common frames omitted").append(CoreConstants.LINE_SEPARATOR);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void printStackLine(StringBuilder paramStringBuilder, int paramInt, StackTraceElementProxy paramStackTraceElementProxy) {
/* 221 */     paramStringBuilder.append(paramStackTraceElementProxy);
/* 222 */     extraData(paramStringBuilder, paramStackTraceElementProxy);
/* 223 */     if (paramInt > 0) {
/* 224 */       printIgnoredCount(paramStringBuilder, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   private void printIgnoredCount(StringBuilder paramStringBuilder, int paramInt) {
/* 229 */     paramStringBuilder.append(" [").append(paramInt).append(" skipped]");
/*     */   }
/*     */   
/*     */   private boolean isIgnoredStackTraceLine(String paramString) {
/* 233 */     if (this.ignoredStackTraceLines != null) {
/* 234 */       for (String str : this.ignoredStackTraceLines) {
/* 235 */         if (paramString.contains(str)) {
/* 236 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 240 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\ThrowableProxyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */