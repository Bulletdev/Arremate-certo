/*     */ package org.apache.poi.hssf.record.cf;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public final class PatternFormatting
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short NO_FILL = 0;
/*     */   public static final short SOLID_FOREGROUND = 1;
/*     */   public static final short FINE_DOTS = 2;
/*     */   public static final short ALT_BARS = 3;
/*     */   public static final short SPARSE_DOTS = 4;
/*     */   public static final short THICK_HORZ_BANDS = 5;
/*     */   public static final short THICK_VERT_BANDS = 6;
/*     */   public static final short THICK_BACKWARD_DIAG = 7;
/*     */   public static final short THICK_FORWARD_DIAG = 8;
/*     */   public static final short BIG_SPOTS = 9;
/*     */   public static final short BRICKS = 10;
/*     */   public static final short THIN_HORZ_BANDS = 11;
/*     */   public static final short THIN_VERT_BANDS = 12;
/*     */   public static final short THIN_BACKWARD_DIAG = 13;
/*     */   public static final short THIN_FORWARD_DIAG = 14;
/*     */   public static final short SQUARES = 15;
/*     */   public static final short DIAMONDS = 16;
/*     */   public static final short LESS_DOTS = 17;
/*     */   public static final short LEAST_DOTS = 18;
/*     */   private int field_15_pattern_style;
/*  72 */   private static final BitField fillPatternStyle = BitFieldFactory.getInstance(64512);
/*     */   
/*     */   private int field_16_pattern_color_indexes;
/*  75 */   private static final BitField patternColorIndex = BitFieldFactory.getInstance(127);
/*  76 */   private static final BitField patternBackgroundColorIndex = BitFieldFactory.getInstance(16256);
/*     */ 
/*     */   
/*     */   public PatternFormatting() {
/*  80 */     this.field_15_pattern_style = 0;
/*  81 */     this.field_16_pattern_color_indexes = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public PatternFormatting(LittleEndianInput paramLittleEndianInput) {
/*  86 */     this.field_15_pattern_style = paramLittleEndianInput.readUShort();
/*  87 */     this.field_16_pattern_color_indexes = paramLittleEndianInput.readUShort();
/*     */   }
/*     */   
/*     */   public int getDataLength() {
/*  91 */     return 4;
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
/*     */   public void setFillPattern(int paramInt) {
/* 118 */     this.field_15_pattern_style = fillPatternStyle.setValue(this.field_15_pattern_style, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFillPattern() {
/* 125 */     return fillPatternStyle.getValue(this.field_15_pattern_style);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillBackgroundColor(int paramInt) {
/* 132 */     this.field_16_pattern_color_indexes = patternBackgroundColorIndex.setValue(this.field_16_pattern_color_indexes, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFillBackgroundColor() {
/* 140 */     return patternBackgroundColorIndex.getValue(this.field_16_pattern_color_indexes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillForegroundColor(int paramInt) {
/* 147 */     this.field_16_pattern_color_indexes = patternColorIndex.setValue(this.field_16_pattern_color_indexes, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFillForegroundColor() {
/* 155 */     return patternColorIndex.getValue(this.field_16_pattern_color_indexes);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 159 */     StringBuffer stringBuffer = new StringBuffer();
/* 160 */     stringBuffer.append("    [Pattern Formatting]\n");
/* 161 */     stringBuffer.append("          .fillpattern= ").append(Integer.toHexString(getFillPattern())).append("\n");
/* 162 */     stringBuffer.append("          .fgcoloridx= ").append(Integer.toHexString(getFillForegroundColor())).append("\n");
/* 163 */     stringBuffer.append("          .bgcoloridx= ").append(Integer.toHexString(getFillBackgroundColor())).append("\n");
/* 164 */     stringBuffer.append("    [/Pattern Formatting]\n");
/* 165 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 169 */     PatternFormatting patternFormatting = new PatternFormatting();
/* 170 */     patternFormatting.field_15_pattern_style = this.field_15_pattern_style;
/* 171 */     patternFormatting.field_16_pattern_color_indexes = this.field_16_pattern_color_indexes;
/* 172 */     return patternFormatting;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 176 */     paramLittleEndianOutput.writeShort(this.field_15_pattern_style);
/* 177 */     paramLittleEndianOutput.writeShort(this.field_16_pattern_color_indexes);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\PatternFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */