/*     */ package ch.qos.logback.core.rolling.helper;
/*     */ 
/*     */ import ch.qos.logback.core.Context;
/*     */ import ch.qos.logback.core.pattern.Converter;
/*     */ import ch.qos.logback.core.pattern.ConverterUtil;
/*     */ import ch.qos.logback.core.pattern.parser.Node;
/*     */ import ch.qos.logback.core.pattern.parser.Parser;
/*     */ import ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil;
/*     */ import ch.qos.logback.core.pattern.util.IEscapeUtil;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
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
/*     */ public class FileNamePattern
/*     */   extends ContextAwareBase
/*     */ {
/*  40 */   static final Map<String, String> CONVERTER_MAP = new HashMap<String, String>();
/*     */   static {
/*  42 */     CONVERTER_MAP.put("i", IntegerTokenConverter.class.getName());
/*  43 */     CONVERTER_MAP.put("d", DateTokenConverter.class.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   String pattern;
/*     */   Converter<Object> headTokenConverter;
/*     */   
/*     */   public FileNamePattern(String paramString, Context paramContext) {
/*  51 */     setPattern(FileFilterUtil.slashify(paramString));
/*  52 */     setContext(paramContext);
/*  53 */     parse();
/*  54 */     ConverterUtil.startConverters(this.headTokenConverter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void parse() {
/*     */     try {
/*  64 */       String str = escapeRightParantesis(this.pattern);
/*  65 */       Parser parser = new Parser(str, (IEscapeUtil)new AlmostAsIsEscapeUtil());
/*  66 */       parser.setContext(this.context);
/*  67 */       Node node = parser.parse();
/*  68 */       this.headTokenConverter = parser.compile(node, CONVERTER_MAP);
/*     */     }
/*  70 */     catch (ScanException scanException) {
/*  71 */       addError("Failed to parse pattern \"" + this.pattern + "\".", (Throwable)scanException);
/*     */     } 
/*     */   }
/*     */   
/*     */   String escapeRightParantesis(String paramString) {
/*  76 */     return this.pattern.replace(")", "\\)");
/*     */   }
/*     */   
/*     */   public String toString() {
/*  80 */     return this.pattern;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  85 */     byte b = 31;
/*  86 */     int i = 1;
/*  87 */     i = 31 * i + ((this.pattern == null) ? 0 : this.pattern.hashCode());
/*  88 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  94 */     if (this == paramObject)
/*  95 */       return true; 
/*  96 */     if (paramObject == null)
/*  97 */       return false; 
/*  98 */     if (getClass() != paramObject.getClass())
/*  99 */       return false; 
/* 100 */     FileNamePattern fileNamePattern = (FileNamePattern)paramObject;
/* 101 */     if (this.pattern == null) {
/* 102 */       if (fileNamePattern.pattern != null)
/* 103 */         return false; 
/* 104 */     } else if (!this.pattern.equals(fileNamePattern.pattern)) {
/* 105 */       return false;
/* 106 */     }  return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public DateTokenConverter<Object> getPrimaryDateTokenConverter() {
/* 111 */     Converter<Object> converter = this.headTokenConverter;
/*     */     
/* 113 */     while (converter != null) {
/* 114 */       if (converter instanceof DateTokenConverter) {
/* 115 */         DateTokenConverter<Object> dateTokenConverter = (DateTokenConverter)converter;
/*     */         
/* 117 */         if (dateTokenConverter.isPrimary()) {
/* 118 */           return dateTokenConverter;
/*     */         }
/*     */       } 
/* 121 */       converter = converter.getNext();
/*     */     } 
/*     */     
/* 124 */     return null;
/*     */   }
/*     */   
/*     */   public IntegerTokenConverter getIntegerTokenConverter() {
/* 128 */     Converter<Object> converter = this.headTokenConverter;
/*     */     
/* 130 */     while (converter != null) {
/* 131 */       if (converter instanceof IntegerTokenConverter) {
/* 132 */         return (IntegerTokenConverter)converter;
/*     */       }
/*     */       
/* 135 */       converter = converter.getNext();
/*     */     } 
/* 137 */     return null;
/*     */   }
/*     */   
/*     */   public boolean hasIntegerTokenCOnverter() {
/* 141 */     IntegerTokenConverter integerTokenConverter = getIntegerTokenConverter();
/* 142 */     return (integerTokenConverter != null);
/*     */   }
/*     */   
/*     */   public String convertMultipleArguments(Object... paramVarArgs) {
/* 146 */     StringBuilder stringBuilder = new StringBuilder();
/* 147 */     Converter<Object> converter = this.headTokenConverter;
/* 148 */     while (converter != null) {
/* 149 */       if (converter instanceof MonoTypedConverter) {
/* 150 */         MonoTypedConverter monoTypedConverter = (MonoTypedConverter)converter;
/* 151 */         for (Object object : paramVarArgs) {
/* 152 */           if (monoTypedConverter.isApplicable(object)) {
/* 153 */             stringBuilder.append(converter.convert(object));
/*     */           }
/*     */         } 
/*     */       } else {
/* 157 */         stringBuilder.append(converter.convert(paramVarArgs));
/*     */       } 
/* 159 */       converter = converter.getNext();
/*     */     } 
/* 161 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String convert(Object paramObject) {
/* 165 */     StringBuilder stringBuilder = new StringBuilder();
/* 166 */     Converter<Object> converter = this.headTokenConverter;
/* 167 */     while (converter != null) {
/* 168 */       stringBuilder.append(converter.convert(paramObject));
/* 169 */       converter = converter.getNext();
/*     */     } 
/* 171 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String convertInt(int paramInt) {
/* 175 */     return convert(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public void setPattern(String paramString) {
/* 179 */     if (paramString != null)
/*     */     {
/* 181 */       this.pattern = paramString.trim();
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPattern() {
/* 186 */     return this.pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toRegexForFixedDate(Date paramDate) {
/* 196 */     StringBuilder stringBuilder = new StringBuilder();
/* 197 */     Converter<Object> converter = this.headTokenConverter;
/* 198 */     while (converter != null) {
/* 199 */       if (converter instanceof ch.qos.logback.core.pattern.LiteralConverter) {
/* 200 */         stringBuilder.append(converter.convert(null));
/* 201 */       } else if (converter instanceof IntegerTokenConverter) {
/* 202 */         stringBuilder.append("(\\d{1,5})");
/* 203 */       } else if (converter instanceof DateTokenConverter) {
/* 204 */         stringBuilder.append(converter.convert(paramDate));
/*     */       } 
/* 206 */       converter = converter.getNext();
/*     */     } 
/* 208 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toRegex() {
/* 215 */     StringBuilder stringBuilder = new StringBuilder();
/* 216 */     Converter<Object> converter = this.headTokenConverter;
/* 217 */     while (converter != null) {
/* 218 */       if (converter instanceof ch.qos.logback.core.pattern.LiteralConverter) {
/* 219 */         stringBuilder.append(converter.convert(null));
/* 220 */       } else if (converter instanceof IntegerTokenConverter) {
/* 221 */         stringBuilder.append("\\d{1,2}");
/* 222 */       } else if (converter instanceof DateTokenConverter) {
/* 223 */         DateTokenConverter dateTokenConverter = (DateTokenConverter)converter;
/* 224 */         stringBuilder.append(dateTokenConverter.toRegex());
/*     */       } 
/* 226 */       converter = converter.getNext();
/*     */     } 
/* 228 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\FileNamePattern.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */