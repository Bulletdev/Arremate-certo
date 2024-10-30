/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.MissingArgEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.RefEval;
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
/*     */ public final class Index
/*     */   implements Function2Arg, Function3Arg, Function4Arg
/*     */ {
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*  50 */     TwoDEval twoDEval = convertFirstArg(paramValueEval1);
/*     */     
/*  52 */     int i = 0;
/*     */     try {
/*  54 */       int j = resolveIndexArg(paramValueEval2, paramInt1, paramInt2);
/*     */       
/*  56 */       if (!twoDEval.isColumn()) {
/*  57 */         if (!twoDEval.isRow())
/*     */         {
/*     */           
/*  60 */           return (ValueEval)ErrorEval.REF_INVALID;
/*     */         }
/*     */ 
/*     */         
/*  64 */         i = j;
/*  65 */         j = 0;
/*     */       } 
/*     */       
/*  68 */       return getValueFromArea(twoDEval, j, i);
/*  69 */     } catch (EvaluationException evaluationException) {
/*  70 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*  75 */     TwoDEval twoDEval = convertFirstArg(paramValueEval1);
/*     */     
/*     */     try {
/*  78 */       int i = resolveIndexArg(paramValueEval3, paramInt1, paramInt2);
/*  79 */       int j = resolveIndexArg(paramValueEval2, paramInt1, paramInt2);
/*  80 */       return getValueFromArea(twoDEval, j, i);
/*  81 */     } catch (EvaluationException evaluationException) {
/*  82 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, ValueEval paramValueEval4) {
/*  87 */     throw new RuntimeException("Incomplete code - don't know how to support the 'area_num' parameter yet)");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static TwoDEval convertFirstArg(ValueEval paramValueEval) {
/*  96 */     ValueEval valueEval = paramValueEval;
/*  97 */     if (valueEval instanceof RefEval)
/*     */     {
/*  99 */       return (TwoDEval)((RefEval)valueEval).offset(0, 0, 0, 0);
/*     */     }
/* 101 */     if (valueEval instanceof TwoDEval) {
/* 102 */       return (TwoDEval)valueEval;
/*     */     }
/*     */ 
/*     */     
/* 106 */     throw new RuntimeException("Incomplete code - cannot handle first arg of type (" + valueEval.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 112 */     switch (paramArrayOfValueEval.length) {
/*     */       case 2:
/* 114 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*     */       case 3:
/* 116 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2]);
/*     */       case 4:
/* 118 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2], paramArrayOfValueEval[3]);
/*     */     } 
/* 120 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */   }
/*     */ 
/*     */   
/*     */   private static ValueEval getValueFromArea(TwoDEval paramTwoDEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 125 */     assert paramInt1 >= 0;
/* 126 */     assert paramInt2 >= 0;
/*     */     
/* 128 */     TwoDEval twoDEval = paramTwoDEval;
/*     */     
/* 130 */     if (paramInt1 != 0) {
/*     */       
/* 132 */       if (paramInt1 > paramTwoDEval.getHeight())
/*     */       {
/* 134 */         throw new EvaluationException(ErrorEval.REF_INVALID);
/*     */       }
/* 136 */       twoDEval = twoDEval.getRow(paramInt1 - 1);
/*     */     } 
/*     */     
/* 139 */     if (paramInt2 != 0) {
/*     */       
/* 141 */       if (paramInt2 > paramTwoDEval.getWidth())
/*     */       {
/* 143 */         throw new EvaluationException(ErrorEval.REF_INVALID);
/*     */       }
/* 145 */       twoDEval = twoDEval.getColumn(paramInt2 - 1);
/*     */     } 
/* 147 */     return (ValueEval)twoDEval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int resolveIndexArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 158 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 159 */     if (valueEval == MissingArgEval.instance) {
/* 160 */       return 0;
/*     */     }
/* 162 */     if (valueEval == BlankEval.instance) {
/* 163 */       return 0;
/*     */     }
/* 165 */     int i = OperandResolver.coerceValueToInt(valueEval);
/* 166 */     if (i < 0) {
/* 167 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */     }
/* 169 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Index.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */