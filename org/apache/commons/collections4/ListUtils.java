/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections4.functors.DefaultEquator;
/*     */ import org.apache.commons.collections4.list.FixedSizeList;
/*     */ import org.apache.commons.collections4.list.LazyList;
/*     */ import org.apache.commons.collections4.list.PredicatedList;
/*     */ import org.apache.commons.collections4.list.TransformedList;
/*     */ import org.apache.commons.collections4.list.UnmodifiableList;
/*     */ import org.apache.commons.collections4.sequence.CommandVisitor;
/*     */ import org.apache.commons.collections4.sequence.EditScript;
/*     */ import org.apache.commons.collections4.sequence.SequencesComparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListUtils
/*     */ {
/*     */   public static <T> List<T> emptyIfNull(List<T> paramList) {
/*  62 */     return (paramList == null) ? Collections.<T>emptyList() : paramList;
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
/*     */   public static <T> List<T> defaultIfNull(List<T> paramList1, List<T> paramList2) {
/*  76 */     return (paramList1 == null) ? paramList2 : paramList1;
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
/*     */   public static <E> List<E> intersection(List<? extends E> paramList1, List<? extends E> paramList2) {
/*     */     // Byte code:
/*     */     //   0: new java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_2
/*     */     //   8: aload_0
/*     */     //   9: astore_3
/*     */     //   10: aload_1
/*     */     //   11: astore #4
/*     */     //   13: aload_0
/*     */     //   14: invokeinterface size : ()I
/*     */     //   19: aload_1
/*     */     //   20: invokeinterface size : ()I
/*     */     //   25: if_icmple -> 33
/*     */     //   28: aload_1
/*     */     //   29: astore_3
/*     */     //   30: aload_0
/*     */     //   31: astore #4
/*     */     //   33: new java/util/HashSet
/*     */     //   36: dup
/*     */     //   37: aload_3
/*     */     //   38: invokespecial <init> : (Ljava/util/Collection;)V
/*     */     //   41: astore #5
/*     */     //   43: aload #4
/*     */     //   45: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   50: astore #6
/*     */     //   52: aload #6
/*     */     //   54: invokeinterface hasNext : ()Z
/*     */     //   59: ifeq -> 101
/*     */     //   62: aload #6
/*     */     //   64: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   69: astore #7
/*     */     //   71: aload #5
/*     */     //   73: aload #7
/*     */     //   75: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   78: ifeq -> 98
/*     */     //   81: aload_2
/*     */     //   82: aload #7
/*     */     //   84: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   89: pop
/*     */     //   90: aload #5
/*     */     //   92: aload #7
/*     */     //   94: invokevirtual remove : (Ljava/lang/Object;)Z
/*     */     //   97: pop
/*     */     //   98: goto -> 52
/*     */     //   101: aload_2
/*     */     //   102: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #90	-> 0
/*     */     //   #92	-> 8
/*     */     //   #93	-> 10
/*     */     //   #94	-> 13
/*     */     //   #95	-> 28
/*     */     //   #96	-> 30
/*     */     //   #99	-> 33
/*     */     //   #101	-> 43
/*     */     //   #102	-> 71
/*     */     //   #103	-> 81
/*     */     //   #104	-> 90
/*     */     //   #106	-> 98
/*     */     //   #107	-> 101
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
/*     */   public static <E> List<E> subtract(List<E> paramList, List<? extends E> paramList1) {
/*     */     // Byte code:
/*     */     //   0: new java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_2
/*     */     //   8: new org/apache/commons/collections4/bag/HashBag
/*     */     //   11: dup
/*     */     //   12: aload_1
/*     */     //   13: invokespecial <init> : (Ljava/util/Collection;)V
/*     */     //   16: astore_3
/*     */     //   17: aload_0
/*     */     //   18: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   23: astore #4
/*     */     //   25: aload #4
/*     */     //   27: invokeinterface hasNext : ()Z
/*     */     //   32: ifeq -> 64
/*     */     //   35: aload #4
/*     */     //   37: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   42: astore #5
/*     */     //   44: aload_3
/*     */     //   45: aload #5
/*     */     //   47: iconst_1
/*     */     //   48: invokevirtual remove : (Ljava/lang/Object;I)Z
/*     */     //   51: ifne -> 61
/*     */     //   54: aload_2
/*     */     //   55: aload #5
/*     */     //   57: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   60: pop
/*     */     //   61: goto -> 25
/*     */     //   64: aload_2
/*     */     //   65: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #127	-> 0
/*     */     //   #128	-> 8
/*     */     //   #129	-> 17
/*     */     //   #130	-> 44
/*     */     //   #131	-> 54
/*     */     //   #133	-> 61
/*     */     //   #134	-> 64
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
/*     */   public static <E> List<E> sum(List<? extends E> paramList1, List<? extends E> paramList2) {
/* 148 */     return subtract(union(paramList1, paramList2), intersection(paramList1, paramList2));
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
/*     */   public static <E> List<E> union(List<? extends E> paramList1, List<? extends E> paramList2) {
/* 163 */     ArrayList<E> arrayList = new ArrayList<E>(paramList1);
/* 164 */     arrayList.addAll(paramList2);
/* 165 */     return arrayList;
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
/*     */   public static <E> List<E> select(Collection<? extends E> paramCollection, Predicate<? super E> paramPredicate) {
/* 185 */     return CollectionUtils.<E, List<E>>select(paramCollection, paramPredicate, new ArrayList<E>(paramCollection.size()));
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
/*     */   public static <E> List<E> selectRejected(Collection<? extends E> paramCollection, Predicate<? super E> paramPredicate) {
/* 205 */     return CollectionUtils.<E, List<E>>selectRejected(paramCollection, paramPredicate, new ArrayList<E>(paramCollection.size()));
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
/*     */ 
/*     */   
/*     */   public static boolean isEqualList(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/* 238 */     if (paramCollection1 == paramCollection2) {
/* 239 */       return true;
/*     */     }
/* 241 */     if (paramCollection1 == null || paramCollection2 == null || paramCollection1.size() != paramCollection2.size()) {
/* 242 */       return false;
/*     */     }
/*     */     
/* 245 */     Iterator<?> iterator1 = paramCollection1.iterator();
/* 246 */     Iterator<?> iterator2 = paramCollection2.iterator();
/* 247 */     Object object1 = null;
/* 248 */     Object object2 = null;
/*     */     
/* 250 */     while (iterator1.hasNext() && iterator2.hasNext()) {
/* 251 */       object1 = iterator1.next();
/* 252 */       object2 = iterator2.next();
/*     */       
/* 254 */       if ((object1 == null) ? (object2 == null) : object1.equals(object2))
/* 255 */         continue;  return false;
/*     */     } 
/*     */ 
/*     */     
/* 259 */     return (!iterator1.hasNext() && !iterator2.hasNext());
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
/*     */   public static int hashCodeForList(Collection<?> paramCollection) {
/* 275 */     if (paramCollection == null) {
/* 276 */       return 0;
/*     */     }
/* 278 */     int i = 1;
/* 279 */     Iterator<?> iterator = paramCollection.iterator();
/*     */     
/* 281 */     while (iterator.hasNext()) {
/* 282 */       Object object = iterator.next();
/* 283 */       i = 31 * i + ((object == null) ? 0 : object.hashCode());
/*     */     } 
/* 285 */     return i;
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
/*     */   
/*     */   public static <E> List<E> retainAll(Collection<E> paramCollection, Collection<?> paramCollection1) {
/*     */     // Byte code:
/*     */     //   0: new java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: aload_0
/*     */     //   5: invokeinterface size : ()I
/*     */     //   10: aload_1
/*     */     //   11: invokeinterface size : ()I
/*     */     //   16: invokestatic min : (II)I
/*     */     //   19: invokespecial <init> : (I)V
/*     */     //   22: astore_2
/*     */     //   23: aload_0
/*     */     //   24: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   29: astore_3
/*     */     //   30: aload_3
/*     */     //   31: invokeinterface hasNext : ()Z
/*     */     //   36: ifeq -> 70
/*     */     //   39: aload_3
/*     */     //   40: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   45: astore #4
/*     */     //   47: aload_1
/*     */     //   48: aload #4
/*     */     //   50: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   55: ifeq -> 67
/*     */     //   58: aload_2
/*     */     //   59: aload #4
/*     */     //   61: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   66: pop
/*     */     //   67: goto -> 30
/*     */     //   70: aload_2
/*     */     //   71: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #312	-> 0
/*     */     //   #314	-> 23
/*     */     //   #315	-> 47
/*     */     //   #316	-> 58
/*     */     //   #318	-> 67
/*     */     //   #319	-> 70
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
/*     */   
/*     */   public static <E> List<E> removeAll(Collection<E> paramCollection, Collection<?> paramCollection1) {
/*     */     // Byte code:
/*     */     //   0: new java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_2
/*     */     //   8: aload_0
/*     */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore_3
/*     */     //   15: aload_3
/*     */     //   16: invokeinterface hasNext : ()Z
/*     */     //   21: ifeq -> 55
/*     */     //   24: aload_3
/*     */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   30: astore #4
/*     */     //   32: aload_1
/*     */     //   33: aload #4
/*     */     //   35: invokeinterface contains : (Ljava/lang/Object;)Z
/*     */     //   40: ifne -> 52
/*     */     //   43: aload_2
/*     */     //   44: aload #4
/*     */     //   46: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   51: pop
/*     */     //   52: goto -> 15
/*     */     //   55: aload_2
/*     */     //   56: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #346	-> 0
/*     */     //   #347	-> 8
/*     */     //   #348	-> 32
/*     */     //   #349	-> 43
/*     */     //   #351	-> 52
/*     */     //   #352	-> 55
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
/*     */   public static <E> List<E> synchronizedList(List<E> paramList) {
/* 380 */     return Collections.synchronizedList(paramList);
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
/*     */   public static <E> List<E> unmodifiableList(List<? extends E> paramList) {
/* 394 */     return UnmodifiableList.unmodifiableList(paramList);
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
/*     */   public static <E> List<E> predicatedList(List<E> paramList, Predicate<E> paramPredicate) {
/* 412 */     return (List<E>)PredicatedList.predicatedList(paramList, paramPredicate);
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
/*     */   public static <E> List<E> transformedList(List<E> paramList, Transformer<? super E, ? extends E> paramTransformer) {
/* 437 */     return (List<E>)TransformedList.transformingList(paramList, paramTransformer);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> List<E> lazyList(List<E> paramList, Factory<? extends E> paramFactory) {
/* 471 */     return (List<E>)LazyList.lazyList(paramList, paramFactory);
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
/*     */   public static <E> List<E> fixedSizeList(List<E> paramList) {
/* 486 */     return (List<E>)FixedSizeList.fixedSizeList(paramList);
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
/*     */   public static <E> int indexOf(List<E> paramList, Predicate<E> paramPredicate) {
/* 502 */     if (paramList != null && paramPredicate != null) {
/* 503 */       for (byte b = 0; b < paramList.size(); b++) {
/* 504 */         E e = paramList.get(b);
/* 505 */         if (paramPredicate.evaluate(e)) {
/* 506 */           return b;
/*     */         }
/*     */       } 
/*     */     }
/* 510 */     return -1;
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
/*     */   public static <E> List<E> longestCommonSubsequence(List<E> paramList1, List<E> paramList2) {
/* 525 */     return longestCommonSubsequence(paramList1, paramList2, (Equator<? super E>)DefaultEquator.defaultEquator());
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
/*     */   public static <E> List<E> longestCommonSubsequence(List<E> paramList1, List<E> paramList2, Equator<? super E> paramEquator) {
/* 541 */     if (paramList1 == null || paramList2 == null) {
/* 542 */       throw new NullPointerException("List must not be null");
/*     */     }
/* 544 */     if (paramEquator == null) {
/* 545 */       throw new NullPointerException("Equator must not be null");
/*     */     }
/*     */     
/* 548 */     SequencesComparator sequencesComparator = new SequencesComparator(paramList1, paramList2, paramEquator);
/* 549 */     EditScript editScript = sequencesComparator.getScript();
/* 550 */     LcsVisitor<E> lcsVisitor = new LcsVisitor();
/* 551 */     editScript.visit(lcsVisitor);
/* 552 */     return lcsVisitor.getSubSequence();
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
/*     */   public static String longestCommonSubsequence(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 568 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/* 569 */       throw new NullPointerException("CharSequence must not be null");
/*     */     }
/* 571 */     List<?> list = longestCommonSubsequence(new CharSequenceAsList(paramCharSequence1), new CharSequenceAsList(paramCharSequence2));
/* 572 */     StringBuilder stringBuilder = new StringBuilder();
/* 573 */     for (Character character : list) {
/* 574 */       stringBuilder.append(character);
/*     */     }
/* 576 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class LcsVisitor<E>
/*     */     implements CommandVisitor<E>
/*     */   {
/* 586 */     private ArrayList<E> sequence = new ArrayList<E>();
/*     */ 
/*     */     
/*     */     public void visitInsertCommand(E param1E) {}
/*     */     
/*     */     public void visitDeleteCommand(E param1E) {}
/*     */     
/*     */     public void visitKeepCommand(E param1E) {
/* 594 */       this.sequence.add(param1E);
/*     */     }
/*     */     
/*     */     public List<E> getSubSequence() {
/* 598 */       return this.sequence;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class CharSequenceAsList
/*     */     extends AbstractList<Character>
/*     */   {
/*     */     private final CharSequence sequence;
/*     */ 
/*     */     
/*     */     public CharSequenceAsList(CharSequence param1CharSequence) {
/* 610 */       this.sequence = param1CharSequence;
/*     */     }
/*     */ 
/*     */     
/*     */     public Character get(int param1Int) {
/* 615 */       return Character.valueOf(this.sequence.charAt(param1Int));
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 620 */       return this.sequence.length();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> List<List<T>> partition(List<T> paramList, int paramInt) {
/* 649 */     if (paramList == null) {
/* 650 */       throw new NullPointerException("List must not be null");
/*     */     }
/* 652 */     if (paramInt <= 0) {
/* 653 */       throw new IllegalArgumentException("Size must be greater than 0");
/*     */     }
/* 655 */     return new Partition<T>(paramList, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Partition<T>
/*     */     extends AbstractList<List<T>>
/*     */   {
/*     */     private final List<T> list;
/*     */     
/*     */     private final int size;
/*     */     
/*     */     private Partition(List<T> param1List, int param1Int) {
/* 667 */       this.list = param1List;
/* 668 */       this.size = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<T> get(int param1Int) {
/* 673 */       int i = size();
/* 674 */       if (i < 0) {
/* 675 */         throw new IllegalArgumentException("negative size: " + i);
/*     */       }
/* 677 */       if (param1Int < 0) {
/* 678 */         throw new IndexOutOfBoundsException("Index " + param1Int + " must not be negative");
/*     */       }
/* 680 */       if (param1Int >= i) {
/* 681 */         throw new IndexOutOfBoundsException("Index " + param1Int + " must be less than size " + i);
/*     */       }
/*     */       
/* 684 */       int j = param1Int * this.size;
/* 685 */       int k = Math.min(j + this.size, this.list.size());
/* 686 */       return this.list.subList(j, k);
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 691 */       return (this.list.size() + this.size - 1) / this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 696 */       return this.list.isEmpty();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\ListUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */