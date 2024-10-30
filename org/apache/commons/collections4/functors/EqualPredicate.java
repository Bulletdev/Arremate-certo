/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.commons.collections4.Equator;
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
/*     */ public final class EqualPredicate<T>
/*     */   implements Serializable, Predicate<T>
/*     */ {
/*     */   private static final long serialVersionUID = 5633766978029907089L;
/*     */   private final T iValue;
/*     */   private final Equator<T> equator;
/*     */   
/*     */   public static <T> Predicate<T> equalPredicate(T paramT) {
/*  50 */     if (paramT == null) {
/*  51 */       return NullPredicate.nullPredicate();
/*     */     }
/*  53 */     return new EqualPredicate<T>(paramT);
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
/*     */   public static <T> Predicate<T> equalPredicate(T paramT, Equator<T> paramEquator) {
/*  66 */     if (paramT == null) {
/*  67 */       return NullPredicate.nullPredicate();
/*     */     }
/*  69 */     return new EqualPredicate<T>(paramT, paramEquator);
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
/*     */   public EqualPredicate(T paramT) {
/*  81 */     this(paramT, null);
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
/*     */   public EqualPredicate(T paramT, Equator<T> paramEquator) {
/*  94 */     this.iValue = paramT;
/*  95 */     this.equator = paramEquator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean evaluate(T paramT) {
/* 105 */     if (this.equator != null) {
/* 106 */       return this.equator.equate(this.iValue, paramT);
/*     */     }
/* 108 */     return this.iValue.equals(paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getValue() {
/* 119 */     return this.iValue;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\EqualPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */