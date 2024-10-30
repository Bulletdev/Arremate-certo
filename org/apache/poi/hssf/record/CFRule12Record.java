/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.hssf.record.cf.ColorGradientFormatting;
/*     */ import org.apache.poi.hssf.record.cf.ColorGradientThreshold;
/*     */ import org.apache.poi.hssf.record.cf.DataBarFormatting;
/*     */ import org.apache.poi.hssf.record.cf.DataBarThreshold;
/*     */ import org.apache.poi.hssf.record.cf.IconMultiStateFormatting;
/*     */ import org.apache.poi.hssf.record.cf.IconMultiStateThreshold;
/*     */ import org.apache.poi.hssf.record.cf.Threshold;
/*     */ import org.apache.poi.hssf.record.common.ExtendedColor;
/*     */ import org.apache.poi.hssf.record.common.FtrHeader;
/*     */ import org.apache.poi.hssf.record.common.FutureRecord;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.usermodel.ConditionalFormattingThreshold;
/*     */ import org.apache.poi.ss.usermodel.IconMultiStateFormatting;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CFRule12Record
/*     */   extends CFRuleBase
/*     */   implements Cloneable, FutureRecord
/*     */ {
/*     */   public static final short sid = 2170;
/*     */   private FtrHeader futureHeader;
/*     */   private int ext_formatting_length;
/*     */   private byte[] ext_formatting_data;
/*     */   private Formula formula_scale;
/*     */   private byte ext_opts;
/*     */   private int priority;
/*     */   private int template_type;
/*     */   private byte template_param_length;
/*     */   private byte[] template_params;
/*     */   private DataBarFormatting data_bar;
/*     */   private IconMultiStateFormatting multistate;
/*     */   private ColorGradientFormatting color_gradient;
/*     */   private byte[] filter_data;
/*     */   
/*     */   private CFRule12Record(byte paramByte1, byte paramByte2) {
/*  73 */     super(paramByte1, paramByte2);
/*  74 */     setDefaults();
/*     */   }
/*     */   
/*     */   private CFRule12Record(byte paramByte1, byte paramByte2, Ptg[] paramArrayOfPtg1, Ptg[] paramArrayOfPtg2, Ptg[] paramArrayOfPtg3) {
/*  78 */     super(paramByte1, paramByte2, paramArrayOfPtg1, paramArrayOfPtg2);
/*  79 */     setDefaults();
/*  80 */     this.formula_scale = Formula.create(paramArrayOfPtg3);
/*     */   }
/*     */   private void setDefaults() {
/*  83 */     this.futureHeader = new FtrHeader();
/*  84 */     this.futureHeader.setRecordType((short)2170);
/*     */     
/*  86 */     this.ext_formatting_length = 0;
/*  87 */     this.ext_formatting_data = new byte[4];
/*     */     
/*  89 */     this.formula_scale = Formula.create(Ptg.EMPTY_PTG_ARRAY);
/*     */     
/*  91 */     this.ext_opts = 0;
/*  92 */     this.priority = 0;
/*  93 */     this.template_type = getConditionType();
/*  94 */     this.template_param_length = 16;
/*  95 */     this.template_params = new byte[this.template_param_length];
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
/*     */   public static CFRule12Record create(HSSFSheet paramHSSFSheet, String paramString) {
/* 107 */     Ptg[] arrayOfPtg = parseFormula(paramString, paramHSSFSheet);
/* 108 */     return new CFRule12Record((byte)2, (byte)0, arrayOfPtg, null, null);
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
/*     */   public static CFRule12Record create(HSSFSheet paramHSSFSheet, byte paramByte, String paramString1, String paramString2) {
/* 124 */     Ptg[] arrayOfPtg1 = parseFormula(paramString1, paramHSSFSheet);
/* 125 */     Ptg[] arrayOfPtg2 = parseFormula(paramString2, paramHSSFSheet);
/* 126 */     return new CFRule12Record((byte)1, paramByte, arrayOfPtg1, arrayOfPtg2, null);
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
/*     */   public static CFRule12Record create(HSSFSheet paramHSSFSheet, byte paramByte, String paramString1, String paramString2, String paramString3) {
/* 143 */     Ptg[] arrayOfPtg1 = parseFormula(paramString1, paramHSSFSheet);
/* 144 */     Ptg[] arrayOfPtg2 = parseFormula(paramString2, paramHSSFSheet);
/* 145 */     Ptg[] arrayOfPtg3 = parseFormula(paramString3, paramHSSFSheet);
/* 146 */     return new CFRule12Record((byte)1, paramByte, arrayOfPtg1, arrayOfPtg2, arrayOfPtg3);
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
/*     */   public static CFRule12Record create(HSSFSheet paramHSSFSheet, ExtendedColor paramExtendedColor) {
/* 159 */     CFRule12Record cFRule12Record = new CFRule12Record((byte)4, (byte)0);
/*     */     
/* 161 */     DataBarFormatting dataBarFormatting = cFRule12Record.createDataBarFormatting();
/* 162 */     dataBarFormatting.setColor(paramExtendedColor);
/* 163 */     dataBarFormatting.setPercentMin((byte)0);
/* 164 */     dataBarFormatting.setPercentMax((byte)100);
/*     */     
/* 166 */     DataBarThreshold dataBarThreshold1 = new DataBarThreshold();
/* 167 */     dataBarThreshold1.setType(ConditionalFormattingThreshold.RangeType.MIN.id);
/* 168 */     dataBarFormatting.setThresholdMin(dataBarThreshold1);
/*     */     
/* 170 */     DataBarThreshold dataBarThreshold2 = new DataBarThreshold();
/* 171 */     dataBarThreshold2.setType(ConditionalFormattingThreshold.RangeType.MAX.id);
/* 172 */     dataBarFormatting.setThresholdMax(dataBarThreshold2);
/*     */     
/* 174 */     return cFRule12Record;
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
/*     */   public static CFRule12Record create(HSSFSheet paramHSSFSheet, IconMultiStateFormatting.IconSet paramIconSet) {
/* 186 */     Threshold[] arrayOfThreshold = new Threshold[paramIconSet.num];
/* 187 */     for (byte b = 0; b < arrayOfThreshold.length; b++) {
/* 188 */       arrayOfThreshold[b] = (Threshold)new IconMultiStateThreshold();
/*     */     }
/*     */     
/* 191 */     CFRule12Record cFRule12Record = new CFRule12Record((byte)6, (byte)0);
/*     */     
/* 193 */     IconMultiStateFormatting iconMultiStateFormatting = cFRule12Record.createMultiStateFormatting();
/* 194 */     iconMultiStateFormatting.setIconSet(paramIconSet);
/* 195 */     iconMultiStateFormatting.setThresholds(arrayOfThreshold);
/* 196 */     return cFRule12Record;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CFRule12Record createColorScale(HSSFSheet paramHSSFSheet) {
/* 207 */     byte b1 = 3;
/* 208 */     ExtendedColor[] arrayOfExtendedColor = new ExtendedColor[b1];
/* 209 */     ColorGradientThreshold[] arrayOfColorGradientThreshold = new ColorGradientThreshold[b1];
/* 210 */     for (byte b2 = 0; b2 < arrayOfColorGradientThreshold.length; b2++) {
/* 211 */       arrayOfColorGradientThreshold[b2] = new ColorGradientThreshold();
/* 212 */       arrayOfExtendedColor[b2] = new ExtendedColor();
/*     */     } 
/*     */     
/* 215 */     CFRule12Record cFRule12Record = new CFRule12Record((byte)3, (byte)0);
/*     */     
/* 217 */     ColorGradientFormatting colorGradientFormatting = cFRule12Record.createColorGradientFormatting();
/* 218 */     colorGradientFormatting.setNumControlPoints(b1);
/* 219 */     colorGradientFormatting.setThresholds(arrayOfColorGradientThreshold);
/* 220 */     colorGradientFormatting.setColors(arrayOfExtendedColor);
/* 221 */     return cFRule12Record;
/*     */   }
/*     */   
/*     */   public CFRule12Record(RecordInputStream paramRecordInputStream) {
/* 225 */     this.futureHeader = new FtrHeader(paramRecordInputStream);
/* 226 */     setConditionType(paramRecordInputStream.readByte());
/* 227 */     setComparisonOperation(paramRecordInputStream.readByte());
/* 228 */     int i = paramRecordInputStream.readUShort();
/* 229 */     int j = paramRecordInputStream.readUShort();
/*     */     
/* 231 */     this.ext_formatting_length = paramRecordInputStream.readInt();
/* 232 */     this.ext_formatting_data = new byte[0];
/* 233 */     if (this.ext_formatting_length == 0) {
/*     */       
/* 235 */       paramRecordInputStream.readUShort();
/*     */     } else {
/* 237 */       int m = readFormatOptions(paramRecordInputStream);
/* 238 */       if (m < this.ext_formatting_length) {
/* 239 */         this.ext_formatting_data = new byte[this.ext_formatting_length - m];
/* 240 */         paramRecordInputStream.readFully(this.ext_formatting_data);
/*     */       } 
/*     */     } 
/*     */     
/* 244 */     setFormula1(Formula.read(i, paramRecordInputStream));
/* 245 */     setFormula2(Formula.read(j, paramRecordInputStream));
/*     */     
/* 247 */     int k = paramRecordInputStream.readUShort();
/* 248 */     this.formula_scale = Formula.read(k, paramRecordInputStream);
/*     */     
/* 250 */     this.ext_opts = paramRecordInputStream.readByte();
/* 251 */     this.priority = paramRecordInputStream.readUShort();
/* 252 */     this.template_type = paramRecordInputStream.readUShort();
/* 253 */     this.template_param_length = paramRecordInputStream.readByte();
/* 254 */     if (this.template_param_length == 0 || this.template_param_length == 16) {
/* 255 */       this.template_params = new byte[this.template_param_length];
/* 256 */       paramRecordInputStream.readFully(this.template_params);
/*     */     } else {
/* 258 */       logger.log(5, new Object[] { "CF Rule v12 template params length should be 0 or 16, found " + this.template_param_length });
/* 259 */       paramRecordInputStream.readRemainder();
/*     */     } 
/*     */     
/* 262 */     byte b = getConditionType();
/* 263 */     if (b == 3) {
/* 264 */       this.color_gradient = new ColorGradientFormatting(paramRecordInputStream);
/* 265 */     } else if (b == 4) {
/* 266 */       this.data_bar = new DataBarFormatting(paramRecordInputStream);
/* 267 */     } else if (b == 5) {
/* 268 */       this.filter_data = paramRecordInputStream.readRemainder();
/* 269 */     } else if (b == 6) {
/* 270 */       this.multistate = new IconMultiStateFormatting(paramRecordInputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean containsDataBarBlock() {
/* 275 */     return (this.data_bar != null);
/*     */   }
/*     */   public DataBarFormatting getDataBarFormatting() {
/* 278 */     return this.data_bar;
/*     */   }
/*     */   public DataBarFormatting createDataBarFormatting() {
/* 281 */     if (this.data_bar != null) return this.data_bar;
/*     */ 
/*     */     
/* 284 */     setConditionType((byte)4);
/* 285 */     this.data_bar = new DataBarFormatting();
/* 286 */     return this.data_bar;
/*     */   }
/*     */   
/*     */   public boolean containsMultiStateBlock() {
/* 290 */     return (this.multistate != null);
/*     */   }
/*     */   public IconMultiStateFormatting getMultiStateFormatting() {
/* 293 */     return this.multistate;
/*     */   }
/*     */   public IconMultiStateFormatting createMultiStateFormatting() {
/* 296 */     if (this.multistate != null) return this.multistate;
/*     */ 
/*     */     
/* 299 */     setConditionType((byte)6);
/* 300 */     this.multistate = new IconMultiStateFormatting();
/* 301 */     return this.multistate;
/*     */   }
/*     */   
/*     */   public boolean containsColorGradientBlock() {
/* 305 */     return (this.color_gradient != null);
/*     */   }
/*     */   public ColorGradientFormatting getColorGradientFormatting() {
/* 308 */     return this.color_gradient;
/*     */   }
/*     */   public ColorGradientFormatting createColorGradientFormatting() {
/* 311 */     if (this.color_gradient != null) return this.color_gradient;
/*     */ 
/*     */     
/* 314 */     setConditionType((byte)3);
/* 315 */     this.color_gradient = new ColorGradientFormatting();
/* 316 */     return this.color_gradient;
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
/*     */   public Ptg[] getParsedExpressionScale() {
/* 328 */     return this.formula_scale.getTokens();
/*     */   }
/*     */   public void setParsedExpressionScale(Ptg[] paramArrayOfPtg) {
/* 331 */     this.formula_scale = Formula.create(paramArrayOfPtg);
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 335 */     return 2170;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 346 */     this.futureHeader.serialize(paramLittleEndianOutput);
/*     */     
/* 348 */     int i = getFormulaSize(getFormula1());
/* 349 */     int j = getFormulaSize(getFormula2());
/*     */     
/* 351 */     paramLittleEndianOutput.writeByte(getConditionType());
/* 352 */     paramLittleEndianOutput.writeByte(getComparisonOperation());
/* 353 */     paramLittleEndianOutput.writeShort(i);
/* 354 */     paramLittleEndianOutput.writeShort(j);
/*     */ 
/*     */     
/* 357 */     if (this.ext_formatting_length == 0) {
/* 358 */       paramLittleEndianOutput.writeInt(0);
/* 359 */       paramLittleEndianOutput.writeShort(0);
/*     */     } else {
/* 361 */       paramLittleEndianOutput.writeInt(this.ext_formatting_length);
/* 362 */       serializeFormattingBlock(paramLittleEndianOutput);
/* 363 */       paramLittleEndianOutput.write(this.ext_formatting_data);
/*     */     } 
/*     */     
/* 366 */     getFormula1().serializeTokens(paramLittleEndianOutput);
/* 367 */     getFormula2().serializeTokens(paramLittleEndianOutput);
/* 368 */     paramLittleEndianOutput.writeShort(getFormulaSize(this.formula_scale));
/* 369 */     this.formula_scale.serializeTokens(paramLittleEndianOutput);
/*     */     
/* 371 */     paramLittleEndianOutput.writeByte(this.ext_opts);
/* 372 */     paramLittleEndianOutput.writeShort(this.priority);
/* 373 */     paramLittleEndianOutput.writeShort(this.template_type);
/* 374 */     paramLittleEndianOutput.writeByte(this.template_param_length);
/* 375 */     paramLittleEndianOutput.write(this.template_params);
/*     */     
/* 377 */     byte b = getConditionType();
/* 378 */     if (b == 3) {
/* 379 */       this.color_gradient.serialize(paramLittleEndianOutput);
/* 380 */     } else if (b == 4) {
/* 381 */       this.data_bar.serialize(paramLittleEndianOutput);
/* 382 */     } else if (b == 5) {
/* 383 */       paramLittleEndianOutput.write(this.filter_data);
/* 384 */     } else if (b == 6) {
/* 385 */       this.multistate.serialize(paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 390 */     int i = FtrHeader.getDataSize() + 6;
/* 391 */     if (this.ext_formatting_length == 0) {
/* 392 */       i += 6;
/*     */     } else {
/* 394 */       i += 4 + getFormattingBlockSize() + this.ext_formatting_data.length;
/*     */     } 
/* 396 */     i += getFormulaSize(getFormula1());
/* 397 */     i += getFormulaSize(getFormula2());
/* 398 */     i += 2 + getFormulaSize(this.formula_scale);
/* 399 */     i += 6 + this.template_params.length;
/*     */     
/* 401 */     byte b = getConditionType();
/* 402 */     if (b == 3) {
/* 403 */       i += this.color_gradient.getDataLength();
/* 404 */     } else if (b == 4) {
/* 405 */       i += this.data_bar.getDataLength();
/* 406 */     } else if (b == 5) {
/* 407 */       i += this.filter_data.length;
/* 408 */     } else if (b == 6) {
/* 409 */       i += this.multistate.getDataLength();
/*     */     } 
/* 411 */     return i;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 415 */     StringBuffer stringBuffer = new StringBuffer();
/* 416 */     stringBuffer.append("[CFRULE12]\n");
/* 417 */     stringBuffer.append("    .condition_type=").append(getConditionType()).append("\n");
/* 418 */     stringBuffer.append("    .dxfn12_length =0x").append(Integer.toHexString(this.ext_formatting_length)).append("\n");
/* 419 */     stringBuffer.append("    .option_flags  =0x").append(Integer.toHexString(getOptions())).append("\n");
/* 420 */     if (containsFontFormattingBlock()) {
/* 421 */       stringBuffer.append(this._fontFormatting.toString()).append("\n");
/*     */     }
/* 423 */     if (containsBorderFormattingBlock()) {
/* 424 */       stringBuffer.append(this._borderFormatting.toString()).append("\n");
/*     */     }
/* 426 */     if (containsPatternFormattingBlock()) {
/* 427 */       stringBuffer.append(this._patternFormatting.toString()).append("\n");
/*     */     }
/* 429 */     stringBuffer.append("    .dxfn12_ext=").append(HexDump.toHex(this.ext_formatting_data)).append("\n");
/* 430 */     stringBuffer.append("    .formula_1 =").append(Arrays.toString((Object[])getFormula1().getTokens())).append("\n");
/* 431 */     stringBuffer.append("    .formula_2 =").append(Arrays.toString((Object[])getFormula2().getTokens())).append("\n");
/* 432 */     stringBuffer.append("    .formula_S =").append(Arrays.toString((Object[])this.formula_scale.getTokens())).append("\n");
/* 433 */     stringBuffer.append("    .ext_opts  =").append(this.ext_opts).append("\n");
/* 434 */     stringBuffer.append("    .priority  =").append(this.priority).append("\n");
/* 435 */     stringBuffer.append("    .template_type  =").append(this.template_type).append("\n");
/* 436 */     stringBuffer.append("    .template_params=").append(HexDump.toHex(this.template_params)).append("\n");
/* 437 */     stringBuffer.append("    .filter_data    =").append(HexDump.toHex(this.filter_data)).append("\n");
/* 438 */     if (this.color_gradient != null) {
/* 439 */       stringBuffer.append(this.color_gradient);
/*     */     }
/* 441 */     if (this.multistate != null) {
/* 442 */       stringBuffer.append(this.multistate);
/*     */     }
/* 444 */     if (this.data_bar != null) {
/* 445 */       stringBuffer.append(this.data_bar);
/*     */     }
/* 447 */     stringBuffer.append("[/CFRULE12]\n");
/* 448 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public CFRule12Record clone() {
/* 453 */     CFRule12Record cFRule12Record = new CFRule12Record(getConditionType(), getComparisonOperation());
/* 454 */     cFRule12Record.futureHeader.setAssociatedRange(this.futureHeader.getAssociatedRange().copy());
/*     */     
/* 456 */     copyTo(cFRule12Record);
/*     */     
/* 458 */     cFRule12Record.ext_formatting_length = this.ext_formatting_length;
/* 459 */     cFRule12Record.ext_formatting_data = new byte[this.ext_formatting_length];
/* 460 */     System.arraycopy(this.ext_formatting_data, 0, cFRule12Record.ext_formatting_data, 0, this.ext_formatting_length);
/*     */     
/* 462 */     cFRule12Record.formula_scale = this.formula_scale.copy();
/*     */     
/* 464 */     cFRule12Record.ext_opts = this.ext_opts;
/* 465 */     cFRule12Record.priority = this.priority;
/* 466 */     cFRule12Record.template_type = this.template_type;
/* 467 */     cFRule12Record.template_param_length = this.template_param_length;
/* 468 */     cFRule12Record.template_params = new byte[this.template_param_length];
/* 469 */     System.arraycopy(this.template_params, 0, cFRule12Record.template_params, 0, this.template_param_length);
/*     */     
/* 471 */     if (this.color_gradient != null) {
/* 472 */       cFRule12Record.color_gradient = (ColorGradientFormatting)this.color_gradient.clone();
/*     */     }
/* 474 */     if (this.multistate != null) {
/* 475 */       cFRule12Record.multistate = (IconMultiStateFormatting)this.multistate.clone();
/*     */     }
/* 477 */     if (this.data_bar != null) {
/* 478 */       cFRule12Record.data_bar = (DataBarFormatting)this.data_bar.clone();
/*     */     }
/* 480 */     if (this.filter_data != null) {
/* 481 */       cFRule12Record.filter_data = new byte[this.filter_data.length];
/* 482 */       System.arraycopy(this.filter_data, 0, cFRule12Record.filter_data, 0, this.filter_data.length);
/*     */     } 
/*     */     
/* 485 */     return cFRule12Record;
/*     */   }
/*     */   
/*     */   public short getFutureRecordType() {
/* 489 */     return this.futureHeader.getRecordType();
/*     */   }
/*     */   public FtrHeader getFutureHeader() {
/* 492 */     return this.futureHeader;
/*     */   }
/*     */   public CellRangeAddress getAssociatedRange() {
/* 495 */     return this.futureHeader.getAssociatedRange();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CFRule12Record.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */