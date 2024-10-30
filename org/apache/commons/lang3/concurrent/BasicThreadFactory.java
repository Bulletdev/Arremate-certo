/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.atomic.AtomicLong;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicThreadFactory
/*     */   implements ThreadFactory
/*     */ {
/*     */   private final AtomicLong threadCounter;
/*     */   private final ThreadFactory wrappedFactory;
/*     */   private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
/*     */   private final String namingPattern;
/*     */   private final Integer priority;
/*     */   private final Boolean daemon;
/*     */   
/*     */   private BasicThreadFactory(Builder paramBuilder) {
/* 117 */     if (paramBuilder.wrappedFactory == null) {
/* 118 */       this.wrappedFactory = Executors.defaultThreadFactory();
/*     */     } else {
/* 120 */       this.wrappedFactory = paramBuilder.wrappedFactory;
/*     */     } 
/*     */     
/* 123 */     this.namingPattern = paramBuilder.namingPattern;
/* 124 */     this.priority = paramBuilder.priority;
/* 125 */     this.daemon = paramBuilder.daemon;
/* 126 */     this.uncaughtExceptionHandler = paramBuilder.exceptionHandler;
/*     */     
/* 128 */     this.threadCounter = new AtomicLong();
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
/*     */   public final ThreadFactory getWrappedFactory() {
/* 140 */     return this.wrappedFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getNamingPattern() {
/* 150 */     return this.namingPattern;
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
/*     */   public final Boolean getDaemonFlag() {
/* 162 */     return this.daemon;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Integer getPriority() {
/* 172 */     return this.priority;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
/* 182 */     return this.uncaughtExceptionHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getThreadCount() {
/* 193 */     return this.threadCounter.get();
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
/*     */   public Thread newThread(Runnable paramRunnable) {
/* 206 */     Thread thread = getWrappedFactory().newThread(paramRunnable);
/* 207 */     initializeThread(thread);
/*     */     
/* 209 */     return thread;
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
/*     */   private void initializeThread(Thread paramThread) {
/* 222 */     if (getNamingPattern() != null) {
/* 223 */       Long long_ = Long.valueOf(this.threadCounter.incrementAndGet());
/* 224 */       paramThread.setName(String.format(getNamingPattern(), new Object[] { long_ }));
/*     */     } 
/*     */     
/* 227 */     if (getUncaughtExceptionHandler() != null) {
/* 228 */       paramThread.setUncaughtExceptionHandler(getUncaughtExceptionHandler());
/*     */     }
/*     */     
/* 231 */     if (getPriority() != null) {
/* 232 */       paramThread.setPriority(getPriority().intValue());
/*     */     }
/*     */     
/* 235 */     if (getDaemonFlag() != null) {
/* 236 */       paramThread.setDaemon(getDaemonFlag().booleanValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Builder
/*     */     implements org.apache.commons.lang3.builder.Builder<BasicThreadFactory>
/*     */   {
/*     */     private ThreadFactory wrappedFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Thread.UncaughtExceptionHandler exceptionHandler;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String namingPattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Integer priority;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Boolean daemon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder wrappedFactory(ThreadFactory param1ThreadFactory) {
/* 283 */       Validate.notNull(param1ThreadFactory, "Wrapped ThreadFactory must not be null!", new Object[0]);
/*     */       
/* 285 */       this.wrappedFactory = param1ThreadFactory;
/* 286 */       return this;
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
/*     */     public Builder namingPattern(String param1String) {
/* 298 */       Validate.notNull(param1String, "Naming pattern must not be null!", new Object[0]);
/*     */       
/* 300 */       this.namingPattern = param1String;
/* 301 */       return this;
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
/*     */     public Builder daemon(boolean param1Boolean) {
/* 313 */       this.daemon = Boolean.valueOf(param1Boolean);
/* 314 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder priority(int param1Int) {
/* 325 */       this.priority = Integer.valueOf(param1Int);
/* 326 */       return this;
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
/*     */     public Builder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler param1UncaughtExceptionHandler) {
/* 340 */       Validate.notNull(param1UncaughtExceptionHandler, "Uncaught exception handler must not be null!", new Object[0]);
/*     */       
/* 342 */       this.exceptionHandler = param1UncaughtExceptionHandler;
/* 343 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void reset() {
/* 353 */       this.wrappedFactory = null;
/* 354 */       this.exceptionHandler = null;
/* 355 */       this.namingPattern = null;
/* 356 */       this.priority = null;
/* 357 */       this.daemon = null;
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
/*     */     public BasicThreadFactory build() {
/* 369 */       BasicThreadFactory basicThreadFactory = new BasicThreadFactory(this);
/* 370 */       reset();
/* 371 */       return basicThreadFactory;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\BasicThreadFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */