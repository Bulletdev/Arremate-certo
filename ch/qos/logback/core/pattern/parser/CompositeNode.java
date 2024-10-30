/*    */ package ch.qos.logback.core.pattern.parser;
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
/*    */ public class CompositeNode
/*    */   extends SimpleKeywordNode
/*    */ {
/*    */   Node childNode;
/*    */   
/*    */   CompositeNode(String paramString) {
/* 20 */     super(2, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public Node getChildNode() {
/* 25 */     return this.childNode;
/*    */   }
/*    */   
/*    */   public void setChildNode(Node paramNode) {
/* 29 */     this.childNode = paramNode;
/*    */   }
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 33 */     if (!super.equals(paramObject)) {
/* 34 */       return false;
/*    */     }
/* 36 */     if (!(paramObject instanceof CompositeNode)) {
/* 37 */       return false;
/*    */     }
/* 39 */     CompositeNode compositeNode = (CompositeNode)paramObject;
/*    */     
/* 41 */     return (this.childNode != null) ? this.childNode.equals(compositeNode.childNode) : ((compositeNode.childNode == null));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 46 */     return super.hashCode();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 50 */     StringBuilder stringBuilder = new StringBuilder();
/* 51 */     if (this.childNode != null) {
/* 52 */       stringBuilder.append("CompositeNode(" + this.childNode + ")");
/*    */     } else {
/* 54 */       stringBuilder.append("CompositeNode(no child)");
/*    */     } 
/* 56 */     stringBuilder.append(printNext());
/* 57 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\CompositeNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */