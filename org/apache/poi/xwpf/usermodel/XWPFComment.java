/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTComment;
/*    */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
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
/*    */ public class XWPFComment
/*    */ {
/*    */   protected String id;
/*    */   protected String author;
/*    */   protected StringBuffer text;
/*    */   
/*    */   public XWPFComment(CTComment paramCTComment, XWPFDocument paramXWPFDocument) {
/* 33 */     this.text = new StringBuffer();
/* 34 */     this.id = paramCTComment.getId().toString();
/* 35 */     this.author = paramCTComment.getAuthor();
/*    */     
/* 37 */     for (CTP cTP : paramCTComment.getPArray()) {
/* 38 */       XWPFParagraph xWPFParagraph = new XWPFParagraph(cTP, paramXWPFDocument);
/* 39 */       this.text.append(xWPFParagraph.getText());
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getId() {
/* 44 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getAuthor() {
/* 48 */     return this.author;
/*    */   }
/*    */   
/*    */   public String getText() {
/* 52 */     return this.text.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */