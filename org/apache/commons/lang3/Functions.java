/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.UncheckedIOException;
/*     */ import java.lang.reflect.UndeclaredThrowableException;
/*     */ import java.util.Collection;
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.BiFunction;
/*     */ import java.util.function.BiPredicate;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Stream;
/*     */ import org.apache.commons.lang3.function.FailableBooleanSupplier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class Functions
/*     */ {
/*     */   public static <O1, O2, T extends Throwable> void accept(FailableBiConsumer<O1, O2, T> paramFailableBiConsumer, O1 paramO1, O2 paramO2) {
/* 294 */     run(() -> paramFailableBiConsumer.accept(paramObject1, paramObject2));
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
/*     */   public static <O, T extends Throwable> void accept(FailableConsumer<O, T> paramFailableConsumer, O paramO) {
/* 306 */     run(() -> paramFailableConsumer.accept(paramObject));
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
/*     */   public static <O1, O2, O, T extends Throwable> O apply(FailableBiFunction<O1, O2, O, T> paramFailableBiFunction, O1 paramO1, O2 paramO2) {
/* 323 */     return get(() -> paramFailableBiFunction.apply(paramObject1, paramObject2));
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
/*     */   public static <I, O, T extends Throwable> O apply(FailableFunction<I, O, T> paramFailableFunction, I paramI) {
/* 337 */     return get(() -> paramFailableFunction.apply(paramObject));
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
/*     */   public static <O1, O2> BiConsumer<O1, O2> asBiConsumer(FailableBiConsumer<O1, O2, ?> paramFailableBiConsumer) {
/* 350 */     return (paramObject1, paramObject2) -> accept(paramFailableBiConsumer, paramObject1, paramObject2);
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
/*     */   public static <O1, O2, O> BiFunction<O1, O2, O> asBiFunction(FailableBiFunction<O1, O2, O, ?> paramFailableBiFunction) {
/* 364 */     return (paramObject1, paramObject2) -> apply(paramFailableBiFunction, paramObject1, paramObject2);
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
/*     */   public static <O1, O2> BiPredicate<O1, O2> asBiPredicate(FailableBiPredicate<O1, O2, ?> paramFailableBiPredicate) {
/* 377 */     return (paramObject1, paramObject2) -> test(paramFailableBiPredicate, paramObject1, paramObject2);
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
/*     */   public static <O> Callable<O> asCallable(FailableCallable<O, ?> paramFailableCallable) {
/* 389 */     return () -> call(paramFailableCallable);
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
/*     */   public static <I> Consumer<I> asConsumer(FailableConsumer<I, ?> paramFailableConsumer) {
/* 401 */     return paramObject -> accept(paramFailableConsumer, paramObject);
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
/*     */   public static <I, O> Function<I, O> asFunction(FailableFunction<I, O, ?> paramFailableFunction) {
/* 414 */     return paramObject -> apply(paramFailableFunction, paramObject);
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
/*     */   public static <I> Predicate<I> asPredicate(FailablePredicate<I, ?> paramFailablePredicate) {
/* 426 */     return paramObject -> test(paramFailablePredicate, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Runnable asRunnable(FailableRunnable<?> paramFailableRunnable) {
/* 437 */     return () -> run(paramFailableRunnable);
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
/*     */   public static <O> Supplier<O> asSupplier(FailableSupplier<O, ?> paramFailableSupplier) {
/* 449 */     return () -> get(paramFailableSupplier);
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
/*     */   public static <O, T extends Throwable> O call(FailableCallable<O, T> paramFailableCallable) {
/* 461 */     return get(paramFailableCallable::call);
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
/*     */   public static <O, T extends Throwable> O get(FailableSupplier<O, T> paramFailableSupplier) {
/*     */     try {
/* 475 */       return paramFailableSupplier.get();
/* 476 */     } catch (Throwable throwable) {
/* 477 */       throw rethrow(throwable);
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
/*     */   private static <T extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<T> paramFailableBooleanSupplier) {
/*     */     try {
/* 490 */       return paramFailableBooleanSupplier.getAsBoolean();
/* 491 */     } catch (Throwable throwable) {
/* 492 */       throw rethrow(throwable);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RuntimeException rethrow(Throwable paramThrowable) {
/* 523 */     Objects.requireNonNull(paramThrowable, "throwable");
/* 524 */     if (paramThrowable instanceof RuntimeException)
/* 525 */       throw (RuntimeException)paramThrowable; 
/* 526 */     if (paramThrowable instanceof Error)
/* 527 */       throw (Error)paramThrowable; 
/* 528 */     if (paramThrowable instanceof IOException) {
/* 529 */       throw new UncheckedIOException((IOException)paramThrowable);
/*     */     }
/* 531 */     throw new UndeclaredThrowableException(paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Throwable> void run(FailableRunnable<T> paramFailableRunnable) {
/*     */     try {
/* 543 */       paramFailableRunnable.run();
/* 544 */     } catch (Throwable throwable) {
/* 545 */       throw rethrow(throwable);
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
/*     */   public static <O> Streams.FailableStream<O> stream(Collection<O> paramCollection) {
/* 562 */     return new Streams.FailableStream<>(paramCollection.stream());
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
/*     */   public static <O> Streams.FailableStream<O> stream(Stream<O> paramStream) {
/* 577 */     return new Streams.FailableStream<>(paramStream);
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
/*     */   public static <O1, O2, T extends Throwable> boolean test(FailableBiPredicate<O1, O2, T> paramFailableBiPredicate, O1 paramO1, O2 paramO2) {
/* 593 */     return getAsBoolean(() -> paramFailableBiPredicate.test(paramObject1, paramObject2));
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
/*     */   public static <O, T extends Throwable> boolean test(FailablePredicate<O, T> paramFailablePredicate, O paramO) {
/* 606 */     return getAsBoolean(() -> paramFailablePredicate.test(paramObject));
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
/*     */   @SafeVarargs
/*     */   public static void tryWithResources(FailableRunnable<? extends Throwable> paramFailableRunnable, FailableConsumer<Throwable, ? extends Throwable> paramFailableConsumer, FailableRunnable<? extends Throwable>... paramVarArgs) {
/*     */     FailableConsumer<Throwable, ? extends Throwable> failableConsumer;
/* 634 */     if (paramFailableConsumer == null) {
/* 635 */       failableConsumer = Functions::rethrow;
/*     */     } else {
/* 637 */       failableConsumer = paramFailableConsumer;
/*     */     } 
/* 639 */     if (paramVarArgs != null) {
/* 640 */       for (FailableRunnable<? extends Throwable> failableRunnable : paramVarArgs) {
/* 641 */         Objects.requireNonNull(failableRunnable, "runnable");
/*     */       }
/*     */     }
/* 644 */     Throwable throwable = null;
/*     */     try {
/* 646 */       paramFailableRunnable.run();
/* 647 */     } catch (Throwable throwable1) {
/* 648 */       throwable = throwable1;
/*     */     } 
/* 650 */     if (paramVarArgs != null) {
/* 651 */       for (FailableRunnable<? extends Throwable> failableRunnable : paramVarArgs) {
/*     */         try {
/* 653 */           failableRunnable.run();
/* 654 */         } catch (Throwable throwable1) {
/* 655 */           if (throwable == null) {
/* 656 */             throwable = throwable1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 661 */     if (throwable != null) {
/*     */       try {
/* 663 */         failableConsumer.accept(throwable);
/* 664 */       } catch (Throwable throwable1) {
/* 665 */         throw rethrow(throwable1);
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SafeVarargs
/*     */   public static void tryWithResources(FailableRunnable<? extends Throwable> paramFailableRunnable, FailableRunnable<? extends Throwable>... paramVarArgs) {
/* 691 */     tryWithResources(paramFailableRunnable, null, paramVarArgs);
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailableSupplier<R, T extends Throwable> {
/*     */     R get() throws T;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailableRunnable<T extends Throwable> {
/*     */     void run() throws T;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailablePredicate<I, T extends Throwable> {
/*     */     boolean test(I param1I) throws T;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailableFunction<I, R, T extends Throwable> {
/*     */     R apply(I param1I) throws T;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailableConsumer<O, T extends Throwable> {
/*     */     void accept(O param1O) throws T;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailableCallable<R, T extends Throwable> {
/*     */     R call() throws T;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailableBiPredicate<O1, O2, T extends Throwable> {
/*     */     boolean test(O1 param1O1, O2 param1O2) throws T;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailableBiFunction<O1, O2, R, T extends Throwable> {
/*     */     R apply(O1 param1O1, O2 param1O2) throws T;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   @FunctionalInterface
/*     */   public static interface FailableBiConsumer<O1, O2, T extends Throwable> {
/*     */     void accept(O1 param1O1, O2 param1O2) throws T;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\Functions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */