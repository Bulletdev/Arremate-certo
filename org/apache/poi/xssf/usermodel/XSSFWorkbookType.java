/*    */ package org.apache.poi.xssf.usermodel;
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
/*    */ public enum XSSFWorkbookType
/*    */ {
/* 26 */   XLSX(XSSFRelation.WORKBOOK.getContentType(), "xlsx"),
/* 27 */   XLSM(XSSFRelation.MACROS_WORKBOOK.getContentType(), "xlsm");
/*    */   
/*    */   private final String _contentType;
/*    */   private final String _extension;
/*    */   
/*    */   XSSFWorkbookType(String paramString1, String paramString2) {
/* 33 */     this._contentType = paramString1;
/* 34 */     this._extension = paramString2;
/*    */   }
/*    */   
/*    */   public String getContentType() {
/* 38 */     return this._contentType;
/*    */   }
/*    */   
/*    */   public String getExtension() {
/* 42 */     return this._extension;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFWorkbookType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */