/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.OperationEvaluationContext;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Sumifs
/*     */   implements FreeRefFunction
/*     */ {
/*  54 */   public static final FreeRefFunction instance = new Sumifs();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/*  60 */     if (paramArrayOfValueEval.length < 3 || paramArrayOfValueEval.length % 2 == 0) {
/*  61 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*     */     try {
/*  65 */       AreaEval areaEval = convertRangeArg(paramArrayOfValueEval[0]);
/*     */ 
/*     */       
/*  68 */       AreaEval[] arrayOfAreaEval = new AreaEval[(paramArrayOfValueEval.length - 1) / 2];
/*  69 */       CountUtils.I_MatchPredicate[] arrayOfI_MatchPredicate = new CountUtils.I_MatchPredicate[arrayOfAreaEval.length];
/*  70 */       for (byte b1 = 1, b2 = 0; b1 < paramArrayOfValueEval.length; b1 += 2, b2++) {
/*  71 */         arrayOfAreaEval[b2] = convertRangeArg(paramArrayOfValueEval[b1]);
/*     */         
/*  73 */         arrayOfI_MatchPredicate[b2] = Countif.createCriteriaPredicate(paramArrayOfValueEval[b1 + 1], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/*     */       } 
/*     */       
/*  76 */       validateCriteriaRanges(arrayOfAreaEval, areaEval);
/*  77 */       validateCriteria(arrayOfI_MatchPredicate);
/*     */       
/*  79 */       double d = sumMatchingCells(arrayOfAreaEval, arrayOfI_MatchPredicate, areaEval);
/*  80 */       return (ValueEval)new NumberEval(d);
/*  81 */     } catch (EvaluationException evaluationException) {
/*  82 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validateCriteriaRanges(AreaEval[] paramArrayOfAreaEval, AreaEval paramAreaEval) throws EvaluationException {
/*  93 */     for (AreaEval areaEval : paramArrayOfAreaEval) {
/*  94 */       if (areaEval.getHeight() != paramAreaEval.getHeight() || areaEval.getWidth() != paramAreaEval.getWidth())
/*     */       {
/*  96 */         throw EvaluationException.invalidValue();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validateCriteria(CountUtils.I_MatchPredicate[] paramArrayOfI_MatchPredicate) throws EvaluationException {
/* 107 */     for (CountUtils.I_MatchPredicate i_MatchPredicate : paramArrayOfI_MatchPredicate) {
/*     */ 
/*     */       
/* 110 */       if (i_MatchPredicate instanceof Countif.ErrorMatcher) {
/* 111 */         throw new EvaluationException(ErrorEval.valueOf(((Countif.ErrorMatcher)i_MatchPredicate).getValue()));
/*     */       }
/*     */     } 
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
/*     */   private static double sumMatchingCells(AreaEval[] paramArrayOfAreaEval, CountUtils.I_MatchPredicate[] paramArrayOfI_MatchPredicate, AreaEval paramAreaEval) {
/* 126 */     int i = paramAreaEval.getHeight();
/* 127 */     int j = paramAreaEval.getWidth();
/*     */     
/* 129 */     double d = 0.0D;
/* 130 */     for (byte b = 0; b < i; b++) {
/* 131 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         
/* 133 */         boolean bool = true;
/* 134 */         for (byte b2 = 0; b2 < paramArrayOfAreaEval.length; b2++) {
/* 135 */           AreaEval areaEval = paramArrayOfAreaEval[b2];
/* 136 */           CountUtils.I_MatchPredicate i_MatchPredicate = paramArrayOfI_MatchPredicate[b2];
/*     */           
/* 138 */           if (!i_MatchPredicate.matches(areaEval.getRelativeValue(b, b1))) {
/* 139 */             bool = false;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/* 145 */         if (bool) {
/* 146 */           d += accumulate(paramAreaEval, b, b1);
/*     */         }
/*     */       } 
/*     */     } 
/* 150 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static double accumulate(AreaEval paramAreaEval, int paramInt1, int paramInt2) {
/* 156 */     ValueEval valueEval = paramAreaEval.getRelativeValue(paramInt1, paramInt2);
/* 157 */     if (valueEval instanceof NumberEval) {
/* 158 */       return ((NumberEval)valueEval).getNumberValue();
/*     */     }
/*     */     
/* 161 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private static AreaEval convertRangeArg(ValueEval paramValueEval) throws EvaluationException {
/* 165 */     if (paramValueEval instanceof AreaEval) {
/* 166 */       return (AreaEval)paramValueEval;
/*     */     }
/* 168 */     if (paramValueEval instanceof RefEval) {
/* 169 */       return ((RefEval)paramValueEval).offset(0, 0, 0, 0);
/*     */     }
/* 171 */     throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Sumifs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */