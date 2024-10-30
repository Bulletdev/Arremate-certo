/*     */ package org.apache.poi.ss.formula.eval;
/*     */ 
/*     */ import java.util.regex.Pattern;
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
/*     */ public final class OperandResolver
/*     */ {
/*     */   private static final String Digits = "(\\p{Digit}+)";
/*     */   private static final String Exp = "[eE][+-]?(\\p{Digit}+)";
/*     */   private static final String fpRegex = "[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?))))[\\x00-\\x20]*";
/*     */   
/*     */   public static ValueEval getSingleValue(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*     */     ValueEval valueEval;
/*  61 */     if (paramValueEval instanceof RefEval) {
/*  62 */       valueEval = chooseSingleElementFromRef((RefEval)paramValueEval);
/*  63 */     } else if (paramValueEval instanceof AreaEval) {
/*  64 */       valueEval = chooseSingleElementFromArea((AreaEval)paramValueEval, paramInt1, paramInt2);
/*     */     } else {
/*  66 */       valueEval = paramValueEval;
/*     */     } 
/*  68 */     if (valueEval instanceof ErrorEval) {
/*  69 */       throw new EvaluationException((ErrorEval)valueEval);
/*     */     }
/*  71 */     return valueEval;
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
/*     */   public static ValueEval chooseSingleElementFromArea(AreaEval paramAreaEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 120 */     ValueEval valueEval = chooseSingleElementFromAreaInternal(paramAreaEval, paramInt1, paramInt2);
/* 121 */     if (valueEval instanceof ErrorEval) {
/* 122 */       throw new EvaluationException((ErrorEval)valueEval);
/*     */     }
/* 124 */     return valueEval;
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
/*     */   private static ValueEval chooseSingleElementFromAreaInternal(AreaEval paramAreaEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 156 */     if (paramAreaEval.isColumn()) {
/* 157 */       if (paramAreaEval.isRow()) {
/* 158 */         return paramAreaEval.getRelativeValue(0, 0);
/*     */       }
/* 160 */       if (!paramAreaEval.containsRow(paramInt1)) {
/* 161 */         throw EvaluationException.invalidValue();
/*     */       }
/* 163 */       return paramAreaEval.getAbsoluteValue(paramInt1, paramAreaEval.getFirstColumn());
/*     */     } 
/* 165 */     if (!paramAreaEval.isRow()) {
/*     */       
/* 167 */       if (paramAreaEval.containsRow(paramInt1) && paramAreaEval.containsColumn(paramInt2)) {
/* 168 */         return paramAreaEval.getAbsoluteValue(paramAreaEval.getFirstRow(), paramAreaEval.getFirstColumn());
/*     */       }
/* 170 */       throw EvaluationException.invalidValue();
/*     */     } 
/* 172 */     if (!paramAreaEval.containsColumn(paramInt2)) {
/* 173 */       throw EvaluationException.invalidValue();
/*     */     }
/* 175 */     return paramAreaEval.getAbsoluteValue(paramAreaEval.getFirstRow(), paramInt2);
/*     */   }
/*     */   
/*     */   private static ValueEval chooseSingleElementFromRef(RefEval paramRefEval) {
/* 179 */     return paramRefEval.getInnerValueEval(paramRefEval.getFirstSheetIndex());
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
/*     */   public static int coerceValueToInt(ValueEval paramValueEval) throws EvaluationException {
/* 195 */     if (paramValueEval == BlankEval.instance) {
/* 196 */       return 0;
/*     */     }
/* 198 */     double d = coerceValueToDouble(paramValueEval);
/*     */ 
/*     */     
/* 201 */     return (int)Math.floor(d);
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
/*     */   public static double coerceValueToDouble(ValueEval paramValueEval) throws EvaluationException {
/* 217 */     if (paramValueEval == BlankEval.instance) {
/* 218 */       return 0.0D;
/*     */     }
/* 220 */     if (paramValueEval instanceof NumericValueEval)
/*     */     {
/* 222 */       return ((NumericValueEval)paramValueEval).getNumberValue();
/*     */     }
/* 224 */     if (paramValueEval instanceof StringEval) {
/* 225 */       Double double_ = parseDouble(((StringEval)paramValueEval).getStringValue());
/* 226 */       if (double_ == null) {
/* 227 */         throw EvaluationException.invalidValue();
/*     */       }
/* 229 */       return double_.doubleValue();
/*     */     } 
/* 231 */     throw new RuntimeException("Unexpected arg eval type (" + paramValueEval.getClass().getName() + ")");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Double parseDouble(String paramString) {
/* 255 */     if (Pattern.matches("[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?))))[\\x00-\\x20]*", paramString)) {
/*     */       try {
/* 257 */         return Double.valueOf(Double.parseDouble(paramString));
/* 258 */       } catch (NumberFormatException numberFormatException) {
/* 259 */         return null;
/*     */       } 
/*     */     }
/* 262 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String coerceValueToString(ValueEval paramValueEval) {
/* 272 */     if (paramValueEval instanceof StringValueEval) {
/* 273 */       StringValueEval stringValueEval = (StringValueEval)paramValueEval;
/* 274 */       return stringValueEval.getStringValue();
/*     */     } 
/* 276 */     if (paramValueEval == BlankEval.instance) {
/* 277 */       return "";
/*     */     }
/* 279 */     throw new IllegalArgumentException("Unexpected eval class (" + paramValueEval.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Boolean coerceValueToBoolean(ValueEval paramValueEval, boolean paramBoolean) throws EvaluationException {
/* 288 */     if (paramValueEval == null || paramValueEval == BlankEval.instance)
/*     */     {
/* 290 */       return null;
/*     */     }
/* 292 */     if (paramValueEval instanceof BoolEval) {
/* 293 */       return Boolean.valueOf(((BoolEval)paramValueEval).getBooleanValue());
/*     */     }
/*     */     
/* 296 */     if (paramValueEval == BlankEval.instance) {
/* 297 */       return null;
/*     */     }
/*     */     
/* 300 */     if (paramValueEval instanceof StringEval) {
/* 301 */       if (paramBoolean) {
/* 302 */         return null;
/*     */       }
/* 304 */       String str = ((StringEval)paramValueEval).getStringValue();
/* 305 */       if (str.equalsIgnoreCase("true")) {
/* 306 */         return Boolean.TRUE;
/*     */       }
/* 308 */       if (str.equalsIgnoreCase("false")) {
/* 309 */         return Boolean.FALSE;
/*     */       }
/*     */       
/* 312 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */     } 
/*     */     
/* 315 */     if (paramValueEval instanceof NumericValueEval) {
/* 316 */       NumericValueEval numericValueEval = (NumericValueEval)paramValueEval;
/* 317 */       double d = numericValueEval.getNumberValue();
/* 318 */       if (Double.isNaN(d)) {
/* 319 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       }
/* 321 */       return Boolean.valueOf((d != 0.0D));
/*     */     } 
/* 323 */     if (paramValueEval instanceof ErrorEval) {
/* 324 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*     */     }
/* 326 */     throw new RuntimeException("Unexpected eval (" + paramValueEval.getClass().getName() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\OperandResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */