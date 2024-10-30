/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.FormulaParseException;
/*     */ import org.apache.poi.ss.formula.FormulaParser;
/*     */ import org.apache.poi.ss.formula.FormulaParsingWorkbook;
/*     */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.MissingArgEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPxg;
/*     */ import org.apache.poi.ss.usermodel.Table;
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
/*     */ public final class Indirect
/*     */   implements FreeRefFunction
/*     */ {
/*  50 */   public static final FreeRefFunction instance = new Indirect();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/*  57 */     if (paramArrayOfValueEval.length < 1) {
/*  58 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */     
/*     */     try {
/*     */       boolean bool;
/*     */       
/*  64 */       ValueEval valueEval = OperandResolver.getSingleValue(paramArrayOfValueEval[0], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/*     */       
/*  66 */       String str = OperandResolver.coerceValueToString(valueEval);
/*  67 */       switch (paramArrayOfValueEval.length) {
/*     */         case 1:
/*  69 */           bool = true;
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
/*  81 */           return evaluateIndirect(paramOperationEvaluationContext, str, bool);case 2: bool = evaluateBooleanArg(paramArrayOfValueEval[1], paramOperationEvaluationContext); return evaluateIndirect(paramOperationEvaluationContext, str, bool);
/*     */       } 
/*     */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     } catch (EvaluationException evaluationException) {
/*     */       return (ValueEval)evaluationException.getErrorEval();
/*  86 */     }  } private static boolean evaluateBooleanArg(ValueEval paramValueEval, OperationEvaluationContext paramOperationEvaluationContext) throws EvaluationException { ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/*     */     
/*  88 */     if (valueEval == BlankEval.instance || valueEval == MissingArgEval.instance) {
/*  89 */       return false;
/*     */     }
/*     */ 
/*     */     
/*  93 */     return OperandResolver.coerceValueToBoolean(valueEval, false).booleanValue(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ValueEval evaluateIndirect(OperationEvaluationContext paramOperationEvaluationContext, String paramString, boolean paramBoolean) {
/*     */     String str1, str2, str3, str4, str5;
/* 100 */     int i = paramString.lastIndexOf('!');
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     if (i < 0) {
/* 106 */       str1 = null;
/* 107 */       str2 = null;
/* 108 */       str3 = paramString;
/*     */     } else {
/* 110 */       String[] arrayOfString = parseWorkbookAndSheetName(paramString.subSequence(0, i));
/* 111 */       if (arrayOfString == null) {
/* 112 */         return (ValueEval)ErrorEval.REF_INVALID;
/*     */       }
/* 114 */       str1 = arrayOfString[0];
/* 115 */       str2 = arrayOfString[1];
/* 116 */       str3 = paramString.substring(i + 1);
/*     */     } 
/*     */     
/* 119 */     if (Table.isStructuredReference.matcher(str3).matches()) {
/*     */       
/* 121 */       Area3DPxg area3DPxg = null;
/*     */       try {
/* 123 */         area3DPxg = FormulaParser.parseStructuredReference(str3, (FormulaParsingWorkbook)paramOperationEvaluationContext.getWorkbook(), paramOperationEvaluationContext.getRowIndex());
/* 124 */       } catch (FormulaParseException formulaParseException) {
/* 125 */         return (ValueEval)ErrorEval.REF_INVALID;
/*     */       } 
/* 127 */       return paramOperationEvaluationContext.getArea3DEval(area3DPxg);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 132 */     int j = str3.indexOf(':');
/* 133 */     if (j < 0) {
/* 134 */       str4 = str3.trim();
/* 135 */       str5 = null;
/*     */     } else {
/* 137 */       str4 = str3.substring(0, j).trim();
/* 138 */       str5 = str3.substring(j + 1).trim();
/*     */     } 
/* 140 */     return paramOperationEvaluationContext.getDynamicReference(str1, str2, str4, str5, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] parseWorkbookAndSheetName(CharSequence paramCharSequence) {
/* 150 */     int i = paramCharSequence.length() - 1;
/* 151 */     if (i < 0) {
/* 152 */       return null;
/*     */     }
/* 154 */     if (canTrim(paramCharSequence)) {
/* 155 */       return null;
/*     */     }
/* 157 */     char c = paramCharSequence.charAt(0);
/* 158 */     if (Character.isWhitespace(c)) {
/* 159 */       return null;
/*     */     }
/* 161 */     if (c == '\'') {
/*     */       String str1;
/*     */       boolean bool;
/* 164 */       if (paramCharSequence.charAt(i) != '\'') {
/* 165 */         return null;
/*     */       }
/* 167 */       c = paramCharSequence.charAt(1);
/* 168 */       if (Character.isWhitespace(c)) {
/* 169 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 173 */       if (c == '[') {
/* 174 */         int j = paramCharSequence.toString().lastIndexOf(']');
/* 175 */         if (j < 0) {
/* 176 */           return null;
/*     */         }
/* 178 */         str1 = unescapeString(paramCharSequence.subSequence(2, j));
/* 179 */         if (str1 == null || canTrim(str1)) {
/* 180 */           return null;
/*     */         }
/* 182 */         bool = j + 1;
/*     */       } else {
/* 184 */         str1 = null;
/* 185 */         bool = true;
/*     */       } 
/*     */ 
/*     */       
/* 189 */       String str2 = unescapeString(paramCharSequence.subSequence(bool, i));
/* 190 */       if (str2 == null)
/*     */       {
/* 192 */         return null;
/*     */       }
/* 194 */       return new String[] { str1, str2 };
/*     */     } 
/*     */     
/* 197 */     if (c == '[') {
/* 198 */       int j = paramCharSequence.toString().lastIndexOf(']');
/* 199 */       if (j < 0) {
/* 200 */         return null;
/*     */       }
/* 202 */       CharSequence charSequence1 = paramCharSequence.subSequence(1, j);
/* 203 */       if (canTrim(charSequence1)) {
/* 204 */         return null;
/*     */       }
/* 206 */       CharSequence charSequence2 = paramCharSequence.subSequence(j + 1, paramCharSequence.length());
/* 207 */       if (canTrim(charSequence2)) {
/* 208 */         return null;
/*     */       }
/* 210 */       return new String[] { charSequence1.toString(), charSequence2.toString() };
/*     */     } 
/*     */     
/* 213 */     return new String[] { null, paramCharSequence.toString() };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String unescapeString(CharSequence paramCharSequence) {
/* 221 */     int i = paramCharSequence.length();
/* 222 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 223 */     byte b = 0;
/* 224 */     while (b < i) {
/* 225 */       char c = paramCharSequence.charAt(b);
/* 226 */       if (c == '\'') {
/*     */         
/* 228 */         b++;
/* 229 */         if (b >= i) {
/* 230 */           return null;
/*     */         }
/* 232 */         c = paramCharSequence.charAt(b);
/* 233 */         if (c != '\'') {
/* 234 */           return null;
/*     */         }
/*     */       } 
/* 237 */       stringBuilder.append(c);
/* 238 */       b++;
/*     */     } 
/* 240 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static boolean canTrim(CharSequence paramCharSequence) {
/* 244 */     int i = paramCharSequence.length() - 1;
/* 245 */     if (i < 0) {
/* 246 */       return false;
/*     */     }
/* 248 */     if (Character.isWhitespace(paramCharSequence.charAt(0))) {
/* 249 */       return true;
/*     */     }
/* 251 */     if (Character.isWhitespace(paramCharSequence.charAt(i))) {
/* 252 */       return true;
/*     */     }
/* 254 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Indirect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */