/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimeUtil
/*    */ {
/*    */   public static long computeStartOfNextSecond(long paramLong) {
/* 22 */     Calendar calendar = Calendar.getInstance();
/* 23 */     calendar.setTime(new Date(paramLong));
/* 24 */     calendar.set(14, 0);
/* 25 */     calendar.add(13, 1);
/* 26 */     return calendar.getTime().getTime();
/*    */   }
/*    */   
/*    */   public static long computeStartOfNextMinute(long paramLong) {
/* 30 */     Calendar calendar = Calendar.getInstance();
/* 31 */     calendar.setTime(new Date(paramLong));
/* 32 */     calendar.set(14, 0);
/* 33 */     calendar.set(13, 0);
/* 34 */     calendar.add(12, 1);
/* 35 */     return calendar.getTime().getTime();
/*    */   }
/*    */   
/*    */   public static long computeStartOfNextHour(long paramLong) {
/* 39 */     Calendar calendar = Calendar.getInstance();
/* 40 */     calendar.setTime(new Date(paramLong));
/* 41 */     calendar.set(14, 0);
/* 42 */     calendar.set(13, 0);
/* 43 */     calendar.set(12, 0);
/* 44 */     calendar.add(10, 1);
/* 45 */     return calendar.getTime().getTime();
/*    */   }
/*    */   
/*    */   public static long computeStartOfNextDay(long paramLong) {
/* 49 */     Calendar calendar = Calendar.getInstance();
/* 50 */     calendar.setTime(new Date(paramLong));
/*    */     
/* 52 */     calendar.add(5, 1);
/* 53 */     calendar.set(14, 0);
/* 54 */     calendar.set(13, 0);
/* 55 */     calendar.set(12, 0);
/* 56 */     calendar.set(11, 0);
/* 57 */     return calendar.getTime().getTime();
/*    */   }
/*    */   
/*    */   public static long computeStartOfNextWeek(long paramLong) {
/* 61 */     Calendar calendar = Calendar.getInstance();
/* 62 */     calendar.setTime(new Date(paramLong));
/*    */     
/* 64 */     calendar.set(7, calendar.getFirstDayOfWeek());
/* 65 */     calendar.set(11, 0);
/* 66 */     calendar.set(12, 0);
/* 67 */     calendar.set(13, 0);
/* 68 */     calendar.set(14, 0);
/* 69 */     calendar.add(3, 1);
/* 70 */     return calendar.getTime().getTime();
/*    */   }
/*    */   
/*    */   public static long computeStartOfNextMonth(long paramLong) {
/* 74 */     Calendar calendar = Calendar.getInstance();
/* 75 */     calendar.setTime(new Date(paramLong));
/*    */     
/* 77 */     calendar.set(5, 1);
/* 78 */     calendar.set(11, 0);
/* 79 */     calendar.set(12, 0);
/* 80 */     calendar.set(13, 0);
/* 81 */     calendar.set(14, 0);
/* 82 */     calendar.add(2, 1);
/* 83 */     return calendar.getTime().getTime();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\TimeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */