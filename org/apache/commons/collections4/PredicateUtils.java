/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import org.apache.commons.collections4.functors.AllPredicate;
/*     */ import org.apache.commons.collections4.functors.AndPredicate;
/*     */ import org.apache.commons.collections4.functors.AnyPredicate;
/*     */ import org.apache.commons.collections4.functors.EqualPredicate;
/*     */ import org.apache.commons.collections4.functors.ExceptionPredicate;
/*     */ import org.apache.commons.collections4.functors.FalsePredicate;
/*     */ import org.apache.commons.collections4.functors.IdentityPredicate;
/*     */ import org.apache.commons.collections4.functors.InstanceofPredicate;
/*     */ import org.apache.commons.collections4.functors.InvokerTransformer;
/*     */ import org.apache.commons.collections4.functors.NonePredicate;
/*     */ import org.apache.commons.collections4.functors.NotNullPredicate;
/*     */ import org.apache.commons.collections4.functors.NotPredicate;
/*     */ import org.apache.commons.collections4.functors.NullIsExceptionPredicate;
/*     */ import org.apache.commons.collections4.functors.NullIsFalsePredicate;
/*     */ import org.apache.commons.collections4.functors.NullIsTruePredicate;
/*     */ import org.apache.commons.collections4.functors.NullPredicate;
/*     */ import org.apache.commons.collections4.functors.OnePredicate;
/*     */ import org.apache.commons.collections4.functors.OrPredicate;
/*     */ import org.apache.commons.collections4.functors.TransformedPredicate;
/*     */ import org.apache.commons.collections4.functors.TransformerPredicate;
/*     */ import org.apache.commons.collections4.functors.TruePredicate;
/*     */ import org.apache.commons.collections4.functors.UniquePredicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PredicateUtils
/*     */ {
/*     */   public static <T> Predicate<T> exceptionPredicate() {
/*  91 */     return ExceptionPredicate.exceptionPredicate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> truePredicate() {
/* 102 */     return TruePredicate.truePredicate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> falsePredicate() {
/* 113 */     return FalsePredicate.falsePredicate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> nullPredicate() {
/* 124 */     return NullPredicate.nullPredicate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> notNullPredicate() {
/* 135 */     return NotNullPredicate.notNullPredicate();
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
/*     */   public static <T> Predicate<T> equalPredicate(T paramT) {
/* 148 */     return EqualPredicate.equalPredicate(paramT);
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
/*     */   public static <T> Predicate<T> identityPredicate(T paramT) {
/* 161 */     return IdentityPredicate.identityPredicate(paramT);
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
/*     */   public static Predicate<Object> instanceofPredicate(Class<?> paramClass) {
/* 175 */     return InstanceofPredicate.instanceOfPredicate(paramClass);
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
/*     */   public static <T> Predicate<T> uniquePredicate() {
/* 191 */     return UniquePredicate.uniquePredicate();
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
/*     */   public static <T> Predicate<T> invokerPredicate(String paramString) {
/* 213 */     return asPredicate(InvokerTransformer.invokerTransformer(paramString));
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
/*     */   public static <T> Predicate<T> invokerPredicate(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 239 */     return asPredicate(InvokerTransformer.invokerTransformer(paramString, paramArrayOfClass, paramArrayOfObject));
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
/*     */   public static <T> Predicate<T> andPredicate(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 258 */     return AndPredicate.andPredicate(paramPredicate1, paramPredicate2);
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
/*     */   public static <T> Predicate<T> allPredicate(Predicate<? super T>... paramVarArgs) {
/* 274 */     return AllPredicate.allPredicate((Predicate[])paramVarArgs);
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
/*     */   public static <T> Predicate<T> allPredicate(Collection<? extends Predicate<? super T>> paramCollection) {
/* 290 */     return AllPredicate.allPredicate(paramCollection);
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
/*     */   public static <T> Predicate<T> orPredicate(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 306 */     return OrPredicate.orPredicate(paramPredicate1, paramPredicate2);
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
/*     */   public static <T> Predicate<T> anyPredicate(Predicate<? super T>... paramVarArgs) {
/* 322 */     return AnyPredicate.anyPredicate((Predicate[])paramVarArgs);
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
/*     */   public static <T> Predicate<T> anyPredicate(Collection<? extends Predicate<? super T>> paramCollection) {
/* 338 */     return AnyPredicate.anyPredicate(paramCollection);
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
/*     */   public static <T> Predicate<T> eitherPredicate(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 355 */     return (Predicate)onePredicate((Predicate<?>[])new Predicate[] { paramPredicate1, paramPredicate2 });
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
/*     */   public static <T> Predicate<T> onePredicate(Predicate<? super T>... paramVarArgs) {
/* 372 */     return OnePredicate.onePredicate((Predicate[])paramVarArgs);
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
/*     */   public static <T> Predicate<T> onePredicate(Collection<? extends Predicate<? super T>> paramCollection) {
/* 388 */     return OnePredicate.onePredicate(paramCollection);
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
/*     */   public static <T> Predicate<T> neitherPredicate(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 405 */     return (Predicate)nonePredicate((Predicate<?>[])new Predicate[] { paramPredicate1, paramPredicate2 });
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
/*     */   public static <T> Predicate<T> nonePredicate(Predicate<? super T>... paramVarArgs) {
/* 422 */     return NonePredicate.nonePredicate((Predicate[])paramVarArgs);
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
/*     */   public static <T> Predicate<T> nonePredicate(Collection<? extends Predicate<? super T>> paramCollection) {
/* 438 */     return NonePredicate.nonePredicate(paramCollection);
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
/*     */   public static <T> Predicate<T> notPredicate(Predicate<? super T> paramPredicate) {
/* 452 */     return NotPredicate.notPredicate(paramPredicate);
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
/*     */   public static <T> Predicate<T> asPredicate(Transformer<? super T, Boolean> paramTransformer) {
/* 470 */     return TransformerPredicate.transformerPredicate(paramTransformer);
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
/*     */   public static <T> Predicate<T> nullIsExceptionPredicate(Predicate<? super T> paramPredicate) {
/* 488 */     return NullIsExceptionPredicate.nullIsExceptionPredicate(paramPredicate);
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
/*     */   public static <T> Predicate<T> nullIsFalsePredicate(Predicate<? super T> paramPredicate) {
/* 503 */     return NullIsFalsePredicate.nullIsFalsePredicate(paramPredicate);
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
/*     */   public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> paramPredicate) {
/* 518 */     return NullIsTruePredicate.nullIsTruePredicate(paramPredicate);
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
/*     */   public static <T> Predicate<T> transformedPredicate(Transformer<? super T, ? extends T> paramTransformer, Predicate<? super T> paramPredicate) {
/* 537 */     return TransformedPredicate.transformedPredicate(paramTransformer, paramPredicate);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\PredicateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */