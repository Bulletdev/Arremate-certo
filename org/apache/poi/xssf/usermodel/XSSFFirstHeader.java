/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.Header;
/*    */ import org.apache.poi.xssf.usermodel.extensions.XSSFHeaderFooter;
/*    */ import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTHeaderFooter;
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
/*    */ 
/*    */ 
/*    */ public class XSSFFirstHeader
/*    */   extends XSSFHeaderFooter
/*    */   implements Header
/*    */ {
/*    */   protected XSSFFirstHeader(CTHeaderFooter paramCTHeaderFooter) {
/* 39 */     super(paramCTHeaderFooter);
/* 40 */     paramCTHeaderFooter.setDifferentFirst(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getText() {
/* 48 */     return getHeaderFooter().getFirstHeader();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setText(String paramString) {
/* 57 */     if (paramString == null) {
/* 58 */       getHeaderFooter().unsetFirstHeader();
/*    */     } else {
/* 60 */       getHeaderFooter().setFirstHeader(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFFirstHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */