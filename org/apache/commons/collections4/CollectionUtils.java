/*      */ package org.apache.commons.collections4;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Comparator;
/*      */ import java.util.Enumeration;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.collections4.collection.PredicatedCollection;
/*      */ import org.apache.commons.collections4.collection.SynchronizedCollection;
/*      */ import org.apache.commons.collections4.collection.TransformedCollection;
/*      */ import org.apache.commons.collections4.collection.UnmodifiableBoundedCollection;
/*      */ import org.apache.commons.collections4.collection.UnmodifiableCollection;
/*      */ import org.apache.commons.collections4.functors.TruePredicate;
/*      */ import org.apache.commons.collections4.iterators.CollatingIterator;
/*      */ import org.apache.commons.collections4.iterators.PermutationIterator;
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
/*      */ public class CollectionUtils
/*      */ {
/*      */   private static class CardinalityHelper<O>
/*      */   {
/*      */     final Map<O, Integer> cardinalityA;
/*      */     final Map<O, Integer> cardinalityB;
/*      */     
/*      */     public CardinalityHelper(Iterable<? extends O> param1Iterable1, Iterable<? extends O> param1Iterable2) {
/*   75 */       this.cardinalityA = CollectionUtils.getCardinalityMap(param1Iterable1);
/*   76 */       this.cardinalityB = CollectionUtils.getCardinalityMap(param1Iterable2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int max(Object param1Object) {
/*   85 */       return Math.max(freqA(param1Object), freqB(param1Object));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int min(Object param1Object) {
/*   94 */       return Math.min(freqA(param1Object), freqB(param1Object));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int freqA(Object param1Object) {
/*  103 */       return getFreq(param1Object, this.cardinalityA);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int freqB(Object param1Object) {
/*  112 */       return getFreq(param1Object, this.cardinalityB);
/*      */     }
/*      */     
/*      */     private final int getFreq(Object param1Object, Map<?, Integer> param1Map) {
/*  116 */       Integer integer = param1Map.get(param1Object);
/*  117 */       if (integer != null) {
/*  118 */         return integer.intValue();
/*      */       }
/*  120 */       return 0;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class SetOperationCardinalityHelper<O>
/*      */     extends CardinalityHelper<O>
/*      */     implements Iterable<O>
/*      */   {
/*      */     private final Set<O> elements;
/*      */ 
/*      */ 
/*      */     
/*      */     private final List<O> newList;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SetOperationCardinalityHelper(Iterable<? extends O> param1Iterable1, Iterable<? extends O> param1Iterable2) {
/*  142 */       super(param1Iterable1, param1Iterable2);
/*  143 */       this.elements = new HashSet<O>();
/*  144 */       CollectionUtils.addAll(this.elements, param1Iterable1);
/*  145 */       CollectionUtils.addAll(this.elements, param1Iterable2);
/*      */       
/*  147 */       this.newList = new ArrayList<O>(this.elements.size());
/*      */     }
/*      */     
/*      */     public Iterator<O> iterator() {
/*  151 */       return this.elements.iterator();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setCardinality(O param1O, int param1Int) {
/*  160 */       for (byte b = 0; b < param1Int; b++) {
/*  161 */         this.newList.add(param1O);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Collection<O> list() {
/*  170 */       return this.newList;
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
/*  182 */   public static final Collection EMPTY_COLLECTION = UnmodifiableCollection.unmodifiableCollection(new ArrayList());
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
/*      */   public static <T> Collection<T> emptyCollection() {
/*  200 */     return EMPTY_COLLECTION;
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
/*      */   public static <T> Collection<T> emptyIfNull(Collection<T> paramCollection) {
/*  213 */     return (paramCollection == null) ? EMPTY_COLLECTION : paramCollection;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O> Collection<O> union(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2) {
/*      */     // Byte code:
/*      */     //   0: new org/apache/commons/collections4/CollectionUtils$SetOperationCardinalityHelper
/*      */     //   3: dup
/*      */     //   4: aload_0
/*      */     //   5: aload_1
/*      */     //   6: invokespecial <init> : (Ljava/lang/Iterable;Ljava/lang/Iterable;)V
/*      */     //   9: astore_2
/*      */     //   10: aload_2
/*      */     //   11: invokevirtual iterator : ()Ljava/util/Iterator;
/*      */     //   14: astore_3
/*      */     //   15: aload_3
/*      */     //   16: invokeinterface hasNext : ()Z
/*      */     //   21: ifeq -> 47
/*      */     //   24: aload_3
/*      */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   30: astore #4
/*      */     //   32: aload_2
/*      */     //   33: aload #4
/*      */     //   35: aload_2
/*      */     //   36: aload #4
/*      */     //   38: invokevirtual max : (Ljava/lang/Object;)I
/*      */     //   41: invokevirtual setCardinality : (Ljava/lang/Object;I)V
/*      */     //   44: goto -> 15
/*      */     //   47: aload_2
/*      */     //   48: invokevirtual list : ()Ljava/util/Collection;
/*      */     //   51: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #232	-> 0
/*      */     //   #233	-> 10
/*      */     //   #234	-> 32
/*      */     //   #235	-> 44
/*      */     //   #236	-> 47
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O> Collection<O> intersection(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2) {
/*      */     // Byte code:
/*      */     //   0: new org/apache/commons/collections4/CollectionUtils$SetOperationCardinalityHelper
/*      */     //   3: dup
/*      */     //   4: aload_0
/*      */     //   5: aload_1
/*      */     //   6: invokespecial <init> : (Ljava/lang/Iterable;Ljava/lang/Iterable;)V
/*      */     //   9: astore_2
/*      */     //   10: aload_2
/*      */     //   11: invokevirtual iterator : ()Ljava/util/Iterator;
/*      */     //   14: astore_3
/*      */     //   15: aload_3
/*      */     //   16: invokeinterface hasNext : ()Z
/*      */     //   21: ifeq -> 47
/*      */     //   24: aload_3
/*      */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   30: astore #4
/*      */     //   32: aload_2
/*      */     //   33: aload #4
/*      */     //   35: aload_2
/*      */     //   36: aload #4
/*      */     //   38: invokevirtual min : (Ljava/lang/Object;)I
/*      */     //   41: invokevirtual setCardinality : (Ljava/lang/Object;I)V
/*      */     //   44: goto -> 15
/*      */     //   47: aload_2
/*      */     //   48: invokevirtual list : ()Ljava/util/Collection;
/*      */     //   51: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #256	-> 0
/*      */     //   #257	-> 10
/*      */     //   #258	-> 32
/*      */     //   #259	-> 44
/*      */     //   #260	-> 47
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O> Collection<O> disjunction(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2) {
/*      */     // Byte code:
/*      */     //   0: new org/apache/commons/collections4/CollectionUtils$SetOperationCardinalityHelper
/*      */     //   3: dup
/*      */     //   4: aload_0
/*      */     //   5: aload_1
/*      */     //   6: invokespecial <init> : (Ljava/lang/Iterable;Ljava/lang/Iterable;)V
/*      */     //   9: astore_2
/*      */     //   10: aload_2
/*      */     //   11: invokevirtual iterator : ()Ljava/util/Iterator;
/*      */     //   14: astore_3
/*      */     //   15: aload_3
/*      */     //   16: invokeinterface hasNext : ()Z
/*      */     //   21: ifeq -> 54
/*      */     //   24: aload_3
/*      */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   30: astore #4
/*      */     //   32: aload_2
/*      */     //   33: aload #4
/*      */     //   35: aload_2
/*      */     //   36: aload #4
/*      */     //   38: invokevirtual max : (Ljava/lang/Object;)I
/*      */     //   41: aload_2
/*      */     //   42: aload #4
/*      */     //   44: invokevirtual min : (Ljava/lang/Object;)I
/*      */     //   47: isub
/*      */     //   48: invokevirtual setCardinality : (Ljava/lang/Object;I)V
/*      */     //   51: goto -> 15
/*      */     //   54: aload_2
/*      */     //   55: invokevirtual list : ()Ljava/util/Collection;
/*      */     //   58: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #284	-> 0
/*      */     //   #285	-> 10
/*      */     //   #286	-> 32
/*      */     //   #287	-> 51
/*      */     //   #288	-> 54
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O> Collection<O> subtract(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2) {
/*  305 */     Predicate<O> predicate = TruePredicate.truePredicate();
/*  306 */     return subtract(paramIterable1, paramIterable2, predicate);
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
/*      */   public static <O> Collection<O> subtract(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2, Predicate<O> paramPredicate) {
/*      */     // Byte code:
/*      */     //   0: new java/util/ArrayList
/*      */     //   3: dup
/*      */     //   4: invokespecial <init> : ()V
/*      */     //   7: astore_3
/*      */     //   8: new org/apache/commons/collections4/bag/HashBag
/*      */     //   11: dup
/*      */     //   12: invokespecial <init> : ()V
/*      */     //   15: astore #4
/*      */     //   17: aload_1
/*      */     //   18: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   23: astore #5
/*      */     //   25: aload #5
/*      */     //   27: invokeinterface hasNext : ()Z
/*      */     //   32: ifeq -> 66
/*      */     //   35: aload #5
/*      */     //   37: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   42: astore #6
/*      */     //   44: aload_2
/*      */     //   45: aload #6
/*      */     //   47: invokeinterface evaluate : (Ljava/lang/Object;)Z
/*      */     //   52: ifeq -> 63
/*      */     //   55: aload #4
/*      */     //   57: aload #6
/*      */     //   59: invokevirtual add : (Ljava/lang/Object;)Z
/*      */     //   62: pop
/*      */     //   63: goto -> 25
/*      */     //   66: aload_0
/*      */     //   67: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   72: astore #5
/*      */     //   74: aload #5
/*      */     //   76: invokeinterface hasNext : ()Z
/*      */     //   81: ifeq -> 114
/*      */     //   84: aload #5
/*      */     //   86: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   91: astore #6
/*      */     //   93: aload #4
/*      */     //   95: aload #6
/*      */     //   97: iconst_1
/*      */     //   98: invokevirtual remove : (Ljava/lang/Object;I)Z
/*      */     //   101: ifne -> 111
/*      */     //   104: aload_3
/*      */     //   105: aload #6
/*      */     //   107: invokevirtual add : (Ljava/lang/Object;)Z
/*      */     //   110: pop
/*      */     //   111: goto -> 74
/*      */     //   114: aload_3
/*      */     //   115: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #333	-> 0
/*      */     //   #334	-> 8
/*      */     //   #335	-> 17
/*      */     //   #336	-> 44
/*      */     //   #337	-> 55
/*      */     //   #339	-> 63
/*      */     //   #340	-> 66
/*      */     //   #341	-> 93
/*      */     //   #342	-> 104
/*      */     //   #344	-> 111
/*      */     //   #345	-> 114
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
/*      */   public static boolean containsAll(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/*  371 */     if (paramCollection2.isEmpty()) {
/*  372 */       return true;
/*      */     }
/*  374 */     Iterator<?> iterator = paramCollection1.iterator();
/*  375 */     HashSet<Object> hashSet = new HashSet();
/*  376 */     for (Object object : paramCollection2) {
/*  377 */       if (hashSet.contains(object)) {
/*      */         continue;
/*      */       }
/*      */       
/*  381 */       boolean bool = false;
/*  382 */       while (iterator.hasNext()) {
/*  383 */         Object object1 = iterator.next();
/*  384 */         hashSet.add(object1);
/*  385 */         if ((object == null) ? (object1 == null) : object.equals(object1)) {
/*  386 */           bool = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/*  391 */       if (bool) {
/*      */         continue;
/*      */       }
/*  394 */       return false;
/*      */     } 
/*      */     
/*  397 */     return true;
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
/*      */   
/*      */   public static boolean containsAny(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/*  414 */     if (paramCollection1.size() < paramCollection2.size()) {
/*  415 */       for (Object object : paramCollection1) {
/*  416 */         if (paramCollection2.contains(object)) {
/*  417 */           return true;
/*      */         }
/*      */       } 
/*      */     } else {
/*  421 */       for (Object object : paramCollection2) {
/*  422 */         if (paramCollection1.contains(object)) {
/*  423 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*  427 */     return false;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O> Map<O, Integer> getCardinalityMap(Iterable<? extends O> paramIterable) {
/*      */     // Byte code:
/*      */     //   0: new java/util/HashMap
/*      */     //   3: dup
/*      */     //   4: invokespecial <init> : ()V
/*      */     //   7: astore_1
/*      */     //   8: aload_0
/*      */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   14: astore_2
/*      */     //   15: aload_2
/*      */     //   16: invokeinterface hasNext : ()Z
/*      */     //   21: ifeq -> 84
/*      */     //   24: aload_2
/*      */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   30: astore_3
/*      */     //   31: aload_1
/*      */     //   32: aload_3
/*      */     //   33: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   38: checkcast java/lang/Integer
/*      */     //   41: astore #4
/*      */     //   43: aload #4
/*      */     //   45: ifnonnull -> 63
/*      */     //   48: aload_1
/*      */     //   49: aload_3
/*      */     //   50: iconst_1
/*      */     //   51: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   54: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   59: pop
/*      */     //   60: goto -> 81
/*      */     //   63: aload_1
/*      */     //   64: aload_3
/*      */     //   65: aload #4
/*      */     //   67: invokevirtual intValue : ()I
/*      */     //   70: iconst_1
/*      */     //   71: iadd
/*      */     //   72: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */     //   75: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   80: pop
/*      */     //   81: goto -> 15
/*      */     //   84: aload_1
/*      */     //   85: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #443	-> 0
/*      */     //   #444	-> 8
/*      */     //   #445	-> 31
/*      */     //   #446	-> 43
/*      */     //   #447	-> 48
/*      */     //   #449	-> 63
/*      */     //   #451	-> 81
/*      */     //   #452	-> 84
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isSubCollection(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/*  468 */     CardinalityHelper cardinalityHelper = new CardinalityHelper(paramCollection1, paramCollection2);
/*  469 */     for (Object object : paramCollection1) {
/*  470 */       if (cardinalityHelper.freqA(object) > cardinalityHelper.freqB(object)) {
/*  471 */         return false;
/*      */       }
/*      */     } 
/*  474 */     return true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isProperSubCollection(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/*  499 */     return (paramCollection1.size() < paramCollection2.size() && isSubCollection(paramCollection1, paramCollection2));
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
/*      */   public static boolean isEqualCollection(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/*  515 */     if (paramCollection1.size() != paramCollection2.size()) {
/*  516 */       return false;
/*      */     }
/*  518 */     CardinalityHelper cardinalityHelper = new CardinalityHelper(paramCollection1, paramCollection2);
/*  519 */     if (cardinalityHelper.cardinalityA.size() != cardinalityHelper.cardinalityB.size()) {
/*  520 */       return false;
/*      */     }
/*  522 */     for (Object object : cardinalityHelper.cardinalityA.keySet()) {
/*  523 */       if (cardinalityHelper.freqA(object) != cardinalityHelper.freqB(object)) {
/*  524 */         return false;
/*      */       }
/*      */     } 
/*  527 */     return true;
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
/*      */   public static <E> boolean isEqualCollection(Collection<? extends E> paramCollection1, Collection<? extends E> paramCollection2, final Equator<? super E> equator) {
/*  554 */     if (equator == null) {
/*  555 */       throw new NullPointerException("Equator must not be null.");
/*      */     }
/*      */     
/*  558 */     if (paramCollection1.size() != paramCollection2.size()) {
/*  559 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  563 */     Transformer<Object, Object> transformer = new Transformer<Object, Object>() {
/*      */         public CollectionUtils.EquatorWrapper<?> transform(Object param1Object) {
/*  565 */           return new CollectionUtils.EquatorWrapper(equator, param1Object);
/*      */         }
/*      */       };
/*      */     
/*  569 */     return isEqualCollection(collect(paramCollection1, (Transformer)transformer), collect(paramCollection2, (Transformer)transformer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class EquatorWrapper<O>
/*      */   {
/*      */     private final Equator<? super O> equator;
/*      */ 
/*      */ 
/*      */     
/*      */     private final O object;
/*      */ 
/*      */ 
/*      */     
/*      */     public EquatorWrapper(Equator<? super O> param1Equator, O param1O) {
/*  586 */       this.equator = param1Equator;
/*  587 */       this.object = param1O;
/*      */     }
/*      */     
/*      */     public O getObject() {
/*  591 */       return this.object;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  596 */       if (!(param1Object instanceof EquatorWrapper)) {
/*  597 */         return false;
/*      */       }
/*      */       
/*  600 */       EquatorWrapper<O> equatorWrapper = (EquatorWrapper)param1Object;
/*  601 */       return this.equator.equate(this.object, equatorWrapper.getObject());
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  606 */       return this.equator.hash(this.object);
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
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <O> int cardinality(O paramO, Iterable<? super O> paramIterable) {
/*  623 */     if (paramIterable == null) {
/*  624 */       throw new NullPointerException("coll must not be null.");
/*      */     }
/*  626 */     return IterableUtils.frequency(paramIterable, paramO);
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
/*      */   @Deprecated
/*      */   public static <T> T find(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
/*  643 */     return (paramPredicate != null) ? IterableUtils.<T>find(paramIterable, paramPredicate) : null;
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
/*      */   @Deprecated
/*      */   public static <T, C extends Closure<? super T>> C forAllDo(Iterable<T> paramIterable, C paramC) {
/*  660 */     if (paramC != null) {
/*  661 */       IterableUtils.forEach(paramIterable, (Closure<? super T>)paramC);
/*      */     }
/*  663 */     return paramC;
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
/*      */   
/*      */   @Deprecated
/*      */   public static <T, C extends Closure<? super T>> C forAllDo(Iterator<T> paramIterator, C paramC) {
/*  681 */     if (paramC != null) {
/*  682 */       IteratorUtils.forEach(paramIterator, (Closure<? super T>)paramC);
/*      */     }
/*  684 */     return paramC;
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
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T, C extends Closure<? super T>> T forAllButLastDo(Iterable<T> paramIterable, C paramC) {
/*  703 */     return (paramC != null) ? IterableUtils.<T>forEachButLast(paramIterable, (Closure<? super T>)paramC) : null;
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
/*      */   
/*      */   @Deprecated
/*      */   public static <T, C extends Closure<? super T>> T forAllButLastDo(Iterator<T> paramIterator, C paramC) {
/*  721 */     return (paramC != null) ? IteratorUtils.<T>forEachButLast(paramIterator, (Closure<? super T>)paramC) : null;
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
/*      */   public static <T> boolean filter(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
/*  736 */     boolean bool = false;
/*  737 */     if (paramIterable != null && paramPredicate != null) {
/*  738 */       for (Iterator<T> iterator = paramIterable.iterator(); iterator.hasNext();) {
/*  739 */         if (!paramPredicate.evaluate(iterator.next())) {
/*  740 */           iterator.remove();
/*  741 */           bool = true;
/*      */         } 
/*      */       } 
/*      */     }
/*  745 */     return bool;
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
/*      */ 
/*      */   
/*      */   public static <T> boolean filterInverse(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
/*  763 */     return filter(paramIterable, (paramPredicate == null) ? null : PredicateUtils.<T>notPredicate(paramPredicate));
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <C> void transform(Collection<C> paramCollection, Transformer<? super C, ? extends C> paramTransformer) {
/*  786 */     if (paramCollection != null && paramTransformer != null) {
/*  787 */       if (paramCollection instanceof List) {
/*  788 */         List list = (List)paramCollection;
/*  789 */         for (ListIterator<C> listIterator = list.listIterator(); listIterator.hasNext();) {
/*  790 */           listIterator.set(paramTransformer.transform(listIterator.next()));
/*      */         }
/*      */       } else {
/*  793 */         Collection<C> collection = collect(paramCollection, paramTransformer);
/*  794 */         paramCollection.clear();
/*  795 */         paramCollection.addAll(collection);
/*      */       } 
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <C> int countMatches(Iterable<C> paramIterable, Predicate<? super C> paramPredicate) {
/*  814 */     return (paramPredicate == null) ? 0 : (int)IterableUtils.<C>countMatches(paramIterable, paramPredicate);
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
/*      */   @Deprecated
/*      */   public static <C> boolean exists(Iterable<C> paramIterable, Predicate<? super C> paramPredicate) {
/*  831 */     return (paramPredicate == null) ? false : IterableUtils.<C>matchesAny(paramIterable, paramPredicate);
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
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <C> boolean matchesAll(Iterable<C> paramIterable, Predicate<? super C> paramPredicate) {
/*  851 */     return (paramPredicate == null) ? false : IterableUtils.<C>matchesAll(paramIterable, paramPredicate);
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
/*      */   
/*      */   public static <O> Collection<O> select(Iterable<? extends O> paramIterable, Predicate<? super O> paramPredicate) {
/*  868 */     ArrayList<O> arrayList = (paramIterable instanceof Collection) ? new ArrayList(((Collection)paramIterable).size()) : new ArrayList();
/*      */     
/*  870 */     return select(paramIterable, paramPredicate, arrayList);
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
/*      */   public static <O, R extends Collection<? super O>> R select(Iterable<? extends O> paramIterable, Predicate<? super O> paramPredicate, R paramR) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: ifnull -> 55
/*      */     //   4: aload_1
/*      */     //   5: ifnull -> 55
/*      */     //   8: aload_0
/*      */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   14: astore_3
/*      */     //   15: aload_3
/*      */     //   16: invokeinterface hasNext : ()Z
/*      */     //   21: ifeq -> 55
/*      */     //   24: aload_3
/*      */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   30: astore #4
/*      */     //   32: aload_1
/*      */     //   33: aload #4
/*      */     //   35: invokeinterface evaluate : (Ljava/lang/Object;)Z
/*      */     //   40: ifeq -> 52
/*      */     //   43: aload_2
/*      */     //   44: aload #4
/*      */     //   46: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   51: pop
/*      */     //   52: goto -> 15
/*      */     //   55: aload_2
/*      */     //   56: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #891	-> 0
/*      */     //   #892	-> 8
/*      */     //   #893	-> 32
/*      */     //   #894	-> 43
/*      */     //   #896	-> 52
/*      */     //   #898	-> 55
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
/*      */   public static <O, R extends Collection<? super O>> R select(Iterable<? extends O> paramIterable, Predicate<? super O> paramPredicate, R paramR1, R paramR2) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: ifnull -> 70
/*      */     //   4: aload_1
/*      */     //   5: ifnull -> 70
/*      */     //   8: aload_0
/*      */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   14: astore #4
/*      */     //   16: aload #4
/*      */     //   18: invokeinterface hasNext : ()Z
/*      */     //   23: ifeq -> 70
/*      */     //   26: aload #4
/*      */     //   28: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   33: astore #5
/*      */     //   35: aload_1
/*      */     //   36: aload #5
/*      */     //   38: invokeinterface evaluate : (Ljava/lang/Object;)Z
/*      */     //   43: ifeq -> 58
/*      */     //   46: aload_2
/*      */     //   47: aload #5
/*      */     //   49: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   54: pop
/*      */     //   55: goto -> 67
/*      */     //   58: aload_3
/*      */     //   59: aload #5
/*      */     //   61: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   66: pop
/*      */     //   67: goto -> 16
/*      */     //   70: aload_2
/*      */     //   71: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #931	-> 0
/*      */     //   #932	-> 8
/*      */     //   #933	-> 35
/*      */     //   #934	-> 46
/*      */     //   #936	-> 58
/*      */     //   #938	-> 67
/*      */     //   #940	-> 70
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
/*      */   public static <O> Collection<O> selectRejected(Iterable<? extends O> paramIterable, Predicate<? super O> paramPredicate) {
/*  958 */     ArrayList<O> arrayList = (paramIterable instanceof Collection) ? new ArrayList(((Collection)paramIterable).size()) : new ArrayList();
/*      */     
/*  960 */     return selectRejected(paramIterable, paramPredicate, arrayList);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O, R extends Collection<? super O>> R selectRejected(Iterable<? extends O> paramIterable, Predicate<? super O> paramPredicate, R paramR) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: ifnull -> 55
/*      */     //   4: aload_1
/*      */     //   5: ifnull -> 55
/*      */     //   8: aload_0
/*      */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   14: astore_3
/*      */     //   15: aload_3
/*      */     //   16: invokeinterface hasNext : ()Z
/*      */     //   21: ifeq -> 55
/*      */     //   24: aload_3
/*      */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   30: astore #4
/*      */     //   32: aload_1
/*      */     //   33: aload #4
/*      */     //   35: invokeinterface evaluate : (Ljava/lang/Object;)Z
/*      */     //   40: ifne -> 52
/*      */     //   43: aload_2
/*      */     //   44: aload #4
/*      */     //   46: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   51: pop
/*      */     //   52: goto -> 15
/*      */     //   55: aload_2
/*      */     //   56: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #981	-> 0
/*      */     //   #982	-> 8
/*      */     //   #983	-> 32
/*      */     //   #984	-> 43
/*      */     //   #986	-> 52
/*      */     //   #988	-> 55
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <I, O> Collection<O> collect(Iterable<I> paramIterable, Transformer<? super I, ? extends O> paramTransformer) {
/* 1006 */     ArrayList<O> arrayList = (paramIterable instanceof Collection) ? new ArrayList(((Collection)paramIterable).size()) : new ArrayList();
/*      */     
/* 1008 */     return collect(paramIterable, paramTransformer, arrayList);
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
/*      */   
/*      */   public static <I, O> Collection<O> collect(Iterator<I> paramIterator, Transformer<? super I, ? extends O> paramTransformer) {
/* 1025 */     return collect(paramIterator, paramTransformer, new ArrayList<O>());
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <I, O, R extends Collection<? super O>> R collect(Iterable<? extends I> paramIterable, Transformer<? super I, ? extends O> paramTransformer, R paramR) {
/* 1048 */     if (paramIterable != null) {
/* 1049 */       return collect(paramIterable.iterator(), paramTransformer, paramR);
/*      */     }
/* 1051 */     return paramR;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <I, O, R extends Collection<? super O>> R collect(Iterator<? extends I> paramIterator, Transformer<? super I, ? extends O> paramTransformer, R paramR) {
/* 1074 */     if (paramIterator != null && paramTransformer != null) {
/* 1075 */       while (paramIterator.hasNext()) {
/* 1076 */         I i = paramIterator.next();
/* 1077 */         O o = paramTransformer.transform(i);
/* 1078 */         paramR.add(o);
/*      */       } 
/*      */     }
/* 1081 */     return paramR;
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
/*      */   public static <T> boolean addIgnoreNull(Collection<T> paramCollection, T paramT) {
/* 1096 */     if (paramCollection == null) {
/* 1097 */       throw new NullPointerException("The collection must not be null");
/*      */     }
/* 1099 */     return (paramT != null && paramCollection.add(paramT));
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
/*      */   public static <C> boolean addAll(Collection<C> paramCollection, Iterable<? extends C> paramIterable) {
/* 1114 */     if (paramIterable instanceof Collection) {
/* 1115 */       return paramCollection.addAll((Collection<? extends C>)paramIterable);
/*      */     }
/* 1117 */     return addAll(paramCollection, paramIterable.iterator());
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
/*      */   public static <C> boolean addAll(Collection<C> paramCollection, Iterator<? extends C> paramIterator) {
/* 1130 */     boolean bool = false;
/* 1131 */     while (paramIterator.hasNext()) {
/* 1132 */       bool |= paramCollection.add(paramIterator.next());
/*      */     }
/* 1134 */     return bool;
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
/*      */   public static <C> boolean addAll(Collection<C> paramCollection, Enumeration<? extends C> paramEnumeration) {
/* 1147 */     boolean bool = false;
/* 1148 */     while (paramEnumeration.hasMoreElements()) {
/* 1149 */       bool |= paramCollection.add(paramEnumeration.nextElement());
/*      */     }
/* 1151 */     return bool;
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
/*      */   public static <C> boolean addAll(Collection<C> paramCollection, C[] paramArrayOfC) {
/* 1164 */     boolean bool = false;
/* 1165 */     for (C c : paramArrayOfC) {
/* 1166 */       bool |= paramCollection.add(c);
/*      */     }
/* 1168 */     return bool;
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
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T> T get(Iterator<T> paramIterator, int paramInt) {
/* 1188 */     return IteratorUtils.get(paramIterator, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void checkIndexBounds(int paramInt) {
/* 1197 */     if (paramInt < 0) {
/* 1198 */       throw new IndexOutOfBoundsException("Index cannot be negative: " + paramInt);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T> T get(Iterable<T> paramIterable, int paramInt) {
/* 1217 */     return IterableUtils.get(paramIterable, paramInt);
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
/*      */   public static Object get(Object paramObject, int paramInt) {
/* 1251 */     int i = paramInt;
/* 1252 */     if (i < 0) {
/* 1253 */       throw new IndexOutOfBoundsException("Index cannot be negative: " + i);
/*      */     }
/* 1255 */     if (paramObject instanceof Map) {
/* 1256 */       Map map = (Map)paramObject;
/* 1257 */       Iterator<?> iterator = map.entrySet().iterator();
/* 1258 */       return IteratorUtils.get(iterator, i);
/* 1259 */     }  if (paramObject instanceof Object[])
/* 1260 */       return ((Object[])paramObject)[i]; 
/* 1261 */     if (paramObject instanceof Iterator) {
/* 1262 */       Iterator<?> iterator = (Iterator)paramObject;
/* 1263 */       return IteratorUtils.get(iterator, i);
/* 1264 */     }  if (paramObject instanceof Iterable) {
/* 1265 */       Iterable<?> iterable = (Iterable)paramObject;
/* 1266 */       return IterableUtils.get(iterable, i);
/* 1267 */     }  if (paramObject instanceof Collection) {
/* 1268 */       Iterator<?> iterator = ((Collection)paramObject).iterator();
/* 1269 */       return IteratorUtils.get(iterator, i);
/* 1270 */     }  if (paramObject instanceof Enumeration) {
/* 1271 */       Enumeration<?> enumeration = (Enumeration)paramObject;
/* 1272 */       return EnumerationUtils.get(enumeration, i);
/* 1273 */     }  if (paramObject == null) {
/* 1274 */       throw new IllegalArgumentException("Unsupported object type: null");
/*      */     }
/*      */     try {
/* 1277 */       return Array.get(paramObject, i);
/* 1278 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 1279 */       throw new IllegalArgumentException("Unsupported object type: " + paramObject.getClass().getName());
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> Map.Entry<K, V> get(Map<K, V> paramMap, int paramInt) {
/* 1296 */     checkIndexBounds(paramInt);
/* 1297 */     return get(paramMap.entrySet(), paramInt);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int size(Object paramObject) {
/* 1318 */     if (paramObject == null) {
/* 1319 */       return 0;
/*      */     }
/* 1321 */     int i = 0;
/* 1322 */     if (paramObject instanceof Map) {
/* 1323 */       i = ((Map)paramObject).size();
/* 1324 */     } else if (paramObject instanceof Collection) {
/* 1325 */       i = ((Collection)paramObject).size();
/* 1326 */     } else if (paramObject instanceof Iterable) {
/* 1327 */       i = IterableUtils.size((Iterable)paramObject);
/* 1328 */     } else if (paramObject instanceof Object[]) {
/* 1329 */       i = ((Object[])paramObject).length;
/* 1330 */     } else if (paramObject instanceof Iterator) {
/* 1331 */       i = IteratorUtils.size((Iterator)paramObject);
/* 1332 */     } else if (paramObject instanceof Enumeration) {
/* 1333 */       Enumeration enumeration = (Enumeration)paramObject;
/* 1334 */       while (enumeration.hasMoreElements()) {
/* 1335 */         i++;
/* 1336 */         enumeration.nextElement();
/*      */       } 
/*      */     } else {
/*      */       try {
/* 1340 */         i = Array.getLength(paramObject);
/* 1341 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 1342 */         throw new IllegalArgumentException("Unsupported object type: " + paramObject.getClass().getName());
/*      */       } 
/*      */     } 
/* 1345 */     return i;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean sizeIsEmpty(Object paramObject) {
/* 1369 */     if (paramObject == null)
/* 1370 */       return true; 
/* 1371 */     if (paramObject instanceof Collection)
/* 1372 */       return ((Collection)paramObject).isEmpty(); 
/* 1373 */     if (paramObject instanceof Iterable)
/* 1374 */       return IterableUtils.isEmpty((Iterable)paramObject); 
/* 1375 */     if (paramObject instanceof Map)
/* 1376 */       return ((Map)paramObject).isEmpty(); 
/* 1377 */     if (paramObject instanceof Object[])
/* 1378 */       return (((Object[])paramObject).length == 0); 
/* 1379 */     if (paramObject instanceof Iterator)
/* 1380 */       return !((Iterator)paramObject).hasNext(); 
/* 1381 */     if (paramObject instanceof Enumeration) {
/* 1382 */       return !((Enumeration)paramObject).hasMoreElements();
/*      */     }
/*      */     try {
/* 1385 */       return (Array.getLength(paramObject) == 0);
/* 1386 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 1387 */       throw new IllegalArgumentException("Unsupported object type: " + paramObject.getClass().getName());
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(Collection<?> paramCollection) {
/* 1403 */     return (paramCollection == null || paramCollection.isEmpty());
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
/*      */   public static boolean isNotEmpty(Collection<?> paramCollection) {
/* 1416 */     return !isEmpty(paramCollection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void reverseArray(Object[] paramArrayOfObject) {
/* 1426 */     byte b = 0;
/* 1427 */     int i = paramArrayOfObject.length - 1;
/*      */ 
/*      */     
/* 1430 */     while (i > b) {
/* 1431 */       Object object = paramArrayOfObject[i];
/* 1432 */       paramArrayOfObject[i] = paramArrayOfObject[b];
/* 1433 */       paramArrayOfObject[b] = object;
/* 1434 */       i--;
/* 1435 */       b++;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isFull(Collection<? extends Object> paramCollection) {
/* 1455 */     if (paramCollection == null) {
/* 1456 */       throw new NullPointerException("The collection must not be null");
/*      */     }
/* 1458 */     if (paramCollection instanceof BoundedCollection) {
/* 1459 */       return ((BoundedCollection)paramCollection).isFull();
/*      */     }
/*      */     try {
/* 1462 */       BoundedCollection boundedCollection = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(paramCollection);
/*      */       
/* 1464 */       return boundedCollection.isFull();
/* 1465 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 1466 */       return false;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int maxSize(Collection<? extends Object> paramCollection) {
/* 1486 */     if (paramCollection == null) {
/* 1487 */       throw new NullPointerException("The collection must not be null");
/*      */     }
/* 1489 */     if (paramCollection instanceof BoundedCollection) {
/* 1490 */       return ((BoundedCollection)paramCollection).maxSize();
/*      */     }
/*      */     try {
/* 1493 */       BoundedCollection boundedCollection = UnmodifiableBoundedCollection.unmodifiableBoundedCollection(paramCollection);
/*      */       
/* 1495 */       return boundedCollection.maxSize();
/* 1496 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 1497 */       return -1;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O extends Comparable<? super O>> List<O> collate(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2) {
/* 1517 */     return collate(paramIterable1, paramIterable2, ComparatorUtils.naturalComparator(), true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O extends Comparable<? super O>> List<O> collate(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2, boolean paramBoolean) {
/* 1538 */     return collate(paramIterable1, paramIterable2, ComparatorUtils.naturalComparator(), paramBoolean);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O> List<O> collate(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2, Comparator<? super O> paramComparator) {
/* 1557 */     return collate(paramIterable1, paramIterable2, paramComparator, true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <O> List<O> collate(Iterable<? extends O> paramIterable1, Iterable<? extends O> paramIterable2, Comparator<? super O> paramComparator, boolean paramBoolean) {
/* 1579 */     if (paramIterable1 == null || paramIterable2 == null) {
/* 1580 */       throw new NullPointerException("The collections must not be null");
/*      */     }
/* 1582 */     if (paramComparator == null) {
/* 1583 */       throw new NullPointerException("The comparator must not be null");
/*      */     }
/*      */ 
/*      */     
/* 1587 */     boolean bool = (paramIterable1 instanceof Collection && paramIterable2 instanceof Collection) ? Math.max(1, ((Collection)paramIterable1).size() + ((Collection)paramIterable2).size()) : true;
/*      */ 
/*      */     
/* 1590 */     CollatingIterator<Object> collatingIterator = new CollatingIterator(paramComparator, paramIterable1.iterator(), paramIterable2.iterator());
/* 1591 */     if (paramBoolean) {
/* 1592 */       return IteratorUtils.toList((Iterator)collatingIterator, bool);
/*      */     }
/* 1594 */     ArrayList<O> arrayList = new ArrayList(bool);
/*      */     
/* 1596 */     Object object = null;
/* 1597 */     while (collatingIterator.hasNext()) {
/* 1598 */       Object object1 = collatingIterator.next();
/* 1599 */       if (object == null || !object.equals(object1)) {
/* 1600 */         arrayList.add(object1);
/*      */       }
/* 1602 */       object = object1;
/*      */     } 
/*      */     
/* 1605 */     arrayList.trimToSize();
/* 1606 */     return arrayList;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> Collection<List<E>> permutations(Collection<E> paramCollection) {
/* 1631 */     PermutationIterator permutationIterator = new PermutationIterator(paramCollection);
/* 1632 */     LinkedList<List> linkedList = new LinkedList();
/* 1633 */     while (permutationIterator.hasNext()) {
/* 1634 */       linkedList.add(permutationIterator.next());
/*      */     }
/* 1636 */     return (Collection)linkedList;
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
/*      */   public static <C> Collection<C> retainAll(Collection<C> paramCollection, Collection<?> paramCollection1) {
/* 1663 */     return ListUtils.retainAll(paramCollection, paramCollection1);
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
/*      */   public static <E> Collection<E> retainAll(Iterable<E> paramIterable, Iterable<? extends E> paramIterable1, Equator<? super E> paramEquator) {
/*      */     // Byte code:
/*      */     //   0: new org/apache/commons/collections4/CollectionUtils$2
/*      */     //   3: dup
/*      */     //   4: aload_2
/*      */     //   5: invokespecial <init> : (Lorg/apache/commons/collections4/Equator;)V
/*      */     //   8: astore_3
/*      */     //   9: aload_1
/*      */     //   10: aload_3
/*      */     //   11: new java/util/HashSet
/*      */     //   14: dup
/*      */     //   15: invokespecial <init> : ()V
/*      */     //   18: invokestatic collect : (Ljava/lang/Iterable;Lorg/apache/commons/collections4/Transformer;Ljava/util/Collection;)Ljava/util/Collection;
/*      */     //   21: checkcast java/util/Set
/*      */     //   24: astore #4
/*      */     //   26: new java/util/ArrayList
/*      */     //   29: dup
/*      */     //   30: invokespecial <init> : ()V
/*      */     //   33: astore #5
/*      */     //   35: aload_0
/*      */     //   36: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   41: astore #6
/*      */     //   43: aload #6
/*      */     //   45: invokeinterface hasNext : ()Z
/*      */     //   50: ifeq -> 95
/*      */     //   53: aload #6
/*      */     //   55: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   60: astore #7
/*      */     //   62: aload #4
/*      */     //   64: new org/apache/commons/collections4/CollectionUtils$EquatorWrapper
/*      */     //   67: dup
/*      */     //   68: aload_2
/*      */     //   69: aload #7
/*      */     //   71: invokespecial <init> : (Lorg/apache/commons/collections4/Equator;Ljava/lang/Object;)V
/*      */     //   74: invokeinterface contains : (Ljava/lang/Object;)Z
/*      */     //   79: ifeq -> 92
/*      */     //   82: aload #5
/*      */     //   84: aload #7
/*      */     //   86: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   91: pop
/*      */     //   92: goto -> 43
/*      */     //   95: aload #5
/*      */     //   97: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1695	-> 0
/*      */     //   #1701	-> 9
/*      */     //   #1704	-> 26
/*      */     //   #1705	-> 35
/*      */     //   #1706	-> 62
/*      */     //   #1707	-> 82
/*      */     //   #1709	-> 92
/*      */     //   #1710	-> 95
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
/*      */   public static <E> Collection<E> removeAll(Collection<E> paramCollection, Collection<?> paramCollection1) {
/* 1737 */     return ListUtils.removeAll(paramCollection, paramCollection1);
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
/*      */   public static <E> Collection<E> removeAll(Iterable<E> paramIterable, Iterable<? extends E> paramIterable1, Equator<? super E> paramEquator) {
/*      */     // Byte code:
/*      */     //   0: new org/apache/commons/collections4/CollectionUtils$3
/*      */     //   3: dup
/*      */     //   4: aload_2
/*      */     //   5: invokespecial <init> : (Lorg/apache/commons/collections4/Equator;)V
/*      */     //   8: astore_3
/*      */     //   9: aload_1
/*      */     //   10: aload_3
/*      */     //   11: new java/util/HashSet
/*      */     //   14: dup
/*      */     //   15: invokespecial <init> : ()V
/*      */     //   18: invokestatic collect : (Ljava/lang/Iterable;Lorg/apache/commons/collections4/Transformer;Ljava/util/Collection;)Ljava/util/Collection;
/*      */     //   21: checkcast java/util/Set
/*      */     //   24: astore #4
/*      */     //   26: new java/util/ArrayList
/*      */     //   29: dup
/*      */     //   30: invokespecial <init> : ()V
/*      */     //   33: astore #5
/*      */     //   35: aload_0
/*      */     //   36: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   41: astore #6
/*      */     //   43: aload #6
/*      */     //   45: invokeinterface hasNext : ()Z
/*      */     //   50: ifeq -> 95
/*      */     //   53: aload #6
/*      */     //   55: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   60: astore #7
/*      */     //   62: aload #4
/*      */     //   64: new org/apache/commons/collections4/CollectionUtils$EquatorWrapper
/*      */     //   67: dup
/*      */     //   68: aload_2
/*      */     //   69: aload #7
/*      */     //   71: invokespecial <init> : (Lorg/apache/commons/collections4/Equator;Ljava/lang/Object;)V
/*      */     //   74: invokeinterface contains : (Ljava/lang/Object;)Z
/*      */     //   79: ifne -> 92
/*      */     //   82: aload #5
/*      */     //   84: aload #7
/*      */     //   86: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   91: pop
/*      */     //   92: goto -> 43
/*      */     //   95: aload #5
/*      */     //   97: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1770	-> 0
/*      */     //   #1776	-> 9
/*      */     //   #1779	-> 26
/*      */     //   #1780	-> 35
/*      */     //   #1781	-> 62
/*      */     //   #1782	-> 82
/*      */     //   #1784	-> 92
/*      */     //   #1785	-> 95
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
/*      */   @Deprecated
/*      */   public static <C> Collection<C> synchronizedCollection(Collection<C> paramCollection) {
/* 1815 */     return (Collection<C>)SynchronizedCollection.synchronizedCollection(paramCollection);
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
/*      */   @Deprecated
/*      */   public static <C> Collection<C> unmodifiableCollection(Collection<? extends C> paramCollection) {
/* 1831 */     return UnmodifiableCollection.unmodifiableCollection(paramCollection);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static <C> Collection<C> predicatedCollection(Collection<C> paramCollection, Predicate<? super C> paramPredicate) {
/* 1850 */     return (Collection<C>)PredicatedCollection.predicatedCollection(paramCollection, paramPredicate);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> Collection<E> transformingCollection(Collection<E> paramCollection, Transformer<? super E, ? extends E> paramTransformer) {
/* 1871 */     return (Collection<E>)TransformedCollection.transformingCollection(paramCollection, paramTransformer);
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
/*      */   public static <E> E extractSingleton(Collection<E> paramCollection) {
/* 1884 */     if (paramCollection == null) {
/* 1885 */       throw new NullPointerException("Collection must not be null.");
/*      */     }
/* 1887 */     if (paramCollection.size() != 1) {
/* 1888 */       throw new IllegalArgumentException("Can extract singleton only when collection size == 1");
/*      */     }
/* 1890 */     return paramCollection.iterator().next();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\CollectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */