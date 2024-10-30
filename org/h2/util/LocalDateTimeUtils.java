/*     */ package org.h2.util;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.Date;
/*     */ import java.sql.Time;
/*     */ import java.util.Arrays;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.h2.api.TimestampWithTimeZone;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueDate;
/*     */ import org.h2.value.ValueTime;
/*     */ import org.h2.value.ValueTimestamp;
/*     */ import org.h2.value.ValueTimestampTimeZone;
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
/*     */ public class LocalDateTimeUtils
/*     */ {
/*     */   private static Class<?> LOCAL_DATE;
/*     */   private static Class<?> LOCAL_TIME;
/*     */   private static Class<?> LOCAL_DATE_TIME;
/*     */   private static Class<?> OFFSET_DATE_TIME;
/*     */   private static Class<?> ZONE_OFFSET;
/*     */   private static Method TO_LOCAL_DATE;
/*     */   private static Method TO_LOCAL_TIME;
/*     */   private static Method DATE_VALUE_OF;
/*     */   private static Method TIME_VALUE_OF;
/*     */   private static Method LOCAL_DATE_OF_YEAR_MONTH_DAY;
/*     */   private static Method LOCAL_DATE_PARSE;
/*     */   private static Method LOCAL_DATE_GET_YEAR;
/*     */   private static Method LOCAL_DATE_GET_MONTH_VALUE;
/*     */   private static Method LOCAL_DATE_GET_DAY_OF_MONTH;
/*     */   private static Method LOCAL_DATE_AT_START_OF_DAY;
/*     */   private static Method LOCAL_TIME_PARSE;
/*     */   private static Method LOCAL_DATE_TIME_PLUS_NANOS;
/*     */   private static Method LOCAL_DATE_TIME_TO_LOCAL_DATE;
/*     */   private static Method LOCAL_DATE_TIME_TRUNCATED_TO;
/*     */   private static Method LOCAL_DATE_TIME_PARSE;
/*     */   private static Method ZONE_OFFSET_OF_TOTAL_SECONDS;
/*     */   private static Method OFFSET_DATE_TIME_OF_LOCAL_DATE_TIME_ZONE_OFFSET;
/*     */   private static Method OFFSET_DATE_TIME_PARSE;
/*     */   private static Method OFFSET_DATE_TIME_TO_LOCAL_DATE_TIME;
/*     */   private static Method OFFSET_DATE_TIME_GET_OFFSET;
/*     */   private static Method ZONE_OFFSET_GET_TOTAL_SECONDS;
/*     */   private static Method DURATION_BETWEEN;
/*     */   private static Method DURATION_TO_NANOS;
/*     */   private static Object CHRONO_UNIT_DAYS;
/*     */   private static final boolean IS_JAVA8_DATE_API_PRESENT;
/*     */   
/*     */   static {
/*     */     boolean bool;
/*     */     try {
/* 128 */       LOCAL_DATE = Class.forName("java.time.LocalDate");
/* 129 */       LOCAL_TIME = Class.forName("java.time.LocalTime");
/* 130 */       LOCAL_DATE_TIME = Class.forName("java.time.LocalDateTime");
/* 131 */       OFFSET_DATE_TIME = Class.forName("java.time.OffsetDateTime");
/* 132 */       ZONE_OFFSET = Class.forName("java.time.ZoneOffset");
/* 133 */       bool = true;
/* 134 */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       
/* 136 */       bool = false;
/*     */     } 
/* 138 */     IS_JAVA8_DATE_API_PRESENT = bool;
/*     */     
/* 140 */     if (IS_JAVA8_DATE_API_PRESENT) {
/*     */       
/* 142 */       Class<?> clazz1 = getClass("java.time.temporal.TemporalUnit");
/* 143 */       Class<?> clazz2 = getClass("java.time.temporal.ChronoUnit");
/* 144 */       Class<?> clazz3 = getClass("java.time.Duration");
/* 145 */       Class<?> clazz4 = getClass("java.time.temporal.Temporal");
/*     */       
/* 147 */       TO_LOCAL_DATE = getMethod(Date.class, "toLocalDate", new Class[0]);
/* 148 */       TO_LOCAL_TIME = getMethod(Time.class, "toLocalTime", new Class[0]);
/*     */       
/* 150 */       DATE_VALUE_OF = getMethod(Date.class, "valueOf", new Class[] { LOCAL_DATE });
/* 151 */       TIME_VALUE_OF = getMethod(Time.class, "valueOf", new Class[] { LOCAL_TIME });
/*     */       
/* 153 */       LOCAL_DATE_OF_YEAR_MONTH_DAY = getMethod(LOCAL_DATE, "of", new Class[] { int.class, int.class, int.class });
/*     */       
/* 155 */       LOCAL_DATE_PARSE = getMethod(LOCAL_DATE, "parse", new Class[] { CharSequence.class });
/*     */       
/* 157 */       LOCAL_DATE_GET_YEAR = getMethod(LOCAL_DATE, "getYear", new Class[0]);
/* 158 */       LOCAL_DATE_GET_MONTH_VALUE = getMethod(LOCAL_DATE, "getMonthValue", new Class[0]);
/* 159 */       LOCAL_DATE_GET_DAY_OF_MONTH = getMethod(LOCAL_DATE, "getDayOfMonth", new Class[0]);
/* 160 */       LOCAL_DATE_AT_START_OF_DAY = getMethod(LOCAL_DATE, "atStartOfDay", new Class[0]);
/*     */       
/* 162 */       LOCAL_TIME_PARSE = getMethod(LOCAL_TIME, "parse", new Class[] { CharSequence.class });
/*     */       
/* 164 */       LOCAL_DATE_TIME_PLUS_NANOS = getMethod(LOCAL_DATE_TIME, "plusNanos", new Class[] { long.class });
/* 165 */       LOCAL_DATE_TIME_TO_LOCAL_DATE = getMethod(LOCAL_DATE_TIME, "toLocalDate", new Class[0]);
/* 166 */       LOCAL_DATE_TIME_TRUNCATED_TO = getMethod(LOCAL_DATE_TIME, "truncatedTo", new Class[] { clazz1 });
/* 167 */       LOCAL_DATE_TIME_PARSE = getMethod(LOCAL_DATE_TIME, "parse", new Class[] { CharSequence.class });
/*     */       
/* 169 */       ZONE_OFFSET_OF_TOTAL_SECONDS = getMethod(ZONE_OFFSET, "ofTotalSeconds", new Class[] { int.class });
/*     */       
/* 171 */       OFFSET_DATE_TIME_TO_LOCAL_DATE_TIME = getMethod(OFFSET_DATE_TIME, "toLocalDateTime", new Class[0]);
/* 172 */       OFFSET_DATE_TIME_GET_OFFSET = getMethod(OFFSET_DATE_TIME, "getOffset", new Class[0]);
/* 173 */       OFFSET_DATE_TIME_OF_LOCAL_DATE_TIME_ZONE_OFFSET = getMethod(OFFSET_DATE_TIME, "of", new Class[] { LOCAL_DATE_TIME, ZONE_OFFSET });
/*     */       
/* 175 */       OFFSET_DATE_TIME_PARSE = getMethod(OFFSET_DATE_TIME, "parse", new Class[] { CharSequence.class });
/*     */       
/* 177 */       ZONE_OFFSET_GET_TOTAL_SECONDS = getMethod(ZONE_OFFSET, "getTotalSeconds", new Class[0]);
/*     */       
/* 179 */       DURATION_BETWEEN = getMethod(clazz3, "between", new Class[] { clazz4, clazz4 });
/* 180 */       DURATION_TO_NANOS = getMethod(clazz3, "toNanos", new Class[0]);
/*     */       
/* 182 */       CHRONO_UNIT_DAYS = getFieldValue(clazz2, "DAYS");
/*     */     } 
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
/*     */   public static boolean isJava8DateApiPresent() {
/* 199 */     return IS_JAVA8_DATE_API_PRESENT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<?> getLocalDateClass() {
/* 208 */     return LOCAL_DATE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<?> getLocalTimeClass() {
/* 218 */     return LOCAL_TIME;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<?> getLocalDateTimeClass() {
/* 227 */     return LOCAL_DATE_TIME;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Class<?> getOffsetDateTimeClass() {
/* 236 */     return OFFSET_DATE_TIME;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object parseLocalDate(CharSequence paramCharSequence) {
/*     */     try {
/* 247 */       return LOCAL_DATE_PARSE.invoke(null, new Object[] { paramCharSequence });
/* 248 */     } catch (IllegalAccessException|InvocationTargetException illegalAccessException) {
/* 249 */       throw new IllegalArgumentException("error when parsing text '" + paramCharSequence + "'", illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object parseLocalTime(CharSequence paramCharSequence) {
/*     */     try {
/* 261 */       return LOCAL_TIME_PARSE.invoke(null, new Object[] { paramCharSequence });
/* 262 */     } catch (IllegalAccessException|InvocationTargetException illegalAccessException) {
/* 263 */       throw new IllegalArgumentException("error when parsing text '" + paramCharSequence + "'", illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object parseLocalDateTime(CharSequence paramCharSequence) {
/*     */     try {
/* 275 */       return LOCAL_DATE_TIME_PARSE.invoke(null, new Object[] { paramCharSequence });
/* 276 */     } catch (IllegalAccessException|InvocationTargetException illegalAccessException) {
/* 277 */       throw new IllegalArgumentException("error when parsing text '" + paramCharSequence + "'", illegalAccessException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Object parseOffsetDateTime(CharSequence paramCharSequence) {
/*     */     try {
/* 289 */       return OFFSET_DATE_TIME_PARSE.invoke(null, new Object[] { paramCharSequence });
/* 290 */     } catch (IllegalAccessException|InvocationTargetException illegalAccessException) {
/* 291 */       throw new IllegalArgumentException("error when parsing text '" + paramCharSequence + "'", illegalAccessException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Class<?> getClass(String paramString) {
/*     */     try {
/* 297 */       return Class.forName(paramString);
/* 298 */     } catch (ClassNotFoundException classNotFoundException) {
/* 299 */       throw new IllegalStateException("Java 8 or later but class " + paramString + " is missing", classNotFoundException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Method getMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) {
/*     */     try {
/* 307 */       return paramClass.getMethod(paramString, paramVarArgs);
/* 308 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 309 */       throw new IllegalStateException("Java 8 or later but method " + paramClass.getName() + "#" + paramString + "(" + Arrays.toString(paramVarArgs) + ") is missing", noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object getFieldValue(Class<?> paramClass, String paramString) {
/*     */     try {
/* 317 */       return paramClass.getField(paramString).get(null);
/* 318 */     } catch (NoSuchFieldException|IllegalAccessException noSuchFieldException) {
/* 319 */       throw new IllegalStateException("Java 8 or later but field " + paramClass.getName() + "#" + paramString + " is missing", noSuchFieldException);
/*     */     } 
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
/*     */   public static boolean isLocalDate(Class<?> paramClass) {
/* 333 */     return (LOCAL_DATE == paramClass);
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
/*     */   public static boolean isLocalTime(Class<?> paramClass) {
/* 345 */     return (LOCAL_TIME == paramClass);
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
/*     */   public static boolean isLocalDateTime(Class<?> paramClass) {
/* 357 */     return (LOCAL_DATE_TIME == paramClass);
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
/*     */   public static boolean isOffsetDateTime(Class<?> paramClass) {
/* 369 */     return (OFFSET_DATE_TIME == paramClass);
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
/*     */   public static Object valueToLocalDate(Value paramValue) {
/* 381 */     return dateToLocalDate(paramValue.getDate());
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
/*     */   public static Object valueToLocalTime(Value paramValue) {
/* 393 */     return timeToLocalTime(paramValue.getTime());
/*     */   }
/*     */   
/*     */   private static Object dateToLocalDate(Date paramDate) {
/*     */     try {
/* 398 */       return TO_LOCAL_DATE.invoke(paramDate, new Object[0]);
/* 399 */     } catch (IllegalAccessException illegalAccessException) {
/* 400 */       throw DbException.convert(illegalAccessException);
/* 401 */     } catch (InvocationTargetException invocationTargetException) {
/* 402 */       throw DbException.convertInvocation(invocationTargetException, "date conversion failed");
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Object timeToLocalTime(Time paramTime) {
/*     */     try {
/* 408 */       return TO_LOCAL_TIME.invoke(paramTime, new Object[0]);
/* 409 */     } catch (IllegalAccessException illegalAccessException) {
/* 410 */       throw DbException.convert(illegalAccessException);
/* 411 */     } catch (InvocationTargetException invocationTargetException) {
/* 412 */       throw DbException.convertInvocation(invocationTargetException, "time conversion failed");
/*     */     } 
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
/*     */   public static Object valueToLocalDateTime(ValueTimestamp paramValueTimestamp) {
/* 426 */     long l1 = paramValueTimestamp.getDateValue();
/* 427 */     long l2 = paramValueTimestamp.getTimeNanos();
/*     */     try {
/* 429 */       Object object1 = localDateFromDateValue(l1);
/* 430 */       Object object2 = LOCAL_DATE_AT_START_OF_DAY.invoke(object1, new Object[0]);
/* 431 */       return LOCAL_DATE_TIME_PLUS_NANOS.invoke(object2, new Object[] { Long.valueOf(l2) });
/* 432 */     } catch (IllegalAccessException illegalAccessException) {
/* 433 */       throw DbException.convert(illegalAccessException);
/* 434 */     } catch (InvocationTargetException invocationTargetException) {
/* 435 */       throw DbException.convertInvocation(invocationTargetException, "timestamp conversion failed");
/*     */     } 
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
/*     */   public static Object valueToOffsetDateTime(ValueTimestampTimeZone paramValueTimestampTimeZone) {
/* 448 */     return timestampWithTimeZoneToOffsetDateTime((TimestampWithTimeZone)paramValueTimestampTimeZone.getObject());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object timestampWithTimeZoneToOffsetDateTime(TimestampWithTimeZone paramTimestampWithTimeZone) {
/* 454 */     long l1 = paramTimestampWithTimeZone.getYMD();
/* 455 */     long l2 = paramTimestampWithTimeZone.getNanosSinceMidnight();
/*     */     try {
/* 457 */       Object object1 = localDateTimeFromDateNanos(l1, l2);
/*     */       
/* 459 */       short s = paramTimestampWithTimeZone.getTimeZoneOffsetMins();
/* 460 */       int i = (int)TimeUnit.MINUTES.toSeconds(s);
/*     */       
/* 462 */       Object object2 = ZONE_OFFSET_OF_TOTAL_SECONDS.invoke(null, new Object[] { Integer.valueOf(i) });
/*     */       
/* 464 */       return OFFSET_DATE_TIME_OF_LOCAL_DATE_TIME_ZONE_OFFSET.invoke(null, new Object[] { object1, object2 });
/*     */     }
/* 466 */     catch (IllegalAccessException illegalAccessException) {
/* 467 */       throw DbException.convert(illegalAccessException);
/* 468 */     } catch (InvocationTargetException invocationTargetException) {
/* 469 */       throw DbException.convertInvocation(invocationTargetException, "timestamp with time zone conversion failed");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Value localDateToDateValue(Object paramObject) {
/*     */     try {
/* 481 */       Date date = (Date)DATE_VALUE_OF.invoke(null, new Object[] { paramObject });
/* 482 */       return (Value)ValueDate.get(date);
/* 483 */     } catch (IllegalAccessException illegalAccessException) {
/* 484 */       throw DbException.convert(illegalAccessException);
/* 485 */     } catch (InvocationTargetException invocationTargetException) {
/* 486 */       throw DbException.convertInvocation(invocationTargetException, "date conversion failed");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Value localTimeToTimeValue(Object paramObject) {
/*     */     try {
/* 498 */       Time time = (Time)TIME_VALUE_OF.invoke(null, new Object[] { paramObject });
/* 499 */       return (Value)ValueTime.get(time);
/* 500 */     } catch (IllegalAccessException illegalAccessException) {
/* 501 */       throw DbException.convert(illegalAccessException);
/* 502 */     } catch (InvocationTargetException invocationTargetException) {
/* 503 */       throw DbException.convertInvocation(invocationTargetException, "time conversion failed");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Value localDateTimeToValue(Object paramObject) {
/*     */     try {
/* 515 */       Object object = LOCAL_DATE_TIME_TO_LOCAL_DATE.invoke(paramObject, new Object[0]);
/* 516 */       long l1 = dateValueFromLocalDate(object);
/* 517 */       long l2 = timeNanosFromLocalDate(paramObject);
/* 518 */       return (Value)ValueTimestamp.fromDateValueAndNanos(l1, l2);
/* 519 */     } catch (IllegalAccessException illegalAccessException) {
/* 520 */       throw DbException.convert(illegalAccessException);
/* 521 */     } catch (InvocationTargetException invocationTargetException) {
/* 522 */       throw DbException.convertInvocation(invocationTargetException, "local date time conversion failed");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Value offsetDateTimeToValue(Object paramObject) {
/*     */     try {
/* 534 */       Object object1 = OFFSET_DATE_TIME_TO_LOCAL_DATE_TIME.invoke(paramObject, new Object[0]);
/* 535 */       Object object2 = LOCAL_DATE_TIME_TO_LOCAL_DATE.invoke(object1, new Object[0]);
/* 536 */       Object object3 = OFFSET_DATE_TIME_GET_OFFSET.invoke(paramObject, new Object[0]);
/*     */       
/* 538 */       long l1 = dateValueFromLocalDate(object2);
/* 539 */       long l2 = timeNanosFromLocalDate(object1);
/* 540 */       short s = zoneOffsetToOffsetMinute(object3);
/* 541 */       return (Value)ValueTimestampTimeZone.fromDateValueAndNanos(l1, l2, s);
/*     */     }
/* 543 */     catch (IllegalAccessException illegalAccessException) {
/* 544 */       throw DbException.convert(illegalAccessException);
/* 545 */     } catch (InvocationTargetException invocationTargetException) {
/* 546 */       throw DbException.convertInvocation(invocationTargetException, "time conversion failed");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static long dateValueFromLocalDate(Object paramObject) throws IllegalAccessException, InvocationTargetException {
/* 552 */     int i = ((Integer)LOCAL_DATE_GET_YEAR.invoke(paramObject, new Object[0])).intValue();
/* 553 */     int j = ((Integer)LOCAL_DATE_GET_MONTH_VALUE.invoke(paramObject, new Object[0])).intValue();
/* 554 */     int k = ((Integer)LOCAL_DATE_GET_DAY_OF_MONTH.invoke(paramObject, new Object[0])).intValue();
/* 555 */     return DateTimeUtils.dateValue(i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   private static long timeNanosFromLocalDate(Object paramObject) throws IllegalAccessException, InvocationTargetException {
/* 560 */     Object object1 = LOCAL_DATE_TIME_TRUNCATED_TO.invoke(paramObject, new Object[] { CHRONO_UNIT_DAYS });
/* 561 */     Object object2 = DURATION_BETWEEN.invoke(null, new Object[] { object1, paramObject });
/* 562 */     return ((Long)DURATION_TO_NANOS.invoke(object2, new Object[0])).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private static short zoneOffsetToOffsetMinute(Object paramObject) throws IllegalAccessException, InvocationTargetException {
/* 567 */     int i = ((Integer)ZONE_OFFSET_GET_TOTAL_SECONDS.invoke(paramObject, new Object[0])).intValue();
/* 568 */     return (short)(int)TimeUnit.SECONDS.toMinutes(i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object localDateFromDateValue(long paramLong) throws IllegalAccessException, InvocationTargetException {
/* 574 */     int i = DateTimeUtils.yearFromDateValue(paramLong);
/* 575 */     int j = DateTimeUtils.monthFromDateValue(paramLong);
/* 576 */     int k = DateTimeUtils.dayFromDateValue(paramLong);
/*     */     
/* 578 */     return LOCAL_DATE_OF_YEAR_MONTH_DAY.invoke(null, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
/*     */   }
/*     */ 
/*     */   
/*     */   private static Object localDateTimeFromDateNanos(long paramLong1, long paramLong2) throws IllegalAccessException, InvocationTargetException {
/* 583 */     Object object1 = localDateFromDateValue(paramLong1);
/* 584 */     Object object2 = LOCAL_DATE_AT_START_OF_DAY.invoke(object1, new Object[0]);
/* 585 */     return LOCAL_DATE_TIME_PLUS_NANOS.invoke(object2, new Object[] { Long.valueOf(paramLong2) });
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\LocalDateTimeUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */