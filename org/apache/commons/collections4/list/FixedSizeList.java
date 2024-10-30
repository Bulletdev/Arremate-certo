/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.apache.commons.collections4.BoundedCollection;
/*     */ import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableIterator;
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
/*     */ public class FixedSizeList<E>
/*     */   extends AbstractSerializableListDecorator<E>
/*     */   implements BoundedCollection<E>
/*     */ {
/*     */   private static final long serialVersionUID = -2218010673611160319L;
/*     */   
/*     */   public static <E> FixedSizeList<E> fixedSizeList(List<E> paramList) {
/*  56 */     return new FixedSizeList<E>(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FixedSizeList(List<E> paramList) {
/*  67 */     super(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/*  73 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int paramInt, E paramE) {
/*  78 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/*  83 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/*  88 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  93 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public E get(int paramInt) {
/*  98 */     return decorated().get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 103 */     return decorated().indexOf(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 108 */     return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/* 113 */     return decorated().lastIndexOf(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 118 */     return (ListIterator<E>)new FixedSizeListIterator(decorated().listIterator(0));
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/* 123 */     return (ListIterator<E>)new FixedSizeListIterator(decorated().listIterator(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public E remove(int paramInt) {
/* 128 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 133 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 138 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 143 */     throw new UnsupportedOperationException("List is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public E set(int paramInt, E paramE) {
/* 148 */     return decorated().set(paramInt, paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 153 */     List<E> list = decorated().subList(paramInt1, paramInt2);
/* 154 */     return new FixedSizeList(list);
/*     */   }
/*     */ 
/*     */   
/*     */   private class FixedSizeListIterator
/*     */     extends AbstractListIteratorDecorator<E>
/*     */   {
/*     */     protected FixedSizeListIterator(ListIterator<E> param1ListIterator) {
/* 162 */       super(param1ListIterator);
/*     */     }
/*     */     
/*     */     public void remove() {
/* 166 */       throw new UnsupportedOperationException("List is fixed size");
/*     */     }
/*     */     
/*     */     public void add(Object param1Object) {
/* 170 */       throw new UnsupportedOperationException("List is fixed size");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isFull() {
/* 175 */     return true;
/*     */   }
/*     */   
/*     */   public int maxSize() {
/* 179 */     return size();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\FixedSizeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */