/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.common.usermodel.HyperlinkType;
/*    */ import org.apache.poi.hssf.record.common.ExtendedColor;
/*    */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*    */ import org.apache.poi.ss.usermodel.CreationHelper;
/*    */ import org.apache.poi.ss.usermodel.DataFormat;
/*    */ import org.apache.poi.ss.usermodel.ExtendedColor;
/*    */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
/*    */ import org.apache.poi.ss.usermodel.Hyperlink;
/*    */ import org.apache.poi.ss.usermodel.RichTextString;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.util.Removal;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HSSFCreationHelper
/*    */   implements CreationHelper
/*    */ {
/*    */   private final HSSFWorkbook workbook;
/*    */   
/*    */   @Internal(since = "3.15 beta 3")
/*    */   HSSFCreationHelper(HSSFWorkbook paramHSSFWorkbook) {
/* 36 */     this.workbook = paramHSSFWorkbook;
/*    */   }
/*    */ 
/*    */   
/*    */   public HSSFRichTextString createRichTextString(String paramString) {
/* 41 */     return new HSSFRichTextString(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public HSSFDataFormat createDataFormat() {
/* 46 */     return this.workbook.createDataFormat();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   @Removal(version = "3.17")
/*    */   public HSSFHyperlink createHyperlink(int paramInt) {
/* 57 */     return new HSSFHyperlink(paramInt);
/*    */   }
/*    */   
/*    */   public HSSFHyperlink createHyperlink(HyperlinkType paramHyperlinkType) {
/* 61 */     return new HSSFHyperlink(paramHyperlinkType);
/*    */   }
/*    */ 
/*    */   
/*    */   public HSSFExtendedColor createExtendedColor() {
/* 66 */     return new HSSFExtendedColor(new ExtendedColor());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HSSFFormulaEvaluator createFormulaEvaluator() {
/* 76 */     return new HSSFFormulaEvaluator(this.workbook);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HSSFClientAnchor createClientAnchor() {
/* 87 */     return new HSSFClientAnchor();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFCreationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */