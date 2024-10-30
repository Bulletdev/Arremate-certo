/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.FontRecord;
/*     */ import org.apache.poi.hssf.util.HSSFColor;
/*     */ import org.apache.poi.ss.usermodel.Font;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HSSFFont
/*     */   implements Font
/*     */ {
/*     */   public static final String FONT_ARIAL = "Arial";
/*     */   private FontRecord font;
/*     */   private short index;
/*     */   
/*     */   protected HSSFFont(short paramShort, FontRecord paramFontRecord) {
/*  47 */     this.font = paramFontRecord;
/*  48 */     this.index = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontName(String paramString) {
/*  59 */     this.font.setFontName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFontName() {
/*  70 */     return this.font.getFontName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getIndex() {
/*  81 */     return this.index;
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
/*     */   public void setFontHeight(short paramShort) {
/*  93 */     this.font.setFontHeight(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontHeightInPoints(short paramShort) {
/* 104 */     this.font.setFontHeight((short)(paramShort * 20));
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
/*     */   public short getFontHeight() {
/* 116 */     return this.font.getFontHeight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFontHeightInPoints() {
/* 127 */     return (short)(this.font.getFontHeight() / 20);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItalic(boolean paramBoolean) {
/* 137 */     this.font.setItalic(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getItalic() {
/* 147 */     return this.font.isItalic();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrikeout(boolean paramBoolean) {
/* 157 */     this.font.setStrikeout(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getStrikeout() {
/* 167 */     return this.font.isStruckout();
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
/*     */   public void setColor(short paramShort) {
/* 179 */     this.font.setColorPaletteIndex(paramShort);
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
/*     */   public short getColor() {
/* 191 */     return this.font.getColorPaletteIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFColor getHSSFColor(HSSFWorkbook paramHSSFWorkbook) {
/* 199 */     HSSFPalette hSSFPalette = paramHSSFWorkbook.getCustomPalette();
/* 200 */     return hSSFPalette.getColor(getColor());
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
/*     */   public void setBoldweight(short paramShort) {
/* 212 */     this.font.setBoldWeight(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBold(boolean paramBoolean) {
/* 220 */     if (paramBoolean) {
/* 221 */       this.font.setBoldWeight((short)700);
/*     */     } else {
/* 223 */       this.font.setBoldWeight((short)400);
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
/*     */   public short getBoldweight() {
/* 235 */     return this.font.getBoldWeight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBold() {
/* 243 */     return (getBoldweight() == 700);
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
/*     */   public void setTypeOffset(short paramShort) {
/* 256 */     this.font.setSuperSubScript(paramShort);
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
/*     */   public short getTypeOffset() {
/* 269 */     return this.font.getSuperSubScript();
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
/* 284 */     this.font.setUnderline(paramByte);
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
/* 299 */     return this.font.getUnderline();
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
/*     */   public int getCharSet() {
/* 312 */     byte b = this.font.getCharset();
/* 313 */     if (b >= 0) {
/* 314 */       return b;
/*     */     }
/* 316 */     return b + 256;
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
/*     */   public void setCharSet(int paramInt) {
/* 328 */     byte b = (byte)paramInt;
/* 329 */     if (paramInt > 127) {
/* 330 */       b = (byte)(paramInt - 256);
/*     */     }
/* 332 */     setCharSet(b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharSet(byte paramByte) {
/* 343 */     this.font.setCharset(paramByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 348 */     return "org.apache.poi.hssf.usermodel.HSSFFont{" + this.font + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 354 */     byte b = 31;
/* 355 */     int i = 1;
/* 356 */     i = 31 * i + ((this.font == null) ? 0 : this.font.hashCode());
/* 357 */     i = 31 * i + this.index;
/* 358 */     return i;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 362 */     if (this == paramObject) return true; 
/* 363 */     if (paramObject == null) return false; 
/* 364 */     if (paramObject instanceof HSSFFont) {
/* 365 */       HSSFFont hSSFFont = (HSSFFont)paramObject;
/* 366 */       if (this.font == null) {
/* 367 */         if (hSSFFont.font != null)
/* 368 */           return false; 
/* 369 */       } else if (!this.font.equals(hSSFFont.font)) {
/* 370 */         return false;
/* 371 */       }  if (this.index != hSSFFont.index)
/* 372 */         return false; 
/* 373 */       return true;
/*     */     } 
/* 375 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */