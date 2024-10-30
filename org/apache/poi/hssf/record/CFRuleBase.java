/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.model.HSSFFormulaParser;
/*     */ import org.apache.poi.hssf.record.cf.BorderFormatting;
/*     */ import org.apache.poi.hssf.record.cf.FontFormatting;
/*     */ import org.apache.poi.hssf.record.cf.PatternFormatting;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.FormulaType;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CFRuleBase
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final class ComparisonOperator
/*     */   {
/*     */     public static final byte NO_COMPARISON = 0;
/*     */     public static final byte BETWEEN = 1;
/*     */     public static final byte NOT_BETWEEN = 2;
/*     */     public static final byte EQUAL = 3;
/*     */     public static final byte NOT_EQUAL = 4;
/*     */     public static final byte GT = 5;
/*     */     public static final byte LT = 6;
/*     */     public static final byte GE = 7;
/*     */     public static final byte LE = 8;
/*     */     private static final byte max_operator = 8;
/*     */   }
/*  56 */   protected static final POILogger logger = POILogFactory.getLogger(CFRuleBase.class);
/*     */   
/*     */   private byte condition_type;
/*     */   
/*     */   public static final byte CONDITION_TYPE_CELL_VALUE_IS = 1;
/*     */   
/*     */   public static final byte CONDITION_TYPE_FORMULA = 2;
/*     */   
/*     */   public static final byte CONDITION_TYPE_COLOR_SCALE = 3;
/*     */   
/*     */   public static final byte CONDITION_TYPE_DATA_BAR = 4;
/*     */   
/*     */   public static final byte CONDITION_TYPE_FILTER = 5;
/*     */   public static final byte CONDITION_TYPE_ICON_SET = 6;
/*     */   private byte comparison_operator;
/*     */   public static final int TEMPLATE_CELL_VALUE = 0;
/*     */   public static final int TEMPLATE_FORMULA = 1;
/*     */   public static final int TEMPLATE_COLOR_SCALE_FORMATTING = 2;
/*     */   public static final int TEMPLATE_DATA_BAR_FORMATTING = 3;
/*     */   public static final int TEMPLATE_ICON_SET_FORMATTING = 4;
/*     */   public static final int TEMPLATE_FILTER = 5;
/*     */   public static final int TEMPLATE_UNIQUE_VALUES = 7;
/*     */   public static final int TEMPLATE_CONTAINS_TEXT = 8;
/*     */   public static final int TEMPLATE_CONTAINS_BLANKS = 9;
/*     */   public static final int TEMPLATE_CONTAINS_NO_BLANKS = 10;
/*     */   public static final int TEMPLATE_CONTAINS_ERRORS = 11;
/*     */   public static final int TEMPLATE_CONTAINS_NO_ERRORS = 12;
/*     */   public static final int TEMPLATE_TODAY = 15;
/*     */   public static final int TEMPLATE_TOMORROW = 16;
/*     */   public static final int TEMPLATE_YESTERDAY = 17;
/*     */   public static final int TEMPLATE_LAST_7_DAYS = 18;
/*     */   public static final int TEMPLATE_LAST_MONTH = 19;
/*     */   public static final int TEMPLATE_NEXT_MONTH = 20;
/*     */   public static final int TEMPLATE_THIS_WEEK = 21;
/*     */   public static final int TEMPLATE_NEXT_WEEK = 22;
/*     */   public static final int TEMPLATE_LAST_WEEK = 23;
/*     */   public static final int TEMPLATE_THIS_MONTH = 24;
/*     */   public static final int TEMPLATE_ABOVE_AVERAGE = 25;
/*     */   public static final int TEMPLATE_BELOW_AVERAGE = 26;
/*     */   public static final int TEMPLATE_DUPLICATE_VALUES = 27;
/*     */   public static final int TEMPLATE_ABOVE_OR_EQUAL_TO_AVERAGE = 29;
/*     */   public static final int TEMPLATE_BELOW_OR_EQUAL_TO_AVERAGE = 30;
/*  98 */   static final BitField modificationBits = bf(4194303);
/*  99 */   static final BitField alignHor = bf(1);
/* 100 */   static final BitField alignVer = bf(2);
/* 101 */   static final BitField alignWrap = bf(4);
/* 102 */   static final BitField alignRot = bf(8);
/* 103 */   static final BitField alignJustLast = bf(16);
/* 104 */   static final BitField alignIndent = bf(32);
/* 105 */   static final BitField alignShrin = bf(64);
/* 106 */   static final BitField mergeCell = bf(128);
/* 107 */   static final BitField protLocked = bf(256);
/* 108 */   static final BitField protHidden = bf(512);
/* 109 */   static final BitField bordLeft = bf(1024);
/* 110 */   static final BitField bordRight = bf(2048);
/* 111 */   static final BitField bordTop = bf(4096);
/* 112 */   static final BitField bordBot = bf(8192);
/* 113 */   static final BitField bordTlBr = bf(16384);
/* 114 */   static final BitField bordBlTr = bf(32768);
/* 115 */   static final BitField pattStyle = bf(65536);
/* 116 */   static final BitField pattCol = bf(131072);
/* 117 */   static final BitField pattBgCol = bf(262144);
/* 118 */   static final BitField notUsed2 = bf(3670016);
/* 119 */   static final BitField undocumented = bf(62914560);
/* 120 */   static final BitField fmtBlockBits = bf(2080374784);
/* 121 */   static final BitField font = bf(67108864);
/* 122 */   static final BitField align = bf(134217728);
/* 123 */   static final BitField bord = bf(268435456);
/* 124 */   static final BitField patt = bf(536870912);
/* 125 */   static final BitField prot = bf(1073741824);
/* 126 */   static final BitField alignTextDir = bf(-2147483648); protected int formatting_options;
/*     */   
/*     */   private static BitField bf(int paramInt) {
/* 129 */     return BitFieldFactory.getInstance(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected short formatting_not_used;
/*     */ 
/*     */   
/*     */   protected FontFormatting _fontFormatting;
/*     */   
/*     */   protected BorderFormatting _borderFormatting;
/*     */   
/*     */   protected PatternFormatting _patternFormatting;
/*     */   
/*     */   private Formula formula1;
/*     */   
/*     */   private Formula formula2;
/*     */ 
/*     */   
/*     */   protected CFRuleBase(byte paramByte1, byte paramByte2) {
/* 149 */     setConditionType(paramByte1);
/* 150 */     setComparisonOperation(paramByte2);
/* 151 */     this.formula1 = Formula.create(Ptg.EMPTY_PTG_ARRAY);
/* 152 */     this.formula2 = Formula.create(Ptg.EMPTY_PTG_ARRAY);
/*     */   }
/*     */   protected CFRuleBase(byte paramByte1, byte paramByte2, Ptg[] paramArrayOfPtg1, Ptg[] paramArrayOfPtg2) {
/* 155 */     this(paramByte1, paramByte2);
/* 156 */     this.formula1 = Formula.create(paramArrayOfPtg1);
/* 157 */     this.formula2 = Formula.create(paramArrayOfPtg2);
/*     */   }
/*     */   protected CFRuleBase() {}
/*     */   
/*     */   protected int readFormatOptions(RecordInputStream paramRecordInputStream) {
/* 162 */     this.formatting_options = paramRecordInputStream.readInt();
/* 163 */     this.formatting_not_used = paramRecordInputStream.readShort();
/*     */     
/* 165 */     int i = 6;
/*     */     
/* 167 */     if (containsFontFormattingBlock()) {
/* 168 */       this._fontFormatting = new FontFormatting(paramRecordInputStream);
/* 169 */       i += this._fontFormatting.getDataLength();
/*     */     } 
/*     */     
/* 172 */     if (containsBorderFormattingBlock()) {
/* 173 */       this._borderFormatting = new BorderFormatting(paramRecordInputStream);
/* 174 */       i += this._borderFormatting.getDataLength();
/*     */     } 
/*     */     
/* 177 */     if (containsPatternFormattingBlock()) {
/* 178 */       this._patternFormatting = new PatternFormatting(paramRecordInputStream);
/* 179 */       i += this._patternFormatting.getDataLength();
/*     */     } 
/*     */     
/* 182 */     return i;
/*     */   }
/*     */   
/*     */   public byte getConditionType() {
/* 186 */     return this.condition_type;
/*     */   }
/*     */   
/* 189 */   protected void setConditionType(byte paramByte) { if (!(this instanceof CFRuleRecord) || 
/* 190 */       paramByte == 1 || paramByte == 2) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 197 */       this.condition_type = paramByte;
/*     */       return;
/*     */     } 
/*     */     throw new IllegalArgumentException("CFRuleRecord only accepts Value-Is and Formula types"); } public void setComparisonOperation(byte paramByte) {
/* 201 */     if (paramByte < 0 || paramByte > 8) {
/* 202 */       throw new IllegalArgumentException("Valid operators are only in the range 0 to 8");
/*     */     }
/*     */     
/* 205 */     this.comparison_operator = paramByte;
/*     */   }
/*     */   public byte getComparisonOperation() {
/* 208 */     return this.comparison_operator;
/*     */   }
/*     */   
/*     */   public boolean containsFontFormattingBlock() {
/* 212 */     return getOptionFlag(font);
/*     */   }
/*     */   public void setFontFormatting(FontFormatting paramFontFormatting) {
/* 215 */     this._fontFormatting = paramFontFormatting;
/* 216 */     setOptionFlag((paramFontFormatting != null), font);
/*     */   }
/*     */   public FontFormatting getFontFormatting() {
/* 219 */     if (containsFontFormattingBlock()) {
/* 220 */       return this._fontFormatting;
/*     */     }
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   public boolean containsAlignFormattingBlock() {
/* 226 */     return getOptionFlag(align);
/*     */   }
/*     */   public void setAlignFormattingUnchanged() {
/* 229 */     setOptionFlag(false, align);
/*     */   }
/*     */   
/*     */   public boolean containsBorderFormattingBlock() {
/* 233 */     return getOptionFlag(bord);
/*     */   }
/*     */   public void setBorderFormatting(BorderFormatting paramBorderFormatting) {
/* 236 */     this._borderFormatting = paramBorderFormatting;
/* 237 */     setOptionFlag((paramBorderFormatting != null), bord);
/*     */   }
/*     */   public BorderFormatting getBorderFormatting() {
/* 240 */     if (containsBorderFormattingBlock()) {
/* 241 */       return this._borderFormatting;
/*     */     }
/* 243 */     return null;
/*     */   }
/*     */   
/*     */   public boolean containsPatternFormattingBlock() {
/* 247 */     return getOptionFlag(patt);
/*     */   }
/*     */   public void setPatternFormatting(PatternFormatting paramPatternFormatting) {
/* 250 */     this._patternFormatting = paramPatternFormatting;
/* 251 */     setOptionFlag((paramPatternFormatting != null), patt);
/*     */   }
/*     */   public PatternFormatting getPatternFormatting() {
/* 254 */     if (containsPatternFormattingBlock())
/*     */     {
/* 256 */       return this._patternFormatting;
/*     */     }
/* 258 */     return null;
/*     */   }
/*     */   
/*     */   public boolean containsProtectionFormattingBlock() {
/* 262 */     return getOptionFlag(prot);
/*     */   }
/*     */   public void setProtectionFormattingUnchanged() {
/* 265 */     setOptionFlag(false, prot);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOptions() {
/* 274 */     return this.formatting_options;
/*     */   }
/*     */   
/*     */   private boolean isModified(BitField paramBitField) {
/* 278 */     return !paramBitField.isSet(this.formatting_options);
/*     */   }
/*     */   private void setModified(boolean paramBoolean, BitField paramBitField) {
/* 281 */     this.formatting_options = paramBitField.setBoolean(this.formatting_options, !paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean isLeftBorderModified() {
/* 285 */     return isModified(bordLeft);
/*     */   }
/*     */   public void setLeftBorderModified(boolean paramBoolean) {
/* 288 */     setModified(paramBoolean, bordLeft);
/*     */   }
/*     */   
/*     */   public boolean isRightBorderModified() {
/* 292 */     return isModified(bordRight);
/*     */   }
/*     */   
/*     */   public void setRightBorderModified(boolean paramBoolean) {
/* 296 */     setModified(paramBoolean, bordRight);
/*     */   }
/*     */   
/*     */   public boolean isTopBorderModified() {
/* 300 */     return isModified(bordTop);
/*     */   }
/*     */   public void setTopBorderModified(boolean paramBoolean) {
/* 303 */     setModified(paramBoolean, bordTop);
/*     */   }
/*     */   
/*     */   public boolean isBottomBorderModified() {
/* 307 */     return isModified(bordBot);
/*     */   }
/*     */   public void setBottomBorderModified(boolean paramBoolean) {
/* 310 */     setModified(paramBoolean, bordBot);
/*     */   }
/*     */   
/*     */   public boolean isTopLeftBottomRightBorderModified() {
/* 314 */     return isModified(bordTlBr);
/*     */   }
/*     */   public void setTopLeftBottomRightBorderModified(boolean paramBoolean) {
/* 317 */     setModified(paramBoolean, bordTlBr);
/*     */   }
/*     */   
/*     */   public boolean isBottomLeftTopRightBorderModified() {
/* 321 */     return isModified(bordBlTr);
/*     */   }
/*     */   public void setBottomLeftTopRightBorderModified(boolean paramBoolean) {
/* 324 */     setModified(paramBoolean, bordBlTr);
/*     */   }
/*     */   
/*     */   public boolean isPatternStyleModified() {
/* 328 */     return isModified(pattStyle);
/*     */   }
/*     */   public void setPatternStyleModified(boolean paramBoolean) {
/* 331 */     setModified(paramBoolean, pattStyle);
/*     */   }
/*     */   
/*     */   public boolean isPatternColorModified() {
/* 335 */     return isModified(pattCol);
/*     */   }
/*     */   public void setPatternColorModified(boolean paramBoolean) {
/* 338 */     setModified(paramBoolean, pattCol);
/*     */   }
/*     */   
/*     */   public boolean isPatternBackgroundColorModified() {
/* 342 */     return isModified(pattBgCol);
/*     */   }
/*     */   public void setPatternBackgroundColorModified(boolean paramBoolean) {
/* 345 */     setModified(paramBoolean, pattBgCol);
/*     */   }
/*     */   
/*     */   private boolean getOptionFlag(BitField paramBitField) {
/* 349 */     return paramBitField.isSet(this.formatting_options);
/*     */   }
/*     */   private void setOptionFlag(boolean paramBoolean, BitField paramBitField) {
/* 352 */     this.formatting_options = paramBitField.setBoolean(this.formatting_options, paramBoolean);
/*     */   }
/*     */   
/*     */   protected int getFormattingBlockSize() {
/* 356 */     return 6 + (containsFontFormattingBlock() ? (this._fontFormatting.getRawRecord()).length : 0) + (containsBorderFormattingBlock() ? 8 : 0) + (containsPatternFormattingBlock() ? 4 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void serializeFormattingBlock(LittleEndianOutput paramLittleEndianOutput) {
/* 362 */     paramLittleEndianOutput.writeInt(this.formatting_options);
/* 363 */     paramLittleEndianOutput.writeShort(this.formatting_not_used);
/*     */     
/* 365 */     if (containsFontFormattingBlock()) {
/* 366 */       byte[] arrayOfByte = this._fontFormatting.getRawRecord();
/* 367 */       paramLittleEndianOutput.write(arrayOfByte);
/*     */     } 
/*     */     
/* 370 */     if (containsBorderFormattingBlock()) {
/* 371 */       this._borderFormatting.serialize(paramLittleEndianOutput);
/*     */     }
/*     */     
/* 374 */     if (containsPatternFormattingBlock()) {
/* 375 */       this._patternFormatting.serialize(paramLittleEndianOutput);
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
/*     */   public Ptg[] getParsedExpression1() {
/* 388 */     return this.formula1.getTokens();
/*     */   }
/*     */   public void setParsedExpression1(Ptg[] paramArrayOfPtg) {
/* 391 */     this.formula1 = Formula.create(paramArrayOfPtg);
/*     */   }
/*     */   protected Formula getFormula1() {
/* 394 */     return this.formula1;
/*     */   }
/*     */   protected void setFormula1(Formula paramFormula) {
/* 397 */     this.formula1 = paramFormula;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ptg[] getParsedExpression2() {
/* 406 */     return Formula.getTokens(this.formula2);
/*     */   }
/*     */   public void setParsedExpression2(Ptg[] paramArrayOfPtg) {
/* 409 */     this.formula2 = Formula.create(paramArrayOfPtg);
/*     */   }
/*     */   protected Formula getFormula2() {
/* 412 */     return this.formula2;
/*     */   }
/*     */   protected void setFormula2(Formula paramFormula) {
/* 415 */     this.formula2 = paramFormula;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static int getFormulaSize(Formula paramFormula) {
/* 423 */     return paramFormula.getEncodedTokenSize();
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
/*     */   public static Ptg[] parseFormula(String paramString, HSSFSheet paramHSSFSheet) {
/* 437 */     if (paramString == null) {
/* 438 */       return null;
/*     */     }
/* 440 */     int i = paramHSSFSheet.getWorkbook().getSheetIndex((Sheet)paramHSSFSheet);
/* 441 */     return HSSFFormulaParser.parse(paramString, paramHSSFSheet.getWorkbook(), FormulaType.CELL, i);
/*     */   }
/*     */   
/*     */   protected void copyTo(CFRuleBase paramCFRuleBase) {
/* 445 */     paramCFRuleBase.condition_type = this.condition_type;
/* 446 */     paramCFRuleBase.comparison_operator = this.comparison_operator;
/*     */     
/* 448 */     paramCFRuleBase.formatting_options = this.formatting_options;
/* 449 */     paramCFRuleBase.formatting_not_used = this.formatting_not_used;
/* 450 */     if (containsFontFormattingBlock()) {
/* 451 */       paramCFRuleBase._fontFormatting = this._fontFormatting.clone();
/*     */     }
/* 453 */     if (containsBorderFormattingBlock()) {
/* 454 */       paramCFRuleBase._borderFormatting = this._borderFormatting.clone();
/*     */     }
/* 456 */     if (containsPatternFormattingBlock()) {
/* 457 */       paramCFRuleBase._patternFormatting = (PatternFormatting)this._patternFormatting.clone();
/*     */     }
/*     */     
/* 460 */     paramCFRuleBase.setFormula1(getFormula1().copy());
/* 461 */     paramCFRuleBase.setFormula2(getFormula2().copy());
/*     */   }
/*     */   
/*     */   public abstract CFRuleBase clone();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CFRuleBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */