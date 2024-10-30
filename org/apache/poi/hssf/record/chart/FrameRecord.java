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
/*     */ public final class FrameRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4146;
/*  33 */   private static final BitField autoSize = BitFieldFactory.getInstance(1);
/*  34 */   private static final BitField autoPosition = BitFieldFactory.getInstance(2);
/*     */   
/*     */   private short field_1_borderType;
/*     */   
/*     */   public static final short BORDER_TYPE_REGULAR = 0;
/*     */   
/*     */   public static final short BORDER_TYPE_SHADOW = 1;
/*     */   
/*     */   private short field_2_options;
/*     */ 
/*     */   
/*     */   public FrameRecord() {}
/*     */ 
/*     */   
/*     */   public FrameRecord(RecordInputStream paramRecordInputStream) {
/*  49 */     this.field_1_borderType = paramRecordInputStream.readShort();
/*  50 */     this.field_2_options = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  55 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  57 */     stringBuffer.append("[FRAME]\n");
/*  58 */     stringBuffer.append("    .borderType           = ").append("0x").append(HexDump.toHex(getBorderType())).append(" (").append(getBorderType()).append(" )");
/*     */ 
/*     */     
/*  61 */     stringBuffer.append(System.getProperty("line.separator"));
/*  62 */     stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append(getOptions()).append(" )");
/*     */ 
/*     */     
/*  65 */     stringBuffer.append(System.getProperty("line.separator"));
/*  66 */     stringBuffer.append("         .autoSize                 = ").append(isAutoSize()).append('\n');
/*  67 */     stringBuffer.append("         .autoPosition             = ").append(isAutoPosition()).append('\n');
/*     */     
/*  69 */     stringBuffer.append("[/FRAME]\n");
/*  70 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  74 */     paramLittleEndianOutput.writeShort(this.field_1_borderType);
/*  75 */     paramLittleEndianOutput.writeShort(this.field_2_options);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  79 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  84 */     return 4146;
/*     */   }
/*     */ 
/*     */   
/*     */   public FrameRecord clone() {
/*  89 */     FrameRecord frameRecord = new FrameRecord();
/*     */     
/*  91 */     frameRecord.field_1_borderType = this.field_1_borderType;
/*  92 */     frameRecord.field_2_options = this.field_2_options;
/*  93 */     return frameRecord;
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
/*     */   public short getBorderType() {
/* 108 */     return this.field_1_borderType;
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
/*     */   public void setBorderType(short paramShort) {
/* 121 */     this.field_1_borderType = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 129 */     return this.field_2_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 137 */     this.field_2_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoSize(boolean paramBoolean) {
/* 146 */     this.field_2_options = autoSize.setShortBoolean(this.field_2_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoSize() {
/* 155 */     return autoSize.isSet(this.field_2_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoPosition(boolean paramBoolean) {
/* 164 */     this.field_2_options = autoPosition.setShortBoolean(this.field_2_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoPosition() {
/* 173 */     return autoPosition.isSet(this.field_2_options);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\FrameRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */