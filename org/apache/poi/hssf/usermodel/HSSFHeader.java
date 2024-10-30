/*    */ package org.apache.poi.hssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.hssf.record.HeaderRecord;
/*    */ import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
/*    */ import org.apache.poi.ss.usermodel.Header;
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
/*    */ 
/*    */ public final class HSSFHeader
/*    */   extends HeaderFooter
/*    */   implements Header
/*    */ {
/*    */   private final PageSettingsBlock _psb;
/*    */   
/*    */   protected HSSFHeader(PageSettingsBlock paramPageSettingsBlock) {
/* 39 */     this._psb = paramPageSettingsBlock;
/*    */   }
/*    */   
/*    */   protected String getRawText() {
/* 43 */     HeaderRecord headerRecord = this._psb.getHeader();
/* 44 */     if (headerRecord == null) {
/* 45 */       return "";
/*    */     }
/* 47 */     return headerRecord.getText();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setHeaderFooterText(String paramString) {
/* 52 */     HeaderRecord headerRecord = this._psb.getHeader();
/* 53 */     if (headerRecord == null) {
/* 54 */       headerRecord = new HeaderRecord(paramString);
/* 55 */       this._psb.setHeader(headerRecord);
/*    */     } else {
/* 57 */       headerRecord.setText(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */