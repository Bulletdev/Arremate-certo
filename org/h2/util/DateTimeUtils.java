/*     */ package org.h2.util;
/*     */ 
/*     */ import java.sql.Date;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueDate;
/*     */ import org.h2.value.ValueNull;
/*     */ import org.h2.value.ValueTime;
/*     */ import org.h2.value.ValueTimestamp;
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
/*     */ public class DateTimeUtils
/*     */ {
/*     */   public static final long MILLIS_PER_DAY = 86400000L;
/*     */   private static final long NANOS_PER_DAY = 86400000000000L;
/*     */   private static final int SHIFT_YEAR = 9;
/*     */   private static final int SHIFT_MONTH = 5;
/*  43 */   private static final int[] NORMAL_DAYS_PER_MONTH = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private static final int[] DAYS_OFFSET = new int[] { 0, 31, 61, 92, 122, 153, 184, 214, 245, 275, 306, 337, 366 };
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
/*  60 */   private static final ThreadLocal<Calendar> CACHED_CALENDAR = new ThreadLocal<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   private static final ThreadLocal<Calendar> CACHED_CALENDAR_NON_DEFAULT_TIMEZONE = new ThreadLocal<>();
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
/*  76 */   private static int zoneOffsetMillis = Calendar.getInstance().get(15);
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
/*     */   public static void resetCalendar() {
/*  88 */     CACHED_CALENDAR.remove();
/*  89 */     zoneOffsetMillis = Calendar.getInstance().get(15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Calendar getCalendar() {
/*  98 */     Calendar calendar = CACHED_CALENDAR.get();
/*  99 */     if (calendar == null) {
/* 100 */       calendar = Calendar.getInstance();
/* 101 */       CACHED_CALENDAR.set(calendar);
/*     */     } 
/* 103 */     calendar.clear();
/* 104 */     return calendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Calendar getCalendar(TimeZone paramTimeZone) {
/* 114 */     Calendar calendar = CACHED_CALENDAR_NON_DEFAULT_TIMEZONE.get();
/* 115 */     if (calendar == null || !calendar.getTimeZone().equals(paramTimeZone)) {
/* 116 */       calendar = Calendar.getInstance(paramTimeZone);
/* 117 */       CACHED_CALENDAR_NON_DEFAULT_TIMEZONE.set(calendar);
/*     */     } 
/* 119 */     calendar.clear();
/* 120 */     return calendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date convertDate(Value paramValue, Calendar paramCalendar) {
/* 131 */     if (paramValue == ValueNull.INSTANCE) {
/* 132 */       return null;
/*     */     }
/* 134 */     ValueDate valueDate = (ValueDate)paramValue.convertTo(10);
/* 135 */     Calendar calendar = (Calendar)paramCalendar.clone();
/* 136 */     calendar.clear();
/* 137 */     calendar.setLenient(true);
/* 138 */     long l1 = valueDate.getDateValue();
/* 139 */     setCalendarFields(calendar, yearFromDateValue(l1), monthFromDateValue(l1), dayFromDateValue(l1), 0, 0, 0, 0);
/*     */ 
/*     */     
/* 142 */     long l2 = calendar.getTimeInMillis();
/* 143 */     return new Date(l2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Time convertTime(Value paramValue, Calendar paramCalendar) {
/* 154 */     if (paramValue == ValueNull.INSTANCE) {
/* 155 */       return null;
/*     */     }
/* 157 */     ValueTime valueTime = (ValueTime)paramValue.convertTo(9);
/* 158 */     Calendar calendar = (Calendar)paramCalendar.clone();
/* 159 */     calendar.clear();
/* 160 */     calendar.setLenient(true);
/* 161 */     long l1 = valueTime.getNanos();
/* 162 */     long l2 = l1 / 1000000L;
/* 163 */     l1 -= l2 * 1000000L;
/* 164 */     long l3 = l2 / 1000L;
/* 165 */     l2 -= l3 * 1000L;
/* 166 */     long l4 = l3 / 60L;
/* 167 */     l3 -= l4 * 60L;
/* 168 */     long l5 = l4 / 60L;
/* 169 */     l4 -= l5 * 60L;
/* 170 */     setCalendarFields(calendar, 1970, 1, 1, (int)l5, (int)l4, (int)l3, (int)l2);
/*     */     
/* 172 */     long l6 = calendar.getTimeInMillis();
/* 173 */     return new Time(l6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Timestamp convertTimestamp(Value paramValue, Calendar paramCalendar) {
/* 184 */     if (paramValue == ValueNull.INSTANCE) {
/* 185 */       return null;
/*     */     }
/* 187 */     ValueTimestamp valueTimestamp = (ValueTimestamp)paramValue.convertTo(11);
/* 188 */     Calendar calendar = (Calendar)paramCalendar.clone();
/* 189 */     calendar.clear();
/* 190 */     calendar.setLenient(true);
/* 191 */     long l1 = valueTimestamp.getDateValue();
/* 192 */     long l2 = valueTimestamp.getTimeNanos();
/* 193 */     long l3 = l2 / 1000000L;
/* 194 */     l2 -= l3 * 1000000L;
/* 195 */     long l4 = l3 / 1000L;
/* 196 */     l3 -= l4 * 1000L;
/* 197 */     long l5 = l4 / 60L;
/* 198 */     l4 -= l5 * 60L;
/* 199 */     long l6 = l5 / 60L;
/* 200 */     l5 -= l6 * 60L;
/* 201 */     setCalendarFields(calendar, yearFromDateValue(l1), monthFromDateValue(l1), dayFromDateValue(l1), (int)l6, (int)l5, (int)l4, (int)l3);
/*     */ 
/*     */     
/* 204 */     long l7 = calendar.getTimeInMillis();
/* 205 */     Timestamp timestamp = new Timestamp(l7);
/* 206 */     timestamp.setNanos((int)(l2 + l3 * 1000000L));
/* 207 */     return timestamp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueDate convertDate(Date paramDate, Calendar paramCalendar) {
/* 218 */     if (paramCalendar == null) {
/* 219 */       throw DbException.getInvalidValueException("calendar", null);
/*     */     }
/* 221 */     Calendar calendar = (Calendar)paramCalendar.clone();
/* 222 */     calendar.setTimeInMillis(paramDate.getTime());
/* 223 */     long l = dateValueFromCalendar(calendar);
/* 224 */     return ValueDate.fromDateValue(l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueTime convertTime(Time paramTime, Calendar paramCalendar) {
/* 235 */     if (paramCalendar == null) {
/* 236 */       throw DbException.getInvalidValueException("calendar", null);
/*     */     }
/* 238 */     Calendar calendar = (Calendar)paramCalendar.clone();
/* 239 */     calendar.setTimeInMillis(paramTime.getTime());
/* 240 */     long l = nanosFromCalendar(calendar);
/* 241 */     return ValueTime.fromNanos(l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long convertToLocal(Date paramDate, Calendar paramCalendar) {
/* 252 */     if (paramCalendar == null) {
/* 253 */       throw DbException.getInvalidValueException("calendar", null);
/*     */     }
/* 255 */     paramCalendar = (Calendar)paramCalendar.clone();
/* 256 */     Calendar calendar = Calendar.getInstance();
/* 257 */     synchronized (calendar) {
/* 258 */       calendar.setTime(paramDate);
/* 259 */       convertTime(calendar, paramCalendar);
/*     */     } 
/* 261 */     return paramCalendar.getTime().getTime();
/*     */   }
/*     */   
/*     */   private static void convertTime(Calendar paramCalendar1, Calendar paramCalendar2) {
/* 265 */     paramCalendar2.set(0, paramCalendar1.get(0));
/* 266 */     paramCalendar2.set(1, paramCalendar1.get(1));
/* 267 */     paramCalendar2.set(2, paramCalendar1.get(2));
/* 268 */     paramCalendar2.set(5, paramCalendar1.get(5));
/* 269 */     paramCalendar2.set(11, paramCalendar1.get(11));
/* 270 */     paramCalendar2.set(12, paramCalendar1.get(12));
/* 271 */     paramCalendar2.set(13, paramCalendar1.get(13));
/* 272 */     paramCalendar2.set(14, paramCalendar1.get(14));
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
/*     */   public static ValueTimestamp convertTimestamp(Timestamp paramTimestamp, Calendar paramCalendar) {
/* 284 */     if (paramCalendar == null) {
/* 285 */       throw DbException.getInvalidValueException("calendar", null);
/*     */     }
/* 287 */     Calendar calendar = (Calendar)paramCalendar.clone();
/* 288 */     calendar.setTimeInMillis(paramTimestamp.getTime());
/* 289 */     long l1 = dateValueFromCalendar(calendar);
/* 290 */     long l2 = nanosFromCalendar(calendar);
/* 291 */     l2 += (paramTimestamp.getNanos() % 1000000);
/* 292 */     return ValueTimestamp.fromDateValueAndNanos(l1, l2);
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
/*     */   public static long parseDateValue(String paramString, int paramInt1, int paramInt2) {
/* 305 */     if (paramString.charAt(paramInt1) == '+')
/*     */     {
/* 307 */       paramInt1++;
/*     */     }
/*     */     
/* 310 */     int i = paramString.indexOf('-', paramInt1 + 1);
/* 311 */     int j = paramString.indexOf('-', i + 1);
/* 312 */     if (i <= 0 || j <= i) {
/* 313 */       throw new IllegalArgumentException(paramString);
/*     */     }
/* 315 */     int k = Integer.parseInt(paramString.substring(paramInt1, i));
/* 316 */     int m = Integer.parseInt(paramString.substring(i + 1, j));
/* 317 */     int n = Integer.parseInt(paramString.substring(j + 1, paramInt2));
/* 318 */     if (!isValidDate(k, m, n)) {
/* 319 */       throw new IllegalArgumentException(k + "-" + m + "-" + n);
/*     */     }
/* 321 */     return dateValue(k, m, n);
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
/*     */   public static long parseTimeNanos(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
/*     */     boolean bool;
/* 338 */     int i = 0, j = 0, k = 0;
/* 339 */     long l = 0L;
/* 340 */     int m = paramString.indexOf(':', paramInt1);
/* 341 */     int n = paramString.indexOf(':', m + 1);
/* 342 */     int i1 = paramString.indexOf('.', n + 1);
/* 343 */     if (m <= 0 || n <= m) {
/*     */ 
/*     */       
/* 346 */       m = paramString.indexOf('.', paramInt1);
/* 347 */       n = paramString.indexOf('.', m + 1);
/* 348 */       i1 = paramString.indexOf('.', n + 1);
/*     */       
/* 350 */       if (m <= 0 || n <= m) {
/* 351 */         throw new IllegalArgumentException(paramString);
/*     */       }
/*     */     } 
/*     */     
/* 355 */     i = Integer.parseInt(paramString.substring(paramInt1, m));
/* 356 */     if (i < 0) {
/* 357 */       if (paramBoolean) {
/* 358 */         throw new IllegalArgumentException(paramString);
/*     */       }
/* 360 */       bool = true;
/* 361 */       i = -i;
/*     */     } else {
/* 363 */       bool = false;
/*     */     } 
/* 365 */     j = Integer.parseInt(paramString.substring(m + 1, n));
/* 366 */     if (i1 < 0) {
/* 367 */       k = Integer.parseInt(paramString.substring(n + 1, paramInt2));
/*     */     } else {
/* 369 */       k = Integer.parseInt(paramString.substring(n + 1, i1));
/* 370 */       String str = (paramString.substring(i1 + 1, paramInt2) + "000000000").substring(0, 9);
/* 371 */       l = Integer.parseInt(str);
/*     */     } 
/* 373 */     if (i >= 2000000 || j < 0 || j >= 60 || k < 0 || k >= 60)
/*     */     {
/* 375 */       throw new IllegalArgumentException(paramString);
/*     */     }
/* 377 */     if (paramBoolean && i >= 24) {
/* 378 */       throw new IllegalArgumentException(paramString);
/*     */     }
/* 380 */     l += ((i * 60L + j) * 60L + k) * 1000000000L;
/* 381 */     return bool ? -l : l;
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
/*     */   
/*     */   public static long getMillis(TimeZone paramTimeZone, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/*     */     try {
/* 402 */       return getTimeTry(false, paramTimeZone, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
/*     */     }
/* 404 */     catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */       
/* 407 */       String str = illegalArgumentException.toString();
/* 408 */       if (str.indexOf("HOUR_OF_DAY") > 0) {
/* 409 */         if (paramInt4 < 0 || paramInt4 > 23) {
/* 410 */           throw illegalArgumentException;
/*     */         }
/* 412 */         return getTimeTry(true, paramTimeZone, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
/*     */       } 
/* 414 */       if (str.indexOf("DAY_OF_MONTH") > 0) {
/*     */         int i;
/* 416 */         if (paramInt2 == 2) {
/* 417 */           i = (new GregorianCalendar()).isLeapYear(paramInt1) ? 29 : 28;
/*     */         } else {
/* 419 */           i = 30 + (paramInt2 + ((paramInt2 > 7) ? 1 : 0) & 0x1);
/*     */         } 
/* 421 */         if (paramInt3 < 1 || paramInt3 > i) {
/* 422 */           throw illegalArgumentException;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 427 */         paramInt4 += 6;
/* 428 */         return getTimeTry(true, paramTimeZone, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
/*     */       } 
/*     */       
/* 431 */       return getTimeTry(true, paramTimeZone, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long getTimeTry(boolean paramBoolean, TimeZone paramTimeZone, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/*     */     Calendar calendar;
/* 440 */     if (paramTimeZone == null) {
/* 441 */       calendar = getCalendar();
/*     */     } else {
/* 443 */       calendar = getCalendar(paramTimeZone);
/*     */     } 
/* 445 */     calendar.setLenient(paramBoolean);
/* 446 */     setCalendarFields(calendar, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
/* 447 */     return calendar.getTime().getTime();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setCalendarFields(Calendar paramCalendar, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
/* 452 */     if (paramInt1 <= 0) {
/* 453 */       paramCalendar.set(0, 0);
/* 454 */       paramCalendar.set(1, 1 - paramInt1);
/*     */     } else {
/* 456 */       paramCalendar.set(0, 1);
/* 457 */       paramCalendar.set(1, paramInt1);
/*     */     } 
/*     */     
/* 460 */     paramCalendar.set(2, paramInt2 - 1);
/* 461 */     paramCalendar.set(5, paramInt3);
/* 462 */     paramCalendar.set(11, paramInt4);
/* 463 */     paramCalendar.set(12, paramInt5);
/* 464 */     paramCalendar.set(13, paramInt6);
/* 465 */     paramCalendar.set(14, paramInt7);
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
/*     */   public static int getDatePart(Date paramDate, int paramInt) {
/* 477 */     Calendar calendar = getCalendar();
/* 478 */     calendar.setTime(paramDate);
/* 479 */     if (paramInt == 1) {
/* 480 */       return getYear(calendar);
/*     */     }
/* 482 */     int i = calendar.get(paramInt);
/* 483 */     if (paramInt == 2) {
/* 484 */       return i + 1;
/*     */     }
/* 486 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getYear(Calendar paramCalendar) {
/* 496 */     int i = paramCalendar.get(1);
/* 497 */     if (paramCalendar.get(0) == 0) {
/* 498 */       i = 1 - i;
/*     */     }
/* 500 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getTimeLocalWithoutDst(Date paramDate) {
/* 511 */     return paramDate.getTime() + zoneOffsetMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getTimeUTCWithoutDst(long paramLong) {
/* 522 */     return paramLong - zoneOffsetMillis;
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
/*     */   public static int getIsoDayOfWeek(Date paramDate) {
/* 534 */     Calendar calendar = Calendar.getInstance();
/* 535 */     calendar.setTimeInMillis(paramDate.getTime());
/* 536 */     int i = calendar.get(7) - 1;
/* 537 */     return (i == 0) ? 7 : i;
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
/*     */   public static int getIsoWeek(Date paramDate) {
/* 555 */     Calendar calendar = Calendar.getInstance();
/* 556 */     calendar.setTimeInMillis(paramDate.getTime());
/* 557 */     calendar.setFirstDayOfWeek(2);
/* 558 */     calendar.setMinimalDaysInFirstWeek(4);
/* 559 */     return calendar.get(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getIsoYear(Date paramDate) {
/* 570 */     Calendar calendar = Calendar.getInstance();
/* 571 */     calendar.setTimeInMillis(paramDate.getTime());
/* 572 */     calendar.setFirstDayOfWeek(2);
/* 573 */     calendar.setMinimalDaysInFirstWeek(4);
/* 574 */     int i = getYear(calendar);
/* 575 */     int j = calendar.get(2);
/* 576 */     int k = calendar.get(3);
/* 577 */     if (j == 0 && k > 51) {
/* 578 */       i--;
/* 579 */     } else if (j == 11 && k == 1) {
/* 580 */       i++;
/*     */     } 
/* 582 */     return i;
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
/*     */   public static String formatDateTime(Date paramDate, String paramString1, String paramString2, String paramString3) {
/* 596 */     SimpleDateFormat simpleDateFormat = getDateFormat(paramString1, paramString2, paramString3);
/* 597 */     synchronized (simpleDateFormat) {
/* 598 */       return simpleDateFormat.format(paramDate);
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
/*     */   public static Date parseDateTime(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 613 */     SimpleDateFormat simpleDateFormat = getDateFormat(paramString2, paramString3, paramString4);
/*     */     try {
/* 615 */       synchronized (simpleDateFormat) {
/* 616 */         return simpleDateFormat.parse(paramString1);
/*     */       } 
/* 618 */     } catch (Exception exception) {
/*     */       
/* 620 */       throw DbException.get(90014, exception, new String[] { paramString1 });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static SimpleDateFormat getDateFormat(String paramString1, String paramString2, String paramString3) {
/*     */     try {
/*     */       SimpleDateFormat simpleDateFormat;
/* 630 */       if (paramString2 == null) {
/* 631 */         simpleDateFormat = new SimpleDateFormat(paramString1);
/*     */       } else {
/* 633 */         Locale locale = new Locale(paramString2);
/* 634 */         simpleDateFormat = new SimpleDateFormat(paramString1, locale);
/*     */       } 
/* 636 */       if (paramString3 != null) {
/* 637 */         simpleDateFormat.setTimeZone(TimeZone.getTimeZone(paramString3));
/*     */       }
/* 639 */       return simpleDateFormat;
/* 640 */     } catch (Exception exception) {
/* 641 */       throw DbException.get(90014, exception, new String[] { paramString1 + "/" + paramString2 + "/" + paramString3 });
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
/*     */   public static boolean isValidDate(int paramInt1, int paramInt2, int paramInt3) {
/* 655 */     if (paramInt2 < 1 || paramInt2 > 12 || paramInt3 < 1) {
/* 656 */       return false;
/*     */     }
/* 658 */     if (paramInt1 > 1582) {
/*     */       
/* 660 */       if (paramInt2 != 2) {
/* 661 */         return (paramInt3 <= NORMAL_DAYS_PER_MONTH[paramInt2]);
/*     */       }
/*     */       
/* 664 */       if ((paramInt1 & 0x3) != 0) {
/* 665 */         return (paramInt3 <= 28);
/*     */       }
/* 667 */       return (paramInt3 <= ((paramInt1 % 100 != 0 || paramInt1 % 400 == 0) ? 29 : 28));
/* 668 */     }  if (paramInt1 == 1582 && paramInt2 == 10)
/*     */     {
/* 670 */       return (paramInt3 <= 31 && (paramInt3 < 5 || paramInt3 > 14));
/*     */     }
/* 672 */     if (paramInt2 != 2 && paramInt3 <= NORMAL_DAYS_PER_MONTH[paramInt2]) {
/* 673 */       return true;
/*     */     }
/* 675 */     return (paramInt3 <= (((paramInt1 & 0x3) != 0) ? 28 : 29));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date convertDateValueToDate(long paramLong) {
/* 686 */     long l = getMillis(null, yearFromDateValue(paramLong), monthFromDateValue(paramLong), dayFromDateValue(paramLong), 0, 0, 0, 0);
/*     */ 
/*     */     
/* 689 */     return new Date(l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long convertDateValueToMillis(TimeZone paramTimeZone, long paramLong) {
/* 700 */     return getMillis(paramTimeZone, yearFromDateValue(paramLong), monthFromDateValue(paramLong), dayFromDateValue(paramLong), 0, 0, 0, 0);
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
/*     */   public static Timestamp convertDateValueToTimestamp(long paramLong1, long paramLong2) {
/* 715 */     long l1 = paramLong2 / 1000000L;
/* 716 */     paramLong2 -= l1 * 1000000L;
/* 717 */     long l2 = l1 / 1000L;
/* 718 */     l1 -= l2 * 1000L;
/* 719 */     long l3 = l2 / 60L;
/* 720 */     l2 -= l3 * 60L;
/* 721 */     long l4 = l3 / 60L;
/* 722 */     l3 -= l4 * 60L;
/* 723 */     long l5 = getMillis(null, yearFromDateValue(paramLong1), monthFromDateValue(paramLong1), dayFromDateValue(paramLong1), (int)l4, (int)l3, (int)l2, 0);
/*     */ 
/*     */     
/* 726 */     Timestamp timestamp = new Timestamp(l5);
/* 727 */     timestamp.setNanos((int)(paramLong2 + l1 * 1000000L));
/* 728 */     return timestamp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Time convertNanoToTime(long paramLong) {
/* 738 */     long l1 = paramLong / 1000000L;
/* 739 */     long l2 = l1 / 1000L;
/* 740 */     l1 -= l2 * 1000L;
/* 741 */     long l3 = l2 / 60L;
/* 742 */     l2 -= l3 * 60L;
/* 743 */     long l4 = l3 / 60L;
/* 744 */     l3 -= l4 * 60L;
/* 745 */     long l5 = getMillis(null, 1970, 1, 1, (int)(l4 % 24L), (int)l3, (int)l2, (int)l1);
/*     */     
/* 747 */     return new Time(l5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int yearFromDateValue(long paramLong) {
/* 757 */     return (int)(paramLong >>> 9L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int monthFromDateValue(long paramLong) {
/* 767 */     return (int)(paramLong >>> 5L) & 0xF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int dayFromDateValue(long paramLong) {
/* 777 */     return (int)(paramLong & 0x1FL);
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
/*     */   public static long dateValue(long paramLong, int paramInt1, int paramInt2) {
/* 789 */     return paramLong << 9L | (paramInt1 << 5) | paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long dateValueFromDate(long paramLong) {
/* 800 */     Calendar calendar = getCalendar();
/* 801 */     calendar.setTimeInMillis(paramLong);
/* 802 */     return dateValueFromCalendar(calendar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long dateValueFromCalendar(Calendar paramCalendar) {
/* 813 */     int i = getYear(paramCalendar);
/* 814 */     int j = paramCalendar.get(2) + 1;
/* 815 */     int k = paramCalendar.get(5);
/* 816 */     return i << 9L | (j << 5) | k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nanosFromDate(long paramLong) {
/* 827 */     Calendar calendar = getCalendar();
/* 828 */     calendar.setTimeInMillis(paramLong);
/* 829 */     return nanosFromCalendar(calendar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long nanosFromCalendar(Calendar paramCalendar) {
/* 839 */     int i = paramCalendar.get(11);
/* 840 */     int j = paramCalendar.get(12);
/* 841 */     int k = paramCalendar.get(13);
/* 842 */     int m = paramCalendar.get(14);
/* 843 */     return (((i * 60L + j) * 60L + k) * 1000L + m) * 1000000L;
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
/*     */   public static ValueTimestamp normalizeTimestamp(long paramLong1, long paramLong2) {
/* 855 */     if (paramLong2 > 86400000000000L || paramLong2 < 0L) {
/*     */       long l;
/* 857 */       if (paramLong2 > 86400000000000L) {
/* 858 */         l = paramLong2 / 86400000000000L;
/*     */       } else {
/* 860 */         l = (paramLong2 - 86400000000000L + 1L) / 86400000000000L;
/*     */       } 
/* 862 */       paramLong2 -= l * 86400000000000L;
/* 863 */       paramLong1 += l;
/*     */     } 
/* 865 */     return ValueTimestamp.fromDateValueAndNanos(dateValueFromAbsoluteDay(paramLong1), paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long absoluteDayFromDateValue(long paramLong) {
/* 876 */     long l1 = yearFromDateValue(paramLong);
/* 877 */     int i = monthFromDateValue(paramLong);
/* 878 */     int j = dayFromDateValue(paramLong);
/* 879 */     if (i <= 2) {
/* 880 */       l1--;
/* 881 */       i += 12;
/*     */     } 
/* 883 */     long l2 = (l1 * 2922L >> 3L) + DAYS_OFFSET[i - 3] + j - 719484L;
/* 884 */     if (l1 <= 1582L && (l1 < 1582L || i * 100 + j < 1005)) {
/*     */       
/* 886 */       l2 += 13L;
/* 887 */     } else if (l1 < 1901L || l1 > 2099L) {
/*     */       
/* 889 */       l2 += l1 / 400L - l1 / 100L + 15L;
/*     */     } 
/* 891 */     return l2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long dateValueFromAbsoluteDay(long paramLong) {
/* 901 */     long l3, l1 = paramLong + 719468L;
/* 902 */     long l2 = 0L;
/* 903 */     if (l1 > 578040L) {
/*     */       
/* 905 */       long l = l1 / 146097L;
/* 906 */       l1 -= l * 146097L;
/* 907 */       l2 = l1 / 36524L;
/* 908 */       l1 -= l2 * 36524L;
/* 909 */       l3 = l * 400L + l2 * 100L;
/*     */     } else {
/*     */       
/* 912 */       l1 += 292200000002L;
/* 913 */       l3 = -800000000L;
/*     */     } 
/* 915 */     long l4 = l1 / 1461L;
/* 916 */     l1 -= l4 * 1461L;
/* 917 */     long l5 = l1 / 365L;
/* 918 */     l1 -= l5 * 365L;
/* 919 */     if (l1 == 0L && (l5 == 4L || l2 == 4L)) {
/* 920 */       l5--;
/* 921 */       l1 += 365L;
/*     */     } 
/* 923 */     l5 += l3 + l4 * 4L;
/*     */     
/* 925 */     int i = ((int)l1 * 2 + 1) * 5 / 306;
/* 926 */     l1 -= (DAYS_OFFSET[i] - 1);
/* 927 */     if (i >= 10) {
/* 928 */       l5++;
/* 929 */       i -= 12;
/*     */     } 
/* 931 */     return dateValue(l5, i + 3, (int)l1);
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
/*     */   public static Timestamp addMonths(Timestamp paramTimestamp, int paramInt) {
/* 945 */     Calendar calendar = Calendar.getInstance();
/* 946 */     calendar.setTime(paramTimestamp);
/* 947 */     calendar.add(2, paramInt);
/*     */     
/* 949 */     Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
/* 950 */     timestamp.setNanos(paramTimestamp.getNanos());
/* 951 */     return timestamp;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\DateTimeUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */