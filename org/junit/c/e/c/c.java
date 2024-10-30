/*     */ package org.junit.c.e.c;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.FutureTask;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import org.junit.c.b.g;
/*     */ import org.junit.f.a.h;
/*     */ import org.junit.f.a.l;
/*     */ import org.junit.f.a.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends l
/*     */ {
/*     */   private final l c;
/*     */   private final TimeUnit timeUnit;
/*     */   private final long timeout;
/*     */   private final boolean dl;
/*     */   
/*     */   public static a a() {
/*  31 */     return new a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public c(l paraml, long paramLong) {
/*  43 */     this(a().a(paramLong, TimeUnit.MILLISECONDS), paraml);
/*     */   }
/*     */   
/*     */   private c(a parama, l paraml) {
/*  47 */     this.c = paraml;
/*  48 */     this.timeout = a.a(parama);
/*  49 */     this.timeUnit = a.a(parama);
/*  50 */     this.dl = a.a(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*     */     private boolean dl = false;
/*     */ 
/*     */     
/*  60 */     private long timeout = 0L;
/*  61 */     private TimeUnit unit = TimeUnit.SECONDS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a a(long param1Long, TimeUnit param1TimeUnit) {
/*  80 */       if (param1Long < 0L) {
/*  81 */         throw new IllegalArgumentException("timeout must be non-negative");
/*     */       }
/*  83 */       if (param1TimeUnit == null) {
/*  84 */         throw new NullPointerException("TimeUnit cannot be null");
/*     */       }
/*  86 */       this.timeout = param1Long;
/*  87 */       this.unit = param1TimeUnit;
/*  88 */       return this;
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
/*     */     public a a(boolean param1Boolean) {
/* 101 */       this.dl = param1Boolean;
/* 102 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public c a(l param1l) {
/* 112 */       if (param1l == null) {
/* 113 */         throw new NullPointerException("statement cannot be null");
/*     */       }
/* 115 */       return new c(this, param1l);
/*     */     }
/*     */     
/*     */     private a() {} }
/*     */   
/*     */   public void io() throws Throwable {
/* 121 */     b b = new b();
/* 122 */     FutureTask<Throwable> futureTask = new FutureTask(b);
/* 123 */     ThreadGroup threadGroup = new ThreadGroup("FailOnTimeoutGroup");
/* 124 */     Thread thread = new Thread(threadGroup, futureTask, "Time-limited test");
/*     */     try {
/* 126 */       thread.setDaemon(true);
/* 127 */       thread.start();
/* 128 */       b.iE();
/* 129 */       Throwable throwable = a(futureTask, thread);
/* 130 */       if (throwable != null) {
/* 131 */         throw throwable;
/*     */       }
/*     */     } finally {
/*     */       try {
/* 135 */         thread.join(1L);
/* 136 */       } catch (InterruptedException interruptedException) {
/* 137 */         Thread.currentThread().interrupt();
/*     */       } 
/*     */       try {
/* 140 */         threadGroup.destroy();
/* 141 */       } catch (IllegalThreadStateException illegalThreadStateException) {}
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
/*     */   private Throwable a(FutureTask<Throwable> paramFutureTask, Thread paramThread) {
/*     */     try {
/* 155 */       if (this.timeout > 0L) {
/* 156 */         return paramFutureTask.get(this.timeout, this.timeUnit);
/*     */       }
/* 158 */       return paramFutureTask.get();
/*     */     }
/* 160 */     catch (InterruptedException interruptedException) {
/* 161 */       return interruptedException;
/* 162 */     } catch (ExecutionException executionException) {
/*     */       
/* 164 */       return executionException.getCause();
/* 165 */     } catch (TimeoutException timeoutException) {
/* 166 */       return a(paramThread);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Exception a(Thread paramThread) {
/* 171 */     StackTraceElement[] arrayOfStackTraceElement = paramThread.getStackTrace();
/* 172 */     Thread thread = this.dl ? a(paramThread) : null;
/* 173 */     n n = new n(this.timeout, this.timeUnit);
/* 174 */     if (arrayOfStackTraceElement != null) {
/* 175 */       n.setStackTrace(arrayOfStackTraceElement);
/* 176 */       paramThread.interrupt();
/*     */     } 
/* 178 */     if (thread != null) {
/* 179 */       Exception exception = new Exception("Appears to be stuck in thread " + thread.getName());
/*     */ 
/*     */       
/* 182 */       exception.setStackTrace(a(thread));
/* 183 */       return (Exception)new h(Arrays.asList(new Throwable[] { (Throwable)n, exception }));
/*     */     } 
/*     */     
/* 186 */     return (Exception)n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StackTraceElement[] a(Thread paramThread) {
/*     */     try {
/* 198 */       return paramThread.getStackTrace();
/* 199 */     } catch (SecurityException securityException) {
/* 200 */       return new StackTraceElement[0];
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
/*     */   private Thread a(Thread paramThread) {
/* 215 */     List<Thread> list = a(paramThread.getThreadGroup());
/* 216 */     if (list.isEmpty()) {
/* 217 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 225 */     Thread thread = null;
/* 226 */     long l1 = 0L;
/* 227 */     for (Thread thread1 : list) {
/* 228 */       if (thread1.getState() == Thread.State.RUNNABLE) {
/* 229 */         long l2 = a(thread1);
/* 230 */         if (thread == null || l2 > l1) {
/* 231 */           thread = thread1;
/* 232 */           l1 = l2;
/*     */         } 
/*     */       } 
/*     */     } 
/* 236 */     return (thread == paramThread) ? null : thread;
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
/*     */   private List<Thread> a(ThreadGroup paramThreadGroup) {
/* 248 */     int i = paramThreadGroup.activeCount();
/* 249 */     int j = Math.max(i * 2, 100);
/* 250 */     for (byte b = 0; b < 5; b++) {
/* 251 */       Thread[] arrayOfThread = new Thread[j];
/* 252 */       int k = paramThreadGroup.enumerate(arrayOfThread);
/* 253 */       if (k < j) {
/* 254 */         return Arrays.<Thread>asList(arrayOfThread).subList(0, k);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 259 */       j += 100;
/*     */     } 
/*     */ 
/*     */     
/* 263 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long a(Thread paramThread) {
/* 272 */     g g = org.junit.c.b.c.a();
/* 273 */     if (g.gk()) {
/*     */       try {
/* 275 */         return g.m(paramThread.getId());
/* 276 */       } catch (UnsupportedOperationException unsupportedOperationException) {}
/*     */     }
/*     */     
/* 279 */     return 0L;
/*     */   }
/*     */   
/*     */   private class b implements Callable<Throwable> {
/* 283 */     private final CountDownLatch c = new CountDownLatch(1);
/*     */     
/*     */     public Throwable d() throws Exception {
/*     */       try {
/* 287 */         this.c.countDown();
/* 288 */         c.a(this.a).io();
/* 289 */       } catch (Exception exception) {
/* 290 */         throw exception;
/* 291 */       } catch (Throwable throwable) {
/* 292 */         return throwable;
/*     */       } 
/* 294 */       return null;
/*     */     }
/*     */     
/*     */     public void iE() throws InterruptedException {
/* 298 */       this.c.await();
/*     */     }
/*     */     
/*     */     private b(c this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\c\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */