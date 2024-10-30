/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.TwoDEval;
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
/*     */ public final class LinearRegressionFunction
/*     */   extends Fixed2ArgFunction
/*     */ {
/*     */   public FUNCTION function;
/*     */   
/*     */   private static abstract class ValueArray
/*     */     implements LookupUtils.ValueVector
/*     */   {
/*     */     private final int _size;
/*     */     
/*     */     protected ValueArray(int param1Int) {
/*  48 */       this._size = param1Int;
/*     */     }
/*     */     protected abstract ValueEval getItemInternal(int param1Int);
/*     */     public ValueEval getItem(int param1Int) {
/*  52 */       if (param1Int < 0 || param1Int > this._size) {
/*  53 */         throw new IllegalArgumentException("Specified index " + param1Int + " is outside range (0.." + (this._size - 1) + ")");
/*     */       }
/*     */       
/*  56 */       return getItemInternal(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public final int getSize() {
/*  61 */       return this._size;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class SingleCellValueArray extends ValueArray { private final ValueEval _value;
/*     */     
/*     */     public SingleCellValueArray(ValueEval param1ValueEval) {
/*  68 */       super(1);
/*  69 */       this._value = param1ValueEval;
/*     */     }
/*     */     
/*     */     protected ValueEval getItemInternal(int param1Int) {
/*  73 */       return this._value;
/*     */     } }
/*     */   
/*     */   private static final class RefValueArray extends ValueArray {
/*     */     private final RefEval _ref;
/*     */     private final int _width;
/*     */     
/*     */     public RefValueArray(RefEval param1RefEval) {
/*  81 */       super(param1RefEval.getNumberOfSheets());
/*  82 */       this._ref = param1RefEval;
/*  83 */       this._width = param1RefEval.getNumberOfSheets();
/*     */     }
/*     */     
/*     */     protected ValueEval getItemInternal(int param1Int) {
/*  87 */       int i = param1Int % this._width + this._ref.getFirstSheetIndex();
/*  88 */       return this._ref.getInnerValueEval(i);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class AreaValueArray extends ValueArray {
/*     */     private final TwoDEval _ae;
/*     */     private final int _width;
/*     */     
/*     */     public AreaValueArray(TwoDEval param1TwoDEval) {
/*  97 */       super(param1TwoDEval.getWidth() * param1TwoDEval.getHeight());
/*  98 */       this._ae = param1TwoDEval;
/*  99 */       this._width = param1TwoDEval.getWidth();
/*     */     }
/*     */     
/*     */     protected ValueEval getItemInternal(int param1Int) {
/* 103 */       int i = param1Int / this._width;
/* 104 */       int j = param1Int % this._width;
/* 105 */       return this._ae.getValue(i, j);
/*     */     } }
/*     */   
/*     */   public enum FUNCTION {
/* 109 */     INTERCEPT, SLOPE;
/*     */   }
/*     */   
/*     */   public LinearRegressionFunction(FUNCTION paramFUNCTION) {
/* 113 */     this.function = paramFUNCTION;
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*     */     double d;
/*     */     try {
/* 120 */       LookupUtils.ValueVector valueVector1 = createValueVector(paramValueEval1);
/* 121 */       LookupUtils.ValueVector valueVector2 = createValueVector(paramValueEval2);
/* 122 */       int i = valueVector2.getSize();
/* 123 */       if (i == 0 || valueVector1.getSize() != i) {
/* 124 */         return (ValueEval)ErrorEval.NA;
/*     */       }
/* 126 */       d = evaluateInternal(valueVector2, valueVector1, i);
/* 127 */     } catch (EvaluationException evaluationException) {
/* 128 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/* 130 */     if (Double.isNaN(d) || Double.isInfinite(d)) {
/* 131 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     }
/* 133 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double evaluateInternal(LookupUtils.ValueVector paramValueVector1, LookupUtils.ValueVector paramValueVector2, int paramInt) throws EvaluationException {
/* 140 */     ErrorEval errorEval1 = null;
/* 141 */     ErrorEval errorEval2 = null;
/* 142 */     boolean bool = false;
/*     */     
/* 144 */     double d1 = 0.0D, d2 = 0.0D;
/*     */     
/* 146 */     for (byte b1 = 0; b1 < paramInt; b1++) {
/* 147 */       ValueEval valueEval1 = paramValueVector1.getItem(b1);
/* 148 */       ValueEval valueEval2 = paramValueVector2.getItem(b1);
/* 149 */       if (valueEval1 instanceof ErrorEval && 
/* 150 */         errorEval1 == null) {
/* 151 */         errorEval1 = (ErrorEval)valueEval1;
/*     */ 
/*     */       
/*     */       }
/* 155 */       else if (valueEval2 instanceof ErrorEval && 
/* 156 */         errorEval2 == null) {
/* 157 */         errorEval2 = (ErrorEval)valueEval2;
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 162 */       else if (valueEval1 instanceof NumberEval && valueEval2 instanceof NumberEval) {
/* 163 */         bool = true;
/* 164 */         NumberEval numberEval1 = (NumberEval)valueEval1;
/* 165 */         NumberEval numberEval2 = (NumberEval)valueEval2;
/* 166 */         d1 += numberEval1.getNumberValue();
/* 167 */         d2 += numberEval2.getNumberValue();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 172 */     double d3 = d1 / paramInt;
/* 173 */     double d4 = d2 / paramInt;
/*     */ 
/*     */     
/* 176 */     double d5 = 0.0D, d6 = 0.0D;
/* 177 */     for (byte b2 = 0; b2 < paramInt; b2++) {
/* 178 */       ValueEval valueEval1 = paramValueVector1.getItem(b2);
/* 179 */       ValueEval valueEval2 = paramValueVector2.getItem(b2);
/*     */       
/* 181 */       if (valueEval1 instanceof ErrorEval && 
/* 182 */         errorEval1 == null) {
/* 183 */         errorEval1 = (ErrorEval)valueEval1;
/*     */ 
/*     */       
/*     */       }
/* 187 */       else if (valueEval2 instanceof ErrorEval && 
/* 188 */         errorEval2 == null) {
/* 189 */         errorEval2 = (ErrorEval)valueEval2;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 195 */       else if (valueEval1 instanceof NumberEval && valueEval2 instanceof NumberEval) {
/* 196 */         NumberEval numberEval1 = (NumberEval)valueEval1;
/* 197 */         NumberEval numberEval2 = (NumberEval)valueEval2;
/* 198 */         d5 += (numberEval1.getNumberValue() - d3) * (numberEval1.getNumberValue() - d3);
/* 199 */         d6 += (numberEval1.getNumberValue() - d3) * (numberEval2.getNumberValue() - d4);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 204 */     double d7 = d6 / d5;
/* 205 */     double d8 = d4 - d7 * d3;
/*     */     
/* 207 */     if (errorEval1 != null) {
/* 208 */       throw new EvaluationException(errorEval1);
/*     */     }
/* 210 */     if (errorEval2 != null) {
/* 211 */       throw new EvaluationException(errorEval2);
/*     */     }
/* 213 */     if (!bool) {
/* 214 */       throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */     }
/*     */     
/* 217 */     if (this.function == FUNCTION.INTERCEPT) {
/* 218 */       return d8;
/*     */     }
/* 220 */     return d7;
/*     */   }
/*     */ 
/*     */   
/*     */   private static LookupUtils.ValueVector createValueVector(ValueEval paramValueEval) throws EvaluationException {
/* 225 */     if (paramValueEval instanceof ErrorEval) {
/* 226 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*     */     }
/* 228 */     if (paramValueEval instanceof TwoDEval) {
/* 229 */       return new AreaValueArray((TwoDEval)paramValueEval);
/*     */     }
/* 231 */     if (paramValueEval instanceof RefEval) {
/* 232 */       return new RefValueArray((RefEval)paramValueEval);
/*     */     }
/* 234 */     return new SingleCellValueArray(paramValueEval);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\LinearRegressionFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */