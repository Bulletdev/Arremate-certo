/*     */ package org.apache.commons.io.function;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @FunctionalInterface
/*     */ public interface IOFunction<T, R>
/*     */ {
/*     */   default <V> IOFunction<V, R> compose(IOFunction<? super V, ? extends T> paramIOFunction) {
/*  62 */     Objects.requireNonNull(paramIOFunction);
/*  63 */     return paramObject -> apply(paramIOFunction.apply(paramObject));
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
/*     */   default <V> IOFunction<V, R> compose(Function<? super V, ? extends T> paramFunction) {
/*  82 */     Objects.requireNonNull(paramFunction);
/*  83 */     return paramObject -> apply(paramFunction.apply(paramObject));
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
/*     */   default IOSupplier<R> compose(IOSupplier<? extends T> paramIOSupplier) {
/* 100 */     Objects.requireNonNull(paramIOSupplier);
/* 101 */     return () -> apply(paramIOSupplier.get());
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
/*     */   default IOSupplier<R> compose(Supplier<? extends T> paramSupplier) {
/* 118 */     Objects.requireNonNull(paramSupplier);
/* 119 */     return () -> apply(paramSupplier.get());
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
/*     */   default <V> IOFunction<T, V> andThen(IOFunction<? super R, ? extends V> paramIOFunction) {
/* 138 */     Objects.requireNonNull(paramIOFunction);
/* 139 */     return paramObject -> paramIOFunction.apply(apply((T)paramObject));
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
/*     */   default <V> IOFunction<T, V> andThen(Function<? super R, ? extends V> paramFunction) {
/* 158 */     Objects.requireNonNull(paramFunction);
/* 159 */     return paramObject -> paramFunction.apply(apply((T)paramObject));
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
/*     */   default IOConsumer<T> andThen(IOConsumer<? super R> paramIOConsumer) {
/* 176 */     Objects.requireNonNull(paramIOConsumer);
/* 177 */     return paramObject -> paramIOConsumer.accept(apply((T)paramObject));
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
/*     */   default IOConsumer<T> andThen(Consumer<? super R> paramConsumer) {
/* 194 */     Objects.requireNonNull(paramConsumer);
/* 195 */     return paramObject -> paramConsumer.accept(apply((T)paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <T> IOFunction<T, T> identity() {
/* 205 */     return paramObject -> paramObject;
/*     */   }
/*     */   
/*     */   R apply(T paramT) throws IOException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\function\IOFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */