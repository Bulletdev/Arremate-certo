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
/*     */ 
/*     */ public final class SheetPropertiesRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4164;
/*  36 */   private static final BitField chartTypeManuallyFormatted = BitFieldFactory.getInstance(1);
/*  37 */   private static final BitField plotVisibleOnly = BitFieldFactory.getInstance(2);
/*  38 */   private static final BitField doNotSizeWithWindow = BitFieldFactory.getInstance(4);
/*  39 */   private static final BitField defaultPlotDimensions = BitFieldFactory.getInstance(8);
/*  40 */   private static final BitField autoPlotArea = BitFieldFactory.getInstance(16);
/*     */   
/*     */   private int field_1_flags;
/*     */   
/*     */   private int field_2_empty;
/*     */   
/*     */   public static final byte EMPTY_NOT_PLOTTED = 0;
/*     */   
/*     */   public static final byte EMPTY_ZERO = 1;
/*     */   public static final byte EMPTY_INTERPOLATED = 2;
/*     */   
/*     */   public SheetPropertiesRecord() {}
/*     */   
/*     */   public SheetPropertiesRecord(RecordInputStream paramRecordInputStream) {
/*  54 */     this.field_1_flags = paramRecordInputStream.readUShort();
/*  55 */     this.field_2_empty = paramRecordInputStream.readUShort();
/*     */   }
/*     */   
/*     */   public String toString() {
/*  59 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  61 */     stringBuffer.append("[SHTPROPS]\n");
/*  62 */     stringBuffer.append("    .flags                = ").append(HexDump.shortToHex(this.field_1_flags)).append('\n');
/*  63 */     stringBuffer.append("         .chartTypeManuallyFormatted= ").append(isChartTypeManuallyFormatted()).append('\n');
/*  64 */     stringBuffer.append("         .plotVisibleOnly           = ").append(isPlotVisibleOnly()).append('\n');
/*  65 */     stringBuffer.append("         .doNotSizeWithWindow       = ").append(isDoNotSizeWithWindow()).append('\n');
/*  66 */     stringBuffer.append("         .defaultPlotDimensions     = ").append(isDefaultPlotDimensions()).append('\n');
/*  67 */     stringBuffer.append("         .autoPlotArea              = ").append(isAutoPlotArea()).append('\n');
/*  68 */     stringBuffer.append("    .empty                = ").append(HexDump.shortToHex(this.field_2_empty)).append('\n');
/*     */     
/*  70 */     stringBuffer.append("[/SHTPROPS]\n");
/*  71 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  75 */     paramLittleEndianOutput.writeShort(this.field_1_flags);
/*  76 */     paramLittleEndianOutput.writeShort(this.field_2_empty);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  80 */     return 4;
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  84 */     return 4164;
/*     */   }
/*     */   
/*     */   public Object clone() {
/*  88 */     SheetPropertiesRecord sheetPropertiesRecord = new SheetPropertiesRecord();
/*     */     
/*  90 */     sheetPropertiesRecord.field_1_flags = this.field_1_flags;
/*  91 */     sheetPropertiesRecord.field_2_empty = this.field_2_empty;
/*  92 */     return sheetPropertiesRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFlags() {
/*  99 */     return this.field_1_flags;
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
/*     */   public int getEmpty() {
/* 111 */     return this.field_2_empty;
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
/*     */   public void setEmpty(byte paramByte) {
/* 124 */     this.field_2_empty = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChartTypeManuallyFormatted(boolean paramBoolean) {
/* 132 */     this.field_1_flags = chartTypeManuallyFormatted.setBoolean(this.field_1_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isChartTypeManuallyFormatted() {
/* 140 */     return chartTypeManuallyFormatted.isSet(this.field_1_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPlotVisibleOnly(boolean paramBoolean) {
/* 148 */     this.field_1_flags = plotVisibleOnly.setBoolean(this.field_1_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPlotVisibleOnly() {
/* 156 */     return plotVisibleOnly.isSet(this.field_1_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDoNotSizeWithWindow(boolean paramBoolean) {
/* 164 */     this.field_1_flags = doNotSizeWithWindow.setBoolean(this.field_1_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDoNotSizeWithWindow() {
/* 172 */     return doNotSizeWithWindow.isSet(this.field_1_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultPlotDimensions(boolean paramBoolean) {
/* 180 */     this.field_1_flags = defaultPlotDimensions.setBoolean(this.field_1_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultPlotDimensions() {
/* 188 */     return defaultPlotDimensions.isSet(this.field_1_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoPlotArea(boolean paramBoolean) {
/* 196 */     this.field_1_flags = autoPlotArea.setBoolean(this.field_1_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoPlotArea() {
/* 204 */     return autoPlotArea.isSet(this.field_1_flags);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\SheetPropertiesRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */