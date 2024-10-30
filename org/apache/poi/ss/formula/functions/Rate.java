/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public class Rate
/*     */   implements Function
/*     */ {
/*  32 */   private static final POILogger LOG = POILogFactory.getLogger(Rate.class);
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     double d4;
/*  35 */     if (paramArrayOfValueEval.length < 3) {
/*  36 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*  39 */     double d1 = 0.0D, d2 = 0.0D, d3 = 0.1D;
/*     */     
/*     */     try {
/*  42 */       ValueEval valueEval1 = OperandResolver.getSingleValue(paramArrayOfValueEval[0], paramInt1, paramInt2);
/*  43 */       ValueEval valueEval2 = OperandResolver.getSingleValue(paramArrayOfValueEval[1], paramInt1, paramInt2);
/*  44 */       ValueEval valueEval3 = OperandResolver.getSingleValue(paramArrayOfValueEval[2], paramInt1, paramInt2);
/*  45 */       ValueEval valueEval4 = null;
/*  46 */       if (paramArrayOfValueEval.length >= 4)
/*  47 */         valueEval4 = OperandResolver.getSingleValue(paramArrayOfValueEval[3], paramInt1, paramInt2); 
/*  48 */       ValueEval valueEval5 = null;
/*  49 */       if (paramArrayOfValueEval.length >= 5)
/*  50 */         valueEval5 = OperandResolver.getSingleValue(paramArrayOfValueEval[4], paramInt1, paramInt2); 
/*  51 */       ValueEval valueEval6 = null;
/*  52 */       if (paramArrayOfValueEval.length >= 6) {
/*  53 */         valueEval6 = OperandResolver.getSingleValue(paramArrayOfValueEval[5], paramInt1, paramInt2);
/*     */       }
/*  55 */       double d5 = OperandResolver.coerceValueToDouble(valueEval1);
/*  56 */       double d6 = OperandResolver.coerceValueToDouble(valueEval2);
/*  57 */       double d7 = OperandResolver.coerceValueToDouble(valueEval3);
/*  58 */       if (paramArrayOfValueEval.length >= 4)
/*  59 */         d1 = OperandResolver.coerceValueToDouble(valueEval4); 
/*  60 */       if (paramArrayOfValueEval.length >= 5)
/*  61 */         d2 = OperandResolver.coerceValueToDouble(valueEval5); 
/*  62 */       if (paramArrayOfValueEval.length >= 6)
/*  63 */         d3 = OperandResolver.coerceValueToDouble(valueEval6); 
/*  64 */       d4 = calculateRate(d5, d6, d7, d1, d2, d3);
/*     */       
/*  66 */       checkValue(d4);
/*  67 */     } catch (EvaluationException evaluationException) {
/*  68 */       LOG.log(7, new Object[] { "Can't evaluate rate function", evaluationException });
/*  69 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */     
/*  72 */     return (ValueEval)new NumberEval(d4);
/*     */   }
/*     */ 
/*     */   
/*     */   private double calculateRate(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
/*  77 */     byte b = 20;
/*  78 */     double d1 = 1.0E-7D;
/*     */     
/*  80 */     double d5 = 0.0D, d6 = 0.0D, d7 = 0.0D;
/*  81 */     double d8 = paramDouble6;
/*  82 */     if (Math.abs(d8) < d1) {
/*  83 */       double d = paramDouble3 * (1.0D + paramDouble1 * d8) + paramDouble2 * (1.0D + d8 * paramDouble5) * paramDouble1 + paramDouble4;
/*     */     } else {
/*  85 */       d6 = Math.exp(paramDouble1 * Math.log(1.0D + d8));
/*  86 */       double d = paramDouble3 * d6 + paramDouble2 * (1.0D / d8 + paramDouble5) * (d6 - 1.0D) + paramDouble4;
/*     */     } 
/*  88 */     double d2 = paramDouble3 + paramDouble2 * paramDouble1 + paramDouble4;
/*  89 */     double d3 = paramDouble3 * d6 + paramDouble2 * (1.0D / d8 + paramDouble5) * (d6 - 1.0D) + paramDouble4;
/*     */ 
/*     */     
/*  92 */     double d4 = 0.0D;
/*  93 */     d5 = d8;
/*  94 */     while (Math.abs(d2 - d3) > d1 && d7 < b) {
/*  95 */       double d; d8 = (d3 * d4 - d2 * d5) / (d3 - d2);
/*  96 */       d4 = d5;
/*  97 */       d5 = d8;
/*     */       
/*  99 */       if (Math.abs(d8) < d1) {
/* 100 */         d = paramDouble3 * (1.0D + paramDouble1 * d8) + paramDouble2 * (1.0D + d8 * paramDouble5) * paramDouble1 + paramDouble4;
/*     */       } else {
/* 102 */         d6 = Math.exp(paramDouble1 * Math.log(1.0D + d8));
/* 103 */         d = paramDouble3 * d6 + paramDouble2 * (1.0D / d8 + paramDouble5) * (d6 - 1.0D) + paramDouble4;
/*     */       } 
/*     */       
/* 106 */       d2 = d3;
/* 107 */       d3 = d;
/* 108 */       d7++;
/*     */     } 
/* 110 */     return d8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final void checkValue(double paramDouble) throws EvaluationException {
/* 119 */     if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble))
/* 120 */       throw new EvaluationException(ErrorEval.NUM_ERROR); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Rate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */