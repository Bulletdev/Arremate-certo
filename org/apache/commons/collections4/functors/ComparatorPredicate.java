/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComparatorPredicate<T>
/*     */   implements Serializable, Predicate<T>
/*     */ {
/*     */   private static final long serialVersionUID = -1863209236504077399L;
/*     */   private final T object;
/*     */   private final Comparator<T> comparator;
/*     */   private final Criterion criterion;
/*     */   
/*     */   public enum Criterion
/*     */   {
/*  84 */     EQUAL, GREATER, LESS, GREATER_OR_EQUAL, LESS_OR_EQUAL;
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
/*     */   public static <T> Predicate<T> comparatorPredicate(T paramT, Comparator<T> paramComparator) {
/* 108 */     return comparatorPredicate(paramT, paramComparator, Criterion.EQUAL);
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
/*     */   public static <T> Predicate<T> comparatorPredicate(T paramT, Comparator<T> paramComparator, Criterion paramCriterion) {
/* 123 */     if (paramComparator == null) {
/* 124 */       throw new NullPointerException("Comparator must not be null.");
/*     */     }
/* 126 */     if (paramCriterion == null) {
/* 127 */       throw new NullPointerException("Criterion must not be null.");
/*     */     }
/* 129 */     return new ComparatorPredicate<T>(paramT, paramComparator, paramCriterion);
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
/*     */   public ComparatorPredicate(T paramT, Comparator<T> paramComparator, Criterion paramCriterion) {
/* 142 */     this.object = paramT;
/* 143 */     this.comparator = paramComparator;
/* 144 */     this.criterion = paramCriterion;
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
/*     */   public boolean evaluate(T paramT) {
/* 167 */     boolean bool = false;
/* 168 */     int i = this.comparator.compare(this.object, paramT);
/* 169 */     switch (this.criterion) {
/*     */       case EQUAL:
/* 171 */         bool = (i == 0) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 189 */         return bool;case GREATER: bool = (i > 0) ? true : false; return bool;case LESS: bool = (i < 0) ? true : false; return bool;case GREATER_OR_EQUAL: bool = (i >= 0) ? true : false; return bool;case LESS_OR_EQUAL: bool = (i <= 0) ? true : false; return bool;
/*     */     } 
/*     */     throw new IllegalStateException("The current criterion '" + this.criterion + "' is invalid.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\ComparatorPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */