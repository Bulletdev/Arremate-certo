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
/*    */ 
/*    */ 
/*    */ public final class Hlookup
/*    */   extends Var3or4ArgFunction
/*    */ {
/* 43 */   private static final ValueEval DEFAULT_ARG3 = (ValueEval)BoolEval.TRUE;
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/* 47 */     return evaluate(paramInt1, paramInt2, paramValueEval1, paramValueEval2, paramValueEval3, DEFAULT_ARG3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, ValueEval paramValueEval4) {
/*    */     try {
/* 55 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/* 56 */       TwoDEval twoDEval = LookupUtils.resolveTableArrayArg(paramValueEval2);
/* 57 */       boolean bool = LookupUtils.resolveRangeLookupArg(paramValueEval4, paramInt1, paramInt2);
/* 58 */       int i = LookupUtils.lookupIndexOfValue(valueEval, LookupUtils.createRowVector(twoDEval, 0), bool);
/* 59 */       int j = LookupUtils.resolveRowOrColIndexArg(paramValueEval3, paramInt1, paramInt2);
/* 60 */       LookupUtils.ValueVector valueVector = createResultColumnVector(twoDEval, j);
/* 61 */       return valueVector.getItem(i);
/* 62 */     } catch (EvaluationException evaluationException) {
/* 63 */       return (ValueEval)evaluationException.getErrorEval();
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
/*    */   private LookupUtils.ValueVector createResultColumnVector(TwoDEval paramTwoDEval, int paramInt) throws EvaluationException {
/* 75 */     if (paramInt >= paramTwoDEval.getHeight()) {
/* 76 */       throw EvaluationException.invalidRef();
/*    */     }
/* 78 */     return LookupUtils.createRowVector(paramTwoDEval, paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Hlookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */