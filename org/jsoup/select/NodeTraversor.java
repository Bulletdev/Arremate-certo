/*    */ package org.jsoup.select;
/*    */ 
/*    */ import org.jsoup.nodes.Node;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeTraversor
/*    */ {
/*    */   private NodeVisitor visitor;
/*    */   
/*    */   public NodeTraversor(NodeVisitor paramNodeVisitor) {
/* 18 */     this.visitor = paramNodeVisitor;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void traverse(Node paramNode) {
/* 26 */     Node node = paramNode;
/* 27 */     byte b = 0;
/*    */     
/* 29 */     while (node != null) {
/* 30 */       this.visitor.head(node, b);
/* 31 */       if (node.childNodeSize() > 0) {
/* 32 */         node = node.childNode(0);
/* 33 */         b++; continue;
/*    */       } 
/* 35 */       while (node.nextSibling() == null && b > 0) {
/* 36 */         this.visitor.tail(node, b);
/* 37 */         node = node.parentNode();
/* 38 */         b--;
/*    */       } 
/* 40 */       this.visitor.tail(node, b);
/* 41 */       if (node == paramNode)
/*    */         break; 
/* 43 */       node = node.nextSibling();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\select\NodeTraversor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */