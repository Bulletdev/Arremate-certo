/*     */ package org.apache.poi.ss.formula.eval;
/*     */ 
/*     */ import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
/*     */ import org.apache.poi.ss.formula.functions.Function;
/*     */ import org.apache.poi.ss.util.NumberComparer;
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
/*     */ public abstract class RelationalOperationEval
/*     */   extends Fixed2ArgFunction
/*     */ {
/*     */   protected abstract boolean convertComparisonResult(int paramInt);
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*     */     ValueEval valueEval1, valueEval2;
/*     */     try {
/*  64 */       valueEval1 = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*  65 */       valueEval2 = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/*  66 */     } catch (EvaluationException evaluationException) {
/*  67 */       return evaluationException.getErrorEval();
/*     */     } 
/*  69 */     int i = doCompare(valueEval1, valueEval2);
/*  70 */     boolean bool = convertComparisonResult(i);
/*  71 */     return BoolEval.valueOf(bool);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int doCompare(ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*  76 */     if (paramValueEval1 == BlankEval.instance) {
/*  77 */       return compareBlank(paramValueEval2);
/*     */     }
/*  79 */     if (paramValueEval2 == BlankEval.instance) {
/*  80 */       return -compareBlank(paramValueEval1);
/*     */     }
/*     */     
/*  83 */     if (paramValueEval1 instanceof BoolEval) {
/*  84 */       if (paramValueEval2 instanceof BoolEval) {
/*  85 */         BoolEval boolEval1 = (BoolEval)paramValueEval1;
/*  86 */         BoolEval boolEval2 = (BoolEval)paramValueEval2;
/*  87 */         if (boolEval1.getBooleanValue() == boolEval2.getBooleanValue()) {
/*  88 */           return 0;
/*     */         }
/*  90 */         return boolEval1.getBooleanValue() ? 1 : -1;
/*     */       } 
/*  92 */       return 1;
/*     */     } 
/*  94 */     if (paramValueEval2 instanceof BoolEval) {
/*  95 */       return -1;
/*     */     }
/*  97 */     if (paramValueEval1 instanceof StringEval) {
/*  98 */       if (paramValueEval2 instanceof StringEval) {
/*  99 */         StringEval stringEval1 = (StringEval)paramValueEval1;
/* 100 */         StringEval stringEval2 = (StringEval)paramValueEval2;
/* 101 */         return stringEval1.getStringValue().compareToIgnoreCase(stringEval2.getStringValue());
/*     */       } 
/* 103 */       return 1;
/*     */     } 
/* 105 */     if (paramValueEval2 instanceof StringEval) {
/* 106 */       return -1;
/*     */     }
/* 108 */     if (paramValueEval1 instanceof NumberEval && 
/* 109 */       paramValueEval2 instanceof NumberEval) {
/* 110 */       NumberEval numberEval1 = (NumberEval)paramValueEval1;
/* 111 */       NumberEval numberEval2 = (NumberEval)paramValueEval2;
/* 112 */       return NumberComparer.compare(numberEval1.getNumberValue(), numberEval2.getNumberValue());
/*     */     } 
/*     */     
/* 115 */     throw new IllegalArgumentException("Bad operand types (" + paramValueEval1.getClass().getName() + "), (" + paramValueEval2.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */   
/*     */   private static int compareBlank(ValueEval paramValueEval) {
/* 120 */     if (paramValueEval == BlankEval.instance) {
/* 121 */       return 0;
/*     */     }
/* 123 */     if (paramValueEval instanceof BoolEval) {
/* 124 */       BoolEval boolEval = (BoolEval)paramValueEval;
/* 125 */       return boolEval.getBooleanValue() ? -1 : 0;
/*     */     } 
/* 127 */     if (paramValueEval instanceof NumberEval) {
/* 128 */       NumberEval numberEval = (NumberEval)paramValueEval;
/* 129 */       return NumberComparer.compare(0.0D, numberEval.getNumberValue());
/*     */     } 
/* 131 */     if (paramValueEval instanceof StringEval) {
/* 132 */       StringEval stringEval = (StringEval)paramValueEval;
/* 133 */       return (stringEval.getStringValue().length() < 1) ? 0 : -1;
/*     */     } 
/* 135 */     throw new IllegalArgumentException("bad value class (" + paramValueEval.getClass().getName() + ")");
/*     */   }
/*     */   
/* 138 */   public static final Function EqualEval = (Function)new RelationalOperationEval() {
/*     */       protected boolean convertComparisonResult(int param1Int) {
/* 140 */         return (param1Int == 0);
/*     */       }
/*     */     };
/* 143 */   public static final Function GreaterEqualEval = (Function)new RelationalOperationEval() {
/*     */       protected boolean convertComparisonResult(int param1Int) {
/* 145 */         return (param1Int >= 0);
/*     */       }
/*     */     };
/* 148 */   public static final Function GreaterThanEval = (Function)new RelationalOperationEval() {
/*     */       protected boolean convertComparisonResult(int param1Int) {
/* 150 */         return (param1Int > 0);
/*     */       }
/*     */     };
/* 153 */   public static final Function LessEqualEval = (Function)new RelationalOperationEval() {
/*     */       protected boolean convertComparisonResult(int param1Int) {
/* 155 */         return (param1Int <= 0);
/*     */       }
/*     */     };
/* 158 */   public static final Function LessThanEval = (Function)new RelationalOperationEval() {
/*     */       protected boolean convertComparisonResult(int param1Int) {
/* 160 */         return (param1Int < 0);
/*     */       }
/*     */     };
/* 163 */   public static final Function NotEqualEval = (Function)new RelationalOperationEval() {
/*     */       protected boolean convertComparisonResult(int param1Int) {
/* 165 */         return (param1Int != 0);
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\RelationalOperationEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */