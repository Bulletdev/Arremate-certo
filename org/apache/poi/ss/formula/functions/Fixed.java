/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*     */ public final class Fixed
/*     */   implements Function1Arg, Function2Arg, Function3Arg
/*     */ {
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*  39 */     return fixed(paramValueEval1, paramValueEval2, paramValueEval3, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*  45 */     return fixed(paramValueEval1, paramValueEval2, (ValueEval)BoolEval.FALSE, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*  50 */     return fixed(paramValueEval, (ValueEval)new NumberEval(2.0D), (ValueEval)BoolEval.FALSE, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*  55 */     switch (paramArrayOfValueEval.length) {
/*     */       case 1:
/*  57 */         return fixed(paramArrayOfValueEval[0], (ValueEval)new NumberEval(2.0D), (ValueEval)BoolEval.FALSE, paramInt1, paramInt2);
/*     */       
/*     */       case 2:
/*  60 */         return fixed(paramArrayOfValueEval[0], paramArrayOfValueEval[1], (ValueEval)BoolEval.FALSE, paramInt1, paramInt2);
/*     */       
/*     */       case 3:
/*  63 */         return fixed(paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2], paramInt1, paramInt2);
/*     */     } 
/*  65 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ValueEval fixed(ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, int paramInt1, int paramInt2) {
/*     */     try {
/*  73 */       ValueEval valueEval1 = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*     */ 
/*     */       
/*  76 */       BigDecimal bigDecimal = new BigDecimal(OperandResolver.coerceValueToDouble(valueEval1));
/*     */       
/*  78 */       ValueEval valueEval2 = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/*     */ 
/*     */       
/*  81 */       int i = OperandResolver.coerceValueToInt(valueEval2);
/*  82 */       ValueEval valueEval3 = OperandResolver.getSingleValue(paramValueEval3, paramInt1, paramInt2);
/*     */ 
/*     */       
/*  85 */       Boolean bool = OperandResolver.coerceValueToBoolean(valueEval3, false);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  90 */       bigDecimal = bigDecimal.setScale(i, RoundingMode.HALF_UP);
/*     */ 
/*     */       
/*  93 */       NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
/*  94 */       DecimalFormat decimalFormat = (DecimalFormat)numberFormat;
/*  95 */       decimalFormat.setGroupingUsed(!bool.booleanValue());
/*  96 */       decimalFormat.setMinimumFractionDigits((i >= 0) ? i : 0);
/*  97 */       decimalFormat.setMaximumFractionDigits((i >= 0) ? i : 0);
/*  98 */       String str = decimalFormat.format(bigDecimal.doubleValue());
/*     */ 
/*     */       
/* 101 */       return (ValueEval)new StringEval(str);
/* 102 */     } catch (EvaluationException evaluationException) {
/* 103 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Fixed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */