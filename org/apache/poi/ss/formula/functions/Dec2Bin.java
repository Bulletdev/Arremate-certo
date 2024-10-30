/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
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
/*     */ 
/*     */ 
/*     */ public class Dec2Bin
/*     */   extends Var1or2ArgFunction
/*     */   implements FreeRefFunction
/*     */ {
/*  53 */   public static final FreeRefFunction instance = new Dec2Bin();
/*     */   private static final long MIN_VALUE = -512L;
/*     */   private static final long MAX_VALUE = 511L;
/*     */   private static final int DEFAULT_PLACES_VALUE = 10;
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*     */     ValueEval valueEval;
/*     */     int i;
/*     */     try {
/*  62 */       valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*  63 */     } catch (EvaluationException evaluationException) {
/*  64 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  66 */     String str1 = OperandResolver.coerceValueToString(valueEval);
/*  67 */     Double double_ = OperandResolver.parseDouble(str1);
/*     */ 
/*     */     
/*  70 */     if (double_ == null) {
/*  71 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */ 
/*     */     
/*  75 */     if (double_.longValue() < -512L || double_.longValue() > 511L) {
/*  76 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     }
/*     */ 
/*     */     
/*  80 */     if (double_.doubleValue() < 0.0D || paramValueEval2 == null) {
/*  81 */       i = 10;
/*     */     } else {
/*     */       ValueEval valueEval1;
/*     */       try {
/*  85 */         valueEval1 = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/*  86 */       } catch (EvaluationException evaluationException) {
/*  87 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*  89 */       String str = OperandResolver.coerceValueToString(valueEval1);
/*  90 */       Double double_1 = OperandResolver.parseDouble(str);
/*     */ 
/*     */       
/*  93 */       if (double_1 == null) {
/*  94 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       }
/*     */ 
/*     */       
/*  98 */       i = double_1.intValue();
/*     */       
/* 100 */       if (i < 0 || i == 0) {
/* 101 */         return (ValueEval)ErrorEval.NUM_ERROR;
/*     */       }
/*     */     } 
/* 104 */     String str2 = Integer.toBinaryString(double_.intValue());
/*     */     
/* 106 */     if (str2.length() > 10) {
/* 107 */       str2 = str2.substring(str2.length() - 10, str2.length());
/*     */     }
/*     */     
/* 110 */     if (str2.length() > i) {
/* 111 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     }
/*     */     
/* 114 */     return (ValueEval)new StringEval(str2);
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/* 118 */     return evaluate(paramInt1, paramInt2, paramValueEval, null);
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 122 */     if (paramArrayOfValueEval.length == 1) {
/* 123 */       return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0]);
/*     */     }
/* 125 */     if (paramArrayOfValueEval.length == 2) {
/* 126 */       return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*     */     }
/*     */     
/* 129 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Dec2Bin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */