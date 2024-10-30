/*     */ package org.apache.commons.lang3.tuple;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Objects;
/*     */ import org.apache.commons.lang3.builder.CompareToBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Triple<L, M, R>
/*     */   implements Serializable, Comparable<Triple<L, M, R>>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   private static final class TripleAdapter<L, M, R>
/*     */     extends Triple<L, M, R>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public L getLeft() {
/*  48 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public M getMiddle() {
/*  53 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public R getRight() {
/*  58 */       return null;
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
/*  74 */   public static final Triple<?, ?, ?>[] EMPTY_ARRAY = (Triple<?, ?, ?>[])new TripleAdapter[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <L, M, R> Triple<L, M, R>[] emptyArray() {
/*  88 */     return (Triple<L, M, R>[])EMPTY_ARRAY;
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
/*     */   public static <L, M, R> Triple<L, M, R> of(L paramL, M paramM, R paramR) {
/* 106 */     return new ImmutableTriple<>(paramL, paramM, paramR);
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
/*     */   public int compareTo(Triple<L, M, R> paramTriple) {
/* 120 */     return (new CompareToBuilder()).append(getLeft(), paramTriple.getLeft())
/* 121 */       .append(getMiddle(), paramTriple.getMiddle())
/* 122 */       .append(getRight(), paramTriple.getRight()).toComparison();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 133 */     if (paramObject == this) {
/* 134 */       return true;
/*     */     }
/* 136 */     if (paramObject instanceof Triple) {
/* 137 */       Triple triple = (Triple)paramObject;
/* 138 */       return (Objects.equals(getLeft(), triple.getLeft()) && 
/* 139 */         Objects.equals(getMiddle(), triple.getMiddle()) && 
/* 140 */         Objects.equals(getRight(), triple.getRight()));
/*     */     } 
/* 142 */     return false;
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
/*     */   public int hashCode() {
/* 174 */     return Objects.hashCode(getLeft()) ^ Objects.hashCode(getMiddle()) ^ Objects.hashCode(getRight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 184 */     return "(" + getLeft() + "," + getMiddle() + "," + getRight() + ")";
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
/*     */   public String toString(String paramString) {
/* 199 */     return String.format(paramString, new Object[] { getLeft(), getMiddle(), getRight() });
/*     */   }
/*     */   
/*     */   public abstract L getLeft();
/*     */   
/*     */   public abstract M getMiddle();
/*     */   
/*     */   public abstract R getRight();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\tuple\Triple.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */