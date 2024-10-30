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
/*     */ public final class LineFormatRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4103;
/*  33 */   private static final BitField auto = BitFieldFactory.getInstance(1);
/*  34 */   private static final BitField drawTicks = BitFieldFactory.getInstance(4);
/*  35 */   private static final BitField unknown = BitFieldFactory.getInstance(4);
/*     */   
/*     */   private int field_1_lineColor;
/*     */   
/*     */   private short field_2_linePattern;
/*     */   
/*     */   public static final short LINE_PATTERN_SOLID = 0;
/*     */   
/*     */   public static final short LINE_PATTERN_DASH = 1;
/*     */   
/*     */   public static final short LINE_PATTERN_DOT = 2;
/*     */   
/*     */   public static final short LINE_PATTERN_DASH_DOT = 3;
/*     */   public static final short LINE_PATTERN_DASH_DOT_DOT = 4;
/*     */   public static final short LINE_PATTERN_NONE = 5;
/*     */   public static final short LINE_PATTERN_DARK_GRAY_PATTERN = 6;
/*     */   public static final short LINE_PATTERN_MEDIUM_GRAY_PATTERN = 7;
/*     */   public static final short LINE_PATTERN_LIGHT_GRAY_PATTERN = 8;
/*     */   private short field_3_weight;
/*     */   public static final short WEIGHT_HAIRLINE = -1;
/*     */   public static final short WEIGHT_NARROW = 0;
/*     */   public static final short WEIGHT_MEDIUM = 1;
/*     */   public static final short WEIGHT_WIDE = 2;
/*     */   private short field_4_format;
/*     */   private short field_5_colourPaletteIndex;
/*     */   
/*     */   public LineFormatRecord() {}
/*     */   
/*     */   public LineFormatRecord(RecordInputStream paramRecordInputStream) {
/*  64 */     this.field_1_lineColor = paramRecordInputStream.readInt();
/*  65 */     this.field_2_linePattern = paramRecordInputStream.readShort();
/*  66 */     this.field_3_weight = paramRecordInputStream.readShort();
/*  67 */     this.field_4_format = paramRecordInputStream.readShort();
/*  68 */     this.field_5_colourPaletteIndex = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  74 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  76 */     stringBuffer.append("[LINEFORMAT]\n");
/*  77 */     stringBuffer.append("    .lineColor            = ").append("0x").append(HexDump.toHex(getLineColor())).append(" (").append(getLineColor()).append(" )");
/*     */ 
/*     */     
/*  80 */     stringBuffer.append(System.getProperty("line.separator"));
/*  81 */     stringBuffer.append("    .linePattern          = ").append("0x").append(HexDump.toHex(getLinePattern())).append(" (").append(getLinePattern()).append(" )");
/*     */ 
/*     */     
/*  84 */     stringBuffer.append(System.getProperty("line.separator"));
/*  85 */     stringBuffer.append("    .weight               = ").append("0x").append(HexDump.toHex(getWeight())).append(" (").append(getWeight()).append(" )");
/*     */ 
/*     */     
/*  88 */     stringBuffer.append(System.getProperty("line.separator"));
/*  89 */     stringBuffer.append("    .format               = ").append("0x").append(HexDump.toHex(getFormat())).append(" (").append(getFormat()).append(" )");
/*     */ 
/*     */     
/*  92 */     stringBuffer.append(System.getProperty("line.separator"));
/*  93 */     stringBuffer.append("         .auto                     = ").append(isAuto()).append('\n');
/*  94 */     stringBuffer.append("         .drawTicks                = ").append(isDrawTicks()).append('\n');
/*  95 */     stringBuffer.append("         .unknown                  = ").append(isUnknown()).append('\n');
/*  96 */     stringBuffer.append("    .colourPaletteIndex   = ").append("0x").append(HexDump.toHex(getColourPaletteIndex())).append(" (").append(getColourPaletteIndex()).append(" )");
/*     */ 
/*     */     
/*  99 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/* 101 */     stringBuffer.append("[/LINEFORMAT]\n");
/* 102 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 106 */     paramLittleEndianOutput.writeInt(this.field_1_lineColor);
/* 107 */     paramLittleEndianOutput.writeShort(this.field_2_linePattern);
/* 108 */     paramLittleEndianOutput.writeShort(this.field_3_weight);
/* 109 */     paramLittleEndianOutput.writeShort(this.field_4_format);
/* 110 */     paramLittleEndianOutput.writeShort(this.field_5_colourPaletteIndex);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 114 */     return 12;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 119 */     return 4103;
/*     */   }
/*     */ 
/*     */   
/*     */   public LineFormatRecord clone() {
/* 124 */     LineFormatRecord lineFormatRecord = new LineFormatRecord();
/*     */     
/* 126 */     lineFormatRecord.field_1_lineColor = this.field_1_lineColor;
/* 127 */     lineFormatRecord.field_2_linePattern = this.field_2_linePattern;
/* 128 */     lineFormatRecord.field_3_weight = this.field_3_weight;
/* 129 */     lineFormatRecord.field_4_format = this.field_4_format;
/* 130 */     lineFormatRecord.field_5_colourPaletteIndex = this.field_5_colourPaletteIndex;
/* 131 */     return lineFormatRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLineColor() {
/* 142 */     return this.field_1_lineColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineColor(int paramInt) {
/* 150 */     this.field_1_lineColor = paramInt;
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
/*     */   public short getLinePattern() {
/* 169 */     return this.field_2_linePattern;
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
/*     */   public void setLinePattern(short paramShort) {
/* 189 */     this.field_2_linePattern = paramShort;
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
/*     */   public short getWeight() {
/* 203 */     return this.field_3_weight;
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
/*     */   public void setWeight(short paramShort) {
/* 218 */     this.field_3_weight = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFormat() {
/* 226 */     return this.field_4_format;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormat(short paramShort) {
/* 234 */     this.field_4_format = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getColourPaletteIndex() {
/* 242 */     return this.field_5_colourPaletteIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColourPaletteIndex(short paramShort) {
/* 250 */     this.field_5_colourPaletteIndex = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAuto(boolean paramBoolean) {
/* 259 */     this.field_4_format = auto.setShortBoolean(this.field_4_format, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAuto() {
/* 268 */     return auto.isSet(this.field_4_format);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDrawTicks(boolean paramBoolean) {
/* 277 */     this.field_4_format = drawTicks.setShortBoolean(this.field_4_format, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDrawTicks() {
/* 286 */     return drawTicks.isSet(this.field_4_format);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnknown(boolean paramBoolean) {
/* 295 */     this.field_4_format = unknown.setShortBoolean(this.field_4_format, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUnknown() {
/* 304 */     return unknown.isSet(this.field_4_format);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\LineFormatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */