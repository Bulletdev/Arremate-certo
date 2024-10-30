/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.cG;
/*     */ import com.google.a.d.ci;
/*     */ import com.google.b.a.a;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @c
/*     */ public final class am
/*     */   implements aq
/*     */ {
/*     */   private final ExecutorService executor;
/*     */   
/*     */   private am(ExecutorService paramExecutorService) {
/*  53 */     this.executor = (ExecutorService)D.checkNotNull(paramExecutorService);
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
/*     */   public static am a(ExecutorService paramExecutorService) {
/*  68 */     return new am(paramExecutorService);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T a(T paramT, Class<T> paramClass, long paramLong, TimeUnit paramTimeUnit) {
/*  77 */     D.checkNotNull(paramT);
/*  78 */     D.checkNotNull(paramClass);
/*  79 */     D.checkNotNull(paramTimeUnit);
/*  80 */     P(paramLong);
/*  81 */     D.a(paramClass.isInterface(), "interfaceType must be an interface type");
/*     */     
/*  83 */     Set<Method> set = b(paramClass);
/*     */     
/*  85 */     InvocationHandler invocationHandler = new InvocationHandler(this, paramT, paramLong, paramTimeUnit, set)
/*     */       {
/*     */         
/*     */         public Object invoke(Object param1Object, final Method method, final Object[] args) throws Throwable
/*     */         {
/*  90 */           Callable<Object> callable = new Callable(this)
/*     */             {
/*     */               public Object call() throws Exception
/*     */               {
/*     */                 try {
/*  95 */                   return method.invoke(this.a.ar, args);
/*  96 */                 } catch (InvocationTargetException invocationTargetException) {
/*  97 */                   throw am.b(invocationTargetException, false);
/*     */                 } 
/*     */               }
/*     */             };
/* 101 */           return am.a(this.a, callable, this.bD, this.f, this.F
/* 102 */               .contains(method));
/*     */         }
/*     */       };
/* 105 */     return a(paramClass, invocationHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T> T a(Class<T> paramClass, InvocationHandler paramInvocationHandler) {
/* 111 */     Object object = Proxy.newProxyInstance(paramClass
/* 112 */         .getClassLoader(), new Class[] { paramClass }, paramInvocationHandler);
/* 113 */     return paramClass.cast(object);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private <T> T a(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean) throws Exception {
/* 119 */     D.checkNotNull(paramCallable);
/* 120 */     D.checkNotNull(paramTimeUnit);
/* 121 */     P(paramLong);
/*     */     
/* 123 */     Future<T> future = this.executor.submit(paramCallable);
/*     */     
/*     */     try {
/* 126 */       if (paramBoolean) {
/*     */         try {
/* 128 */           return future.get(paramLong, paramTimeUnit);
/* 129 */         } catch (InterruptedException interruptedException) {
/* 130 */           future.cancel(true);
/* 131 */           throw interruptedException;
/*     */         } 
/*     */       }
/* 134 */       return aw.a(future, paramLong, paramTimeUnit);
/*     */     }
/* 136 */     catch (ExecutionException executionException) {
/* 137 */       throw a(executionException, true);
/* 138 */     } catch (TimeoutException timeoutException) {
/* 139 */       future.cancel(true);
/* 140 */       throw new av(timeoutException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public <T> T a(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit) throws TimeoutException, InterruptedException, ExecutionException {
/* 148 */     D.checkNotNull(paramCallable);
/* 149 */     D.checkNotNull(paramTimeUnit);
/* 150 */     P(paramLong);
/*     */     
/* 152 */     Future<T> future = this.executor.submit(paramCallable);
/*     */     
/*     */     try {
/* 155 */       return future.get(paramLong, paramTimeUnit);
/* 156 */     } catch (InterruptedException|TimeoutException interruptedException) {
/* 157 */       future.cancel(true);
/* 158 */       throw interruptedException;
/* 159 */     } catch (ExecutionException executionException) {
/* 160 */       h(executionException.getCause());
/* 161 */       throw new AssertionError();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public <T> T b(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit) throws TimeoutException, ExecutionException {
/* 170 */     D.checkNotNull(paramCallable);
/* 171 */     D.checkNotNull(paramTimeUnit);
/* 172 */     P(paramLong);
/*     */     
/* 174 */     Future<T> future = this.executor.submit(paramCallable);
/*     */     
/*     */     try {
/* 177 */       return aw.a(future, paramLong, paramTimeUnit);
/* 178 */     } catch (TimeoutException timeoutException) {
/* 179 */       future.cancel(true);
/* 180 */       throw timeoutException;
/* 181 */     } catch (ExecutionException executionException) {
/* 182 */       h(executionException.getCause());
/* 183 */       throw new AssertionError();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit) throws TimeoutException, InterruptedException {
/* 190 */     D.checkNotNull(paramRunnable);
/* 191 */     D.checkNotNull(paramTimeUnit);
/* 192 */     P(paramLong);
/*     */     
/* 194 */     Future<?> future = this.executor.submit(paramRunnable);
/*     */     
/*     */     try {
/* 197 */       future.get(paramLong, paramTimeUnit);
/* 198 */     } catch (InterruptedException|TimeoutException interruptedException) {
/* 199 */       future.cancel(true);
/* 200 */       throw interruptedException;
/* 201 */     } catch (ExecutionException executionException) {
/* 202 */       i(executionException.getCause());
/* 203 */       throw new AssertionError();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 210 */     D.checkNotNull(paramRunnable);
/* 211 */     D.checkNotNull(paramTimeUnit);
/* 212 */     P(paramLong);
/*     */     
/* 214 */     Future<?> future = this.executor.submit(paramRunnable);
/*     */     
/*     */     try {
/* 217 */       aw.a(future, paramLong, paramTimeUnit);
/* 218 */     } catch (TimeoutException timeoutException) {
/* 219 */       future.cancel(true);
/* 220 */       throw timeoutException;
/* 221 */     } catch (ExecutionException executionException) {
/* 222 */       i(executionException.getCause());
/* 223 */       throw new AssertionError();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Exception a(Exception paramException, boolean paramBoolean) throws Exception {
/* 228 */     Throwable throwable = paramException.getCause();
/* 229 */     if (throwable == null) {
/* 230 */       throw paramException;
/*     */     }
/* 232 */     if (paramBoolean) {
/*     */       
/* 234 */       StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])ci.a((Object[])throwable.getStackTrace(), (Object[])paramException.getStackTrace(), StackTraceElement.class);
/* 235 */       throwable.setStackTrace(arrayOfStackTraceElement);
/*     */     } 
/* 237 */     if (throwable instanceof Exception) {
/* 238 */       throw (Exception)throwable;
/*     */     }
/* 240 */     if (throwable instanceof Error) {
/* 241 */       throw (Error)throwable;
/*     */     }
/*     */     
/* 244 */     throw paramException;
/*     */   }
/*     */   
/*     */   private static Set<Method> b(Class<?> paramClass) {
/* 248 */     HashSet<Method> hashSet = cG.a();
/* 249 */     for (Method method : paramClass.getMethods()) {
/* 250 */       if (b(method)) {
/* 251 */         hashSet.add(method);
/*     */       }
/*     */     } 
/* 254 */     return hashSet;
/*     */   }
/*     */   
/*     */   private static boolean b(Method paramMethod) {
/* 258 */     for (Class<InterruptedException> clazz : paramMethod.getExceptionTypes()) {
/*     */       
/* 260 */       if (clazz == InterruptedException.class) {
/* 261 */         return true;
/*     */       }
/*     */     } 
/* 264 */     return false;
/*     */   }
/*     */   
/*     */   private void h(Throwable paramThrowable) throws ExecutionException {
/* 268 */     if (paramThrowable instanceof Error)
/* 269 */       throw new w((Error)paramThrowable); 
/* 270 */     if (paramThrowable instanceof RuntimeException) {
/* 271 */       throw new au(paramThrowable);
/*     */     }
/* 273 */     throw new ExecutionException(paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   private void i(Throwable paramThrowable) {
/* 278 */     if (paramThrowable instanceof Error) {
/* 279 */       throw new w((Error)paramThrowable);
/*     */     }
/* 281 */     throw new au(paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void P(long paramLong) {
/* 286 */     D.a((paramLong > 0L), "timeout must be positive: %s", paramLong);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\am.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */