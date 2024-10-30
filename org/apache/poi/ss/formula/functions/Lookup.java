/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.TwoDEval;
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
/*    */ 
/*    */ public final class Lookup
/*    */   extends Var2or3ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/* 44 */     throw new RuntimeException("Two arg version of LOOKUP not supported yet");
/*    */   }
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*    */     try {
/* 50 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/* 51 */       TwoDEval twoDEval1 = LookupUtils.resolveTableArrayArg(paramValueEval2);
/* 52 */       TwoDEval twoDEval2 = LookupUtils.resolveTableArrayArg(paramValueEval3);
/*    */       
/* 54 */       LookupUtils.ValueVector valueVector1 = createVector(twoDEval1);
/* 55 */       LookupUtils.ValueVector valueVector2 = createVector(twoDEval2);
/* 56 */       if (valueVector1.getSize() > valueVector2.getSize())
/*    */       {
/* 58 */         throw new RuntimeException("Lookup vector and result vector of differing sizes not supported yet");
/*    */       }
/* 60 */       int i = LookupUtils.lookupIndexOfValue(valueEval, valueVector1, true);
/*    */       
/* 62 */       return valueVector2.getItem(i);
/* 63 */     } catch (EvaluationException evaluationException) {
/* 64 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */   
/*    */   private static LookupUtils.ValueVector createVector(TwoDEval paramTwoDEval) {
/* 69 */     LookupUtils.ValueVector valueVector = LookupUtils.createVector(paramTwoDEval);
/* 70 */     if (valueVector != null) {
/* 71 */       return valueVector;
/*    */     }
/*    */     
/* 74 */     throw new RuntimeException("non-vector lookup or result areas not supported yet");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Lookup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */