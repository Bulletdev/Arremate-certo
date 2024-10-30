/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FontRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 49;
/*     */   public static final short SS_NONE = 0;
/*     */   public static final short SS_SUPER = 1;
/*     */   public static final short SS_SUB = 2;
/*     */   public static final byte U_NONE = 0;
/*     */   public static final byte U_SINGLE = 1;
/*     */   public static final byte U_DOUBLE = 2;
/*     */   public static final byte U_SINGLE_ACCOUNTING = 33;
/*     */   public static final byte U_DOUBLE_ACCOUNTING = 34;
/*     */   private short field_1_font_height;
/*     */   private short field_2_attributes;
/*  46 */   private static final BitField italic = BitFieldFactory.getInstance(2);
/*     */ 
/*     */   
/*  49 */   private static final BitField strikeout = BitFieldFactory.getInstance(8);
/*  50 */   private static final BitField macoutline = BitFieldFactory.getInstance(16);
/*  51 */   private static final BitField macshadow = BitFieldFactory.getInstance(32);
/*     */   
/*     */   private short field_3_color_palette_index;
/*     */   
/*     */   private short field_4_bold_weight;
/*     */   
/*     */   private short field_5_super_sub_script;
/*     */   private byte field_6_underline;
/*     */   private byte field_7_family;
/*     */   private byte field_8_charset;
/*  61 */   private byte field_9_zero = 0;
/*     */   
/*     */   private String field_11_font_name;
/*     */ 
/*     */   
/*     */   public FontRecord() {}
/*     */   
/*     */   public FontRecord(RecordInputStream paramRecordInputStream) {
/*  69 */     this.field_1_font_height = paramRecordInputStream.readShort();
/*  70 */     this.field_2_attributes = paramRecordInputStream.readShort();
/*  71 */     this.field_3_color_palette_index = paramRecordInputStream.readShort();
/*  72 */     this.field_4_bold_weight = paramRecordInputStream.readShort();
/*  73 */     this.field_5_super_sub_script = paramRecordInputStream.readShort();
/*  74 */     this.field_6_underline = paramRecordInputStream.readByte();
/*  75 */     this.field_7_family = paramRecordInputStream.readByte();
/*  76 */     this.field_8_charset = paramRecordInputStream.readByte();
/*  77 */     this.field_9_zero = paramRecordInputStream.readByte();
/*  78 */     int i = paramRecordInputStream.readUByte();
/*  79 */     int j = paramRecordInputStream.readUByte();
/*     */     
/*  81 */     if (i > 0) {
/*  82 */       if (j == 0) {
/*  83 */         this.field_11_font_name = paramRecordInputStream.readCompressedUnicode(i);
/*     */       } else {
/*  85 */         this.field_11_font_name = paramRecordInputStream.readUnicodeLEString(i);
/*     */       } 
/*     */     } else {
/*  88 */       this.field_11_font_name = "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontHeight(short paramShort) {
/*  98 */     this.field_1_font_height = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAttributes(short paramShort) {
/* 107 */     this.field_2_attributes = paramShort;
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
/* 119 */     this.field_2_attributes = italic.setShortBoolean(this.field_2_attributes, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrikeout(boolean paramBoolean) {
/* 129 */     this.field_2_attributes = strikeout.setShortBoolean(this.field_2_attributes, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMacoutline(boolean paramBoolean) {
/* 140 */     this.field_2_attributes = macoutline.setShortBoolean(this.field_2_attributes, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMacshadow(boolean paramBoolean) {
/* 151 */     this.field_2_attributes = macshadow.setShortBoolean(this.field_2_attributes, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColorPaletteIndex(short paramShort) {
/* 160 */     this.field_3_color_palette_index = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBoldWeight(short paramShort) {
/* 170 */     this.field_4_bold_weight = paramShort;
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
/*     */   public void setSuperSubScript(short paramShort) {
/* 182 */     this.field_5_super_sub_script = paramShort;
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
/*     */   public void setUnderline(byte paramByte) {
/* 197 */     this.field_6_underline = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamily(byte paramByte) {
/* 206 */     this.field_7_family = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharset(byte paramByte) {
/* 215 */     this.field_8_charset = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontName(String paramString) {
/* 225 */     this.field_11_font_name = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFontHeight() {
/* 234 */     return this.field_1_font_height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getAttributes() {
/* 243 */     return this.field_2_attributes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isItalic() {
/* 253 */     return italic.isSet(this.field_2_attributes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStruckout() {
/* 263 */     return strikeout.isSet(this.field_2_attributes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMacoutlined() {
/* 274 */     return macoutline.isSet(this.field_2_attributes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMacshadowed() {
/* 285 */     return macshadow.isSet(this.field_2_attributes);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getColorPaletteIndex() {
/* 294 */     return this.field_3_color_palette_index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBoldWeight() {
/* 304 */     return this.field_4_bold_weight;
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
/*     */   public short getSuperSubScript() {
/* 316 */     return this.field_5_super_sub_script;
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
/*     */   public byte getUnderline() {
/* 331 */     return this.field_6_underline;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getFamily() {
/* 340 */     return this.field_7_family;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getCharset() {
/* 349 */     return this.field_8_charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFontName() {
/* 358 */     return this.field_11_font_name;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 362 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 364 */     stringBuffer.append("[FONT]\n");
/* 365 */     stringBuffer.append("    .fontheight    = ").append(HexDump.shortToHex(getFontHeight())).append("\n");
/* 366 */     stringBuffer.append("    .attributes    = ").append(HexDump.shortToHex(getAttributes())).append("\n");
/* 367 */     stringBuffer.append("       .italic     = ").append(isItalic()).append("\n");
/* 368 */     stringBuffer.append("       .strikout   = ").append(isStruckout()).append("\n");
/* 369 */     stringBuffer.append("       .macoutlined= ").append(isMacoutlined()).append("\n");
/* 370 */     stringBuffer.append("       .macshadowed= ").append(isMacshadowed()).append("\n");
/* 371 */     stringBuffer.append("    .colorpalette  = ").append(HexDump.shortToHex(getColorPaletteIndex())).append("\n");
/* 372 */     stringBuffer.append("    .boldweight    = ").append(HexDump.shortToHex(getBoldWeight())).append("\n");
/* 373 */     stringBuffer.append("    .supersubscript= ").append(HexDump.shortToHex(getSuperSubScript())).append("\n");
/* 374 */     stringBuffer.append("    .underline     = ").append(HexDump.byteToHex(getUnderline())).append("\n");
/* 375 */     stringBuffer.append("    .family        = ").append(HexDump.byteToHex(getFamily())).append("\n");
/* 376 */     stringBuffer.append("    .charset       = ").append(HexDump.byteToHex(getCharset())).append("\n");
/* 377 */     stringBuffer.append("    .fontname      = ").append(getFontName()).append("\n");
/* 378 */     stringBuffer.append("[/FONT]\n");
/* 379 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 384 */     paramLittleEndianOutput.writeShort(getFontHeight());
/* 385 */     paramLittleEndianOutput.writeShort(getAttributes());
/* 386 */     paramLittleEndianOutput.writeShort(getColorPaletteIndex());
/* 387 */     paramLittleEndianOutput.writeShort(getBoldWeight());
/* 388 */     paramLittleEndianOutput.writeShort(getSuperSubScript());
/* 389 */     paramLittleEndianOutput.writeByte(getUnderline());
/* 390 */     paramLittleEndianOutput.writeByte(getFamily());
/* 391 */     paramLittleEndianOutput.writeByte(getCharset());
/* 392 */     paramLittleEndianOutput.writeByte(this.field_9_zero);
/* 393 */     int i = this.field_11_font_name.length();
/* 394 */     paramLittleEndianOutput.writeByte(i);
/* 395 */     boolean bool = StringUtil.hasMultibyte(this.field_11_font_name);
/* 396 */     paramLittleEndianOutput.writeByte(bool ? 1 : 0);
/* 397 */     if (i > 0)
/* 398 */       if (bool) {
/* 399 */         StringUtil.putUnicodeLE(this.field_11_font_name, paramLittleEndianOutput);
/*     */       } else {
/* 401 */         StringUtil.putCompressedUnicode(this.field_11_font_name, paramLittleEndianOutput);
/*     */       }  
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 406 */     byte b = 16;
/* 407 */     int i = this.field_11_font_name.length();
/* 408 */     if (i < 1) {
/* 409 */       return b;
/*     */     }
/*     */     
/* 412 */     boolean bool = StringUtil.hasMultibyte(this.field_11_font_name);
/* 413 */     return b + i * (bool ? 2 : 1);
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 417 */     return 49;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cloneStyleFrom(FontRecord paramFontRecord) {
/* 428 */     this.field_1_font_height = paramFontRecord.field_1_font_height;
/* 429 */     this.field_2_attributes = paramFontRecord.field_2_attributes;
/* 430 */     this.field_3_color_palette_index = paramFontRecord.field_3_color_palette_index;
/* 431 */     this.field_4_bold_weight = paramFontRecord.field_4_bold_weight;
/* 432 */     this.field_5_super_sub_script = paramFontRecord.field_5_super_sub_script;
/* 433 */     this.field_6_underline = paramFontRecord.field_6_underline;
/* 434 */     this.field_7_family = paramFontRecord.field_7_family;
/* 435 */     this.field_8_charset = paramFontRecord.field_8_charset;
/* 436 */     this.field_9_zero = paramFontRecord.field_9_zero;
/* 437 */     this.field_11_font_name = paramFontRecord.field_11_font_name;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 441 */     byte b = 31;
/* 442 */     int i = 1;
/* 443 */     i = 31 * i + ((this.field_11_font_name == null) ? 0 : this.field_11_font_name.hashCode());
/*     */ 
/*     */ 
/*     */     
/* 447 */     i = 31 * i + this.field_1_font_height;
/* 448 */     i = 31 * i + this.field_2_attributes;
/* 449 */     i = 31 * i + this.field_3_color_palette_index;
/* 450 */     i = 31 * i + this.field_4_bold_weight;
/* 451 */     i = 31 * i + this.field_5_super_sub_script;
/* 452 */     i = 31 * i + this.field_6_underline;
/* 453 */     i = 31 * i + this.field_7_family;
/* 454 */     i = 31 * i + this.field_8_charset;
/* 455 */     i = 31 * i + this.field_9_zero;
/* 456 */     return i;
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
/*     */   public boolean sameProperties(FontRecord paramFontRecord) {
/* 473 */     return (this.field_1_font_height == paramFontRecord.field_1_font_height && this.field_2_attributes == paramFontRecord.field_2_attributes && this.field_3_color_palette_index == paramFontRecord.field_3_color_palette_index && this.field_4_bold_weight == paramFontRecord.field_4_bold_weight && this.field_5_super_sub_script == paramFontRecord.field_5_super_sub_script && this.field_6_underline == paramFontRecord.field_6_underline && this.field_7_family == paramFontRecord.field_7_family && this.field_8_charset == paramFontRecord.field_8_charset && this.field_9_zero == paramFontRecord.field_9_zero && stringEquals(this.field_11_font_name, paramFontRecord.field_11_font_name));
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
/*     */   public boolean equals(Object paramObject) {
/* 488 */     return (paramObject instanceof FontRecord) ? sameProperties((FontRecord)paramObject) : false;
/*     */   }
/*     */   
/*     */   private static boolean stringEquals(String paramString1, String paramString2) {
/* 492 */     return (paramString1 == paramString2 || (paramString1 != null && paramString1.equals(paramString2)));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FontRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */