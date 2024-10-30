/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.apache.poi.ss.SpreadsheetVersion;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormatting;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
/*     */ import org.apache.poi.ss.usermodel.ExtendedColor;
/*     */ import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
/*     */ import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellRangeUtil;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTConditionalFormatting;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFSheetConditionalFormatting
/*     */   implements SheetConditionalFormatting
/*     */ {
/*     */   protected static final String CF_EXT_2009_NS_X14 = "http://schemas.microsoft.com/office/spreadsheetml/2009/9/main";
/*     */   private final XSSFSheet _sheet;
/*     */   
/*     */   XSSFSheetConditionalFormatting(XSSFSheet paramXSSFSheet) {
/*  50 */     this._sheet = paramXSSFSheet;
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
/*     */   public XSSFConditionalFormattingRule createConditionalFormattingRule(byte paramByte, String paramString1, String paramString2) {
/*     */     STConditionalFormattingOperator.Enum enum_;
/*  81 */     XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
/*  82 */     CTCfRule cTCfRule = xSSFConditionalFormattingRule.getCTCfRule();
/*  83 */     cTCfRule.addFormula(paramString1);
/*  84 */     if (paramString2 != null) cTCfRule.addFormula(paramString2); 
/*  85 */     cTCfRule.setType(STCfType.CELL_IS);
/*     */     
/*  87 */     switch (paramByte) { case 1:
/*  88 */         enum_ = STConditionalFormattingOperator.BETWEEN;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  98 */         cTCfRule.setOperator(enum_);
/*     */         
/* 100 */         return xSSFConditionalFormattingRule;case 2: enum_ = STConditionalFormattingOperator.NOT_BETWEEN; cTCfRule.setOperator(enum_); return xSSFConditionalFormattingRule;case 6: enum_ = STConditionalFormattingOperator.LESS_THAN; cTCfRule.setOperator(enum_); return xSSFConditionalFormattingRule;case 8: enum_ = STConditionalFormattingOperator.LESS_THAN_OR_EQUAL; cTCfRule.setOperator(enum_); return xSSFConditionalFormattingRule;case 5: enum_ = STConditionalFormattingOperator.GREATER_THAN; cTCfRule.setOperator(enum_); return xSSFConditionalFormattingRule;case 7: enum_ = STConditionalFormattingOperator.GREATER_THAN_OR_EQUAL; cTCfRule.setOperator(enum_); return xSSFConditionalFormattingRule;case 3: enum_ = STConditionalFormattingOperator.EQUAL; cTCfRule.setOperator(enum_); return xSSFConditionalFormattingRule;case 4: enum_ = STConditionalFormattingOperator.NOT_EQUAL; cTCfRule.setOperator(enum_); return xSSFConditionalFormattingRule; }
/*     */     
/*     */     throw new IllegalArgumentException("Unknown comparison operator: " + paramByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFConditionalFormattingRule createConditionalFormattingRule(byte paramByte, String paramString) {
/* 107 */     return createConditionalFormattingRule(paramByte, paramString, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFConditionalFormattingRule createConditionalFormattingRule(String paramString) {
/* 116 */     XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
/* 117 */     CTCfRule cTCfRule = xSSFConditionalFormattingRule.getCTCfRule();
/* 118 */     cTCfRule.addFormula(paramString);
/* 119 */     cTCfRule.setType(STCfType.EXPRESSION);
/* 120 */     return xSSFConditionalFormattingRule;
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
/*     */   public XSSFConditionalFormattingRule createConditionalFormattingRule(XSSFColor paramXSSFColor) {
/* 134 */     XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
/*     */ 
/*     */     
/* 137 */     xSSFConditionalFormattingRule.createDataBarFormatting(paramXSSFColor);
/*     */ 
/*     */     
/* 140 */     return xSSFConditionalFormattingRule;
/*     */   }
/*     */   public XSSFConditionalFormattingRule createConditionalFormattingRule(ExtendedColor paramExtendedColor) {
/* 143 */     return createConditionalFormattingRule((XSSFColor)paramExtendedColor);
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
/*     */   public XSSFConditionalFormattingRule createConditionalFormattingRule(IconMultiStateFormatting.IconSet paramIconSet) {
/* 156 */     XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
/*     */ 
/*     */     
/* 159 */     xSSFConditionalFormattingRule.createMultiStateFormatting(paramIconSet);
/*     */ 
/*     */     
/* 162 */     return xSSFConditionalFormattingRule;
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
/*     */   public XSSFConditionalFormattingRule createConditionalFormattingColorScaleRule() {
/* 176 */     XSSFConditionalFormattingRule xSSFConditionalFormattingRule = new XSSFConditionalFormattingRule(this._sheet);
/*     */ 
/*     */     
/* 179 */     xSSFConditionalFormattingRule.createColorScaleFormatting();
/*     */ 
/*     */     
/* 182 */     return xSSFConditionalFormattingRule;
/*     */   }
/*     */   
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule[] paramArrayOfConditionalFormattingRule) {
/* 186 */     if (paramArrayOfCellRangeAddress == null) {
/* 187 */       throw new IllegalArgumentException("regions must not be null");
/*     */     }
/* 189 */     for (CellRangeAddress cellRangeAddress : paramArrayOfCellRangeAddress) cellRangeAddress.validate(SpreadsheetVersion.EXCEL2007);
/*     */     
/* 191 */     if (paramArrayOfConditionalFormattingRule == null) {
/* 192 */       throw new IllegalArgumentException("cfRules must not be null");
/*     */     }
/* 194 */     if (paramArrayOfConditionalFormattingRule.length == 0) {
/* 195 */       throw new IllegalArgumentException("cfRules must not be empty");
/*     */     }
/* 197 */     if (paramArrayOfConditionalFormattingRule.length > 3) {
/* 198 */       throw new IllegalArgumentException("Number of rules must not exceed 3");
/*     */     }
/*     */     
/* 201 */     CellRangeAddress[] arrayOfCellRangeAddress = CellRangeUtil.mergeCellRanges(paramArrayOfCellRangeAddress);
/* 202 */     CTConditionalFormatting cTConditionalFormatting = this._sheet.getCTWorksheet().addNewConditionalFormatting();
/* 203 */     ArrayList<String> arrayList = new ArrayList();
/* 204 */     for (CellRangeAddress cellRangeAddress : arrayOfCellRangeAddress) arrayList.add(cellRangeAddress.formatAsString()); 
/* 205 */     cTConditionalFormatting.setSqref(arrayList);
/*     */     
/* 207 */     int i = 1;
/* 208 */     for (CTConditionalFormatting cTConditionalFormatting1 : this._sheet.getCTWorksheet().getConditionalFormattingArray()) {
/* 209 */       i += cTConditionalFormatting1.sizeOfCfRuleArray();
/*     */     }
/*     */     
/* 212 */     for (ConditionalFormattingRule conditionalFormattingRule : paramArrayOfConditionalFormattingRule) {
/* 213 */       XSSFConditionalFormattingRule xSSFConditionalFormattingRule = (XSSFConditionalFormattingRule)conditionalFormattingRule;
/* 214 */       xSSFConditionalFormattingRule.getCTCfRule().setPriority(i++);
/* 215 */       cTConditionalFormatting.addNewCfRule().set((XmlObject)xSSFConditionalFormattingRule.getCTCfRule());
/*     */     } 
/* 217 */     return this._sheet.getCTWorksheet().sizeOfConditionalFormattingArray() - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule paramConditionalFormattingRule) {
/* 223 */     (new XSSFConditionalFormattingRule[1])[0] = (XSSFConditionalFormattingRule)paramConditionalFormattingRule; return addConditionalFormatting(paramArrayOfCellRangeAddress, (paramConditionalFormattingRule == null) ? null : (ConditionalFormattingRule[])new XSSFConditionalFormattingRule[1]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int addConditionalFormatting(CellRangeAddress[] paramArrayOfCellRangeAddress, ConditionalFormattingRule paramConditionalFormattingRule1, ConditionalFormattingRule paramConditionalFormattingRule2) {
/* 232 */     (new XSSFConditionalFormattingRule[2])[0] = (XSSFConditionalFormattingRule)paramConditionalFormattingRule1; (new XSSFConditionalFormattingRule[2])[1] = (XSSFConditionalFormattingRule)paramConditionalFormattingRule2; return addConditionalFormatting(paramArrayOfCellRangeAddress, (paramConditionalFormattingRule1 == null) ? null : (ConditionalFormattingRule[])new XSSFConditionalFormattingRule[2]);
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
/*     */   public int addConditionalFormatting(ConditionalFormatting paramConditionalFormatting) {
/* 252 */     XSSFConditionalFormatting xSSFConditionalFormatting = (XSSFConditionalFormatting)paramConditionalFormatting;
/* 253 */     CTWorksheet cTWorksheet = this._sheet.getCTWorksheet();
/* 254 */     cTWorksheet.addNewConditionalFormatting().set(xSSFConditionalFormatting.getCTConditionalFormatting().copy());
/* 255 */     return cTWorksheet.sizeOfConditionalFormattingArray() - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFConditionalFormatting getConditionalFormattingAt(int paramInt) {
/* 266 */     checkIndex(paramInt);
/* 267 */     CTConditionalFormatting cTConditionalFormatting = this._sheet.getCTWorksheet().getConditionalFormattingArray(paramInt);
/* 268 */     return new XSSFConditionalFormatting(this._sheet, cTConditionalFormatting);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumConditionalFormattings() {
/* 275 */     return this._sheet.getCTWorksheet().sizeOfConditionalFormattingArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeConditionalFormatting(int paramInt) {
/* 283 */     checkIndex(paramInt);
/* 284 */     this._sheet.getCTWorksheet().removeConditionalFormatting(paramInt);
/*     */   }
/*     */   
/*     */   private void checkIndex(int paramInt) {
/* 288 */     int i = getNumConditionalFormattings();
/* 289 */     if (paramInt < 0 || paramInt >= i)
/* 290 */       throw new IllegalArgumentException("Specified CF index " + paramInt + " is outside the allowable range (0.." + (i - 1) + ")"); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFSheetConditionalFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */