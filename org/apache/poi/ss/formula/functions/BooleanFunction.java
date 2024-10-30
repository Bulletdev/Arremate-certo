/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
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
/*     */ public abstract class BooleanFunction
/*     */   implements Function
/*     */ {
/*     */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     boolean bool;
/*  43 */     if (paramArrayOfValueEval.length < 1) {
/*  44 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*     */     try {
/*  48 */       bool = calculate(paramArrayOfValueEval);
/*  49 */     } catch (EvaluationException evaluationException) {
/*  50 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  52 */     return (ValueEval)BoolEval.valueOf(bool);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean calculate(ValueEval[] paramArrayOfValueEval) throws EvaluationException {
/*  57 */     boolean bool = getInitialResultValue();
/*  58 */     boolean bool1 = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     for (ValueEval valueEval : paramArrayOfValueEval) {
/*     */       
/*  65 */       if (valueEval instanceof TwoDEval) {
/*  66 */         TwoDEval twoDEval = (TwoDEval)valueEval;
/*  67 */         int i = twoDEval.getHeight();
/*  68 */         int j = twoDEval.getWidth();
/*  69 */         for (byte b = 0; b < i; b++) {
/*  70 */           for (byte b1 = 0; b1 < j; b1++) {
/*  71 */             ValueEval valueEval1 = twoDEval.getValue(b, b1);
/*  72 */             Boolean bool2 = OperandResolver.coerceValueToBoolean(valueEval1, true);
/*  73 */             if (bool2 != null) {
/*  74 */               bool = partialEvaluate(bool, bool2.booleanValue());
/*  75 */               bool1 = true;
/*     */             }
/*     */           
/*     */           }
/*     */         
/*     */         } 
/*  81 */       } else if (valueEval instanceof RefEval) {
/*  82 */         RefEval refEval = (RefEval)valueEval;
/*  83 */         int i = refEval.getFirstSheetIndex();
/*  84 */         int j = refEval.getLastSheetIndex();
/*  85 */         for (int k = i; k <= j; k++) {
/*  86 */           ValueEval valueEval1 = refEval.getInnerValueEval(k);
/*  87 */           Boolean bool2 = OperandResolver.coerceValueToBoolean(valueEval1, true);
/*  88 */           if (bool2 != null) {
/*  89 */             bool = partialEvaluate(bool, bool2.booleanValue());
/*  90 */             bool1 = true;
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         Boolean bool2;
/*     */         
/*  96 */         if (valueEval == MissingArgEval.instance) {
/*  97 */           bool2 = null;
/*     */         } else {
/*  99 */           bool2 = OperandResolver.coerceValueToBoolean(valueEval, false);
/*     */         } 
/*     */         
/* 102 */         if (bool2 != null) {
/* 103 */           bool = partialEvaluate(bool, bool2.booleanValue());
/* 104 */           bool1 = true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 108 */     if (!bool1) {
/* 109 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */     }
/* 111 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   public static final Function AND = new BooleanFunction() {
/*     */       protected boolean getInitialResultValue() {
/* 121 */         return true;
/*     */       }
/*     */       protected boolean partialEvaluate(boolean param1Boolean1, boolean param1Boolean2) {
/* 124 */         return (param1Boolean1 && param1Boolean2);
/*     */       }
/*     */     };
/* 127 */   public static final Function OR = new BooleanFunction() {
/*     */       protected boolean getInitialResultValue() {
/* 129 */         return false;
/*     */       }
/*     */       protected boolean partialEvaluate(boolean param1Boolean1, boolean param1Boolean2) {
/* 132 */         return (param1Boolean1 || param1Boolean2);
/*     */       }
/*     */     };
/* 135 */   public static final Function FALSE = new Fixed0ArgFunction() {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2) {
/* 137 */         return (ValueEval)BoolEval.FALSE;
/*     */       }
/*     */     };
/* 140 */   public static final Function TRUE = new Fixed0ArgFunction() {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2) {
/* 142 */         return (ValueEval)BoolEval.TRUE;
/*     */       }
/*     */     };
/* 145 */   public static final Function NOT = new Fixed1ArgFunction() {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/*     */         boolean bool;
/*     */         try {
/* 149 */           ValueEval valueEval = OperandResolver.getSingleValue(param1ValueEval, param1Int1, param1Int2);
/* 150 */           Boolean bool1 = OperandResolver.coerceValueToBoolean(valueEval, false);
/* 151 */           bool = (bool1 == null) ? false : bool1.booleanValue();
/* 152 */         } catch (EvaluationException evaluationException) {
/* 153 */           return (ValueEval)evaluationException.getErrorEval();
/*     */         } 
/*     */         
/* 156 */         return (ValueEval)BoolEval.valueOf(!bool);
/*     */       }
/*     */     };
/*     */   
/*     */   protected abstract boolean getInitialResultValue();
/*     */   
/*     */   protected abstract boolean partialEvaluate(boolean paramBoolean1, boolean paramBoolean2);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\BooleanFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */