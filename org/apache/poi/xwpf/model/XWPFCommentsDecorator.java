/*    */ package org.apache.poi.xwpf.model;
/*    */ 
/*    */ import org.apache.poi.xwpf.usermodel.XWPFComment;
/*    */ import org.apache.poi.xwpf.usermodel.XWPFParagraph;
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
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
/*    */ public class XWPFCommentsDecorator
/*    */   extends XWPFParagraphDecorator
/*    */ {
/*    */   private StringBuffer commentText;
/*    */   
/*    */   public XWPFCommentsDecorator(XWPFParagraphDecorator paramXWPFParagraphDecorator) {
/* 33 */     this(paramXWPFParagraphDecorator.paragraph, paramXWPFParagraphDecorator);
/*    */   }
/*    */   
/*    */   public XWPFCommentsDecorator(XWPFParagraph paramXWPFParagraph, XWPFParagraphDecorator paramXWPFParagraphDecorator) {
/* 37 */     super(paramXWPFParagraph, paramXWPFParagraphDecorator);
/*    */ 
/*    */     
/* 40 */     this.commentText = new StringBuffer();
/*    */     
/* 42 */     for (CTMarkupRange cTMarkupRange : paramXWPFParagraph.getCTP().getCommentRangeStartArray()) {
/* 43 */       XWPFComment xWPFComment; if ((xWPFComment = paramXWPFParagraph.getDocument().getCommentByID(cTMarkupRange.getId().toString())) != null)
/* 44 */         this.commentText.append("\tComment by " + xWPFComment.getAuthor() + ": " + xWPFComment.getText()); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getCommentText() {
/* 49 */     return this.commentText.toString();
/*    */   }
/*    */   
/*    */   public String getText() {
/* 53 */     return super.getText() + this.commentText;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwpf\model\XWPFCommentsDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */