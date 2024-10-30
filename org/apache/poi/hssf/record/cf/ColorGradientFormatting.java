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
/*     */ 
/*     */ 
/*     */ public final class ColorGradientFormatting
/*     */   implements Cloneable
/*     */ {
/*  34 */   private static POILogger log = POILogFactory.getLogger(ColorGradientFormatting.class);
/*     */   
/*  36 */   private byte options = 0;
/*     */   
/*     */   private ColorGradientThreshold[] thresholds;
/*     */   private ExtendedColor[] colors;
/*  40 */   private static BitField clamp = BitFieldFactory.getInstance(1);
/*  41 */   private static BitField background = BitFieldFactory.getInstance(2);
/*     */   
/*     */   public ColorGradientFormatting() {
/*  44 */     this.options = 3;
/*  45 */     this.thresholds = new ColorGradientThreshold[3];
/*  46 */     this.colors = new ExtendedColor[3];
/*     */   }
/*     */   public ColorGradientFormatting(LittleEndianInput paramLittleEndianInput) {
/*  49 */     paramLittleEndianInput.readShort();
/*  50 */     paramLittleEndianInput.readByte();
/*  51 */     byte b1 = paramLittleEndianInput.readByte();
/*  52 */     byte b2 = paramLittleEndianInput.readByte();
/*  53 */     if (b1 != b2) {
/*  54 */       log.log(5, new Object[] { "Inconsistent Color Gradient defintion, found " + b1 + " vs " + b2 + " entries" });
/*     */     }
/*  56 */     this.options = paramLittleEndianInput.readByte();
/*     */     
/*  58 */     this.thresholds = new ColorGradientThreshold[b1]; byte b;
/*  59 */     for (b = 0; b < this.thresholds.length; b++) {
/*  60 */       this.thresholds[b] = new ColorGradientThreshold(paramLittleEndianInput);
/*     */     }
/*  62 */     this.colors = new ExtendedColor[b2];
/*  63 */     for (b = 0; b < this.colors.length; b++) {
/*  64 */       paramLittleEndianInput.readDouble();
/*  65 */       this.colors[b] = new ExtendedColor(paramLittleEndianInput);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getNumControlPoints() {
/*  70 */     return this.thresholds.length;
/*     */   }
/*     */   public void setNumControlPoints(int paramInt) {
/*  73 */     if (paramInt != this.thresholds.length) {
/*  74 */       ColorGradientThreshold[] arrayOfColorGradientThreshold = new ColorGradientThreshold[paramInt];
/*  75 */       ExtendedColor[] arrayOfExtendedColor = new ExtendedColor[paramInt];
/*     */       
/*  77 */       int i = Math.min(this.thresholds.length, paramInt);
/*  78 */       System.arraycopy(this.thresholds, 0, arrayOfColorGradientThreshold, 0, i);
/*  79 */       System.arraycopy(this.colors, 0, arrayOfExtendedColor, 0, i);
/*     */       
/*  81 */       this.thresholds = arrayOfColorGradientThreshold;
/*  82 */       this.colors = arrayOfExtendedColor;
/*     */       
/*  84 */       updateThresholdPositions();
/*     */     } 
/*     */   }
/*     */   
/*     */   public ColorGradientThreshold[] getThresholds() {
/*  89 */     return this.thresholds;
/*     */   }
/*     */   public void setThresholds(ColorGradientThreshold[] paramArrayOfColorGradientThreshold) {
/*  92 */     this.thresholds = (paramArrayOfColorGradientThreshold == null) ? null : (ColorGradientThreshold[])paramArrayOfColorGradientThreshold.clone();
/*  93 */     updateThresholdPositions();
/*     */   }
/*     */   
/*     */   public ExtendedColor[] getColors() {
/*  97 */     return this.colors;
/*     */   }
/*     */   public void setColors(ExtendedColor[] paramArrayOfExtendedColor) {
/* 100 */     this.colors = (paramArrayOfExtendedColor == null) ? null : (ExtendedColor[])paramArrayOfExtendedColor.clone();
/*     */   }
/*     */   
/*     */   public boolean isClampToCurve() {
/* 104 */     return getOptionFlag(clamp);
/*     */   }
/*     */   public boolean isAppliesToBackground() {
/* 107 */     return getOptionFlag(background);
/*     */   }
/*     */   private boolean getOptionFlag(BitField paramBitField) {
/* 110 */     int i = paramBitField.getValue(this.options);
/* 111 */     return !(i == 0);
/*     */   }
/*     */   
/*     */   private void updateThresholdPositions() {
/* 115 */     double d = 1.0D / (this.thresholds.length - 1);
/* 116 */     for (byte b = 0; b < this.thresholds.length; b++) {
/* 117 */       this.thresholds[b].setPosition(d * b);
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString() {
/* 122 */     StringBuffer stringBuffer = new StringBuffer();
/* 123 */     stringBuffer.append("    [Color Gradient Formatting]\n");
/* 124 */     stringBuffer.append("          .clamp     = ").append(isClampToCurve()).append("\n");
/* 125 */     stringBuffer.append("          .background= ").append(isAppliesToBackground()).append("\n");
/* 126 */     for (ColorGradientThreshold colorGradientThreshold : this.thresholds) {
/* 127 */       stringBuffer.append(colorGradientThreshold.toString());
/*     */     }
/* 129 */     for (ExtendedColor extendedColor : this.colors) {
/* 130 */       stringBuffer.append(extendedColor.toString());
/*     */     }
/* 132 */     stringBuffer.append("    [/Color Gradient Formatting]\n");
/* 133 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 137 */     ColorGradientFormatting colorGradientFormatting = new ColorGradientFormatting();
/* 138 */     colorGradientFormatting.options = this.options;
/* 139 */     colorGradientFormatting.thresholds = new ColorGradientThreshold[this.thresholds.length];
/* 140 */     colorGradientFormatting.colors = new ExtendedColor[this.colors.length];
/* 141 */     System.arraycopy(this.thresholds, 0, colorGradientFormatting.thresholds, 0, this.thresholds.length);
/* 142 */     System.arraycopy(this.colors, 0, colorGradientFormatting.colors, 0, this.colors.length);
/* 143 */     return colorGradientFormatting;
/*     */   }
/*     */   
/*     */   public int getDataLength() {
/* 147 */     int i = 6;
/* 148 */     for (ColorGradientThreshold colorGradientThreshold : this.thresholds) {
/* 149 */       i += colorGradientThreshold.getDataLength();
/*     */     }
/* 151 */     for (ExtendedColor extendedColor : this.colors) {
/* 152 */       i += extendedColor.getDataLength();
/* 153 */       i += 8;
/*     */     } 
/* 155 */     return i;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 159 */     paramLittleEndianOutput.writeShort(0);
/* 160 */     paramLittleEndianOutput.writeByte(0);
/* 161 */     paramLittleEndianOutput.writeByte(this.thresholds.length);
/* 162 */     paramLittleEndianOutput.writeByte(this.thresholds.length);
/* 163 */     paramLittleEndianOutput.writeByte(this.options);
/*     */     
/* 165 */     for (ColorGradientThreshold colorGradientThreshold : this.thresholds) {
/* 166 */       colorGradientThreshold.serialize(paramLittleEndianOutput);
/*     */     }
/*     */     
/* 169 */     double d = 1.0D / (this.colors.length - 1);
/* 170 */     for (byte b = 0; b < this.colors.length; b++) {
/* 171 */       paramLittleEndianOutput.writeDouble(b * d);
/*     */       
/* 173 */       ExtendedColor extendedColor = this.colors[b];
/* 174 */       extendedColor.serialize(paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\ColorGradientFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */