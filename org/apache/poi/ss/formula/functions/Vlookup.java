/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.TwoDEval;
/*    */ import org.apache.poi.ss.formula.eval.BoolEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*    */ 
/*    */ public final class Vlookup
/*    */   extends Var3or4ArgFunction
/*    */ {
/* 41 */   private static final ValueEval DEFAULT_ARG3 = (ValueEval)BoolEval.TRUE;
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/* 45 */     return evaluate(paramInt1, paramInt2, paramValueEval1, paramValueEval2, paramValueEval3, DEFAULT_ARG3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, ValueEval paramValueEval4) {
/*    */     try {
/* 53 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/* 54 */       TwoDEval twoDEval = LookupUtils.resolveTableArrayArg(paramValueEval2);
/* 55 */       boolean bool = LookupUtils.resolveRangeLookupArg(paramValueEval4, paramInt1, paramInt2);
/* 56 */       int i = LookupUtils.lookupIndexOfValue(valueEval, LookupUtils.createColumnVector(twoDEval, 0), bool);
/* 57 */       int j = LookupUtils.resolveRowOrColIndexArg(paramValueEval3, paramInt1, paramInt2);
/* 58 */       LookupUtils.ValueVector valueVector = createResultColumnVector(twoDEval, j);
/* 59 */       return valueVector.getItem(i);
/* 60 */     } catch (EvaluationException evaluationException) {
/* 61 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private LookupUtils.ValueVector createResultColumnVector(TwoDEval paramTwoDEval, int paramInt) throws EvaluationException {
/* 74 */     if (paramInt >= paramTwoDEval.getWidth()) {
/* 75 */       throw EvaluationException.invalidRef();
/*    */     }
/* 77 */     return LookupUtils.createColumnVector(paramTwoDEval, paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Vlookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */