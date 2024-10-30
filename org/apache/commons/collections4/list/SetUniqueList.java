/*     */ package org.apache.commons.collections4.list;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.ListUtils;
/*     */ import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
/*     */ import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
/*     */ import org.apache.commons.collections4.set.UnmodifiableSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SetUniqueList<E>
/*     */   extends AbstractSerializableListDecorator<E>
/*     */ {
/*     */   private static final long serialVersionUID = 7196982186153478694L;
/*     */   private final Set<E> set;
/*     */   
/*     */   public static <E> SetUniqueList<E> setUniqueList(List<E> paramList) {
/*  72 */     if (paramList == null) {
/*  73 */       throw new NullPointerException("List must not be null");
/*     */     }
/*  75 */     if (paramList.isEmpty()) {
/*  76 */       return new SetUniqueList<E>(paramList, new HashSet<E>());
/*     */     }
/*  78 */     ArrayList<E> arrayList = new ArrayList<E>(paramList);
/*  79 */     paramList.clear();
/*  80 */     SetUniqueList<E> setUniqueList = new SetUniqueList<E>(paramList, new HashSet<E>());
/*  81 */     setUniqueList.addAll(arrayList);
/*  82 */     return setUniqueList;
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
/*     */   protected SetUniqueList(List<E> paramList, Set<E> paramSet) {
/*  96 */     super(paramList);
/*  97 */     if (paramSet == null) {
/*  98 */       throw new NullPointerException("Set must not be null");
/*     */     }
/* 100 */     this.set = paramSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<E> asSet() {
/* 110 */     return UnmodifiableSet.unmodifiableSet(this.set);
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
/*     */   public boolean add(E paramE) {
/* 127 */     int i = size();
/*     */ 
/*     */     
/* 130 */     add(size(), paramE);
/*     */ 
/*     */     
/* 133 */     return (i != size());
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
/*     */   public void add(int paramInt, E paramE) {
/* 150 */     if (!this.set.contains(paramE)) {
/* 151 */       super.add(paramInt, paramE);
/* 152 */       this.set.add(paramE);
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
/*     */   public boolean addAll(Collection<? extends E> paramCollection) {
/* 171 */     return addAll(size(), paramCollection);
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
/*     */     //   0: new java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_3
/*     */     //   8: aload_2
/*     */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore #4
/*     */     //   16: aload #4
/*     */     //   18: invokeinterface hasNext : ()Z
/*     */     //   23: ifeq -> 61
/*     */     //   26: aload #4
/*     */     //   28: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   33: astore #5
/*     */     //   35: aload_0
/*     */     //   36: getfield set : Ljava/util/Set;
/*     */     //   39: aload #5
/*     */     //   41: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   46: ifeq -> 58
/*     */     //   49: aload_3
/*     */     //   50: aload #5
/*     */     //   52: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   57: pop
/*     */     //   58: goto -> 16
/*     */     //   61: aload_0
/*     */     //   62: iload_1
/*     */     //   63: aload_3
/*     */     //   64: invokespecial addAll : (ILjava/util/Collection;)Z
/*     */     //   67: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #191	-> 0
/*     */     //   #192	-> 8
/*     */     //   #193	-> 35
/*     */     //   #194	-> 49
/*     */     //   #196	-> 58
/*     */     //   #197	-> 61
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
/*     */   public E set(int paramInt, E paramE) {
/* 214 */     int i = indexOf(paramE);
/* 215 */     E e = super.set(paramInt, paramE);
/*     */     
/* 217 */     if (i != -1 && i != paramInt)
/*     */     {
/*     */       
/* 220 */       super.remove(i);
/*     */     }
/*     */     
/* 223 */     this.set.remove(e);
/* 224 */     this.set.add(paramE);
/*     */     
/* 226 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 231 */     boolean bool = this.set.remove(paramObject);
/* 232 */     if (bool) {
/* 233 */       super.remove(paramObject);
/*     */     }
/* 235 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public E remove(int paramInt) {
/* 240 */     E e = super.remove(paramInt);
/* 241 */     this.set.remove(e);
/* 242 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 247 */     boolean bool = false;
/* 248 */     for (Object object : paramCollection) {
/* 249 */       bool |= remove(object);
/*     */     }
/* 251 */     return bool;
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
/* 265 */     boolean bool = this.set.retainAll(paramCollection);
/* 266 */     if (!bool) {
/* 267 */       return false;
/*     */     }
/* 269 */     if (this.set.size() == 0) {
/* 270 */       super.clear();
/*     */     } else {
/*     */       
/* 273 */       super.retainAll(this.set);
/*     */     } 
/* 275 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 280 */     super.clear();
/* 281 */     this.set.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 286 */     return this.set.contains(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsAll(Collection<?> paramCollection) {
/* 291 */     return this.set.containsAll(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 296 */     return (Iterator<E>)new SetListIterator<E>(super.iterator(), this.set);
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator() {
/* 301 */     return (ListIterator<E>)new SetListListIterator<E>(super.listIterator(), this.set);
/*     */   }
/*     */ 
/*     */   
/*     */   public ListIterator<E> listIterator(int paramInt) {
/* 306 */     return (ListIterator<E>)new SetListListIterator<E>(super.listIterator(paramInt), this.set);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<E> subList(int paramInt1, int paramInt2) {
/* 317 */     List<E> list = super.subList(paramInt1, paramInt2);
/* 318 */     Set<E> set = createSetBasedOnList(this.set, list);
/* 319 */     return ListUtils.unmodifiableList(new SetUniqueList(list, set));
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
/*     */   protected Set<E> createSetBasedOnList(Set<E> paramSet, List<E> paramList) {
/*     */     Set<E> set;
/* 334 */     if (paramSet.getClass().equals(HashSet.class)) {
/* 335 */       set = new HashSet(paramList.size());
/*     */     } else {
/*     */       try {
/* 338 */         set = (Set)paramSet.getClass().newInstance();
/* 339 */       } catch (InstantiationException instantiationException) {
/* 340 */         set = new HashSet();
/* 341 */       } catch (IllegalAccessException illegalAccessException) {
/* 342 */         set = new HashSet();
/*     */       } 
/*     */     } 
/* 345 */     set.addAll(paramList);
/* 346 */     return set;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class SetListIterator<E>
/*     */     extends AbstractIteratorDecorator<E>
/*     */   {
/*     */     private final Set<E> set;
/*     */     
/* 356 */     private E last = null;
/*     */     
/*     */     protected SetListIterator(Iterator<E> param1Iterator, Set<E> param1Set) {
/* 359 */       super(param1Iterator);
/* 360 */       this.set = param1Set;
/*     */     }
/*     */ 
/*     */     
/*     */     public E next() {
/* 365 */       this.last = (E)super.next();
/* 366 */       return this.last;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 371 */       super.remove();
/* 372 */       this.set.remove(this.last);
/* 373 */       this.last = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class SetListListIterator<E>
/*     */     extends AbstractListIteratorDecorator<E>
/*     */   {
/*     */     private final Set<E> set;
/*     */     
/* 384 */     private E last = null;
/*     */     
/*     */     protected SetListListIterator(ListIterator<E> param1ListIterator, Set<E> param1Set) {
/* 387 */       super(param1ListIterator);
/* 388 */       this.set = param1Set;
/*     */     }
/*     */ 
/*     */     
/*     */     public E next() {
/* 393 */       this.last = (E)super.next();
/* 394 */       return this.last;
/*     */     }
/*     */ 
/*     */     
/*     */     public E previous() {
/* 399 */       this.last = (E)super.previous();
/* 400 */       return this.last;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 405 */       super.remove();
/* 406 */       this.set.remove(this.last);
/* 407 */       this.last = null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(E param1E) {
/* 412 */       if (!this.set.contains(param1E)) {
/* 413 */         super.add(param1E);
/* 414 */         this.set.add(param1E);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(E param1E) {
/* 420 */       throw new UnsupportedOperationException("ListIterator does not support set");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\list\SetUniqueList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */