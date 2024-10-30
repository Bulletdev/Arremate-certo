/*     */ package org.apache.poi.hssf.record.cf;
/*     */ 
/*     */ import org.apache.poi.hssf.record.common.ExtendedColor;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public final class DataBarFormatting
/*     */   implements Cloneable
/*     */ {
/*  32 */   private static POILogger log = POILogFactory.getLogger(DataBarFormatting.class);
/*     */   
/*  34 */   private byte options = 0;
/*  35 */   private byte percentMin = 0;
/*  36 */   private byte percentMax = 0;
/*     */   
/*     */   private ExtendedColor color;
/*     */   private DataBarThreshold thresholdMin;
/*     */   private DataBarThreshold thresholdMax;
/*  41 */   private static BitField iconOnly = BitFieldFactory.getInstance(1);
/*  42 */   private static BitField reversed = BitFieldFactory.getInstance(4);
/*     */   
/*     */   public DataBarFormatting() {
/*  45 */     this.options = 2;
/*     */   }
/*     */   public DataBarFormatting(LittleEndianInput paramLittleEndianInput) {
/*  48 */     paramLittleEndianInput.readShort();
/*  49 */     paramLittleEndianInput.readByte();
/*  50 */     this.options = paramLittleEndianInput.readByte();
/*     */     
/*  52 */     this.percentMin = paramLittleEndianInput.readByte();
/*  53 */     this.percentMax = paramLittleEndianInput.readByte();
/*  54 */     if (this.percentMin < 0 || this.percentMin > 100)
/*  55 */       log.log(5, new Object[] { "Inconsistent Minimum Percentage found " + this.percentMin }); 
/*  56 */     if (this.percentMax < 0 || this.percentMax > 100) {
/*  57 */       log.log(5, new Object[] { "Inconsistent Minimum Percentage found " + this.percentMin });
/*     */     }
/*  59 */     this.color = new ExtendedColor(paramLittleEndianInput);
/*  60 */     this.thresholdMin = new DataBarThreshold(paramLittleEndianInput);
/*  61 */     this.thresholdMax = new DataBarThreshold(paramLittleEndianInput);
/*     */   }
/*     */   
/*     */   public boolean isIconOnly() {
/*  65 */     return getOptionFlag(iconOnly);
/*     */   }
/*     */   public void setIconOnly(boolean paramBoolean) {
/*  68 */     setOptionFlag(paramBoolean, iconOnly);
/*     */   }
/*     */   
/*     */   public boolean isReversed() {
/*  72 */     return getOptionFlag(reversed);
/*     */   }
/*     */   public void setReversed(boolean paramBoolean) {
/*  75 */     setOptionFlag(paramBoolean, reversed);
/*     */   }
/*     */   
/*     */   private boolean getOptionFlag(BitField paramBitField) {
/*  79 */     int i = paramBitField.getValue(this.options);
/*  80 */     return !(i == 0);
/*     */   }
/*     */   private void setOptionFlag(boolean paramBoolean, BitField paramBitField) {
/*  83 */     this.options = paramBitField.setByteBoolean(this.options, paramBoolean);
/*     */   }
/*     */   
/*     */   public byte getPercentMin() {
/*  87 */     return this.percentMin;
/*     */   }
/*     */   public void setPercentMin(byte paramByte) {
/*  90 */     this.percentMin = paramByte;
/*     */   }
/*     */   
/*     */   public byte getPercentMax() {
/*  94 */     return this.percentMax;
/*     */   }
/*     */   public void setPercentMax(byte paramByte) {
/*  97 */     this.percentMax = paramByte;
/*     */   }
/*     */   
/*     */   public ExtendedColor getColor() {
/* 101 */     return this.color;
/*     */   }
/*     */   public void setColor(ExtendedColor paramExtendedColor) {
/* 104 */     this.color = paramExtendedColor;
/*     */   }
/*     */   
/*     */   public DataBarThreshold getThresholdMin() {
/* 108 */     return this.thresholdMin;
/*     */   }
/*     */   public void setThresholdMin(DataBarThreshold paramDataBarThreshold) {
/* 111 */     this.thresholdMin = paramDataBarThreshold;
/*     */   }
/*     */   
/*     */   public DataBarThreshold getThresholdMax() {
/* 115 */     return this.thresholdMax;
/*     */   }
/*     */   public void setThresholdMax(DataBarThreshold paramDataBarThreshold) {
/* 118 */     this.thresholdMax = paramDataBarThreshold;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 122 */     StringBuffer stringBuffer = new StringBuffer();
/* 123 */     stringBuffer.append("    [Data Bar Formatting]\n");
/* 124 */     stringBuffer.append("          .icon_only= ").append(isIconOnly()).append("\n");
/* 125 */     stringBuffer.append("          .reversed = ").append(isReversed()).append("\n");
/* 126 */     stringBuffer.append(this.color);
/* 127 */     stringBuffer.append(this.thresholdMin);
/* 128 */     stringBuffer.append(this.thresholdMax);
/* 129 */     stringBuffer.append("    [/Data Bar Formatting]\n");
/* 130 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 134 */     DataBarFormatting dataBarFormatting = new DataBarFormatting();
/* 135 */     dataBarFormatting.options = this.options;
/* 136 */     dataBarFormatting.percentMin = this.percentMin;
/* 137 */     dataBarFormatting.percentMax = this.percentMax;
/* 138 */     dataBarFormatting.color = this.color.clone();
/* 139 */     dataBarFormatting.thresholdMin = this.thresholdMin.clone();
/* 140 */     dataBarFormatting.thresholdMax = this.thresholdMax.clone();
/* 141 */     return dataBarFormatting;
/*     */   }
/*     */   
/*     */   public int getDataLength() {
/* 145 */     return 6 + this.color.getDataLength() + this.thresholdMin.getDataLength() + this.thresholdMax.getDataLength();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 151 */     paramLittleEndianOutput.writeShort(0);
/* 152 */     paramLittleEndianOutput.writeByte(0);
/* 153 */     paramLittleEndianOutput.writeByte(this.options);
/* 154 */     paramLittleEndianOutput.writeByte(this.percentMin);
/* 155 */     paramLittleEndianOutput.writeByte(this.percentMax);
/* 156 */     this.color.serialize(paramLittleEndianOutput);
/* 157 */     this.thresholdMin.serialize(paramLittleEndianOutput);
/* 158 */     this.thresholdMax.serialize(paramLittleEndianOutput);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\DataBarFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */