/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.ThreeDEval;
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.NumericValueEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.RefEval;
/*     */ import org.apache.poi.ss.formula.eval.StringValueEval;
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
/*     */ public abstract class MultiOperandNumericFunction
/*     */   implements Function
/*     */ {
/*     */   private final boolean _isReferenceBoolCounted;
/*     */   private final boolean _isBlankCounted;
/*     */   
/*     */   protected MultiOperandNumericFunction(boolean paramBoolean1, boolean paramBoolean2) {
/*  44 */     this._isReferenceBoolCounted = paramBoolean1;
/*  45 */     this._isBlankCounted = paramBoolean2;
/*     */   }
/*     */   
/*  48 */   static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
/*     */   
/*     */   private static final int DEFAULT_MAX_NUM_OPERANDS = 30;
/*     */ 
/*     */   
/*     */   private static class DoubleList
/*     */   {
/*  55 */     private double[] _array = new double[8];
/*  56 */     private int _count = 0;
/*     */ 
/*     */     
/*     */     public double[] toArray() {
/*  60 */       if (this._count < 1) {
/*  61 */         return MultiOperandNumericFunction.EMPTY_DOUBLE_ARRAY;
/*     */       }
/*  63 */       double[] arrayOfDouble = new double[this._count];
/*  64 */       System.arraycopy(this._array, 0, arrayOfDouble, 0, this._count);
/*  65 */       return arrayOfDouble;
/*     */     }
/*     */     
/*     */     private void ensureCapacity(int param1Int) {
/*  69 */       if (param1Int > this._array.length) {
/*  70 */         int i = param1Int * 3 / 2;
/*  71 */         double[] arrayOfDouble = new double[i];
/*  72 */         System.arraycopy(this._array, 0, arrayOfDouble, 0, this._count);
/*  73 */         this._array = arrayOfDouble;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void add(double param1Double) {
/*  78 */       ensureCapacity(this._count + 1);
/*  79 */       this._array[this._count] = param1Double;
/*  80 */       this._count++;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     double d;
/*     */     try {
/*  90 */       double[] arrayOfDouble = getNumberArray(paramArrayOfValueEval);
/*  91 */       d = evaluate(arrayOfDouble);
/*  92 */     } catch (EvaluationException evaluationException) {
/*  93 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */     
/*  96 */     if (Double.isNaN(d) || Double.isInfinite(d)) {
/*  97 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     }
/*  99 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract double evaluate(double[] paramArrayOfdouble) throws EvaluationException;
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getMaxNumOperands() {
/* 109 */     return 30;
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
/*     */   protected final double[] getNumberArray(ValueEval[] paramArrayOfValueEval) throws EvaluationException {
/* 122 */     if (paramArrayOfValueEval.length > getMaxNumOperands()) {
/* 123 */       throw EvaluationException.invalidValue();
/*     */     }
/* 125 */     DoubleList doubleList = new DoubleList(); byte b;
/*     */     int i;
/* 127 */     for (b = 0, i = paramArrayOfValueEval.length; b < i; b++) {
/* 128 */       collectValues(paramArrayOfValueEval[b], doubleList);
/*     */     }
/* 130 */     return doubleList.toArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSubtotalCounted() {
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void collectValues(ValueEval paramValueEval, DoubleList paramDoubleList) throws EvaluationException {
/* 144 */     if (paramValueEval instanceof ThreeDEval) {
/* 145 */       ThreeDEval threeDEval = (ThreeDEval)paramValueEval;
/* 146 */       for (int i = threeDEval.getFirstSheetIndex(); i <= threeDEval.getLastSheetIndex(); i++) {
/* 147 */         int j = threeDEval.getWidth();
/* 148 */         int k = threeDEval.getHeight();
/* 149 */         for (byte b = 0; b < k; b++) {
/* 150 */           for (byte b1 = 0; b1 < j; b1++) {
/* 151 */             ValueEval valueEval = threeDEval.getValue(i, b, b1);
/* 152 */             if (isSubtotalCounted() || !threeDEval.isSubTotal(b, b1))
/* 153 */               collectValue(valueEval, true, paramDoubleList); 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/* 159 */     if (paramValueEval instanceof TwoDEval) {
/* 160 */       TwoDEval twoDEval = (TwoDEval)paramValueEval;
/* 161 */       int i = twoDEval.getWidth();
/* 162 */       int j = twoDEval.getHeight();
/* 163 */       for (byte b = 0; b < j; b++) {
/* 164 */         for (byte b1 = 0; b1 < i; b1++) {
/* 165 */           ValueEval valueEval = twoDEval.getValue(b, b1);
/* 166 */           if (isSubtotalCounted() || !twoDEval.isSubTotal(b, b1))
/* 167 */             collectValue(valueEval, true, paramDoubleList); 
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/* 172 */     if (paramValueEval instanceof RefEval) {
/* 173 */       RefEval refEval = (RefEval)paramValueEval;
/* 174 */       for (int i = refEval.getFirstSheetIndex(); i <= refEval.getLastSheetIndex(); i++) {
/* 175 */         collectValue(refEval.getInnerValueEval(i), true, paramDoubleList);
/*     */       }
/*     */       return;
/*     */     } 
/* 179 */     collectValue(paramValueEval, false, paramDoubleList);
/*     */   }
/*     */   private void collectValue(ValueEval paramValueEval, boolean paramBoolean, DoubleList paramDoubleList) throws EvaluationException {
/* 182 */     if (paramValueEval == null) {
/* 183 */       throw new IllegalArgumentException("ve must not be null");
/*     */     }
/* 185 */     if (paramValueEval instanceof BoolEval) {
/* 186 */       if (!paramBoolean || this._isReferenceBoolCounted) {
/* 187 */         BoolEval boolEval = (BoolEval)paramValueEval;
/* 188 */         paramDoubleList.add(boolEval.getNumberValue());
/*     */       } 
/*     */       return;
/*     */     } 
/* 192 */     if (paramValueEval instanceof NumericValueEval) {
/* 193 */       NumericValueEval numericValueEval = (NumericValueEval)paramValueEval;
/* 194 */       paramDoubleList.add(numericValueEval.getNumberValue());
/*     */       return;
/*     */     } 
/* 197 */     if (paramValueEval instanceof StringValueEval) {
/* 198 */       if (paramBoolean) {
/*     */         return;
/*     */       }
/*     */       
/* 202 */       String str = ((StringValueEval)paramValueEval).getStringValue();
/* 203 */       Double double_ = OperandResolver.parseDouble(str);
/* 204 */       if (double_ == null) {
/* 205 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/* 207 */       paramDoubleList.add(double_.doubleValue());
/*     */       return;
/*     */     } 
/* 210 */     if (paramValueEval instanceof ErrorEval) {
/* 211 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*     */     }
/* 213 */     if (paramValueEval == BlankEval.instance) {
/* 214 */       if (this._isBlankCounted) {
/* 215 */         paramDoubleList.add(0.0D);
/*     */       }
/*     */       return;
/*     */     } 
/* 219 */     throw new RuntimeException("Invalid ValueEval type passed for conversion: (" + paramValueEval.getClass() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\MultiOperandNumericFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */