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
/*     */ 
/*     */ 
/*     */ public class Complex
/*     */   extends Var2or3ArgFunction
/*     */   implements FreeRefFunction
/*     */ {
/*  59 */   public static final FreeRefFunction instance = new Complex();
/*     */   
/*     */   public static final String DEFAULT_SUFFIX = "i";
/*     */   public static final String SUPPORTED_SUFFIX = "j";
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*  65 */     return evaluate(paramInt1, paramInt2, paramValueEval1, paramValueEval2, (ValueEval)new StringEval("i"));
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*     */     ValueEval valueEval1, valueEval2;
/*     */     try {
/*  71 */       valueEval1 = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*  72 */     } catch (EvaluationException evaluationException) {
/*  73 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  75 */     double d1 = 0.0D;
/*     */     try {
/*  77 */       d1 = OperandResolver.coerceValueToDouble(valueEval1);
/*  78 */     } catch (EvaluationException evaluationException) {
/*  79 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/*  84 */       valueEval2 = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/*  85 */     } catch (EvaluationException evaluationException) {
/*  86 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  88 */     double d2 = 0.0D;
/*     */     try {
/*  90 */       d2 = OperandResolver.coerceValueToDouble(valueEval2);
/*  91 */     } catch (EvaluationException evaluationException) {
/*  92 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     } 
/*     */     
/*  95 */     String str = OperandResolver.coerceValueToString(paramValueEval3);
/*  96 */     if (str.length() == 0) {
/*  97 */       str = "i";
/*     */     }
/*  99 */     if (str.equals("i".toUpperCase(Locale.ROOT)) || str.equals("j".toUpperCase(Locale.ROOT)))
/*     */     {
/* 101 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/* 103 */     if (!str.equals("i") && !str.equals("j")) {
/* 104 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/* 107 */     StringBuffer stringBuffer = new StringBuffer("");
/* 108 */     if (d1 != 0.0D) {
/* 109 */       if (isDoubleAnInt(d1)) {
/* 110 */         stringBuffer.append((int)d1);
/*     */       } else {
/* 112 */         stringBuffer.append(d1);
/*     */       } 
/*     */     }
/* 115 */     if (d2 != 0.0D) {
/* 116 */       if (stringBuffer.length() != 0 && 
/* 117 */         d2 > 0.0D) {
/* 118 */         stringBuffer.append("+");
/*     */       }
/*     */ 
/*     */       
/* 122 */       if (d2 != 1.0D && d2 != -1.0D) {
/* 123 */         if (isDoubleAnInt(d2)) {
/* 124 */           stringBuffer.append((int)d2);
/*     */         } else {
/* 126 */           stringBuffer.append(d2);
/*     */         } 
/*     */       }
/*     */       
/* 130 */       stringBuffer.append(str);
/*     */     } 
/*     */     
/* 133 */     return (ValueEval)new StringEval(stringBuffer.toString());
/*     */   }
/*     */   
/*     */   private boolean isDoubleAnInt(double paramDouble) {
/* 137 */     return (paramDouble == Math.floor(paramDouble) && !Double.isInfinite(paramDouble));
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 141 */     if (paramArrayOfValueEval.length == 2) {
/* 142 */       return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*     */     }
/* 144 */     if (paramArrayOfValueEval.length == 3) {
/* 145 */       return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2]);
/*     */     }
/*     */     
/* 148 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Complex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */