/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ public final class AxisOptionsRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4194;
/*  35 */   private static final BitField defaultMinimum = BitFieldFactory.getInstance(1);
/*  36 */   private static final BitField defaultMaximum = BitFieldFactory.getInstance(2);
/*  37 */   private static final BitField defaultMajor = BitFieldFactory.getInstance(4);
/*  38 */   private static final BitField defaultMinorUnit = BitFieldFactory.getInstance(8);
/*  39 */   private static final BitField isDate = BitFieldFactory.getInstance(16);
/*  40 */   private static final BitField defaultBase = BitFieldFactory.getInstance(32);
/*  41 */   private static final BitField defaultCross = BitFieldFactory.getInstance(64);
/*  42 */   private static final BitField defaultDateSettings = BitFieldFactory.getInstance(128);
/*     */   
/*     */   private short field_1_minimumCategory;
/*     */   
/*     */   private short field_2_maximumCategory;
/*     */   
/*     */   private short field_3_majorUnitValue;
/*     */   
/*     */   private short field_4_majorUnit;
/*     */   
/*     */   private short field_5_minorUnitValue;
/*     */   
/*     */   private short field_6_minorUnit;
/*     */   private short field_7_baseUnit;
/*     */   private short field_8_crossingPoint;
/*     */   private short field_9_options;
/*     */   
/*     */   public AxisOptionsRecord() {}
/*     */   
/*     */   public AxisOptionsRecord(RecordInputStream paramRecordInputStream) {
/*  62 */     this.field_1_minimumCategory = paramRecordInputStream.readShort();
/*  63 */     this.field_2_maximumCategory = paramRecordInputStream.readShort();
/*  64 */     this.field_3_majorUnitValue = paramRecordInputStream.readShort();
/*  65 */     this.field_4_majorUnit = paramRecordInputStream.readShort();
/*  66 */     this.field_5_minorUnitValue = paramRecordInputStream.readShort();
/*  67 */     this.field_6_minorUnit = paramRecordInputStream.readShort();
/*  68 */     this.field_7_baseUnit = paramRecordInputStream.readShort();
/*  69 */     this.field_8_crossingPoint = paramRecordInputStream.readShort();
/*  70 */     this.field_9_options = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  75 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  77 */     stringBuffer.append("[AXCEXT]\n");
/*  78 */     stringBuffer.append("    .minimumCategory      = ").append("0x").append(HexDump.toHex(getMinimumCategory())).append(" (").append(getMinimumCategory()).append(" )");
/*     */ 
/*     */     
/*  81 */     stringBuffer.append(System.getProperty("line.separator"));
/*  82 */     stringBuffer.append("    .maximumCategory      = ").append("0x").append(HexDump.toHex(getMaximumCategory())).append(" (").append(getMaximumCategory()).append(" )");
/*     */ 
/*     */     
/*  85 */     stringBuffer.append(System.getProperty("line.separator"));
/*  86 */     stringBuffer.append("    .majorUnitValue       = ").append("0x").append(HexDump.toHex(getMajorUnitValue())).append(" (").append(getMajorUnitValue()).append(" )");
/*     */ 
/*     */     
/*  89 */     stringBuffer.append(System.getProperty("line.separator"));
/*  90 */     stringBuffer.append("    .majorUnit            = ").append("0x").append(HexDump.toHex(getMajorUnit())).append(" (").append(getMajorUnit()).append(" )");
/*     */ 
/*     */     
/*  93 */     stringBuffer.append(System.getProperty("line.separator"));
/*  94 */     stringBuffer.append("    .minorUnitValue       = ").append("0x").append(HexDump.toHex(getMinorUnitValue())).append(" (").append(getMinorUnitValue()).append(" )");
/*     */ 
/*     */     
/*  97 */     stringBuffer.append(System.getProperty("line.separator"));
/*  98 */     stringBuffer.append("    .minorUnit            = ").append("0x").append(HexDump.toHex(getMinorUnit())).append(" (").append(getMinorUnit()).append(" )");
/*     */ 
/*     */     
/* 101 */     stringBuffer.append(System.getProperty("line.separator"));
/* 102 */     stringBuffer.append("    .baseUnit             = ").append("0x").append(HexDump.toHex(getBaseUnit())).append(" (").append(getBaseUnit()).append(" )");
/*     */ 
/*     */     
/* 105 */     stringBuffer.append(System.getProperty("line.separator"));
/* 106 */     stringBuffer.append("    .crossingPoint        = ").append("0x").append(HexDump.toHex(getCrossingPoint())).append(" (").append(getCrossingPoint()).append(" )");
/*     */ 
/*     */     
/* 109 */     stringBuffer.append(System.getProperty("line.separator"));
/* 110 */     stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append(getOptions()).append(" )");
/*     */ 
/*     */     
/* 113 */     stringBuffer.append(System.getProperty("line.separator"));
/* 114 */     stringBuffer.append("         .defaultMinimum           = ").append(isDefaultMinimum()).append('\n');
/* 115 */     stringBuffer.append("         .defaultMaximum           = ").append(isDefaultMaximum()).append('\n');
/* 116 */     stringBuffer.append("         .defaultMajor             = ").append(isDefaultMajor()).append('\n');
/* 117 */     stringBuffer.append("         .defaultMinorUnit         = ").append(isDefaultMinorUnit()).append('\n');
/* 118 */     stringBuffer.append("         .isDate                   = ").append(isIsDate()).append('\n');
/* 119 */     stringBuffer.append("         .defaultBase              = ").append(isDefaultBase()).append('\n');
/* 120 */     stringBuffer.append("         .defaultCross             = ").append(isDefaultCross()).append('\n');
/* 121 */     stringBuffer.append("         .defaultDateSettings      = ").append(isDefaultDateSettings()).append('\n');
/*     */     
/* 123 */     stringBuffer.append("[/AXCEXT]\n");
/* 124 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 128 */     paramLittleEndianOutput.writeShort(this.field_1_minimumCategory);
/* 129 */     paramLittleEndianOutput.writeShort(this.field_2_maximumCategory);
/* 130 */     paramLittleEndianOutput.writeShort(this.field_3_majorUnitValue);
/* 131 */     paramLittleEndianOutput.writeShort(this.field_4_majorUnit);
/* 132 */     paramLittleEndianOutput.writeShort(this.field_5_minorUnitValue);
/* 133 */     paramLittleEndianOutput.writeShort(this.field_6_minorUnit);
/* 134 */     paramLittleEndianOutput.writeShort(this.field_7_baseUnit);
/* 135 */     paramLittleEndianOutput.writeShort(this.field_8_crossingPoint);
/* 136 */     paramLittleEndianOutput.writeShort(this.field_9_options);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 140 */     return 18;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 145 */     return 4194;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisOptionsRecord clone() {
/* 150 */     AxisOptionsRecord axisOptionsRecord = new AxisOptionsRecord();
/*     */     
/* 152 */     axisOptionsRecord.field_1_minimumCategory = this.field_1_minimumCategory;
/* 153 */     axisOptionsRecord.field_2_maximumCategory = this.field_2_maximumCategory;
/* 154 */     axisOptionsRecord.field_3_majorUnitValue = this.field_3_majorUnitValue;
/* 155 */     axisOptionsRecord.field_4_majorUnit = this.field_4_majorUnit;
/* 156 */     axisOptionsRecord.field_5_minorUnitValue = this.field_5_minorUnitValue;
/* 157 */     axisOptionsRecord.field_6_minorUnit = this.field_6_minorUnit;
/* 158 */     axisOptionsRecord.field_7_baseUnit = this.field_7_baseUnit;
/* 159 */     axisOptionsRecord.field_8_crossingPoint = this.field_8_crossingPoint;
/* 160 */     axisOptionsRecord.field_9_options = this.field_9_options;
/* 161 */     return axisOptionsRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMinimumCategory() {
/* 172 */     return this.field_1_minimumCategory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumCategory(short paramShort) {
/* 180 */     this.field_1_minimumCategory = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMaximumCategory() {
/* 188 */     return this.field_2_maximumCategory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumCategory(short paramShort) {
/* 196 */     this.field_2_maximumCategory = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMajorUnitValue() {
/* 204 */     return this.field_3_majorUnitValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMajorUnitValue(short paramShort) {
/* 212 */     this.field_3_majorUnitValue = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMajorUnit() {
/* 220 */     return this.field_4_majorUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMajorUnit(short paramShort) {
/* 228 */     this.field_4_majorUnit = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMinorUnitValue() {
/* 236 */     return this.field_5_minorUnitValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinorUnitValue(short paramShort) {
/* 244 */     this.field_5_minorUnitValue = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getMinorUnit() {
/* 252 */     return this.field_6_minorUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinorUnit(short paramShort) {
/* 260 */     this.field_6_minorUnit = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBaseUnit() {
/* 268 */     return this.field_7_baseUnit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBaseUnit(short paramShort) {
/* 276 */     this.field_7_baseUnit = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCrossingPoint() {
/* 284 */     return this.field_8_crossingPoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossingPoint(short paramShort) {
/* 292 */     this.field_8_crossingPoint = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 300 */     return this.field_9_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 308 */     this.field_9_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultMinimum(boolean paramBoolean) {
/* 317 */     this.field_9_options = defaultMinimum.setShortBoolean(this.field_9_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultMinimum() {
/* 326 */     return defaultMinimum.isSet(this.field_9_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultMaximum(boolean paramBoolean) {
/* 335 */     this.field_9_options = defaultMaximum.setShortBoolean(this.field_9_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultMaximum() {
/* 344 */     return defaultMaximum.isSet(this.field_9_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultMajor(boolean paramBoolean) {
/* 353 */     this.field_9_options = defaultMajor.setShortBoolean(this.field_9_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultMajor() {
/* 362 */     return defaultMajor.isSet(this.field_9_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultMinorUnit(boolean paramBoolean) {
/* 371 */     this.field_9_options = defaultMinorUnit.setShortBoolean(this.field_9_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultMinorUnit() {
/* 380 */     return defaultMinorUnit.isSet(this.field_9_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsDate(boolean paramBoolean) {
/* 389 */     this.field_9_options = isDate.setShortBoolean(this.field_9_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isIsDate() {
/* 398 */     return isDate.isSet(this.field_9_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultBase(boolean paramBoolean) {
/* 407 */     this.field_9_options = defaultBase.setShortBoolean(this.field_9_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultBase() {
/* 416 */     return defaultBase.isSet(this.field_9_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultCross(boolean paramBoolean) {
/* 425 */     this.field_9_options = defaultCross.setShortBoolean(this.field_9_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultCross() {
/* 434 */     return defaultCross.isSet(this.field_9_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultDateSettings(boolean paramBoolean) {
/* 443 */     this.field_9_options = defaultDateSettings.setShortBoolean(this.field_9_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultDateSettings() {
/* 452 */     return defaultDateSettings.isSet(this.field_9_options);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\AxisOptionsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */