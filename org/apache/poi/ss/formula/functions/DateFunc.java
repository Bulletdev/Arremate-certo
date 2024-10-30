/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*     */ public final class DateFunc
/*     */   extends Fixed3ArgFunction
/*     */ {
/*  34 */   public static final Function instance = new DateFunc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*     */     double d;
/*     */     try {
/*  43 */       double d1 = NumericFunction.singleOperandEvaluate(paramValueEval1, paramInt1, paramInt2);
/*  44 */       double d2 = NumericFunction.singleOperandEvaluate(paramValueEval2, paramInt1, paramInt2);
/*  45 */       double d3 = NumericFunction.singleOperandEvaluate(paramValueEval3, paramInt1, paramInt2);
/*  46 */       d = evaluate(getYear(d1), (int)(d2 - 1.0D), (int)d3);
/*  47 */       NumericFunction.checkValue(d);
/*  48 */     } catch (EvaluationException evaluationException) {
/*  49 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  51 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static double evaluate(int paramInt1, int paramInt2, int paramInt3) throws EvaluationException {
/*  59 */     if (paramInt1 < 0) {
/*  60 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */     }
/*     */     
/*  63 */     while (paramInt2 < 0) {
/*  64 */       paramInt1--;
/*  65 */       paramInt2 += 12;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  71 */     if (paramInt1 == 1900 && paramInt2 == 1 && paramInt3 == 29) {
/*  72 */       return 60.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  77 */     int i = paramInt3;
/*  78 */     if (paramInt1 == 1900 && ((
/*  79 */       paramInt2 == 0 && i >= 60) || (paramInt2 == 1 && i >= 30)))
/*     */     {
/*  81 */       i--;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  86 */     Calendar calendar = LocaleUtil.getLocaleCalendar(paramInt1, paramInt2, i);
/*     */ 
/*     */ 
/*     */     
/*  90 */     if (paramInt3 < 0 && calendar.get(1) == 1900 && paramInt2 > 1 && calendar.get(2) < 2)
/*     */     {
/*     */       
/*  93 */       calendar.add(5, 1);
/*     */     }
/*     */ 
/*     */     
/*  97 */     boolean bool = false;
/*     */ 
/*     */     
/* 100 */     return DateUtil.getExcelDate(calendar.getTime(), bool);
/*     */   }
/*     */   
/*     */   private static int getYear(double paramDouble) {
/* 104 */     int i = (int)paramDouble;
/*     */     
/* 106 */     if (i < 0) {
/* 107 */       return -1;
/*     */     }
/*     */     
/* 110 */     return (i < 1900) ? (1900 + i) : i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\DateFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */