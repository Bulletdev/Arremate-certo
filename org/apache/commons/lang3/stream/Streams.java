/*     */ package org.apache.commons.lang3.stream;
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
/*     */ import org.apache.commons.lang3.function.Failable;
/*     */ import org.apache.commons.lang3.function.FailableConsumer;
/*     */ import org.apache.commons.lang3.function.FailableFunction;
/*     */ import org.apache.commons.lang3.function.FailablePredicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Streams
/*     */ {
/*     */   public static class ArrayCollector<O>
/*     */     implements Collector<O, List<O>, O[]>
/*     */   {
/*  70 */     private static final Set<Collector.Characteristics> characteristics = Collections.emptySet();
/*     */     private final Class<O> elementType;
/*     */     
/*     */     public ArrayCollector(Class<O> param1Class) {
/*  74 */       this.elementType = param1Class;
/*     */     }
/*     */ 
/*     */     
/*     */     public BiConsumer<List<O>, O> accumulator() {
/*  79 */       return List::add;
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<Collector.Characteristics> characteristics() {
/*  84 */       return characteristics;
/*     */     }
/*     */ 
/*     */     
/*     */     public BinaryOperator<List<O>> combiner() {
/*  89 */       return (param1List1, param1List2) -> {
/*     */           param1List1.addAll(param1List2);
/*     */           return param1List1;
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public Function<List<O>, O[]> finisher() {
/*  97 */       return param1List -> {
/*     */           Object[] arrayOfObject = (Object[])Array.newInstance(this.elementType, param1List.size());
/*     */           return param1List.toArray(arrayOfObject);
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Supplier<List<O>> supplier() {
/* 106 */       return java.util.ArrayList::new;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class FailableStream<O>
/*     */   {
/*     */     private Stream<O> stream;
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean terminated;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public FailableStream(Stream<O> param1Stream) {
/* 126 */       this.stream = param1Stream;
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
/*     */     public boolean allMatch(FailablePredicate<O, ?> param1FailablePredicate) {
/* 146 */       assertNotTerminated();
/* 147 */       return stream().allMatch(Failable.asPredicate(param1FailablePredicate));
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
/*     */     public boolean anyMatch(FailablePredicate<O, ?> param1FailablePredicate) {
/* 165 */       assertNotTerminated();
/* 166 */       return stream().anyMatch(Failable.asPredicate(param1FailablePredicate));
/*     */     }
/*     */     
/*     */     protected void assertNotTerminated() {
/* 170 */       if (this.terminated) {
/* 171 */         throw new IllegalStateException("This stream is already terminated.");
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <A, R> R collect(Collector<? super O, A, R> param1Collector) {
/* 231 */       makeTerminated();
/* 232 */       return stream().collect(param1Collector);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <A, R> R collect(Supplier<R> param1Supplier, BiConsumer<R, ? super O> param1BiConsumer, BiConsumer<R, R> param1BiConsumer1) {
/* 289 */       makeTerminated();
/* 290 */       return stream().collect(param1Supplier, param1BiConsumer, param1BiConsumer1);
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
/*     */     public FailableStream<O> filter(FailablePredicate<O, ?> param1FailablePredicate) {
/* 304 */       assertNotTerminated();
/* 305 */       this.stream = this.stream.filter(Failable.asPredicate(param1FailablePredicate));
/* 306 */       return this;
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
/*     */     public void forEach(FailableConsumer<O, ?> param1FailableConsumer) {
/* 325 */       makeTerminated();
/* 326 */       stream().forEach(Failable.asConsumer(param1FailableConsumer));
/*     */     }
/*     */     
/*     */     protected void makeTerminated() {
/* 330 */       assertNotTerminated();
/* 331 */       this.terminated = true;
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
/*     */     public <R> FailableStream<R> map(FailableFunction<O, R, ?> param1FailableFunction) {
/* 345 */       assertNotTerminated();
/* 346 */       return new FailableStream(this.stream.map(Failable.asFunction(param1FailableFunction)));
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
/*     */     
/*     */     public O reduce(O param1O, BinaryOperator<O> param1BinaryOperator) {
/* 399 */       makeTerminated();
/* 400 */       return stream().reduce(param1O, param1BinaryOperator);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Stream<O> stream() {
/* 409 */       return this.stream;
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
/*     */   public static <O> FailableStream<O> stream(Collection<O> paramCollection) {
/* 450 */     return stream(paramCollection.stream());
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
/*     */   public static <O> FailableStream<O> stream(Stream<O> paramStream) {
/* 490 */     return new FailableStream<>(paramStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <O> Collector<O, ?, O[]> toArray(Class<O> paramClass) {
/* 501 */     return new ArrayCollector<>(paramClass);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\stream\Streams.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */