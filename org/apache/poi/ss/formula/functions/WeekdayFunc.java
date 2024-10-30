/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.MissingArgEval;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.usermodel.DateUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WeekdayFunc
/*     */   implements Function
/*     */ {
/*  42 */   public static final Function instance = new WeekdayFunc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     try {
/*     */       double d2;
/*  83 */       if (paramArrayOfValueEval.length < 1 || paramArrayOfValueEval.length > 2) {
/*  84 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       }
/*     */ 
/*     */       
/*  88 */       ValueEval valueEval = OperandResolver.getSingleValue(paramArrayOfValueEval[0], paramInt1, paramInt2);
/*  89 */       double d1 = OperandResolver.coerceValueToDouble(valueEval);
/*  90 */       if (!DateUtil.isValidExcelDate(d1)) {
/*  91 */         return (ValueEval)ErrorEval.NUM_ERROR;
/*     */       }
/*  93 */       Calendar calendar = DateUtil.getJavaCalendar(d1, false);
/*  94 */       int i = calendar.get(7);
/*     */ 
/*     */       
/*  97 */       int j = 1;
/*  98 */       if (paramArrayOfValueEval.length == 2) {
/*  99 */         ValueEval valueEval1 = OperandResolver.getSingleValue(paramArrayOfValueEval[1], paramInt1, paramInt2);
/* 100 */         if (valueEval1 == MissingArgEval.instance || valueEval1 == BlankEval.instance) {
/* 101 */           return (ValueEval)ErrorEval.NUM_ERROR;
/*     */         }
/* 103 */         j = OperandResolver.coerceValueToInt(valueEval1);
/* 104 */         if (j == 2) {
/* 105 */           j = 11;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 111 */       if (j == 1) {
/* 112 */         d2 = i;
/*     */       }
/* 114 */       else if (j == 3) {
/* 115 */         d2 = ((i + 6 - 1) % 7);
/* 116 */       } else if (j >= 11 && j <= 17) {
/* 117 */         d2 = ((i + 6 - j - 10) % 7 + 1);
/*     */       } else {
/* 119 */         return (ValueEval)ErrorEval.NUM_ERROR;
/*     */       } 
/*     */       
/* 122 */       return (ValueEval)new NumberEval(d2);
/* 123 */     } catch (EvaluationException evaluationException) {
/* 124 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\WeekdayFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */