/*     */ package org.apache.commons.lang3.compare;
/*     */ 
/*     */ import java.util.function.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComparableUtils
/*     */ {
/*     */   public static class ComparableCheckBuilder<A extends Comparable<A>>
/*     */   {
/*     */     private final A a;
/*     */     
/*     */     private ComparableCheckBuilder(A param1A) {
/*  42 */       this.a = param1A;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean between(A param1A1, A param1A2) {
/*  53 */       return (betweenOrdered(param1A1, param1A2) || betweenOrdered(param1A2, param1A1));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean betweenExclusive(A param1A1, A param1A2) {
/*  64 */       return (betweenOrderedExclusive(param1A1, param1A2) || betweenOrderedExclusive(param1A2, param1A1));
/*     */     }
/*     */     
/*     */     private boolean betweenOrdered(A param1A1, A param1A2) {
/*  68 */       return (greaterThanOrEqualTo(param1A1) && lessThanOrEqualTo(param1A2));
/*     */     }
/*     */     
/*     */     private boolean betweenOrderedExclusive(A param1A1, A param1A2) {
/*  72 */       return (greaterThan(param1A1) && lessThan(param1A2));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equalTo(A param1A) {
/*  82 */       return (this.a.compareTo(param1A) == 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean greaterThan(A param1A) {
/*  92 */       return (this.a.compareTo(param1A) > 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean greaterThanOrEqualTo(A param1A) {
/* 102 */       return (this.a.compareTo(param1A) >= 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean lessThan(A param1A) {
/* 112 */       return (this.a.compareTo(param1A) < 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean lessThanOrEqualTo(A param1A) {
/* 122 */       return (this.a.compareTo(param1A) <= 0);
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
/*     */   public static <A extends Comparable<A>> Predicate<A> between(A paramA1, A paramA2) {
/* 135 */     return paramComparable3 -> is(paramComparable3).between(paramComparable1, paramComparable2);
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
/*     */   public static <A extends Comparable<A>> Predicate<A> betweenExclusive(A paramA1, A paramA2) {
/* 147 */     return paramComparable3 -> is(paramComparable3).betweenExclusive(paramComparable1, paramComparable2);
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
/*     */   public static <A extends Comparable<A>> Predicate<A> ge(A paramA) {
/* 159 */     return paramComparable2 -> is(paramComparable2).greaterThanOrEqualTo(paramComparable1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <A extends Comparable<A>> Predicate<A> gt(A paramA) {
/* 170 */     return paramComparable2 -> is(paramComparable2).greaterThan(paramComparable1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <A extends Comparable<A>> ComparableCheckBuilder<A> is(A paramA) {
/* 181 */     return new ComparableCheckBuilder<>((Comparable)paramA);
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
/*     */   public static <A extends Comparable<A>> Predicate<A> le(A paramA) {
/* 193 */     return paramComparable2 -> is(paramComparable2).lessThanOrEqualTo(paramComparable1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <A extends Comparable<A>> Predicate<A> lt(A paramA) {
/* 204 */     return paramComparable2 -> is(paramComparable2).lessThan(paramComparable1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\compare\ComparableUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */