/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import org.apache.commons.collections4.comparators.BooleanComparator;
/*     */ import org.apache.commons.collections4.comparators.ComparableComparator;
/*     */ import org.apache.commons.collections4.comparators.ComparatorChain;
/*     */ import org.apache.commons.collections4.comparators.NullComparator;
/*     */ import org.apache.commons.collections4.comparators.ReverseComparator;
/*     */ import org.apache.commons.collections4.comparators.TransformingComparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComparatorUtils
/*     */ {
/*  54 */   public static final Comparator NATURAL_COMPARATOR = (Comparator)ComparableComparator.comparableComparator();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Comparable<? super E>> Comparator<E> naturalComparator() {
/*  64 */     return NATURAL_COMPARATOR;
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
/*     */   public static <E> Comparator<E> chainedComparator(Comparator<E>... paramVarArgs) {
/*  78 */     ComparatorChain comparatorChain = new ComparatorChain();
/*  79 */     for (Comparator<E> comparator : paramVarArgs) {
/*  80 */       if (comparator == null) {
/*  81 */         throw new NullPointerException("Comparator cannot be null");
/*     */       }
/*  83 */       comparatorChain.addComparator(comparator);
/*     */     } 
/*  85 */     return (Comparator<E>)comparatorChain;
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
/*     */   public static <E> Comparator<E> chainedComparator(Collection<Comparator<E>> paramCollection) {
/* 102 */     return chainedComparator(paramCollection.<Comparator<E>>toArray((Comparator<E>[])new Comparator[paramCollection.size()]));
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
/*     */   public static <E> Comparator<E> reversedComparator(Comparator<E> paramComparator) {
/* 116 */     return (Comparator<E>)new ReverseComparator(paramComparator);
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
/*     */   public static Comparator<Boolean> booleanComparator(boolean paramBoolean) {
/* 132 */     return (Comparator<Boolean>)BooleanComparator.booleanComparator(paramBoolean);
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
/*     */   public static <E> Comparator<E> nullLowComparator(Comparator<E> paramComparator) {
/* 149 */     if (paramComparator == null) {
/* 150 */       paramComparator = NATURAL_COMPARATOR;
/*     */     }
/* 152 */     return (Comparator<E>)new NullComparator(paramComparator, false);
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
/*     */   public static <E> Comparator<E> nullHighComparator(Comparator<E> paramComparator) {
/* 169 */     if (paramComparator == null) {
/* 170 */       paramComparator = NATURAL_COMPARATOR;
/*     */     }
/* 172 */     return (Comparator<E>)new NullComparator(paramComparator, true);
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
/*     */   public static <I, O> Comparator<I> transformedComparator(Comparator<O> paramComparator, Transformer<? super I, ? extends O> paramTransformer) {
/* 193 */     if (paramComparator == null) {
/* 194 */       paramComparator = NATURAL_COMPARATOR;
/*     */     }
/* 196 */     return (Comparator<I>)new TransformingComparator(paramTransformer, paramComparator);
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
/*     */   public static <E> E min(E paramE1, E paramE2, Comparator<E> paramComparator) {
/* 212 */     if (paramComparator == null) {
/* 213 */       paramComparator = NATURAL_COMPARATOR;
/*     */     }
/* 215 */     int i = paramComparator.compare(paramE1, paramE2);
/* 216 */     return (i < 0) ? paramE1 : paramE2;
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
/*     */   public static <E> E max(E paramE1, E paramE2, Comparator<E> paramComparator) {
/* 232 */     if (paramComparator == null) {
/* 233 */       paramComparator = NATURAL_COMPARATOR;
/*     */     }
/* 235 */     int i = paramComparator.compare(paramE1, paramE2);
/* 236 */     return (i > 0) ? paramE1 : paramE2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\ComparatorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */