/*     */ package ch.qos.logback.classic.net;
/*     */ 
/*     */ import ch.qos.logback.classic.PatternLayout;
/*     */ import ch.qos.logback.classic.pattern.SyslogStartConverter;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.classic.spi.IThrowableProxy;
/*     */ import ch.qos.logback.classic.spi.StackTraceElementProxy;
/*     */ import ch.qos.logback.classic.util.LevelToSyslogSeverity;
/*     */ import ch.qos.logback.core.Layout;
/*     */ import ch.qos.logback.core.net.SyslogAppenderBase;
/*     */ import ch.qos.logback.core.net.SyslogOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.net.SocketException;
/*     */ import java.net.UnknownHostException;
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
/*     */ public class SyslogAppender
/*     */   extends SyslogAppenderBase<ILoggingEvent>
/*     */ {
/*     */   public static final String DEFAULT_SUFFIX_PATTERN = "[%thread] %logger %msg";
/*     */   public static final String DEFAULT_STACKTRACE_PATTERN = "\t";
/*  44 */   PatternLayout stackTraceLayout = new PatternLayout();
/*  45 */   String stackTracePattern = "\t";
/*     */   
/*     */   boolean throwableExcluded = false;
/*     */   
/*     */   public void start() {
/*  50 */     super.start();
/*  51 */     setupStackTraceLayout();
/*     */   }
/*     */   
/*     */   String getPrefixPattern() {
/*  55 */     return "%syslogStart{" + getFacility() + "}%nopex{}";
/*     */   }
/*     */ 
/*     */   
/*     */   public SyslogOutputStream createOutputStream() throws SocketException, UnknownHostException {
/*  60 */     return new SyslogOutputStream(getSyslogHost(), getPort());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSeverityForEvent(Object paramObject) {
/*  71 */     ILoggingEvent iLoggingEvent = (ILoggingEvent)paramObject;
/*  72 */     return LevelToSyslogSeverity.convert(iLoggingEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void postProcess(Object paramObject, OutputStream paramOutputStream) {
/*  77 */     if (this.throwableExcluded) {
/*     */       return;
/*     */     }
/*  80 */     ILoggingEvent iLoggingEvent = (ILoggingEvent)paramObject;
/*  81 */     IThrowableProxy iThrowableProxy = iLoggingEvent.getThrowableProxy();
/*     */     
/*  83 */     if (iThrowableProxy == null) {
/*     */       return;
/*     */     }
/*  86 */     String str = this.stackTraceLayout.doLayout(iLoggingEvent);
/*  87 */     boolean bool = true;
/*  88 */     while (iThrowableProxy != null) {
/*  89 */       StackTraceElementProxy[] arrayOfStackTraceElementProxy = iThrowableProxy.getStackTraceElementProxyArray();
/*     */       try {
/*  91 */         handleThrowableFirstLine(paramOutputStream, iThrowableProxy, str, bool);
/*  92 */         bool = false;
/*  93 */         for (StackTraceElementProxy stackTraceElementProxy : arrayOfStackTraceElementProxy) {
/*  94 */           StringBuilder stringBuilder = new StringBuilder();
/*  95 */           stringBuilder.append(str).append(stackTraceElementProxy);
/*  96 */           paramOutputStream.write(stringBuilder.toString().getBytes());
/*  97 */           paramOutputStream.flush();
/*     */         } 
/*  99 */       } catch (IOException iOException) {
/*     */         break;
/*     */       } 
/* 102 */       iThrowableProxy = iThrowableProxy.getCause();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void handleThrowableFirstLine(OutputStream paramOutputStream, IThrowableProxy paramIThrowableProxy, String paramString, boolean paramBoolean) throws IOException {
/* 108 */     StringBuilder stringBuilder = (new StringBuilder()).append(paramString);
/*     */     
/* 110 */     if (!paramBoolean) {
/* 111 */       stringBuilder.append("Caused by: ");
/*     */     }
/* 113 */     stringBuilder.append(paramIThrowableProxy.getClassName()).append(": ").append(paramIThrowableProxy.getMessage());
/* 114 */     paramOutputStream.write(stringBuilder.toString().getBytes());
/* 115 */     paramOutputStream.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   boolean stackTraceHeaderLine(StringBuilder paramStringBuilder, boolean paramBoolean) {
/* 120 */     return false;
/*     */   }
/*     */   
/*     */   public Layout<ILoggingEvent> buildLayout() {
/* 124 */     PatternLayout patternLayout = new PatternLayout();
/* 125 */     patternLayout.getInstanceConverterMap().put("syslogStart", SyslogStartConverter.class.getName());
/* 126 */     if (this.suffixPattern == null) {
/* 127 */       this.suffixPattern = "[%thread] %logger %msg";
/*     */     }
/* 129 */     patternLayout.setPattern(getPrefixPattern() + this.suffixPattern);
/* 130 */     patternLayout.setContext(getContext());
/* 131 */     patternLayout.start();
/* 132 */     return (Layout<ILoggingEvent>)patternLayout;
/*     */   }
/*     */   
/*     */   private void setupStackTraceLayout() {
/* 136 */     this.stackTraceLayout.getInstanceConverterMap().put("syslogStart", SyslogStartConverter.class.getName());
/*     */     
/* 138 */     this.stackTraceLayout.setPattern(getPrefixPattern() + this.stackTracePattern);
/* 139 */     this.stackTraceLayout.setContext(getContext());
/* 140 */     this.stackTraceLayout.start();
/*     */   }
/*     */   
/*     */   public boolean isThrowableExcluded() {
/* 144 */     return this.throwableExcluded;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThrowableExcluded(boolean paramBoolean) {
/* 155 */     this.throwableExcluded = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStackTracePattern() {
/* 165 */     return this.stackTracePattern;
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
/*     */   public void setStackTracePattern(String paramString) {
/* 178 */     this.stackTracePattern = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\SyslogAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */