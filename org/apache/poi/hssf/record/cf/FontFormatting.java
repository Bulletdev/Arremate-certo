/*     */ package org.apache.poi.hssf.record.cf;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FontFormatting
/*     */   implements Cloneable
/*     */ {
/*  32 */   private final byte[] _rawData = new byte[118];
/*     */   
/*     */   private static final int OFFSET_FONT_NAME = 0;
/*     */   
/*     */   private static final int OFFSET_FONT_HEIGHT = 64;
/*     */   
/*     */   private static final int OFFSET_FONT_OPTIONS = 68;
/*     */   
/*     */   private static final int OFFSET_FONT_WEIGHT = 72;
/*     */   
/*     */   private static final int OFFSET_ESCAPEMENT_TYPE = 74;
/*     */   private static final int OFFSET_UNDERLINE_TYPE = 76;
/*     */   private static final int OFFSET_FONT_COLOR_INDEX = 80;
/*     */   private static final int OFFSET_OPTION_FLAGS = 88;
/*     */   private static final int OFFSET_ESCAPEMENT_TYPE_MODIFIED = 92;
/*     */   private static final int OFFSET_UNDERLINE_TYPE_MODIFIED = 96;
/*     */   private static final int OFFSET_FONT_WEIGHT_MODIFIED = 100;
/*     */   private static final int OFFSET_NOT_USED1 = 104;
/*     */   private static final int OFFSET_NOT_USED2 = 108;
/*     */   private static final int OFFSET_NOT_USED3 = 112;
/*     */   private static final int OFFSET_FONT_FORMATING_END = 116;
/*     */   private static final int RAW_DATA_SIZE = 118;
/*     */   public static final int FONT_CELL_HEIGHT_PRESERVED = -1;
/*  55 */   private static final BitField posture = BitFieldFactory.getInstance(2);
/*  56 */   private static final BitField outline = BitFieldFactory.getInstance(8);
/*  57 */   private static final BitField shadow = BitFieldFactory.getInstance(16);
/*  58 */   private static final BitField cancellation = BitFieldFactory.getInstance(128);
/*     */ 
/*     */ 
/*     */   
/*  62 */   private static final BitField styleModified = BitFieldFactory.getInstance(2);
/*  63 */   private static final BitField outlineModified = BitFieldFactory.getInstance(8);
/*  64 */   private static final BitField shadowModified = BitFieldFactory.getInstance(16);
/*  65 */   private static final BitField cancellationModified = BitFieldFactory.getInstance(128);
/*     */ 
/*     */   
/*     */   public static final short SS_NONE = 0;
/*     */ 
/*     */   
/*     */   public static final short SS_SUPER = 1;
/*     */ 
/*     */   
/*     */   public static final short SS_SUB = 2;
/*     */   
/*     */   public static final byte U_NONE = 0;
/*     */   
/*     */   public static final byte U_SINGLE = 1;
/*     */   
/*     */   public static final byte U_DOUBLE = 2;
/*     */   
/*     */   public static final byte U_SINGLE_ACCOUNTING = 33;
/*     */   
/*     */   public static final byte U_DOUBLE_ACCOUNTING = 34;
/*     */   
/*     */   private static final short FONT_WEIGHT_NORMAL = 400;
/*     */   
/*     */   private static final short FONT_WEIGHT_BOLD = 700;
/*     */ 
/*     */   
/*     */   public FontFormatting() {
/*  92 */     setFontHeight(-1);
/*  93 */     setItalic(false);
/*  94 */     setFontWieghtModified(false);
/*  95 */     setOutline(false);
/*  96 */     setShadow(false);
/*  97 */     setStrikeout(false);
/*  98 */     setEscapementType((short)0);
/*  99 */     setUnderlineType((short)0);
/* 100 */     setFontColorIndex((short)-1);
/*     */     
/* 102 */     setFontStyleModified(false);
/* 103 */     setFontOutlineModified(false);
/* 104 */     setFontShadowModified(false);
/* 105 */     setFontCancellationModified(false);
/*     */     
/* 107 */     setEscapementTypeModified(false);
/* 108 */     setUnderlineTypeModified(false);
/*     */     
/* 110 */     setShort(0, 0);
/* 111 */     setInt(104, 1);
/* 112 */     setInt(108, 0);
/* 113 */     setInt(112, 2147483647);
/* 114 */     setShort(116, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public FontFormatting(RecordInputStream paramRecordInputStream) {
/* 119 */     for (byte b = 0; b < this._rawData.length; b++) {
/* 120 */       this._rawData[b] = paramRecordInputStream.readByte();
/*     */     }
/*     */   }
/*     */   
/*     */   private short getShort(int paramInt) {
/* 125 */     return LittleEndian.getShort(this._rawData, paramInt);
/*     */   }
/*     */   private void setShort(int paramInt1, int paramInt2) {
/* 128 */     LittleEndian.putShort(this._rawData, paramInt1, (short)paramInt2);
/*     */   }
/*     */   private int getInt(int paramInt) {
/* 131 */     return LittleEndian.getInt(this._rawData, paramInt);
/*     */   }
/*     */   private void setInt(int paramInt1, int paramInt2) {
/* 134 */     LittleEndian.putInt(this._rawData, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getRawRecord() {
/* 139 */     return this._rawData;
/*     */   }
/*     */   
/*     */   public int getDataLength() {
/* 143 */     return 118;
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
/*     */   public void setFontHeight(int paramInt) {
/* 155 */     setInt(64, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFontHeight() {
/* 165 */     return getInt(64);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setFontOption(boolean paramBoolean, BitField paramBitField) {
/* 170 */     int i = getInt(68);
/* 171 */     i = paramBitField.setBoolean(i, paramBoolean);
/* 172 */     setInt(68, i);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean getFontOption(BitField paramBitField) {
/* 177 */     int i = getInt(68);
/* 178 */     return paramBitField.isSet(i);
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
/*     */   public void setItalic(boolean paramBoolean) {
/* 190 */     setFontOption(paramBoolean, posture);
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
/*     */   public boolean isItalic() {
/* 202 */     return getFontOption(posture);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOutline(boolean paramBoolean) {
/* 207 */     setFontOption(paramBoolean, outline);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOutlineOn() {
/* 212 */     return getFontOption(outline);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShadow(boolean paramBoolean) {
/* 217 */     setFontOption(paramBoolean, shadow);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isShadowOn() {
/* 222 */     return getFontOption(shadow);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrikeout(boolean paramBoolean) {
/* 232 */     setFontOption(paramBoolean, cancellation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStruckout() {
/* 243 */     return getFontOption(cancellation);
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
/*     */   private void setFontWeight(short paramShort) {
/* 255 */     short s = paramShort;
/* 256 */     if (s < 100) s = 100; 
/* 257 */     if (s > 1000) s = 1000; 
/* 258 */     setShort(72, s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBold(boolean paramBoolean) {
/* 268 */     setFontWeight(paramBoolean ? 700 : 400);
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
/*     */   public short getFontWeight() {
/* 280 */     return getShort(72);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBold() {
/* 291 */     return (getFontWeight() == 700);
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
/*     */   public short getEscapementType() {
/* 304 */     return getShort(74);
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
/*     */   public void setEscapementType(short paramShort) {
/* 317 */     setShort(74, paramShort);
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
/*     */   public short getUnderlineType() {
/* 333 */     return getShort(76);
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
/*     */   public void setUnderlineType(short paramShort) {
/* 349 */     setShort(76, paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFontColorIndex() {
/* 355 */     return (short)getInt(80);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontColorIndex(short paramShort) {
/* 360 */     setInt(80, paramShort);
/*     */   }
/*     */   
/*     */   private boolean getOptionFlag(BitField paramBitField) {
/* 364 */     int i = getInt(88);
/* 365 */     int j = paramBitField.getValue(i);
/* 366 */     return (j == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setOptionFlag(boolean paramBoolean, BitField paramBitField) {
/* 371 */     boolean bool = paramBoolean ? false : true;
/* 372 */     int i = getInt(88);
/* 373 */     i = paramBitField.setValue(i, bool);
/* 374 */     setInt(88, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFontStyleModified() {
/* 380 */     return getOptionFlag(styleModified);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontStyleModified(boolean paramBoolean) {
/* 386 */     setOptionFlag(paramBoolean, styleModified);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFontOutlineModified() {
/* 391 */     return getOptionFlag(outlineModified);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontOutlineModified(boolean paramBoolean) {
/* 396 */     setOptionFlag(paramBoolean, outlineModified);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFontShadowModified() {
/* 401 */     return getOptionFlag(shadowModified);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontShadowModified(boolean paramBoolean) {
/* 406 */     setOptionFlag(paramBoolean, shadowModified);
/*     */   }
/*     */   
/*     */   public void setFontCancellationModified(boolean paramBoolean) {
/* 410 */     setOptionFlag(paramBoolean, cancellationModified);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFontCancellationModified() {
/* 415 */     return getOptionFlag(cancellationModified);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEscapementTypeModified(boolean paramBoolean) {
/* 420 */     boolean bool = paramBoolean ? false : true;
/* 421 */     setInt(92, bool);
/*     */   }
/*     */   
/*     */   public boolean isEscapementTypeModified() {
/* 425 */     int i = getInt(92);
/* 426 */     return (i == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnderlineTypeModified(boolean paramBoolean) {
/* 431 */     boolean bool = paramBoolean ? false : true;
/* 432 */     setInt(96, bool);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnderlineTypeModified() {
/* 437 */     int i = getInt(96);
/* 438 */     return (i == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontWieghtModified(boolean paramBoolean) {
/* 443 */     boolean bool = paramBoolean ? false : true;
/* 444 */     setInt(100, bool);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFontWeightModified() {
/* 449 */     int i = getInt(100);
/* 450 */     return (i == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 455 */     StringBuffer stringBuffer = new StringBuffer();
/* 456 */     stringBuffer.append("    [Font Formatting]\n");
/*     */     
/* 458 */     stringBuffer.append("\t.font height = ").append(getFontHeight()).append(" twips\n");
/*     */     
/* 460 */     if (isFontStyleModified()) {
/*     */       
/* 462 */       stringBuffer.append("\t.font posture = ").append(isItalic() ? "Italic" : "Normal").append("\n");
/*     */     }
/*     */     else {
/*     */       
/* 466 */       stringBuffer.append("\t.font posture = ]not modified]").append("\n");
/*     */     } 
/*     */     
/* 469 */     if (isFontOutlineModified()) {
/*     */       
/* 471 */       stringBuffer.append("\t.font outline = ").append(isOutlineOn()).append("\n");
/*     */     }
/*     */     else {
/*     */       
/* 475 */       stringBuffer.append("\t.font outline is not modified\n");
/*     */     } 
/*     */     
/* 478 */     if (isFontShadowModified()) {
/*     */       
/* 480 */       stringBuffer.append("\t.font shadow = ").append(isShadowOn()).append("\n");
/*     */     }
/*     */     else {
/*     */       
/* 484 */       stringBuffer.append("\t.font shadow is not modified\n");
/*     */     } 
/*     */     
/* 487 */     if (isFontCancellationModified()) {
/*     */       
/* 489 */       stringBuffer.append("\t.font strikeout = ").append(isStruckout()).append("\n");
/*     */     }
/*     */     else {
/*     */       
/* 493 */       stringBuffer.append("\t.font strikeout is not modified\n");
/*     */     } 
/*     */     
/* 496 */     if (isFontStyleModified()) {
/*     */       
/* 498 */       stringBuffer.append("\t.font weight = ").append(getFontWeight()).append((getFontWeight() == 400) ? "(Normal)" : ((getFontWeight() == 700) ? "(Bold)" : ("0x" + Integer.toHexString(getFontWeight())))).append("\n");
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 508 */       stringBuffer.append("\t.font weight = ]not modified]").append("\n");
/*     */     } 
/*     */     
/* 511 */     if (isEscapementTypeModified()) {
/*     */       
/* 513 */       stringBuffer.append("\t.escapement type = ").append(getEscapementType()).append("\n");
/*     */     }
/*     */     else {
/*     */       
/* 517 */       stringBuffer.append("\t.escapement type is not modified\n");
/*     */     } 
/*     */     
/* 520 */     if (isUnderlineTypeModified()) {
/*     */       
/* 522 */       stringBuffer.append("\t.underline type = ").append(getUnderlineType()).append("\n");
/*     */     }
/*     */     else {
/*     */       
/* 526 */       stringBuffer.append("\t.underline type is not modified\n");
/*     */     } 
/* 528 */     stringBuffer.append("\t.color index = ").append("0x" + Integer.toHexString(getFontColorIndex()).toUpperCase(Locale.ROOT)).append("\n");
/*     */     
/* 530 */     stringBuffer.append("    [/Font Formatting]\n");
/* 531 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public FontFormatting clone() {
/* 536 */     FontFormatting fontFormatting = new FontFormatting();
/* 537 */     System.arraycopy(this._rawData, 0, fontFormatting._rawData, 0, this._rawData.length);
/* 538 */     return fontFormatting;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\FontFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */