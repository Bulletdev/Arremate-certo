/*     */ package ch.qos.logback.core;
/*     */ 
/*     */ import ch.qos.logback.core.spi.AppenderAttachable;
/*     */ import ch.qos.logback.core.spi.AppenderAttachableImpl;
/*     */ import ch.qos.logback.core.util.InterruptUtil;
/*     */ import java.util.Iterator;
/*     */ import java.util.concurrent.ArrayBlockingQueue;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AsyncAppenderBase<E>
/*     */   extends UnsynchronizedAppenderBase<E>
/*     */   implements AppenderAttachable<E>
/*     */ {
/*  42 */   AppenderAttachableImpl<E> aai = new AppenderAttachableImpl();
/*     */ 
/*     */   
/*     */   BlockingQueue<E> blockingQueue;
/*     */   
/*     */   public static final int DEFAULT_QUEUE_SIZE = 256;
/*     */   
/*  49 */   int queueSize = 256;
/*     */   
/*  51 */   int appenderCount = 0;
/*     */   
/*     */   static final int UNDEFINED = -1;
/*  54 */   int discardingThreshold = -1;
/*     */   
/*     */   boolean neverBlock = false;
/*  57 */   a worker = new a(this);
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DEFAULT_MAX_FLUSH_TIME = 1000;
/*     */ 
/*     */ 
/*     */   
/*  65 */   int maxFlushTime = 1000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isDiscardable(E paramE) {
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void preprocess(E paramE) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  92 */     if (isStarted())
/*     */       return; 
/*  94 */     if (this.appenderCount == 0) {
/*  95 */       addError("No attached appenders found.");
/*     */       return;
/*     */     } 
/*  98 */     if (this.queueSize < 1) {
/*  99 */       addError("Invalid queue size [" + this.queueSize + "]");
/*     */       return;
/*     */     } 
/* 102 */     this.blockingQueue = new ArrayBlockingQueue<E>(this.queueSize);
/*     */     
/* 104 */     if (this.discardingThreshold == -1)
/* 105 */       this.discardingThreshold = this.queueSize / 5; 
/* 106 */     addInfo("Setting discardingThreshold to " + this.discardingThreshold);
/* 107 */     this.worker.setDaemon(true);
/* 108 */     this.worker.setName("AsyncAppender-Worker-" + getName());
/*     */     
/* 110 */     super.start();
/* 111 */     this.worker.start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 116 */     if (!isStarted()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 122 */     super.stop();
/*     */ 
/*     */ 
/*     */     
/* 126 */     this.worker.interrupt();
/*     */     
/* 128 */     InterruptUtil interruptUtil = new InterruptUtil(this.context);
/*     */     
/*     */     try {
/* 131 */       interruptUtil.maskInterruptFlag();
/*     */       
/* 133 */       this.worker.join(this.maxFlushTime);
/*     */ 
/*     */       
/* 136 */       if (this.worker.isAlive()) {
/* 137 */         addWarn("Max queue flush timeout (" + this.maxFlushTime + " ms) exceeded. Approximately " + this.blockingQueue.size() + " queued events were possibly discarded.");
/*     */       } else {
/*     */         
/* 140 */         addInfo("Queue flush finished successfully within timeout.");
/*     */       }
/*     */     
/* 143 */     } catch (InterruptedException interruptedException) {
/* 144 */       int i = this.blockingQueue.size();
/* 145 */       addError("Failed to join worker thread. " + i + " queued events may be discarded.", interruptedException);
/*     */     } finally {
/* 147 */       interruptUtil.unmaskInterruptFlag();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void append(E paramE) {
/* 157 */     if (isQueueBelowDiscardingThreshold() && isDiscardable(paramE)) {
/*     */       return;
/*     */     }
/* 160 */     preprocess(paramE);
/* 161 */     put(paramE);
/*     */   }
/*     */   
/*     */   private boolean isQueueBelowDiscardingThreshold() {
/* 165 */     return (this.blockingQueue.remainingCapacity() < this.discardingThreshold);
/*     */   }
/*     */   
/*     */   private void put(E paramE) {
/* 169 */     if (this.neverBlock) {
/* 170 */       this.blockingQueue.offer(paramE);
/*     */     } else {
/* 172 */       putUninterruptibly(paramE);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void putUninterruptibly(E paramE) {
/* 177 */     boolean bool = false;
/*     */     try {
/*     */       while (true) {
/*     */         try {
/* 181 */           this.blockingQueue.put(paramE);
/*     */           break;
/* 183 */         } catch (InterruptedException interruptedException) {
/* 184 */           bool = true;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 188 */       if (bool) {
/* 189 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getQueueSize() {
/* 195 */     return this.queueSize;
/*     */   }
/*     */   
/*     */   public void setQueueSize(int paramInt) {
/* 199 */     this.queueSize = paramInt;
/*     */   }
/*     */   
/*     */   public int getDiscardingThreshold() {
/* 203 */     return this.discardingThreshold;
/*     */   }
/*     */   
/*     */   public void setDiscardingThreshold(int paramInt) {
/* 207 */     this.discardingThreshold = paramInt;
/*     */   }
/*     */   
/*     */   public int getMaxFlushTime() {
/* 211 */     return this.maxFlushTime;
/*     */   }
/*     */   
/*     */   public void setMaxFlushTime(int paramInt) {
/* 215 */     this.maxFlushTime = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumberOfElementsInQueue() {
/* 224 */     return this.blockingQueue.size();
/*     */   }
/*     */   
/*     */   public void setNeverBlock(boolean paramBoolean) {
/* 228 */     this.neverBlock = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isNeverBlock() {
/* 232 */     return this.neverBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRemainingCapacity() {
/* 242 */     return this.blockingQueue.remainingCapacity();
/*     */   }
/*     */   
/*     */   public void addAppender(Appender<E> paramAppender) {
/* 246 */     if (this.appenderCount == 0) {
/* 247 */       this.appenderCount++;
/* 248 */       addInfo("Attaching appender named [" + paramAppender.getName() + "] to AsyncAppender.");
/* 249 */       this.aai.addAppender(paramAppender);
/*     */     } else {
/* 251 */       addWarn("One and only one appender may be attached to AsyncAppender.");
/* 252 */       addWarn("Ignoring additional appender named [" + paramAppender.getName() + "]");
/*     */     } 
/*     */   }
/*     */   
/*     */   public Iterator<Appender<E>> iteratorForAppenders() {
/* 257 */     return this.aai.iteratorForAppenders();
/*     */   }
/*     */   
/*     */   public Appender<E> getAppender(String paramString) {
/* 261 */     return this.aai.getAppender(paramString);
/*     */   }
/*     */   
/*     */   public boolean isAttached(Appender<E> paramAppender) {
/* 265 */     return this.aai.isAttached(paramAppender);
/*     */   }
/*     */   
/*     */   public void detachAndStopAllAppenders() {
/* 269 */     this.aai.detachAndStopAllAppenders();
/*     */   }
/*     */   
/*     */   public boolean detachAppender(Appender<E> paramAppender) {
/* 273 */     return this.aai.detachAppender(paramAppender);
/*     */   }
/*     */   
/*     */   public boolean detachAppender(String paramString) {
/* 277 */     return this.aai.detachAppender(paramString);
/*     */   }
/*     */   
/*     */   class a
/*     */     extends Thread {
/*     */     public void run() {
/* 283 */       AsyncAppenderBase asyncAppenderBase = this.a;
/* 284 */       AppenderAttachableImpl appenderAttachableImpl = asyncAppenderBase.aai;
/*     */ 
/*     */       
/* 287 */       while (asyncAppenderBase.isStarted()) {
/*     */         try {
/* 289 */           Object object = asyncAppenderBase.blockingQueue.take();
/* 290 */           appenderAttachableImpl.appendLoopOnAppenders(object);
/* 291 */         } catch (InterruptedException interruptedException) {
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 296 */       this.a.addInfo("Worker thread will flush remaining events before exiting. ");
/*     */       
/* 298 */       for (Object object : asyncAppenderBase.blockingQueue) {
/* 299 */         appenderAttachableImpl.appendLoopOnAppenders(object);
/* 300 */         asyncAppenderBase.blockingQueue.remove(object);
/*     */       } 
/*     */       
/* 303 */       appenderAttachableImpl.detachAndStopAllAppenders();
/*     */     }
/*     */     
/*     */     a(AsyncAppenderBase this$0) {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\AsyncAppenderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */