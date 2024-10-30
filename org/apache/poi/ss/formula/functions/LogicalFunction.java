/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*     */ public abstract class LogicalFunction
/*     */   extends Fixed1ArgFunction
/*     */ {
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*     */     ErrorEval errorEval;
/*     */     try {
/*  41 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*  42 */     } catch (EvaluationException evaluationException) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  49 */       errorEval = evaluationException.getErrorEval();
/*     */     } 
/*  51 */     return (ValueEval)BoolEval.valueOf(evaluate((ValueEval)errorEval));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  59 */   public static final Function ISLOGICAL = new LogicalFunction() {
/*     */       protected boolean evaluate(ValueEval param1ValueEval) {
/*  61 */         return param1ValueEval instanceof BoolEval;
/*     */       }
/*     */     };
/*  64 */   public static final Function ISNONTEXT = new LogicalFunction() {
/*     */       protected boolean evaluate(ValueEval param1ValueEval) {
/*  66 */         return !(param1ValueEval instanceof org.apache.poi.ss.formula.eval.StringEval);
/*     */       }
/*     */     };
/*  69 */   public static final Function ISNUMBER = new LogicalFunction() {
/*     */       protected boolean evaluate(ValueEval param1ValueEval) {
/*  71 */         return param1ValueEval instanceof org.apache.poi.ss.formula.eval.NumberEval;
/*     */       }
/*     */     };
/*  74 */   public static final Function ISTEXT = new LogicalFunction() {
/*     */       protected boolean evaluate(ValueEval param1ValueEval) {
/*  76 */         return param1ValueEval instanceof org.apache.poi.ss.formula.eval.StringEval;
/*     */       }
/*     */     };
/*     */   
/*  80 */   public static final Function ISBLANK = new LogicalFunction()
/*     */     {
/*     */       protected boolean evaluate(ValueEval param1ValueEval) {
/*  83 */         return param1ValueEval instanceof org.apache.poi.ss.formula.eval.BlankEval;
/*     */       }
/*     */     };
/*     */   
/*  87 */   public static final Function ISERROR = new LogicalFunction()
/*     */     {
/*     */       protected boolean evaluate(ValueEval param1ValueEval) {
/*  90 */         return param1ValueEval instanceof ErrorEval;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   public static final Function ISERR = new LogicalFunction()
/*     */     {
/*     */       protected boolean evaluate(ValueEval param1ValueEval) {
/* 108 */         if (param1ValueEval instanceof ErrorEval) {
/* 109 */           return (param1ValueEval != ErrorEval.NA);
/*     */         }
/* 111 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 125 */   public static final Function ISNA = new LogicalFunction()
/*     */     {
/*     */       protected boolean evaluate(ValueEval param1ValueEval) {
/* 128 */         return (param1ValueEval == ErrorEval.NA);
/*     */       }
/*     */     };
/*     */   
/* 132 */   public static final Function ISREF = new Fixed1ArgFunction()
/*     */     {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/* 135 */         if (param1ValueEval instanceof org.apache.poi.ss.formula.eval.RefEval || param1ValueEval instanceof org.apache.poi.ss.formula.eval.AreaEval) {
/* 136 */           return (ValueEval)BoolEval.TRUE;
/*     */         }
/* 138 */         return (ValueEval)BoolEval.FALSE;
/*     */       }
/*     */     };
/*     */   
/*     */   protected abstract boolean evaluate(ValueEval paramValueEval);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\LogicalFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */