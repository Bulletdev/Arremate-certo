/*      */ package org.apache.commons.collections4.list;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.AbstractList;
/*      */ import java.util.Collection;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.NoSuchElementException;
/*      */ import org.apache.commons.collections4.OrderedIterator;
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
/*      */ public abstract class AbstractLinkedList<E>
/*      */   implements List<E>
/*      */ {
/*      */   transient Node<E> header;
/*      */   transient int size;
/*      */   transient int modCount;
/*      */   
/*      */   protected AbstractLinkedList() {}
/*      */   
/*      */   protected AbstractLinkedList(Collection<? extends E> paramCollection) {
/*   87 */     init();
/*   88 */     addAll(paramCollection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void init() {
/*   98 */     this.header = createHeaderNode();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  104 */     return this.size;
/*      */   }
/*      */   
/*      */   public boolean isEmpty() {
/*  108 */     return (size() == 0);
/*      */   }
/*      */   
/*      */   public E get(int paramInt) {
/*  112 */     Node<E> node = getNode(paramInt, false);
/*  113 */     return node.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<E> iterator() {
/*  119 */     return listIterator();
/*      */   }
/*      */   
/*      */   public ListIterator<E> listIterator() {
/*  123 */     return new LinkedListIterator<E>(this, 0);
/*      */   }
/*      */   
/*      */   public ListIterator<E> listIterator(int paramInt) {
/*  127 */     return new LinkedListIterator<E>(this, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(Object paramObject) {
/*  133 */     byte b = 0;
/*  134 */     for (Node<E> node = this.header.next; node != this.header; node = node.next) {
/*  135 */       if (isEqualValue(node.getValue(), paramObject)) {
/*  136 */         return b;
/*      */       }
/*  138 */       b++;
/*      */     } 
/*  140 */     return -1;
/*      */   }
/*      */   
/*      */   public int lastIndexOf(Object paramObject) {
/*  144 */     int i = this.size - 1;
/*  145 */     for (Node<E> node = this.header.previous; node != this.header; node = node.previous) {
/*  146 */       if (isEqualValue(node.getValue(), paramObject)) {
/*  147 */         return i;
/*      */       }
/*  149 */       i--;
/*      */     } 
/*  151 */     return -1;
/*      */   }
/*      */   
/*      */   public boolean contains(Object paramObject) {
/*  155 */     return (indexOf(paramObject) != -1);
/*      */   }
/*      */   
/*      */   public boolean containsAll(Collection<?> paramCollection) {
/*  159 */     for (Object object : paramCollection) {
/*  160 */       if (!contains(object)) {
/*  161 */         return false;
/*      */       }
/*      */     } 
/*  164 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Object[] toArray() {
/*  170 */     return toArray(new Object[this.size]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T[] toArray(T[] paramArrayOfT) {
/*  176 */     if (paramArrayOfT.length < this.size) {
/*  177 */       Class<?> clazz = paramArrayOfT.getClass().getComponentType();
/*  178 */       paramArrayOfT = (T[])Array.newInstance(clazz, this.size);
/*      */     } 
/*      */     
/*  181 */     byte b = 0;
/*  182 */     for (Node<E> node = this.header.next; node != this.header; node = node.next, b++) {
/*  183 */       paramArrayOfT[b] = (T)node.getValue();
/*      */     }
/*      */     
/*  186 */     if (paramArrayOfT.length > this.size) {
/*  187 */       paramArrayOfT[this.size] = null;
/*      */     }
/*  189 */     return paramArrayOfT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<E> subList(int paramInt1, int paramInt2) {
/*  200 */     return new LinkedSubList<E>(this, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean add(E paramE) {
/*  206 */     addLast(paramE);
/*  207 */     return true;
/*      */   }
/*      */   
/*      */   public void add(int paramInt, E paramE) {
/*  211 */     Node<E> node = getNode(paramInt, true);
/*  212 */     addNodeBefore(node, paramE);
/*      */   }
/*      */   
/*      */   public boolean addAll(Collection<? extends E> paramCollection) {
/*  216 */     return addAll(this.size, paramCollection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: iload_1
/*      */     //   2: iconst_1
/*      */     //   3: invokevirtual getNode : (IZ)Lorg/apache/commons/collections4/list/AbstractLinkedList$Node;
/*      */     //   6: astore_3
/*      */     //   7: aload_2
/*      */     //   8: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   13: astore #4
/*      */     //   15: aload #4
/*      */     //   17: invokeinterface hasNext : ()Z
/*      */     //   22: ifeq -> 44
/*      */     //   25: aload #4
/*      */     //   27: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   32: astore #5
/*      */     //   34: aload_0
/*      */     //   35: aload_3
/*      */     //   36: aload #5
/*      */     //   38: invokevirtual addNodeBefore : (Lorg/apache/commons/collections4/list/AbstractLinkedList$Node;Ljava/lang/Object;)V
/*      */     //   41: goto -> 15
/*      */     //   44: iconst_1
/*      */     //   45: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #220	-> 0
/*      */     //   #221	-> 7
/*      */     //   #222	-> 34
/*      */     //   #223	-> 41
/*      */     //   #224	-> 44
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public E remove(int paramInt) {
/*  230 */     Node<E> node = getNode(paramInt, false);
/*  231 */     E e = node.getValue();
/*  232 */     removeNode(node);
/*  233 */     return e;
/*      */   }
/*      */   
/*      */   public boolean remove(Object paramObject) {
/*  237 */     for (Node<E> node = this.header.next; node != this.header; node = node.next) {
/*  238 */       if (isEqualValue(node.getValue(), paramObject)) {
/*  239 */         removeNode(node);
/*  240 */         return true;
/*      */       } 
/*      */     } 
/*  243 */     return false;
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
/*      */   public boolean removeAll(Collection<?> paramCollection) {
/*  256 */     boolean bool = false;
/*  257 */     Iterator<E> iterator = iterator();
/*  258 */     while (iterator.hasNext()) {
/*  259 */       if (paramCollection.contains(iterator.next())) {
/*  260 */         iterator.remove();
/*  261 */         bool = true;
/*      */       } 
/*      */     } 
/*  264 */     return bool;
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
/*      */   public boolean retainAll(Collection<?> paramCollection) {
/*  279 */     boolean bool = false;
/*  280 */     Iterator<E> iterator = iterator();
/*  281 */     while (iterator.hasNext()) {
/*  282 */       if (!paramCollection.contains(iterator.next())) {
/*  283 */         iterator.remove();
/*  284 */         bool = true;
/*      */       } 
/*      */     } 
/*  287 */     return bool;
/*      */   }
/*      */   
/*      */   public E set(int paramInt, E paramE) {
/*  291 */     Node<E> node = getNode(paramInt, false);
/*  292 */     E e = node.getValue();
/*  293 */     updateNode(node, paramE);
/*  294 */     return e;
/*      */   }
/*      */   
/*      */   public void clear() {
/*  298 */     removeAllNodes();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public E getFirst() {
/*  304 */     Node<E> node = this.header.next;
/*  305 */     if (node == this.header) {
/*  306 */       throw new NoSuchElementException();
/*      */     }
/*  308 */     return node.getValue();
/*      */   }
/*      */   
/*      */   public E getLast() {
/*  312 */     Node<E> node = this.header.previous;
/*  313 */     if (node == this.header) {
/*  314 */       throw new NoSuchElementException();
/*      */     }
/*  316 */     return node.getValue();
/*      */   }
/*      */   
/*      */   public boolean addFirst(E paramE) {
/*  320 */     addNodeAfter(this.header, paramE);
/*  321 */     return true;
/*      */   }
/*      */   
/*      */   public boolean addLast(E paramE) {
/*  325 */     addNodeBefore(this.header, paramE);
/*  326 */     return true;
/*      */   }
/*      */   
/*      */   public E removeFirst() {
/*  330 */     Node<E> node = this.header.next;
/*  331 */     if (node == this.header) {
/*  332 */       throw new NoSuchElementException();
/*      */     }
/*  334 */     E e = node.getValue();
/*  335 */     removeNode(node);
/*  336 */     return e;
/*      */   }
/*      */   
/*      */   public E removeLast() {
/*  340 */     Node<E> node = this.header.previous;
/*  341 */     if (node == this.header) {
/*  342 */       throw new NoSuchElementException();
/*      */     }
/*  344 */     E e = node.getValue();
/*  345 */     removeNode(node);
/*  346 */     return e;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/*  352 */     if (paramObject == this) {
/*  353 */       return true;
/*      */     }
/*  355 */     if (!(paramObject instanceof List)) {
/*  356 */       return false;
/*      */     }
/*  358 */     List list = (List)paramObject;
/*  359 */     if (list.size() != size()) {
/*  360 */       return false;
/*      */     }
/*  362 */     ListIterator<E> listIterator = listIterator();
/*  363 */     ListIterator<Object> listIterator1 = list.listIterator();
/*  364 */     while (listIterator.hasNext() && listIterator1.hasNext()) {
/*  365 */       E e = listIterator.next();
/*  366 */       Object object = listIterator1.next();
/*  367 */       if ((e == null) ? (object == null) : e.equals(object))
/*  368 */         continue;  return false;
/*      */     } 
/*      */     
/*  371 */     return (!listIterator.hasNext() && !listIterator1.hasNext());
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  376 */     int i = 1;
/*  377 */     for (E e : this) {
/*  378 */       i = 31 * i + ((e == null) ? 0 : e.hashCode());
/*      */     }
/*  380 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  385 */     if (size() == 0) {
/*  386 */       return "[]";
/*      */     }
/*  388 */     StringBuilder stringBuilder = new StringBuilder(16 * size());
/*  389 */     stringBuilder.append('[');
/*      */     
/*  391 */     Iterator<E> iterator = iterator();
/*  392 */     boolean bool = iterator.hasNext();
/*  393 */     while (bool) {
/*  394 */       E e = iterator.next();
/*  395 */       stringBuilder.append((e == this) ? "(this Collection)" : e);
/*  396 */       bool = iterator.hasNext();
/*  397 */       if (bool) {
/*  398 */         stringBuilder.append(", ");
/*      */       }
/*      */     } 
/*  401 */     stringBuilder.append(']');
/*  402 */     return stringBuilder.toString();
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
/*      */   protected boolean isEqualValue(Object paramObject1, Object paramObject2) {
/*  416 */     return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
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
/*      */   protected void updateNode(Node<E> paramNode, E paramE) {
/*  428 */     paramNode.setValue(paramE);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Node<E> createHeaderNode() {
/*  439 */     return new Node<E>();
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
/*      */   protected Node<E> createNode(E paramE) {
/*  451 */     return new Node<E>(paramE);
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
/*      */   protected void addNodeBefore(Node<E> paramNode, E paramE) {
/*  466 */     Node<E> node = createNode(paramE);
/*  467 */     addNode(node, paramNode);
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
/*      */   protected void addNodeAfter(Node<E> paramNode, E paramE) {
/*  482 */     Node<E> node = createNode(paramE);
/*  483 */     addNode(node, paramNode.next);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void addNode(Node<E> paramNode1, Node<E> paramNode2) {
/*  494 */     paramNode1.next = paramNode2;
/*  495 */     paramNode1.previous = paramNode2.previous;
/*  496 */     paramNode2.previous.next = paramNode1;
/*  497 */     paramNode2.previous = paramNode1;
/*  498 */     this.size++;
/*  499 */     this.modCount++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeNode(Node<E> paramNode) {
/*  509 */     paramNode.previous.next = paramNode.next;
/*  510 */     paramNode.next.previous = paramNode.previous;
/*  511 */     this.size--;
/*  512 */     this.modCount++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeAllNodes() {
/*  519 */     this.header.next = this.header;
/*  520 */     this.header.previous = this.header;
/*  521 */     this.size = 0;
/*  522 */     this.modCount++;
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
/*      */   protected Node<E> getNode(int paramInt, boolean paramBoolean) throws IndexOutOfBoundsException {
/*      */     Node<E> node;
/*  538 */     if (paramInt < 0) {
/*  539 */       throw new IndexOutOfBoundsException("Couldn't get the node: index (" + paramInt + ") less than zero.");
/*      */     }
/*      */     
/*  542 */     if (!paramBoolean && paramInt == this.size) {
/*  543 */       throw new IndexOutOfBoundsException("Couldn't get the node: index (" + paramInt + ") is the size of the list.");
/*      */     }
/*      */     
/*  546 */     if (paramInt > this.size) {
/*  547 */       throw new IndexOutOfBoundsException("Couldn't get the node: index (" + paramInt + ") greater than the size of the " + "list (" + this.size + ").");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  553 */     if (paramInt < this.size / 2) {
/*      */       
/*  555 */       node = this.header.next;
/*  556 */       for (byte b = 0; b < paramInt; b++) {
/*  557 */         node = node.next;
/*      */       }
/*      */     } else {
/*      */       
/*  561 */       node = this.header;
/*  562 */       for (int i = this.size; i > paramInt; i--) {
/*  563 */         node = node.previous;
/*      */       }
/*      */     } 
/*  566 */     return node;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Iterator<E> createSubListIterator(LinkedSubList<E> paramLinkedSubList) {
/*  577 */     return createSubListListIterator(paramLinkedSubList, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ListIterator<E> createSubListListIterator(LinkedSubList<E> paramLinkedSubList, int paramInt) {
/*  588 */     return new LinkedSubListIterator<E>(paramLinkedSubList, paramInt);
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
/*      */   protected void doWriteObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/*  603 */     paramObjectOutputStream.writeInt(size());
/*  604 */     for (E e : this) {
/*  605 */       paramObjectOutputStream.writeObject(e);
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
/*      */   protected void doReadObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/*  621 */     init();
/*  622 */     int i = paramObjectInputStream.readInt();
/*  623 */     for (byte b = 0; b < i; b++) {
/*  624 */       add((E)paramObjectInputStream.readObject());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class Node<E>
/*      */   {
/*      */     protected Node<E> previous;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Node<E> next;
/*      */ 
/*      */ 
/*      */     
/*      */     protected E value;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Node() {
/*  649 */       this.previous = this;
/*  650 */       this.next = this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Node(E param1E) {
/*  660 */       this.value = param1E;
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
/*      */     protected Node(Node<E> param1Node1, Node<E> param1Node2, E param1E) {
/*  672 */       this.previous = param1Node1;
/*  673 */       this.next = param1Node2;
/*  674 */       this.value = param1E;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected E getValue() {
/*  684 */       return this.value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setValue(E param1E) {
/*  694 */       this.value = param1E;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Node<E> getPreviousNode() {
/*  704 */       return this.previous;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setPreviousNode(Node<E> param1Node) {
/*  714 */       this.previous = param1Node;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected Node<E> getNextNode() {
/*  724 */       return this.next;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void setNextNode(Node<E> param1Node) {
/*  734 */       this.next = param1Node;
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
/*      */   protected static class LinkedListIterator<E>
/*      */     implements ListIterator<E>, OrderedIterator<E>
/*      */   {
/*      */     protected final AbstractLinkedList<E> parent;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected AbstractLinkedList.Node<E> next;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected int nextIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected AbstractLinkedList.Node<E> current;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected int expectedModCount;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected LinkedListIterator(AbstractLinkedList<E> param1AbstractLinkedList, int param1Int) throws IndexOutOfBoundsException {
/*  786 */       this.parent = param1AbstractLinkedList;
/*  787 */       this.expectedModCount = param1AbstractLinkedList.modCount;
/*  788 */       this.next = param1AbstractLinkedList.getNode(param1Int, true);
/*  789 */       this.nextIndex = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void checkModCount() {
/*  800 */       if (this.parent.modCount != this.expectedModCount) {
/*  801 */         throw new ConcurrentModificationException();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected AbstractLinkedList.Node<E> getLastNodeReturned() throws IllegalStateException {
/*  813 */       if (this.current == null) {
/*  814 */         throw new IllegalStateException();
/*      */       }
/*  816 */       return this.current;
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/*  820 */       return (this.next != this.parent.header);
/*      */     }
/*      */     
/*      */     public E next() {
/*  824 */       checkModCount();
/*  825 */       if (!hasNext()) {
/*  826 */         throw new NoSuchElementException("No element at index " + this.nextIndex + ".");
/*      */       }
/*  828 */       E e = this.next.getValue();
/*  829 */       this.current = this.next;
/*  830 */       this.next = this.next.next;
/*  831 */       this.nextIndex++;
/*  832 */       return e;
/*      */     }
/*      */     
/*      */     public boolean hasPrevious() {
/*  836 */       return (this.next.previous != this.parent.header);
/*      */     }
/*      */     
/*      */     public E previous() {
/*  840 */       checkModCount();
/*  841 */       if (!hasPrevious()) {
/*  842 */         throw new NoSuchElementException("Already at start of list.");
/*      */       }
/*  844 */       this.next = this.next.previous;
/*  845 */       E e = this.next.getValue();
/*  846 */       this.current = this.next;
/*  847 */       this.nextIndex--;
/*  848 */       return e;
/*      */     }
/*      */     
/*      */     public int nextIndex() {
/*  852 */       return this.nextIndex;
/*      */     }
/*      */ 
/*      */     
/*      */     public int previousIndex() {
/*  857 */       return nextIndex() - 1;
/*      */     }
/*      */     
/*      */     public void remove() {
/*  861 */       checkModCount();
/*  862 */       if (this.current == this.next) {
/*      */         
/*  864 */         this.next = this.next.next;
/*  865 */         this.parent.removeNode(getLastNodeReturned());
/*      */       } else {
/*      */         
/*  868 */         this.parent.removeNode(getLastNodeReturned());
/*  869 */         this.nextIndex--;
/*      */       } 
/*  871 */       this.current = null;
/*  872 */       this.expectedModCount++;
/*      */     }
/*      */     
/*      */     public void set(E param1E) {
/*  876 */       checkModCount();
/*  877 */       getLastNodeReturned().setValue(param1E);
/*      */     }
/*      */     
/*      */     public void add(E param1E) {
/*  881 */       checkModCount();
/*  882 */       this.parent.addNodeBefore(this.next, param1E);
/*  883 */       this.current = null;
/*  884 */       this.nextIndex++;
/*  885 */       this.expectedModCount++;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class LinkedSubListIterator<E>
/*      */     extends LinkedListIterator<E>
/*      */   {
/*      */     protected final AbstractLinkedList.LinkedSubList<E> sub;
/*      */ 
/*      */ 
/*      */     
/*      */     protected LinkedSubListIterator(AbstractLinkedList.LinkedSubList<E> param1LinkedSubList, int param1Int) {
/*  900 */       super(param1LinkedSubList.parent, param1Int + param1LinkedSubList.offset);
/*  901 */       this.sub = param1LinkedSubList;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/*  906 */       return (nextIndex() < this.sub.size);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasPrevious() {
/*  911 */       return (previousIndex() >= 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public int nextIndex() {
/*  916 */       return super.nextIndex() - this.sub.offset;
/*      */     }
/*      */ 
/*      */     
/*      */     public void add(E param1E) {
/*  921 */       super.add(param1E);
/*  922 */       this.sub.expectedModCount = this.parent.modCount;
/*  923 */       this.sub.size++;
/*      */     }
/*      */ 
/*      */     
/*      */     public void remove() {
/*  928 */       super.remove();
/*  929 */       this.sub.expectedModCount = this.parent.modCount;
/*  930 */       this.sub.size--;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class LinkedSubList<E>
/*      */     extends AbstractList<E>
/*      */   {
/*      */     AbstractLinkedList<E> parent;
/*      */     
/*      */     int offset;
/*      */     
/*      */     int size;
/*      */     
/*      */     int expectedModCount;
/*      */ 
/*      */     
/*      */     protected LinkedSubList(AbstractLinkedList<E> param1AbstractLinkedList, int param1Int1, int param1Int2) {
/*  949 */       if (param1Int1 < 0) {
/*  950 */         throw new IndexOutOfBoundsException("fromIndex = " + param1Int1);
/*      */       }
/*  952 */       if (param1Int2 > param1AbstractLinkedList.size()) {
/*  953 */         throw new IndexOutOfBoundsException("toIndex = " + param1Int2);
/*      */       }
/*  955 */       if (param1Int1 > param1Int2) {
/*  956 */         throw new IllegalArgumentException("fromIndex(" + param1Int1 + ") > toIndex(" + param1Int2 + ")");
/*      */       }
/*  958 */       this.parent = param1AbstractLinkedList;
/*  959 */       this.offset = param1Int1;
/*  960 */       this.size = param1Int2 - param1Int1;
/*  961 */       this.expectedModCount = param1AbstractLinkedList.modCount;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/*  966 */       checkModCount();
/*  967 */       return this.size;
/*      */     }
/*      */ 
/*      */     
/*      */     public E get(int param1Int) {
/*  972 */       rangeCheck(param1Int, this.size);
/*  973 */       checkModCount();
/*  974 */       return this.parent.get(param1Int + this.offset);
/*      */     }
/*      */ 
/*      */     
/*      */     public void add(int param1Int, E param1E) {
/*  979 */       rangeCheck(param1Int, this.size + 1);
/*  980 */       checkModCount();
/*  981 */       this.parent.add(param1Int + this.offset, param1E);
/*  982 */       this.expectedModCount = this.parent.modCount;
/*  983 */       this.size++;
/*  984 */       this.modCount++;
/*      */     }
/*      */ 
/*      */     
/*      */     public E remove(int param1Int) {
/*  989 */       rangeCheck(param1Int, this.size);
/*  990 */       checkModCount();
/*  991 */       E e = this.parent.remove(param1Int + this.offset);
/*  992 */       this.expectedModCount = this.parent.modCount;
/*  993 */       this.size--;
/*  994 */       this.modCount++;
/*  995 */       return e;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean addAll(Collection<? extends E> param1Collection) {
/* 1000 */       return addAll(this.size, param1Collection);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean addAll(int param1Int, Collection<? extends E> param1Collection) {
/* 1005 */       rangeCheck(param1Int, this.size + 1);
/* 1006 */       int i = param1Collection.size();
/* 1007 */       if (i == 0) {
/* 1008 */         return false;
/*      */       }
/*      */       
/* 1011 */       checkModCount();
/* 1012 */       this.parent.addAll(this.offset + param1Int, param1Collection);
/* 1013 */       this.expectedModCount = this.parent.modCount;
/* 1014 */       this.size += i;
/* 1015 */       this.modCount++;
/* 1016 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public E set(int param1Int, E param1E) {
/* 1021 */       rangeCheck(param1Int, this.size);
/* 1022 */       checkModCount();
/* 1023 */       return this.parent.set(param1Int + this.offset, param1E);
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1028 */       checkModCount();
/* 1029 */       Iterator<E> iterator = iterator();
/* 1030 */       while (iterator.hasNext()) {
/* 1031 */         iterator.next();
/* 1032 */         iterator.remove();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<E> iterator() {
/* 1038 */       checkModCount();
/* 1039 */       return this.parent.createSubListIterator(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public ListIterator<E> listIterator(int param1Int) {
/* 1044 */       rangeCheck(param1Int, this.size + 1);
/* 1045 */       checkModCount();
/* 1046 */       return this.parent.createSubListListIterator(this, param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public List<E> subList(int param1Int1, int param1Int2) {
/* 1051 */       return new LinkedSubList(this.parent, param1Int1 + this.offset, param1Int2 + this.offset);
/*      */     }
/*      */     
/*      */     protected void rangeCheck(int param1Int1, int param1Int2) {
/* 1055 */       if (param1Int1 < 0 || param1Int1 >= param1Int2) {
/* 1056 */         throw new IndexOutOfBoundsException("Index '" + param1Int1 + "' out of bounds for size '" + this.size + "'");
/*      */       }
/*      */     }
/*      */     
/*      */     protected void checkModCount() {
/* 1061 */       if (this.parent.modCount != this.expectedModCount)
/* 1062 */         throw new ConcurrentModificationException(); 
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\AbstractLinkedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */