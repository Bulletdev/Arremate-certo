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
/*    */ public class XSSFOddFooter
/*    */   extends XSSFHeaderFooter
/*    */   implements Footer
/*    */ {
/*    */   public XSSFOddFooter(CTHeaderFooter paramCTHeaderFooter) {
/* 38 */     super(paramCTHeaderFooter);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getText() {
/* 46 */     return getHeaderFooter().getOddFooter();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setText(String paramString) {
/* 55 */     if (paramString == null) {
/* 56 */       getHeaderFooter().unsetOddFooter();
/*    */     } else {
/* 58 */       getHeaderFooter().setOddFooter(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFOddFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */