/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.DataValidation;
/*     */ import org.apache.poi.ss.usermodel.DataValidationConstraint;
/*     */ import org.apache.poi.ss.usermodel.DataValidationHelper;
/*     */ import org.apache.poi.ss.util.CellRangeAddressList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFDataValidationHelper
/*     */   implements DataValidationHelper
/*     */ {
/*     */   public HSSFDataValidationHelper(HSSFSheet paramHSSFSheet) {}
/*     */   
/*     */   public DataValidationConstraint createDateConstraint(int paramInt, String paramString1, String paramString2, String paramString3) {
/*  47 */     return DVConstraint.createDateConstraint(paramInt, paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createExplicitListConstraint(String[] paramArrayOfString) {
/*  58 */     return DVConstraint.createExplicitListConstraint(paramArrayOfString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createFormulaListConstraint(String paramString) {
/*  69 */     return DVConstraint.createFormulaListConstraint(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createNumericConstraint(int paramInt1, int paramInt2, String paramString1, String paramString2) {
/*  75 */     return DVConstraint.createNumericConstraint(paramInt1, paramInt2, paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public DataValidationConstraint createIntegerConstraint(int paramInt, String paramString1, String paramString2) {
/*  79 */     return DVConstraint.createNumericConstraint(1, paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createDecimalConstraint(int paramInt, String paramString1, String paramString2) {
/*  90 */     return DVConstraint.createNumericConstraint(2, paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createTextLengthConstraint(int paramInt, String paramString1, String paramString2) {
/* 101 */     return DVConstraint.createNumericConstraint(6, paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createTimeConstraint(int paramInt, String paramString1, String paramString2) {
/* 112 */     return DVConstraint.createTimeConstraint(paramInt, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint createCustomConstraint(String paramString) {
/* 118 */     return DVConstraint.createCustomFormulaConstraint(paramString);
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
/*     */   public DataValidation createValidation(DataValidationConstraint paramDataValidationConstraint, CellRangeAddressList paramCellRangeAddressList) {
/* 130 */     return new HSSFDataValidation(paramCellRangeAddressList, paramDataValidationConstraint);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFDataValidationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */