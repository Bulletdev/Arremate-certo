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
/*     */ public final class LegendRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4117;
/*  33 */   private static final BitField autoPosition = BitFieldFactory.getInstance(1);
/*  34 */   private static final BitField autoSeries = BitFieldFactory.getInstance(2);
/*  35 */   private static final BitField autoXPositioning = BitFieldFactory.getInstance(4);
/*  36 */   private static final BitField autoYPositioning = BitFieldFactory.getInstance(8);
/*  37 */   private static final BitField vertical = BitFieldFactory.getInstance(16);
/*  38 */   private static final BitField dataTable = BitFieldFactory.getInstance(32);
/*     */   
/*     */   private int field_1_xAxisUpperLeft;
/*     */   
/*     */   private int field_2_yAxisUpperLeft;
/*     */   
/*     */   private int field_3_xSize;
/*     */   
/*     */   private int field_4_ySize;
/*     */   
/*     */   private byte field_5_type;
/*     */   
/*     */   public static final byte TYPE_BOTTOM = 0;
/*     */   public static final byte TYPE_CORNER = 1;
/*     */   public static final byte TYPE_TOP = 2;
/*     */   public static final byte TYPE_RIGHT = 3;
/*     */   public static final byte TYPE_LEFT = 4;
/*     */   public static final byte TYPE_UNDOCKED = 7;
/*     */   private byte field_6_spacing;
/*     */   public static final byte SPACING_CLOSE = 0;
/*     */   public static final byte SPACING_MEDIUM = 1;
/*     */   public static final byte SPACING_OPEN = 2;
/*     */   private short field_7_options;
/*     */   
/*     */   public LegendRecord() {}
/*     */   
/*     */   public LegendRecord(RecordInputStream paramRecordInputStream) {
/*  65 */     this.field_1_xAxisUpperLeft = paramRecordInputStream.readInt();
/*  66 */     this.field_2_yAxisUpperLeft = paramRecordInputStream.readInt();
/*  67 */     this.field_3_xSize = paramRecordInputStream.readInt();
/*  68 */     this.field_4_ySize = paramRecordInputStream.readInt();
/*  69 */     this.field_5_type = paramRecordInputStream.readByte();
/*  70 */     this.field_6_spacing = paramRecordInputStream.readByte();
/*  71 */     this.field_7_options = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  76 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  78 */     stringBuffer.append("[LEGEND]\n");
/*  79 */     stringBuffer.append("    .xAxisUpperLeft       = ").append("0x").append(HexDump.toHex(getXAxisUpperLeft())).append(" (").append(getXAxisUpperLeft()).append(" )");
/*     */ 
/*     */     
/*  82 */     stringBuffer.append(System.getProperty("line.separator"));
/*  83 */     stringBuffer.append("    .yAxisUpperLeft       = ").append("0x").append(HexDump.toHex(getYAxisUpperLeft())).append(" (").append(getYAxisUpperLeft()).append(" )");
/*     */ 
/*     */     
/*  86 */     stringBuffer.append(System.getProperty("line.separator"));
/*  87 */     stringBuffer.append("    .xSize                = ").append("0x").append(HexDump.toHex(getXSize())).append(" (").append(getXSize()).append(" )");
/*     */ 
/*     */     
/*  90 */     stringBuffer.append(System.getProperty("line.separator"));
/*  91 */     stringBuffer.append("    .ySize                = ").append("0x").append(HexDump.toHex(getYSize())).append(" (").append(getYSize()).append(" )");
/*     */ 
/*     */     
/*  94 */     stringBuffer.append(System.getProperty("line.separator"));
/*  95 */     stringBuffer.append("    .type                 = ").append("0x").append(HexDump.toHex(getType())).append(" (").append(getType()).append(" )");
/*     */ 
/*     */     
/*  98 */     stringBuffer.append(System.getProperty("line.separator"));
/*  99 */     stringBuffer.append("    .spacing              = ").append("0x").append(HexDump.toHex(getSpacing())).append(" (").append(getSpacing()).append(" )");
/*     */ 
/*     */     
/* 102 */     stringBuffer.append(System.getProperty("line.separator"));
/* 103 */     stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append(getOptions()).append(" )");
/*     */ 
/*     */     
/* 106 */     stringBuffer.append(System.getProperty("line.separator"));
/* 107 */     stringBuffer.append("         .autoPosition             = ").append(isAutoPosition()).append('\n');
/* 108 */     stringBuffer.append("         .autoSeries               = ").append(isAutoSeries()).append('\n');
/* 109 */     stringBuffer.append("         .autoXPositioning         = ").append(isAutoXPositioning()).append('\n');
/* 110 */     stringBuffer.append("         .autoYPositioning         = ").append(isAutoYPositioning()).append('\n');
/* 111 */     stringBuffer.append("         .vertical                 = ").append(isVertical()).append('\n');
/* 112 */     stringBuffer.append("         .dataTable                = ").append(isDataTable()).append('\n');
/*     */     
/* 114 */     stringBuffer.append("[/LEGEND]\n");
/* 115 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 119 */     paramLittleEndianOutput.writeInt(this.field_1_xAxisUpperLeft);
/* 120 */     paramLittleEndianOutput.writeInt(this.field_2_yAxisUpperLeft);
/* 121 */     paramLittleEndianOutput.writeInt(this.field_3_xSize);
/* 122 */     paramLittleEndianOutput.writeInt(this.field_4_ySize);
/* 123 */     paramLittleEndianOutput.writeByte(this.field_5_type);
/* 124 */     paramLittleEndianOutput.writeByte(this.field_6_spacing);
/* 125 */     paramLittleEndianOutput.writeShort(this.field_7_options);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 129 */     return 20;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 134 */     return 4117;
/*     */   }
/*     */ 
/*     */   
/*     */   public LegendRecord clone() {
/* 139 */     LegendRecord legendRecord = new LegendRecord();
/*     */     
/* 141 */     legendRecord.field_1_xAxisUpperLeft = this.field_1_xAxisUpperLeft;
/* 142 */     legendRecord.field_2_yAxisUpperLeft = this.field_2_yAxisUpperLeft;
/* 143 */     legendRecord.field_3_xSize = this.field_3_xSize;
/* 144 */     legendRecord.field_4_ySize = this.field_4_ySize;
/* 145 */     legendRecord.field_5_type = this.field_5_type;
/* 146 */     legendRecord.field_6_spacing = this.field_6_spacing;
/* 147 */     legendRecord.field_7_options = this.field_7_options;
/* 148 */     return legendRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getXAxisUpperLeft() {
/* 159 */     return this.field_1_xAxisUpperLeft;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXAxisUpperLeft(int paramInt) {
/* 167 */     this.field_1_xAxisUpperLeft = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getYAxisUpperLeft() {
/* 175 */     return this.field_2_yAxisUpperLeft;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setYAxisUpperLeft(int paramInt) {
/* 183 */     this.field_2_yAxisUpperLeft = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getXSize() {
/* 191 */     return this.field_3_xSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXSize(int paramInt) {
/* 199 */     this.field_3_xSize = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getYSize() {
/* 207 */     return this.field_4_ySize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setYSize(int paramInt) {
/* 215 */     this.field_4_ySize = paramInt;
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
/*     */   public byte getType() {
/* 231 */     return this.field_5_type;
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
/*     */   public void setType(byte paramByte) {
/* 248 */     this.field_5_type = paramByte;
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
/*     */   public byte getSpacing() {
/* 261 */     return this.field_6_spacing;
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
/*     */   public void setSpacing(byte paramByte) {
/* 275 */     this.field_6_spacing = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 283 */     return this.field_7_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 291 */     this.field_7_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoPosition(boolean paramBoolean) {
/* 300 */     this.field_7_options = autoPosition.setShortBoolean(this.field_7_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoPosition() {
/* 309 */     return autoPosition.isSet(this.field_7_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoSeries(boolean paramBoolean) {
/* 318 */     this.field_7_options = autoSeries.setShortBoolean(this.field_7_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoSeries() {
/* 327 */     return autoSeries.isSet(this.field_7_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoXPositioning(boolean paramBoolean) {
/* 336 */     this.field_7_options = autoXPositioning.setShortBoolean(this.field_7_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoXPositioning() {
/* 345 */     return autoXPositioning.isSet(this.field_7_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoYPositioning(boolean paramBoolean) {
/* 354 */     this.field_7_options = autoYPositioning.setShortBoolean(this.field_7_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoYPositioning() {
/* 363 */     return autoYPositioning.isSet(this.field_7_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVertical(boolean paramBoolean) {
/* 372 */     this.field_7_options = vertical.setShortBoolean(this.field_7_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVertical() {
/* 381 */     return vertical.isSet(this.field_7_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDataTable(boolean paramBoolean) {
/* 390 */     this.field_7_options = dataTable.setShortBoolean(this.field_7_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDataTable() {
/* 399 */     return dataTable.isSet(this.field_7_options);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\LegendRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */