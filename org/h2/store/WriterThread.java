/*     */ package org.h2.store;
/*     */ 
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.security.AccessControlException;
/*     */ import org.h2.Driver;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.message.TraceSystem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WriterThread
/*     */   implements Runnable
/*     */ {
/*     */   private volatile WeakReference<Database> databaseRef;
/*     */   private int writeDelay;
/*     */   private Thread thread;
/*     */   private volatile boolean stop;
/*     */   
/*     */   private WriterThread(Database paramDatabase, int paramInt) {
/*  39 */     this.databaseRef = new WeakReference<>(paramDatabase);
/*  40 */     this.writeDelay = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWriteDelay(int paramInt) {
/*  49 */     this.writeDelay = paramInt;
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
/*     */   public static WriterThread create(Database paramDatabase, int paramInt) {
/*     */     try {
/*  62 */       WriterThread writerThread = new WriterThread(paramDatabase, paramInt);
/*  63 */       writerThread.thread = new Thread(writerThread, "H2 Log Writer " + paramDatabase.getShortName());
/*  64 */       Driver.setThreadContextClassLoader(writerThread.thread);
/*  65 */       writerThread.thread.setDaemon(true);
/*  66 */       return writerThread;
/*  67 */     } catch (AccessControlException accessControlException) {
/*     */       
/*  69 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  75 */     while (!this.stop) {
/*  76 */       Database database = this.databaseRef.get();
/*  77 */       if (database == null) {
/*     */         break;
/*     */       }
/*  80 */       int i = this.writeDelay;
/*     */       try {
/*  82 */         if (database.isFileLockSerialized()) {
/*  83 */           i = 5;
/*  84 */           database.checkpointIfRequired();
/*     */         } else {
/*  86 */           database.flush();
/*     */         } 
/*  88 */       } catch (Exception exception) {
/*  89 */         TraceSystem traceSystem = database.getTraceSystem();
/*  90 */         if (traceSystem != null) {
/*  91 */           traceSystem.getTrace(2).error(exception, "flush");
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  96 */       i = Math.max(i, 5);
/*  97 */       synchronized (this) {
/*  98 */         while (!this.stop && i > 0) {
/*     */           
/* 100 */           int j = Math.min(i, 100);
/*     */           try {
/* 102 */             wait(j);
/* 103 */           } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */           
/* 106 */           i -= j;
/*     */         } 
/*     */       } 
/*     */     } 
/* 110 */     this.databaseRef = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopThread() {
/* 117 */     this.stop = true;
/* 118 */     synchronized (this) {
/* 119 */       notify();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void startThread() {
/* 130 */     this.thread.start();
/* 131 */     this.thread = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\WriterThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */