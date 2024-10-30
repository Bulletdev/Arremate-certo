/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.POIXMLException;
/*     */ import org.apache.poi.ss.usermodel.PageOrder;
/*     */ import org.apache.poi.ss.usermodel.PaperSize;
/*     */ import org.apache.poi.ss.usermodel.PrintCellComments;
/*     */ import org.apache.poi.ss.usermodel.PrintOrientation;
/*     */ import org.apache.poi.ss.usermodel.PrintSetup;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageSetup;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellComments;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STOrientation;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPageOrder;
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
/*     */ public class XSSFPrintSetup
/*     */   implements PrintSetup
/*     */ {
/*     */   private CTWorksheet ctWorksheet;
/*     */   private CTPageSetup pageSetup;
/*     */   private CTPageMargins pageMargins;
/*     */   
/*     */   protected XSSFPrintSetup(CTWorksheet paramCTWorksheet) {
/*  43 */     this.ctWorksheet = paramCTWorksheet;
/*     */     
/*  45 */     if (this.ctWorksheet.isSetPageSetup()) {
/*  46 */       this.pageSetup = this.ctWorksheet.getPageSetup();
/*     */     } else {
/*  48 */       this.pageSetup = this.ctWorksheet.addNewPageSetup();
/*     */     } 
/*  50 */     if (this.ctWorksheet.isSetPageMargins()) {
/*  51 */       this.pageMargins = this.ctWorksheet.getPageMargins();
/*     */     } else {
/*  53 */       this.pageMargins = this.ctWorksheet.addNewPageMargins();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPaperSize(short paramShort) {
/*  63 */     this.pageSetup.setPaperSize(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPaperSize(PaperSize paramPaperSize) {
/*  72 */     setPaperSize((short)(paramPaperSize.ordinal() + 1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(short paramShort) {
/*  83 */     if (paramShort < 10 || paramShort > 400) throw new POIXMLException("Scale value not accepted: you must choose a value between 10 and 400."); 
/*  84 */     this.pageSetup.setScale(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPageStart(short paramShort) {
/*  94 */     this.pageSetup.setFirstPageNumber(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFitWidth(short paramShort) {
/* 103 */     this.pageSetup.setFitToWidth(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFitHeight(short paramShort) {
/* 112 */     this.pageSetup.setFitToHeight(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftToRight(boolean paramBoolean) {
/* 121 */     if (paramBoolean) {
/* 122 */       setPageOrder(PageOrder.OVER_THEN_DOWN);
/*     */     } else {
/* 124 */       setPageOrder(PageOrder.DOWN_THEN_OVER);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLandscape(boolean paramBoolean) {
/* 133 */     if (paramBoolean) {
/* 134 */       setOrientation(PrintOrientation.LANDSCAPE);
/*     */     } else {
/* 136 */       setOrientation(PrintOrientation.PORTRAIT);
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
/*     */   public void setValidSettings(boolean paramBoolean) {
/* 148 */     this.pageSetup.setUsePrinterDefaults(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoColor(boolean paramBoolean) {
/* 157 */     this.pageSetup.setBlackAndWhite(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDraft(boolean paramBoolean) {
/* 166 */     this.pageSetup.setDraft(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotes(boolean paramBoolean) {
/* 175 */     if (paramBoolean) {
/* 176 */       this.pageSetup.setCellComments(STCellComments.AS_DISPLAYED);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoOrientation(boolean paramBoolean) {
/* 186 */     if (paramBoolean) {
/* 187 */       setOrientation(PrintOrientation.DEFAULT);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsePage(boolean paramBoolean) {
/* 197 */     this.pageSetup.setUseFirstPageNumber(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHResolution(short paramShort) {
/* 206 */     this.pageSetup.setHorizontalDpi(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVResolution(short paramShort) {
/* 215 */     this.pageSetup.setVerticalDpi(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeaderMargin(double paramDouble) {
/* 224 */     this.pageMargins.setHeader(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFooterMargin(double paramDouble) {
/* 233 */     this.pageMargins.setFooter(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCopies(short paramShort) {
/* 242 */     this.pageSetup.setCopies(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOrientation(PrintOrientation paramPrintOrientation) {
/* 252 */     STOrientation.Enum enum_ = STOrientation.Enum.forInt(paramPrintOrientation.getValue());
/* 253 */     this.pageSetup.setOrientation(enum_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintOrientation getOrientation() {
/* 263 */     STOrientation.Enum enum_ = this.pageSetup.getOrientation();
/* 264 */     return (enum_ == null) ? PrintOrientation.DEFAULT : PrintOrientation.valueOf(enum_.intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public PrintCellComments getCellComment() {
/* 269 */     STCellComments.Enum enum_ = this.pageSetup.getCellComments();
/* 270 */     return (enum_ == null) ? PrintCellComments.NONE : PrintCellComments.valueOf(enum_.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPageOrder(PageOrder paramPageOrder) {
/* 279 */     STPageOrder.Enum enum_ = STPageOrder.Enum.forInt(paramPageOrder.getValue());
/* 280 */     this.pageSetup.setPageOrder(enum_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PageOrder getPageOrder() {
/* 289 */     return (this.pageSetup.getPageOrder() == null) ? null : PageOrder.valueOf(this.pageSetup.getPageOrder().intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getPaperSize() {
/* 298 */     return (short)(int)this.pageSetup.getPaperSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PaperSize getPaperSizeEnum() {
/* 308 */     return PaperSize.values()[getPaperSize() - 1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getScale() {
/* 317 */     return (short)(int)this.pageSetup.getScale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getPageStart() {
/* 327 */     return (short)(int)this.pageSetup.getFirstPageNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFitWidth() {
/* 336 */     return (short)(int)this.pageSetup.getFitToWidth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFitHeight() {
/* 345 */     return (short)(int)this.pageSetup.getFitToHeight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getLeftToRight() {
/* 354 */     return (getPageOrder() == PageOrder.OVER_THEN_DOWN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getLandscape() {
/* 363 */     return (getOrientation() == PrintOrientation.LANDSCAPE);
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
/*     */   public boolean getValidSettings() {
/* 375 */     return this.pageSetup.getUsePrinterDefaults();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNoColor() {
/* 384 */     return this.pageSetup.getBlackAndWhite();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDraft() {
/* 393 */     return this.pageSetup.getDraft();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNotes() {
/* 402 */     return (getCellComment() == PrintCellComments.AS_DISPLAYED);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNoOrientation() {
/* 411 */     return (getOrientation() == PrintOrientation.DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getUsePage() {
/* 420 */     return this.pageSetup.getUseFirstPageNumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHResolution() {
/* 429 */     return (short)(int)this.pageSetup.getHorizontalDpi();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getVResolution() {
/* 438 */     return (short)(int)this.pageSetup.getVerticalDpi();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHeaderMargin() {
/* 447 */     return this.pageMargins.getHeader();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getFooterMargin() {
/* 456 */     return this.pageMargins.getFooter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCopies() {
/* 465 */     return (short)(int)this.pageSetup.getCopies();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFPrintSetup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */