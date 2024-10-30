/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*     */ public final class Substitute
/*     */   extends Var3or4ArgFunction
/*     */ {
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*     */     String str;
/*     */     try {
/*  36 */       String str1 = TextFunction.evaluateStringArg(paramValueEval1, paramInt1, paramInt2);
/*  37 */       String str2 = TextFunction.evaluateStringArg(paramValueEval2, paramInt1, paramInt2);
/*  38 */       String str3 = TextFunction.evaluateStringArg(paramValueEval3, paramInt1, paramInt2);
/*     */       
/*  40 */       str = replaceAllOccurrences(str1, str2, str3);
/*  41 */     } catch (EvaluationException evaluationException) {
/*  42 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  44 */     return (ValueEval)new StringEval(str);
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, ValueEval paramValueEval4) {
/*     */     String str;
/*     */     try {
/*  51 */       String str1 = TextFunction.evaluateStringArg(paramValueEval1, paramInt1, paramInt2);
/*  52 */       String str2 = TextFunction.evaluateStringArg(paramValueEval2, paramInt1, paramInt2);
/*  53 */       String str3 = TextFunction.evaluateStringArg(paramValueEval3, paramInt1, paramInt2);
/*     */       
/*  55 */       int i = TextFunction.evaluateIntArg(paramValueEval4, paramInt1, paramInt2);
/*  56 */       if (i < 1) {
/*  57 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       }
/*  59 */       str = replaceOneOccurrence(str1, str2, str3, i);
/*  60 */     } catch (EvaluationException evaluationException) {
/*  61 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  63 */     return (ValueEval)new StringEval(str);
/*     */   }
/*     */   
/*     */   private static String replaceAllOccurrences(String paramString1, String paramString2, String paramString3) {
/*  67 */     StringBuffer stringBuffer = new StringBuffer();
/*  68 */     int i = 0;
/*  69 */     int j = -1;
/*     */     while (true) {
/*  71 */       j = paramString1.indexOf(paramString2, i);
/*  72 */       if (j < 0) {
/*     */         
/*  74 */         stringBuffer.append(paramString1.substring(i));
/*  75 */         return stringBuffer.toString();
/*     */       } 
/*     */       
/*  78 */       stringBuffer.append(paramString1.substring(i, j));
/*  79 */       stringBuffer.append(paramString3);
/*  80 */       i = j + paramString2.length();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String replaceOneOccurrence(String paramString1, String paramString2, String paramString3, int paramInt) {
/*  85 */     if (paramString2.length() < 1) {
/*  86 */       return paramString1;
/*     */     }
/*  88 */     int i = 0;
/*  89 */     int j = -1;
/*  90 */     byte b = 0;
/*     */     while (true) {
/*  92 */       j = paramString1.indexOf(paramString2, i);
/*  93 */       if (j < 0)
/*     */       {
/*  95 */         return paramString1;
/*     */       }
/*  97 */       b++;
/*  98 */       if (b == paramInt) {
/*  99 */         StringBuffer stringBuffer = new StringBuffer(paramString1.length() + paramString3.length());
/* 100 */         stringBuffer.append(paramString1.substring(0, j));
/* 101 */         stringBuffer.append(paramString3);
/* 102 */         stringBuffer.append(paramString1.substring(j + paramString2.length()));
/* 103 */         return stringBuffer.toString();
/*     */       } 
/* 105 */       i = j + paramString2.length();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Substitute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */