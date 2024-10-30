/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections4.functors.ChainedClosure;
/*     */ import org.apache.commons.collections4.functors.EqualPredicate;
/*     */ import org.apache.commons.collections4.functors.ExceptionClosure;
/*     */ import org.apache.commons.collections4.functors.ForClosure;
/*     */ import org.apache.commons.collections4.functors.IfClosure;
/*     */ import org.apache.commons.collections4.functors.InvokerTransformer;
/*     */ import org.apache.commons.collections4.functors.NOPClosure;
/*     */ import org.apache.commons.collections4.functors.SwitchClosure;
/*     */ import org.apache.commons.collections4.functors.TransformerClosure;
/*     */ import org.apache.commons.collections4.functors.WhileClosure;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClosureUtils
/*     */ {
/*     */   public static <E> Closure<E> exceptionClosure() {
/*  77 */     return ExceptionClosure.exceptionClosure();
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
/*     */   public static <E> Closure<E> nopClosure() {
/*  90 */     return NOPClosure.nopClosure();
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
/*     */   public static <E> Closure<E> asClosure(Transformer<? super E, ?> paramTransformer) {
/* 105 */     return TransformerClosure.transformerClosure(paramTransformer);
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
/*     */   public static <E> Closure<E> forClosure(int paramInt, Closure<? super E> paramClosure) {
/* 121 */     return ForClosure.forClosure(paramInt, paramClosure);
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
/*     */   public static <E> Closure<E> whileClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure) {
/* 137 */     return WhileClosure.whileClosure(paramPredicate, paramClosure, false);
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
/*     */   public static <E> Closure<E> doWhileClosure(Closure<? super E> paramClosure, Predicate<? super E> paramPredicate) {
/* 154 */     return WhileClosure.whileClosure(paramPredicate, paramClosure, true);
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
/*     */   public static <E> Closure<E> invokerClosure(String paramString) {
/* 171 */     return asClosure(InvokerTransformer.invokerTransformer(paramString));
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
/*     */   public static <E> Closure<E> invokerClosure(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 192 */     return asClosure(InvokerTransformer.invokerTransformer(paramString, paramArrayOfClass, paramArrayOfObject));
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
/*     */   public static <E> Closure<E> chainedClosure(Closure<? super E>... paramVarArgs) {
/* 208 */     return ChainedClosure.chainedClosure((Closure[])paramVarArgs);
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
/*     */   public static <E> Closure<E> chainedClosure(Collection<? extends Closure<? super E>> paramCollection) {
/* 226 */     return ChainedClosure.chainedClosure(paramCollection);
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
/*     */   public static <E> Closure<E> ifClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure) {
/* 244 */     return IfClosure.ifClosure(paramPredicate, paramClosure);
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
/*     */   public static <E> Closure<E> ifClosure(Predicate<? super E> paramPredicate, Closure<? super E> paramClosure1, Closure<? super E> paramClosure2) {
/* 263 */     return IfClosure.ifClosure(paramPredicate, paramClosure1, paramClosure2);
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
/*     */   public static <E> Closure<E> switchClosure(Predicate<? super E>[] paramArrayOfPredicate, Closure<? super E>[] paramArrayOfClosure) {
/* 286 */     return SwitchClosure.switchClosure((Predicate[])paramArrayOfPredicate, (Closure[])paramArrayOfClosure, null);
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
/*     */   public static <E> Closure<E> switchClosure(Predicate<? super E>[] paramArrayOfPredicate, Closure<? super E>[] paramArrayOfClosure, Closure<? super E> paramClosure) {
/* 312 */     return SwitchClosure.switchClosure((Predicate[])paramArrayOfPredicate, (Closure[])paramArrayOfClosure, paramClosure);
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
/*     */   public static <E> Closure<E> switchClosure(Map<Predicate<E>, Closure<E>> paramMap) {
/* 337 */     return SwitchClosure.switchClosure(paramMap);
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
/*     */   public static <E> Closure<E> switchMapClosure(Map<? extends E, Closure<E>> paramMap) {
/* 360 */     if (paramMap == null) {
/* 361 */       throw new NullPointerException("The object and closure map must not be null");
/*     */     }
/* 363 */     Closure<? super E> closure = paramMap.remove(null);
/* 364 */     int i = paramMap.size();
/* 365 */     Closure[] arrayOfClosure = new Closure[i];
/* 366 */     Predicate[] arrayOfPredicate = new Predicate[i];
/* 367 */     byte b = 0;
/* 368 */     for (Map.Entry<? extends E, Closure<E>> entry : paramMap.entrySet()) {
/* 369 */       arrayOfPredicate[b] = EqualPredicate.equalPredicate(entry.getKey());
/* 370 */       arrayOfClosure[b] = (Closure)entry.getValue();
/* 371 */       b++;
/*     */     } 
/* 373 */     return switchClosure((Predicate<? super E>[])arrayOfPredicate, (Closure<? super E>[])arrayOfClosure, closure);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\ClosureUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */