/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.AreaEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.RefEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*     */ public final class Sumif
/*     */   extends Var2or3ArgFunction
/*     */ {
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*     */     AreaEval areaEval;
/*     */     try {
/*  47 */       areaEval = convertRangeArg(paramValueEval1);
/*  48 */     } catch (EvaluationException evaluationException) {
/*  49 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  51 */     return eval(paramInt1, paramInt2, paramValueEval2, areaEval, areaEval);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*     */     AreaEval areaEval1;
/*     */     AreaEval areaEval2;
/*     */     try {
/*  60 */       areaEval1 = convertRangeArg(paramValueEval1);
/*  61 */       areaEval2 = createSumRange(paramValueEval3, areaEval1);
/*  62 */     } catch (EvaluationException evaluationException) {
/*  63 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  65 */     return eval(paramInt1, paramInt2, paramValueEval2, areaEval1, areaEval2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static ValueEval eval(int paramInt1, int paramInt2, ValueEval paramValueEval, AreaEval paramAreaEval1, AreaEval paramAreaEval2) {
/*  71 */     CountUtils.I_MatchPredicate i_MatchPredicate = Countif.createCriteriaPredicate(paramValueEval, paramInt1, paramInt2);
/*     */ 
/*     */     
/*  74 */     if (i_MatchPredicate == null) {
/*  75 */       return (ValueEval)NumberEval.ZERO;
/*     */     }
/*     */     
/*  78 */     double d = sumMatchingCells(paramAreaEval1, i_MatchPredicate, paramAreaEval2);
/*  79 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */   
/*     */   private static double sumMatchingCells(AreaEval paramAreaEval1, CountUtils.I_MatchPredicate paramI_MatchPredicate, AreaEval paramAreaEval2) {
/*  83 */     int i = paramAreaEval1.getHeight();
/*  84 */     int j = paramAreaEval1.getWidth();
/*     */     
/*  86 */     double d = 0.0D;
/*  87 */     for (byte b = 0; b < i; b++) {
/*  88 */       for (byte b1 = 0; b1 < j; b1++) {
/*  89 */         d += accumulate(paramAreaEval1, paramI_MatchPredicate, paramAreaEval2, b, b1);
/*     */       }
/*     */     } 
/*  92 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static double accumulate(AreaEval paramAreaEval1, CountUtils.I_MatchPredicate paramI_MatchPredicate, AreaEval paramAreaEval2, int paramInt1, int paramInt2) {
/*  98 */     if (!paramI_MatchPredicate.matches(paramAreaEval1.getRelativeValue(paramInt1, paramInt2))) {
/*  99 */       return 0.0D;
/*     */     }
/* 101 */     ValueEval valueEval = paramAreaEval2.getRelativeValue(paramInt1, paramInt2);
/* 102 */     if (valueEval instanceof NumberEval) {
/* 103 */       return ((NumberEval)valueEval).getNumberValue();
/*     */     }
/*     */     
/* 106 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static AreaEval createSumRange(ValueEval paramValueEval, AreaEval paramAreaEval) throws EvaluationException {
/* 114 */     if (paramValueEval instanceof AreaEval) {
/* 115 */       return ((AreaEval)paramValueEval).offset(0, paramAreaEval.getHeight() - 1, 0, paramAreaEval.getWidth() - 1);
/*     */     }
/* 117 */     if (paramValueEval instanceof RefEval) {
/* 118 */       return ((RefEval)paramValueEval).offset(0, paramAreaEval.getHeight() - 1, 0, paramAreaEval.getWidth() - 1);
/*     */     }
/* 120 */     throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */   }
/*     */   
/*     */   private static AreaEval convertRangeArg(ValueEval paramValueEval) throws EvaluationException {
/* 124 */     if (paramValueEval instanceof AreaEval) {
/* 125 */       return (AreaEval)paramValueEval;
/*     */     }
/* 127 */     if (paramValueEval instanceof RefEval) {
/* 128 */       return ((RefEval)paramValueEval).offset(0, 0, 0, 0);
/*     */     }
/* 130 */     throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Sumif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */