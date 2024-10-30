/*     */ package org.apache.poi.xssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.common.usermodel.HyperlinkType;
/*     */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*     */ import org.apache.poi.ss.usermodel.CreationHelper;
/*     */ import org.apache.poi.ss.usermodel.DataFormat;
/*     */ import org.apache.poi.ss.usermodel.ExtendedColor;
/*     */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
/*     */ import org.apache.poi.ss.usermodel.Hyperlink;
/*     */ import org.apache.poi.ss.usermodel.RichTextString;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.Removal;
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
/*     */ public class XSSFCreationHelper
/*     */   implements CreationHelper
/*     */ {
/*     */   private final XSSFWorkbook workbook;
/*     */   
/*     */   @Internal
/*     */   public XSSFCreationHelper(XSSFWorkbook paramXSSFWorkbook) {
/*  35 */     this.workbook = paramXSSFWorkbook;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFRichTextString createRichTextString(String paramString) {
/*  43 */     XSSFRichTextString xSSFRichTextString = new XSSFRichTextString(paramString);
/*  44 */     xSSFRichTextString.setStylesTableReference(this.workbook.getStylesSource());
/*  45 */     return xSSFRichTextString;
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFDataFormat createDataFormat() {
/*  50 */     return this.workbook.createDataFormat();
/*     */   }
/*     */ 
/*     */   
/*     */   public XSSFColor createExtendedColor() {
/*  55 */     return new XSSFColor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @Removal(version = "3.17")
/*     */   public XSSFHyperlink createHyperlink(int paramInt) {
/*  68 */     return new XSSFHyperlink(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFHyperlink createHyperlink(HyperlinkType paramHyperlinkType) {
/*  78 */     return new XSSFHyperlink(paramHyperlinkType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XSSFFormulaEvaluator createFormulaEvaluator() {
/*  88 */     return new XSSFFormulaEvaluator(this.workbook);
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
/*     */   public XSSFClientAnchor createClientAnchor() {
/* 100 */     return new XSSFClientAnchor();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFCreationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */