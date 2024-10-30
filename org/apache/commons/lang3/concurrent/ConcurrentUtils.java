/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConcurrentUtils
/*     */ {
/*     */   public static ConcurrentException extractCause(ExecutionException paramExecutionException) {
/*  62 */     if (paramExecutionException == null || paramExecutionException.getCause() == null) {
/*  63 */       return null;
/*     */     }
/*     */     
/*  66 */     throwCause(paramExecutionException);
/*  67 */     return new ConcurrentException(paramExecutionException.getMessage(), paramExecutionException.getCause());
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
/*     */   public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException paramExecutionException) {
/*  84 */     if (paramExecutionException == null || paramExecutionException.getCause() == null) {
/*  85 */       return null;
/*     */     }
/*     */     
/*  88 */     throwCause(paramExecutionException);
/*  89 */     return new ConcurrentRuntimeException(paramExecutionException.getMessage(), paramExecutionException.getCause());
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
/*     */   public static void handleCause(ExecutionException paramExecutionException) throws ConcurrentException {
/* 107 */     ConcurrentException concurrentException = extractCause(paramExecutionException);
/*     */     
/* 109 */     if (concurrentException != null) {
/* 110 */       throw concurrentException;
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
/*     */   public static void handleCauseUnchecked(ExecutionException paramExecutionException) {
/* 128 */     ConcurrentRuntimeException concurrentRuntimeException = extractCauseUnchecked(paramExecutionException);
/*     */     
/* 130 */     if (concurrentRuntimeException != null) {
/* 131 */       throw concurrentRuntimeException;
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
/*     */   static Throwable checkedException(Throwable paramThrowable) {
/* 145 */     Validate.isTrue((paramThrowable != null && !(paramThrowable instanceof RuntimeException) && !(paramThrowable instanceof Error)), "Not a checked exception: " + paramThrowable, new Object[0]);
/*     */ 
/*     */     
/* 148 */     return paramThrowable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void throwCause(ExecutionException paramExecutionException) {
/* 158 */     if (paramExecutionException.getCause() instanceof RuntimeException) {
/* 159 */       throw (RuntimeException)paramExecutionException.getCause();
/*     */     }
/*     */     
/* 162 */     if (paramExecutionException.getCause() instanceof Error) {
/* 163 */       throw (Error)paramExecutionException.getCause();
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
/*     */   public static <T> T initialize(ConcurrentInitializer<T> paramConcurrentInitializer) throws ConcurrentException {
/* 183 */     return (paramConcurrentInitializer != null) ? paramConcurrentInitializer.get() : null;
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
/*     */   public static <T> T initializeUnchecked(ConcurrentInitializer<T> paramConcurrentInitializer) {
/*     */     try {
/* 201 */       return initialize(paramConcurrentInitializer);
/* 202 */     } catch (ConcurrentException concurrentException) {
/* 203 */       throw new ConcurrentRuntimeException(concurrentException.getCause());
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
/*     */   public static <K, V> V putIfAbsent(ConcurrentMap<K, V> paramConcurrentMap, K paramK, V paramV) {
/* 243 */     if (paramConcurrentMap == null) {
/* 244 */       return null;
/*     */     }
/*     */     
/* 247 */     V v = paramConcurrentMap.putIfAbsent(paramK, paramV);
/* 248 */     return (v != null) ? v : paramV;
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
/*     */   public static <K, V> V createIfAbsent(ConcurrentMap<K, V> paramConcurrentMap, K paramK, ConcurrentInitializer<V> paramConcurrentInitializer) throws ConcurrentException {
/* 273 */     if (paramConcurrentMap == null || paramConcurrentInitializer == null) {
/* 274 */       return null;
/*     */     }
/*     */     
/* 277 */     V v = paramConcurrentMap.get(paramK);
/* 278 */     if (v == null) {
/* 279 */       return putIfAbsent(paramConcurrentMap, paramK, paramConcurrentInitializer.get());
/*     */     }
/* 281 */     return v;
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
/*     */   public static <K, V> V createIfAbsentUnchecked(ConcurrentMap<K, V> paramConcurrentMap, K paramK, ConcurrentInitializer<V> paramConcurrentInitializer) {
/*     */     try {
/* 302 */       return createIfAbsent(paramConcurrentMap, paramK, paramConcurrentInitializer);
/* 303 */     } catch (ConcurrentException concurrentException) {
/* 304 */       throw new ConcurrentRuntimeException(concurrentException.getCause());
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
/*     */   public static <T> Future<T> constantFuture(T paramT) {
/* 325 */     return new ConstantFuture<>(paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class ConstantFuture<T>
/*     */     implements Future<T>
/*     */   {
/*     */     private final T value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ConstantFuture(T param1T) {
/* 343 */       this.value = param1T;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isDone() {
/* 353 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T get() {
/* 361 */       return this.value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T get(long param1Long, TimeUnit param1TimeUnit) {
/* 370 */       return this.value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isCancelled() {
/* 379 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean cancel(boolean param1Boolean) {
/* 388 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\ConcurrentUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */