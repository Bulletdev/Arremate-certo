/*     */ package org.apache.commons.collections4.comparators;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ import org.apache.commons.collections4.ComparatorUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NullComparator<E>
/*     */   implements Serializable, Comparator<E>
/*     */ {
/*     */   private static final long serialVersionUID = -5820772575483504339L;
/*     */   private final Comparator<? super E> nonNullComparator;
/*     */   private final boolean nullsAreHigh;
/*     */   
/*     */   public NullComparator() {
/*  56 */     this(ComparatorUtils.NATURAL_COMPARATOR, true);
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
/*     */   public NullComparator(Comparator<? super E> paramComparator) {
/*  73 */     this(paramComparator, true);
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
/*     */   public NullComparator(boolean paramBoolean) {
/*  90 */     this(ComparatorUtils.NATURAL_COMPARATOR, paramBoolean);
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
/*     */   public NullComparator(Comparator<? super E> paramComparator, boolean paramBoolean) {
/* 113 */     this.nonNullComparator = paramComparator;
/* 114 */     this.nullsAreHigh = paramBoolean;
/*     */     
/* 116 */     if (paramComparator == null) {
/* 117 */       throw new NullPointerException("null nonNullComparator");
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
/*     */   public int compare(E paramE1, E paramE2) {
/* 140 */     if (paramE1 == paramE2) return 0; 
/* 141 */     if (paramE1 == null) return this.nullsAreHigh ? 1 : -1; 
/* 142 */     if (paramE2 == null) return this.nullsAreHigh ? -1 : 1; 
/* 143 */     return this.nonNullComparator.compare(paramE1, paramE2);
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
/*     */   public int hashCode() {
/* 155 */     return (this.nullsAreHigh ? -1 : 1) * this.nonNullComparator.hashCode();
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
/*     */   public boolean equals(Object paramObject) {
/* 171 */     if (paramObject == null) return false; 
/* 172 */     if (paramObject == this) return true; 
/* 173 */     if (!paramObject.getClass().equals(getClass())) return false;
/*     */     
/* 175 */     NullComparator nullComparator = (NullComparator)paramObject;
/*     */     
/* 177 */     return (this.nullsAreHigh == nullComparator.nullsAreHigh && this.nonNullComparator.equals(nullComparator.nonNullComparator));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\comparators\NullComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */