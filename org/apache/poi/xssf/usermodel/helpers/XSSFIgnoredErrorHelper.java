/*     */ package org.apache.poi.xssf.usermodel.helpers;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ import org.apache.poi.ss.usermodel.IgnoredErrorType;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIgnoredError;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFIgnoredErrorHelper
/*     */ {
/*     */   public static boolean isSet(IgnoredErrorType paramIgnoredErrorType, CTIgnoredError paramCTIgnoredError) {
/*  32 */     switch (paramIgnoredErrorType) {
/*     */       case CALCULATED_COLUMN:
/*  34 */         return paramCTIgnoredError.isSetCalculatedColumn();
/*     */       case EMPTY_CELL_REFERENCE:
/*  36 */         return paramCTIgnoredError.isSetEmptyCellReference();
/*     */       case EVALUATION_ERROR:
/*  38 */         return paramCTIgnoredError.isSetEvalError();
/*     */       case FORMULA:
/*  40 */         return paramCTIgnoredError.isSetFormula();
/*     */       case FORMULA_RANGE:
/*  42 */         return paramCTIgnoredError.isSetFormulaRange();
/*     */       case LIST_DATA_VALIDATION:
/*  44 */         return paramCTIgnoredError.isSetListDataValidation();
/*     */       case NUMBER_STORED_AS_TEXT:
/*  46 */         return paramCTIgnoredError.isSetNumberStoredAsText();
/*     */       case TWO_DIGIT_TEXT_YEAR:
/*  48 */         return paramCTIgnoredError.isSetTwoDigitTextYear();
/*     */       case UNLOCKED_FORMULA:
/*  50 */         return paramCTIgnoredError.isSetUnlockedFormula();
/*     */     } 
/*  52 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void set(IgnoredErrorType paramIgnoredErrorType, CTIgnoredError paramCTIgnoredError) {
/*  57 */     switch (paramIgnoredErrorType) {
/*     */       case CALCULATED_COLUMN:
/*  59 */         paramCTIgnoredError.setCalculatedColumn(true);
/*     */         return;
/*     */       case EMPTY_CELL_REFERENCE:
/*  62 */         paramCTIgnoredError.setEmptyCellReference(true);
/*     */         return;
/*     */       case EVALUATION_ERROR:
/*  65 */         paramCTIgnoredError.setEvalError(true);
/*     */         return;
/*     */       case FORMULA:
/*  68 */         paramCTIgnoredError.setFormula(true);
/*     */         return;
/*     */       case FORMULA_RANGE:
/*  71 */         paramCTIgnoredError.setFormulaRange(true);
/*     */         return;
/*     */       case LIST_DATA_VALIDATION:
/*  74 */         paramCTIgnoredError.setListDataValidation(true);
/*     */         return;
/*     */       case NUMBER_STORED_AS_TEXT:
/*  77 */         paramCTIgnoredError.setNumberStoredAsText(true);
/*     */         return;
/*     */       case TWO_DIGIT_TEXT_YEAR:
/*  80 */         paramCTIgnoredError.setTwoDigitTextYear(true);
/*     */         return;
/*     */       case UNLOCKED_FORMULA:
/*  83 */         paramCTIgnoredError.setUnlockedFormula(true);
/*     */         return;
/*     */     } 
/*  86 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addIgnoredErrors(CTIgnoredError paramCTIgnoredError, String paramString, IgnoredErrorType... paramVarArgs) {
/*  91 */     paramCTIgnoredError.setSqref(Arrays.asList(new String[] { paramString }));
/*  92 */     for (IgnoredErrorType ignoredErrorType : paramVarArgs) {
/*  93 */       set(ignoredErrorType, paramCTIgnoredError);
/*     */     }
/*     */   }
/*     */   
/*     */   public static Set<IgnoredErrorType> getErrorTypes(CTIgnoredError paramCTIgnoredError) {
/*  98 */     LinkedHashSet<IgnoredErrorType> linkedHashSet = new LinkedHashSet();
/*  99 */     for (IgnoredErrorType ignoredErrorType : IgnoredErrorType.values()) {
/* 100 */       if (isSet(ignoredErrorType, paramCTIgnoredError)) {
/* 101 */         linkedHashSet.add(ignoredErrorType);
/*     */       }
/*     */     } 
/* 104 */     return linkedHashSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\XSSFIgnoredErrorHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */