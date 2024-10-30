/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.BlankEval;
/*    */ import org.apache.poi.ss.formula.eval.BoolEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.MissingArgEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IfFunc
/*    */   extends Var2or3ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*    */     boolean bool;
/*    */     try {
/* 44 */       bool = evaluateFirstArg(paramValueEval1, paramInt1, paramInt2);
/* 45 */     } catch (EvaluationException evaluationException) {
/* 46 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/* 48 */     if (bool) {
/* 49 */       if (paramValueEval2 == MissingArgEval.instance) {
/* 50 */         return (ValueEval)BlankEval.instance;
/*    */       }
/* 52 */       return paramValueEval2;
/*    */     } 
/* 54 */     return (ValueEval)BoolEval.FALSE;
/*    */   }
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*    */     boolean bool;
/*    */     try {
/* 61 */       bool = evaluateFirstArg(paramValueEval1, paramInt1, paramInt2);
/* 62 */     } catch (EvaluationException evaluationException) {
/* 63 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/* 65 */     if (bool) {
/* 66 */       if (paramValueEval2 == MissingArgEval.instance) {
/* 67 */         return (ValueEval)BlankEval.instance;
/*    */       }
/* 69 */       return paramValueEval2;
/*    */     } 
/* 71 */     if (paramValueEval3 == MissingArgEval.instance) {
/* 72 */       return (ValueEval)BlankEval.instance;
/*    */     }
/* 74 */     return paramValueEval3;
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean evaluateFirstArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 79 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 80 */     Boolean bool = OperandResolver.coerceValueToBoolean(valueEval, false);
/* 81 */     if (bool == null) {
/* 82 */       return false;
/*    */     }
/* 84 */     return bool.booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\IfFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */