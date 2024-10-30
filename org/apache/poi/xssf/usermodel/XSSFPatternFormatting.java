/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.Color;
/*     */ import org.apache.poi.ss.usermodel.PatternFormatting;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTColor;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XSSFPatternFormatting
/*     */   implements PatternFormatting
/*     */ {
/*     */   CTFill _fill;
/*     */   
/*     */   XSSFPatternFormatting(CTFill paramCTFill) {
/*  35 */     this._fill = paramCTFill;
/*     */   }
/*     */   
/*     */   public XSSFColor getFillBackgroundColorColor() {
/*  39 */     if (!this._fill.isSetPatternFill()) return null; 
/*  40 */     return new XSSFColor(this._fill.getPatternFill().getBgColor());
/*     */   }
/*     */   public XSSFColor getFillForegroundColorColor() {
/*  43 */     if (!this._fill.isSetPatternFill() || !this._fill.getPatternFill().isSetFgColor())
/*  44 */       return null; 
/*  45 */     return new XSSFColor(this._fill.getPatternFill().getFgColor());
/*     */   }
/*     */   
/*     */   public short getFillPattern() {
/*  49 */     if (!this._fill.isSetPatternFill() || !this._fill.getPatternFill().isSetPatternType()) return 0;
/*     */     
/*  51 */     return (short)(this._fill.getPatternFill().getPatternType().intValue() - 1);
/*     */   }
/*     */   
/*     */   public short getFillBackgroundColor() {
/*  55 */     XSSFColor xSSFColor = getFillBackgroundColorColor();
/*  56 */     if (xSSFColor == null) return 0; 
/*  57 */     return xSSFColor.getIndexed();
/*     */   }
/*     */   public short getFillForegroundColor() {
/*  60 */     XSSFColor xSSFColor = getFillForegroundColorColor();
/*  61 */     if (xSSFColor == null) return 0; 
/*  62 */     return xSSFColor.getIndexed();
/*     */   }
/*     */   
/*     */   public void setFillBackgroundColor(Color paramColor) {
/*  66 */     XSSFColor xSSFColor = XSSFColor.toXSSFColor(paramColor);
/*  67 */     if (xSSFColor == null) { setFillBackgroundColor((CTColor)null); }
/*  68 */     else { setFillBackgroundColor(xSSFColor.getCTColor()); }
/*     */   
/*     */   } public void setFillBackgroundColor(short paramShort) {
/*  71 */     CTColor cTColor = CTColor.Factory.newInstance();
/*  72 */     cTColor.setIndexed(paramShort);
/*  73 */     setFillBackgroundColor(cTColor);
/*     */   }
/*     */   private void setFillBackgroundColor(CTColor paramCTColor) {
/*  76 */     CTPatternFill cTPatternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
/*  77 */     if (paramCTColor == null) {
/*  78 */       cTPatternFill.unsetBgColor();
/*     */     } else {
/*  80 */       cTPatternFill.setBgColor(paramCTColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFillForegroundColor(Color paramColor) {
/*  85 */     XSSFColor xSSFColor = XSSFColor.toXSSFColor(paramColor);
/*  86 */     if (xSSFColor == null) { setFillForegroundColor((CTColor)null); }
/*  87 */     else { setFillForegroundColor(xSSFColor.getCTColor()); }
/*     */   
/*     */   } public void setFillForegroundColor(short paramShort) {
/*  90 */     CTColor cTColor = CTColor.Factory.newInstance();
/*  91 */     cTColor.setIndexed(paramShort);
/*  92 */     setFillForegroundColor(cTColor);
/*     */   }
/*     */   private void setFillForegroundColor(CTColor paramCTColor) {
/*  95 */     CTPatternFill cTPatternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
/*  96 */     if (paramCTColor == null) {
/*  97 */       cTPatternFill.unsetFgColor();
/*     */     } else {
/*  99 */       cTPatternFill.setFgColor(paramCTColor);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setFillPattern(short paramShort) {
/* 104 */     CTPatternFill cTPatternFill = this._fill.isSetPatternFill() ? this._fill.getPatternFill() : this._fill.addNewPatternFill();
/* 105 */     if (paramShort == 0) { cTPatternFill.unsetPatternType(); }
/* 106 */     else { cTPatternFill.setPatternType(STPatternType.Enum.forInt(paramShort + 1)); }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFPatternFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */