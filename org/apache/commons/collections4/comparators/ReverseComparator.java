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
/*     */ public class ReverseComparator<E>
/*     */   implements Serializable, Comparator<E>
/*     */ {
/*     */   private static final long serialVersionUID = 2858887242028539265L;
/*     */   private final Comparator<? super E> comparator;
/*     */   
/*     */   public ReverseComparator() {
/*  51 */     this(null);
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
/*     */   public ReverseComparator(Comparator<? super E> paramComparator) {
/*  64 */     this.comparator = (paramComparator == null) ? ComparatorUtils.NATURAL_COMPARATOR : paramComparator;
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
/*     */   public int compare(E paramE1, E paramE2) {
/*  77 */     return this.comparator.compare(paramE2, paramE1);
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
/*     */   public int hashCode() {
/*  90 */     return "ReverseComparator".hashCode() ^ this.comparator.hashCode();
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
/*     */   public boolean equals(Object paramObject) {
/* 111 */     if (this == paramObject) {
/* 112 */       return true;
/*     */     }
/* 114 */     if (null == paramObject) {
/* 115 */       return false;
/*     */     }
/* 117 */     if (paramObject.getClass().equals(getClass())) {
/* 118 */       ReverseComparator reverseComparator = (ReverseComparator)paramObject;
/* 119 */       return this.comparator.equals(reverseComparator.comparator);
/*     */     } 
/* 121 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\comparators\ReverseComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */