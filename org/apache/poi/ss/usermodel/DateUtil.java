/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateUtil
/*     */ {
/*     */   public static final int SECONDS_PER_MINUTE = 60;
/*     */   public static final int MINUTES_PER_HOUR = 60;
/*     */   public static final int HOURS_PER_DAY = 24;
/*     */   public static final int SECONDS_PER_DAY = 86400;
/*     */   private static final int BAD_DATE = -1;
/*     */   public static final long DAY_MILLISECONDS = 86400000L;
/*  44 */   private static final Pattern TIME_SEPARATOR_PATTERN = Pattern.compile(":");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   private static final Pattern date_ptrn1 = Pattern.compile("^\\[\\$\\-.*?\\]");
/*  50 */   private static final Pattern date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+\\]");
/*  51 */   private static final Pattern date_ptrn3a = Pattern.compile("[yYmMdDhHsS]");
/*  52 */   private static final Pattern date_ptrn3b = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/,. :\"\\\\]+0*[ampAMP/]*$");
/*     */   
/*  54 */   private static final Pattern date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)\\]");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getExcelDate(Date paramDate) {
/*  64 */     return getExcelDate(paramDate, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getExcelDate(Date paramDate, boolean paramBoolean) {
/*  75 */     Calendar calendar = LocaleUtil.getLocaleCalendar();
/*  76 */     calendar.setTime(paramDate);
/*  77 */     return internalGetExcelDate(calendar, paramBoolean);
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
/*     */   public static double getExcelDate(Calendar paramCalendar, boolean paramBoolean) {
/*  91 */     return internalGetExcelDate((Calendar)paramCalendar.clone(), paramBoolean);
/*     */   }
/*     */   private static double internalGetExcelDate(Calendar paramCalendar, boolean paramBoolean) {
/*  94 */     if ((!paramBoolean && paramCalendar.get(1) < 1900) || (paramBoolean && paramCalendar.get(1) < 1904))
/*     */     {
/*     */       
/*  97 */       return -1.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     double d1 = (((paramCalendar.get(11) * 60 + paramCalendar.get(12)) * 60 + paramCalendar.get(13)) * 1000 + paramCalendar.get(14)) / 8.64E7D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     Calendar calendar = dayStart(paramCalendar);
/*     */     
/* 113 */     double d2 = d1 + absoluteDay(calendar, paramBoolean);
/*     */     
/* 115 */     if (!paramBoolean && d2 >= 60.0D) {
/* 116 */       d2++;
/* 117 */     } else if (paramBoolean) {
/* 118 */       d2--;
/*     */     } 
/*     */     
/* 121 */     return d2;
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
/*     */   public static Date getJavaDate(double paramDouble, TimeZone paramTimeZone) {
/* 138 */     return getJavaDate(paramDouble, false, paramTimeZone, false);
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
/*     */   public static Date getJavaDate(double paramDouble) {
/* 158 */     return getJavaDate(paramDouble, false, null, false);
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
/*     */   public static Date getJavaDate(double paramDouble, boolean paramBoolean, TimeZone paramTimeZone) {
/* 177 */     return getJavaDate(paramDouble, paramBoolean, paramTimeZone, false);
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
/*     */   public static Date getJavaDate(double paramDouble, boolean paramBoolean1, TimeZone paramTimeZone, boolean paramBoolean2) {
/* 197 */     Calendar calendar = getJavaCalendar(paramDouble, paramBoolean1, paramTimeZone, paramBoolean2);
/* 198 */     return (calendar == null) ? null : calendar.getTime();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getJavaDate(double paramDouble, boolean paramBoolean) {
/* 221 */     return getJavaDate(paramDouble, paramBoolean, null, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setCalendar(Calendar paramCalendar, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
/* 226 */     char c = 'ݬ';
/* 227 */     byte b = -1;
/* 228 */     if (paramBoolean1) {
/* 229 */       c = 'ݰ';
/* 230 */       b = 1;
/*     */     }
/* 232 */     else if (paramInt1 < 61) {
/*     */ 
/*     */       
/* 235 */       b = 0;
/*     */     } 
/* 237 */     paramCalendar.set(c, 0, paramInt1 + b, 0, 0, 0);
/* 238 */     paramCalendar.set(14, paramInt2);
/* 239 */     if (paramCalendar.get(14) == 0) {
/* 240 */       paramCalendar.clear(14);
/*     */     }
/* 242 */     if (paramBoolean2) {
/* 243 */       paramCalendar.add(14, 500);
/* 244 */       paramCalendar.clear(14);
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
/*     */   public static Calendar getJavaCalendar(double paramDouble) {
/* 256 */     return getJavaCalendar(paramDouble, false, (TimeZone)null, false);
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
/*     */   public static Calendar getJavaCalendar(double paramDouble, boolean paramBoolean) {
/* 268 */     return getJavaCalendar(paramDouble, paramBoolean, (TimeZone)null, false);
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
/*     */   public static Calendar getJavaCalendarUTC(double paramDouble, boolean paramBoolean) {
/* 281 */     return getJavaCalendar(paramDouble, paramBoolean, LocaleUtil.TIMEZONE_UTC, false);
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
/*     */   public static Calendar getJavaCalendar(double paramDouble, boolean paramBoolean, TimeZone paramTimeZone) {
/* 294 */     return getJavaCalendar(paramDouble, paramBoolean, paramTimeZone, false);
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
/*     */   public static Calendar getJavaCalendar(double paramDouble, boolean paramBoolean1, TimeZone paramTimeZone, boolean paramBoolean2) {
/*     */     Calendar calendar;
/* 307 */     if (!isValidExcelDate(paramDouble)) {
/* 308 */       return null;
/*     */     }
/* 310 */     int i = (int)Math.floor(paramDouble);
/* 311 */     int j = (int)((paramDouble - i) * 8.64E7D + 0.5D);
/*     */     
/* 313 */     if (paramTimeZone != null) {
/* 314 */       calendar = LocaleUtil.getLocaleCalendar(paramTimeZone);
/*     */     } else {
/* 316 */       calendar = LocaleUtil.getLocaleCalendar();
/*     */     } 
/* 318 */     setCalendar(calendar, i, j, paramBoolean1, paramBoolean2);
/* 319 */     return calendar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 326 */   private static ThreadLocal<Integer> lastFormatIndex = new ThreadLocal<Integer>() {
/*     */       protected Integer initialValue() {
/* 328 */         return Integer.valueOf(-1);
/*     */       }
/*     */     };
/* 331 */   private static ThreadLocal<String> lastFormatString = new ThreadLocal<String>();
/* 332 */   private static ThreadLocal<Boolean> lastCachedResult = new ThreadLocal<Boolean>();
/*     */   
/*     */   private static boolean isCached(String paramString, int paramInt) {
/* 335 */     String str = lastFormatString.get();
/* 336 */     return (str != null && paramInt == ((Integer)lastFormatIndex.get()).intValue() && paramString.equals(str));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void cache(String paramString, int paramInt, boolean paramBoolean) {
/* 341 */     lastFormatIndex.set(Integer.valueOf(paramInt));
/* 342 */     lastFormatString.set(paramString);
/* 343 */     lastCachedResult.set(Boolean.valueOf(paramBoolean));
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
/*     */   public static boolean isADateFormat(int paramInt, String paramString) {
/* 362 */     if (isInternalDateFormat(paramInt)) {
/* 363 */       cache(paramString, paramInt, true);
/* 364 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 368 */     if (paramString == null || paramString.length() == 0) {
/* 369 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 373 */     if (isCached(paramString, paramInt)) {
/* 374 */       return ((Boolean)lastCachedResult.get()).booleanValue();
/*     */     }
/*     */     
/* 377 */     String str = paramString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 398 */     int i = str.length();
/* 399 */     StringBuilder stringBuilder = new StringBuilder(i); int j;
/* 400 */     for (j = 0; j < i; ) {
/* 401 */       char c = str.charAt(j);
/* 402 */       if (j < i - 1) {
/* 403 */         char c1 = str.charAt(j + 1);
/* 404 */         if (c == '\\')
/* 405 */         { switch (c1)
/*     */           { case ' ':
/*     */             case ',':
/*     */             case '-':
/*     */             case '.':
/*     */             case '\\':
/*     */               break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             default:
/* 420 */               stringBuilder.append(c); break; }  } else if (c == ';' && c1 == '@') { j++; } else {  }  j++;
/*     */       } 
/* 422 */     }  str = stringBuilder.toString();
/*     */ 
/*     */     
/* 425 */     if (date_ptrn4.matcher(str).matches()) {
/* 426 */       cache(paramString, paramInt, true);
/* 427 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 432 */     str = date_ptrn1.matcher(str).replaceAll("");
/*     */ 
/*     */     
/* 435 */     str = date_ptrn2.matcher(str).replaceAll("");
/*     */ 
/*     */ 
/*     */     
/* 439 */     j = str.indexOf(';');
/* 440 */     if (0 < j && j < str.length() - 1) {
/* 441 */       str = str.substring(0, j);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 446 */     if (!date_ptrn3a.matcher(str).find()) {
/* 447 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 454 */     boolean bool = date_ptrn3b.matcher(str).matches();
/* 455 */     cache(paramString, paramInt, bool);
/* 456 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isInternalDateFormat(int paramInt) {
/* 465 */     switch (paramInt) {
/*     */ 
/*     */       
/*     */       case 14:
/*     */       case 15:
/*     */       case 16:
/*     */       case 17:
/*     */       case 18:
/*     */       case 19:
/*     */       case 20:
/*     */       case 21:
/*     */       case 22:
/*     */       case 45:
/*     */       case 46:
/*     */       case 47:
/* 480 */         return true;
/*     */     } 
/* 482 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isCellDateFormatted(Cell paramCell) {
/* 493 */     if (paramCell == null) return false; 
/* 494 */     boolean bool = false;
/*     */     
/* 496 */     double d = paramCell.getNumericCellValue();
/* 497 */     if (isValidExcelDate(d)) {
/* 498 */       CellStyle cellStyle = paramCell.getCellStyle();
/* 499 */       if (cellStyle == null) return false; 
/* 500 */       short s = cellStyle.getDataFormat();
/* 501 */       String str = cellStyle.getDataFormatString();
/* 502 */       bool = isADateFormat(s, str);
/*     */     } 
/* 504 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isCellInternalDateFormatted(Cell paramCell) {
/* 515 */     if (paramCell == null) return false; 
/* 516 */     boolean bool = false;
/*     */     
/* 518 */     double d = paramCell.getNumericCellValue();
/* 519 */     if (isValidExcelDate(d)) {
/* 520 */       CellStyle cellStyle = paramCell.getCellStyle();
/* 521 */       short s = cellStyle.getDataFormat();
/* 522 */       bool = isInternalDateFormat(s);
/*     */     } 
/* 524 */     return bool;
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
/*     */   public static boolean isValidExcelDate(double paramDouble) {
/* 537 */     return (paramDouble > -4.9E-324D);
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
/*     */   protected static int absoluteDay(Calendar paramCalendar, boolean paramBoolean) {
/* 549 */     return paramCalendar.get(6) + daysInPriorYears(paramCalendar.get(1), paramBoolean);
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
/*     */   private static int daysInPriorYears(int paramInt, boolean paramBoolean) {
/* 564 */     if ((!paramBoolean && paramInt < 1900) || (paramBoolean && paramInt < 1904)) {
/* 565 */       throw new IllegalArgumentException("'year' must be 1900 or greater");
/*     */     }
/*     */     
/* 568 */     int i = paramInt - 1;
/* 569 */     int j = i / 4 - i / 100 + i / 400 - 460;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 574 */     return 365 * (paramInt - (paramBoolean ? 1904 : 1900)) + j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Calendar dayStart(Calendar paramCalendar) {
/* 580 */     paramCalendar.get(11);
/*     */     
/* 582 */     paramCalendar.set(11, 0);
/* 583 */     paramCalendar.set(12, 0);
/* 584 */     paramCalendar.set(13, 0);
/* 585 */     paramCalendar.set(14, 0);
/* 586 */     paramCalendar.get(11);
/*     */     
/* 588 */     return paramCalendar;
/*     */   }
/*     */   
/*     */   private static final class FormatException
/*     */     extends Exception
/*     */   {
/*     */     public FormatException(String param1String) {
/* 595 */       super(param1String);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double convertTime(String paramString) {
/*     */     try {
/* 606 */       return convertTimeInternal(paramString);
/* 607 */     } catch (FormatException formatException) {
/* 608 */       String str = "Bad time format '" + paramString + "' expected 'HH:MM' or 'HH:MM:SS' - " + formatException.getMessage();
/*     */       
/* 610 */       throw new IllegalArgumentException(str);
/*     */     }  } private static double convertTimeInternal(String paramString) throws FormatException { String str1, str2, str3;
/*     */     int j, k, m;
/*     */     double d;
/* 614 */     int i = paramString.length();
/* 615 */     if (i < 4 || i > 8) {
/* 616 */       throw new FormatException("Bad length");
/*     */     }
/* 618 */     String[] arrayOfString = TIME_SEPARATOR_PATTERN.split(paramString);
/*     */ 
/*     */     
/* 621 */     switch (arrayOfString.length) { case 2:
/* 622 */         str1 = "00";
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 627 */         str2 = arrayOfString[0];
/* 628 */         str3 = arrayOfString[1];
/* 629 */         j = parseInt(str2, "hour", 24);
/* 630 */         k = parseInt(str3, "minute", 60);
/* 631 */         m = parseInt(str1, "second", 60);
/*     */         
/* 633 */         d = (m + (k + j * 60) * 60);
/* 634 */         return d / 86400.0D;case 3: str1 = arrayOfString[2]; str2 = arrayOfString[0]; str3 = arrayOfString[1]; j = parseInt(str2, "hour", 24); k = parseInt(str3, "minute", 60); m = parseInt(str1, "second", 60); d = (m + (k + j * 60) * 60); return d / 86400.0D; }
/*     */     
/*     */     throw new FormatException("Expected 2 or 3 fields but got (" + arrayOfString.length + ")"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date parseYYYYMMDDDate(String paramString) {
/*     */     try {
/* 643 */       return parseYYYYMMDDDateInternal(paramString);
/* 644 */     } catch (FormatException formatException) {
/* 645 */       String str = "Bad time format " + paramString + " expected 'YYYY/MM/DD' - " + formatException.getMessage();
/*     */       
/* 647 */       throw new IllegalArgumentException(str);
/*     */     } 
/*     */   }
/*     */   private static Date parseYYYYMMDDDateInternal(String paramString) throws FormatException {
/* 651 */     if (paramString.length() != 10) {
/* 652 */       throw new FormatException("Bad length");
/*     */     }
/*     */     
/* 655 */     String str1 = paramString.substring(0, 4);
/* 656 */     String str2 = paramString.substring(5, 7);
/* 657 */     String str3 = paramString.substring(8, 10);
/* 658 */     int i = parseInt(str1, "year", -32768, 32767);
/* 659 */     int j = parseInt(str2, "month", 1, 12);
/* 660 */     int k = parseInt(str3, "day", 1, 31);
/*     */     
/* 662 */     Calendar calendar = LocaleUtil.getLocaleCalendar(i, j - 1, k);
/* 663 */     return calendar.getTime();
/*     */   }
/*     */   private static int parseInt(String paramString1, String paramString2, int paramInt) throws FormatException {
/* 666 */     return parseInt(paramString1, paramString2, 0, paramInt - 1);
/*     */   }
/*     */   
/*     */   private static int parseInt(String paramString1, String paramString2, int paramInt1, int paramInt2) throws FormatException {
/*     */     int i;
/*     */     try {
/* 672 */       i = Integer.parseInt(paramString1);
/* 673 */     } catch (NumberFormatException numberFormatException) {
/* 674 */       throw new FormatException("Bad int format '" + paramString1 + "' for " + paramString2 + " field");
/*     */     } 
/* 676 */     if (i < paramInt1 || i > paramInt2) {
/* 677 */       throw new FormatException(paramString2 + " value (" + i + ") is outside the allowable range(0.." + paramInt2 + ")");
/*     */     }
/*     */     
/* 680 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\DateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */