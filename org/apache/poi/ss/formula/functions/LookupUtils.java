/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.ss.formula.TwoDEval;
/*     */ import org.apache.poi.ss.formula.eval.BlankEval;
/*     */ import org.apache.poi.ss.formula.eval.BoolEval;
/*     */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*     */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*     */ import org.apache.poi.ss.formula.eval.NumberEval;
/*     */ import org.apache.poi.ss.formula.eval.NumericValueEval;
/*     */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*     */ import org.apache.poi.ss.formula.eval.RefEval;
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
/*     */ final class LookupUtils
/*     */ {
/*     */   public static interface ValueVector
/*     */   {
/*     */     ValueEval getItem(int param1Int);
/*     */     
/*     */     int getSize();
/*     */   }
/*     */   
/*     */   private static final class RowVector
/*     */     implements ValueVector
/*     */   {
/*     */     private final TwoDEval _tableArray;
/*     */     private final int _size;
/*     */     private final int _rowIndex;
/*     */     
/*     */     public RowVector(TwoDEval param1TwoDEval, int param1Int) {
/*  56 */       this._rowIndex = param1Int;
/*  57 */       int i = param1TwoDEval.getHeight() - 1;
/*  58 */       if (param1Int < 0 || param1Int > i) {
/*  59 */         throw new IllegalArgumentException("Specified row index (" + param1Int + ") is outside the allowed range (0.." + i + ")");
/*     */       }
/*     */       
/*  62 */       this._tableArray = param1TwoDEval;
/*  63 */       this._size = param1TwoDEval.getWidth();
/*     */     }
/*     */     
/*     */     public ValueEval getItem(int param1Int) {
/*  67 */       if (param1Int > this._size) {
/*  68 */         throw new ArrayIndexOutOfBoundsException("Specified index (" + param1Int + ") is outside the allowed range (0.." + (this._size - 1) + ")");
/*     */       }
/*     */       
/*  71 */       return this._tableArray.getValue(this._rowIndex, param1Int);
/*     */     }
/*     */     public int getSize() {
/*  74 */       return this._size;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class ColumnVector
/*     */     implements ValueVector {
/*     */     private final TwoDEval _tableArray;
/*     */     private final int _size;
/*     */     private final int _columnIndex;
/*     */     
/*     */     public ColumnVector(TwoDEval param1TwoDEval, int param1Int) {
/*  85 */       this._columnIndex = param1Int;
/*  86 */       int i = param1TwoDEval.getWidth() - 1;
/*  87 */       if (param1Int < 0 || param1Int > i) {
/*  88 */         throw new IllegalArgumentException("Specified column index (" + param1Int + ") is outside the allowed range (0.." + i + ")");
/*     */       }
/*     */       
/*  91 */       this._tableArray = param1TwoDEval;
/*  92 */       this._size = this._tableArray.getHeight();
/*     */     }
/*     */     
/*     */     public ValueEval getItem(int param1Int) {
/*  96 */       if (param1Int > this._size) {
/*  97 */         throw new ArrayIndexOutOfBoundsException("Specified index (" + param1Int + ") is outside the allowed range (0.." + (this._size - 1) + ")");
/*     */       }
/*     */       
/* 100 */       return this._tableArray.getValue(param1Int, this._columnIndex);
/*     */     }
/*     */     public int getSize() {
/* 103 */       return this._size;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class SheetVector implements ValueVector {
/*     */     private final RefEval _re;
/*     */     private final int _size;
/*     */     
/*     */     public SheetVector(RefEval param1RefEval) {
/* 112 */       this._size = param1RefEval.getNumberOfSheets();
/* 113 */       this._re = param1RefEval;
/*     */     }
/*     */     
/*     */     public ValueEval getItem(int param1Int) {
/* 117 */       if (param1Int >= this._size) {
/* 118 */         throw new ArrayIndexOutOfBoundsException("Specified index (" + param1Int + ") is outside the allowed range (0.." + (this._size - 1) + ")");
/*     */       }
/*     */       
/* 121 */       int i = this._re.getFirstSheetIndex() + param1Int;
/* 122 */       return this._re.getInnerValueEval(i);
/*     */     }
/*     */     public int getSize() {
/* 125 */       return this._size;
/*     */     }
/*     */   }
/*     */   
/*     */   public static ValueVector createRowVector(TwoDEval paramTwoDEval, int paramInt) {
/* 130 */     return new RowVector(paramTwoDEval, paramInt);
/*     */   }
/*     */   public static ValueVector createColumnVector(TwoDEval paramTwoDEval, int paramInt) {
/* 133 */     return new ColumnVector(paramTwoDEval, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ValueVector createVector(TwoDEval paramTwoDEval) {
/* 139 */     if (paramTwoDEval.isColumn()) {
/* 140 */       return createColumnVector(paramTwoDEval, 0);
/*     */     }
/* 142 */     if (paramTwoDEval.isRow()) {
/* 143 */       return createRowVector(paramTwoDEval, 0);
/*     */     }
/* 145 */     return null;
/*     */   }
/*     */   
/*     */   public static ValueVector createVector(RefEval paramRefEval) {
/* 149 */     return new SheetVector(paramRefEval);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class CompareResult
/*     */   {
/*     */     private final boolean _isTypeMismatch;
/*     */ 
/*     */     
/*     */     private final boolean _isLessThan;
/*     */ 
/*     */     
/*     */     private final boolean _isEqual;
/*     */ 
/*     */     
/*     */     private final boolean _isGreaterThan;
/*     */ 
/*     */ 
/*     */     
/*     */     private CompareResult(boolean param1Boolean, int param1Int) {
/* 170 */       if (param1Boolean) {
/* 171 */         this._isTypeMismatch = true;
/* 172 */         this._isLessThan = false;
/* 173 */         this._isEqual = false;
/* 174 */         this._isGreaterThan = false;
/*     */       } else {
/* 176 */         this._isTypeMismatch = false;
/* 177 */         this._isLessThan = (param1Int < 0);
/* 178 */         this._isEqual = (param1Int == 0);
/* 179 */         this._isGreaterThan = (param1Int > 0);
/*     */       } 
/*     */     }
/* 182 */     public static final CompareResult TYPE_MISMATCH = new CompareResult(true, 0);
/* 183 */     public static final CompareResult LESS_THAN = new CompareResult(false, -1);
/* 184 */     public static final CompareResult EQUAL = new CompareResult(false, 0);
/* 185 */     public static final CompareResult GREATER_THAN = new CompareResult(false, 1);
/*     */     
/*     */     public static final CompareResult valueOf(int param1Int) {
/* 188 */       if (param1Int < 0) {
/* 189 */         return LESS_THAN;
/*     */       }
/* 191 */       if (param1Int > 0) {
/* 192 */         return GREATER_THAN;
/*     */       }
/* 194 */       return EQUAL;
/*     */     }
/*     */     
/*     */     public static final CompareResult valueOf(boolean param1Boolean) {
/* 198 */       if (param1Boolean) {
/* 199 */         return EQUAL;
/*     */       }
/* 201 */       return LESS_THAN;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isTypeMismatch() {
/* 206 */       return this._isTypeMismatch;
/*     */     }
/*     */     public boolean isLessThan() {
/* 209 */       return this._isLessThan;
/*     */     }
/*     */     public boolean isEqual() {
/* 212 */       return this._isEqual;
/*     */     }
/*     */     public boolean isGreaterThan() {
/* 215 */       return this._isGreaterThan;
/*     */     }
/*     */     public String toString() {
/* 218 */       StringBuffer stringBuffer = new StringBuffer(64);
/* 219 */       stringBuffer.append(getClass().getName()).append(" [");
/* 220 */       stringBuffer.append(formatAsString());
/* 221 */       stringBuffer.append("]");
/* 222 */       return stringBuffer.toString();
/*     */     }
/*     */     
/*     */     private String formatAsString() {
/* 226 */       if (this._isTypeMismatch) {
/* 227 */         return "TYPE_MISMATCH";
/*     */       }
/* 229 */       if (this._isLessThan) {
/* 230 */         return "LESS_THAN";
/*     */       }
/* 232 */       if (this._isEqual) {
/* 233 */         return "EQUAL";
/*     */       }
/* 235 */       if (this._isGreaterThan) {
/* 236 */         return "GREATER_THAN";
/*     */       }
/*     */       
/* 239 */       return "??error??";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface LookupValueComparer
/*     */   {
/*     */     LookupUtils.CompareResult compareTo(ValueEval param1ValueEval);
/*     */   }
/*     */   
/*     */   private static abstract class LookupValueComparerBase
/*     */     implements LookupValueComparer
/*     */   {
/*     */     private final Class<? extends ValueEval> _targetClass;
/*     */     
/*     */     protected LookupValueComparerBase(ValueEval param1ValueEval) {
/* 255 */       if (param1ValueEval == null) {
/* 256 */         throw new RuntimeException("targetValue cannot be null");
/*     */       }
/* 258 */       this._targetClass = (Class)param1ValueEval.getClass();
/*     */     }
/*     */     public final LookupUtils.CompareResult compareTo(ValueEval param1ValueEval) {
/* 261 */       if (param1ValueEval == null) {
/* 262 */         throw new RuntimeException("compare to value cannot be null");
/*     */       }
/* 264 */       if (this._targetClass != param1ValueEval.getClass()) {
/* 265 */         return LookupUtils.CompareResult.TYPE_MISMATCH;
/*     */       }
/* 267 */       return compareSameType(param1ValueEval);
/*     */     }
/*     */     public String toString() {
/* 270 */       StringBuffer stringBuffer = new StringBuffer(64);
/* 271 */       stringBuffer.append(getClass().getName()).append(" [");
/* 272 */       stringBuffer.append(getValueAsString());
/* 273 */       stringBuffer.append("]");
/* 274 */       return stringBuffer.toString();
/*     */     }
/*     */     
/*     */     protected abstract LookupUtils.CompareResult compareSameType(ValueEval param1ValueEval);
/*     */     
/*     */     protected abstract String getValueAsString();
/*     */   }
/*     */   
/*     */   private static final class StringLookupComparer
/*     */     extends LookupValueComparerBase {
/*     */     private String _value;
/*     */     private final Pattern _wildCardPattern;
/*     */     private boolean _matchExact;
/*     */     private boolean _isMatchFunction;
/*     */     
/*     */     protected StringLookupComparer(StringEval param1StringEval, boolean param1Boolean1, boolean param1Boolean2) {
/* 290 */       super((ValueEval)param1StringEval);
/* 291 */       this._value = param1StringEval.getStringValue();
/* 292 */       this._wildCardPattern = Countif.StringMatcher.getWildCardPattern(this._value);
/* 293 */       this._matchExact = param1Boolean1;
/* 294 */       this._isMatchFunction = param1Boolean2;
/*     */     }
/*     */     
/*     */     protected LookupUtils.CompareResult compareSameType(ValueEval param1ValueEval) {
/* 298 */       StringEval stringEval = (StringEval)param1ValueEval;
/*     */       
/* 300 */       String str = stringEval.getStringValue();
/* 301 */       if (this._wildCardPattern != null) {
/* 302 */         Matcher matcher = this._wildCardPattern.matcher(str);
/* 303 */         boolean bool = matcher.matches();
/*     */         
/* 305 */         if (this._isMatchFunction || !this._matchExact)
/*     */         {
/* 307 */           return LookupUtils.CompareResult.valueOf(bool);
/*     */         }
/*     */       } 
/*     */       
/* 311 */       return LookupUtils.CompareResult.valueOf(this._value.compareToIgnoreCase(str));
/*     */     }
/*     */     protected String getValueAsString() {
/* 314 */       return this._value;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class NumberLookupComparer extends LookupValueComparerBase { private double _value;
/*     */     
/*     */     protected NumberLookupComparer(NumberEval param1NumberEval) {
/* 321 */       super((ValueEval)param1NumberEval);
/* 322 */       this._value = param1NumberEval.getNumberValue();
/*     */     }
/*     */     protected LookupUtils.CompareResult compareSameType(ValueEval param1ValueEval) {
/* 325 */       NumberEval numberEval = (NumberEval)param1ValueEval;
/* 326 */       return LookupUtils.CompareResult.valueOf(Double.compare(this._value, numberEval.getNumberValue()));
/*     */     }
/*     */     protected String getValueAsString() {
/* 329 */       return String.valueOf(this._value);
/*     */     } }
/*     */   
/*     */   private static final class BooleanLookupComparer extends LookupValueComparerBase {
/*     */     private boolean _value;
/*     */     
/*     */     protected BooleanLookupComparer(BoolEval param1BoolEval) {
/* 336 */       super((ValueEval)param1BoolEval);
/* 337 */       this._value = param1BoolEval.getBooleanValue();
/*     */     }
/*     */     protected LookupUtils.CompareResult compareSameType(ValueEval param1ValueEval) {
/* 340 */       BoolEval boolEval = (BoolEval)param1ValueEval;
/* 341 */       boolean bool = boolEval.getBooleanValue();
/* 342 */       if (this._value == bool) {
/* 343 */         return LookupUtils.CompareResult.EQUAL;
/*     */       }
/*     */       
/* 346 */       if (this._value) {
/* 347 */         return LookupUtils.CompareResult.GREATER_THAN;
/*     */       }
/* 349 */       return LookupUtils.CompareResult.LESS_THAN;
/*     */     }
/*     */     protected String getValueAsString() {
/* 352 */       return String.valueOf(this._value);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int resolveRowOrColIndexArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/*     */     ValueEval valueEval;
/* 380 */     if (paramValueEval == null) {
/* 381 */       throw new IllegalArgumentException("argument must not be null");
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 386 */       valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, (short)paramInt2);
/* 387 */     } catch (EvaluationException evaluationException) {
/*     */       
/* 389 */       throw EvaluationException.invalidRef();
/*     */     } 
/*     */     
/* 392 */     if (valueEval instanceof StringEval) {
/* 393 */       StringEval stringEval = (StringEval)valueEval;
/* 394 */       String str = stringEval.getStringValue();
/* 395 */       Double double_ = OperandResolver.parseDouble(str);
/* 396 */       if (double_ == null)
/*     */       {
/* 398 */         throw EvaluationException.invalidRef();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 404 */     int i = OperandResolver.coerceValueToInt(valueEval);
/* 405 */     if (i < 1)
/*     */     {
/* 407 */       throw EvaluationException.invalidValue();
/*     */     }
/* 409 */     return i - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TwoDEval resolveTableArrayArg(ValueEval paramValueEval) throws EvaluationException {
/* 419 */     if (paramValueEval instanceof TwoDEval) {
/* 420 */       return (TwoDEval)paramValueEval;
/*     */     }
/*     */     
/* 423 */     if (paramValueEval instanceof RefEval) {
/* 424 */       RefEval refEval = (RefEval)paramValueEval;
/*     */ 
/*     */ 
/*     */       
/* 428 */       return (TwoDEval)refEval.offset(0, 0, 0, 0);
/*     */     } 
/* 430 */     throw EvaluationException.invalidValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean resolveRangeLookupArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 440 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 441 */     if (valueEval instanceof BlankEval)
/*     */     {
/*     */ 
/*     */       
/* 445 */       return false;
/*     */     }
/* 447 */     if (valueEval instanceof BoolEval) {
/*     */       
/* 449 */       BoolEval boolEval = (BoolEval)valueEval;
/* 450 */       return boolEval.getBooleanValue();
/*     */     } 
/*     */     
/* 453 */     if (valueEval instanceof StringEval) {
/* 454 */       String str = ((StringEval)valueEval).getStringValue();
/* 455 */       if (str.length() < 1)
/*     */       {
/*     */         
/* 458 */         throw EvaluationException.invalidValue();
/*     */       }
/*     */       
/* 461 */       Boolean bool = Countif.parseBoolean(str);
/* 462 */       if (bool != null)
/*     */       {
/* 464 */         return bool.booleanValue();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 469 */       throw EvaluationException.invalidValue();
/*     */     } 
/*     */ 
/*     */     
/* 473 */     if (valueEval instanceof NumericValueEval) {
/* 474 */       NumericValueEval numericValueEval = (NumericValueEval)valueEval;
/*     */       
/* 476 */       return (0.0D != numericValueEval.getNumberValue());
/*     */     } 
/* 478 */     throw new RuntimeException("Unexpected eval type (" + valueEval.getClass().getName() + ")");
/*     */   }
/*     */   public static int lookupIndexOfValue(ValueEval paramValueEval, ValueVector paramValueVector, boolean paramBoolean) throws EvaluationException {
/*     */     int i;
/* 482 */     LookupValueComparer lookupValueComparer = createLookupComparer(paramValueEval, paramBoolean, false);
/*     */     
/* 484 */     if (paramBoolean) {
/* 485 */       i = performBinarySearch(paramValueVector, lookupValueComparer);
/*     */     } else {
/* 487 */       i = lookupIndexOfExactValue(lookupValueComparer, paramValueVector);
/*     */     } 
/* 489 */     if (i < 0) {
/* 490 */       throw new EvaluationException(ErrorEval.NA);
/*     */     }
/* 492 */     return i;
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
/*     */   private static int lookupIndexOfExactValue(LookupValueComparer paramLookupValueComparer, ValueVector paramValueVector) {
/* 506 */     int i = paramValueVector.getSize();
/* 507 */     for (byte b = 0; b < i; b++) {
/* 508 */       if (paramLookupValueComparer.compareTo(paramValueVector.getItem(b)).isEqual()) {
/* 509 */         return b;
/*     */       }
/*     */     } 
/* 512 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class BinarySearchIndexes
/*     */   {
/*     */     private int _lowIx;
/*     */ 
/*     */     
/*     */     private int _highIx;
/*     */ 
/*     */     
/*     */     public BinarySearchIndexes(int param1Int) {
/* 526 */       this._lowIx = -1;
/* 527 */       this._highIx = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getMidIx() {
/* 534 */       int i = this._highIx - this._lowIx;
/* 535 */       if (i < 2) {
/* 536 */         return -1;
/*     */       }
/* 538 */       return this._lowIx + i / 2;
/*     */     }
/*     */     
/*     */     public int getLowIx() {
/* 542 */       return this._lowIx;
/*     */     }
/*     */     public int getHighIx() {
/* 545 */       return this._highIx;
/*     */     }
/*     */     public void narrowSearch(int param1Int, boolean param1Boolean) {
/* 548 */       if (param1Boolean) {
/* 549 */         this._highIx = param1Int;
/*     */       } else {
/* 551 */         this._lowIx = param1Int;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int performBinarySearch(ValueVector paramValueVector, LookupValueComparer paramLookupValueComparer) {
/* 561 */     BinarySearchIndexes binarySearchIndexes = new BinarySearchIndexes(paramValueVector.getSize());
/*     */     
/*     */     while (true) {
/* 564 */       int i = binarySearchIndexes.getMidIx();
/*     */       
/* 566 */       if (i < 0) {
/* 567 */         return binarySearchIndexes.getLowIx();
/*     */       }
/* 569 */       CompareResult compareResult = paramLookupValueComparer.compareTo(paramValueVector.getItem(i));
/* 570 */       if (compareResult.isTypeMismatch()) {
/* 571 */         int j = handleMidValueTypeMismatch(paramLookupValueComparer, paramValueVector, binarySearchIndexes, i);
/* 572 */         if (j < 0) {
/*     */           continue;
/*     */         }
/* 575 */         i = j;
/* 576 */         compareResult = paramLookupValueComparer.compareTo(paramValueVector.getItem(i));
/*     */       } 
/* 578 */       if (compareResult.isEqual()) {
/* 579 */         return findLastIndexInRunOfEqualValues(paramLookupValueComparer, paramValueVector, i, binarySearchIndexes.getHighIx());
/*     */       }
/* 581 */       binarySearchIndexes.narrowSearch(i, compareResult.isLessThan());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int handleMidValueTypeMismatch(LookupValueComparer paramLookupValueComparer, ValueVector paramValueVector, BinarySearchIndexes paramBinarySearchIndexes, int paramInt) {
/*     */     CompareResult compareResult;
/* 593 */     int i = paramInt;
/* 594 */     int j = paramBinarySearchIndexes.getHighIx();
/*     */     
/*     */     while (true) {
/* 597 */       i++;
/* 598 */       if (i == j) {
/*     */ 
/*     */         
/* 601 */         paramBinarySearchIndexes.narrowSearch(paramInt, true);
/* 602 */         return -1;
/*     */       } 
/* 604 */       compareResult = paramLookupValueComparer.compareTo(paramValueVector.getItem(i));
/* 605 */       if (compareResult.isLessThan() && i == j - 1) {
/*     */         
/* 607 */         paramBinarySearchIndexes.narrowSearch(paramInt, true);
/* 608 */         return -1;
/*     */       } 
/*     */ 
/*     */       
/* 612 */       if (compareResult.isTypeMismatch())
/*     */         continue; 
/*     */       break;
/*     */     } 
/* 616 */     if (compareResult.isEqual()) {
/* 617 */       return i;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 622 */     paramBinarySearchIndexes.narrowSearch(i, compareResult.isLessThan());
/* 623 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int findLastIndexInRunOfEqualValues(LookupValueComparer paramLookupValueComparer, ValueVector paramValueVector, int paramInt1, int paramInt2) {
/* 632 */     for (int i = paramInt1 + 1; i < paramInt2; i++) {
/* 633 */       if (!paramLookupValueComparer.compareTo(paramValueVector.getItem(i)).isEqual()) {
/* 634 */         return i - 1;
/*     */       }
/*     */     } 
/* 637 */     return paramInt2 - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static LookupValueComparer createLookupComparer(ValueEval paramValueEval, boolean paramBoolean1, boolean paramBoolean2) {
/* 642 */     if (paramValueEval == BlankEval.instance)
/*     */     {
/*     */ 
/*     */       
/* 646 */       return new NumberLookupComparer(NumberEval.ZERO);
/*     */     }
/* 648 */     if (paramValueEval instanceof StringEval)
/*     */     {
/* 650 */       return new StringLookupComparer((StringEval)paramValueEval, paramBoolean1, paramBoolean2);
/*     */     }
/* 652 */     if (paramValueEval instanceof NumberEval) {
/* 653 */       return new NumberLookupComparer((NumberEval)paramValueEval);
/*     */     }
/* 655 */     if (paramValueEval instanceof BoolEval) {
/* 656 */       return new BooleanLookupComparer((BoolEval)paramValueEval);
/*     */     }
/* 658 */     throw new IllegalArgumentException("Bad lookup value type (" + paramValueEval.getClass().getName() + ")");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\LookupUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */