/*    */ package org.apache.poi.xssf.usermodel;
/*    */ 
/*    */ import org.apache.poi.ss.usermodel.Footer;
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
/*    */ public class XSSFFirstFooter
/*    */   extends XSSFHeaderFooter
/*    */   implements Footer
/*    */ {
/*    */   protected XSSFFirstFooter(CTHeaderFooter paramCTHeaderFooter) {
/* 39 */     super(paramCTHeaderFooter);
/* 40 */     paramCTHeaderFooter.setDifferentFirst(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getText() {
/* 48 */     return getHeaderFooter().getFirstFooter();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setText(String paramString) {
/* 57 */     if (paramString == null) {
/* 58 */       getHeaderFooter().unsetFirstFooter();
/*    */     } else {
/* 60 */       getHeaderFooter().setFirstFooter(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFFirstFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */