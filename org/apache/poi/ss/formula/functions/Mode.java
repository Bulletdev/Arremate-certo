/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
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
/*     */ public final class Mode
/*     */   implements Function
/*     */ {
/*     */   public static double evaluate(double[] paramArrayOfdouble) throws EvaluationException {
/*  48 */     if (paramArrayOfdouble.length < 2) {
/*  49 */       throw new EvaluationException(ErrorEval.NA);
/*     */     }
/*     */ 
/*     */     
/*  53 */     int[] arrayOfInt = new int[paramArrayOfdouble.length];
/*  54 */     Arrays.fill(arrayOfInt, 1); byte b1; int i;
/*  55 */     for (b1 = 0, i = paramArrayOfdouble.length; b1 < i; b1++) {
/*  56 */       for (int m = b1 + 1, n = paramArrayOfdouble.length; m < n; m++) {
/*  57 */         if (paramArrayOfdouble[b1] == paramArrayOfdouble[m])
/*  58 */           arrayOfInt[b1] = arrayOfInt[b1] + 1; 
/*     */       } 
/*     */     } 
/*  61 */     double d = 0.0D;
/*  62 */     int j = 0; byte b2; int k;
/*  63 */     for (b2 = 0, k = arrayOfInt.length; b2 < k; b2++) {
/*  64 */       if (arrayOfInt[b2] > j) {
/*  65 */         d = paramArrayOfdouble[b2];
/*  66 */         j = arrayOfInt[b2];
/*     */       } 
/*     */     } 
/*  69 */     if (j > 1) {
/*  70 */       return d;
/*     */     }
/*  72 */     throw new EvaluationException(ErrorEval.NA);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     double d;
/*     */     try {
/*  79 */       ArrayList<Double> arrayList = new ArrayList();
/*  80 */       for (byte b1 = 0; b1 < paramArrayOfValueEval.length; b1++) {
/*  81 */         collectValues(paramArrayOfValueEval[b1], arrayList);
/*     */       }
/*  83 */       double[] arrayOfDouble = new double[arrayList.size()];
/*  84 */       for (byte b2 = 0; b2 < arrayOfDouble.length; b2++) {
/*  85 */         arrayOfDouble[b2] = ((Double)arrayList.get(b2)).doubleValue();
/*     */       }
/*  87 */       d = evaluate(arrayOfDouble);
/*  88 */     } catch (EvaluationException evaluationException) {
/*  89 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  91 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */   
/*     */   private static void collectValues(ValueEval paramValueEval, List<Double> paramList) throws EvaluationException {
/*  95 */     if (paramValueEval instanceof TwoDEval) {
/*  96 */       TwoDEval twoDEval = (TwoDEval)paramValueEval;
/*  97 */       int i = twoDEval.getWidth();
/*  98 */       int j = twoDEval.getHeight();
/*  99 */       for (byte b = 0; b < j; b++) {
/* 100 */         for (byte b1 = 0; b1 < i; b1++) {
/* 101 */           ValueEval valueEval = twoDEval.getValue(b, b1);
/* 102 */           collectValue(valueEval, paramList, false);
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/* 107 */     if (paramValueEval instanceof RefEval) {
/* 108 */       RefEval refEval = (RefEval)paramValueEval;
/* 109 */       int i = refEval.getFirstSheetIndex();
/* 110 */       int j = refEval.getLastSheetIndex();
/* 111 */       for (int k = i; k <= j; k++) {
/* 112 */         collectValue(refEval.getInnerValueEval(k), paramList, true);
/*     */       }
/*     */       return;
/*     */     } 
/* 116 */     collectValue(paramValueEval, paramList, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void collectValue(ValueEval paramValueEval, List<Double> paramList, boolean paramBoolean) throws EvaluationException {
/* 122 */     if (paramValueEval instanceof ErrorEval) {
/* 123 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*     */     }
/* 125 */     if (paramValueEval == BlankEval.instance || paramValueEval instanceof org.apache.poi.ss.formula.eval.BoolEval || paramValueEval instanceof org.apache.poi.ss.formula.eval.StringEval) {
/* 126 */       if (paramBoolean) {
/* 127 */         throw EvaluationException.invalidValue();
/*     */       }
/*     */       return;
/*     */     } 
/* 131 */     if (paramValueEval instanceof NumberEval) {
/* 132 */       paramList.add(new Double(((NumberEval)paramValueEval).getNumberValue()));
/*     */       return;
/*     */     } 
/* 135 */     throw new RuntimeException("Unexpected value type (" + paramValueEval.getClass().getName() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Mode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */