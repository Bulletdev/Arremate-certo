/*     */ package org.apache.commons.lang3.function;
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
/*     */ import org.apache.commons.lang3.stream.Streams;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Failable
/*     */ {
/*     */   public static <T, U, E extends Throwable> void accept(FailableBiConsumer<T, U, E> paramFailableBiConsumer, T paramT, U paramU) {
/*  83 */     run(() -> paramFailableBiConsumer.accept(paramObject1, paramObject2));
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
/*     */   public static <T, E extends Throwable> void accept(FailableConsumer<T, E> paramFailableConsumer, T paramT) {
/*  95 */     run(() -> paramFailableConsumer.accept(paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Throwable> void accept(FailableDoubleConsumer<E> paramFailableDoubleConsumer, double paramDouble) {
/* 106 */     run(() -> paramFailableDoubleConsumer.accept(paramDouble));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Throwable> void accept(FailableIntConsumer<E> paramFailableIntConsumer, int paramInt) {
/* 117 */     run(() -> paramFailableIntConsumer.accept(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Throwable> void accept(FailableLongConsumer<E> paramFailableLongConsumer, long paramLong) {
/* 128 */     run(() -> paramFailableLongConsumer.accept(paramLong));
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
/*     */   public static <T, U, R, E extends Throwable> R apply(FailableBiFunction<T, U, R, E> paramFailableBiFunction, T paramT, U paramU) {
/* 145 */     return get(() -> paramFailableBiFunction.apply(paramObject1, paramObject2));
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
/*     */   public static <T, R, E extends Throwable> R apply(FailableFunction<T, R, E> paramFailableFunction, T paramT) {
/* 159 */     return get(() -> paramFailableFunction.apply(paramObject));
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
/*     */   public static <E extends Throwable> double applyAsDouble(FailableDoubleBinaryOperator<E> paramFailableDoubleBinaryOperator, double paramDouble1, double paramDouble2) {
/* 173 */     return getAsDouble(() -> paramFailableDoubleBinaryOperator.applyAsDouble(paramDouble1, paramDouble2));
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
/*     */   public static <T, U> BiConsumer<T, U> asBiConsumer(FailableBiConsumer<T, U, ?> paramFailableBiConsumer) {
/* 185 */     return (paramObject1, paramObject2) -> accept(paramFailableBiConsumer, paramObject1, paramObject2);
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
/*     */   public static <T, U, R> BiFunction<T, U, R> asBiFunction(FailableBiFunction<T, U, R, ?> paramFailableBiFunction) {
/* 198 */     return (paramObject1, paramObject2) -> apply(paramFailableBiFunction, paramObject1, paramObject2);
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
/*     */   public static <T, U> BiPredicate<T, U> asBiPredicate(FailableBiPredicate<T, U, ?> paramFailableBiPredicate) {
/* 210 */     return (paramObject1, paramObject2) -> test(paramFailableBiPredicate, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <V> Callable<V> asCallable(FailableCallable<V, ?> paramFailableCallable) {
/* 221 */     return () -> call(paramFailableCallable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Consumer<T> asConsumer(FailableConsumer<T, ?> paramFailableConsumer) {
/* 232 */     return paramObject -> accept(paramFailableConsumer, paramObject);
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
/*     */   public static <T, R> Function<T, R> asFunction(FailableFunction<T, R, ?> paramFailableFunction) {
/* 244 */     return paramObject -> apply(paramFailableFunction, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Predicate<T> asPredicate(FailablePredicate<T, ?> paramFailablePredicate) {
/* 255 */     return paramObject -> test(paramFailablePredicate, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Runnable asRunnable(FailableRunnable<?> paramFailableRunnable) {
/* 265 */     return () -> run(paramFailableRunnable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Supplier<T> asSupplier(FailableSupplier<T, ?> paramFailableSupplier) {
/* 276 */     return () -> get(paramFailableSupplier);
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
/*     */   public static <V, E extends Throwable> V call(FailableCallable<V, E> paramFailableCallable) {
/* 288 */     return get(paramFailableCallable::call);
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
/*     */   public static <T, E extends Throwable> T get(FailableSupplier<T, E> paramFailableSupplier) {
/*     */     try {
/* 301 */       return paramFailableSupplier.get();
/* 302 */     } catch (Throwable throwable) {
/* 303 */       throw rethrow(throwable);
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
/*     */   public static <E extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<E> paramFailableBooleanSupplier) {
/*     */     try {
/* 316 */       return paramFailableBooleanSupplier.getAsBoolean();
/* 317 */     } catch (Throwable throwable) {
/* 318 */       throw rethrow(throwable);
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
/*     */   public static <E extends Throwable> double getAsDouble(FailableDoubleSupplier<E> paramFailableDoubleSupplier) {
/*     */     try {
/* 331 */       return paramFailableDoubleSupplier.getAsDouble();
/* 332 */     } catch (Throwable throwable) {
/* 333 */       throw rethrow(throwable);
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
/*     */   public static <E extends Throwable> int getAsInt(FailableIntSupplier<E> paramFailableIntSupplier) {
/*     */     try {
/* 346 */       return paramFailableIntSupplier.getAsInt();
/* 347 */     } catch (Throwable throwable) {
/* 348 */       throw rethrow(throwable);
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
/*     */   public static <E extends Throwable> long getAsLong(FailableLongSupplier<E> paramFailableLongSupplier) {
/*     */     try {
/* 361 */       return paramFailableLongSupplier.getAsLong();
/* 362 */     } catch (Throwable throwable) {
/* 363 */       throw rethrow(throwable);
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
/*     */   
/*     */   public static RuntimeException rethrow(Throwable paramThrowable) {
/* 395 */     Objects.requireNonNull(paramThrowable, "throwable");
/* 396 */     if (paramThrowable instanceof RuntimeException)
/* 397 */       throw (RuntimeException)paramThrowable; 
/* 398 */     if (paramThrowable instanceof Error)
/* 399 */       throw (Error)paramThrowable; 
/* 400 */     if (paramThrowable instanceof IOException) {
/* 401 */       throw new UncheckedIOException((IOException)paramThrowable);
/*     */     }
/* 403 */     throw new UndeclaredThrowableException(paramThrowable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Throwable> void run(FailableRunnable<E> paramFailableRunnable) {
/*     */     try {
/* 415 */       paramFailableRunnable.run();
/* 416 */     } catch (Throwable throwable) {
/* 417 */       throw rethrow(throwable);
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
/*     */   public static <E> Streams.FailableStream<E> stream(Collection<E> paramCollection) {
/* 434 */     return new Streams.FailableStream(paramCollection.stream());
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
/*     */   public static <T> Streams.FailableStream<T> stream(Stream<T> paramStream) {
/* 448 */     return new Streams.FailableStream(paramStream);
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
/*     */   public static <T, U, E extends Throwable> boolean test(FailableBiPredicate<T, U, E> paramFailableBiPredicate, T paramT, U paramU) {
/* 464 */     return getAsBoolean(() -> paramFailableBiPredicate.test(paramObject1, paramObject2));
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
/*     */   public static <T, E extends Throwable> boolean test(FailablePredicate<T, E> paramFailablePredicate, T paramT) {
/* 477 */     return getAsBoolean(() -> paramFailablePredicate.test(paramObject));
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
/*     */   @SafeVarargs
/*     */   public static void tryWithResources(FailableRunnable<? extends Throwable> paramFailableRunnable, FailableConsumer<Throwable, ? extends Throwable> paramFailableConsumer, FailableRunnable<? extends Throwable>... paramVarArgs) {
/*     */     FailableConsumer<Throwable, ? extends Throwable> failableConsumer;
/* 504 */     if (paramFailableConsumer == null) {
/* 505 */       failableConsumer = Failable::rethrow;
/*     */     } else {
/* 507 */       failableConsumer = paramFailableConsumer;
/*     */     } 
/* 509 */     if (paramVarArgs != null) {
/* 510 */       for (FailableRunnable<? extends Throwable> failableRunnable : paramVarArgs) {
/* 511 */         Objects.requireNonNull(failableRunnable, "runnable");
/*     */       }
/*     */     }
/* 514 */     Throwable throwable = null;
/*     */     try {
/* 516 */       paramFailableRunnable.run();
/* 517 */     } catch (Throwable throwable1) {
/* 518 */       throwable = throwable1;
/*     */     } 
/* 520 */     if (paramVarArgs != null) {
/* 521 */       for (FailableRunnable<? extends Throwable> failableRunnable : paramVarArgs) {
/*     */         try {
/* 523 */           failableRunnable.run();
/* 524 */         } catch (Throwable throwable1) {
/* 525 */           if (throwable == null) {
/* 526 */             throwable = throwable1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 531 */     if (throwable != null) {
/*     */       try {
/* 533 */         failableConsumer.accept(throwable);
/* 534 */       } catch (Throwable throwable1) {
/* 535 */         throw rethrow(throwable1);
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
/*     */   @SafeVarargs
/*     */   public static void tryWithResources(FailableRunnable<? extends Throwable> paramFailableRunnable, FailableRunnable<? extends Throwable>... paramVarArgs) {
/* 560 */     tryWithResources(paramFailableRunnable, null, paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\Failable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */