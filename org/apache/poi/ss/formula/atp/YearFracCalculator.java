/*     */ package org.apache.poi.ss.formula.atp;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.usermodel.DateUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class YearFracCalculator
/*     */ {
/*     */   private static final int MS_PER_HOUR = 3600000;
/*     */   private static final int MS_PER_DAY = 86400000;
/*     */   private static final int DAYS_PER_NORMAL_YEAR = 365;
/*     */   private static final int DAYS_PER_LEAP_YEAR = 366;
/*     */   private static final int LONG_MONTH_LEN = 31;
/*     */   private static final int SHORT_MONTH_LEN = 30;
/*     */   private static final int SHORT_FEB_LEN = 28;
/*     */   private static final int LONG_FEB_LEN = 29;
/*     */   
/*     */   public static double calculate(double paramDouble1, double paramDouble2, int paramInt) throws EvaluationException {
/*  55 */     if (paramInt < 0 || paramInt >= 5)
/*     */     {
/*  57 */       throw new EvaluationException(ErrorEval.NUM_ERROR);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     int i = (int)Math.floor(paramDouble1);
/*  64 */     int j = (int)Math.floor(paramDouble2);
/*  65 */     if (i == j)
/*     */     {
/*  67 */       return 0.0D;
/*     */     }
/*     */     
/*  70 */     if (i > j) {
/*  71 */       int k = i;
/*  72 */       i = j;
/*  73 */       j = k;
/*     */     } 
/*     */     
/*  76 */     switch (paramInt) { case 0:
/*  77 */         return basis0(i, j);
/*  78 */       case 1: return basis1(i, j);
/*  79 */       case 2: return basis2(i, j);
/*  80 */       case 3: return basis3(i, j);
/*  81 */       case 4: return basis4(i, j); }
/*     */     
/*  83 */     throw new IllegalStateException("cannot happen");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double basis0(int paramInt1, int paramInt2) {
/*  92 */     SimpleDate simpleDate1 = createDate(paramInt1);
/*  93 */     SimpleDate simpleDate2 = createDate(paramInt2);
/*  94 */     int i = simpleDate1.day;
/*  95 */     int j = simpleDate2.day;
/*     */ 
/*     */     
/*  98 */     if (i == 31 && j == 31) {
/*  99 */       i = 30;
/* 100 */       j = 30;
/* 101 */     } else if (i == 31) {
/* 102 */       i = 30;
/* 103 */     } else if (i == 30 && j == 31) {
/* 104 */       j = 30;
/*     */     
/*     */     }
/* 107 */     else if (simpleDate1.month == 2 && isLastDayOfMonth(simpleDate1)) {
/*     */       
/* 109 */       i = 30;
/* 110 */       if (simpleDate2.month == 2 && isLastDayOfMonth(simpleDate2))
/*     */       {
/* 112 */         j = 30;
/*     */       }
/*     */     } 
/* 115 */     return calculateAdjusted(simpleDate1, simpleDate2, i, j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double basis1(int paramInt1, int paramInt2) {
/*     */     double d;
/* 122 */     SimpleDate simpleDate1 = createDate(paramInt1);
/* 123 */     SimpleDate simpleDate2 = createDate(paramInt2);
/*     */     
/* 125 */     if (isGreaterThanOneYear(simpleDate1, simpleDate2)) {
/* 126 */       d = averageYearLength(simpleDate1.year, simpleDate2.year);
/* 127 */     } else if (shouldCountFeb29(simpleDate1, simpleDate2)) {
/* 128 */       d = 366.0D;
/*     */     } else {
/* 130 */       d = 365.0D;
/*     */     } 
/* 132 */     return dateDiff(simpleDate1.tsMilliseconds, simpleDate2.tsMilliseconds) / d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double basis2(int paramInt1, int paramInt2) {
/* 140 */     return (paramInt2 - paramInt1) / 360.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double basis3(double paramDouble1, double paramDouble2) {
/* 147 */     return (paramDouble2 - paramDouble1) / 365.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double basis4(int paramInt1, int paramInt2) {
/* 154 */     SimpleDate simpleDate1 = createDate(paramInt1);
/* 155 */     SimpleDate simpleDate2 = createDate(paramInt2);
/* 156 */     int i = simpleDate1.day;
/* 157 */     int j = simpleDate2.day;
/*     */ 
/*     */ 
/*     */     
/* 161 */     if (i == 31) {
/* 162 */       i = 30;
/*     */     }
/* 164 */     if (j == 31) {
/* 165 */       j = 30;
/*     */     }
/*     */     
/* 168 */     return calculateAdjusted(simpleDate1, simpleDate2, i, j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static double calculateAdjusted(SimpleDate paramSimpleDate1, SimpleDate paramSimpleDate2, int paramInt1, int paramInt2) {
/* 174 */     double d = ((paramSimpleDate2.year - paramSimpleDate1.year) * 360 + (paramSimpleDate2.month - paramSimpleDate1.month) * 30 + (paramInt2 - paramInt1) * 1);
/*     */ 
/*     */ 
/*     */     
/* 178 */     return d / 360.0D;
/*     */   }
/*     */   
/*     */   private static boolean isLastDayOfMonth(SimpleDate paramSimpleDate) {
/* 182 */     if (paramSimpleDate.day < 28) {
/* 183 */       return false;
/*     */     }
/* 185 */     return (paramSimpleDate.day == getLastDayOfMonth(paramSimpleDate));
/*     */   }
/*     */   
/*     */   private static int getLastDayOfMonth(SimpleDate paramSimpleDate) {
/* 189 */     switch (paramSimpleDate.month) {
/*     */       case 1:
/*     */       case 3:
/*     */       case 5:
/*     */       case 7:
/*     */       case 8:
/*     */       case 10:
/*     */       case 12:
/* 197 */         return 31;
/*     */       case 4:
/*     */       case 6:
/*     */       case 9:
/*     */       case 11:
/* 202 */         return 30;
/*     */     } 
/* 204 */     if (isLeapYear(paramSimpleDate.year)) {
/* 205 */       return 29;
/*     */     }
/* 207 */     return 28;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean shouldCountFeb29(SimpleDate paramSimpleDate1, SimpleDate paramSimpleDate2) {
/* 215 */     boolean bool1 = isLeapYear(paramSimpleDate1.year);
/* 216 */     if (bool1 && paramSimpleDate1.year == paramSimpleDate2.year)
/*     */     {
/* 218 */       return true;
/*     */     }
/*     */     
/* 221 */     boolean bool2 = isLeapYear(paramSimpleDate2.year);
/* 222 */     if (!bool1 && !bool2) {
/* 223 */       return false;
/*     */     }
/* 225 */     if (bool1) {
/* 226 */       switch (paramSimpleDate1.month) {
/*     */         case 1:
/*     */         case 2:
/* 229 */           return true;
/*     */       } 
/* 231 */       return false;
/*     */     } 
/* 233 */     if (bool2) {
/* 234 */       switch (paramSimpleDate2.month) {
/*     */         case 1:
/* 236 */           return false;
/*     */         case 2:
/*     */           break;
/*     */         default:
/* 240 */           return true;
/*     */       } 
/* 242 */       return (paramSimpleDate2.day == 29);
/*     */     } 
/* 244 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int dateDiff(long paramLong1, long paramLong2) {
/* 252 */     long l = paramLong2 - paramLong1;
/*     */ 
/*     */     
/* 255 */     int i = (int)(l % 86400000L / 3600000L);
/* 256 */     switch (i) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 0:
/* 266 */         return (int)(0.5D + l / 8.64E7D);
/*     */     } 
/*     */     throw new RuntimeException("Unexpected date diff between " + paramLong1 + " and " + paramLong2);
/*     */   } private static double averageYearLength(int paramInt1, int paramInt2) {
/* 270 */     byte b = 0;
/* 271 */     for (int i = paramInt1; i <= paramInt2; i++) {
/* 272 */       b += true;
/* 273 */       if (isLeapYear(i)) {
/* 274 */         b++;
/*     */       }
/*     */     } 
/* 277 */     double d = (paramInt2 - paramInt1 + 1);
/* 278 */     return b / d;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isLeapYear(int paramInt) {
/* 283 */     if (paramInt % 4 != 0) {
/* 284 */       return false;
/*     */     }
/*     */     
/* 287 */     if (paramInt % 400 == 0) {
/* 288 */       return true;
/*     */     }
/*     */     
/* 291 */     if (paramInt % 100 == 0) {
/* 292 */       return false;
/*     */     }
/* 294 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean isGreaterThanOneYear(SimpleDate paramSimpleDate1, SimpleDate paramSimpleDate2) {
/* 298 */     if (paramSimpleDate1.year == paramSimpleDate2.year) {
/* 299 */       return false;
/*     */     }
/* 301 */     if (paramSimpleDate1.year + 1 != paramSimpleDate2.year) {
/* 302 */       return true;
/*     */     }
/*     */     
/* 305 */     if (paramSimpleDate1.month > paramSimpleDate2.month) {
/* 306 */       return false;
/*     */     }
/* 308 */     if (paramSimpleDate1.month < paramSimpleDate2.month) {
/* 309 */       return true;
/*     */     }
/*     */     
/* 312 */     return (paramSimpleDate1.day < paramSimpleDate2.day);
/*     */   }
/*     */ 
/*     */   
/*     */   private static SimpleDate createDate(int paramInt) {
/* 317 */     Calendar calendar = LocaleUtil.getLocaleCalendar(LocaleUtil.TIMEZONE_UTC);
/* 318 */     DateUtil.setCalendar(calendar, paramInt, 0, false, false);
/* 319 */     return new SimpleDate(calendar);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class SimpleDate
/*     */   {
/*     */     public static final int JANUARY = 1;
/*     */     
/*     */     public static final int FEBRUARY = 2;
/*     */     
/*     */     public final int year;
/*     */     
/*     */     public final int month;
/*     */     public final int day;
/*     */     public long tsMilliseconds;
/*     */     
/*     */     public SimpleDate(Calendar param1Calendar) {
/* 336 */       this.year = param1Calendar.get(1);
/* 337 */       this.month = param1Calendar.get(2) + 1;
/* 338 */       this.day = param1Calendar.get(5);
/* 339 */       this.tsMilliseconds = param1Calendar.getTimeInMillis();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\YearFracCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */