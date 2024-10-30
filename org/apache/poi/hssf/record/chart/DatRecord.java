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
/*     */ public final class DatRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4195;
/*  33 */   private static final BitField horizontalBorder = BitFieldFactory.getInstance(1);
/*  34 */   private static final BitField verticalBorder = BitFieldFactory.getInstance(2);
/*  35 */   private static final BitField border = BitFieldFactory.getInstance(4);
/*  36 */   private static final BitField showSeriesKey = BitFieldFactory.getInstance(8);
/*     */ 
/*     */   
/*     */   private short field_1_options;
/*     */ 
/*     */ 
/*     */   
/*     */   public DatRecord() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public DatRecord(RecordInputStream paramRecordInputStream) {
/*  48 */     this.field_1_options = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  53 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  55 */     stringBuffer.append("[DAT]\n");
/*  56 */     stringBuffer.append("    .options              = ").append("0x").append(HexDump.toHex(getOptions())).append(" (").append(getOptions()).append(" )");
/*     */ 
/*     */     
/*  59 */     stringBuffer.append(System.getProperty("line.separator"));
/*  60 */     stringBuffer.append("         .horizontalBorder         = ").append(isHorizontalBorder()).append('\n');
/*  61 */     stringBuffer.append("         .verticalBorder           = ").append(isVerticalBorder()).append('\n');
/*  62 */     stringBuffer.append("         .border                   = ").append(isBorder()).append('\n');
/*  63 */     stringBuffer.append("         .showSeriesKey            = ").append(isShowSeriesKey()).append('\n');
/*     */     
/*  65 */     stringBuffer.append("[/DAT]\n");
/*  66 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  70 */     paramLittleEndianOutput.writeShort(this.field_1_options);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  74 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  79 */     return 4195;
/*     */   }
/*     */ 
/*     */   
/*     */   public DatRecord clone() {
/*  84 */     DatRecord datRecord = new DatRecord();
/*  85 */     datRecord.field_1_options = this.field_1_options;
/*  86 */     return datRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/*  97 */     return this.field_1_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 105 */     this.field_1_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontalBorder(boolean paramBoolean) {
/* 114 */     this.field_1_options = horizontalBorder.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHorizontalBorder() {
/* 123 */     return horizontalBorder.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalBorder(boolean paramBoolean) {
/* 132 */     this.field_1_options = verticalBorder.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVerticalBorder() {
/* 141 */     return verticalBorder.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBorder(boolean paramBoolean) {
/* 150 */     this.field_1_options = border.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBorder() {
/* 159 */     return border.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowSeriesKey(boolean paramBoolean) {
/* 168 */     this.field_1_options = showSeriesKey.setShortBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShowSeriesKey() {
/* 177 */     return showSeriesKey.isSet(this.field_1_options);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\DatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */