/*     */ package ch.qos.logback.classic.net;
/*     */ 
/*     */ import ch.qos.logback.classic.ClassicConstants;
/*     */ import ch.qos.logback.classic.PatternLayout;
/*     */ import ch.qos.logback.classic.boolex.OnErrorEvaluator;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.core.Layout;
/*     */ import ch.qos.logback.core.boolex.EventEvaluator;
/*     */ import ch.qos.logback.core.helpers.CyclicBuffer;
/*     */ import ch.qos.logback.core.net.SMTPAppenderBase;
/*     */ import ch.qos.logback.core.pattern.PatternLayoutBase;
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
/*     */ public class SMTPAppender
/*     */   extends SMTPAppenderBase<ILoggingEvent>
/*     */ {
/*     */   static final String DEFAULT_SUBJECT_PATTERN = "%logger{20} - %m";
/*  42 */   private int bufferSize = 512;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean includeCallerData = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  55 */     if (this.eventEvaluator == null) {
/*  56 */       OnErrorEvaluator onErrorEvaluator = new OnErrorEvaluator();
/*  57 */       onErrorEvaluator.setContext(getContext());
/*  58 */       onErrorEvaluator.setName("onError");
/*  59 */       onErrorEvaluator.start();
/*  60 */       this.eventEvaluator = (EventEvaluator)onErrorEvaluator;
/*     */     } 
/*  62 */     super.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SMTPAppender(EventEvaluator<ILoggingEvent> paramEventEvaluator) {
/*  70 */     this.eventEvaluator = paramEventEvaluator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void subAppend(CyclicBuffer<ILoggingEvent> paramCyclicBuffer, ILoggingEvent paramILoggingEvent) {
/*  78 */     if (this.includeCallerData) {
/*  79 */       paramILoggingEvent.getCallerData();
/*     */     }
/*  81 */     paramILoggingEvent.prepareForDeferredProcessing();
/*  82 */     paramCyclicBuffer.add(paramILoggingEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void fillBuffer(CyclicBuffer<ILoggingEvent> paramCyclicBuffer, StringBuffer paramStringBuffer) {
/*  87 */     int i = paramCyclicBuffer.length();
/*  88 */     for (byte b = 0; b < i; b++) {
/*  89 */       ILoggingEvent iLoggingEvent = (ILoggingEvent)paramCyclicBuffer.get();
/*  90 */       paramStringBuffer.append(this.layout.doLayout(iLoggingEvent));
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean eventMarksEndOfLife(ILoggingEvent paramILoggingEvent) {
/*  95 */     Marker marker = paramILoggingEvent.getMarker();
/*  96 */     if (marker == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     return marker.contains(ClassicConstants.FINALIZE_SESSION_MARKER);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Layout<ILoggingEvent> makeSubjectLayout(String paramString) {
/* 104 */     if (paramString == null) {
/* 105 */       paramString = "%logger{20} - %m";
/*     */     }
/* 107 */     PatternLayout patternLayout = new PatternLayout();
/* 108 */     patternLayout.setContext(getContext());
/* 109 */     patternLayout.setPattern(paramString);
/*     */ 
/*     */ 
/*     */     
/* 113 */     patternLayout.setPostCompileProcessor(null);
/* 114 */     patternLayout.start();
/* 115 */     return (Layout<ILoggingEvent>)patternLayout;
/*     */   }
/*     */   
/*     */   protected PatternLayout makeNewToPatternLayout(String paramString) {
/* 119 */     PatternLayout patternLayout = new PatternLayout();
/* 120 */     patternLayout.setPattern(paramString + "%nopex");
/* 121 */     return patternLayout;
/*     */   }
/*     */   
/*     */   public boolean isIncludeCallerData() {
/* 125 */     return this.includeCallerData;
/*     */   }
/*     */   
/*     */   public void setIncludeCallerData(boolean paramBoolean) {
/* 129 */     this.includeCallerData = paramBoolean;
/*     */   }
/*     */   
/*     */   public SMTPAppender() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\SMTPAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */