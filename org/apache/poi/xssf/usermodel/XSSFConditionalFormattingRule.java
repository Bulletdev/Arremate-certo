/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.ss.usermodel.BorderFormatting;
/*     */ import org.apache.poi.ss.usermodel.ColorScaleFormatting;
/*     */ import org.apache.poi.ss.usermodel.ConditionType;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
/*     */ import org.apache.poi.ss.usermodel.DataBarFormatting;
/*     */ import org.apache.poi.ss.usermodel.FontFormatting;
/*     */ import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
/*     */ import org.apache.poi.ss.usermodel.PatternFormatting;
/*     */ import org.apache.poi.xssf.model.StylesTable;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfRule;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCfvo;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColorScale;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDataBar;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDxf;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIconSet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfType;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCfvoType;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STConditionalFormattingOperator;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFConditionalFormattingRule
/*     */   implements ConditionalFormattingRule
/*     */ {
/*     */   private final CTCfRule _cfRule;
/*     */   private XSSFSheet _sh;
/*  39 */   private static Map<STCfType.Enum, ConditionType> typeLookup = new HashMap<STCfType.Enum, ConditionType>();
/*     */   static {
/*  41 */     typeLookup.put(STCfType.CELL_IS, ConditionType.CELL_VALUE_IS);
/*  42 */     typeLookup.put(STCfType.EXPRESSION, ConditionType.FORMULA);
/*  43 */     typeLookup.put(STCfType.COLOR_SCALE, ConditionType.COLOR_SCALE);
/*  44 */     typeLookup.put(STCfType.DATA_BAR, ConditionType.DATA_BAR);
/*  45 */     typeLookup.put(STCfType.ICON_SET, ConditionType.ICON_SET);
/*     */ 
/*     */     
/*  48 */     typeLookup.put(STCfType.TOP_10, ConditionType.FILTER);
/*  49 */     typeLookup.put(STCfType.UNIQUE_VALUES, ConditionType.FILTER);
/*  50 */     typeLookup.put(STCfType.DUPLICATE_VALUES, ConditionType.FILTER);
/*  51 */     typeLookup.put(STCfType.CONTAINS_TEXT, ConditionType.FILTER);
/*  52 */     typeLookup.put(STCfType.NOT_CONTAINS_TEXT, ConditionType.FILTER);
/*  53 */     typeLookup.put(STCfType.BEGINS_WITH, ConditionType.FILTER);
/*  54 */     typeLookup.put(STCfType.ENDS_WITH, ConditionType.FILTER);
/*  55 */     typeLookup.put(STCfType.CONTAINS_BLANKS, ConditionType.FILTER);
/*  56 */     typeLookup.put(STCfType.NOT_CONTAINS_BLANKS, ConditionType.FILTER);
/*  57 */     typeLookup.put(STCfType.CONTAINS_ERRORS, ConditionType.FILTER);
/*  58 */     typeLookup.put(STCfType.NOT_CONTAINS_ERRORS, ConditionType.FILTER);
/*  59 */     typeLookup.put(STCfType.TIME_PERIOD, ConditionType.FILTER);
/*  60 */     typeLookup.put(STCfType.ABOVE_AVERAGE, ConditionType.FILTER);
/*     */   }
/*     */   
/*     */   XSSFConditionalFormattingRule(XSSFSheet paramXSSFSheet) {
/*  64 */     this._cfRule = CTCfRule.Factory.newInstance();
/*  65 */     this._sh = paramXSSFSheet;
/*     */   }
/*     */   
/*     */   XSSFConditionalFormattingRule(XSSFSheet paramXSSFSheet, CTCfRule paramCTCfRule) {
/*  69 */     this._cfRule = paramCTCfRule;
/*  70 */     this._sh = paramXSSFSheet;
/*     */   }
/*     */   
/*     */   CTCfRule getCTCfRule() {
/*  74 */     return this._cfRule;
/*     */   }
/*     */   
/*     */   CTDxf getDxf(boolean paramBoolean) {
/*  78 */     StylesTable stylesTable = this._sh.getWorkbook().getStylesSource();
/*  79 */     CTDxf cTDxf = null;
/*  80 */     if (stylesTable._getDXfsSize() > 0 && this._cfRule.isSetDxfId()) {
/*  81 */       int i = (int)this._cfRule.getDxfId();
/*  82 */       cTDxf = stylesTable.getDxfAt(i);
/*     */     } 
/*  84 */     if (paramBoolean && cTDxf == null) {
/*  85 */       cTDxf = CTDxf.Factory.newInstance();
/*  86 */       int i = stylesTable.putDxf(cTDxf);
/*  87 */       this._cfRule.setDxfId((i - 1));
/*     */     } 
/*  89 */     return cTDxf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFBorderFormatting createBorderFormatting() {
/*     */     CTBorder cTBorder;
/*  99 */     CTDxf cTDxf = getDxf(true);
/*     */     
/* 101 */     if (!cTDxf.isSetBorder()) {
/* 102 */       cTBorder = cTDxf.addNewBorder();
/*     */     } else {
/* 104 */       cTBorder = cTDxf.getBorder();
/*     */     } 
/*     */     
/* 107 */     return new XSSFBorderFormatting(cTBorder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFBorderFormatting getBorderFormatting() {
/* 114 */     CTDxf cTDxf = getDxf(false);
/* 115 */     if (cTDxf == null || !cTDxf.isSetBorder()) return null;
/*     */     
/* 117 */     return new XSSFBorderFormatting(cTDxf.getBorder());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFFontFormatting createFontFormatting() {
/*     */     CTFont cTFont;
/* 127 */     CTDxf cTDxf = getDxf(true);
/*     */     
/* 129 */     if (!cTDxf.isSetFont()) {
/* 130 */       cTFont = cTDxf.addNewFont();
/*     */     } else {
/* 132 */       cTFont = cTDxf.getFont();
/*     */     } 
/*     */     
/* 135 */     return new XSSFFontFormatting(cTFont);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFFontFormatting getFontFormatting() {
/* 142 */     CTDxf cTDxf = getDxf(false);
/* 143 */     if (cTDxf == null || !cTDxf.isSetFont()) return null;
/*     */     
/* 145 */     return new XSSFFontFormatting(cTDxf.getFont());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFPatternFormatting createPatternFormatting() {
/*     */     CTFill cTFill;
/* 155 */     CTDxf cTDxf = getDxf(true);
/*     */     
/* 157 */     if (!cTDxf.isSetFill()) {
/* 158 */       cTFill = cTDxf.addNewFill();
/*     */     } else {
/* 160 */       cTFill = cTDxf.getFill();
/*     */     } 
/*     */     
/* 163 */     return new XSSFPatternFormatting(cTFill);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFPatternFormatting getPatternFormatting() {
/* 170 */     CTDxf cTDxf = getDxf(false);
/* 171 */     if (cTDxf == null || !cTDxf.isSetFill()) return null;
/*     */     
/* 173 */     return new XSSFPatternFormatting(cTDxf.getFill());
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFDataBarFormatting createDataBarFormatting(XSSFColor paramXSSFColor) {
/* 178 */     if (this._cfRule.isSetDataBar() && this._cfRule.getType() == STCfType.DATA_BAR) {
/* 179 */       return getDataBarFormatting();
/*     */     }
/*     */     
/* 182 */     this._cfRule.setType(STCfType.DATA_BAR);
/*     */ 
/*     */     
/* 185 */     CTDataBar cTDataBar = null;
/* 186 */     if (this._cfRule.isSetDataBar()) {
/* 187 */       cTDataBar = this._cfRule.getDataBar();
/*     */     } else {
/* 189 */       cTDataBar = this._cfRule.addNewDataBar();
/*     */     } 
/*     */     
/* 192 */     cTDataBar.setColor(paramXSSFColor.getCTColor());
/*     */ 
/*     */     
/* 195 */     CTCfvo cTCfvo1 = cTDataBar.addNewCfvo();
/* 196 */     cTCfvo1.setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MIN.name));
/* 197 */     CTCfvo cTCfvo2 = cTDataBar.addNewCfvo();
/* 198 */     cTCfvo2.setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MAX.name));
/*     */ 
/*     */     
/* 201 */     return new XSSFDataBarFormatting(cTDataBar);
/*     */   }
/*     */   public XSSFDataBarFormatting getDataBarFormatting() {
/* 204 */     if (this._cfRule.isSetDataBar()) {
/* 205 */       CTDataBar cTDataBar = this._cfRule.getDataBar();
/* 206 */       return new XSSFDataBarFormatting(cTDataBar);
/*     */     } 
/* 208 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFIconMultiStateFormatting createMultiStateFormatting(IconMultiStateFormatting.IconSet paramIconSet) {
/* 214 */     if (this._cfRule.isSetIconSet() && this._cfRule.getType() == STCfType.ICON_SET) {
/* 215 */       return getMultiStateFormatting();
/*     */     }
/*     */     
/* 218 */     this._cfRule.setType(STCfType.ICON_SET);
/*     */ 
/*     */     
/* 221 */     CTIconSet cTIconSet = null;
/* 222 */     if (this._cfRule.isSetIconSet()) {
/* 223 */       cTIconSet = this._cfRule.getIconSet();
/*     */     } else {
/* 225 */       cTIconSet = this._cfRule.addNewIconSet();
/*     */     } 
/*     */     
/* 228 */     if (paramIconSet.name != null) {
/* 229 */       STIconSetType.Enum enum_1 = STIconSetType.Enum.forString(paramIconSet.name);
/* 230 */       cTIconSet.setIconSet(enum_1);
/*     */     } 
/*     */ 
/*     */     
/* 234 */     int i = 100 / paramIconSet.num;
/* 235 */     STCfvoType.Enum enum_ = STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.PERCENT.name);
/* 236 */     for (byte b = 0; b < paramIconSet.num; b++) {
/* 237 */       CTCfvo cTCfvo = cTIconSet.addNewCfvo();
/* 238 */       cTCfvo.setType(enum_);
/* 239 */       cTCfvo.setVal(Integer.toString(b * i));
/*     */     } 
/*     */ 
/*     */     
/* 243 */     return new XSSFIconMultiStateFormatting(cTIconSet);
/*     */   }
/*     */   public XSSFIconMultiStateFormatting getMultiStateFormatting() {
/* 246 */     if (this._cfRule.isSetIconSet()) {
/* 247 */       CTIconSet cTIconSet = this._cfRule.getIconSet();
/* 248 */       return new XSSFIconMultiStateFormatting(cTIconSet);
/*     */     } 
/* 250 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFColorScaleFormatting createColorScaleFormatting() {
/* 256 */     if (this._cfRule.isSetColorScale() && this._cfRule.getType() == STCfType.COLOR_SCALE) {
/* 257 */       return getColorScaleFormatting();
/*     */     }
/*     */     
/* 260 */     this._cfRule.setType(STCfType.COLOR_SCALE);
/*     */ 
/*     */     
/* 263 */     CTColorScale cTColorScale = null;
/* 264 */     if (this._cfRule.isSetColorScale()) {
/* 265 */       cTColorScale = this._cfRule.getColorScale();
/*     */     } else {
/* 267 */       cTColorScale = this._cfRule.addNewColorScale();
/*     */     } 
/*     */ 
/*     */     
/* 271 */     if (cTColorScale.sizeOfCfvoArray() == 0) {
/*     */       
/* 273 */       CTCfvo cTCfvo = cTColorScale.addNewCfvo();
/* 274 */       cTCfvo.setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MIN.name));
/* 275 */       cTCfvo = cTColorScale.addNewCfvo();
/* 276 */       cTCfvo.setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.PERCENTILE.name));
/* 277 */       cTCfvo.setVal("50");
/* 278 */       cTCfvo = cTColorScale.addNewCfvo();
/* 279 */       cTCfvo.setType(STCfvoType.Enum.forString(ConditionalFormattingThreshold.RangeType.MAX.name));
/*     */       
/* 281 */       for (byte b = 0; b < 3; b++) {
/* 282 */         cTColorScale.addNewColor();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 287 */     return new XSSFColorScaleFormatting(cTColorScale);
/*     */   }
/*     */   public XSSFColorScaleFormatting getColorScaleFormatting() {
/* 290 */     if (this._cfRule.isSetColorScale()) {
/* 291 */       CTColorScale cTColorScale = this._cfRule.getColorScale();
/* 292 */       return new XSSFColorScaleFormatting(cTColorScale);
/*     */     } 
/* 294 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConditionType getConditionType() {
/* 303 */     return typeLookup.get(this._cfRule.getType());
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
/*     */   public byte getComparisonOperation() {
/* 317 */     STConditionalFormattingOperator.Enum enum_ = this._cfRule.getOperator();
/* 318 */     if (enum_ == null) return 0;
/*     */     
/* 320 */     switch (enum_.intValue()) { case 1:
/* 321 */         return 6;
/* 322 */       case 2: return 8;
/* 323 */       case 6: return 5;
/* 324 */       case 5: return 7;
/* 325 */       case 3: return 3;
/* 326 */       case 4: return 4;
/* 327 */       case 7: return 1;
/* 328 */       case 8: return 2; }
/*     */     
/* 330 */     return 0;
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
/*     */   public String getFormula1() {
/* 348 */     return (this._cfRule.sizeOfFormulaArray() > 0) ? this._cfRule.getFormulaArray(0) : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFormula2() {
/* 359 */     return (this._cfRule.sizeOfFormulaArray() == 2) ? this._cfRule.getFormulaArray(1) : null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFConditionalFormattingRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */