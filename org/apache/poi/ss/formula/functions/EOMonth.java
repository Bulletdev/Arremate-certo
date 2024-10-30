/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*    */ public class EOMonth
/*    */   implements FreeRefFunction
/*    */ {
/* 46 */   public static final FreeRefFunction instance = new EOMonth();
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 50 */     if (paramArrayOfValueEval.length != 2) {
/* 51 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/*    */     try {
/* 55 */       double d = NumericFunction.singleOperandEvaluate(paramArrayOfValueEval[0], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/* 56 */       int i = (int)NumericFunction.singleOperandEvaluate(paramArrayOfValueEval[1], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/*    */ 
/*    */       
/* 59 */       if (d >= 0.0D && d < 1.0D) {
/* 60 */         d = 1.0D;
/*    */       }
/*    */       
/* 63 */       Date date = DateUtil.getJavaDate(d, false);
/*    */       
/* 65 */       Calendar calendar = LocaleUtil.getLocaleCalendar();
/* 66 */       calendar.setTime(date);
/* 67 */       calendar.clear(10);
/* 68 */       calendar.set(11, 0);
/* 69 */       calendar.clear(12);
/* 70 */       calendar.clear(13);
/* 71 */       calendar.clear(14);
/*    */       
/* 73 */       calendar.add(2, i + 1);
/* 74 */       calendar.set(5, 1);
/* 75 */       calendar.add(5, -1);
/*    */       
/* 77 */       return (ValueEval)new NumberEval(DateUtil.getExcelDate(calendar.getTime()));
/* 78 */     } catch (EvaluationException evaluationException) {
/* 79 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\EOMonth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */