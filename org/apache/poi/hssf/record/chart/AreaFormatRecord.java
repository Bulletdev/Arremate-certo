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
/*     */ public final class AreaFormatRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4106;
/*  35 */   private static final BitField automatic = BitFieldFactory.getInstance(1);
/*  36 */   private static final BitField invert = BitFieldFactory.getInstance(2);
/*     */   
/*     */   private int field_1_foregroundColor;
/*     */   
/*     */   private int field_2_backgroundColor;
/*     */   
/*     */   private short field_3_pattern;
/*     */   
/*     */   private short field_4_formatFlags;
/*     */   
/*     */   private short field_5_forecolorIndex;
/*     */   
/*     */   private short field_6_backcolorIndex;
/*     */   
/*     */   public AreaFormatRecord() {}
/*     */   
/*     */   public AreaFormatRecord(RecordInputStream paramRecordInputStream) {
/*  53 */     this.field_1_foregroundColor = paramRecordInputStream.readInt();
/*  54 */     this.field_2_backgroundColor = paramRecordInputStream.readInt();
/*  55 */     this.field_3_pattern = paramRecordInputStream.readShort();
/*  56 */     this.field_4_formatFlags = paramRecordInputStream.readShort();
/*  57 */     this.field_5_forecolorIndex = paramRecordInputStream.readShort();
/*  58 */     this.field_6_backcolorIndex = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  64 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  66 */     stringBuffer.append("[AREAFORMAT]\n");
/*  67 */     stringBuffer.append("    .foregroundColor      = ").append("0x").append(HexDump.toHex(getForegroundColor())).append(" (").append(getForegroundColor()).append(" )");
/*     */ 
/*     */     
/*  70 */     stringBuffer.append(System.getProperty("line.separator"));
/*  71 */     stringBuffer.append("    .backgroundColor      = ").append("0x").append(HexDump.toHex(getBackgroundColor())).append(" (").append(getBackgroundColor()).append(" )");
/*     */ 
/*     */     
/*  74 */     stringBuffer.append(System.getProperty("line.separator"));
/*  75 */     stringBuffer.append("    .pattern              = ").append("0x").append(HexDump.toHex(getPattern())).append(" (").append(getPattern()).append(" )");
/*     */ 
/*     */     
/*  78 */     stringBuffer.append(System.getProperty("line.separator"));
/*  79 */     stringBuffer.append("    .formatFlags          = ").append("0x").append(HexDump.toHex(getFormatFlags())).append(" (").append(getFormatFlags()).append(" )");
/*     */ 
/*     */     
/*  82 */     stringBuffer.append(System.getProperty("line.separator"));
/*  83 */     stringBuffer.append("         .automatic                = ").append(isAutomatic()).append('\n');
/*  84 */     stringBuffer.append("         .invert                   = ").append(isInvert()).append('\n');
/*  85 */     stringBuffer.append("    .forecolorIndex       = ").append("0x").append(HexDump.toHex(getForecolorIndex())).append(" (").append(getForecolorIndex()).append(" )");
/*     */ 
/*     */     
/*  88 */     stringBuffer.append(System.getProperty("line.separator"));
/*  89 */     stringBuffer.append("    .backcolorIndex       = ").append("0x").append(HexDump.toHex(getBackcolorIndex())).append(" (").append(getBackcolorIndex()).append(" )");
/*     */ 
/*     */     
/*  92 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/*  94 */     stringBuffer.append("[/AREAFORMAT]\n");
/*  95 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  99 */     paramLittleEndianOutput.writeInt(this.field_1_foregroundColor);
/* 100 */     paramLittleEndianOutput.writeInt(this.field_2_backgroundColor);
/* 101 */     paramLittleEndianOutput.writeShort(this.field_3_pattern);
/* 102 */     paramLittleEndianOutput.writeShort(this.field_4_formatFlags);
/* 103 */     paramLittleEndianOutput.writeShort(this.field_5_forecolorIndex);
/* 104 */     paramLittleEndianOutput.writeShort(this.field_6_backcolorIndex);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 108 */     return 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 113 */     return 4106;
/*     */   }
/*     */ 
/*     */   
/*     */   public AreaFormatRecord clone() {
/* 118 */     AreaFormatRecord areaFormatRecord = new AreaFormatRecord();
/*     */     
/* 120 */     areaFormatRecord.field_1_foregroundColor = this.field_1_foregroundColor;
/* 121 */     areaFormatRecord.field_2_backgroundColor = this.field_2_backgroundColor;
/* 122 */     areaFormatRecord.field_3_pattern = this.field_3_pattern;
/* 123 */     areaFormatRecord.field_4_formatFlags = this.field_4_formatFlags;
/* 124 */     areaFormatRecord.field_5_forecolorIndex = this.field_5_forecolorIndex;
/* 125 */     areaFormatRecord.field_6_backcolorIndex = this.field_6_backcolorIndex;
/* 126 */     return areaFormatRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getForegroundColor() {
/* 137 */     return this.field_1_foregroundColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForegroundColor(int paramInt) {
/* 145 */     this.field_1_foregroundColor = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBackgroundColor() {
/* 153 */     return this.field_2_backgroundColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackgroundColor(int paramInt) {
/* 161 */     this.field_2_backgroundColor = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getPattern() {
/* 169 */     return this.field_3_pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPattern(short paramShort) {
/* 177 */     this.field_3_pattern = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFormatFlags() {
/* 185 */     return this.field_4_formatFlags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatFlags(short paramShort) {
/* 193 */     this.field_4_formatFlags = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getForecolorIndex() {
/* 201 */     return this.field_5_forecolorIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForecolorIndex(short paramShort) {
/* 209 */     this.field_5_forecolorIndex = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBackcolorIndex() {
/* 217 */     return this.field_6_backcolorIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackcolorIndex(short paramShort) {
/* 225 */     this.field_6_backcolorIndex = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutomatic(boolean paramBoolean) {
/* 234 */     this.field_4_formatFlags = automatic.setShortBoolean(this.field_4_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutomatic() {
/* 243 */     return automatic.isSet(this.field_4_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInvert(boolean paramBoolean) {
/* 252 */     this.field_4_formatFlags = invert.setShortBoolean(this.field_4_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInvert() {
/* 261 */     return invert.isSet(this.field_4_formatFlags);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\AreaFormatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */