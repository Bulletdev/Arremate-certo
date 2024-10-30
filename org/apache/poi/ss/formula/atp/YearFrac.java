/*     */ package org.apache.poi.ss.formula.atp;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
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
/*     */ final class YearFrac
/*     */   implements FreeRefFunction
/*     */ {
/*  53 */   public static final FreeRefFunction instance = new YearFrac();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/*     */     double d;
/*  60 */     int i = paramOperationEvaluationContext.getRowIndex();
/*  61 */     int j = paramOperationEvaluationContext.getColumnIndex();
/*     */     
/*     */     try {
/*  64 */       int k = 0;
/*  65 */       switch (paramArrayOfValueEval.length) {
/*     */         case 3:
/*  67 */           k = evaluateIntArg(paramArrayOfValueEval[2], i, j);
/*     */           break;
/*     */         case 2:
/*     */           break;
/*     */         default:
/*  72 */           return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       } 
/*  74 */       double d1 = evaluateDateArg(paramArrayOfValueEval[0], i, j);
/*  75 */       double d2 = evaluateDateArg(paramArrayOfValueEval[1], i, j);
/*  76 */       d = YearFracCalculator.calculate(d1, d2, k);
/*  77 */     } catch (EvaluationException evaluationException) {
/*  78 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */     
/*  81 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */   
/*     */   private static double evaluateDateArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*  85 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, (short)paramInt2);
/*     */     
/*  87 */     if (valueEval instanceof StringEval) {
/*  88 */       String str = ((StringEval)valueEval).getStringValue();
/*  89 */       Double double_ = OperandResolver.parseDouble(str);
/*  90 */       if (double_ != null) {
/*  91 */         return double_.doubleValue();
/*     */       }
/*  93 */       Calendar calendar = DateParser.parseDate(str);
/*  94 */       return DateUtil.getExcelDate(calendar, false);
/*     */     } 
/*  96 */     return OperandResolver.coerceValueToDouble(valueEval);
/*     */   }
/*     */   
/*     */   private static int evaluateIntArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 100 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, (short)paramInt2);
/* 101 */     return OperandResolver.coerceValueToInt(valueEval);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\YearFrac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */