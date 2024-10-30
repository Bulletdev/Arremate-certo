/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.DVRecord;
/*     */ import org.apache.poi.ss.usermodel.DataValidation;
/*     */ import org.apache.poi.ss.usermodel.DataValidationConstraint;
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
/*     */ public final class HSSFDataValidation
/*     */   implements DataValidation
/*     */ {
/*     */   private String _prompt_title;
/*     */   private String _prompt_text;
/*     */   private String _error_title;
/*     */   private String _error_text;
/*  36 */   private int _errorStyle = 0;
/*     */   
/*     */   private boolean _emptyCellAllowed = true;
/*     */   
/*     */   private boolean _suppress_dropdown_arrow = false;
/*     */   
/*     */   private boolean _showPromptBox = true;
/*     */   
/*     */   private boolean _showErrorBox = true;
/*     */   
/*     */   private CellRangeAddressList _regions;
/*     */   private DVConstraint _constraint;
/*     */   
/*     */   public HSSFDataValidation(CellRangeAddressList paramCellRangeAddressList, DataValidationConstraint paramDataValidationConstraint) {
/*  50 */     this._regions = paramCellRangeAddressList;
/*     */ 
/*     */     
/*  53 */     this._constraint = (DVConstraint)paramDataValidationConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint getValidationConstraint() {
/*  61 */     return this._constraint;
/*     */   }
/*     */   
/*     */   public DVConstraint getConstraint() {
/*  65 */     return this._constraint;
/*     */   }
/*     */   
/*     */   public CellRangeAddressList getRegions() {
/*  69 */     return this._regions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setErrorStyle(int paramInt) {
/*  77 */     this._errorStyle = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getErrorStyle() {
/*  84 */     return this._errorStyle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmptyCellAllowed(boolean paramBoolean) {
/*  91 */     this._emptyCellAllowed = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getEmptyCellAllowed() {
/*  98 */     return this._emptyCellAllowed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuppressDropDownArrow(boolean paramBoolean) {
/* 105 */     this._suppress_dropdown_arrow = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSuppressDropDownArrow() {
/* 112 */     if (this._constraint.getValidationType() == 3) {
/* 113 */       return this._suppress_dropdown_arrow;
/*     */     }
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowPromptBox(boolean paramBoolean) {
/* 122 */     this._showPromptBox = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getShowPromptBox() {
/* 129 */     return this._showPromptBox;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowErrorBox(boolean paramBoolean) {
/* 136 */     this._showErrorBox = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getShowErrorBox() {
/* 143 */     return this._showErrorBox;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createPromptBox(String paramString1, String paramString2) {
/* 151 */     this._prompt_title = paramString1;
/* 152 */     this._prompt_text = paramString2;
/* 153 */     setShowPromptBox(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptBoxTitle() {
/* 160 */     return this._prompt_title;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptBoxText() {
/* 167 */     return this._prompt_text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createErrorBox(String paramString1, String paramString2) {
/* 174 */     this._error_title = paramString1;
/* 175 */     this._error_text = paramString2;
/* 176 */     setShowErrorBox(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getErrorBoxTitle() {
/* 183 */     return this._error_title;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getErrorBoxText() {
/* 190 */     return this._error_text;
/*     */   }
/*     */ 
/*     */   
/*     */   public DVRecord createDVRecord(HSSFSheet paramHSSFSheet) {
/* 195 */     DVConstraint.FormulaPair formulaPair = this._constraint.createFormulas(paramHSSFSheet);
/*     */     
/* 197 */     return new DVRecord(this._constraint.getValidationType(), this._constraint.getOperator(), this._errorStyle, this._emptyCellAllowed, getSuppressDropDownArrow(), (this._constraint.getValidationType() == 3 && this._constraint.getExplicitListValues() != null), this._showPromptBox, this._prompt_title, this._prompt_text, this._showErrorBox, this._error_title, this._error_text, formulaPair.getFormula1(), formulaPair.getFormula2(), this._regions);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFDataValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */