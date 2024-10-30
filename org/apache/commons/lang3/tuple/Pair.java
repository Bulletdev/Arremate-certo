/*     */ package org.apache.commons.lang3.tuple;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
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
/*     */ public abstract class Pair<L, R>
/*     */   implements Serializable, Comparable<Pair<L, R>>, Map.Entry<L, R>
/*     */ {
/*     */   private static final long serialVersionUID = 4954918890077093841L;
/*     */   
/*     */   private static final class PairAdapter<L, R>
/*     */     extends Pair<L, R>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public L getLeft() {
/*  49 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public R getRight() {
/*  54 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public R setValue(R param1R) {
/*  59 */       return null;
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
/*  75 */   public static final Pair<?, ?>[] EMPTY_ARRAY = (Pair<?, ?>[])new PairAdapter[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <L, R> Pair<L, R>[] emptyArray() {
/*  88 */     return (Pair<L, R>[])EMPTY_ARRAY;
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
/*     */   public static <L, R> Pair<L, R> of(L paramL, R paramR) {
/* 104 */     return ImmutablePair.of(paramL, paramR);
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
/*     */   public static <L, R> Pair<L, R> of(Map.Entry<L, R> paramEntry) {
/* 120 */     return ImmutablePair.of(paramEntry);
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
/*     */   public int compareTo(Pair<L, R> paramPair) {
/* 133 */     return (new CompareToBuilder()).append(getLeft(), paramPair.getLeft())
/* 134 */       .append(getRight(), paramPair.getRight()).toComparison();
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
/* 145 */     if (paramObject == this) {
/* 146 */       return true;
/*     */     }
/* 148 */     if (paramObject instanceof Map.Entry) {
/* 149 */       Map.Entry entry = (Map.Entry)paramObject;
/* 150 */       return (Objects.equals(getKey(), entry.getKey()) && 
/* 151 */         Objects.equals(getValue(), entry.getValue()));
/*     */     } 
/* 153 */     return false;
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
/*     */   public final L getKey() {
/* 166 */     return getLeft();
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
/*     */   public R getValue() {
/* 198 */     return getRight();
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
/* 210 */     return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 220 */     return "(" + getLeft() + ',' + getRight() + ')';
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
/* 235 */     return String.format(paramString, new Object[] { getLeft(), getRight() });
/*     */   }
/*     */   
/*     */   public abstract L getLeft();
/*     */   
/*     */   public abstract R getRight();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\tuple\Pair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */