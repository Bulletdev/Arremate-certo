/*     */ package org.apache.poi.xssf.usermodel.extensions;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.BorderStyle;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.model.ThemesTable;
/*     */ import org.apache.poi.xssf.usermodel.XSSFColor;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorder;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBorderPr;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFCellBorder
/*     */ {
/*     */   private ThemesTable _theme;
/*     */   private CTBorder border;
/*     */   
/*     */   public XSSFCellBorder(CTBorder paramCTBorder, ThemesTable paramThemesTable) {
/*  41 */     this(paramCTBorder);
/*  42 */     this._theme = paramThemesTable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFCellBorder(CTBorder paramCTBorder) {
/*  49 */     this.border = paramCTBorder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFCellBorder() {
/*  57 */     this.border = CTBorder.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setThemesTable(ThemesTable paramThemesTable) {
/*  66 */     this._theme = paramThemesTable;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum BorderSide
/*     */   {
/*  73 */     TOP, RIGHT, BOTTOM, LEFT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTBorder getCTBorder() {
/*  83 */     return this.border;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderStyle(BorderSide paramBorderSide) {
/*  94 */     CTBorderPr cTBorderPr = getBorder(paramBorderSide);
/*  95 */     STBorderStyle.Enum enum_ = (cTBorderPr == null) ? STBorderStyle.NONE : cTBorderPr.getStyle();
/*  96 */     return BorderStyle.values()[enum_.intValue() - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBorderStyle(BorderSide paramBorderSide, BorderStyle paramBorderStyle) {
/* 107 */     getBorder(paramBorderSide, true).setStyle(STBorderStyle.Enum.forInt(paramBorderStyle.ordinal() + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFColor getBorderColor(BorderSide paramBorderSide) {
/* 117 */     CTBorderPr cTBorderPr = getBorder(paramBorderSide);
/*     */     
/* 119 */     if (cTBorderPr != null && cTBorderPr.isSetColor()) {
/* 120 */       XSSFColor xSSFColor = new XSSFColor(cTBorderPr.getColor());
/* 121 */       if (this._theme != null) {
/* 122 */         this._theme.inheritFromThemeAsRequired(xSSFColor);
/*     */       }
/* 124 */       return xSSFColor;
/*     */     } 
/*     */     
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBorderColor(BorderSide paramBorderSide, XSSFColor paramXSSFColor) {
/* 138 */     CTBorderPr cTBorderPr = getBorder(paramBorderSide, true);
/* 139 */     if (paramXSSFColor == null) { cTBorderPr.unsetColor(); }
/*     */     else
/* 141 */     { cTBorderPr.setColor(paramXSSFColor.getCTColor()); }
/*     */   
/*     */   }
/*     */   private CTBorderPr getBorder(BorderSide paramBorderSide) {
/* 145 */     return getBorder(paramBorderSide, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private CTBorderPr getBorder(BorderSide paramBorderSide, boolean paramBoolean) {
/*     */     CTBorderPr cTBorderPr;
/* 151 */     switch (paramBorderSide) {
/*     */       case TOP:
/* 153 */         cTBorderPr = this.border.getTop();
/* 154 */         if (paramBoolean && cTBorderPr == null) cTBorderPr = this.border.addNewTop();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 171 */         return cTBorderPr;case RIGHT: cTBorderPr = this.border.getRight(); if (paramBoolean && cTBorderPr == null) cTBorderPr = this.border.addNewRight();  return cTBorderPr;case BOTTOM: cTBorderPr = this.border.getBottom(); if (paramBoolean && cTBorderPr == null) cTBorderPr = this.border.addNewBottom();  return cTBorderPr;case LEFT: cTBorderPr = this.border.getLeft(); if (paramBoolean && cTBorderPr == null) cTBorderPr = this.border.addNewLeft();  return cTBorderPr;
/*     */     } 
/*     */     throw new IllegalArgumentException("No suitable side specified for the border");
/*     */   }
/*     */   public int hashCode() {
/* 176 */     return this.border.toString().hashCode();
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 180 */     if (!(paramObject instanceof XSSFCellBorder)) return false;
/*     */     
/* 182 */     XSSFCellBorder xSSFCellBorder = (XSSFCellBorder)paramObject;
/* 183 */     return this.border.toString().equals(xSSFCellBorder.getCTBorder().toString());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\extensions\XSSFCellBorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */