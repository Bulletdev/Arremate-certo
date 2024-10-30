/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.util.Collection;
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
/*     */ public final class AnyPredicate<T>
/*     */   extends AbstractQuantifierPredicate<T>
/*     */ {
/*     */   private static final long serialVersionUID = 7429999530934647542L;
/*     */   
/*     */   public static <T> Predicate<T> anyPredicate(Predicate<? super T>... paramVarArgs) {
/*  53 */     FunctorUtils.validate((Predicate<?>[])paramVarArgs);
/*  54 */     if (paramVarArgs.length == 0) {
/*  55 */       return FalsePredicate.falsePredicate();
/*     */     }
/*  57 */     if (paramVarArgs.length == 1) {
/*  58 */       return (Predicate)paramVarArgs[0];
/*     */     }
/*  60 */     return new AnyPredicate<T>((Predicate<? super T>[])FunctorUtils.copy(paramVarArgs));
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
/*     */   public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<? super T>> paramCollection) {
/*  77 */     Predicate[] arrayOfPredicate = (Predicate[])FunctorUtils.validate(paramCollection);
/*  78 */     if (arrayOfPredicate.length == 0) {
/*  79 */       return FalsePredicate.falsePredicate();
/*     */     }
/*  81 */     if (arrayOfPredicate.length == 1) {
/*  82 */       return arrayOfPredicate[0];
/*     */     }
/*  84 */     return new AnyPredicate<T>((Predicate<? super T>[])arrayOfPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnyPredicate(Predicate<? super T>... paramVarArgs) {
/*  94 */     super(paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean evaluate(T paramT) {
/* 104 */     for (Predicate<? super T> predicate : this.iPredicates) {
/* 105 */       if (predicate.evaluate(paramT)) {
/* 106 */         return true;
/*     */       }
/*     */     } 
/* 109 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\AnyPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */