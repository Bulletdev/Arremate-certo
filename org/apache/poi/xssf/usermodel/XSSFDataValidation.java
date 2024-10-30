/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.usermodel.DataValidation;
/*     */ import org.apache.poi.ss.usermodel.DataValidationConstraint;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellRangeAddressList;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataValidation;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationErrorStyle;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationOperator;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STDataValidationType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFDataValidation
/*     */   implements DataValidation
/*     */ {
/*     */   private CTDataValidation ctDdataValidation;
/*     */   private XSSFDataValidationConstraint validationConstraint;
/*     */   private CellRangeAddressList regions;
/*  42 */   static Map<Integer, STDataValidationOperator.Enum> operatorTypeMappings = new HashMap<Integer, STDataValidationOperator.Enum>();
/*  43 */   static Map<STDataValidationOperator.Enum, Integer> operatorTypeReverseMappings = new HashMap<STDataValidationOperator.Enum, Integer>();
/*  44 */   static Map<Integer, STDataValidationType.Enum> validationTypeMappings = new HashMap<Integer, STDataValidationType.Enum>();
/*  45 */   static Map<STDataValidationType.Enum, Integer> validationTypeReverseMappings = new HashMap<STDataValidationType.Enum, Integer>();
/*  46 */   static Map<Integer, STDataValidationErrorStyle.Enum> errorStyleMappings = new HashMap<Integer, STDataValidationErrorStyle.Enum>();
/*     */   static {
/*  48 */     errorStyleMappings.put(Integer.valueOf(2), STDataValidationErrorStyle.INFORMATION);
/*  49 */     errorStyleMappings.put(Integer.valueOf(0), STDataValidationErrorStyle.STOP);
/*  50 */     errorStyleMappings.put(Integer.valueOf(1), STDataValidationErrorStyle.WARNING);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     operatorTypeMappings.put(Integer.valueOf(0), STDataValidationOperator.BETWEEN);
/*  56 */     operatorTypeMappings.put(Integer.valueOf(1), STDataValidationOperator.NOT_BETWEEN);
/*  57 */     operatorTypeMappings.put(Integer.valueOf(2), STDataValidationOperator.EQUAL);
/*  58 */     operatorTypeMappings.put(Integer.valueOf(3), STDataValidationOperator.NOT_EQUAL);
/*  59 */     operatorTypeMappings.put(Integer.valueOf(4), STDataValidationOperator.GREATER_THAN);
/*  60 */     operatorTypeMappings.put(Integer.valueOf(6), STDataValidationOperator.GREATER_THAN_OR_EQUAL);
/*  61 */     operatorTypeMappings.put(Integer.valueOf(5), STDataValidationOperator.LESS_THAN);
/*  62 */     operatorTypeMappings.put(Integer.valueOf(7), STDataValidationOperator.LESS_THAN_OR_EQUAL);
/*     */     
/*  64 */     for (Map.Entry<Integer, STDataValidationOperator.Enum> entry : operatorTypeMappings.entrySet()) {
/*  65 */       operatorTypeReverseMappings.put((STDataValidationOperator.Enum)entry.getValue(), (Integer)entry.getKey());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  70 */     validationTypeMappings.put(Integer.valueOf(7), STDataValidationType.CUSTOM);
/*  71 */     validationTypeMappings.put(Integer.valueOf(4), STDataValidationType.DATE);
/*  72 */     validationTypeMappings.put(Integer.valueOf(2), STDataValidationType.DECIMAL);
/*  73 */     validationTypeMappings.put(Integer.valueOf(3), STDataValidationType.LIST);
/*  74 */     validationTypeMappings.put(Integer.valueOf(0), STDataValidationType.NONE);
/*  75 */     validationTypeMappings.put(Integer.valueOf(6), STDataValidationType.TEXT_LENGTH);
/*  76 */     validationTypeMappings.put(Integer.valueOf(5), STDataValidationType.TIME);
/*  77 */     validationTypeMappings.put(Integer.valueOf(1), STDataValidationType.WHOLE);
/*     */     
/*  79 */     for (Map.Entry<Integer, STDataValidationType.Enum> entry : validationTypeMappings.entrySet()) {
/*  80 */       validationTypeReverseMappings.put((STDataValidationType.Enum)entry.getValue(), (Integer)entry.getKey());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   XSSFDataValidation(CellRangeAddressList paramCellRangeAddressList, CTDataValidation paramCTDataValidation) {
/*  86 */     this(getConstraint(paramCTDataValidation), paramCellRangeAddressList, paramCTDataValidation);
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFDataValidation(XSSFDataValidationConstraint paramXSSFDataValidationConstraint, CellRangeAddressList paramCellRangeAddressList, CTDataValidation paramCTDataValidation) {
/*  91 */     this.validationConstraint = paramXSSFDataValidationConstraint;
/*  92 */     this.ctDdataValidation = paramCTDataValidation;
/*  93 */     this.regions = paramCellRangeAddressList;
/*     */   }
/*     */   
/*     */   CTDataValidation getCtDdataValidation() {
/*  97 */     return this.ctDdataValidation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createErrorBox(String paramString1, String paramString2) {
/* 106 */     this.ctDdataValidation.setErrorTitle(paramString1);
/* 107 */     this.ctDdataValidation.setError(paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createPromptBox(String paramString1, String paramString2) {
/* 114 */     this.ctDdataValidation.setPromptTitle(paramString1);
/* 115 */     this.ctDdataValidation.setPrompt(paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getEmptyCellAllowed() {
/* 122 */     return this.ctDdataValidation.getAllowBlank();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getErrorBoxText() {
/* 129 */     return this.ctDdataValidation.getError();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getErrorBoxTitle() {
/* 136 */     return this.ctDdataValidation.getErrorTitle();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getErrorStyle() {
/* 143 */     return this.ctDdataValidation.getErrorStyle().intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptBoxText() {
/* 150 */     return this.ctDdataValidation.getPrompt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPromptBoxTitle() {
/* 157 */     return this.ctDdataValidation.getPromptTitle();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getShowErrorBox() {
/* 164 */     return this.ctDdataValidation.getShowErrorMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getShowPromptBox() {
/* 171 */     return this.ctDdataValidation.getShowInputMessage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSuppressDropDownArrow() {
/* 178 */     return !this.ctDdataValidation.getShowDropDown();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataValidationConstraint getValidationConstraint() {
/* 185 */     return this.validationConstraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmptyCellAllowed(boolean paramBoolean) {
/* 192 */     this.ctDdataValidation.setAllowBlank(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setErrorStyle(int paramInt) {
/* 199 */     this.ctDdataValidation.setErrorStyle(errorStyleMappings.get(Integer.valueOf(paramInt)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowErrorBox(boolean paramBoolean) {
/* 206 */     this.ctDdataValidation.setShowErrorMessage(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowPromptBox(boolean paramBoolean) {
/* 213 */     this.ctDdataValidation.setShowInputMessage(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSuppressDropDownArrow(boolean paramBoolean) {
/* 220 */     if (this.validationConstraint.getValidationType() == 3) {
/* 221 */       this.ctDdataValidation.setShowDropDown(!paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   public CellRangeAddressList getRegions() {
/* 226 */     return this.regions;
/*     */   }
/*     */   
/*     */   public String prettyPrint() {
/* 230 */     StringBuilder stringBuilder = new StringBuilder();
/* 231 */     for (CellRangeAddress cellRangeAddress : this.regions.getCellRangeAddresses()) {
/* 232 */       stringBuilder.append(cellRangeAddress.formatAsString());
/*     */     }
/* 234 */     stringBuilder.append(" => ");
/* 235 */     stringBuilder.append(this.validationConstraint.prettyPrint());
/* 236 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static XSSFDataValidationConstraint getConstraint(CTDataValidation paramCTDataValidation) {
/* 240 */     XSSFDataValidationConstraint xSSFDataValidationConstraint = null;
/* 241 */     String str1 = paramCTDataValidation.getFormula1();
/* 242 */     String str2 = paramCTDataValidation.getFormula2();
/* 243 */     STDataValidationOperator.Enum enum_ = paramCTDataValidation.getOperator();
/* 244 */     STDataValidationType.Enum enum_1 = paramCTDataValidation.getType();
/* 245 */     Integer integer1 = validationTypeReverseMappings.get(enum_1);
/* 246 */     Integer integer2 = operatorTypeReverseMappings.get(enum_);
/* 247 */     xSSFDataValidationConstraint = new XSSFDataValidationConstraint(integer1.intValue(), integer2.intValue(), str1, str2);
/* 248 */     return xSSFDataValidationConstraint;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFDataValidation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */