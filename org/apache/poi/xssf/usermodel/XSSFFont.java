/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ import org.apache.poi.ss.usermodel.FontCharset;
/*     */ import org.apache.poi.ss.usermodel.FontFamily;
/*     */ import org.apache.poi.ss.usermodel.FontScheme;
/*     */ import org.apache.poi.ss.usermodel.FontUnderline;
/*     */ import org.apache.poi.ss.usermodel.IndexedColors;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.model.StylesTable;
/*     */ import org.apache.poi.xssf.model.ThemesTable;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBooleanProperty;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontName;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontScheme;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTIntProperty;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STFontScheme;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUnderlineValues;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignRun;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFFont
/*     */   implements Font
/*     */ {
/*     */   public static final String DEFAULT_FONT_NAME = "Calibri";
/*     */   public static final short DEFAULT_FONT_SIZE = 11;
/*  61 */   public static final short DEFAULT_FONT_COLOR = IndexedColors.BLACK.getIndex();
/*     */ 
/*     */   
/*     */   private ThemesTable _themes;
/*     */ 
/*     */   
/*     */   private CTFont _ctFont;
/*     */   
/*     */   private short _index;
/*     */ 
/*     */   
/*     */   public XSSFFont(CTFont paramCTFont) {
/*  73 */     this._ctFont = paramCTFont;
/*  74 */     this._index = 0;
/*     */   }
/*     */   
/*     */   public XSSFFont(CTFont paramCTFont, int paramInt) {
/*  78 */     this._ctFont = paramCTFont;
/*  79 */     this._index = (short)paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XSSFFont() {
/*  86 */     this._ctFont = CTFont.Factory.newInstance();
/*  87 */     setFontName("Calibri");
/*  88 */     setFontHeight(11.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTFont getCTFont() {
/*  96 */     return this._ctFont;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBold() {
/* 105 */     CTBooleanProperty cTBooleanProperty = (this._ctFont.sizeOfBArray() == 0) ? null : this._ctFont.getBArray(0);
/* 106 */     return (cTBooleanProperty != null && cTBooleanProperty.getVal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCharSet() {
/* 116 */     CTIntProperty cTIntProperty = (this._ctFont.sizeOfCharsetArray() == 0) ? null : this._ctFont.getCharsetArray(0);
/* 117 */     return (cTIntProperty == null) ? FontCharset.ANSI.getValue() : FontCharset.valueOf(cTIntProperty.getVal()).getValue();
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
/*     */   public short getColor() {
/* 130 */     CTColor cTColor = (this._ctFont.sizeOfColorArray() == 0) ? null : this._ctFont.getColorArray(0);
/* 131 */     if (cTColor == null) return IndexedColors.BLACK.getIndex();
/*     */     
/* 133 */     long l = cTColor.getIndexed();
/* 134 */     if (l == DEFAULT_FONT_COLOR)
/* 135 */       return IndexedColors.BLACK.getIndex(); 
/* 136 */     if (l == IndexedColors.RED.getIndex()) {
/* 137 */       return IndexedColors.RED.getIndex();
/*     */     }
/* 139 */     return (short)(int)l;
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
/*     */   public XSSFColor getXSSFColor() {
/* 151 */     CTColor cTColor = (this._ctFont.sizeOfColorArray() == 0) ? null : this._ctFont.getColorArray(0);
/* 152 */     if (cTColor != null) {
/* 153 */       XSSFColor xSSFColor = new XSSFColor(cTColor);
/* 154 */       if (this._themes != null) {
/* 155 */         this._themes.inheritFromThemeAsRequired(xSSFColor);
/*     */       }
/* 157 */       return xSSFColor;
/*     */     } 
/* 159 */     return null;
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
/*     */   public short getThemeColor() {
/* 171 */     CTColor cTColor = (this._ctFont.sizeOfColorArray() == 0) ? null : this._ctFont.getColorArray(0);
/* 172 */     long l = (cTColor == null) ? 0L : cTColor.getTheme();
/* 173 */     return (short)(int)l;
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
/*     */   public short getFontHeight() {
/* 187 */     return (short)(int)(getFontHeightRaw() * 20.0D);
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
/*     */   public short getFontHeightInPoints() {
/* 199 */     return (short)(int)getFontHeightRaw();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double getFontHeightRaw() {
/* 207 */     CTFontSize cTFontSize = (this._ctFont.sizeOfSzArray() == 0) ? null : this._ctFont.getSzArray(0);
/* 208 */     if (cTFontSize != null) {
/* 209 */       return cTFontSize.getVal();
/*     */     }
/*     */     
/* 212 */     return 11.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFontName() {
/* 221 */     CTFontName cTFontName = (this._ctFont.sizeOfNameArray() == 0) ? null : this._ctFont.getNameArray(0);
/* 222 */     return (cTFontName == null) ? "Calibri" : cTFontName.getVal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getItalic() {
/* 231 */     CTBooleanProperty cTBooleanProperty = (this._ctFont.sizeOfIArray() == 0) ? null : this._ctFont.getIArray(0);
/* 232 */     return (cTBooleanProperty != null && cTBooleanProperty.getVal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getStrikeout() {
/* 241 */     CTBooleanProperty cTBooleanProperty = (this._ctFont.sizeOfStrikeArray() == 0) ? null : this._ctFont.getStrikeArray(0);
/* 242 */     return (cTBooleanProperty != null && cTBooleanProperty.getVal());
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
/*     */   public short getTypeOffset() {
/* 254 */     CTVerticalAlignFontProperty cTVerticalAlignFontProperty = (this._ctFont.sizeOfVertAlignArray() == 0) ? null : this._ctFont.getVertAlignArray(0);
/* 255 */     if (cTVerticalAlignFontProperty == null) {
/* 256 */       return 0;
/*     */     }
/* 258 */     int i = cTVerticalAlignFontProperty.getVal().intValue();
/* 259 */     switch (i) {
/*     */       case 1:
/* 261 */         return 0;
/*     */       case 3:
/* 263 */         return 2;
/*     */       case 2:
/* 265 */         return 1;
/*     */     } 
/* 267 */     throw new POIXMLException("Wrong offset value " + i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getUnderline() {
/* 278 */     CTUnderlineProperty cTUnderlineProperty = (this._ctFont.sizeOfUArray() == 0) ? null : this._ctFont.getUArray(0);
/* 279 */     if (cTUnderlineProperty != null) {
/* 280 */       FontUnderline fontUnderline = FontUnderline.valueOf(cTUnderlineProperty.getVal().intValue());
/* 281 */       return fontUnderline.getByteValue();
/*     */     } 
/* 283 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBold(boolean paramBoolean) {
/* 292 */     if (paramBoolean) {
/* 293 */       CTBooleanProperty cTBooleanProperty = (this._ctFont.sizeOfBArray() == 0) ? this._ctFont.addNewB() : this._ctFont.getBArray(0);
/* 294 */       cTBooleanProperty.setVal(paramBoolean);
/*     */     } else {
/* 296 */       this._ctFont.setBArray(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBoldweight(short paramShort) {
/* 305 */     setBold((paramShort == 700));
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
/*     */   public short getBoldweight() {
/* 317 */     return getBold() ? 700 : 400;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharSet(byte paramByte) {
/* 327 */     int i = paramByte & 0xFF;
/* 328 */     setCharSet(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharSet(int paramInt) {
/* 337 */     FontCharset fontCharset = FontCharset.valueOf(paramInt);
/* 338 */     if (fontCharset != null) {
/* 339 */       setCharSet(fontCharset);
/*     */     } else {
/* 341 */       throw new POIXMLException("Attention: an attempt to set a type of unknow charset and charset");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharSet(FontCharset paramFontCharset) {
/*     */     CTIntProperty cTIntProperty;
/* 352 */     if (this._ctFont.sizeOfCharsetArray() == 0) {
/* 353 */       cTIntProperty = this._ctFont.addNewCharset();
/*     */     } else {
/* 355 */       cTIntProperty = this._ctFont.getCharsetArray(0);
/*     */     } 
/*     */ 
/*     */     
/* 359 */     cTIntProperty.setVal(paramFontCharset.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(short paramShort) {
/* 370 */     CTColor cTColor = (this._ctFont.sizeOfColorArray() == 0) ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0);
/* 371 */     switch (paramShort) {
/*     */       case 32767:
/* 373 */         cTColor.setIndexed(DEFAULT_FONT_COLOR);
/*     */         return;
/*     */       
/*     */       case 10:
/* 377 */         cTColor.setIndexed(IndexedColors.RED.getIndex());
/*     */         return;
/*     */     } 
/*     */     
/* 381 */     cTColor.setIndexed(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor(XSSFColor paramXSSFColor) {
/* 391 */     if (paramXSSFColor == null) { this._ctFont.setColorArray(null); }
/*     */     else
/* 393 */     { CTColor cTColor = (this._ctFont.sizeOfColorArray() == 0) ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0);
/* 394 */       if (cTColor.isSetIndexed()) {
/* 395 */         cTColor.unsetIndexed();
/*     */       }
/* 397 */       cTColor.setRgb(paramXSSFColor.getRGB()); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontHeight(short paramShort) {
/* 407 */     setFontHeight(paramShort / 20.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontHeight(double paramDouble) {
/* 416 */     CTFontSize cTFontSize = (this._ctFont.sizeOfSzArray() == 0) ? this._ctFont.addNewSz() : this._ctFont.getSzArray(0);
/* 417 */     cTFontSize.setVal(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontHeightInPoints(short paramShort) {
/* 426 */     setFontHeight(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThemeColor(short paramShort) {
/* 435 */     CTColor cTColor = (this._ctFont.sizeOfColorArray() == 0) ? this._ctFont.addNewColor() : this._ctFont.getColorArray(0);
/* 436 */     cTColor.setTheme(paramShort);
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
/*     */   public void setFontName(String paramString) {
/* 451 */     CTFontName cTFontName = (this._ctFont.sizeOfNameArray() == 0) ? this._ctFont.addNewName() : this._ctFont.getNameArray(0);
/* 452 */     cTFontName.setVal((paramString == null) ? "Calibri" : paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItalic(boolean paramBoolean) {
/* 463 */     if (paramBoolean) {
/* 464 */       CTBooleanProperty cTBooleanProperty = (this._ctFont.sizeOfIArray() == 0) ? this._ctFont.addNewI() : this._ctFont.getIArray(0);
/* 465 */       cTBooleanProperty.setVal(paramBoolean);
/*     */     } else {
/* 467 */       this._ctFont.setIArray(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrikeout(boolean paramBoolean) {
/* 479 */     if (!paramBoolean) { this._ctFont.setStrikeArray(null); }
/*     */     else
/* 481 */     { CTBooleanProperty cTBooleanProperty = (this._ctFont.sizeOfStrikeArray() == 0) ? this._ctFont.addNewStrike() : this._ctFont.getStrikeArray(0);
/* 482 */       cTBooleanProperty.setVal(paramBoolean); }
/*     */   
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
/*     */   public void setTypeOffset(short paramShort) {
/* 497 */     if (paramShort == 0) {
/* 498 */       this._ctFont.setVertAlignArray(null);
/*     */     } else {
/* 500 */       CTVerticalAlignFontProperty cTVerticalAlignFontProperty = (this._ctFont.sizeOfVertAlignArray() == 0) ? this._ctFont.addNewVertAlign() : this._ctFont.getVertAlignArray(0);
/* 501 */       switch (paramShort) {
/*     */         case 0:
/* 503 */           cTVerticalAlignFontProperty.setVal(STVerticalAlignRun.BASELINE);
/*     */           return;
/*     */         case 2:
/* 506 */           cTVerticalAlignFontProperty.setVal(STVerticalAlignRun.SUBSCRIPT);
/*     */           return;
/*     */         case 1:
/* 509 */           cTVerticalAlignFontProperty.setVal(STVerticalAlignRun.SUPERSCRIPT);
/*     */           return;
/*     */       } 
/* 512 */       throw new IllegalStateException("Invalid type offset: " + paramShort);
/*     */     } 
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
/*     */   public void setUnderline(byte paramByte) {
/* 525 */     setUnderline(FontUnderline.valueOf(paramByte));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnderline(FontUnderline paramFontUnderline) {
/* 536 */     if (paramFontUnderline == FontUnderline.NONE && this._ctFont.sizeOfUArray() > 0) {
/* 537 */       this._ctFont.setUArray(null);
/*     */     } else {
/* 539 */       CTUnderlineProperty cTUnderlineProperty = (this._ctFont.sizeOfUArray() == 0) ? this._ctFont.addNewU() : this._ctFont.getUArray(0);
/* 540 */       STUnderlineValues.Enum enum_ = STUnderlineValues.Enum.forInt(paramFontUnderline.getValue());
/* 541 */       cTUnderlineProperty.setVal(enum_);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 547 */     return this._ctFont.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long registerTo(StylesTable paramStylesTable) {
/* 556 */     this._themes = paramStylesTable.getTheme();
/* 557 */     short s = (short)paramStylesTable.putFont(this, true);
/* 558 */     this._index = s;
/* 559 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThemesTable(ThemesTable paramThemesTable) {
/* 567 */     this._themes = paramThemesTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FontScheme getScheme() {
/* 578 */     CTFontScheme cTFontScheme = (this._ctFont.sizeOfSchemeArray() == 0) ? null : this._ctFont.getSchemeArray(0);
/* 579 */     return (cTFontScheme == null) ? FontScheme.NONE : FontScheme.valueOf(cTFontScheme.getVal().intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScheme(FontScheme paramFontScheme) {
/* 589 */     CTFontScheme cTFontScheme = (this._ctFont.sizeOfSchemeArray() == 0) ? this._ctFont.addNewScheme() : this._ctFont.getSchemeArray(0);
/* 590 */     STFontScheme.Enum enum_ = STFontScheme.Enum.forInt(paramFontScheme.getValue());
/* 591 */     cTFontScheme.setVal(enum_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFamily() {
/* 601 */     CTIntProperty cTIntProperty = (this._ctFont.sizeOfFamilyArray() == 0) ? this._ctFont.addNewFamily() : this._ctFont.getFamilyArray(0);
/* 602 */     return (cTIntProperty == null) ? FontFamily.NOT_APPLICABLE.getValue() : FontFamily.valueOf(cTIntProperty.getVal()).getValue();
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
/*     */   public void setFamily(int paramInt) {
/* 614 */     CTIntProperty cTIntProperty = (this._ctFont.sizeOfFamilyArray() == 0) ? this._ctFont.addNewFamily() : this._ctFont.getFamilyArray(0);
/* 615 */     cTIntProperty.setVal(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFamily(FontFamily paramFontFamily) {
/* 626 */     setFamily(paramFontFamily.getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getIndex() {
/* 636 */     return this._index;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 640 */     return this._ctFont.toString().hashCode();
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 644 */     if (!(paramObject instanceof XSSFFont)) return false;
/*     */     
/* 646 */     XSSFFont xSSFFont = (XSSFFont)paramObject;
/* 647 */     return this._ctFont.toString().equals(xSSFFont.getCTFont().toString());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */