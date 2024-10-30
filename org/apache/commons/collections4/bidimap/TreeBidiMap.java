/*      */ package org.apache.commons.collections4.bidimap;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.Collection;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.collections4.BidiMap;
/*      */ import org.apache.commons.collections4.KeyValue;
/*      */ import org.apache.commons.collections4.MapIterator;
/*      */ import org.apache.commons.collections4.OrderedBidiMap;
/*      */ import org.apache.commons.collections4.OrderedIterator;
/*      */ import org.apache.commons.collections4.OrderedMapIterator;
/*      */ import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
/*      */ import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TreeBidiMap<K extends Comparable<K>, V extends Comparable<V>>
/*      */   implements Serializable, OrderedBidiMap<K, V>
/*      */ {
/*      */   private static final long serialVersionUID = 721969328361807L;
/*      */   private transient Node<K, V>[] rootNode;
/*      */   
/*      */   enum DataElement
/*      */   {
/*   82 */     KEY("key"), VALUE("value");
/*      */ 
/*      */ 
/*      */     
/*      */     private final String description;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     DataElement(String param1String1) {
/*   92 */       this.description = param1String1;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*   97 */       return this.description;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  104 */   private transient int nodeCount = 0;
/*  105 */   private transient int modifications = 0;
/*      */   private transient Set<K> keySet;
/*      */   private transient Set<V> valuesSet;
/*      */   private transient Set<Map.Entry<K, V>> entrySet;
/*  109 */   private transient Inverse inverse = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TreeBidiMap() {
/*  118 */     this.rootNode = (Node<K, V>[])new Node[2];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TreeBidiMap(Map<? extends K, ? extends V> paramMap) {
/*  130 */     this();
/*  131 */     putAll(paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  142 */     return this.nodeCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  152 */     return (this.nodeCount == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsKey(Object paramObject) {
/*  167 */     checkKey(paramObject);
/*  168 */     return (lookupKey(paramObject) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsValue(Object paramObject) {
/*  183 */     checkValue(paramObject);
/*  184 */     return (lookupValue(paramObject) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V get(Object paramObject) {
/*  201 */     checkKey(paramObject);
/*  202 */     Node<K, V> node = lookupKey(paramObject);
/*  203 */     return (node == null) ? null : node.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V put(K paramK, V paramV) {
/*  232 */     V v = get(paramK);
/*  233 */     doPut(paramK, paramV);
/*  234 */     return v;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*  246 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/*  247 */       put((K)entry.getKey(), (V)entry.getValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V remove(Object paramObject) {
/*  264 */     return doRemoveKey(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  272 */     modify();
/*      */     
/*  274 */     this.nodeCount = 0;
/*  275 */     this.rootNode[DataElement.KEY.ordinal()] = null;
/*  276 */     this.rootNode[DataElement.VALUE.ordinal()] = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K getKey(Object paramObject) {
/*  294 */     checkValue(paramObject);
/*  295 */     Node<K, V> node = lookupValue(paramObject);
/*  296 */     return (node == null) ? null : node.getKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K removeValue(Object paramObject) {
/*  312 */     return doRemoveValue(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K firstKey() {
/*  324 */     if (this.nodeCount == 0) {
/*  325 */       throw new NoSuchElementException("Map is empty");
/*      */     }
/*  327 */     return leastNode(this.rootNode[DataElement.KEY.ordinal()], DataElement.KEY).getKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K lastKey() {
/*  338 */     if (this.nodeCount == 0) {
/*  339 */       throw new NoSuchElementException("Map is empty");
/*      */     }
/*  341 */     return greatestNode(this.rootNode[DataElement.KEY.ordinal()], DataElement.KEY).getKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K nextKey(K paramK) {
/*  354 */     checkKey(paramK);
/*  355 */     Node<K, V> node = nextGreater(lookupKey(paramK), DataElement.KEY);
/*  356 */     return (node == null) ? null : node.getKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K previousKey(K paramK) {
/*  369 */     checkKey(paramK);
/*  370 */     Node<K, V> node = nextSmaller(lookupKey(paramK), DataElement.KEY);
/*  371 */     return (node == null) ? null : node.getKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<K> keySet() {
/*  389 */     if (this.keySet == null) {
/*  390 */       this.keySet = new KeyView(DataElement.KEY);
/*      */     }
/*  392 */     return this.keySet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<V> values() {
/*  411 */     if (this.valuesSet == null) {
/*  412 */       this.valuesSet = new ValueView(DataElement.KEY);
/*      */     }
/*  414 */     return this.valuesSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<Map.Entry<K, V>> entrySet() {
/*  434 */     if (this.entrySet == null) {
/*  435 */       this.entrySet = new EntryView();
/*      */     }
/*  437 */     return this.entrySet;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public OrderedMapIterator<K, V> mapIterator() {
/*  443 */     if (isEmpty()) {
/*  444 */       return EmptyOrderedMapIterator.emptyOrderedMapIterator();
/*      */     }
/*  446 */     return new ViewMapIterator(DataElement.KEY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public OrderedBidiMap<V, K> inverseBidiMap() {
/*  457 */     if (this.inverse == null) {
/*  458 */       this.inverse = new Inverse();
/*      */     }
/*  460 */     return this.inverse;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/*  472 */     return doEquals(paramObject, DataElement.KEY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  482 */     return doHashCode(DataElement.KEY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  492 */     return doToString(DataElement.KEY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doPut(K paramK, V paramV) {
/*  503 */     checkKeyAndValue(paramK, paramV);
/*      */ 
/*      */     
/*  506 */     doRemoveKey(paramK);
/*  507 */     doRemoveValue(paramV);
/*      */     
/*  509 */     Node<K, V> node = this.rootNode[DataElement.KEY.ordinal()];
/*  510 */     if (node == null) {
/*      */       
/*  512 */       Node<K, V> node1 = new Node<K, V>(paramK, paramV);
/*  513 */       this.rootNode[DataElement.KEY.ordinal()] = node1;
/*  514 */       this.rootNode[DataElement.VALUE.ordinal()] = node1;
/*  515 */       grow();
/*      */     } else {
/*      */       
/*      */       while (true) {
/*      */         
/*  520 */         int i = compare(paramK, node.getKey());
/*      */         
/*  522 */         if (i == 0)
/*      */         {
/*  524 */           throw new IllegalArgumentException("Cannot store a duplicate key (\"" + paramK + "\") in this Map"); } 
/*  525 */         if (i < 0) {
/*  526 */           if (node.getLeft(DataElement.KEY) != null) {
/*  527 */             node = node.getLeft(DataElement.KEY); continue;
/*      */           } 
/*  529 */           Node<K, V> node2 = new Node<K, V>(paramK, paramV);
/*      */           
/*  531 */           insertValue(node2);
/*  532 */           node.setLeft(node2, DataElement.KEY);
/*  533 */           node2.setParent(node, DataElement.KEY);
/*  534 */           doRedBlackInsert(node2, DataElement.KEY);
/*  535 */           grow();
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/*  540 */         if (node.getRight(DataElement.KEY) != null) {
/*  541 */           node = node.getRight(DataElement.KEY); continue;
/*      */         } 
/*  543 */         Node<K, V> node1 = new Node<K, V>(paramK, paramV);
/*      */         
/*  545 */         insertValue(node1);
/*  546 */         node.setRight(node1, DataElement.KEY);
/*  547 */         node1.setParent(node, DataElement.KEY);
/*  548 */         doRedBlackInsert(node1, DataElement.KEY);
/*  549 */         grow();
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private V doRemoveKey(Object paramObject) {
/*  559 */     Node<K, V> node = lookupKey(paramObject);
/*  560 */     if (node == null) {
/*  561 */       return null;
/*      */     }
/*  563 */     doRedBlackDelete(node);
/*  564 */     return node.getValue();
/*      */   }
/*      */   
/*      */   private K doRemoveValue(Object paramObject) {
/*  568 */     Node<K, V> node = lookupValue(paramObject);
/*  569 */     if (node == null) {
/*  570 */       return null;
/*      */     }
/*  572 */     doRedBlackDelete(node);
/*  573 */     return node.getKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private <T extends Comparable<T>> Node<K, V> lookup(Object paramObject, DataElement paramDataElement) {
/*  586 */     Node<K, V> node1 = null;
/*  587 */     Node<K, V> node2 = this.rootNode[paramDataElement.ordinal()];
/*      */     
/*  589 */     while (node2 != null) {
/*  590 */       int i = compare((Comparable)paramObject, (Comparable)node2.getData(paramDataElement));
/*  591 */       if (i == 0) {
/*  592 */         node1 = node2;
/*      */         break;
/*      */       } 
/*  595 */       node2 = (i < 0) ? node2.getLeft(paramDataElement) : node2.getRight(paramDataElement);
/*      */     } 
/*      */ 
/*      */     
/*  599 */     return node1;
/*      */   }
/*      */   
/*      */   private Node<K, V> lookupKey(Object paramObject) {
/*  603 */     return lookup(paramObject, DataElement.KEY);
/*      */   }
/*      */   
/*      */   private Node<K, V> lookupValue(Object paramObject) {
/*  607 */     return lookup(paramObject, DataElement.VALUE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Node<K, V> nextGreater(Node<K, V> paramNode, DataElement paramDataElement) {
/*      */     Node<K, V> node;
/*  619 */     if (paramNode == null) {
/*  620 */       node = null;
/*  621 */     } else if (paramNode.getRight(paramDataElement) != null) {
/*      */ 
/*      */       
/*  624 */       node = leastNode(paramNode.getRight(paramDataElement), paramDataElement);
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */       
/*  632 */       Node<K, V> node1 = paramNode.getParent(paramDataElement);
/*  633 */       Node<K, V> node2 = paramNode;
/*      */       
/*  635 */       while (node1 != null && node2 == node1.getRight(paramDataElement)) {
/*  636 */         node2 = node1;
/*  637 */         node1 = node1.getParent(paramDataElement);
/*      */       } 
/*  639 */       node = node1;
/*      */     } 
/*  641 */     return node;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Node<K, V> nextSmaller(Node<K, V> paramNode, DataElement paramDataElement) {
/*      */     Node<K, V> node;
/*  653 */     if (paramNode == null) {
/*  654 */       node = null;
/*  655 */     } else if (paramNode.getLeft(paramDataElement) != null) {
/*      */ 
/*      */       
/*  658 */       node = greatestNode(paramNode.getLeft(paramDataElement), paramDataElement);
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */ 
/*      */       
/*  666 */       Node<K, V> node1 = paramNode.getParent(paramDataElement);
/*  667 */       Node<K, V> node2 = paramNode;
/*      */       
/*  669 */       while (node1 != null && node2 == node1.getLeft(paramDataElement)) {
/*  670 */         node2 = node1;
/*  671 */         node1 = node1.getParent(paramDataElement);
/*      */       } 
/*  673 */       node = node1;
/*      */     } 
/*  675 */     return node;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T extends Comparable<T>> int compare(T paramT1, T paramT2) {
/*  690 */     return paramT1.compareTo(paramT2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Node<K, V> leastNode(Node<K, V> paramNode, DataElement paramDataElement) {
/*  702 */     Node<K, V> node = paramNode;
/*  703 */     if (node != null) {
/*  704 */       while (node.getLeft(paramDataElement) != null) {
/*  705 */         node = node.getLeft(paramDataElement);
/*      */       }
/*      */     }
/*  708 */     return node;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Node<K, V> greatestNode(Node<K, V> paramNode, DataElement paramDataElement) {
/*  719 */     Node<K, V> node = paramNode;
/*  720 */     if (node != null) {
/*  721 */       while (node.getRight(paramDataElement) != null) {
/*  722 */         node = node.getRight(paramDataElement);
/*      */       }
/*      */     }
/*  725 */     return node;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void copyColor(Node<K, V> paramNode1, Node<K, V> paramNode2, DataElement paramDataElement) {
/*  737 */     if (paramNode2 != null) {
/*  738 */       if (paramNode1 == null) {
/*      */         
/*  740 */         paramNode2.setBlack(paramDataElement);
/*      */       } else {
/*  742 */         paramNode2.copyColor(paramNode1, paramDataElement);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isRed(Node<?, ?> paramNode, DataElement paramDataElement) {
/*  755 */     return (paramNode != null && paramNode.isRed(paramDataElement));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isBlack(Node<?, ?> paramNode, DataElement paramDataElement) {
/*  766 */     return (paramNode == null || paramNode.isBlack(paramDataElement));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void makeRed(Node<?, ?> paramNode, DataElement paramDataElement) {
/*  776 */     if (paramNode != null) {
/*  777 */       paramNode.setRed(paramDataElement);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void makeBlack(Node<?, ?> paramNode, DataElement paramDataElement) {
/*  788 */     if (paramNode != null) {
/*  789 */       paramNode.setBlack(paramDataElement);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Node<K, V> getGrandParent(Node<K, V> paramNode, DataElement paramDataElement) {
/*  801 */     return getParent(getParent(paramNode, paramDataElement), paramDataElement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Node<K, V> getParent(Node<K, V> paramNode, DataElement paramDataElement) {
/*  812 */     return (paramNode == null) ? null : paramNode.getParent(paramDataElement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Node<K, V> getRightChild(Node<K, V> paramNode, DataElement paramDataElement) {
/*  823 */     return (paramNode == null) ? null : paramNode.getRight(paramDataElement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Node<K, V> getLeftChild(Node<K, V> paramNode, DataElement paramDataElement) {
/*  834 */     return (paramNode == null) ? null : paramNode.getLeft(paramDataElement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void rotateLeft(Node<K, V> paramNode, DataElement paramDataElement) {
/*  844 */     Node<K, V> node = paramNode.getRight(paramDataElement);
/*  845 */     paramNode.setRight(node.getLeft(paramDataElement), paramDataElement);
/*      */     
/*  847 */     if (node.getLeft(paramDataElement) != null) {
/*  848 */       node.getLeft(paramDataElement).setParent(paramNode, paramDataElement);
/*      */     }
/*  850 */     node.setParent(paramNode.getParent(paramDataElement), paramDataElement);
/*      */     
/*  852 */     if (paramNode.getParent(paramDataElement) == null) {
/*      */       
/*  854 */       this.rootNode[paramDataElement.ordinal()] = node;
/*  855 */     } else if (paramNode.getParent(paramDataElement).getLeft(paramDataElement) == paramNode) {
/*  856 */       paramNode.getParent(paramDataElement).setLeft(node, paramDataElement);
/*      */     } else {
/*  858 */       paramNode.getParent(paramDataElement).setRight(node, paramDataElement);
/*      */     } 
/*      */     
/*  861 */     node.setLeft(paramNode, paramDataElement);
/*  862 */     paramNode.setParent(node, paramDataElement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void rotateRight(Node<K, V> paramNode, DataElement paramDataElement) {
/*  872 */     Node<K, V> node = paramNode.getLeft(paramDataElement);
/*  873 */     paramNode.setLeft(node.getRight(paramDataElement), paramDataElement);
/*  874 */     if (node.getRight(paramDataElement) != null) {
/*  875 */       node.getRight(paramDataElement).setParent(paramNode, paramDataElement);
/*      */     }
/*  877 */     node.setParent(paramNode.getParent(paramDataElement), paramDataElement);
/*      */     
/*  879 */     if (paramNode.getParent(paramDataElement) == null) {
/*      */       
/*  881 */       this.rootNode[paramDataElement.ordinal()] = node;
/*  882 */     } else if (paramNode.getParent(paramDataElement).getRight(paramDataElement) == paramNode) {
/*  883 */       paramNode.getParent(paramDataElement).setRight(node, paramDataElement);
/*      */     } else {
/*  885 */       paramNode.getParent(paramDataElement).setLeft(node, paramDataElement);
/*      */     } 
/*      */     
/*  888 */     node.setRight(paramNode, paramDataElement);
/*  889 */     paramNode.setParent(node, paramDataElement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doRedBlackInsert(Node<K, V> paramNode, DataElement paramDataElement) {
/*  900 */     Node<K, V> node = paramNode;
/*  901 */     makeRed(node, paramDataElement);
/*      */     
/*  903 */     while (node != null && node != this.rootNode[paramDataElement.ordinal()] && isRed(node.getParent(paramDataElement), paramDataElement)) {
/*      */ 
/*      */       
/*  906 */       if (node.isLeftChild(paramDataElement)) {
/*  907 */         Node<K, V> node2 = getRightChild(getGrandParent(node, paramDataElement), paramDataElement);
/*      */         
/*  909 */         if (isRed(node2, paramDataElement)) {
/*  910 */           makeBlack(getParent(node, paramDataElement), paramDataElement);
/*  911 */           makeBlack(node2, paramDataElement);
/*  912 */           makeRed(getGrandParent(node, paramDataElement), paramDataElement);
/*      */           
/*  914 */           node = getGrandParent(node, paramDataElement);
/*      */           continue;
/*      */         } 
/*  917 */         if (node.isRightChild(paramDataElement)) {
/*  918 */           node = getParent(node, paramDataElement);
/*      */           
/*  920 */           rotateLeft(node, paramDataElement);
/*      */         } 
/*      */         
/*  923 */         makeBlack(getParent(node, paramDataElement), paramDataElement);
/*  924 */         makeRed(getGrandParent(node, paramDataElement), paramDataElement);
/*      */         
/*  926 */         if (getGrandParent(node, paramDataElement) != null) {
/*  927 */           rotateRight(getGrandParent(node, paramDataElement), paramDataElement);
/*      */         }
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  933 */       Node<K, V> node1 = getLeftChild(getGrandParent(node, paramDataElement), paramDataElement);
/*      */       
/*  935 */       if (isRed(node1, paramDataElement)) {
/*  936 */         makeBlack(getParent(node, paramDataElement), paramDataElement);
/*  937 */         makeBlack(node1, paramDataElement);
/*  938 */         makeRed(getGrandParent(node, paramDataElement), paramDataElement);
/*      */         
/*  940 */         node = getGrandParent(node, paramDataElement);
/*      */         continue;
/*      */       } 
/*  943 */       if (node.isLeftChild(paramDataElement)) {
/*  944 */         node = getParent(node, paramDataElement);
/*      */         
/*  946 */         rotateRight(node, paramDataElement);
/*      */       } 
/*      */       
/*  949 */       makeBlack(getParent(node, paramDataElement), paramDataElement);
/*  950 */       makeRed(getGrandParent(node, paramDataElement), paramDataElement);
/*      */       
/*  952 */       if (getGrandParent(node, paramDataElement) != null) {
/*  953 */         rotateLeft(getGrandParent(node, paramDataElement), paramDataElement);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  959 */     makeBlack(this.rootNode[paramDataElement.ordinal()], paramDataElement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doRedBlackDelete(Node<K, V> paramNode) {
/*  969 */     for (DataElement dataElement : DataElement.values()) {
/*      */ 
/*      */       
/*  972 */       if (paramNode.getLeft(dataElement) != null && paramNode.getRight(dataElement) != null) {
/*  973 */         swapPosition(nextGreater(paramNode, dataElement), paramNode, dataElement);
/*      */       }
/*      */       
/*  976 */       Node<K, V> node = (paramNode.getLeft(dataElement) != null) ? paramNode.getLeft(dataElement) : paramNode.getRight(dataElement);
/*      */ 
/*      */       
/*  979 */       if (node != null) {
/*  980 */         node.setParent(paramNode.getParent(dataElement), dataElement);
/*      */         
/*  982 */         if (paramNode.getParent(dataElement) == null) {
/*  983 */           this.rootNode[dataElement.ordinal()] = node;
/*  984 */         } else if (paramNode == paramNode.getParent(dataElement).getLeft(dataElement)) {
/*  985 */           paramNode.getParent(dataElement).setLeft(node, dataElement);
/*      */         } else {
/*  987 */           paramNode.getParent(dataElement).setRight(node, dataElement);
/*      */         } 
/*      */         
/*  990 */         paramNode.setLeft(null, dataElement);
/*  991 */         paramNode.setRight(null, dataElement);
/*  992 */         paramNode.setParent(null, dataElement);
/*      */         
/*  994 */         if (isBlack(paramNode, dataElement)) {
/*  995 */           doRedBlackDeleteFixup(node, dataElement);
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 1000 */       else if (paramNode.getParent(dataElement) == null) {
/*      */ 
/*      */         
/* 1003 */         this.rootNode[dataElement.ordinal()] = null;
/*      */       }
/*      */       else {
/*      */         
/* 1007 */         if (isBlack(paramNode, dataElement)) {
/* 1008 */           doRedBlackDeleteFixup(paramNode, dataElement);
/*      */         }
/*      */         
/* 1011 */         if (paramNode.getParent(dataElement) != null) {
/* 1012 */           if (paramNode == paramNode.getParent(dataElement).getLeft(dataElement)) {
/* 1013 */             paramNode.getParent(dataElement).setLeft(null, dataElement);
/*      */           } else {
/* 1015 */             paramNode.getParent(dataElement).setRight(null, dataElement);
/*      */           } 
/*      */           
/* 1018 */           paramNode.setParent(null, dataElement);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1023 */     shrink();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void doRedBlackDeleteFixup(Node<K, V> paramNode, DataElement paramDataElement) {
/* 1036 */     Node<K, V> node = paramNode;
/*      */     
/* 1038 */     while (node != this.rootNode[paramDataElement.ordinal()] && isBlack(node, paramDataElement)) {
/* 1039 */       if (node.isLeftChild(paramDataElement)) {
/* 1040 */         Node<K, V> node2 = getRightChild(getParent(node, paramDataElement), paramDataElement);
/*      */         
/* 1042 */         if (isRed(node2, paramDataElement)) {
/* 1043 */           makeBlack(node2, paramDataElement);
/* 1044 */           makeRed(getParent(node, paramDataElement), paramDataElement);
/* 1045 */           rotateLeft(getParent(node, paramDataElement), paramDataElement);
/*      */           
/* 1047 */           node2 = getRightChild(getParent(node, paramDataElement), paramDataElement);
/*      */         } 
/*      */         
/* 1050 */         if (isBlack(getLeftChild(node2, paramDataElement), paramDataElement) && isBlack(getRightChild(node2, paramDataElement), paramDataElement)) {
/*      */           
/* 1052 */           makeRed(node2, paramDataElement);
/*      */           
/* 1054 */           node = getParent(node, paramDataElement); continue;
/*      */         } 
/* 1056 */         if (isBlack(getRightChild(node2, paramDataElement), paramDataElement)) {
/* 1057 */           makeBlack(getLeftChild(node2, paramDataElement), paramDataElement);
/* 1058 */           makeRed(node2, paramDataElement);
/* 1059 */           rotateRight(node2, paramDataElement);
/*      */           
/* 1061 */           node2 = getRightChild(getParent(node, paramDataElement), paramDataElement);
/*      */         } 
/*      */         
/* 1064 */         copyColor(getParent(node, paramDataElement), node2, paramDataElement);
/* 1065 */         makeBlack(getParent(node, paramDataElement), paramDataElement);
/* 1066 */         makeBlack(getRightChild(node2, paramDataElement), paramDataElement);
/* 1067 */         rotateLeft(getParent(node, paramDataElement), paramDataElement);
/*      */         
/* 1069 */         node = this.rootNode[paramDataElement.ordinal()];
/*      */         continue;
/*      */       } 
/* 1072 */       Node<K, V> node1 = getLeftChild(getParent(node, paramDataElement), paramDataElement);
/*      */       
/* 1074 */       if (isRed(node1, paramDataElement)) {
/* 1075 */         makeBlack(node1, paramDataElement);
/* 1076 */         makeRed(getParent(node, paramDataElement), paramDataElement);
/* 1077 */         rotateRight(getParent(node, paramDataElement), paramDataElement);
/*      */         
/* 1079 */         node1 = getLeftChild(getParent(node, paramDataElement), paramDataElement);
/*      */       } 
/*      */       
/* 1082 */       if (isBlack(getRightChild(node1, paramDataElement), paramDataElement) && isBlack(getLeftChild(node1, paramDataElement), paramDataElement)) {
/*      */         
/* 1084 */         makeRed(node1, paramDataElement);
/*      */         
/* 1086 */         node = getParent(node, paramDataElement); continue;
/*      */       } 
/* 1088 */       if (isBlack(getLeftChild(node1, paramDataElement), paramDataElement)) {
/* 1089 */         makeBlack(getRightChild(node1, paramDataElement), paramDataElement);
/* 1090 */         makeRed(node1, paramDataElement);
/* 1091 */         rotateLeft(node1, paramDataElement);
/*      */         
/* 1093 */         node1 = getLeftChild(getParent(node, paramDataElement), paramDataElement);
/*      */       } 
/*      */       
/* 1096 */       copyColor(getParent(node, paramDataElement), node1, paramDataElement);
/* 1097 */       makeBlack(getParent(node, paramDataElement), paramDataElement);
/* 1098 */       makeBlack(getLeftChild(node1, paramDataElement), paramDataElement);
/* 1099 */       rotateRight(getParent(node, paramDataElement), paramDataElement);
/*      */       
/* 1101 */       node = this.rootNode[paramDataElement.ordinal()];
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1106 */     makeBlack(node, paramDataElement);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void swapPosition(Node<K, V> paramNode1, Node<K, V> paramNode2, DataElement paramDataElement) {
/* 1120 */     Node<K, V> node1 = paramNode1.getParent(paramDataElement);
/* 1121 */     Node node2 = paramNode1.getLeft(paramDataElement);
/* 1122 */     Node node3 = paramNode1.getRight(paramDataElement);
/* 1123 */     Node<K, V> node4 = paramNode2.getParent(paramDataElement);
/* 1124 */     Node node5 = paramNode2.getLeft(paramDataElement);
/* 1125 */     Node node6 = paramNode2.getRight(paramDataElement);
/* 1126 */     boolean bool1 = (paramNode1.getParent(paramDataElement) != null && paramNode1 == paramNode1.getParent(paramDataElement).getLeft(paramDataElement)) ? true : false;
/*      */     
/* 1128 */     boolean bool2 = (paramNode2.getParent(paramDataElement) != null && paramNode2 == paramNode2.getParent(paramDataElement).getLeft(paramDataElement)) ? true : false;
/*      */ 
/*      */ 
/*      */     
/* 1132 */     if (paramNode1 == node4) {
/* 1133 */       paramNode1.setParent(paramNode2, paramDataElement);
/*      */       
/* 1135 */       if (bool2) {
/* 1136 */         paramNode2.setLeft(paramNode1, paramDataElement);
/* 1137 */         paramNode2.setRight(node3, paramDataElement);
/*      */       } else {
/* 1139 */         paramNode2.setRight(paramNode1, paramDataElement);
/* 1140 */         paramNode2.setLeft(node2, paramDataElement);
/*      */       } 
/*      */     } else {
/* 1143 */       paramNode1.setParent(node4, paramDataElement);
/*      */       
/* 1145 */       if (node4 != null) {
/* 1146 */         if (bool2) {
/* 1147 */           node4.setLeft(paramNode1, paramDataElement);
/*      */         } else {
/* 1149 */           node4.setRight(paramNode1, paramDataElement);
/*      */         } 
/*      */       }
/*      */       
/* 1153 */       paramNode2.setLeft(node2, paramDataElement);
/* 1154 */       paramNode2.setRight(node3, paramDataElement);
/*      */     } 
/*      */     
/* 1157 */     if (paramNode2 == node1) {
/* 1158 */       paramNode2.setParent(paramNode1, paramDataElement);
/*      */       
/* 1160 */       if (bool1) {
/* 1161 */         paramNode1.setLeft(paramNode2, paramDataElement);
/* 1162 */         paramNode1.setRight(node6, paramDataElement);
/*      */       } else {
/* 1164 */         paramNode1.setRight(paramNode2, paramDataElement);
/* 1165 */         paramNode1.setLeft(node5, paramDataElement);
/*      */       } 
/*      */     } else {
/* 1168 */       paramNode2.setParent(node1, paramDataElement);
/*      */       
/* 1170 */       if (node1 != null) {
/* 1171 */         if (bool1) {
/* 1172 */           node1.setLeft(paramNode2, paramDataElement);
/*      */         } else {
/* 1174 */           node1.setRight(paramNode2, paramDataElement);
/*      */         } 
/*      */       }
/*      */       
/* 1178 */       paramNode1.setLeft(node5, paramDataElement);
/* 1179 */       paramNode1.setRight(node6, paramDataElement);
/*      */     } 
/*      */ 
/*      */     
/* 1183 */     if (paramNode1.getLeft(paramDataElement) != null) {
/* 1184 */       paramNode1.getLeft(paramDataElement).setParent(paramNode1, paramDataElement);
/*      */     }
/*      */     
/* 1187 */     if (paramNode1.getRight(paramDataElement) != null) {
/* 1188 */       paramNode1.getRight(paramDataElement).setParent(paramNode1, paramDataElement);
/*      */     }
/*      */     
/* 1191 */     if (paramNode2.getLeft(paramDataElement) != null) {
/* 1192 */       paramNode2.getLeft(paramDataElement).setParent(paramNode2, paramDataElement);
/*      */     }
/*      */     
/* 1195 */     if (paramNode2.getRight(paramDataElement) != null) {
/* 1196 */       paramNode2.getRight(paramDataElement).setParent(paramNode2, paramDataElement);
/*      */     }
/*      */     
/* 1199 */     paramNode1.swapColors(paramNode2, paramDataElement);
/*      */ 
/*      */     
/* 1202 */     if (this.rootNode[paramDataElement.ordinal()] == paramNode1) {
/* 1203 */       this.rootNode[paramDataElement.ordinal()] = paramNode2;
/* 1204 */     } else if (this.rootNode[paramDataElement.ordinal()] == paramNode2) {
/* 1205 */       this.rootNode[paramDataElement.ordinal()] = paramNode1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkNonNullComparable(Object paramObject, DataElement paramDataElement) {
/* 1221 */     if (paramObject == null) {
/* 1222 */       throw new NullPointerException(paramDataElement + " cannot be null");
/*      */     }
/* 1224 */     if (!(paramObject instanceof Comparable)) {
/* 1225 */       throw new ClassCastException(paramDataElement + " must be Comparable");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkKey(Object paramObject) {
/* 1238 */     checkNonNullComparable(paramObject, DataElement.KEY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkValue(Object paramObject) {
/* 1250 */     checkNonNullComparable(paramObject, DataElement.VALUE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkKeyAndValue(Object paramObject1, Object paramObject2) {
/* 1264 */     checkKey(paramObject1);
/* 1265 */     checkValue(paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void modify() {
/* 1274 */     this.modifications++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void grow() {
/* 1281 */     modify();
/* 1282 */     this.nodeCount++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void shrink() {
/* 1289 */     modify();
/* 1290 */     this.nodeCount--;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void insertValue(Node<K, V> paramNode) throws IllegalArgumentException {
/* 1302 */     Node<K, V> node = this.rootNode[DataElement.VALUE.ordinal()];
/*      */     
/*      */     while (true) {
/* 1305 */       int i = compare((Comparable)paramNode.getValue(), (Comparable)node.getValue());
/*      */       
/* 1307 */       if (i == 0) {
/* 1308 */         throw new IllegalArgumentException("Cannot store a duplicate value (\"" + paramNode.getData(DataElement.VALUE) + "\") in this Map");
/*      */       }
/* 1310 */       if (i < 0) {
/* 1311 */         if (node.getLeft(DataElement.VALUE) != null) {
/* 1312 */           node = node.getLeft(DataElement.VALUE); continue;
/*      */         } 
/* 1314 */         node.setLeft(paramNode, DataElement.VALUE);
/* 1315 */         paramNode.setParent(node, DataElement.VALUE);
/* 1316 */         doRedBlackInsert(paramNode, DataElement.VALUE);
/*      */         
/*      */         break;
/*      */       } 
/*      */       
/* 1321 */       if (node.getRight(DataElement.VALUE) != null) {
/* 1322 */         node = node.getRight(DataElement.VALUE); continue;
/*      */       } 
/* 1324 */       node.setRight(paramNode, DataElement.VALUE);
/* 1325 */       paramNode.setParent(node, DataElement.VALUE);
/* 1326 */       doRedBlackInsert(paramNode, DataElement.VALUE);
/*      */       break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean doEquals(Object paramObject, DataElement paramDataElement) {
/* 1343 */     if (paramObject == this) {
/* 1344 */       return true;
/*      */     }
/* 1346 */     if (!(paramObject instanceof Map)) {
/* 1347 */       return false;
/*      */     }
/* 1349 */     Map map = (Map)paramObject;
/* 1350 */     if (map.size() != size()) {
/* 1351 */       return false;
/*      */     }
/*      */     
/* 1354 */     if (this.nodeCount > 0) {
/*      */       try {
/* 1356 */         for (MapIterator<?, ?> mapIterator = getMapIterator(paramDataElement); mapIterator.hasNext(); ) {
/* 1357 */           Object object1 = mapIterator.next();
/* 1358 */           Object object2 = mapIterator.getValue();
/* 1359 */           if (!object2.equals(map.get(object1))) {
/* 1360 */             return false;
/*      */           }
/*      */         } 
/* 1363 */       } catch (ClassCastException classCastException) {
/* 1364 */         return false;
/* 1365 */       } catch (NullPointerException nullPointerException) {
/* 1366 */         return false;
/*      */       } 
/*      */     }
/* 1369 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int doHashCode(DataElement paramDataElement) {
/* 1379 */     int i = 0;
/* 1380 */     if (this.nodeCount > 0) {
/* 1381 */       for (MapIterator<?, ?> mapIterator = getMapIterator(paramDataElement); mapIterator.hasNext(); ) {
/* 1382 */         Object object1 = mapIterator.next();
/* 1383 */         Object object2 = mapIterator.getValue();
/* 1384 */         i += object1.hashCode() ^ object2.hashCode();
/*      */       } 
/*      */     }
/* 1387 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String doToString(DataElement paramDataElement) {
/* 1397 */     if (this.nodeCount == 0) {
/* 1398 */       return "{}";
/*      */     }
/* 1400 */     StringBuilder stringBuilder = new StringBuilder(this.nodeCount * 32);
/* 1401 */     stringBuilder.append('{');
/* 1402 */     MapIterator<?, ?> mapIterator = getMapIterator(paramDataElement);
/* 1403 */     boolean bool = mapIterator.hasNext();
/* 1404 */     while (bool) {
/* 1405 */       Object object1 = mapIterator.next();
/* 1406 */       Object object2 = mapIterator.getValue();
/* 1407 */       stringBuilder.append((object1 == this) ? "(this Map)" : object1).append('=').append((object2 == this) ? "(this Map)" : object2);
/*      */ 
/*      */ 
/*      */       
/* 1411 */       bool = mapIterator.hasNext();
/* 1412 */       if (bool) {
/* 1413 */         stringBuilder.append(", ");
/*      */       }
/*      */     } 
/*      */     
/* 1417 */     stringBuilder.append('}');
/* 1418 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   private MapIterator<?, ?> getMapIterator(DataElement paramDataElement) {
/* 1422 */     switch (paramDataElement) {
/*      */       case KEY:
/* 1424 */         return (MapIterator<?, ?>)new ViewMapIterator(DataElement.KEY);
/*      */       case VALUE:
/* 1426 */         return (MapIterator<?, ?>)new InverseViewMapIterator(DataElement.VALUE);
/*      */     } 
/* 1428 */     throw new IllegalArgumentException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 1437 */     paramObjectInputStream.defaultReadObject();
/* 1438 */     this.rootNode = (Node<K, V>[])new Node[2];
/* 1439 */     int i = paramObjectInputStream.readInt();
/* 1440 */     for (byte b = 0; b < i; b++) {
/* 1441 */       Comparable comparable1 = (Comparable)paramObjectInputStream.readObject();
/* 1442 */       Comparable comparable2 = (Comparable)paramObjectInputStream.readObject();
/* 1443 */       put((K)comparable1, (V)comparable2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 1451 */     paramObjectOutputStream.defaultWriteObject();
/* 1452 */     paramObjectOutputStream.writeInt(size());
/* 1453 */     for (Map.Entry<K, V> entry : entrySet()) {
/* 1454 */       paramObjectOutputStream.writeObject(entry.getKey());
/* 1455 */       paramObjectOutputStream.writeObject(entry.getValue());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   abstract class View<E>
/*      */     extends AbstractSet<E>
/*      */   {
/*      */     final TreeBidiMap.DataElement orderType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     View(TreeBidiMap.DataElement param1DataElement) {
/* 1475 */       this.orderType = param1DataElement;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1480 */       return TreeBidiMap.this.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1485 */       TreeBidiMap.this.clear();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class KeyView
/*      */     extends View<K>
/*      */   {
/*      */     public KeyView(TreeBidiMap.DataElement param1DataElement) {
/* 1495 */       super(param1DataElement);
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<K> iterator() {
/* 1500 */       return (Iterator<K>)new TreeBidiMap.ViewMapIterator(this.orderType);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1505 */       TreeBidiMap.checkNonNullComparable(param1Object, TreeBidiMap.DataElement.KEY);
/* 1506 */       return (TreeBidiMap.this.lookupKey(param1Object) != null);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1511 */       return (TreeBidiMap.this.doRemoveKey(param1Object) != null);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class ValueView
/*      */     extends View<V>
/*      */   {
/*      */     public ValueView(TreeBidiMap.DataElement param1DataElement) {
/* 1522 */       super(param1DataElement);
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<V> iterator() {
/* 1527 */       return (Iterator<V>)new TreeBidiMap.InverseViewMapIterator(this.orderType);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1532 */       TreeBidiMap.checkNonNullComparable(param1Object, TreeBidiMap.DataElement.VALUE);
/* 1533 */       return (TreeBidiMap.this.lookupValue(param1Object) != null);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1538 */       return (TreeBidiMap.this.doRemoveValue(param1Object) != null);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class EntryView
/*      */     extends View<Map.Entry<K, V>>
/*      */   {
/*      */     EntryView() {
/* 1549 */       super(TreeBidiMap.DataElement.KEY);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1554 */       if (!(param1Object instanceof Map.Entry)) {
/* 1555 */         return false;
/*      */       }
/* 1557 */       Map.Entry entry = (Map.Entry)param1Object;
/* 1558 */       Object object = entry.getValue();
/* 1559 */       TreeBidiMap.Node node = TreeBidiMap.this.lookupKey(entry.getKey());
/* 1560 */       return (node != null && node.getValue().equals(object));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1565 */       if (!(param1Object instanceof Map.Entry)) {
/* 1566 */         return false;
/*      */       }
/* 1568 */       Map.Entry entry = (Map.Entry)param1Object;
/* 1569 */       Object object = entry.getValue();
/* 1570 */       TreeBidiMap.Node node = TreeBidiMap.this.lookupKey(entry.getKey());
/* 1571 */       if (node != null && node.getValue().equals(object)) {
/* 1572 */         TreeBidiMap.this.doRedBlackDelete(node);
/* 1573 */         return true;
/*      */       } 
/* 1575 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<Map.Entry<K, V>> iterator() {
/* 1580 */       return (Iterator<Map.Entry<K, V>>)new TreeBidiMap.ViewMapEntryIterator();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class InverseEntryView
/*      */     extends View<Map.Entry<V, K>>
/*      */   {
/*      */     InverseEntryView() {
/* 1590 */       super(TreeBidiMap.DataElement.VALUE);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1595 */       if (!(param1Object instanceof Map.Entry)) {
/* 1596 */         return false;
/*      */       }
/* 1598 */       Map.Entry entry = (Map.Entry)param1Object;
/* 1599 */       Object object = entry.getValue();
/* 1600 */       TreeBidiMap.Node node = TreeBidiMap.this.lookupValue(entry.getKey());
/* 1601 */       return (node != null && node.getKey().equals(object));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1606 */       if (!(param1Object instanceof Map.Entry)) {
/* 1607 */         return false;
/*      */       }
/* 1609 */       Map.Entry entry = (Map.Entry)param1Object;
/* 1610 */       Object object = entry.getValue();
/* 1611 */       TreeBidiMap.Node node = TreeBidiMap.this.lookupValue(entry.getKey());
/* 1612 */       if (node != null && node.getKey().equals(object)) {
/* 1613 */         TreeBidiMap.this.doRedBlackDelete(node);
/* 1614 */         return true;
/*      */       } 
/* 1616 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<Map.Entry<V, K>> iterator() {
/* 1621 */       return (Iterator<Map.Entry<V, K>>)new TreeBidiMap.InverseViewMapEntryIterator();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   abstract class ViewIterator
/*      */   {
/*      */     private final TreeBidiMap.DataElement orderType;
/*      */ 
/*      */ 
/*      */     
/*      */     TreeBidiMap.Node<K, V> lastReturnedNode;
/*      */ 
/*      */ 
/*      */     
/*      */     private TreeBidiMap.Node<K, V> nextNode;
/*      */ 
/*      */     
/*      */     private TreeBidiMap.Node<K, V> previousNode;
/*      */ 
/*      */     
/*      */     private int expectedModifications;
/*      */ 
/*      */ 
/*      */     
/*      */     ViewIterator(TreeBidiMap.DataElement param1DataElement) {
/* 1649 */       this.orderType = param1DataElement;
/* 1650 */       this.expectedModifications = TreeBidiMap.this.modifications;
/* 1651 */       this.nextNode = TreeBidiMap.this.leastNode(TreeBidiMap.this.rootNode[param1DataElement.ordinal()], param1DataElement);
/* 1652 */       this.lastReturnedNode = null;
/* 1653 */       this.previousNode = null;
/*      */     }
/*      */     
/*      */     public final boolean hasNext() {
/* 1657 */       return (this.nextNode != null);
/*      */     }
/*      */     
/*      */     protected TreeBidiMap.Node<K, V> navigateNext() {
/* 1661 */       if (this.nextNode == null) {
/* 1662 */         throw new NoSuchElementException();
/*      */       }
/* 1664 */       if (TreeBidiMap.this.modifications != this.expectedModifications) {
/* 1665 */         throw new ConcurrentModificationException();
/*      */       }
/* 1667 */       this.lastReturnedNode = this.nextNode;
/* 1668 */       this.previousNode = this.nextNode;
/* 1669 */       this.nextNode = TreeBidiMap.this.nextGreater(this.nextNode, this.orderType);
/* 1670 */       return this.lastReturnedNode;
/*      */     }
/*      */     
/*      */     public boolean hasPrevious() {
/* 1674 */       return (this.previousNode != null);
/*      */     }
/*      */     
/*      */     protected TreeBidiMap.Node<K, V> navigatePrevious() {
/* 1678 */       if (this.previousNode == null) {
/* 1679 */         throw new NoSuchElementException();
/*      */       }
/* 1681 */       if (TreeBidiMap.this.modifications != this.expectedModifications) {
/* 1682 */         throw new ConcurrentModificationException();
/*      */       }
/* 1684 */       this.nextNode = this.lastReturnedNode;
/* 1685 */       if (this.nextNode == null) {
/* 1686 */         this.nextNode = TreeBidiMap.this.nextGreater(this.previousNode, this.orderType);
/*      */       }
/* 1688 */       this.lastReturnedNode = this.previousNode;
/* 1689 */       this.previousNode = TreeBidiMap.this.nextSmaller(this.previousNode, this.orderType);
/* 1690 */       return this.lastReturnedNode;
/*      */     }
/*      */     
/*      */     public final void remove() {
/* 1694 */       if (this.lastReturnedNode == null) {
/* 1695 */         throw new IllegalStateException();
/*      */       }
/* 1697 */       if (TreeBidiMap.this.modifications != this.expectedModifications) {
/* 1698 */         throw new ConcurrentModificationException();
/*      */       }
/* 1700 */       TreeBidiMap.this.doRedBlackDelete(this.lastReturnedNode);
/* 1701 */       this.expectedModifications++;
/* 1702 */       this.lastReturnedNode = null;
/* 1703 */       if (this.nextNode == null) {
/* 1704 */         this.previousNode = TreeBidiMap.this.greatestNode(TreeBidiMap.this.rootNode[this.orderType.ordinal()], this.orderType);
/*      */       } else {
/* 1706 */         this.previousNode = TreeBidiMap.this.nextSmaller(this.nextNode, this.orderType);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class ViewMapIterator
/*      */     extends ViewIterator
/*      */     implements OrderedMapIterator<K, V>
/*      */   {
/*      */     ViewMapIterator(TreeBidiMap.DataElement param1DataElement) {
/* 1721 */       super(param1DataElement);
/*      */     }
/*      */ 
/*      */     
/*      */     public K getKey() {
/* 1726 */       if (this.lastReturnedNode == null) {
/* 1727 */         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
/*      */       }
/*      */       
/* 1730 */       return this.lastReturnedNode.getKey();
/*      */     }
/*      */ 
/*      */     
/*      */     public V getValue() {
/* 1735 */       if (this.lastReturnedNode == null) {
/* 1736 */         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
/*      */       }
/*      */       
/* 1739 */       return this.lastReturnedNode.getValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public V setValue(V param1V) {
/* 1744 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public K next() {
/* 1749 */       return navigateNext().getKey();
/*      */     }
/*      */ 
/*      */     
/*      */     public K previous() {
/* 1754 */       return navigatePrevious().getKey();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class InverseViewMapIterator
/*      */     extends ViewIterator
/*      */     implements OrderedMapIterator<V, K>
/*      */   {
/*      */     public InverseViewMapIterator(TreeBidiMap.DataElement param1DataElement) {
/* 1767 */       super(param1DataElement);
/*      */     }
/*      */ 
/*      */     
/*      */     public V getKey() {
/* 1772 */       if (this.lastReturnedNode == null) {
/* 1773 */         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
/*      */       }
/*      */       
/* 1776 */       return this.lastReturnedNode.getValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public K getValue() {
/* 1781 */       if (this.lastReturnedNode == null) {
/* 1782 */         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
/*      */       }
/*      */       
/* 1785 */       return this.lastReturnedNode.getKey();
/*      */     }
/*      */ 
/*      */     
/*      */     public K setValue(K param1K) {
/* 1790 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public V next() {
/* 1795 */       return navigateNext().getValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public V previous() {
/* 1800 */       return navigatePrevious().getValue();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class ViewMapEntryIterator
/*      */     extends ViewIterator
/*      */     implements OrderedIterator<Map.Entry<K, V>>
/*      */   {
/*      */     ViewMapEntryIterator() {
/* 1813 */       super(TreeBidiMap.DataElement.KEY);
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, V> next() {
/* 1818 */       return navigateNext();
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, V> previous() {
/* 1823 */       return navigatePrevious();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class InverseViewMapEntryIterator
/*      */     extends ViewIterator
/*      */     implements OrderedIterator<Map.Entry<V, K>>
/*      */   {
/*      */     InverseViewMapEntryIterator() {
/* 1836 */       super(TreeBidiMap.DataElement.VALUE);
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<V, K> next() {
/* 1841 */       return createEntry(navigateNext());
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<V, K> previous() {
/* 1846 */       return createEntry(navigatePrevious());
/*      */     }
/*      */     
/*      */     private Map.Entry<V, K> createEntry(TreeBidiMap.Node<K, V> param1Node) {
/* 1850 */       return (Map.Entry<V, K>)new UnmodifiableMapEntry(param1Node.getValue(), param1Node.getKey());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class Node<K extends Comparable<K>, V extends Comparable<V>>
/*      */     implements Map.Entry<K, V>, KeyValue<K, V>
/*      */   {
/*      */     private final K key;
/*      */ 
/*      */     
/*      */     private final V value;
/*      */ 
/*      */     
/*      */     private final Node<K, V>[] leftNode;
/*      */ 
/*      */     
/*      */     private final Node<K, V>[] rightNode;
/*      */     
/*      */     private final Node<K, V>[] parentNode;
/*      */     
/*      */     private final boolean[] blackColor;
/*      */     
/*      */     private int hashcodeValue;
/*      */     
/*      */     private boolean calculatedHashCode;
/*      */ 
/*      */     
/*      */     Node(K param1K, V param1V) {
/* 1880 */       this.key = param1K;
/* 1881 */       this.value = param1V;
/* 1882 */       this.leftNode = (Node<K, V>[])new Node[2];
/* 1883 */       this.rightNode = (Node<K, V>[])new Node[2];
/* 1884 */       this.parentNode = (Node<K, V>[])new Node[2];
/* 1885 */       this.blackColor = new boolean[] { true, true };
/* 1886 */       this.calculatedHashCode = false;
/*      */     }
/*      */     
/*      */     private Object getData(TreeBidiMap.DataElement param1DataElement) {
/* 1890 */       switch (param1DataElement) {
/*      */         case KEY:
/* 1892 */           return getKey();
/*      */         case VALUE:
/* 1894 */           return getValue();
/*      */       } 
/* 1896 */       throw new IllegalArgumentException();
/*      */     }
/*      */ 
/*      */     
/*      */     private void setLeft(Node<K, V> param1Node, TreeBidiMap.DataElement param1DataElement) {
/* 1901 */       this.leftNode[param1DataElement.ordinal()] = param1Node;
/*      */     }
/*      */     
/*      */     private Node<K, V> getLeft(TreeBidiMap.DataElement param1DataElement) {
/* 1905 */       return this.leftNode[param1DataElement.ordinal()];
/*      */     }
/*      */     
/*      */     private void setRight(Node<K, V> param1Node, TreeBidiMap.DataElement param1DataElement) {
/* 1909 */       this.rightNode[param1DataElement.ordinal()] = param1Node;
/*      */     }
/*      */     
/*      */     private Node<K, V> getRight(TreeBidiMap.DataElement param1DataElement) {
/* 1913 */       return this.rightNode[param1DataElement.ordinal()];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void setParent(Node<K, V> param1Node, TreeBidiMap.DataElement param1DataElement) {
/* 1923 */       this.parentNode[param1DataElement.ordinal()] = param1Node;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Node<K, V> getParent(TreeBidiMap.DataElement param1DataElement) {
/* 1933 */       return this.parentNode[param1DataElement.ordinal()];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void swapColors(Node<K, V> param1Node, TreeBidiMap.DataElement param1DataElement) {
/* 1944 */       this.blackColor[param1DataElement.ordinal()] = this.blackColor[param1DataElement.ordinal()] ^ param1Node.blackColor[param1DataElement.ordinal()];
/* 1945 */       param1Node.blackColor[param1DataElement.ordinal()] = param1Node.blackColor[param1DataElement.ordinal()] ^ this.blackColor[param1DataElement.ordinal()];
/* 1946 */       this.blackColor[param1DataElement.ordinal()] = this.blackColor[param1DataElement.ordinal()] ^ param1Node.blackColor[param1DataElement.ordinal()];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean isBlack(TreeBidiMap.DataElement param1DataElement) {
/* 1956 */       return this.blackColor[param1DataElement.ordinal()];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean isRed(TreeBidiMap.DataElement param1DataElement) {
/* 1966 */       return !this.blackColor[param1DataElement.ordinal()];
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void setBlack(TreeBidiMap.DataElement param1DataElement) {
/* 1975 */       this.blackColor[param1DataElement.ordinal()] = true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void setRed(TreeBidiMap.DataElement param1DataElement) {
/* 1984 */       this.blackColor[param1DataElement.ordinal()] = false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void copyColor(Node<K, V> param1Node, TreeBidiMap.DataElement param1DataElement) {
/* 1994 */       this.blackColor[param1DataElement.ordinal()] = param1Node.blackColor[param1DataElement.ordinal()];
/*      */     }
/*      */     
/*      */     private boolean isLeftChild(TreeBidiMap.DataElement param1DataElement) {
/* 1998 */       return (this.parentNode[param1DataElement.ordinal()] != null && (this.parentNode[param1DataElement.ordinal()]).leftNode[param1DataElement.ordinal()] == this);
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean isRightChild(TreeBidiMap.DataElement param1DataElement) {
/* 2003 */       return (this.parentNode[param1DataElement.ordinal()] != null && (this.parentNode[param1DataElement.ordinal()]).rightNode[param1DataElement.ordinal()] == this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public K getKey() {
/* 2015 */       return this.key;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V getValue() {
/* 2025 */       return this.value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V setValue(V param1V) throws UnsupportedOperationException {
/* 2037 */       throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 2050 */       if (param1Object == this) {
/* 2051 */         return true;
/*      */       }
/* 2053 */       if (!(param1Object instanceof Map.Entry)) {
/* 2054 */         return false;
/*      */       }
/* 2056 */       Map.Entry entry = (Map.Entry)param1Object;
/* 2057 */       return (getKey().equals(entry.getKey()) && getValue().equals(entry.getValue()));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 2065 */       if (!this.calculatedHashCode) {
/* 2066 */         this.hashcodeValue = getKey().hashCode() ^ getValue().hashCode();
/* 2067 */         this.calculatedHashCode = true;
/*      */       } 
/* 2069 */       return this.hashcodeValue;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   class Inverse
/*      */     implements OrderedBidiMap<V, K>
/*      */   {
/*      */     private Set<V> inverseKeySet;
/*      */ 
/*      */     
/*      */     private Set<K> inverseValuesSet;
/*      */ 
/*      */     
/*      */     private Set<Map.Entry<V, K>> inverseEntrySet;
/*      */ 
/*      */     
/*      */     public int size() {
/* 2088 */       return TreeBidiMap.this.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 2093 */       return TreeBidiMap.this.isEmpty();
/*      */     }
/*      */ 
/*      */     
/*      */     public K get(Object param1Object) {
/* 2098 */       return (K)TreeBidiMap.this.getKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public V getKey(Object param1Object) {
/* 2103 */       return (V)TreeBidiMap.this.get(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsKey(Object param1Object) {
/* 2108 */       return TreeBidiMap.this.containsValue(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsValue(Object param1Object) {
/* 2113 */       return TreeBidiMap.this.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public V firstKey() {
/* 2118 */       if (TreeBidiMap.this.nodeCount == 0) {
/* 2119 */         throw new NoSuchElementException("Map is empty");
/*      */       }
/* 2121 */       return (V)TreeBidiMap.this.leastNode(TreeBidiMap.this.rootNode[TreeBidiMap.DataElement.VALUE.ordinal()], TreeBidiMap.DataElement.VALUE).getValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public V lastKey() {
/* 2126 */       if (TreeBidiMap.this.nodeCount == 0) {
/* 2127 */         throw new NoSuchElementException("Map is empty");
/*      */       }
/* 2129 */       return (V)TreeBidiMap.this.greatestNode(TreeBidiMap.this.rootNode[TreeBidiMap.DataElement.VALUE.ordinal()], TreeBidiMap.DataElement.VALUE).getValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public V nextKey(V param1V) {
/* 2134 */       TreeBidiMap.checkKey(param1V);
/* 2135 */       TreeBidiMap.Node node = TreeBidiMap.this.nextGreater(TreeBidiMap.this.lookup(param1V, TreeBidiMap.DataElement.VALUE), TreeBidiMap.DataElement.VALUE);
/* 2136 */       return (node == null) ? null : (V)node.getValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public V previousKey(V param1V) {
/* 2141 */       TreeBidiMap.checkKey(param1V);
/* 2142 */       TreeBidiMap.Node node = TreeBidiMap.this.nextSmaller(TreeBidiMap.this.lookup(param1V, TreeBidiMap.DataElement.VALUE), TreeBidiMap.DataElement.VALUE);
/* 2143 */       return (node == null) ? null : (V)node.getValue();
/*      */     }
/*      */ 
/*      */     
/*      */     public K put(V param1V, K param1K) {
/* 2148 */       K k = get(param1V);
/* 2149 */       TreeBidiMap.this.doPut(param1K, param1V);
/* 2150 */       return k;
/*      */     }
/*      */ 
/*      */     
/*      */     public void putAll(Map<? extends V, ? extends K> param1Map) {
/* 2155 */       for (Map.Entry<? extends V, ? extends K> entry : param1Map.entrySet()) {
/* 2156 */         put((V)entry.getKey(), (K)entry.getValue());
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public K remove(Object param1Object) {
/* 2162 */       return (K)TreeBidiMap.this.removeValue(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public V removeValue(Object param1Object) {
/* 2167 */       return (V)TreeBidiMap.this.remove(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 2172 */       TreeBidiMap.this.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<V> keySet() {
/* 2177 */       if (this.inverseKeySet == null) {
/* 2178 */         this.inverseKeySet = new TreeBidiMap.ValueView(TreeBidiMap.DataElement.VALUE);
/*      */       }
/* 2180 */       return this.inverseKeySet;
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<K> values() {
/* 2185 */       if (this.inverseValuesSet == null) {
/* 2186 */         this.inverseValuesSet = new TreeBidiMap.KeyView(TreeBidiMap.DataElement.VALUE);
/*      */       }
/* 2188 */       return this.inverseValuesSet;
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<Map.Entry<V, K>> entrySet() {
/* 2193 */       if (this.inverseEntrySet == null) {
/* 2194 */         this.inverseEntrySet = new TreeBidiMap.InverseEntryView();
/*      */       }
/* 2196 */       return this.inverseEntrySet;
/*      */     }
/*      */ 
/*      */     
/*      */     public OrderedMapIterator<V, K> mapIterator() {
/* 2201 */       if (isEmpty()) {
/* 2202 */         return EmptyOrderedMapIterator.emptyOrderedMapIterator();
/*      */       }
/* 2204 */       return new TreeBidiMap.InverseViewMapIterator(TreeBidiMap.DataElement.VALUE);
/*      */     }
/*      */ 
/*      */     
/*      */     public OrderedBidiMap<K, V> inverseBidiMap() {
/* 2209 */       return TreeBidiMap.this;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 2214 */       return TreeBidiMap.this.doEquals(param1Object, TreeBidiMap.DataElement.VALUE);
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 2219 */       return TreeBidiMap.this.doHashCode(TreeBidiMap.DataElement.VALUE);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 2224 */       return TreeBidiMap.this.doToString(TreeBidiMap.DataElement.VALUE);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\TreeBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */