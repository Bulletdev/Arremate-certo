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
/*     */ 
/*     */ public final class TickRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4126;
/*  35 */   private static final BitField autoTextColor = BitFieldFactory.getInstance(1);
/*  36 */   private static final BitField autoTextBackground = BitFieldFactory.getInstance(2);
/*  37 */   private static final BitField rotation = BitFieldFactory.getInstance(28);
/*  38 */   private static final BitField autorotate = BitFieldFactory.getInstance(32);
/*     */   
/*     */   private byte field_1_majorTickType;
/*     */   
/*     */   private byte field_2_minorTickType;
/*     */   
/*     */   private byte field_3_labelPosition;
/*     */   
/*     */   private byte field_4_background;
/*     */   
/*     */   private int field_5_labelColorRgb;
/*     */   
/*     */   private int field_6_zero1;
/*     */   
/*     */   private int field_7_zero2;
/*     */   private int field_8_zero3;
/*     */   private int field_9_zero4;
/*     */   private short field_10_options;
/*     */   private short field_11_tickColor;
/*     */   private short field_12_zero5;
/*     */   
/*     */   public TickRecord() {}
/*     */   
/*     */   public TickRecord(RecordInputStream paramRecordInputStream) {
/*  62 */     this.field_1_majorTickType = paramRecordInputStream.readByte();
/*  63 */     this.field_2_minorTickType = paramRecordInputStream.readByte();
/*  64 */     this.field_3_labelPosition = paramRecordInputStream.readByte();
/*  65 */     this.field_4_background = paramRecordInputStream.readByte();
/*  66 */     this.field_5_labelColorRgb = paramRecordInputStream.readInt();
/*  67 */     this.field_6_zero1 = paramRecordInputStream.readInt();
/*  68 */     this.field_7_zero2 = paramRecordInputStream.readInt();
/*  69 */     this.field_8_zero3 = paramRecordInputStream.readInt();
/*  70 */     this.field_9_zero4 = paramRecordInputStream.readInt();
/*     */     
/*  72 */     this.field_10_options = paramRecordInputStream.readShort();
/*  73 */     this.field_11_tickColor = paramRecordInputStream.readShort();
/*  74 */     this.field_12_zero5 = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  79 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  81 */     stringBuffer.append("[TICK]\n");
/*  82 */     stringBuffer.append("    .majorTickType        = ").append("0x").append(HexDump.toHex(getMajorTickType())).append(" (").append(getMajorTickType()).append(" )");
/*     */ 
/*     */     
/*  85 */     stringBuffer.append(System.getProperty("line.separator"));
/*  86 */     stringBuffer.append("    .minorTickType        = ").append("0x").append(HexDump.toHex(getMinorTickType())).append(" (").append(getMinorTickType()).append(" )");
/*     */ 
/*     */     
/*  89 */     stringBuffer.append(System.getProperty("line.separator"));
/*  90 */     stringBuffer.append("    .labelPosition        = ").append("0x").append(HexDump.toHex(getLabelPosition())).append(" (").append(getLabelPosition()).append(" )");
/*     */ 
/*     */     
/*  93 */     stringBuffer.append(System.getProperty("line.separator"));
/*  94 */     stringBuffer.append("    .background           = ").append("0x").append(HexDump.toHex(getBackground())).append(" (").append(getBackground()).append(" )");
/*     */ 
/*     */     
/*  97 */     stringBuffer.append(System.getProperty("line.separator"));
/*  98 */     stringBuffer.append("    .labelColorRgb        = ").append("0x").append(HexDump.toHex(getLabelColorRgb())).append(" (").append(getLabelColorRgb()).append(" )");
/*     */ 
/*     */     
/* 101 */     stringBuffer.append(System.getProperty("line.separator"));
/* 102 */     stringBuffer.append("    .zero1                = ").append("0x").append(HexDump.toHex(getZero1())).append(" (").append(getZero1()).append(" )");
/*     */ 
/*     */     
/* 105 */     stringBuffer.append(System.getProperty("line.separator"));
/* 106 */     stringBuffer.append("    .zero2                = ").append("0x").append(HexDump.toHex(getZero2())).append(" (").append(getZero2()).append(" )");
/*     */ 
/*     */     
/* 109 */     stringBuffer.append(System.getProperty("line.separator"));
/* 110 */     stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append(getOptions()).append(" )");
/*     */ 
/*     */     
/* 113 */     stringBuffer.append(System.getProperty("line.separator"));
/* 114 */     stringBuffer.append("         .autoTextColor            = ").append(isAutoTextColor()).append('\n');
/* 115 */     stringBuffer.append("         .autoTextBackground       = ").append(isAutoTextBackground()).append('\n');
/* 116 */     stringBuffer.append("         .rotation                 = ").append(getRotation()).append('\n');
/* 117 */     stringBuffer.append("         .autorotate               = ").append(isAutorotate()).append('\n');
/* 118 */     stringBuffer.append("    .tickColor            = ").append("0x").append(HexDump.toHex(getTickColor())).append(" (").append(getTickColor()).append(" )");
/*     */ 
/*     */     
/* 121 */     stringBuffer.append(System.getProperty("line.separator"));
/* 122 */     stringBuffer.append("    .zero3                = ").append("0x").append(HexDump.toHex(getZero3())).append(" (").append(getZero3()).append(" )");
/*     */ 
/*     */     
/* 125 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/* 127 */     stringBuffer.append("[/TICK]\n");
/* 128 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 132 */     paramLittleEndianOutput.writeByte(this.field_1_majorTickType);
/* 133 */     paramLittleEndianOutput.writeByte(this.field_2_minorTickType);
/* 134 */     paramLittleEndianOutput.writeByte(this.field_3_labelPosition);
/* 135 */     paramLittleEndianOutput.writeByte(this.field_4_background);
/* 136 */     paramLittleEndianOutput.writeInt(this.field_5_labelColorRgb);
/* 137 */     paramLittleEndianOutput.writeInt(this.field_6_zero1);
/* 138 */     paramLittleEndianOutput.writeInt(this.field_7_zero2);
/* 139 */     paramLittleEndianOutput.writeInt(this.field_8_zero3);
/* 140 */     paramLittleEndianOutput.writeInt(this.field_9_zero4);
/* 141 */     paramLittleEndianOutput.writeShort(this.field_10_options);
/* 142 */     paramLittleEndianOutput.writeShort(this.field_11_tickColor);
/* 143 */     paramLittleEndianOutput.writeShort(this.field_12_zero5);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 147 */     return 30;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 152 */     return 4126;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 156 */     TickRecord tickRecord = new TickRecord();
/*     */     
/* 158 */     tickRecord.field_1_majorTickType = this.field_1_majorTickType;
/* 159 */     tickRecord.field_2_minorTickType = this.field_2_minorTickType;
/* 160 */     tickRecord.field_3_labelPosition = this.field_3_labelPosition;
/* 161 */     tickRecord.field_4_background = this.field_4_background;
/* 162 */     tickRecord.field_5_labelColorRgb = this.field_5_labelColorRgb;
/* 163 */     tickRecord.field_6_zero1 = this.field_6_zero1;
/* 164 */     tickRecord.field_7_zero2 = this.field_7_zero2;
/* 165 */     tickRecord.field_8_zero3 = this.field_8_zero3;
/* 166 */     tickRecord.field_9_zero4 = this.field_9_zero4;
/* 167 */     tickRecord.field_10_options = this.field_10_options;
/* 168 */     tickRecord.field_11_tickColor = this.field_11_tickColor;
/* 169 */     tickRecord.field_12_zero5 = this.field_12_zero5;
/* 170 */     return tickRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getMajorTickType() {
/* 181 */     return this.field_1_majorTickType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMajorTickType(byte paramByte) {
/* 189 */     this.field_1_majorTickType = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getMinorTickType() {
/* 197 */     return this.field_2_minorTickType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinorTickType(byte paramByte) {
/* 205 */     this.field_2_minorTickType = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getLabelPosition() {
/* 213 */     return this.field_3_labelPosition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelPosition(byte paramByte) {
/* 221 */     this.field_3_labelPosition = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getBackground() {
/* 229 */     return this.field_4_background;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackground(byte paramByte) {
/* 237 */     this.field_4_background = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLabelColorRgb() {
/* 245 */     return this.field_5_labelColorRgb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelColorRgb(int paramInt) {
/* 253 */     this.field_5_labelColorRgb = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getZero1() {
/* 261 */     return this.field_6_zero1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZero1(int paramInt) {
/* 269 */     this.field_6_zero1 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getZero2() {
/* 277 */     return this.field_7_zero2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZero2(int paramInt) {
/* 285 */     this.field_7_zero2 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 293 */     return this.field_10_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 301 */     this.field_10_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTickColor() {
/* 309 */     return this.field_11_tickColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTickColor(short paramShort) {
/* 317 */     this.field_11_tickColor = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getZero3() {
/* 325 */     return this.field_12_zero5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZero3(short paramShort) {
/* 333 */     this.field_12_zero5 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoTextColor(boolean paramBoolean) {
/* 342 */     this.field_10_options = autoTextColor.setShortBoolean(this.field_10_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoTextColor() {
/* 351 */     return autoTextColor.isSet(this.field_10_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoTextBackground(boolean paramBoolean) {
/* 360 */     this.field_10_options = autoTextBackground.setShortBoolean(this.field_10_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoTextBackground() {
/* 369 */     return autoTextBackground.isSet(this.field_10_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotation(short paramShort) {
/* 378 */     this.field_10_options = rotation.setShortValue(this.field_10_options, paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getRotation() {
/* 387 */     return rotation.getShortValue(this.field_10_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutorotate(boolean paramBoolean) {
/* 396 */     this.field_10_options = autorotate.setShortBoolean(this.field_10_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutorotate() {
/* 405 */     return autorotate.isSet(this.field_10_options);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\TickRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */