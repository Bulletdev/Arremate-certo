/*    */ package org.apache.poi.xwpf.model;
/*    */ 
/*    */ import org.apache.poi.xwpf.usermodel.XWPFParagraph;
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
/*    */ public abstract class XWPFParagraphDecorator
/*    */ {
/*    */   protected XWPFParagraph paragraph;
/*    */   protected XWPFParagraphDecorator nextDecorator;
/*    */   
/*    */   public XWPFParagraphDecorator(XWPFParagraph paramXWPFParagraph) {
/* 29 */     this(paramXWPFParagraph, null);
/*    */   }
/*    */   
/*    */   public XWPFParagraphDecorator(XWPFParagraph paramXWPFParagraph, XWPFParagraphDecorator paramXWPFParagraphDecorator) {
/* 33 */     this.paragraph = paramXWPFParagraph;
/* 34 */     this.nextDecorator = paramXWPFParagraphDecorator;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 38 */     if (this.nextDecorator != null) {
/* 39 */       return this.nextDecorator.getText();
/*    */     }
/* 41 */     return this.paragraph.getText();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwpf\model\XWPFParagraphDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */