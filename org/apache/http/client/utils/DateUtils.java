/*     */ package org.apache.http.client.utils;
/*     */ 
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TimeZone;
/*     */ import org.apache.http.util.Args;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DateUtils
/*     */ {
/*     */   public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";
/*     */   public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
/*     */   public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
/*  67 */   private static final String[] DEFAULT_PATTERNS = new String[] { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
/*     */ 
/*     */ 
/*     */   
/*  75 */   public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
/*     */   
/*     */   static {
/*  78 */     Calendar calendar = Calendar.getInstance();
/*  79 */     calendar.setTimeZone(GMT);
/*  80 */     calendar.set(2000, 0, 1, 0, 0, 0);
/*  81 */     calendar.set(14, 0);
/*  82 */     DEFAULT_TWO_DIGIT_YEAR_START = calendar.getTime();
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
/*     */   public static Date parseDate(String paramString) {
/*  94 */     return parseDate(paramString, null, null);
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
/*     */   public static Date parseDate(String paramString, String[] paramArrayOfString) {
/* 106 */     return parseDate(paramString, paramArrayOfString, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date parseDate(String paramString, String[] paramArrayOfString, Date paramDate) {
/* 125 */     Args.notNull(paramString, "Date value");
/* 126 */     String[] arrayOfString = (paramArrayOfString != null) ? paramArrayOfString : DEFAULT_PATTERNS;
/* 127 */     Date date = (paramDate != null) ? paramDate : DEFAULT_TWO_DIGIT_YEAR_START;
/* 128 */     String str = paramString;
/*     */ 
/*     */     
/* 131 */     if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
/* 132 */       str = str.substring(1, str.length() - 1);
/*     */     }
/*     */     
/* 135 */     for (String str1 : arrayOfString) {
/* 136 */       SimpleDateFormat simpleDateFormat = DateFormatHolder.formatFor(str1);
/* 137 */       simpleDateFormat.set2DigitYearStart(date);
/* 138 */       ParsePosition parsePosition = new ParsePosition(0);
/* 139 */       Date date1 = simpleDateFormat.parse(str, parsePosition);
/* 140 */       if (parsePosition.getIndex() != 0) {
/* 141 */         return date1;
/*     */       }
/*     */     } 
/* 144 */     return null;
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
/*     */   public static String formatDate(Date paramDate) {
/* 156 */     return formatDate(paramDate, "EEE, dd MMM yyyy HH:mm:ss zzz");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatDate(Date paramDate, String paramString) {
/* 173 */     Args.notNull(paramDate, "Date");
/* 174 */     Args.notNull(paramString, "Pattern");
/* 175 */     SimpleDateFormat simpleDateFormat = DateFormatHolder.formatFor(paramString);
/* 176 */     return simpleDateFormat.format(paramDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clearThreadLocal() {
/* 185 */     DateFormatHolder.clearThreadLocal();
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
/*     */ 
/*     */   
/*     */   static final class DateFormatHolder
/*     */   {
/* 201 */     private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> THREADLOCAL_FORMATS = new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>();
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
/*     */     public static SimpleDateFormat formatFor(String param1String) {
/* 216 */       SoftReference<Map> softReference = (SoftReference)THREADLOCAL_FORMATS.get();
/* 217 */       Map<Object, Object> map = (softReference == null) ? null : softReference.get();
/* 218 */       if (map == null) {
/* 219 */         map = new HashMap<Object, Object>();
/* 220 */         THREADLOCAL_FORMATS.set(new SoftReference(map));
/*     */       } 
/*     */ 
/*     */       
/* 224 */       SimpleDateFormat simpleDateFormat = (SimpleDateFormat)map.get(param1String);
/* 225 */       if (simpleDateFormat == null) {
/* 226 */         simpleDateFormat = new SimpleDateFormat(param1String, Locale.US);
/* 227 */         simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
/* 228 */         map.put(param1String, simpleDateFormat);
/*     */       } 
/*     */       
/* 231 */       return simpleDateFormat;
/*     */     }
/*     */     
/*     */     public static void clearThreadLocal() {
/* 235 */       THREADLOCAL_FORMATS.remove();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\DateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */