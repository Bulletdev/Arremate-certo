/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
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
/*     */ public class CursorableLinkedList<E>
/*     */   extends AbstractLinkedList<E>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8836393098519411393L;
/*     */   private transient List<WeakReference<Cursor<E>>> cursors;
/*     */   
/*     */   public CursorableLinkedList() {
/*  72 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CursorableLinkedList(Collection<? extends E> paramCollection) {
/*  81 */     super(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init() {
/*  90 */     super.init();
/*  91 */     this.cursors = new ArrayList<WeakReference<Cursor<E>>>();
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
/*     */   
/*     */   public Iterator<E> iterator() {
/* 106 */     return super.listIterator(0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 126 */     return cursor(0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/* 147 */     return cursor(paramInt);
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
/*     */   public Cursor<E> cursor() {
/* 174 */     return cursor(0);
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
/*     */   public Cursor<E> cursor(int paramInt) {
/* 205 */     Cursor<E> cursor = new Cursor(this, paramInt);
/* 206 */     registerCursor(cursor);
/* 207 */     return cursor;
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
/*     */   protected void updateNode(AbstractLinkedList.Node<E> paramNode, E paramE) {
/* 221 */     super.updateNode(paramNode, paramE);
/* 222 */     broadcastNodeChanged(paramNode);
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
/*     */   protected void addNode(AbstractLinkedList.Node<E> paramNode1, AbstractLinkedList.Node<E> paramNode2) {
/* 234 */     super.addNode(paramNode1, paramNode2);
/* 235 */     broadcastNodeInserted(paramNode1);
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
/* 246 */     super.removeNode(paramNode);
/* 247 */     broadcastNodeRemoved(paramNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAllNodes() {
/* 255 */     if (size() > 0) {
/*     */       
/* 257 */       Iterator<E> iterator = iterator();
/* 258 */       while (iterator.hasNext()) {
/* 259 */         iterator.next();
/* 260 */         iterator.remove();
/*     */       } 
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
/*     */   
/*     */   protected void registerCursor(Cursor<E> paramCursor) {
/* 274 */     for (Iterator<WeakReference<Cursor<E>>> iterator = this.cursors.iterator(); iterator.hasNext(); ) {
/* 275 */       WeakReference weakReference = iterator.next();
/* 276 */       if (weakReference.get() == null) {
/* 277 */         iterator.remove();
/*     */       }
/*     */     } 
/* 280 */     this.cursors.add(new WeakReference<Cursor<E>>(paramCursor));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void unregisterCursor(Cursor<E> paramCursor) {
/* 289 */     for (Iterator<WeakReference<Cursor<E>>> iterator = this.cursors.iterator(); iterator.hasNext(); ) {
/* 290 */       WeakReference<Cursor> weakReference = (WeakReference)iterator.next();
/* 291 */       Cursor<E> cursor = weakReference.get();
/* 292 */       if (cursor == null) {
/*     */ 
/*     */ 
/*     */         
/* 296 */         iterator.remove(); continue;
/* 297 */       }  if (cursor == paramCursor) {
/* 298 */         weakReference.clear();
/* 299 */         iterator.remove();
/*     */         break;
/*     */       } 
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
/*     */   protected void broadcastNodeChanged(AbstractLinkedList.Node<E> paramNode) {
/* 313 */     Iterator<WeakReference<Cursor<E>>> iterator = this.cursors.iterator();
/* 314 */     while (iterator.hasNext()) {
/* 315 */       WeakReference<Cursor> weakReference = (WeakReference)iterator.next();
/* 316 */       Cursor<E> cursor = weakReference.get();
/* 317 */       if (cursor == null) {
/* 318 */         iterator.remove(); continue;
/*     */       } 
/* 320 */       cursor.nodeChanged(paramNode);
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
/*     */   protected void broadcastNodeRemoved(AbstractLinkedList.Node<E> paramNode) {
/* 332 */     Iterator<WeakReference<Cursor<E>>> iterator = this.cursors.iterator();
/* 333 */     while (iterator.hasNext()) {
/* 334 */       WeakReference<Cursor> weakReference = (WeakReference)iterator.next();
/* 335 */       Cursor<E> cursor = weakReference.get();
/* 336 */       if (cursor == null) {
/* 337 */         iterator.remove(); continue;
/*     */       } 
/* 339 */       cursor.nodeRemoved(paramNode);
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
/*     */   protected void broadcastNodeInserted(AbstractLinkedList.Node<E> paramNode) {
/* 351 */     Iterator<WeakReference<Cursor<E>>> iterator = this.cursors.iterator();
/* 352 */     while (iterator.hasNext()) {
/* 353 */       WeakReference<Cursor> weakReference = (WeakReference)iterator.next();
/* 354 */       Cursor<E> cursor = weakReference.get();
/* 355 */       if (cursor == null) {
/* 356 */         iterator.remove(); continue;
/*     */       } 
/* 358 */       cursor.nodeInserted(paramNode);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 368 */     paramObjectOutputStream.defaultWriteObject();
/* 369 */     doWriteObject(paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 376 */     paramObjectInputStream.defaultReadObject();
/* 377 */     doReadObject(paramObjectInputStream);
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
/*     */   protected ListIterator<E> createSubListListIterator(AbstractLinkedList.LinkedSubList<E> paramLinkedSubList, int paramInt) {
/* 390 */     SubCursor<E> subCursor = new SubCursor<E>(paramLinkedSubList, paramInt);
/* 391 */     registerCursor(subCursor);
/* 392 */     return subCursor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Cursor<E>
/*     */     extends AbstractLinkedList.LinkedListIterator<E>
/*     */   {
/*     */     boolean valid = true;
/*     */ 
/*     */ 
/*     */     
/*     */     boolean nextIndexValid = true;
/*     */ 
/*     */ 
/*     */     
/*     */     boolean currentRemovedByAnother = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Cursor(CursorableLinkedList<E> param1CursorableLinkedList, int param1Int) {
/* 415 */       super(param1CursorableLinkedList, param1Int);
/* 416 */       this.valid = true;
/*     */     }
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
/*     */     public void remove() {
/* 434 */       if (this.current != null || !this.currentRemovedByAnother) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 440 */         checkModCount();
/* 441 */         this.parent.removeNode(getLastNodeReturned());
/*     */       } 
/* 443 */       this.currentRemovedByAnother = false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void add(E param1E) {
/* 455 */       super.add(param1E);
/*     */ 
/*     */       
/* 458 */       this.next = this.next.next;
/*     */     }
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
/*     */     public int nextIndex() {
/* 473 */       if (!this.nextIndexValid) {
/* 474 */         if (this.next == this.parent.header) {
/* 475 */           this.nextIndex = this.parent.size();
/*     */         } else {
/* 477 */           byte b = 0;
/* 478 */           AbstractLinkedList.Node<E> node = this.parent.header.next;
/* 479 */           while (node != this.next) {
/* 480 */             b++;
/* 481 */             node = node.next;
/*     */           } 
/* 483 */           this.nextIndex = b;
/*     */         } 
/* 485 */         this.nextIndexValid = true;
/*     */       } 
/* 487 */       return this.nextIndex;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void nodeChanged(AbstractLinkedList.Node<E> param1Node) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void nodeRemoved(AbstractLinkedList.Node<E> param1Node) {
/* 505 */       if (param1Node == this.next && param1Node == this.current) {
/*     */         
/* 507 */         this.next = param1Node.next;
/* 508 */         this.current = null;
/* 509 */         this.currentRemovedByAnother = true;
/* 510 */       } else if (param1Node == this.next) {
/*     */ 
/*     */         
/* 513 */         this.next = param1Node.next;
/* 514 */         this.currentRemovedByAnother = false;
/* 515 */       } else if (param1Node == this.current) {
/*     */ 
/*     */         
/* 518 */         this.current = null;
/* 519 */         this.currentRemovedByAnother = true;
/* 520 */         this.nextIndex--;
/*     */       } else {
/* 522 */         this.nextIndexValid = false;
/* 523 */         this.currentRemovedByAnother = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void nodeInserted(AbstractLinkedList.Node<E> param1Node) {
/* 533 */       if (param1Node.previous == this.current) {
/* 534 */         this.next = param1Node;
/* 535 */       } else if (this.next.previous == param1Node) {
/* 536 */         this.next = param1Node;
/*     */       } else {
/* 538 */         this.nextIndexValid = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void checkModCount() {
/* 547 */       if (!this.valid) {
/* 548 */         throw new ConcurrentModificationException("Cursor closed");
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void close() {
/* 561 */       if (this.valid) {
/* 562 */         ((CursorableLinkedList)this.parent).unregisterCursor(this);
/* 563 */         this.valid = false;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class SubCursor<E>
/*     */     extends Cursor<E>
/*     */   {
/*     */     protected final AbstractLinkedList.LinkedSubList<E> sub;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected SubCursor(AbstractLinkedList.LinkedSubList<E> param1LinkedSubList, int param1Int) {
/* 586 */       super((CursorableLinkedList<E>)param1LinkedSubList.parent, param1Int + param1LinkedSubList.offset);
/* 587 */       this.sub = param1LinkedSubList;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 592 */       return (nextIndex() < this.sub.size);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasPrevious() {
/* 597 */       return (previousIndex() >= 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public int nextIndex() {
/* 602 */       return super.nextIndex() - this.sub.offset;
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(E param1E) {
/* 607 */       super.add(param1E);
/* 608 */       this.sub.expectedModCount = this.parent.modCount;
/* 609 */       this.sub.size++;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 614 */       super.remove();
/* 615 */       this.sub.expectedModCount = this.parent.modCount;
/* 616 */       this.sub.size--;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\CursorableLinkedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */