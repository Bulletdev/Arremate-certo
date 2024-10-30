/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.CFRuleBase;
/*     */ import org.apache.poi.hssf.record.cf.FontFormatting;
/*     */ import org.apache.poi.hssf.util.HSSFColor;
/*     */ import org.apache.poi.ss.usermodel.Color;
/*     */ import org.apache.poi.ss.usermodel.FontFormatting;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HSSFFontFormatting
/*     */   implements FontFormatting
/*     */ {
/*     */   public static final byte U_NONE = 0;
/*     */   public static final byte U_SINGLE = 1;
/*     */   public static final byte U_DOUBLE = 2;
/*     */   public static final byte U_SINGLE_ACCOUNTING = 33;
/*     */   public static final byte U_DOUBLE_ACCOUNTING = 34;
/*     */   private final FontFormatting fontFormatting;
/*     */   private final HSSFWorkbook workbook;
/*     */   
/*     */   protected HSSFFontFormatting(CFRuleBase paramCFRuleBase, HSSFWorkbook paramHSSFWorkbook) {
/*  44 */     this.fontFormatting = paramCFRuleBase.getFontFormatting();
/*  45 */     this.workbook = paramHSSFWorkbook;
/*     */   }
/*     */   
/*     */   protected FontFormatting getFontFormattingBlock() {
/*  49 */     return this.fontFormatting;
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
/*  62 */     return this.fontFormatting.getEscapementType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFontColorIndex() {
/*  70 */     return this.fontFormatting.getFontColorIndex();
/*     */   }
/*     */   
/*     */   public HSSFColor getFontColor() {
/*  74 */     return this.workbook.getCustomPalette().getColor(getFontColorIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontColor(Color paramColor) {
/*  80 */     HSSFColor hSSFColor = HSSFColor.toHSSFColor(paramColor);
/*  81 */     if (hSSFColor == null) {
/*  82 */       this.fontFormatting.setFontColorIndex((short)0);
/*     */     } else {
/*  84 */       this.fontFormatting.setFontColorIndex(hSSFColor.getIndex());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFontHeight() {
/*  94 */     return this.fontFormatting.getFontHeight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFontWeight() {
/* 104 */     return this.fontFormatting.getFontWeight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] getRawRecord() {
/* 111 */     return this.fontFormatting.getRawRecord();
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
/* 127 */     return this.fontFormatting.getUnderlineType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBold() {
/* 137 */     return (this.fontFormatting.isFontWeightModified() && this.fontFormatting.isBold());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEscapementTypeModified() {
/* 145 */     return this.fontFormatting.isEscapementTypeModified();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFontCancellationModified() {
/* 153 */     return this.fontFormatting.isFontCancellationModified();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFontOutlineModified() {
/* 161 */     return this.fontFormatting.isFontOutlineModified();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFontShadowModified() {
/* 169 */     return this.fontFormatting.isFontShadowModified();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFontStyleModified() {
/* 177 */     return this.fontFormatting.isFontStyleModified();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isItalic() {
/* 185 */     return (this.fontFormatting.isFontStyleModified() && this.fontFormatting.isItalic());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOutlineOn() {
/* 193 */     return (this.fontFormatting.isFontOutlineModified() && this.fontFormatting.isOutlineOn());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isShadowOn() {
/* 201 */     return (this.fontFormatting.isFontOutlineModified() && this.fontFormatting.isShadowOn());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStruckout() {
/* 209 */     return (this.fontFormatting.isFontCancellationModified() && this.fontFormatting.isStruckout());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUnderlineTypeModified() {
/* 217 */     return this.fontFormatting.isUnderlineTypeModified();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFontWeightModified() {
/* 225 */     return this.fontFormatting.isFontWeightModified();
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
/*     */   public void setFontStyle(boolean paramBoolean1, boolean paramBoolean2) {
/* 237 */     boolean bool = (paramBoolean1 || paramBoolean2) ? true : false;
/* 238 */     this.fontFormatting.setItalic(paramBoolean1);
/* 239 */     this.fontFormatting.setBold(paramBoolean2);
/* 240 */     this.fontFormatting.setFontStyleModified(bool);
/* 241 */     this.fontFormatting.setFontWieghtModified(bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetFontStyle() {
/* 249 */     setFontStyle(false, false);
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
/*     */   public void setEscapementType(short paramShort) {
/* 261 */     switch (paramShort) {
/*     */       case 1:
/*     */       case 2:
/* 264 */         this.fontFormatting.setEscapementType(paramShort);
/* 265 */         this.fontFormatting.setEscapementTypeModified(true);
/*     */         break;
/*     */       case 0:
/* 268 */         this.fontFormatting.setEscapementType(paramShort);
/* 269 */         this.fontFormatting.setEscapementTypeModified(false);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEscapementTypeModified(boolean paramBoolean) {
/* 280 */     this.fontFormatting.setEscapementTypeModified(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontCancellationModified(boolean paramBoolean) {
/* 289 */     this.fontFormatting.setFontCancellationModified(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontColorIndex(short paramShort) {
/* 298 */     this.fontFormatting.setFontColorIndex(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontHeight(int paramInt) {
/* 307 */     this.fontFormatting.setFontHeight(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontOutlineModified(boolean paramBoolean) {
/* 316 */     this.fontFormatting.setFontOutlineModified(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontShadowModified(boolean paramBoolean) {
/* 325 */     this.fontFormatting.setFontShadowModified(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFontStyleModified(boolean paramBoolean) {
/* 334 */     this.fontFormatting.setFontStyleModified(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutline(boolean paramBoolean) {
/* 343 */     this.fontFormatting.setOutline(paramBoolean);
/* 344 */     this.fontFormatting.setFontOutlineModified(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShadow(boolean paramBoolean) {
/* 353 */     this.fontFormatting.setShadow(paramBoolean);
/* 354 */     this.fontFormatting.setFontShadowModified(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStrikeout(boolean paramBoolean) {
/* 363 */     this.fontFormatting.setStrikeout(paramBoolean);
/* 364 */     this.fontFormatting.setFontCancellationModified(paramBoolean);
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
/*     */   public void setUnderlineType(short paramShort) {
/* 379 */     switch (paramShort) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 33:
/*     */       case 34:
/* 384 */         this.fontFormatting.setUnderlineType(paramShort);
/* 385 */         setUnderlineTypeModified(true);
/*     */         break;
/*     */       
/*     */       case 0:
/* 389 */         this.fontFormatting.setUnderlineType(paramShort);
/* 390 */         setUnderlineTypeModified(false);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnderlineTypeModified(boolean paramBoolean) {
/* 402 */     this.fontFormatting.setUnderlineTypeModified(paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFFontFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */