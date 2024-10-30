/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableIterator;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
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
/*     */ public final class UnmodifiableList<E>
/*     */   extends AbstractSerializableListDecorator<E>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = 6595182819922443652L;
/*     */   
/*     */   public static <E> List<E> unmodifiableList(List<? extends E> paramList) {
/*  55 */     if (paramList instanceof Unmodifiable)
/*     */     {
/*  57 */       return (List)paramList;
/*     */     }
/*     */     
/*  60 */     return new UnmodifiableList<E>(paramList);
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
/*     */   public UnmodifiableList(List<? extends E> paramList) {
/*  72 */     super((List)paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/*  78 */     return UnmodifiableIterator.unmodifiableIterator(decorated().iterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(Object paramObject) {
/*  83 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/*  88 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  93 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/*  98 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 103 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 108 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 114 */     return UnmodifiableListIterator.umodifiableListIterator(decorated().listIterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/* 119 */     return UnmodifiableListIterator.umodifiableListIterator(decorated().listIterator(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int paramInt, E paramE) {
/* 124 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/* 129 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public E remove(int paramInt) {
/* 134 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public E set(int paramInt, E paramE) {
/* 139 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 144 */     List<E> list = decorated().subList(paramInt1, paramInt2);
/* 145 */     return new UnmodifiableList(list);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\UnmodifiableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */