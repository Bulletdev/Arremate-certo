/*    */ package org.h2.index;
/*    */ 
/*    */ import org.h2.result.Row;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TreeNode
/*    */ {
/*    */   int balance;
/*    */   TreeNode left;
/*    */   TreeNode right;
/*    */   TreeNode parent;
/*    */   final Row row;
/*    */   
/*    */   TreeNode(Row paramRow) {
/* 41 */     this.row = paramRow;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean isFromLeft() {
/* 51 */     return (this.parent == null || this.parent.left == this);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\TreeNode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */