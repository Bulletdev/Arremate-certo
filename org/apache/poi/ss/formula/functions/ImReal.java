/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.StringEval;
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
/*    */ 
/*    */ public class ImReal
/*    */   extends Fixed1ArgFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 48 */   public static final FreeRefFunction instance = new ImReal();
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     ValueEval valueEval;
/*    */     try {
/* 53 */       valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 54 */     } catch (EvaluationException evaluationException) {
/* 55 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/* 57 */     String str1 = OperandResolver.coerceValueToString(valueEval);
/*    */     
/* 59 */     Matcher matcher = Imaginary.COMPLEX_NUMBER_PATTERN.matcher(str1);
/* 60 */     boolean bool = matcher.matches();
/*    */     
/* 62 */     String str2 = "";
/* 63 */     if (bool == true) {
/* 64 */       String str = matcher.group(2);
/* 65 */       boolean bool1 = (str.length() != 0) ? true : false;
/*    */       
/* 67 */       if (str.length() == 0) {
/* 68 */         return (ValueEval)new StringEval(String.valueOf(0));
/*    */       }
/*    */       
/* 71 */       if (bool1) {
/* 72 */         String str3 = "";
/* 73 */         String str4 = matcher.group(1);
/* 74 */         if (str4.length() != 0 && !str4.equals("+")) {
/* 75 */           str3 = str4;
/*    */         }
/*    */         
/* 78 */         String str5 = matcher.group(2);
/* 79 */         if (str5.length() != 0) {
/* 80 */           str2 = str3 + str5;
/*    */         } else {
/* 82 */           str2 = str3 + "1";
/*    */         } 
/*    */       } 
/*    */     } else {
/* 86 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*    */     } 
/*    */     
/* 89 */     return (ValueEval)new StringEval(str2);
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 93 */     if (paramArrayOfValueEval.length != 1) {
/* 94 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/* 96 */     return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\ImReal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */