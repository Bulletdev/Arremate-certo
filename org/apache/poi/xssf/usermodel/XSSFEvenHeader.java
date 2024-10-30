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
/*    */ 
/*    */ 
/*    */ public class XSSFEvenHeader
/*    */   extends XSSFHeaderFooter
/*    */   implements Header
/*    */ {
/*    */   public XSSFEvenHeader(CTHeaderFooter paramCTHeaderFooter) {
/* 41 */     super(paramCTHeaderFooter);
/* 42 */     paramCTHeaderFooter.setDifferentOddEven(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getText() {
/* 50 */     return getHeaderFooter().getEvenHeader();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setText(String paramString) {
/* 59 */     if (paramString == null) {
/* 60 */       getHeaderFooter().unsetEvenHeader();
/*    */     } else {
/* 62 */       getHeaderFooter().setEvenHeader(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFEvenHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */