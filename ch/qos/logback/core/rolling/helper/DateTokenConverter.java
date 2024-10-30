/*     */ package ch.qos.logback.core.rolling.helper;
/*     */ 
/*     */ import ch.qos.logback.core.pattern.DynamicConverter;
/*     */ import ch.qos.logback.core.util.CachingDateFormatter;
/*     */ import ch.qos.logback.core.util.DatePatternToRegexUtil;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.TimeZone;
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
/*     */ public class DateTokenConverter<E>
/*     */   extends DynamicConverter<E>
/*     */   implements MonoTypedConverter
/*     */ {
/*     */   public static final String CONVERTER_KEY = "d";
/*     */   public static final String AUXILIARY_TOKEN = "AUX";
/*     */   public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
/*     */   private String datePattern;
/*     */   private TimeZone timeZone;
/*     */   private CachingDateFormatter cdf;
/*     */   private boolean primary = true;
/*     */   
/*     */   public void start() {
/*  47 */     this.datePattern = getFirstOption();
/*  48 */     if (this.datePattern == null) {
/*  49 */       this.datePattern = "yyyy-MM-dd";
/*     */     }
/*     */     
/*  52 */     List<String> list = getOptionList();
/*  53 */     if (list != null) {
/*  54 */       for (byte b = 1; b < list.size(); b++) {
/*  55 */         String str = list.get(b);
/*  56 */         if ("AUX".equalsIgnoreCase(str)) {
/*  57 */           this.primary = false;
/*     */         } else {
/*  59 */           this.timeZone = TimeZone.getTimeZone(str);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  64 */     this.cdf = new CachingDateFormatter(this.datePattern);
/*  65 */     if (this.timeZone != null) {
/*  66 */       this.cdf.setTimeZone(this.timeZone);
/*     */     }
/*     */   }
/*     */   
/*     */   public String convert(Date paramDate) {
/*  71 */     return this.cdf.format(paramDate.getTime());
/*     */   }
/*     */   
/*     */   public String convert(Object paramObject) {
/*  75 */     if (paramObject == null) {
/*  76 */       throw new IllegalArgumentException("Null argument forbidden");
/*     */     }
/*  78 */     if (paramObject instanceof Date) {
/*  79 */       return convert((Date)paramObject);
/*     */     }
/*  81 */     throw new IllegalArgumentException("Cannot convert " + paramObject + " of type" + paramObject.getClass().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDatePattern() {
/*  88 */     return this.datePattern;
/*     */   }
/*     */   
/*     */   public TimeZone getTimeZone() {
/*  92 */     return this.timeZone;
/*     */   }
/*     */   
/*     */   public boolean isApplicable(Object paramObject) {
/*  96 */     return paramObject instanceof Date;
/*     */   }
/*     */   
/*     */   public String toRegex() {
/* 100 */     DatePatternToRegexUtil datePatternToRegexUtil = new DatePatternToRegexUtil(this.datePattern);
/* 101 */     return datePatternToRegexUtil.toRegex();
/*     */   }
/*     */   
/*     */   public boolean isPrimary() {
/* 105 */     return this.primary;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\DateTokenConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */