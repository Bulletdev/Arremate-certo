/*     */ package org.apache.poi.ss.formula.atp;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import org.apache.poi.ss.formula.eval.AreaEvalBase;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
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
/*     */ final class ArgumentsEvaluator
/*     */ {
/*  38 */   public static final ArgumentsEvaluator instance = new ArgumentsEvaluator();
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
/*     */   public double evaluateDateArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*  54 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, (short)paramInt2);
/*     */     
/*  56 */     if (valueEval instanceof StringEval) {
/*  57 */       String str = ((StringEval)valueEval).getStringValue();
/*  58 */       Double double_ = OperandResolver.parseDouble(str);
/*  59 */       if (double_ != null) {
/*  60 */         return double_.doubleValue();
/*     */       }
/*  62 */       Calendar calendar = DateParser.parseDate(str);
/*  63 */       return DateUtil.getExcelDate(calendar, false);
/*     */     } 
/*  65 */     return OperandResolver.coerceValueToDouble(valueEval);
/*     */   }
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
/*     */   public double[] evaluateDatesArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*  78 */     if (paramValueEval == null) {
/*  79 */       return new double[0];
/*     */     }
/*     */     
/*  82 */     if (paramValueEval instanceof StringEval)
/*  83 */       return new double[] { evaluateDateArg(paramValueEval, paramInt1, paramInt2) }; 
/*  84 */     if (paramValueEval instanceof AreaEvalBase) {
/*  85 */       ArrayList<Double> arrayList = new ArrayList();
/*  86 */       AreaEvalBase areaEvalBase = (AreaEvalBase)paramValueEval;
/*  87 */       for (int i = areaEvalBase.getFirstRow(); i <= areaEvalBase.getLastRow(); i++) {
/*  88 */         for (int j = areaEvalBase.getFirstColumn(); j <= areaEvalBase.getLastColumn(); j++)
/*     */         {
/*     */           
/*  91 */           arrayList.add(Double.valueOf(evaluateDateArg(areaEvalBase.getAbsoluteValue(i, j), i, j)));
/*     */         }
/*     */       } 
/*  94 */       double[] arrayOfDouble = new double[arrayList.size()];
/*  95 */       for (byte b = 0; b < arrayList.size(); b++) {
/*  96 */         arrayOfDouble[b] = ((Double)arrayList.get(b)).doubleValue();
/*     */       }
/*  98 */       return arrayOfDouble;
/*     */     } 
/* 100 */     return new double[] { OperandResolver.coerceValueToDouble(paramValueEval) };
/*     */   }
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
/*     */   public double evaluateNumberArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 113 */     if (paramValueEval == null) {
/* 114 */       return 0.0D;
/*     */     }
/*     */     
/* 117 */     return OperandResolver.coerceValueToDouble(paramValueEval);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\ArgumentsEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */