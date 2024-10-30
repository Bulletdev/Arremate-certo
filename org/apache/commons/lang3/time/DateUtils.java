/*      */ package org.apache.commons.lang3.time;
/*      */ 
/*      */ import java.text.ParseException;
/*      */ import java.text.ParsePosition;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.Iterator;
/*      */ import java.util.Locale;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.TimeZone;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DateUtils
/*      */ {
/*      */   public static final long MILLIS_PER_SECOND = 1000L;
/*      */   public static final long MILLIS_PER_MINUTE = 60000L;
/*      */   public static final long MILLIS_PER_HOUR = 3600000L;
/*      */   public static final long MILLIS_PER_DAY = 86400000L;
/*      */   public static final int SEMI_MONTH = 1001;
/*   83 */   private static final int[][] fields = new int[][] { { 14 }, { 13 }, { 12 }, { 11, 10 }, { 5, 5, 9 }, { 2, 1001 }, { 1 }, { 0 } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_WEEK_SUNDAY = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_WEEK_MONDAY = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_WEEK_RELATIVE = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_WEEK_CENTER = 4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_MONTH_SUNDAY = 5;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int RANGE_MONTH_MONDAY = 6;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private enum ModifyType
/*      */   {
/*  127 */     TRUNCATE,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  132 */     ROUND,
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  137 */     CEILING;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameDay(Date paramDate1, Date paramDate2) {
/*  167 */     if (paramDate1 == null || paramDate2 == null) {
/*  168 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  170 */     Calendar calendar1 = Calendar.getInstance();
/*  171 */     calendar1.setTime(paramDate1);
/*  172 */     Calendar calendar2 = Calendar.getInstance();
/*  173 */     calendar2.setTime(paramDate2);
/*  174 */     return isSameDay(calendar1, calendar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameDay(Calendar paramCalendar1, Calendar paramCalendar2) {
/*  191 */     if (paramCalendar1 == null || paramCalendar2 == null) {
/*  192 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  194 */     return (paramCalendar1.get(0) == paramCalendar2.get(0) && paramCalendar1
/*  195 */       .get(1) == paramCalendar2.get(1) && paramCalendar1
/*  196 */       .get(6) == paramCalendar2.get(6));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameInstant(Date paramDate1, Date paramDate2) {
/*  212 */     if (paramDate1 == null || paramDate2 == null) {
/*  213 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  215 */     return (paramDate1.getTime() == paramDate2.getTime());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameInstant(Calendar paramCalendar1, Calendar paramCalendar2) {
/*  230 */     if (paramCalendar1 == null || paramCalendar2 == null) {
/*  231 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  233 */     return (paramCalendar1.getTime().getTime() == paramCalendar2.getTime().getTime());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSameLocalTime(Calendar paramCalendar1, Calendar paramCalendar2) {
/*  250 */     if (paramCalendar1 == null || paramCalendar2 == null) {
/*  251 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  253 */     return (paramCalendar1.get(14) == paramCalendar2.get(14) && paramCalendar1
/*  254 */       .get(13) == paramCalendar2.get(13) && paramCalendar1
/*  255 */       .get(12) == paramCalendar2.get(12) && paramCalendar1
/*  256 */       .get(11) == paramCalendar2.get(11) && paramCalendar1
/*  257 */       .get(6) == paramCalendar2.get(6) && paramCalendar1
/*  258 */       .get(1) == paramCalendar2.get(1) && paramCalendar1
/*  259 */       .get(0) == paramCalendar2.get(0) && paramCalendar1
/*  260 */       .getClass() == paramCalendar2.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date parseDate(String paramString, String... paramVarArgs) throws ParseException {
/*  279 */     return parseDate(paramString, null, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date parseDate(String paramString, Locale paramLocale, String... paramVarArgs) throws ParseException {
/*  302 */     return parseDateWithLeniency(paramString, paramLocale, paramVarArgs, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date parseDateStrictly(String paramString, String... paramVarArgs) throws ParseException {
/*  322 */     return parseDateStrictly(paramString, null, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date parseDateStrictly(String paramString, Locale paramLocale, String... paramVarArgs) throws ParseException {
/*  344 */     return parseDateWithLeniency(paramString, paramLocale, paramVarArgs, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Date parseDateWithLeniency(String paramString, Locale paramLocale, String[] paramArrayOfString, boolean paramBoolean) throws ParseException {
/*  366 */     if (paramString == null || paramArrayOfString == null) {
/*  367 */       throw new IllegalArgumentException("Date and Patterns must not be null");
/*      */     }
/*      */     
/*  370 */     TimeZone timeZone = TimeZone.getDefault();
/*  371 */     Locale locale = (paramLocale == null) ? Locale.getDefault() : paramLocale;
/*  372 */     ParsePosition parsePosition = new ParsePosition(0);
/*  373 */     Calendar calendar = Calendar.getInstance(timeZone, locale);
/*  374 */     calendar.setLenient(paramBoolean);
/*      */     
/*  376 */     for (String str : paramArrayOfString) {
/*  377 */       FastDateParser fastDateParser = new FastDateParser(str, timeZone, locale);
/*  378 */       calendar.clear();
/*      */       try {
/*  380 */         if (fastDateParser.parse(paramString, parsePosition, calendar) && parsePosition.getIndex() == paramString.length()) {
/*  381 */           return calendar.getTime();
/*      */         }
/*  383 */       } catch (IllegalArgumentException illegalArgumentException) {}
/*      */ 
/*      */       
/*  386 */       parsePosition.setIndex(0);
/*      */     } 
/*  388 */     throw new ParseException("Unable to parse the date: " + paramString, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addYears(Date paramDate, int paramInt) {
/*  402 */     return add(paramDate, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addMonths(Date paramDate, int paramInt) {
/*  416 */     return add(paramDate, 2, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addWeeks(Date paramDate, int paramInt) {
/*  430 */     return add(paramDate, 3, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addDays(Date paramDate, int paramInt) {
/*  444 */     return add(paramDate, 5, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addHours(Date paramDate, int paramInt) {
/*  458 */     return add(paramDate, 11, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addMinutes(Date paramDate, int paramInt) {
/*  472 */     return add(paramDate, 12, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addSeconds(Date paramDate, int paramInt) {
/*  486 */     return add(paramDate, 13, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date addMilliseconds(Date paramDate, int paramInt) {
/*  500 */     return add(paramDate, 14, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Date add(Date paramDate, int paramInt1, int paramInt2) {
/*  515 */     validateDateNotNull(paramDate);
/*  516 */     Calendar calendar = Calendar.getInstance();
/*  517 */     calendar.setTime(paramDate);
/*  518 */     calendar.add(paramInt1, paramInt2);
/*  519 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setYears(Date paramDate, int paramInt) {
/*  534 */     return set(paramDate, 1, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setMonths(Date paramDate, int paramInt) {
/*  549 */     return set(paramDate, 2, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setDays(Date paramDate, int paramInt) {
/*  564 */     return set(paramDate, 5, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setHours(Date paramDate, int paramInt) {
/*  580 */     return set(paramDate, 11, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setMinutes(Date paramDate, int paramInt) {
/*  595 */     return set(paramDate, 12, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setSeconds(Date paramDate, int paramInt) {
/*  610 */     return set(paramDate, 13, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date setMilliseconds(Date paramDate, int paramInt) {
/*  625 */     return set(paramDate, 14, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Date set(Date paramDate, int paramInt1, int paramInt2) {
/*  642 */     validateDateNotNull(paramDate);
/*      */     
/*  644 */     Calendar calendar = Calendar.getInstance();
/*  645 */     calendar.setLenient(false);
/*  646 */     calendar.setTime(paramDate);
/*  647 */     calendar.set(paramInt1, paramInt2);
/*  648 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar toCalendar(Date paramDate) {
/*  661 */     Calendar calendar = Calendar.getInstance();
/*  662 */     calendar.setTime(paramDate);
/*  663 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar toCalendar(Date paramDate, TimeZone paramTimeZone) {
/*  675 */     Calendar calendar = Calendar.getInstance(paramTimeZone);
/*  676 */     calendar.setTime(paramDate);
/*  677 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date round(Date paramDate, int paramInt) {
/*  708 */     validateDateNotNull(paramDate);
/*  709 */     Calendar calendar = Calendar.getInstance();
/*  710 */     calendar.setTime(paramDate);
/*  711 */     modify(calendar, paramInt, ModifyType.ROUND);
/*  712 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar round(Calendar paramCalendar, int paramInt) {
/*  743 */     if (paramCalendar == null) {
/*  744 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  746 */     Calendar calendar = (Calendar)paramCalendar.clone();
/*  747 */     modify(calendar, paramInt, ModifyType.ROUND);
/*  748 */     return calendar;
/*      */   }
/*      */   
/*      */   private static IllegalArgumentException nullDateIllegalArgumentException() {
/*  752 */     return new IllegalArgumentException("The date must not be null");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date round(Object paramObject, int paramInt) {
/*  784 */     if (paramObject == null) {
/*  785 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  787 */     if (paramObject instanceof Date)
/*  788 */       return round((Date)paramObject, paramInt); 
/*  789 */     if (paramObject instanceof Calendar) {
/*  790 */       return round((Calendar)paramObject, paramInt).getTime();
/*      */     }
/*  792 */     throw new ClassCastException("Could not round " + paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date truncate(Date paramDate, int paramInt) {
/*  813 */     validateDateNotNull(paramDate);
/*  814 */     Calendar calendar = Calendar.getInstance();
/*  815 */     calendar.setTime(paramDate);
/*  816 */     modify(calendar, paramInt, ModifyType.TRUNCATE);
/*  817 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar truncate(Calendar paramCalendar, int paramInt) {
/*  836 */     if (paramCalendar == null) {
/*  837 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  839 */     Calendar calendar = (Calendar)paramCalendar.clone();
/*  840 */     modify(calendar, paramInt, ModifyType.TRUNCATE);
/*  841 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date truncate(Object paramObject, int paramInt) {
/*  861 */     if (paramObject == null) {
/*  862 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  864 */     if (paramObject instanceof Date)
/*  865 */       return truncate((Date)paramObject, paramInt); 
/*  866 */     if (paramObject instanceof Calendar) {
/*  867 */       return truncate((Calendar)paramObject, paramInt).getTime();
/*      */     }
/*  869 */     throw new ClassCastException("Could not truncate " + paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date ceiling(Date paramDate, int paramInt) {
/*  891 */     validateDateNotNull(paramDate);
/*  892 */     Calendar calendar = Calendar.getInstance();
/*  893 */     calendar.setTime(paramDate);
/*  894 */     modify(calendar, paramInt, ModifyType.CEILING);
/*  895 */     return calendar.getTime();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Calendar ceiling(Calendar paramCalendar, int paramInt) {
/*  915 */     if (paramCalendar == null) {
/*  916 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  918 */     Calendar calendar = (Calendar)paramCalendar.clone();
/*  919 */     modify(calendar, paramInt, ModifyType.CEILING);
/*  920 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Date ceiling(Object paramObject, int paramInt) {
/*  941 */     if (paramObject == null) {
/*  942 */       throw nullDateIllegalArgumentException();
/*      */     }
/*  944 */     if (paramObject instanceof Date)
/*  945 */       return ceiling((Date)paramObject, paramInt); 
/*  946 */     if (paramObject instanceof Calendar) {
/*  947 */       return ceiling((Calendar)paramObject, paramInt).getTime();
/*      */     }
/*  949 */     throw new ClassCastException("Could not find ceiling of for type: " + paramObject.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void modify(Calendar paramCalendar, int paramInt, ModifyType paramModifyType) {
/*  963 */     if (paramCalendar.get(1) > 280000000) {
/*  964 */       throw new ArithmeticException("Calendar value too large for accurate calculations");
/*      */     }
/*      */     
/*  967 */     if (paramInt == 14) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  977 */     Date date = paramCalendar.getTime();
/*  978 */     long l = date.getTime();
/*  979 */     boolean bool1 = false;
/*      */ 
/*      */     
/*  982 */     int i = paramCalendar.get(14);
/*  983 */     if (ModifyType.TRUNCATE == paramModifyType || i < 500) {
/*  984 */       l -= i;
/*      */     }
/*  986 */     if (paramInt == 13) {
/*  987 */       bool1 = true;
/*      */     }
/*      */ 
/*      */     
/*  991 */     int j = paramCalendar.get(13);
/*  992 */     if (!bool1 && (ModifyType.TRUNCATE == paramModifyType || j < 30)) {
/*  993 */       l -= j * 1000L;
/*      */     }
/*  995 */     if (paramInt == 12) {
/*  996 */       bool1 = true;
/*      */     }
/*      */ 
/*      */     
/* 1000 */     int k = paramCalendar.get(12);
/* 1001 */     if (!bool1 && (ModifyType.TRUNCATE == paramModifyType || k < 30)) {
/* 1002 */       l -= k * 60000L;
/*      */     }
/*      */ 
/*      */     
/* 1006 */     if (date.getTime() != l) {
/* 1007 */       date.setTime(l);
/* 1008 */       paramCalendar.setTime(date);
/*      */     } 
/*      */ 
/*      */     
/* 1012 */     boolean bool2 = false;
/* 1013 */     for (int[] arrayOfInt : fields) {
/* 1014 */       for (int n : arrayOfInt) {
/* 1015 */         if (n == paramInt) {
/*      */           
/* 1017 */           if (paramModifyType == ModifyType.CEILING || (paramModifyType == ModifyType.ROUND && bool2)) {
/* 1018 */             if (paramInt == 1001) {
/*      */ 
/*      */ 
/*      */               
/* 1022 */               if (paramCalendar.get(5) == 1) {
/* 1023 */                 paramCalendar.add(5, 15);
/*      */               } else {
/* 1025 */                 paramCalendar.add(5, -15);
/* 1026 */                 paramCalendar.add(2, 1);
/*      */               }
/*      */             
/* 1029 */             } else if (paramInt == 9) {
/*      */ 
/*      */ 
/*      */               
/* 1033 */               if (paramCalendar.get(11) == 0) {
/* 1034 */                 paramCalendar.add(11, 12);
/*      */               } else {
/* 1036 */                 paramCalendar.add(11, -12);
/* 1037 */                 paramCalendar.add(5, 1);
/*      */               }
/*      */             
/*      */             }
/*      */             else {
/*      */               
/* 1043 */               paramCalendar.add(arrayOfInt[0], 1);
/*      */             } 
/*      */           }
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/* 1050 */       int m = 0;
/* 1051 */       boolean bool = false;
/*      */       
/* 1053 */       switch (paramInt) {
/*      */         case 1001:
/* 1055 */           if (arrayOfInt[0] == 5) {
/*      */ 
/*      */ 
/*      */             
/* 1059 */             m = paramCalendar.get(5) - 1;
/*      */ 
/*      */             
/* 1062 */             if (m >= 15) {
/* 1063 */               m -= 15;
/*      */             }
/*      */             
/* 1066 */             bool2 = (m > 7) ? true : false;
/* 1067 */             bool = true;
/*      */           } 
/*      */           break;
/*      */         case 9:
/* 1071 */           if (arrayOfInt[0] == 11) {
/*      */ 
/*      */             
/* 1074 */             m = paramCalendar.get(11);
/* 1075 */             if (m >= 12) {
/* 1076 */               m -= 12;
/*      */             }
/* 1078 */             bool2 = (m >= 6) ? true : false;
/* 1079 */             bool = true;
/*      */           } 
/*      */           break;
/*      */       } 
/*      */ 
/*      */       
/* 1085 */       if (!bool) {
/* 1086 */         int n = paramCalendar.getActualMinimum(arrayOfInt[0]);
/* 1087 */         int i1 = paramCalendar.getActualMaximum(arrayOfInt[0]);
/*      */         
/* 1089 */         m = paramCalendar.get(arrayOfInt[0]) - n;
/*      */         
/* 1091 */         bool2 = (m > (i1 - n) / 2) ? true : false;
/*      */       } 
/*      */       
/* 1094 */       if (m != 0) {
/* 1095 */         paramCalendar.set(arrayOfInt[0], paramCalendar.get(arrayOfInt[0]) - m);
/*      */       }
/*      */     } 
/* 1098 */     throw new IllegalArgumentException("The field " + paramInt + " is not supported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator<Calendar> iterator(Date paramDate, int paramInt) {
/* 1128 */     validateDateNotNull(paramDate);
/* 1129 */     Calendar calendar = Calendar.getInstance();
/* 1130 */     calendar.setTime(paramDate);
/* 1131 */     return iterator(calendar, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator<Calendar> iterator(Calendar paramCalendar, int paramInt) {
/* 1159 */     if (paramCalendar == null) {
/* 1160 */       throw nullDateIllegalArgumentException();
/*      */     }
/* 1162 */     Calendar calendar1 = null;
/* 1163 */     Calendar calendar2 = null;
/* 1164 */     int i = 1;
/* 1165 */     int j = 7;
/* 1166 */     switch (paramInt) {
/*      */       
/*      */       case 5:
/*      */       case 6:
/* 1170 */         calendar1 = truncate(paramCalendar, 2);
/*      */         
/* 1172 */         calendar2 = (Calendar)calendar1.clone();
/* 1173 */         calendar2.add(2, 1);
/* 1174 */         calendar2.add(5, -1);
/*      */         
/* 1176 */         if (paramInt == 6) {
/* 1177 */           i = 2;
/* 1178 */           j = 1;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/* 1186 */         calendar1 = truncate(paramCalendar, 5);
/* 1187 */         calendar2 = truncate(paramCalendar, 5);
/* 1188 */         switch (paramInt) {
/*      */ 
/*      */ 
/*      */           
/*      */           case 2:
/* 1193 */             i = 2;
/* 1194 */             j = 1;
/*      */             break;
/*      */           case 3:
/* 1197 */             i = paramCalendar.get(7);
/* 1198 */             j = i - 1;
/*      */             break;
/*      */           case 4:
/* 1201 */             i = paramCalendar.get(7) - 3;
/* 1202 */             j = paramCalendar.get(7) + 3;
/*      */             break;
/*      */         } 
/*      */         
/*      */         break;
/*      */       
/*      */       default:
/* 1209 */         throw new IllegalArgumentException("The range style " + paramInt + " is not valid.");
/*      */     } 
/* 1211 */     if (i < 1) {
/* 1212 */       i += 7;
/*      */     }
/* 1214 */     if (i > 7) {
/* 1215 */       i -= 7;
/*      */     }
/* 1217 */     if (j < 1) {
/* 1218 */       j += 7;
/*      */     }
/* 1220 */     if (j > 7) {
/* 1221 */       j -= 7;
/*      */     }
/* 1223 */     while (calendar1.get(7) != i) {
/* 1224 */       calendar1.add(5, -1);
/*      */     }
/* 1226 */     while (calendar2.get(7) != j) {
/* 1227 */       calendar2.add(5, 1);
/*      */     }
/* 1229 */     return new DateIterator(calendar1, calendar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator<?> iterator(Object paramObject, int paramInt) {
/* 1249 */     if (paramObject == null) {
/* 1250 */       throw nullDateIllegalArgumentException();
/*      */     }
/* 1252 */     if (paramObject instanceof Date)
/* 1253 */       return iterator((Date)paramObject, paramInt); 
/* 1254 */     if (paramObject instanceof Calendar) {
/* 1255 */       return iterator((Calendar)paramObject, paramInt);
/*      */     }
/* 1257 */     throw new ClassCastException("Could not iterate based on " + paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInMilliseconds(Date paramDate, int paramInt) {
/* 1293 */     return getFragment(paramDate, paramInt, TimeUnit.MILLISECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInSeconds(Date paramDate, int paramInt) {
/* 1331 */     return getFragment(paramDate, paramInt, TimeUnit.SECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInMinutes(Date paramDate, int paramInt) {
/* 1369 */     return getFragment(paramDate, paramInt, TimeUnit.MINUTES);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInHours(Date paramDate, int paramInt) {
/* 1407 */     return getFragment(paramDate, paramInt, TimeUnit.HOURS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInDays(Date paramDate, int paramInt) {
/* 1445 */     return getFragment(paramDate, paramInt, TimeUnit.DAYS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInMilliseconds(Calendar paramCalendar, int paramInt) {
/* 1483 */     return getFragment(paramCalendar, paramInt, TimeUnit.MILLISECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInSeconds(Calendar paramCalendar, int paramInt) {
/* 1520 */     return getFragment(paramCalendar, paramInt, TimeUnit.SECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInMinutes(Calendar paramCalendar, int paramInt) {
/* 1558 */     return getFragment(paramCalendar, paramInt, TimeUnit.MINUTES);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInHours(Calendar paramCalendar, int paramInt) {
/* 1596 */     return getFragment(paramCalendar, paramInt, TimeUnit.HOURS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long getFragmentInDays(Calendar paramCalendar, int paramInt) {
/* 1636 */     return getFragment(paramCalendar, paramInt, TimeUnit.DAYS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getFragment(Date paramDate, int paramInt, TimeUnit paramTimeUnit) {
/* 1651 */     validateDateNotNull(paramDate);
/* 1652 */     Calendar calendar = Calendar.getInstance();
/* 1653 */     calendar.setTime(paramDate);
/* 1654 */     return getFragment(calendar, paramInt, paramTimeUnit);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long getFragment(Calendar paramCalendar, int paramInt, TimeUnit paramTimeUnit) {
/* 1669 */     if (paramCalendar == null) {
/* 1670 */       throw nullDateIllegalArgumentException();
/*      */     }
/*      */     
/* 1673 */     long l = 0L;
/*      */     
/* 1675 */     byte b = (paramTimeUnit == TimeUnit.DAYS) ? 0 : 1;
/*      */ 
/*      */     
/* 1678 */     switch (paramInt) {
/*      */       case 1:
/* 1680 */         l += paramTimeUnit.convert((paramCalendar.get(6) - b), TimeUnit.DAYS);
/*      */         break;
/*      */       case 2:
/* 1683 */         l += paramTimeUnit.convert((paramCalendar.get(5) - b), TimeUnit.DAYS);
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1689 */     switch (paramInt) {
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 5:
/*      */       case 6:
/* 1697 */         l += paramTimeUnit.convert(paramCalendar.get(11), TimeUnit.HOURS);
/*      */       
/*      */       case 11:
/* 1700 */         l += paramTimeUnit.convert(paramCalendar.get(12), TimeUnit.MINUTES);
/*      */       
/*      */       case 12:
/* 1703 */         l += paramTimeUnit.convert(paramCalendar.get(13), TimeUnit.SECONDS);
/*      */       
/*      */       case 13:
/* 1706 */         l += paramTimeUnit.convert(paramCalendar.get(14), TimeUnit.MILLISECONDS);
/*      */ 
/*      */ 
/*      */       
/*      */       case 14:
/* 1711 */         return l;
/*      */     } 
/*      */     throw new IllegalArgumentException("The fragment " + paramInt + " is not supported");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean truncatedEquals(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt) {
/* 1728 */     return (truncatedCompareTo(paramCalendar1, paramCalendar2, paramInt) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean truncatedEquals(Date paramDate1, Date paramDate2, int paramInt) {
/* 1745 */     return (truncatedCompareTo(paramDate1, paramDate2, paramInt) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int truncatedCompareTo(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt) {
/* 1763 */     Calendar calendar1 = truncate(paramCalendar1, paramInt);
/* 1764 */     Calendar calendar2 = truncate(paramCalendar2, paramInt);
/* 1765 */     return calendar1.compareTo(calendar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int truncatedCompareTo(Date paramDate1, Date paramDate2, int paramInt) {
/* 1783 */     Date date1 = truncate(paramDate1, paramInt);
/* 1784 */     Date date2 = truncate(paramDate2, paramInt);
/* 1785 */     return date1.compareTo(date2);
/*      */   }
/*      */   
/*      */   private static void validateDateNotNull(Date paramDate) {
/* 1789 */     Validate.notNull(paramDate, "The date must not be null", new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class DateIterator
/*      */     implements Iterator<Calendar>
/*      */   {
/*      */     private final Calendar endFinal;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Calendar spot;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     DateIterator(Calendar param1Calendar1, Calendar param1Calendar2) {
/* 1808 */       this.endFinal = param1Calendar2;
/* 1809 */       this.spot = param1Calendar1;
/* 1810 */       this.spot.add(5, -1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/* 1820 */       return this.spot.before(this.endFinal);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Calendar next() {
/* 1830 */       if (this.spot.equals(this.endFinal)) {
/* 1831 */         throw new NoSuchElementException();
/*      */       }
/* 1833 */       this.spot.add(5, 1);
/* 1834 */       return (Calendar)this.spot.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void remove() {
/* 1845 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\DateUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */