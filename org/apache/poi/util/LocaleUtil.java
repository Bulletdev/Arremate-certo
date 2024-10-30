/*     */ package org.apache.poi.util;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Calendar;
/*     */ import java.util.Locale;
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
/*     */ public final class LocaleUtil
/*     */ {
/*  46 */   public static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public static final Charset CHARSET_1252 = Charset.forName("CP1252");
/*     */   
/*  55 */   private static final ThreadLocal<TimeZone> userTimeZone = new ThreadLocal<TimeZone>();
/*  56 */   private static final ThreadLocal<Locale> userLocale = new ThreadLocal<Locale>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setUserTimeZone(TimeZone paramTimeZone) {
/*  66 */     userTimeZone.set(paramTimeZone);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressForbidden("implementation around default locales in POI")
/*     */   public static TimeZone getUserTimeZone() {
/*  74 */     TimeZone timeZone = userTimeZone.get();
/*  75 */     return (timeZone != null) ? timeZone : TimeZone.getDefault();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void resetUserTimeZone() {
/*  82 */     userTimeZone.remove();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setUserLocale(Locale paramLocale) {
/*  90 */     userLocale.set(paramLocale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressForbidden("implementation around default locales in POI")
/*     */   public static Locale getUserLocale() {
/*  98 */     Locale locale = userLocale.get();
/*  99 */     return (locale != null) ? locale : Locale.getDefault();
/*     */   }
/*     */   
/*     */   public static void resetUserLocale() {
/* 103 */     userLocale.remove();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Calendar getLocaleCalendar() {
/* 110 */     return getLocaleCalendar(getUserTimeZone());
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
/*     */   public static Calendar getLocaleCalendar(int paramInt1, int paramInt2, int paramInt3) {
/* 122 */     return getLocaleCalendar(paramInt1, paramInt2, paramInt3, 0, 0, 0);
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
/*     */   public static Calendar getLocaleCalendar(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 137 */     Calendar calendar = getLocaleCalendar();
/* 138 */     calendar.set(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/* 139 */     calendar.clear(14);
/* 140 */     return calendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Calendar getLocaleCalendar(TimeZone paramTimeZone) {
/* 147 */     return Calendar.getInstance(paramTimeZone, getUserLocale());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\LocaleUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */