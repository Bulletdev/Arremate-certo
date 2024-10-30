/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.CFRuleBase;
/*     */ import org.apache.poi.hssf.record.cf.BorderFormatting;
/*     */ import org.apache.poi.hssf.util.HSSFColor;
/*     */ import org.apache.poi.ss.usermodel.BorderFormatting;
/*     */ import org.apache.poi.ss.usermodel.BorderStyle;
/*     */ import org.apache.poi.ss.usermodel.Color;
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
/*     */ public final class HSSFBorderFormatting
/*     */   implements BorderFormatting
/*     */ {
/*     */   private final HSSFWorkbook workbook;
/*     */   private final CFRuleBase cfRuleRecord;
/*     */   private final BorderFormatting borderFormatting;
/*     */   
/*     */   protected HSSFBorderFormatting(CFRuleBase paramCFRuleBase, HSSFWorkbook paramHSSFWorkbook) {
/*  36 */     this.workbook = paramHSSFWorkbook;
/*  37 */     this.cfRuleRecord = paramCFRuleBase;
/*  38 */     this.borderFormatting = paramCFRuleBase.getBorderFormatting();
/*     */   }
/*     */   
/*     */   protected BorderFormatting getBorderFormattingBlock() {
/*  42 */     return this.borderFormatting;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderBottom() {
/*  51 */     return (short)this.borderFormatting.getBorderBottom();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderBottomEnum() {
/*  58 */     return BorderStyle.valueOf((short)this.borderFormatting.getBorderBottom());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderDiagonal() {
/*  67 */     return (short)this.borderFormatting.getBorderDiagonal();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderDiagonalEnum() {
/*  74 */     return BorderStyle.valueOf((short)this.borderFormatting.getBorderDiagonal());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderLeft() {
/*  83 */     return (short)this.borderFormatting.getBorderLeft();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderLeftEnum() {
/*  90 */     return BorderStyle.valueOf((short)this.borderFormatting.getBorderLeft());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderRight() {
/*  99 */     return (short)this.borderFormatting.getBorderRight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderRightEnum() {
/* 106 */     return BorderStyle.valueOf((short)this.borderFormatting.getBorderRight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getBorderTop() {
/* 115 */     return (short)this.borderFormatting.getBorderTop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BorderStyle getBorderTopEnum() {
/* 122 */     return BorderStyle.valueOf((short)this.borderFormatting.getBorderTop());
/*     */   }
/*     */ 
/*     */   
/*     */   public short getBottomBorderColor() {
/* 127 */     return (short)this.borderFormatting.getBottomBorderColor();
/*     */   }
/*     */   
/*     */   public HSSFColor getBottomBorderColorColor() {
/* 131 */     return this.workbook.getCustomPalette().getColor(this.borderFormatting.getBottomBorderColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getDiagonalBorderColor() {
/* 138 */     return (short)this.borderFormatting.getDiagonalBorderColor();
/*     */   }
/*     */   
/*     */   public HSSFColor getDiagonalBorderColorColor() {
/* 142 */     return this.workbook.getCustomPalette().getColor(this.borderFormatting.getDiagonalBorderColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getLeftBorderColor() {
/* 149 */     return (short)this.borderFormatting.getLeftBorderColor();
/*     */   }
/*     */   
/*     */   public HSSFColor getLeftBorderColorColor() {
/* 153 */     return this.workbook.getCustomPalette().getColor(this.borderFormatting.getLeftBorderColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getRightBorderColor() {
/* 160 */     return (short)this.borderFormatting.getRightBorderColor();
/*     */   }
/*     */   
/*     */   public HSSFColor getRightBorderColorColor() {
/* 164 */     return this.workbook.getCustomPalette().getColor(this.borderFormatting.getRightBorderColor());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTopBorderColor() {
/* 171 */     return (short)this.borderFormatting.getTopBorderColor();
/*     */   }
/*     */   
/*     */   public HSSFColor getTopBorderColorColor() {
/* 175 */     return this.workbook.getCustomPalette().getColor(this.borderFormatting.getTopBorderColor());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBackwardDiagonalOn() {
/* 181 */     return this.borderFormatting.isBackwardDiagonalOn();
/*     */   }
/*     */   public boolean isForwardDiagonalOn() {
/* 184 */     return this.borderFormatting.isForwardDiagonalOn();
/*     */   }
/*     */   
/*     */   public void setBackwardDiagonalOn(boolean paramBoolean) {
/* 188 */     this.borderFormatting.setBackwardDiagonalOn(paramBoolean);
/* 189 */     if (paramBoolean)
/* 190 */       this.cfRuleRecord.setTopLeftBottomRightBorderModified(paramBoolean); 
/*     */   }
/*     */   
/*     */   public void setForwardDiagonalOn(boolean paramBoolean) {
/* 194 */     this.borderFormatting.setForwardDiagonalOn(paramBoolean);
/* 195 */     if (paramBoolean) {
/* 196 */       this.cfRuleRecord.setBottomLeftTopRightBorderModified(paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderBottom(short paramShort) {
/* 202 */     this.borderFormatting.setBorderBottom(paramShort);
/* 203 */     if (paramShort != 0) {
/* 204 */       this.cfRuleRecord.setBottomBorderModified(true);
/*     */     } else {
/* 206 */       this.cfRuleRecord.setBottomBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBorderBottom(BorderStyle paramBorderStyle) {
/* 211 */     setBorderBottom(paramBorderStyle.getCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderDiagonal(short paramShort) {
/* 216 */     this.borderFormatting.setBorderDiagonal(paramShort);
/* 217 */     if (paramShort != 0) {
/* 218 */       this.cfRuleRecord.setBottomLeftTopRightBorderModified(true);
/* 219 */       this.cfRuleRecord.setTopLeftBottomRightBorderModified(true);
/*     */     } else {
/* 221 */       this.cfRuleRecord.setBottomLeftTopRightBorderModified(false);
/* 222 */       this.cfRuleRecord.setTopLeftBottomRightBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBorderDiagonal(BorderStyle paramBorderStyle) {
/* 227 */     setBorderDiagonal(paramBorderStyle.getCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderLeft(short paramShort) {
/* 232 */     this.borderFormatting.setBorderLeft(paramShort);
/* 233 */     if (paramShort != 0) {
/* 234 */       this.cfRuleRecord.setLeftBorderModified(true);
/*     */     } else {
/* 236 */       this.cfRuleRecord.setLeftBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBorderLeft(BorderStyle paramBorderStyle) {
/* 241 */     setBorderLeft(paramBorderStyle.getCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderRight(short paramShort) {
/* 246 */     this.borderFormatting.setBorderRight(paramShort);
/* 247 */     if (paramShort != 0) {
/* 248 */       this.cfRuleRecord.setRightBorderModified(true);
/*     */     } else {
/* 250 */       this.cfRuleRecord.setRightBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBorderRight(BorderStyle paramBorderStyle) {
/* 255 */     setBorderRight(paramBorderStyle.getCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBorderTop(short paramShort) {
/* 260 */     this.borderFormatting.setBorderTop(paramShort);
/* 261 */     if (paramShort != 0) {
/* 262 */       this.cfRuleRecord.setTopBorderModified(true);
/*     */     } else {
/* 264 */       this.cfRuleRecord.setTopBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBorderTop(BorderStyle paramBorderStyle) {
/* 269 */     setBorderTop(paramBorderStyle.getCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBottomBorderColor(short paramShort) {
/* 274 */     this.borderFormatting.setBottomBorderColor(paramShort);
/* 275 */     if (paramShort != 0) {
/* 276 */       this.cfRuleRecord.setBottomBorderModified(true);
/*     */     } else {
/* 278 */       this.cfRuleRecord.setBottomBorderModified(false);
/*     */     } 
/*     */   }
/*     */   public void setBottomBorderColor(Color paramColor) {
/* 282 */     HSSFColor hSSFColor = HSSFColor.toHSSFColor(paramColor);
/* 283 */     if (hSSFColor == null) {
/* 284 */       setBottomBorderColor((short)0);
/*     */     } else {
/* 286 */       setBottomBorderColor(hSSFColor.getIndex());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDiagonalBorderColor(short paramShort) {
/* 292 */     this.borderFormatting.setDiagonalBorderColor(paramShort);
/* 293 */     if (paramShort != 0) {
/* 294 */       this.cfRuleRecord.setBottomLeftTopRightBorderModified(true);
/* 295 */       this.cfRuleRecord.setTopLeftBottomRightBorderModified(true);
/*     */     } else {
/* 297 */       this.cfRuleRecord.setBottomLeftTopRightBorderModified(false);
/* 298 */       this.cfRuleRecord.setTopLeftBottomRightBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDiagonalBorderColor(Color paramColor) {
/* 303 */     HSSFColor hSSFColor = HSSFColor.toHSSFColor(paramColor);
/* 304 */     if (hSSFColor == null) {
/* 305 */       setDiagonalBorderColor((short)0);
/*     */     } else {
/* 307 */       setDiagonalBorderColor(hSSFColor.getIndex());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLeftBorderColor(short paramShort) {
/* 313 */     this.borderFormatting.setLeftBorderColor(paramShort);
/* 314 */     if (paramShort != 0) {
/* 315 */       this.cfRuleRecord.setLeftBorderModified(true);
/*     */     } else {
/* 317 */       this.cfRuleRecord.setLeftBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setLeftBorderColor(Color paramColor) {
/* 322 */     HSSFColor hSSFColor = HSSFColor.toHSSFColor(paramColor);
/* 323 */     if (hSSFColor == null) {
/* 324 */       setLeftBorderColor((short)0);
/*     */     } else {
/* 326 */       setLeftBorderColor(hSSFColor.getIndex());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRightBorderColor(short paramShort) {
/* 332 */     this.borderFormatting.setRightBorderColor(paramShort);
/* 333 */     if (paramShort != 0) {
/* 334 */       this.cfRuleRecord.setRightBorderModified(true);
/*     */     } else {
/* 336 */       this.cfRuleRecord.setRightBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setRightBorderColor(Color paramColor) {
/* 341 */     HSSFColor hSSFColor = HSSFColor.toHSSFColor(paramColor);
/* 342 */     if (hSSFColor == null) {
/* 343 */       setRightBorderColor((short)0);
/*     */     } else {
/* 345 */       setRightBorderColor(hSSFColor.getIndex());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTopBorderColor(short paramShort) {
/* 351 */     this.borderFormatting.setTopBorderColor(paramShort);
/* 352 */     if (paramShort != 0) {
/* 353 */       this.cfRuleRecord.setTopBorderModified(true);
/*     */     } else {
/* 355 */       this.cfRuleRecord.setTopBorderModified(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTopBorderColor(Color paramColor) {
/* 360 */     HSSFColor hSSFColor = HSSFColor.toHSSFColor(paramColor);
/* 361 */     if (hSSFColor == null) {
/* 362 */       setTopBorderColor((short)0);
/*     */     } else {
/* 364 */       setTopBorderColor(hSSFColor.getIndex());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFBorderFormatting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */