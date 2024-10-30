/*     */ package org.h2.util;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.TimeZone;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.h2.message.DbException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ToDateTokenizer
/*     */ {
/*  35 */   static final Pattern PATTERN_NUMBER = Pattern.compile("^([+-]?[0-9]+)");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   static final Pattern PATTERN_FOUR_DIGITS = Pattern.compile("^([+-]?[0-9]{4})");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  45 */   static final Pattern PATTERN_TWO_TO_FOUR_DIGITS = Pattern.compile("^([+-]?[0-9]{2,4})");
/*     */ 
/*     */ 
/*     */   
/*  49 */   static final Pattern PATTERN_THREE_DIGITS = Pattern.compile("^([+-]?[0-9]{3})");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   static final Pattern PATTERN_TWO_DIGITS = Pattern.compile("^([+-]?[0-9]{2})");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   static final Pattern PATTERN_TWO_DIGITS_OR_LESS = Pattern.compile("^([+-]?[0-9][0-9]?)");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   static final Pattern PATTERN_ONE_DIGIT = Pattern.compile("^([+-]?[0-9])");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  71 */   static final Pattern PATTERN_FF = Pattern.compile("^(FF[0-9]?)", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  77 */   static final Pattern PATTERN_AM_PM = Pattern.compile("^(AM|A\\.M\\.|PM|P\\.M\\.)", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   static final Pattern PATTERN_BC_AD = Pattern.compile("^(BC|B\\.C\\.|AD|A\\.D\\.)", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   static final YearParslet PARSLET_YEAR = new YearParslet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   static final MonthParslet PARSLET_MONTH = new MonthParslet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   static final DayParslet PARSLET_DAY = new DayParslet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 104 */   static final TimeParslet PARSLET_TIME = new TimeParslet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int MILLIS_IN_HOUR = 3600000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class YearParslet
/*     */     implements ToDateParslet
/*     */   {
/*     */     public void parse(ToDateParser param1ToDateParser, ToDateTokenizer.FormatTokenEnum param1FormatTokenEnum, String param1String) {
/*     */       Calendar calendar2;
/*     */       int j;
/* 135 */       Calendar calendar1 = param1ToDateParser.getResultCalendar();
/* 136 */       String str = null;
/* 137 */       int i = 0;
/* 138 */       switch (param1FormatTokenEnum) {
/*     */         case SYYYY:
/*     */         case YYYY:
/*     */         case IYYY:
/* 142 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_FOUR_DIGITS, param1ToDateParser, param1FormatTokenEnum);
/*     */ 
/*     */           
/* 145 */           if (str.startsWith("+")) {
/* 146 */             str = str.substring(1);
/*     */           }
/* 148 */           i = Integer.parseInt(str);
/*     */ 
/*     */           
/* 151 */           if (i == 0) {
/* 152 */             ToDateTokenizer.throwException(param1ToDateParser, "Year may not be zero");
/*     */           }
/* 154 */           calendar1.set(1, (i >= 0) ? i : (i + 1));
/*     */           break;
/*     */         case YYY:
/*     */         case IYY:
/* 158 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_THREE_DIGITS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 160 */           i = Integer.parseInt(str);
/*     */ 
/*     */           
/* 163 */           calendar1.set(1, (i >= 0) ? i : (i + 1));
/*     */           break;
/*     */         case RRRR:
/* 166 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_TO_FOUR_DIGITS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 168 */           i = Integer.parseInt(str);
/* 169 */           if (str.length() < 4) {
/* 170 */             if (i < 50) {
/* 171 */               i += 2000;
/* 172 */             } else if (i < 100) {
/* 173 */               i += 1900;
/*     */             } 
/*     */           }
/* 176 */           if (i == 0) {
/* 177 */             ToDateTokenizer.throwException(param1ToDateParser, "Year may not be zero");
/*     */           }
/* 179 */           calendar1.set(1, i);
/*     */           break;
/*     */         case RR:
/* 182 */           calendar2 = Calendar.getInstance();
/* 183 */           j = calendar2.get(1) / 100;
/* 184 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 186 */           i = Integer.parseInt(str) + j * 100;
/* 187 */           calendar1.set(1, i);
/*     */           break;
/*     */         case EE:
/* 190 */           ToDateTokenizer.throwException(param1ToDateParser, String.format("token '%s' not supported yet.", new Object[] { param1FormatTokenEnum.name() }));
/*     */           break;
/*     */         
/*     */         case E:
/* 194 */           ToDateTokenizer.throwException(param1ToDateParser, String.format("token '%s' not supported yet.", new Object[] { param1FormatTokenEnum.name() }));
/*     */           break;
/*     */         
/*     */         case YY:
/*     */         case IY:
/* 199 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 201 */           i = Integer.parseInt(str);
/*     */ 
/*     */           
/* 204 */           calendar1.set(1, (i >= 0) ? i : (i + 1));
/*     */           break;
/*     */         case SCC:
/*     */         case CC:
/* 208 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 210 */           i = Integer.parseInt(str) * 100;
/* 211 */           calendar1.set(1, i);
/*     */           break;
/*     */         case Y:
/*     */         case I:
/* 215 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_ONE_DIGIT, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 217 */           i = Integer.parseInt(str);
/*     */ 
/*     */           
/* 220 */           calendar1.set(1, (i >= 0) ? i : (i + 1));
/*     */           break;
/*     */         case BC_AD:
/* 223 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_BC_AD, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 225 */           if (str.toUpperCase().startsWith("B")) {
/* 226 */             calendar1.set(0, 0); break;
/*     */           } 
/* 228 */           calendar1.set(0, 1);
/*     */           break;
/*     */         
/*     */         default:
/* 232 */           throw new IllegalArgumentException(String.format("%s: Internal Error. Unhandled case: %s", new Object[] { getClass().getSimpleName(), param1FormatTokenEnum }));
/*     */       } 
/*     */ 
/*     */       
/* 236 */       param1ToDateParser.remove(str, param1String);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class MonthParslet
/*     */     implements ToDateParslet
/*     */   {
/* 244 */     private static final String[] ROMAN_MONTH = new String[] { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII" };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void parse(ToDateParser param1ToDateParser, ToDateTokenizer.FormatTokenEnum param1FormatTokenEnum, String param1String) {
/* 250 */       Calendar calendar = param1ToDateParser.getResultCalendar();
/* 251 */       String str1 = param1ToDateParser.getInputStr();
/* 252 */       String str2 = null;
/* 253 */       int i = 0;
/* 254 */       switch (param1FormatTokenEnum) {
/*     */         case MONTH:
/* 256 */           str2 = ToDateTokenizer.setByName(calendar, param1ToDateParser, 2, 2);
/*     */           break;
/*     */         
/*     */         case Q:
/* 260 */           ToDateTokenizer.throwException(param1ToDateParser, String.format("token '%s' not supported yet.", new Object[] { param1FormatTokenEnum.name() }));
/*     */           break;
/*     */         
/*     */         case MON:
/* 264 */           str2 = ToDateTokenizer.setByName(calendar, param1ToDateParser, 2, 1);
/*     */           break;
/*     */ 
/*     */         
/*     */         case MM:
/* 269 */           str2 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS_OR_LESS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 271 */           i = Integer.parseInt(str2);
/* 272 */           calendar.set(2, i - 1);
/*     */           break;
/*     */         case RM:
/* 275 */           i = 0;
/* 276 */           for (String str : ROMAN_MONTH) {
/* 277 */             i++;
/* 278 */             int j = str.length();
/* 279 */             if (str1.length() >= j && str.equalsIgnoreCase(str1.substring(0, j))) {
/*     */               
/* 281 */               calendar.set(2, i);
/* 282 */               str2 = str;
/*     */               break;
/*     */             } 
/*     */           } 
/* 286 */           if (str2 == null || str2.isEmpty()) {
/* 287 */             ToDateTokenizer.throwException(param1ToDateParser, String.format("Issue happened when parsing token '%s'. Expected one of: %s", new Object[] { param1FormatTokenEnum.name(), Arrays.toString((Object[])ROMAN_MONTH) }));
/*     */           }
/*     */           break;
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 294 */           throw new IllegalArgumentException(String.format("%s: Internal Error. Unhandled case: %s", new Object[] { getClass().getSimpleName(), param1FormatTokenEnum }));
/*     */       } 
/*     */ 
/*     */       
/* 298 */       param1ToDateParser.remove(str2, param1String);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class DayParslet
/*     */     implements ToDateParslet
/*     */   {
/*     */     public void parse(ToDateParser param1ToDateParser, ToDateTokenizer.FormatTokenEnum param1FormatTokenEnum, String param1String) {
/* 309 */       Calendar calendar = param1ToDateParser.getResultCalendar();
/* 310 */       String str = null;
/* 311 */       int i = 0;
/* 312 */       switch (param1FormatTokenEnum) {
/*     */         case DDD:
/* 314 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_NUMBER, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 316 */           i = Integer.parseInt(str);
/* 317 */           calendar.set(6, i);
/*     */           break;
/*     */         case DD:
/* 320 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS_OR_LESS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 322 */           i = Integer.parseInt(str);
/* 323 */           calendar.set(5, i);
/*     */           break;
/*     */         case D:
/* 326 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_ONE_DIGIT, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 328 */           i = Integer.parseInt(str);
/* 329 */           calendar.set(5, i);
/*     */           break;
/*     */         case DAY:
/* 332 */           str = ToDateTokenizer.setByName(calendar, param1ToDateParser, 7, 2);
/*     */           break;
/*     */         
/*     */         case DY:
/* 336 */           str = ToDateTokenizer.setByName(calendar, param1ToDateParser, 7, 1);
/*     */           break;
/*     */         
/*     */         case J:
/* 340 */           str = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_NUMBER, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/*     */           try {
/* 343 */             Date date = (new SimpleDateFormat("Myydd")).parse(str);
/* 344 */             calendar.setTime(date);
/* 345 */           } catch (ParseException parseException) {
/* 346 */             ToDateTokenizer.throwException(param1ToDateParser, String.format("Failed to parse Julian date: %s", new Object[] { str }));
/*     */           } 
/*     */           break;
/*     */         
/*     */         default:
/* 351 */           throw new IllegalArgumentException(String.format("%s: Internal Error. Unhandled case: %s", new Object[] { getClass().getSimpleName(), param1FormatTokenEnum }));
/*     */       } 
/*     */ 
/*     */       
/* 355 */       param1ToDateParser.remove(str, param1String);
/*     */     }
/*     */   }
/*     */   
/*     */   static class TimeParslet
/*     */     implements ToDateParslet {
/*     */     public void parse(ToDateParser param1ToDateParser, ToDateTokenizer.FormatTokenEnum param1FormatTokenEnum, String param1String) {
/*     */       String str2;
/*     */       Double double_;
/*     */       TimeZone timeZone;
/*     */       int j;
/*     */       String str3;
/* 367 */       Calendar calendar = param1ToDateParser.getResultCalendar();
/* 368 */       String str1 = null;
/* 369 */       int i = 0;
/* 370 */       switch (param1FormatTokenEnum) {
/*     */         case HH24:
/* 372 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS_OR_LESS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 374 */           i = Integer.parseInt(str1);
/* 375 */           calendar.set(11, i);
/*     */           break;
/*     */         case HH12:
/*     */         case HH:
/* 379 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS_OR_LESS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 381 */           i = Integer.parseInt(str1);
/* 382 */           calendar.set(10, i);
/*     */           break;
/*     */         case MI:
/* 385 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS_OR_LESS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 387 */           i = Integer.parseInt(str1);
/* 388 */           calendar.set(12, i);
/*     */           break;
/*     */         case SS:
/* 391 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS_OR_LESS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 393 */           i = Integer.parseInt(str1);
/* 394 */           calendar.set(13, i);
/*     */           break;
/*     */         case SSSSS:
/* 397 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_NUMBER, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 399 */           i = Integer.parseInt(str1);
/* 400 */           calendar.set(11, 0);
/* 401 */           calendar.set(12, 0);
/* 402 */           calendar.set(13, i);
/*     */           break;
/*     */         case FF:
/* 405 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_NUMBER, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 407 */           str2 = String.format("%-9s", new Object[] { str1 }).replace(' ', '0');
/* 408 */           str2 = str2.substring(0, 9);
/* 409 */           double_ = Double.valueOf(Double.parseDouble(str2));
/* 410 */           param1ToDateParser.setNanos(double_.intValue());
/* 411 */           i = (int)Math.round(double_.doubleValue() / 1000000.0D);
/* 412 */           calendar.set(14, i);
/*     */           break;
/*     */         case AM_PM:
/* 415 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_AM_PM, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 417 */           if (str1.toUpperCase().startsWith("A")) {
/* 418 */             calendar.set(9, 0); break;
/*     */           } 
/* 420 */           calendar.set(9, 1);
/*     */           break;
/*     */         
/*     */         case TZH:
/* 424 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS_OR_LESS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 426 */           i = Integer.parseInt(str1);
/* 427 */           timeZone = calendar.getTimeZone();
/* 428 */           j = timeZone.getRawOffset();
/*     */           
/* 430 */           j = j / 3600000 * 3600000;
/* 431 */           timeZone.setRawOffset(j + i);
/* 432 */           calendar.setTimeZone(timeZone);
/*     */           break;
/*     */         case TZM:
/* 435 */           str1 = ToDateTokenizer.matchStringOrThrow(ToDateTokenizer.PATTERN_TWO_DIGITS_OR_LESS, param1ToDateParser, param1FormatTokenEnum);
/*     */           
/* 437 */           i = Integer.parseInt(str1);
/* 438 */           timeZone = calendar.getTimeZone();
/* 439 */           j = timeZone.getRawOffset();
/*     */           
/* 441 */           j %= 3600000;
/* 442 */           timeZone.setRawOffset(i * 3600000 + j);
/* 443 */           calendar.setTimeZone(timeZone);
/*     */           break;
/*     */         
/*     */         case TZR:
/* 447 */           str3 = param1ToDateParser.getInputStr();
/* 448 */           timeZone = calendar.getTimeZone();
/* 449 */           for (String str : TimeZone.getAvailableIDs()) {
/* 450 */             int k = str.length();
/* 451 */             if (str3.length() >= k && str.equalsIgnoreCase(str3.substring(0, k))) {
/*     */               
/* 453 */               timeZone.setID(str);
/* 454 */               calendar.setTimeZone(timeZone);
/* 455 */               str1 = str;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */           break;
/*     */ 
/*     */         
/*     */         case TZD:
/* 463 */           ToDateTokenizer.throwException(param1ToDateParser, String.format("token '%s' not supported yet.", new Object[] { param1FormatTokenEnum.name() }));
/*     */           break;
/*     */         
/*     */         default:
/* 467 */           throw new IllegalArgumentException(String.format("%s: Internal Error. Unhandled case: %s", new Object[] { getClass().getSimpleName(), param1FormatTokenEnum }));
/*     */       } 
/*     */ 
/*     */       
/* 471 */       param1ToDateParser.remove(str1, param1String);
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
/*     */   static String matchStringOrThrow(Pattern paramPattern, ToDateParser paramToDateParser, Enum<?> paramEnum) {
/* 484 */     String str = paramToDateParser.getInputStr();
/* 485 */     Matcher matcher = paramPattern.matcher(str);
/* 486 */     if (!matcher.find()) {
/* 487 */       throwException(paramToDateParser, String.format("Issue happened when parsing token '%s'", new Object[] { paramEnum.name() }));
/*     */     }
/* 489 */     return matcher.group(1);
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
/*     */   static String setByName(Calendar paramCalendar, ToDateParser paramToDateParser, int paramInt1, int paramInt2) {
/* 502 */     String str1 = null;
/* 503 */     String str2 = paramToDateParser.getInputStr();
/* 504 */     Map<String, Integer> map = paramCalendar.getDisplayNames(paramInt1, paramInt2, Locale.getDefault());
/*     */     
/* 506 */     for (String str : map.keySet()) {
/* 507 */       int i = str.length();
/* 508 */       if (str.equalsIgnoreCase(str2.substring(0, i))) {
/* 509 */         paramCalendar.set(paramInt1, ((Integer)map.get(str)).intValue());
/* 510 */         str1 = str;
/*     */         break;
/*     */       } 
/*     */     } 
/* 514 */     if (str1 == null || str1.isEmpty()) {
/* 515 */       throwException(paramToDateParser, String.format("Tried to parse one of '%s' but failed (may be an internal error?)", new Object[] { map.keySet() }));
/*     */     }
/*     */ 
/*     */     
/* 519 */     return str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void throwException(ToDateParser paramToDateParser, String paramString) {
/* 529 */     throw DbException.get(90056, new String[] { paramToDateParser.getFunctionName(), String.format(" %s. Details: %s", new Object[] { paramString, paramToDateParser }) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum FormatTokenEnum
/*     */   {
/* 540 */     YYYY((String)ToDateTokenizer.PARSLET_YEAR),
/*     */     
/* 542 */     SYYYY((String)ToDateTokenizer.PARSLET_YEAR),
/*     */     
/* 544 */     IYYY((String)ToDateTokenizer.PARSLET_YEAR),
/* 545 */     YYY((String)ToDateTokenizer.PARSLET_YEAR),
/* 546 */     IYY((String)ToDateTokenizer.PARSLET_YEAR),
/* 547 */     YY((String)ToDateTokenizer.PARSLET_YEAR),
/* 548 */     IY((String)ToDateTokenizer.PARSLET_YEAR),
/*     */     
/* 550 */     SCC((String)ToDateTokenizer.PARSLET_YEAR),
/*     */     
/* 552 */     CC((String)ToDateTokenizer.PARSLET_YEAR),
/*     */     
/* 554 */     RRRR((String)ToDateTokenizer.PARSLET_YEAR),
/*     */     
/* 556 */     RR((String)ToDateTokenizer.PARSLET_YEAR),
/*     */     
/* 558 */     BC_AD((String)ToDateTokenizer.PARSLET_YEAR, ToDateTokenizer.PATTERN_BC_AD),
/*     */     
/* 560 */     MONTH((String)ToDateTokenizer.PARSLET_MONTH),
/*     */     
/* 562 */     MON((String)ToDateTokenizer.PARSLET_MONTH),
/*     */     
/* 564 */     MM((String)ToDateTokenizer.PARSLET_MONTH),
/*     */     
/* 566 */     RM((String)ToDateTokenizer.PARSLET_MONTH),
/*     */     
/* 568 */     DDD((String)ToDateTokenizer.PARSLET_DAY),
/*     */     
/* 570 */     DAY((String)ToDateTokenizer.PARSLET_DAY),
/*     */     
/* 572 */     DD((String)ToDateTokenizer.PARSLET_DAY),
/*     */     
/* 574 */     DY((String)ToDateTokenizer.PARSLET_DAY),
/* 575 */     HH24((String)ToDateTokenizer.PARSLET_TIME),
/* 576 */     HH12((String)ToDateTokenizer.PARSLET_TIME),
/*     */     
/* 578 */     HH((String)ToDateTokenizer.PARSLET_TIME),
/*     */     
/* 580 */     MI((String)ToDateTokenizer.PARSLET_TIME),
/*     */     
/* 582 */     SSSSS((String)ToDateTokenizer.PARSLET_TIME),
/* 583 */     SS((String)ToDateTokenizer.PARSLET_TIME),
/*     */     
/* 585 */     FF((String)ToDateTokenizer.PARSLET_TIME, ToDateTokenizer.PATTERN_FF),
/*     */     
/* 587 */     TZH((String)ToDateTokenizer.PARSLET_TIME),
/*     */     
/* 589 */     TZM((String)ToDateTokenizer.PARSLET_TIME),
/*     */     
/* 591 */     TZR((String)ToDateTokenizer.PARSLET_TIME),
/*     */ 
/*     */     
/* 594 */     TZD((String)ToDateTokenizer.PARSLET_TIME),
/*     */     
/* 596 */     AM_PM((String)ToDateTokenizer.PARSLET_TIME, ToDateTokenizer.PATTERN_AM_PM),
/*     */ 
/*     */ 
/*     */     
/* 600 */     EE((String)ToDateTokenizer.PARSLET_YEAR),
/*     */ 
/*     */ 
/*     */     
/* 604 */     E((String)ToDateTokenizer.PARSLET_YEAR),
/* 605 */     Y((String)ToDateTokenizer.PARSLET_YEAR),
/* 606 */     I((String)ToDateTokenizer.PARSLET_YEAR),
/*     */     
/* 608 */     Q((String)ToDateTokenizer.PARSLET_MONTH),
/*     */     
/* 610 */     D((String)ToDateTokenizer.PARSLET_DAY),
/*     */ 
/*     */     
/* 613 */     J((String)ToDateTokenizer.PARSLET_DAY);
/*     */     
/* 615 */     private static final List<FormatTokenEnum> EMPTY_LIST = new ArrayList<>(0);
/*     */ 
/*     */     
/* 618 */     private static final Map<Character, List<FormatTokenEnum>> CACHE = new HashMap<>((values()).length);
/*     */     
/*     */     private final ToDateTokenizer.ToDateParslet toDateParslet;
/*     */     
/*     */     private final Pattern patternToUse;
/*     */ 
/*     */     
/*     */     static {
/*     */     
/*     */     }
/*     */     
/*     */     FormatTokenEnum(ToDateTokenizer.ToDateParslet param1ToDateParslet, Pattern param1Pattern) {
/* 630 */       this.toDateParslet = param1ToDateParslet;
/* 631 */       this.patternToUse = param1Pattern;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     FormatTokenEnum(ToDateTokenizer.ToDateParslet param1ToDateParslet) {
/* 640 */       this.toDateParslet = param1ToDateParslet;
/* 641 */       this.patternToUse = Pattern.compile(String.format("^(%s)", new Object[] { name() }), 2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static List<FormatTokenEnum> getTokensInQuestion(String param1String) {
/* 653 */       List<FormatTokenEnum> list = EMPTY_LIST;
/* 654 */       if (CACHE.size() <= 0) {
/* 655 */         initCache();
/*     */       }
/* 657 */       if (param1String != null && param1String.length() > 0) {
/* 658 */         Character character = Character.valueOf(Character.toUpperCase(param1String.charAt(0)));
/* 659 */         list = CACHE.get(character);
/*     */       } 
/* 661 */       if (list == null) {
/* 662 */         list = EMPTY_LIST;
/*     */       }
/* 664 */       return list;
/*     */     }
/*     */     
/*     */     private static synchronized void initCache() {
/* 668 */       if (CACHE.size() <= 0) {
/* 669 */         for (FormatTokenEnum formatTokenEnum : values()) {
/*     */           
/* 671 */           ArrayList<Character> arrayList = new ArrayList();
/*     */           
/* 673 */           if (formatTokenEnum.name().contains("_")) {
/* 674 */             String[] arrayOfString = formatTokenEnum.name().split("_");
/* 675 */             for (String str : arrayOfString) {
/* 676 */               arrayList.add(Character.valueOf(str.toUpperCase().charAt(0)));
/*     */             }
/*     */           } else {
/* 679 */             arrayList.add(Character.valueOf(formatTokenEnum.name().toUpperCase().charAt(0)));
/*     */           } 
/*     */           
/* 682 */           for (Character character : arrayList) {
/* 683 */             List<FormatTokenEnum> list = CACHE.get(character);
/* 684 */             if (list == null) {
/* 685 */               list = new ArrayList(1);
/* 686 */               CACHE.put(character, list);
/*     */             } 
/* 688 */             list.add(formatTokenEnum);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean parseFormatStrWithToken(ToDateParser param1ToDateParser) {
/* 703 */       Matcher matcher = this.patternToUse.matcher(param1ToDateParser.getFormatStr());
/* 704 */       boolean bool = matcher.find();
/* 705 */       if (bool) {
/* 706 */         String str = matcher.group(1);
/* 707 */         this.toDateParslet.parse(param1ToDateParser, this, str);
/*     */       } 
/* 709 */       return bool;
/*     */     }
/*     */   }
/*     */   
/*     */   static interface ToDateParslet {
/*     */     void parse(ToDateParser param1ToDateParser, ToDateTokenizer.FormatTokenEnum param1FormatTokenEnum, String param1String);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\ToDateTokenizer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */