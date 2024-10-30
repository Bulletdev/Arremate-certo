/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Days360
/*     */   extends Var2or3ArgFunction
/*     */ {
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*     */     double d;
/*     */     try {
/*  72 */       double d1 = NumericFunction.singleOperandEvaluate(paramValueEval1, paramInt1, paramInt2);
/*  73 */       double d2 = NumericFunction.singleOperandEvaluate(paramValueEval2, paramInt1, paramInt2);
/*  74 */       d = evaluate(d1, d2, false);
/*  75 */     } catch (EvaluationException evaluationException) {
/*  76 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  78 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*     */     double d;
/*     */     try {
/*  85 */       double d1 = NumericFunction.singleOperandEvaluate(paramValueEval1, paramInt1, paramInt2);
/*  86 */       double d2 = NumericFunction.singleOperandEvaluate(paramValueEval2, paramInt1, paramInt2);
/*  87 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval3, paramInt1, paramInt2);
/*  88 */       Boolean bool = OperandResolver.coerceValueToBoolean(valueEval, false);
/*  89 */       d = evaluate(d1, d2, (bool == null) ? false : bool.booleanValue());
/*  90 */     } catch (EvaluationException evaluationException) {
/*  91 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  93 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */   
/*     */   private static double evaluate(double paramDouble1, double paramDouble2, boolean paramBoolean) {
/*  97 */     Calendar calendar1 = getDate(paramDouble1);
/*  98 */     Calendar calendar2 = getDate(paramDouble2);
/*  99 */     int[] arrayOfInt1 = getStartingDate(calendar1, paramBoolean);
/* 100 */     int[] arrayOfInt2 = getEndingDate(calendar2, calendar1, paramBoolean);
/*     */     
/* 102 */     return (arrayOfInt2[0] * 360 + arrayOfInt2[1] * 30 + arrayOfInt2[2] - arrayOfInt1[0] * 360 + arrayOfInt1[1] * 30 + arrayOfInt1[2]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Calendar getDate(double paramDouble) {
/* 108 */     Calendar calendar = LocaleUtil.getLocaleCalendar();
/* 109 */     calendar.setTime(DateUtil.getJavaDate(paramDouble, false));
/* 110 */     return calendar;
/*     */   }
/*     */   
/*     */   private static int[] getStartingDate(Calendar paramCalendar, boolean paramBoolean) {
/* 114 */     Calendar calendar = paramCalendar;
/* 115 */     int i = calendar.get(1);
/* 116 */     int j = calendar.get(2);
/* 117 */     int k = Math.min(30, calendar.get(5));
/*     */     
/* 119 */     if (!paramBoolean && isLastDayOfMonth(calendar)) k = 30;
/*     */     
/* 121 */     return new int[] { i, j, k };
/*     */   }
/*     */   
/*     */   private static int[] getEndingDate(Calendar paramCalendar1, Calendar paramCalendar2, boolean paramBoolean) {
/* 125 */     Calendar calendar = paramCalendar1;
/* 126 */     int i = calendar.get(1);
/* 127 */     int j = calendar.get(2);
/* 128 */     int k = Math.min(30, calendar.get(5));
/*     */     
/* 130 */     if (!paramBoolean && paramCalendar1.get(5) == 31) {
/* 131 */       if (paramCalendar2.get(5) < 30) {
/* 132 */         calendar.set(5, 1);
/* 133 */         calendar.add(2, 1);
/* 134 */         i = calendar.get(1);
/* 135 */         j = calendar.get(2);
/* 136 */         k = 1;
/*     */       } else {
/* 138 */         k = 30;
/*     */       } 
/*     */     }
/*     */     
/* 142 */     return new int[] { i, j, k };
/*     */   }
/*     */   
/*     */   private static boolean isLastDayOfMonth(Calendar paramCalendar) {
/* 146 */     int i = paramCalendar.get(5);
/* 147 */     int j = paramCalendar.getActualMaximum(5);
/* 148 */     return (i == j);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Days360.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */