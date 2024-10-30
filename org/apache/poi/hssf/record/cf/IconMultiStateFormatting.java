/*     */ package org.apache.poi.hssf.record.cf;
/*     */ 
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
/*     */ 
/*     */ public final class IconMultiStateFormatting
/*     */   implements Cloneable
/*     */ {
/*  32 */   private static POILogger log = POILogFactory.getLogger(IconMultiStateFormatting.class);
/*     */   
/*     */   private org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet iconSet;
/*     */   
/*     */   private byte options;
/*     */   private Threshold[] thresholds;
/*  38 */   private static BitField iconOnly = BitFieldFactory.getInstance(1);
/*  39 */   private static BitField reversed = BitFieldFactory.getInstance(4);
/*     */   
/*     */   public IconMultiStateFormatting() {
/*  42 */     this.iconSet = org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet.GYR_3_TRAFFIC_LIGHTS;
/*  43 */     this.options = 0;
/*  44 */     this.thresholds = new Threshold[this.iconSet.num];
/*     */   }
/*     */   public IconMultiStateFormatting(LittleEndianInput paramLittleEndianInput) {
/*  47 */     paramLittleEndianInput.readShort();
/*  48 */     paramLittleEndianInput.readByte();
/*  49 */     byte b1 = paramLittleEndianInput.readByte();
/*  50 */     byte b2 = paramLittleEndianInput.readByte();
/*  51 */     this.iconSet = org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet.byId(b2);
/*  52 */     if (this.iconSet.num != b1) {
/*  53 */       log.log(5, new Object[] { "Inconsistent Icon Set defintion, found " + this.iconSet + " but defined as " + b1 + " entries" });
/*     */     }
/*  55 */     this.options = paramLittleEndianInput.readByte();
/*     */     
/*  57 */     this.thresholds = new Threshold[this.iconSet.num];
/*  58 */     for (byte b = 0; b < this.thresholds.length; b++) {
/*  59 */       this.thresholds[b] = new IconMultiStateThreshold(paramLittleEndianInput);
/*     */     }
/*     */   }
/*     */   
/*     */   public org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet getIconSet() {
/*  64 */     return this.iconSet;
/*     */   }
/*     */   public void setIconSet(org.apache.poi.ss.usermodel.IconMultiStateFormatting.IconSet paramIconSet) {
/*  67 */     this.iconSet = paramIconSet;
/*     */   }
/*     */   
/*     */   public Threshold[] getThresholds() {
/*  71 */     return this.thresholds;
/*     */   }
/*     */   public void setThresholds(Threshold[] paramArrayOfThreshold) {
/*  74 */     this.thresholds = (paramArrayOfThreshold == null) ? null : (Threshold[])paramArrayOfThreshold.clone();
/*     */   }
/*     */   
/*     */   public boolean isIconOnly() {
/*  78 */     return getOptionFlag(iconOnly);
/*     */   }
/*     */   public void setIconOnly(boolean paramBoolean) {
/*  81 */     setOptionFlag(paramBoolean, iconOnly);
/*     */   }
/*     */   
/*     */   public boolean isReversed() {
/*  85 */     return getOptionFlag(reversed);
/*     */   }
/*     */   public void setReversed(boolean paramBoolean) {
/*  88 */     setOptionFlag(paramBoolean, reversed);
/*     */   }
/*     */   
/*     */   private boolean getOptionFlag(BitField paramBitField) {
/*  92 */     int i = paramBitField.getValue(this.options);
/*  93 */     return !(i == 0);
/*     */   }
/*     */   private void setOptionFlag(boolean paramBoolean, BitField paramBitField) {
/*  96 */     this.options = paramBitField.setByteBoolean(this.options, paramBoolean);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuffer stringBuffer = new StringBuffer();
/* 101 */     stringBuffer.append("    [Icon Formatting]\n");
/* 102 */     stringBuffer.append("          .icon_set = ").append(this.iconSet).append("\n");
/* 103 */     stringBuffer.append("          .icon_only= ").append(isIconOnly()).append("\n");
/* 104 */     stringBuffer.append("          .reversed = ").append(isReversed()).append("\n");
/* 105 */     for (Threshold threshold : this.thresholds) {
/* 106 */       stringBuffer.append(threshold.toString());
/*     */     }
/* 108 */     stringBuffer.append("    [/Icon Formatting]\n");
/* 109 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 113 */     IconMultiStateFormatting iconMultiStateFormatting = new IconMultiStateFormatting();
/* 114 */     iconMultiStateFormatting.iconSet = this.iconSet;
/* 115 */     iconMultiStateFormatting.options = this.options;
/* 116 */     iconMultiStateFormatting.thresholds = new Threshold[this.thresholds.length];
/* 117 */     System.arraycopy(this.thresholds, 0, iconMultiStateFormatting.thresholds, 0, this.thresholds.length);
/* 118 */     return iconMultiStateFormatting;
/*     */   }
/*     */   
/*     */   public int getDataLength() {
/* 122 */     int i = 6;
/* 123 */     for (Threshold threshold : this.thresholds) {
/* 124 */       i += threshold.getDataLength();
/*     */     }
/* 126 */     return i;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 130 */     paramLittleEndianOutput.writeShort(0);
/* 131 */     paramLittleEndianOutput.writeByte(0);
/* 132 */     paramLittleEndianOutput.writeByte(this.iconSet.num);
/* 133 */     paramLittleEndianOutput.writeByte(this.iconSet.id);
/* 134 */     paramLittleEndianOutput.writeByte(this.options);
/* 135 */     for (Threshold threshold : this.thresholds)
/* 136 */       threshold.serialize(paramLittleEndianOutput); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\IconMultiStateFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */