/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
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
/*     */ public abstract class NumericFunction
/*     */   implements Function
/*     */ {
/*     */   static final double ZERO = 0.0D;
/*     */   static final double TEN = 10.0D;
/*  31 */   static final double LOG_10_TO_BASE_e = Math.log(10.0D);
/*     */   
/*     */   protected static final double singleOperandEvaluate(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*  34 */     if (paramValueEval == null) {
/*  35 */       throw new IllegalArgumentException("arg must not be null");
/*     */     }
/*  37 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*  38 */     double d = OperandResolver.coerceValueToDouble(valueEval);
/*  39 */     checkValue(d);
/*  40 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final void checkValue(double paramDouble) throws EvaluationException {
/*  47 */     if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble)) {
/*  48 */       throw new EvaluationException(ErrorEval.NUM_ERROR);
/*     */     }
/*     */   }
/*     */   
/*     */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     double d;
/*     */     try {
/*  55 */       d = eval(paramArrayOfValueEval, paramInt1, paramInt2);
/*  56 */       checkValue(d);
/*  57 */     } catch (EvaluationException evaluationException) {
/*  58 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  60 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class OneArg
/*     */     extends Fixed1ArgFunction
/*     */   {
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/*     */       double d;
/*     */       try {
/*  75 */         double d1 = NumericFunction.singleOperandEvaluate(param1ValueEval, param1Int1, param1Int2);
/*  76 */         d = evaluate(d1);
/*  77 */         NumericFunction.checkValue(d);
/*  78 */       } catch (EvaluationException evaluationException) {
/*  79 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*  81 */       return (ValueEval)new NumberEval(d);
/*     */     }
/*     */     protected final double eval(ValueEval[] param1ArrayOfValueEval, int param1Int1, int param1Int2) throws EvaluationException {
/*  84 */       if (param1ArrayOfValueEval.length != 1) {
/*  85 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/*  87 */       double d = NumericFunction.singleOperandEvaluate(param1ArrayOfValueEval[0], param1Int1, param1Int2);
/*  88 */       return evaluate(d);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract double evaluate(double param1Double) throws EvaluationException;
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class TwoArg
/*     */     extends Fixed2ArgFunction
/*     */   {
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */       double d;
/*     */       try {
/* 102 */         double d1 = NumericFunction.singleOperandEvaluate(param1ValueEval1, param1Int1, param1Int2);
/* 103 */         double d2 = NumericFunction.singleOperandEvaluate(param1ValueEval2, param1Int1, param1Int2);
/* 104 */         d = evaluate(d1, d2);
/* 105 */         NumericFunction.checkValue(d);
/* 106 */       } catch (EvaluationException evaluationException) {
/* 107 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/* 109 */       return (ValueEval)new NumberEval(d);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract double evaluate(double param1Double1, double param1Double2) throws EvaluationException;
/*     */   }
/*     */ 
/*     */   
/* 117 */   public static final Function ABS = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 119 */         return Math.abs(param1Double);
/*     */       }
/*     */     };
/* 122 */   public static final Function ACOS = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 124 */         return Math.acos(param1Double);
/*     */       }
/*     */     };
/* 127 */   public static final Function ACOSH = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 129 */         return MathX.acosh(param1Double);
/*     */       }
/*     */     };
/* 132 */   public static final Function ASIN = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 134 */         return Math.asin(param1Double);
/*     */       }
/*     */     };
/* 137 */   public static final Function ASINH = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 139 */         return MathX.asinh(param1Double);
/*     */       }
/*     */     };
/* 142 */   public static final Function ATAN = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 144 */         return Math.atan(param1Double);
/*     */       }
/*     */     };
/* 147 */   public static final Function ATANH = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 149 */         return MathX.atanh(param1Double);
/*     */       }
/*     */     };
/* 152 */   public static final Function COS = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 154 */         return Math.cos(param1Double);
/*     */       }
/*     */     };
/* 157 */   public static final Function COSH = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 159 */         return MathX.cosh(param1Double);
/*     */       }
/*     */     };
/* 162 */   public static final Function DEGREES = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 164 */         return Math.toDegrees(param1Double);
/*     */       }
/*     */     };
/* 167 */   static final NumberEval DOLLAR_ARG2_DEFAULT = new NumberEval(2.0D);
/* 168 */   public static final Function DOLLAR = new Var1or2ArgFunction() {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/* 170 */         return evaluate(param1Int1, param1Int2, param1ValueEval, (ValueEval)NumericFunction.DOLLAR_ARG2_DEFAULT);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */         double d1, d2;
/*     */         try {
/* 178 */           d1 = NumericFunction.singleOperandEvaluate(param1ValueEval1, param1Int1, param1Int2);
/* 179 */           d2 = NumericFunction.singleOperandEvaluate(param1ValueEval2, param1Int1, param1Int2);
/* 180 */         } catch (EvaluationException evaluationException) {
/* 181 */           return (ValueEval)evaluationException.getErrorEval();
/*     */         } 
/*     */         
/* 184 */         int i = (int)d2;
/*     */         
/* 186 */         if (i > 127) {
/* 187 */           return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 194 */         return (ValueEval)new NumberEval(d1);
/*     */       }
/*     */     };
/* 197 */   public static final Function EXP = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 199 */         return Math.pow(Math.E, param1Double);
/*     */       }
/*     */     };
/* 202 */   public static final Function FACT = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 204 */         return MathX.factorial((int)param1Double);
/*     */       }
/*     */     };
/* 207 */   public static final Function INT = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 209 */         return Math.round(param1Double - 0.5D);
/*     */       }
/*     */     };
/* 212 */   public static final Function LN = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 214 */         return Math.log(param1Double);
/*     */       }
/*     */     };
/* 217 */   public static final Function LOG10 = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 219 */         return Math.log(param1Double) / NumericFunction.LOG_10_TO_BASE_e;
/*     */       }
/*     */     };
/* 222 */   public static final Function RADIANS = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 224 */         return Math.toRadians(param1Double);
/*     */       }
/*     */     };
/* 227 */   public static final Function SIGN = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 229 */         return MathX.sign(param1Double);
/*     */       }
/*     */     };
/* 232 */   public static final Function SIN = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 234 */         return Math.sin(param1Double);
/*     */       }
/*     */     };
/* 237 */   public static final Function SINH = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 239 */         return MathX.sinh(param1Double);
/*     */       }
/*     */     };
/* 242 */   public static final Function SQRT = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 244 */         return Math.sqrt(param1Double);
/*     */       }
/*     */     };
/*     */   
/* 248 */   public static final Function TAN = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 250 */         return Math.tan(param1Double);
/*     */       }
/*     */     };
/* 253 */   public static final Function TANH = new OneArg() {
/*     */       protected double evaluate(double param1Double) {
/* 255 */         return MathX.tanh(param1Double);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 261 */   public static final Function ATAN2 = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) throws EvaluationException {
/* 263 */         if (param1Double1 == 0.0D && param1Double2 == 0.0D) {
/* 264 */           throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */         }
/* 266 */         return Math.atan2(param1Double2, param1Double1);
/*     */       }
/*     */     };
/* 269 */   public static final Function CEILING = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) {
/* 271 */         return MathX.ceiling(param1Double1, param1Double2);
/*     */       }
/*     */     };
/* 274 */   public static final Function COMBIN = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) throws EvaluationException {
/* 276 */         if (param1Double1 > 2.147483647E9D || param1Double2 > 2.147483647E9D) {
/* 277 */           throw new EvaluationException(ErrorEval.NUM_ERROR);
/*     */         }
/* 279 */         return MathX.nChooseK((int)param1Double1, (int)param1Double2);
/*     */       }
/*     */     };
/* 282 */   public static final Function FLOOR = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) throws EvaluationException {
/* 284 */         if (param1Double2 == 0.0D) {
/* 285 */           if (param1Double1 == 0.0D) {
/* 286 */             return 0.0D;
/*     */           }
/* 288 */           throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */         } 
/* 290 */         return MathX.floor(param1Double1, param1Double2);
/*     */       }
/*     */     };
/* 293 */   public static final Function MOD = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) throws EvaluationException {
/* 295 */         if (param1Double2 == 0.0D) {
/* 296 */           throw new EvaluationException(ErrorEval.DIV_ZERO);
/*     */         }
/* 298 */         return MathX.mod(param1Double1, param1Double2);
/*     */       }
/*     */     };
/* 301 */   public static final Function POWER = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) {
/* 303 */         return Math.pow(param1Double1, param1Double2);
/*     */       }
/*     */     };
/* 306 */   public static final Function ROUND = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) {
/* 308 */         return MathX.round(param1Double1, (int)param1Double2);
/*     */       }
/*     */     };
/* 311 */   public static final Function ROUNDDOWN = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) {
/* 313 */         return MathX.roundDown(param1Double1, (int)param1Double2);
/*     */       }
/*     */     };
/* 316 */   public static final Function ROUNDUP = new TwoArg() {
/*     */       protected double evaluate(double param1Double1, double param1Double2) {
/* 318 */         return MathX.roundUp(param1Double1, (int)param1Double2);
/*     */       }
/*     */     };
/* 321 */   static final NumberEval TRUNC_ARG2_DEFAULT = new NumberEval(0.0D);
/* 322 */   public static final Function TRUNC = new Var1or2ArgFunction()
/*     */     {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/* 325 */         return evaluate(param1Int1, param1Int2, param1ValueEval, (ValueEval)NumericFunction.TRUNC_ARG2_DEFAULT);
/*     */       }
/*     */       
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */         double d;
/*     */         try {
/* 331 */           double d1 = NumericFunction.singleOperandEvaluate(param1ValueEval1, param1Int1, param1Int2);
/* 332 */           double d2 = NumericFunction.singleOperandEvaluate(param1ValueEval2, param1Int1, param1Int2);
/* 333 */           double d3 = Math.pow(10.0D, d2);
/* 334 */           if (d1 < 0.0D) { d = -Math.floor(-d1 * d3) / d3; }
/* 335 */           else { d = Math.floor(d1 * d3) / d3; }
/* 336 */            NumericFunction.checkValue(d);
/* 337 */         } catch (EvaluationException evaluationException) {
/* 338 */           return (ValueEval)evaluationException.getErrorEval();
/*     */         } 
/* 340 */         return (ValueEval)new NumberEval(d);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class Log
/*     */     extends Var1or2ArgFunction
/*     */   {
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/*     */       double d;
/*     */       try {
/* 353 */         double d1 = NumericFunction.singleOperandEvaluate(param1ValueEval, param1Int1, param1Int2);
/* 354 */         d = Math.log(d1) / NumericFunction.LOG_10_TO_BASE_e;
/* 355 */         NumericFunction.checkValue(d);
/* 356 */       } catch (EvaluationException evaluationException) {
/* 357 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/* 359 */       return (ValueEval)new NumberEval(d);
/*     */     }
/*     */     
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */       double d;
/*     */       try {
/* 365 */         double d1 = NumericFunction.singleOperandEvaluate(param1ValueEval1, param1Int1, param1Int2);
/* 366 */         double d2 = NumericFunction.singleOperandEvaluate(param1ValueEval2, param1Int1, param1Int2);
/* 367 */         double d3 = Math.log(d1);
/* 368 */         double d4 = d2;
/* 369 */         if (Double.compare(d4, Math.E) == 0) {
/* 370 */           d = d3;
/*     */         } else {
/* 372 */           d = d3 / Math.log(d4);
/*     */         } 
/* 374 */         NumericFunction.checkValue(d);
/* 375 */       } catch (EvaluationException evaluationException) {
/* 376 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/* 378 */       return (ValueEval)new NumberEval(d);
/*     */     }
/*     */   }
/*     */   
/* 382 */   public static final Function LOG = new Log();
/*     */   
/* 384 */   static final NumberEval PI_EVAL = new NumberEval(Math.PI);
/* 385 */   public static final Function PI = new Fixed0ArgFunction() {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2) {
/* 387 */         return (ValueEval)NumericFunction.PI_EVAL;
/*     */       }
/*     */     };
/* 390 */   public static final Function RAND = new Fixed0ArgFunction() {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2) {
/* 392 */         return (ValueEval)new NumberEval(Math.random());
/*     */       }
/*     */     };
/* 395 */   public static final Function POISSON = new Fixed3ArgFunction()
/*     */     {
/*     */       private static final double DEFAULT_RETURN_RESULT = 1.0D;
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
/*     */       private boolean isDefaultResult(double param1Double1, double param1Double2) {
/* 409 */         if (param1Double1 == 0.0D && param1Double2 == 0.0D) {
/* 410 */           return true;
/*     */         }
/* 412 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       private boolean checkArgument(double param1Double) throws EvaluationException {
/* 417 */         NumericFunction.checkValue(param1Double);
/*     */ 
/*     */         
/* 420 */         if (param1Double < 0.0D) {
/* 421 */           throw new EvaluationException(ErrorEval.NUM_ERROR);
/*     */         }
/*     */         
/* 424 */         return true;
/*     */       }
/*     */       
/*     */       private double probability(int param1Int, double param1Double) {
/* 428 */         return Math.pow(param1Double, param1Int) * Math.exp(-param1Double) / factorial(param1Int);
/*     */       }
/*     */       
/*     */       private double cumulativeProbability(int param1Int, double param1Double) {
/* 432 */         double d = 0.0D;
/* 433 */         for (byte b = 0; b <= param1Int; b++) {
/* 434 */           d += probability(b, param1Double);
/*     */         }
/* 436 */         return d;
/*     */       }
/*     */ 
/*     */       
/* 440 */       private final long[] FACTORIALS = new long[] { 1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public long factorial(int param1Int) {
/* 451 */         if (param1Int < 0 || param1Int > 20) {
/* 452 */           throw new IllegalArgumentException("Valid argument should be in the range [0..20]");
/*     */         }
/* 454 */         return this.FACTORIALS[param1Int];
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2, ValueEval param1ValueEval3) {
/* 460 */         double d1 = 0.0D;
/* 461 */         double d2 = 0.0D;
/* 462 */         boolean bool = ((BoolEval)param1ValueEval3).getBooleanValue();
/* 463 */         double d3 = 0.0D;
/*     */         
/*     */         try {
/* 466 */           d2 = NumericFunction.singleOperandEvaluate(param1ValueEval1, param1Int1, param1Int2);
/* 467 */           d1 = NumericFunction.singleOperandEvaluate(param1ValueEval2, param1Int1, param1Int2);
/*     */ 
/*     */ 
/*     */           
/* 471 */           if (isDefaultResult(d2, d1)) {
/* 472 */             return (ValueEval)new NumberEval(1.0D);
/*     */           }
/*     */           
/* 475 */           checkArgument(d2);
/* 476 */           checkArgument(d1);
/*     */ 
/*     */           
/* 479 */           if (bool) {
/* 480 */             d3 = cumulativeProbability((int)d2, d1);
/*     */           } else {
/* 482 */             d3 = probability((int)d2, d1);
/*     */           } 
/*     */ 
/*     */           
/* 486 */           NumericFunction.checkValue(d3);
/*     */         }
/* 488 */         catch (EvaluationException evaluationException) {
/* 489 */           return (ValueEval)evaluationException.getErrorEval();
/*     */         } 
/*     */         
/* 492 */         return (ValueEval)new NumberEval(d3);
/*     */       }
/*     */     };
/*     */   
/*     */   protected abstract double eval(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) throws EvaluationException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\NumericFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */