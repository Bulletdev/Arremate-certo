/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
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
/*    */ public class XWPFDefaultRunStyle
/*    */ {
/*    */   private CTRPr rpr;
/*    */   
/*    */   public XWPFDefaultRunStyle(CTRPr paramCTRPr) {
/* 30 */     this.rpr = paramCTRPr;
/*    */   }
/*    */   
/*    */   protected CTRPr getRPr() {
/* 34 */     return this.rpr;
/*    */   }
/*    */   
/*    */   public int getFontSize() {
/* 38 */     if (this.rpr.isSetSz())
/* 39 */       return this.rpr.getSz().getVal().intValue() / 2; 
/* 40 */     return -1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFDefaultRunStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */