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
/*     */ public abstract class XYNumericFunction
/*     */   extends Fixed2ArgFunction
/*     */ {
/*     */   protected abstract Accumulator createAccumulator();
/*     */   
/*     */   private static abstract class ValueArray
/*     */     implements LookupUtils.ValueVector
/*     */   {
/*     */     private final int _size;
/*     */     
/*     */     protected ValueArray(int param1Int) {
/*  36 */       this._size = param1Int;
/*     */     }
/*     */     public ValueEval getItem(int param1Int) {
/*  39 */       if (param1Int < 0 || param1Int > this._size) {
/*  40 */         throw new IllegalArgumentException("Specified index " + param1Int + " is outside range (0.." + (this._size - 1) + ")");
/*     */       }
/*     */       
/*  43 */       return getItemInternal(param1Int);
/*     */     }
/*     */     
/*     */     public final int getSize() {
/*  47 */       return this._size;
/*     */     }
/*     */     protected abstract ValueEval getItemInternal(int param1Int); }
/*     */   
/*     */   private static final class SingleCellValueArray extends ValueArray { private final ValueEval _value;
/*     */     
/*     */     public SingleCellValueArray(ValueEval param1ValueEval) {
/*  54 */       super(1);
/*  55 */       this._value = param1ValueEval;
/*     */     }
/*     */     protected ValueEval getItemInternal(int param1Int) {
/*  58 */       return this._value;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static final class RefValueArray extends ValueArray {
/*     */     private final RefEval _ref;
/*     */     private final int _width;
/*     */     
/*     */     public RefValueArray(RefEval param1RefEval) {
/*  67 */       super(param1RefEval.getNumberOfSheets());
/*  68 */       this._ref = param1RefEval;
/*  69 */       this._width = param1RefEval.getNumberOfSheets();
/*     */     }
/*     */     protected ValueEval getItemInternal(int param1Int) {
/*  72 */       int i = param1Int % this._width + this._ref.getFirstSheetIndex();
/*  73 */       return this._ref.getInnerValueEval(i);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class AreaValueArray extends ValueArray {
/*     */     private final TwoDEval _ae;
/*     */     private final int _width;
/*     */     
/*     */     public AreaValueArray(TwoDEval param1TwoDEval) {
/*  82 */       super(param1TwoDEval.getWidth() * param1TwoDEval.getHeight());
/*  83 */       this._ae = param1TwoDEval;
/*  84 */       this._width = param1TwoDEval.getWidth();
/*     */     }
/*     */     protected ValueEval getItemInternal(int param1Int) {
/*  87 */       int i = param1Int / this._width;
/*  88 */       int j = param1Int % this._width;
/*  89 */       return this._ae.getValue(i, j);
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
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*     */     double d;
/*     */     try {
/* 106 */       LookupUtils.ValueVector valueVector1 = createValueVector(paramValueEval1);
/* 107 */       LookupUtils.ValueVector valueVector2 = createValueVector(paramValueEval2);
/* 108 */       int i = valueVector1.getSize();
/* 109 */       if (i == 0 || valueVector2.getSize() != i) {
/* 110 */         return (ValueEval)ErrorEval.NA;
/*     */       }
/* 112 */       d = evaluateInternal(valueVector1, valueVector2, i);
/* 113 */     } catch (EvaluationException evaluationException) {
/* 114 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/* 116 */     if (Double.isNaN(d) || Double.isInfinite(d)) {
/* 117 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     }
/* 119 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */ 
/*     */   
/*     */   private double evaluateInternal(LookupUtils.ValueVector paramValueVector1, LookupUtils.ValueVector paramValueVector2, int paramInt) throws EvaluationException {
/* 124 */     Accumulator accumulator = createAccumulator();
/*     */ 
/*     */     
/* 127 */     ErrorEval errorEval1 = null;
/* 128 */     ErrorEval errorEval2 = null;
/* 129 */     boolean bool = false;
/* 130 */     double d = 0.0D;
/*     */     
/* 132 */     for (byte b = 0; b < paramInt; b++) {
/* 133 */       ValueEval valueEval1 = paramValueVector1.getItem(b);
/* 134 */       ValueEval valueEval2 = paramValueVector2.getItem(b);
/* 135 */       if (valueEval1 instanceof ErrorEval && 
/* 136 */         errorEval1 == null) {
/* 137 */         errorEval1 = (ErrorEval)valueEval1;
/*     */ 
/*     */       
/*     */       }
/* 141 */       else if (valueEval2 instanceof ErrorEval && 
/* 142 */         errorEval2 == null) {
/* 143 */         errorEval2 = (ErrorEval)valueEval2;
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 148 */       else if (valueEval1 instanceof NumberEval && valueEval2 instanceof NumberEval) {
/* 149 */         bool = true;
/* 150 */         NumberEval numberEval1 = (NumberEval)valueEval1;
/* 151 */         NumberEval numberEval2 = (NumberEval)valueEval2;
/* 152 */         d += accumulator.accumulate(numberEval1.getNumberValue(), numberEval2.getNumberValue());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 157 */     if (errorEval1 != null) {
/* 158 */       throw new EvaluationException(errorEval1);
/*     */     }
/* 160 */     if (errorEval2 != null) {
/* 161 */       throw new EvaluationException(errorEval2);
/*     */     }
/* 163 */     if (!bool) {
/* 164 */       throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */     }
/* 166 */     return d;
/*     */   }
/*     */   
/*     */   private static LookupUtils.ValueVector createValueVector(ValueEval paramValueEval) throws EvaluationException {
/* 170 */     if (paramValueEval instanceof ErrorEval) {
/* 171 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*     */     }
/* 173 */     if (paramValueEval instanceof TwoDEval) {
/* 174 */       return new AreaValueArray((TwoDEval)paramValueEval);
/*     */     }
/* 176 */     if (paramValueEval instanceof RefEval) {
/* 177 */       return new RefValueArray((RefEval)paramValueEval);
/*     */     }
/* 179 */     return new SingleCellValueArray(paramValueEval);
/*     */   }
/*     */   
/*     */   protected static interface Accumulator {
/*     */     double accumulate(double param1Double1, double param1Double2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\XYNumericFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */