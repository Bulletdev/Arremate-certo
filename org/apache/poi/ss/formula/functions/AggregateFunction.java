/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
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
/*     */ public abstract class AggregateFunction
/*     */   extends MultiOperandNumericFunction
/*     */ {
/*     */   private static final class LargeSmall
/*     */     extends Fixed2ArgFunction
/*     */   {
/*     */     private final boolean _isLarge;
/*     */     
/*     */     protected LargeSmall(boolean param1Boolean) {
/*  34 */       this._isLarge = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */       double d1, d2;
/*     */       try {
/*  41 */         ValueEval valueEval = OperandResolver.getSingleValue(param1ValueEval2, param1Int1, param1Int2);
/*  42 */         d1 = OperandResolver.coerceValueToDouble(valueEval);
/*  43 */       } catch (EvaluationException evaluationException) {
/*     */         
/*  45 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       } 
/*     */       
/*  48 */       if (d1 < 1.0D)
/*     */       {
/*  50 */         return (ValueEval)ErrorEval.NUM_ERROR;
/*     */       }
/*     */       
/*  53 */       int i = (int)Math.ceil(d1);
/*     */ 
/*     */       
/*     */       try {
/*  57 */         double[] arrayOfDouble = AggregateFunction.ValueCollector.collectValues(new ValueEval[] { param1ValueEval1 });
/*  58 */         if (i > arrayOfDouble.length) {
/*  59 */           return (ValueEval)ErrorEval.NUM_ERROR;
/*     */         }
/*  61 */         d2 = this._isLarge ? StatsLib.kthLargest(arrayOfDouble, i) : StatsLib.kthSmallest(arrayOfDouble, i);
/*  62 */         NumericFunction.checkValue(d2);
/*  63 */       } catch (EvaluationException evaluationException) {
/*  64 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*     */       
/*  67 */       return (ValueEval)new NumberEval(d2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class Percentile
/*     */     extends Fixed2ArgFunction
/*     */   {
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */       double d1;
/*     */       double d2;
/*     */       try {
/*  96 */         ValueEval valueEval = OperandResolver.getSingleValue(param1ValueEval2, param1Int1, param1Int2);
/*  97 */         d1 = OperandResolver.coerceValueToDouble(valueEval);
/*  98 */       } catch (EvaluationException evaluationException) {
/*     */         
/* 100 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       } 
/* 102 */       if (d1 < 0.0D || d1 > 1.0D) {
/* 103 */         return (ValueEval)ErrorEval.NUM_ERROR;
/*     */       }
/*     */ 
/*     */       
/*     */       try {
/* 108 */         double[] arrayOfDouble = AggregateFunction.ValueCollector.collectValues(new ValueEval[] { param1ValueEval1 });
/* 109 */         int i = arrayOfDouble.length;
/*     */         
/* 111 */         if (i == 0 || i > 8191) {
/* 112 */           return (ValueEval)ErrorEval.NUM_ERROR;
/*     */         }
/*     */         
/* 115 */         double d = (i - 1) * d1 + 1.0D;
/* 116 */         if (d == 1.0D) {
/* 117 */           d2 = StatsLib.kthSmallest(arrayOfDouble, 1);
/* 118 */         } else if (Double.compare(d, i) == 0) {
/* 119 */           d2 = StatsLib.kthLargest(arrayOfDouble, 1);
/*     */         } else {
/* 121 */           int j = (int)d;
/* 122 */           double d3 = d - j;
/* 123 */           d2 = StatsLib.kthSmallest(arrayOfDouble, j) + d3 * (StatsLib.kthSmallest(arrayOfDouble, j + 1) - StatsLib.kthSmallest(arrayOfDouble, j));
/*     */         } 
/*     */ 
/*     */         
/* 127 */         NumericFunction.checkValue(d2);
/* 128 */       } catch (EvaluationException evaluationException) {
/* 129 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*     */       
/* 132 */       return (ValueEval)new NumberEval(d2);
/*     */     }
/*     */   }
/*     */   
/*     */   static final class ValueCollector extends MultiOperandNumericFunction {
/* 137 */     private static final ValueCollector instance = new ValueCollector();
/*     */     public ValueCollector() {
/* 139 */       super(false, false);
/*     */     }
/*     */     public static double[] collectValues(ValueEval... param1VarArgs) throws EvaluationException {
/* 142 */       return instance.getNumberArray(param1VarArgs);
/*     */     }
/*     */     protected double evaluate(double[] param1ArrayOfdouble) {
/* 145 */       throw new IllegalStateException("should not be called");
/*     */     }
/*     */   }
/*     */   
/*     */   protected AggregateFunction() {
/* 150 */     super(false, false);
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
/*     */   static Function subtotalInstance(Function paramFunction) {
/* 165 */     final AggregateFunction arg = (AggregateFunction)paramFunction;
/* 166 */     return new AggregateFunction()
/*     */       {
/*     */         protected double evaluate(double[] param1ArrayOfdouble) throws EvaluationException {
/* 169 */           return arg.evaluate(param1ArrayOfdouble);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean isSubtotalCounted() {
/* 177 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/* 183 */   public static final Function AVEDEV = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 185 */         return StatsLib.avedev(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 188 */   public static final Function AVERAGE = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) throws EvaluationException {
/* 190 */         if (param1ArrayOfdouble.length < 1) {
/* 191 */           throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */         }
/* 193 */         return MathX.average(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 196 */   public static final Function DEVSQ = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 198 */         return StatsLib.devsq(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 201 */   public static final Function LARGE = new LargeSmall(true);
/* 202 */   public static final Function MAX = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 204 */         return (param1ArrayOfdouble.length > 0) ? MathX.max(param1ArrayOfdouble) : 0.0D;
/*     */       }
/*     */     };
/* 207 */   public static final Function MEDIAN = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 209 */         return StatsLib.median(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 212 */   public static final Function MIN = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 214 */         return (param1ArrayOfdouble.length > 0) ? MathX.min(param1ArrayOfdouble) : 0.0D;
/*     */       }
/*     */     };
/*     */   
/* 218 */   public static final Function PERCENTILE = new Percentile();
/*     */   
/* 220 */   public static final Function PRODUCT = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 222 */         return MathX.product(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 225 */   public static final Function SMALL = new LargeSmall(false);
/* 226 */   public static final Function STDEV = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) throws EvaluationException {
/* 228 */         if (param1ArrayOfdouble.length < 1) {
/* 229 */           throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */         }
/* 231 */         return StatsLib.stdev(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 234 */   public static final Function SUM = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 236 */         return MathX.sum(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 239 */   public static final Function SUMSQ = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 241 */         return MathX.sumsq(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 244 */   public static final Function VAR = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) throws EvaluationException {
/* 246 */         if (param1ArrayOfdouble.length < 1) {
/* 247 */           throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */         }
/* 249 */         return StatsLib.var(param1ArrayOfdouble);
/*     */       }
/*     */     };
/* 252 */   public static final Function VARP = new AggregateFunction() {
/*     */       protected double evaluate(double[] param1ArrayOfdouble) throws EvaluationException {
/* 254 */         if (param1ArrayOfdouble.length < 1) {
/* 255 */           throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */         }
/* 257 */         return StatsLib.varp(param1ArrayOfdouble);
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\AggregateFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */