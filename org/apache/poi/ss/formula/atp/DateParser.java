/*    */ package org.apache.poi.ss.formula.atp;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.regex.Pattern;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.util.LocaleUtil;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DateParser
/*    */ {
/*    */   public static Calendar parseDate(String paramString) throws EvaluationException {
/*    */     int j, k, m;
/* 43 */     String[] arrayOfString = Pattern.compile("/").split(paramString);
/* 44 */     if (arrayOfString.length != 3) {
/* 45 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     }
/* 47 */     String str = arrayOfString[2];
/* 48 */     int i = str.indexOf(' ');
/* 49 */     if (i > 0)
/*    */     {
/* 51 */       str = str.substring(0, i);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 57 */       j = Integer.parseInt(arrayOfString[0]);
/* 58 */       k = Integer.parseInt(arrayOfString[1]);
/* 59 */       m = Integer.parseInt(str);
/* 60 */     } catch (NumberFormatException numberFormatException) {
/* 61 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     } 
/* 63 */     if (j < 0 || k < 0 || m < 0 || (j > 12 && k > 12 && m > 12))
/*    */     {
/* 65 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     }
/*    */     
/* 68 */     if (j >= 1900 && j < 9999)
/*    */     {
/* 70 */       return makeDate(j, k, m);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 78 */     throw new RuntimeException("Unable to determine date format for text '" + paramString + "'");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static Calendar makeDate(int paramInt1, int paramInt2, int paramInt3) throws EvaluationException {
/* 85 */     if (paramInt2 < 1 || paramInt2 > 12) {
/* 86 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     }
/* 88 */     Calendar calendar = LocaleUtil.getLocaleCalendar(paramInt1, paramInt2 - 1, 1, 0, 0, 0);
/* 89 */     if (paramInt3 < 1 || paramInt3 > calendar.getActualMaximum(5)) {
/* 90 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     }
/* 92 */     calendar.set(5, paramInt3);
/* 93 */     return calendar;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\DateParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */