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
/*    */ 
/*    */ public class XSSFEvenFooter
/*    */   extends XSSFHeaderFooter
/*    */   implements Footer
/*    */ {
/*    */   public XSSFEvenFooter(CTHeaderFooter paramCTHeaderFooter) {
/* 40 */     super(paramCTHeaderFooter);
/* 41 */     paramCTHeaderFooter.setDifferentOddEven(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getText() {
/* 49 */     return getHeaderFooter().getEvenFooter();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setText(String paramString) {
/* 58 */     if (paramString == null) {
/* 59 */       getHeaderFooter().unsetEvenFooter();
/*    */     } else {
/* 61 */       getHeaderFooter().setEvenFooter(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFEvenFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */