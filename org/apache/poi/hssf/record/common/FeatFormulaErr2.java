/*     */ package org.apache.poi.hssf.record.common;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FeatFormulaErr2
/*     */   implements SharedFeature
/*     */ {
/*  39 */   private static final BitField CHECK_CALCULATION_ERRORS = BitFieldFactory.getInstance(1);
/*  40 */   private static final BitField CHECK_EMPTY_CELL_REF = BitFieldFactory.getInstance(2);
/*  41 */   private static final BitField CHECK_NUMBERS_AS_TEXT = BitFieldFactory.getInstance(4);
/*  42 */   private static final BitField CHECK_INCONSISTENT_RANGES = BitFieldFactory.getInstance(8);
/*  43 */   private static final BitField CHECK_INCONSISTENT_FORMULAS = BitFieldFactory.getInstance(16);
/*  44 */   private static final BitField CHECK_DATETIME_FORMATS = BitFieldFactory.getInstance(32);
/*  45 */   private static final BitField CHECK_UNPROTECTED_FORMULAS = BitFieldFactory.getInstance(64);
/*  46 */   private static final BitField PERFORM_DATA_VALIDATION = BitFieldFactory.getInstance(128);
/*     */ 
/*     */   
/*     */   private int errorCheck;
/*     */ 
/*     */ 
/*     */   
/*     */   public FeatFormulaErr2() {}
/*     */ 
/*     */   
/*     */   public FeatFormulaErr2(RecordInputStream paramRecordInputStream) {
/*  57 */     this.errorCheck = paramRecordInputStream.readInt();
/*     */   }
/*     */   
/*     */   public String toString() {
/*  61 */     StringBuffer stringBuffer = new StringBuffer();
/*  62 */     stringBuffer.append(" [FEATURE FORMULA ERRORS]\n");
/*  63 */     stringBuffer.append("  checkCalculationErrors    = ");
/*  64 */     stringBuffer.append("  checkEmptyCellRef         = ");
/*  65 */     stringBuffer.append("  checkNumbersAsText        = ");
/*  66 */     stringBuffer.append("  checkInconsistentRanges   = ");
/*  67 */     stringBuffer.append("  checkInconsistentFormulas = ");
/*  68 */     stringBuffer.append("  checkDateTimeFormats      = ");
/*  69 */     stringBuffer.append("  checkUnprotectedFormulas  = ");
/*  70 */     stringBuffer.append("  performDataValidation     = ");
/*  71 */     stringBuffer.append(" [/FEATURE FORMULA ERRORS]\n");
/*  72 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  76 */     paramLittleEndianOutput.writeInt(this.errorCheck);
/*     */   }
/*     */   
/*     */   public int getDataSize() {
/*  80 */     return 4;
/*     */   }
/*     */   
/*     */   public int _getRawErrorCheckValue() {
/*  84 */     return this.errorCheck;
/*     */   }
/*     */   
/*     */   public boolean getCheckCalculationErrors() {
/*  88 */     return CHECK_CALCULATION_ERRORS.isSet(this.errorCheck);
/*     */   }
/*     */   public void setCheckCalculationErrors(boolean paramBoolean) {
/*  91 */     this.errorCheck = CHECK_CALCULATION_ERRORS.setBoolean(this.errorCheck, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean getCheckEmptyCellRef() {
/*  95 */     return CHECK_EMPTY_CELL_REF.isSet(this.errorCheck);
/*     */   }
/*     */   public void setCheckEmptyCellRef(boolean paramBoolean) {
/*  98 */     this.errorCheck = CHECK_EMPTY_CELL_REF.setBoolean(this.errorCheck, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean getCheckNumbersAsText() {
/* 102 */     return CHECK_NUMBERS_AS_TEXT.isSet(this.errorCheck);
/*     */   }
/*     */   public void setCheckNumbersAsText(boolean paramBoolean) {
/* 105 */     this.errorCheck = CHECK_NUMBERS_AS_TEXT.setBoolean(this.errorCheck, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean getCheckInconsistentRanges() {
/* 109 */     return CHECK_INCONSISTENT_RANGES.isSet(this.errorCheck);
/*     */   }
/*     */   public void setCheckInconsistentRanges(boolean paramBoolean) {
/* 112 */     this.errorCheck = CHECK_INCONSISTENT_RANGES.setBoolean(this.errorCheck, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean getCheckInconsistentFormulas() {
/* 116 */     return CHECK_INCONSISTENT_FORMULAS.isSet(this.errorCheck);
/*     */   }
/*     */   public void setCheckInconsistentFormulas(boolean paramBoolean) {
/* 119 */     this.errorCheck = CHECK_INCONSISTENT_FORMULAS.setBoolean(this.errorCheck, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean getCheckDateTimeFormats() {
/* 123 */     return CHECK_DATETIME_FORMATS.isSet(this.errorCheck);
/*     */   }
/*     */   public void setCheckDateTimeFormats(boolean paramBoolean) {
/* 126 */     this.errorCheck = CHECK_DATETIME_FORMATS.setBoolean(this.errorCheck, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean getCheckUnprotectedFormulas() {
/* 130 */     return CHECK_UNPROTECTED_FORMULAS.isSet(this.errorCheck);
/*     */   }
/*     */   public void setCheckUnprotectedFormulas(boolean paramBoolean) {
/* 133 */     this.errorCheck = CHECK_UNPROTECTED_FORMULAS.setBoolean(this.errorCheck, paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean getPerformDataValidation() {
/* 137 */     return PERFORM_DATA_VALIDATION.isSet(this.errorCheck);
/*     */   }
/*     */   public void setPerformDataValidation(boolean paramBoolean) {
/* 140 */     this.errorCheck = PERFORM_DATA_VALIDATION.setBoolean(this.errorCheck, paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\common\FeatFormulaErr2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */