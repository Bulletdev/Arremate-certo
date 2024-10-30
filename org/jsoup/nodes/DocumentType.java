/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ import org.jsoup.helper.StringUtil;
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
/*    */ public class DocumentType
/*    */   extends Node
/*    */ {
/*    */   public DocumentType(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 20 */     super(paramString4);
/*    */     
/* 22 */     attr("name", paramString1);
/* 23 */     attr("publicId", paramString2);
/* 24 */     attr("systemId", paramString3);
/*    */   }
/*    */ 
/*    */   
/*    */   public String nodeName() {
/* 29 */     return "#doctype";
/*    */   }
/*    */ 
/*    */   
/*    */   void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 34 */     paramStringBuilder.append("<!DOCTYPE");
/* 35 */     if (!StringUtil.isBlank(attr("name")))
/* 36 */       paramStringBuilder.append(" ").append(attr("name")); 
/* 37 */     if (!StringUtil.isBlank(attr("publicId")))
/* 38 */       paramStringBuilder.append(" PUBLIC \"").append(attr("publicId")).append('"'); 
/* 39 */     if (!StringUtil.isBlank(attr("systemId")))
/* 40 */       paramStringBuilder.append(" \"").append(attr("systemId")).append('"'); 
/* 41 */     paramStringBuilder.append('>');
/*    */   }
/*    */   
/*    */   void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\DocumentType.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */