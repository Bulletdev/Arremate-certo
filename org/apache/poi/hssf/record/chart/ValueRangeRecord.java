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
/*     */ public final class ValueRangeRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4127;
/*  33 */   private static final BitField automaticMinimum = BitFieldFactory.getInstance(1);
/*  34 */   private static final BitField automaticMaximum = BitFieldFactory.getInstance(2);
/*  35 */   private static final BitField automaticMajor = BitFieldFactory.getInstance(4);
/*  36 */   private static final BitField automaticMinor = BitFieldFactory.getInstance(8);
/*  37 */   private static final BitField automaticCategoryCrossing = BitFieldFactory.getInstance(16);
/*  38 */   private static final BitField logarithmicScale = BitFieldFactory.getInstance(32);
/*  39 */   private static final BitField valuesInReverse = BitFieldFactory.getInstance(64);
/*  40 */   private static final BitField crossCategoryAxisAtMaximum = BitFieldFactory.getInstance(128);
/*  41 */   private static final BitField reserved = BitFieldFactory.getInstance(256);
/*     */   
/*     */   private double field_1_minimumAxisValue;
/*     */   
/*     */   private double field_2_maximumAxisValue;
/*     */   
/*     */   private double field_3_majorIncrement;
/*     */   
/*     */   private double field_4_minorIncrement;
/*     */   
/*     */   private double field_5_categoryAxisCross;
/*     */   
/*     */   private short field_6_options;
/*     */   
/*     */   public ValueRangeRecord() {}
/*     */   
/*     */   public ValueRangeRecord(RecordInputStream paramRecordInputStream) {
/*  58 */     this.field_1_minimumAxisValue = paramRecordInputStream.readDouble();
/*  59 */     this.field_2_maximumAxisValue = paramRecordInputStream.readDouble();
/*  60 */     this.field_3_majorIncrement = paramRecordInputStream.readDouble();
/*  61 */     this.field_4_minorIncrement = paramRecordInputStream.readDouble();
/*  62 */     this.field_5_categoryAxisCross = paramRecordInputStream.readDouble();
/*  63 */     this.field_6_options = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  69 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  71 */     stringBuffer.append("[VALUERANGE]\n");
/*  72 */     stringBuffer.append("    .minimumAxisValue     = ").append(" (").append(getMinimumAxisValue()).append(" )");
/*     */     
/*  74 */     stringBuffer.append(System.getProperty("line.separator"));
/*  75 */     stringBuffer.append("    .maximumAxisValue     = ").append(" (").append(getMaximumAxisValue()).append(" )");
/*     */     
/*  77 */     stringBuffer.append(System.getProperty("line.separator"));
/*  78 */     stringBuffer.append("    .majorIncrement       = ").append(" (").append(getMajorIncrement()).append(" )");
/*     */     
/*  80 */     stringBuffer.append(System.getProperty("line.separator"));
/*  81 */     stringBuffer.append("    .minorIncrement       = ").append(" (").append(getMinorIncrement()).append(" )");
/*     */     
/*  83 */     stringBuffer.append(System.getProperty("line.separator"));
/*  84 */     stringBuffer.append("    .categoryAxisCross    = ").append(" (").append(getCategoryAxisCross()).append(" )");
/*     */     
/*  86 */     stringBuffer.append(System.getProperty("line.separator"));
/*  87 */     stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append(getOptions()).append(" )");
/*     */ 
/*     */     
/*  90 */     stringBuffer.append(System.getProperty("line.separator"));
/*  91 */     stringBuffer.append("         .automaticMinimum         = ").append(isAutomaticMinimum()).append('\n');
/*  92 */     stringBuffer.append("         .automaticMaximum         = ").append(isAutomaticMaximum()).append('\n');
/*  93 */     stringBuffer.append("         .automaticMajor           = ").append(isAutomaticMajor()).append('\n');
/*  94 */     stringBuffer.append("         .automaticMinor           = ").append(isAutomaticMinor()).append('\n');
/*  95 */     stringBuffer.append("         .automaticCategoryCrossing     = ").append(isAutomaticCategoryCrossing()).append('\n');
/*  96 */     stringBuffer.append("         .logarithmicScale         = ").append(isLogarithmicScale()).append('\n');
/*  97 */     stringBuffer.append("         .valuesInReverse          = ").append(isValuesInReverse()).append('\n');
/*  98 */     stringBuffer.append("         .crossCategoryAxisAtMaximum     = ").append(isCrossCategoryAxisAtMaximum()).append('\n');
/*  99 */     stringBuffer.append("         .reserved                 = ").append(isReserved()).append('\n');
/*     */     
/* 101 */     stringBuffer.append("[/VALUERANGE]\n");
/* 102 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 106 */     paramLittleEndianOutput.writeDouble(this.field_1_minimumAxisValue);
/* 107 */     paramLittleEndianOutput.writeDouble(this.field_2_maximumAxisValue);
/* 108 */     paramLittleEndianOutput.writeDouble(this.field_3_majorIncrement);
/* 109 */     paramLittleEndianOutput.writeDouble(this.field_4_minorIncrement);
/* 110 */     paramLittleEndianOutput.writeDouble(this.field_5_categoryAxisCross);
/* 111 */     paramLittleEndianOutput.writeShort(this.field_6_options);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 115 */     return 42;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 120 */     return 4127;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 124 */     ValueRangeRecord valueRangeRecord = new ValueRangeRecord();
/*     */     
/* 126 */     valueRangeRecord.field_1_minimumAxisValue = this.field_1_minimumAxisValue;
/* 127 */     valueRangeRecord.field_2_maximumAxisValue = this.field_2_maximumAxisValue;
/* 128 */     valueRangeRecord.field_3_majorIncrement = this.field_3_majorIncrement;
/* 129 */     valueRangeRecord.field_4_minorIncrement = this.field_4_minorIncrement;
/* 130 */     valueRangeRecord.field_5_categoryAxisCross = this.field_5_categoryAxisCross;
/* 131 */     valueRangeRecord.field_6_options = this.field_6_options;
/* 132 */     return valueRangeRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinimumAxisValue() {
/* 143 */     return this.field_1_minimumAxisValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinimumAxisValue(double paramDouble) {
/* 151 */     this.field_1_minimumAxisValue = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaximumAxisValue() {
/* 159 */     return this.field_2_maximumAxisValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaximumAxisValue(double paramDouble) {
/* 167 */     this.field_2_maximumAxisValue = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMajorIncrement() {
/* 175 */     return this.field_3_majorIncrement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMajorIncrement(double paramDouble) {
/* 183 */     this.field_3_majorIncrement = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinorIncrement() {
/* 191 */     return this.field_4_minorIncrement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinorIncrement(double paramDouble) {
/* 199 */     this.field_4_minorIncrement = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCategoryAxisCross() {
/* 207 */     return this.field_5_categoryAxisCross;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategoryAxisCross(double paramDouble) {
/* 215 */     this.field_5_categoryAxisCross = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 223 */     return this.field_6_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 231 */     this.field_6_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutomaticMinimum(boolean paramBoolean) {
/* 240 */     this.field_6_options = automaticMinimum.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutomaticMinimum() {
/* 249 */     return automaticMinimum.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutomaticMaximum(boolean paramBoolean) {
/* 258 */     this.field_6_options = automaticMaximum.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutomaticMaximum() {
/* 267 */     return automaticMaximum.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutomaticMajor(boolean paramBoolean) {
/* 276 */     this.field_6_options = automaticMajor.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutomaticMajor() {
/* 285 */     return automaticMajor.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutomaticMinor(boolean paramBoolean) {
/* 294 */     this.field_6_options = automaticMinor.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutomaticMinor() {
/* 303 */     return automaticMinor.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutomaticCategoryCrossing(boolean paramBoolean) {
/* 312 */     this.field_6_options = automaticCategoryCrossing.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutomaticCategoryCrossing() {
/* 321 */     return automaticCategoryCrossing.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogarithmicScale(boolean paramBoolean) {
/* 330 */     this.field_6_options = logarithmicScale.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLogarithmicScale() {
/* 339 */     return logarithmicScale.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValuesInReverse(boolean paramBoolean) {
/* 348 */     this.field_6_options = valuesInReverse.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValuesInReverse() {
/* 357 */     return valuesInReverse.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossCategoryAxisAtMaximum(boolean paramBoolean) {
/* 366 */     this.field_6_options = crossCategoryAxisAtMaximum.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCrossCategoryAxisAtMaximum() {
/* 375 */     return crossCategoryAxisAtMaximum.isSet(this.field_6_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved(boolean paramBoolean) {
/* 384 */     this.field_6_options = reserved.setShortBoolean(this.field_6_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReserved() {
/* 393 */     return reserved.isSet(this.field_6_options);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ValueRangeRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */