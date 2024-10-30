/*     */ package ch.qos.logback.classic;
/*     */ import ch.qos.logback.classic.pattern.CallerDataConverter;
/*     */ import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
/*     */ import ch.qos.logback.classic.pattern.ContextNameConverter;
/*     */ import ch.qos.logback.classic.pattern.DateConverter;
/*     */ import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
/*     */ import ch.qos.logback.classic.pattern.FileOfCallerConverter;
/*     */ import ch.qos.logback.classic.pattern.LevelConverter;
/*     */ import ch.qos.logback.classic.pattern.LineOfCallerConverter;
/*     */ import ch.qos.logback.classic.pattern.LineSeparatorConverter;
/*     */ import ch.qos.logback.classic.pattern.LocalSequenceNumberConverter;
/*     */ import ch.qos.logback.classic.pattern.LoggerConverter;
/*     */ import ch.qos.logback.classic.pattern.MDCConverter;
/*     */ import ch.qos.logback.classic.pattern.MarkerConverter;
/*     */ import ch.qos.logback.classic.pattern.MessageConverter;
/*     */ import ch.qos.logback.classic.pattern.MethodOfCallerConverter;
/*     */ import ch.qos.logback.classic.pattern.NopThrowableInformationConverter;
/*     */ import ch.qos.logback.classic.pattern.PrefixCompositeConverter;
/*     */ import ch.qos.logback.classic.pattern.PropertyConverter;
/*     */ import ch.qos.logback.classic.pattern.RelativeTimeConverter;
/*     */ import ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
/*     */ import ch.qos.logback.classic.pattern.ThreadConverter;
/*     */ import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.core.pattern.color.BlackCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.BlueCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.BoldBlueCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.BoldMagentaCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.BoldWhiteCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.CyanCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.GreenCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.MagentaCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.RedCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.color.YellowCompositeConverter;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class PatternLayout extends PatternLayoutBase<ILoggingEvent> {
/*  41 */   public static final Map<String, String> DEFAULT_CONVERTER_MAP = new HashMap<String, String>();
/*  42 */   public static final Map<String, String> CONVERTER_CLASS_TO_KEY_MAP = new HashMap<String, String>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   public static final Map<String, String> defaultConverterMap = DEFAULT_CONVERTER_MAP;
/*     */   
/*     */   public static final String HEADER_PREFIX = "#logback.classic pattern: ";
/*     */   
/*     */   static {
/*  52 */     DEFAULT_CONVERTER_MAP.putAll(Parser.DEFAULT_COMPOSITE_CONVERTER_MAP);
/*     */     
/*  54 */     DEFAULT_CONVERTER_MAP.put("d", DateConverter.class.getName());
/*  55 */     DEFAULT_CONVERTER_MAP.put("date", DateConverter.class.getName());
/*  56 */     CONVERTER_CLASS_TO_KEY_MAP.put(DateConverter.class.getName(), "date");
/*     */     
/*  58 */     DEFAULT_CONVERTER_MAP.put("r", RelativeTimeConverter.class.getName());
/*  59 */     DEFAULT_CONVERTER_MAP.put("relative", RelativeTimeConverter.class.getName());
/*  60 */     CONVERTER_CLASS_TO_KEY_MAP.put(RelativeTimeConverter.class.getName(), "relative");
/*     */     
/*  62 */     DEFAULT_CONVERTER_MAP.put("level", LevelConverter.class.getName());
/*  63 */     DEFAULT_CONVERTER_MAP.put("le", LevelConverter.class.getName());
/*  64 */     DEFAULT_CONVERTER_MAP.put("p", LevelConverter.class.getName());
/*  65 */     CONVERTER_CLASS_TO_KEY_MAP.put(LevelConverter.class.getName(), "level");
/*     */ 
/*     */     
/*  68 */     DEFAULT_CONVERTER_MAP.put("t", ThreadConverter.class.getName());
/*  69 */     DEFAULT_CONVERTER_MAP.put("thread", ThreadConverter.class.getName());
/*  70 */     CONVERTER_CLASS_TO_KEY_MAP.put(ThreadConverter.class.getName(), "thread");
/*     */     
/*  72 */     DEFAULT_CONVERTER_MAP.put("lo", LoggerConverter.class.getName());
/*  73 */     DEFAULT_CONVERTER_MAP.put("logger", LoggerConverter.class.getName());
/*  74 */     DEFAULT_CONVERTER_MAP.put("c", LoggerConverter.class.getName());
/*  75 */     CONVERTER_CLASS_TO_KEY_MAP.put(LoggerConverter.class.getName(), "logger");
/*     */     
/*  77 */     DEFAULT_CONVERTER_MAP.put("m", MessageConverter.class.getName());
/*  78 */     DEFAULT_CONVERTER_MAP.put("msg", MessageConverter.class.getName());
/*  79 */     DEFAULT_CONVERTER_MAP.put("message", MessageConverter.class.getName());
/*  80 */     CONVERTER_CLASS_TO_KEY_MAP.put(MessageConverter.class.getName(), "message");
/*     */     
/*  82 */     DEFAULT_CONVERTER_MAP.put("C", ClassOfCallerConverter.class.getName());
/*  83 */     DEFAULT_CONVERTER_MAP.put("class", ClassOfCallerConverter.class.getName());
/*  84 */     CONVERTER_CLASS_TO_KEY_MAP.put(ClassOfCallerConverter.class.getName(), "class");
/*     */     
/*  86 */     DEFAULT_CONVERTER_MAP.put("M", MethodOfCallerConverter.class.getName());
/*  87 */     DEFAULT_CONVERTER_MAP.put("method", MethodOfCallerConverter.class.getName());
/*  88 */     CONVERTER_CLASS_TO_KEY_MAP.put(MethodOfCallerConverter.class.getName(), "method");
/*     */     
/*  90 */     DEFAULT_CONVERTER_MAP.put("L", LineOfCallerConverter.class.getName());
/*  91 */     DEFAULT_CONVERTER_MAP.put("line", LineOfCallerConverter.class.getName());
/*  92 */     CONVERTER_CLASS_TO_KEY_MAP.put(LineOfCallerConverter.class.getName(), "line");
/*     */     
/*  94 */     DEFAULT_CONVERTER_MAP.put("F", FileOfCallerConverter.class.getName());
/*  95 */     DEFAULT_CONVERTER_MAP.put("file", FileOfCallerConverter.class.getName());
/*  96 */     CONVERTER_CLASS_TO_KEY_MAP.put(FileOfCallerConverter.class.getName(), "file");
/*     */     
/*  98 */     DEFAULT_CONVERTER_MAP.put("X", MDCConverter.class.getName());
/*  99 */     DEFAULT_CONVERTER_MAP.put("mdc", MDCConverter.class.getName());
/*     */     
/* 101 */     DEFAULT_CONVERTER_MAP.put("ex", ThrowableProxyConverter.class.getName());
/* 102 */     DEFAULT_CONVERTER_MAP.put("exception", ThrowableProxyConverter.class.getName());
/* 103 */     DEFAULT_CONVERTER_MAP.put("rEx", RootCauseFirstThrowableProxyConverter.class.getName());
/* 104 */     DEFAULT_CONVERTER_MAP.put("rootException", RootCauseFirstThrowableProxyConverter.class.getName());
/* 105 */     DEFAULT_CONVERTER_MAP.put("throwable", ThrowableProxyConverter.class.getName());
/*     */     
/* 107 */     DEFAULT_CONVERTER_MAP.put("xEx", ExtendedThrowableProxyConverter.class.getName());
/* 108 */     DEFAULT_CONVERTER_MAP.put("xException", ExtendedThrowableProxyConverter.class.getName());
/* 109 */     DEFAULT_CONVERTER_MAP.put("xThrowable", ExtendedThrowableProxyConverter.class.getName());
/*     */     
/* 111 */     DEFAULT_CONVERTER_MAP.put("nopex", NopThrowableInformationConverter.class.getName());
/* 112 */     DEFAULT_CONVERTER_MAP.put("nopexception", NopThrowableInformationConverter.class.getName());
/*     */     
/* 114 */     DEFAULT_CONVERTER_MAP.put("cn", ContextNameConverter.class.getName());
/* 115 */     DEFAULT_CONVERTER_MAP.put("contextName", ContextNameConverter.class.getName());
/* 116 */     CONVERTER_CLASS_TO_KEY_MAP.put(ContextNameConverter.class.getName(), "contextName");
/*     */     
/* 118 */     DEFAULT_CONVERTER_MAP.put("caller", CallerDataConverter.class.getName());
/* 119 */     CONVERTER_CLASS_TO_KEY_MAP.put(CallerDataConverter.class.getName(), "caller");
/*     */     
/* 121 */     DEFAULT_CONVERTER_MAP.put("marker", MarkerConverter.class.getName());
/* 122 */     CONVERTER_CLASS_TO_KEY_MAP.put(MarkerConverter.class.getName(), "marker");
/*     */     
/* 124 */     DEFAULT_CONVERTER_MAP.put("property", PropertyConverter.class.getName());
/*     */     
/* 126 */     DEFAULT_CONVERTER_MAP.put("n", LineSeparatorConverter.class.getName());
/*     */     
/* 128 */     DEFAULT_CONVERTER_MAP.put("black", BlackCompositeConverter.class.getName());
/* 129 */     DEFAULT_CONVERTER_MAP.put("red", RedCompositeConverter.class.getName());
/* 130 */     DEFAULT_CONVERTER_MAP.put("green", GreenCompositeConverter.class.getName());
/* 131 */     DEFAULT_CONVERTER_MAP.put("yellow", YellowCompositeConverter.class.getName());
/* 132 */     DEFAULT_CONVERTER_MAP.put("blue", BlueCompositeConverter.class.getName());
/* 133 */     DEFAULT_CONVERTER_MAP.put("magenta", MagentaCompositeConverter.class.getName());
/* 134 */     DEFAULT_CONVERTER_MAP.put("cyan", CyanCompositeConverter.class.getName());
/* 135 */     DEFAULT_CONVERTER_MAP.put("white", WhiteCompositeConverter.class.getName());
/* 136 */     DEFAULT_CONVERTER_MAP.put("gray", GrayCompositeConverter.class.getName());
/* 137 */     DEFAULT_CONVERTER_MAP.put("boldRed", BoldRedCompositeConverter.class.getName());
/* 138 */     DEFAULT_CONVERTER_MAP.put("boldGreen", BoldGreenCompositeConverter.class.getName());
/* 139 */     DEFAULT_CONVERTER_MAP.put("boldYellow", BoldYellowCompositeConverter.class.getName());
/* 140 */     DEFAULT_CONVERTER_MAP.put("boldBlue", BoldBlueCompositeConverter.class.getName());
/* 141 */     DEFAULT_CONVERTER_MAP.put("boldMagenta", BoldMagentaCompositeConverter.class.getName());
/* 142 */     DEFAULT_CONVERTER_MAP.put("boldCyan", BoldCyanCompositeConverter.class.getName());
/* 143 */     DEFAULT_CONVERTER_MAP.put("boldWhite", BoldWhiteCompositeConverter.class.getName());
/* 144 */     DEFAULT_CONVERTER_MAP.put("highlight", HighlightingCompositeConverter.class.getName());
/*     */     
/* 146 */     DEFAULT_CONVERTER_MAP.put("lsn", LocalSequenceNumberConverter.class.getName());
/* 147 */     CONVERTER_CLASS_TO_KEY_MAP.put(LocalSequenceNumberConverter.class.getName(), "lsn");
/*     */     
/* 149 */     DEFAULT_CONVERTER_MAP.put("prefix", PrefixCompositeConverter.class.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getDefaultConverterMap() {
/* 158 */     return DEFAULT_CONVERTER_MAP;
/*     */   }
/*     */   
/*     */   public String doLayout(ILoggingEvent paramILoggingEvent) {
/* 162 */     if (!isStarted()) {
/* 163 */       return "";
/*     */     }
/* 165 */     return writeLoopOnConverters(paramILoggingEvent);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getPresentationHeaderPrefix() {
/* 170 */     return "#logback.classic pattern: ";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\PatternLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */