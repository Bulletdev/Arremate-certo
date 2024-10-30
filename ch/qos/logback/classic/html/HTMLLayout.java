/*     */ package ch.qos.logback.classic.html;
/*     */ 
/*     */ import ch.qos.logback.classic.PatternLayout;
/*     */ import ch.qos.logback.classic.pattern.MDCConverter;
/*     */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.helpers.Transform;
/*     */ import ch.qos.logback.core.html.HTMLLayoutBase;
/*     */ import ch.qos.logback.core.html.IThrowableRenderer;
/*     */ import ch.qos.logback.core.pattern.Converter;
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
/*     */ public class HTMLLayout
/*     */   extends HTMLLayoutBase<ILoggingEvent>
/*     */ {
/*     */   static final String DEFAULT_CONVERSION_PATTERN = "%date%thread%level%logger%mdc%msg";
/*  56 */   IThrowableRenderer<ILoggingEvent> throwableRenderer = new DefaultThrowableRenderer();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  62 */     byte b = 0;
/*  63 */     if (this.throwableRenderer == null) {
/*  64 */       addError("ThrowableRender cannot be null.");
/*  65 */       b++;
/*     */     } 
/*  67 */     if (b == 0) {
/*  68 */       super.start();
/*     */     }
/*     */   }
/*     */   
/*     */   protected Map<String, String> getDefaultConverterMap() {
/*  73 */     return PatternLayout.DEFAULT_CONVERTER_MAP;
/*     */   }
/*     */   
/*     */   public String doLayout(ILoggingEvent paramILoggingEvent) {
/*  77 */     StringBuilder stringBuilder = new StringBuilder();
/*  78 */     startNewTableIfLimitReached(stringBuilder);
/*     */     
/*  80 */     boolean bool = true;
/*  81 */     if ((this.counter++ & 0x1L) == 0L) {
/*  82 */       bool = false;
/*     */     }
/*     */     
/*  85 */     String str = paramILoggingEvent.getLevel().toString().toLowerCase();
/*     */     
/*  87 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*  88 */     stringBuilder.append("<tr class=\"");
/*  89 */     stringBuilder.append(str);
/*  90 */     if (bool) {
/*  91 */       stringBuilder.append(" odd\">");
/*     */     } else {
/*  93 */       stringBuilder.append(" even\">");
/*     */     } 
/*  95 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     
/*  97 */     Converter<ILoggingEvent> converter = this.head;
/*  98 */     while (converter != null) {
/*  99 */       appendEventToBuffer(stringBuilder, converter, paramILoggingEvent);
/* 100 */       converter = converter.getNext();
/*     */     } 
/* 102 */     stringBuilder.append("</tr>");
/* 103 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     
/* 105 */     if (paramILoggingEvent.getThrowableProxy() != null) {
/* 106 */       this.throwableRenderer.render(stringBuilder, paramILoggingEvent);
/*     */     }
/* 108 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void appendEventToBuffer(StringBuilder paramStringBuilder, Converter<ILoggingEvent> paramConverter, ILoggingEvent paramILoggingEvent) {
/* 112 */     paramStringBuilder.append("<td class=\"");
/* 113 */     paramStringBuilder.append(computeConverterName(paramConverter));
/* 114 */     paramStringBuilder.append("\">");
/* 115 */     paramStringBuilder.append(Transform.escapeTags(paramConverter.convert(paramILoggingEvent)));
/* 116 */     paramStringBuilder.append("</td>");
/* 117 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */   }
/*     */   
/*     */   public IThrowableRenderer getThrowableRenderer() {
/* 121 */     return this.throwableRenderer;
/*     */   }
/*     */   
/*     */   public void setThrowableRenderer(IThrowableRenderer<ILoggingEvent> paramIThrowableRenderer) {
/* 125 */     this.throwableRenderer = paramIThrowableRenderer;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String computeConverterName(Converter paramConverter) {
/* 130 */     if (paramConverter instanceof MDCConverter) {
/* 131 */       MDCConverter mDCConverter = (MDCConverter)paramConverter;
/* 132 */       String str = mDCConverter.getFirstOption();
/* 133 */       if (str != null) {
/* 134 */         return str;
/*     */       }
/* 136 */       return "MDC";
/*     */     } 
/*     */     
/* 139 */     return super.computeConverterName(paramConverter);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\html\HTMLLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */