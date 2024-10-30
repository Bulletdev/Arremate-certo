/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.AreaEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.NumericValueEval;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Sumproduct
/*     */   implements Function
/*     */ {
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*  59 */     int i = paramArrayOfValueEval.length;
/*     */     
/*  61 */     if (i < 1) {
/*  62 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*  64 */     ValueEval valueEval = paramArrayOfValueEval[0];
/*     */     try {
/*  66 */       if (valueEval instanceof NumericValueEval) {
/*  67 */         return evaluateSingleProduct(paramArrayOfValueEval);
/*     */       }
/*  69 */       if (valueEval instanceof RefEval) {
/*  70 */         return evaluateSingleProduct(paramArrayOfValueEval);
/*     */       }
/*  72 */       if (valueEval instanceof TwoDEval) {
/*  73 */         TwoDEval twoDEval = (TwoDEval)valueEval;
/*  74 */         if (twoDEval.isRow() && twoDEval.isColumn()) {
/*  75 */           return evaluateSingleProduct(paramArrayOfValueEval);
/*     */         }
/*  77 */         return evaluateAreaSumProduct(paramArrayOfValueEval);
/*     */       } 
/*  79 */     } catch (EvaluationException evaluationException) {
/*  80 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  82 */     throw new RuntimeException("Invalid arg type for SUMPRODUCT: (" + valueEval.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   private static ValueEval evaluateSingleProduct(ValueEval[] paramArrayOfValueEval) throws EvaluationException {
/*  87 */     int i = paramArrayOfValueEval.length;
/*     */     
/*  89 */     double d = 1.0D;
/*  90 */     for (byte b = 0; b < i; b++) {
/*  91 */       double d1 = getScalarValue(paramArrayOfValueEval[b]);
/*  92 */       d *= d1;
/*     */     } 
/*  94 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */ 
/*     */   
/*     */   private static double getScalarValue(ValueEval paramValueEval) throws EvaluationException {
/*     */     ValueEval valueEval;
/* 100 */     if (paramValueEval instanceof RefEval) {
/* 101 */       RefEval refEval = (RefEval)paramValueEval;
/* 102 */       if (refEval.getNumberOfSheets() > 1) {
/* 103 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/* 105 */       valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
/*     */     } else {
/* 107 */       valueEval = paramValueEval;
/*     */     } 
/*     */     
/* 110 */     if (valueEval == null) {
/* 111 */       throw new RuntimeException("parameter may not be null");
/*     */     }
/* 113 */     if (valueEval instanceof AreaEval) {
/* 114 */       AreaEval areaEval = (AreaEval)valueEval;
/*     */       
/* 116 */       if (!areaEval.isColumn() || !areaEval.isRow()) {
/* 117 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/* 119 */       valueEval = areaEval.getRelativeValue(0, 0);
/*     */     } 
/*     */     
/* 122 */     return getProductTerm(valueEval, true);
/*     */   }
/*     */   
/*     */   private static ValueEval evaluateAreaSumProduct(ValueEval[] paramArrayOfValueEval) throws EvaluationException {
/* 126 */     int i = paramArrayOfValueEval.length;
/* 127 */     TwoDEval[] arrayOfTwoDEval = new TwoDEval[i];
/*     */     try {
/* 129 */       System.arraycopy(paramArrayOfValueEval, 0, arrayOfTwoDEval, 0, i);
/* 130 */     } catch (ArrayStoreException arrayStoreException) {
/*     */       
/* 132 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     } 
/*     */ 
/*     */     
/* 136 */     TwoDEval twoDEval = arrayOfTwoDEval[0];
/*     */     
/* 138 */     int j = twoDEval.getHeight();
/* 139 */     int k = twoDEval.getWidth();
/*     */ 
/*     */     
/* 142 */     if (!areasAllSameSize(arrayOfTwoDEval, j, k)) {
/*     */ 
/*     */       
/* 145 */       for (byte b1 = 1; b1 < arrayOfTwoDEval.length; b1++) {
/* 146 */         throwFirstError(arrayOfTwoDEval[b1]);
/*     */       }
/* 148 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     } 
/*     */     
/* 151 */     double d = 0.0D;
/*     */     
/* 153 */     for (byte b = 0; b < j; b++) {
/* 154 */       for (byte b1 = 0; b1 < k; b1++) {
/* 155 */         double d1 = 1.0D;
/* 156 */         for (byte b2 = 0; b2 < i; b2++) {
/* 157 */           double d2 = getProductTerm(arrayOfTwoDEval[b2].getValue(b, b1), false);
/* 158 */           d1 *= d2;
/*     */         } 
/* 160 */         d += d1;
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */   
/*     */   private static void throwFirstError(TwoDEval paramTwoDEval) throws EvaluationException {
/* 168 */     int i = paramTwoDEval.getHeight();
/* 169 */     int j = paramTwoDEval.getWidth();
/* 170 */     for (byte b = 0; b < i; b++) {
/* 171 */       for (byte b1 = 0; b1 < j; b1++) {
/* 172 */         ValueEval valueEval = paramTwoDEval.getValue(b, b1);
/* 173 */         if (valueEval instanceof ErrorEval) {
/* 174 */           throw new EvaluationException((ErrorEval)valueEval);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean areasAllSameSize(TwoDEval[] paramArrayOfTwoDEval, int paramInt1, int paramInt2) {
/* 181 */     for (byte b = 0; b < paramArrayOfTwoDEval.length; b++) {
/* 182 */       TwoDEval twoDEval = paramArrayOfTwoDEval[b];
/*     */       
/* 184 */       if (twoDEval.getHeight() != paramInt1) {
/* 185 */         return false;
/*     */       }
/* 187 */       if (twoDEval.getWidth() != paramInt2) {
/* 188 */         return false;
/*     */       }
/*     */     } 
/* 191 */     return true;
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
/*     */   private static double getProductTerm(ValueEval paramValueEval, boolean paramBoolean) throws EvaluationException {
/* 207 */     if (paramValueEval instanceof org.apache.poi.ss.formula.eval.BlankEval || paramValueEval == null) {
/*     */ 
/*     */       
/* 210 */       if (paramBoolean) {
/* 211 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/* 213 */       return 0.0D;
/*     */     } 
/*     */     
/* 216 */     if (paramValueEval instanceof ErrorEval) {
/* 217 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*     */     }
/* 219 */     if (paramValueEval instanceof org.apache.poi.ss.formula.eval.StringEval) {
/* 220 */       if (paramBoolean) {
/* 221 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/*     */ 
/*     */       
/* 225 */       return 0.0D;
/*     */     } 
/* 227 */     if (paramValueEval instanceof NumericValueEval) {
/* 228 */       NumericValueEval numericValueEval = (NumericValueEval)paramValueEval;
/* 229 */       return numericValueEval.getNumberValue();
/*     */     } 
/* 231 */     throw new RuntimeException("Unexpected value eval class (" + paramValueEval.getClass().getName() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Sumproduct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */