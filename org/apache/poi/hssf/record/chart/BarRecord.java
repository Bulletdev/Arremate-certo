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
/*     */ public final class BarRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4119;
/*  35 */   private static final BitField horizontal = BitFieldFactory.getInstance(1);
/*  36 */   private static final BitField stacked = BitFieldFactory.getInstance(2);
/*  37 */   private static final BitField displayAsPercentage = BitFieldFactory.getInstance(4);
/*  38 */   private static final BitField shadow = BitFieldFactory.getInstance(8);
/*     */ 
/*     */   
/*     */   private short field_1_barSpace;
/*     */   
/*     */   private short field_2_categorySpace;
/*     */   
/*     */   private short field_3_formatFlags;
/*     */ 
/*     */   
/*     */   public BarRecord() {}
/*     */ 
/*     */   
/*     */   public BarRecord(RecordInputStream paramRecordInputStream) {
/*  52 */     this.field_1_barSpace = paramRecordInputStream.readShort();
/*  53 */     this.field_2_categorySpace = paramRecordInputStream.readShort();
/*  54 */     this.field_3_formatFlags = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  59 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  61 */     stringBuffer.append("[BAR]\n");
/*  62 */     stringBuffer.append("    .barSpace             = ").append("0x").append(HexDump.toHex(getBarSpace())).append(" (").append(getBarSpace()).append(" )");
/*     */ 
/*     */     
/*  65 */     stringBuffer.append(System.getProperty("line.separator"));
/*  66 */     stringBuffer.append("    .categorySpace        = ").append("0x").append(HexDump.toHex(getCategorySpace())).append(" (").append(getCategorySpace()).append(" )");
/*     */ 
/*     */     
/*  69 */     stringBuffer.append(System.getProperty("line.separator"));
/*  70 */     stringBuffer.append("    .formatFlags          = ").append("0x").append(HexDump.toHex(getFormatFlags())).append(" (").append(getFormatFlags()).append(" )");
/*     */ 
/*     */     
/*  73 */     stringBuffer.append(System.getProperty("line.separator"));
/*  74 */     stringBuffer.append("         .horizontal               = ").append(isHorizontal()).append('\n');
/*  75 */     stringBuffer.append("         .stacked                  = ").append(isStacked()).append('\n');
/*  76 */     stringBuffer.append("         .displayAsPercentage      = ").append(isDisplayAsPercentage()).append('\n');
/*  77 */     stringBuffer.append("         .shadow                   = ").append(isShadow()).append('\n');
/*     */     
/*  79 */     stringBuffer.append("[/BAR]\n");
/*  80 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  84 */     paramLittleEndianOutput.writeShort(this.field_1_barSpace);
/*  85 */     paramLittleEndianOutput.writeShort(this.field_2_categorySpace);
/*  86 */     paramLittleEndianOutput.writeShort(this.field_3_formatFlags);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  90 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  95 */     return 4119;
/*     */   }
/*     */ 
/*     */   
/*     */   public BarRecord clone() {
/* 100 */     BarRecord barRecord = new BarRecord();
/*     */     
/* 102 */     barRecord.field_1_barSpace = this.field_1_barSpace;
/* 103 */     barRecord.field_2_categorySpace = this.field_2_categorySpace;
/* 104 */     barRecord.field_3_formatFlags = this.field_3_formatFlags;
/* 105 */     return barRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBarSpace() {
/* 116 */     return this.field_1_barSpace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBarSpace(short paramShort) {
/* 124 */     this.field_1_barSpace = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCategorySpace() {
/* 132 */     return this.field_2_categorySpace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategorySpace(short paramShort) {
/* 140 */     this.field_2_categorySpace = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFormatFlags() {
/* 148 */     return this.field_3_formatFlags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatFlags(short paramShort) {
/* 156 */     this.field_3_formatFlags = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontal(boolean paramBoolean) {
/* 165 */     this.field_3_formatFlags = horizontal.setShortBoolean(this.field_3_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHorizontal() {
/* 174 */     return horizontal.isSet(this.field_3_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStacked(boolean paramBoolean) {
/* 183 */     this.field_3_formatFlags = stacked.setShortBoolean(this.field_3_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStacked() {
/* 192 */     return stacked.isSet(this.field_3_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayAsPercentage(boolean paramBoolean) {
/* 201 */     this.field_3_formatFlags = displayAsPercentage.setShortBoolean(this.field_3_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDisplayAsPercentage() {
/* 210 */     return displayAsPercentage.isSet(this.field_3_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShadow(boolean paramBoolean) {
/* 219 */     this.field_3_formatFlags = shadow.setShortBoolean(this.field_3_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShadow() {
/* 228 */     return shadow.isSet(this.field_3_formatFlags);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\BarRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */