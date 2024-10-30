/*    */ package org.apache.poi.ss.formula.eval;
/*    */ 
/*    */ import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
/*    */ import org.apache.poi.ss.formula.functions.Function;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class TwoOperandNumericOperation
/*    */   extends Fixed2ArgFunction
/*    */ {
/*    */   protected final double singleOperandEvaluate(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 29 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 30 */     return OperandResolver.coerceValueToDouble(valueEval);
/*    */   }
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*    */     double d;
/*    */     try {
/* 35 */       double d1 = singleOperandEvaluate(paramValueEval1, paramInt1, paramInt2);
/* 36 */       double d2 = singleOperandEvaluate(paramValueEval2, paramInt1, paramInt2);
/* 37 */       d = evaluate(d1, d2);
/* 38 */       if (d == 0.0D)
/*    */       {
/* 40 */         if (!(this instanceof SubtractEvalClass)) {
/* 41 */           return NumberEval.ZERO;
/*    */         }
/*    */       }
/* 44 */       if (Double.isNaN(d) || Double.isInfinite(d)) {
/* 45 */         return ErrorEval.NUM_ERROR;
/*    */       }
/* 47 */     } catch (EvaluationException evaluationException) {
/* 48 */       return evaluationException.getErrorEval();
/*    */     } 
/* 50 */     return new NumberEval(d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/* 55 */   public static final Function AddEval = (Function)new TwoOperandNumericOperation() {
/*    */       protected double evaluate(double param1Double1, double param1Double2) {
/* 57 */         return param1Double1 + param1Double2;
/*    */       }
/*    */     };
/* 60 */   public static final Function DivideEval = (Function)new TwoOperandNumericOperation() {
/*    */       protected double evaluate(double param1Double1, double param1Double2) throws EvaluationException {
/* 62 */         if (param1Double2 == 0.0D) {
/* 63 */           throw new EvaluationException(ErrorEval.DIV_ZERO);
/*    */         }
/* 65 */         return param1Double1 / param1Double2;
/*    */       }
/*    */     };
/* 68 */   public static final Function MultiplyEval = (Function)new TwoOperandNumericOperation() {
/*    */       protected double evaluate(double param1Double1, double param1Double2) {
/* 70 */         return param1Double1 * param1Double2;
/*    */       }
/*    */     };
/* 73 */   public static final Function PowerEval = (Function)new TwoOperandNumericOperation() {
/*    */       protected double evaluate(double param1Double1, double param1Double2) {
/* 75 */         return Math.pow(param1Double1, param1Double2);
/*    */       }
/*    */     };
/*    */   
/*    */   private static final class SubtractEvalClass
/*    */     extends TwoOperandNumericOperation
/*    */   {
/*    */     protected double evaluate(double param1Double1, double param1Double2) {
/* 83 */       return param1Double1 - param1Double2;
/*    */     } }
/*    */   
/* 86 */   public static final Function SubtractEval = (Function)new SubtractEvalClass();
/*    */   
/*    */   protected abstract double evaluate(double paramDouble1, double paramDouble2) throws EvaluationException;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\TwoOperandNumericOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */