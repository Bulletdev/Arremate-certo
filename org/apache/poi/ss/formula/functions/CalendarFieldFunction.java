/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.usermodel.DateUtil;
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
/*    */ public final class CalendarFieldFunction
/*    */   extends Fixed1ArgFunction
/*    */ {
/* 38 */   public static final Function YEAR = new CalendarFieldFunction(1);
/* 39 */   public static final Function MONTH = new CalendarFieldFunction(2);
/* 40 */   public static final Function DAY = new CalendarFieldFunction(5);
/* 41 */   public static final Function HOUR = new CalendarFieldFunction(11);
/* 42 */   public static final Function MINUTE = new CalendarFieldFunction(12);
/* 43 */   public static final Function SECOND = new CalendarFieldFunction(13);
/*    */   
/*    */   private final int _dateFieldId;
/*    */   
/*    */   private CalendarFieldFunction(int paramInt) {
/* 48 */     this._dateFieldId = paramInt;
/*    */   }
/*    */   
/*    */   public final ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     double d;
/*    */     try {
/* 54 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 55 */       d = OperandResolver.coerceValueToDouble(valueEval);
/* 56 */     } catch (EvaluationException evaluationException) {
/* 57 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/* 59 */     if (d < 0.0D) {
/* 60 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*    */     }
/* 62 */     return (ValueEval)new NumberEval(getCalField(d));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private int getCalField(double paramDouble) {
/* 68 */     if ((int)paramDouble == 0) {
/* 69 */       switch (this._dateFieldId) { case 1:
/* 70 */           return 1900;
/* 71 */         case 2: return 1;
/* 72 */         case 5: return 0; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     }
/* 80 */     Calendar calendar = DateUtil.getJavaCalendarUTC(paramDouble + 5.78125E-6D, false);
/* 81 */     int i = calendar.get(this._dateFieldId);
/*    */ 
/*    */     
/* 84 */     if (this._dateFieldId == 2) {
/* 85 */       i++;
/*    */     }
/*    */     
/* 88 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\CalendarFieldFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */