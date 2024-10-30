/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*     */ import org.apache.poi.hssf.model.InternalWorkbook;
/*     */ import org.apache.poi.hssf.record.NameCommentRecord;
/*     */ import org.apache.poi.hssf.record.NameRecord;
/*     */ import org.apache.poi.ss.formula.FormulaType;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.Name;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HSSFName
/*     */   implements Name
/*     */ {
/*     */   private HSSFWorkbook _book;
/*     */   private NameRecord _definedNameRec;
/*     */   private NameCommentRecord _commentRec;
/*     */   
/*     */   HSSFName(HSSFWorkbook paramHSSFWorkbook, NameRecord paramNameRecord) {
/*  47 */     this(paramHSSFWorkbook, paramNameRecord, null);
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
/*     */   HSSFName(HSSFWorkbook paramHSSFWorkbook, NameRecord paramNameRecord, NameCommentRecord paramNameCommentRecord) {
/*  59 */     this._book = paramHSSFWorkbook;
/*  60 */     this._definedNameRec = paramNameRecord;
/*  61 */     this._commentRec = paramNameCommentRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSheetName() {
/*  68 */     int i = this._definedNameRec.getExternSheetNumber();
/*     */     
/*  70 */     return this._book.getWorkbook().findSheetFirstNameFromExternSheet(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNameName() {
/*  77 */     return this._definedNameRec.getNameText();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 130 */     validateName(paramString);
/*     */     
/* 132 */     InternalWorkbook internalWorkbook = this._book.getWorkbook();
/* 133 */     this._definedNameRec.setNameText(paramString);
/*     */     
/* 135 */     int i = this._definedNameRec.getSheetNumber();
/*     */ 
/*     */     
/* 138 */     int j = internalWorkbook.getNumNames() - 1;
/* 139 */     for (int k = j; k >= 0; k--) {
/*     */       
/* 141 */       NameRecord nameRecord = internalWorkbook.getNameRecord(k);
/* 142 */       if (nameRecord != this._definedNameRec && 
/* 143 */         nameRecord.getNameText().equalsIgnoreCase(paramString) && i == nameRecord.getSheetNumber()) {
/* 144 */         String str = "The " + ((i == 0) ? "workbook" : "sheet") + " already contains this name: " + paramString;
/* 145 */         this._definedNameRec.setNameText(paramString + "(2)");
/* 146 */         throw new IllegalArgumentException(str);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 152 */     if (this._commentRec != null) {
/* 153 */       this._commentRec.setNameText(paramString);
/* 154 */       this._book.getWorkbook().updateNameCommentRecordCache(this._commentRec);
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
/*     */   private static void validateName(String paramString) {
/* 168 */     if (paramString.length() == 0) {
/* 169 */       throw new IllegalArgumentException("Name cannot be blank");
/*     */     }
/*     */ 
/*     */     
/* 173 */     char c = paramString.charAt(0);
/* 174 */     String str = "_";
/* 175 */     boolean bool = (Character.isLetter(c) || str.indexOf(c) != -1) ? true : false;
/* 176 */     if (!bool) {
/* 177 */       throw new IllegalArgumentException("Invalid name: '" + paramString + "': first character must be underscore or a letter");
/*     */     }
/*     */ 
/*     */     
/* 181 */     str = "_\\";
/* 182 */     for (char c1 : paramString.toCharArray()) {
/* 183 */       bool = (Character.isLetterOrDigit(c1) || str.indexOf(c1) != -1) ? true : false;
/* 184 */       if (!bool) {
/* 185 */         throw new IllegalArgumentException("Invalid name: '" + paramString + "'");
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setRefersToFormula(String paramString) {
/* 191 */     Ptg[] arrayOfPtg = HSSFFormulaParser.parse(paramString, this._book, FormulaType.NAMEDRANGE, getSheetIndex());
/* 192 */     this._definedNameRec.setNameDefinition(arrayOfPtg);
/*     */   }
/*     */   
/*     */   public String getRefersToFormula() {
/* 196 */     if (this._definedNameRec.isFunctionName()) {
/* 197 */       throw new IllegalStateException("Only applicable to named ranges");
/*     */     }
/* 199 */     Ptg[] arrayOfPtg = this._definedNameRec.getNameDefinition();
/* 200 */     if (arrayOfPtg.length < 1)
/*     */     {
/* 202 */       return null;
/*     */     }
/* 204 */     return HSSFFormulaParser.toFormulaString(this._book, arrayOfPtg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setNameDefinition(Ptg[] paramArrayOfPtg) {
/* 215 */     this._definedNameRec.setNameDefinition(paramArrayOfPtg);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeleted() {
/* 220 */     Ptg[] arrayOfPtg = this._definedNameRec.getNameDefinition();
/* 221 */     return Ptg.doesFormulaReferToDeletedCell(arrayOfPtg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFunctionName() {
/* 230 */     return this._definedNameRec.isFunctionName();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 234 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 235 */     stringBuffer.append(getClass().getName()).append(" [");
/* 236 */     stringBuffer.append(this._definedNameRec.getNameText());
/* 237 */     stringBuffer.append("]");
/* 238 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSheetIndex(int paramInt) {
/* 249 */     int i = this._book.getNumberOfSheets() - 1;
/* 250 */     if (paramInt < -1 || paramInt > i) {
/* 251 */       throw new IllegalArgumentException("Sheet index (" + paramInt + ") is out of range" + ((i == -1) ? "" : (" (0.." + i + ")")));
/*     */     }
/*     */ 
/*     */     
/* 255 */     this._definedNameRec.setSheetNumber(paramInt + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSheetIndex() {
/* 264 */     return this._definedNameRec.getSheetNumber() - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getComment() {
/* 273 */     if (this._commentRec != null)
/*     */     {
/* 275 */       if (this._commentRec.getCommentText() != null && this._commentRec.getCommentText().length() > 0)
/*     */       {
/* 277 */         return this._commentRec.getCommentText();
/*     */       }
/*     */     }
/* 280 */     return this._definedNameRec.getDescriptionText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setComment(String paramString) {
/* 290 */     this._definedNameRec.setDescriptionText(paramString);
/*     */     
/* 292 */     if (this._commentRec != null) {
/* 293 */       this._commentRec.setCommentText(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFunction(boolean paramBoolean) {
/* 304 */     this._definedNameRec.setFunction(paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */