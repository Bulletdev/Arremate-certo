/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.collection.PredicatedCollection;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PredicatedList<E>
/*     */   extends PredicatedCollection<E>
/*     */   implements List<E>
/*     */ {
/*     */   private static final long serialVersionUID = -5722039223898659102L;
/*     */   
/*     */   public static <T> PredicatedList<T> predicatedList(List<T> paramList, Predicate<? super T> paramPredicate) {
/*  68 */     return new PredicatedList<T>(paramList, paramPredicate);
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
/*     */   protected PredicatedList(List<E> paramList, Predicate<? super E> paramPredicate) {
/*  84 */     super(paramList, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<E> decorated() {
/*  94 */     return (List<E>)super.decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  99 */     return (paramObject == this || decorated().equals(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 104 */     return decorated().hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E get(int paramInt) {
/* 110 */     return decorated().get(paramInt);
/*     */   }
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 114 */     return decorated().indexOf(paramObject);
/*     */   }
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/* 118 */     return decorated().lastIndexOf(paramObject);
/*     */   }
/*     */   
/*     */   public E remove(int paramInt) {
/* 122 */     return decorated().remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int paramInt, E paramE) {
/* 128 */     validate(paramE);
/* 129 */     decorated().add(paramInt, paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   6: astore_3
/*     */     //   7: aload_3
/*     */     //   8: invokeinterface hasNext : ()Z
/*     */     //   13: ifeq -> 33
/*     */     //   16: aload_3
/*     */     //   17: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   22: astore #4
/*     */     //   24: aload_0
/*     */     //   25: aload #4
/*     */     //   27: invokevirtual validate : (Ljava/lang/Object;)V
/*     */     //   30: goto -> 7
/*     */     //   33: aload_0
/*     */     //   34: invokevirtual decorated : ()Ljava/util/List;
/*     */     //   37: iload_1
/*     */     //   38: aload_2
/*     */     //   39: invokeinterface addAll : (ILjava/util/Collection;)Z
/*     */     //   44: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #133	-> 0
/*     */     //   #134	-> 24
/*     */     //   #135	-> 30
/*     */     //   #136	-> 33
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 140 */     return listIterator(0);
/*     */   }
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/* 144 */     return (ListIterator<E>)new PredicatedListIterator(decorated().listIterator(paramInt));
/*     */   }
/*     */   
/*     */   public E set(int paramInt, E paramE) {
/* 148 */     validate(paramE);
/* 149 */     return decorated().set(paramInt, paramE);
/*     */   }
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 153 */     List<E> list = decorated().subList(paramInt1, paramInt2);
/* 154 */     return new PredicatedList(list, this.predicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class PredicatedListIterator
/*     */     extends AbstractListIteratorDecorator<E>
/*     */   {
/*     */     protected PredicatedListIterator(ListIterator<E> param1ListIterator) {
/* 168 */       super(param1ListIterator);
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(E param1E) {
/* 173 */       PredicatedList.this.validate(param1E);
/* 174 */       getListIterator().add(param1E);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(E param1E) {
/* 179 */       PredicatedList.this.validate(param1E);
/* 180 */       getListIterator().set(param1E);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\PredicatedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */