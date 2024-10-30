/*     */ package org.apache.commons.collections4.comparators;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BooleanComparator
/*     */   implements Serializable, Comparator<Boolean>
/*     */ {
/*     */   private static final long serialVersionUID = 1830042991606340609L;
/*  39 */   private static final BooleanComparator TRUE_FIRST = new BooleanComparator(true);
/*     */ 
/*     */   
/*  42 */   private static final BooleanComparator FALSE_FIRST = new BooleanComparator(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean trueFirst = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BooleanComparator getTrueFirstComparator() {
/*  61 */     return TRUE_FIRST;
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
/*     */   public static BooleanComparator getFalseFirstComparator() {
/*  77 */     return FALSE_FIRST;
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
/*     */   public static BooleanComparator booleanComparator(boolean paramBoolean) {
/*  97 */     return paramBoolean ? TRUE_FIRST : FALSE_FIRST;
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
/*     */   public BooleanComparator() {
/* 110 */     this(false);
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
/*     */   public BooleanComparator(boolean paramBoolean) {
/* 124 */     this.trueFirst = paramBoolean;
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
/*     */   public int compare(Boolean paramBoolean1, Boolean paramBoolean2) {
/* 139 */     boolean bool1 = paramBoolean1.booleanValue();
/* 140 */     boolean bool2 = paramBoolean2.booleanValue();
/*     */     
/* 142 */     return (bool1 ^ bool2) ? ((bool1 ^ this.trueFirst) ? 1 : -1) : 0;
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
/* 154 */     int i = "BooleanComparator".hashCode();
/* 155 */     return this.trueFirst ? (-1 * i) : i;
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
/*     */   public boolean equals(Object paramObject) {
/* 172 */     return (this == paramObject || (paramObject instanceof BooleanComparator && this.trueFirst == ((BooleanComparator)paramObject).trueFirst));
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
/*     */   public boolean sortsTrueFirst() {
/* 189 */     return this.trueFirst;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\comparators\BooleanComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */