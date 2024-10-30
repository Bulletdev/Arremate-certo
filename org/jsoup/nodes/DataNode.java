/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataNode
/*    */   extends Node
/*    */ {
/*    */   private static final String DATA_KEY = "data";
/*    */   
/*    */   public DataNode(String paramString1, String paramString2) {
/* 16 */     super(paramString2);
/* 17 */     this.attributes.put("data", paramString1);
/*    */   }
/*    */   
/*    */   public String nodeName() {
/* 21 */     return "#data";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getWholeData() {
/* 29 */     return this.attributes.get("data");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataNode setWholeData(String paramString) {
/* 38 */     this.attributes.put("data", paramString);
/* 39 */     return this;
/*    */   }
/*    */   
/*    */   void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 43 */     paramStringBuilder.append(getWholeData());
/*    */   }
/*    */   
/*    */   void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*    */   
/*    */   public String toString() {
/* 49 */     return outerHtml();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static DataNode createFromEncoded(String paramString1, String paramString2) {
/* 59 */     String str = Entities.unescape(paramString1);
/* 60 */     return new DataNode(str, paramString2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\DataNode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */