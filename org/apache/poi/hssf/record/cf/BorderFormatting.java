/*     */ package org.apache.poi.hssf.record.cf;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public final class BorderFormatting
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short BORDER_NONE = 0;
/*     */   public static final short BORDER_THIN = 1;
/*     */   public static final short BORDER_MEDIUM = 2;
/*     */   public static final short BORDER_DASHED = 3;
/*     */   public static final short BORDER_HAIR = 4;
/*     */   public static final short BORDER_THICK = 5;
/*     */   public static final short BORDER_DOUBLE = 6;
/*     */   public static final short BORDER_DOTTED = 7;
/*     */   public static final short BORDER_MEDIUM_DASHED = 8;
/*     */   public static final short BORDER_DASH_DOT = 9;
/*     */   public static final short BORDER_MEDIUM_DASH_DOT = 10;
/*     */   public static final short BORDER_DASH_DOT_DOT = 11;
/*     */   public static final short BORDER_MEDIUM_DASH_DOT_DOT = 12;
/*     */   public static final short BORDER_SLANTED_DASH_DOT = 13;
/*     */   private int field_13_border_styles1;
/*  62 */   private static final BitField bordLeftLineStyle = BitFieldFactory.getInstance(15);
/*  63 */   private static final BitField bordRightLineStyle = BitFieldFactory.getInstance(240);
/*  64 */   private static final BitField bordTopLineStyle = BitFieldFactory.getInstance(3840);
/*  65 */   private static final BitField bordBottomLineStyle = BitFieldFactory.getInstance(61440);
/*  66 */   private static final BitField bordLeftLineColor = BitFieldFactory.getInstance(8323072);
/*  67 */   private static final BitField bordRightLineColor = BitFieldFactory.getInstance(1065353216);
/*  68 */   private static final BitField bordTlBrLineOnOff = BitFieldFactory.getInstance(1073741824);
/*  69 */   private static final BitField bordBlTrtLineOnOff = BitFieldFactory.getInstance(-2147483648);
/*     */   
/*     */   private int field_14_border_styles2;
/*  72 */   private static final BitField bordTopLineColor = BitFieldFactory.getInstance(127);
/*  73 */   private static final BitField bordBottomLineColor = BitFieldFactory.getInstance(16256);
/*  74 */   private static final BitField bordDiagLineColor = BitFieldFactory.getInstance(2080768);
/*  75 */   private static final BitField bordDiagLineStyle = BitFieldFactory.getInstance(31457280);
/*     */ 
/*     */   
/*     */   public BorderFormatting() {
/*  79 */     this.field_13_border_styles1 = 0;
/*  80 */     this.field_14_border_styles2 = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public BorderFormatting(LittleEndianInput paramLittleEndianInput) {
/*  85 */     this.field_13_border_styles1 = paramLittleEndianInput.readInt();
/*  86 */     this.field_14_border_styles2 = paramLittleEndianInput.readInt();
/*     */   }
/*     */   
/*     */   public int getDataLength() {
/*  90 */     return 8;
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
/*     */   public void setBorderLeft(int paramInt) {
/* 112 */     this.field_13_border_styles1 = bordLeftLineStyle.setValue(this.field_13_border_styles1, paramInt);
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
/*     */   public int getBorderLeft() {
/* 134 */     return bordLeftLineStyle.getValue(this.field_13_border_styles1);
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
/*     */   public void setBorderRight(int paramInt) {
/* 156 */     this.field_13_border_styles1 = bordRightLineStyle.setValue(this.field_13_border_styles1, paramInt);
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
/*     */   public int getBorderRight() {
/* 178 */     return bordRightLineStyle.getValue(this.field_13_border_styles1);
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
/*     */   public void setBorderTop(int paramInt) {
/* 200 */     this.field_13_border_styles1 = bordTopLineStyle.setValue(this.field_13_border_styles1, paramInt);
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
/*     */   public int getBorderTop() {
/* 222 */     return bordTopLineStyle.getValue(this.field_13_border_styles1);
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
/*     */   public void setBorderBottom(int paramInt) {
/* 244 */     this.field_13_border_styles1 = bordBottomLineStyle.setValue(this.field_13_border_styles1, paramInt);
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
/*     */   public int getBorderBottom() {
/* 266 */     return bordBottomLineStyle.getValue(this.field_13_border_styles1);
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
/*     */   public void setBorderDiagonal(int paramInt) {
/* 288 */     this.field_14_border_styles2 = bordDiagLineStyle.setValue(this.field_14_border_styles2, paramInt);
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
/*     */   public int getBorderDiagonal() {
/* 310 */     return bordDiagLineStyle.getValue(this.field_14_border_styles2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftBorderColor(int paramInt) {
/* 318 */     this.field_13_border_styles1 = bordLeftLineColor.setValue(this.field_13_border_styles1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLeftBorderColor() {
/* 327 */     return bordLeftLineColor.getValue(this.field_13_border_styles1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRightBorderColor(int paramInt) {
/* 335 */     this.field_13_border_styles1 = bordRightLineColor.setValue(this.field_13_border_styles1, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRightBorderColor() {
/* 344 */     return bordRightLineColor.getValue(this.field_13_border_styles1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTopBorderColor(int paramInt) {
/* 352 */     this.field_14_border_styles2 = bordTopLineColor.setValue(this.field_14_border_styles2, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTopBorderColor() {
/* 361 */     return bordTopLineColor.getValue(this.field_14_border_styles2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBottomBorderColor(int paramInt) {
/* 370 */     this.field_14_border_styles2 = bordBottomLineColor.setValue(this.field_14_border_styles2, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBottomBorderColor() {
/* 379 */     return bordBottomLineColor.getValue(this.field_14_border_styles2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDiagonalBorderColor(int paramInt) {
/* 387 */     this.field_14_border_styles2 = bordDiagLineColor.setValue(this.field_14_border_styles2, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDiagonalBorderColor() {
/* 396 */     return bordDiagLineColor.getValue(this.field_14_border_styles2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setForwardDiagonalOn(boolean paramBoolean) {
/* 405 */     this.field_13_border_styles1 = bordBlTrtLineOnOff.setBoolean(this.field_13_border_styles1, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBackwardDiagonalOn(boolean paramBoolean) {
/* 414 */     this.field_13_border_styles1 = bordTlBrLineOnOff.setBoolean(this.field_13_border_styles1, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isForwardDiagonalOn() {
/* 421 */     return bordBlTrtLineOnOff.isSet(this.field_13_border_styles1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBackwardDiagonalOn() {
/* 428 */     return bordTlBrLineOnOff.isSet(this.field_13_border_styles1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 433 */     StringBuffer stringBuffer = new StringBuffer();
/* 434 */     stringBuffer.append("    [Border Formatting]\n");
/* 435 */     stringBuffer.append("          .lftln     = ").append(Integer.toHexString(getBorderLeft())).append("\n");
/* 436 */     stringBuffer.append("          .rgtln     = ").append(Integer.toHexString(getBorderRight())).append("\n");
/* 437 */     stringBuffer.append("          .topln     = ").append(Integer.toHexString(getBorderTop())).append("\n");
/* 438 */     stringBuffer.append("          .btmln     = ").append(Integer.toHexString(getBorderBottom())).append("\n");
/* 439 */     stringBuffer.append("          .leftborder= ").append(Integer.toHexString(getLeftBorderColor())).append("\n");
/* 440 */     stringBuffer.append("          .rghtborder= ").append(Integer.toHexString(getRightBorderColor())).append("\n");
/* 441 */     stringBuffer.append("          .topborder= ").append(Integer.toHexString(getTopBorderColor())).append("\n");
/* 442 */     stringBuffer.append("          .bottomborder= ").append(Integer.toHexString(getBottomBorderColor())).append("\n");
/* 443 */     stringBuffer.append("          .fwdiag= ").append(isForwardDiagonalOn()).append("\n");
/* 444 */     stringBuffer.append("          .bwdiag= ").append(isBackwardDiagonalOn()).append("\n");
/* 445 */     stringBuffer.append("    [/Border Formatting]\n");
/* 446 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public BorderFormatting clone() {
/* 451 */     BorderFormatting borderFormatting = new BorderFormatting();
/* 452 */     borderFormatting.field_13_border_styles1 = this.field_13_border_styles1;
/* 453 */     borderFormatting.field_14_border_styles2 = this.field_14_border_styles2;
/* 454 */     return borderFormatting;
/*     */   }
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/* 458 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 0, this.field_13_border_styles1);
/* 459 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, this.field_14_border_styles2);
/* 460 */     return 8;
/*     */   }
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 463 */     paramLittleEndianOutput.writeInt(this.field_13_border_styles1);
/* 464 */     paramLittleEndianOutput.writeInt(this.field_14_border_styles2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\BorderFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */