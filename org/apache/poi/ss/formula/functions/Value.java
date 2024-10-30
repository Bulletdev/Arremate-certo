/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*     */ 
/*     */ public final class Value
/*     */   extends Fixed1ArgFunction
/*     */ {
/*     */   private static final int MIN_DISTANCE_BETWEEN_THOUSANDS_SEPARATOR = 4;
/*  40 */   private static final Double ZERO = new Double(0.0D);
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*     */     ValueEval valueEval;
/*     */     try {
/*  45 */       valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*  46 */     } catch (EvaluationException evaluationException) {
/*  47 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*  49 */     String str = OperandResolver.coerceValueToString(valueEval);
/*  50 */     Double double_ = convertTextToNumber(str);
/*  51 */     if (double_ == null) {
/*  52 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*     */     }
/*  54 */     return (ValueEval)new NumberEval(double_.doubleValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Double convertTextToNumber(String paramString) {
/*     */     double d1;
/*  63 */     boolean bool1 = false;
/*  64 */     boolean bool2 = false;
/*  65 */     boolean bool3 = false;
/*  66 */     boolean bool4 = false;
/*     */     
/*  68 */     int i = paramString.length();
/*     */     int j;
/*  70 */     for (j = 0; j < i; j++) {
/*  71 */       char c = paramString.charAt(j);
/*  72 */       if (Character.isDigit(c) || c == '.') {
/*     */         break;
/*     */       }
/*  75 */       switch (c) {
/*     */         case ' ':
/*     */           break;
/*     */         
/*     */         case '$':
/*  80 */           if (bool1)
/*     */           {
/*  82 */             return null;
/*     */           }
/*  84 */           bool1 = true;
/*     */           break;
/*     */         case '+':
/*  87 */           if (bool3 || bool2) {
/*  88 */             return null;
/*     */           }
/*  90 */           bool2 = true;
/*     */           break;
/*     */         case '-':
/*  93 */           if (bool3 || bool2) {
/*  94 */             return null;
/*     */           }
/*  96 */           bool3 = true;
/*     */           break;
/*     */         
/*     */         default:
/* 100 */           return null;
/*     */       } 
/*     */     } 
/* 103 */     if (j >= i) {
/*     */       
/* 105 */       if (bool1 || bool3 || bool2) {
/* 106 */         return null;
/*     */       }
/* 108 */       return ZERO;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 113 */     boolean bool5 = false;
/* 114 */     int k = -32768;
/*     */     
/* 116 */     StringBuffer stringBuffer = new StringBuffer(i);
/* 117 */     for (; j < i; j++) {
/* 118 */       char c = paramString.charAt(j);
/* 119 */       if (Character.isDigit(c)) {
/* 120 */         stringBuffer.append(c);
/*     */       } else {
/*     */         String str; int m;
/* 123 */         switch (c) {
/*     */           case ' ':
/* 125 */             str = paramString.substring(j).trim();
/*     */             
/* 127 */             if (str.equals("%")) {
/* 128 */               bool4 = true;
/*     */               break;
/*     */             } 
/* 131 */             if (str.length() > 0)
/*     */             {
/* 133 */               return null;
/*     */             }
/*     */             break;
/*     */           case '.':
/* 137 */             if (bool5) {
/* 138 */               return null;
/*     */             }
/* 140 */             if (j - k < 4) {
/* 141 */               return null;
/*     */             }
/* 143 */             bool5 = true;
/* 144 */             stringBuffer.append('.');
/*     */             break;
/*     */           case ',':
/* 147 */             if (bool5)
/*     */             {
/* 149 */               return null;
/*     */             }
/* 151 */             m = j - k;
/*     */             
/* 153 */             if (m < 4) {
/* 154 */               return null;
/*     */             }
/* 156 */             k = j;
/*     */             break;
/*     */ 
/*     */           
/*     */           case 'E':
/*     */           case 'e':
/* 162 */             if (j - k < 4) {
/* 163 */               return null;
/*     */             }
/*     */             
/* 166 */             stringBuffer.append(paramString.substring(j));
/* 167 */             j = i;
/*     */             break;
/*     */           case '%':
/* 170 */             bool4 = true;
/*     */             break;
/*     */           
/*     */           default:
/* 174 */             return null;
/*     */         } 
/*     */       } 
/* 177 */     }  if (!bool5 && 
/* 178 */       j - k < 4) {
/* 179 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 184 */       d1 = Double.parseDouble(stringBuffer.toString());
/* 185 */     } catch (NumberFormatException numberFormatException) {
/*     */       
/* 187 */       return null;
/*     */     } 
/* 189 */     double d2 = bool3 ? -d1 : d1;
/* 190 */     return Double.valueOf(bool4 ? (d2 / 100.0D) : d2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */