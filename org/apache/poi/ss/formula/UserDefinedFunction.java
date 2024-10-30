/*    */ package org.apache.poi.ss.formula;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.FunctionNameEval;
/*    */ import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
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
/*    */ final class UserDefinedFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 34 */   public static final FreeRefFunction instance = new UserDefinedFunction();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/*    */     String str;
/* 41 */     int i = paramArrayOfValueEval.length;
/* 42 */     if (i < 1) {
/* 43 */       throw new RuntimeException("function name argument missing");
/*    */     }
/*    */     
/* 46 */     ValueEval valueEval = paramArrayOfValueEval[0];
/*    */     
/* 48 */     if (valueEval instanceof FunctionNameEval) {
/* 49 */       str = ((FunctionNameEval)valueEval).getFunctionName();
/*    */     } else {
/* 51 */       throw new RuntimeException("First argument should be a NameEval, but got (" + valueEval.getClass().getName() + ")");
/*    */     } 
/*    */     
/* 54 */     FreeRefFunction freeRefFunction = paramOperationEvaluationContext.findUserDefinedFunction(str);
/* 55 */     if (freeRefFunction == null) {
/* 56 */       throw new NotImplementedFunctionException(str);
/*    */     }
/* 58 */     int j = i - 1;
/* 59 */     ValueEval[] arrayOfValueEval = new ValueEval[j];
/* 60 */     System.arraycopy(paramArrayOfValueEval, 1, arrayOfValueEval, 0, j);
/* 61 */     return freeRefFunction.evaluate(arrayOfValueEval, paramOperationEvaluationContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\UserDefinedFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */