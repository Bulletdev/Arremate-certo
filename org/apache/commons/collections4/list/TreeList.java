/*      */ package org.apache.commons.collections4.list;
/*      */ 
/*      */ import java.util.AbstractList;
/*      */ import java.util.ArrayDeque;
/*      */ import java.util.Collection;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Iterator;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TreeList<E>
/*      */   extends AbstractList<E>
/*      */ {
/*      */   private AVLNode<E> root;
/*      */   private int size;
/*      */   
/*      */   public TreeList() {}
/*      */   
/*      */   public TreeList(Collection<? extends E> paramCollection) {
/*   86 */     if (!paramCollection.isEmpty()) {
/*   87 */       this.root = new AVLNode<E>(paramCollection);
/*   88 */       this.size = paramCollection.size();
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
/*      */   public E get(int paramInt) {
/*  101 */     checkInterval(paramInt, 0, size() - 1);
/*  102 */     return this.root.get(paramInt).getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  112 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<E> iterator() {
/*  123 */     return listIterator(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ListIterator<E> listIterator() {
/*  134 */     return listIterator(0);
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
/*      */   public ListIterator<E> listIterator(int paramInt) {
/*  147 */     checkInterval(paramInt, 0, size());
/*  148 */     return new TreeListIterator<E>(this, paramInt);
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
/*      */   public int indexOf(Object paramObject) {
/*  160 */     if (this.root == null) {
/*  161 */       return -1;
/*      */     }
/*  163 */     return this.root.indexOf(paramObject, this.root.relativePosition);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean contains(Object paramObject) {
/*  174 */     return (indexOf(paramObject) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object[] toArray() {
/*  185 */     Object[] arrayOfObject = new Object[size()];
/*  186 */     if (this.root != null) {
/*  187 */       this.root.toArray(arrayOfObject, this.root.relativePosition);
/*      */     }
/*  189 */     return arrayOfObject;
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
/*      */   public void add(int paramInt, E paramE) {
/*  201 */     this.modCount++;
/*  202 */     checkInterval(paramInt, 0, size());
/*  203 */     if (this.root == null) {
/*  204 */       this.root = new AVLNode<E>(paramInt, paramE, null, null);
/*      */     } else {
/*  206 */       this.root = this.root.insert(paramInt, paramE);
/*      */     } 
/*  208 */     this.size++;
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
/*      */   public boolean addAll(Collection<? extends E> paramCollection) {
/*  224 */     if (paramCollection.isEmpty()) {
/*  225 */       return false;
/*      */     }
/*  227 */     this.modCount += paramCollection.size();
/*  228 */     AVLNode<E> aVLNode = new AVLNode(paramCollection);
/*  229 */     this.root = (this.root == null) ? aVLNode : this.root.addAll(aVLNode, this.size);
/*  230 */     this.size += paramCollection.size();
/*  231 */     return true;
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
/*      */   public E set(int paramInt, E paramE) {
/*  244 */     checkInterval(paramInt, 0, size() - 1);
/*  245 */     AVLNode<E> aVLNode = this.root.get(paramInt);
/*  246 */     Object object = aVLNode.value;
/*  247 */     aVLNode.setValue(paramE);
/*  248 */     return (E)object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public E remove(int paramInt) {
/*  259 */     this.modCount++;
/*  260 */     checkInterval(paramInt, 0, size() - 1);
/*  261 */     E e = get(paramInt);
/*  262 */     this.root = this.root.remove(paramInt);
/*  263 */     this.size--;
/*  264 */     return e;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  272 */     this.modCount++;
/*  273 */     this.root = null;
/*  274 */     this.size = 0;
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
/*      */   private void checkInterval(int paramInt1, int paramInt2, int paramInt3) {
/*  287 */     if (paramInt1 < paramInt2 || paramInt1 > paramInt3) {
/*  288 */       throw new IndexOutOfBoundsException("Invalid index:" + paramInt1 + ", size=" + size());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class AVLNode<E>
/*      */   {
/*      */     private AVLNode<E> left;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean leftIsPrevious;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode<E> right;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean rightIsNext;
/*      */ 
/*      */ 
/*      */     
/*      */     private int height;
/*      */ 
/*      */ 
/*      */     
/*      */     private int relativePosition;
/*      */ 
/*      */ 
/*      */     
/*      */     private E value;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode(int param1Int, E param1E, AVLNode<E> param1AVLNode1, AVLNode<E> param1AVLNode2) {
/*  331 */       this.relativePosition = param1Int;
/*  332 */       this.value = param1E;
/*  333 */       this.rightIsNext = true;
/*  334 */       this.leftIsPrevious = true;
/*  335 */       this.right = param1AVLNode1;
/*  336 */       this.left = param1AVLNode2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode(Collection<? extends E> param1Collection) {
/*  347 */       this(param1Collection.iterator(), 0, param1Collection.size() - 1, 0, null, null);
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
/*      */     private AVLNode(Iterator<? extends E> param1Iterator, int param1Int1, int param1Int2, int param1Int3, AVLNode<E> param1AVLNode1, AVLNode<E> param1AVLNode2) {
/*  373 */       int i = param1Int1 + (param1Int2 - param1Int1) / 2;
/*  374 */       if (param1Int1 < i) {
/*  375 */         this.left = new AVLNode(param1Iterator, param1Int1, i - 1, i, param1AVLNode1, this);
/*      */       } else {
/*  377 */         this.leftIsPrevious = true;
/*  378 */         this.left = param1AVLNode1;
/*      */       } 
/*  380 */       this.value = param1Iterator.next();
/*  381 */       this.relativePosition = i - param1Int3;
/*  382 */       if (i < param1Int2) {
/*  383 */         this.right = new AVLNode(param1Iterator, i + 1, param1Int2, i, this, param1AVLNode2);
/*      */       } else {
/*  385 */         this.rightIsNext = true;
/*  386 */         this.right = param1AVLNode2;
/*      */       } 
/*  388 */       recalcHeight();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     E getValue() {
/*  397 */       return this.value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void setValue(E param1E) {
/*  406 */       this.value = param1E;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     AVLNode<E> get(int param1Int) {
/*  414 */       int i = param1Int - this.relativePosition;
/*      */       
/*  416 */       if (i == 0) {
/*  417 */         return this;
/*      */       }
/*      */       
/*  420 */       AVLNode<E> aVLNode = (i < 0) ? getLeftSubTree() : getRightSubTree();
/*  421 */       if (aVLNode == null) {
/*  422 */         return null;
/*      */       }
/*  424 */       return aVLNode.get(i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int indexOf(Object param1Object, int param1Int) {
/*  431 */       if (getLeftSubTree() != null) {
/*  432 */         int i = this.left.indexOf(param1Object, param1Int + this.left.relativePosition);
/*  433 */         if (i != -1) {
/*  434 */           return i;
/*      */         }
/*      */       } 
/*  437 */       if ((this.value == null) ? (this.value == param1Object) : this.value.equals(param1Object)) {
/*  438 */         return param1Int;
/*      */       }
/*  440 */       if (getRightSubTree() != null) {
/*  441 */         return this.right.indexOf(param1Object, param1Int + this.right.relativePosition);
/*      */       }
/*  443 */       return -1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void toArray(Object[] param1ArrayOfObject, int param1Int) {
/*  453 */       param1ArrayOfObject[param1Int] = this.value;
/*  454 */       if (getLeftSubTree() != null) {
/*  455 */         this.left.toArray(param1ArrayOfObject, param1Int + this.left.relativePosition);
/*      */       }
/*  457 */       if (getRightSubTree() != null) {
/*  458 */         this.right.toArray(param1ArrayOfObject, param1Int + this.right.relativePosition);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     AVLNode<E> next() {
/*  468 */       if (this.rightIsNext || this.right == null) {
/*  469 */         return this.right;
/*      */       }
/*  471 */       return this.right.min();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     AVLNode<E> previous() {
/*  480 */       if (this.leftIsPrevious || this.left == null) {
/*  481 */         return this.left;
/*      */       }
/*  483 */       return this.left.max();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     AVLNode<E> insert(int param1Int, E param1E) {
/*  494 */       int i = param1Int - this.relativePosition;
/*      */       
/*  496 */       if (i <= 0) {
/*  497 */         return insertOnLeft(i, param1E);
/*      */       }
/*  499 */       return insertOnRight(i, param1E);
/*      */     }
/*      */     
/*      */     private AVLNode<E> insertOnLeft(int param1Int, E param1E) {
/*  503 */       if (getLeftSubTree() == null) {
/*  504 */         setLeft(new AVLNode(-1, param1E, this, this.left), null);
/*      */       } else {
/*  506 */         setLeft(this.left.insert(param1Int, param1E), null);
/*      */       } 
/*      */       
/*  509 */       if (this.relativePosition >= 0) {
/*  510 */         this.relativePosition++;
/*      */       }
/*  512 */       AVLNode<E> aVLNode = balance();
/*  513 */       recalcHeight();
/*  514 */       return aVLNode;
/*      */     }
/*      */     
/*      */     private AVLNode<E> insertOnRight(int param1Int, E param1E) {
/*  518 */       if (getRightSubTree() == null) {
/*  519 */         setRight(new AVLNode(1, param1E, this.right, this), null);
/*      */       } else {
/*  521 */         setRight(this.right.insert(param1Int, param1E), null);
/*      */       } 
/*  523 */       if (this.relativePosition < 0) {
/*  524 */         this.relativePosition--;
/*      */       }
/*  526 */       AVLNode<E> aVLNode = balance();
/*  527 */       recalcHeight();
/*  528 */       return aVLNode;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode<E> getLeftSubTree() {
/*  536 */       return this.leftIsPrevious ? null : this.left;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode<E> getRightSubTree() {
/*  543 */       return this.rightIsNext ? null : this.right;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode<E> max() {
/*  552 */       return (getRightSubTree() == null) ? this : this.right.max();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode<E> min() {
/*  561 */       return (getLeftSubTree() == null) ? this : this.left.min();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     AVLNode<E> remove(int param1Int) {
/*  571 */       int i = param1Int - this.relativePosition;
/*      */       
/*  573 */       if (i == 0) {
/*  574 */         return removeSelf();
/*      */       }
/*  576 */       if (i > 0) {
/*  577 */         setRight(this.right.remove(i), this.right.right);
/*  578 */         if (this.relativePosition < 0) {
/*  579 */           this.relativePosition++;
/*      */         }
/*      */       } else {
/*  582 */         setLeft(this.left.remove(i), this.left.left);
/*  583 */         if (this.relativePosition > 0) {
/*  584 */           this.relativePosition--;
/*      */         }
/*      */       } 
/*  587 */       recalcHeight();
/*  588 */       return balance();
/*      */     }
/*      */     
/*      */     private AVLNode<E> removeMax() {
/*  592 */       if (getRightSubTree() == null) {
/*  593 */         return removeSelf();
/*      */       }
/*  595 */       setRight(this.right.removeMax(), this.right.right);
/*  596 */       if (this.relativePosition < 0) {
/*  597 */         this.relativePosition++;
/*      */       }
/*  599 */       recalcHeight();
/*  600 */       return balance();
/*      */     }
/*      */     
/*      */     private AVLNode<E> removeMin() {
/*  604 */       if (getLeftSubTree() == null) {
/*  605 */         return removeSelf();
/*      */       }
/*  607 */       setLeft(this.left.removeMin(), this.left.left);
/*  608 */       if (this.relativePosition > 0) {
/*  609 */         this.relativePosition--;
/*      */       }
/*  611 */       recalcHeight();
/*  612 */       return balance();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode<E> removeSelf() {
/*  621 */       if (getRightSubTree() == null && getLeftSubTree() == null) {
/*  622 */         return null;
/*      */       }
/*  624 */       if (getRightSubTree() == null) {
/*  625 */         if (this.relativePosition > 0) {
/*  626 */           this.left.relativePosition += this.relativePosition + ((this.relativePosition > 0) ? 0 : 1);
/*      */         }
/*  628 */         this.left.max().setRight(null, this.right);
/*  629 */         return this.left;
/*      */       } 
/*  631 */       if (getLeftSubTree() == null) {
/*  632 */         this.right.relativePosition += this.relativePosition - ((this.relativePosition < 0) ? 0 : 1);
/*  633 */         this.right.min().setLeft(null, this.left);
/*  634 */         return this.right;
/*      */       } 
/*      */       
/*  637 */       if (heightRightMinusLeft() > 0) {
/*      */         
/*  639 */         AVLNode<E> aVLNode = this.right.min();
/*  640 */         this.value = aVLNode.value;
/*  641 */         if (this.leftIsPrevious) {
/*  642 */           this.left = aVLNode.left;
/*      */         }
/*  644 */         this.right = this.right.removeMin();
/*  645 */         if (this.relativePosition < 0) {
/*  646 */           this.relativePosition++;
/*      */         }
/*      */       } else {
/*      */         
/*  650 */         AVLNode<E> aVLNode1 = this.left.max();
/*  651 */         this.value = aVLNode1.value;
/*  652 */         if (this.rightIsNext) {
/*  653 */           this.right = aVLNode1.right;
/*      */         }
/*  655 */         AVLNode<E> aVLNode2 = this.left.left;
/*  656 */         this.left = this.left.removeMax();
/*  657 */         if (this.left == null) {
/*      */ 
/*      */           
/*  660 */           this.left = aVLNode2;
/*  661 */           this.leftIsPrevious = true;
/*      */         } 
/*  663 */         if (this.relativePosition > 0) {
/*  664 */           this.relativePosition--;
/*      */         }
/*      */       } 
/*  667 */       recalcHeight();
/*  668 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private AVLNode<E> balance() {
/*  676 */       switch (heightRightMinusLeft()) {
/*      */         case -1:
/*      */         case 0:
/*      */         case 1:
/*  680 */           return this;
/*      */         case -2:
/*  682 */           if (this.left.heightRightMinusLeft() > 0) {
/*  683 */             setLeft(this.left.rotateLeft(), null);
/*      */           }
/*  685 */           return rotateRight();
/*      */         case 2:
/*  687 */           if (this.right.heightRightMinusLeft() < 0) {
/*  688 */             setRight(this.right.rotateRight(), null);
/*      */           }
/*  690 */           return rotateLeft();
/*      */       } 
/*  692 */       throw new RuntimeException("tree inconsistent!");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int getOffset(AVLNode<E> param1AVLNode) {
/*  700 */       if (param1AVLNode == null) {
/*  701 */         return 0;
/*      */       }
/*  703 */       return param1AVLNode.relativePosition;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int setOffset(AVLNode<E> param1AVLNode, int param1Int) {
/*  710 */       if (param1AVLNode == null) {
/*  711 */         return 0;
/*      */       }
/*  713 */       int i = getOffset(param1AVLNode);
/*  714 */       param1AVLNode.relativePosition = param1Int;
/*  715 */       return i;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void recalcHeight() {
/*  722 */       this.height = Math.max((getLeftSubTree() == null) ? -1 : (getLeftSubTree()).height, (getRightSubTree() == null) ? -1 : (getRightSubTree()).height) + 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int getHeight(AVLNode<E> param1AVLNode) {
/*  731 */       return (param1AVLNode == null) ? -1 : param1AVLNode.height;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int heightRightMinusLeft() {
/*  738 */       return getHeight(getRightSubTree()) - getHeight(getLeftSubTree());
/*      */     }
/*      */     
/*      */     private AVLNode<E> rotateLeft() {
/*  742 */       AVLNode<E> aVLNode1 = this.right;
/*  743 */       AVLNode<E> aVLNode2 = getRightSubTree().getLeftSubTree();
/*      */       
/*  745 */       int i = this.relativePosition + getOffset(aVLNode1);
/*  746 */       int j = -aVLNode1.relativePosition;
/*  747 */       int k = getOffset(aVLNode1) + getOffset(aVLNode2);
/*      */       
/*  749 */       setRight(aVLNode2, aVLNode1);
/*  750 */       aVLNode1.setLeft(this, null);
/*      */       
/*  752 */       setOffset(aVLNode1, i);
/*  753 */       setOffset(this, j);
/*  754 */       setOffset(aVLNode2, k);
/*  755 */       return aVLNode1;
/*      */     }
/*      */     
/*      */     private AVLNode<E> rotateRight() {
/*  759 */       AVLNode<E> aVLNode1 = this.left;
/*  760 */       AVLNode<E> aVLNode2 = getLeftSubTree().getRightSubTree();
/*      */       
/*  762 */       int i = this.relativePosition + getOffset(aVLNode1);
/*  763 */       int j = -aVLNode1.relativePosition;
/*  764 */       int k = getOffset(aVLNode1) + getOffset(aVLNode2);
/*      */       
/*  766 */       setLeft(aVLNode2, aVLNode1);
/*  767 */       aVLNode1.setRight(this, null);
/*      */       
/*  769 */       setOffset(aVLNode1, i);
/*  770 */       setOffset(this, j);
/*  771 */       setOffset(aVLNode2, k);
/*  772 */       return aVLNode1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void setLeft(AVLNode<E> param1AVLNode1, AVLNode<E> param1AVLNode2) {
/*  782 */       this.leftIsPrevious = (param1AVLNode1 == null);
/*  783 */       this.left = this.leftIsPrevious ? param1AVLNode2 : param1AVLNode1;
/*  784 */       recalcHeight();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void setRight(AVLNode<E> param1AVLNode1, AVLNode<E> param1AVLNode2) {
/*  794 */       this.rightIsNext = (param1AVLNode1 == null);
/*  795 */       this.right = this.rightIsNext ? param1AVLNode2 : param1AVLNode1;
/*  796 */       recalcHeight();
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
/*      */ 
/*      */     
/*      */     private AVLNode<E> addAll(AVLNode<E> param1AVLNode, int param1Int) {
/*  811 */       AVLNode<E> aVLNode1 = max();
/*  812 */       AVLNode<E> aVLNode2 = param1AVLNode.min();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  820 */       if (param1AVLNode.height > this.height) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  825 */         AVLNode<E> aVLNode4 = removeMax();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  831 */         ArrayDeque<AVLNode<E>> arrayDeque1 = new ArrayDeque();
/*  832 */         AVLNode<E> aVLNode5 = param1AVLNode;
/*  833 */         int k = aVLNode5.relativePosition + param1Int;
/*  834 */         int m = 0;
/*  835 */         while (aVLNode5 != null && aVLNode5.height > getHeight(aVLNode4)) {
/*  836 */           m = k;
/*  837 */           arrayDeque1.push(aVLNode5);
/*  838 */           aVLNode5 = aVLNode5.left;
/*  839 */           if (aVLNode5 != null) {
/*  840 */             k += aVLNode5.relativePosition;
/*      */           }
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  847 */         aVLNode1.setLeft(aVLNode4, null);
/*  848 */         aVLNode1.setRight(aVLNode5, aVLNode2);
/*  849 */         if (aVLNode4 != null) {
/*  850 */           aVLNode4.max().setRight(null, aVLNode1);
/*  851 */           aVLNode4.relativePosition -= param1Int - 1;
/*      */         } 
/*  853 */         if (aVLNode5 != null) {
/*  854 */           aVLNode5.min().setLeft(null, aVLNode1);
/*  855 */           aVLNode5.relativePosition = k - param1Int + 1;
/*      */         } 
/*  857 */         aVLNode1.relativePosition = param1Int - 1 - m;
/*  858 */         param1AVLNode.relativePosition += param1Int;
/*      */ 
/*      */         
/*  861 */         aVLNode5 = aVLNode1;
/*  862 */         while (!arrayDeque1.isEmpty()) {
/*  863 */           AVLNode<E> aVLNode = arrayDeque1.pop();
/*  864 */           aVLNode.setLeft(aVLNode5, null);
/*  865 */           aVLNode5 = aVLNode.balance();
/*      */         } 
/*  867 */         return aVLNode5;
/*      */       } 
/*  869 */       param1AVLNode = param1AVLNode.removeMin();
/*      */       
/*  871 */       ArrayDeque<AVLNode> arrayDeque = new ArrayDeque();
/*  872 */       AVLNode<E> aVLNode3 = this;
/*  873 */       int i = aVLNode3.relativePosition;
/*  874 */       int j = 0;
/*  875 */       while (aVLNode3 != null && aVLNode3.height > getHeight(param1AVLNode)) {
/*  876 */         j = i;
/*  877 */         arrayDeque.push(aVLNode3);
/*  878 */         aVLNode3 = aVLNode3.right;
/*  879 */         if (aVLNode3 != null) {
/*  880 */           i += aVLNode3.relativePosition;
/*      */         }
/*      */       } 
/*      */       
/*  884 */       aVLNode2.setRight(param1AVLNode, null);
/*  885 */       aVLNode2.setLeft(aVLNode3, aVLNode1);
/*  886 */       if (param1AVLNode != null) {
/*  887 */         param1AVLNode.min().setLeft(null, aVLNode2);
/*  888 */         param1AVLNode.relativePosition++;
/*      */       } 
/*  890 */       if (aVLNode3 != null) {
/*  891 */         aVLNode3.max().setRight(null, aVLNode2);
/*  892 */         aVLNode3.relativePosition = i - param1Int;
/*      */       } 
/*  894 */       aVLNode2.relativePosition = param1Int - j;
/*      */       
/*  896 */       aVLNode3 = aVLNode2;
/*  897 */       while (!arrayDeque.isEmpty()) {
/*  898 */         AVLNode<E> aVLNode = arrayDeque.pop();
/*  899 */         aVLNode.setRight(aVLNode3, null);
/*  900 */         aVLNode3 = aVLNode.balance();
/*      */       } 
/*  902 */       return aVLNode3;
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
/*      */     public String toString() {
/*  962 */       return "AVLNode(" + this.relativePosition + ',' + ((this.left != null) ? 1 : 0) + ',' + this.value + ',' + ((getRightSubTree() != null) ? 1 : 0) + ", faedelung " + this.rightIsNext + " )";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class TreeListIterator<E>
/*      */     implements ListIterator<E>, OrderedIterator<E>
/*      */   {
/*      */     private final TreeList<E> parent;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private TreeList.AVLNode<E> next;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int nextIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private TreeList.AVLNode<E> current;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int currentIndex;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int expectedModCount;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected TreeListIterator(TreeList<E> param1TreeList, int param1Int) throws IndexOutOfBoundsException {
/* 1017 */       this.parent = param1TreeList;
/* 1018 */       this.expectedModCount = param1TreeList.modCount;
/* 1019 */       this.next = (param1TreeList.root == null) ? null : param1TreeList.root.get(param1Int);
/* 1020 */       this.nextIndex = param1Int;
/* 1021 */       this.currentIndex = -1;
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
/* 1032 */       if (this.parent.modCount != this.expectedModCount) {
/* 1033 */         throw new ConcurrentModificationException();
/*      */       }
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/* 1038 */       return (this.nextIndex < this.parent.size());
/*      */     }
/*      */     
/*      */     public E next() {
/* 1042 */       checkModCount();
/* 1043 */       if (!hasNext()) {
/* 1044 */         throw new NoSuchElementException("No element at index " + this.nextIndex + ".");
/*      */       }
/* 1046 */       if (this.next == null) {
/* 1047 */         this.next = this.parent.root.get(this.nextIndex);
/*      */       }
/* 1049 */       E e = this.next.getValue();
/* 1050 */       this.current = this.next;
/* 1051 */       this.currentIndex = this.nextIndex++;
/* 1052 */       this.next = this.next.next();
/* 1053 */       return e;
/*      */     }
/*      */     
/*      */     public boolean hasPrevious() {
/* 1057 */       return (this.nextIndex > 0);
/*      */     }
/*      */     
/*      */     public E previous() {
/* 1061 */       checkModCount();
/* 1062 */       if (!hasPrevious()) {
/* 1063 */         throw new NoSuchElementException("Already at start of list.");
/*      */       }
/* 1065 */       if (this.next == null) {
/* 1066 */         this.next = this.parent.root.get(this.nextIndex - 1);
/*      */       } else {
/* 1068 */         this.next = this.next.previous();
/*      */       } 
/* 1070 */       E e = this.next.getValue();
/* 1071 */       this.current = this.next;
/* 1072 */       this.currentIndex = --this.nextIndex;
/* 1073 */       return e;
/*      */     }
/*      */     
/*      */     public int nextIndex() {
/* 1077 */       return this.nextIndex;
/*      */     }
/*      */     
/*      */     public int previousIndex() {
/* 1081 */       return nextIndex() - 1;
/*      */     }
/*      */     
/*      */     public void remove() {
/* 1085 */       checkModCount();
/* 1086 */       if (this.currentIndex == -1) {
/* 1087 */         throw new IllegalStateException();
/*      */       }
/* 1089 */       this.parent.remove(this.currentIndex);
/* 1090 */       if (this.nextIndex != this.currentIndex)
/*      */       {
/* 1092 */         this.nextIndex--;
/*      */       }
/*      */ 
/*      */       
/* 1096 */       this.next = null;
/* 1097 */       this.current = null;
/* 1098 */       this.currentIndex = -1;
/* 1099 */       this.expectedModCount++;
/*      */     }
/*      */     
/*      */     public void set(E param1E) {
/* 1103 */       checkModCount();
/* 1104 */       if (this.current == null) {
/* 1105 */         throw new IllegalStateException();
/*      */       }
/* 1107 */       this.current.setValue(param1E);
/*      */     }
/*      */     
/*      */     public void add(E param1E) {
/* 1111 */       checkModCount();
/* 1112 */       this.parent.add(this.nextIndex, param1E);
/* 1113 */       this.current = null;
/* 1114 */       this.currentIndex = -1;
/* 1115 */       this.nextIndex++;
/* 1116 */       this.expectedModCount++;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\TreeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */