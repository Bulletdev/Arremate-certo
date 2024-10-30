/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.usermodel.DateUtil;
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
/*    */ public class WeekNum
/*    */   extends Fixed2ArgFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 47 */   public static final FreeRefFunction instance = new WeekNum();
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/* 50 */     double d = 0.0D;
/*    */     try {
/* 52 */       d = NumericFunction.singleOperandEvaluate(paramValueEval1, paramInt1, paramInt2);
/* 53 */     } catch (EvaluationException evaluationException) {
/* 54 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/* 56 */     Calendar calendar = LocaleUtil.getLocaleCalendar();
/* 57 */     calendar.setTime(DateUtil.getJavaDate(d, false));
/*    */     
/* 59 */     int i = 0;
/*    */     try {
/* 61 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/* 62 */       i = OperandResolver.coerceValueToInt(valueEval);
/* 63 */     } catch (EvaluationException evaluationException) {
/* 64 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*    */     } 
/*    */     
/* 67 */     if (i != 1 && i != 2) {
/* 68 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*    */     }
/*    */     
/* 71 */     return (ValueEval)new NumberEval(getWeekNo(calendar, i));
/*    */   }
/*    */   
/*    */   public int getWeekNo(Calendar paramCalendar, int paramInt) {
/* 75 */     if (paramInt == 1) {
/* 76 */       paramCalendar.setFirstDayOfWeek(1);
/*    */     } else {
/* 78 */       paramCalendar.setFirstDayOfWeek(2);
/*    */     } 
/* 80 */     return paramCalendar.get(3);
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 84 */     if (paramArrayOfValueEval.length == 2) {
/* 85 */       return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*    */     }
/* 87 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\WeekNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */