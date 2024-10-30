/*     */ package org.apache.poi.xssf.usermodel.extensions;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.HorizontalAlignment;
/*     */ import org.apache.poi.ss.usermodel.VerticalAlignment;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STHorizontalAlignment;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignment;
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
/*     */ public class XSSFCellAlignment
/*     */ {
/*     */   private CTCellAlignment cellAlignement;
/*     */   
/*     */   public XSSFCellAlignment(CTCellAlignment paramCTCellAlignment) {
/*  39 */     this.cellAlignement = paramCTCellAlignment;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public VerticalAlignment getVertical() {
/*  49 */     STVerticalAlignment.Enum enum_ = this.cellAlignement.getVertical();
/*  50 */     if (enum_ == null) enum_ = STVerticalAlignment.BOTTOM;
/*     */     
/*  52 */     return VerticalAlignment.values()[enum_.intValue() - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVertical(VerticalAlignment paramVerticalAlignment) {
/*  62 */     this.cellAlignement.setVertical(STVerticalAlignment.Enum.forInt(paramVerticalAlignment.ordinal() + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HorizontalAlignment getHorizontal() {
/*  72 */     STHorizontalAlignment.Enum enum_ = this.cellAlignement.getHorizontal();
/*  73 */     if (enum_ == null) enum_ = STHorizontalAlignment.GENERAL;
/*     */     
/*  75 */     return HorizontalAlignment.values()[enum_.intValue() - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontal(HorizontalAlignment paramHorizontalAlignment) {
/*  85 */     this.cellAlignement.setHorizontal(STHorizontalAlignment.Enum.forInt(paramHorizontalAlignment.ordinal() + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getIndent() {
/*  94 */     return this.cellAlignement.getIndent();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndent(long paramLong) {
/* 103 */     this.cellAlignement.setIndent(paramLong);
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
/*     */   
/*     */   public long getTextRotation() {
/* 121 */     return this.cellAlignement.getTextRotation();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextRotation(long paramLong) {
/* 144 */     if (paramLong < 0L && paramLong >= -90L) {
/* 145 */       paramLong = 90L + -1L * paramLong;
/*     */     }
/* 147 */     this.cellAlignement.setTextRotation(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getWrapText() {
/* 156 */     return this.cellAlignement.getWrapText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWrapText(boolean paramBoolean) {
/* 165 */     this.cellAlignement.setWrapText(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean getShrinkToFit() {
/* 169 */     return this.cellAlignement.getShrinkToFit();
/*     */   }
/*     */   
/*     */   public void setShrinkToFit(boolean paramBoolean) {
/* 173 */     this.cellAlignement.setShrinkToFit(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public CTCellAlignment getCTCellAlignment() {
/* 181 */     return this.cellAlignement;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\extensions\XSSFCellAlignment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */