/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*     */ import org.apache.poi.hssf.record.CFRule12Record;
/*     */ import org.apache.poi.hssf.record.CFRuleBase;
/*     */ import org.apache.poi.hssf.record.cf.BorderFormatting;
/*     */ import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
/*     */ import org.apache.poi.hssf.record.cf.DataBarFormatting;
/*     */ import org.apache.poi.hssf.record.cf.FontFormatting;
/*     */ import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
/*     */ import org.apache.poi.hssf.record.cf.PatternFormatting;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.BorderFormatting;
/*     */ import org.apache.poi.ss.usermodel.ColorScaleFormatting;
/*     */ import org.apache.poi.ss.usermodel.ConditionType;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
/*     */ import org.apache.poi.ss.usermodel.DataBarFormatting;
/*     */ import org.apache.poi.ss.usermodel.FontFormatting;
/*     */ import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
/*     */ import org.apache.poi.ss.usermodel.PatternFormatting;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HSSFConditionalFormattingRule
/*     */   implements ConditionalFormattingRule
/*     */ {
/*     */   private static final byte CELL_COMPARISON = 1;
/*     */   private final CFRuleBase cfRuleRecord;
/*     */   private final HSSFWorkbook workbook;
/*     */   private final HSSFSheet sheet;
/*     */   
/*     */   HSSFConditionalFormattingRule(HSSFSheet paramHSSFSheet, CFRuleBase paramCFRuleBase) {
/*  49 */     if (paramHSSFSheet == null) {
/*  50 */       throw new IllegalArgumentException("pSheet must not be null");
/*     */     }
/*  52 */     if (paramCFRuleBase == null) {
/*  53 */       throw new IllegalArgumentException("pRuleRecord must not be null");
/*     */     }
/*  55 */     this.sheet = paramHSSFSheet;
/*  56 */     this.workbook = paramHSSFSheet.getWorkbook();
/*  57 */     this.cfRuleRecord = paramCFRuleBase;
/*     */   }
/*     */   
/*     */   CFRuleBase getCfRuleRecord() {
/*  61 */     return this.cfRuleRecord;
/*     */   }
/*     */   
/*  64 */   private CFRule12Record getCFRule12Record(boolean paramBoolean) { if (this.cfRuleRecord instanceof CFRule12Record)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  70 */       return (CFRule12Record)this.cfRuleRecord; } 
/*     */     if (paramBoolean)
/*     */       throw new IllegalArgumentException("Can't convert a CF into a CF12 record"); 
/*     */     return null; } private HSSFFontFormatting getFontFormatting(boolean paramBoolean) {
/*  74 */     FontFormatting fontFormatting = this.cfRuleRecord.getFontFormatting();
/*  75 */     if (fontFormatting == null) {
/*  76 */       if (!paramBoolean) return null; 
/*  77 */       fontFormatting = new FontFormatting();
/*  78 */       this.cfRuleRecord.setFontFormatting(fontFormatting);
/*     */     } 
/*  80 */     return new HSSFFontFormatting(this.cfRuleRecord, this.workbook);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFFontFormatting getFontFormatting() {
/*  87 */     return getFontFormatting(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFFontFormatting createFontFormatting() {
/*  95 */     return getFontFormatting(true);
/*     */   }
/*     */   
/*     */   private HSSFBorderFormatting getBorderFormatting(boolean paramBoolean) {
/*  99 */     BorderFormatting borderFormatting = this.cfRuleRecord.getBorderFormatting();
/* 100 */     if (borderFormatting == null) {
/* 101 */       if (!paramBoolean) return null; 
/* 102 */       borderFormatting = new BorderFormatting();
/* 103 */       this.cfRuleRecord.setBorderFormatting(borderFormatting);
/*     */     } 
/* 105 */     return new HSSFBorderFormatting(this.cfRuleRecord, this.workbook);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFBorderFormatting getBorderFormatting() {
/* 112 */     return getBorderFormatting(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFBorderFormatting createBorderFormatting() {
/* 120 */     return getBorderFormatting(true);
/*     */   }
/*     */   
/*     */   private HSSFPatternFormatting getPatternFormatting(boolean paramBoolean) {
/* 124 */     PatternFormatting patternFormatting = this.cfRuleRecord.getPatternFormatting();
/* 125 */     if (patternFormatting == null) {
/* 126 */       if (!paramBoolean) return null; 
/* 127 */       patternFormatting = new PatternFormatting();
/* 128 */       this.cfRuleRecord.setPatternFormatting(patternFormatting);
/*     */     } 
/* 130 */     return new HSSFPatternFormatting(this.cfRuleRecord, this.workbook);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFPatternFormatting getPatternFormatting() {
/* 138 */     return getPatternFormatting(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFPatternFormatting createPatternFormatting() {
/* 147 */     return getPatternFormatting(true);
/*     */   }
/*     */   
/*     */   private HSSFDataBarFormatting getDataBarFormatting(boolean paramBoolean) {
/* 151 */     CFRule12Record cFRule12Record = getCFRule12Record(paramBoolean);
/* 152 */     if (cFRule12Record == null) return null;
/*     */     
/* 154 */     DataBarFormatting dataBarFormatting = cFRule12Record.getDataBarFormatting();
/* 155 */     if (dataBarFormatting == null) {
/* 156 */       if (!paramBoolean) return null; 
/* 157 */       cFRule12Record.createDataBarFormatting();
/*     */     } 
/*     */     
/* 160 */     return new HSSFDataBarFormatting(cFRule12Record, this.sheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFDataBarFormatting getDataBarFormatting() {
/* 167 */     return getDataBarFormatting(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFDataBarFormatting createDataBarFormatting() {
/* 174 */     return getDataBarFormatting(true);
/*     */   }
/*     */   
/*     */   private HSSFIconMultiStateFormatting getMultiStateFormatting(boolean paramBoolean) {
/* 178 */     CFRule12Record cFRule12Record = getCFRule12Record(paramBoolean);
/* 179 */     if (cFRule12Record == null) return null;
/*     */     
/* 181 */     IconMultiStateFormatting iconMultiStateFormatting = cFRule12Record.getMultiStateFormatting();
/* 182 */     if (iconMultiStateFormatting == null) {
/* 183 */       if (!paramBoolean) return null; 
/* 184 */       cFRule12Record.createMultiStateFormatting();
/*     */     } 
/* 186 */     return new HSSFIconMultiStateFormatting(cFRule12Record, this.sheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFIconMultiStateFormatting getMultiStateFormatting() {
/* 193 */     return getMultiStateFormatting(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFIconMultiStateFormatting createMultiStateFormatting() {
/* 200 */     return getMultiStateFormatting(true);
/*     */   }
/*     */   
/*     */   private HSSFColorScaleFormatting getColorScaleFormatting(boolean paramBoolean) {
/* 204 */     CFRule12Record cFRule12Record = getCFRule12Record(paramBoolean);
/* 205 */     if (cFRule12Record == null) return null;
/*     */     
/* 207 */     ColorGradientFormatting colorGradientFormatting = cFRule12Record.getColorGradientFormatting();
/* 208 */     if (colorGradientFormatting == null) {
/* 209 */       if (!paramBoolean) return null; 
/* 210 */       cFRule12Record.createColorGradientFormatting();
/*     */     } 
/*     */     
/* 213 */     return new HSSFColorScaleFormatting(cFRule12Record, this.sheet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFColorScaleFormatting getColorScaleFormatting() {
/* 220 */     return getColorScaleFormatting(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFColorScaleFormatting createColorScaleFormatting() {
/* 227 */     return getColorScaleFormatting(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConditionType getConditionType() {
/* 235 */     byte b = this.cfRuleRecord.getConditionType();
/* 236 */     return ConditionType.forId(b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getComparisonOperation() {
/* 244 */     return this.cfRuleRecord.getComparisonOperation();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFormula1() {
/* 249 */     return toFormulaString(this.cfRuleRecord.getParsedExpression1());
/*     */   }
/*     */   
/*     */   public String getFormula2() {
/* 253 */     byte b = this.cfRuleRecord.getConditionType();
/* 254 */     if (b == 1) {
/* 255 */       byte b1 = this.cfRuleRecord.getComparisonOperation();
/* 256 */       switch (b1) {
/*     */         case 1:
/*     */         case 2:
/* 259 */           return toFormulaString(this.cfRuleRecord.getParsedExpression2());
/*     */       } 
/*     */     } 
/* 262 */     return null;
/*     */   }
/*     */   
/*     */   protected String toFormulaString(Ptg[] paramArrayOfPtg) {
/* 266 */     return toFormulaString(paramArrayOfPtg, this.workbook);
/*     */   }
/*     */   protected static String toFormulaString(Ptg[] paramArrayOfPtg, HSSFWorkbook paramHSSFWorkbook) {
/* 269 */     if (paramArrayOfPtg == null || paramArrayOfPtg.length == 0) {
/* 270 */       return null;
/*     */     }
/* 272 */     return HSSFFormulaParser.toFormulaString(paramHSSFWorkbook, paramArrayOfPtg);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFConditionalFormattingRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */