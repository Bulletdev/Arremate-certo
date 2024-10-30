/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.CFRule12Record;
/*     */ import org.apache.poi.hssf.record.CFRuleBase;
/*     */ import org.apache.poi.hssf.record.CFRuleRecord;
/*     */ import org.apache.poi.hssf.record.aggregates.CFRecordsAggregate;
/*     */ import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormatting;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
/*     */ import org.apache.poi.ss.usermodel.ExtendedColor;
/*     */ import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
/*     */ import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HSSFSheetConditionalFormatting
/*     */   implements SheetConditionalFormatting
/*     */ {
/*     */   private final HSSFSheet _sheet;
/*     */   private final ConditionalFormattingTable _conditionalFormattingTable;
/*     */   
/*     */   HSSFSheetConditionalFormatting(HSSFSheet paramHSSFSheet) {
/*  41 */     this._sheet = paramHSSFSheet;
/*  42 */     this._conditionalFormattingTable = paramHSSFSheet.getSheet().getConditionalFormattingTable();
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
/*     */   public HSSFConditionalFormattingRule createConditionalFormattingRule(byte paramByte, String paramString1, String paramString2) {
/*  72 */     CFRuleRecord cFRuleRecord = CFRuleRecord.create(this._sheet, paramByte, paramString1, paramString2);
/*  73 */     return new HSSFConditionalFormattingRule(this._sheet, (CFRuleBase)cFRuleRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFConditionalFormattingRule createConditionalFormattingRule(byte paramByte, String paramString) {
/*  79 */     CFRuleRecord cFRuleRecord = CFRuleRecord.create(this._sheet, paramByte, paramString, null);
/*  80 */     return new HSSFConditionalFormattingRule(this._sheet, (CFRuleBase)cFRuleRecord);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFConditionalFormattingRule createConditionalFormattingRule(String paramString) {
/*  91 */     CFRuleRecord cFRuleRecord = CFRuleRecord.create(this._sheet, paramString);
/*  92 */     return new HSSFConditionalFormattingRule(this._sheet, (CFRuleBase)cFRuleRecord);
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
/*     */   public HSSFConditionalFormattingRule createConditionalFormattingRule(IconMultiStateFormatting.IconSet paramIconSet) {
/* 106 */     CFRule12Record cFRule12Record = CFRule12Record.create(this._sheet, paramIconSet);
/* 107 */     return new HSSFConditionalFormattingRule(this._sheet, (CFRuleBase)cFRule12Record);
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
/*     */   public HSSFConditionalFormattingRule createConditionalFormattingRule(HSSFExtendedColor paramHSSFExtendedColor) {
/* 121 */     CFRule12Record cFRule12Record = CFRule12Record.create(this._sheet, paramHSSFExtendedColor.getExtendedColor());
/* 122 */     return new HSSFConditionalFormattingRule(this._sheet, (CFRuleBase)cFRule12Record);
/*     */   }
/*     */   public HSSFConditionalFormattingRule createConditionalFormattingRule(ExtendedColor paramExtendedColor) {
/* 125 */     return createConditionalFormattingRule((HSSFExtendedColor)paramExtendedColor);
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
/*     */   public HSSFConditionalFormattingRule createConditionalFormattingColorScaleRule() {
/* 139 */     CFRule12Record cFRule12Record = CFRule12Record.createColorScale(this._sheet);
/* 140 */     return new HSSFConditionalFormattingRule(this._sheet, (CFRuleBase)cFRule12Record);
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
/*     */   public int addConditionalFormatting(HSSFConditionalFormatting paramHSSFConditionalFormatting) {
/* 156 */     CFRecordsAggregate cFRecordsAggregate = paramHSSFConditionalFormatting.getCFRecordsAggregate().cloneCFAggregate();
/*     */     
/* 158 */     return this._conditionalFormattingTable.add(cFRecordsAggregate);
/*     */   }
/*     */   
/*     */   public int addConditionalFormatting(ConditionalFormatting paramConditionalFormatting) {
/* 162 */     return addConditionalFormatting((HSSFConditionalFormatting)paramConditionalFormatting);
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
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, HSSFConditionalFormattingRule[] paramArrayOfHSSFConditionalFormattingRule) {
/* 174 */     if (paramArrayOfCellRangeAddress == null) {
/* 175 */       throw new IllegalArgumentException("regions must not be null");
/*     */     }
/* 177 */     for (CellRangeAddress cellRangeAddress : paramArrayOfCellRangeAddress) cellRangeAddress.validate(SpreadsheetVersion.EXCEL97);
/*     */     
/* 179 */     if (paramArrayOfHSSFConditionalFormattingRule == null) {
/* 180 */       throw new IllegalArgumentException("cfRules must not be null");
/*     */     }
/* 182 */     if (paramArrayOfHSSFConditionalFormattingRule.length == 0) {
/* 183 */       throw new IllegalArgumentException("cfRules must not be empty");
/*     */     }
/* 185 */     if (paramArrayOfHSSFConditionalFormattingRule.length > 3) {
/* 186 */       throw new IllegalArgumentException("Number of rules must not exceed 3");
/*     */     }
/*     */     
/* 189 */     CFRuleBase[] arrayOfCFRuleBase = new CFRuleBase[paramArrayOfHSSFConditionalFormattingRule.length];
/* 190 */     for (byte b = 0; b != paramArrayOfHSSFConditionalFormattingRule.length; b++) {
/* 191 */       arrayOfCFRuleBase[b] = paramArrayOfHSSFConditionalFormattingRule[b].getCfRuleRecord();
/*     */     }
/* 193 */     CFRecordsAggregate cFRecordsAggregate = new CFRecordsAggregate(paramArrayOfCellRangeAddress, arrayOfCFRuleBase);
/* 194 */     return this._conditionalFormattingTable.add(cFRecordsAggregate);
/*     */   }
/*     */   
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule[] paramArrayOfConditionalFormattingRule) {
/*     */     HSSFConditionalFormattingRule[] arrayOfHSSFConditionalFormattingRule;
/* 199 */     if (paramArrayOfConditionalFormattingRule instanceof HSSFConditionalFormattingRule[]) { arrayOfHSSFConditionalFormattingRule = (HSSFConditionalFormattingRule[])paramArrayOfConditionalFormattingRule; }
/*     */     else
/* 201 */     { arrayOfHSSFConditionalFormattingRule = new HSSFConditionalFormattingRule[paramArrayOfConditionalFormattingRule.length];
/* 202 */       System.arraycopy(paramArrayOfConditionalFormattingRule, 0, arrayOfHSSFConditionalFormattingRule, 0, arrayOfHSSFConditionalFormattingRule.length); }
/*     */     
/* 204 */     return addConditionalFormatting(paramArrayOfCellRangeAddress, arrayOfHSSFConditionalFormattingRule);
/*     */   }
/*     */ 
/*     */   
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, HSSFConditionalFormattingRule paramHSSFConditionalFormattingRule) {
/* 209 */     (new HSSFConditionalFormattingRule[1])[0] = paramHSSFConditionalFormattingRule; return addConditionalFormatting(paramArrayOfCellRangeAddress, (paramHSSFConditionalFormattingRule == null) ? null : new HSSFConditionalFormattingRule[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule paramConditionalFormattingRule) {
/* 216 */     return addConditionalFormatting(paramArrayOfCellRangeAddress, (HSSFConditionalFormattingRule)paramConditionalFormattingRule);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, HSSFConditionalFormattingRule paramHSSFConditionalFormattingRule1, HSSFConditionalFormattingRule paramHSSFConditionalFormattingRule2) {
/* 222 */     return addConditionalFormatting(paramArrayOfCellRangeAddress, new HSSFConditionalFormattingRule[] { paramHSSFConditionalFormattingRule1, paramHSSFConditionalFormattingRule2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule paramConditionalFormattingRule1, ConditionalFormattingRule paramConditionalFormattingRule2) {
/* 229 */     return addConditionalFormatting(paramArrayOfCellRangeAddress, (HSSFConditionalFormattingRule)paramConditionalFormattingRule1, (HSSFConditionalFormattingRule)paramConditionalFormattingRule2);
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
/*     */   public HSSFConditionalFormatting getConditionalFormattingAt(int paramInt) {
/* 243 */     CFRecordsAggregate cFRecordsAggregate = this._conditionalFormattingTable.get(paramInt);
/* 244 */     if (cFRecordsAggregate == null) {
/* 245 */       return null;
/*     */     }
/* 247 */     return new HSSFConditionalFormatting(this._sheet, cFRecordsAggregate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumConditionalFormattings() {
/* 254 */     return this._conditionalFormattingTable.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeConditionalFormatting(int paramInt) {
/* 262 */     this._conditionalFormattingTable.remove(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFSheetConditionalFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */