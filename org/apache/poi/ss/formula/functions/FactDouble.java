/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.math.BigInteger;
/*    */ import java.util.HashMap;
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*    */ public class FactDouble
/*    */   extends Fixed1ArgFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 46 */   public static final FreeRefFunction instance = new FactDouble();
/*    */ 
/*    */   
/* 49 */   static HashMap<Integer, BigInteger> cache = new HashMap<Integer, BigInteger>();
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     int i;
/*    */     try {
/* 54 */       i = OperandResolver.coerceValueToInt(paramValueEval);
/* 55 */     } catch (EvaluationException evaluationException) {
/* 56 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */     
/* 59 */     if (i < 0) {
/* 60 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*    */     }
/*    */     
/* 63 */     return (ValueEval)new NumberEval(factorial(i).longValue());
/*    */   }
/*    */   
/*    */   public static BigInteger factorial(int paramInt) {
/* 67 */     if (paramInt == 0 || paramInt < 0) {
/* 68 */       return BigInteger.ONE;
/*    */     }
/*    */     
/* 71 */     if (cache.containsKey(Integer.valueOf(paramInt))) {
/* 72 */       return cache.get(Integer.valueOf(paramInt));
/*    */     }
/*    */     
/* 75 */     BigInteger bigInteger = BigInteger.valueOf(paramInt).multiply(factorial(paramInt - 2));
/* 76 */     cache.put(Integer.valueOf(paramInt), bigInteger);
/* 77 */     return bigInteger;
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 81 */     if (paramArrayOfValueEval.length != 1) {
/* 82 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/* 84 */     return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\FactDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */