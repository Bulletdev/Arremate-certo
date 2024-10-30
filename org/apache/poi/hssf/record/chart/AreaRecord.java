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
/*     */ public final class AreaRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4122;
/*     */   private short field_1_formatFlags;
/*  35 */   private static final BitField stacked = BitFieldFactory.getInstance(1);
/*  36 */   private static final BitField displayAsPercentage = BitFieldFactory.getInstance(2);
/*  37 */   private static final BitField shadow = BitFieldFactory.getInstance(4);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AreaRecord() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AreaRecord(RecordInputStream paramRecordInputStream) {
/*  48 */     this.field_1_formatFlags = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  53 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  55 */     stringBuffer.append("[AREA]\n");
/*  56 */     stringBuffer.append("    .formatFlags          = ").append("0x").append(HexDump.toHex(getFormatFlags())).append(" (").append(getFormatFlags()).append(" )");
/*     */ 
/*     */     
/*  59 */     stringBuffer.append(System.getProperty("line.separator"));
/*  60 */     stringBuffer.append("         .stacked                  = ").append(isStacked()).append('\n');
/*  61 */     stringBuffer.append("         .displayAsPercentage      = ").append(isDisplayAsPercentage()).append('\n');
/*  62 */     stringBuffer.append("         .shadow                   = ").append(isShadow()).append('\n');
/*     */     
/*  64 */     stringBuffer.append("[/AREA]\n");
/*  65 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  69 */     paramLittleEndianOutput.writeShort(this.field_1_formatFlags);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  73 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  78 */     return 4122;
/*     */   }
/*     */ 
/*     */   
/*     */   public AreaRecord clone() {
/*  83 */     AreaRecord areaRecord = new AreaRecord();
/*     */     
/*  85 */     areaRecord.field_1_formatFlags = this.field_1_formatFlags;
/*  86 */     return areaRecord;
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
/*  97 */     return this.field_1_formatFlags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatFlags(short paramShort) {
/* 105 */     this.field_1_formatFlags = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStacked(boolean paramBoolean) {
/* 114 */     this.field_1_formatFlags = stacked.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStacked() {
/* 123 */     return stacked.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDisplayAsPercentage(boolean paramBoolean) {
/* 132 */     this.field_1_formatFlags = displayAsPercentage.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDisplayAsPercentage() {
/* 141 */     return displayAsPercentage.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShadow(boolean paramBoolean) {
/* 150 */     this.field_1_formatFlags = shadow.setShortBoolean(this.field_1_formatFlags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShadow() {
/* 159 */     return shadow.isSet(this.field_1_formatFlags);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\AreaRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */