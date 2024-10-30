/*     */ package ch.qos.logback.classic.boolex;
/*     */ 
/*     */ import ch.qos.logback.classic.Level;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.classic.spi.IThrowableProxy;
/*     */ import ch.qos.logback.classic.spi.LoggerContextVO;
/*     */ import ch.qos.logback.classic.spi.ThrowableProxy;
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.boolex.JaninoEventEvaluatorBase;
/*     */ import ch.qos.logback.core.boolex.Matcher;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class JaninoEventEvaluator
/*     */   extends JaninoEventEvaluatorBase<ILoggingEvent>
/*     */ {
/*     */   public static final String IMPORT_LEVEL = "import ch.qos.logback.classic.Level;\r\n";
/*  35 */   public static final List<String> DEFAULT_PARAM_NAME_LIST = new ArrayList<String>();
/*  36 */   public static final List<Class> DEFAULT_PARAM_TYPE_LIST = (List)new ArrayList<Class<?>>();
/*     */   
/*     */   static {
/*  39 */     DEFAULT_PARAM_NAME_LIST.add("DEBUG");
/*  40 */     DEFAULT_PARAM_NAME_LIST.add("INFO");
/*  41 */     DEFAULT_PARAM_NAME_LIST.add("WARN");
/*  42 */     DEFAULT_PARAM_NAME_LIST.add("ERROR");
/*     */     
/*  44 */     DEFAULT_PARAM_NAME_LIST.add("event");
/*  45 */     DEFAULT_PARAM_NAME_LIST.add("message");
/*     */     
/*  47 */     DEFAULT_PARAM_NAME_LIST.add("formattedMessage");
/*  48 */     DEFAULT_PARAM_NAME_LIST.add("logger");
/*  49 */     DEFAULT_PARAM_NAME_LIST.add("loggerContext");
/*  50 */     DEFAULT_PARAM_NAME_LIST.add("level");
/*  51 */     DEFAULT_PARAM_NAME_LIST.add("timeStamp");
/*  52 */     DEFAULT_PARAM_NAME_LIST.add("marker");
/*  53 */     DEFAULT_PARAM_NAME_LIST.add("mdc");
/*  54 */     DEFAULT_PARAM_NAME_LIST.add("throwableProxy");
/*  55 */     DEFAULT_PARAM_NAME_LIST.add("throwable");
/*     */     
/*  57 */     DEFAULT_PARAM_TYPE_LIST.add(int.class);
/*  58 */     DEFAULT_PARAM_TYPE_LIST.add(int.class);
/*  59 */     DEFAULT_PARAM_TYPE_LIST.add(int.class);
/*  60 */     DEFAULT_PARAM_TYPE_LIST.add(int.class);
/*     */     
/*  62 */     DEFAULT_PARAM_TYPE_LIST.add(ILoggingEvent.class);
/*  63 */     DEFAULT_PARAM_TYPE_LIST.add(String.class);
/*  64 */     DEFAULT_PARAM_TYPE_LIST.add(String.class);
/*  65 */     DEFAULT_PARAM_TYPE_LIST.add(String.class);
/*  66 */     DEFAULT_PARAM_TYPE_LIST.add(LoggerContextVO.class);
/*  67 */     DEFAULT_PARAM_TYPE_LIST.add(int.class);
/*  68 */     DEFAULT_PARAM_TYPE_LIST.add(long.class);
/*  69 */     DEFAULT_PARAM_TYPE_LIST.add(Marker.class);
/*  70 */     DEFAULT_PARAM_TYPE_LIST.add(Map.class);
/*  71 */     DEFAULT_PARAM_TYPE_LIST.add(IThrowableProxy.class);
/*  72 */     DEFAULT_PARAM_TYPE_LIST.add(Throwable.class);
/*     */   }
/*     */   
/*     */   protected String getDecoratedExpression() {
/*  76 */     String str = getExpression();
/*  77 */     if (!str.contains("return")) {
/*  78 */       str = "return " + str + ";";
/*  79 */       addInfo("Adding [return] prefix and a semicolon suffix. Expression becomes [" + str + "]");
/*  80 */       addInfo("See also http://logback.qos.ch/codes.html#block");
/*     */     } 
/*     */     
/*  83 */     return "import ch.qos.logback.classic.Level;\r\n" + str;
/*     */   }
/*     */   
/*     */   protected String[] getParameterNames() {
/*  87 */     ArrayList<String> arrayList = new ArrayList();
/*  88 */     arrayList.addAll(DEFAULT_PARAM_NAME_LIST);
/*     */     
/*  90 */     for (byte b = 0; b < this.matcherList.size(); b++) {
/*  91 */       Matcher matcher = this.matcherList.get(b);
/*  92 */       arrayList.add(matcher.getName());
/*     */     } 
/*     */     
/*  95 */     return arrayList.<String>toArray(CoreConstants.EMPTY_STRING_ARRAY);
/*     */   }
/*     */   
/*     */   protected Class[] getParameterTypes() {
/*  99 */     ArrayList<Class<?>> arrayList = new ArrayList();
/* 100 */     arrayList.addAll((Collection)DEFAULT_PARAM_TYPE_LIST);
/* 101 */     for (byte b = 0; b < this.matcherList.size(); b++) {
/* 102 */       arrayList.add(Matcher.class);
/*     */     }
/* 104 */     return (Class[])arrayList.<Class<?>[]>toArray((Class<?>[][])CoreConstants.EMPTY_CLASS_ARRAY);
/*     */   }
/*     */   
/*     */   protected Object[] getParameterValues(ILoggingEvent paramILoggingEvent) {
/* 108 */     int i = this.matcherList.size();
/*     */     
/* 110 */     byte b1 = 0;
/* 111 */     Object[] arrayOfObject = new Object[DEFAULT_PARAM_NAME_LIST.size() + i];
/*     */     
/* 113 */     arrayOfObject[b1++] = Level.DEBUG_INTEGER;
/* 114 */     arrayOfObject[b1++] = Level.INFO_INTEGER;
/* 115 */     arrayOfObject[b1++] = Level.WARN_INTEGER;
/* 116 */     arrayOfObject[b1++] = Level.ERROR_INTEGER;
/*     */     
/* 118 */     arrayOfObject[b1++] = paramILoggingEvent;
/* 119 */     arrayOfObject[b1++] = paramILoggingEvent.getMessage();
/* 120 */     arrayOfObject[b1++] = paramILoggingEvent.getFormattedMessage();
/* 121 */     arrayOfObject[b1++] = paramILoggingEvent.getLoggerName();
/* 122 */     arrayOfObject[b1++] = paramILoggingEvent.getLoggerContextVO();
/* 123 */     arrayOfObject[b1++] = paramILoggingEvent.getLevel().toInteger();
/* 124 */     arrayOfObject[b1++] = Long.valueOf(paramILoggingEvent.getTimeStamp());
/*     */ 
/*     */ 
/*     */     
/* 128 */     arrayOfObject[b1++] = paramILoggingEvent.getMarker();
/* 129 */     arrayOfObject[b1++] = paramILoggingEvent.getMDCPropertyMap();
/*     */     
/* 131 */     IThrowableProxy iThrowableProxy = paramILoggingEvent.getThrowableProxy();
/*     */     
/* 133 */     if (iThrowableProxy != null) {
/* 134 */       arrayOfObject[b1++] = iThrowableProxy;
/* 135 */       if (iThrowableProxy instanceof ThrowableProxy) {
/* 136 */         arrayOfObject[b1++] = ((ThrowableProxy)iThrowableProxy).getThrowable();
/*     */       } else {
/* 138 */         arrayOfObject[b1++] = null;
/*     */       } 
/*     */     } else {
/* 141 */       arrayOfObject[b1++] = null;
/* 142 */       arrayOfObject[b1++] = null;
/*     */     } 
/*     */     
/* 145 */     for (byte b2 = 0; b2 < i; b2++) {
/* 146 */       arrayOfObject[b1++] = this.matcherList.get(b2);
/*     */     }
/*     */     
/* 149 */     return arrayOfObject;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\boolex\JaninoEventEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */