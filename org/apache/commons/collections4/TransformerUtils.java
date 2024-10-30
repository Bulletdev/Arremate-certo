/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.functors.ChainedTransformer;
/*     */ import org.apache.commons.collections4.functors.CloneTransformer;
/*     */ import org.apache.commons.collections4.functors.ClosureTransformer;
/*     */ import org.apache.commons.collections4.functors.ConstantTransformer;
/*     */ import org.apache.commons.collections4.functors.EqualPredicate;
/*     */ import org.apache.commons.collections4.functors.ExceptionTransformer;
/*     */ import org.apache.commons.collections4.functors.FactoryTransformer;
/*     */ import org.apache.commons.collections4.functors.IfTransformer;
/*     */ import org.apache.commons.collections4.functors.InstantiateTransformer;
/*     */ import org.apache.commons.collections4.functors.InvokerTransformer;
/*     */ import org.apache.commons.collections4.functors.MapTransformer;
/*     */ import org.apache.commons.collections4.functors.NOPTransformer;
/*     */ import org.apache.commons.collections4.functors.PredicateTransformer;
/*     */ import org.apache.commons.collections4.functors.StringValueTransformer;
/*     */ import org.apache.commons.collections4.functors.SwitchTransformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformerUtils
/*     */ {
/*     */   public static <I, O> Transformer<I, O> exceptionTransformer() {
/*  88 */     return ExceptionTransformer.exceptionTransformer();
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
/*     */   public static <I, O> Transformer<I, O> nullTransformer() {
/* 100 */     return ConstantTransformer.nullTransformer();
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
/*     */   public static <T> Transformer<T, T> nopTransformer() {
/* 113 */     return NOPTransformer.nopTransformer();
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
/*     */   public static <T> Transformer<T, T> cloneTransformer() {
/* 130 */     return CloneTransformer.cloneTransformer();
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
/*     */   public static <I, O> Transformer<I, O> constantTransformer(O paramO) {
/* 144 */     return ConstantTransformer.constantTransformer(paramO);
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
/*     */   public static <T> Transformer<T, T> asTransformer(Closure<? super T> paramClosure) {
/* 158 */     return ClosureTransformer.closureTransformer(paramClosure);
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
/*     */   public static <T> Transformer<T, Boolean> asTransformer(Predicate<? super T> paramPredicate) {
/* 172 */     return PredicateTransformer.predicateTransformer(paramPredicate);
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
/*     */   public static <I, O> Transformer<I, O> asTransformer(Factory<? extends O> paramFactory) {
/* 187 */     return FactoryTransformer.factoryTransformer(paramFactory);
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
/*     */   public static <T> Transformer<T, T> chainedTransformer(Transformer<? super T, ? extends T>... paramVarArgs) {
/* 202 */     return ChainedTransformer.chainedTransformer((Transformer[])paramVarArgs);
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
/*     */   public static <T> Transformer<T, T> chainedTransformer(Collection<? extends Transformer<? super T, ? extends T>> paramCollection) {
/* 218 */     return ChainedTransformer.chainedTransformer(paramCollection);
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
/*     */   public static <T> Transformer<T, T> ifTransformer(Predicate<? super T> paramPredicate, Transformer<? super T, ? extends T> paramTransformer) {
/* 235 */     return IfTransformer.ifTransformer(paramPredicate, paramTransformer);
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
/*     */   public static <I, O> Transformer<I, O> ifTransformer(Predicate<? super I> paramPredicate, Transformer<? super I, ? extends O> paramTransformer1, Transformer<? super I, ? extends O> paramTransformer2) {
/* 255 */     return IfTransformer.ifTransformer(paramPredicate, paramTransformer1, paramTransformer2);
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
/*     */   @Deprecated
/*     */   public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I> paramPredicate, Transformer<? super I, ? extends O> paramTransformer1, Transformer<? super I, ? extends O> paramTransformer2) {
/* 277 */     return SwitchTransformer.switchTransformer(new Predicate[] { paramPredicate }, new Transformer[] { paramTransformer1 }, paramTransformer2);
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
/*     */   public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] paramArrayOfPredicate, Transformer<? super I, ? extends O>[] paramArrayOfTransformer) {
/* 299 */     return SwitchTransformer.switchTransformer((Predicate[])paramArrayOfPredicate, (Transformer[])paramArrayOfTransformer, null);
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
/*     */   public static <I, O> Transformer<I, O> switchTransformer(Predicate<? super I>[] paramArrayOfPredicate, Transformer<? super I, ? extends O>[] paramArrayOfTransformer, Transformer<? super I, ? extends O> paramTransformer) {
/* 323 */     return SwitchTransformer.switchTransformer((Predicate[])paramArrayOfPredicate, (Transformer[])paramArrayOfTransformer, paramTransformer);
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
/*     */   public static <I, O> Transformer<I, O> switchTransformer(Map<Predicate<I>, Transformer<I, O>> paramMap) {
/* 349 */     return SwitchTransformer.switchTransformer(paramMap);
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
/*     */   public static <I, O> Transformer<I, O> switchMapTransformer(Map<I, Transformer<I, O>> paramMap) {
/* 373 */     if (paramMap == null) {
/* 374 */       throw new NullPointerException("The object and transformer map must not be null");
/*     */     }
/* 376 */     Transformer<? super I, ? extends O> transformer = paramMap.remove(null);
/* 377 */     int i = paramMap.size();
/* 378 */     Transformer[] arrayOfTransformer = new Transformer[i];
/* 379 */     Predicate[] arrayOfPredicate = new Predicate[i];
/* 380 */     byte b = 0;
/* 381 */     for (Map.Entry<I, Transformer<I, O>> entry : paramMap.entrySet()) {
/* 382 */       arrayOfPredicate[b] = EqualPredicate.equalPredicate(entry.getKey());
/* 383 */       arrayOfTransformer[b++] = (Transformer)entry.getValue();
/*     */     } 
/* 385 */     return switchTransformer((Predicate<? super I>[])arrayOfPredicate, (Transformer<? super I, ? extends O>[])arrayOfTransformer, transformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Transformer<Class<? extends T>, T> instantiateTransformer() {
/* 396 */     return InstantiateTransformer.instantiateTransformer();
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
/*     */   public static <T> Transformer<Class<? extends T>, T> instantiateTransformer(Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 413 */     return InstantiateTransformer.instantiateTransformer(paramArrayOfClass, paramArrayOfObject);
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
/*     */   public static <I, O> Transformer<I, O> mapTransformer(Map<? super I, ? extends O> paramMap) {
/* 428 */     return MapTransformer.mapTransformer(paramMap);
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
/*     */   public static <I, O> Transformer<I, O> invokerTransformer(String paramString) {
/* 448 */     return InvokerTransformer.invokerTransformer(paramString, null, null);
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
/*     */   public static <I, O> Transformer<I, O> invokerTransformer(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 468 */     return InvokerTransformer.invokerTransformer(paramString, paramArrayOfClass, paramArrayOfObject);
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
/*     */   public static <T> Transformer<T, String> stringValueTransformer() {
/* 481 */     return StringValueTransformer.stringValueTransformer();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\TransformerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */