/*     */ package ch.qos.logback.core.html;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.LayoutBase;
/*     */ import ch.qos.logback.core.pattern.Converter;
/*     */ import ch.qos.logback.core.pattern.ConverterUtil;
/*     */ import ch.qos.logback.core.pattern.parser.Node;
/*     */ import ch.qos.logback.core.pattern.parser.Parser;
/*     */ import ch.qos.logback.core.spi.ScanException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
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
/*     */ public abstract class HTMLLayoutBase<E>
/*     */   extends LayoutBase<E>
/*     */ {
/*     */   protected String pattern;
/*     */   protected Converter<E> head;
/*  42 */   protected String title = "Logback Log Messages";
/*     */ 
/*     */ 
/*     */   
/*     */   protected CssBuilder cssBuilder;
/*     */ 
/*     */   
/*  49 */   protected long counter = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPattern(String paramString) {
/*  57 */     this.pattern = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPattern() {
/*  64 */     return this.pattern;
/*     */   }
/*     */   
/*     */   public CssBuilder getCssBuilder() {
/*  68 */     return this.cssBuilder;
/*     */   }
/*     */   
/*     */   public void setCssBuilder(CssBuilder paramCssBuilder) {
/*  72 */     this.cssBuilder = paramCssBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  80 */     byte b = 0;
/*     */     
/*     */     try {
/*  83 */       Parser parser = new Parser(this.pattern);
/*  84 */       parser.setContext(getContext());
/*  85 */       Node node = parser.parse();
/*  86 */       this.head = parser.compile(node, getEffectiveConverterMap());
/*  87 */       ConverterUtil.startConverters(this.head);
/*  88 */     } catch (ScanException scanException) {
/*  89 */       addError("Incorrect pattern found", (Throwable)scanException);
/*  90 */       b++;
/*     */     } 
/*     */     
/*  93 */     if (b == 0) {
/*  94 */       this.started = true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Map<String, String> getDefaultConverterMap();
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getEffectiveConverterMap() {
/* 105 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */ 
/*     */     
/* 108 */     Map<String, String> map = getDefaultConverterMap();
/* 109 */     if (map != null) {
/* 110 */       hashMap.putAll(map);
/*     */     }
/*     */ 
/*     */     
/* 114 */     Context context = getContext();
/* 115 */     if (context != null) {
/*     */       
/* 117 */       Map<?, ?> map1 = (Map)context.getObject("PATTERN_RULE_REGISTRY");
/* 118 */       if (map1 != null) {
/* 119 */         hashMap.putAll(map1);
/*     */       }
/*     */     } 
/* 122 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitle(String paramString) {
/* 133 */     this.title = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 140 */     return this.title;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType() {
/* 148 */     return "text/html";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileHeader() {
/* 156 */     StringBuilder stringBuilder = new StringBuilder();
/* 157 */     stringBuilder.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
/* 158 */     stringBuilder.append(" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
/* 159 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 160 */     stringBuilder.append("<html>");
/* 161 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 162 */     stringBuilder.append("  <head>");
/* 163 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 164 */     stringBuilder.append("    <title>");
/* 165 */     stringBuilder.append(this.title);
/* 166 */     stringBuilder.append("</title>");
/* 167 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     
/* 169 */     this.cssBuilder.addCss(stringBuilder);
/*     */     
/* 171 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 172 */     stringBuilder.append("  </head>");
/* 173 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 174 */     stringBuilder.append("<body>");
/* 175 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     
/* 177 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String getPresentationHeader() {
/* 181 */     StringBuilder stringBuilder = new StringBuilder();
/* 182 */     stringBuilder.append("<hr/>");
/* 183 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 184 */     stringBuilder.append("<p>Log session start time ");
/* 185 */     stringBuilder.append(new Date());
/* 186 */     stringBuilder.append("</p><p></p>");
/* 187 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 188 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 189 */     stringBuilder.append("<table cellspacing=\"0\">");
/* 190 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */     
/* 192 */     buildHeaderRowForTable(stringBuilder);
/*     */     
/* 194 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void buildHeaderRowForTable(StringBuilder paramStringBuilder) {
/* 198 */     Converter<E> converter = this.head;
/*     */     
/* 200 */     paramStringBuilder.append("<tr class=\"header\">");
/* 201 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 202 */     while (converter != null) {
/* 203 */       String str = computeConverterName(converter);
/* 204 */       if (str == null) {
/* 205 */         converter = converter.getNext();
/*     */         continue;
/*     */       } 
/* 208 */       paramStringBuilder.append("<td class=\"");
/* 209 */       paramStringBuilder.append(computeConverterName(converter));
/* 210 */       paramStringBuilder.append("\">");
/* 211 */       paramStringBuilder.append(computeConverterName(converter));
/* 212 */       paramStringBuilder.append("</td>");
/* 213 */       paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 214 */       converter = converter.getNext();
/*     */     } 
/* 216 */     paramStringBuilder.append("</tr>");
/* 217 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*     */   }
/*     */   
/*     */   public String getPresentationFooter() {
/* 221 */     StringBuilder stringBuilder = new StringBuilder();
/* 222 */     stringBuilder.append("</table>");
/* 223 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFileFooter() {
/* 231 */     StringBuilder stringBuilder = new StringBuilder();
/* 232 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 233 */     stringBuilder.append("</body></html>");
/* 234 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected void startNewTableIfLimitReached(StringBuilder paramStringBuilder) {
/* 238 */     if (this.counter >= 10000L) {
/* 239 */       this.counter = 0L;
/* 240 */       paramStringBuilder.append("</table>");
/* 241 */       paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 242 */       paramStringBuilder.append("<p></p>");
/* 243 */       paramStringBuilder.append("<table cellspacing=\"0\">");
/* 244 */       paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 245 */       buildHeaderRowForTable(paramStringBuilder);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String computeConverterName(Converter paramConverter) {
/* 250 */     String str = paramConverter.getClass().getSimpleName();
/* 251 */     int i = str.indexOf("Converter");
/* 252 */     if (i == -1) {
/* 253 */       return str;
/*     */     }
/* 255 */     return str.substring(0, i);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\html\HTMLLayoutBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */