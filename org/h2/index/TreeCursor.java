/*     */ package org.h2.index;
/*     */ 
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TreeCursor
/*     */   implements Cursor
/*     */ {
/*     */   private final TreeIndex tree;
/*     */   private TreeNode node;
/*     */   private boolean beforeFirst;
/*     */   private final SearchRow first;
/*     */   private final SearchRow last;
/*     */   
/*     */   TreeCursor(TreeIndex paramTreeIndex, TreeNode paramTreeNode, SearchRow paramSearchRow1, SearchRow paramSearchRow2) {
/*  21 */     this.tree = paramTreeIndex;
/*  22 */     this.node = paramTreeNode;
/*  23 */     this.first = paramSearchRow1;
/*  24 */     this.last = paramSearchRow2;
/*  25 */     this.beforeFirst = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public Row get() {
/*  30 */     return (this.node == null) ? null : this.node.row;
/*     */   }
/*     */ 
/*     */   
/*     */   public SearchRow getSearchRow() {
/*  35 */     return (SearchRow)get();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean next() {
/*  40 */     if (this.beforeFirst) {
/*  41 */       this.beforeFirst = false;
/*  42 */       if (this.node == null) {
/*  43 */         return false;
/*     */       }
/*  45 */       if (this.first != null && this.tree.compareRows((SearchRow)this.node.row, this.first) < 0) {
/*  46 */         this.node = next(this.node);
/*     */       }
/*     */     } else {
/*  49 */       this.node = next(this.node);
/*     */     } 
/*  51 */     if (this.node != null && this.last != null && 
/*  52 */       this.tree.compareRows((SearchRow)this.node.row, this.last) > 0) {
/*  53 */       this.node = null;
/*     */     }
/*     */     
/*  56 */     return (this.node != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean previous() {
/*  61 */     this.node = previous(this.node);
/*  62 */     return (this.node != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static TreeNode next(TreeNode paramTreeNode) {
/*  72 */     if (paramTreeNode == null) {
/*  73 */       return null;
/*     */     }
/*  75 */     TreeNode treeNode1 = paramTreeNode.right;
/*  76 */     if (treeNode1 != null) {
/*  77 */       paramTreeNode = treeNode1;
/*  78 */       TreeNode treeNode = paramTreeNode.left;
/*  79 */       while (treeNode != null) {
/*  80 */         paramTreeNode = treeNode;
/*  81 */         treeNode = paramTreeNode.left;
/*     */       } 
/*  83 */       return paramTreeNode;
/*     */     } 
/*  85 */     TreeNode treeNode2 = paramTreeNode;
/*  86 */     paramTreeNode = paramTreeNode.parent;
/*  87 */     while (paramTreeNode != null && treeNode2 == paramTreeNode.right) {
/*  88 */       treeNode2 = paramTreeNode;
/*  89 */       paramTreeNode = paramTreeNode.parent;
/*     */     } 
/*  91 */     return paramTreeNode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static TreeNode previous(TreeNode paramTreeNode) {
/* 102 */     if (paramTreeNode == null) {
/* 103 */       return null;
/*     */     }
/* 105 */     TreeNode treeNode1 = paramTreeNode.left;
/* 106 */     if (treeNode1 != null) {
/* 107 */       paramTreeNode = treeNode1;
/* 108 */       TreeNode treeNode = paramTreeNode.right;
/* 109 */       while (treeNode != null) {
/* 110 */         paramTreeNode = treeNode;
/* 111 */         treeNode = paramTreeNode.right;
/*     */       } 
/* 113 */       return paramTreeNode;
/*     */     } 
/* 115 */     TreeNode treeNode2 = paramTreeNode;
/* 116 */     paramTreeNode = paramTreeNode.parent;
/* 117 */     while (paramTreeNode != null && treeNode2 == paramTreeNode.left) {
/* 118 */       treeNode2 = paramTreeNode;
/* 119 */       paramTreeNode = paramTreeNode.parent;
/*     */     } 
/* 121 */     return paramTreeNode;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\TreeCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */