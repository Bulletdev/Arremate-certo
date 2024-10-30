/*     */ package com.sun.jna.platform.win32.COM.util;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.COMUtils;
/*     */ import com.sun.jna.platform.win32.Ole32;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
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
/*     */ 
/*     */ public class ComThread
/*     */ {
/*  40 */   private static ThreadLocal<Boolean> isCOMThread = new ThreadLocal<Boolean>();
/*     */   
/*     */   ExecutorService executor;
/*     */   Runnable firstTask;
/*     */   boolean requiresInitialisation;
/*     */   long timeoutMilliseconds;
/*     */   Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
/*     */   
/*     */   public ComThread(String paramString, long paramLong, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
/*  49 */     this(paramString, paramLong, paramUncaughtExceptionHandler, 0);
/*     */   }
/*     */   
/*     */   public ComThread(final String threadName, long paramLong, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, final int coinitialiseExFlag) {
/*  53 */     this.requiresInitialisation = true;
/*  54 */     this.timeoutMilliseconds = paramLong;
/*  55 */     this.uncaughtExceptionHandler = paramUncaughtExceptionHandler;
/*  56 */     this.firstTask = new Runnable()
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         public void run()
/*     */         {
/*     */           try {
/*  64 */             WinNT.HRESULT hRESULT = Ole32.INSTANCE.CoInitializeEx(null, coinitialiseExFlag);
/*  65 */             ComThread.isCOMThread.set(Boolean.valueOf(true));
/*  66 */             COMUtils.checkRC(hRESULT);
/*  67 */             ComThread.this.requiresInitialisation = false;
/*  68 */           } catch (Throwable throwable) {
/*  69 */             ComThread.this.uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), throwable);
/*     */           } 
/*     */         }
/*     */       };
/*  73 */     this.executor = Executors.newSingleThreadExecutor(new ThreadFactory()
/*     */         {
/*     */           public Thread newThread(Runnable param1Runnable)
/*     */           {
/*  77 */             if (!ComThread.this.requiresInitialisation)
/*     */             {
/*  79 */               throw new RuntimeException("ComThread executor has a problem.");
/*     */             }
/*  81 */             Thread thread = new Thread(param1Runnable, threadName);
/*     */ 
/*     */             
/*  84 */             thread.setDaemon(true);
/*     */             
/*  86 */             thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
/*     */                 {
/*     */                   public void uncaughtException(Thread param2Thread, Throwable param2Throwable) {
/*  89 */                     ComThread.this.requiresInitialisation = true;
/*  90 */                     ComThread.this.uncaughtExceptionHandler.uncaughtException(param2Thread, param2Throwable);
/*     */                   }
/*     */                 });
/*     */             
/*  94 */             return thread;
/*     */           }
/*     */         });
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
/*     */   public void terminate(long paramLong) {
/*     */     try {
/* 110 */       this.executor.submit(new Runnable()
/*     */           {
/*     */             public void run() {
/* 113 */               Ole32.INSTANCE.CoUninitialize();
/*     */             }
/* 115 */           }).get(paramLong, TimeUnit.MILLISECONDS);
/*     */       
/* 117 */       this.executor.shutdown();
/*     */     }
/* 119 */     catch (InterruptedException interruptedException) {
/* 120 */       interruptedException.printStackTrace();
/* 121 */     } catch (ExecutionException executionException) {
/* 122 */       executionException.printStackTrace();
/* 123 */     } catch (TimeoutException timeoutException) {
/* 124 */       this.executor.shutdownNow();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/* 130 */     if (!this.executor.isShutdown()) {
/* 131 */       terminate(100L);
/*     */     }
/*     */   }
/*     */   
/*     */   static void setComThread(boolean paramBoolean) {
/* 136 */     isCOMThread.set(Boolean.valueOf(paramBoolean));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(Callable<T> paramCallable) throws TimeoutException, InterruptedException, ExecutionException {
/* 143 */     Boolean bool = isCOMThread.get();
/* 144 */     if (bool == null) {
/* 145 */       bool = Boolean.valueOf(false);
/*     */     }
/* 147 */     if (bool.booleanValue()) {
/*     */       try {
/* 149 */         return paramCallable.call();
/* 150 */       } catch (Exception exception) {
/* 151 */         throw new ExecutionException(exception);
/*     */       } 
/*     */     }
/* 154 */     if (this.requiresInitialisation) {
/* 155 */       this.executor.execute(this.firstTask);
/*     */     }
/* 157 */     return this.executor.<T>submit(paramCallable).get(this.timeoutMilliseconds, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\ComThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */