/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.RefEval;
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
/*    */ public class EDate
/*    */   implements FreeRefFunction
/*    */ {
/* 37 */   public static final FreeRefFunction instance = new EDate();
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 40 */     if (paramArrayOfValueEval.length != 2) {
/* 41 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     try {
/* 44 */       double d = getValue(paramArrayOfValueEval[0]);
/* 45 */       int i = (int)getValue(paramArrayOfValueEval[1]);
/*    */       
/* 47 */       Date date = DateUtil.getJavaDate(d);
/* 48 */       Calendar calendar = LocaleUtil.getLocaleCalendar();
/* 49 */       calendar.setTime(date);
/* 50 */       calendar.add(2, i);
/* 51 */       return (ValueEval)new NumberEval(DateUtil.getExcelDate(calendar.getTime()));
/* 52 */     } catch (EvaluationException evaluationException) {
/* 53 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */   
/*    */   private double getValue(ValueEval paramValueEval) throws EvaluationException {
/* 58 */     if (paramValueEval instanceof NumberEval) {
/* 59 */       return ((NumberEval)paramValueEval).getNumberValue();
/*    */     }
/* 61 */     if (paramValueEval instanceof org.apache.poi.ss.formula.eval.BlankEval) {
/* 62 */       return 0.0D;
/*    */     }
/* 64 */     if (paramValueEval instanceof RefEval) {
/* 65 */       RefEval refEval = (RefEval)paramValueEval;
/* 66 */       if (refEval.getNumberOfSheets() > 1)
/*    */       {
/* 68 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */       }
/*    */       
/* 71 */       ValueEval valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
/* 72 */       if (valueEval instanceof NumberEval) {
/* 73 */         return ((NumberEval)valueEval).getNumberValue();
/*    */       }
/* 75 */       if (valueEval instanceof org.apache.poi.ss.formula.eval.BlankEval) {
/* 76 */         return 0.0D;
/*    */       }
/*    */     } 
/* 79 */     throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\EDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */