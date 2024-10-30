/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.ss.formula.LazyRefEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NotImplementedException;
/*     */ import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Subtotal
/*     */   implements Function
/*     */ {
/*     */   private static Function findFunction(int paramInt) throws EvaluationException {
/*  70 */     switch (paramInt) { case 1:
/*  71 */         return AggregateFunction.subtotalInstance(AggregateFunction.AVERAGE);
/*  72 */       case 2: return Count.subtotalInstance();
/*  73 */       case 3: return Counta.subtotalInstance();
/*  74 */       case 4: return AggregateFunction.subtotalInstance(AggregateFunction.MAX);
/*  75 */       case 5: return AggregateFunction.subtotalInstance(AggregateFunction.MIN);
/*  76 */       case 6: return AggregateFunction.subtotalInstance(AggregateFunction.PRODUCT);
/*  77 */       case 7: return AggregateFunction.subtotalInstance(AggregateFunction.STDEV);
/*  78 */       case 8: throw new NotImplementedFunctionException("STDEVP");
/*  79 */       case 9: return AggregateFunction.subtotalInstance(AggregateFunction.SUM);
/*  80 */       case 10: throw new NotImplementedFunctionException("VAR");
/*  81 */       case 11: throw new NotImplementedFunctionException("VARP"); }
/*     */     
/*  83 */     if (paramInt > 100 && paramInt < 112) {
/*  84 */       throw new NotImplementedException("SUBTOTAL - with 'exclude hidden values' option");
/*     */     }
/*  86 */     throw EvaluationException.invalidValue();
/*     */   }
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     Function function;
/*  90 */     int i = paramArrayOfValueEval.length - 1;
/*  91 */     if (i < 1) {
/*  92 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/*  97 */       ValueEval valueEval = OperandResolver.getSingleValue(paramArrayOfValueEval[0], paramInt1, paramInt2);
/*  98 */       int j = OperandResolver.coerceValueToInt(valueEval);
/*  99 */       function = findFunction(j);
/* 100 */     } catch (EvaluationException evaluationException) {
/* 101 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */ 
/*     */     
/* 105 */     ArrayList arrayList = new ArrayList(Arrays.asList((Object[])paramArrayOfValueEval).subList(1, paramArrayOfValueEval.length));
/*     */     
/* 107 */     Iterator<ValueEval> iterator = arrayList.iterator();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     while (iterator.hasNext()) {
/* 113 */       ValueEval valueEval = iterator.next();
/* 114 */       if (valueEval instanceof LazyRefEval) {
/* 115 */         LazyRefEval lazyRefEval = (LazyRefEval)valueEval;
/* 116 */         if (lazyRefEval.isSubTotal()) {
/* 117 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 122 */     return function.evaluate((ValueEval[])arrayList.toArray((Object[])new ValueEval[arrayList.size()]), paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Subtotal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */