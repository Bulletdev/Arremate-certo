/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*     */ public class Roman
/*     */   extends Fixed2ArgFunction
/*     */ {
/*  46 */   public static final int[] VALUES = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
/*  47 */   public static final String[] ROMAN = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*  52 */     int i = 0;
/*     */     try {
/*  54 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/*  55 */       i = OperandResolver.coerceValueToInt(valueEval);
/*  56 */     } catch (EvaluationException evaluationException) {
/*  57 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     } 
/*  59 */     if (i < 0) {
/*  60 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*  62 */     if (i > 3999) {
/*  63 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*  65 */     if (i == 0) {
/*  66 */       return (ValueEval)new StringEval("");
/*     */     }
/*     */     
/*  69 */     int j = 0;
/*     */     try {
/*  71 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/*  72 */       j = OperandResolver.coerceValueToInt(valueEval);
/*  73 */     } catch (EvaluationException evaluationException) {
/*  74 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*     */     } 
/*     */     
/*  77 */     if (j > 4 || j < 0) {
/*  78 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*  81 */     String str = integerToRoman(i);
/*     */     
/*  83 */     if (j == 0) {
/*  84 */       return (ValueEval)new StringEval(str);
/*     */     }
/*     */     
/*  87 */     return (ValueEval)new StringEval(makeConcise(str, j));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String integerToRoman(int paramInt) {
/*  96 */     StringBuilder stringBuilder = new StringBuilder();
/*  97 */     for (byte b = 0; b < 13; b++) {
/*  98 */       while (paramInt >= VALUES[b]) {
/*  99 */         paramInt -= VALUES[b];
/* 100 */         stringBuilder.append(ROMAN[b]);
/*     */       } 
/*     */     } 
/* 103 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String makeConcise(String paramString, int paramInt) {
/* 113 */     if (paramInt > 0) {
/* 114 */       paramString = paramString.replaceAll("XLV", "VL");
/* 115 */       paramString = paramString.replaceAll("XCV", "VC");
/* 116 */       paramString = paramString.replaceAll("CDL", "LD");
/* 117 */       paramString = paramString.replaceAll("CML", "LM");
/* 118 */       paramString = paramString.replaceAll("CMVC", "LMVL");
/*     */     } 
/* 120 */     if (paramInt == 1) {
/* 121 */       paramString = paramString.replaceAll("CDXC", "LDXL");
/* 122 */       paramString = paramString.replaceAll("CDVC", "LDVL");
/* 123 */       paramString = paramString.replaceAll("CMXC", "LMXL");
/* 124 */       paramString = paramString.replaceAll("XCIX", "VCIV");
/* 125 */       paramString = paramString.replaceAll("XLIX", "VLIV");
/*     */     } 
/* 127 */     if (paramInt > 1) {
/* 128 */       paramString = paramString.replaceAll("XLIX", "IL");
/* 129 */       paramString = paramString.replaceAll("XCIX", "IC");
/* 130 */       paramString = paramString.replaceAll("CDXC", "XD");
/* 131 */       paramString = paramString.replaceAll("CDVC", "XDV");
/* 132 */       paramString = paramString.replaceAll("CDIC", "XDIX");
/* 133 */       paramString = paramString.replaceAll("LMVL", "XMV");
/* 134 */       paramString = paramString.replaceAll("CMIC", "XMIX");
/* 135 */       paramString = paramString.replaceAll("CMXC", "XM");
/*     */     } 
/* 137 */     if (paramInt > 2) {
/* 138 */       paramString = paramString.replaceAll("XDV", "VD");
/* 139 */       paramString = paramString.replaceAll("XDIX", "VDIV");
/* 140 */       paramString = paramString.replaceAll("XMV", "VM");
/* 141 */       paramString = paramString.replaceAll("XMIX", "VMIV");
/*     */     } 
/* 143 */     if (paramInt == 4) {
/* 144 */       paramString = paramString.replaceAll("VDIV", "ID");
/* 145 */       paramString = paramString.replaceAll("VMIV", "IM");
/*     */     } 
/*     */     
/* 148 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Roman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */