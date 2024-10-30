/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.collections4.OrderedIterator;
/*     */ import org.apache.commons.collections4.functors.UniquePredicate;
/*     */ import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
/*     */ import org.apache.commons.collections4.list.UnmodifiableList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListOrderedSet<E>
/*     */   extends AbstractSerializableSetDecorator<E>
/*     */ {
/*     */   private static final long serialVersionUID = -228664372470420141L;
/*     */   private final List<E> setOrder;
/*     */   
/*     */   public static <E> ListOrderedSet<E> listOrderedSet(Set<E> paramSet, List<E> paramList) {
/*  78 */     if (paramSet == null) {
/*  79 */       throw new NullPointerException("Set must not be null");
/*     */     }
/*  81 */     if (paramList == null) {
/*  82 */       throw new NullPointerException("List must not be null");
/*     */     }
/*  84 */     if (paramSet.size() > 0 || paramList.size() > 0) {
/*  85 */       throw new IllegalArgumentException("Set and List must be empty");
/*     */     }
/*  87 */     return new ListOrderedSet<E>(paramSet, paramList);
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
/*     */   public static <E> ListOrderedSet<E> listOrderedSet(Set<E> paramSet) {
/* 102 */     return new ListOrderedSet<E>(paramSet);
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
/*     */   public static <E> ListOrderedSet<E> listOrderedSet(List<E> paramList) {
/* 120 */     if (paramList == null) {
/* 121 */       throw new NullPointerException("List must not be null");
/*     */     }
/* 123 */     CollectionUtils.filter(paramList, UniquePredicate.uniquePredicate());
/* 124 */     HashSet<E> hashSet = new HashSet<E>(paramList);
/*     */     
/* 126 */     return new ListOrderedSet<E>(hashSet, paramList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListOrderedSet() {
/* 137 */     super(new HashSet<E>());
/* 138 */     this.setOrder = new ArrayList<E>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ListOrderedSet(Set<E> paramSet) {
/* 148 */     super(paramSet);
/* 149 */     this.setOrder = new ArrayList<E>(paramSet);
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
/*     */   protected ListOrderedSet(Set<E> paramSet, List<E> paramList) {
/* 163 */     super(paramSet);
/* 164 */     if (paramList == null) {
/* 165 */       throw new NullPointerException("List must not be null");
/*     */     }
/* 167 */     this.setOrder = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<E> asList() {
/* 177 */     return UnmodifiableList.unmodifiableList(this.setOrder);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 183 */     decorated().clear();
/* 184 */     this.setOrder.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public OrderedIterator<E> iterator() {
/* 189 */     return new OrderedSetIterator<E>(this.setOrder.listIterator(), decorated());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(E paramE) {
/* 194 */     if (decorated().add(paramE)) {
/* 195 */       this.setOrder.add(paramE);
/* 196 */       return true;
/*     */     } 
/* 198 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_2
/*     */     //   2: aload_1
/*     */     //   3: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   8: astore_3
/*     */     //   9: aload_3
/*     */     //   10: invokeinterface hasNext : ()Z
/*     */     //   15: ifeq -> 38
/*     */     //   18: aload_3
/*     */     //   19: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   24: astore #4
/*     */     //   26: iload_2
/*     */     //   27: aload_0
/*     */     //   28: aload #4
/*     */     //   30: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   33: ior
/*     */     //   34: istore_2
/*     */     //   35: goto -> 9
/*     */     //   38: iload_2
/*     */     //   39: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #203	-> 0
/*     */     //   #204	-> 2
/*     */     //   #205	-> 26
/*     */     //   #206	-> 35
/*     */     //   #207	-> 38
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 212 */     boolean bool = decorated().remove(paramObject);
/* 213 */     if (bool) {
/* 214 */       this.setOrder.remove(paramObject);
/*     */     }
/* 216 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 221 */     boolean bool = false;
/* 222 */     for (Object object : paramCollection) {
/* 223 */       bool |= remove(object);
/*     */     }
/* 225 */     return bool;
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
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 239 */     boolean bool = decorated().retainAll(paramCollection);
/* 240 */     if (!bool) {
/* 241 */       return false;
/*     */     }
/* 243 */     if (decorated().size() == 0) {
/* 244 */       this.setOrder.clear();
/*     */     } else {
/* 246 */       for (Iterator<E> iterator = this.setOrder.iterator(); iterator.hasNext();) {
/* 247 */         if (!decorated().contains(iterator.next())) {
/* 248 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     } 
/* 252 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] toArray() {
/* 257 */     return this.setOrder.toArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T[] toArray(T[] paramArrayOfT) {
/* 262 */     return this.setOrder.toArray(paramArrayOfT);
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
/*     */   public E get(int paramInt) {
/* 277 */     return this.setOrder.get(paramInt);
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
/*     */   public int indexOf(Object paramObject) {
/* 290 */     return this.setOrder.indexOf(paramObject);
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
/*     */   public void add(int paramInt, E paramE) {
/* 303 */     if (!contains(paramE)) {
/* 304 */       decorated().add(paramE);
/* 305 */       this.setOrder.add(paramInt, paramE);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_3
/*     */     //   2: new java/util/ArrayList
/*     */     //   5: dup
/*     */     //   6: invokespecial <init> : ()V
/*     */     //   9: astore #4
/*     */     //   11: aload_2
/*     */     //   12: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   17: astore #5
/*     */     //   19: aload #5
/*     */     //   21: invokeinterface hasNext : ()Z
/*     */     //   26: ifeq -> 77
/*     */     //   29: aload #5
/*     */     //   31: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   36: astore #6
/*     */     //   38: aload_0
/*     */     //   39: aload #6
/*     */     //   41: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   44: ifeq -> 50
/*     */     //   47: goto -> 19
/*     */     //   50: aload_0
/*     */     //   51: invokevirtual decorated : ()Ljava/util/Set;
/*     */     //   54: aload #6
/*     */     //   56: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   61: pop
/*     */     //   62: aload #4
/*     */     //   64: aload #6
/*     */     //   66: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   71: pop
/*     */     //   72: iconst_1
/*     */     //   73: istore_3
/*     */     //   74: goto -> 19
/*     */     //   77: iload_3
/*     */     //   78: ifeq -> 94
/*     */     //   81: aload_0
/*     */     //   82: getfield setOrder : Ljava/util/List;
/*     */     //   85: iload_1
/*     */     //   86: aload #4
/*     */     //   88: invokeinterface addAll : (ILjava/util/Collection;)Z
/*     */     //   93: pop
/*     */     //   94: iload_3
/*     */     //   95: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #321	-> 0
/*     */     //   #323	-> 2
/*     */     //   #324	-> 11
/*     */     //   #325	-> 38
/*     */     //   #326	-> 47
/*     */     //   #328	-> 50
/*     */     //   #329	-> 62
/*     */     //   #330	-> 72
/*     */     //   #331	-> 74
/*     */     //   #333	-> 77
/*     */     //   #334	-> 81
/*     */     //   #337	-> 94
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
/*     */   public E remove(int paramInt) {
/* 349 */     E e = this.setOrder.remove(paramInt);
/* 350 */     remove(e);
/* 351 */     return e;
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
/*     */   public String toString() {
/* 364 */     return this.setOrder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class OrderedSetIterator<E>
/*     */     extends AbstractIteratorDecorator<E>
/*     */     implements OrderedIterator<E>
/*     */   {
/*     */     private final Collection<E> set;
/*     */ 
/*     */     
/*     */     private E last;
/*     */ 
/*     */ 
/*     */     
/*     */     private OrderedSetIterator(ListIterator<E> param1ListIterator, Collection<E> param1Collection) {
/* 382 */       super(param1ListIterator);
/* 383 */       this.set = param1Collection;
/*     */     }
/*     */ 
/*     */     
/*     */     public E next() {
/* 388 */       this.last = getIterator().next();
/* 389 */       return this.last;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 394 */       this.set.remove(this.last);
/* 395 */       getIterator().remove();
/* 396 */       this.last = null;
/*     */     }
/*     */     
/*     */     public boolean hasPrevious() {
/* 400 */       return ((ListIterator)getIterator()).hasPrevious();
/*     */     }
/*     */     
/*     */     public E previous() {
/* 404 */       this.last = ((ListIterator<E>)getIterator()).previous();
/* 405 */       return this.last;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\ListOrderedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */