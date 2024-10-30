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
/*     */ public final class SeriesLabelsRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4108;
/*  35 */   private static final BitField showActual = BitFieldFactory.getInstance(1);
/*  36 */   private static final BitField showPercent = BitFieldFactory.getInstance(2);
/*  37 */   private static final BitField labelAsPercentage = BitFieldFactory.getInstance(4);
/*  38 */   private static final BitField smoothedLine = BitFieldFactory.getInstance(8);
/*  39 */   private static final BitField showLabel = BitFieldFactory.getInstance(16);
/*  40 */   private static final BitField showBubbleSizes = BitFieldFactory.getInstance(32);
/*     */ 
/*     */   
/*     */   private short field_1_formatFlags;
/*     */ 
/*     */ 
/*     */   
/*     */   public SeriesLabelsRecord() {}
/*     */ 
/*     */   
/*     */   public SeriesLabelsRecord(RecordInputStream paramRecordInputStream) {
/*  51 */     this.field_1_formatFlags = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  56 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  58 */     stringBuffer.append("[ATTACHEDLABEL]\n");
/*  59 */     stringBuffer.append("    .formatFlags          = ").append("0x").append(HexDump.toHex(getFormatFlags())).append(" (").append(getFormatFlags()).append(" )");
/*     */ 
/*     */     
/*  62 */     stringBuffer.append(System.getProperty("line.separator"));
/*  63 */     stringBuffer.append("         .showActual               = ").append(isShowActual()).append('\n');
/*  64 */     stringBuffer.append("         .showPercent              = ").append(isShowPercent()).append('\n');
/*  65 */     stringBuffer.append("         .labelAsPercentage        = ").append(isLabelAsPercentage()).append('\n');
/*  66 */     stringBuffer.append("         .smoothedLine             = ").append(isSmoothedLine()).append('\n');
/*  67 */     stringBuffer.append("         .showLabel                = ").append(isShowLabel()).append('\n');
/*  68 */     stringBuffer.append("         .showBubbleSizes          = ").append(isShowBubbleSizes()).append('\n');
/*     */     
/*  70 */     stringBuffer.append("[/ATTACHEDLABEL]\n");
/*  71 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  75 */     paramLittleEndianOutput.writeShort(this.field_1_formatFlags);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  79 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  84 */     return 4108;
/*     */   }
/*     */   
/*     */   public Object clone() {
/*  88 */     SeriesLabelsRecord seriesLabelsRecord = new SeriesLabelsRecord();
/*     */     
/*  90 */     seriesLabelsRecord.field_1_formatFlags = this.field_1_formatFlags;
/*  91 */     return seriesLabelsRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFormatFlags() {
/* 102 */     return this.field_1_formatFlags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatFlags(short paramShort) {
/* 110 */     this.field_1_formatFlags = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowActual(boolean paramBoolean) {
/* 119 */     this.field_1_formatFlags = showActual.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShowActual() {
/* 128 */     return showActual.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowPercent(boolean paramBoolean) {
/* 137 */     this.field_1_formatFlags = showPercent.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShowPercent() {
/* 146 */     return showPercent.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLabelAsPercentage(boolean paramBoolean) {
/* 155 */     this.field_1_formatFlags = labelAsPercentage.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLabelAsPercentage() {
/* 164 */     return labelAsPercentage.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSmoothedLine(boolean paramBoolean) {
/* 173 */     this.field_1_formatFlags = smoothedLine.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSmoothedLine() {
/* 182 */     return smoothedLine.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowLabel(boolean paramBoolean) {
/* 191 */     this.field_1_formatFlags = showLabel.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShowLabel() {
/* 200 */     return showLabel.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShowBubbleSizes(boolean paramBoolean) {
/* 209 */     this.field_1_formatFlags = showBubbleSizes.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShowBubbleSizes() {
/* 218 */     return showBubbleSizes.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\SeriesLabelsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */