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
/*     */ public final class OnePredicate<T>
/*     */   extends AbstractQuantifierPredicate<T>
/*     */ {
/*     */   private static final long serialVersionUID = -8125389089924745785L;
/*     */   
/*     */   public static <T> Predicate<T> onePredicate(Predicate<? super T>... paramVarArgs) {
/*  53 */     FunctorUtils.validate((Predicate<?>[])paramVarArgs);
/*  54 */     if (paramVarArgs.length == 0) {
/*  55 */       return FalsePredicate.falsePredicate();
/*     */     }
/*  57 */     if (paramVarArgs.length == 1) {
/*  58 */       return (Predicate)paramVarArgs[0];
/*     */     }
/*  60 */     return new OnePredicate<T>((Predicate<? super T>[])FunctorUtils.copy(paramVarArgs));
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
/*     */   public static <T> Predicate<T> onePredicate(Collection<? extends Predicate<? super T>> paramCollection) {
/*  73 */     Predicate[] arrayOfPredicate = (Predicate[])FunctorUtils.validate(paramCollection);
/*  74 */     return new OnePredicate<T>((Predicate<? super T>[])arrayOfPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OnePredicate(Predicate<? super T>... paramVarArgs) {
/*  84 */     super(paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean evaluate(T paramT) {
/*  95 */     boolean bool = false;
/*  96 */     for (Predicate<? super T> predicate : this.iPredicates) {
/*  97 */       if (predicate.evaluate(paramT)) {
/*  98 */         if (bool) {
/*  99 */           return false;
/*     */         }
/* 101 */         bool = true;
/*     */       } 
/*     */     } 
/* 104 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\OnePredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */