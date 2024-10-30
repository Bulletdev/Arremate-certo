/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.collection.TransformedCollection;
/*     */ import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
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
/*     */ public class TransformedList<E>
/*     */   extends TransformedCollection<E>
/*     */   implements List<E>
/*     */ {
/*     */   private static final long serialVersionUID = 1077193035000013141L;
/*     */   
/*     */   public static <E> TransformedList<E> transformingList(List<E> paramList, Transformer<? super E, ? extends E> paramTransformer) {
/*  61 */     return new TransformedList<E>(paramList, paramTransformer);
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
/*     */   public static <E> TransformedList<E> transformedList(List<E> paramList, Transformer<? super E, ? extends E> paramTransformer) {
/*  81 */     TransformedList<E> transformedList = new TransformedList<E>(paramList, paramTransformer);
/*  82 */     if (paramList.size() > 0) {
/*     */       
/*  84 */       Object[] arrayOfObject = paramList.toArray();
/*  85 */       paramList.clear();
/*  86 */       for (Object object : arrayOfObject) {
/*  87 */         transformedList.decorated().add(paramTransformer.transform(object));
/*     */       }
/*     */     } 
/*  90 */     return transformedList;
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
/*     */   protected TransformedList(List<E> paramList, Transformer<? super E, ? extends E> paramTransformer) {
/* 105 */     super(paramList, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<E> getList() {
/* 114 */     return (List<E>)decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 119 */     return (paramObject == this || decorated().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 124 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int paramInt) {
/* 130 */     return getList().get(paramInt);
/*     */   }
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 134 */     return getList().indexOf(paramObject);
/*     */   }
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/* 138 */     return getList().lastIndexOf(paramObject);
/*     */   }
/*     */   
/*     */   public E remove(int paramInt) {
/* 142 */     return getList().remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int paramInt, E paramE) {
/* 148 */     paramE = (E)transform(paramE);
/* 149 */     getList().add(paramInt, paramE);
/*     */   }
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/* 153 */     paramCollection = transform(paramCollection);
/* 154 */     return getList().addAll(paramInt, paramCollection);
/*     */   }
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 158 */     return listIterator(0);
/*     */   }
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/* 162 */     return (ListIterator<E>)new TransformedListIterator(getList().listIterator(paramInt));
/*     */   }
/*     */   
/*     */   public E set(int paramInt, E paramE) {
/* 166 */     paramE = (E)transform(paramE);
/* 167 */     return getList().set(paramInt, paramE);
/*     */   }
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 171 */     List<E> list = getList().subList(paramInt1, paramInt2);
/* 172 */     return new TransformedList(list, this.transformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class TransformedListIterator
/*     */     extends AbstractListIteratorDecorator<E>
/*     */   {
/*     */     protected TransformedListIterator(ListIterator<E> param1ListIterator) {
/* 186 */       super(param1ListIterator);
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(E param1E) {
/* 191 */       param1E = (E)TransformedList.this.transform(param1E);
/* 192 */       getListIterator().add(param1E);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(E param1E) {
/* 197 */       param1E = (E)TransformedList.this.transform(param1E);
/* 198 */       getListIterator().set(param1E);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\TransformedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */