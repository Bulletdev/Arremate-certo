/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.AreaEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
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
/*     */ public class Rank
/*     */   extends Var2or3ArgFunction
/*     */ {
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*     */     AreaEval areaEval;
/*     */     double d;
/*     */     try {
/*  52 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*  53 */       d = OperandResolver.coerceValueToDouble(valueEval);
/*  54 */       if (Double.isNaN(d) || Double.isInfinite(d)) {
/*  55 */         throw new EvaluationException(ErrorEval.NUM_ERROR);
/*     */       }
/*  57 */       areaEval = convertRangeArg(paramValueEval2);
/*  58 */     } catch (EvaluationException evaluationException) {
/*  59 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  61 */     return eval(paramInt1, paramInt2, d, areaEval, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*     */     AreaEval areaEval;
/*     */     double d;
/*  68 */     boolean bool = false;
/*     */     try {
/*  70 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*  71 */       d = OperandResolver.coerceValueToDouble(valueEval);
/*  72 */       if (Double.isNaN(d) || Double.isInfinite(d)) {
/*  73 */         throw new EvaluationException(ErrorEval.NUM_ERROR);
/*     */       }
/*  75 */       areaEval = convertRangeArg(paramValueEval2);
/*     */       
/*  77 */       valueEval = OperandResolver.getSingleValue(paramValueEval3, paramInt1, paramInt2);
/*  78 */       int i = OperandResolver.coerceValueToInt(valueEval);
/*  79 */       if (i == 0)
/*  80 */       { bool = true; }
/*  81 */       else if (i == 1)
/*  82 */       { bool = false; }
/*  83 */       else { throw new EvaluationException(ErrorEval.NUM_ERROR); }
/*     */     
/*  85 */     } catch (EvaluationException evaluationException) {
/*  86 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  88 */     return eval(paramInt1, paramInt2, d, areaEval, bool);
/*     */   }
/*     */ 
/*     */   
/*     */   private static ValueEval eval(int paramInt1, int paramInt2, double paramDouble, AreaEval paramAreaEval, boolean paramBoolean) {
/*  93 */     byte b1 = 1;
/*  94 */     int i = paramAreaEval.getHeight();
/*  95 */     int j = paramAreaEval.getWidth();
/*  96 */     for (byte b2 = 0; b2 < i; b2++) {
/*  97 */       for (byte b = 0; b < j; b++) {
/*     */         
/*  99 */         Double double_ = getValue(paramAreaEval, b2, b);
/* 100 */         if (double_ != null && ((
/* 101 */           paramBoolean && double_.doubleValue() > paramDouble) || (!paramBoolean && double_.doubleValue() < paramDouble))) {
/* 102 */           b1++;
/*     */         }
/*     */       } 
/*     */     } 
/* 106 */     return (ValueEval)new NumberEval(b1);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Double getValue(AreaEval paramAreaEval, int paramInt1, int paramInt2) {
/* 111 */     ValueEval valueEval = paramAreaEval.getRelativeValue(paramInt1, paramInt2);
/* 112 */     if (valueEval instanceof NumberEval) {
/* 113 */       return Double.valueOf(((NumberEval)valueEval).getNumberValue());
/*     */     }
/*     */     
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   private static AreaEval convertRangeArg(ValueEval paramValueEval) throws EvaluationException {
/* 120 */     if (paramValueEval instanceof AreaEval) {
/* 121 */       return (AreaEval)paramValueEval;
/*     */     }
/* 123 */     if (paramValueEval instanceof RefEval) {
/* 124 */       return ((RefEval)paramValueEval).offset(0, 0, 0, 0);
/*     */     }
/* 126 */     throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Rank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */