/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.BinaryOperator;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.Stream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class Streams
/*     */ {
/*     */   @Deprecated
/*     */   public static class FailableStream<O>
/*     */   {
/*     */     private Stream<O> stream;
/*     */     private boolean terminated;
/*     */     
/*     */     public FailableStream(Stream<O> param1Stream) {
/*  87 */       this.stream = param1Stream;
/*     */     }
/*     */     
/*     */     protected void assertNotTerminated() {
/*  91 */       if (this.terminated) {
/*  92 */         throw new IllegalStateException("This stream is already terminated.");
/*     */       }
/*     */     }
/*     */     
/*     */     protected void makeTerminated() {
/*  97 */       assertNotTerminated();
/*  98 */       this.terminated = true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FailableStream<O> filter(Functions.FailablePredicate<O, ?> param1FailablePredicate) {
/* 112 */       assertNotTerminated();
/* 113 */       this.stream = this.stream.filter(Functions.asPredicate(param1FailablePredicate));
/* 114 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void forEach(Functions.FailableConsumer<O, ?> param1FailableConsumer) {
/* 133 */       makeTerminated();
/* 134 */       stream().forEach(Functions.asConsumer(param1FailableConsumer));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <A, R> R collect(Collector<? super O, A, R> param1Collector) {
/* 186 */       makeTerminated();
/* 187 */       return stream().collect(param1Collector);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <A, R> R collect(Supplier<R> param1Supplier, BiConsumer<R, ? super O> param1BiConsumer, BiConsumer<R, R> param1BiConsumer1) {
/* 236 */       makeTerminated();
/* 237 */       return stream().collect(param1Supplier, param1BiConsumer, param1BiConsumer1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public O reduce(O param1O, BinaryOperator<O> param1BinaryOperator) {
/* 284 */       makeTerminated();
/* 285 */       return stream().reduce(param1O, param1BinaryOperator);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <R> FailableStream<R> map(Functions.FailableFunction<O, R, ?> param1FailableFunction) {
/* 299 */       assertNotTerminated();
/* 300 */       return new FailableStream(this.stream.map(Functions.asFunction(param1FailableFunction)));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Stream<O> stream() {
/* 308 */       return this.stream;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean allMatch(Functions.FailablePredicate<O, ?> param1FailablePredicate) {
/* 331 */       assertNotTerminated();
/* 332 */       return stream().allMatch(Functions.asPredicate(param1FailablePredicate));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean anyMatch(Functions.FailablePredicate<O, ?> param1FailablePredicate) {
/* 353 */       assertNotTerminated();
/* 354 */       return stream().anyMatch(Functions.asPredicate(param1FailablePredicate));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <O> FailableStream<O> stream(Stream<O> paramStream) {
/* 397 */     return new FailableStream<>(paramStream);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <O> FailableStream<O> stream(Collection<O> paramCollection) {
/* 439 */     return stream(paramCollection.stream());
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static class ArrayCollector<O>
/*     */     implements Collector<O, List<O>, O[]>
/*     */   {
/* 447 */     private static final Set<Collector.Characteristics> characteristics = Collections.emptySet();
/*     */     private final Class<O> elementType;
/*     */     
/*     */     public ArrayCollector(Class<O> param1Class) {
/* 451 */       this.elementType = param1Class;
/*     */     }
/*     */ 
/*     */     
/*     */     public Supplier<List<O>> supplier() {
/* 456 */       return java.util.ArrayList::new;
/*     */     }
/*     */ 
/*     */     
/*     */     public BiConsumer<List<O>, O> accumulator() {
/* 461 */       return List::add;
/*     */     }
/*     */ 
/*     */     
/*     */     public BinaryOperator<List<O>> combiner() {
/* 466 */       return (param1List1, param1List2) -> {
/*     */           param1List1.addAll(param1List2);
/*     */           return param1List1;
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public Function<List<O>, O[]> finisher() {
/* 474 */       return param1List -> {
/*     */           Object[] arrayOfObject = (Object[])Array.newInstance(this.elementType, param1List.size());
/*     */           return param1List.toArray(arrayOfObject);
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Collector.Characteristics> characteristics() {
/* 483 */       return characteristics;
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
/*     */   public static <O> Collector<O, ?, O[]> toArray(Class<O> paramClass) {
/* 497 */     return new ArrayCollector<>(paramClass);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\Streams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */