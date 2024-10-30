/*     */ package org.apache.commons.collections4.collection;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.Bag;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.bag.HashBag;
/*     */ import org.apache.commons.collections4.bag.PredicatedBag;
/*     */ import org.apache.commons.collections4.functors.NotNullPredicate;
/*     */ import org.apache.commons.collections4.list.PredicatedList;
/*     */ import org.apache.commons.collections4.multiset.HashMultiSet;
/*     */ import org.apache.commons.collections4.multiset.PredicatedMultiSet;
/*     */ import org.apache.commons.collections4.queue.PredicatedQueue;
/*     */ import org.apache.commons.collections4.set.PredicatedSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PredicatedCollection<E>
/*     */   extends AbstractCollectionDecorator<E>
/*     */ {
/*     */   private static final long serialVersionUID = -5259182142076705162L;
/*     */   protected final Predicate<? super E> predicate;
/*     */   
/*     */   public static <E> Builder<E> builder(Predicate<? super E> paramPredicate) {
/*  76 */     return new Builder<E>(paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Builder<E> notNullBuilder() {
/*  87 */     return new Builder<E>(NotNullPredicate.notNullPredicate());
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
/*     */   public static <T> PredicatedCollection<T> predicatedCollection(Collection<T> paramCollection, Predicate<? super T> paramPredicate) {
/* 106 */     return new PredicatedCollection<T>(paramCollection, paramPredicate);
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
/*     */   protected PredicatedCollection(Collection<E> paramCollection, Predicate<? super E> paramPredicate) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: invokespecial <init> : (Ljava/util/Collection;)V
/*     */     //   5: aload_2
/*     */     //   6: ifnonnull -> 19
/*     */     //   9: new java/lang/NullPointerException
/*     */     //   12: dup
/*     */     //   13: ldc 'Predicate must not be null.'
/*     */     //   15: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   18: athrow
/*     */     //   19: aload_0
/*     */     //   20: aload_2
/*     */     //   21: putfield predicate : Lorg/apache/commons/collections4/Predicate;
/*     */     //   24: aload_1
/*     */     //   25: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   30: astore_3
/*     */     //   31: aload_3
/*     */     //   32: invokeinterface hasNext : ()Z
/*     */     //   37: ifeq -> 57
/*     */     //   40: aload_3
/*     */     //   41: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   46: astore #4
/*     */     //   48: aload_0
/*     */     //   49: aload #4
/*     */     //   51: invokevirtual validate : (Ljava/lang/Object;)V
/*     */     //   54: goto -> 31
/*     */     //   57: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #122	-> 0
/*     */     //   #123	-> 5
/*     */     //   #124	-> 9
/*     */     //   #126	-> 19
/*     */     //   #127	-> 24
/*     */     //   #128	-> 48
/*     */     //   #129	-> 54
/*     */     //   #130	-> 57
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
/*     */   protected void validate(E paramE) {
/* 142 */     if (!this.predicate.evaluate(paramE)) {
/* 143 */       throw new IllegalArgumentException("Cannot add Object '" + paramE + "' - Predicate '" + this.predicate + "' rejected it");
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
/*     */   public boolean add(E paramE) {
/* 159 */     validate(paramE);
/* 160 */     return decorated().add(paramE);
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
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   6: astore_2
/*     */     //   7: aload_2
/*     */     //   8: invokeinterface hasNext : ()Z
/*     */     //   13: ifeq -> 31
/*     */     //   16: aload_2
/*     */     //   17: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   22: astore_3
/*     */     //   23: aload_0
/*     */     //   24: aload_3
/*     */     //   25: invokevirtual validate : (Ljava/lang/Object;)V
/*     */     //   28: goto -> 7
/*     */     //   31: aload_0
/*     */     //   32: invokevirtual decorated : ()Ljava/util/Collection;
/*     */     //   35: aload_1
/*     */     //   36: invokeinterface addAll : (Ljava/util/Collection;)Z
/*     */     //   41: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #174	-> 0
/*     */     //   #175	-> 23
/*     */     //   #176	-> 28
/*     */     //   #177	-> 31
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
/*     */   public static class Builder<E>
/*     */   {
/*     */     private final Predicate<? super E> predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 212 */     private final List<E> accepted = new ArrayList<E>();
/*     */ 
/*     */     
/* 215 */     private final List<E> rejected = new ArrayList<E>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder(Predicate<? super E> param1Predicate) {
/* 225 */       if (param1Predicate == null) {
/* 226 */         throw new NullPointerException("Predicate must not be null");
/*     */       }
/* 228 */       this.predicate = param1Predicate;
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
/*     */     public Builder<E> add(E param1E) {
/* 241 */       if (this.predicate.evaluate(param1E)) {
/* 242 */         this.accepted.add(param1E);
/*     */       } else {
/* 244 */         this.rejected.add(param1E);
/*     */       } 
/* 246 */       return this;
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
/*     */     public Builder<E> addAll(Collection<? extends E> param1Collection) {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: ifnull -> 36
/*     */       //   4: aload_1
/*     */       //   5: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */       //   10: astore_2
/*     */       //   11: aload_2
/*     */       //   12: invokeinterface hasNext : ()Z
/*     */       //   17: ifeq -> 36
/*     */       //   20: aload_2
/*     */       //   21: invokeinterface next : ()Ljava/lang/Object;
/*     */       //   26: astore_3
/*     */       //   27: aload_0
/*     */       //   28: aload_3
/*     */       //   29: invokevirtual add : (Ljava/lang/Object;)Lorg/apache/commons/collections4/collection/PredicatedCollection$Builder;
/*     */       //   32: pop
/*     */       //   33: goto -> 11
/*     */       //   36: aload_0
/*     */       //   37: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #259	-> 0
/*     */       //   #260	-> 4
/*     */       //   #261	-> 27
/*     */       //   #262	-> 33
/*     */       //   #264	-> 36
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
/*     */     public List<E> createPredicatedList() {
/* 276 */       return createPredicatedList(new ArrayList<E>());
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
/*     */     public List<E> createPredicatedList(List<E> param1List) {
/* 292 */       if (param1List == null) {
/* 293 */         throw new NullPointerException("List must not be null.");
/*     */       }
/* 295 */       PredicatedList<E> predicatedList = PredicatedList.predicatedList(param1List, this.predicate);
/* 296 */       predicatedList.addAll(this.accepted);
/* 297 */       return (List<E>)predicatedList;
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
/*     */     public Set<E> createPredicatedSet() {
/* 309 */       return createPredicatedSet(new HashSet<E>());
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
/*     */     public Set<E> createPredicatedSet(Set<E> param1Set) {
/* 325 */       if (param1Set == null) {
/* 326 */         throw new NullPointerException("Set must not be null.");
/*     */       }
/* 328 */       PredicatedSet predicatedSet = PredicatedSet.predicatedSet(param1Set, this.predicate);
/* 329 */       predicatedSet.addAll(this.accepted);
/* 330 */       return (Set<E>)predicatedSet;
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
/*     */     public MultiSet<E> createPredicatedMultiSet() {
/* 342 */       return createPredicatedMultiSet((MultiSet<E>)new HashMultiSet());
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
/*     */     public MultiSet<E> createPredicatedMultiSet(MultiSet<E> param1MultiSet) {
/* 358 */       if (param1MultiSet == null) {
/* 359 */         throw new NullPointerException("MultiSet must not be null.");
/*     */       }
/* 361 */       PredicatedMultiSet predicatedMultiSet = PredicatedMultiSet.predicatedMultiSet(param1MultiSet, this.predicate);
/*     */       
/* 363 */       predicatedMultiSet.addAll(this.accepted);
/* 364 */       return (MultiSet<E>)predicatedMultiSet;
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
/*     */     public Bag<E> createPredicatedBag() {
/* 376 */       return createPredicatedBag((Bag<E>)new HashBag());
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
/*     */     public Bag<E> createPredicatedBag(Bag<E> param1Bag) {
/* 392 */       if (param1Bag == null) {
/* 393 */         throw new NullPointerException("Bag must not be null.");
/*     */       }
/* 395 */       PredicatedBag predicatedBag = PredicatedBag.predicatedBag(param1Bag, this.predicate);
/* 396 */       predicatedBag.addAll(this.accepted);
/* 397 */       return (Bag<E>)predicatedBag;
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
/*     */     public Queue<E> createPredicatedQueue() {
/* 409 */       return createPredicatedQueue(new LinkedList<E>());
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
/*     */     public Queue<E> createPredicatedQueue(Queue<E> param1Queue) {
/* 425 */       if (param1Queue == null) {
/* 426 */         throw new NullPointerException("queue must not be null");
/*     */       }
/* 428 */       PredicatedQueue predicatedQueue = PredicatedQueue.predicatedQueue(param1Queue, this.predicate);
/* 429 */       predicatedQueue.addAll(this.accepted);
/* 430 */       return (Queue<E>)predicatedQueue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Collection<E> rejectedElements() {
/* 439 */       return Collections.unmodifiableCollection(this.rejected);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\collection\PredicatedCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */