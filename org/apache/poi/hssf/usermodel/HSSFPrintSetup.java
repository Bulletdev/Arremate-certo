/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.PrintSetupRecord;
/*     */ import org.apache.poi.ss.usermodel.PrintSetup;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSSFPrintSetup
/*     */   implements PrintSetup
/*     */ {
/*     */   PrintSetupRecord printSetupRecord;
/*     */   
/*     */   protected HSSFPrintSetup(PrintSetupRecord paramPrintSetupRecord) {
/*  48 */     this.printSetupRecord = paramPrintSetupRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPaperSize(short paramShort) {
/*  56 */     this.printSetupRecord.setPaperSize(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(short paramShort) {
/*  64 */     this.printSetupRecord.setScale(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPageStart(short paramShort) {
/*  72 */     this.printSetupRecord.setPageStart(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFitWidth(short paramShort) {
/*  80 */     this.printSetupRecord.setFitWidth(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFitHeight(short paramShort) {
/*  88 */     this.printSetupRecord.setFitHeight(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/*  96 */     this.printSetupRecord.setOptions(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeftToRight(boolean paramBoolean) {
/* 104 */     this.printSetupRecord.setLeftToRight(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLandscape(boolean paramBoolean) {
/* 112 */     this.printSetupRecord.setLandscape(!paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValidSettings(boolean paramBoolean) {
/* 120 */     this.printSetupRecord.setValidSettings(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoColor(boolean paramBoolean) {
/* 128 */     this.printSetupRecord.setNoColor(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDraft(boolean paramBoolean) {
/* 136 */     this.printSetupRecord.setDraft(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotes(boolean paramBoolean) {
/* 144 */     this.printSetupRecord.setNotes(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoOrientation(boolean paramBoolean) {
/* 152 */     this.printSetupRecord.setNoOrientation(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsePage(boolean paramBoolean) {
/* 160 */     this.printSetupRecord.setUsePage(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHResolution(short paramShort) {
/* 168 */     this.printSetupRecord.setHResolution(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVResolution(short paramShort) {
/* 176 */     this.printSetupRecord.setVResolution(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeaderMargin(double paramDouble) {
/* 184 */     this.printSetupRecord.setHeaderMargin(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFooterMargin(double paramDouble) {
/* 192 */     this.printSetupRecord.setFooterMargin(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCopies(short paramShort) {
/* 200 */     this.printSetupRecord.setCopies(paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getPaperSize() {
/* 208 */     return this.printSetupRecord.getPaperSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getScale() {
/* 216 */     return this.printSetupRecord.getScale();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getPageStart() {
/* 224 */     return this.printSetupRecord.getPageStart();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFitWidth() {
/* 232 */     return this.printSetupRecord.getFitWidth();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getFitHeight() {
/* 240 */     return this.printSetupRecord.getFitHeight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 248 */     return this.printSetupRecord.getOptions();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getLeftToRight() {
/* 256 */     return this.printSetupRecord.getLeftToRight();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getLandscape() {
/* 264 */     return !this.printSetupRecord.getLandscape();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getValidSettings() {
/* 272 */     return this.printSetupRecord.getValidSettings();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNoColor() {
/* 280 */     return this.printSetupRecord.getNoColor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getDraft() {
/* 288 */     return this.printSetupRecord.getDraft();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNotes() {
/* 296 */     return this.printSetupRecord.getNotes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getNoOrientation() {
/* 304 */     return this.printSetupRecord.getNoOrientation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getUsePage() {
/* 312 */     return this.printSetupRecord.getUsePage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHResolution() {
/* 320 */     return this.printSetupRecord.getHResolution();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getVResolution() {
/* 328 */     return this.printSetupRecord.getVResolution();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHeaderMargin() {
/* 336 */     return this.printSetupRecord.getHeaderMargin();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getFooterMargin() {
/* 344 */     return this.printSetupRecord.getFooterMargin();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCopies() {
/* 352 */     return this.printSetupRecord.getCopies();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFPrintSetup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */