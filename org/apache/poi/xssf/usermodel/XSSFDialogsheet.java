/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationship;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDialogsheet;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageBreak;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPageMargins;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPrintOptions;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetFormatPr;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetPr;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetProtection;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetViews;
/*     */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;
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
/*     */ public class XSSFDialogsheet
/*     */   extends XSSFSheet
/*     */   implements Sheet
/*     */ {
/*     */   protected CTDialogsheet dialogsheet;
/*     */   
/*     */   protected XSSFDialogsheet(XSSFSheet paramXSSFSheet, PackageRelationship paramPackageRelationship) {
/*  38 */     super(paramXSSFSheet.getPackagePart(), paramPackageRelationship);
/*  39 */     this.dialogsheet = CTDialogsheet.Factory.newInstance();
/*  40 */     this.worksheet = CTWorksheet.Factory.newInstance();
/*     */   }
/*     */   
/*     */   public XSSFRow createRow(int paramInt) {
/*  44 */     return null;
/*     */   }
/*     */   
/*     */   protected CTHeaderFooter getSheetTypeHeaderFooter() {
/*  48 */     if (this.dialogsheet.getHeaderFooter() == null) {
/*  49 */       this.dialogsheet.setHeaderFooter(CTHeaderFooter.Factory.newInstance());
/*     */     }
/*  51 */     return this.dialogsheet.getHeaderFooter();
/*     */   }
/*     */   
/*     */   protected CTSheetPr getSheetTypeSheetPr() {
/*  55 */     if (this.dialogsheet.getSheetPr() == null) {
/*  56 */       this.dialogsheet.setSheetPr(CTSheetPr.Factory.newInstance());
/*     */     }
/*  58 */     return this.dialogsheet.getSheetPr();
/*     */   }
/*     */   
/*     */   protected CTPageBreak getSheetTypeColumnBreaks() {
/*  62 */     return null;
/*     */   }
/*     */   
/*     */   protected CTSheetFormatPr getSheetTypeSheetFormatPr() {
/*  66 */     if (this.dialogsheet.getSheetFormatPr() == null) {
/*  67 */       this.dialogsheet.setSheetFormatPr(CTSheetFormatPr.Factory.newInstance());
/*     */     }
/*  69 */     return this.dialogsheet.getSheetFormatPr();
/*     */   }
/*     */   
/*     */   protected CTPageMargins getSheetTypePageMargins() {
/*  73 */     if (this.dialogsheet.getPageMargins() == null) {
/*  74 */       this.dialogsheet.setPageMargins(CTPageMargins.Factory.newInstance());
/*     */     }
/*  76 */     return this.dialogsheet.getPageMargins();
/*     */   }
/*     */   
/*     */   protected CTPageBreak getSheetTypeRowBreaks() {
/*  80 */     return null;
/*     */   }
/*     */   
/*     */   protected CTSheetViews getSheetTypeSheetViews() {
/*  84 */     if (this.dialogsheet.getSheetViews() == null) {
/*  85 */       this.dialogsheet.setSheetViews(CTSheetViews.Factory.newInstance());
/*  86 */       this.dialogsheet.getSheetViews().addNewSheetView();
/*     */     } 
/*  88 */     return this.dialogsheet.getSheetViews();
/*     */   }
/*     */   
/*     */   protected CTPrintOptions getSheetTypePrintOptions() {
/*  92 */     if (this.dialogsheet.getPrintOptions() == null) {
/*  93 */       this.dialogsheet.setPrintOptions(CTPrintOptions.Factory.newInstance());
/*     */     }
/*  95 */     return this.dialogsheet.getPrintOptions();
/*     */   }
/*     */   
/*     */   protected CTSheetProtection getSheetTypeProtection() {
/*  99 */     if (this.dialogsheet.getSheetProtection() == null) {
/* 100 */       this.dialogsheet.setSheetProtection(CTSheetProtection.Factory.newInstance());
/*     */     }
/* 102 */     return this.dialogsheet.getSheetProtection();
/*     */   }
/*     */   
/*     */   public boolean getDialog() {
/* 106 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFDialogsheet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */