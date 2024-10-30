/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.SheetNameFormatter;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.MissingArgEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Address
/*     */   implements Function
/*     */ {
/*     */   public static final int REF_ABSOLUTE = 1;
/*     */   public static final int REF_ROW_ABSOLUTE_COLUMN_RELATIVE = 2;
/*     */   public static final int REF_ROW_RELATIVE_RELATIVE_ABSOLUTE = 3;
/*     */   public static final int REF_RELATIVE = 4;
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*  36 */     if (paramArrayOfValueEval.length < 2 || paramArrayOfValueEval.length > 5) {
/*  37 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     try {
/*     */       boolean bool1, bool2, bool3;
/*     */       String str;
/*  42 */       int i = (int)NumericFunction.singleOperandEvaluate(paramArrayOfValueEval[0], paramInt1, paramInt2);
/*  43 */       int j = (int)NumericFunction.singleOperandEvaluate(paramArrayOfValueEval[1], paramInt1, paramInt2);
/*     */ 
/*     */       
/*  46 */       if (paramArrayOfValueEval.length > 2 && paramArrayOfValueEval[2] != MissingArgEval.instance) {
/*  47 */         bool3 = (int)NumericFunction.singleOperandEvaluate(paramArrayOfValueEval[2], paramInt1, paramInt2);
/*     */       } else {
/*  49 */         bool3 = true;
/*     */       } 
/*  51 */       switch (bool3) {
/*     */         case true:
/*  53 */           bool1 = true;
/*  54 */           bool2 = true;
/*     */           break;
/*     */         case true:
/*  57 */           bool1 = true;
/*  58 */           bool2 = false;
/*     */           break;
/*     */         case true:
/*  61 */           bool1 = false;
/*  62 */           bool2 = true;
/*     */           break;
/*     */         case true:
/*  65 */           bool1 = false;
/*  66 */           bool2 = false;
/*     */           break;
/*     */         default:
/*  69 */           throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  82 */       if (paramArrayOfValueEval.length == 5) {
/*  83 */         ValueEval valueEval = OperandResolver.getSingleValue(paramArrayOfValueEval[4], paramInt1, paramInt2);
/*  84 */         str = (valueEval == MissingArgEval.instance) ? null : OperandResolver.coerceValueToString(valueEval);
/*     */       } else {
/*  86 */         str = null;
/*     */       } 
/*     */       
/*  89 */       CellReference cellReference = new CellReference(i - 1, j - 1, bool1, bool2);
/*  90 */       StringBuffer stringBuffer = new StringBuffer(32);
/*  91 */       if (str != null) {
/*  92 */         SheetNameFormatter.appendFormat(stringBuffer, str);
/*  93 */         stringBuffer.append('!');
/*     */       } 
/*  95 */       stringBuffer.append(cellReference.formatAsString());
/*     */       
/*  97 */       return (ValueEval)new StringEval(stringBuffer.toString());
/*     */     }
/*  99 */     catch (EvaluationException evaluationException) {
/* 100 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */