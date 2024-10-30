/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.http.conn.HttpClientConnectionManager;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class IdleConnectionEvictor
/*     */ {
/*     */   private final HttpClientConnectionManager connectionManager;
/*     */   private final ThreadFactory threadFactory;
/*     */   private final Thread thread;
/*     */   private final long sleepTimeMs;
/*     */   private final long maxIdleTimeMs;
/*     */   private volatile Exception exception;
/*     */   
/*     */   public IdleConnectionEvictor(final HttpClientConnectionManager connectionManager, ThreadFactory paramThreadFactory, long paramLong1, TimeUnit paramTimeUnit1, long paramLong2, TimeUnit paramTimeUnit2) {
/*  57 */     this.connectionManager = (HttpClientConnectionManager)Args.notNull(connectionManager, "Connection manager");
/*  58 */     this.threadFactory = (paramThreadFactory != null) ? paramThreadFactory : new DefaultThreadFactory();
/*  59 */     this.sleepTimeMs = (paramTimeUnit1 != null) ? paramTimeUnit1.toMillis(paramLong1) : paramLong1;
/*  60 */     this.maxIdleTimeMs = (paramTimeUnit2 != null) ? paramTimeUnit2.toMillis(paramLong2) : paramLong2;
/*  61 */     this.thread = this.threadFactory.newThread(new Runnable()
/*     */         {
/*     */           public void run() {
/*     */             try {
/*  65 */               while (!Thread.currentThread().isInterrupted()) {
/*  66 */                 Thread.sleep(IdleConnectionEvictor.this.sleepTimeMs);
/*  67 */                 connectionManager.closeExpiredConnections();
/*  68 */                 if (IdleConnectionEvictor.this.maxIdleTimeMs > 0L) {
/*  69 */                   connectionManager.closeIdleConnections(IdleConnectionEvictor.this.maxIdleTimeMs, TimeUnit.MILLISECONDS);
/*     */                 }
/*     */               } 
/*  72 */             } catch (Exception exception) {
/*  73 */               IdleConnectionEvictor.this.exception = exception;
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IdleConnectionEvictor(HttpClientConnectionManager paramHttpClientConnectionManager, long paramLong1, TimeUnit paramTimeUnit1, long paramLong2, TimeUnit paramTimeUnit2) {
/*  84 */     this(paramHttpClientConnectionManager, null, paramLong1, paramTimeUnit1, paramLong2, paramTimeUnit2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IdleConnectionEvictor(HttpClientConnectionManager paramHttpClientConnectionManager, long paramLong, TimeUnit paramTimeUnit) {
/*  90 */     this(paramHttpClientConnectionManager, null, (paramLong > 0L) ? paramLong : 5L, (paramTimeUnit != null) ? paramTimeUnit : TimeUnit.SECONDS, paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  96 */     this.thread.start();
/*     */   }
/*     */   
/*     */   public void shutdown() {
/* 100 */     this.thread.interrupt();
/*     */   }
/*     */   
/*     */   public boolean isRunning() {
/* 104 */     return this.thread.isAlive();
/*     */   }
/*     */   
/*     */   public void awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/* 108 */     this.thread.join(((paramTimeUnit != null) ? paramTimeUnit : TimeUnit.MILLISECONDS).toMillis(paramLong));
/*     */   }
/*     */   
/*     */   static class DefaultThreadFactory
/*     */     implements ThreadFactory
/*     */   {
/*     */     public Thread newThread(Runnable param1Runnable) {
/* 115 */       Thread thread = new Thread(param1Runnable, "Connection evictor");
/* 116 */       thread.setDaemon(true);
/* 117 */       return thread;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\IdleConnectionEvictor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */