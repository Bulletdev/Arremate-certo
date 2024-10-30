/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.AreaEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NotImplementedException;
/*     */ import org.apache.poi.ss.formula.eval.NumericValueEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.StringValueEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*     */ public final class DStarRunner
/*     */   implements Function3Arg
/*     */ {
/*     */   private final DStarAlgorithmEnum algoType;
/*     */   
/*     */   public enum DStarAlgorithmEnum
/*     */   {
/*  43 */     DGET,
/*  44 */     DMIN;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DStarRunner(DStarAlgorithmEnum paramDStarAlgorithmEnum) {
/*  50 */     this.algoType = paramDStarAlgorithmEnum;
/*     */   }
/*     */   
/*     */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/*  54 */     if (paramArrayOfValueEval.length == 3) {
/*  55 */       return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2]);
/*     */     }
/*     */     
/*  58 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*     */     int i;
/*     */     DMin dMin;
/*  65 */     if (!(paramValueEval1 instanceof AreaEval) || !(paramValueEval3 instanceof AreaEval)) {
/*  66 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*  68 */     AreaEval areaEval1 = (AreaEval)paramValueEval1;
/*  69 */     AreaEval areaEval2 = (AreaEval)paramValueEval3;
/*     */     
/*     */     try {
/*  72 */       paramValueEval2 = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/*  73 */     } catch (EvaluationException evaluationException) {
/*  74 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/*  79 */       i = getColumnForName(paramValueEval2, areaEval1);
/*     */     }
/*  81 */     catch (EvaluationException evaluationException) {
/*  82 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     } 
/*  84 */     if (i == -1) {
/*  85 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*     */ 
/*     */     
/*  89 */     DGet dGet = null;
/*  90 */     switch (this.algoType) { case largerThan:
/*  91 */         dGet = new DGet(); break;
/*  92 */       case largerEqualThan: dMin = new DMin(); break;
/*     */       default:
/*  94 */         throw new IllegalStateException("Unexpected algorithm type " + this.algoType + " encountered."); }
/*     */ 
/*     */ 
/*     */     
/*  98 */     int j = areaEval1.getHeight();
/*  99 */     for (byte b = 1; b < j; b++) {
/* 100 */       boolean bool = true;
/*     */       try {
/* 102 */         bool = fullfillsConditions(areaEval1, b, areaEval2);
/*     */       }
/* 104 */       catch (EvaluationException evaluationException) {
/* 105 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */       } 
/*     */       
/* 108 */       if (bool) {
/* 109 */         ValueEval valueEval = resolveReference(areaEval1, b, i);
/*     */         
/* 111 */         boolean bool1 = dMin.processMatch(valueEval);
/* 112 */         if (!bool1) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 119 */     return dMin.getResult();
/*     */   }
/*     */   
/*     */   private enum operator {
/* 123 */     largerThan,
/* 124 */     largerEqualThan,
/* 125 */     smallerThan,
/* 126 */     smallerEqualThan,
/* 127 */     equal;
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
/*     */   private static int getColumnForName(ValueEval paramValueEval, AreaEval paramAreaEval) throws EvaluationException {
/* 140 */     String str = OperandResolver.coerceValueToString(paramValueEval);
/* 141 */     return getColumnForString(paramAreaEval, str);
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
/*     */   private static int getColumnForString(AreaEval paramAreaEval, String paramString) throws EvaluationException {
/* 154 */     byte b = -1;
/* 155 */     int i = paramAreaEval.getWidth();
/* 156 */     for (byte b1 = 0; b1 < i; b1++) {
/* 157 */       ValueEval valueEval = resolveReference(paramAreaEval, 0, b1);
/* 158 */       if (!(valueEval instanceof org.apache.poi.ss.formula.eval.BlankEval))
/*     */       {
/*     */         
/* 161 */         if (!(valueEval instanceof ErrorEval)) {
/*     */ 
/*     */           
/* 164 */           String str = OperandResolver.coerceValueToString(valueEval);
/* 165 */           if (paramString.equals(str)) {
/* 166 */             b = b1; break;
/*     */           } 
/*     */         }  } 
/*     */     } 
/* 170 */     return b;
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
/*     */   private static boolean fullfillsConditions(AreaEval paramAreaEval1, int paramInt, AreaEval paramAreaEval2) throws EvaluationException {
/* 188 */     int i = paramAreaEval2.getHeight();
/* 189 */     for (byte b = 1; b < i; b++) {
/* 190 */       boolean bool = true;
/* 191 */       int j = paramAreaEval2.getWidth();
/* 192 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */ 
/*     */         
/* 195 */         boolean bool1 = true;
/* 196 */         ValueEval valueEval = null;
/*     */ 
/*     */         
/* 199 */         valueEval = resolveReference(paramAreaEval2, b, b1);
/*     */ 
/*     */         
/* 202 */         if (!(valueEval instanceof org.apache.poi.ss.formula.eval.BlankEval)) {
/*     */ 
/*     */           
/* 205 */           ValueEval valueEval1 = resolveReference(paramAreaEval2, 0, b1);
/*     */           
/* 207 */           if (!(valueEval1 instanceof StringValueEval)) {
/* 208 */             throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */           }
/*     */           
/* 211 */           if (getColumnForName(valueEval1, paramAreaEval1) == -1)
/*     */           {
/* 213 */             bool1 = false;
/*     */           }
/* 215 */           if (bool1 == true) {
/*     */             
/* 217 */             ValueEval valueEval2 = resolveReference(paramAreaEval1, paramInt, getColumnForName(valueEval1, paramAreaEval1));
/* 218 */             if (!testNormalCondition(valueEval2, valueEval)) {
/* 219 */               bool = false;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } else {
/* 224 */             if (OperandResolver.coerceValueToString(valueEval).isEmpty()) {
/* 225 */               throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */             }
/* 227 */             throw new NotImplementedException("D* function with formula conditions");
/*     */           } 
/*     */         } 
/*     */       } 
/* 231 */       if (bool == true) {
/* 232 */         return true;
/*     */       }
/*     */     } 
/* 235 */     return false;
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
/*     */   private static boolean testNormalCondition(ValueEval paramValueEval1, ValueEval paramValueEval2) throws EvaluationException {
/* 248 */     if (paramValueEval2 instanceof StringEval) {
/* 249 */       String str1 = ((StringEval)paramValueEval2).getStringValue();
/*     */       
/* 251 */       if (str1.startsWith("<")) {
/* 252 */         String str = str1.substring(1);
/* 253 */         if (str.startsWith("=")) {
/* 254 */           str = str.substring(1);
/* 255 */           return testNumericCondition(paramValueEval1, operator.smallerEqualThan, str);
/*     */         } 
/* 257 */         return testNumericCondition(paramValueEval1, operator.smallerThan, str);
/*     */       } 
/*     */       
/* 260 */       if (str1.startsWith(">")) {
/* 261 */         String str = str1.substring(1);
/* 262 */         if (str.startsWith("=")) {
/* 263 */           str = str.substring(1);
/* 264 */           return testNumericCondition(paramValueEval1, operator.largerEqualThan, str);
/*     */         } 
/* 266 */         return testNumericCondition(paramValueEval1, operator.largerThan, str);
/*     */       } 
/*     */       
/* 269 */       if (str1.startsWith("=")) {
/* 270 */         String str3 = str1.substring(1);
/*     */         
/* 272 */         if (str3.isEmpty()) {
/* 273 */           return paramValueEval1 instanceof org.apache.poi.ss.formula.eval.BlankEval;
/*     */         }
/*     */         
/* 276 */         boolean bool = false;
/*     */         try {
/* 278 */           Integer.parseInt(str3);
/* 279 */           bool = true;
/* 280 */         } catch (NumberFormatException numberFormatException) {
/*     */           try {
/* 282 */             Double.parseDouble(str3);
/* 283 */             bool = true;
/* 284 */           } catch (NumberFormatException numberFormatException1) {
/* 285 */             bool = false;
/*     */           } 
/*     */         } 
/* 288 */         if (bool) {
/* 289 */           return testNumericCondition(paramValueEval1, operator.equal, str3);
/*     */         }
/* 291 */         String str4 = (paramValueEval1 instanceof org.apache.poi.ss.formula.eval.BlankEval) ? "" : OperandResolver.coerceValueToString(paramValueEval1);
/* 292 */         return str3.equals(str4);
/*     */       } 
/*     */       
/* 295 */       if (str1.isEmpty()) {
/* 296 */         return paramValueEval1 instanceof StringEval;
/*     */       }
/*     */       
/* 299 */       String str2 = (paramValueEval1 instanceof org.apache.poi.ss.formula.eval.BlankEval) ? "" : OperandResolver.coerceValueToString(paramValueEval1);
/* 300 */       return str2.startsWith(str1);
/*     */     } 
/*     */ 
/*     */     
/* 304 */     if (paramValueEval2 instanceof NumericValueEval) {
/* 305 */       double d = ((NumericValueEval)paramValueEval2).getNumberValue();
/* 306 */       Double double_ = getNumberFromValueEval(paramValueEval1);
/* 307 */       if (double_ == null) {
/* 308 */         return false;
/*     */       }
/*     */       
/* 311 */       return (d == double_.doubleValue());
/*     */     } 
/* 313 */     if (paramValueEval2 instanceof ErrorEval) {
/* 314 */       if (paramValueEval1 instanceof ErrorEval) {
/* 315 */         return (((ErrorEval)paramValueEval2).getErrorCode() == ((ErrorEval)paramValueEval1).getErrorCode());
/*     */       }
/*     */       
/* 318 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 322 */     return false;
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
/*     */   private static boolean testNumericCondition(ValueEval paramValueEval, operator paramoperator, String paramString) throws EvaluationException {
/* 338 */     if (!(paramValueEval instanceof NumericValueEval))
/* 339 */       return false; 
/* 340 */     double d1 = ((NumericValueEval)paramValueEval).getNumberValue();
/*     */ 
/*     */     
/* 343 */     double d2 = 0.0D;
/*     */     try {
/* 345 */       int j = Integer.parseInt(paramString);
/* 346 */       d2 = j;
/* 347 */     } catch (NumberFormatException numberFormatException) {
/*     */       try {
/* 349 */         d2 = Double.parseDouble(paramString);
/* 350 */       } catch (NumberFormatException numberFormatException1) {
/* 351 */         throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */       } 
/*     */     } 
/*     */     
/* 355 */     int i = NumberComparer.compare(d1, d2);
/* 356 */     switch (paramoperator) {
/*     */       case largerThan:
/* 358 */         return (i > 0);
/*     */       case largerEqualThan:
/* 360 */         return (i >= 0);
/*     */       case smallerThan:
/* 362 */         return (i < 0);
/*     */       case smallerEqualThan:
/* 364 */         return (i <= 0);
/*     */       case equal:
/* 366 */         return (i == 0);
/*     */     } 
/* 368 */     return false;
/*     */   }
/*     */   
/*     */   private static Double getNumberFromValueEval(ValueEval paramValueEval) {
/* 372 */     if (paramValueEval instanceof NumericValueEval) {
/* 373 */       return Double.valueOf(((NumericValueEval)paramValueEval).getNumberValue());
/*     */     }
/* 375 */     if (paramValueEval instanceof StringValueEval) {
/* 376 */       String str = ((StringValueEval)paramValueEval).getStringValue();
/*     */       try {
/* 378 */         return Double.valueOf(Double.parseDouble(str));
/* 379 */       } catch (NumberFormatException numberFormatException) {
/* 380 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 384 */     return null;
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
/*     */   private static ValueEval resolveReference(AreaEval paramAreaEval, int paramInt1, int paramInt2) {
/*     */     try {
/* 398 */       return OperandResolver.getSingleValue(paramAreaEval.getValue(paramInt1, paramInt2), paramAreaEval.getFirstRow() + paramInt1, paramAreaEval.getFirstColumn() + paramInt2);
/* 399 */     } catch (EvaluationException evaluationException) {
/* 400 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\DStarRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */