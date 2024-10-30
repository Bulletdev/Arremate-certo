/*    */ package org.apache.poi.xwpf.model;
/*    */ 
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
/*    */ public class XMLParagraph
/*    */ {
/*    */   protected CTP paragraph;
/*    */   
/*    */   public XMLParagraph(CTP paramCTP) {
/* 30 */     this.paragraph = paramCTP;
/*    */   }
/*    */   
/*    */   public CTP getCTP() {
/* 34 */     return this.paragraph;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwpf\model\XMLParagraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */