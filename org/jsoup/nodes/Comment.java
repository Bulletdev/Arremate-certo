/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Comment
/*    */   extends Node
/*    */ {
/*    */   private static final String COMMENT_KEY = "comment";
/*    */   
/*    */   public Comment(String paramString1, String paramString2) {
/* 16 */     super(paramString2);
/* 17 */     this.attributes.put("comment", paramString1);
/*    */   }
/*    */   
/*    */   public String nodeName() {
/* 21 */     return "#comment";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getData() {
/* 29 */     return this.attributes.get("comment");
/*    */   }
/*    */   
/*    */   void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 33 */     if (paramOutputSettings.prettyPrint())
/* 34 */       indent(paramStringBuilder, paramInt, paramOutputSettings); 
/* 35 */     paramStringBuilder.append("<!--").append(getData()).append("-->");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*    */ 
/*    */   
/*    */   public String toString() {
/* 44 */     return outerHtml();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\Comment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */