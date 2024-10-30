/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.hssf.record.FooterRecord;
/*    */ import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
/*    */ import org.apache.poi.ss.usermodel.Footer;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class HSSFFooter
/*    */   extends HeaderFooter
/*    */   implements Footer
/*    */ {
/*    */   private final PageSettingsBlock _psb;
/*    */   
/*    */   protected HSSFFooter(PageSettingsBlock paramPageSettingsBlock) {
/* 38 */     this._psb = paramPageSettingsBlock;
/*    */   }
/*    */   
/*    */   protected String getRawText() {
/* 42 */     FooterRecord footerRecord = this._psb.getFooter();
/* 43 */     if (footerRecord == null) {
/* 44 */       return "";
/*    */     }
/* 46 */     return footerRecord.getText();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setHeaderFooterText(String paramString) {
/* 51 */     FooterRecord footerRecord = this._psb.getFooter();
/* 52 */     if (footerRecord == null) {
/* 53 */       footerRecord = new FooterRecord(paramString);
/* 54 */       this._psb.setFooter(footerRecord);
/*    */     } else {
/* 56 */       footerRecord.setText(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */