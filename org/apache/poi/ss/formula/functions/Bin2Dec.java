/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*     */ public class Bin2Dec
/*     */   extends Fixed1ArgFunction
/*     */   implements FreeRefFunction
/*     */ {
/*  45 */   public static final FreeRefFunction instance = new Bin2Dec(); public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) { String str1;
/*     */     String str2;
/*     */     boolean bool;
/*     */     String str3;
/*  49 */     if (paramValueEval instanceof RefEval) {
/*  50 */       RefEval refEval = (RefEval)paramValueEval;
/*  51 */       str1 = OperandResolver.coerceValueToString(refEval.getInnerValueEval(refEval.getFirstSheetIndex()));
/*     */     } else {
/*  53 */       str1 = OperandResolver.coerceValueToString(paramValueEval);
/*     */     } 
/*  55 */     if (str1.length() > 10) {
/*  56 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     if (str1.length() < 10) {
/*  64 */       str2 = str1;
/*  65 */       bool = true;
/*     */     } else {
/*  67 */       str2 = str1.substring(1);
/*  68 */       bool = str1.startsWith("0");
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/*  73 */       if (bool) {
/*     */         
/*  75 */         int i = getDecimalValue(str2);
/*  76 */         str3 = String.valueOf(i);
/*     */       }
/*     */       else {
/*     */         
/*  80 */         String str = toggleBits(str2);
/*     */         
/*  82 */         int i = getDecimalValue(str);
/*     */ 
/*     */         
/*  85 */         i++;
/*     */         
/*  87 */         str3 = "-" + String.valueOf(i);
/*     */       } 
/*  89 */     } catch (NumberFormatException numberFormatException) {
/*  90 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     } 
/*     */     
/*  93 */     return (ValueEval)new NumberEval(Long.parseLong(str3)); }
/*     */ 
/*     */   
/*     */   private int getDecimalValue(String paramString) {
/*  97 */     int i = 0;
/*  98 */     int j = paramString.length();
/*  99 */     int k = j - 1;
/*     */     
/* 101 */     for (byte b = 0; b < j; b++) {
/* 102 */       int m = Integer.parseInt(paramString.substring(b, b + 1));
/* 103 */       int n = (int)(m * Math.pow(2.0D, k));
/* 104 */       i += n;
/* 105 */       k--;
/*     */     } 
/* 107 */     return i;
/*     */   }
/*     */   
/*     */   private static String toggleBits(String paramString) {
/* 111 */     long l1 = Long.parseLong(paramString, 2);
/* 112 */     long l2 = l1 ^ (1L << paramString.length()) - 1L;
/* 113 */     String str = Long.toBinaryString(l2);
/* 114 */     for (; str.length() < paramString.length(); str = '0' + str);
/* 115 */     return str;
/*     */   }
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 119 */     if (paramArrayOfValueEval.length != 1) {
/* 120 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/* 122 */     return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Bin2Dec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */