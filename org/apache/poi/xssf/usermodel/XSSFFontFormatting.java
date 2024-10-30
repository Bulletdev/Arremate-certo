/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.Color;
/*     */ import org.apache.poi.ss.usermodel.FontFormatting;
/*     */ import org.apache.poi.ss.usermodel.FontUnderline;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFont;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFontSize;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTUnderlineProperty;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTVerticalAlignFontProperty;
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
/*     */ public class XSSFFontFormatting
/*     */   implements FontFormatting
/*     */ {
/*     */   CTFont _font;
/*     */   
/*     */   XSSFFontFormatting(CTFont paramCTFont) {
/*  38 */     this._font = paramCTFont;
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
/*  51 */     if (this._font.sizeOfVertAlignArray() == 0) return 0;
/*     */     
/*  53 */     CTVerticalAlignFontProperty cTVerticalAlignFontProperty = this._font.getVertAlignArray(0);
/*  54 */     return (short)(cTVerticalAlignFontProperty.getVal().intValue() - 1);
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
/*  67 */     this._font.setVertAlignArray(null);
/*  68 */     if (paramShort != 0) {
/*  69 */       this._font.addNewVertAlign().setVal(STVerticalAlignRun.Enum.forInt(paramShort + 1));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFontColorIndex() {
/*  78 */     if (this._font.sizeOfColorArray() == 0) return -1;
/*     */     
/*  80 */     int i = 0;
/*  81 */     CTColor cTColor = this._font.getColorArray(0);
/*  82 */     if (cTColor.isSetIndexed()) i = (int)cTColor.getIndexed(); 
/*  83 */     return (short)i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontColorIndex(short paramShort) {
/*  91 */     this._font.setColorArray(null);
/*  92 */     if (paramShort != -1) {
/*  93 */       this._font.addNewColor().setIndexed(paramShort);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFColor getFontColor() {
/*  99 */     if (this._font.sizeOfColorArray() == 0) return null;
/*     */     
/* 101 */     return new XSSFColor(this._font.getColorArray(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFontColor(Color paramColor) {
/* 106 */     XSSFColor xSSFColor = XSSFColor.toXSSFColor(paramColor);
/* 107 */     if (xSSFColor == null) {
/* 108 */       this._font.getColorList().clear();
/*     */     } else {
/* 110 */       this._font.setColorArray(0, xSSFColor.getCTColor());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFontHeight() {
/* 121 */     if (this._font.sizeOfSzArray() == 0) return -1;
/*     */     
/* 123 */     CTFontSize cTFontSize = this._font.getSzArray(0);
/* 124 */     return (short)(int)(20.0D * cTFontSize.getVal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontHeight(int paramInt) {
/* 134 */     this._font.setSzArray(null);
/* 135 */     if (paramInt != -1) {
/* 136 */       this._font.addNewSz().setVal(paramInt / 20.0D);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getUnderlineType() {
/* 153 */     if (this._font.sizeOfUArray() == 0) return 0; 
/* 154 */     CTUnderlineProperty cTUnderlineProperty = this._font.getUArray(0);
/* 155 */     switch (cTUnderlineProperty.getVal().intValue()) { case 1:
/* 156 */         return 1;
/* 157 */       case 2: return 2;
/* 158 */       case 3: return 33;
/* 159 */       case 4: return 34; }
/* 160 */      return 0;
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
/*     */   public void setUnderlineType(short paramShort) {
/* 177 */     this._font.setUArray(null);
/* 178 */     if (paramShort != 0) {
/* 179 */       FontUnderline fontUnderline = FontUnderline.valueOf(paramShort);
/* 180 */       STUnderlineValues.Enum enum_ = STUnderlineValues.Enum.forInt(fontUnderline.getValue());
/* 181 */       this._font.addNewU().setVal(enum_);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBold() {
/* 192 */     return (this._font.sizeOfBArray() == 1 && this._font.getBArray(0).getVal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isItalic() {
/* 200 */     return (this._font.sizeOfIArray() == 1 && this._font.getIArray(0).getVal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontStyle(boolean paramBoolean1, boolean paramBoolean2) {
/* 211 */     this._font.setIArray(null);
/* 212 */     this._font.setBArray(null);
/* 213 */     if (paramBoolean1) this._font.addNewI().setVal(true); 
/* 214 */     if (paramBoolean2) this._font.addNewB().setVal(true);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetFontStyle() {
/* 222 */     this._font.set((XmlObject)CTFont.Factory.newInstance());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFFontFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */