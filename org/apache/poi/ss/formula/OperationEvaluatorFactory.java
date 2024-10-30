/*     */ package org.apache.poi.ss.formula;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.formula.eval.ConcatEval;
/*     */ import org.apache.poi.ss.formula.eval.FunctionEval;
/*     */ import org.apache.poi.ss.formula.eval.IntersectionEval;
/*     */ import org.apache.poi.ss.formula.eval.PercentEval;
/*     */ import org.apache.poi.ss.formula.eval.RangeEval;
/*     */ import org.apache.poi.ss.formula.eval.RelationalOperationEval;
/*     */ import org.apache.poi.ss.formula.eval.TwoOperandNumericOperation;
/*     */ import org.apache.poi.ss.formula.eval.UnaryMinusEval;
/*     */ import org.apache.poi.ss.formula.eval.UnaryPlusEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.formula.functions.Function;
/*     */ import org.apache.poi.ss.formula.functions.Indirect;
/*     */ import org.apache.poi.ss.formula.ptg.AbstractFunctionPtg;
/*     */ import org.apache.poi.ss.formula.ptg.AddPtg;
/*     */ import org.apache.poi.ss.formula.ptg.ConcatPtg;
/*     */ import org.apache.poi.ss.formula.ptg.DividePtg;
/*     */ import org.apache.poi.ss.formula.ptg.EqualPtg;
/*     */ import org.apache.poi.ss.formula.ptg.GreaterEqualPtg;
/*     */ import org.apache.poi.ss.formula.ptg.GreaterThanPtg;
/*     */ import org.apache.poi.ss.formula.ptg.IntersectionPtg;
/*     */ import org.apache.poi.ss.formula.ptg.LessEqualPtg;
/*     */ import org.apache.poi.ss.formula.ptg.LessThanPtg;
/*     */ import org.apache.poi.ss.formula.ptg.MultiplyPtg;
/*     */ import org.apache.poi.ss.formula.ptg.NotEqualPtg;
/*     */ import org.apache.poi.ss.formula.ptg.OperationPtg;
/*     */ import org.apache.poi.ss.formula.ptg.PercentPtg;
/*     */ import org.apache.poi.ss.formula.ptg.PowerPtg;
/*     */ import org.apache.poi.ss.formula.ptg.RangePtg;
/*     */ import org.apache.poi.ss.formula.ptg.SubtractPtg;
/*     */ import org.apache.poi.ss.formula.ptg.UnaryMinusPtg;
/*     */ import org.apache.poi.ss.formula.ptg.UnaryPlusPtg;
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
/*     */ final class OperationEvaluatorFactory
/*     */ {
/*  66 */   private static final Map<OperationPtg, Function> _instancesByPtgClass = initialiseInstancesMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<OperationPtg, Function> initialiseInstancesMap() {
/*  73 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(32);
/*     */     
/*  75 */     put((Map)hashMap, (OperationPtg)EqualPtg.instance, RelationalOperationEval.EqualEval);
/*  76 */     put((Map)hashMap, (OperationPtg)GreaterEqualPtg.instance, RelationalOperationEval.GreaterEqualEval);
/*  77 */     put((Map)hashMap, (OperationPtg)GreaterThanPtg.instance, RelationalOperationEval.GreaterThanEval);
/*  78 */     put((Map)hashMap, (OperationPtg)LessEqualPtg.instance, RelationalOperationEval.LessEqualEval);
/*  79 */     put((Map)hashMap, (OperationPtg)LessThanPtg.instance, RelationalOperationEval.LessThanEval);
/*  80 */     put((Map)hashMap, (OperationPtg)NotEqualPtg.instance, RelationalOperationEval.NotEqualEval);
/*     */     
/*  82 */     put((Map)hashMap, (OperationPtg)ConcatPtg.instance, ConcatEval.instance);
/*  83 */     put((Map)hashMap, (OperationPtg)AddPtg.instance, TwoOperandNumericOperation.AddEval);
/*  84 */     put((Map)hashMap, (OperationPtg)DividePtg.instance, TwoOperandNumericOperation.DivideEval);
/*  85 */     put((Map)hashMap, (OperationPtg)MultiplyPtg.instance, TwoOperandNumericOperation.MultiplyEval);
/*  86 */     put((Map)hashMap, (OperationPtg)PercentPtg.instance, PercentEval.instance);
/*  87 */     put((Map)hashMap, (OperationPtg)PowerPtg.instance, TwoOperandNumericOperation.PowerEval);
/*  88 */     put((Map)hashMap, (OperationPtg)SubtractPtg.instance, TwoOperandNumericOperation.SubtractEval);
/*  89 */     put((Map)hashMap, (OperationPtg)UnaryMinusPtg.instance, UnaryMinusEval.instance);
/*  90 */     put((Map)hashMap, (OperationPtg)UnaryPlusPtg.instance, UnaryPlusEval.instance);
/*  91 */     put((Map)hashMap, RangePtg.instance, RangeEval.instance);
/*  92 */     put((Map)hashMap, IntersectionPtg.instance, IntersectionEval.instance);
/*  93 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void put(Map<OperationPtg, Function> paramMap, OperationPtg paramOperationPtg, Function paramFunction) {
/*  99 */     Constructor[] arrayOfConstructor = (Constructor[])paramOperationPtg.getClass().getDeclaredConstructors();
/* 100 */     if (arrayOfConstructor.length > 1 || !Modifier.isPrivate(arrayOfConstructor[0].getModifiers())) {
/* 101 */       throw new RuntimeException("Failed to verify instance (" + paramOperationPtg.getClass().getName() + ") is a singleton.");
/*     */     }
/*     */     
/* 104 */     paramMap.put(paramOperationPtg, paramFunction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueEval evaluate(OperationPtg paramOperationPtg, ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 113 */     if (paramOperationPtg == null) {
/* 114 */       throw new IllegalArgumentException("ptg must not be null");
/*     */     }
/* 116 */     Function function = _instancesByPtgClass.get(paramOperationPtg);
/*     */     
/* 118 */     if (function != null) {
/* 119 */       return function.evaluate(paramArrayOfValueEval, paramOperationEvaluationContext.getRowIndex(), (short)paramOperationEvaluationContext.getColumnIndex());
/*     */     }
/*     */     
/* 122 */     if (paramOperationPtg instanceof AbstractFunctionPtg) {
/* 123 */       AbstractFunctionPtg abstractFunctionPtg = (AbstractFunctionPtg)paramOperationPtg;
/* 124 */       short s = abstractFunctionPtg.getFunctionIndex();
/* 125 */       switch (s) {
/*     */         case 148:
/* 127 */           return Indirect.instance.evaluate(paramArrayOfValueEval, paramOperationEvaluationContext);
/*     */         case 255:
/* 129 */           return UserDefinedFunction.instance.evaluate(paramArrayOfValueEval, paramOperationEvaluationContext);
/*     */       } 
/*     */       
/* 132 */       return FunctionEval.getBasicFunction(s).evaluate(paramArrayOfValueEval, paramOperationEvaluationContext.getRowIndex(), (short)paramOperationEvaluationContext.getColumnIndex());
/*     */     } 
/* 134 */     throw new RuntimeException("Unexpected operation ptg class (" + paramOperationPtg.getClass().getName() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\OperationEvaluatorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */