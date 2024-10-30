/*     */ package ch.qos.logback.core.rolling.helper;
/*     */ 
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
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
/*     */ public class RollingCalendar
/*     */   extends GregorianCalendar
/*     */ {
/*     */   private static final long serialVersionUID = -5937537740925066161L;
/*  44 */   static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
/*     */   
/*  46 */   PeriodicityType periodicityType = PeriodicityType.ERRONEOUS;
/*     */   
/*     */   String datePattern;
/*     */   
/*     */   public RollingCalendar(String paramString) {
/*  51 */     this.datePattern = paramString;
/*  52 */     this.periodicityType = computePeriodicityType();
/*     */   }
/*     */   
/*     */   public RollingCalendar(String paramString, TimeZone paramTimeZone, Locale paramLocale) {
/*  56 */     super(paramTimeZone, paramLocale);
/*  57 */     this.datePattern = paramString;
/*  58 */     this.periodicityType = computePeriodicityType();
/*     */   }
/*     */   
/*     */   public PeriodicityType getPeriodicityType() {
/*  62 */     return this.periodicityType;
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
/*     */   public PeriodicityType computePeriodicityType() {
/*  75 */     GregorianCalendar gregorianCalendar = new GregorianCalendar(GMT_TIMEZONE, Locale.getDefault());
/*     */ 
/*     */     
/*  78 */     Date date = new Date(0L);
/*     */     
/*  80 */     if (this.datePattern != null) {
/*  81 */       for (PeriodicityType periodicityType : PeriodicityType.VALID_ORDERED_LIST) {
/*  82 */         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern);
/*  83 */         simpleDateFormat.setTimeZone(GMT_TIMEZONE);
/*     */         
/*  85 */         String str1 = simpleDateFormat.format(date);
/*     */         
/*  87 */         Date date1 = innerGetEndOfThisPeriod(gregorianCalendar, periodicityType, date);
/*  88 */         String str2 = simpleDateFormat.format(date1);
/*     */ 
/*     */         
/*  91 */         if (str1 != null && str2 != null && !str1.equals(str2)) {
/*  92 */           return periodicityType;
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  97 */     return PeriodicityType.ERRONEOUS;
/*     */   }
/*     */   
/*     */   public boolean isCollisionFree() {
/* 101 */     switch (null.t[this.periodicityType.ordinal()]) {
/*     */       
/*     */       case 1:
/* 104 */         return !collision(43200000L);
/*     */ 
/*     */       
/*     */       case 2:
/* 108 */         if (collision(604800000L)) {
/* 109 */           return false;
/*     */         }
/* 111 */         if (collision(2678400000L)) {
/* 112 */           return false;
/*     */         }
/* 114 */         if (collision(31536000000L))
/* 115 */           return false; 
/* 116 */         return true;
/*     */       
/*     */       case 3:
/* 119 */         if (collision(2937600000L)) {
/* 120 */           return false;
/*     */         }
/* 122 */         if (collision(31622400000L))
/* 123 */           return false; 
/* 124 */         return true;
/*     */     } 
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean collision(long paramLong) {
/* 131 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.datePattern);
/* 132 */     simpleDateFormat.setTimeZone(GMT_TIMEZONE);
/* 133 */     Date date1 = new Date(0L);
/* 134 */     String str1 = simpleDateFormat.format(date1);
/* 135 */     Date date2 = new Date(paramLong);
/* 136 */     String str2 = simpleDateFormat.format(date2);
/*     */     
/* 138 */     return str1.equals(str2);
/*     */   }
/*     */   
/*     */   public void printPeriodicity(ContextAwareBase paramContextAwareBase) {
/* 142 */     switch (null.t[this.periodicityType.ordinal()]) {
/*     */       case 4:
/* 144 */         paramContextAwareBase.addInfo("Roll-over every millisecond.");
/*     */         return;
/*     */       
/*     */       case 5:
/* 148 */         paramContextAwareBase.addInfo("Roll-over every second.");
/*     */         return;
/*     */       
/*     */       case 6:
/* 152 */         paramContextAwareBase.addInfo("Roll-over every minute.");
/*     */         return;
/*     */       
/*     */       case 1:
/* 156 */         paramContextAwareBase.addInfo("Roll-over at the top of every hour.");
/*     */         return;
/*     */       
/*     */       case 7:
/* 160 */         paramContextAwareBase.addInfo("Roll-over at midday and midnight.");
/*     */         return;
/*     */       
/*     */       case 2:
/* 164 */         paramContextAwareBase.addInfo("Roll-over at midnight.");
/*     */         return;
/*     */       
/*     */       case 3:
/* 168 */         paramContextAwareBase.addInfo("Rollover at the start of week.");
/*     */         return;
/*     */       
/*     */       case 8:
/* 172 */         paramContextAwareBase.addInfo("Rollover at start of every month.");
/*     */         return;
/*     */     } 
/*     */     
/* 176 */     paramContextAwareBase.addInfo("Unknown periodicity.");
/*     */   }
/*     */ 
/*     */   
/*     */   public long periodBarriersCrossed(long paramLong1, long paramLong2) {
/* 181 */     if (paramLong1 > paramLong2) {
/* 182 */       throw new IllegalArgumentException("Start cannot come before end");
/*     */     }
/* 184 */     long l1 = getStartOfCurrentPeriodWithGMTOffsetCorrection(paramLong1, getTimeZone());
/* 185 */     long l2 = getStartOfCurrentPeriodWithGMTOffsetCorrection(paramLong2, getTimeZone());
/*     */     
/* 187 */     long l3 = l2 - l1;
/*     */     
/* 189 */     switch (null.t[this.periodicityType.ordinal()]) {
/*     */       
/*     */       case 4:
/* 192 */         return l3;
/*     */       case 5:
/* 194 */         return l3 / 1000L;
/*     */       case 6:
/* 196 */         return l3 / 60000L;
/*     */       
/*     */       case 1:
/* 199 */         return (int)l3 / 3600000L;
/*     */       case 2:
/* 201 */         return l3 / 86400000L;
/*     */       case 3:
/* 203 */         return l3 / 604800000L;
/*     */       case 8:
/* 205 */         return diffInMonths(paramLong1, paramLong2);
/*     */     } 
/* 207 */     throw new IllegalStateException("Unknown periodicity type.");
/*     */   }
/*     */ 
/*     */   
/*     */   public static int diffInMonths(long paramLong1, long paramLong2) {
/* 212 */     if (paramLong1 > paramLong2)
/* 213 */       throw new IllegalArgumentException("startTime cannot be larger than endTime"); 
/* 214 */     Calendar calendar1 = Calendar.getInstance();
/* 215 */     calendar1.setTimeInMillis(paramLong1);
/* 216 */     Calendar calendar2 = Calendar.getInstance();
/* 217 */     calendar2.setTimeInMillis(paramLong2);
/* 218 */     int i = calendar2.get(1) - calendar1.get(1);
/* 219 */     int j = calendar2.get(2) - calendar1.get(2);
/* 220 */     return i * 12 + j;
/*     */   }
/*     */   
/*     */   private static Date innerGetEndOfThisPeriod(Calendar paramCalendar, PeriodicityType paramPeriodicityType, Date paramDate) {
/* 224 */     return innerGetEndOfNextNthPeriod(paramCalendar, paramPeriodicityType, paramDate, 1);
/*     */   }
/*     */   
/*     */   private static Date innerGetEndOfNextNthPeriod(Calendar paramCalendar, PeriodicityType paramPeriodicityType, Date paramDate, int paramInt) {
/* 228 */     paramCalendar.setTime(paramDate);
/* 229 */     switch (null.t[paramPeriodicityType.ordinal()]) {
/*     */       case 4:
/* 231 */         paramCalendar.add(14, paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 282 */         return paramCalendar.getTime();case 5: paramCalendar.set(14, 0); paramCalendar.add(13, paramInt); return paramCalendar.getTime();case 6: paramCalendar.set(13, 0); paramCalendar.set(14, 0); paramCalendar.add(12, paramInt); return paramCalendar.getTime();case 1: paramCalendar.set(12, 0); paramCalendar.set(13, 0); paramCalendar.set(14, 0); paramCalendar.add(11, paramInt); return paramCalendar.getTime();case 2: paramCalendar.set(11, 0); paramCalendar.set(12, 0); paramCalendar.set(13, 0); paramCalendar.set(14, 0); paramCalendar.add(5, paramInt); return paramCalendar.getTime();case 3: paramCalendar.set(7, paramCalendar.getFirstDayOfWeek()); paramCalendar.set(11, 0); paramCalendar.set(12, 0); paramCalendar.set(13, 0); paramCalendar.set(14, 0); paramCalendar.add(3, paramInt); return paramCalendar.getTime();case 8: paramCalendar.set(5, 1); paramCalendar.set(11, 0); paramCalendar.set(12, 0); paramCalendar.set(13, 0); paramCalendar.set(14, 0); paramCalendar.add(2, paramInt); return paramCalendar.getTime();
/*     */     } 
/*     */     throw new IllegalStateException("Unknown periodicity type.");
/*     */   } public Date getEndOfNextNthPeriod(Date paramDate, int paramInt) {
/* 286 */     return innerGetEndOfNextNthPeriod(this, this.periodicityType, paramDate, paramInt);
/*     */   }
/*     */   
/*     */   public Date getNextTriggeringDate(Date paramDate) {
/* 290 */     return getEndOfNextNthPeriod(paramDate, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getStartOfCurrentPeriodWithGMTOffsetCorrection(long paramLong, TimeZone paramTimeZone) {
/* 299 */     Calendar calendar = Calendar.getInstance(paramTimeZone);
/* 300 */     calendar.setTimeInMillis(paramLong);
/* 301 */     Date date = getEndOfNextNthPeriod(calendar.getTime(), 0);
/*     */     
/* 303 */     calendar = Calendar.getInstance(paramTimeZone);
/* 304 */     calendar.setTimeInMillis(date.getTime());
/* 305 */     long l = (calendar.get(15) + calendar.get(16));
/* 306 */     return date.getTime() + l;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\RollingCalendar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */