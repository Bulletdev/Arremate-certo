/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
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
/*    */ public class XWPFDefaultParagraphStyle
/*    */ {
/*    */   private CTPPr ppr;
/*    */   
/*    */   public XWPFDefaultParagraphStyle(CTPPr paramCTPPr) {
/* 30 */     this.ppr = paramCTPPr;
/*    */   }
/*    */   
/*    */   protected CTPPr getPPr() {
/* 34 */     return this.ppr;
/*    */   }
/*    */   
/*    */   public int getSpacingAfter() {
/* 38 */     if (this.ppr.isSetSpacing())
/* 39 */       return this.ppr.getSpacing().getAfter().intValue(); 
/* 40 */     return -1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFDefaultParagraphStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */