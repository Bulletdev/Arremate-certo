/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NodeCachingLinkedList<E>
/*     */   extends AbstractLinkedList<E>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 6897789178562232073L;
/*     */   private static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;
/*     */   private transient AbstractLinkedList.Node<E> firstCachedNode;
/*     */   private transient int cacheSize;
/*     */   private int maximumCacheSize;
/*     */   
/*     */   public NodeCachingLinkedList() {
/*  74 */     this(20);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeCachingLinkedList(Collection<? extends E> paramCollection) {
/*  83 */     super(paramCollection);
/*  84 */     this.maximumCacheSize = 20;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeCachingLinkedList(int paramInt) {
/*  94 */     this.maximumCacheSize = paramInt;
/*  95 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getMaximumCacheSize() {
/* 105 */     return this.maximumCacheSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setMaximumCacheSize(int paramInt) {
/* 114 */     this.maximumCacheSize = paramInt;
/* 115 */     shrinkCacheToMaximumSize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void shrinkCacheToMaximumSize() {
/* 123 */     while (this.cacheSize > this.maximumCacheSize) {
/* 124 */       getNodeFromCache();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractLinkedList.Node<E> getNodeFromCache() {
/* 136 */     if (this.cacheSize == 0) {
/* 137 */       return null;
/*     */     }
/* 139 */     AbstractLinkedList.Node<E> node = this.firstCachedNode;
/* 140 */     this.firstCachedNode = node.next;
/* 141 */     node.next = null;
/*     */     
/* 143 */     this.cacheSize--;
/* 144 */     return node;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isCacheFull() {
/* 153 */     return (this.cacheSize >= this.maximumCacheSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addNodeToCache(AbstractLinkedList.Node<E> paramNode) {
/* 163 */     if (isCacheFull()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 168 */     AbstractLinkedList.Node<E> node = this.firstCachedNode;
/* 169 */     paramNode.previous = null;
/* 170 */     paramNode.next = node;
/* 171 */     paramNode.setValue(null);
/* 172 */     this.firstCachedNode = paramNode;
/* 173 */     this.cacheSize++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractLinkedList.Node<E> createNode(E paramE) {
/* 186 */     AbstractLinkedList.Node<E> node = getNodeFromCache();
/* 187 */     if (node == null) {
/* 188 */       return super.createNode(paramE);
/*     */     }
/* 190 */     node.setValue(paramE);
/* 191 */     return node;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeNode(AbstractLinkedList.Node<E> paramNode) {
/* 202 */     super.removeNode(paramNode);
/* 203 */     addNodeToCache(paramNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAllNodes() {
/* 217 */     int i = Math.min(this.size, this.maximumCacheSize - this.cacheSize);
/* 218 */     AbstractLinkedList.Node<E> node = this.header.next;
/* 219 */     for (byte b = 0; b < i; b++) {
/* 220 */       AbstractLinkedList.Node<E> node1 = node;
/* 221 */       node = node.next;
/* 222 */       addNodeToCache(node1);
/*     */     } 
/* 224 */     super.removeAllNodes();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 232 */     paramObjectOutputStream.defaultWriteObject();
/* 233 */     doWriteObject(paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 240 */     paramObjectInputStream.defaultReadObject();
/* 241 */     doReadObject(paramObjectInputStream);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\NodeCachingLinkedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */