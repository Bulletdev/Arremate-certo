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
/*     */ public final class CategorySeriesAxisRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4128;
/*  35 */   private static final BitField valueAxisCrossing = BitFieldFactory.getInstance(1);
/*  36 */   private static final BitField crossesFarRight = BitFieldFactory.getInstance(2);
/*  37 */   private static final BitField reversed = BitFieldFactory.getInstance(4);
/*     */   
/*     */   private short field_1_crossingPoint;
/*     */   
/*     */   private short field_2_labelFrequency;
/*     */   
/*     */   private short field_3_tickMarkFrequency;
/*     */   
/*     */   private short field_4_options;
/*     */ 
/*     */   
/*     */   public CategorySeriesAxisRecord() {}
/*     */ 
/*     */   
/*     */   public CategorySeriesAxisRecord(RecordInputStream paramRecordInputStream) {
/*  52 */     this.field_1_crossingPoint = paramRecordInputStream.readShort();
/*  53 */     this.field_2_labelFrequency = paramRecordInputStream.readShort();
/*  54 */     this.field_3_tickMarkFrequency = paramRecordInputStream.readShort();
/*  55 */     this.field_4_options = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  60 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  62 */     stringBuffer.append("[CATSERRANGE]\n");
/*  63 */     stringBuffer.append("    .crossingPoint        = ").append("0x").append(HexDump.toHex(getCrossingPoint())).append(" (").append(getCrossingPoint()).append(" )");
/*     */ 
/*     */     
/*  66 */     stringBuffer.append(System.getProperty("line.separator"));
/*  67 */     stringBuffer.append("    .labelFrequency       = ").append("0x").append(HexDump.toHex(getLabelFrequency())).append(" (").append(getLabelFrequency()).append(" )");
/*     */ 
/*     */     
/*  70 */     stringBuffer.append(System.getProperty("line.separator"));
/*  71 */     stringBuffer.append("    .tickMarkFrequency    = ").append("0x").append(HexDump.toHex(getTickMarkFrequency())).append(" (").append(getTickMarkFrequency()).append(" )");
/*     */ 
/*     */     
/*  74 */     stringBuffer.append(System.getProperty("line.separator"));
/*  75 */     stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append(getOptions()).append(" )");
/*     */ 
/*     */     
/*  78 */     stringBuffer.append(System.getProperty("line.separator"));
/*  79 */     stringBuffer.append("         .valueAxisCrossing        = ").append(isValueAxisCrossing()).append('\n');
/*  80 */     stringBuffer.append("         .crossesFarRight          = ").append(isCrossesFarRight()).append('\n');
/*  81 */     stringBuffer.append("         .reversed                 = ").append(isReversed()).append('\n');
/*     */     
/*  83 */     stringBuffer.append("[/CATSERRANGE]\n");
/*  84 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  88 */     paramLittleEndianOutput.writeShort(this.field_1_crossingPoint);
/*  89 */     paramLittleEndianOutput.writeShort(this.field_2_labelFrequency);
/*  90 */     paramLittleEndianOutput.writeShort(this.field_3_tickMarkFrequency);
/*  91 */     paramLittleEndianOutput.writeShort(this.field_4_options);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  95 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 100 */     return 4128;
/*     */   }
/*     */ 
/*     */   
/*     */   public CategorySeriesAxisRecord clone() {
/* 105 */     CategorySeriesAxisRecord categorySeriesAxisRecord = new CategorySeriesAxisRecord();
/*     */     
/* 107 */     categorySeriesAxisRecord.field_1_crossingPoint = this.field_1_crossingPoint;
/* 108 */     categorySeriesAxisRecord.field_2_labelFrequency = this.field_2_labelFrequency;
/* 109 */     categorySeriesAxisRecord.field_3_tickMarkFrequency = this.field_3_tickMarkFrequency;
/* 110 */     categorySeriesAxisRecord.field_4_options = this.field_4_options;
/* 111 */     return categorySeriesAxisRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCrossingPoint() {
/* 122 */     return this.field_1_crossingPoint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossingPoint(short paramShort) {
/* 130 */     this.field_1_crossingPoint = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLabelFrequency() {
/* 138 */     return this.field_2_labelFrequency;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelFrequency(short paramShort) {
/* 146 */     this.field_2_labelFrequency = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTickMarkFrequency() {
/* 154 */     return this.field_3_tickMarkFrequency;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTickMarkFrequency(short paramShort) {
/* 162 */     this.field_3_tickMarkFrequency = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 170 */     return this.field_4_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 178 */     this.field_4_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValueAxisCrossing(boolean paramBoolean) {
/* 187 */     this.field_4_options = valueAxisCrossing.setShortBoolean(this.field_4_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValueAxisCrossing() {
/* 196 */     return valueAxisCrossing.isSet(this.field_4_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCrossesFarRight(boolean paramBoolean) {
/* 205 */     this.field_4_options = crossesFarRight.setShortBoolean(this.field_4_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCrossesFarRight() {
/* 214 */     return crossesFarRight.isSet(this.field_4_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReversed(boolean paramBoolean) {
/* 223 */     this.field_4_options = reversed.setShortBoolean(this.field_4_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReversed() {
/* 232 */     return reversed.isSet(this.field_4_options);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\CategorySeriesAxisRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */