/*     */ package org.apache.commons.io.monitor;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class FileAlterationMonitor
/*     */   implements Runnable
/*     */ {
/*     */   private final long interval;
/*  33 */   private final List<FileAlterationObserver> observers = new CopyOnWriteArrayList<>();
/*  34 */   private Thread thread = null;
/*     */   
/*     */   private ThreadFactory threadFactory;
/*     */   
/*     */   private volatile boolean running = false;
/*     */ 
/*     */   
/*     */   public FileAlterationMonitor() {
/*  42 */     this(10000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationMonitor(long paramLong) {
/*  52 */     this.interval = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FileAlterationMonitor(long paramLong, FileAlterationObserver... paramVarArgs) {
/*  63 */     this(paramLong);
/*  64 */     if (paramVarArgs != null) {
/*  65 */       for (FileAlterationObserver fileAlterationObserver : paramVarArgs) {
/*  66 */         addObserver(fileAlterationObserver);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getInterval() {
/*  77 */     return this.interval;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setThreadFactory(ThreadFactory paramThreadFactory) {
/*  86 */     this.threadFactory = paramThreadFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addObserver(FileAlterationObserver paramFileAlterationObserver) {
/*  95 */     if (paramFileAlterationObserver != null) {
/*  96 */       this.observers.add(paramFileAlterationObserver);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeObserver(FileAlterationObserver paramFileAlterationObserver) {
/* 106 */     if (paramFileAlterationObserver != null) {
/* 107 */       while (this.observers.remove(paramFileAlterationObserver));
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
/*     */   public Iterable<FileAlterationObserver> getObservers() {
/* 120 */     return this.observers;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void start() throws Exception {
/* 129 */     if (this.running) {
/* 130 */       throw new IllegalStateException("Monitor is already running");
/*     */     }
/* 132 */     for (FileAlterationObserver fileAlterationObserver : this.observers) {
/* 133 */       fileAlterationObserver.initialize();
/*     */     }
/* 135 */     this.running = true;
/* 136 */     if (this.threadFactory != null) {
/* 137 */       this.thread = this.threadFactory.newThread(this);
/*     */     } else {
/* 139 */       this.thread = new Thread(this);
/*     */     } 
/* 141 */     this.thread.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void stop() throws Exception {
/* 150 */     stop(this.interval);
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
/*     */   public synchronized void stop(long paramLong) throws Exception {
/* 162 */     if (!this.running) {
/* 163 */       throw new IllegalStateException("Monitor is not running");
/*     */     }
/* 165 */     this.running = false;
/*     */     try {
/* 167 */       this.thread.interrupt();
/* 168 */       this.thread.join(paramLong);
/* 169 */     } catch (InterruptedException interruptedException) {
/* 170 */       Thread.currentThread().interrupt();
/*     */     } 
/* 172 */     for (FileAlterationObserver fileAlterationObserver : this.observers) {
/* 173 */       fileAlterationObserver.destroy();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 182 */     while (this.running) {
/* 183 */       for (FileAlterationObserver fileAlterationObserver : this.observers) {
/* 184 */         fileAlterationObserver.checkAndNotify();
/*     */       }
/* 186 */       if (!this.running) {
/*     */         break;
/*     */       }
/*     */       try {
/* 190 */         Thread.sleep(this.interval);
/* 191 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\monitor\FileAlterationMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */