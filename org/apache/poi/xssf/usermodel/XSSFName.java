/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.formula.FormulaParser;
/*     */ import org.apache.poi.ss.formula.FormulaType;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.Name;
/*     */ import org.apache.poi.ss.util.AreaReference;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class XSSFName
/*     */   implements Name
/*     */ {
/*     */   public static final String BUILTIN_PRINT_AREA = "_xlnm.Print_Area";
/*     */   public static final String BUILTIN_PRINT_TITLE = "_xlnm.Print_Titles";
/*     */   public static final String BUILTIN_CRITERIA = "_xlnm.Criteria:";
/*     */   public static final String BUILTIN_EXTRACT = "_xlnm.Extract:";
/*     */   public static final String BUILTIN_FILTER_DB = "_xlnm._FilterDatabase";
/*     */   public static final String BUILTIN_CONSOLIDATE_AREA = "_xlnm.Consolidate_Area";
/*     */   public static final String BUILTIN_DATABASE = "_xlnm.Database";
/*     */   public static final String BUILTIN_SHEET_TITLE = "_xlnm.Sheet_Title";
/*     */   private XSSFWorkbook _workbook;
/*     */   private CTDefinedName _ctName;
/*     */   
/*     */   protected XSSFName(CTDefinedName paramCTDefinedName, XSSFWorkbook paramXSSFWorkbook) {
/* 117 */     this._workbook = paramXSSFWorkbook;
/* 118 */     this._ctName = paramCTDefinedName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CTDefinedName getCTName() {
/* 125 */     return this._ctName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNameName() {
/* 134 */     return this._ctName.getName();
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
/*     */   public void setNameName(String paramString) {
/* 168 */     validateName(paramString);
/*     */     
/* 170 */     String str = getNameName();
/* 171 */     int i = getSheetIndex();
/*     */     
/* 173 */     for (XSSFName xSSFName : this._workbook.getNames(paramString)) {
/* 174 */       if (xSSFName.getSheetIndex() == i && xSSFName != this) {
/* 175 */         String str1 = "The " + ((i == -1) ? "workbook" : "sheet") + " already contains this name: " + paramString;
/* 176 */         throw new IllegalArgumentException(str1);
/*     */       } 
/*     */     } 
/* 179 */     this._ctName.setName(paramString);
/*     */     
/* 181 */     this._workbook.updateName(this, str);
/*     */   }
/*     */   
/*     */   public String getRefersToFormula() {
/* 185 */     String str = this._ctName.getStringValue();
/* 186 */     if (str == null || str.length() < 1) {
/* 187 */       return null;
/*     */     }
/* 189 */     return str;
/*     */   }
/*     */   
/*     */   public void setRefersToFormula(String paramString) {
/* 193 */     XSSFEvaluationWorkbook xSSFEvaluationWorkbook = XSSFEvaluationWorkbook.create(this._workbook);
/*     */     
/* 195 */     FormulaParser.parse(paramString, xSSFEvaluationWorkbook, FormulaType.NAMEDRANGE, getSheetIndex(), -1);
/*     */     
/* 197 */     this._ctName.setStringValue(paramString);
/*     */   }
/*     */   
/*     */   public boolean isDeleted() {
/* 201 */     String str = getRefersToFormula();
/* 202 */     if (str == null) {
/* 203 */       return false;
/*     */     }
/* 205 */     XSSFEvaluationWorkbook xSSFEvaluationWorkbook = XSSFEvaluationWorkbook.create(this._workbook);
/* 206 */     Ptg[] arrayOfPtg = FormulaParser.parse(str, xSSFEvaluationWorkbook, FormulaType.NAMEDRANGE, getSheetIndex(), -1);
/* 207 */     return Ptg.doesFormulaReferToDeletedCell(arrayOfPtg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSheetIndex(int paramInt) {
/* 216 */     int i = this._workbook.getNumberOfSheets() - 1;
/* 217 */     if (paramInt < -1 || paramInt > i) {
/* 218 */       throw new IllegalArgumentException("Sheet index (" + paramInt + ") is out of range" + ((i == -1) ? "" : (" (0.." + i + ")")));
/*     */     }
/*     */ 
/*     */     
/* 222 */     if (paramInt == -1) {
/* 223 */       if (this._ctName.isSetLocalSheetId()) this._ctName.unsetLocalSheetId(); 
/*     */     } else {
/* 225 */       this._ctName.setLocalSheetId(paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSheetIndex() {
/* 235 */     return this._ctName.isSetLocalSheetId() ? (int)this._ctName.getLocalSheetId() : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFunction(boolean paramBoolean) {
/* 245 */     this._ctName.setFunction(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFunction() {
/* 255 */     return this._ctName.getFunction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFunctionGroupId(int paramInt) {
/* 266 */     this._ctName.setFunctionGroupId(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFunctionGroupId() {
/* 277 */     return (int)this._ctName.getFunctionGroupId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSheetName() {
/* 287 */     if (this._ctName.isSetLocalSheetId()) {
/*     */       
/* 289 */       int i = (int)this._ctName.getLocalSheetId();
/* 290 */       return this._workbook.getSheetName(i);
/*     */     } 
/* 292 */     String str = getRefersToFormula();
/* 293 */     AreaReference areaReference = new AreaReference(str);
/* 294 */     return areaReference.getFirstCell().getSheetName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFunctionName() {
/* 303 */     return getFunction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 312 */     return this._ctName.getComment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComment(String paramString) {
/* 321 */     this._ctName.setComment(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 326 */     return this._ctName.toString().hashCode();
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
/*     */   public boolean equals(Object paramObject) {
/* 340 */     if (paramObject == this) return true;
/*     */     
/* 342 */     if (!(paramObject instanceof XSSFName)) return false;
/*     */     
/* 344 */     XSSFName xSSFName = (XSSFName)paramObject;
/* 345 */     return this._ctName.toString().equals(xSSFName.getCTName().toString());
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
/*     */   private static void validateName(String paramString) {
/* 358 */     if (paramString.length() == 0) {
/* 359 */       throw new IllegalArgumentException("Name cannot be blank");
/*     */     }
/*     */ 
/*     */     
/* 363 */     char c = paramString.charAt(0);
/* 364 */     String str = "_";
/* 365 */     boolean bool = (Character.isLetter(c) || str.indexOf(c) != -1) ? true : false;
/* 366 */     if (!bool) {
/* 367 */       throw new IllegalArgumentException("Invalid name: '" + paramString + "': first character must be underscore or a letter");
/*     */     }
/*     */ 
/*     */     
/* 371 */     str = "_\\";
/* 372 */     for (char c1 : paramString.toCharArray()) {
/* 373 */       bool = (Character.isLetterOrDigit(c1) || str.indexOf(c1) != -1) ? true : false;
/* 374 */       if (!bool)
/* 375 */         throw new IllegalArgumentException("Invalid name: '" + paramString + "'"); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */