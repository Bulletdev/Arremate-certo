/*     */ package org.apache.poi.hssf.record.aggregates;
/*     */ 
/*     */ import org.apache.poi.hssf.record.ArrayRecord;
/*     */ import org.apache.poi.hssf.record.CellValueRecordInterface;
/*     */ import org.apache.poi.hssf.record.FormulaRecord;
/*     */ import org.apache.poi.hssf.record.Record;
/*     */ import org.apache.poi.hssf.record.RecordFormatException;
/*     */ import org.apache.poi.hssf.record.SharedFormulaRecord;
/*     */ import org.apache.poi.hssf.record.SharedValueRecordBase;
/*     */ import org.apache.poi.hssf.record.StringRecord;
/*     */ import org.apache.poi.hssf.util.CellRangeAddress8Bit;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.FormulaError;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FormulaRecordAggregate
/*     */   extends RecordAggregate
/*     */   implements CellValueRecordInterface
/*     */ {
/*     */   private final FormulaRecord _formulaRecord;
/*     */   private SharedValueManager _sharedValueManager;
/*     */   private StringRecord _stringRecord;
/*     */   private SharedFormulaRecord _sharedFormulaRecord;
/*     */   
/*     */   public FormulaRecordAggregate(FormulaRecord paramFormulaRecord, StringRecord paramStringRecord, SharedValueManager paramSharedValueManager) {
/*  56 */     if (paramSharedValueManager == null) {
/*  57 */       throw new IllegalArgumentException("sfm must not be null");
/*     */     }
/*  59 */     if (paramFormulaRecord.hasCachedResultString()) {
/*  60 */       if (paramStringRecord == null) {
/*  61 */         throw new RecordFormatException("Formula record flag is set but String record was not found");
/*     */       }
/*  63 */       this._stringRecord = paramStringRecord;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  68 */       this._stringRecord = null;
/*     */     } 
/*     */     
/*  71 */     this._formulaRecord = paramFormulaRecord;
/*  72 */     this._sharedValueManager = paramSharedValueManager;
/*  73 */     if (paramFormulaRecord.isSharedFormula()) {
/*  74 */       CellReference cellReference = paramFormulaRecord.getFormula().getExpReference();
/*  75 */       if (cellReference == null) {
/*  76 */         handleMissingSharedFormulaRecord(paramFormulaRecord);
/*     */       } else {
/*  78 */         this._sharedFormulaRecord = paramSharedValueManager.linkSharedFormulaRecord(cellReference, this);
/*     */       } 
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
/*     */   private static void handleMissingSharedFormulaRecord(FormulaRecord paramFormulaRecord) {
/*  96 */     Ptg ptg = paramFormulaRecord.getParsedExpression()[0];
/*  97 */     if (ptg instanceof org.apache.poi.ss.formula.ptg.ExpPtg) {
/*  98 */       throw new RecordFormatException("SharedFormulaRecord not found for FormulaRecord with (isSharedFormula=true)");
/*     */     }
/*     */ 
/*     */     
/* 102 */     paramFormulaRecord.setSharedFormula(false);
/*     */   }
/*     */   
/*     */   public FormulaRecord getFormulaRecord() {
/* 106 */     return this._formulaRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringRecord getStringRecord() {
/* 114 */     return this._stringRecord;
/*     */   }
/*     */   
/*     */   public short getXFIndex() {
/* 118 */     return this._formulaRecord.getXFIndex();
/*     */   }
/*     */   
/*     */   public void setXFIndex(short paramShort) {
/* 122 */     this._formulaRecord.setXFIndex(paramShort);
/*     */   }
/*     */   
/*     */   public void setColumn(short paramShort) {
/* 126 */     this._formulaRecord.setColumn(paramShort);
/*     */   }
/*     */   
/*     */   public void setRow(int paramInt) {
/* 130 */     this._formulaRecord.setRow(paramInt);
/*     */   }
/*     */   
/*     */   public short getColumn() {
/* 134 */     return this._formulaRecord.getColumn();
/*     */   }
/*     */   
/*     */   public int getRow() {
/* 138 */     return this._formulaRecord.getRow();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 142 */     return this._formulaRecord.toString();
/*     */   }
/*     */   
/*     */   public void visitContainedRecords(RecordAggregate.RecordVisitor paramRecordVisitor) {
/* 146 */     paramRecordVisitor.visitRecord((Record)this._formulaRecord);
/* 147 */     SharedValueRecordBase sharedValueRecordBase = this._sharedValueManager.getRecordForFirstCell(this);
/* 148 */     if (sharedValueRecordBase != null) {
/* 149 */       paramRecordVisitor.visitRecord((Record)sharedValueRecordBase);
/*     */     }
/* 151 */     if (this._formulaRecord.hasCachedResultString() && this._stringRecord != null) {
/* 152 */       paramRecordVisitor.visitRecord((Record)this._stringRecord);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/* 157 */     if (this._stringRecord == null) {
/* 158 */       return null;
/*     */     }
/* 160 */     return this._stringRecord.getString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCachedStringResult(String paramString) {
/* 166 */     if (this._stringRecord == null) {
/* 167 */       this._stringRecord = new StringRecord();
/*     */     }
/* 169 */     this._stringRecord.setString(paramString);
/* 170 */     if (paramString.length() < 1) {
/* 171 */       this._formulaRecord.setCachedResultTypeEmptyString();
/*     */     } else {
/* 173 */       this._formulaRecord.setCachedResultTypeString();
/*     */     } 
/*     */   }
/*     */   public void setCachedBooleanResult(boolean paramBoolean) {
/* 177 */     this._stringRecord = null;
/* 178 */     this._formulaRecord.setCachedResultBoolean(paramBoolean);
/*     */   }
/*     */   public void setCachedErrorResult(int paramInt) {
/* 181 */     this._stringRecord = null;
/* 182 */     this._formulaRecord.setCachedResultErrorCode(paramInt);
/*     */   }
/*     */   public void setCachedErrorResult(FormulaError paramFormulaError) {
/* 185 */     setCachedErrorResult(paramFormulaError.getCode());
/*     */   }
/*     */   public void setCachedDoubleResult(double paramDouble) {
/* 188 */     this._stringRecord = null;
/* 189 */     this._formulaRecord.setValue(paramDouble);
/*     */   }
/*     */   
/*     */   public Ptg[] getFormulaTokens() {
/* 193 */     if (this._sharedFormulaRecord != null) {
/* 194 */       return this._sharedFormulaRecord.getFormulaTokens(this._formulaRecord);
/*     */     }
/* 196 */     CellReference cellReference = this._formulaRecord.getFormula().getExpReference();
/* 197 */     if (cellReference != null) {
/* 198 */       ArrayRecord arrayRecord = this._sharedValueManager.getArrayRecord(cellReference.getRow(), cellReference.getCol());
/* 199 */       return arrayRecord.getFormulaTokens();
/*     */     } 
/* 201 */     return this._formulaRecord.getParsedExpression();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParsedExpression(Ptg[] paramArrayOfPtg) {
/* 208 */     notifyFormulaChanging();
/* 209 */     this._formulaRecord.setParsedExpression(paramArrayOfPtg);
/*     */   }
/*     */   
/*     */   public void unlinkSharedFormula() {
/* 213 */     SharedFormulaRecord sharedFormulaRecord = this._sharedFormulaRecord;
/* 214 */     if (sharedFormulaRecord == null) {
/* 215 */       throw new IllegalStateException("Formula not linked to shared formula");
/*     */     }
/* 217 */     Ptg[] arrayOfPtg = sharedFormulaRecord.getFormulaTokens(this._formulaRecord);
/* 218 */     this._formulaRecord.setParsedExpression(arrayOfPtg);
/*     */     
/* 220 */     this._formulaRecord.setSharedFormula(false);
/* 221 */     this._sharedFormulaRecord = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyFormulaChanging() {
/* 229 */     if (this._sharedFormulaRecord != null)
/* 230 */       this._sharedValueManager.unlink(this._sharedFormulaRecord); 
/*     */   }
/*     */   
/*     */   public boolean isPartOfArrayFormula() {
/* 234 */     if (this._sharedFormulaRecord != null) {
/* 235 */       return false;
/*     */     }
/* 237 */     CellReference cellReference = this._formulaRecord.getFormula().getExpReference();
/* 238 */     ArrayRecord arrayRecord = (cellReference == null) ? null : this._sharedValueManager.getArrayRecord(cellReference.getRow(), cellReference.getCol());
/* 239 */     return (arrayRecord != null);
/*     */   }
/*     */   
/*     */   public CellRangeAddress getArrayFormulaRange() {
/* 243 */     if (this._sharedFormulaRecord != null) {
/* 244 */       throw new IllegalStateException("not an array formula cell.");
/*     */     }
/* 246 */     CellReference cellReference = this._formulaRecord.getFormula().getExpReference();
/* 247 */     if (cellReference == null) {
/* 248 */       throw new IllegalStateException("not an array formula cell.");
/*     */     }
/* 250 */     ArrayRecord arrayRecord = this._sharedValueManager.getArrayRecord(cellReference.getRow(), cellReference.getCol());
/* 251 */     if (arrayRecord == null) {
/* 252 */       throw new IllegalStateException("ArrayRecord was not found for the locator " + cellReference.formatAsString());
/*     */     }
/* 254 */     CellRangeAddress8Bit cellRangeAddress8Bit = arrayRecord.getRange();
/* 255 */     return new CellRangeAddress(cellRangeAddress8Bit.getFirstRow(), cellRangeAddress8Bit.getLastRow(), cellRangeAddress8Bit.getFirstColumn(), cellRangeAddress8Bit.getLastColumn());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setArrayFormula(CellRangeAddress paramCellRangeAddress, Ptg[] paramArrayOfPtg) {
/* 260 */     ArrayRecord arrayRecord = new ArrayRecord(Formula.create(paramArrayOfPtg), new CellRangeAddress8Bit(paramCellRangeAddress.getFirstRow(), paramCellRangeAddress.getLastRow(), paramCellRangeAddress.getFirstColumn(), paramCellRangeAddress.getLastColumn()));
/* 261 */     this._sharedValueManager.addArrayRecord(arrayRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CellRangeAddress removeArrayFormula(int paramInt1, int paramInt2) {
/* 268 */     CellRangeAddress8Bit cellRangeAddress8Bit = this._sharedValueManager.removeArrayFormula(paramInt1, paramInt2);
/*     */     
/* 270 */     this._formulaRecord.setParsedExpression(null);
/* 271 */     return new CellRangeAddress(cellRangeAddress8Bit.getFirstRow(), cellRangeAddress8Bit.getLastRow(), cellRangeAddress8Bit.getFirstColumn(), cellRangeAddress8Bit.getLastColumn());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\aggregates\FormulaRecordAggregate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */