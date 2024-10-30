/*     */ package ch.qos.logback.core.pattern;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.LayoutBase;
/*     */ import ch.qos.logback.core.pattern.parser.Node;
/*     */ import ch.qos.logback.core.pattern.parser.Parser;
/*     */ import ch.qos.logback.core.spi.ScanException;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.StatusManager;
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
/*     */ public abstract class PatternLayoutBase<E>
/*     */   extends LayoutBase<E>
/*     */ {
/*     */   static final int INTIAL_STRING_BUILDER_SIZE = 256;
/*     */   Converter<E> head;
/*     */   String pattern;
/*     */   protected PostCompileProcessor<E> postCompileProcessor;
/*  35 */   Map<String, String> instanceConverterMap = new HashMap<String, String>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean outputPatternAsHeader = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Map<String, String> getDefaultConverterMap();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getEffectiveConverterMap() {
/*  51 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */ 
/*     */     
/*  54 */     Map<String, String> map = getDefaultConverterMap();
/*  55 */     if (map != null) {
/*  56 */       hashMap.putAll(map);
/*     */     }
/*     */ 
/*     */     
/*  60 */     Context context = getContext();
/*  61 */     if (context != null) {
/*     */       
/*  63 */       Map<?, ?> map1 = (Map)context.getObject("PATTERN_RULE_REGISTRY");
/*  64 */       if (map1 != null) {
/*  65 */         hashMap.putAll(map1);
/*     */       }
/*     */     } 
/*     */     
/*  69 */     hashMap.putAll(this.instanceConverterMap);
/*  70 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   public void start() {
/*  74 */     if (this.pattern == null || this.pattern.length() == 0) {
/*  75 */       addError("Empty or null pattern.");
/*     */       return;
/*     */     } 
/*     */     try {
/*  79 */       Parser parser = new Parser(this.pattern);
/*  80 */       if (getContext() != null) {
/*  81 */         parser.setContext(getContext());
/*     */       }
/*  83 */       Node node = parser.parse();
/*  84 */       this.head = parser.compile(node, getEffectiveConverterMap());
/*  85 */       if (this.postCompileProcessor != null) {
/*  86 */         this.postCompileProcessor.process(this.context, this.head);
/*     */       }
/*  88 */       ConverterUtil.setContextForConverters(getContext(), this.head);
/*  89 */       ConverterUtil.startConverters(this.head);
/*  90 */       super.start();
/*  91 */     } catch (ScanException scanException) {
/*  92 */       StatusManager statusManager = getContext().getStatusManager();
/*  93 */       statusManager.add((Status)new ErrorStatus("Failed to parse pattern \"" + getPattern() + "\".", this, (Throwable)scanException));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setPostCompileProcessor(PostCompileProcessor<E> paramPostCompileProcessor) {
/*  98 */     this.postCompileProcessor = paramPostCompileProcessor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setContextForConverters(Converter<E> paramConverter) {
/* 108 */     ConverterUtil.setContextForConverters(getContext(), paramConverter);
/*     */   }
/*     */   
/*     */   protected String writeLoopOnConverters(E paramE) {
/* 112 */     StringBuilder stringBuilder = new StringBuilder(256);
/* 113 */     Converter<E> converter = this.head;
/* 114 */     while (converter != null) {
/* 115 */       converter.write(stringBuilder, paramE);
/* 116 */       converter = converter.getNext();
/*     */     } 
/* 118 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String getPattern() {
/* 122 */     return this.pattern;
/*     */   }
/*     */   
/*     */   public void setPattern(String paramString) {
/* 126 */     this.pattern = paramString;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 130 */     return getClass().getName() + "(\"" + getPattern() + "\")";
/*     */   }
/*     */   
/*     */   public Map<String, String> getInstanceConverterMap() {
/* 134 */     return this.instanceConverterMap;
/*     */   }
/*     */   
/*     */   protected String getPresentationHeaderPrefix() {
/* 138 */     return "";
/*     */   }
/*     */   
/*     */   public boolean isOutputPatternAsHeader() {
/* 142 */     return this.outputPatternAsHeader;
/*     */   }
/*     */   
/*     */   public void setOutputPatternAsHeader(boolean paramBoolean) {
/* 146 */     this.outputPatternAsHeader = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPresentationHeader() {
/* 151 */     if (this.outputPatternAsHeader) {
/* 152 */       return getPresentationHeaderPrefix() + this.pattern;
/*     */     }
/* 154 */     return super.getPresentationHeader();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\PatternLayoutBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */