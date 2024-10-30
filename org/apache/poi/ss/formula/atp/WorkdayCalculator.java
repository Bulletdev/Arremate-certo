/*     */ package org.apache.poi.ss.formula.atp;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
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
/*     */ public class WorkdayCalculator
/*     */ {
/*  30 */   public static final WorkdayCalculator instance = new WorkdayCalculator();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int calculateWorkdays(double paramDouble1, double paramDouble2, double[] paramArrayOfdouble) {
/*  48 */     int i = pastDaysOfWeek(paramDouble1, paramDouble2, 7);
/*  49 */     int j = pastDaysOfWeek(paramDouble1, paramDouble2, 1);
/*  50 */     int k = calculateNonWeekendHolidays(paramDouble1, paramDouble2, paramArrayOfdouble);
/*  51 */     return (int)(paramDouble2 - paramDouble1 + 1.0D) - i - j - k;
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
/*     */   public Date calculateWorkdays(double paramDouble, int paramInt, double[] paramArrayOfdouble) {
/*  63 */     Date date = DateUtil.getJavaDate(paramDouble);
/*  64 */     byte b = (paramInt < 0) ? -1 : 1;
/*  65 */     Calendar calendar = LocaleUtil.getLocaleCalendar();
/*  66 */     calendar.setTime(date);
/*  67 */     double d = DateUtil.getExcelDate(calendar.getTime());
/*  68 */     while (paramInt != 0) {
/*  69 */       calendar.add(6, b);
/*  70 */       d += b;
/*  71 */       if (calendar.get(7) != 7 && calendar.get(7) != 1 && !isHoliday(d, paramArrayOfdouble))
/*     */       {
/*     */         
/*  74 */         paramInt -= b;
/*     */       }
/*     */     } 
/*  77 */     return calendar.getTime();
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
/*     */   protected int pastDaysOfWeek(double paramDouble1, double paramDouble2, int paramInt) {
/*  89 */     byte b = 0;
/*  90 */     int i = (int)Math.floor((paramDouble1 < paramDouble2) ? paramDouble1 : paramDouble2);
/*  91 */     int j = (int)Math.floor((paramDouble2 > paramDouble1) ? paramDouble2 : paramDouble1);
/*  92 */     for (; i <= j; i++) {
/*  93 */       Calendar calendar = LocaleUtil.getLocaleCalendar();
/*  94 */       calendar.setTime(DateUtil.getJavaDate(i));
/*  95 */       if (calendar.get(7) == paramInt) {
/*  96 */         b++;
/*     */       }
/*     */     } 
/*  99 */     return (paramDouble1 < paramDouble2) ? b : -b;
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
/*     */   protected int calculateNonWeekendHolidays(double paramDouble1, double paramDouble2, double[] paramArrayOfdouble) {
/* 111 */     byte b1 = 0;
/* 112 */     double d1 = (paramDouble1 < paramDouble2) ? paramDouble1 : paramDouble2;
/* 113 */     double d2 = (paramDouble2 > paramDouble1) ? paramDouble2 : paramDouble1;
/* 114 */     for (byte b2 = 0; b2 < paramArrayOfdouble.length; b2++) {
/* 115 */       if (isInARange(d1, d2, paramArrayOfdouble[b2]) && 
/* 116 */         !isWeekend(paramArrayOfdouble[b2])) {
/* 117 */         b1++;
/*     */       }
/*     */     } 
/*     */     
/* 121 */     return (paramDouble1 < paramDouble2) ? b1 : -b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isWeekend(double paramDouble) {
/* 129 */     Calendar calendar = LocaleUtil.getLocaleCalendar();
/* 130 */     calendar.setTime(DateUtil.getJavaDate(paramDouble));
/* 131 */     return (calendar.get(7) == 7 || calendar.get(7) == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isHoliday(double paramDouble, double[] paramArrayOfdouble) {
/* 140 */     for (byte b = 0; b < paramArrayOfdouble.length; b++) {
/* 141 */       if (Math.round(paramArrayOfdouble[b]) == Math.round(paramDouble)) {
/* 142 */         return true;
/*     */       }
/*     */     } 
/* 145 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int isNonWorkday(double paramDouble, double[] paramArrayOfdouble) {
/* 154 */     return (isWeekend(paramDouble) || isHoliday(paramDouble, paramArrayOfdouble)) ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isInARange(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 164 */     return (paramDouble3 >= paramDouble1 && paramDouble3 <= paramDouble2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\WorkdayCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */