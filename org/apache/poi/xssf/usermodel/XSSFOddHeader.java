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
/*    */ public class XSSFOddHeader
/*    */   extends XSSFHeaderFooter
/*    */   implements Header
/*    */ {
/*    */   protected XSSFOddHeader(CTHeaderFooter paramCTHeaderFooter) {
/* 38 */     super(paramCTHeaderFooter);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getText() {
/* 46 */     return getHeaderFooter().getOddHeader();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setText(String paramString) {
/* 55 */     if (paramString == null) {
/* 56 */       getHeaderFooter().unsetOddHeader();
/*    */     } else {
/* 58 */       getHeaderFooter().setOddHeader(paramString);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\XSSFOddHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */