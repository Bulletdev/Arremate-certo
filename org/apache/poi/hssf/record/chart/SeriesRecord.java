/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
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
/*     */ public final class SeriesRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4099;
/*     */   private short field_1_categoryDataType;
/*     */   public static final short CATEGORY_DATA_TYPE_DATES = 0;
/*     */   public static final short CATEGORY_DATA_TYPE_NUMERIC = 1;
/*     */   public static final short CATEGORY_DATA_TYPE_SEQUENCE = 2;
/*     */   public static final short CATEGORY_DATA_TYPE_TEXT = 3;
/*     */   private short field_2_valuesDataType;
/*     */   public static final short VALUES_DATA_TYPE_DATES = 0;
/*     */   public static final short VALUES_DATA_TYPE_NUMERIC = 1;
/*     */   public static final short VALUES_DATA_TYPE_SEQUENCE = 2;
/*     */   public static final short VALUES_DATA_TYPE_TEXT = 3;
/*     */   private short field_3_numCategories;
/*     */   private short field_4_numValues;
/*     */   private short field_5_bubbleSeriesType;
/*     */   public static final short BUBBLE_SERIES_TYPE_DATES = 0;
/*     */   public static final short BUBBLE_SERIES_TYPE_NUMERIC = 1;
/*     */   public static final short BUBBLE_SERIES_TYPE_SEQUENCE = 2;
/*     */   public static final short BUBBLE_SERIES_TYPE_TEXT = 3;
/*     */   private short field_6_numBubbleValues;
/*     */   
/*     */   public SeriesRecord() {}
/*     */   
/*     */   public SeriesRecord(RecordInputStream paramRecordInputStream) {
/*  57 */     this.field_1_categoryDataType = paramRecordInputStream.readShort();
/*  58 */     this.field_2_valuesDataType = paramRecordInputStream.readShort();
/*  59 */     this.field_3_numCategories = paramRecordInputStream.readShort();
/*  60 */     this.field_4_numValues = paramRecordInputStream.readShort();
/*  61 */     this.field_5_bubbleSeriesType = paramRecordInputStream.readShort();
/*  62 */     this.field_6_numBubbleValues = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  68 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  70 */     stringBuffer.append("[SERIES]\n");
/*  71 */     stringBuffer.append("    .categoryDataType     = ").append("0x").append(HexDump.toHex(getCategoryDataType())).append(" (").append(getCategoryDataType()).append(" )");
/*     */ 
/*     */     
/*  74 */     stringBuffer.append(System.getProperty("line.separator"));
/*  75 */     stringBuffer.append("    .valuesDataType       = ").append("0x").append(HexDump.toHex(getValuesDataType())).append(" (").append(getValuesDataType()).append(" )");
/*     */ 
/*     */     
/*  78 */     stringBuffer.append(System.getProperty("line.separator"));
/*  79 */     stringBuffer.append("    .numCategories        = ").append("0x").append(HexDump.toHex(getNumCategories())).append(" (").append(getNumCategories()).append(" )");
/*     */ 
/*     */     
/*  82 */     stringBuffer.append(System.getProperty("line.separator"));
/*  83 */     stringBuffer.append("    .numValues            = ").append("0x").append(HexDump.toHex(getNumValues())).append(" (").append(getNumValues()).append(" )");
/*     */ 
/*     */     
/*  86 */     stringBuffer.append(System.getProperty("line.separator"));
/*  87 */     stringBuffer.append("    .bubbleSeriesType     = ").append("0x").append(HexDump.toHex(getBubbleSeriesType())).append(" (").append(getBubbleSeriesType()).append(" )");
/*     */ 
/*     */     
/*  90 */     stringBuffer.append(System.getProperty("line.separator"));
/*  91 */     stringBuffer.append("    .numBubbleValues      = ").append("0x").append(HexDump.toHex(getNumBubbleValues())).append(" (").append(getNumBubbleValues()).append(" )");
/*     */ 
/*     */     
/*  94 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  96 */     stringBuffer.append("[/SERIES]\n");
/*  97 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 101 */     paramLittleEndianOutput.writeShort(this.field_1_categoryDataType);
/* 102 */     paramLittleEndianOutput.writeShort(this.field_2_valuesDataType);
/* 103 */     paramLittleEndianOutput.writeShort(this.field_3_numCategories);
/* 104 */     paramLittleEndianOutput.writeShort(this.field_4_numValues);
/* 105 */     paramLittleEndianOutput.writeShort(this.field_5_bubbleSeriesType);
/* 106 */     paramLittleEndianOutput.writeShort(this.field_6_numBubbleValues);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 110 */     return 12;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 115 */     return 4099;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 119 */     SeriesRecord seriesRecord = new SeriesRecord();
/*     */     
/* 121 */     seriesRecord.field_1_categoryDataType = this.field_1_categoryDataType;
/* 122 */     seriesRecord.field_2_valuesDataType = this.field_2_valuesDataType;
/* 123 */     seriesRecord.field_3_numCategories = this.field_3_numCategories;
/* 124 */     seriesRecord.field_4_numValues = this.field_4_numValues;
/* 125 */     seriesRecord.field_5_bubbleSeriesType = this.field_5_bubbleSeriesType;
/* 126 */     seriesRecord.field_6_numBubbleValues = this.field_6_numBubbleValues;
/* 127 */     return seriesRecord;
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
/*     */   public short getCategoryDataType() {
/* 144 */     return this.field_1_categoryDataType;
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
/*     */   public void setCategoryDataType(short paramShort) {
/* 159 */     this.field_1_categoryDataType = paramShort;
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
/*     */   public short getValuesDataType() {
/* 173 */     return this.field_2_valuesDataType;
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
/*     */   public void setValuesDataType(short paramShort) {
/* 188 */     this.field_2_valuesDataType = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNumCategories() {
/* 196 */     return this.field_3_numCategories;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumCategories(short paramShort) {
/* 204 */     this.field_3_numCategories = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNumValues() {
/* 212 */     return this.field_4_numValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumValues(short paramShort) {
/* 220 */     this.field_4_numValues = paramShort;
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
/*     */   public short getBubbleSeriesType() {
/* 234 */     return this.field_5_bubbleSeriesType;
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
/*     */   public void setBubbleSeriesType(short paramShort) {
/* 249 */     this.field_5_bubbleSeriesType = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getNumBubbleValues() {
/* 257 */     return this.field_6_numBubbleValues;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNumBubbleValues(short paramShort) {
/* 265 */     this.field_6_numBubbleValues = paramShort;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\SeriesRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */