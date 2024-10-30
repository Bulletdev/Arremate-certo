/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.usermodel.DataFormatter;
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
/*     */ public abstract class TextFunction
/*     */   implements Function
/*     */ {
/*  31 */   protected static final DataFormatter formatter = new DataFormatter();
/*     */   
/*     */   protected static String evaluateStringArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*  34 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*  35 */     return OperandResolver.coerceValueToString(valueEval);
/*     */   }
/*     */   protected static int evaluateIntArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*  38 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*  39 */     return OperandResolver.coerceValueToInt(valueEval);
/*     */   }
/*     */   
/*     */   protected static double evaluateDoubleArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*  43 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*  44 */     return OperandResolver.coerceValueToDouble(valueEval);
/*     */   }
/*     */   
/*     */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*     */     try {
/*  49 */       return evaluateFunc(paramArrayOfValueEval, paramInt1, paramInt2);
/*  50 */     } catch (EvaluationException evaluationException) {
/*  51 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class SingleArgTextFunc
/*     */     extends Fixed1ArgFunction
/*     */   {
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/*     */       String str;
/*     */       try {
/*  67 */         str = TextFunction.evaluateStringArg(param1ValueEval, param1Int1, param1Int2);
/*  68 */       } catch (EvaluationException evaluationException) {
/*  69 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*  71 */       return evaluate(str);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract ValueEval evaluate(String param1String);
/*     */   }
/*     */ 
/*     */   
/*  79 */   public static final Function CHAR = new Fixed1ArgFunction() {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/*     */         int i;
/*     */         try {
/*  83 */           i = TextFunction.evaluateIntArg(param1ValueEval, param1Int1, param1Int2);
/*  84 */           if (i < 0 || i >= 256) {
/*  85 */             throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */           }
/*     */         }
/*  88 */         catch (EvaluationException evaluationException) {
/*  89 */           return (ValueEval)evaluationException.getErrorEval();
/*     */         } 
/*  91 */         return (ValueEval)new StringEval(String.valueOf((char)i));
/*     */       }
/*     */     };
/*     */   
/*  95 */   public static final Function LEN = new SingleArgTextFunc() {
/*     */       protected ValueEval evaluate(String param1String) {
/*  97 */         return (ValueEval)new NumberEval(param1String.length());
/*     */       }
/*     */     };
/* 100 */   public static final Function LOWER = new SingleArgTextFunc() {
/*     */       protected ValueEval evaluate(String param1String) {
/* 102 */         return (ValueEval)new StringEval(param1String.toLowerCase(Locale.ROOT));
/*     */       }
/*     */     };
/* 105 */   public static final Function UPPER = new SingleArgTextFunc() {
/*     */       protected ValueEval evaluate(String param1String) {
/* 107 */         return (ValueEval)new StringEval(param1String.toUpperCase(Locale.ROOT));
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
/* 118 */   public static final Function PROPER = new SingleArgTextFunc() {
/*     */       protected ValueEval evaluate(String param1String) {
/* 120 */         StringBuilder stringBuilder = new StringBuilder();
/* 121 */         boolean bool = true;
/* 122 */         for (char c : param1String.toCharArray()) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 127 */           if (bool) {
/* 128 */             stringBuilder.append(String.valueOf(c).toUpperCase(Locale.ROOT));
/*     */           } else {
/*     */             
/* 131 */             stringBuilder.append(String.valueOf(c).toLowerCase(Locale.ROOT));
/*     */           } 
/* 133 */           bool = !Character.isLetter(c) ? true : false;
/*     */         } 
/* 135 */         return (ValueEval)new StringEval(stringBuilder.toString());
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 145 */   public static final Function TRIM = new SingleArgTextFunc() {
/*     */       protected ValueEval evaluate(String param1String) {
/* 147 */         return (ValueEval)new StringEval(param1String.trim());
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public static final Function CLEAN = new SingleArgTextFunc() {
/*     */       protected ValueEval evaluate(String param1String) {
/* 159 */         StringBuilder stringBuilder = new StringBuilder();
/* 160 */         for (char c : param1String.toCharArray()) {
/* 161 */           if (isPrintable(c)) {
/* 162 */             stringBuilder.append(c);
/*     */           }
/*     */         } 
/* 165 */         return (ValueEval)new StringEval(stringBuilder.toString());
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
/*     */       
/*     */       private boolean isPrintable(char param1Char) {
/* 180 */         return (param1Char >= ' ');
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
/* 194 */   public static final Function MID = new Fixed3ArgFunction()
/*     */     {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2, ValueEval param1ValueEval3)
/*     */       {
/*     */         String str1;
/*     */         
/*     */         int i, j;
/*     */         try {
/* 202 */           str1 = TextFunction.evaluateStringArg(param1ValueEval1, param1Int1, param1Int2);
/* 203 */           i = TextFunction.evaluateIntArg(param1ValueEval2, param1Int1, param1Int2);
/* 204 */           j = TextFunction.evaluateIntArg(param1ValueEval3, param1Int1, param1Int2);
/* 205 */         } catch (EvaluationException evaluationException) {
/* 206 */           return (ValueEval)evaluationException.getErrorEval();
/*     */         } 
/* 208 */         int k = i - 1;
/*     */ 
/*     */ 
/*     */         
/* 212 */         if (k < 0) {
/* 213 */           return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */         }
/* 215 */         if (j < 0) {
/* 216 */           return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */         }
/* 218 */         int m = str1.length();
/* 219 */         if (j < 0 || k > m) {
/* 220 */           return (ValueEval)new StringEval("");
/*     */         }
/* 222 */         int n = Math.min(k + j, m);
/* 223 */         String str2 = str1.substring(k, n);
/* 224 */         return (ValueEval)new StringEval(str2);
/*     */       }
/*     */     };
/*     */   
/*     */   private static final class LeftRight extends Var1or2ArgFunction {
/* 229 */     private static final ValueEval DEFAULT_ARG1 = (ValueEval)new NumberEval(1.0D); private final boolean _isLeft;
/*     */     
/*     */     protected LeftRight(boolean param1Boolean) {
/* 232 */       this._isLeft = param1Boolean;
/*     */     }
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval) {
/* 235 */       return evaluate(param1Int1, param1Int2, param1ValueEval, DEFAULT_ARG1);
/*     */     }
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */       String str1;
/*     */       int i;
/*     */       String str2;
/*     */       try {
/* 242 */         str1 = TextFunction.evaluateStringArg(param1ValueEval1, param1Int1, param1Int2);
/* 243 */         i = TextFunction.evaluateIntArg(param1ValueEval2, param1Int1, param1Int2);
/* 244 */       } catch (EvaluationException evaluationException) {
/* 245 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*     */       
/* 248 */       if (i < 0) {
/* 249 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       }
/*     */ 
/*     */       
/* 253 */       if (this._isLeft) {
/* 254 */         str2 = str1.substring(0, Math.min(str1.length(), i));
/*     */       } else {
/* 256 */         str2 = str1.substring(Math.max(0, str1.length() - i));
/*     */       } 
/* 258 */       return (ValueEval)new StringEval(str2);
/*     */     }
/*     */   }
/*     */   
/* 262 */   public static final Function LEFT = new LeftRight(true);
/* 263 */   public static final Function RIGHT = new LeftRight(false);
/*     */   
/* 265 */   public static final Function CONCATENATE = new Function()
/*     */     {
/*     */       public ValueEval evaluate(ValueEval[] param1ArrayOfValueEval, int param1Int1, int param1Int2) {
/* 268 */         StringBuilder stringBuilder = new StringBuilder();
/* 269 */         for (ValueEval valueEval : param1ArrayOfValueEval) {
/*     */           try {
/* 271 */             stringBuilder.append(TextFunction.evaluateStringArg(valueEval, param1Int1, param1Int2));
/* 272 */           } catch (EvaluationException evaluationException) {
/* 273 */             return (ValueEval)evaluationException.getErrorEval();
/*     */           } 
/*     */         } 
/* 276 */         return (ValueEval)new StringEval(stringBuilder.toString());
/*     */       }
/*     */     };
/*     */   
/* 280 */   public static final Function EXACT = new Fixed2ArgFunction()
/*     */     {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2)
/*     */       {
/*     */         String str1;
/*     */         String str2;
/*     */         try {
/* 287 */           str1 = TextFunction.evaluateStringArg(param1ValueEval1, param1Int1, param1Int2);
/* 288 */           str2 = TextFunction.evaluateStringArg(param1ValueEval2, param1Int1, param1Int2);
/* 289 */         } catch (EvaluationException evaluationException) {
/* 290 */           return (ValueEval)evaluationException.getErrorEval();
/*     */         } 
/* 292 */         return (ValueEval)BoolEval.valueOf(str1.equals(str2));
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
/* 306 */   public static final Function TEXT = new Fixed2ArgFunction()
/*     */     {
/*     */       public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */         double d;
/*     */         String str;
/*     */         try {
/* 312 */           d = TextFunction.evaluateDoubleArg(param1ValueEval1, param1Int1, param1Int2);
/* 313 */           str = TextFunction.evaluateStringArg(param1ValueEval2, param1Int1, param1Int2);
/* 314 */         } catch (EvaluationException evaluationException) {
/* 315 */           return (ValueEval)evaluationException.getErrorEval();
/*     */         } 
/*     */ 
/*     */         
/*     */         try {
/* 320 */           String str1 = TextFunction.formatter.formatRawCellContents(d, -1, str);
/* 321 */           return (ValueEval)new StringEval(str1);
/* 322 */         } catch (Exception exception) {
/* 323 */           return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */         } 
/*     */       }
/*     */     };
/*     */   
/*     */   private static final class SearchFind
/*     */     extends Var2or3ArgFunction {
/*     */     private final boolean _isCaseSensitive;
/*     */     
/*     */     public SearchFind(boolean param1Boolean) {
/* 333 */       this._isCaseSensitive = param1Boolean;
/*     */     }
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2) {
/*     */       try {
/* 337 */         String str1 = TextFunction.evaluateStringArg(param1ValueEval1, param1Int1, param1Int2);
/* 338 */         String str2 = TextFunction.evaluateStringArg(param1ValueEval2, param1Int1, param1Int2);
/* 339 */         return eval(str2, str1, 0);
/* 340 */       } catch (EvaluationException evaluationException) {
/* 341 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*     */     }
/*     */     
/*     */     public ValueEval evaluate(int param1Int1, int param1Int2, ValueEval param1ValueEval1, ValueEval param1ValueEval2, ValueEval param1ValueEval3) {
/*     */       try {
/* 347 */         String str1 = TextFunction.evaluateStringArg(param1ValueEval1, param1Int1, param1Int2);
/* 348 */         String str2 = TextFunction.evaluateStringArg(param1ValueEval2, param1Int1, param1Int2);
/*     */         
/* 350 */         int i = TextFunction.evaluateIntArg(param1ValueEval3, param1Int1, param1Int2) - 1;
/* 351 */         if (i < 0) {
/* 352 */           return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */         }
/* 354 */         return eval(str2, str1, i);
/* 355 */       } catch (EvaluationException evaluationException) {
/* 356 */         return (ValueEval)evaluationException.getErrorEval();
/*     */       } 
/*     */     }
/*     */     private ValueEval eval(String param1String1, String param1String2, int param1Int) {
/*     */       int i;
/* 361 */       if (this._isCaseSensitive) {
/* 362 */         i = param1String1.indexOf(param1String2, param1Int);
/*     */       } else {
/* 364 */         i = param1String1.toUpperCase(Locale.ROOT).indexOf(param1String2.toUpperCase(Locale.ROOT), param1Int);
/*     */       } 
/*     */       
/* 367 */       if (i == -1) {
/* 368 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       }
/* 370 */       return (ValueEval)new NumberEval((i + 1));
/*     */     }
/*     */   }
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
/* 386 */   public static final Function FIND = new SearchFind(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 395 */   public static final Function SEARCH = new SearchFind(false);
/*     */   
/*     */   protected abstract ValueEval evaluateFunc(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) throws EvaluationException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\TextFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */