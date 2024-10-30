/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*     */ public final class Irr
/*     */   implements Function
/*     */ {
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*  37 */     if (paramArrayOfValueEval.length == 0 || paramArrayOfValueEval.length > 2)
/*     */     {
/*  39 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*     */     try {
/*  43 */       double d1, arrayOfDouble[] = AggregateFunction.ValueCollector.collectValues(new ValueEval[] { paramArrayOfValueEval[0] });
/*     */       
/*  45 */       if (paramArrayOfValueEval.length == 2) {
/*  46 */         d1 = NumericFunction.singleOperandEvaluate(paramArrayOfValueEval[1], paramInt1, paramInt2);
/*     */       } else {
/*  48 */         d1 = 0.1D;
/*     */       } 
/*  50 */       double d2 = irr(arrayOfDouble, d1);
/*  51 */       NumericFunction.checkValue(d2);
/*  52 */       return (ValueEval)new NumberEval(d2);
/*  53 */     } catch (EvaluationException evaluationException) {
/*  54 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double irr(double[] paramArrayOfdouble) {
/*  65 */     return irr(paramArrayOfdouble, 0.1D);
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
/*     */   public static double irr(double[] paramArrayOfdouble, double paramDouble) {
/*  92 */     byte b1 = 20;
/*  93 */     double d1 = 1.0E-7D;
/*     */     
/*  95 */     double d2 = paramDouble;
/*     */ 
/*     */     
/*  98 */     byte b2 = 0;
/*  99 */     while (b2 < b1) {
/*     */ 
/*     */       
/* 102 */       double d4 = 0.0D;
/* 103 */       double d5 = 0.0D;
/* 104 */       for (byte b = 0; b < paramArrayOfdouble.length; b++) {
/* 105 */         d4 += paramArrayOfdouble[b] / Math.pow(1.0D + d2, b);
/* 106 */         d5 += -b * paramArrayOfdouble[b] / Math.pow(1.0D + d2, (b + 1));
/*     */       } 
/*     */ 
/*     */       
/* 110 */       double d3 = d2 - d4 / d5;
/*     */       
/* 112 */       if (Math.abs(d3 - d2) <= d1) {
/* 113 */         return d3;
/*     */       }
/*     */       
/* 116 */       d2 = d3;
/* 117 */       b2++;
/*     */     } 
/*     */     
/* 120 */     return Double.NaN;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Irr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */