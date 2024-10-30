/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.Locale;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Dec2Hex
/*     */   extends Var1or2ArgFunction
/*     */   implements FreeRefFunction
/*     */ {
/*  57 */   public static final FreeRefFunction instance = new Dec2Hex();
/*     */   
/*  59 */   private static final long MIN_VALUE = Long.parseLong("-549755813888");
/*  60 */   private static final long MAX_VALUE = Long.parseLong("549755813887");
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*     */     ValueEval valueEval;
/*     */     String str2;
/*     */     try {
/*  66 */       valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*  67 */     } catch (EvaluationException evaluationException) {
/*  68 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  70 */     String str1 = OperandResolver.coerceValueToString(valueEval);
/*  71 */     Double double_ = OperandResolver.parseDouble(str1);
/*     */ 
/*     */     
/*  74 */     if (double_ == null) {
/*  75 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */ 
/*     */     
/*  79 */     if (double_.longValue() < MIN_VALUE || double_.longValue() > MAX_VALUE) {
/*  80 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     }
/*     */     
/*  83 */     int i = 0;
/*  84 */     if (double_.doubleValue() < 0.0D) {
/*  85 */       i = 10;
/*     */     }
/*  87 */     else if (paramValueEval2 != null) {
/*     */       ValueEval valueEval1;
/*     */       try {
/*  90 */         valueEval1 = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/*  91 */       } catch (EvaluationException evaluationException) {
/*  92 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*  94 */       String str = OperandResolver.coerceValueToString(valueEval1);
/*  95 */       Double double_1 = OperandResolver.parseDouble(str);
/*     */ 
/*     */       
/*  98 */       if (double_1 == null) {
/*  99 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       }
/*     */ 
/*     */       
/* 103 */       i = double_1.intValue();
/*     */       
/* 105 */       if (i < 0) {
/* 106 */         return (ValueEval)ErrorEval.NUM_ERROR;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 111 */     if (i != 0) {
/* 112 */       str2 = String.format(Locale.ROOT, "%0" + i + "X", new Object[] { Integer.valueOf(double_.intValue()) });
/*     */     } else {
/*     */       
/* 115 */       str2 = Long.toHexString(double_.longValue());
/*     */     } 
/*     */     
/* 118 */     if (double_.doubleValue() < 0.0D) {
/* 119 */       str2 = "FF" + str2.substring(2);
/*     */     }
/*     */     
/* 122 */     return (ValueEval)new StringEval(str2.toUpperCase(Locale.ROOT));
/*     */   }
/*     */   private static final int DEFAULT_PLACES_VALUE = 10;
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/* 126 */     return evaluate(paramInt1, paramInt2, paramValueEval, null);
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 130 */     if (paramArrayOfValueEval.length == 1) {
/* 131 */       return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0]);
/*     */     }
/* 133 */     if (paramArrayOfValueEval.length == 2) {
/* 134 */       return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*     */     }
/* 136 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Dec2Hex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */