/*     */ package org.a.a.k;
/*     */ 
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.Supplier;
/*     */ import org.a.a.k.a.e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
/*     */   private b() {
/*  37 */     throw new AssertionError("shouldn't be instantiated");
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
/*     */   public static <T> T get(T paramT) {
/*  50 */     if (paramT == null) {
/*  51 */       throw new NoSuchElementException("No value present");
/*     */     }
/*  53 */     return paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @e(f = {"#1"}, eu = true)
/*     */   public static boolean D(Object paramObject) {
/*  63 */     return (paramObject != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> void a(T paramT, Consumer<? super T> paramConsumer) {
/*  72 */     if (paramT != null) {
/*  73 */       paramConsumer.accept(paramT);
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
/*     */   public static <T> T a(T paramT, Predicate<? super T> paramPredicate) {
/*  85 */     if (paramT == null) {
/*  86 */       return null;
/*     */     }
/*  88 */     return paramPredicate.test(paramT) ? paramT : null;
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
/*     */   public static <T, U> U a(T paramT, Function<? super T, ? extends U> paramFunction) {
/* 100 */     if (paramT == null) {
/* 101 */       return null;
/*     */     }
/* 103 */     return paramFunction.apply(paramT);
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
/*     */   public static <T> T p(T paramT1, T paramT2) {
/* 115 */     return (paramT1 != null) ? paramT1 : paramT2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T a(T paramT, Supplier<? extends T> paramSupplier) {
/* 125 */     return (paramT != null) ? paramT : paramSupplier.get();
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
/*     */   public static <T, X extends Throwable> T b(T paramT, Supplier<? extends X> paramSupplier) throws X {
/* 137 */     if (paramT != null) {
/* 138 */       return paramT;
/*     */     }
/* 140 */     throw (X)paramSupplier.get();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\k\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */