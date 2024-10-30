/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.MissingArgEval;
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
/*     */ public abstract class FinanceFunction
/*     */   implements Function3Arg, Function4Arg
/*     */ {
/*  31 */   private static final ValueEval DEFAULT_ARG3 = (ValueEval)NumberEval.ZERO;
/*  32 */   private static final ValueEval DEFAULT_ARG4 = (ValueEval)BoolEval.FALSE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*  41 */     return evaluate(paramInt1, paramInt2, paramValueEval1, paramValueEval2, paramValueEval3, DEFAULT_ARG3);
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, ValueEval paramValueEval4) {
/*  45 */     return evaluate(paramInt1, paramInt2, paramValueEval1, paramValueEval2, paramValueEval3, paramValueEval4, DEFAULT_ARG4);
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, ValueEval paramValueEval4, ValueEval paramValueEval5) {
/*     */     double d;
/*     */     try {
/*  51 */       double d1 = NumericFunction.singleOperandEvaluate(paramValueEval1, paramInt1, paramInt2);
/*  52 */       double d2 = NumericFunction.singleOperandEvaluate(paramValueEval2, paramInt1, paramInt2);
/*  53 */       double d3 = NumericFunction.singleOperandEvaluate(paramValueEval3, paramInt1, paramInt2);
/*  54 */       double d4 = NumericFunction.singleOperandEvaluate(paramValueEval4, paramInt1, paramInt2);
/*  55 */       double d5 = NumericFunction.singleOperandEvaluate(paramValueEval5, paramInt1, paramInt2);
/*  56 */       d = evaluate(d1, d2, d3, d4, (d5 != 0.0D));
/*  57 */       NumericFunction.checkValue(d);
/*  58 */     } catch (EvaluationException evaluationException) {
/*  59 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  61 */     return (ValueEval)new NumberEval(d); } public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     ValueEval valueEval1;
/*     */     ValueEval valueEval2;
/*  64 */     switch (paramArrayOfValueEval.length) {
/*     */       case 3:
/*  66 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2], DEFAULT_ARG3, DEFAULT_ARG4);
/*     */       case 4:
/*  68 */         valueEval1 = paramArrayOfValueEval[3];
/*  69 */         if (valueEval1 == MissingArgEval.instance) {
/*  70 */           valueEval1 = DEFAULT_ARG3;
/*     */         }
/*  72 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2], valueEval1, DEFAULT_ARG4);
/*     */       
/*     */       case 5:
/*  75 */         valueEval1 = paramArrayOfValueEval[3];
/*  76 */         if (valueEval1 == MissingArgEval.instance) {
/*  77 */           valueEval1 = DEFAULT_ARG3;
/*     */         }
/*  79 */         valueEval2 = paramArrayOfValueEval[4];
/*  80 */         if (valueEval2 == MissingArgEval.instance) {
/*  81 */           valueEval2 = DEFAULT_ARG4;
/*     */         }
/*  83 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2], valueEval1, valueEval2);
/*     */     } 
/*     */     
/*  86 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double evaluate(double[] paramArrayOfdouble) throws EvaluationException {
/*  96 */     double d1 = 0.0D;
/*  97 */     double d2 = 0.0D;
/*     */     
/*  99 */     switch (paramArrayOfdouble.length) {
/*     */       case 5:
/* 101 */         d2 = paramArrayOfdouble[4];
/*     */       
/*     */       case 4:
/* 104 */         d1 = paramArrayOfdouble[3];
/*     */         break;
/*     */       case 3:
/*     */         break;
/*     */       default:
/* 109 */         throw new IllegalStateException("Wrong number of arguments");
/*     */     } 
/* 111 */     return evaluate(paramArrayOfdouble[0], paramArrayOfdouble[1], paramArrayOfdouble[2], d1, (d2 != 0.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   public static final Function FV = new FinanceFunction() {
/*     */       protected double evaluate(double param1Double1, double param1Double2, double param1Double3, double param1Double4, boolean param1Boolean) {
/* 119 */         return FinanceLib.fv(param1Double1, param1Double2, param1Double3, param1Double4, param1Boolean);
/*     */       }
/*     */     };
/* 122 */   public static final Function NPER = new FinanceFunction() {
/*     */       protected double evaluate(double param1Double1, double param1Double2, double param1Double3, double param1Double4, boolean param1Boolean) {
/* 124 */         return FinanceLib.nper(param1Double1, param1Double2, param1Double3, param1Double4, param1Boolean);
/*     */       }
/*     */     };
/* 127 */   public static final Function PMT = new FinanceFunction() {
/*     */       protected double evaluate(double param1Double1, double param1Double2, double param1Double3, double param1Double4, boolean param1Boolean) {
/* 129 */         return FinanceLib.pmt(param1Double1, param1Double2, param1Double3, param1Double4, param1Boolean);
/*     */       }
/*     */     };
/* 132 */   public static final Function PV = new FinanceFunction() {
/*     */       protected double evaluate(double param1Double1, double param1Double2, double param1Double3, double param1Double4, boolean param1Boolean) {
/* 134 */         return FinanceLib.pv(param1Double1, param1Double2, param1Double3, param1Double4, param1Boolean);
/*     */       }
/*     */     };
/*     */   
/*     */   protected abstract double evaluate(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, boolean paramBoolean) throws EvaluationException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\FinanceFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */