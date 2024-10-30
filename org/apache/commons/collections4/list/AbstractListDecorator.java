/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
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
/*     */ public abstract class AbstractListDecorator<E>
/*     */   extends AbstractCollectionDecorator<E>
/*     */   implements List<E>
/*     */ {
/*     */   private static final long serialVersionUID = 4500739654952315623L;
/*     */   
/*     */   protected AbstractListDecorator() {}
/*     */   
/*     */   protected AbstractListDecorator(List<E> paramList) {
/*  55 */     super(paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<E> decorated() {
/*  65 */     return (List<E>)super.decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  70 */     return (paramObject == this || decorated().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  75 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int paramInt, E paramE) {
/*  81 */     decorated().add(paramInt, paramE);
/*     */   }
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/*  85 */     return decorated().addAll(paramInt, paramCollection);
/*     */   }
/*     */   
/*     */   public E get(int paramInt) {
/*  89 */     return decorated().get(paramInt);
/*     */   }
/*     */   
/*     */   public int indexOf(Object paramObject) {
/*  93 */     return decorated().indexOf(paramObject);
/*     */   }
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/*  97 */     return decorated().lastIndexOf(paramObject);
/*     */   }
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 101 */     return decorated().listIterator();
/*     */   }
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/* 105 */     return decorated().listIterator(paramInt);
/*     */   }
/*     */   
/*     */   public E remove(int paramInt) {
/* 109 */     return decorated().remove(paramInt);
/*     */   }
/*     */   
/*     */   public E set(int paramInt, E paramE) {
/* 113 */     return decorated().set(paramInt, paramE);
/*     */   }
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 117 */     return decorated().subList(paramInt1, paramInt2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\AbstractListDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */