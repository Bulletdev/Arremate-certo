/*     */ package org.apache.poi.xssf.usermodel.extensions;
/*     */ 
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.xssf.usermodel.XSSFColor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class XSSFCellFill
/*     */ {
/*     */   private CTFill _fill;
/*     */   
/*     */   public XSSFCellFill(CTFill paramCTFill) {
/*  40 */     this._fill = paramCTFill;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFCellFill() {
/*  47 */     this._fill = CTFill.Factory.newInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFColor getFillBackgroundColor() {
/*  56 */     CTPatternFill cTPatternFill = this._fill.getPatternFill();
/*  57 */     if (cTPatternFill == null) return null;
/*     */     
/*  59 */     CTColor cTColor = cTPatternFill.getBgColor();
/*  60 */     return (cTColor == null) ? null : new XSSFColor(cTColor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillBackgroundColor(int paramInt) {
/*  69 */     CTPatternFill cTPatternFill = ensureCTPatternFill();
/*  70 */     CTColor cTColor = cTPatternFill.isSetBgColor() ? cTPatternFill.getBgColor() : cTPatternFill.addNewBgColor();
/*  71 */     cTColor.setIndexed(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillBackgroundColor(XSSFColor paramXSSFColor) {
/*  80 */     CTPatternFill cTPatternFill = ensureCTPatternFill();
/*  81 */     cTPatternFill.setBgColor(paramXSSFColor.getCTColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFColor getFillForegroundColor() {
/*  90 */     CTPatternFill cTPatternFill = this._fill.getPatternFill();
/*  91 */     if (cTPatternFill == null) return null;
/*     */     
/*  93 */     CTColor cTColor = cTPatternFill.getFgColor();
/*  94 */     return (cTColor == null) ? null : new XSSFColor(cTColor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillForegroundColor(int paramInt) {
/* 103 */     CTPatternFill cTPatternFill = ensureCTPatternFill();
/* 104 */     CTColor cTColor = cTPatternFill.isSetFgColor() ? cTPatternFill.getFgColor() : cTPatternFill.addNewFgColor();
/* 105 */     cTColor.setIndexed(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFillForegroundColor(XSSFColor paramXSSFColor) {
/* 114 */     CTPatternFill cTPatternFill = ensureCTPatternFill();
/* 115 */     cTPatternFill.setFgColor(paramXSSFColor.getCTColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public STPatternType.Enum getPatternType() {
/* 124 */     CTPatternFill cTPatternFill = this._fill.getPatternFill();
/* 125 */     return (cTPatternFill == null) ? null : cTPatternFill.getPatternType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPatternType(STPatternType.Enum paramEnum) {
/* 134 */     CTPatternFill cTPatternFill = ensureCTPatternFill();
/* 135 */     cTPatternFill.setPatternType(paramEnum);
/*     */   }
/*     */   
/*     */   private CTPatternFill ensureCTPatternFill() {
/* 139 */     CTPatternFill cTPatternFill = this._fill.getPatternFill();
/* 140 */     if (cTPatternFill == null) {
/* 141 */       cTPatternFill = this._fill.addNewPatternFill();
/*     */     }
/* 143 */     return cTPatternFill;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTFill getCTFill() {
/* 153 */     return this._fill;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 158 */     return this._fill.toString().hashCode();
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 162 */     if (!(paramObject instanceof XSSFCellFill)) return false;
/*     */     
/* 164 */     XSSFCellFill xSSFCellFill = (XSSFCellFill)paramObject;
/* 165 */     return this._fill.toString().equals(xSSFCellFill.getCTFill().toString());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\extensions\XSSFCellFill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */