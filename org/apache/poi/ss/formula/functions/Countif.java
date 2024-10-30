/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.ss.formula.ThreeDEval;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.RefEval;
/*     */ import org.apache.poi.ss.formula.eval.StringEval;
/*     */ import org.apache.poi.ss.formula.eval.ValueEval;
/*     */ import org.apache.poi.ss.usermodel.FormulaError;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Countif
/*     */   extends Fixed2ArgFunction
/*     */ {
/*     */   private static final class CmpOp
/*     */   {
/*     */     public static final int NONE = 0;
/*     */     public static final int EQ = 1;
/*     */     public static final int NE = 2;
/*     */     public static final int LE = 3;
/*     */     public static final int LT = 4;
/*     */     public static final int GT = 5;
/*     */     public static final int GE = 6;
/*  56 */     public static final CmpOp OP_NONE = op("", 0);
/*  57 */     public static final CmpOp OP_EQ = op("=", 1);
/*  58 */     public static final CmpOp OP_NE = op("<>", 2);
/*  59 */     public static final CmpOp OP_LE = op("<=", 3);
/*  60 */     public static final CmpOp OP_LT = op("<", 4);
/*  61 */     public static final CmpOp OP_GT = op(">", 5);
/*  62 */     public static final CmpOp OP_GE = op(">=", 6);
/*     */     private final String _representation;
/*     */     private final int _code;
/*     */     
/*     */     private static CmpOp op(String param1String, int param1Int) {
/*  67 */       return new CmpOp(param1String, param1Int);
/*     */     }
/*     */     private CmpOp(String param1String, int param1Int) {
/*  70 */       this._representation = param1String;
/*  71 */       this._code = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getLength() {
/*  77 */       return this._representation.length();
/*     */     }
/*     */     public int getCode() {
/*  80 */       return this._code;
/*     */     }
/*     */     public static CmpOp getOperator(String param1String) {
/*  83 */       int i = param1String.length();
/*  84 */       if (i < 1) {
/*  85 */         return OP_NONE;
/*     */       }
/*     */       
/*  88 */       char c = param1String.charAt(0);
/*     */       
/*  90 */       switch (c) {
/*     */         case '=':
/*  92 */           return OP_EQ;
/*     */         case '>':
/*  94 */           if (i > 1) {
/*  95 */             switch (param1String.charAt(1)) {
/*     */               case '=':
/*  97 */                 return OP_GE;
/*     */             } 
/*     */           }
/* 100 */           return OP_GT;
/*     */         case '<':
/* 102 */           if (i > 1) {
/* 103 */             switch (param1String.charAt(1)) {
/*     */               case '=':
/* 105 */                 return OP_LE;
/*     */               case '>':
/* 107 */                 return OP_NE;
/*     */             } 
/*     */           }
/* 110 */           return OP_LT;
/*     */       } 
/* 112 */       return OP_NONE;
/*     */     }
/*     */     public boolean evaluate(boolean param1Boolean) {
/* 115 */       switch (this._code) {
/*     */         case 0:
/*     */         case 1:
/* 118 */           return param1Boolean;
/*     */         case 2:
/* 120 */           return !param1Boolean;
/*     */       } 
/* 122 */       throw new RuntimeException("Cannot call boolean evaluate on non-equality operator '" + this._representation + "'");
/*     */     }
/*     */     
/*     */     public boolean evaluate(int param1Int) {
/* 126 */       switch (this._code) {
/*     */         case 0:
/*     */         case 1:
/* 129 */           return (param1Int == 0);
/* 130 */         case 2: return (param1Int != 0);
/* 131 */         case 4: return (param1Int < 0);
/* 132 */         case 3: return (param1Int <= 0);
/* 133 */         case 5: return (param1Int > 0);
/* 134 */         case 6: return (param1Int >= 0);
/*     */       } 
/* 136 */       throw new RuntimeException("Cannot call boolean evaluate on non-equality operator '" + this._representation + "'");
/*     */     }
/*     */     
/*     */     public String toString() {
/* 140 */       StringBuffer stringBuffer = new StringBuffer(64);
/* 141 */       stringBuffer.append(getClass().getName());
/* 142 */       stringBuffer.append(" [").append(this._representation).append("]");
/* 143 */       return stringBuffer.toString();
/*     */     }
/*     */     public String getRepresentation() {
/* 146 */       return this._representation;
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract class MatcherBase implements CountUtils.I_MatchPredicate {
/*     */     private final Countif.CmpOp _operator;
/*     */     
/*     */     MatcherBase(Countif.CmpOp param1CmpOp) {
/* 154 */       this._operator = param1CmpOp;
/*     */     }
/*     */     protected final int getCode() {
/* 157 */       return this._operator.getCode();
/*     */     }
/*     */     protected final boolean evaluate(int param1Int) {
/* 160 */       return this._operator.evaluate(param1Int);
/*     */     }
/*     */     protected final boolean evaluate(boolean param1Boolean) {
/* 163 */       return this._operator.evaluate(param1Boolean);
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 167 */       StringBuffer stringBuffer = new StringBuffer(64);
/* 168 */       stringBuffer.append(getClass().getName()).append(" [");
/* 169 */       stringBuffer.append(this._operator.getRepresentation());
/* 170 */       stringBuffer.append(getValueText());
/* 171 */       stringBuffer.append("]");
/* 172 */       return stringBuffer.toString();
/*     */     }
/*     */     
/*     */     protected abstract String getValueText();
/*     */   }
/*     */   
/*     */   private static final class NumberMatcher extends MatcherBase {
/*     */     private final double _value;
/*     */     
/*     */     public NumberMatcher(double param1Double, Countif.CmpOp param1CmpOp) {
/* 182 */       super(param1CmpOp);
/* 183 */       this._value = param1Double;
/*     */     }
/*     */     
/*     */     protected String getValueText() {
/* 187 */       return String.valueOf(this._value);
/*     */     }
/*     */     
/*     */     public boolean matches(ValueEval param1ValueEval) {
/*     */       double d;
/* 192 */       if (param1ValueEval instanceof StringEval) {
/*     */ 
/*     */         
/* 195 */         switch (getCode()) {
/*     */           case 0:
/*     */           case 1:
/*     */             break;
/*     */ 
/*     */           
/*     */           case 2:
/* 202 */             return true;
/*     */ 
/*     */           
/*     */           default:
/* 206 */             return false;
/*     */         } 
/* 208 */         StringEval stringEval = (StringEval)param1ValueEval;
/* 209 */         Double double_ = OperandResolver.parseDouble(stringEval.getStringValue());
/* 210 */         if (double_ == null)
/*     */         {
/* 212 */           return false;
/*     */         }
/* 214 */         return (this._value == double_.doubleValue());
/* 215 */       }  if (param1ValueEval instanceof NumberEval)
/* 216 */       { NumberEval numberEval = (NumberEval)param1ValueEval;
/* 217 */         d = numberEval.getNumberValue(); }
/* 218 */       else { if (param1ValueEval instanceof BlankEval) {
/* 219 */           switch (getCode()) {
/*     */             
/*     */             case 2:
/* 222 */               return true;
/*     */           } 
/* 224 */           return false;
/*     */         } 
/*     */         
/* 227 */         return false; }
/*     */       
/* 229 */       return evaluate(Double.compare(d, this._value));
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class BooleanMatcher extends MatcherBase {
/*     */     private final int _value;
/*     */     
/*     */     public BooleanMatcher(boolean param1Boolean, Countif.CmpOp param1CmpOp) {
/* 237 */       super(param1CmpOp);
/* 238 */       this._value = boolToInt(param1Boolean);
/*     */     }
/*     */     
/*     */     protected String getValueText() {
/* 242 */       return (this._value == 1) ? "TRUE" : "FALSE";
/*     */     }
/*     */     
/*     */     private static int boolToInt(boolean param1Boolean) {
/* 246 */       return param1Boolean ? 1 : 0;
/*     */     }
/*     */     
/*     */     public boolean matches(ValueEval param1ValueEval) {
/*     */       int i;
/* 251 */       if (param1ValueEval instanceof StringEval)
/*     */       {
/*     */ 
/*     */         
/* 255 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 265 */       if (param1ValueEval instanceof BoolEval)
/* 266 */       { BoolEval boolEval = (BoolEval)param1ValueEval;
/* 267 */         i = boolToInt(boolEval.getBooleanValue()); }
/* 268 */       else { if (param1ValueEval instanceof BlankEval) {
/* 269 */           switch (getCode()) {
/*     */             
/*     */             case 2:
/* 272 */               return true;
/*     */           } 
/* 274 */           return false;
/*     */         } 
/* 276 */         if (param1ValueEval instanceof NumberEval) {
/* 277 */           switch (getCode()) {
/*     */             
/*     */             case 2:
/* 280 */               return true;
/*     */           } 
/* 282 */           return false;
/*     */         } 
/*     */         
/* 285 */         return false; }
/*     */       
/* 287 */       return evaluate(i - this._value);
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class ErrorMatcher extends MatcherBase {
/*     */     private final int _value;
/*     */     
/*     */     public ErrorMatcher(int param1Int, Countif.CmpOp param1CmpOp) {
/* 295 */       super(param1CmpOp);
/* 296 */       this._value = param1Int;
/*     */     }
/*     */     
/*     */     protected String getValueText() {
/* 300 */       return FormulaError.forInt(this._value).getString();
/*     */     }
/*     */     
/*     */     public boolean matches(ValueEval param1ValueEval) {
/* 304 */       if (param1ValueEval instanceof ErrorEval) {
/* 305 */         int i = ((ErrorEval)param1ValueEval).getErrorCode();
/* 306 */         return evaluate(i - this._value);
/*     */       } 
/* 308 */       return false;
/*     */     }
/*     */     
/*     */     public int getValue() {
/* 312 */       return this._value;
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class StringMatcher extends MatcherBase {
/*     */     private final String _value;
/*     */     private final Pattern _pattern;
/*     */     
/*     */     public StringMatcher(String param1String, Countif.CmpOp param1CmpOp) {
/* 321 */       super(param1CmpOp);
/* 322 */       this._value = param1String;
/* 323 */       switch (param1CmpOp.getCode()) {
/*     */         case 0:
/*     */         case 1:
/*     */         case 2:
/* 327 */           this._pattern = getWildCardPattern(param1String);
/*     */           return;
/*     */       } 
/*     */       
/* 331 */       this._pattern = null;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String getValueText() {
/* 336 */       if (this._pattern == null) {
/* 337 */         return this._value;
/*     */       }
/* 339 */       return this._pattern.pattern();
/*     */     }
/*     */     
/*     */     public boolean matches(ValueEval param1ValueEval) {
/* 343 */       if (param1ValueEval instanceof BlankEval) {
/* 344 */         switch (getCode()) {
/*     */           case 0:
/*     */           case 1:
/* 347 */             return (this._value.length() == 0);
/*     */ 
/*     */           
/*     */           case 2:
/* 351 */             return (this._value.length() != 0);
/*     */         } 
/*     */         
/* 354 */         return false;
/*     */       } 
/* 356 */       if (!(param1ValueEval instanceof StringEval))
/*     */       {
/*     */ 
/*     */         
/* 360 */         return false;
/*     */       }
/* 362 */       String str = ((StringEval)param1ValueEval).getStringValue();
/* 363 */       if (str.length() < 1 && this._value.length() < 1) {
/*     */ 
/*     */         
/* 366 */         switch (getCode()) { case 0:
/* 367 */             return true;
/* 368 */           case 1: return false;
/* 369 */           case 2: return true; }
/*     */         
/* 371 */         return false;
/*     */       } 
/* 373 */       if (this._pattern != null) {
/* 374 */         return evaluate(this._pattern.matcher(str).matches());
/*     */       }
/*     */ 
/*     */       
/* 378 */       return evaluate(str.compareToIgnoreCase(this._value));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static Pattern getWildCardPattern(String param1String) {
/* 385 */       int i = param1String.length();
/* 386 */       StringBuffer stringBuffer = new StringBuffer(i);
/* 387 */       boolean bool = false;
/* 388 */       for (byte b = 0; b < i; b++) {
/* 389 */         char c = param1String.charAt(b);
/* 390 */         switch (c) {
/*     */           case '?':
/* 392 */             bool = true;
/*     */             
/* 394 */             stringBuffer.append('.');
/*     */             break;
/*     */           case '*':
/* 397 */             bool = true;
/*     */             
/* 399 */             stringBuffer.append(".*");
/*     */             break;
/*     */           case '~':
/* 402 */             if (b + 1 < i) {
/* 403 */               c = param1String.charAt(b + 1);
/* 404 */               switch (c) {
/*     */                 case '*':
/*     */                 case '?':
/* 407 */                   bool = true;
/* 408 */                   stringBuffer.append('[').append(c).append(']');
/* 409 */                   b++;
/*     */                   break;
/*     */               } 
/*     */             
/*     */             } 
/* 414 */             stringBuffer.append('~');
/*     */             break;
/*     */           
/*     */           case '$':
/*     */           case '(':
/*     */           case ')':
/*     */           case '.':
/*     */           case '[':
/*     */           case ']':
/*     */           case '^':
/* 424 */             stringBuffer.append("\\").append(c);
/*     */             break;
/*     */           default:
/* 427 */             stringBuffer.append(c); break;
/*     */         } 
/* 429 */       }  if (bool) {
/* 430 */         return Pattern.compile(stringBuffer.toString(), 2);
/*     */       }
/* 432 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/* 438 */     CountUtils.I_MatchPredicate i_MatchPredicate = createCriteriaPredicate(paramValueEval2, paramInt1, paramInt2);
/* 439 */     if (i_MatchPredicate == null)
/*     */     {
/* 441 */       return (ValueEval)NumberEval.ZERO;
/*     */     }
/* 443 */     double d = countMatchingCellsInArea(paramValueEval1, i_MatchPredicate);
/* 444 */     return (ValueEval)new NumberEval(d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double countMatchingCellsInArea(ValueEval paramValueEval, CountUtils.I_MatchPredicate paramI_MatchPredicate) {
/* 451 */     if (paramValueEval instanceof RefEval)
/* 452 */       return CountUtils.countMatchingCellsInRef((RefEval)paramValueEval, paramI_MatchPredicate); 
/* 453 */     if (paramValueEval instanceof ThreeDEval) {
/* 454 */       return CountUtils.countMatchingCellsInArea((ThreeDEval)paramValueEval, paramI_MatchPredicate);
/*     */     }
/* 456 */     throw new IllegalArgumentException("Bad range arg type (" + paramValueEval.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static CountUtils.I_MatchPredicate createCriteriaPredicate(ValueEval paramValueEval, int paramInt1, int paramInt2) {
/* 466 */     ValueEval valueEval = evaluateCriteriaArg(paramValueEval, paramInt1, paramInt2);
/*     */     
/* 468 */     if (valueEval instanceof NumberEval) {
/* 469 */       return new NumberMatcher(((NumberEval)valueEval).getNumberValue(), CmpOp.OP_NONE);
/*     */     }
/* 471 */     if (valueEval instanceof BoolEval) {
/* 472 */       return new BooleanMatcher(((BoolEval)valueEval).getBooleanValue(), CmpOp.OP_NONE);
/*     */     }
/*     */     
/* 475 */     if (valueEval instanceof StringEval) {
/* 476 */       return createGeneralMatchPredicate((StringEval)valueEval);
/*     */     }
/* 478 */     if (valueEval instanceof ErrorEval) {
/* 479 */       return new ErrorMatcher(((ErrorEval)valueEval).getErrorCode(), CmpOp.OP_NONE);
/*     */     }
/* 481 */     if (valueEval == BlankEval.instance) {
/* 482 */       return null;
/*     */     }
/* 484 */     throw new RuntimeException("Unexpected type for criteria (" + valueEval.getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ValueEval evaluateCriteriaArg(ValueEval paramValueEval, int paramInt1, int paramInt2) {
/*     */     try {
/* 494 */       return OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 495 */     } catch (EvaluationException evaluationException) {
/* 496 */       return (ValueEval)evaluationException.getErrorEval();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static CountUtils.I_MatchPredicate createGeneralMatchPredicate(StringEval paramStringEval) {
/* 503 */     String str = paramStringEval.getStringValue();
/* 504 */     CmpOp cmpOp = CmpOp.getOperator(str);
/* 505 */     str = str.substring(cmpOp.getLength());
/*     */     
/* 507 */     Boolean bool = parseBoolean(str);
/* 508 */     if (bool != null) {
/* 509 */       return new BooleanMatcher(bool.booleanValue(), cmpOp);
/*     */     }
/*     */     
/* 512 */     Double double_ = OperandResolver.parseDouble(str);
/* 513 */     if (double_ != null) {
/* 514 */       return new NumberMatcher(double_.doubleValue(), cmpOp);
/*     */     }
/* 516 */     ErrorEval errorEval = parseError(str);
/* 517 */     if (errorEval != null) {
/* 518 */       return new ErrorMatcher(errorEval.getErrorCode(), cmpOp);
/*     */     }
/*     */ 
/*     */     
/* 522 */     return new StringMatcher(str, cmpOp);
/*     */   }
/*     */   private static ErrorEval parseError(String paramString) {
/* 525 */     if (paramString.length() < 4 || paramString.charAt(0) != '#') {
/* 526 */       return null;
/*     */     }
/* 528 */     if (paramString.equals("#NULL!")) return ErrorEval.NULL_INTERSECTION; 
/* 529 */     if (paramString.equals("#DIV/0!")) return ErrorEval.DIV_ZERO; 
/* 530 */     if (paramString.equals("#VALUE!")) return ErrorEval.VALUE_INVALID; 
/* 531 */     if (paramString.equals("#REF!")) return ErrorEval.REF_INVALID; 
/* 532 */     if (paramString.equals("#NAME?")) return ErrorEval.NAME_INVALID; 
/* 533 */     if (paramString.equals("#NUM!")) return ErrorEval.NUM_ERROR; 
/* 534 */     if (paramString.equals("#N/A")) return ErrorEval.NA;
/*     */     
/* 536 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Boolean parseBoolean(String paramString) {
/* 543 */     if (paramString.length() < 1) {
/* 544 */       return null;
/*     */     }
/* 546 */     switch (paramString.charAt(0)) {
/*     */       case 'T':
/*     */       case 't':
/* 549 */         if ("TRUE".equalsIgnoreCase(paramString)) {
/* 550 */           return Boolean.TRUE;
/*     */         }
/*     */         break;
/*     */       case 'F':
/*     */       case 'f':
/* 555 */         if ("FALSE".equalsIgnoreCase(paramString)) {
/* 556 */           return Boolean.FALSE;
/*     */         }
/*     */         break;
/*     */     } 
/* 560 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Countif.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */