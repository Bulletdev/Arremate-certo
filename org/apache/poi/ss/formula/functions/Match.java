/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.NumericValueEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.RefEval;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Match
/*     */   extends Var2or3ArgFunction
/*     */ {
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*  67 */     return eval(paramInt1, paramInt2, paramValueEval1, paramValueEval2, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*     */     double d;
/*     */     try {
/*  77 */       d = evaluateMatchTypeArg(paramValueEval3, paramInt1, paramInt2);
/*  78 */     } catch (EvaluationException evaluationException) {
/*     */ 
/*     */ 
/*     */       
/*  82 */       return (ValueEval)ErrorEval.REF_INVALID;
/*     */     } 
/*     */     
/*  85 */     return eval(paramInt1, paramInt2, paramValueEval1, paramValueEval2, d);
/*     */   }
/*     */ 
/*     */   
/*     */   private static ValueEval eval(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, double paramDouble) {
/*  90 */     boolean bool1 = (paramDouble == 0.0D) ? true : false;
/*     */     
/*  92 */     boolean bool2 = (paramDouble > 0.0D) ? true : false;
/*     */     
/*     */     try {
/*  95 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*  96 */       LookupUtils.ValueVector valueVector = evaluateLookupRange(paramValueEval2);
/*  97 */       int i = findIndexOfValue(valueEval, valueVector, bool1, bool2);
/*  98 */       return (ValueEval)new NumberEval((i + 1));
/*  99 */     } catch (EvaluationException evaluationException) {
/* 100 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final class SingleValueVector
/*     */     implements LookupUtils.ValueVector {
/*     */     private final ValueEval _value;
/*     */     
/*     */     public SingleValueVector(ValueEval param1ValueEval) {
/* 109 */       this._value = param1ValueEval;
/*     */     }
/*     */     
/*     */     public ValueEval getItem(int param1Int) {
/* 113 */       if (param1Int != 0) {
/* 114 */         throw new RuntimeException("Invalid index (" + param1Int + ") only zero is allowed");
/*     */       }
/*     */       
/* 117 */       return this._value;
/*     */     }
/*     */     
/*     */     public int getSize() {
/* 121 */       return 1;
/*     */     }
/*     */   }
/*     */   
/*     */   private static LookupUtils.ValueVector evaluateLookupRange(ValueEval paramValueEval) throws EvaluationException {
/* 126 */     if (paramValueEval instanceof RefEval) {
/* 127 */       RefEval refEval = (RefEval)paramValueEval;
/* 128 */       if (refEval.getNumberOfSheets() == 1) {
/* 129 */         return new SingleValueVector(refEval.getInnerValueEval(refEval.getFirstSheetIndex()));
/*     */       }
/* 131 */       return LookupUtils.createVector(refEval);
/*     */     } 
/*     */     
/* 134 */     if (paramValueEval instanceof TwoDEval) {
/* 135 */       LookupUtils.ValueVector valueVector = LookupUtils.createVector((TwoDEval)paramValueEval);
/* 136 */       if (valueVector == null) {
/* 137 */         throw new EvaluationException(ErrorEval.NA);
/*     */       }
/* 139 */       return valueVector;
/*     */     } 
/*     */ 
/*     */     
/* 143 */     if (paramValueEval instanceof NumericValueEval) {
/* 144 */       throw new EvaluationException(ErrorEval.NA);
/*     */     }
/* 146 */     if (paramValueEval instanceof StringEval) {
/* 147 */       StringEval stringEval = (StringEval)paramValueEval;
/* 148 */       Double double_ = OperandResolver.parseDouble(stringEval.getStringValue());
/* 149 */       if (double_ == null)
/*     */       {
/* 151 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/*     */       
/* 154 */       throw new EvaluationException(ErrorEval.NA);
/*     */     } 
/* 156 */     throw new RuntimeException("Unexpected eval type (" + paramValueEval.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static double evaluateMatchTypeArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 163 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*     */     
/* 165 */     if (valueEval instanceof ErrorEval) {
/* 166 */       throw new EvaluationException((ErrorEval)valueEval);
/*     */     }
/* 168 */     if (valueEval instanceof NumericValueEval) {
/* 169 */       NumericValueEval numericValueEval = (NumericValueEval)valueEval;
/* 170 */       return numericValueEval.getNumberValue();
/*     */     } 
/* 172 */     if (valueEval instanceof StringEval) {
/* 173 */       StringEval stringEval = (StringEval)valueEval;
/* 174 */       Double double_ = OperandResolver.parseDouble(stringEval.getStringValue());
/* 175 */       if (double_ == null)
/*     */       {
/* 177 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/*     */       
/* 180 */       return double_.doubleValue();
/*     */     } 
/* 182 */     throw new RuntimeException("Unexpected match_type type (" + valueEval.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int findIndexOfValue(ValueEval paramValueEval, LookupUtils.ValueVector paramValueVector, boolean paramBoolean1, boolean paramBoolean2) throws EvaluationException {
/* 191 */     LookupUtils.LookupValueComparer lookupValueComparer = createLookupComparer(paramValueEval, paramBoolean1);
/*     */     
/* 193 */     int i = paramValueVector.getSize();
/* 194 */     if (paramBoolean1) {
/* 195 */       for (byte b1 = 0; b1 < i; b1++) {
/* 196 */         if (lookupValueComparer.compareTo(paramValueVector.getItem(b1)).isEqual()) {
/* 197 */           return b1;
/*     */         }
/*     */       } 
/* 200 */       throw new EvaluationException(ErrorEval.NA);
/*     */     } 
/*     */     
/* 203 */     if (paramBoolean2) {
/*     */       
/* 205 */       for (int j = i - 1; j >= 0; j--) {
/* 206 */         LookupUtils.CompareResult compareResult = lookupValueComparer.compareTo(paramValueVector.getItem(j));
/* 207 */         if (!compareResult.isTypeMismatch())
/*     */         {
/*     */           
/* 210 */           if (!compareResult.isLessThan())
/* 211 */             return j; 
/*     */         }
/*     */       } 
/* 214 */       throw new EvaluationException(ErrorEval.NA);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 219 */     for (byte b = 0; b < i; b++) {
/* 220 */       LookupUtils.CompareResult compareResult = lookupValueComparer.compareTo(paramValueVector.getItem(b));
/* 221 */       if (compareResult.isEqual()) {
/* 222 */         return b;
/*     */       }
/* 224 */       if (compareResult.isGreaterThan()) {
/* 225 */         if (b < 1) {
/* 226 */           throw new EvaluationException(ErrorEval.NA);
/*     */         }
/* 228 */         return b - 1;
/*     */       } 
/*     */     } 
/* 231 */     return i - 1;
/*     */   }
/*     */   
/*     */   private static LookupUtils.LookupValueComparer createLookupComparer(ValueEval paramValueEval, boolean paramBoolean) {
/* 235 */     return LookupUtils.createLookupComparer(paramValueEval, paramBoolean, true);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Match.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */