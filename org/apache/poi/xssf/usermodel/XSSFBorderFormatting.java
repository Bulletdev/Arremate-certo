/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.BorderFormatting;
/*     */ import org.apache.poi.ss.usermodel.BorderStyle;
/*     */ import org.apache.poi.ss.usermodel.Color;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STBorderStyle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFBorderFormatting
/*     */   implements BorderFormatting
/*     */ {
/*     */   CTBorder _border;
/*     */   
/*     */   XSSFBorderFormatting(CTBorder paramCTBorder) {
/*  35 */     this._border = paramCTBorder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderBottom() {
/*  44 */     return getBorderBottomEnum().getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderBottomEnum() {
/*  51 */     STBorderStyle.Enum enum_ = this._border.isSetBottom() ? this._border.getBottom().getStyle() : null;
/*  52 */     return (enum_ == null) ? BorderStyle.NONE : BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderDiagonal() {
/*  61 */     return getBorderDiagonalEnum().getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderDiagonalEnum() {
/*  68 */     STBorderStyle.Enum enum_ = this._border.isSetDiagonal() ? this._border.getDiagonal().getStyle() : null;
/*  69 */     return (enum_ == null) ? BorderStyle.NONE : BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderLeft() {
/*  78 */     return getBorderLeftEnum().getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderLeftEnum() {
/*  85 */     STBorderStyle.Enum enum_ = this._border.isSetLeft() ? this._border.getLeft().getStyle() : null;
/*  86 */     return (enum_ == null) ? BorderStyle.NONE : BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderRight() {
/*  95 */     return getBorderRightEnum().getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderRightEnum() {
/* 102 */     STBorderStyle.Enum enum_ = this._border.isSetRight() ? this._border.getRight().getStyle() : null;
/* 103 */     return (enum_ == null) ? BorderStyle.NONE : BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderTop() {
/* 112 */     return getBorderTopEnum().getCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderTopEnum() {
/* 119 */     STBorderStyle.Enum enum_ = this._border.isSetTop() ? this._border.getTop().getStyle() : null;
/* 120 */     return (enum_ == null) ? BorderStyle.NONE : BorderStyle.valueOf((short)(enum_.intValue() - 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFColor getBottomBorderColorColor() {
/* 125 */     if (!this._border.isSetBottom()) return null;
/*     */     
/* 127 */     CTBorderPr cTBorderPr = this._border.getBottom();
/* 128 */     return new XSSFColor(cTBorderPr.getColor());
/*     */   }
/*     */   
/*     */   public short getBottomBorderColor() {
/* 132 */     XSSFColor xSSFColor = getBottomBorderColorColor();
/* 133 */     if (xSSFColor == null) return 0; 
/* 134 */     return xSSFColor.getIndexed();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFColor getDiagonalBorderColorColor() {
/* 139 */     if (!this._border.isSetDiagonal()) return null;
/*     */     
/* 141 */     CTBorderPr cTBorderPr = this._border.getDiagonal();
/* 142 */     return new XSSFColor(cTBorderPr.getColor());
/*     */   }
/*     */   
/*     */   public short getDiagonalBorderColor() {
/* 146 */     XSSFColor xSSFColor = getDiagonalBorderColorColor();
/* 147 */     if (xSSFColor == null) return 0; 
/* 148 */     return xSSFColor.getIndexed();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFColor getLeftBorderColorColor() {
/* 153 */     if (!this._border.isSetLeft()) return null;
/*     */     
/* 155 */     CTBorderPr cTBorderPr = this._border.getLeft();
/* 156 */     return new XSSFColor(cTBorderPr.getColor());
/*     */   }
/*     */   
/*     */   public short getLeftBorderColor() {
/* 160 */     XSSFColor xSSFColor = getLeftBorderColorColor();
/* 161 */     if (xSSFColor == null) return 0; 
/* 162 */     return xSSFColor.getIndexed();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFColor getRightBorderColorColor() {
/* 167 */     if (!this._border.isSetRight()) return null;
/*     */     
/* 169 */     CTBorderPr cTBorderPr = this._border.getRight();
/* 170 */     return new XSSFColor(cTBorderPr.getColor());
/*     */   }
/*     */   
/*     */   public short getRightBorderColor() {
/* 174 */     XSSFColor xSSFColor = getRightBorderColorColor();
/* 175 */     if (xSSFColor == null) return 0; 
/* 176 */     return xSSFColor.getIndexed();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFColor getTopBorderColorColor() {
/* 181 */     if (!this._border.isSetTop()) return null;
/*     */     
/* 183 */     CTBorderPr cTBorderPr = this._border.getTop();
/* 184 */     return new XSSFColor(cTBorderPr.getColor());
/*     */   }
/*     */   
/*     */   public short getTopBorderColor() {
/* 188 */     XSSFColor xSSFColor = getRightBorderColorColor();
/* 189 */     if (xSSFColor == null) return 0; 
/* 190 */     return xSSFColor.getIndexed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBorderBottom(short paramShort) {
/* 198 */     setBorderBottom(BorderStyle.valueOf(paramShort));
/*     */   }
/*     */   
/*     */   public void setBorderBottom(BorderStyle paramBorderStyle) {
/* 202 */     CTBorderPr cTBorderPr = this._border.isSetBottom() ? this._border.getBottom() : this._border.addNewBottom();
/* 203 */     if (paramBorderStyle == BorderStyle.NONE) { this._border.unsetBottom(); }
/* 204 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBorderDiagonal(short paramShort) {
/* 212 */     setBorderDiagonal(BorderStyle.valueOf(paramShort));
/*     */   }
/*     */   
/*     */   public void setBorderDiagonal(BorderStyle paramBorderStyle) {
/* 216 */     CTBorderPr cTBorderPr = this._border.isSetDiagonal() ? this._border.getDiagonal() : this._border.addNewDiagonal();
/* 217 */     if (paramBorderStyle == BorderStyle.NONE) { this._border.unsetDiagonal(); }
/* 218 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBorderLeft(short paramShort) {
/* 226 */     setBorderLeft(BorderStyle.valueOf(paramShort));
/*     */   }
/*     */   
/*     */   public void setBorderLeft(BorderStyle paramBorderStyle) {
/* 230 */     CTBorderPr cTBorderPr = this._border.isSetLeft() ? this._border.getLeft() : this._border.addNewLeft();
/* 231 */     if (paramBorderStyle == BorderStyle.NONE) { this._border.unsetLeft(); }
/* 232 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBorderRight(short paramShort) {
/* 240 */     setBorderRight(BorderStyle.valueOf(paramShort));
/*     */   }
/*     */   
/*     */   public void setBorderRight(BorderStyle paramBorderStyle) {
/* 244 */     CTBorderPr cTBorderPr = this._border.isSetRight() ? this._border.getRight() : this._border.addNewRight();
/* 245 */     if (paramBorderStyle == BorderStyle.NONE) { this._border.unsetRight(); }
/* 246 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBorderTop(short paramShort) {
/* 254 */     setBorderTop(BorderStyle.valueOf(paramShort));
/*     */   }
/*     */   
/*     */   public void setBorderTop(BorderStyle paramBorderStyle) {
/* 258 */     CTBorderPr cTBorderPr = this._border.isSetTop() ? this._border.getTop() : this._border.addNewTop();
/* 259 */     if (paramBorderStyle == BorderStyle.NONE) { this._border.unsetTop(); }
/* 260 */     else { cTBorderPr.setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.getCode() + 1)); }
/*     */   
/*     */   }
/*     */   
/*     */   public void setBottomBorderColor(Color paramColor) {
/* 265 */     XSSFColor xSSFColor = XSSFColor.toXSSFColor(paramColor);
/* 266 */     if (xSSFColor == null) { setBottomBorderColor((CTColor)null); }
/* 267 */     else { setBottomBorderColor(xSSFColor.getCTColor()); }
/*     */   
/*     */   }
/*     */   public void setBottomBorderColor(short paramShort) {
/* 271 */     CTColor cTColor = CTColor.Factory.newInstance();
/* 272 */     cTColor.setIndexed(paramShort);
/* 273 */     setBottomBorderColor(cTColor);
/*     */   }
/*     */   public void setBottomBorderColor(CTColor paramCTColor) {
/* 276 */     CTBorderPr cTBorderPr = this._border.isSetBottom() ? this._border.getBottom() : this._border.addNewBottom();
/* 277 */     if (paramCTColor == null) {
/* 278 */       cTBorderPr.unsetColor();
/*     */     } else {
/* 280 */       cTBorderPr.setColor(paramCTColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDiagonalBorderColor(Color paramColor) {
/* 286 */     XSSFColor xSSFColor = XSSFColor.toXSSFColor(paramColor);
/* 287 */     if (xSSFColor == null) { setDiagonalBorderColor((CTColor)null); }
/* 288 */     else { setDiagonalBorderColor(xSSFColor.getCTColor()); }
/*     */   
/*     */   }
/*     */   public void setDiagonalBorderColor(short paramShort) {
/* 292 */     CTColor cTColor = CTColor.Factory.newInstance();
/* 293 */     cTColor.setIndexed(paramShort);
/* 294 */     setDiagonalBorderColor(cTColor);
/*     */   }
/*     */   public void setDiagonalBorderColor(CTColor paramCTColor) {
/* 297 */     CTBorderPr cTBorderPr = this._border.isSetDiagonal() ? this._border.getDiagonal() : this._border.addNewDiagonal();
/* 298 */     if (paramCTColor == null) {
/* 299 */       cTBorderPr.unsetColor();
/*     */     } else {
/* 301 */       cTBorderPr.setColor(paramCTColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLeftBorderColor(Color paramColor) {
/* 307 */     XSSFColor xSSFColor = XSSFColor.toXSSFColor(paramColor);
/* 308 */     if (xSSFColor == null) { setLeftBorderColor((CTColor)null); }
/* 309 */     else { setLeftBorderColor(xSSFColor.getCTColor()); }
/*     */   
/*     */   }
/*     */   public void setLeftBorderColor(short paramShort) {
/* 313 */     CTColor cTColor = CTColor.Factory.newInstance();
/* 314 */     cTColor.setIndexed(paramShort);
/* 315 */     setLeftBorderColor(cTColor);
/*     */   }
/*     */   public void setLeftBorderColor(CTColor paramCTColor) {
/* 318 */     CTBorderPr cTBorderPr = this._border.isSetLeft() ? this._border.getLeft() : this._border.addNewLeft();
/* 319 */     if (paramCTColor == null) {
/* 320 */       cTBorderPr.unsetColor();
/*     */     } else {
/* 322 */       cTBorderPr.setColor(paramCTColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRightBorderColor(Color paramColor) {
/* 328 */     XSSFColor xSSFColor = XSSFColor.toXSSFColor(paramColor);
/* 329 */     if (xSSFColor == null) { setRightBorderColor((CTColor)null); }
/* 330 */     else { setRightBorderColor(xSSFColor.getCTColor()); }
/*     */   
/*     */   }
/*     */   public void setRightBorderColor(short paramShort) {
/* 334 */     CTColor cTColor = CTColor.Factory.newInstance();
/* 335 */     cTColor.setIndexed(paramShort);
/* 336 */     setRightBorderColor(cTColor);
/*     */   }
/*     */   public void setRightBorderColor(CTColor paramCTColor) {
/* 339 */     CTBorderPr cTBorderPr = this._border.isSetRight() ? this._border.getRight() : this._border.addNewRight();
/* 340 */     if (paramCTColor == null) {
/* 341 */       cTBorderPr.unsetColor();
/*     */     } else {
/* 343 */       cTBorderPr.setColor(paramCTColor);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTopBorderColor(Color paramColor) {
/* 349 */     XSSFColor xSSFColor = XSSFColor.toXSSFColor(paramColor);
/* 350 */     if (xSSFColor == null) { setTopBorderColor((CTColor)null); }
/* 351 */     else { setTopBorderColor(xSSFColor.getCTColor()); }
/*     */   
/*     */   }
/*     */   public void setTopBorderColor(short paramShort) {
/* 355 */     CTColor cTColor = CTColor.Factory.newInstance();
/* 356 */     cTColor.setIndexed(paramShort);
/* 357 */     setTopBorderColor(cTColor);
/*     */   }
/*     */   public void setTopBorderColor(CTColor paramCTColor) {
/* 360 */     CTBorderPr cTBorderPr = this._border.isSetTop() ? this._border.getTop() : this._border.addNewTop();
/* 361 */     if (paramCTColor == null) {
/* 362 */       cTBorderPr.unsetColor();
/*     */     } else {
/* 364 */       cTBorderPr.setColor(paramCTColor);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFBorderFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */