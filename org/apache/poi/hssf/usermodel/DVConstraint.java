/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*     */ import org.apache.poi.hssf.record.DVRecord;
/*     */ import org.apache.poi.ss.formula.FormulaRenderer;
/*     */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*     */ import org.apache.poi.ss.formula.FormulaType;
/*     */ import org.apache.poi.ss.formula.ptg.NumberPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.StringPtg;
/*     */ import org.apache.poi.ss.usermodel.DataValidationConstraint;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DVConstraint
/*     */   implements DataValidationConstraint
/*     */ {
/*     */   private final int _validationType;
/*     */   private int _operator;
/*     */   private String[] _explicitListValues;
/*     */   private String _formula1;
/*     */   private String _formula2;
/*     */   private Double _value1;
/*     */   private Double _value2;
/*     */   
/*     */   static final class FormulaPair
/*     */   {
/*     */     private final Ptg[] _formula1;
/*     */     private final Ptg[] _formula2;
/*     */     
/*     */     FormulaPair(Ptg[] param1ArrayOfPtg1, Ptg[] param1ArrayOfPtg2) {
/*  46 */       this._formula1 = (param1ArrayOfPtg1 == null) ? null : (Ptg[])param1ArrayOfPtg1.clone();
/*  47 */       this._formula2 = (param1ArrayOfPtg2 == null) ? null : (Ptg[])param1ArrayOfPtg2.clone();
/*     */     }
/*     */     public Ptg[] getFormula1() {
/*  50 */       return this._formula1;
/*     */     }
/*     */     public Ptg[] getFormula2() {
/*  53 */       return this._formula2;
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
/*     */   private DVConstraint(int paramInt1, int paramInt2, String paramString1, String paramString2, Double paramDouble1, Double paramDouble2, String[] paramArrayOfString) {
/*  70 */     this._validationType = paramInt1;
/*  71 */     this._operator = paramInt2;
/*  72 */     this._formula1 = paramString1;
/*  73 */     this._formula2 = paramString2;
/*  74 */     this._value1 = paramDouble1;
/*  75 */     this._value2 = paramDouble2;
/*  76 */     this._explicitListValues = (paramArrayOfString == null) ? null : (String[])paramArrayOfString.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DVConstraint(String paramString, String[] paramArrayOfString) {
/*  84 */     this(3, 0, paramString, null, null, null, paramArrayOfString);
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
/*     */   public static DVConstraint createNumericConstraint(int paramInt1, int paramInt2, String paramString1, String paramString2) {
/* 103 */     switch (paramInt1) {
/*     */       case 0:
/* 105 */         if (paramString1 != null || paramString2 != null) {
/* 106 */           throw new IllegalArgumentException("expr1 and expr2 must be null for validation type 'any'");
/*     */         }
/*     */         break;
/*     */       case 1:
/*     */       case 2:
/*     */       case 6:
/* 112 */         if (paramString1 == null) {
/* 113 */           throw new IllegalArgumentException("expr1 must be supplied");
/*     */         }
/* 115 */         DataValidationConstraint.OperatorType.validateSecondArg(paramInt2, paramString2);
/*     */         break;
/*     */       default:
/* 118 */         throw new IllegalArgumentException("Validation Type (" + paramInt1 + ") not supported with this method");
/*     */     } 
/*     */ 
/*     */     
/* 122 */     String str1 = getFormulaFromTextExpression(paramString1);
/* 123 */     Double double_1 = (str1 == null) ? convertNumber(paramString1) : null;
/*     */     
/* 125 */     String str2 = getFormulaFromTextExpression(paramString2);
/* 126 */     Double double_2 = (str2 == null) ? convertNumber(paramString2) : null;
/* 127 */     return new DVConstraint(paramInt1, paramInt2, str1, str2, double_1, double_2, null);
/*     */   }
/*     */   
/*     */   public static DVConstraint createFormulaListConstraint(String paramString) {
/* 131 */     return new DVConstraint(paramString, null);
/*     */   }
/*     */   public static DVConstraint createExplicitListConstraint(String[] paramArrayOfString) {
/* 134 */     return new DVConstraint(null, paramArrayOfString);
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
/*     */   public static DVConstraint createTimeConstraint(int paramInt, String paramString1, String paramString2) {
/* 150 */     if (paramString1 == null) {
/* 151 */       throw new IllegalArgumentException("expr1 must be supplied");
/*     */     }
/* 153 */     DataValidationConstraint.OperatorType.validateSecondArg(paramInt, paramString1);
/*     */ 
/*     */     
/* 156 */     String str1 = getFormulaFromTextExpression(paramString1);
/* 157 */     Double double_1 = (str1 == null) ? convertTime(paramString1) : null;
/*     */     
/* 159 */     String str2 = getFormulaFromTextExpression(paramString2);
/* 160 */     Double double_2 = (str2 == null) ? convertTime(paramString2) : null;
/* 161 */     return new DVConstraint(5, paramInt, str1, str2, double_1, double_2, null);
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
/*     */   public static DVConstraint createDateConstraint(int paramInt, String paramString1, String paramString2, String paramString3) {
/* 179 */     if (paramString1 == null) {
/* 180 */       throw new IllegalArgumentException("expr1 must be supplied");
/*     */     }
/* 182 */     DataValidationConstraint.OperatorType.validateSecondArg(paramInt, paramString2);
/* 183 */     SimpleDateFormat simpleDateFormat = null;
/* 184 */     if (paramString3 != null) {
/* 185 */       simpleDateFormat = new SimpleDateFormat(paramString3, LocaleUtil.getUserLocale());
/* 186 */       simpleDateFormat.setTimeZone(LocaleUtil.getUserTimeZone());
/*     */     } 
/*     */ 
/*     */     
/* 190 */     String str1 = getFormulaFromTextExpression(paramString1);
/* 191 */     Double double_1 = (str1 == null) ? convertDate(paramString1, simpleDateFormat) : null;
/*     */     
/* 193 */     String str2 = getFormulaFromTextExpression(paramString2);
/* 194 */     Double double_2 = (str2 == null) ? convertDate(paramString2, simpleDateFormat) : null;
/* 195 */     return new DVConstraint(4, paramInt, str1, str2, double_1, double_2, null);
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
/*     */   private static String getFormulaFromTextExpression(String paramString) {
/* 210 */     if (paramString == null) {
/* 211 */       return null;
/*     */     }
/* 213 */     if (paramString.length() < 1) {
/* 214 */       throw new IllegalArgumentException("Empty string is not a valid formula/value expression");
/*     */     }
/* 216 */     if (paramString.charAt(0) == '=') {
/* 217 */       return paramString.substring(1);
/*     */     }
/* 219 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Double convertNumber(String paramString) {
/* 227 */     if (paramString == null) {
/* 228 */       return null;
/*     */     }
/*     */     try {
/* 231 */       return new Double(paramString);
/* 232 */     } catch (NumberFormatException numberFormatException) {
/* 233 */       throw new RuntimeException("The supplied text '" + paramString + "' could not be parsed as a number");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Double convertTime(String paramString) {
/* 242 */     if (paramString == null) {
/* 243 */       return null;
/*     */     }
/* 245 */     return new Double(HSSFDateUtil.convertTime(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Double convertDate(String paramString, SimpleDateFormat paramSimpleDateFormat) {
/*     */     Date date;
/* 252 */     if (paramString == null) {
/* 253 */       return null;
/*     */     }
/*     */     
/* 256 */     if (paramSimpleDateFormat == null) {
/* 257 */       date = HSSFDateUtil.parseYYYYMMDDDate(paramString);
/*     */     } else {
/*     */       try {
/* 260 */         date = paramSimpleDateFormat.parse(paramString);
/* 261 */       } catch (ParseException parseException) {
/* 262 */         throw new RuntimeException("Failed to parse date '" + paramString + "' using specified format '" + paramSimpleDateFormat + "'", parseException);
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     return new Double(HSSFDateUtil.getExcelDate(date));
/*     */   }
/*     */   
/*     */   public static DVConstraint createCustomFormulaConstraint(String paramString) {
/* 270 */     if (paramString == null) {
/* 271 */       throw new IllegalArgumentException("formula must be supplied");
/*     */     }
/* 273 */     return new DVConstraint(7, 0, paramString, null, null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValidationType() {
/* 280 */     return this._validationType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isListValidationType() {
/* 287 */     return (this._validationType == 3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExplicitList() {
/* 294 */     return (this._validationType == 3 && this._explicitListValues != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOperator() {
/* 300 */     return this._operator;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOperator(int paramInt) {
/* 306 */     this._operator = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getExplicitListValues() {
/* 313 */     return this._explicitListValues;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setExplicitListValues(String[] paramArrayOfString) {
/* 319 */     if (this._validationType != 3) {
/* 320 */       throw new RuntimeException("Cannot setExplicitListValues on non-list constraint");
/*     */     }
/* 322 */     this._formula1 = null;
/* 323 */     this._explicitListValues = paramArrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormula1() {
/* 330 */     return this._formula1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormula1(String paramString) {
/* 336 */     this._value1 = null;
/* 337 */     this._explicitListValues = null;
/* 338 */     this._formula1 = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormula2() {
/* 345 */     return this._formula2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormula2(String paramString) {
/* 351 */     this._value2 = null;
/* 352 */     this._formula2 = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getValue1() {
/* 359 */     return this._value1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue1(double paramDouble) {
/* 365 */     this._formula1 = null;
/* 366 */     this._value1 = new Double(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Double getValue2() {
/* 373 */     return this._value2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValue2(double paramDouble) {
/* 379 */     this._formula2 = null;
/* 380 */     this._value2 = new Double(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FormulaPair createFormulas(HSSFSheet paramHSSFSheet) {
/*     */     Ptg[] arrayOfPtg1;
/*     */     Ptg[] arrayOfPtg2;
/* 389 */     if (isListValidationType()) {
/* 390 */       arrayOfPtg1 = createListFormula(paramHSSFSheet);
/* 391 */       arrayOfPtg2 = Ptg.EMPTY_PTG_ARRAY;
/*     */     } else {
/* 393 */       arrayOfPtg1 = convertDoubleFormula(this._formula1, this._value1, paramHSSFSheet);
/* 394 */       arrayOfPtg2 = convertDoubleFormula(this._formula2, this._value2, paramHSSFSheet);
/*     */     } 
/* 396 */     return new FormulaPair(arrayOfPtg1, arrayOfPtg2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Ptg[] createListFormula(HSSFSheet paramHSSFSheet) {
/* 402 */     if (this._explicitListValues == null) {
/* 403 */       HSSFWorkbook hSSFWorkbook = paramHSSFSheet.getWorkbook();
/*     */       
/* 405 */       return HSSFFormulaParser.parse(this._formula1, hSSFWorkbook, FormulaType.DATAVALIDATION_LIST, hSSFWorkbook.getSheetIndex(paramHSSFSheet));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 410 */     StringBuffer stringBuffer = new StringBuffer(this._explicitListValues.length * 16);
/* 411 */     for (byte b = 0; b < this._explicitListValues.length; b++) {
/* 412 */       if (b > 0) {
/* 413 */         stringBuffer.append(false);
/*     */       }
/* 415 */       stringBuffer.append(this._explicitListValues[b]);
/*     */     } 
/*     */     
/* 418 */     return new Ptg[] { (Ptg)new StringPtg(stringBuffer.toString()) };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Ptg[] convertDoubleFormula(String paramString, Double paramDouble, HSSFSheet paramHSSFSheet) {
/* 427 */     if (paramString == null) {
/* 428 */       if (paramDouble == null) {
/* 429 */         return Ptg.EMPTY_PTG_ARRAY;
/*     */       }
/* 431 */       return new Ptg[] { (Ptg)new NumberPtg(paramDouble.doubleValue()) };
/*     */     } 
/* 433 */     if (paramDouble != null) {
/* 434 */       throw new IllegalStateException("Both formula and value cannot be present");
/*     */     }
/* 436 */     HSSFWorkbook hSSFWorkbook = paramHSSFSheet.getWorkbook();
/* 437 */     return HSSFFormulaParser.parse(paramString, hSSFWorkbook, FormulaType.CELL, hSSFWorkbook.getSheetIndex(paramHSSFSheet)); } static DVConstraint createDVConstraint(DVRecord paramDVRecord, FormulaRenderingWorkbook paramFormulaRenderingWorkbook) {
/*     */     FormulaValuePair formulaValuePair1;
/*     */     FormulaValuePair formulaValuePair2;
/*     */     String str;
/* 441 */     switch (paramDVRecord.getDataType()) {
/*     */       case 0:
/* 443 */         return new DVConstraint(0, paramDVRecord.getConditionOperator(), null, null, null, null, null);
/*     */       case 1:
/*     */       case 2:
/*     */       case 4:
/*     */       case 5:
/*     */       case 6:
/* 449 */         formulaValuePair1 = toFormulaString(paramDVRecord.getFormula1(), paramFormulaRenderingWorkbook);
/* 450 */         formulaValuePair2 = toFormulaString(paramDVRecord.getFormula2(), paramFormulaRenderingWorkbook);
/* 451 */         return new DVConstraint(paramDVRecord.getDataType(), paramDVRecord.getConditionOperator(), formulaValuePair1.formula(), formulaValuePair2.formula(), formulaValuePair1.value(), formulaValuePair2.value(), null);
/*     */       
/*     */       case 3:
/* 454 */         if (paramDVRecord.getListExplicitFormula()) {
/* 455 */           String str1 = toFormulaString(paramDVRecord.getFormula1(), paramFormulaRenderingWorkbook).string();
/* 456 */           if (str1.startsWith("\"")) {
/* 457 */             str1 = str1.substring(1);
/*     */           }
/* 459 */           if (str1.endsWith("\"")) {
/* 460 */             str1 = str1.substring(0, str1.length() - 1);
/*     */           }
/* 462 */           String[] arrayOfString = str1.split(Pattern.quote("\000"));
/* 463 */           return createExplicitListConstraint(arrayOfString);
/*     */         } 
/* 465 */         str = toFormulaString(paramDVRecord.getFormula1(), paramFormulaRenderingWorkbook).string();
/* 466 */         return createFormulaListConstraint(str);
/*     */       
/*     */       case 7:
/* 469 */         return createCustomFormulaConstraint(toFormulaString(paramDVRecord.getFormula1(), paramFormulaRenderingWorkbook).string());
/*     */     } 
/* 471 */     throw new UnsupportedOperationException("validationType=" + paramDVRecord.getDataType());
/*     */   }
/*     */   
/*     */   private static class FormulaValuePair { private String _formula;
/*     */     private String _value;
/*     */     
/*     */     private FormulaValuePair() {}
/*     */     
/*     */     public String formula() {
/* 480 */       return this._formula;
/*     */     }
/*     */     
/*     */     public Double value() {
/* 484 */       if (this._value == null) {
/* 485 */         return null;
/*     */       }
/* 487 */       return new Double(this._value);
/*     */     }
/*     */     
/*     */     public String string() {
/* 491 */       if (this._formula != null) {
/* 492 */         return this._formula;
/*     */       }
/* 494 */       if (this._value != null) {
/* 495 */         return this._value;
/*     */       }
/* 497 */       return null;
/*     */     } }
/*     */ 
/*     */   
/*     */   private static FormulaValuePair toFormulaString(Ptg[] paramArrayOfPtg, FormulaRenderingWorkbook paramFormulaRenderingWorkbook) {
/* 502 */     FormulaValuePair formulaValuePair = new FormulaValuePair();
/* 503 */     if (paramArrayOfPtg != null && paramArrayOfPtg.length > 0) {
/* 504 */       String str = FormulaRenderer.toFormulaString(paramFormulaRenderingWorkbook, paramArrayOfPtg);
/* 505 */       if (paramArrayOfPtg.length == 1 && paramArrayOfPtg[0].getClass() == NumberPtg.class) {
/* 506 */         formulaValuePair._value = str;
/*     */       } else {
/* 508 */         formulaValuePair._formula = str;
/*     */       } 
/*     */     } 
/* 511 */     return formulaValuePair;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\DVConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */