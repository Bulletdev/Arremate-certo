/*    */ package org.apache.poi.xssf.streaming;
/*    */ 
/*    */ import org.apache.poi.common.usermodel.HyperlinkType;
/*    */ import org.apache.poi.ss.usermodel.ClientAnchor;
/*    */ import org.apache.poi.ss.usermodel.CreationHelper;
/*    */ import org.apache.poi.ss.usermodel.DataFormat;
/*    */ import org.apache.poi.ss.usermodel.ExtendedColor;
/*    */ import org.apache.poi.ss.usermodel.FormulaEvaluator;
/*    */ import org.apache.poi.ss.usermodel.Hyperlink;
/*    */ import org.apache.poi.ss.usermodel.RichTextString;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.util.POILogFactory;
/*    */ import org.apache.poi.util.POILogger;
/*    */ import org.apache.poi.util.Removal;
/*    */ import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
/*    */ import org.apache.poi.xssf.usermodel.XSSFRichTextString;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SXSSFCreationHelper
/*    */   implements CreationHelper
/*    */ {
/* 39 */   private static final POILogger logger = POILogFactory.getLogger(SXSSFCreationHelper.class);
/*    */ 
/*    */   
/*    */   private final SXSSFWorkbook wb;
/*    */ 
/*    */   
/*    */   private final XSSFCreationHelper helper;
/*    */ 
/*    */ 
/*    */   
/*    */   @Internal
/*    */   public SXSSFCreationHelper(SXSSFWorkbook paramSXSSFWorkbook) {
/* 51 */     this.helper = new XSSFCreationHelper(paramSXSSFWorkbook.getXSSFWorkbook());
/* 52 */     this.wb = paramSXSSFWorkbook;
/*    */   }
/*    */ 
/*    */   
/*    */   public XSSFRichTextString createRichTextString(String paramString) {
/* 57 */     logger.log(3, new Object[] { "SXSSF doesn't support Rich Text Strings, any formatting information will be lost" });
/* 58 */     return new XSSFRichTextString(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public SXSSFFormulaEvaluator createFormulaEvaluator() {
/* 63 */     return new SXSSFFormulaEvaluator(this.wb);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DataFormat createDataFormat() {
/* 69 */     return (DataFormat)this.helper.createDataFormat();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   @Removal(version = "3.17")
/*    */   public Hyperlink createHyperlink(int paramInt) {
/* 79 */     return (Hyperlink)this.helper.createHyperlink(paramInt);
/*    */   }
/*    */   
/*    */   public Hyperlink createHyperlink(HyperlinkType paramHyperlinkType) {
/* 83 */     return (Hyperlink)this.helper.createHyperlink(paramHyperlinkType);
/*    */   }
/*    */   
/*    */   public ExtendedColor createExtendedColor() {
/* 87 */     return (ExtendedColor)this.helper.createExtendedColor();
/*    */   }
/*    */   
/*    */   public ClientAnchor createClientAnchor() {
/* 91 */     return (ClientAnchor)this.helper.createClientAnchor();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xssf\streaming\SXSSFCreationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */