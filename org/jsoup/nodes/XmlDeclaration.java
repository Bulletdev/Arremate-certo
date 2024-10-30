/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlDeclaration
/*    */   extends Node
/*    */ {
/*    */   private static final String DECL_KEY = "declaration";
/*    */   private final boolean isProcessingInstruction;
/*    */   
/*    */   public XmlDeclaration(String paramString1, String paramString2, boolean paramBoolean) {
/* 18 */     super(paramString2);
/* 19 */     this.attributes.put("declaration", paramString1);
/* 20 */     this.isProcessingInstruction = paramBoolean;
/*    */   }
/*    */   
/*    */   public String nodeName() {
/* 24 */     return "#declaration";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getWholeDeclaration() {
/* 32 */     return this.attributes.get("declaration");
/*    */   }
/*    */   
/*    */   void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 36 */     paramStringBuilder.append("<").append(this.isProcessingInstruction ? "!" : "?").append(getWholeDeclaration()).append(">");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 46 */     return outerHtml();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\XmlDeclaration.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */